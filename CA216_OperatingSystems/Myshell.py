#Cormac Duggan 17100348
import cmd, sys, os, subprocess, readline, multiprocessing, threading #imports for everything needed
lock = threading.Lock() #create the lock
dick = {">":"w", ">>":"a"} #dictionary to set value of > to writing to files and >> to appending to files
class myshell(cmd.Cmd):
	prompt = os.getcwd() + "~ "
	shell = os.getcwd() + "/myshell.py" #save path of original shell executable
	helpfile = os.getcwd() + "/readme" #save path of help manual

	def default(self, line): #do anything that isnt already defined in the myshell class
		try: #try to do any of the following options
			comment = line.split()
			if len(comment) > 1 and comment[-1] == "&": #if the invoked command is of length greater than 1 and ends with a & start a subprocesses of the same function in the background and return to the command prompt immediately
				newcomment = " ".join(comment[:-1]) #remove & from the arguments of the command
				p = multiprocessing.Process(target=myshell.default, args=(0, newcomment)) #create subprocess with new arguments
				p.start() #start subprocess
			elif len(comment) > 1 and comment[-2] in dick.keys(): #if the arguments contain a > or >> in the second to last position change the output to the file named in the last position
				with open(comment[-1], dick[comment[-2]]) as f: #open the given file for either write or append based on the invocation
					lock.acquire() #get lock for critical section
					subprocess.call(line.split()[:-2], stdout = f) #write subprocess output to file
					lock.release() #release lock after critical section ends
			else: #if no & or file redirection is given simply create a subprocess with the given arguments
				subprocess.call(line.split())
		except FileNotFoundError: #exceot error for when command does not exist in the shell or in any other context available
			print("The command was not found.")
		except PermissionError: #except error for when user does not have permission to use a certain command
			print("You do not have access to this.")

	def do_quit(self, irrelevant): #if quit is encountered stop the shell
		if irrelevant == "" or irrelevant == "&" or (len(irrelevant.split()) == 2 and irrelevant.split()[-2] in dick.keys()) or (len(irrelevant.split()) == 3 and irrelevant.split()[-3] in dick.keys() and irrelevant.split()[-1] == "&"): #if any potential invocation of quit using & or output redirection is encountered quit the shell
			return True
		else: #if quit is invoked incorrectly raise an error
			print("Incorrect invocation of quit. See help.")

	def do_EOF(self, irrelevant): #at the end of a file quit the shell
		return True

	def do_cd(self, directory): #if a directory is given change the directory otherwise print out the current working directory
		if directory == "": #if no directory is given to change into
			print(os.getcwd()) #print the directory
		elif directory.split()[-1] == "&": #if an & is encountered start a subprocess that does cd function (does not work if directory is change in subprocess as child process changing the directory wont change the parent processes directory)
			newcomment = "".join(directory[:-1]) #retain arguments apart from the &
			p = multiprocessing.Process(target=myshell.do_cd, args=(0, newcomment)) #create a subprocess of the cd function with the old arguments
			p.start() #start the subprocess
		else: #if a anything else is given as arguments with the invocation of cd
			try: #try to do any of the following
				os.chdir(os.getcwd() + "/" + directory) #if directory is supplied as argument change the working directory unless this is a child process in which case an error will be raised
				myshell.prompt = os.getcwd() + "~ " #change the shell promt to the current directory
				os.environ["PWD"] = os.getcwd() #change the pwd in the environment strings
			except FileNotFoundError: #if the directory doesnt exist or a child process tries to change the directory raise error
				print("This directory does not exist in the current working directory, or invocation of cd is incorrect.")
			except PermissionError: # if the user does not have access to the directory raise error
				print("You do not have permission to access this directory.")

	def do_clr(self, irrelevant): #clear the screen apart from the prompt
		if irrelevant == "": #if there is no aruments supplied with the invocation of clear
			print('\033[2J\033[H', end="") #print this which will clear the screen and go back to the prompt on the first line at the top of the window
		else: #if an argument is supplied with the invocation of the clr command
			comment = irrelevant.split() #split up all elements of the arguments
			if comment[-1] == "&": #if the last argument is an & start a subprocess of clr
				newcomment = " ".join(comment[:-1]) #get rid of the & for the subprocess call
				p = multiprocessing.Process(target=myshell.do_clr, args=(0, newcomment)) #create the subprocess wiht new arguments
				p.start() #start the new subprocess
			elif len(comment) > 1 and comment[-2] in dick.keys(): #if a file redirection is given delete the entire contents of the file
				with open(comment[-1], 'w') as f: #open the given file to write to
					lock.acquire() #get lock for critical section
					f.write("") #write nothing
					lock.release() #release lock
			else: #if any other invocation is given apart from &, redirection, and empty tell user the invocation was incorrect
				print("Incorrect invocation of clr. See help.")

	def do_dir(self, directory):
		if directory == "": #if no directory is given just list the contents of the directory
			for item in os.listdir(): #for every item in the current directory
				if item[0] != ".": #if the current item does not begin with a . print it
					print(item)
		else: #if something is given apart from just the invocation of dir
			comment = directory.split() #separate the contents of the arguments
			if comment[-1] == "&": #if the last item of the arguments is an & create a subprocesses to run in the background with all the arguments except the &
				newcomment = " ".join(comment[:-1]) #make the arguments a single string again without the &
				p = multiprocessing.Process(target=myshell.do_dir, args=(0, newcomment)) #create the subprocess
				p.start() #start the subprocess
			else: #if there is no &
				try: #try and do the following
					if len(comment) > 1 and comment[-2] in dick.keys(): #if the arguments contain a redirection do the following
						if directory.split()[0] in dick.keys(): #if the first argument is the redirection symbol
							direc = os.getcwd() #set the output directory to the current directory
						else: #otherwise change the output directory to the given directory
							direc = directory.split()[0] #change output directory
						os.listdir(direc) #create error if directory doesnt exist before lock is acquired
						with open(comment[-1], dick[comment[-2]]) as f: # open the output file for either writing or appending
							lock.acquire() #get the lock
							for item in os.listdir(direc): #for every item in the directory
								if item[0] != ".": #if the item does not start with a .
									f.write(item + "\n") #write that item to the file with a newline at the end
							lock.release() #release the lock
					else: #if a directory is given but no output redirection is given
						for item in os.listdir(directory): #for every item in the given directory
							if item[0] != ".": #if the item does not start with .
								print(item) #print that item
				except FileNotFoundError: #if the directory does not exist raise an error
					print("Directory does not exist.")
				except PermissionError: #if the user does not have permission to access the directory raise an error
					print("You do not have permission to access this directory.")

	def do_environ(self, irrelevant): #list all the environment strings
		if irrelevant == "": #if no arguments are given with the environ invocation do this
			big = 0 #save 0 variable
			for key in os.environ.keys(): #for every key in the environ strings find the largest
				if len(key) > big: #if the current string is larger than the current largest
					big = len(key) #replace the largest
			for item in os.environ: #print out all of the enviroment strings formatted
				print("Key: {:{}} Environment: {}".format(item, big, os.environ[item])) #print formatted strings
		else: #if an argument was given do one of the following
			comment = irrelevant.split() #split the given arguments
			if comment[-1] == "&": #if the end of the arguments is an &
				newcomment = " ".join(comment[:-1]) #join the remaining arguments
				p = multiprocessing.Process(target=myshell.do_environ, args=(0, newcomment)) #create a subprocess with the remaining arguments
				p.start() #start the subprocess
			elif len(comment) > 2 or (len(comment) == 1 and comment[0] != "&") or len(comment) == 2 and not comment[0] in dick.keys(): #if the environ command is invoked incorrectly print an error
				print("Incorrect invocation of environ. See help.")
			else: #if output redirection is given do this
				try: #try and do the following
					with open(comment[-1], dick[comment[-2]]) as f: #open the file to write or append
						big = 0 #set a beginning size
						for key in os.environ.keys(): #for every key in the environment strings
							if len(key) > big: #if the key is larger than the current big
								big = len(key) #change big to the length of the current key for formatting the printed strings later
						lock.acquire() #get a lock
						for item in os.environ: #for every item in the environment strings write the formatted strings to the file
							f.write("Key: {:{}} Environment: {}\n".format(item, big, os.environ[item])) #write the formatted string
						f.write('\n') #add an extra new line at the end
						lock.release() #release the lock
				except PermissionError: #if the user does not have permission to open the file raise an error
					print("You do not have permission to access this file.")

	def do_echo(self, comment): #echo back whatever the argument given is
		try: #try to do the following
			comment = comment.split() #split the arguments given
			if comment[-1] == "&": #if the last item of the arguments is an & call a subprocess of echo using all the other arguments
				newcomment = " ".join(comment[:-1]) #rejoin the remaining arguments and separate them by a space
				p = multiprocessing.Process(target=myshell.do_echo, args=(0, newcomment)) #create the new subprocess
				p.start() #start the subprocess
			else: #if no & is given
				if len(comment) < 2 or not comment[-2] in dick.keys(): #if no output redirection is given do the following
					print(" ".join(comment)) #print the comment back to the user
				else: #if a redirection for output is given
					try: #try to do the following
						with open(comment[-1], dick[comment[-2]]) as f: #open the file for writing or appending
							lock.acquire() #get the lock
							f.write(" ".join(comment[:-2])) #write back the comment to the output file
							f.write("\n") #add a new line after the comment is echoed in the output file
							lock.release() #release the lock
					except PermissionError: #if the user doesnt have write permissions for the output file raise error
						print("You do not have permission to access this file.")
		except IndexError: #if no comment is given to echo back raise an error
			print("We need something to echo back. See help.")

	def emptyline(self): #if someone hits enter do nothing
		pass

	def do_help(self, args): #provide help for using the shell
		if len(args.split()) > 1 and args.split()[-2] in dick.keys(): #if a redirection is given when invoking the help function
			with open(myshell.helpfile, 'r') as helps: #open the file containing the help document
				helper = helps.read() #read everything from the help file
			with open(args.split()[-1], dick[args.split()[-2]]) as f: #open the output redirection file for writing or appending
				f.write(helper) #write the entire help document to the output file
		elif args == "": #if no arguments are given to the help invocation
			start = -20 #set start point
			stop = 0 #set stop point for lines to be printed
			with open(myshell.helpfile, 'r') as f: #open the help file for reading
				lines = f.readlines() #read all the lines of the help file into a list
			while stop < len(lines): #while there are still lines left in the help file
				try: #try to do this
					start += 20 #change the start to begin in the proper place
					stop += 20 # set the stop to the 20 position
					for line in lines[start:stop]: #for the 20 lines in this set
						print(line, end = "") #print out each line
					p = input() #wait for someone to hit enter to display the next lines of the help file
					if p == "q": #if someone enters a q to exit the help function
						stop = len(lines) #set the stop number so that the loop will stop
				except IndexError: #when an index error inevitably occurs print out the remaining lines of the help file
					print(line[start:])
		else:
			print('Incorrect invocation of help. Please write just the word help.')

	def do_pause(self, irrelevant): #stop all execution of files and shell when pause is encountered
		if irrelevant == "": #if pause is invoked correctly
			try:
				lock.acquire() #get a lock
				input() #wait for someone to hit enter
				lock.release() #release the lock
			except EOFError:
				return True
		else: #if pause is invoked incorrectly raise error
			print("Incorrect invocation of pause. See help.")

if __name__ == '__main__':
	if len(sys.argv) > 1: #if a batch file is given in the start of the myshell call do this
		myshell.use_rawinput = False #dont use raw input for the shell instead use the given file
		#If input file is given run shell from given file
		readfile = sys.argv[1] #set the file name to readfile
		try: #try and open the file
			with open(readfile, 'r') as f: #open the batch file as f
				print('\033[2J\033[H', end="") #clear the screen
				print("Welcome to Shell 3.0. Type help for information on how to use this.") #give the shell opening intro
				myshell(stdin = f).cmdloop() #start the shell with the file lines as the input for the shell
		except FileNotFoundError: #if the batch file does not exist raise an error
			print("Batch file does not exist.")
	else: #if no batch file is given do this
		#If no file given run default prompt shell
		print('\033[2J\033[H', end="") #clear the screen
		print("Welcome to Shell 3.0. Type help for information on how to use this.") #give the opening greeting for the shell
		myshell().cmdloop() #start the shell with raw input as the expected input method

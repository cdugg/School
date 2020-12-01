class Player:
	def __init__(self, name, colour="dead"):
		self.name=name
		self.properties={}#property name :[house count , hotel count , rent]
		self.money=1500
		self.inJail=False
		self.doublesCount=0
		self.position=0
		self.cards = []
		self.mortgaged = {}
		self.lost=False
		self.colour= colour
		self.colourmap={
		"red":[-5,-5],
		"green":[5,-5],
		"blue":[-5,5],
		"pink":[5,5],
		"dead":[-1000,-1000]
		}


		self.pygamemap={
		"-1":[-100,-100],
		"0":[390,390],
		"1":[345,390],
		"2":[315,390],
		"3":[280,390],
		"4":[245,390],
		"5":[210,390],
		"6":[175,390],
		"7":[140,390],
		"8":[105,390],
		"9":[70,390],
		"10":[25,390],
		"11":[25,345],
		"12":[25,310],
		"13":[25,275],
		"14":[25,240],
		"15":[25,205],
		"16":[25,170],
		"17":[25,135],
		"18":[25,100],
		"19":[25,65],
		"20":[25,25],
		"21":[70,25],
		"22":[105,25],
		"23":[140,25],
		"24":[175,25],
		"25":[210,25],
		"26":[245,25],
		"27":[280,25],
		"28":[315,25],
		"29":[345,25],
		"30":[390,25],
		"31":[390,70],
		"32":[390,105],
		"33":[390,140],
		"34":[390,175],
		"35":[390,210],
		"36":[390,245],
		"37":[390,280],
		"38":[390,315],
		"39":[390,345]
		}		

		if self.colour=="red":
			self.img = pygame.image.load('Images/red.png')
		elif self.colour=="green":	
			self.img = pygame.image.load('Images/green.png')
		elif self.colour=="blue":
			self.img = pygame.image.load('Images/blue.png')
		elif self.colour=="pink":
			self.img = pygame.image.load('Images/pink.png')
		else:
			self.img = pygame.image.load('Images/red.png')



	def pyposition(self):
		return [self.pygamemap[str(self.position)][0]+self.colourmap[self.colour][0],self.pygamemap[str(self.position)][1]+self.colourmap[self.colour][1]]

	def __str__(self):
		return self.name


		


class Round:
	def __init__(self,players):
		self.players=players
		self.win= False
		self.white = (255, 64, 64)
		self.w = 425
		self.h = 425
		self.screen = pygame.display.set_mode((self.w, self.h))
		self.screen.fill((self.white))
		self.gameDisplay = pygame.display.set_mode((self.w,self.h))
		self.x,self.y=390,390
		self.img = pygame.image.load('Images/monopoly.jpg')




	def rotation(self, tiles):#done?
		#send playerlist to clients
		i = 1
		for client_socket in clients:
			for player in playerlist:
				time.sleep(0.01)
				client_socket.send(player.name.encode('utf-8'))
			i += 1
		for client_socket in clients:
			time.sleep(0.01)
			client_socket.send("Done".encode('utf-8'))
		#send board to clients
		j = 0
		l = ["red.png","green.png","blue.png","pink.png"]
		for client_socket in clients:
			for player in playerlist:
				time.sleep(0.05)
				client_socket.send(str(len("Images/{}".format(l[j]))).encode('utf-8') + "Images/{}".format(l[j]).encode('utf-8') + str(len(str(player.pyposition()[0]))).encode('utf-8') + str(player.pyposition()[0]).encode('utf-8') + str(len(str(player.pyposition()[1]))).encode('utf-8') + str(player.pyposition()[1]).encode('utf-8'))
				j += 1
			j = 0
		i = -1
		
		while self.win== False:
			self.screen.fill((self.white))
			self.screen.blit(self.img,(0,0))
			losecount=0
			j = 0
			for player in self.players:
				if not player.lost:
					for client_socket in clients.keys():
						#print(l[j], player.pyposition()[0], player.pyposition()[1])
						#print(clients)
						client_socket.send(str(1).encode('utf-8'))
						client_socket.send(str(len("Images/{}".format(l[j]))).encode('utf-8') + "Images/{}".format(l[j]).encode('utf-8') + str(len(str(player.pyposition()[0]))).encode('utf-8') + str(player.pyposition()[0]).encode('utf-8') + str(len(str(player.pyposition()[1]))).encode('utf-8') + str(player.pyposition()[1]).encode('utf-8'))
					self.gameDisplay.blit(player.img, (player.pyposition()[0],player.pyposition()[1]))
					winner=player.name
				else:
					for client in clients.keys():
						if clients[client][1] == player:
							client.send(str(0).encode('utf-8'))
					losecount+=1
				if losecount+1==len(self.players):
					self.win=True
				j += 1
			pygame.display.flip()
			if i==len(self.players)-1:
				i=0
			else:
				i+=1
			if not self.players[i].lost and self.win == False:
				if self.roll(self.players[i], tiles):
					i-=1
			j = 0

		print("congratultions",winner,"you've won!")

	def display(self):
		self.screen.fill((self.white))
		self.screen.blit(self.img,(0,0))	
		for player in self.players:
			if not player.lost:
				self.gameDisplay.blit(player.img, (player.pyposition()[0],player.pyposition()[1]))
				pygame.display.flip()


	def lose(self, player):
		newlist=[]
		for play in self.players:
			if not play == player:
				newlist.append(play)
			else:
				replaceplayer= Player(player.name)
				replaceplayer.lost= True
				newlist.append(replaceplayer)
		self.players=newlist
		player.position=-1
		send = "{} has lost the game.".format(player.name)
		print(send)
		for client in clients.keys():
			client.send(str(len(send)).encode('utf-8') + send.encode('utf-8'))
		return None


	def roll(self, player, tiles):#done?
		if player.colour == "red":
			print("It is your turn, ",player.name+"! Press ENTER to continue.",end="")
			input()
			dice1=random.randint(1,6)
			dice2=random.randint(1,6)
			print("You rolled a "+str(dice1 + dice2)+".")
			jailed=False
			if dice1==dice2:
				if not player.inJail:
					if player.doublesCount==2:
						player.inJail=True
						print("You rolled doubles three times in a row, go to jail!")
						player.position=19 
						player.doublesCount=0
						jailed=True
					else:
						player.doublesCount+=1
						print("Double! Take another turn!")
				else:
					player.inJail=False
					print("you're free from jail!")
			else:
				player.doublesCount=0
			if not player.inJail:
				player.position=(player.position+dice2+dice1)%40
				if player.position <= dice1 + dice2 - 1:
					player.money+=200
					print("You passed Go! You collect $200. You now have $" + str(player.money)+".")
				print("Your position is currently "+str(player.position)+".")
				self.takeTurn(player, tiles)
			if dice1==dice2 and not player.inJail and not jailed:
				return True
			return False
		else:
			send = "It is your turn, {}! Press ENTER to continue.".format(player.name)
			for item in clients.keys():
				if clients[item][1] == player:
					item.send(str(2).encode('utf-8'))
					item.send(str(len(send)).encode('utf-8') + send.encode('utf-8'))
					break
			dice1=random.randint(1,6)
			dice2=random.randint(1,6)
			send = "You rolled a {}.".format(dice1 + dice2)
			jailed=False
			item.send(str(len(send)).encode('utf-8') + send.encode('utf-8'))
			if dice1==dice2:
				if not player.inJail:
					if player.doublesCount==2:
						player.inJail=True
						send = "You rolled doubles three times in a row, go to jail!"
						player.position=19 
						player.doublesCount=0
						jailed=True
					else:
						player.doublesCount+=1
						send = "Double! Take another turn!"
				else:
					player.inJail=False
					send = "you're free from jail!"
				print(0, len(send), send)
				item.send(str(0).encode('utf-8') + str(len(send)).encode('utf-8') + send.encode('utf-8'))
			else:
				player.doublesCount=0
				if not player.inJail:
					player.position=(player.position+dice2+dice1)%40
					if player.position <= dice1 + dice2 - 1:
						player.money+=200
						send = "You passed Go! You collect $200. You now have ${}.".format(player.money)
						item.send(str(1).encode('utf-8') + str(len(send)).encode('utf-8') + send.encode('utf-8'))
					send = "Your position is currently {}.".format(player.position)
					item.send(str(2).encode('utf-8') + str(len(send)).encode('utf-8') + send.encode('utf-8'))
				self.takeTurn(player, tiles)
			if dice1==dice2 and not player.inJail and not jailed:
				return True
			return False
		

	def takeTurn(self, player, tiles):
		print("You've landed on " + tiles.tiles[str(player.position)][0]+".")
		self.display()
		tile= tiles.tiles[str(player.position)]
		if tiles.tileOwner(tile,self.players)!=player and tiles.tileOwner(tile,self.players)!=None:
			self.payRent(player, tiles.tileOwner(tile,self.players), tile)
		inputLoop=True
		if player.position in tiles.normal:
			while inputLoop:
				action=""
				print("What would you like to do? You currently have $"+str(player.money)+".\n Enter a number.\n1) Buy this property. It costs $"+str(tiles.tilesProperties(player.position)[2])+".\n2) Buy a house or hotel on this property. It costs $"+str(tiles.tilesProperties(player.position)[3])+".\n3) Pass your turn.")
				action=input()

				if action in "123" and action!="":
					inputLoop= False

				if action=="1":
					if tiles.tileOwner(tile,self.players)==None:
						if tiles.tilesProperties(player.position)[2]> player.money:
							print("You cannot afford this property.") 
						else:
							self.buyProperty(player, tile, tiles,player.position)
					else:
						print("Someone already owns this property.")
						inputLoop=True

				elif action=="2":
					if tiles.tileOwner(tile,self.players)==player:
						if tiles.tilesProperties(player.position)[3]> player.money:
							print("You cannot afford to build on this property.")
						self.buyHouse(player, tile, tiles, player.position)
					else:
						print("You must own this property to build on it.")
						inputLoop=True


				elif action=="3":
					return None


		elif player.position in tiles.util or player.position in tiles.transport:
			while inputLoop:
					action=""
					print("What would you like to do? You currently have $"+str(player.money)+".\n Enter a number.\n1) Buy this property. It costs $"+str(tiles.tilesProperties(player.position)[2])+".\n2) Pass your turn.")
					action=input()

					if action in "12" and action!="":
						inputLoop= False

					if action=="1":
						if tiles.tileOwner(tile,self.players)==None:
							if tiles.tilesProperties(player.position)[2]> player.money:
								print("You cannot afford this property.") 
							else:
								self.buyfacility(player, tile, tiles,player.position)
						else:
							print("Someone already owns this property.")
							inputLoop=True


					elif action=="2":
						return None

		elif player.position==30:
			player.inJail=True
			print("Go to jail! Do not pass Go. Do not collect $200.")
			player.position=19
			player.doublesCount=0
			return None

		elif player.position==2 or player.position==17:
			print("Community Chest! You draw a card.")
			player.money+=100
			print("It's your birthday! You get $100. You now have $"+str(player.money)+".")

		elif player.position==7 or player.position==22:
			print("Chance! You draw a card.")
			player.money-=100
			print("It's tax time! You lose $100. You now have $"+str(player.money)+".")
			if player.money<=0:
				self.lose(player)


		elif player.position==4:
			print("Income tax. You lose $200.")
			player.money-=100
			print("You now have $"+str(player.money)+".")
			if player.money<=0:
				self.lose(player)


		elif player.position==38:
			print("Super tax. You lose $100.")
			player.money-=100
			print("You now have $"+str(player.money)+".")
			if player.money<=0:
				self.lose(player)


	def payRent(self, player, owner, tile):
		rent= owner.properties[tile][2]
		player.money-=rent
		owner.money+=rent
		if player.money<=0:
			owner.money+=player.money
		print("You've landed on "+owner.name+"'s tile. You have paid "+str(rent)+" in rent. You now have $"+str(player.money)+". ")
		if player.money<=0:
			owner.money+=player.money
			self.lose(player)
		return None

	def buyProperty(self,player,tile,tiles,position):
		rent= tiles.tiles[str(position)][4]
		player.properties[tile]= [0,0,rent]
		player.money-=tiles.tiles[str(position)][2]
		print("You have purchased "+tiles.tiles[str(position)][0]+". You now have $"+str(player.money)+" remaining.")
		if player.money<=0:
			self.lose(player)
		return None

	def buyfacility(self,player,tile,tiles,position):
		rent= tiles.tiles[str(position)][2]
		player.properties[tile]= [0,0,rent]
		player.money-=tiles.tiles[str(position)][2]
		print("You have purchased "+tiles.tiles[str(position)][0]+". You now have $"+str(player.money)+" remaining.")
		if player.money<=0:
			self.lose(player)
		return None


	def buyHouse(self, player, tile, tiles, position):

		if player.properties[tile][0]!=4:
			player.money-=tiles.tilesProperties(player.position)[3]
			player.properties[tile][0]+=1
			print(player.properties[tile][0])
			rent= tiles.tiles[str(position)][4+player.properties[tile][1]]
			print("You have purchased a house on "+tiles.tiles[str(position)][0]+". You now have $"+str(player.money)+" remaining. Rent is now "+str(rent)+".")
			if player.money<=0:
				self.lose(player)
		else:
			if player.properties[tile][1]==1:
				print("You can't build anything else on this tile.")
			else:
				player.money-=self.tilesProperties(player.position)[3]
				player.properties[tile][1]=1
				rent=  tiles.tiles[str(position)][9]
				print("You have purchased a hotel on"+tiles.tiles[str(position)][0]+". You now have $"+str(player.money)+" remaining. Rent is now "+str(rent)+".")
				if player.money<=0:
					self.lose(player)
		player.properties[tile][2]=rent
		return None



class Tile:
	def __init__(self):
		self.other = [0, 2, 4, 7, 10, 17, 20, 22, 30, 33, 36, 38]
		self.util = [12, 28]
		self.transport = [5, 15, 25, 35]
		self.normal= [1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39]
		self.tiles = {
		# (name,color,price,housePrice,rent,rent1,rent2,rent3,rent4,rentHotel,mortgage,demortgage)
		"1":("Ha'penny Bridge","brown",60,50,2,10,30,90,160,250,30,33),
		"3":("Molly Malone Statue","brown",60,50,4,20,60,180,320,450,30,33),
		"6":("Dublin Zoo","light blue",100,50,6,30,90,270,400,550,50,55),
		"8":("Kilmainham Gaol","light blue",100,50,6,30,90,270,400,550,50,55),
		"9":("Irish Museum of Modern Art","light blue",120,50,8,40,100,300,450,600,60,66),
		"11":("The Royal Dublin Golf Club","pink",140,100,10,50,150,450,625,750,70,77),
		"13":("Croke Park","pink",140,100,10,50,150,450,625,750,70,77),
		"14":("Aviva Stadium","pink",160,100,12,60,180,500,700,900,80,88),
		"16":("Brown Thomas","orange",180,100,14,70,200,550,750,950,90,99),
		"18":("Dundrum Town Centre","orange",180,100,14,70,200,550,750,950,90,99),
		"19":("Arnotts","orange",200,100,16,80,220,600,800,1000,100,110),
	    "21":("National Botanic Gardens","red",220,150,18,90,250,700,875,1050,110,121),
	    "23":("Guinness Storehouse","red",220,150,18,90,250,700,875,1050,110,121),
	    "24":("Weir and Sons","red",240,150,20,100,300,750,925,1100,120,132),
	    "26":("Freshly Chopped","yellow",260,150,22,110,330,800,975,1150,130,143),
	    "27":("National Gallery of Ireland","yellow",260,150,22,110,330,800,975,1150,130,143),
	    "29":("Temple Bar","yellow",280,150,24,120,360,850,1025,1200,140,154),
	    "31":("St. Columbas College","green",300,200,26,130,390,900,1100,1275,150,165),
	    "32":("Nord Anglia International School Dublin","green",300,200,26,130,390,900,1100,1275,150,165),
	    "34":("Dublin City University","green",320,200,28,150,450,1000,1200,1400,160,176),
	    "37":("Phoenix Park","blue",350,200,35,175,500,1100,1300,1500,175,192),
	    "39":("GPO","blue",400,200,50,200,600,1400,1700,2000,200,220),
		#transport
		"5":("Dublin Airport","travel",200,25,50,100,200),
		"15":("Luas","travel",200,25,50,100,200),
		"25":("Dublin Port","travel",200,25,50,100,200),
		"35":("Dublin Bus","travel",200,25,50,100,200),
		#utility
		"12":("Electric Company","utility",150),
		"28":("Water Works","utility",150),
		#other
		"0":("Pass Go", 0),
		"2":("Community Chest", 0),
		"4":("Income Tax", 0),
		"7":("Chance", 0),
		"10":("In jail/ Just visiting", 0),
		"17":("Community Chest", 0),
		"20":("Free parking", 0),
		"22":("Chance", 0),
		"30":("Go to Jail", 0),
		"33":("Community Chest", 0),
		"36":("Chance", 0),
		"38":("Super Tax", 0)}

		self.colors = {
		"brown": {"Ha'penny Bridge","Molly Malone Statue"},
		"light blue": {"Dublin Zoo","Kilmainham Gaol","Irish Museum of Modern Art"},
		"pink": {"The Royal Dublin Golf Club","Croke Park","Aviva Stadium"},
		"orange": {"Brown Thomas","Dundrum Town Centre","Arnotts"},
		"red": {"National Botanic Gardens","Guinness Storehouse","Weir and Sons"},
		"yellow": {"Freshly Chopped","National Gallery of Ireland","Temple Bar"},
		"green": {"St. Columbas College","Nord Anglia International School Dublin","Dublin City University"},
		"blue": {"Phoenix Park","GPO"}}

	def tileOwner(self, tile, playerlist):
		for player in playerlist:
			if tile in player.properties.keys():
				return player
		return None

	def tilesProperties(self, position):
		return self.tiles[str(position)]



def main():
	print("Welcome to Monopoly.")
	run = Round(playerlist)
	tiles = Tile()
	run.rotation(tiles)


def receive_message(client_socket):
	try:
		message_header = client_socket.recv(HEADER_LENGTH)
		if not len(message_header):
			return False

		message_length = int(message_header.decode('utf-8').strip())
		return {'header': message_header, 'data': client_socket.recv(message_length)}

	except Exception as e:
		print(e)
		return False

import random
import pygame
from pygame.locals import*
import socket
import select
import sys
import time
HEADER_LENGTH = 10
IP = ""
PORT = 8000
#init host player
playerlist=[]
nameInput=input("Please enter your name: ")
i=0
colours=["red","green","blue","pink"]
playerlist.append(Player(nameInput, colours[0]))

#start server open for connections
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
try:
	server_socket.bind((IP, PORT))
except PermissionError:
	print("Could not create game server.")
	sys.exit()
server_socket.listen()

sockets_list = [server_socket]
clients = {}
print('Waiting for players to connect to game.')

x = ""
i = 1
while i < 4 and x != "n":
	read_sockets, x, exception_sockets = select.select(sockets_list, [], sockets_list)
	for notified_socket in read_sockets:
		if notified_socket == server_socket:
			client_socket, client_address = server_socket.accept()
			user = receive_message(client_socket)
			#print(user)
			if user is False:
				continue
			sockets_list.append(client_socket)
			clients[client_socket] = user
		else:
			message = receive_message(notified_socket)
			if message is False:
				print('Closed connection from: {}'.format(clients[notified_socket]['data'].decode('utf-8')))
				sockets_list.remove(notified_socket)
				del clients[notified_socket]
				continue
			user = clients[notified_socket]

			print(f'Received message from {user["data"].decode("utf-8")}: {message["data"].decode("utf-8")}')
			for client_socket in clients:
				if client_socket != notified_socket:
					client_socket.send(user['header'] + user['data'] + message['header'] + message['data'])
	for notified_socket in exception_sockets:
		sockets_list.remove(notified_socket)
		del clients[notified_socket]
	try:
		nameInput = user['data'].decode('utf-8')
		print('New player added to game: {}'.format(nameInput))
		p = Player(nameInput, colours[i])
		clients[client_socket] = (user, p)
		playerlist.append(p)
		i += 1
		if i < 4:
			x = input("Would you like more players (y/n)")
	except:
		pass

if __name__ == '__main__':
	main()
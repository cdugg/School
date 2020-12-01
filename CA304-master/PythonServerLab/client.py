import socket, select, sys

ip_addr = '127.0.0.1'
port = 8000

server_connection = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_connection.connect((ip_addr, port))
print('Client connected')

inputs = [sys.stdin, server_connection]

while True:
	try:
		read, write, error = select.select(inputs, [], [])
		for data_input in read:
			if data_input == server_connection:
				message = data_input.recv(1024)
				pasrsed_message = message.decode()
				if pasrsed_message != '':
					print(pasrsed_message)
			else:
				message = sys.stdin.readline()
				server_connection.send(message.encode())
				sys.stdout.write('<You>')
				sys.stdout.write(message)
				sys.stdout.flush()
	except KeyboardInterrupt:
		server_connection.close()
		print("Disconnected")
		sys.exit(0)

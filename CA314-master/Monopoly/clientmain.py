class Board():
	def __init__(self):
		self.white = (255, 64, 64)
		self.w = 425
		self.h = 425
		self.screen = pygame.display.set_mode((self.w, self.h))
		self.screen.fill((self.white))
		self.gameDisplay = pygame.display.set_mode((self.w,self.h))
		self.x,self.y=390,390
		self.img = pygame.image.load('Images/monopoly.jpg')
	def initboard(self):
		self.screen.fill((self.white))
		self.screen.blit(self.img,(0,0))
		images = []
		posxs = []
		posys = []
		client_socket.setblocking(True)
		for i in range(0, len(playerlist)):
			imglen = int(client_socket.recv(2).decode())
			imgloc = client_socket.recv(imglen).decode()
			#print(imglen, imgloc)
			pxlen = int(client_socket.recv(1).decode())
			posx = int(client_socket.recv(pxlen).decode())
			pylen = int(client_socket.recv(1).decode())
			posy = int(client_socket.recv(pxlen).decode())
			self.gameDisplay.blit(pygame.image.load(imgloc), (posx, posy))
		pygame.display.flip()

def lose():
	print('You lost GG in the chat.')
	sys.exit()

def boardload(bored):
	#print('boardload')
	imglen = int(client_socket.recv(2).decode())
	imgloc = client_socket.recv(imglen).decode()
	pxlen = int(client_socket.recv(1).decode())
	posx = int(client_socket.recv(pxlen).decode())
	pylen = int(client_socket.recv(1).decode())
	posy = int(client_socket.recv(pylen).decode())
	#print(imglen, imgloc, pxlen, posx, pylen, posy)
	bored.gameDisplay.blit(pygame.image.load(imgloc), (posx, posy))
	pygame.display.flip()

def recieve():
	#print('recieve')
	hilen = int(client_socket.recv(2).decode())
	hitxt = client_socket.recv(hilen).decode()
	#print(hilen, hitxt)
	print(hitxt)
	rollen = int(client_socket.recv(2).decode())
	rolltxt = client_socket.recv(rollen).decode()
	print(rolltxt)
	nextt = int(client_socket.recv(1).decode())
	#print(nextt)
	if nextt == 0:#got doubles
		dlen = int(client_socket.recv(2).decode())
		dtxt = client_socket.recv(dlen).decode()
		print(dtxt)
	elif nextt == 1:
		plen = int(client_socket.recv(2).decode())
		ptxt = client_socket.recv(plen).decode()
		print(ptxt)
		ignore = int(client_socket.recv(1).decode())
		#print(ignore)
		poslen = int(client_socket.recv(2).decode())
		posprint = client_socket.recv(poslen).decode()
		print(posprint)
	else:
		poslen = int(client_socket.recv(2).decode())
		posprint = client_socket.recv(poslen).decode()
		print(posprint)

def turn():
	#print('turn')
	x = int(client_socket.recv(1).decode())
	print(x)
	if x == 0:
		plen = int(client_socket.recv(2).decode())
		ptxt = client_socket.recv(plen).decode()
		print(ptxt)

import pygame
import socket
import select
import errno
import sys
import time

HEADER_LENGTH = 10

IP = "127.0.0.1"
PORT = 8000
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    client_socket.connect((IP, PORT))
except:
    print("Incorrect port or IP address provided.")
    sys.exit()
client_socket.setblocking(False)
my_username = input("Username: ")
username = my_username.encode('utf-8')
username_header = f"{len(username):<{HEADER_LENGTH}}".encode('utf-8')
client_socket.send(username_header + username)
print("Waiting for host to start game.")

#recieve playerlist
playerlist = []
while len(playerlist) < 5:
	try:
		username = client_socket.recv(HEADER_LENGTH)
		if not len(username):
			print('Connection closed by the server')
			sys.exit()
		if username.decode('utf-8') == 'Done':
			break
		playerlist.append(username.decode('utf-8'))
	except:
		pass

bored = Board()
bored.initboard()
bored.screen.fill((bored.white))
bored.screen.blit(bored.img,(0,0))
time.sleep(100)
while True:
	for i in range(0, len(playerlist)):
		x = int(client_socket.recv(1))
		client_socket.setblocking(True)
		if x == 0:
			lose()
		elif x == 1:
			boardload(bored)
			bored.screen.fill((bored.white))
			bored.screen.blit(bored.img,(0,0))
		elif x == 2:
			recieve()

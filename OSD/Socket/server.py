import socket
s=socket.socket()
host = socket.gethostname()
port = 12345
s.bind((host,port))
s.listen(5)
while True:
	c,add = s.accept()
	print "sending..."
	c.send("Received from Server")
c.close()
s.close()

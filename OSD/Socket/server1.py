import socket
s=socket.socket()
port = 12345
s.bind(("10.1.100.233",port))
s.listen(5)
while True:
	c,add = s.accept()
	print "connection is done with:",add
	c.send("Received from Server")
c.close()
s.close()

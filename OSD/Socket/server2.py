import socket

s=socket.socket()
port = 12345
s.bind(("10.1.100.233",port))
s.listen(5)

while True:
	c,add = s.accept()
	c.send("\n1.server.py\n2.client.py\n3.server1.py")
	m = c.recv(1024)
	fd = open(m,'r')
	buff = fd.read()
	c.send(buff)


c.close()
s.close()

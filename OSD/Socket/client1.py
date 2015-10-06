import socket
c = socket.socket()
port = 12345
c.connect(("10.1.96.143",port))
m = c.recv(1024)
print "Receiving from server - 10.1.96.143"
print m
c.close()

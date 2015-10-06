import socket
c = socket.socket()
host = socket.gethostname()
port = 12345
c.connect((host,port))
m = c.recv(1024)
print m
c.close()

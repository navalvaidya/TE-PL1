import socket
c=socket.socket()
p=12345
c.connect(("10.1.100.233",p))
m=c.recv(1024)
print "Receiving from server-10.1.100.233"
print m
ch=raw_input("Enter the name")
c.send(ch)
print "Choice sent"
n=c.recv(1024)
f=open(ch,'w')
f.write(n)
print n
c.close()

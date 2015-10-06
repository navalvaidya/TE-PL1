import os,sys
r,w =os.pipe()
child=os.fork()

if child:
	os.close(r)
	print("Child Process Writing..........")
	w=os.fdopen(w,'w')
	w.write("Using Pipes")
	print("String Written")
	
		
else:
	os.close(w)
	print("Parent Process reading............")
	r=os.fdopen(r,'r')
	tempstr=r.read()
	print("read string from pipe")
	print("Printing Original string .......")
	print(tempstr)
	print("Printing reversed string .......")
	rev=tempstr[::-1]
	print(rev)
	
	
		
	


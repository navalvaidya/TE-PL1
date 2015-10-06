import pymongo

client = pymongo.MongoClient( "localhost" , 27017 ) 
db=client.test

while True:
	print "1.View Databases\n2.View Collection\n3.view documents of collection student\n4.Insert Into collection student\n5.Delete from 	collection student by id\n6.Update collection student\n7.Exit"
	ch=raw_input("Enter your choice :")
	if(ch=='7'):
		break
	
	if(ch=='1'):
		print"\nName of Databases"
		a=client.database_names()
		print a
	
	if(ch=='2'):
		b=db.collection_names()
		print "\nName of Collections:"
		print b
	
	if(ch=='3'):	
		print "\nPrinting data of student collection:"
		data=db.student.find()
		for c in data:
			print c
		
	if(ch=='4'):
		uid=raw_input("enter id :")
		uname=raw_input("enter name :s")
		db.student.insert({'id':uid,'name':uname})
	
	if(ch=='5'):
		did=raw_input("Enter the id whose document is to be deleted :")
		db.student.remove({'id':did})
	
	if(ch=='6'):
		upid=raw_input("Enter the id whose document is to be updated :")
		name=raw_input("Enter updated name of given id :")
		db.student.update({'id':upid},{'name':name})







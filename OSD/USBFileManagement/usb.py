import os,sys
while(True):
	print "\n1.List the files in USB\n2.Make \n3.Delete \n4.Copy files\n5.Rename a file.\n6.Modify file content.\n7.Display file content.\n8.Exit";
	ch=raw_input("Enter your choice :");
	if(ch=='8'):
		break;

	if(ch=='1'):
		os.system("ls -l /media/naval/NAVAL");

	if(ch=='2'):
		ch=raw_input("Make a directory or file (d/f) :")
		if(ch=='f'):
			name=raw_input("Enter the name of the file :")
			path="/media/naval/NAVAL/"+name
			fopen=open(path,'w')
			fopen.close()
			print "File successfully created!"
	
		if(ch=='d'):

			name=raw_input("Enter the name of the Directory :")
			path="/media/naval/NAVAL/"+name
			os.mkdir(path,1777)
			print "Directory successfully created!"
	if(ch=='3'):
	
		ch=raw_input("Make a directory or file (d/f) :")
		if(ch=='f'):
			name=raw_input("Enter the path of the file :")
			path="/media/naval/NAVAL/"+name
			os.system("rm "+path)
		if(ch=='d'):
			name1=raw_input("Enter the path of the directory :")
			path1="/media/naval/NAVAL/"+name1
			os.system("rmdir "+path1)
	if(ch=='4'):
		src = raw_input("Enter path of file source :")
		dest = raw_input("Enter path of destination directory :")
		srcpath="/media/naval/NAVAL/"+src
		destpath="/media/naval/NAVAL/"+dest		
		os.system('cp '+srcpath+' '+destpath)
		print "File successfully copied to Destinatiion directory"

	if(ch=='5'):
		old=raw_input("Enter the path of file or directory to be renamed :")
		new=raw_input("Enter the path of new file or directory name :")
		oldpath="/media/naval/NAVAL/"+old
		newpath="/media/naval/NAVAL/"+new
		os.system("mv "+oldpath+" "+newpath)
	
	if(ch=='6'):
		print "opening vi editor............"
		print "i->insert\nh,j,k,l->left,down,up,right\ndd->remove a line\n:q->quit\n:q!->quit without savingn\n:wq->wrire and quit"
		name=raw_input("Enter the path of file to open for Editing :")
		path="/media/naval/NAVAL/"+name
		os.system("vi "+path)
	
	if(ch=='7'):
		name=raw_input("Enter Path of file :")
		path="/media/naval/NAVAL/"+name
		print "Displaying content of file"
		os.system("cat "+path)


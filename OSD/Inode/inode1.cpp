/*To Run The Program
 Syntax :- g++ Program_name.cpp &
 	./a.out
*/
#include<iostream>
#include<stdlib.h>
#include<stdio.h>
#include<sys/stat.h>
using namespace std;
int main(int argc,char *argv[])
{
struct stat sb;
FILE *ptr;
char filename[10];
cout<<"Enter the name of file";
cin>>filename;

stat(filename,&sb);
if(stat(filename,&sb)==-1){
	cout<<"file does not exist";
	cout<<"Creating file ";
	ptr=fopen(filename,"wb");
	fclose(ptr);
	}
else   {
stat(filename,&sb);
 if(S_ISBLK(sb.st_mode)){cout<<"block device\n";}            
  else if(S_ISCHR(sb.st_mode)){cout<<"character device\n";} 
  else if(S_ISDIR(sb.st_mode)){cout<<"directory\n";}
  else if(S_ISLNK(sb.st_mode)){cout<<"symlink\n";}  
  else if(S_ISREG(sb.st_mode)){cout<<"regular file\n";}
  else if(S_ISSOCK(sb.st_mode)){cout<<"socket\n";}      
   else {cout<<"unknown?\n";}    


cout<<"\n1.The size of file is"<<sb.st_size;
cout<<"\n2.Inode Number of file is"<<sb.st_ino;
cout<<"\n3.Mode:(octal)"<<sb.st_mode;
cout<<"\n4.Link count:"<<sb.st_nlink;
cout<<"\n5.Ownership:UID="<<sb.st_uid<<"\n \tGID="<<sb.st_gid;
cout<<"\n6.Preferred I/O block size:"<<sb.st_blksize<<"In Bytes";
cout<<"\n7.File size:"<<sb.st_size<<"In Bytes";
cout<<"\n8.Blocks allocated:"<<sb.st_blocks<<"In Bytes";
cout<< "\n9. Time of last access:"<<sb.st_atime;
cout<<"\n10. Time of last modification:"<<sb.st_mtime;
cout<<"\n11. Time of status change:"<<sb.st_ctime;

}
}


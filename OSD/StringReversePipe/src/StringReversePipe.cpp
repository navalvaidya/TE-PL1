//============================================================================
// Name        : StringReversePipe.cpp
// Author      : Naval Vaidya
// Version     :
// Copyright   : Your copyright notice
// Description : String Reversel Parent Process,Child Process,Pipes
//============================================================================

#include <unistd.h>
#include <iostream>
#include <string.h>
#include <stdlib.h>
using namespace std;

int main(){
	int fd[2];
	pipe(fd);
	int length;
	char buffer[100];
	char buffer1[100];
	char reverse[100];
	char data[100]= "TestingPipe";
	length=strlen(data);
	pid_t child;

	child=fork();

	if(child==0){

		write(fd[1],data,strlen(data));
		cout<<"Child Process data written to pipe\n";
		sleep(3);

		read(fd[0],buffer1,100);

		for(int j=0;j<length;j++){
			if(buffer1[j]!='\0')
				cout<<buffer1[j];
		}
	}

	else{

			read(fd[0],buffer,100);
			cout<<"Parent Process read data from pipe\n";


			for(int j=0;j<length;j++){
				if(buffer[j]!='\0')
					cout<<buffer[j];
			}

			for(int i=0;i<length;i++){
				if(buffer[i]!='\0')
					reverse[length-1-i]=buffer[i];
			}
			cout<<"\nReverse String: "<<reverse<<endl;
			write(fd[1],reverse,strlen(data));
			cout<<"Parent Process writing Data\n";
		}
}

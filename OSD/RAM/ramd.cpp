#include <iostream>
#include <stdlib.h>
#include <spawn.h>
#include <sys/wait.h>

using namespace std;

int main(int argc, char *argv[],char *envp[])
{

pid_t c;
int ret,waitt;
system("rm -r /run/ramd");
system("umount /run/ramd");
system("rmdir /run/ramd");
system("mkdir /run/ramd");
system("chmod 777 /run/ramd");
system("mount -t tmpfs -o size=4096k yay /run/ramd");
system("cp cal.cpp /run/ramd");
system("chmod 777 /run/ramd/cal.cpp");
system("df -h | grep ramd");
system("g++ /run/ramd/cal.cpp");
system("cp a.out /run/ramd");

ret=posix_spawn(&c,"/run/ramd/a.out",NULL,NULL,argv,envp);

if(ret==0)
cout<<"Welcome!\n";
else
cout<<"Error! Process could not be created!\n";

wait(&waitt);

return 0;

}

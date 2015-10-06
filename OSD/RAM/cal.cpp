#include <iostream>
using namespace std;

int main()
{
int a,b,ans;
int ch;
char chc;
cout<<"\nEnter the two nos.\n";
cin>>a>>b;

do
{
cout<<"1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\nEnter your choice\n";
cin>>ch;
switch(ch)
{
case 1:
ans=a+b;
cout<<"Addition: "<<ans<<endl;
break;
case 2:
ans=a-b;
cout<<"Subtraction: "<<ans<<endl;
break;
case 3:
ans=a*b;
cout<<"Multiplication: "<<ans<<endl;
break;
case 4:
ans=a/b;
cout<<"Division: "<<ans<<endl;
break;
default:
cout<<"\nWrong Choice!!\n";
}
cout<<"Enter y to continue\n";
cin>>chc;
}while(chc=='y');

return 0;
}


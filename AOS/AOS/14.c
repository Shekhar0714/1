#include<stdio.h>
#include<stdlib.h>
//#include<fntcl.h>
#include<sys/stat.h>
void first()
{
	printf("U r in 1st\n");
}
void second()
{
	printf("U r in 2nd\n");
}
 int main()
 {

 	atexit(first);
 	atexit(second);
  	atexit(first);
 	return 0;
 }

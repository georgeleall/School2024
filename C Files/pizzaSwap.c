#include <stdio.h>

int swap(int *x, int *y){
int z = *x; //assigning temporary var to pointer x.
*x = *y; //assigning pointer x to pointer y.
*y = z; //setting pointer y to temporary var.
}

void main(void){

int x = 4; //assigning values
int y = 9;

printf("%s\n","X and Y values before swap");
printf("%d\n",x);
printf("%d\n",y); //print x and y value before swap

swap(&x,&y); //calling swap function

printf("%s\n","X and Y values after swap");
printf("%d\n",x);
printf("%d\n",y); //print x and y value after swap
}


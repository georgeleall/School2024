#include <stdio.h>

int add(int x, int y, int z); //calling functions lines 3-6
int subtract(int x, int y, int z);
int divide(int x, int y);
int multiply(int x, int y);


int main(){
int x = 3; //initializing variables in lines 2-4 
int y = 4;
int z = 5;

printf("%d\n", divide(multiply(add(x, y, z), x), x)); //printing functions 14-15
printf("%d\n", multiply(subtract(x, y, z), y));

return 0;
}


int add(int x,int y,int z){ //creating functions 21-39
return x+y+z;
}

int subtract(int x,int y,int z){
return z-y-x;
}

int divide(int x,int y){
if(y==0){ //if y=0 this if statement will prevent the zero division error.
printf("Invalid Denominator");
}

return x/y;
}

int multiply(int x,int y){
return x*y;
}

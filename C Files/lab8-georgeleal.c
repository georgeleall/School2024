#include <stdio.h>

int a = 0; // initializing global variable a
int b = 0; // initializing global variable b

int whatPercentage(); // calling function

int main(){
a = 10; //giving first value
b = 5; //giving first value
printf("%d\n",whatPercentage()); //printing percentage

a = 2; //giving second value
b= 1; //giving second value
printf("%d\n",whatPercentage()); //printing percentage

return 0;
}

int whatPercentage(){ //creating function with formula
return ((b*100/a)); // my error was multiplying last, I needed to multiply first, as integer division discards decimals.
}

//4. When I first call the function with the values a=10 and b=5, it gives me the percentage 50%. When I call it the 2nd time a and b both have new values which is a=2 and b=1 which would be 50%.

//5. When I would try to run const int for the global declaration, it would give me an error. This is because I would try to change the values under it and with const ints, you can not change the values.

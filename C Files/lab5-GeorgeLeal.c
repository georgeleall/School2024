#include <stdio.h>

// 1. I will begin by asking the user for their input of a number.
// 2. I will then create and assign a variable to that number.
// 3. I will check if it's even or odd.
// 4. I will then return the results of the even or odd test.
int main(){

int number = 0;

printf("Enter a number:");
scanf("%d", &number);

if(number%2==0){
printf("The number you entered (%d) is even.\n",number);
}

else{
printf("The number you entered (%d) is odd.\n",number);
}

return 0;

}

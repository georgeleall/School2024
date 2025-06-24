#include <stdio.h>

int totalbooks=0; //setting both variables to 0.
int userbooks=0;

int main(){

while(1){ //creating infinite loop
printf("Please enter how many books you would like to enter.");
if(scanf("%d", &userbooks) == 0){ //asking for user input and breaking if user inputs 0.
break;
}
else{
totalbooks+= userbooks; //if not 0 and user did not input quit, the user's book number will be added to total books and will keep going until user quits or inputs 0.
}
}

printf("Total number of books: %d\n", totalbooks); // returns the total amount of books.
return 0; 
}

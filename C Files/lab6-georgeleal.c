#include <stdio.h>

//1. I will first create a variable to store the next biggest value. 
//2. I will then create a counter.
//3. I will create a while loop that will run through the list of scores.
//4. I will then create an if statement that will compare two values.
//5. If the current highest number is smaller than the current value, the highest number will be updated to the current value.
//6. Then the counter will increment through the list.
//7. The output will then be displayed.

int main(){

int score = 0;
int highest = 0;
int i=0;

printf("Please enter scores for the students.\n");


while(i<10){
printf("Enter the score for the Student %d:", i+1);
scanf("%d", &score);

if(score>highest){
highest=score;
}


i++;
}
printf("The highest score entered is: %d\n", highest);

return 0;
}

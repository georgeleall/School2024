#include <stdio.h>
#include <stdlib.h>
int main()
{
int n;
// take n input from user, should be more than 4

printf("Please enter the size of the zoo.");
while (scanf("%d", &n) == 1) {
        if (n >= 4) {
            break; 
        }
        else {
            printf("Make your number larger than 4: ");
        }
}
// Allocate memory for an array of string pointers (zoo)
char **zoo = (char **)malloc(n * sizeof(char *));
zoo[0] = "Monkey";
zoo[1] = "Tiger";
zoo[2] = "Gorilla";
// assign names to all n value
zoo[n - 1] = "Beluga";

// Prints the first three animals
printf("First three animals in the zoo: \n");
// apply for loop on zoo and print first 3 animal name
for (int i = 0; i < 3; i++){
        printf("%s\n", zoo[i]);
}
// Prints the last animal name -> zoo[n - 1];
printf("Last animal in the zoo: \n");
printf("%s\n", zoo[n-1]);
// Free the dynamically allocated memory
free(zoo);
return 0;
}

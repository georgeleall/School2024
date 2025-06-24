#include <stdio.h>
#include <stdlib.h>

struct book { //creating the struct lines 4-8
    char name[100];
    char author[100];
    int year;
};

void printFunc(struct book *books, int n) { //creating a function that will print out each of the struct properties.
for (int i = 0 ; i < n; i++) { //this for loop goes through the struct.
    // print all records
    printf("\nBook %d:\n", i + 1);
    printf("Book Name: %s\n", books[i].name);
    printf("Author Name: %s\n", books[i].author);
    printf("Year Published: %d\n",books[i].year);
    }
}

int main(){

    int n = 0; //creating a variable that will ask the user to decide how many books they want to enter.
    
printf("Please enter how many books you would like to  enter.");
scanf("%d", &n); //asking the user to input the number of books they would like to enter.

    struct book books[n];
    for (int i = 0 ; i < n ; i++) { //creating a function that goes through each of the struct's properties that will assign it.
        printf("\nBook %d:\n", i + 1);
        
        printf("Book Name: "); //asking the user for the book name
        scanf(" %[^\n]", books[i].name);
        
        printf("Book Author: "); //asking the user for the book author
        scanf(" %[^\n]", books[i].author);
        
        printf("Year Published: "); //asking the user for the year the book was published.
        scanf("%d", &books[i].year);
        
    }
    printFunc(books, n); //calling the function
    
    return 0;
}

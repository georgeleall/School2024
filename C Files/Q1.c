#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student {
char name[10];
int id;
double gpa;
};

void show_student(struct student *curr){
    printf("%s has id %d and GPA %.2f\n", curr->name, curr->id, curr->gpa);

}

int search_by_name(struct student *students, int length){
    char name[10];  // Buffer to store the name input
    int i, j;

    printf("Enter the name to search for: ");
    scanf("%s", name); 
    
    for (i = 0; i < length; i++) {
        for (j = 0; j < 10; j++) {
            if (students[i].name[j] != name[j]) {
                break;
            }
            if (students[i].name[j] == '\0' && name[j] == '\0') {
                show_student(&students[i]);
                return 1;
            }
        }
    }
    return 0;
}

int search_by_id(struct student *students, int length){
int id;

    printf("Enter the id to search for: ");
    scanf("%d", &id);
    
    for (int i = 0; i < length; i++) {
        if (students[i].id == id) {
            show_student(&students[i]);
            return 1;
        }
    }
    return 0;
}


int main(void) {
char choice;

struct student students[4] = {
  {"Fred", 1, 2.23},
  {"Wilma",2,3.65},
  {"Peter",3,4.00},
  {"Ed",4,3.0}
};

printf("Enter n for search by name or i for search by ID:");
scanf(" %c", &choice);

    if (choice == 'n') {
        search_by_name(students, 4);
    } else if (choice == 'i') {
        search_by_id(students, 4);
    } else {
        printf("Please make a valid choice.\n");
    }


return 0;
}

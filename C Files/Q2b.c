#include <stdio.h>
#include <stdlib.h>

// define struct
struct student {
    char name[50];
    int grade;
};

void printFunc(struct student *students, int n) {
for (int i = 0 ; i < n; i++) {
    // print all records
    printf("\nStudent %d:\n", i + 1);
    printf("Student Name: %s\n", students[i].name);
    printf("Student Age: %d\n",students[i].grade);
    }
}

int main(){
    int n = 1;
    struct student students[n];
    for (int i = 0 ; i < n ; i++) {
        printf("\nName %d:\n", i + 1);
        scanf("%s", students[i].name);
        //take all 4 variables value from user
        printf("Grade: ");
        scanf("%d", &students[i].grade);
    }
    printFunc(students, n);
}

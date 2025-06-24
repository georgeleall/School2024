#include <stdio.h>
#include <stdlib.h>

// define struct
struct student {
    char name[100];
    // define other 3 variables
    int age;
    float GPA;
    char major[100];
};

void printFunc(struct student *students, int n) {
for (int i = 0 ; i < n; i++) {
    // print all records
    printf("\nRecord %d:\n", i + 1);
    printf("Student Name: %s\n", students[i].name);
    printf("Student Age: %d\n",students[i].age);
    printf("Student GPA: %.1f\n", students[i].GPA);
    printf("Student Major: %s\n", students[i].major);
    }
}

int main(){
    int n = 3;
    struct student students[n];
    for (int i = 0 ; i < n ; i++) {
        printf("\nName %d:\n", i + 1);
        scanf("%s", students[i].name);
        //take all 4 variables value from user
        printf("Age: ");
        scanf("%d", &students[i].age);
        
        printf("GPA: ");
        scanf("%f", &students[i].GPA);
        
        printf("Major: ");
        scanf("%s", students[i].major);
        
    }
    printFunc(students, n);
}

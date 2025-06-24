#include <stdio.h>
#include <stdlib.h>

struct date {
int mm;
int dd;
int yyyy;
};

void days(struct date *date){
if (month <=2){
printf(1461*((yyyy-1)/4)+(153*((mm+13)/5))+dd)
}else{
printf(1461*((yyyy)/4)+153*((mm+1)/5)+dd)
}

int main(){
    struct student students[n];
    for (int i = 0 ; i < n ; i++) {
        printf("\Month :\n", i + 1);
        scanf("%d", date[i].mm);
        printf("Day: ");
        scanf("%d", &date[i].dd);
        printf("Year: ");
        scanf("%d", &date[i].yyyy);

    }
    days(date);
}

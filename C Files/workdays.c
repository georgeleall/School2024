#include <stdio.h>

enum week {Monday = 0, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday}; //creating the enum with the weekdays.

int main(){

int day = 0; //creating the day variable.

printf("Enter a day of the week, Monday being 0 and Sunday being 6.:\n");

scanf("%d", &day); //asking the user to choose a day of the week.

switch(day) { //creating switch case that will choose if it's a workday or weekend.
	case Monday:
	printf("It's a workday.\n");
	break;
	
	case Tuesday:
	printf("It's a workday.\n");
	break;
	
	case Wednesday:
	printf("It's a workday.\n");
	break;
	
	case Thursday:
	printf("It's a workday.\n");
	break;
	
	case Friday:
	printf("It's a workday.\n");
	break;
	
	case Saturday:
	printf("It's the weekend.\n");
	break;
	
	case Sunday:
	printf("It's the weekend.\n");
	break;
}

return 0;
}

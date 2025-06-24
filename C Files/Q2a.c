#include <stdio.h>
#include <stdlib.h>

int arrSize;

int arraySum(int* arr);

void arrayTraverse(int* arr);

int main(){

int* arr;

printf("Enter the size of the array: ");
scanf("%d", &arrSize);

arr = (int*)malloc(arrSize * sizeof(int));
arr[0]=1;
arr[1]=0;
arr[2]=3;
arr[3]=7;

for (int i = 0; i < arrSize; i++){
        printf("%d\n", arr[i]);
}

int sum = arraySum(arr);
printf("Sum of all elements in the array: %d\n", sum);

arrayTraverse(arr);


free(arr);
return 0;
}

int arraySum(int* arr){
//this function takes the pointer to the array and returns the sum of all the elements
int sum = 0;
for (int i = 0; i < arrSize; ++i) {
	sum += arr[i];
}
    return sum;
}

void arrayTraverse(int *arr){
//uses a pointer to print its position.
//For example, [1,2,3,4,5] if the user were to input position 0, the output should be 1.
int position = 0;

printf("Enter a position of the array: ");
scanf("%d", &position);

printf("Element at position %d: %d\n", position, arr[position]);
}

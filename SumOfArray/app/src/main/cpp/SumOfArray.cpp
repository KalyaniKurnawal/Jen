
#include "SumOfArray.h"
SumOfArray::SumOfArray(int x) {
    SumOfArray::num=x;
}

int SumOfArray::sum() {
    int count=num;
    int sum=0;
    for(int i=1;i<=count;i++)
    {
        sum=sum+i;
    }
    return sum;
}



#include "SortNumber.h"
#include <android/log.h>



void Sort::no_of_element(int m) {

    num=m;
    __android_log_print(ANDROID_LOG_ERROR, "Tag", "\n===== >Num=%d\n===== >INC =%d",num,inc);

}

void Sort::fun(int x) {

    __android_log_print(ANDROID_LOG_ERROR, "Tag", "\n===== >Num=%d\n===== >INC =%d",num,inc);

        if(num>inc) {
            array[inc] = x;
            inc++;
        }

    __android_log_print(ANDROID_LOG_ERROR, "Tag", "============== >Array Element %d\n======== >M = %d",array[inc-1],x);

}

bool Sort::sort() {

    for(int i=0;i<num;i++)
    {
        for(int j=i+1;j<num;j++)
        {
            if(array[i]>array[j])
            {
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
    }


    return true;
}
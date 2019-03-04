//
// Created by santosh on 4/2/19.
//

#include "Sort.h"
#include <android/log.h>

bool Sort::sort(int arr[],int n) {

    __android_log_print(ANDROID_LOG_ERROR, "Array Size = ", "%d",n);
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    for(int i=0;i<n;i++) {
            __android_log_print(ANDROID_LOG_ERROR, "Array Elements ", "%d", arr[i]);
    }
    return true;
}

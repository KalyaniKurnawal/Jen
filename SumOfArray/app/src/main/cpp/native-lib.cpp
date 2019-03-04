#include <jni.h>
#include <string>
#include "SumOfArray.h"

extern "C" JNIEXPORT jint JNICALL
Java_com_example_sumofarray_MainActivity_sum(
        JNIEnv *env,
        jobject ,jint num) {
    SumOfArray sumOfArray(num);
    return sumOfArray.sum();
}
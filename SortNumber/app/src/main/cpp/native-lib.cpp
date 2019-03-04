#include <jni.h>
#include <string>
#include "SortNumber.h"
#include <android/log.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_example_sortnumber_MainActivity_no_of_element(JNIEnv *env, jobject instance,jint no1) {

    Sort sort1;
    sort1.no_of_element(no1);
    __android_log_write(ANDROID_LOG_ERROR, "Tag", "============== >no_of_element called ");//Or ANDROID_LOG_INFO, ...
}
JNIEXPORT extern "C" void JNICALL
Java_com_example_sortnumber_MainActivity_fun(JNIEnv *env, jobject instance, jint no2) {

    Sort sort1;
    sort1.fun(no2);

    __android_log_write(ANDROID_LOG_ERROR, "Tag", "============== >Func() called ");//Or ANDROID_LOG_INFO, ...

}
extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_sortnumber_MainActivity_sort(JNIEnv *env, jobject instance) {

    Sort sort1;
    bool temp;
    temp = sort1.sort();

    __android_log_print(ANDROID_LOG_ERROR, "Tag", "============== >Sorting %d",temp );//Or ANDROID_LOG_INFO, ...
    return temp;
}extern "C"
JNIEXPORT void JNICALL
Java_com_example_sortnumber_MainActivity_no_1of_1element(JNIEnv *env, jobject instance, jint no1) {

    // TODO
    Sort sort1;
    sort1.no_of_element(no1);
    __android_log_write(ANDROID_LOG_ERROR, "Tag", "============== >no_of_element called ");//Or ANDROID_LOG_INFO, ...
}
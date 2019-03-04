#include <jni.h>
#include <string>
#include "Sort.h"

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_sno_MainActivity_sort(JNIEnv *env, jobject instance, jintArray array_, jint no1) {
    jint *array = env->GetIntArrayElements(array_, NULL);

    // TODO
    int temp;
    Sort s;
    temp=s.sort(array,no1);
    return temp;

}
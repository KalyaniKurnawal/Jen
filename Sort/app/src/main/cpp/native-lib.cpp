#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_sort_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jintArray JNICALL
Java_SortArray_sort(JNIEnv *env, jobject instance, jintArray arr_) {
    jint *arr = env->GetIntArrayElements(arr_, NULL);

    // TODO

    env->ReleaseIntArrayElements(arr_, arr, 0);
}
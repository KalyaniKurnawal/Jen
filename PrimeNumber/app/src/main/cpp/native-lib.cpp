#include <jni.h>
#include <string>
#include "PrimeNumber.h"

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_primenumber_MainActivity_isPrime(
        JNIEnv *env,
        jobject ,jint num) {
    PrimeNumber primeNumber(num);
    return primeNumber.isPrime();
}

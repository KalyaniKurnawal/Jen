//
// Created by santosh on 22/1/19.
//

#include "PrimeNumber.h"

PrimeNumber::PrimeNumber(int x) {
    PrimeNumber::num = x;

}
bool PrimeNumber::isPrime() {
    bool isPrime = true;
    for (int i = 2; i <=num/2 ; ++i) {
        if(num%i == 0){
            return false;
        } else{
            isPrime = true;
        }

    }
    return isPrime;
}
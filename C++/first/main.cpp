#include "DynamicArray.h"
#include <iostream>

int main() {
    DynamicArray arr1(5, 1);
    std::cout << "arr1: " << arr1 << std::endl;

    DynamicArray arr2 = arr1;
    std::cout << "arr2: " << arr2 << std::endl;

    DynamicArray arr3(3, 2);
    std::cout << "arr3: " << arr3 << std::endl;

    arr3 = arr2;
    std::cout << "arr3 (after assignment): " << arr3 << std::endl;

    arr3.resize(7);
    std::cout << "arr3 (after resizing): " << arr3 << std::

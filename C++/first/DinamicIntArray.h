#ifndef DYNAMIC_ARRAY_H
#define DYNAMIC_ARRAY_H

#include <iostream>
#include <stdexcept>

class DynamicArray {
private:
    int* data;
    int size;

public:
    DynamicArray();
    explicit DynamicArray(int size, int value = 0);
    DynamicArray(const DynamicArray& other);
    DynamicArray(DynamicArray&& other) noexcept;
    ~DynamicArray();
    int getSize() const;
    int& operator[](int index);
    void resize(int newSize);
    DynamicArray& operator=(const DynamicArray& other);
    DynamicArray& operator=(DynamicArray&& other) noexcept;
    bool operator==(const DynamicArray& other) const;
    bool operator!=(const DynamicArray& other) const;
    bool operator<(const DynamicArray& other) const;
    bool operator<=(const DynamicArray& other) const;
    bool operator>(const DynamicArray& other) const;
    bool operator>=(const DynamicArray& other) const;
    DynamicArray operator+(const DynamicArray& other) const;
};

std::ostream& operator<<(std::ostream& os, const DynamicArray& arr);
std::istream& operator>>(std::istream& is, DynamicArray& arr);

#endif

#include "DynamicArray.h"

DynamicArray::DynamicArray() : data(nullptr), size(0) {}

DynamicArray::DynamicArray(int size, int value) : size(size) {
    data = new int[size];
    for (int i = 0; i < size; ++i) {
        data[i] = value;
    }
}

DynamicArray::DynamicArray(const DynamicArray& other) : size(other.size) {
    data = new int[size];
    for (int i = 0; i < size; ++i) {
        data[i] = other.data[i];
    }
}

DynamicArray::DynamicArray(DynamicArray&& other) noexcept : data(other.data), size(other.size) {
    other.data = nullptr;
    other.size = 0;
}

DynamicArray::~DynamicArray() {
    delete[] data;
}

int DynamicArray::getSize() const {
    return size;
}

int& DynamicArray::operator[](int index) {
    if (index < 0 || index >= size) {
        throw std::out_of_range("Index out of range");
    }
    return data[index];
}

void DynamicArray::resize(int newSize) {
    int* newData = new int[newSize];
    for (int i = 0; i < std::min(size, newSize); ++i) {
        newData[i] = data[i];
    }
    delete[] data;
    data = newData;
    size = newSize;
}

DynamicArray& DynamicArray::operator=(const DynamicArray& other) {
    if (this != &other) {
        delete[] data;
        size = other.size;
        data = new int[size];
        for (int i = 0; i < size; ++i) {
            data[i] = other.data[i];
        }
    }
    return *this;
}

DynamicArray& DynamicArray::operator=(DynamicArray&& other) noexcept {
    if (this != &other) {
        delete[] data;
        data = other.data;
        size = other.size;
        other.data = nullptr;
        other.size = 0;
    }
    return *this;
}

bool DynamicArray::operator==(const DynamicArray& other) const {
    if (size != other.size) {
        throw std::logic_error("Arrays of different sizes cannot be compared");
    }
    for (int i = 0; i < size; ++i) {
        if (data[i] != other.data[i]) {
            return false;
        }
    }
    return true;
}

bool DynamicArray::operator!=(const DynamicArray& other) const {
    return !(*this == other);
}

bool DynamicArray::operator<(const DynamicArray& other) const {
    for (int i = 0; i < std::min(size, other.size); ++i) {
        if (data[i] < other.data[i]) {
            return true;
        } else if (data[i] > other.data[i]) {
            return false;
        }
    }
    return size < other.size;
}

bool DynamicArray::operator<=(const DynamicArray& other) const {
    return *this < other || *this == other;
}

bool DynamicArray::operator>(const DynamicArray& other) const {
    return !(*this <= other);
}

bool DynamicArray::operator>=(const DynamicArray& other) const {
    return !(*this < other);
}

DynamicArray DynamicArray::operator+(const DynamicArray& other) const {
    DynamicArray result(size + other.size);
    for (int i = 0; i < size; ++i) {
        result.data[i] = data[i];
    }
    for (int i = 0; i < other.size; ++i) {
        result.data[size + i] = other.data[i];
    }
    return result;
}

std::ostream& operator<<(std::ostream& os, const DynamicArray& arr) {
    for (int i = 0; i < arr.getSize(); ++i) {
        os << arr[i] << " ";
    }
    return os;
}

std::istream& operator>>(std::istream& is, DynamicArray& arr) {
    int size;
    is >> size;
    arr.resize(size);
    for (int i = 0; i < size; ++i) {
        is >> arr[i];
    }
    return is;
}

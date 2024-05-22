#include <iostream>

class DynamicIntArray {
private:
    int* data;
    int length;

public:
    // Конструкторы
    DynamicIntArray() : data(nullptr), length(0) {}

    explicit DynamicIntArray(int size) : length(size) {
        data = new int[length] {};
    }

    DynamicIntArray(int size, int value) : length(size) {
        data = new int[length];
        for (int i = 0; i < length; ++i) {
            data[i] = value;
        }
    }

    DynamicIntArray(const DynamicIntArray& other) : length(other.length) {
        data = new int[length];
        for (int i = 0; i < length; ++i) {
            data[i] = other.data[i];
        }
    }

    DynamicIntArray(DynamicIntArray&& other) noexcept : data(other.data), length(other.length) {
        other.data = nullptr;
        other.length = 0;
    }

    // Деструктор
    ~DynamicIntArray() {
        delete[] data;
    }

    // Методы
    int size() const { return length; }

    int& operator[](int index) {
        if (index < 0 || index >= length) {
            throw std::out_of_range("Index out of range");
        }
        return data[index];
    }

    const int& operator[](int index) const {
        if (index < 0 || index >= length) {
            throw std::out_of_range("Index out of range");
        }
        return data[index];
    }

    void resize(int newSize) {
        int* newData = new int[newSize] {};
        int copyLength = (newSize < length) ? newSize : length;
        for (int i = 0; i < copyLength; ++i) {
            newData[i] = data[i];
        }
        delete[] data;
        data = newData;
        length = newSize;
    }

    DynamicIntArray& operator=(const DynamicIntArray& other) {
        if (this != &other) {
            delete[] data;
            length = other.length;
            data = new int[length];
            for (int i = 0; i < length; ++i) {
                data[i] = other.data[i];
            }
        }
        return *this;
    }

    DynamicIntArray& operator=(DynamicIntArray&& other) noexcept {
        if (this != &other) {
            delete[] data;
            data = other.data;
            length = other.length;
            other.data = nullptr;
            other.length = 0;
        }
        return *this;
    }

    bool operator==(const DynamicIntArray& other) const {
        if (length != other.length) {
            throw std::runtime_error("Arrays have different lengths");
        }
        for (int i = 0; i < length; ++i) {
            if (data[i] != other.data[i]) {
                return false;
            }
        }
        return true;
    }

    bool operator!=(const DynamicIntArray& other) const {
        return !(*this == other);
    }

    bool operator<(const DynamicIntArray& other) const {
        int minLength = (length < other.length) ? length : other.length;
        for (int i = 0; i < minLength; ++i) {
            if (data[i] < other.data[i]) {
                return true;
            } else if (data[i] > other.data[i]) {
                return false;
            }
        }
        return length < other.length;
    }

    bool operator<=(const DynamicIntArray& other) const {
        return (*this < other) || (*this == other);
    }

    bool operator>(const DynamicIntArray& other) const {
        return !(*this <= other);
    }

    bool operator>=(const DynamicIntArray& other) const {
        return !(*this < other);
    }

    DynamicIntArray operator+(const DynamicIntArray& other) const {
        DynamicIntArray result(length + other.length);
        for (int i = 0; i < length; ++i) {
            result.data[i] = data[i];
        }
        for (int i = 0; i < other.length; ++i) {
            result.data[length + i] = other.data[i];
        }
        return result;
    }

    friend std::ostream& operator<<(std::ostream& out, const DynamicIntArray& arr) {
        out << "[ ";
        for (int i = 0; i < arr.length; ++i) {
            out << arr.data[i] << " ";
        }
        out << "]";
        return out;
    }

    friend std::istream& operator>>(std::istream& in, DynamicIntArray& arr) {
        for (int i = 0; i < arr.length; ++i) {
            in >> arr.data[i];
        }
        return in;
    }
};

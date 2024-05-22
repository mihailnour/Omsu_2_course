#include "CircularBuffer.h"

CircularBuffer::CircularBuffer(int capacity) : capacity(capacity), size(0), front(0), rear(0) {
    buffer = new int[capacity];
}

CircularBuffer::~CircularBuffer() {
    delete[] buffer;
}

void CircularBuffer::enqueue(int value) {
    if (size == capacity) {
        throw std::overflow_error("Buffer is full");
    }
    buffer[rear] = value;
    rear = (rear + 1) % capacity;
    ++size;
}

int CircularBuffer::dequeue() {
    if (isEmpty()) {
        throw std::underflow_error("Buffer is empty");
    }
    int value = buffer[front];
    front = (front + 1) % capacity;
    --size;
    return value;
}

int CircularBuffer::peek() const {
    if (isEmpty()) {
        throw std::underflow_error("Buffer is empty");
    }
    return buffer[front];
}

int CircularBuffer::getSize() const {
    return size;
}

bool CircularBuffer::isEmpty() const {
    return size == 0;
}

void CircularBuffer::makeEmpty() {
    size = 0;
    front = rear = 0;
}

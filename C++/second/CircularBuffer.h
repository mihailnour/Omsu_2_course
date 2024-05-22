#ifndef CIRCULAR_BUFFER_H
#define CIRCULAR_BUFFER_H

#include <iostream>
#include <stdexcept>

class CircularBuffer {
private:
    int* buffer;
    int capacity;
    int size;
    int front;
    int rear;

public:
    CircularBuffer(int capacity);
    ~CircularBuffer();

    void enqueue(int value);
    int dequeue();
    int peek() const;
    int getSize() const;
    bool isEmpty() const;
    void makeEmpty();
};

#endif CIRCULAR_BUFFER_H

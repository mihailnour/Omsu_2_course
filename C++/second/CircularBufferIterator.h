#ifndef CIRCULAR_BUFFER_ITERATOR_H
#define CIRCULAR_BUFFER_ITERATOR_H

#include "CircularBuffer.h"

class CircularBufferIterator {
private:
    const CircularBuffer& buffer;
    int current;
    bool started;

public:
    CircularBufferIterator(const CircularBuffer& buf);

    void start();
    void next();
    bool finish() const;
    int getValue() const;
};

#endif CIRCULAR_BUFFER_ITERATOR_HPP

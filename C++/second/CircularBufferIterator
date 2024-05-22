#include "CircularBufferIterator.h"

CircularBufferIterator::CircularBufferIterator(const CircularBuffer& buf) : buffer(buf), current(buf.getSize()), started(false) {}

void CircularBufferIterator::start() {
    current = buffer.getSize();
    started = true;
}

void CircularBufferIterator::next() {
    if (!started) {
        throw std::logic_error("Iterator not started");
    }
    current = (current + 1) % buffer.getSize();
}

bool CircularBufferIterator::finish() const {
    return current == buffer.getSize();
}

int CircularBufferIterator::getValue() const {
    if (!started || finish()) {
        throw std::logic_error("Iterator not started or finished");
    }
    return buffer.peek();
}

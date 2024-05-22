#include "Container.h"
#include <stdexcept>

namespace Storage {

Container::Container(int l, int w, int h, double maxW, int cap)
    : length(l), width(w), height(h), maxWeight(maxW), boxCount(0), capacity(cap), currentWeight(0.0) {
    boxes = new Box[capacity];
}

Container::~Container() {
    delete[] boxes;
}

int Container::getBoxCount() const { return boxCount; }
double Container::getCurrentWeight() const { return currentWeight; }

int Container::getTotalValue() const {
    int total = 0;
    for (int i = 0; i < boxCount; ++i) {
        total += boxes[i].getValue();
    }
    return total;
}

Box& Container::getBox(int index) {
    if (index < 0 || index >= boxCount) {
        throw std::out_of_range("Index out of range");
    }
    return boxes[index];
}

void Container::addBox(const Box &box) {
    if (currentWeight + box.getWeight() > maxWeight) {
        throw std::runtime_error("Exceeds maximum weight limit");
    }
    if (boxCount == capacity) {
        throw std::runtime_error("Container is full");
    }
    boxes[boxCount++] = box;
    currentWeight += box.getWeight();
}

void Container::removeBox(int index) {
    if (index < 0 || index >= boxCount) {
        throw std::out_of_range("Index out of range");
    }
    currentWeight -= boxes[index].getWeight();
    for (int i = index; i < boxCount - 1; ++i) {
        boxes[i] = boxes[i + 1];
    }
    --boxCount;
}

std::ostream& operator<<(std::ostream &out, const Container &container) {
    out << "Container(length: " << container.length << ", width: " << container.width
        << ", height: " << container.height << ", maxWeight: " << container.maxWeight
        << ", currentWeight: " << container.currentWeight << ", boxCount: " << container.boxCount << ")\n";
    for (int i = 0; i < container.boxCount; ++i) {
        out << container.boxes[i] << "\n";
    }
    return out;
}

} // namespace Storage

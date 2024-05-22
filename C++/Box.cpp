#include "Box.h"

namespace Storage {

Box::Box(int l, int w, int h, double wt, int val)
    : length(l), width(w), height(h), weight(wt), value(val) {}

int Box::getLength() const { return length; }
int Box::getWidth() const { return width; }
int Box::getHeight() const { return height; }
double Box::getWeight() const { return weight; }
int Box::getValue() const { return value; }

void Box::setLength(int l) { length = l; }
void Box::setWidth(int w) { width = w; }
void Box::setHeight(int h) { height = h; }
void Box::setWeight(double wt) { weight = wt; }
void Box::setValue(int val) { value = val; }

bool Box::operator==(const Box &other) const {
    return length == other.length && width == other.width &&
           height == other.height && weight == other.weight &&
           value == other.value;
}

std::ostream& operator<<(std::ostream &out, const Box &box) {
    out << "Box(length: " << box.length << ", width: " << box.width
        << ", height: " << box.height << ", weight: " << box.weight
        << ", value: " << box.value << ")";
    return out;
}

std::istream& operator>>(std::istream &in, Box &box) {
    in >> box.length >> box.width >> box.height >> box.weight >> box.value;
    return in;
}

int totalValue(Box boxes[], int size) {
    int total = 0;
    for (int i = 0; i < size; ++i) {
        total += boxes[i].getValue();
    }
    return total;
}

bool checkDimensions(Box boxes[], int size, int maxDim) {
    int totalDim = 0;
    for (int i = 0; i < size; ++i) {
        totalDim += boxes[i].getLength() + boxes[i].getWidth() + boxes[i].getHeight();
    }
    return totalDim <= maxDim;
}

double maxWeightUnderVolume(Box boxes[], int size, int maxV) {
    double maxWeight = 0;
    for (int i = 0; i < size; ++i) {
        int volume = boxes[i].getLength() * boxes[i].getWidth() * boxes[i].getHeight();
        if (volume <= maxV && boxes[i].getWeight() > maxWeight) {
            maxWeight = boxes[i].getWeight();
        }
    }
    return maxWeight;
}

bool canNest(Box boxes[], int size) {
    for (int i = 0; i < size - 1; ++i) {
        bool canNestCurrent = false;
        for (int j = 0; j < size; ++j) {
            if (i != j && boxes[i].getLength() < boxes[j].getLength() &&
                boxes[i].getWidth() < boxes[j].getWidth() &&
                boxes[i].getHeight() < boxes[j].getHeight()) {
                canNestCurrent = true;
                break;
            }
        }
        if (!canNestCurrent) {
            return false;
        }
    }
    return true;
}

} // namespace Storage

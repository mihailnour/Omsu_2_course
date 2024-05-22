#ifndef CONTAINER_H
#define CONTAINER_H

#include "Box.h"

namespace Storage {

class Container {
private:
    Box* boxes;
    int boxCount;
    int capacity;
    int length;
    int width;
    int height;
    double maxWeight;
    double currentWeight;

public:
    Container(int l, int w, int h, double maxW, int cap = 10);
    ~Container();

    int getBoxCount() const;
    double getCurrentWeight() const;
    int getTotalValue() const;
    Box& getBox(int index);
    void addBox(const Box &box);
    void removeBox(int index);

    friend std::ostream& operator<<(std::ostream &out, const Container &container);
};

} // namespace Storage

#endif // CONTAINER_H

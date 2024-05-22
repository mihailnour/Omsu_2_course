#ifndef BOX_H
#define BOX_H

#include <iostream>

namespace Storage {

class Box {
private:
    int length;
    int width;
    int height;
    double weight;
    int value;

public:
    Box(int l = 0, int w = 0, int h = 0, double wt = 0.0, int val = 0);

    int getLength() const;
    int getWidth() const;
    int getHeight() const;
    double getWeight() const;
    int getValue() const;

    void setLength(int l);
    void setWidth(int w);
    void setHeight(int h);
    void setWeight(double wt);
    void setValue(int val);

    bool operator==(const Box &other) const;

    friend std::ostream& operator<<(std::ostream &out, const Box &box);
    friend std::istream& operator>>(std::istream &in, Box &box);
};

int totalValue(Box boxes[], int size);
bool checkDimensions(Box boxes[], int size, int maxDim);
double maxWeightUnderVolume(Box boxes[], int size, int maxV);
bool canNest(Box boxes[], int size);

} // namespace Storage

#endif // BOX_H

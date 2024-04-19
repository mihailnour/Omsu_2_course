#include <iostream>

struct Box {
    int length;
    int width;
    int height;
    double weight;
    int value;

    Box(int l, int w, int h, double wei, int val)
    {
        length = l;
        width = w;
        height = h;
        weight = wei;
        value = val;
    }
};

int calculateTotalValue(const Box* boxes, int size) {
    int totalValue = 0;
    for (int i = 0; i < size; i++) {
        totalValue += boxes[i].value;
    }
    return totalValue;
}

bool compareTotalDimensions(const Box* boxes, int size, int maxTotalDim) {
    int TotalDim = 0;
    for (int i = 0; i < size; i++) {
        TotalDim += boxes[i].length + boxes[i].width + boxes[i].height;
    }
    return TotalDim <= maxTotalDim;
}

double getMaxWeight(const Box* boxes, int size, double maxV) {
    double maxWeight = 0.0;
    for (int i = 0; i < size; ++i) {
        double volume = boxes[i].length * boxes[i].width * boxes[i].height;
        if (volume <= maxV && boxes[i].weight > maxWeight) {
            maxWeight = boxes[i].weight;
        }
    }
    return maxWeight;
}

int main() {
    Box box1(10, 5, 8, 2.5, 200);
    Box box2(8, 6, 4, 1.8, 150);
    Box boxesArray[] = { box1, box2 };
    bool isTotalDimAccepted = compareTotalDimensions(boxesArray, 2, 50);
    double maxWeightForMaxVolume = getMaxWeight(boxesArray, 2, 100.0);
    int totalValue = calculateTotalValue(boxesArray, 2);
    std::cout << "Total value of all boxes: " << totalValue << " kopecks" << std::endl;
    if (isTotalDimAccepted) {
        std::cout << "Total dimensions of all boxes are within the limit." << std::endl;
    }
    else {
        std::cout << "Total dimensions of all boxes exceed the limit." << std::endl;
    }
    std::cout << "Maximum weight for boxes with volume <= 100: " << maxWeightForMaxVolume << " kg" << std::endl;
    return 0;
}

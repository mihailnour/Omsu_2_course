#include <iostream>

struct Box {
    int length;
    int width;
    int height;
    double weight;
    int value;

    Box(int l, int w, int h, double wei, int val) {
        length = l;
        width = ;
        height = h;
        weight = wei;
        value = val;
    }
};

std::ostream& operator<<(std::ostream& os, const Box& box) {
    os << "Length: " << box.length << ", Width: " << box.width << ", Height: " << box.height << ", Weight: " << box.weight << ", Value: " << box.value;
    return os;
}

std::istream& operator >> (std::istream& is, Box& box) {
    is >> box.length >> box.width >> box.height >> box.weight >> box.value;
    return is;
}
    bool operator==(const Box& a, const Box& b) {
        return a.length == b.length && a.width == b.width && a.height == b.height && a.weight == b.weight && a.value == b.value;
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

bool canFitInside(const Box* boxes, int size) {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            if (i != j) {
                if (boxes[i].length >= boxes[j].length && boxes[i].width >= boxes[j].width && boxes[i].height >= boxes[j].height) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
    }
    return true;
}

int main() {
    Box box1(10, 5, 8, 2.5, 200);
    Box box2(8, 6, 4, 1.8, 150);
    Box boxesArray[] = { box1, box2 };
    bool isTotalDimAccepted = compareTotalDimensions(boxesArray, 2, 50);
    double maxWeightForMaxVolume = getMaxWeight(boxesArray, 2, 100.0);
    int totalValue = calculateTotalValue(boxesArray, 2);
    bool allFitInside = canFitInside(boxesArray, 2);
    std::cout << "Total value of all boxes: " << totalValue << " kopecks" << std::endl;
    if (isTotalDimAccepted) {
        std::cout << "Total dimensions of all boxes are within the limit." << std::endl;
    }
    else {
        std::cout << "Total dimensions of all boxes exceed the limit." << std::endl;
    }
    std::cout << "Maximum weight for boxes with volume <= 100: " << maxWeightForMaxVolume << " kg" << std::endl;
    if (allFitInside) {
        std::cout << "All boxes can fit inside each other." << std::endl;
    }
    else {
        std::cout << "Not all boxes can fit inside each other." << std::endl;
    }
    return 0;
}

#include <iostream>
#include "Box.h"
#include "Container.h"

using namespace Storage;

int main() {
    Box b1(10, 20, 30, 2.5, 1000);
    Box b2(15, 25, 35, 3.0, 2000);
    Box b3(5, 10, 15, 1.0, 500);

    Box boxes[] = {b1, b2, b3};
    int size = 3;

    std::cout << "Total value of boxes: " << totalValue(boxes, size) << " копеек\n";
    std::cout << "Check dimensions under 200: " << (checkDimensions(boxes, size, 200) ? "Yes" : "No") << "\n";
    std::cout << "Max weight under volume 10000: " << maxWeightUnderVolume(boxes, size, 10000) << " кг\n";
    std::cout << "Can nest: " << (canNest(boxes, size) ? "Yes" : "No") << "\n";

    Container container(100, 100, 100, 50.0);

    container.addBox(b1);
    container.addBox(b2);
    container.addBox(b3);

    std::cout << container;

    return 0;
}

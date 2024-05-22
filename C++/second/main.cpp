#include "CircularBuffer.h"
#include "CircularBufferIterator.h"
#include <iostream>

int main() {
    try {
        CircularBuffer buffer(5);

        // Добавляем элементы в буфер
        buffer.enqueue(10);
        buffer.enqueue(20);
        buffer.enqueue(30);

        // Итерируемся по буферу с помощью итератора
        CircularBufferIterator iter(buffer);
        iter.start();
        while (!iter.finish()) {
            std::cout << iter.getValue() << " ";
            iter.next();
        }
        std::cout << std::endl;

        // Удаляем элементы из буфера
        buffer.dequeue();
        buffer.dequeue();
        buffer.enqueue(40);
        buffer.enqueue(50);

        // Итерируемся по буферу снова
        iter.start();
        while (!iter.finish()) {
            std::cout << iter.getValue() << " ";
            iter.next();
        }
        std::cout << std::endl;
    } catch (const std::exception& e) {
        std::cerr << "Exception: " << e.what() << std::endl;
    }

    return 0;
}

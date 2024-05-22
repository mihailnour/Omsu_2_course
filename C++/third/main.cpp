#include <iostream>
#include "CircularList.h"

int main() {
    // Создаем кольцевой список целых чисел
    CircularList<int> list;

    // Вставляем элементы в список
    for (int i = 1; i <= 5; ++i) {
        list.insert(list.begin(), i);
    }

    // Выводим элементы списка
    std::cout << "Elements in the list: ";
    auto it = list.begin();
    while (!it.finish()) {
        std::cout << it.getValue() << " ";
        it.next();
    }
    std::cout << std::endl;

    // Находим первое вхождение элемента 3
    auto found = list.find(3);
    if (!found.finish()) {
        std::cout << "Element 3 found in the list." << std::endl;
    } else {
        std::cout << "Element 3 not found in the list." << std::endl;
    }

    // Удаляем элементы из списка
    while (!list.isEmpty()) {
        list.erase(list.begin());
    }

    // Проверяем, пуст ли список
    if (list.isEmpty()) {
        std::cout << "List is empty." << std::endl;
    } else {
        std::cout << "List is not empty." << std::endl;
    }

    return 0;
}

#ifndef CIRCULAR_LIST_H
#define CIRCULAR_LIST_H

#include "List.h"
#include "Iterator.h"

template <typename T>
class CircularList : public List<T> {
private:
    struct Node {
        T data;
        Node* next;
    };

    Node* head;
    int count;

public:
    CircularList();
    CircularList(const CircularList<T>& other);
    CircularList(CircularList<T>&& other) noexcept;
    ~CircularList();

    void insert(Iterator<T>& pos, const T& value) override;
    void erase(Iterator<T>& pos) override;
    Iterator<T> find(const T& value) const override;
    void clear() override;
    bool isEmpty() const override;
    int size() const override;
    Iterator<T> begin() const override;
};

template <typename T>
class CircularListIterator : public Iterator<T> {
private:
    typename CircularList<T>::Node* current;
    const CircularList<T>& list;
    bool started;

public:
    CircularListIterator(const CircularList<T>& list);
    void start() override;
    T& getValue() override;
    void next() override;
    bool finish() const override;
};

#include "CircularList.tpp"

#endif // CIRCULAR_LIST_HPP

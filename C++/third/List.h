#ifndef LIST_H
#define LIST_H

template <typename T>
class Iterator;

template <typename T>
class List {
public:
    virtual void insert(Iterator<T>& pos, const T& value) = 0;
    virtual void erase(Iterator<T>& pos) = 0;
    virtual Iterator<T> find(const T& value) const = 0;
    virtual void clear() = 0;
    virtual bool isEmpty() const = 0;
    virtual int size() const = 0;
    virtual Iterator<T> begin() const = 0;

    virtual ~List() {}
};

#endif // LIST_H

#ifndef ITERATOR_H
#define ITERATOR_H

template <typename T>
class Iterator {
public:
    virtual void start() = 0;
    virtual T& getValue() = 0;
    virtual void next() = 0;
    virtual bool finish() const = 0;

    virtual ~Iterator() {}
};

#endif // ITERATOR_HPP

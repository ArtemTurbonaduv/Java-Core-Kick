package com.artem.task1.observer;

public interface ArrayObservable {
    void attach(ArrayObserver observer);
    void detach(ArrayObserver observer);
    void notifyObservers();
}

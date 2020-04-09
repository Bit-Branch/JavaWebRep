package by.epam.shape.observer;

public interface ObservableShape {
    void addObserver(Observer obs);
    void deleteObserver(Observer obs);
    void notifyObservers();
}

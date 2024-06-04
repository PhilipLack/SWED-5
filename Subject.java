package model;

interface Subject {
    void attachObserver(Observer observer, String subscriptionPreferences);
    void detachObserver(Observer observer);
    void notifyObservers();
}

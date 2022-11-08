package observer;

import java.util.*;

/**
 * Problem: Build a news publishing application
 * with publisher notifying all subscribers when each news is published
 * 
 * Solution: Build a Observable news publisher class which holds list of
 * subscribers
 * and notify them when each news is published
 * 
 * Observable class - maintains subscribers(observers) list
 * - invokes observer notification methods
 * Observer interface - defines notification methods that concrete class has to
 * implement Observer concrete class - perform action w.r.t notification by the
 * observable class.
 * Client - constructs Observable object and attachs subscribers
 * and manipulates observable object
 */

// News Observable class
class NewsPublisher {
    private List<NewsObserver> observers = new ArrayList<NewsObserver>();

    public void addObserver(NewsObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (NewsObserver observer : observers) {
            observer.updateMessage(message);
        }
    }

    public void publishNews(String message) {
        notifyObservers(message);
    }
}

// News Observer interface
interface NewsObserver {
    public void updateMessage(String message);
}

// News Observer concrete class
class Person implements NewsObserver {
    String name;

    Person(String name) {
        this.name = name;
    }

    public void updateMessage(String message) {
        System.out.println(this.name + " person message: " + message);
    }
}

// start of client code
public class ObserverExample {
    public static void main(String[] args) {
        Person ram = new Person("Ram");
        Person priya = new Person("Priya");
        Person anand = new Person("Anand");

        NewsPublisher newsPublisher = new NewsPublisher();
        newsPublisher.addObserver(anand);
        newsPublisher.addObserver(ram);
        newsPublisher.addObserver(priya);

        newsPublisher.publishNews("Flood alert");
        System.out.println("------");
        newsPublisher.publishNews("ABC Company share price increase");
        System.out.println("------");
    }
}
// end of client code

// OUTPUT
// Anand person message: Flood alert
// Ram person message: Flood alert
// Priya person message: Flood alert
// ------
// Anand person message: ABC Company share price increase
// Ram person message: ABC Company share price increase
// Priya person message: ABC Company share price increase
// ------
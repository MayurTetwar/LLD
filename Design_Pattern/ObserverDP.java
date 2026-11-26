package Design_Pattern;

import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
    void update();
}

// Observable interface: a YouTube channel interface
interface IChannel {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}

// Concrete Subject: a YouTube channel that observers can subscribe to
class Channel implements IChannel {
    private List<ISubscriber> subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (ISubscriber sub : subscribers) {
            sub.update();
        }
    }

    public void uploadVideo(String title) {
        latestVideo = title;
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifySubscribers();
    }

    public String getVideoData() {
        return "\nCheckout our new Video : " + latestVideo + "\n";
    }
}

// Concrete Observer: represents a subscriber to the channel
class Subscriber implements ISubscriber {
    private String name;
    private Channel channel;

    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + "," + channel.getVideoData());
    }
}

public class ObserverDP {
    public static void main(String[] args) {
        // Create a channel and subscribers
        Channel channel = new Channel("CoderArmy");

        Subscriber subs1 = new Subscriber("Varun", channel);
        Subscriber subs2 = new Subscriber("Tarun", channel);

        // Varun and Tarun subscribe to CoderArmy
        channel.subscribe(subs1);
        channel.subscribe(subs2);

        // Upload a video: both Varun and Tarun are notified
        channel.uploadVideo("Observer Pattern Tutorial");

        // Varun unsubscribes; Tarun remains subscribed
        channel.unsubscribe(subs1);

        // Upload another video: only Tarun is notified
        channel.uploadVideo("Decorator Pattern Tutorial");
    }
}

/*
Other type of uml and code (ig this is good):- 
+----------------------+  has many   +-------------------------+
|  Subject             | ──────────▶ | <<interface>> Observer  |
| + subscribe(o)       |             | + update(...)           |
| + unsubscribe(o)     |             +-------------------------+
| + notifyObservers()  |                   ▲          ▲
+----------------------+                   ┆          ┆
                                      ObserverA   ObserverB

                                      
import java.util.*;

interface OrderObserver {
    void onStatusChanged(String orderId, String newStatus);
}

class Order {                                        // the subject
    private final String id;
    private String status = "PLACED";
    private final List<OrderObserver> observers = new ArrayList<>();

    Order(String id) { this.id = id; }

    void subscribe(OrderObserver o)   { observers.add(o); }
    void unsubscribe(OrderObserver o) { observers.remove(o); }

    void setStatus(String newStatus) {
        this.status = newStatus;
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver o : observers) {
            o.onStatusChanged(id, status);
        }
    }
}

class EmailNotifier implements OrderObserver {
    public void onStatusChanged(String id, String status) {
        System.out.println("Email: order " + id + " is " + status);
    }
}

class SmsNotifier implements OrderObserver {
    public void onStatusChanged(String id, String status) {
        System.out.println("SMS: order " + id + " is " + status);
    }
}

class AnalyticsTracker implements OrderObserver {
    public void onStatusChanged(String id, String status) {
        System.out.println("Analytics: " + id + " -> " + status);
    }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order("ORD-1");
        OrderObserver sms = new SmsNotifier();

        order.subscribe(new EmailNotifier());
        order.subscribe(sms);
        order.subscribe(new AnalyticsTracker());

        order.setStatus("SHIPPED");     // all three react

        order.unsubscribe(sms);         // customer turns SMS off
        order.setStatus("DELIVERED");   // only two react
    }

*/


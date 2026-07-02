import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(double stockPrice);
}

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

// Concrete Observer 1
class MobileApp implements Observer {

    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(double stockPrice) {
        System.out.println(user +
                " (Mobile App): Stock Price Updated to Rs." +
                stockPrice);
    }
}

// Concrete Observer 2
class WebApp implements Observer {

    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(double stockPrice) {
        System.out.println(user +
                " (Web App): Stock Price Updated to Rs." +
                stockPrice);
    }
}

public class ObserverPatternExample {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Abirami");
        Observer webUser = new WebApp("Priya");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        stockMarket.setStockPrice(1500.50);
        stockMarket.setStockPrice(1750.75);
    }
}
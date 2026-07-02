interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card");
    }
}

// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal");
    }
}

// Context Class
class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternExample {

    public static void main(String[] args) {

        PaymentContext payment = new PaymentContext();

        payment.setPaymentStrategy(new CreditCardPayment());
        payment.executePayment(5000);

        payment.setPaymentStrategy(new PayPalPayment());
        payment.executePayment(2500);
    }
}
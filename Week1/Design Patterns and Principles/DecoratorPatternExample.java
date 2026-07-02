interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}

// Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete Decorator 1
class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("SMS Notification: " + message);
    }
}

// Concrete Decorator 2
class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Slack Notification: " + message);
    }
}

public class DecoratorPatternExample {

    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Server is running successfully.");
    }
}
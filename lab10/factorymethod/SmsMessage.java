package factorymethod;

import common.ConsoleLogger;

public class SmsMessage implements NotificationMessage {

    private final String text;

    public SmsMessage(String flightNumber, String details) {
        this.text = flightNumber + ": " + details;
    }

    @Override
    public String getChannelName() {
        return "SMS";
    }

    @Override
    public String render() {
        return "SMS | " + text;
    }

    @Override
    public void send() {
        ConsoleLogger.log("SMS-шлюз", render());
    }
}

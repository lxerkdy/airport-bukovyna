package factorymethod;

import common.ConsoleLogger;

public class BoardMessage implements NotificationMessage {

    private final String line;

    public BoardMessage(String flightNumber, String details) {
        this.line = flightNumber + " >>> " + details.toUpperCase();
    }

    @Override
    public String getChannelName() {
        return "Табло";
    }

    @Override
    public String render() {
        return "Табло | [ " + line + " ]";
    }

    @Override
    public void send() {
        ConsoleLogger.log("Табло аеропорту", render());
    }
}

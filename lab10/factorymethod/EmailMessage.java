package factorymethod;

import common.ConsoleLogger;

public class EmailMessage implements NotificationMessage {

    private final String subject;
    private final String body;

    public EmailMessage(String flightNumber, String details) {
        this.subject = "Зміна за рейсом " + flightNumber;
        this.body = "Шановний пасажире! За рейсом " + flightNumber
                + " сталася зміна: " + details
                + ". Просимо вибачення за незручності.";
    }

    @Override
    public String getChannelName() {
        return "E-mail";
    }

    @Override
    public String render() {
        return "E-mail | Тема: " + subject + " | Текст: " + body;
    }

    @Override
    public void send() {
        ConsoleLogger.log("Поштовий сервер", render());
    }
}

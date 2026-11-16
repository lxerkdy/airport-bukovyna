package factorymethod;

import common.ConsoleLogger;

public class MobileAppMessage implements NotificationMessage {

    private final String title;
    private final String text;

    public MobileAppMessage(String flightNumber, String details) {
        this.title = "Рейс " + flightNumber;
        this.text = details;
    }

    @Override
    public String getChannelName() {
        return "Мобільний застосунок";
    }

    @Override
    public String render() {
        return "Push | Заголовок: " + title + " | Текст: " + text
                + " | Дія: [Відкрити рейс]";
    }

    @Override
    public void send() {
        ConsoleLogger.log("Push-сервіс", render());
    }
}

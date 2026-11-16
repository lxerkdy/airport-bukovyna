package factorymethod;

// Product: повідомлення, яке пасажир отримує через конкретний канал
public interface NotificationMessage {

    String getChannelName();

    // Вигляд повідомлення в конкретному каналі
    String render();

    void send();
}

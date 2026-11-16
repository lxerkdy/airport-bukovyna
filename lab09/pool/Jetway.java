package pool;

public class Jetway {

    private final String id;
    private String flightNumber;
    private int issueCount;

    // Створюється лише пулом (пакетний доступ)
    Jetway(String id) {
        this.id = id;
        this.flightNumber = null;
        this.issueCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public boolean isAttached() {
        return flightNumber != null;
    }

    public int getIssueCount() {
        return issueCount;
    }

    void attach(String flightNumber) {
        this.flightNumber = flightNumber;
        this.issueCount++;
    }

    // Скидання стану: від'єднання від борту, рейс не зберігається
    void reset() {
        this.flightNumber = null;
    }
}

package pool;

import common.ConsoleLogger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Object Pool телетрапів.
 *
 * Усі телетрапи створюються й готуються один раз у конструкторі.
 * Далі вони лише видаються рейсам і повертаються в пул.
 *
 * Якщо вільних телетрапів немає, рейс стає в чергу (FIFO).
 * Коли черга заповнена, рейс отримує автобус до перону.
 */
public class JetwayPool {

    private static final String SOURCE = "JetwayPool";

    private final List<Jetway> allJetways = new ArrayList<>();
    private final Deque<Jetway> freeJetways = new ArrayDeque<>();
    private final Map<String, Jetway> busyJetways = new HashMap<>();
    private final Deque<String> waitingQueue = new ArrayDeque<>();

    private final int maxQueueSize;
    private int createdCount;

    public JetwayPool(int size, int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;

        for (int i = 1; i <= size; i++) {
            Jetway jetway = createJetway("T-" + i);
            allJetways.add(jetway);
            freeJetways.add(jetway);
        }
    }

    // Єдине місце створення телетрапів
    private Jetway createJetway(String id) {
        ConsoleLogger.log(
                SOURCE,
                "Підготовка телетрапа " + id
                        + " (підведення, калібрування, перевірка)"
        );

        createdCount++;

        return new Jetway(id);
    }

    public synchronized AllocationResult request(String flightNumber) {
        Jetway jetway = freeJetways.poll();

        if (jetway != null) {
            issue(jetway, flightNumber);

            return AllocationResult.JETWAY;
        }

        if (waitingQueue.size() < maxQueueSize) {
            waitingQueue.add(flightNumber);

            ConsoleLogger.log(
                    SOURCE,
                    "Вільних телетрапів немає: рейс " + flightNumber
                            + " очікує в черзі (позиція "
                            + waitingQueue.size() + ")"
            );

            return AllocationResult.QUEUED;
        }

        ConsoleLogger.log(
                SOURCE,
                "Вільних телетрапів немає, черга заповнена: рейс "
                        + flightNumber + " отримує автобус до перону"
        );

        return AllocationResult.BUS;
    }

    public synchronized void release(String flightNumber) {
        Jetway jetway = busyJetways.remove(flightNumber);

        if (jetway == null) {
            ConsoleLogger.log(
                    SOURCE,
                    "Рейс " + flightNumber + " не використовує телетрап"
            );

            return;
        }

        jetway.reset();

        ConsoleLogger.log(
                SOURCE,
                jetway.getId() + " повернено, стан скинуто"
        );

        String nextFlight = waitingQueue.poll();

        if (nextFlight != null) {
            // Без повторної підготовки
            issue(jetway, nextFlight);
        } else {
            freeJetways.add(jetway);
        }
    }

    private void issue(Jetway jetway, String flightNumber) {
        jetway.attach(flightNumber);
        busyJetways.put(flightNumber, jetway);

        ConsoleLogger.log(
                SOURCE,
                "Телетрап " + jetway.getId() + " → " + flightNumber
        );
    }

    public synchronized void printStatistics() {
        ConsoleLogger.log(SOURCE, "Статистика видач:");

        for (Jetway jetway : allJetways) {
            ConsoleLogger.log(
                    SOURCE,
                    jetway.getId() + ": видач = " + jetway.getIssueCount()
            );
        }

        ConsoleLogger.log(
                SOURCE,
                "Загалом створено телетрапів: " + createdCount
        );
    }
}

package command;

import common.ConsoleLogger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Invoker: приймає команди, веде історію (undo), чергу (пакет) і журнал дій. */
public class DispatcherConsole {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final String dispatcherName;
    private final Deque<ScheduleCommand> history = new ArrayDeque<>();
    private final Queue<ScheduleCommand> pending = new LinkedList<>();
    private final List<String> journal = new ArrayList<>();

    public DispatcherConsole(String dispatcherName) {
        this.dispatcherName = dispatcherName;
    }

    public void execute(ScheduleCommand command) {
        ConsoleLogger.log("DispatcherConsole", "Диспетчер " + dispatcherName
                + " подав команду: " + command.describe());
        command.execute();
        history.push(command);
        record("ВИКОНАНО", command);
    }

    public void undoLast() {
        if (history.isEmpty()) {
            ConsoleLogger.log("DispatcherConsole", "Немає дій для скасування.");
            return;
        }
        ScheduleCommand command = history.pop();
        command.undo();
        record("СКАСОВАНО", command);
    }

    public void enqueue(ScheduleCommand command) {
        pending.add(command);
        ConsoleLogger.log("DispatcherConsole", "Поставлено в чергу (" + pending.size()
                + "): " + command.describe());
    }

    public void executeBatch() {
        ConsoleLogger.log("DispatcherConsole", "Виконання пакету з " + pending.size() + " змін");
        while (!pending.isEmpty()) {
            execute(pending.poll());
        }
    }

    public void printJournal() {
        ConsoleLogger.log("DispatcherConsole", "Журнал дій диспетчера " + dispatcherName + ":");
        int i = 1;
        for (String entry : journal) {
            ConsoleLogger.log("Journal", i++ + ". " + entry);
        }
    }

    private void record(String status, ScheduleCommand command) {
        String entry = LocalTime.now().format(FMT) + " | " + dispatcherName
                + " | " + status + " | " + command.describe();
        journal.add(entry);
        ConsoleLogger.log(command.getClass().getSimpleName(), status + ": " + command.describe());
    }
}

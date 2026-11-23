package command;

/** Command: об'єкт, що знає, як виконатися і як скасуватися. */
public interface ScheduleCommand {
    void execute();
    void undo();
    String describe();
}

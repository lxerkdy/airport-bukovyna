package bridge;

import java.util.List;

/**
 * Implementor: визначає, ЯК інформація показується (обладнання).
 */
public interface DisplayDevice {

    String getName();

    void render(String title, List<String> lines);
}

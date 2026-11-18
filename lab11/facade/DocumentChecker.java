package facade;

import common.ConsoleLogger;

public class DocumentChecker {

    public boolean checkDocuments(String passengerName,
                                  String documentNumber) {
        ConsoleLogger.log("DocumentChecker",
                "Перевірка документів пасажира " + passengerName);

        boolean valid = passengerName != null && !passengerName.isBlank()
                && documentNumber != null && !documentNumber.isBlank();

        ConsoleLogger.log("DocumentChecker", valid
                ? "Документи перевірено успішно"
                : "Помилка перевірки документів");
        return valid;
    }
}

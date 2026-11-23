package bridge;

public record Flight(
        String code,
        String city,
        String time,
        String gate,
        String status
) {
}

package flyweight;

import java.util.List;

public class SeatType {

    private final String name;
    private final String description;
    private final double seatWidth;
    private final double seatPitch;
    private final double reclineAngle;
    private final List<String> amenities;
    private final String image;

    public SeatType(
            String name,
            String description,
            double seatWidth,
            double seatPitch,
            double reclineAngle,
            List<String> amenities,
            String image
    ) {
        this.name = name;
        this.description = description;
        this.seatWidth = seatWidth;
        this.seatPitch = seatPitch;
        this.reclineAngle = reclineAngle;
        this.amenities = List.copyOf(amenities);
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getSeatWidth() {
        return seatWidth;
    }

    public double getSeatPitch() {
        return seatPitch;
    }

    public double getReclineAngle() {
        return reclineAngle;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public String getImage() {
        return image;
    }

    public void printDetails() {
        System.out.println("Клас: " + name);
        System.out.println("Опис: " + description);
        System.out.println("Ширина крісла: " + seatWidth + " см");
        System.out.println("Крок між рядами: " + seatPitch + " см");
        System.out.println("Нахил спинки: " + reclineAngle + "°");
        System.out.println("Зручності: " + amenities);
        System.out.println("Зображення: " + image);
    }
}
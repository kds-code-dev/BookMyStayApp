/**
 * ABSTRACT CLASS Room
 * Represents a generic room type.
 */

public abstract class Room {

    protected int beds;
    protected int size;
    protected double price;
    int roomNumber;
    boolean isAvailable;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }
    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Beds:");
        System.out.println(beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}
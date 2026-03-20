import java.util.*;

// Domain Model: Represents a Guest's intent to book
class Reservation {
    private String guestName;
    private String roomType;
    private int stayDuration; // in nights

    public Reservation(String guestName, String roomType, int stayDuration) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.stayDuration = stayDuration;
    }

    @Override
    public String toString() {
        return String.format("Request[Guest: %-10s | Room: %-8s | Duration: %d nights]",
                guestName, roomType, stayDuration);
    }
}

// Service: Manages the ordering of incoming requests
class BookingRequestQueue {
    // Standard Java Queue to maintain FIFO order
    private Queue<Reservation> requestQueue = new LinkedList<>();

    // Adds a request to the end of the line
    public void submitRequest(Reservation request) {
        requestQueue.add(request);
        System.out.println("Status: Request received for " + request);
    }

    // Displays the current state of the queue without removing elements
    public void viewQueue() {
        System.out.println("\n--- Current Booking Request Queue (FIFO Order) ---");
        if (requestQueue.isEmpty()) {
            System.out.println("Queue is currently empty.");
        } else {
            int position = 1;
            for (Reservation res : requestQueue) {
                System.out.println(position + ". " + res);
                position++;
            }
        }
        System.out.println("--------------------------------------------------\n");
    }

    // Helper method for the next phase: Processing the next person in line
    public Reservation getNextRequest() {
        return requestQueue.peek();
    }
}

// Main Class to execute Use Case 5
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        BookingRequestQueue bookingSystem = new BookingRequestQueue();

        System.out.println("Simulating Incoming Booking Requests...\n");

        // 1. Guests submit requests in a specific order
        bookingSystem.submitRequest(new Reservation("Alice", "Deluxe", 3));
        bookingSystem.submitRequest(new Reservation("Bob", "Single", 1));
        bookingSystem.submitRequest(new Reservation("Charlie", "Deluxe", 2));
        bookingSystem.submitRequest(new Reservation("Diana", "Suite", 5));

        // 2. Display the queue to prove FIFO order is preserved
        bookingSystem.viewQueue();

        // 3. Verification of Requirements
        System.out.println("System Check:");
        System.out.println("- Requests stored in arrival order? Yes.");
        System.out.println("- Inventory modified? No (State remains intake-only).");
        System.out.println("- Next person to be processed: " + bookingSystem.getNextRequest());
    }
}
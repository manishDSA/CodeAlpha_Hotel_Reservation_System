
import java.util.ArrayList;

import java.util.*;


// IN this enum Store the constant value

enum RoomType {
    SINGLE_BED, DOUBLE_BED, SUITE,Deluxe_room,Executive_Suit,Studio_room_or_apartment,QUEEN_SIZE_ROOM
}

class Room {
    private int roomnumber;
    private RoomType roomType;
    private boolean isBooked;
    private double Price;

    public Room(int roomNumber, RoomType roomType, double price) {
        this.roomnumber = roomNumber;
        this.roomType = roomType;
        this.Price = price;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomnumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return Price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        isBooked = true;
    }

    public void cancel() {
        isBooked = false;
    }
}

class BookingSystem {
    private ArrayList<Room> rooms;

    public BookingSystem() {
        rooms = new ArrayList<>();
        
        rooms.add(new Room(101, RoomType.SINGLE_BED, 150.0));
        rooms.add(new Room(102, RoomType.DOUBLE_BED, 250.0));
        rooms.add(new Room(110, RoomType.Executive_Suit, 500.0));
        rooms.add(new Room(450, RoomType.SINGLE_BED, 150.0));
        rooms.add(new Room(150, RoomType.Deluxe_room, 700.0));
        rooms.add(new Room(126, RoomType.Studio_room_or_apartment, 1500.0));
        rooms.add(new Room(111, RoomType.Deluxe_room, 700.0));
        rooms.add(new Room(114, RoomType.QUEEN_SIZE_ROOM, 1000.0));
    }

    public void displayAvailableRooms() {
    	System.out.println();
        System.out.println("List Of Available Rooms:");
        System.out.println();
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.printf("Room %d: %s - $%.2f%n", room.getRoomNumber(), room.getRoomType(), room.getPrice());
            }
        }
    }

    public void bookRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isBooked()) {
                    System.out.println("Room " + roomNumber + " is already booked.");
                } else {
                    room.book();
                    System.out.println("Room " + roomNumber + " has been booked successfully.");
                    processPayment(room.getPrice());
                }
                return;
            }
        }
        System.out.println("Room " + roomNumber + " does not exist.");
    }

    public void cancelBooking(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (!room.isBooked()) {
                    System.out.println("Room " + roomNumber + " is not booked.");
                } else {
                    room.cancel();
                    System.out.println("Booking for room " + roomNumber + " has been canceled.");
                }
                return;
            }
        }
        System.out.println("Room " + roomNumber + " does not exist.");
    }
public void checkpin() {
	Scanner scanner= new Scanner(System.in);
	 System.out.println("Choose the Payment Mode...");
     int modetype=scanner.nextInt();
     switch (modetype) {
		case 1:
			   System.out.println("Payment Mode is Cash!");
			   
			break;
		case 2:
			
			System.out.println("Payment Mode is Online...");
			
			break;
			
			
       
		default:
			break;
		}
     
	int PIN=9887;
		System.out.println("Enter your PIN: ");
		
		Scanner sc= new Scanner(System.in);
		
		int enteredpin= sc.nextInt();
		
		if (enteredpin==PIN) {
			
		}else {
			System.out.println("Enter a Valid PIN: "+" ");
			checkpin();
		}
		
		
	}

    private void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Total amount due: $%.2f%n", amount);
        checkpin();
//        System.out.println("Choose the Payment Mode...");
//        int modetype=scanner.nextInt();
//        switch (modetype) {
//		case 1:
//			   System.out.println("Payment Mode is Cash!");
//			break;
//		case 2:
//			
//			System.out.println("Payment Mode is Online...");
//			checkpin();
//			break;
//			
//			
//          
//		default:
//			break;
//		}
        System.out.print("Enter payment amount: $");
        double payment = scanner.nextDouble();
        if (payment == amount) {
            System.out.println("Payment accepted. Your Booking is Compelete...Thank you!");
        } 
        else if(payment==0) {
            System.out.println("Insufficient payment. Booking cannot be processed.");
            
        }
        else if(payment>amount) {
        	System.out.println("You have morePaid! Please Check Your payment");
        	processPayment(amount);
        }
        else if(payment<amount) {
        	System.out.println("You have lessPaid! Your Booking is not Accepted Try Again!");
        	processPayment(amount);
        }
        
        
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingSystem bookingRooms = new BookingSystem();

        while (true) {
        	System.out.println();
        	System.out.println("/********Hotel Booking System**********/");
            System.out.println("\n1. /******Display Available Rooms******/");
            System.out.println("2. /*****Book a Room*****/");
            System.out.println("3. /****Cancel a Booking****/");
            System.out.println("4. /***Exit***/");
            System.out.println();
            System.out.println("User Choice....");
            System.out.println();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	bookingRooms.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookRoomNumber = scanner.nextInt();
                    bookingRooms.bookRoom(bookRoomNumber);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelRoomNumber = scanner.nextInt();
                    bookingRooms.cancelBooking(cancelRoomNumber);
                    break;
                case 4:
                	//this option is after booking room
                    System.out.println("Room Booking Is Successfully....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}

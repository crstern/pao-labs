package mypack;

public class Room{
    String number;
    String type;
    int floor;

    public Room(String number, String type, int floor){
        this.number = number;
        this.type = type;
        this.floor = floor;
    }

    public void printRoom(){
        System.out.printf("number: %s, type: %s, floor: %d ", number, type, floor);
    }


    // public static void main(String[] args){
        // Room A = new Room("12A", "normal", 3);
        // Room B = new Room("12B", "tech", 7);

        // A.printRoom();
        // B.printRoom();
    // }

}
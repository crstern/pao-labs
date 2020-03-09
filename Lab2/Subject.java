// import java.lang.reflect.Constructor;

// import javax.security.auth.Subject;

import mypack.Room;
import mypack.Person;


class Subject{
    private Room room;
    private int noOfStudents;
    private Person teacher;

    /**
     * @param room the room to set
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @param noOfStudents the noOfStudents to set
     */
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the noOfStudents
     */
    public int getNoOfStudents() {
        return noOfStudents;
    }
    /**
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @return the teacher
     */
    public Person getTeacher() {
        return teacher;
    }

    public Subject(){
        this.room = new Room("0", "normal", 0);
        this.noOfStudents = 0;
        this.teacher = new Person("John", "Doe", "24", 1123444, "");
    }

    public void preetyPrint(){
        System.out.printf("Room: ");
        room.printRoom();
        System.out.printf(", number of students: %d, ", noOfStudents);
        System.out.printf("Teacher: ");
        teacher.printPerson();
        System.out.println();
    }

    public static void main(String []args){
        Room roomA = new Room("12A", "normal", 3);
        Room roomB = new Room("12B", "tech", 7);

        Person personA = new Person("John", "Doe", "24", 1123444, "student");
        Person personB = new Person("Jane", "Roe", "56", 2233444, "teacher");

        Subject subjectA = new Subject();
        Subject subjectB = new Subject();

        subjectA.setRoom(roomA);
        subjectB.setRoom(roomB);

        subjectA.setNoOfStudents(16);
        subjectB.setNoOfStudents(18);

        subjectA.setTeacher(personA);
        subjectB.setTeacher(personB);


        subjectA.preetyPrint();
        subjectB.preetyPrint();
    }
}
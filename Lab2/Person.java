package mypack;

public class Person{
    private String name;
    private String surname;
    private String age;
    private long identity;
    private String type;

    Person(){
        name = "";
        surname = "";
        age = "";
        identity = 0;
        type = "";
    }

    public Person(String name, String surname, String age, long identity, String type){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.identity = identity;
        this.type = type;
    }

    public void printPerson(){
        System.out.printf("name: %s, surname: %s, age: %s, identity: %s, type: %s ", name, surname, age, identity, type);
    }

    // public static void main(String []args){
    //     Person A = new Person("John", "Doe", "24", 1123444, "student");
    //     Person B = new Person("Jane", "Roe", "56", 2233444, "teacher");
        
    //     A.printPerson();
    //     B.printPerson();
    // }
    
}
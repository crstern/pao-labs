import java.util.Scanner;


class Problema2{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter first number: ");
        int x = scanner.nextInt();
        System.out.printf("Enter the secon number: ");
        int y = scanner.nextInt();

        if (x != y){
            System.out.printf("%d != %d\n", x, y);
            if (x < y){
                System.out.printf("%d < %d\n%d <= %d\n", x, y, x, y);
            }
            else{
                System.out.printf("%d > %d\n%d >= %d\n", x, y, x, y);
            }
        }
        else {
            System.out.printf("%d == %d\n%d <= %d\n%d >= %d\n", x, y, x, y, x, y);
        }
        scanner.close();
 
    }
}
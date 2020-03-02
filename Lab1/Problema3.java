import java.util.Scanner;


class Problema3{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter a value for n: ");
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 0;i < n;i ++){
            if (i % 3 == 0 | i % 5 == 0){
                sum += i;
            }
        }
        System.out.printf("The sum of multiples of 3 and 5 up to n is: %d", sum);
        scan.close();
    }
}
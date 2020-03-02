import java.util.Scanner;
import java.lang.Math;

class Problema4_5_6_7{

    public static boolean isPrime(int x){
        if (x == 2 || x == 3){
            return true;
        }
        if (x % 2 == 0 || x == 1){
            return false;
        }
        for (int d = 3;d < Math.sqrt(x) ; d += 2){
            if(x % d == 0){
                return false;
            }
        }
        return true;
    }

    public static int FibbonaciNumber(int n){
        int x1 = 1, x2 = 1, x3 = 2;
        if(n == 1 || n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        for (int i = 4; i <= n;i++){
            x1 = x2;
            x2 = x3;
            x3 = x2 + x1;
        }
        return x3;
        
    }

    public static void compare(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        int n = scan.nextInt();
        long fact = 1;
        for (int i = 2;i <= n; i++){
            fact *= i;
        }
        System.out.printf("%d! is %d", n, fact);
        scan.close();
    }

    public static int greatestMultiple(int n){
        if (isPrime(n)){
            return n;
        }
        else{
            for (int d = n / 2;d >= 1; d--){
                if(n % d == 0)
                    return d;
            }
        }
        return 0;
    }

    public static void main(String []args){
        System.out.printf("%d", greatestMultiple(2564));
    }
}
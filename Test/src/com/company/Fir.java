package com.company;

class Fir implements Runnable{
    int x;

    public Fir(int x){ this.x = x; }

    public void run(){
        new Thread(() -> {System.out.print(x);}).start();
    }

    public static void main(String args[]) throws ArithmeticException {
        try {
            int x = 0;
            if (Double.isInfinite(2 / x))
                System.out.println("Infinit");
            else
                System.out.println("2/0");
        }
        catch (ArithmeticException e){
            System.out.println("Infinit");
        }
    }
}

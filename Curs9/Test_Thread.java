import java.io.*;
import java.lang.Thread;

class FirDeExecutare extends Thread {
    char c;
    public FirDeExecutare(char c)
    {
        this.c = c; 
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
            System.out.print(c + " ");
    }
   
}

public class Test_Thread
{
    public static void main(String[] args)
    {
        FirDeExecutare fir_1 = new FirDeExecutare('1');
        FirDeExecutare fir_2 = new FirDeExecutare('2');

        fir_1.start();
        fir_2.start();

        for(int i = 0; i < 100; i++)
            System.out.print(Integer.toString(0) + ' ');
            System.out.println();
    }
}

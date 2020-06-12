import java.util.Scanner;

public class Fibo {
    public static int fib(int n)
    {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args)
    {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.print("Give me number from 1 to 45: ");
        int liczba = userInputScanner.nextInt();

        if(liczba<1 || liczba>45)
        {
            System.out.println("Number out of range!");
            return;
        }

        int[] tab = new int[liczba];
        for(int i=0; i<liczba; i++)
        {
            tab[i] = fib(i);
            System.out.println(tab[i]);
        }
    }
}

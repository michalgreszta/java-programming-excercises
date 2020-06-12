import java.util.Scanner;

public class Problem610A
{
    public static void main(String[] args)
    {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter number:");
        int liczba = userInputScanner.nextInt();

        if (liczba%2 == 1)
        {
            System.out.println("There is no such possibility.");
        }
        else if (liczba%4 != 0)
        {
            System.out.println(liczba/4);
        }
        else
        {
            System.out.println(liczba/4-1);
        }

    }
}

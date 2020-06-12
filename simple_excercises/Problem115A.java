import java.util.Scanner;

public class Problem115A
{
    public static void main(String[] args)
    {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter number of employees:");

        int number = userInputScanner.nextInt();

        int[] allEmpl = new int[number+9];

        for (int i = 1; i <= number; i++)
        {
            allEmpl[i] = userInputScanner.nextInt();
        }

        int count=0, result=0;
        for (int i = 1; i <= number; i++)
        {
            count = 0;
            int employee = allEmpl[i];

            while (employee != -1)
            {
                employee = allEmpl[employee];
                count++;
            }

            result = result>count ? result : count;
        }

        System.out.println(result+1);
    }
}

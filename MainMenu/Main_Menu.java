import java.util.Scanner;

class ANHA_MainMenu
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("\n=========================");
            System.out.println("   ANHA BIO SYSTEM MENU");
            System.out.println("=========================");
            System.out.println("1. DNA Analyzer");
            System.out.println("2. Sequence Alignment + Mutation");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if(choice == 1)
            {
                DNA_Analyzer.main(null);   // redirect
            }
            else if(choice == 2)
            {
                Sequence_Alignment.main(null); // redirect
            }
            else if(choice == 3)
            {
                System.out.println("Exiting system...");
                break;
            }
            else
            {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
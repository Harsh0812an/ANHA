
import java.util.Scanner;
class Sequence_Validator
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter DNA Strand 1");
        String DNA1=sc.nextLine();
        System.out.println("Enter DNA Strand 2");
        String DNA2=sc.nextLine();
        DNA1=DNA1.trim().toUpperCase();
        DNA2=DNA2.trim().toUpperCase();
        boolean valid1=true;
        boolean valid2=true;
        if(DNA1.length()==0)
        {
            System.out.println("DNA Strand 1 is empty");
            valid1=false;
        }
        if(DNA2.length()==0)
        {
            System.out.println("DNA Strand 2 is empty");
            valid2=false;
        }
        for(int i=0;i<DNA1.length();i++)
        {
            char ch=DNA1.charAt(i);
            if(ch!='A' && ch!='T' && ch!='G' && ch!='C')
            {
                System.out.println("Invalid character in DNA Strand 1 at position " + (i+1) + ": " + ch);
                valid1=false;
            }
        }
        for(int i=0;i<DNA2.length();i++)
        {
            char ch=DNA2.charAt(i);
            if(ch!='A' && ch!='T' && ch!='G' && ch!='C')
            {
                System.out.println("Invalid character in DNA Strand 2 at position " + (i+1) + ": " + ch);
                valid2=false;
            }
        }
        if(valid1==true)
        {
            System.out.println("DNA Strand 1 is Valid");
        }
        else
        {
            System.out.println("DNA Strand 1 is Invalid");
        }
        if(valid2==true)
        {
            System.out.println("DNA Strand 2 is Valid");
        }
        else
        {
            System.out.println("DNA Strand 2 is Invalid");
        }
        sc.close();
    }
}

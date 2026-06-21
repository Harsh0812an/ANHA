import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// DNA ANALYZER MODULE OF ANHA
public class DNA_Analyzer
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String DNA="";
        System.out.println("Enter 1 to enter DNA manually and 2 to access DNA from a file");
        int choice=sc.nextInt();
        sc.nextLine();

        if(choice==1)
        {
            System.out.println("\nEnter DNA strand");
            DNA=sc.nextLine();
        }
        else
        {
            System.out.println("FASTA File Reader Module Coming Soon...");
            return;
        }

        DNA=DNA.toUpperCase();

        // validation
        for(int i=0;i<DNA.length();i++)
        {
            char ch=DNA.charAt(i);
            if(ch!='A' && ch!='T' && ch!='G' && ch!='C')
            {
                System.out.println("Invalid DNA Sequence!");
                return;
            }
        }

        int length=DNA.length();

        int A=0,T=0,G=0,C=0;

        for(int i=0;i<length;i++)
        {
            char ch=DNA.charAt(i);
            if(ch=='A') A++;
            else if(ch=='T') T++;
            else if(ch=='G') G++;
            else C++;
        }

        double gc=((double)(G+C)/length)*100;
        double at=((double)(A+T)/length)*100;

        // reverse complement
        String rev="";
        for(int i=length-1;i>=0;i--)
        {
            char ch=DNA.charAt(i);

            if(ch=='A') rev+='T';
            else if(ch=='T') rev+='A';
            else if(ch=='G') rev+='C';
            else rev+='G';
        }

        String rna=DNA.replace('T','U');

        int motif=0;

        for(int i=0;i<length-2;i++)
        {
            if(DNA.charAt(i)=='A' && DNA.charAt(i+1)=='T' && DNA.charAt(i+2)=='G')
                motif++;
        }

        int codon=length/3;

        // OUTPUT
        System.out.println("\nDNA Analyzer Report");
        System.out.println("---------------------------");
        System.out.println("DNA : "+DNA);
        System.out.println("Length : "+length);

        System.out.println("\nA:"+A+" T:"+T+" G:"+G+" C:"+C);

        System.out.printf("\nGC Content : %.2f%%\n",gc);
        System.out.printf("AT Content : %.2f%%\n",at);

        System.out.println("\nReverse Complement : "+rev);
        System.out.println("RNA Sequence : "+rna);

        System.out.println("\nATG Motif Count : "+motif);
        System.out.println("Codon Count : "+codon);

        // REPORT
        System.out.println("\nSave report? (yes/no)");
        String save=sc.next();

        if(save.equalsIgnoreCase("yes"))
        {
            try
            {
                FileWriter fw=new FileWriter("DNA_Report.txt");

                LocalDateTime now=LocalDateTime.now();
                DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                fw.write("===== DNA ANALYZER REPORT =====\n");
                fw.write("Generated: "+now.format(dtf)+"\n\n");

                fw.write("DNA: "+DNA+"\n");
                fw.write("Length: "+length+"\n\n");

                fw.write("A:"+A+" T:"+T+" G:"+G+" C:"+C+"\n");
                fw.write("GC: "+gc+"%\n");
                fw.write("AT: "+at+"%\n\n");

                fw.write("Reverse Complement: "+rev+"\n");
                fw.write("RNA: "+rna+"\n\n");

                fw.write("ATG Motif Count: "+motif+"\n");
                fw.write("Codon Count: "+codon+"\n");

                fw.close();

                System.out.println("Report saved as DNA_Report.txt");
            }
            catch(IOException e)
            {
                System.out.println("Error saving report");
            }
        }
    }
}
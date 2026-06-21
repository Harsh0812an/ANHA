import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// SEQUENCE ALIGNMENT + MUTATION MODULE
public class Sequence_Alignment
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("\n===== SEQUENCE ALIGNMENT =====");

        System.out.print("DNA 1: ");
        String DNA_1=sc.nextLine();

        System.out.print("DNA 2: ");
        String DNA_2=sc.nextLine();

        DNA_1=DNA_1.toUpperCase();
        DNA_2=DNA_2.toUpperCase();

        int match=1,mismatch=-1,gap=-2;

        int l1=DNA_1.length();
        int l2=DNA_2.length();

        int[][] A=new int[l1+1][l2+1];

        for(int j=1;j<=l2;j++)
            A[0][j]=A[0][j-1]+gap;

        for(int i=1;i<=l1;i++)
            A[i][0]=A[i-1][0]+gap;

        // Filling the matrix
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                char c1=DNA_1.charAt(i-1);
                char c2=DNA_2.charAt(j-1);

                int diag=A[i-1][j-1]+(c1==c2?match:mismatch);
                int up=A[i-1][j]+gap;
                int left=A[i][j-1]+gap;

                A[i][j]=Math.max(diag,Math.max(up,left));
            }
        }

        // TRACEBACK
        String a1="",a2="";

        int i=l1,j=l2;

        while(i>0||j>0)
        {
            if(i>0&&j>0)
            {
                char c1=DNA_1.charAt(i-1);
                char c2=DNA_2.charAt(j-1);

                int score=(c1==c2?match:mismatch);

                if(A[i][j]==A[i-1][j-1]+score)
                {
                    a1=c1+a1;
                    a2=c2+a2;
                    i--;j--;
                    continue;
                }
            }

            if(i>0&&A[i][j]==A[i-1][j]+gap)
            {
                a1=DNA_1.charAt(i-1)+a1;
                a2="-"+a2;
                i--;
            }
            else if(j>0)
            {
                a1="-"+a1;
                a2=DNA_2.charAt(j-1)+a2;
                j--;
            }
        }

        System.out.println("\n===== FINAL ALIGNMENT =====");
        System.out.println("DNA 1 : "+a1);
        System.out.println("DNA 2 : "+a2);

        // MUTATION COUNT
        int matches=0,sub=0,ins=0,del=0;

        for(int k=0;k<a1.length();k++)
        {
            if(a1.charAt(k)==a2.charAt(k)) matches++;
            else if(a1.charAt(k)=='-') ins++;
            else if(a2.charAt(k)=='-') del++;
            else sub++;
        }

        System.out.println("\n===== MUTATION REPORT =====");

        System.out.println("Matches       : "+matches);
        System.out.println("Substitutions : "+sub);
        System.out.println("Insertions    : "+ins);
        System.out.println("Deletions     : "+del);

        // MUTATION DETECTOR (POSITION WISE)
        System.out.println("\n===== ANHA MUTATION DETECTOR =====\n");

        for(int k=0;k<a1.length();k++)
        {
            char c1=a1.charAt(k);
            char c2=a2.charAt(k);

            if(c1==c2) continue;

            System.out.println("Position "+(k+1));

            if(c1=='-')
                System.out.println("Insertion of "+c2);
            else if(c2=='-')
                System.out.println("Deletion of "+c1);
            else
            {
                System.out.println(c1+" -> "+c2);
                System.out.println("Substitution");
            }

            System.out.println();
        }

        int total=matches+sub+ins+del;

        double similarity=(total>0)?(matches*100.0)/total:0;
        double mutationRate=100-similarity;

        System.out.printf("Similarity      : %.2f%%\n",similarity);
        System.out.printf("Mutation Rate   : %.2f%%\n",mutationRate);

        // REPORT
        System.out.println("\nSave report? (yes/no)");
        String save=sc.next();

        if(save.equalsIgnoreCase("yes"))
        {
            try
            {
                FileWriter fw=new FileWriter("Alignment_Report.txt");

                LocalDateTime now=LocalDateTime.now();
                DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                fw.write("===== ALIGNMENT REPORT =====\n");
                fw.write("Generated: "+now.format(dtf)+"\n\n");

                fw.write("Aligned DNA 1: "+a1+"\n");
                fw.write("Aligned DNA 2: "+a2+"\n\n");

                fw.write("Matches: "+matches+"\n");
                fw.write("Substitutions: "+sub+"\n");
                fw.write("Insertions: "+ins+"\n");
                fw.write("Deletions: "+del+"\n\n");

                fw.write("Similarity: "+similarity+"%\n");
                fw.write("Mutation Rate: "+mutationRate+"%\n");

                fw.close();

                System.out.println("Report saved as Alignment_Report.txt");
            }
            catch(IOException e)
            {
                System.out.println("Error saving report");
            }
        }
    }
}
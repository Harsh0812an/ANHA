
import java.util.Scanner;

class OrfFinder
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String dna;
        //DNA input
        System.out.println("Enter DNA sequence");
        dna=sc.nextLine();
        dna=dna.toUpperCase();
        //Validation
        int length=dna.length();
        boolean valid=true;
        for(int i=0;i<length;i++)
        {
            char ch=dna.charAt(i);

            if(ch!='A' && ch!='T' && ch!='G' && ch!='C')
            {
                valid=false;
                break;
            }
        }
        if(valid==false)
        {
            System.out.println("Enter valid strand");
        }
        else
        {
            //finding start codon position
            int beg=0;
            for(int i=0;i<=length-3;i++)
            {
                char ch=dna.charAt(i);
                char ch1=dna.charAt(i+1);
                char ch2=dna.charAt(i+2);

                if(ch=='A' && ch1=='T' && ch2=='G')
                {
                    beg=i;
                    break;
                }
            }
            //finding end codon
            int end=-1;

            for(int i=beg;i<=length-3;i+=3)
            {
                String codon=dna.substring(i,i+3);
                if(codon.equals("TAA") || codon.equals("TAG") || codon.equals("TGA"))
                {
                    end=i;
                    break;
                }
            }
            if(end!=-1)
            {
                //length of codone
                int len=end-beg+3;
                //extracted codone
                String extracted=dna.substring(beg,end+3);
                System.out.println("ORF Length:"+len);
                System.out.println("Extracted codone:"+extracted);
            }
            else
            {
                System.out.println("No complete ORF found");
            }
        }
    }
}

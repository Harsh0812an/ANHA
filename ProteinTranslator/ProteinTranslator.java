import java.util.Scanner;
class ProteinTranslator
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
            if(ch!='A'&&ch!='T'&&ch!='G'&&ch!='C')
            {
                valid=false;
                break;
            }
        }

        if(valid==false||length==0)
        {
            System.out.println("Enter valid strand");
        }
        else
        {
            //Converting and storing RNA from DNA
            String mRNA="";

            for(int i=0;i<length;i++)
            {
                char ch=dna.charAt(i);

                if(ch=='T')
                {
                    mRNA+='U';
                }
                else
                {
                    mRNA+=ch;
                }
            }

            System.out.println("mRNA Sequence: "+mRNA);

            //Codon Formation
            String codons="";

            for(int i=0;i+2<mRNA.length();i+=3)
            {
                String codon=mRNA.substring(i,i+3);
                codons+=codon+" | ";
            }

            System.out.println("Codons: "+codons);

            //Codon Mapping and Translation
            String protein="";
            String aminoAcids="";
            boolean stopFound=false;
            String stopCodon="None";

            for(int i=0;i+2<mRNA.length();i+=3)
            {
                String codon=mRNA.substring(i,i+3);
                String amino="";

                switch(codon)
                {
                    case "UUU": case "UUC":
                        amino="F";
                        break;

                    case "UUA": case "UUG":
                    case "CUU": case "CUC":
                    case "CUA": case "CUG":
                        amino="L";
                        break;

                    case "UCU": case "UCC":
                    case "UCA": case "UCG":
                    case "AGU": case "AGC":
                        amino="S";
                        break;

                    case "UAU": case "UAC":
                        amino="Y";
                        break;

                    case "UAA": case "UAG": case "UGA":
                        amino="Stop";
                        break;

                    case "UGU": case "UGC":
                        amino="C";
                        break;

                    case "UGG":
                        amino="W";
                        break;

                    case "CCU": case "CCC":
                    case "CCA": case "CCG":
                        amino="P";
                        break;

                    case "CAU": case "CAC":
                        amino="H";
                        break;

                    case "CAA": case "CAG":
                        amino="Q";
                        break;

                    case "CGU": case "CGC":
                    case "CGA": case "CGG":
                    case "AGA": case "AGG":
                        amino="R";
                        break;

                    case "AUU": case "AUC": case "AUA":
                        amino="I";
                        break;

                    case "AUG":
                        amino="M";
                        break;

                    case "ACU": case "ACC":
                    case "ACA": case "ACG":
                        amino="T";
                        break;

                    case "AAU": case "AAC":
                        amino="N";
                        break;

                    case "AAA": case "AAG":
                        amino="K";
                        break;

                    case "GUU": case "GUC":
                    case "GUA": case "GUG":
                        amino="V";
                        break;

                    case "GCU": case "GCC":
                    case "GCA": case "GCG":
                        amino="A";
                        break;

                    case "GAU": case "GAC":
                        amino="D";
                        break;

                    case "GAA": case "GAG":
                        amino="E";
                        break;

                    case "GGU": case "GGC":
                    case "GGA": case "GGG":
                        amino="G";
                        break;
                }

                //Stop Codon Handling
                if(amino.equals("Stop"))
                {
                    stopFound=true;
                    stopCodon=codon;
                    aminoAcids+="Stop | ";
                    break;
                }
                else
                {
                    protein+=amino;
                    aminoAcids+=amino+" | ";
                }
            }

            //Protein Output
            System.out.println("Amino Acids: "+aminoAcids);
            System.out.println("Protein Sequence: "+protein);
            System.out.println("Protein Length: "+protein.length());

            if(stopFound==true)
            {
                System.out.println("Stop Codon: "+stopCodon);
            }
            else
            {
                System.out.println("Stop Codon: Not Found");
            }
        }
        sc.close();
    }
}
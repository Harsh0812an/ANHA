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
            //Reverse complement
            String rev="";
            for(int i=length-1;i>=0;i--)
            {
                char ch=dna.charAt(i);
                if(ch=='A') rev+='T';
                else if(ch=='T') rev+='A';
                else if(ch=='G') rev+='C';
                else rev+='G';
            }

            //Six reading frame setup
            String frame1[]=new String[length/3+1];
            String frame2[]=new String[length/3+1];
            String frame3[]=new String[length/3+1];
            String frame4[]=new String[length/3+1];
            String frame5[]=new String[length/3+1];
            String frame6[]=new String[length/3+1];

            //Forward frame +1
            int pos=0;
            for(int i=0;i<=length-3;i+=3)
            {
                frame1[pos]=dna.substring(i,i+3);
                pos++;
            }

            //Forward frame +2
            pos=0;
            for(int i=1;i<=length-3;i+=3)
            {
                frame2[pos]=dna.substring(i,i+3);
                pos++;
            }

            //Forward frame +3
            pos=0;
            for(int i=2;i<=length-3;i+=3)
            {
                frame3[pos]=dna.substring(i,i+3);
                pos++;
            }

            //Reverse frame -1
            pos=0;
            for(int i=0;i<=length-3;i+=3)
            {
                frame4[pos]=rev.substring(i,i+3);
                pos++;
            }

            //Reverse frame -2
            pos=0;
            for(int i=1;i<=length-3;i+=3)
            {
                frame5[pos]=rev.substring(i,i+3);
                pos++;
            }

            //Reverse frame -3
            pos=0;

            for(int i=2;i<=length-3;i+=3)
            {
                frame6[pos]=rev.substring(i,i+3);
                pos++;
            }

            //Minimum ORF length input
            System.out.println("Enter minimum ORF length");
            int minLength=sc.nextInt();

            //ORF data storage
            String orfSequence[]=new String[length*6];
            String orfFrame[]=new String[length*6];
            int orfStart[]=new int[length*6];
            int orfStop[]=new int[length*6];
            int orfLength[]=new int[length*6];
            int count=0;

            //Multiple ORF detection
            for(int f=0;f<6;f++)
            {
                String strand;
                if(f<3)
                    strand=dna;
                else
                strand=rev;
                int offset=f%3;
                String current[];

                if(f==0) current=frame1;
                else if(f==1) current=frame2;
                else if(f==2) current=frame3;
                else if(f==3) current=frame4;
                else if(f==4) current=frame5;
                else current=frame6;
                int total=(length-offset)/3;
                for(int i=0;i<total;i++)
                {
                    //Start codon detection
                    if(current[i].equals("ATG"))
                    {
                        int beg=offset+(i*3);
                        int end=-1;

                        //Stop codon detection
                        for(int j=i+1;j<total;j++)
                        {
                            String codon=current[j];
                            if(codon.equals("TAA") ||codon.equals("TAG") ||codon.equals("TGA"))
                            {
                                end=offset+(j*3)+2;
                                break;
                            }
                        }

                        //Complete ORF found
                        if(end!=-1)
                        {
                            int len=end-beg+1;
                            //Minimum length filtering
                            if(len>=minLength)
                            {
                                String extracted=
                                    strand.substring(beg,end+1);
                                orfSequence[count]=extracted;
                                if(f<3)
                                    orfFrame[count]="+"+(f+1);
                                else
                                    orfFrame[count]="-"+(f-2);

                                //Position calculation
                                if(f<3)
                                {
                                    orfStart[count]=beg+1;
                                    orfStop[count]=end+1;
                                }
                                else
                                {
                                    orfStart[count]=length-beg;
                                    orfStop[count]=length-end;
                                }
                                orfLength[count]=len;
                                count++;
                            }
                        }
                    }
                }
            }

            //Ranking ORFs by length
            for(int i=0;i<count-1;i++)
            {
                for(int j=0;j<count-1-i;j++)
                {
                    if(orfLength[j]<orfLength[j+1])
                    {
                        int temp=orfLength[j];
                        orfLength[j]=orfLength[j+1];
                        orfLength[j+1]=temp;

                        temp=orfStart[j];
                        orfStart[j]=orfStart[j+1];
                        orfStart[j+1]=temp;

                        temp=orfStop[j];
                        orfStop[j]=orfStop[j+1];
                        orfStop[j+1]=temp;

                        String temp1=orfSequence[j];
                        orfSequence[j]=orfSequence[j+1];
                        orfSequence[j+1]=temp1;

                        temp1=orfFrame[j];
                        orfFrame[j]=orfFrame[j+1];
                        orfFrame[j+1]=temp1;
                    }
                }
            }
            //Display results
            System.out.println("\n================================");
            System.out.println("     ANHA ADVANCED ORF FINDER");
            System.out.println("================================");
            System.out.println("Total ORFs detected: "+count);
            System.out.println("Minimum length: "+minLength);
            if(count==0)
            {
                System.out.println("No complete ORFs found");
            }
            else
            {
                System.out.println("\nRANKED ORF RESULTS");

                for(int i=0;i<count;i++)
                {
                    System.out.println("\n------------------------");
                    System.out.println("Rank: "+(i+1));
                    System.out.println("ORF ID: "+(i+1));
                    System.out.println("Frame: "+orfFrame[i]);
                    System.out.println("Start: "+orfStart[i]);
                    System.out.println("Stop: "+orfStop[i]);
                    System.out.println("Length: "+orfLength[i]+" bp");
                    System.out.println("Sequence: "+orfSequence[i]);
                }
            }
            //Text report generation
            try
            {
                java.io.PrintWriter pw=
                new java.io.PrintWriter("ANHA_ORF_Report.txt");
                pw.println("ANHA ADVANCED ORF FINDER");
                pw.println("========================");
                pw.println("DNA Sequence: "+dna);
                pw.println("Reverse Complement: "+rev);
                pw.println("Minimum ORF Length: "+minLength);
                pw.println("Total ORFs Detected: "+count);
                for(int i=0;i<count;i++)
                {
                    pw.println("\n------------------------");

                    pw.println("Rank: "+(i+1));
                    pw.println("ORF ID: "+(i+1));
                    pw.println("Frame: "+orfFrame[i]);
                    pw.println("Start: "+orfStart[i]);
                    pw.println("Stop: "+orfStop[i]);
                    pw.println("Length: "+orfLength[i]+" bp");
                    pw.println("Sequence: "+orfSequence[i]);
                }
                pw.close();
                System.out.println("\nReport generated successfully");
                System.out.println("File: ANHA_ORF_Report.txt");
            }
            catch(Exception e)
            {
                System.out.println("Error generating report");
            }
        }
    }
}

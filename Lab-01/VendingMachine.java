package Java;
import java.util.*; 

class VendingMachine 

{ 

    enum Coin{ONE,TWO,FIVE,TEN,FIFTEEN} 

    public static void main(String arg[]) 

    { 

        Scanner sc=new Scanner(System.in); 

        int p=15; 

        int t=0; 

        while(t<p) 

        { 

            System.out.println("Enter the coin"); 

            Coin c=Coin.valueOf(sc.next().toUpperCase()); 

            int value=0; 

            switch(c) 

            { 

                case ONE: 

                    value=1; 

                    break; 

                case TWO: 

                    value=2; 

                    break; 

                case FIVE: 

                    value=5; 

                    break; 

                case TEN: 

                    value=10; 

                    break; 

                default: 

                    System.out.println("Invalid"); 

            } 

            t+=value; 

        } 

            System.out.println("Total="+t); 

            System.out.println("Paid Change="+(t-p)); 

    } 

} 
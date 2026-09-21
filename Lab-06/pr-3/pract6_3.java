import java.util.*;
import java.util.function.Function;

public class pract6_3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        List<Double> prices=Arrays.asList(1000.0,2500.0,5000.0,8000.0);

        System.out.println("Prices:");
        for(double price:prices){
            System.out.println(price);
        }

        System.out.println("\nChoose discount rule:");
        System.out.println("1. 10% discount");
        System.out.println("2. 20% discount");
        System.out.println("3. Flat Rs. 500 discount");

        int choice=sc.nextInt();

        Function<Double,Double> discountRule;

        switch(choice){
            case 1:
                discountRule=p->p*0.90;
                break;
            case 2:
                discountRule=p->p*0.80;
                break;
            case 3:
                discountRule=p->Math.max(0,p-500);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("\nPrices after discount:");

        for(double price:prices){
            double finalPrice=discountRule.apply(price);
            System.out.println("Original: Rs."+price+" -> Final: Rs."+finalPrice);
        }

        sc.close();
    }
}
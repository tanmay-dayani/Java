public class ParkingLot
{
private int twoWheelers;
private int fourWheelers;
private final int twoCap;
private final int fourCap;
private static long revenue = 0;
 
public ParkingLot(int twoCap, int fourCap)
{
this.twoCap = twoCap;
this.fourCap = fourCap;
this.twoWheelers = 0;
this.fourWheelers = 0;
}
 
public boolean park(String type)
{
if (type.equals("two"))
{
if (twoWheelers < twoCap)
{
twoWheelers++;
revenue += 20;
return true;
} else
{
System.out.println("Full");
return false;
}
} else if (type.equals("four"))
{
if (fourWheelers < fourCap)
{
fourWheelers++;
revenue += 40;
return true;
} else {
System.out.println("Full");
return false;
}
} else
{
System.out.println("Unknown vehicle type: " + type);
return false;
}
}
 
public void leave(String type)
{
if (type.equals("two"))
{
if (twoWheelers > 0) {
twoWheelers--;
}
} else if (type.equals("four"))
{
if (fourWheelers > 0)
{
fourWheelers--;
}
} else
{
System.out.println("Unknown vehicle type: " + type);
}
}
 
public int getTwoWheelers()
{
return twoWheelers;
}
 
public int getFourWheelers()
{
return fourWheelers;
}
 
public static long getRevenue()
{
return revenue;
}
 
public static void main(String[] args)
{
// Small capacities so we can easily demonstrate "Full"
ParkingLot lot = new ParkingLot(3, 2);
 
System.out.println("Park two: " + lot.park("two")); // true, 1/3
System.out.println("Park two: " + lot.park("two")); // true, 2/3
System.out.println("Park four: " + lot.park("four")); // true, 1/2
System.out.println("Park four: " + lot.park("four")); // true, 2/2
System.out.println("Park four: " + lot.park("four")); // Full -> false, still 2/2
System.out.println("Park two: " + lot.park("two")); // true, 3/3
System.out.println("Park two: " + lot.park("two")); // Full -> false, still 3/3
 
System.out.println("Leave two: ");
lot.leave("two"); // 2/3
System.out.println("Leave four: ");
lot.leave("four"); // 1/2
 
System.out.println("Park four: " + lot.park("four")); // true, 2/2 again
System.out.println("Leave two: ");
lot.leave("two"); // 1/3
 
// Leaving beyond zero should stay at zero, not go negative
lot.leave("four");
lot.leave("four");
lot.leave("four"); // fourWheelers already 0 here, should remain 0
 
System.out.println();
System.out.println("Final two-wheeler occupancy: " + lot.getTwoWheelers() + "/" + lot.twoCap);
System.out.println("Final four-wheeler occupancy: " + lot.getFourWheelers() + "/" + lot.fourCap);
System.out.println("Total revenue: " + ParkingLot.getRevenue());
}
}
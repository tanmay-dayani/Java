interface Switchable{
void on();
void off();
default void toggle(){
on();
}
}
class Fan implements Switchable{
public void on(){
System.out.println("Fan ON");
}
public void off(){
System.out.println("Fan OFF");
}
}
class Light implements Switchable{
public void on(){
System.out.println("Light ON");
}
public void off(){
System.out.println("Light OFF");
}
}
interface SwitchPermission{
boolean maySwitchOn(Switchable device,int hour);
}
public class pract6_1{
public static void main(String[] args){
Switchable[] devices={new Fan(),new Light()};
for(Switchable device:devices){
device.on();
device.toggle();
device.off();
}
SwitchPermission p1=new SwitchPermission(){
public boolean maySwitchOn(Switchable device,int hour){
return hour>=6&&hour<=22;
}
};
SwitchPermission p2=(device,hour)->hour>=6&&hour<=22;
System.out.println("Anonymous class: "+p1.maySwitchOn(new Fan(),10));
System.out.println("Lambda: "+p2.maySwitchOn(new Light(),23));
}
}
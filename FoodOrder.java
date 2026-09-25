abstract class Student
{
    String name;
    String id;
    int balance;
    int hungrylevel;
    int amount;

    abstract void pay();

    public String getname()
    {
        return name;
    }
    void addmoney(int amount)
    {
        balance+=amount;
    }
    void orderfood()
    {
        if(hungrylevel>80)
        {
            System.out.println("EMERGENCY.! Feed the Student Immediatgely");
        }
        if(balance<0)
        {
            System.out.println("cannot psend more than the balance!");
        }

        System.out.println("your order is placed!!");

    }
    void showbalance()
    {
        System.out.println("balance is: "+balance);
    }
}
public class FoodOrder extends Student{
    int orderid;
    String foodname;
    float price;
    int quantity;


    void calctotal()
    {
        float totalamt=quantity*price;
        System.out.println(totalamt);
    }

    void showorder()
    {
        System.out.println("Name: "+super.getname()+\n+"Food: "+foodname+\n+"Quantity: " +qunatity+\n+"Total: "+calctotal());
    }
}

class Payment extends Student{

}c
public class Main {
    
}

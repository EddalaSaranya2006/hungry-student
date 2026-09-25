class Student {

    String name;
    String id;
    float balance;
    int hungerLevel;

    Student(String name, String id, int balance, int hungerLevel) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.hungerLevel = hungerLevel;
    }

    void addMoney(int amount) {
        balance = balance + amount;
        System.out.println("Money added: Rs." + amount);
    }

    void showBalance() {
        System.out.println("Balance: Rs." + balance);
    }

    void orderFood(FoodOrder food) {

        if (hungerLevel > 80) {
            System.out.println(
                "EMERGENCY! Feed the student immediately!"
            );
        }

        if (food.calculateTotal() > balance) {
            System.out.println(
                "Cannot spend more than the balance!"
            );
        } else {
            balance = balance - food.calculateTotal();
            System.out.println("Your order is placed!");
        }
    }
}



class FoodOrder extends Student {

    int orderId;
    String foodName;
    float price;
    int quantity;

    FoodOrder(
        String name,
        String id,
        int balance,
        int hungerLevel,
        int orderId,
        String foodName,
        float price,
        int quantity
    ) {
        super(name, id, balance, hungerLevel);

        this.orderId = orderId;
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
    }

    float calculateTotal() {

        float total = price * quantity;

        if (foodName.equalsIgnoreCase("Biryani")) {
            System.out.println(
                "Student has chosen happiness"
            );
        }

        if (quantity > 3) {
            System.out.println(
                "Bro, are you feeding the entire class?"
            );
        }

        return total;
    }

    void showOrder() {

        System.out.println("Student: " + name);
        System.out.println("Food: " + foodName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: Rs." + calculateTotal());
    }
}


abstract class Payment {

    abstract void pay();
}


class UPI extends Payment {

    void pay() {
        System.out.println("Payment: UPI");
        System.out.println("Payment successful!");
    }
}


class CreditCard extends Payment {

    void pay() {
        System.out.println("Payment: Credit Card");
        System.out.println("Payment successful!");
    }
}


class Cash extends Payment {

    void pay() {
        System.out.println("Payment: Cash");
        System.out.println("Payment successful!");
    }
}


abstract class Delivery {

    abstract void deliver();
}


class BikeDelivery extends Delivery {

    void deliver() {
        System.out.println("Delivery: Bike");
        System.out.println("Your food is coming by bike");
    }
}


class DroneDelivery extends Delivery {

    void deliver() {
        System.out.println("Delivery: Drone");
        System.out.println("Your food is flying to you");
    }
}


public class Main {

    public static void main(String[] args) {

        System.out.println("----- HUNGRY STUDENT -----");

        FoodOrder student = new FoodOrder(
            "Hemanth",
            "S101",
            500,
            90,
            101,
            "Biryani",
            150,
            2
        );

        student.showOrder();

        System.out.println();

        student.orderFood(student);

        System.out.println();

        Payment payment = new UPI();
        payment.pay();

        System.out.println();

        Delivery delivery = new BikeDelivery();
        delivery.deliver();

        System.out.println();

        student.showBalance();
    }
}
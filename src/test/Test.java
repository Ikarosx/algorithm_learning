package test;


import java.util.ArrayList;

/**
 * @author Ikaros
 * @date 2020/4/12 20:11
 */
public class Test {
    
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new AoDiQ5(10));
        cars.add(new PassengerCar(10, 2));
        double sum = 0;
        for (Car car : cars) {
            sum += car.calcPay();
            System.out.println(car);
        }
        System.out.println(sum);
    }
}

class Car {
    double pay;
    double day;
    
    Car(double day) {
        this.day = day;
    }
    
    public double calcPay() {
        return pay * day;
    }
}

class Sedan extends Car {
    Sedan(double day) {
        super(day);
    }
}

class AoDiQ7 extends Sedan {
    public AoDiQ7(double day) {
        super(day);
        this.pay = 600;
    }
    
    @Override
    public String toString() {
        return "AoDiQ7{" + "pay=" + pay + ", day=" + day + '}';
    }
}

class AoDiQ5 extends Sedan {
    public AoDiQ5(double day) {
        super(day);
        this.pay = 450;
    }
    
    @Override
    public String toString() {
        return "AoDiQ5{" + "pay=" + pay + ", day=" + day + '}';
    }
}

class BaoMaX7 extends Sedan {
    public BaoMaX7(double day) {
        super(day);
        this.pay = 700;
    }
    
    @Override
    public String toString() {
        return "BaoMaX7{" + "pay=" + pay + ", day=" + day + '}';
    }
}

class BenChiDaG extends Sedan {
    public BenChiDaG(double day) {
        super(day);
        this.pay = 800;
    }
    
    @Override
    public String toString() {
        return "BenChiDaG{" + "pay=" + pay + ", day=" + day + '}';
    }
}

class PassengerCar extends Car {
    int nums;
    
    PassengerCar(double day, int nums) {
        super(day);
        this.pay = nums <= 16 ? 800 : 1200;
    }
    
    @Override
    public String toString() {
        return "PassengerCar{" + "pay=" + pay + ", day=" + day + ", nums=" + nums + '}';
    }
}
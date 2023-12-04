import java.util.ArrayList;

interface CarbonFootprint {
    double getCarbonFootprint();
}

class Building implements CarbonFootprint {
    double electricity;

    Building(double electricity) {
        this.electricity = electricity;
    }
    public double getCarbonFootprint() {
        System.out.print("Building carbon footprint ");
        return electricity * 0.554;
    }
}

class Car implements CarbonFootprint {
    double fuel;

    Car(double fuel) {
        this.fuel = fuel;
    }
    public double getCarbonFootprint() {
        System.out.print("Car carbon footprint ");
        return fuel * 2.373;
    }
}

class Bicycle implements CarbonFootprint {
    public double getCarbonFootprint() {
        System.out.print("Bicycle carbon footprint ");
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<CarbonFootprint> result = new ArrayList<>();
        result.add(new Building(100));
        result.add(new Car(50));
        result.add(new Bicycle());
        
        for (int i=0;i<result.size();i++) {
            System.out.printf("%.4f%n",result.get(i).getCarbonFootprint());
        }
    }
}
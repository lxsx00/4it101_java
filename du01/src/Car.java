public class Car {
    private String brand;
    private String model;
    private Person owner;
    private int year;
    private String color;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void describeCar() {
        System.out.println("Auto značky " + brand + "model " + model + "bylo vyrobeno v roce " + year + "a zvolená barva je " + color);
    }

    public void checkCarAge() {
        int currentYear = java.time.Year.now().getValue();
        if (currentYear - year > 5) {
            System.out.println("Auto " + brand + " " + model + " je starší než 5 let.");
        } else {
            System.out.println("Auto " + brand + " " + model + " je maximálně 5 let staré.");
        }
    }

    public String getBrand() {
        return brand;
    }


    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Auto {" +
                "značka = '" + brand + "'" +
                ", model = '" + model + "'" +
                ", vlastník = '" + (owner != null ? owner.getName() : "nobody") + "'" +
                ", rok výroby = '" + year + "'" +
                ", barva='" + color + "'" +
                "}";
    }
}


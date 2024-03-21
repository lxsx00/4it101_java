public class DogHouse {
    private String name;
    private Dog dog;
    private String size;
    private String material;

    public DogHouse(String name, String size, String material) {
        this.name = name;
        this.size = size;
        this.material = material;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void printSize() {
        System.out.println("Rozměry boudy se jménem " + "\"" + name + "\"" + " jsou: " + size + ".");
    }

    public void displaySizeAndMaterial() {
        System.out.println("Bouda " + name + " je " + size + " a z materiálu " + material + ".");
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Psí bouda {" +
                "jméno = '" + name + "'" +
                ", pes = '" + (dog != null ? dog.getName() : "no dog") + "'" +
                ", velikost = '" + size + "'" +
                ", materiál = '" + material + "'" +
                "}";
    }
}

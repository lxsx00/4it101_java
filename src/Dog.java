public class Dog {
    private String name;
    private int age;
    private Person owner;
    private DogHouse dogHouse;
    private String breed;

    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setDogHouse(DogHouse dogHouse) {
        this.dogHouse = dogHouse;
        dogHouse.setDog(this);
    }

    public void bark() {
        System.out.println(name + " štěká: Haf! Haf!");
    }

    public String getName() {
        return name;
    }


    public void printLatinName() {
        if ("Zlatý retrívr".equals(breed)) {
            System.out.println(name + " je zlatý retrívr anglicky známý jako Golden retriever.");
        } else if ("Německý ovčak".equals(breed)) {
            System.out.println(name + "je německý ovčak anglicky známý jako German Shepherd");
        } else {
            System.out.println(name + " je psí rasa " + breed + ", v angličtině si to budeš muset dohledat sám");
        }
    }

    @Override
    public String toString() {
        return "Pes {" +
                "jméno = '" + name + "'" +
                ", věk = '" + age + "'" +
                ", páníček = '" + (owner != null ? owner.getName() : "nobody") + "'" +
                ", bouda = '" + (dogHouse != null ? dogHouse.getName() : "no dog house") + "'" +
                ", rasa = '" + breed + "'" +
                "}";
    }
}

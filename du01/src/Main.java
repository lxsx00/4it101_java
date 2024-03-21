public class Main {
    public static void main(String[] args) {
        Person person = new Person("Kaiser Söze", 30, "muž");
        Dog dog = new Dog("Max", 3, "Zlatý retrívr");
        Car car = new Car("Škoda", "Octavia", 2020, "bílá");
        DogHouse dogHouse = new DogHouse("Rexův domeček", "110 x 170 x 120 cm", "dřevo");
        Book book = new Book("Velký Gatsby", "F. Scott Fitzgerald", 208, true);

        System.out.println("\n");

        person.readsBook(book);
        person.ownsDog(dog); //nevypisuje nic
        person.ownsCar(car); //nevypisuje nic

        dog.setDogHouse(dogHouse); //nevypisuje nic
        dog.bark();
        dog.printLatinName();

        car.checkCarAge();

        dogHouse.printSize();

        book.alreadyReadBook();

        /* Mělo by mi to před informace o jednotlivých třídách vypsat 6 řádků.
        Zároveň jsou informace vypsány pomocí toString
         */

        System.out.println("\n");

        System.out.println("Informace o osobě:");
        System.out.println(person);
        System.out.println("\n");

        System.out.println("Informace o vlastněném psovi:");
        System.out.println(dog);
        System.out.println("\n");

        System.out.println("Informace o psí boudě:");
        System.out.println(dogHouse);
        System.out.println("\n");

        System.out.println("Informace o vlastněném modelu vozidla:");
        System.out.println(car);
        System.out.println("\n");

        System.out.println("Informace o právě čtené knize:");
        System.out.println(book);
        System.out.println("\n");
    }
}

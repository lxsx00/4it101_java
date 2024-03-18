public class Person {
    private String name;
    private int age;
    private Dog dog;
    private Car car;
    private Book favoriteBook;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void ownsDog(Dog dog) {
        this.dog = dog;
        dog.setOwner(this);
    }

    public void ownsCar(Car car) {
        this.car = car;
        car.setOwner(this);
    }

    public void readsBook(Book book) {
        this.favoriteBook = book;
        System.out.println(name + " právě čte knihu: " + book.getTitle() + ". Jistě je to dobrá volba");
    }

    public String getName() {
        return name;
    }

    // není to potřeba, jen jsem si to tak připravila
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Osoba {" +
                "jméno = '" + name + "'" +
                ", věk = '" + age + "'" +
                ", pohlaví = '" + gender + "'" +
                ", pes = '" + (dog != null ? dog.getName() : "no dog") + "'" +
                ", auto = '" + (car != null ? car.getBrand() : "no car") + "'" +
                ", oblíbená kniha = '" + (favoriteBook != null ? favoriteBook.getTitle() : "no book") + "'" +
        "}";
    }
}

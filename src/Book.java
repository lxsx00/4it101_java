public class Book {
    private String title;
    private String author;
    private Person owner;
    private int pageCount;
    private boolean read;

    public Book(String title, String author, int pageCount, boolean read) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.read = read;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void alreadyReadBook() {
        if (!read) {
            System.out.println("Čte se kniha " + title + " od autora " + author);
            read = true;
        } else {
            System.out.println("Kniha " + title + " už je přečtena.");
        }
    }

    public void getBookInfo() {
        System.out.println("Kniha  " + title + " od autora " + author + "má " + pageCount + "stran.");
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "Kniha {" +
                "název = '" + title + "'" +
                ", autor = '" + author + "'" +
                ", majitel = '" + (owner != null ? owner.getName() : "nemá majitele") + "'" +
                ", počet stran = '" + pageCount + "'" +
                "}";
    }
}

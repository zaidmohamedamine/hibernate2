package be.technobel.formation.iris.hibernate.model.entity;

public enum Type {
    CATALOGUE("catalogue", 1, 24),
    DICTIONNAIRE("dictionnaire", 1, 23),
    BLOP("blop", 1, 22);

    public String name;
    public int bookShell;
    public int level;

    Type(String name, int bookShell, int level) {
        this.name = name;
        this.bookShell = bookShell;
        this.level = level;
    }

    public String action() {
        if (this == BLOP) return blopAction();
        else if (this == CATALOGUE) return catalogueAction();
        else return "Dictionnaire";
    }

    private String catalogueAction() {
        return CATALOGUE.name;
    }

    private String blopAction() {
        return "Blop";
    }
}

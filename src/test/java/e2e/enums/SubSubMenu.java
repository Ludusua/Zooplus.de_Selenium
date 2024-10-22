package e2e.enums;

public enum SubSubMenu {
    SECTIONONE(1),
    SECTIONTWO(2),
    SECTIONTHREE(3);

    private final int value;

    SubSubMenu(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

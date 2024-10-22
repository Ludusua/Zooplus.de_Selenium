package e2e.enums;

public enum SubMenu {
    KATZE(1),
    HUNDER(2),
    KLEINTIER(3),
    FISCH(4),
    VOGEL(5),
    PFERDE(6),
    DIÄTFUTER(7),
    TOPMARKET(8),
    ANGEBOT(9);

    private final int value;

    SubMenu(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


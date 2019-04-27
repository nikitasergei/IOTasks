package noteBook;

public enum Priority {
    IMPORTANT("ВАЖНО"),
    NOT_IMPORTANT("НЕ ВАЖНО");

    private String value;

    Priority() {
    }

    Priority(String value) {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

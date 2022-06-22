package item

class KeyValueItem {
    private final String key
    private final String value

    KeyValueItem(String key, String value) {
        this.key = key
        this.value = value
    }

    String getKey() {
        return key
    }

    String getValue() {
        return value
    }
}

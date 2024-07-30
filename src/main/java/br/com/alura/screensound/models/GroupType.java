package br.com.alura.screensound.models;

public enum GroupType {
    BAND("Band"),
    SINGER("Singer"),
    PAIR("Pair");

    private final String GROUP_TYPE;

    GroupType (String groupType) {
        this.GROUP_TYPE = groupType;
    }

    public static GroupType fromString(String text) {
        for (GroupType groupType : GroupType.values()) {
            if (groupType.GROUP_TYPE.equalsIgnoreCase(text)) {
                return groupType;
            }
        }
        throw new IllegalArgumentException("No Group Type found for the provided text: " + text);
    }
}

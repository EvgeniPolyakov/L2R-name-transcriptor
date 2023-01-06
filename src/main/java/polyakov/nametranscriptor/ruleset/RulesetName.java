package polyakov.nametranscriptor.ruleset;

public enum RulesetName {
    ALBANIAN("Albanian"),
    ARMENIAN("Armenian"),
    BRAZILIAN("Brazilian"),
    BULGARIAN("Bulgarian"),
    CHINESE("Chinese"),
    CZECH("Czech"),
    ESTONIAN("Estonian"),
    FRENCH("French"),
    GEORGIAN("Georgian"),
    GERMAN("German"),
    GREEK("Greek"),
    JAPANESE("Japanese"),
    KAZAKH("Kazakh"),
    LATVIAN("Latvian"),
    LITHUANIAN("Lithuanian"),
    MACEDONIAN("Macedonian"),
    MOLDOVAN("Moldovan"),
    PORTUGUESE("Portuguese"),
    ROMANIAN("Romanian"),
    RUSSIAN("Russian"),
    SERBOCROAT("Serbocroat"),
    SLOVAK("Slovak"),
    TURKISH("Turkish"),
    UKRAINIAN("Ukrainian");

    private final String name;

    RulesetName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

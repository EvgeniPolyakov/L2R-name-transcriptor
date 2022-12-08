package polyakov.nametranscriptor.model;

import polyakov.nametranscriptor.model.rulesets.*;

import java.util.Map;

public class Rulesets {
    private static final Map<String, Ruleset> RULES = Map.ofEntries(
//            Map.entry("Albania", new Albanian()),
//            Map.entry("Andorra", new Catalan()),
            Map.entry("Armenia", new Armenian()),
//            Map.entry("Austria", new German()),
//            Map.entry("Azerbaijan", new Azerbaijan()),
//            Map.entry("Basque", new Basque()),
            Map.entry("Bosnia and Herzegovina", new Serbocroatian()),
            Map.entry("Belarus", new Russian()),
//            Map.entry("Belgium", new Dutch()),
            Map.entry("Bulgaria", new Russian()),
//            Map.entry("Catalan", new Catalan()),
//            Map.entry("China", new Chinese()),
            Map.entry("Croatia", new Serbocroatian()),
//            Map.entry("Czechia", new Czech()),
            Map.entry("Cyprus", new Greek()),
//            Map.entry("Denmark", new Danish()),
//            Map.entry("England", new English()),
//            Map.entry("Estonia", new Estonian()),
//            Map.entry("Faroe Islands", new Faroese()),
//            Map.entry("Finland", new Finnish()),
//            Map.entry("France", new French()),
            Map.entry("Georgia", new Georgian()),
//            Map.entry("Germany", new German()),
//            Map.entry("Gibraltar", new English()),
            Map.entry("Greece", new Greek()),
//            Map.entry("Hungary", new Hungarian()),
//            Map.entry("Iceland", new Icelandic()),
//            Map.entry("Israel", new Israeli()),
//            Map.entry("Italy", new Italian()),
            Map.entry("Kazakhstan", new Kazakh()),
//            Map.entry("Latvia", new Latvian()),
//            Map.entry("Lichtenstein", new German()),
//            Map.entry("Lithuania", new Lithuanian()),
//            Map.entry("Luxembourg", new German()),
//            Map.entry("Malta", new Italian()),
            Map.entry("Moldova", new Moldovan()),
            Map.entry("Montenegro", new Serbocroatian()),
//            Map.entry("Netherlands", new Dutch()),
//            Map.entry("Northern Macedonia", new Macedonian()),
//            Map.entry("Northern Ireland", new Irish()),
//            Map.entry("Norway", new Norwegian()),
//            Map.entry("Poland", new Polish()),
//            Map.entry("Portugal", new Portuguese()),
//            Map.entry("Republic of Ireland", new Irish()),
            Map.entry("Romania", new Romanian()),
            Map.entry("Russia", new Russian()),
//            Map.entry("San Marino", new Italian()),
//            Map.entry("Scotland", new English()),
            Map.entry("Serbia", new Serbocroatian()),
//            Map.entry("Slovakia", new Slovak()),
            Map.entry("Slovenia", new Serbocroatian()),
//            Map.entry("Spain", new Spanish()),
//            Map.entry("Switzerland", new German()),
//            Map.entry("Sweden", new Swedish()),
            Map.entry("Turkey", new Turkish()),
            Map.entry("Ukraine", new Ukrainian())
//            Map.entry("Wales", new Welsh())
    );

    public static Map<String, Ruleset> getRules() {
        return RULES;
    }
}
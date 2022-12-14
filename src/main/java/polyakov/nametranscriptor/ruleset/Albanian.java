package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.AlbanianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Albanian.*;

@Component
public class Albanian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> checkedName = checkPopularNames(name);
        if (checkedName.isPresent()) {
            return checkedName.get();
        }
        name = checkStart(name);
        if (name.contains("ë")) {
            name = checkCasesOfDiaeresisE(name);
        }
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = checkVowels(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return postCheck(name);
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("ç", "ч");
        name = name.replace("ç", "ч");
        name = name.replace("ć", "ч");
        name = name.replace("č", "ч");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("ë", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("l", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("q", "кь");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("š", "ш");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "дз");
        name = name.replace("y", "ю");
        name = name.replace("z", "з");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("dh", "д");
        name = name.replace("th", "т");
        name = name.replace("rr", "рр");
        name = name.replace("sh", "ш");
        name = name.replace("xh", "дж");
        name = name.replace("zh", "ж");
        name = name.replace("gj", "гь");
        name = name.replace("nj", "нь");
        name = name.replace("ja", "ья");
        name = name.replace("je", "ье");
        name = name.replace("jë", "ье");
        name = name.replace("ji", "ьи");
        name = name.replace("jo", "ьо");
        name = name.replace("ju", "ью");
        name = name.replace("jy", "ью");
        return name;
    }

    private static String checkStart(String name) {
        name = name.replace("ll", "л");
        if (name.startsWith("ë")) {
            name = name.replaceFirst("ë", "э");
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jCombination : J_VOWEL_CASES.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
        }
        for (Map.Entry<String, String> jCombination : J_VOWEL_CASES.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
            }
        }
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "e", vowel + "э");
            name = name.replace(vowel + "ë", vowel + "э");
        }
        for (Map.Entry<String, String> cons : SOFT_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> vowel : SOFTENED_VOWELS.entrySet()) {
                name = name.replace(cons.getKey() + vowel.getKey(), cons.getValue() + vowel.getValue());
            }
        }
        return name;
    }

    private static String checkCasesOfDiaeresisE(String name) {
        for (Map.Entry<String, String> consonant : SOFT_CONSONANTS.entrySet()) {
            if (name.endsWith(consonant.getKey() + "ë")) {
                String sub = name.substring(0, name.length() - consonant.getKey().length() - 1);
                return sub + consonant.getValue() + "я";
            }
        }
        if (name.endsWith("jë")) {
            return name.substring(0, name.length() - 2) + "я";
        }
        if (name.endsWith("ë")) {
            return name.substring(0, name.length() - 1) + "а";
        }
        return name;
    }

    private static String postCheck(String name) {
        if (name.endsWith("кь")) {
            return name.replace("кь", "ч");
        }
        name = name.replaceFirst("льь", "ль");
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(AlbanianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(AlbanianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.ALBANIAN.getName();
    }
}
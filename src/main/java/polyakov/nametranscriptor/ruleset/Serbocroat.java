package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.BalkanNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Serbian.*;

@Component
public class Serbocroat implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = name.replace("đ", "dj");
        if (name.contains("j")) {
            name = checkCombinations(name);
        }
        name = checkStart(name);
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ć", "ч");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("l", "л");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("š", "ш");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("y", "ы");
        name = name.replace("x", "кс");
        name = name.replace("z", "з");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkCombinations(String name) {
        for (Map.Entry<String, String> uc : UTILITY_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> vowel : VOWELS_FOR_UTILITY_CONSONANTS.entrySet()) {
                name = name.replace(uc.getKey() + vowel.getKey(), uc.getValue() + vowel.getValue());
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> c : J_CASES_AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + c.getKey(), vowel + c.getValue());
            }
            name = name.replace(vowel + "e", vowel + "э");
        }
        for (Map.Entry<String, String> jfc : J_FIRST_CASE.entrySet()) {
            if (name.startsWith(jfc.getKey())) {
                name = name.replaceFirst(jfc.getKey(), jfc.getValue());
                break;
            }
        }
        for (Map.Entry<String, String> jcac : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(jcac.getKey(), jcac.getValue());
        }
        name = name.replace("nj", "нь");
        name = name.replace("lj", "ль");
        return name;
    }

    private static String checkStart(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(BalkanNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(BalkanNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.SERBOCROAT.getName();
    }
}
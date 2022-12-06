package polyakov.nametranscriptor.model.rulesets;

import polyakov.nametranscriptor.model.rulesets.names.MoldovanNames;
import polyakov.nametranscriptor.model.rulesets.names.RussianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.model.rulesets.custom.Moldovan.PRIMARY_ENDINGS;
import static polyakov.nametranscriptor.model.rulesets.custom.Moldovan.SECONDARY_ENDINGS;

public class Moldovan extends Romanian {

    @Override
    protected String checkCustomCases(String name) {
        Optional<String> rn = checkRussianNames(name);
        if (rn.isPresent()) {
            name = rn.get();
        }
        Optional<String> mn = checkMoldovanNames(name);
        if (mn.isPresent()) {
            name = mn.get();
        }
        for (Map.Entry<String, String> i : PRIMARY_ENDINGS.entrySet()) {
            if (name.endsWith(i.getKey())) {
                name = name.replace(i.getKey(), i.getValue());
            }
        }
        for (Map.Entry<String, String> i : SECONDARY_ENDINGS.entrySet()) {
            if (name.endsWith(i.getKey())) {
                name = name.replace(i.getKey(), i.getValue());
            }
        }
        name = name.replace("şciu", "щу");
        name = name.replace("şcia", "ща");
        name = name.replace("şc", "щ");
        return super.checkCustomCases(name);
    }

    private Optional<String> checkRussianNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equalsIgnoreCase(name))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    private Optional<String> checkMoldovanNames(String name) {
        return Arrays.stream(MoldovanNames.values())
                .filter(s -> s.getLatinName().equalsIgnoreCase(name))
                .findAny()
                .map(MoldovanNames::getCyrillicName);
    }
}

package variable

import item.Check
import item.KeyValueItem
import item.Setting
import item.work.VariableWork

import java.util.regex.Pattern

class BooleanP extends Setting implements Check, VariableWork {
    private static final SPECIFIED = "ㅇㅂㅇ"
    private static final String patternText = "(\\n|^)\\s*ㅇㅂㅇ\\s"
    private final Pattern pattern = Pattern.compile(patternText)

    @Override
    boolean check(String line) throws Exception {
        return pattern.matcher(line).find()
    }

    @Override
    void start(String line) throws Exception {
        KeyValueItem keyValue = setKeyValue(SPECIFIED, line);
        String key = keyValue.getKey();
        String value = keyValue.getValue();
        value = value.replace("ㅇㅇ", "true");
        value = value.replace("ㄴㄴ", "false");
        value = value.replace(" ", "");
        BM.put(key, changeBool(value));
        set.add(key);
    }
}

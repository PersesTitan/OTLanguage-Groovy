package variable

import item.Check
import item.KeyValueItem
import item.Setting
import item.work.VariableWork

import java.util.regex.Pattern

class LongP extends Setting implements Check, VariableWork {
    public static final String SPECIFIED = "ㅇㅉㅇ"
    public static final String patternText = "(\\n|^)\\s*ㅇㅉㅇ\\s"
    private final Pattern pattern = Pattern.compile patternText

    @Override
    boolean check(String line) {
        return pattern.matcher(line).find()
    }

    @Override
    void start(String line) throws Exception {
        KeyValueItem keyValue = setKeyValue SPECIFIED, line
        String key = keyValue.getKey()
        String value = keyValue.getValue()
        if (!varCheck.check(line, VarType.Long)) throw new Exception(typeErrorMessage)
        LM.put key, Long.valueOf(value)
        set.add key
    }
}

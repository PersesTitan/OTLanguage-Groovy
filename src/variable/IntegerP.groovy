package variable

import item.Check
import item.KeyValueItem
import item.Setting
import item.work.VariableWork

import java.util.regex.Pattern

class IntegerP extends Setting implements Check, VariableWork {
    public static final String SPECIFIED = "ㅇㅈㅇ"
    public static final String patternText = "(\\n|^)\\s*ㅇㅈㅇ\\s"
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
        if (!varCheck.check(line, VarType.Integer)) throw new Exception(typeErrorMessage)
        IM.put key, Integer.valueOf(value)
        set.add key
    }
}

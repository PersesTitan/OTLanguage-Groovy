package variable

import item.Check
import item.KeyValueItem
import item.Setting
import item.work.VariableWork

import java.util.regex.Pattern

class StringP extends Setting implements Check, VariableWork {
    public static final String SPECIFIED = "ㅇㅁㅇ"
    public static final String patternText = "(\\n|^)\\s*ㅇㅁㅇ\\s"
    private final Pattern pattern = Pattern.compile patternText

    @Override
    boolean check(String line) {
        return pattern.matcher(line).find()
    }

    /**
     * @param line 라인 값 받아 오기
     * @throws Exception 변수를 찾을 수 없을 시 에러 발생
     */
    @Override
    void start(String line) throws Exception {
        KeyValueItem keyValue = setKeyValue SPECIFIED, line
        String key = keyValue.getKey()
        String value = keyValue.getValue()
        SM.put key, value
        set.add key
    }
}

package item.etc

import item.Check
import item.Setting

import java.util.regex.Pattern

class TryCatch extends Setting implements Check {
    private static final String SPECIFIED = "ㅜㅅㅜ"
    private final String PATTERN = "\\n\\s*ㅜㅅㅜ\\s|^\\s*ㅜㅅㅜ\\s"
    private final Pattern pattern = Pattern.compile(PATTERN)

    @Override
    boolean check(String line) throws Exception {
        return pattern.matcher(line).find()
    }

    void start(String line) {
        int position = line.indexOf(SPECIFIED) + SPECIFIED.length()
        if (line.strip().startsWith(SPECIFIED +" ")) position += 1
        line = line.substring(position)
        try {
            super.start(line)
        } catch (Exception ignored) {}
    }
}

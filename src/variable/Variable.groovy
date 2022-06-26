package variable

import item.Check
import item.Setting

import java.util.regex.Matcher
import java.util.regex.Pattern

class Variable extends Setting implements Check {
    private final String text = ":\\S+ ";
    private final Pattern pattern = Pattern.compile(text);

    String getVar(String line) {
        Matcher m = pattern.matcher(line);
        while(m.find()) {
            String origin = m.group();
            String key = origin.strip().substring(1);
            if (set.contains(key))
                line = line.replaceFirst(origin, checkValue(key));
        }
        return line;
    }

    @Override
    boolean check(String line) {
        if (line == null || line.isEmpty()) return false;
        boolean bool = pattern.matcher(line).find();

        var lines = line.split(" ");
        return bool || Arrays.stream(lines)
                .filter(v -> !v.isEmpty())
                .filter(v -> v.startsWith(":"))
                .anyMatch(v -> set.contains(v.substring(1)));
    }
}

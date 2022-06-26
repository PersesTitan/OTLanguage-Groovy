package loop

import item.Check
import item.Setting

import java.util.regex.Matcher
import java.util.regex.Pattern

class Bracket extends Setting implements Check {

    private final static char left = '{'
    private final static char right = '}'

    //괄호가 존재하면 아이디로 대체
    String bracket(String total) throws Exception {
        stack.clear()

        total = deleteEnter(total)

        for (int i = 0; i < total.length(); i++) {
            if (total.charAt(i) == left) {
                stack.add(i);
            }

            if (total.charAt(i) == right) {
                if (stack.empty()) throw new Exception("괄호 짝이 맞지 않습니다.")
                String uuid = UUID.randomUUID().toString()
                int start = stack.pop()
                String bl = total.substring start, i+1

                total = total.replace bl, " ${uuid.concat("\n")}"
                i = start + uuid.length()
                uuidMap.put uuid, bl
            }
        }
        return total
    }

    private String deleteEnter(String total) {
        total = setMatcher(total, For.patternText)
        total = setMatcher(total, If.patternText)
        return total
    }

    private static String setMatcher(String total, String text) {
        String patternText = "${text}\\s*\\n+\\s*\\${left}"
        Pattern pattern = Pattern.compile patternText
        Matcher matcher = pattern.matcher total

        //?ㅅ?
        Pattern p = Pattern.compile(text)
        while (matcher.find()) {
            String group = matcher.group()
            Matcher m = p.matcher group
            if (m.find()) total = total.replace group, m.group().strip().concat(Character.toString(left))
        }

        return total
    }

    @Override
    boolean check(String line) throws Exception {
        if (uuidMap.isEmpty()) return false
        return uuidMap.entrySet()
                .stream()
                .anyMatch(v -> line.contains(v.getKey()))
    }
}

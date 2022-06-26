package item

class Setting implements ActivityItem {
    public final static StringBuffer total = new StringBuffer()
    public final static Stack<Integer> stack = new Stack<>()
    public final static Map<String, String> uuidMap = new HashMap<>()
    public final static Map<Integer, String> idLine = new HashMap<>()
    /*===========================================*/
    public final static Set<String> set = new HashSet<>()
    public final static Map<String, Integer> IM = new HashMap<>()
    public final static Map<String, Long> LM = new HashMap<>()
    public final static Map<String, Boolean> BM = new HashMap<>()
    public final static Map<String, String> SM = new HashMap<>()
    public final static Map<String, Character> CM = new HashMap<>()
    public final static Map<String, Float> FM = new HashMap<>()
    public final static Map<String, Double> DM = new HashMap<>()
    /*===========================================*/
    public final static Map<String, String> IFM = new HashMap<>()
    public final static Map<String, String> FORM = new HashMap<>()

    static KeyValueItem setKeyValue(String SPECIFIED, String line) throws Exception {
        int start = line.indexOf(SPECIFIED) + SPECIFIED.length()
        if (line.substring(start).isBlank()) throw new Exception("초기값이 존재 하지 않습니다.")
        int end = line.indexOf(":")
        String key = line.substring(start, end).strip()
        if (set.contains(key)) throw new Exception("이미 존재하는 변수 이름 입니다.")
        String value = line.substring(end+1)
        value = scannerP.start(value)
        return new KeyValueItem(key, value)
    }

    void start(String line) throws Exception {
        if (!line.isBlank()) {
            if (tryCatch.check line) tryCatch.start line
            else if (tryCatchPrint.check line) tryCatchPrint.start(line)
            else {
                if (variable.check line) line = variable.getVar line
                if (scannerP.check line) line = scannerP.start line

                if (print.check line) print.start line
                else if (println.check line) println.start line
                else if (booleanP.check line) booleanP.start line
                else if (characterP.check line) characterP.start line
                else if (doubleP.check line) doubleP.start line
                else if (floatP.check line) floatP.start line
                else if (integerP.check line) integerP.start line
                else if (longP.check line) longP.start line
                else if (stringP.check line) stringP.start line
            }
        }
    }

}

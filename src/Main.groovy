import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.filechooser.FileNameExtensionFilter
import java.nio.charset.StandardCharsets

class Main {
    static void main(String[] args) {
        new Main(args)
    }

    private Main(String[] args) throws Exception {
        String path = args.length <= 0 ? showGUI() : args[0]
        if (!new File(path).canRead()) throw new Exception("파일을 읽을 수 없습니다.")
        if (!path.toLowerCase(Locale.ROOT).endsWith(".otl")) throw new Exception("확장자를 확인해주세요.")
        int count = 0
        varClear()
        String text
        System.out.println("================출력================")
        try (BufferedReader reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            while ((text = reader.readLine()) != null) {
                idLine.put count, text
                total.append text
                start text
                count++
            }
        }
        pause()
    }

    private static String showGUI() throws Exception {
        final JFrame frame = new JFrame()
        final String[] extensions = {"otl"}
        final JFileChooser chooser = new JFileChooser()
        final FileNameExtensionFilter filter = new FileNameExtensionFilter(".otl", extensions)

        frame.setDefaultCloseOperation JFrame.DISPOSE_ON_CLOSE
        chooser.setFileFilter filter
        int open = chooser.showOpenDialog frame.getParent()
        if (open == JFileChooser.OPEN_DIALOG)
            return chooser.getSelectedFile().getPath()
        else throw new Exception("파일이 존재하지 않습니다.")
    }

}

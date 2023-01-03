import javax.swing.*;
import java.awt.*;
import java.io.File;

public class App {
    public static void main(String[] args) {
        // Create the GUI Window
        JFrame frame = new JFrame("Add Custom Font");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Area of text to type in
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(550, 550));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Dialog", Font.BOLD, 48));

        // Adding Custom Font
//        try{
//            File customFontFile = getFontFile("resources/LEMONMILK-Light.otf");
//
//            // Create custom font
//            Font customFont = Font.createFont(Font.TRUETYPE_FONT,
//                    customFontFile).deriveFont(48f);
//            textArea.setFont(customFont);
//        }catch(Exception e){
//            System.out.println("Error: " + e);
//        }

        frame.getContentPane().add(textArea);
        frame.setVisible(true);
    }

    public static File getFontFile(String resource){
        String filePath = App.class.getResource(resource).getPath();

        // check to see if filepath contains any folder with spaces in the name
        if(filePath.contains("%20")){
            filePath = App.class.getResource(resource).getPath()
                    .replaceAll("%20", " ");
        }

        return new File(filePath);
    }
}

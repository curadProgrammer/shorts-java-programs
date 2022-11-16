import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImgButton {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Button Image");
        jFrame.setLayout(new BorderLayout());
        jFrame.setPreferredSize(
                new Dimension(400, 400));
        jFrame.pack();
        jFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        jFrame.add(createImageButton("button.png"));
        jFrame.setVisible(true);
    }

    public static JButton createImageButton
            (String resource){
        JButton button = new JButton();
        try{
            Image image = ImageIO.read(new File(resource));
            button.setIcon(new ImageIcon(image));
            return button;
        }catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }
}

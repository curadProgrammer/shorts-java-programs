import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class App {
    public static void main(String[] args) {
        // GUI Config
        JFrame frame = new JFrame("Mouse Listening");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setLayout(null);

        // GUI Components
        JLabel mouseLocationLabel = new JLabel("X:0 \t Y:0");
        mouseLocationLabel.setBounds(225, 400, 100, 10);

        // Adding Mouse Listener (Updating Label)
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseLocationLabel.setText("X: " + e.getX()
                + "\tY: " + e.getY());
                frame.repaint();
                frame.revalidate();
            }
        });

        frame.add(mouseLocationLabel);
        frame.setVisible(true);
    }
}

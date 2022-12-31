import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class App {
    // value to countdown from
    public static final int COUNTDOWN_TIME = 5;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Happy new Years!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setLayout(null);

        // Countdown Label
        JLabel countdownLabel = new JLabel(Integer.toString(COUNTDOWN_TIME));
        countdownLabel.setFont(new Font("Dialog", Font.BOLD, 128));
        countdownLabel.setBounds(
                (frame.getPreferredSize().width - countdownLabel.getPreferredSize().width)/2,
                (frame.getPreferredSize().height - countdownLabel.getPreferredSize().height)/2,
                100,
                100
        );
        frame.getContentPane().add(countdownLabel);

        // New Years Gif
        JLabel newYearsGif = loadGif("resources/newyears.gif");
        newYearsGif.setBounds(0, 25, 575, 400);
        newYearsGif.setVisible(false);
        frame.getContentPane().add(newYearsGif);

        // Countdown Button
        JButton countdownButton = new JButton("Start Countdown!");
        countdownButton.setBounds(
                (frame.getPreferredSize().width - countdownButton.getPreferredSize().width)/2,
                (frame.getPreferredSize().height -150),
                countdownButton.getPreferredSize().width,
                50
        );
        countdownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newYearsGif.setVisible(false);
                countdownButton.setEnabled(false);
                countdownLabel.setVisible(true);
                countdownLabel.setText(Integer.toString(COUNTDOWN_TIME));

                // start thread
                long startTime = System.currentTimeMillis();
                Thread countdownThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis();
                        try{
                            int time = COUNTDOWN_TIME;
                            while((endTime - startTime)/1000F < COUNTDOWN_TIME){
                                // sleep for 1 second
                                Thread.sleep(1000);

                                // update gui
                                countdownLabel.setText(Integer.toString(--time));

                                // update endTime
                                endTime = System.currentTimeMillis();
                            }
                            countdownLabel.setVisible(false);
                            countdownButton.setEnabled(true);

                            // display animated gif
                            newYearsGif.setVisible(true);
                        }catch(InterruptedException e){
                            System.out.println("Thread Error: " + e);
                        }
                    }
                });
                countdownThread.start();
            }
        });
        frame.getContentPane().add(countdownButton);
        frame.setVisible(true);
    }

    public static JLabel loadGif(String resource){
        URL url = App.class.getResource(resource);
        ImageIcon icon = new ImageIcon(url);
        return new JLabel(icon);
    }
}







































































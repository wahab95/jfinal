package exe;
import javax.swing.*;


public class Frame extends JFrame {
    public Frame() {
        setTitle("Abdulwahhab Ahmad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel with rotating arcs
        add(new Panel());
        //add(new P2());

        setSize(600, 600);
        setUndecorated(false);  // Remove window decorations
        setLocationRelativeTo(null);
        //setOpacity(0.3f);  // Set transparency level (0.0f for fully transparent, 1.0f for opaque)
        
        setVisible(true);
    }
}

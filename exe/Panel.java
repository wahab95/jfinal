package exe;

/**
 * This class creates a custom panel that displays two rotating arcs,
 * one red and one blue, with smooth animation and dynamic positioning.
 * The arcs gradually rotate around a central point, creating a visually
 * appealing effect
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

// Class representing a custom panel that displays two rotating arcs
public class Panel extends JPanel {

    // Instance variables:
    // - arcAngle: Stores the current rotation angle of the arcs (initially 180 degrees)
    // - hints: RenderingHints object for enabling antialiasing (smoother visual appearance)
    private int arcAngle = 180;
    private final RenderingHints hints = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

    // Constructor:
    // - Initializes the timer for animation with a 20 ms delay
    // - Sets the background color to dark gray
    public Panel() {
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Increment the arc angle for rotation
                arcAngle += 2;
                // Trigger a repaint for visual update
                repaint();
            }
        });
        timer.start();
        setBackground(new Color(54, 54, 54));
    }

    // Override the update method to ensure proper repainting based on component size changes
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    // Override the paintComponent method to perform custom drawing
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call parent's method first for basic panel features
        Graphics2D g2d = (Graphics2D) g; // Cast to Graphics2D for advanced drawing features
        g2d.setRenderingHints(hints); // Apply antialiasing for smoother lines and curves

        // Calculate the center coordinates based on the current panel size for dynamic positioning
        int centerX = (getWidth() / 2) - 100; // Divide panel width by 2, offset by 100 for arc positioning
        int centerY = (getHeight() / 2) - 100; // Divide panel height by 2, offset by 100 for arc positioning

        // Draw the arcs with calculated center coordinates and dynamic rotation angles
        // - Red arc on the left, rotated 180 degrees less than the current angle
        g2d.setColor(Color.RED);
        g2d.fillArc(centerX - 100, centerY - 100, 200, 200, arcAngle - 180, 320); // 320 is the arc span angle (full circle)
        // - Blue arc on the right, rotated to the current angle
        g2d.setColor(Color.BLUE);
        g2d.fillArc(centerX + 100, centerY - 100, 200, 200, arcAngle, 320);
    }
}

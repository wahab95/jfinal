package exe;

import java.awt.*;
import java.awt.geom.*;


import javax.swing.JPanel;

public class P2 extends JPanel {
//this is 

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        float[] d={20f,45f};
        float p =0;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        Stroke s =g2.getStroke();
        Stroke s1 = new BasicStroke(6, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,d,p);
        g2.setStroke(s1);
        Ellipse2D e = new Ellipse2D.Double(200, 200 , 200, 200);
        g2.draw(e);
        g2.setStroke(s);
        
    }
    
}

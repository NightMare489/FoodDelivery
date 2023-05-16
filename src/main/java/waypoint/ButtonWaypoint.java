package waypoint;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonWaypoint extends JButton {

    public ButtonWaypoint() {
        setSelected(false);
        setContentAreaFilled(false);
        setIcon(new ImageIcon(getClass().getResource("pin.png")));
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        setSize(new Dimension(24, 24));
    }
}

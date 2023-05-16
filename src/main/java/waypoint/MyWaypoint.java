package waypoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class MyWaypoint extends DefaultWaypoint {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public MyWaypoint(GeoPosition coord) {
        super(coord);
        initButton();
    }

    public MyWaypoint() {
    }

    private String name;
    private JButton button;

    private void initButton() {
        button = new ButtonWaypoint();
    }
}

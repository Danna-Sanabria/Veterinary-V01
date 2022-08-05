package view.panels;

import javax.swing.*;
import java.awt.*;

public class JPanelMain extends JPanel {

    public JPanelMain(JPanelCardLayout jPanelCardLayout, JPanelMenu jPanelMenu, JPanelFooter jPanelFooter) {
        BorderLayout borderLayout = new BorderLayout(5, 5);
        this.setLayout(borderLayout);
        this.add(jPanelMenu, BorderLayout.NORTH);
        this.add(jPanelFooter, BorderLayout.SOUTH);
        this.add(jPanelCardLayout, BorderLayout.CENTER);
    }
}

package view.panels;

import javax.swing.*;
import java.awt.*;

public class JPanelFooter extends JPanel {

    private static final String ROUTE_IMG_BACKGROUND = ".\\resources\\image\\footerPanel.gif";

    public JPanelFooter() {
        this.setPreferredSize(new Dimension(1035, 130));
        this.setBackground(Color.orange);
        repaint();

    }

    @Override
    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(ROUTE_IMG_BACKGROUND);
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}

package view;

import view.panels.JPanelCardLayout;
import view.panels.JPanelFooter;
import view.panels.JPanelMain;
import view.panels.JPanelMenu;

import javax.swing.*;
import java.awt.*;

public class JFrameMedical extends JFrame {
    private static final String VETERINARY = "VETERINARIA";

    public JFrameMedical(JPanelCardLayout jPanelCardLayout, JPanelMenu jPanelMenu, JPanelFooter jPanelFooter) {
        super(VETERINARY);
        this.setSize(1035, 720);
        this.setLocationRelativeTo(null);
        initComponents(jPanelCardLayout, jPanelMenu, jPanelFooter);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponents(JPanelCardLayout jPanelCardLayout, JPanelMenu jPanelMenu, JPanelFooter jPanelFooter) {
        JPanelMain jPanelMain = new JPanelMain(jPanelCardLayout, jPanelMenu, jPanelFooter);
        jPanelMain.setSize(this.getWidth(), this.getHeight());
        this.setContentPane(jPanelMain);
        this.setBackground(Color.white);
    }
}

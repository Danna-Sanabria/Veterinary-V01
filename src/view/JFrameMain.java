package view;

import presenters.JsonConvert;
import presenters.Presenter;
import view.panels.*;
import view.registerPanels.JPanelHomeOptions;
import view.registerPanels.JPanelHomeRegister;

import javax.swing.*;
import java.awt.*;

public class JFrameMain extends JFrame {
    private JPanelMain jPanelMain;
    private JPanelHomeRegister jPanelHomeRegister;
    private JPanelHomeOptions jPanelHomeOptions;
    private CardLayout cardLayout;
    private JPanel panel;

    public JFrameMain(JsonConvert jsonConvert, Presenter presenter) {
        super("INICIO");
        this.setSize(470, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        initComponents(jsonConvert, presenter);
        revalidate();
        repaint();
    }

    public void initComponents(JsonConvert jsonConvert, Presenter presenter) {
        jPanelHomeRegister = new JPanelHomeRegister(this); //CUANDO PREISONA MEDICO
        jPanelHomeOptions = new JPanelHomeOptions(this, presenter);
        addContentToPanel();
    }

    public void addContentToPanel() {
        panel = new JPanel();
        cardLayout = new CardLayout();
        cardLayout.addLayoutComponent(jPanelHomeRegister, "homeRegister");
        cardLayout.addLayoutComponent(jPanelHomeOptions, "mainView");
        panel.add(jPanelHomeOptions);
        panel.add(jPanelHomeRegister);
        panel.setLayout(cardLayout);
        cardLayout.show(panel, "mainView");
        this.setContentPane(panel);
    }

    public void navigateToRegister() {
        cardLayout.show(panel, "register");
    }

    public void navigateToHomeRegister() {
        cardLayout.show(panel, "homeRegister");
    }

    public void navigateToHome() {
        cardLayout.show(panel, "mainView");
    }

}

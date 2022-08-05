package view;

import models.AppointmentManager;
import presenters.JsonConvert;
import presenters.Presenter;
import view.panels.*;
import view.registerPanels.JPanelHomeOptions;
import view.registerPanels.JPanelHomeRegister;

import javax.swing.*;
import java.awt.*;

public class JFrameMain extends JFrame {
    public static final String MESSAGE_INIT = "INICIO";
    private JPanelMain jPanelMain;
    private JPanelHomeRegister jPanelHomeRegister;
    private JPanelHomeOptions jPanelHomeOptions;
    private CardLayout cardLayout;
    private JPanel panel;

    public JFrameMain(Presenter presenter, AppointmentManager appointmentManager) {
        super(MESSAGE_INIT);
        this.setSize(470, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        initComponents(presenter, appointmentManager);
        revalidate();
        repaint();
    }

    public void initComponents(Presenter presenter, AppointmentManager appointmentManager) {
        jPanelHomeRegister = new JPanelHomeRegister(this, appointmentManager );
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

    public void navigateToHomeRegister(String nameDoctor) {
        jPanelHomeRegister.setNameDoctor(nameDoctor);
        cardLayout.show(panel, "homeRegister");
    }

    public void navigateToHome() {
        cardLayout.show(panel, "mainView");
    }

}

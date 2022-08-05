package view.registerPanels;

import com.toedter.calendar.JDateChooser;
import models.AppointmentManager;
import presenters.listeners.HomeRegisterListener;
import view.JFrameMain;

import javax.swing.*;
import java.awt.*;

public class JPanelHomeRegister extends JPanel {

    private HomeRegisterListener homeListener;

    private JButton jButtonObtainSchedule;
    private JButton jButtonScheduleNewAppointment;
    private JButton jButtonBack;
    private JButton jButtonRegister;
    private JDateChooser jDateChooser;
    private JTextField jFielNumberAppointment;
    private JLabel labelInformation;

    public JPanelHomeRegister(JFrameMain jFrameMain, AppointmentManager appointmentManager) {
        setLayout(new GridLayout(10,1));
        homeListener = new HomeRegisterListener(this, jFrameMain, appointmentManager);
        initComponents();
        this.revalidate();
        this.repaint();
    }

    private void initComponents() {

        JLabel jLabelScheduleAppointment = new JLabel("AGENDA");
        jButtonObtainSchedule = new JButton("VER AGENDA");
        jButtonObtainSchedule.addActionListener(homeListener);
        jButtonObtainSchedule.setActionCommand("verAgenda");
        this.add(jButtonObtainSchedule);

        labelInformation = new JLabel();
        this.add(labelInformation);

        JLabel labelSchedule = new JLabel("AGENDE NUEVAS CITAS");
        this.add(labelSchedule);

        jDateChooser = new JDateChooser();
        jDateChooser.setPreferredSize(new Dimension(200, 30));
        this.add(jDateChooser);

        JLabel labelNumber = new JLabel("<html> <center> Indique numero de citas a agendar <html>");
        this.add(labelNumber);

        jFielNumberAppointment = new JTextField();
        jFielNumberAppointment.setPreferredSize(new Dimension(200, 30));
        this.add(jFielNumberAppointment);

        jButtonBack = new JButton("Volver");
        jButtonBack.setBounds(106, 558, 125, 40);
        jButtonBack.setBackground(new Color(49, 153, 139));
        jButtonBack.setFont(new Font("Cambria", 3, 18));
        jButtonBack.setForeground(Color.white);
        jButtonBack.addActionListener(homeListener);
        jButtonBack.setActionCommand("BACK");
        this.add(jButtonBack);

        jButtonRegister = new JButton("Registrar");
        jButtonRegister.setBounds(239, 558, 125, 40);
        jButtonRegister.setBackground(new Color(49, 153, 139));
        jButtonRegister.addActionListener(homeListener);
        jButtonRegister.setActionCommand("REGISTER");
        jButtonRegister.setFont(new Font("Cambria", 3, 18));
        jButtonRegister.setForeground(Color.white);
        this.add(jButtonRegister);
    }

    public JDateChooser getjDateChooser() {
        return jDateChooser;
    }

    public String getjFielNumberAppointment() {
        return jFielNumberAppointment.getText();
    }

    public void setLabelInformation(String text) {
        labelInformation.setText(text);
    }

    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(".\\resources\\image\\fondo.jpg");
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}


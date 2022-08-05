package view.registerPanels;

import com.toedter.calendar.JDateChooser;
import models.AppointmentManager;
import presenters.listeners.HomeRegisterListener;
import view.JFrameMain;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class JPanelHomeRegister extends JPanel {

    private HomeRegisterListener homeListener;
    private JButton jButtonObtainSchedule;
    private JButton jButtonScheduleNewAppointment;
    private JButton jButtonBack;
    private JButton jButtonRegister;
    private JDateChooser jDateChooser;
    private JTextField jFielNumberAppointment;
    private JComboBox<String> jComboBoxHourStart;
    private JLabel labelInformation;
    private String nameDoctor;

    public JPanelHomeRegister(JFrameMain jFrameMain, AppointmentManager appointmentManager) {
        setLayout(new GridLayout(11, 1));
        homeListener = new HomeRegisterListener(this, jFrameMain, appointmentManager);
        initComponents();
        this.revalidate();
        this.repaint();
    }

    private void initComponents() {

        JLabel jLabelScheduleAppointment = new JLabel("INFORMACIÓN AGENDA PROGRAMADA",SwingConstants.CENTER);
        jLabelScheduleAppointment.setFont(new Font("Cambria", 1, 15));
        jLabelScheduleAppointment.setForeground(new Color(220, 67, 134));
        this.add(jLabelScheduleAppointment);

        jButtonObtainSchedule = new JButton("VER AGENDA");
        jButtonObtainSchedule.addActionListener(homeListener);
        jButtonObtainSchedule.setActionCommand("verAgenda");
        jButtonObtainSchedule.setBackground(new Color(49, 153, 139));
        jButtonObtainSchedule.setFont(new Font("Cambria", 3, 18));
        jButtonObtainSchedule.setForeground(Color.white);
        this.add(jButtonObtainSchedule);

        labelInformation = new JLabel();
        labelInformation.setFont(new Font("Cambria", 1, 15));
        labelInformation.setForeground(new Color(220, 67, 134));
        this.add(labelInformation);

        JLabel labelSchedule = new JLabel("AGENDE NUEVAS CITAS",SwingConstants.CENTER);
        labelSchedule.setFont(new Font("Cambria", 1, 15));
        labelSchedule.setForeground(new Color(220, 67, 134));
        this.add(labelSchedule);

        jDateChooser = new JDateChooser();
        jDateChooser.setPreferredSize(new Dimension(200, 30));
        this.add(jDateChooser);

        JLabel jLabelHourStar = new JLabel("<html> <center> SE<<LECCIONE LA HORA A PARTIR DE LA CUAL DESEA AGENDAR CITAS <html>",SwingConstants.CENTER);
        jLabelHourStar.setFont(new Font("Cambria", 1, 15));
        jLabelHourStar.setForeground(new Color(220, 67, 134));
        this.add(jLabelHourStar);

        jComboBoxHourStart = new JComboBox<>(new String[]{"8", "9", "10", "11", "12", "14", "15", "16"});
        this.add(jComboBoxHourStart);

        JLabel labelNumber = new JLabel("<html> <center>INDIQUE NÚMERO DE CITAS<html>",SwingConstants.CENTER);
        labelNumber.setFont(new Font("Cambria", 1, 15));
        labelNumber.setForeground(new Color(220, 67, 134));
        this.add(labelNumber);

        jFielNumberAppointment = new JTextField();
        jFielNumberAppointment.setPreferredSize(new Dimension(200, 30));
        this.add(jFielNumberAppointment);

        jButtonRegister = new JButton("AGENDAR");
        jButtonRegister.setBounds(239, 558, 125, 40);
        jButtonRegister.setBackground(new Color(49, 153, 139));
        jButtonRegister.addActionListener(homeListener);
        jButtonRegister.setActionCommand("agendar");
        jButtonRegister.setFont(new Font("Cambria", 3, 18));
        jButtonRegister.setForeground(Color.white);
        this.add(jButtonRegister);

        jButtonBack = new JButton("VOLVER");
        jButtonBack.setBounds(106, 558, 125, 40);
        jButtonBack.setBackground(new Color(49, 153, 139));
        jButtonBack.setFont(new Font("Cambria", 3, 18));
        jButtonBack.setForeground(Color.white);
        jButtonBack.addActionListener(homeListener);
        jButtonBack.setActionCommand("BACK");
        this.add(jButtonBack);
    }

    public Date getjDateChooser() {
        return jDateChooser.getDate();
    }

    public int getjFielNumberAppointment() {
        return Integer.parseInt(jFielNumberAppointment.getText());
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setLabelInformation(String text) {
        labelInformation.setText(text);
    }

    public int getjComboBoxHourStart() {
        return Integer.parseInt(String.valueOf(jComboBoxHourStart.getSelectedItem()));
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }


    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(".\\resources\\image\\fondo.jpg");
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}


package view.panels;

import models.AppointmentManager;
import presenters.JsonConvert;
import presenters.listeners.ConsultAppointmentListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPanelSearchAppointment extends JPanel {
    private AppointmentManager appointmentManager;
    private ConsultAppointmentListener listener;
    private JTextArea jTextAreaInformation;
    private JTextField jTextFieldId;


    public JPanelSearchAppointment(AppointmentManager appointmentManager) {
        this.appointmentManager = appointmentManager;
        listener = new ConsultAppointmentListener(this,appointmentManager);
        initComponents();
    }

    public void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel jLabelInfo = new JLabel();
        setUIComponentesLabel(jLabelInfo,"Ingrese N° de identificación");
        jLabelInfo.setForeground(new Color(253, 130, 177));
        jLabelInfo.setFont(new Font("Cambria", 1, 20));
        this.add(jLabelInfo);

        jTextFieldId = new JTextField();
        jTextFieldId.addActionListener(listener);
        jTextFieldId.setActionCommand("verificar");
        this.add(jTextFieldId);

        JButton jButtonConsult = new JButton();
        setUIComponentsJButton(jButtonConsult, "CONSULTAR", "CONSULT");
        this.add(jButtonConsult);

        jTextAreaInformation = new JTextArea();
        Font font = new Font("Cambria", 12, 18);
        jTextAreaInformation.setFont(font);
        jTextAreaInformation.setPreferredSize(new Dimension(280, 210));
        jTextAreaInformation.setOpaque(false);
        jTextAreaInformation.setLineWrap(true);
        jTextAreaInformation.setEditable(false);
        jTextAreaInformation.setAlignmentX(CENTER_ALIGNMENT);
        this.add(jTextAreaInformation);
    }

    public void setUIComponentsJButton(JButton buton, String text, String command) {
        buton.setText(text);
        buton.setBackground(new Color(220, 67, 134));
        buton.setForeground(Color.WHITE);
        buton.setBorderPainted(false);
        buton.setFont(new Font("Cambria", 0, 12));
        buton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buton.addActionListener(listener);
        buton.setActionCommand(command);
        this.add(buton);
    }

    public void setUIComponentesLabel(JLabel label, String text) {
        label.setText(text);
        label.setFont(new Font("Cambria", 1, 15));
        label.setForeground(Color.black);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setPreferredSize(new Dimension(220, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);
    }

    public void setjTextAreaInformation(String textInformation) {
        jTextAreaInformation.setText( textInformation);
    }

    public String getjTextFieldId() {
        return jTextFieldId.getText();
    }
}

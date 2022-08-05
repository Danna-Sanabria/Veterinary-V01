package view.panels;

import models.AppointmentManager;
import presenters.listeners.CancelListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelCancelAppointment extends JPanel {

    private AppointmentManager appointmentManager;
    private CancelListener listener;
    private JLabel jLabelCalendar;
    private JLabel jLabelFind;
    private JLabel jLabelHour;
    private JLabel jLabelDate;
    private JLabel jLabelInfo;
    private JComboBox<String> jComboBoxHour;
    private JButton jButtonCancel;
    private JTextField jTextFieldId;
    private JComboBox<String> jcomboBoxTypeModality;
    
    public JPanelCancelAppointment(AppointmentManager appointmentManager) {
        this.appointmentManager = appointmentManager;
        listener = new CancelListener(this,appointmentManager);
        initComponents(appointmentManager);
    }

    private void initComponents(AppointmentManager appointmentManager) {
        this.setLayout(new GridLayout(12,1));
        this.setSize(1034, 515);
        listener = new CancelListener(this, appointmentManager);

        jLabelCalendar = new JLabel();
        setUIComponentesLabel(jLabelCalendar, "CANCELAR CITA");
        jLabelCalendar.setForeground(new Color(253, 130, 177));
        jLabelCalendar.setFont(new Font("Cambria", 1, 20));

        jLabelInfo = new JLabel();
        setUIComponentesLabel(jLabelInfo,"Ingrese N° de identificación");
        jLabelInfo.setForeground(new Color(253, 130, 177));
        jLabelInfo.setFont(new Font("Cambria", 1, 20));

        jTextFieldId = new JTextField();
        jTextFieldId.addActionListener(listener);
        jTextFieldId.setActionCommand("verificar");
        this.add(jTextFieldId);

        jLabelDate = new JLabel();
        setUIComponentesLabel(jLabelDate, "Selecciones modalidad de la cita a cancelar");

        jcomboBoxTypeModality = new JComboBox<>(new String[]{"PRESENCIAL", "DOMICILIO"});
        jcomboBoxTypeModality.setPreferredSize(new Dimension(200, 30));
        jcomboBoxTypeModality.setActionCommand("MODALITY");
        jcomboBoxTypeModality.addActionListener(listener);
        this.add(jcomboBoxTypeModality);

        jLabelHour = new JLabel();
        setUIComponentesLabel(jLabelHour, "Seleccione la cita a cancelar");

        jComboBoxHour = new JComboBox<>();
        jComboBoxHour.setPreferredSize(new Dimension(200, 30));
        this.add(jComboBoxHour);

        jButtonCancel = new JButton();
        setUIComponentsJButton(jButtonCancel, "CANCELAR", "CANCEl");
    }

    public void putList(ArrayList<String> filter) {
        jComboBoxHour.removeAllItems();
        for (String date: filter) {
            jComboBoxHour.addItem(date);
        }
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

    @Override
    public void paint(Graphics g) {
        ImageIcon icon = new ImageIcon(".\\resources\\image\\fondo.jpg");
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    public void messageInformation(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String getjComboBoxHour() {
        return (String)jComboBoxHour.getSelectedItem();
    }

    public String getjTextFieldId() {
        return jTextFieldId.getText();
    }

    public String getTypeModality() {
        return (String) jcomboBoxTypeModality.getSelectedItem();
    }
}
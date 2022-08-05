package view.panels;

import com.toedter.calendar.JDateChooser;
import models.AppointmentManager;
import presenters.JsonConvert;
import presenters.listeners.MedicalAppointmentListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelScheduleAppointment extends JPanel {

    private static final String SCHEDULE_APPOINTMENT = "AGENDA TU CITA";
    private static final String SELEC_DATE = "Seleccione modalidad";
    private static final String SELECT_HOUR = "Citas disponibles:";
    private static final String ROUTE_BACKGROUND = ".\\resources\\image\\fondo.jpg";
    private static final String AGENDAR_CITA = "       AGENDAR CITA         ";
    private static final String SCHEDULE = "AGENDAR";
    private MedicalAppointmentListener medicalAppointmentListener;
    private Color color;
    private JLabel jLabelCalendar;
    private JLabel jLabelFind;
    private JLabel jLabelHour;
    private JLabel jLabelDate;
    private JLabel jLabelInfo;
    private JDateChooser jDateChooser;
    private JComboBox<String> jComboBoxHour;
    private JButton jButtonSchedule;
    private JTextField jTextFieldId;
    private JComboBox<String> jcomboBoxTypeModality;

    public JPanelScheduleAppointment(AppointmentManager appointmentManager, JsonConvert jsonConvert) {
        initComponents(appointmentManager, jsonConvert);
        color = new Color(253, 130, 177);
    }

    private void initComponents(AppointmentManager appointmentManager, JsonConvert jsonConvert) {
        this.setLayout(new GridLayout(12,1));
        this.setSize(1034, 515);
        medicalAppointmentListener = new MedicalAppointmentListener(this, appointmentManager, jsonConvert);

        jLabelCalendar = new JLabel();
        setUIComponentesLabel(jLabelCalendar, SCHEDULE_APPOINTMENT);
        jLabelCalendar.setForeground(new Color(253, 130, 177));
        jLabelCalendar.setFont(new Font("Cambria", 1, 20));

        jLabelInfo = new JLabel();
        setUIComponentesLabel(jLabelInfo,"Ingrese N° de identificación");
        jLabelInfo.setForeground(new Color(253, 130, 177));
        jLabelInfo.setFont(new Font("Cambria", 1, 20));

        jTextFieldId = new JTextField();
        jTextFieldId.addActionListener(medicalAppointmentListener);
        jTextFieldId.setActionCommand("verificar");
        this.add(jTextFieldId);

        jLabelDate = new JLabel();
        setUIComponentesLabel(jLabelDate, SELEC_DATE);

        jcomboBoxTypeModality = new JComboBox<>(new String[]{"PRESENCIAL", "DOMICILIO"});
        jcomboBoxTypeModality.setPreferredSize(new Dimension(200, 30));
        jcomboBoxTypeModality.setActionCommand("modality");
        jcomboBoxTypeModality.addActionListener(medicalAppointmentListener);
        this.add(jcomboBoxTypeModality);

        jLabelHour = new JLabel();
        setUIComponentesLabel(jLabelHour, SELECT_HOUR);

        jComboBoxHour = new JComboBox<>();
        jComboBoxHour.setPreferredSize(new Dimension(200, 30));
        this.add(jComboBoxHour);

        jButtonSchedule = new JButton();
        setUIComponentsJButton(jButtonSchedule, AGENDAR_CITA, SCHEDULE);
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
        buton.addActionListener(medicalAppointmentListener);
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
        ImageIcon icon = new ImageIcon(ROUTE_BACKGROUND);
        Image image = new ImageIcon(icon.getImage()).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    public void setjComboBoxHour(String stringOptions) {
        jComboBoxHour.addItem(stringOptions);
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



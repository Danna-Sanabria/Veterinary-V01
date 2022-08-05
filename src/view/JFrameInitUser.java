package view;

import models.AppointmentManager;
import models.MedicalAppointment;
import presenters.JsonConvert;
import presenters.listeners.InitSesionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class JFrameInitUser extends JFrame {

    public static final String ACTION_COMMAND_EXIT = "EXIT";
    public static final String ACTION_COMMAND_REGISTER = "REGISTER";
    public static final String ACTION_COMMAND_VALIDATE_DOCTOR = "VALIDATE_DOCTOR";
    public static final String MESSAGE_INPUT_TEXT = "Ingrese nombre del propietario";
    public static final String MESAG_INPUT_INFORMATION = "<html> <center>Ingrese identificación del propietario para ingresar<html>";
    public static final String MESSAGE_INPUT_ID_USER = "<html> <center>Ingrese identificación del propietario<html>";
    public static final String MESSAGE_INPUT_NAME_PET = "Ingrese nombre de la mascota";
    public static final String MESSAGE_INPUT_ID_PET = "Ingrese identificacion de la mascota";
    public static final String MESSAGE_SELECT_TYPE_PET = "Seleccione tipo de mascota";
    public static final String MESSAGE_INPUT_NAME = "<html> <center>Digite nombre para ingresar<html>";
    public static final String MESSAGE_ENTER_PASSWORD = "<html> <center>Ingrese su contraseña <html>";
    public static final String TEXT_BUTTON_EXIT = "SALIR";
    public static final String TEXT_BUTTON_REGISTER = "GUARDAR";
    public static final String TEXT_BUTTON_VALIDATE = "VALIDATE";
    public static final String TEXT_BUTTON_VALIDATE_DOCTOR = "VALIDAR_DOCTOR";
    public static final String[] OPTIONS_PETS = {"Gato", "Perro"};
    public static final String[] OPTIONS_TYPE_APPOINTMENT = {"PRESENCIAL", "DOMICILIO"};
    JTextField jFieldIdUserEnter;
    JTextField jFieldIdUser;
    JTextField jFieldNameUser;
    JTextField jFieldNamePet;
    JTextField jFieldIdPet;
    JComboBox<String> jComboBoxType;
    private MedicalAppointment medicalAppointment;
    private JPanel jPanelEnter;
    private JPanel jPanelRegister;
    private JPanel jPanelEnterDoctor;
    private JTabbedPane jTabbedPane;
    private JTextField jFieldNameDoctor;
    private JTextField jFieldPassword;
    JComboBox<String> jComboBoxModality;

    public JFrameInitUser(AppointmentManager appointmentManager, JsonConvert jsonConvert, JFrameMain jFrameMain) {
        super("lOG IN");
        this.setSize(480, 230);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(appointmentManager, jsonConvert, jFrameMain);
        this.setContentPane(jTabbedPane);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents(AppointmentManager appointmentManager, JsonConvert jsonConvert, JFrameMain jFrameMain) {
        InitSesionListener listener = new InitSesionListener(this, appointmentManager, jsonConvert, jFrameMain);

        jFieldIdUserEnter = new JTextField();
        jFieldIdUser = new JTextField();
        jFieldNameUser = new JTextField();
        jFieldNamePet = new JTextField();
        jFieldIdPet = new JTextField();
        jFieldPassword = new JTextField();
        jFieldNameDoctor = new JTextField();
        JLabel jlabelnameUser = new JLabel(MESSAGE_INPUT_TEXT);
        JLabel jlabelidUserEnter = new JLabel(MESAG_INPUT_INFORMATION);
        JLabel jlabelidUser = new JLabel(MESSAGE_INPUT_ID_USER);
        JLabel jlabelnamePet = new JLabel(MESSAGE_INPUT_NAME_PET);
        JLabel jlabelidPet = new JLabel(MESSAGE_INPUT_ID_PET);
        JLabel jlabelTypePet = new JLabel(MESSAGE_SELECT_TYPE_PET);
        JLabel jlabelnameDoctor = new JLabel(MESSAGE_INPUT_NAME);
        JLabel jlabelPasswordDoctor = new JLabel(MESSAGE_ENTER_PASSWORD);
        JButton jButtonBack = new JButton(TEXT_BUTTON_EXIT);
        JButton jButtonRegister = new JButton(TEXT_BUTTON_REGISTER);
        JButton jButtonBack2 = new JButton(TEXT_BUTTON_EXIT);
        JButton jButtonValidate = new JButton(TEXT_BUTTON_VALIDATE);
        JButton jButtonBack3 = new JButton(TEXT_BUTTON_EXIT);
        JButton jButtonValidateDoctor = new JButton(TEXT_BUTTON_VALIDATE_DOCTOR);
        jComboBoxType = new JComboBox<>(OPTIONS_PETS);
        jComboBoxModality = new JComboBox<>(OPTIONS_TYPE_APPOINTMENT);

        jPanelEnter = new JPanel();
        jPanelEnter.setLayout(new GridLayout(2, 4));
        jPanelEnter.add(jlabelidUserEnter);
        initJfield(jPanelEnter, jFieldIdUserEnter, listener);
        jButtonBack2.addActionListener(listener);
        jPanelEnter.add(jButtonBack2);
        jButtonBack2.setActionCommand(ACTION_COMMAND_EXIT);
        jButtonBack2.setBackground(new Color(220, 67, 134));
        jButtonBack2.setForeground(Color.WHITE);
        jButtonBack2.setBorderPainted(true);
        jButtonBack2.setFont(new Font("Cambria", 0, 12));
        jButtonBack2.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonValidate.addActionListener(listener);

        jButtonValidate.setActionCommand(TEXT_BUTTON_VALIDATE);
        jButtonValidate.setBackground(new Color(220, 67, 134));
        jButtonValidate.setForeground(Color.WHITE);
        jButtonValidate.setBorderPainted(true);
        jButtonValidate.setFont(new Font("Cambria", 0, 12));
        jButtonValidate.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelEnter.add(jButtonValidate);

        jPanelRegister = new JPanel();
        jPanelRegister.setLayout(new GridLayout(6, 2));

        jPanelRegister.add(jlabelnamePet);
        initJfield(jPanelRegister, jFieldNamePet, listener);

        jPanelRegister.add(jlabelidPet);
        initJfield(jPanelRegister, jFieldIdPet, listener);

        jPanelRegister.add(jlabelTypePet);
        jComboBoxType.addActionListener(listener);
        jPanelRegister.add(jComboBoxType);

        jPanelRegister.add(jlabelnameUser);
        initJfield(jPanelRegister, jFieldNameUser, listener);

        jPanelRegister.add(jlabelidUser);
        initJfield(jPanelRegister, jFieldIdUser, listener);

        jButtonBack.addActionListener(listener);
        jButtonBack.setActionCommand(ACTION_COMMAND_EXIT);
        jButtonBack.setBackground(new Color(220, 67, 134));
        jButtonBack.setForeground(Color.WHITE);
        jButtonBack.setBorderPainted(true);
        jButtonBack.setFont(new Font("Cambria", 0, 12));
        jButtonBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelRegister.add(jButtonBack);

        jButtonRegister.setBackground(new Color(220, 67, 134));
        jButtonRegister.setForeground(Color.WHITE);
        jButtonRegister.setBorderPainted(true);
        jButtonRegister.setFont(new Font("Cambria", 0, 12));
        jButtonRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonRegister.addActionListener(listener);
        jButtonRegister.setActionCommand(ACTION_COMMAND_REGISTER);
        jPanelRegister.add(jButtonRegister);

        jPanelEnterDoctor = new JPanel();
        jPanelEnterDoctor.setLayout(new GridLayout(4, 2));

        jPanelEnterDoctor.add(jlabelnameDoctor);
        initJfield(jPanelEnterDoctor, jFieldNameDoctor, listener);

        jPanelEnterDoctor.add(jlabelPasswordDoctor);
        initJfield(jPanelEnterDoctor, jFieldPassword, listener);

        jButtonBack3.addActionListener(listener);
        jPanelEnterDoctor.add(jButtonBack3);
        jButtonBack3.setActionCommand(ACTION_COMMAND_EXIT);
        jButtonBack3.setBackground(new Color(220, 67, 134));
        jButtonBack3.setForeground(Color.WHITE);
        jButtonBack3.setBorderPainted(true);
        jButtonBack3.setFont(new Font("Cambria", 0, 12));
        jButtonBack3.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonValidateDoctor.addActionListener(listener);

        jButtonValidateDoctor.setActionCommand(ACTION_COMMAND_VALIDATE_DOCTOR);
        jButtonValidateDoctor.addActionListener(listener);
        jButtonValidateDoctor.setBackground(new Color(220, 67, 134));
        jButtonValidateDoctor.setForeground(Color.WHITE);
        jButtonValidateDoctor.setBorderPainted(true);
        jButtonValidateDoctor.setFont(new Font("Cambria", 0, 12));
        jButtonValidateDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelEnterDoctor.add(jButtonValidateDoctor);

        jTabbedPane = new JTabbedPane();
    }

    public void initJfield(JPanel jpanel, JTextField jTextField, ActionListener listener) {
        jpanel.add(jTextField);
        jTextField.addActionListener(listener);
        jTextField.setPreferredSize(new Dimension(200, 30));
    }

    public JTextField getjFieldIdUserEnter() {
        return jFieldIdUserEnter;
    }

    public JTextField getjFieldIdUser() {
        return jFieldIdUser;
    }

    public JTextField getjFieldNameUser() {
        return jFieldNameUser;
    }

    public JTextField getjFieldNamePet() {
        return jFieldNamePet;
    }

    public JTextField getjFieldIdPet() {
        return jFieldIdPet;
    }

    public String getjComboBoxType() {
        return (String) jComboBoxType.getSelectedItem();
    }

    public String getjFieldNameDoctor() {
        return jFieldNameDoctor.getText();
    }

    public String getjFieldPassword() {
        return jFieldPassword.getText();
    }

    public JPanel getjPanelEnter() {
        return jPanelEnter;
    }

    public JPanel getjPanelRegister() {
        return jPanelRegister;
    }

    public JPanel getjPanelEnterDoctor() {
        return jPanelEnterDoctor;
    }

    public void setjTabbedPane(String name, JPanel jpanel) {
        jTabbedPane.add(name, jpanel);
    }

    public void messageInformation(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}



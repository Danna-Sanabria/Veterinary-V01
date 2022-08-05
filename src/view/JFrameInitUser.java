package view;

import models.AppointmentManager;
import models.MedicalAppointment;
import presenters.JsonConvert;
import presenters.listeners.InitSesionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class JFrameInitUser extends JFrame {

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
    private JPanel jpanelRegisterDoctor;
    private JTextField jFieldNameDoctor;
    private JTextField jFieldPassword;
    JComboBox<String> jComboBoxModality;

    public JFrameInitUser(AppointmentManager appointmentManager, JsonConvert jsonConvert, JFrameMain jFrameMain) {
        super("lOG IN");
        this.setSize(480,230);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(appointmentManager,jsonConvert, jFrameMain);
        this.setContentPane(jTabbedPane);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents(AppointmentManager appointmentManager, JsonConvert jsonConvert, JFrameMain jFrameMain) {
        InitSesionListener listener = new InitSesionListener(this,appointmentManager,jsonConvert, jFrameMain);

        jFieldIdUserEnter = new JTextField();
        jFieldIdUser = new JTextField();
        jFieldNameUser = new JTextField();
        jFieldNamePet = new JTextField();
        jFieldIdPet = new JTextField();
        jFieldPassword = new JTextField();
        jFieldNameDoctor = new JTextField();
        JLabel jlabelnameUser = new JLabel("Ingrese nombre del propietario");
        JLabel jlabelidUserEnter = new JLabel("<html> <center>Ingrese identificación del propietario para ingresar<html>");
        JLabel jlabelidUser = new JLabel("<html> <center>Ingrese identificación del propietario<html>");
        JLabel jlabelnamePet = new JLabel("Ingrese nombre de la mascota");
        JLabel jlabelidPet = new JLabel("Ingrese identificacion de la mascota");
        JLabel jlabelTypePet = new JLabel("Seleccione tipo de mascota");
        JLabel jlabelnameDoctor = new JLabel("<html> <center>Digite nombre para ingresar<html>");
        JLabel jlabelPasswordDoctor = new JLabel("<html> <center>Ingrese su contraseña <html>");
        JButton jButtonBack = new JButton("SALIR");
        JButton jButtonRegister = new JButton("GUARDAR");
        JButton jButtonBack2 = new JButton("SALIR");
        JButton jButtonValidate = new JButton("VALIDAR");
        JButton jButtonBack3 = new JButton("SALIR");
        JButton jButtonValidateDoctor = new JButton("VALIDAR_DOCTOR");
        jComboBoxType = new JComboBox<>(new String[]{"Gato", "Perro"});
        jComboBoxModality = new JComboBox<>(new String[]{"PRESENCIAL", "DOMICILIO"});

        jPanelEnter = new JPanel();
        jPanelEnter.setLayout(new GridLayout(2,4));
        jPanelEnter.add(jlabelidUserEnter);
        initJfield(jPanelEnter,jFieldIdUserEnter, listener);
        jButtonBack2.addActionListener(listener);
        jPanelEnter.add(jButtonBack2);
        jButtonBack2.setActionCommand("EXIT");
        jButtonBack2.setBackground(new Color(220, 67, 134));
        jButtonBack2.setForeground(Color.WHITE);
        jButtonBack2.setBorderPainted(true);
        jButtonBack2.setFont(new Font("Cambria", 0, 12));
        jButtonBack2.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonValidate.addActionListener(listener);

        jButtonValidate.setActionCommand("validar");
        jButtonValidate.setBackground(new Color(220, 67, 134));
        jButtonValidate.setForeground(Color.WHITE);
        jButtonValidate.setBorderPainted(true);
        jButtonValidate.setFont(new Font("Cambria", 0, 12));
        jButtonValidate.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelEnter.add(jButtonValidate);

        jPanelRegister = new JPanel();
        jPanelRegister.setLayout(new GridLayout(6,2));

        jPanelRegister.add(jlabelnamePet);
        initJfield(jPanelRegister,jFieldNamePet,listener);

        jPanelRegister.add(jlabelidPet);
        initJfield(jPanelRegister,jFieldIdPet,listener);

        jPanelRegister.add(jlabelTypePet);
        jComboBoxType.addActionListener(listener);
        jPanelRegister.add(jComboBoxType);

        jPanelRegister.add(jlabelnameUser);
        initJfield(jPanelRegister,jFieldNameUser,listener);

        jPanelRegister.add(jlabelidUser);
        initJfield(jPanelRegister,jFieldIdUser,listener);

        jButtonBack.addActionListener(listener);
        jButtonBack.setActionCommand("EXIT");
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
        jButtonRegister.setActionCommand("REGISTER");
        jPanelRegister.add(jButtonRegister);

        jPanelEnterDoctor = new JPanel();
        jPanelEnterDoctor.setLayout(new GridLayout(4, 2));

        jPanelEnterDoctor.add(jlabelnameDoctor);
        initJfield(jPanelEnterDoctor, jFieldNameDoctor, listener);

        jPanelEnterDoctor.add(jlabelPasswordDoctor);
        initJfield(jPanelEnterDoctor, jFieldPassword, listener);

        jButtonBack3.addActionListener(listener);
        jPanelEnterDoctor.add(jButtonBack3);
        jButtonBack3.setActionCommand("EXIT");
        jButtonBack3.setBackground(new Color(220, 67, 134));
        jButtonBack3.setForeground(Color.WHITE);
        jButtonBack3.setBorderPainted(true);
        jButtonBack3.setFont(new Font("Cambria", 0, 12));
        jButtonBack3.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtonValidateDoctor.addActionListener(listener);

        jButtonValidateDoctor.setActionCommand("validarDoctor");
        jButtonValidateDoctor.setBackground(new Color(220, 67, 134));
        jButtonValidateDoctor.setForeground(Color.WHITE);
        jButtonValidateDoctor.setBorderPainted(true);
        jButtonValidateDoctor.setFont(new Font("Cambria", 0, 12));
        jButtonValidateDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanelEnterDoctor.add(jButtonValidateDoctor);

        jTabbedPane = new JTabbedPane();
        jTabbedPane.add("INGRESAR" , jPanelEnter);
        jTabbedPane.add("REGISTRARSE",jPanelRegister);
    }

    public void initJfield (JPanel jpanel, JTextField jTextField, ActionListener listener){
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

    public void messageInformation(String message){
        JOptionPane.showMessageDialog(null,message);
    }

}



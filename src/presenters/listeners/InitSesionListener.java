package presenters.listeners;

import models.AppointmentManager;
import presenters.JsonConvert;
import view.JFrameInitUser;
import view.JFrameMain;
import view.JFrameMedical;
import view.panels.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InitSesionListener implements ActionListener {

    private static final String MESSAGE_REGISTER_USER_SUCCESFUL = "USUARIO REGISTRADO CON EXITO";
    private static final String VALIDATE = "VALIDATE";
    private static final String EXIT = "EXIT";
    private static final String REGISTER = "REGISTER";
    private static final String VALIDATE_DOCTOR = "VALIDATE_DOCTOR";
    private JFrameInitUser jFrameInitUser;
    private AppointmentManager appointmentManager;
    private JsonConvert jsonConvert;
    private JFrameMain jFrameMain;
    private String nameUser;

    public InitSesionListener(JFrameInitUser jFrameInitUser, AppointmentManager appointmentManager, JsonConvert jsonConvert, JFrameMain jFrameMain) {
        this.jFrameInitUser = jFrameInitUser;
        this.appointmentManager = appointmentManager;
        this.jsonConvert = jsonConvert;
        this.jFrameMain = jFrameMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case VALIDATE:
                validateUser();
                break;
            case EXIT:
                jFrameInitUser.dispose();
                break;
            case REGISTER:
                registerUser();
                break;
            case VALIDATE_DOCTOR:
                validateDoctor();
                break;
        }
    }

    private void registerUser() {
        try {

            register();
            jFrameInitUser.messageInformation(MESSAGE_REGISTER_USER_SUCCESFUL);
        } catch (Exception ex) {
            jFrameInitUser.messageInformation(ex.getMessage());
        }
    }

    private void validateUser() {
        try {
            if (checkUser()) {
                initPageMedicalAppointment(jsonConvert);
                jFrameInitUser.dispose();
            }
        } catch (Exception ex) {
            jFrameInitUser.messageInformation(ex.getMessage());
        }
    }

    private void validateDoctor() {
        try {
            if (appointmentManager.checkDoctor(jFrameInitUser.getjFieldNameDoctor(), jFrameInitUser.getjFieldPassword())) {
                initFramemedical(jFrameInitUser.getjFieldNameDoctor());
                jFrameInitUser.dispose();
            }
        } catch (Exception ex) {
            jFrameInitUser.messageInformation(ex.getMessage());
        }
    }

    public void initPageMedicalAppointment(JsonConvert jsonConvert) throws IOException {
        JPanelHome jPanelHome = new JPanelHome();
        JPanelScheduleAppointment jPanelScheduleAppointment = new JPanelScheduleAppointment(appointmentManager);
        JPanelSearchAppointment jPanelSearchAppointment = new JPanelSearchAppointment(appointmentManager);
        JPanelCancelAppointment jPanelCancelAppointment = new JPanelCancelAppointment(appointmentManager);
        JPanelCardLayout jPanelCardLayout = new JPanelCardLayout(jPanelHome, jPanelScheduleAppointment, jPanelSearchAppointment, jPanelCancelAppointment);
        JPanelMenu jPanelMenu = new JPanelMenu(jPanelCardLayout);
        JPanelFooter jPanelFooter = new JPanelFooter();
        JFrameMedical jFrameMedical = new JFrameMedical(jPanelCardLayout, jPanelMenu, jPanelFooter);
    }

    public boolean checkUser() throws Exception {
        return appointmentManager.checkUser(jFrameInitUser.getjFieldIdUserEnter().getText());
    }

    public void initFramemedical(String nameDoctor) {
        jFrameMain.navigateToHomeRegister(nameDoctor);
    }

    public void register() {
        String namePet = jFrameInitUser.getjFieldNamePet().getText();
        String idPet = jFrameInitUser.getjFieldIdPet().getText();
        String typePet = jFrameInitUser.getjComboBoxType();
        String nameOwner = jFrameInitUser.getjFieldNameUser().getText();
        String idUser = jFrameInitUser.getjFieldIdUser().getText();
        try {
            appointmentManager.checkPerson(idUser);
            appointmentManager.registerUser(namePet, idPet, typePet, nameOwner, idUser);
        } catch (Exception e) {
            jFrameInitUser.messageInformation(e.getMessage());
        }
    }
}

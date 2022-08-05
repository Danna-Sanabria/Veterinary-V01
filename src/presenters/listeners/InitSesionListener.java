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

    private JFrameInitUser jFrameInitUser;
    private AppointmentManager appointmentManager;
    private JsonConvert jsonConvert;
    private JFrameMain jFrameMain;

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
            case "validar":
                validateUser();
                break;
            case "EXIT":
                jFrameInitUser.dispose();
                break;
            case "REGISTER":
                registerUser();
                break;
            case "validarDoctor":
                validateDoctor();
                break;
        }
    }

    private void registerUser() {
        try {
            register();
            jFrameInitUser.messageInformation("USUARIO REGISTRADO CON EXITO");
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
                initFramemedical();
                jFrameInitUser.dispose();
            }
        } catch (Exception ex) {
            jFrameInitUser.messageInformation(ex.getMessage());
        }
    }

    public void initPageMedicalAppointment(JsonConvert jsonConvert) throws IOException {
        JPanelHome jPanelHome = new JPanelHome();
        JPanelScheduleAppointment jPanelScheduleAppointment = new JPanelScheduleAppointment(appointmentManager, jsonConvert);
        JPanelSearchAppointment jPanelSearchAppointment = new JPanelSearchAppointment(appointmentManager, jsonConvert);
        JPanelCancelAppointment jPanelCancelAppointment = new JPanelCancelAppointment(appointmentManager);
        JPanelCardLayout jPanelCardLayout = new JPanelCardLayout(jPanelHome, jPanelScheduleAppointment, jPanelSearchAppointment, jPanelCancelAppointment);
        JPanelMenu jPanelMenu = new JPanelMenu(jPanelCardLayout);
        JPanelFooter jPanelFooter = new JPanelFooter();
        JFrameMedical jFrameMedical = new JFrameMedical(jPanelCardLayout, jPanelMenu, jPanelFooter);
    }

    public boolean checkUser() throws Exception {
        return appointmentManager.checkUser(jFrameInitUser.getjFieldIdUserEnter().getText());
    }

    public void initFramemedical() {
        jFrameMain.navigateToHomeRegister();
    }

    public void register() throws Exception {
        String namePet = jFrameInitUser.getjFieldNamePet().getText();
        String idPet = jFrameInitUser.getjFieldIdPet().getText();
        String typePet = jFrameInitUser.getjComboBoxType();
        String nameOwner = jFrameInitUser.getjFieldNameUser().getText();
        String idUser = jFrameInitUser.getjFieldIdUser().getText();
        appointmentManager.registerUser(namePet, idPet, typePet, nameOwner, idUser);
    }
}

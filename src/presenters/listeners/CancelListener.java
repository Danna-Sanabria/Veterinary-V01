package presenters.listeners;

import models.AppointmentManager;
import view.panels.JPanelCancelAppointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CancelListener implements ActionListener {

    private static final String MODALITY = "MODALITY";
    private static final String MESSAGE_CANCEL_SUCCESFULL = "CITA CANCELADA CON EXITO";
    private static final String CANCEL = "CANCEL";
    private static final String MESSAGE_ENTER_DATES = "POR FAVOR INGRESE LOS DATOS CORRESPONDIENTES";
    private JPanelCancelAppointment jPanelCancelAppointment;
    private AppointmentManager appointmentManager;

    public CancelListener(JPanelCancelAppointment jPanelCancelAppointment, AppointmentManager appointmentManager) {
        this.jPanelCancelAppointment = jPanelCancelAppointment;
        this.appointmentManager = appointmentManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        try {
            switch (action) {
                case MODALITY -> filterSchedule();
                case CANCEL -> cancelAppointment();
            }

        } catch (Exception exception) {
            jPanelCancelAppointment.messageInformation(exception.getMessage());
        }
    }

    public void filterSchedule(){
        ArrayList<String> filter = appointmentManager.filterAppointmentsSchedule(jPanelCancelAppointment.getTypeModality());
        jPanelCancelAppointment.putList(filter);
    }
    
    public void cancelAppointment(){
        try {
            appointmentManager.cancelAppointment(jPanelCancelAppointment.getjTextFieldId(),jPanelCancelAppointment.getTypeModality(),jPanelCancelAppointment.getjComboBoxHour());
            jPanelCancelAppointment.messageInformation(MESSAGE_CANCEL_SUCCESFULL);

        } catch (Exception e) {
            jPanelCancelAppointment.messageInformation(MESSAGE_ENTER_DATES);
        }
    }
}
package presenters.listeners;

import models.AppointmentManager;
import presenters.JsonConvert;
import view.panels.JPanelScheduleAppointment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MedicalAppointmentListener implements ActionListener {

    private static final String SCHEDULE = "SCHEDULE";
    private static final String CONSULT = "CONSULT";
    private static final String CANCEL = "CANCEL";
    public static final String APPOIMENT_CORRECT = "Cita agendada correctamente";
    public static final String DELETE_REGISTER = "Se eliminó el registro";
    private static final String MODALITY = "MODALITY";
    private static final String MESSAGE_ENTER_DATES = "INGRESE LOS DATOS CORRESPONDIENTES";
    private static final String SCHEDULE_APPOINTMENT = "AGENDAR_CITA";
    private JPanelScheduleAppointment jPanelScheduleAppointment;
    private AppointmentManager appointmentManager;

    public MedicalAppointmentListener(JPanelScheduleAppointment jPanelScheduleAppointment, AppointmentManager appointmentManager) {
        this.appointmentManager = appointmentManager;
        this.jPanelScheduleAppointment = jPanelScheduleAppointment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        try {
            switch (action) {
                case MODALITY -> filterModality();
                case SCHEDULE_APPOINTMENT -> schedule();
            }

        } catch (Exception exception) {
        }
    }

    public void filterModality(){
        ArrayList<String> filter = appointmentManager.filterByModality(jPanelScheduleAppointment.getTypeModality());
        System.out.println(jPanelScheduleAppointment.getTypeModality());
        jPanelScheduleAppointment.putList(filter);
    }

    public void schedule(){
        try {
            appointmentManager.scheduleAppointment(jPanelScheduleAppointment.getjTextFieldId(),
                    jPanelScheduleAppointment.getTypeModality(), jPanelScheduleAppointment.getjComboBoxHour());
            filterModality();
        } catch (Exception e) {
            jPanelScheduleAppointment.messageInformation(MESSAGE_ENTER_DATES);
        }
    }
}



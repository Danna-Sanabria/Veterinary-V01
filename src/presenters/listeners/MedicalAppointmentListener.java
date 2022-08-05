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
    private JPanelScheduleAppointment jPanelScheduleAppointment;
    private AppointmentManager appointmentManager;
    private JsonConvert jsonConvert;

    public MedicalAppointmentListener(JPanelScheduleAppointment jPanelScheduleAppointment, AppointmentManager appointmentManager, JsonConvert jsonConvert) {
        this.appointmentManager = appointmentManager;
        this.jPanelScheduleAppointment = jPanelScheduleAppointment;
        this.jsonConvert = jsonConvert;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        try {
            switch (action) {
                case "CHECK" -> init();
                case "modality" -> filterModality();
                case "AGENDAR" -> schedule();
            }

        } catch (Exception exception) {
            // JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void init() throws Exception {
        if (appointmentManager.checkUser(jPanelScheduleAppointment.getjTextFieldId())) {

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
            e.printStackTrace();
        }
    }
}



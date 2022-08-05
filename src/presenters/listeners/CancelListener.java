package presenters.listeners;

import models.AppointmentManager;
import view.panels.JPanelCancelAppointment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CancelListener implements ActionListener {

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
                case "MODALITY" -> filterSchedule();
                case "CANCELAR" -> {
                    cancelAppointment();
                    System.out.println("cancelada con exito");
                }
            }

        } catch (Exception exception) {
            // TODO: 3/08/2022
        }
    }

    public void filterSchedule(){
        ArrayList<String> filter = appointmentManager.filterAppointmentsSchedule(jPanelCancelAppointment.getTypeModality());
        jPanelCancelAppointment.putList(filter);
    }
    
    public void cancelAppointment(){
        try {
            appointmentManager.cancelAppointment(jPanelCancelAppointment.getjTextFieldId(),jPanelCancelAppointment.getTypeModality(),jPanelCancelAppointment.getjComboBoxHour());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

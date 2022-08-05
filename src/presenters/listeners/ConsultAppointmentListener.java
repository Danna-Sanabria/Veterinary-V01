package presenters.listeners;

import models.AppointmentManager;
import view.panels.JPanelSearchAppointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultAppointmentListener implements ActionListener {

    private static final String CONSULT = "CONSULT";
    private JPanelSearchAppointment jPanelSearchAppointment;
    private AppointmentManager appointmentManager;

    public ConsultAppointmentListener(JPanelSearchAppointment jPanelSearchAppointment, AppointmentManager appointmentManager) {
        this.appointmentManager = appointmentManager;
        this.jPanelSearchAppointment = jPanelSearchAppointment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case CONSULT:
                String idUser = jPanelSearchAppointment.getjTextFieldId();
                String information = String.valueOf(appointmentManager.consultAppointmentsSchedule(idUser));
                try {
                    jPanelSearchAppointment.setjTextAreaInformation(appointmentManager.getInformationAppointment(idUser) + "\n" + information);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

        }
    }
}

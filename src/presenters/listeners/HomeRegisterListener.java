package presenters.listeners;

import models.AppointmentManager;
import view.JFrameMain;
import view.registerPanels.JPanelHomeRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class HomeRegisterListener implements ActionListener{

    public static final String REGISTER = "REGISTER";
    public static final String BACK_OPTION = "BACK";
    private static final String SHOW_SCHEDULE = "VER_AGENDA";
    private static final String SCHEDULE = "AGENDAR";
    private JPanelHomeRegister jPanelHomeRegister;
    private AppointmentManager appointmentManager;
    private JFrameMain jFrameMain;

    public HomeRegisterListener(JPanelHomeRegister jPanelHomeRegister, JFrameMain jFrameMain, AppointmentManager appointmentManager) {
        this.jPanelHomeRegister = jPanelHomeRegister;
        this.jFrameMain = jFrameMain;
        this.appointmentManager = appointmentManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case SHOW_SCHEDULE:
                jPanelHomeRegister.setLabelInformation(appointmentManager.getInformationOfSchedule());
                break;
            case SCHEDULE:
                schedule();
                break;
            case BACK_OPTION:
                jFrameMain.navigateToHome();
                break;
        }
    }

    private void schedule() {
        try {
            Date date = jPanelHomeRegister.getjDateChooser();
            Calendar dateG = Calendar.getInstance();
            dateG.setTime(date);
            String aux = appointmentManager.dateformat(dateG.get(Calendar.YEAR), dateG.get(Calendar.MONTH), dateG.get(Calendar.DAY_OF_MONTH), jPanelHomeRegister.getjComboBoxHourStart());
            appointmentManager.createSchedule(jPanelHomeRegister.getjFielNumberAppointment(), jPanelHomeRegister.getNameDoctor(),aux);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


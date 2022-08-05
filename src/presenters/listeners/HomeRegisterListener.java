package presenters.listeners;

import models.AppointmentManager;
import view.JFrameMain;
import view.registerPanels.JPanelHomeRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeRegisterListener implements ActionListener{

    public static final String REGISTER = "REGISTER";
    public static final String BACK_OPTION = "BACK";
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
            case "verAgenda":
                jPanelHomeRegister.setLabelInformation(appointmentManager.getInformationOfSchedule());
                break;
            case REGISTER:
                jFrameMain.navigateToRegister();
                break;
            case BACK_OPTION:
                jFrameMain.navigateToHome();
                break;
        }
    }
}


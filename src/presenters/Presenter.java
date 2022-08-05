package presenters;

import models.AppointmentManager;
import view.JFrameInitUser;
import view.JFrameMain;

public class Presenter {

    private AppointmentManager appointmentManager;
    private JsonConvert jsonConvert;
    JFrameMain jFrameMain;

    public Presenter() {
        JsonConvert jsonConvert = new JsonConvert();
        appointmentManager = new AppointmentManager();
        jFrameMain = new JFrameMain(jsonConvert, this,appointmentManager);
        initData();
        try {
            appointmentManager.scheduleAppointment("10025","presencial","02/08/2022/05:00");
            appointmentManager.scheduleAppointment("10025","presencial","15/10/2022/08:00");
            appointmentManager.scheduleAppointment("10025","domicilio", "04/08/2022/04:00");
            System.out.println(appointmentManager.getInformationAvl());

            appointmentManager.cancelAppointment("10025","presencial","15/10/2022/08:00");
            System.out.println(appointmentManager.getInformationAvl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initData(){
        try {
            appointmentManager.registerUser("bronco", "2222", "perro", "danna", "10025");

            appointmentManager.registerDoctor("Manuel Leon", "1002525", "presencial");
            appointmentManager.registerDoctor("Lina Lopez", "1003636", "domicilio");

            appointmentManager.createAppointment("presencial", "Manuel Leon","1002525","15/10/2022/08:00");
            appointmentManager.createAppointment("presencial","Manuel Leon","1002525","02/08/2022/05:00");
            appointmentManager.createAppointment("presencial","Manuel Leon","1002525","20/08/2022/05:00");
            appointmentManager.createAppointment("domicilio","Lina Lopez","1003636","11/12/2022/01:00");
            appointmentManager.createAppointment("domicilio","Lina Lopez","1003636","04/08/2022/04:00");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(String caseValue) {
        JFrameInitUser initUser = new JFrameInitUser(appointmentManager, jsonConvert, jFrameMain);
        if(caseValue.equalsIgnoreCase("Usuario")){
            initUser.setjTabbedPane("INGRESAR",initUser.getjPanelEnter());
            initUser.setjTabbedPane("REGISTRAR",initUser.getjPanelRegister());
        }else{
            initUser.setjTabbedPane("INGRESAR",initUser.getjPanelEnterDoctor());
        }
    }
}
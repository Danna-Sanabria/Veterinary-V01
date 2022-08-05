package presenters;

import models.AppointmentManager;
import view.JFrameInitUser;
import view.JFrameMain;

public class Presenter {

    private AppointmentManager appointmentManager;
    private JsonConvert jsonConvert;
    JFrameMain jFrameMain;

    public Presenter() {
        try {
            JsonConvert jsonConvert = new JsonConvert();
            appointmentManager = new AppointmentManager(jsonConvert.readMedicalPresencial(), jsonConvert.readMedicalResidence());
            jFrameMain = new JFrameMain(jsonConvert, this, appointmentManager);
            initData();

            /*.createSchedule(4, "Manuel Leon", "02/08/2022/05:00");
            appointmentManager.createSchedule(4, "Lina Lopez", "02/08/2022/05:00");*/

            //jsonConvert.saveMedicalAppoimentsPresencial(appointmentManager.listMedicalPresencial());
            //jsonConvert.saveMedicalAppoimentsResidence(appointmentManager.listMedicalResidence());

            appointmentManager.scheduleAppointment("10025", "presencial", "02/08/2022/07:00");
            appointmentManager.scheduleAppointment("10025", "domicilio", "02/08/2022/06:00");
            appointmentManager.cancelAppointment("10025", "presencial", "02/08/2022/07:00");
            System.out.println(appointmentManager.getInformationAvl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initData(){
        try {
            appointmentManager.registerUser("bronco", "2222", "perro", "danna", "10025");
            appointmentManager.registerUser("Victoria", "1111", "Gato", "David", "10023");
            jsonConvert.saveListPet(appointmentManager.getListPet());
            appointmentManager.registerDoctor("Manuel Leon", "1002525", "presencial");
            appointmentManager.registerDoctor("Lina Lopez", "1003636", "domicilio");
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
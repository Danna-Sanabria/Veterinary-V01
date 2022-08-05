package models;

import Structure.TreeAVL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AppointmentManager {
    private static final String YY_MM_DD = "yy-MM-dd";
    private static final String MESSAGE_VALIDATE_DATE = "Debe ingresar una fecha mayor o igual a la actual ";
    private static final String MESSAGE_VALIDATE_APPOINTMENT = "No hay citas disponibles para este día";
    private static final String MESSAGE_DONT_FIND_ID = "Este Id no se encuentra relacionado a ningun registro";
    private final GregorianCalendar date;
    private ArrayList<Pet> clientsRegister;
    private ArrayList<Doctor> doctorList;
    private TreeAVL<MedicalAppointment> medicalAppointmentsListPresential;
    private TreeAVL<MedicalAppointment> medicalAppointmentsListresidency;
    private MedicalAppointment medical;

    public AppointmentManager() {
        date = new GregorianCalendar();
        clientsRegister = new ArrayList<>();
        doctorList = new ArrayList<>();
        medicalAppointmentsListPresential = new TreeAVL<>((o1, o2) -> validateDates(o1.getDate(), o2.getDate()));
        medicalAppointmentsListresidency = new TreeAVL<>((o1, o2) -> validateDates(o1.getDate(), o2.getDate()));
    }

    public String checkNotEmpty(String word, int length) throws Exception {
        if (!word.isEmpty() && word.length() <= length) {
            return word;
        }
        throw new Exception("Debe rellenar el campo");
    }

    public void registerUser(String namePet, String idPet, String typePet, String nameUser, String idUser) {
        clientsRegister.add(new Pet(namePet, idPet, typePet, new User(nameUser, idUser)));
    }

    public void registerDoctor(String nameDoctor, String idDoctor, String modality) {
        doctorList.add(new Doctor(nameDoctor, idDoctor, modality));
    }

    public void checkPerson(String idUser) throws Exception {
        for (Pet petWithUser : clientsRegister) {
            if (petWithUser.getIdUser().equalsIgnoreCase(idUser)) {
                throw new Exception("Esta persona ya se encuentra en el registro");
            }
        }
    }

    public boolean validateDateActual(GregorianCalendar o1, GregorianCalendar o2) {
        return (o2.get(Calendar.MONTH) == o1.get(Calendar.MONTH)
                && o2.get(Calendar.YEAR) == o1.get(Calendar.YEAR)
                && o2.get(Calendar.DAY_OF_MONTH) == o1.get(Calendar.DAY_OF_MONTH))
                && o2.get(Calendar.HOUR_OF_DAY) == o1.get(Calendar.HOUR_OF_DAY);

    }

    public boolean checkUser(String idUser) throws Exception {
        for (Pet petList : clientsRegister) {
            if (petList.getIdUser().equalsIgnoreCase(idUser)) {
                return true;
            }
        }
        throw new Exception("USUARIO NO REGISTRADO, REGISTRAR PARA CONTINUAR");
    }

    public Pet foundUser(String idUser) throws Exception {
        for (Pet petUser : clientsRegister) {
            if (petUser.getIdUser().equalsIgnoreCase(idUser)) {
                return petUser;
            }
        }
        throw new Exception("");
    }

    public ArrayList<String> filterByModality(String modality) {
        ArrayList<MedicalAppointment> medicalPresencial = medicalAppointmentsListPresential.getListData();
        ArrayList<MedicalAppointment> medicalResidential = medicalAppointmentsListresidency.getListData();
        ArrayList<String> aux = new ArrayList<>();
        if (modality.equalsIgnoreCase("PRESENCIAL")) {
            for (MedicalAppointment medical2 : medicalPresencial) {
                if (!medical2.isState()) {
                    aux.add(String.valueOf(medical2));
                }
            }
        } else {
            for (MedicalAppointment medical3 : medicalResidential) {
                if (!medical3.isState()) {
                    aux.add(String.valueOf(medical3));
                }
            }
        }
        return aux;
    }

    public ArrayList<String> filterAppointmentsSchedule(String modality) {
        ArrayList<MedicalAppointment> medicalPresencial = medicalAppointmentsListPresential.getListData();
        ArrayList<MedicalAppointment> medicalResidential = medicalAppointmentsListresidency.getListData();
        ArrayList<String> aux = new ArrayList<>();
        if (modality.equalsIgnoreCase("PRESENCIAL")) {
            for (MedicalAppointment medical2 : medicalPresencial) {
                if (medical2.isState()) {
                    aux.add(String.valueOf(medical2));
                }
            }
        } else {
            for (MedicalAppointment medical3 : medicalResidential) {
                if (medical3.isState()) {
                    aux.add(String.valueOf(medical3));
                }
            }
        }
        return aux;
    }



    public ArrayList<String> getList(ArrayList<MedicalAppointment> medicalList) {
        ArrayList<String> list = new ArrayList<>();
        for (MedicalAppointment medical : medicalList) {
            list.add(medical.toString());
        }
        return list;
    }

    public void createAppointment(String modality, String nameDoctor, String iddoctor, String date) throws
            Exception {
        if (modality.equalsIgnoreCase("presencial")) {
            medicalAppointmentsListPresential.insert(new MedicalAppointment(new Doctor(nameDoctor, iddoctor, modality), null, transformStringToDate(date), false));
        } else if (modality.equalsIgnoreCase("domicilio")) {
            medicalAppointmentsListresidency.insert(new MedicalAppointment(new Doctor(nameDoctor, iddoctor, modality), null, transformStringToDate(date), false));
        }
    }

    public Doctor getModality(String modality) {
        for (Doctor doctor : doctorList) {
            if (doctor.getTypeModality().equalsIgnoreCase(modality)) {
                return doctor;
            }
        }
        return null;
    }

    public GregorianCalendar transformStringToDate(String date) {
        String dateNew = date.substring(0, 13);
        String[] dateList = dateNew.split("/", 10);
        return new GregorianCalendar(Integer.parseInt(dateList[2]), Integer.parseInt(dateList[1]) - 1, Integer.parseInt(dateList[0]), Integer.parseInt(dateList[3]), 0);
    }

    public void scheduleAppointment(String idUser, String modality, String date) throws Exception {
        Pet pet = foundUser(idUser);
        Doctor doc = getModality(modality);
        GregorianCalendar dateCita = transformStringToDate(date);
        MedicalAppointment medical = new MedicalAppointment(doc, pet, dateCita, true);
        MedicalAppointment medical2;

        if (modality.equalsIgnoreCase("PRESENCIAL")) {
            medical2 = medicalAppointmentsListPresential.exist(medical);
        } else {
            medical2 = medicalAppointmentsListresidency.exist(medical);
        }
        medical2.setPet(pet);
        medical2.setState(true);

    }

    public MedicalAppointment getAppointment(String idUser) {
        return null;
    }

    public ArrayList<String> consultAppointmentsSchedule(String idUser) {
        ArrayList<String> auxList = new ArrayList<>();
        ArrayList<MedicalAppointment> medical = medicalAppointmentsListPresential.getListData();
        for (MedicalAppointment medical2 : medical) {
            if (medical2.isState() && medical2.getIdUser().equalsIgnoreCase(idUser)) {
                auxList.add(String.valueOf(medical2.dateformat()));
            }
        }
        ArrayList<MedicalAppointment> medicalResidential = medicalAppointmentsListresidency.getListData();
        for (MedicalAppointment medical2 : medicalResidential) {
            if (medical2.isState() && medical2.getIdUser().equalsIgnoreCase(idUser)) {
                auxList.add(String.valueOf(medical2.dateformat()));
            }
        }
        return auxList;
    }

    public String getInformationAvl() {
        StringBuilder data = new StringBuilder();
        for (MedicalAppointment medical : medicalAppointmentsListPresential.getListData()) {
            data.append(medical.dateformat()).append(medical.isState()).append(",,");
        }
        return data.toString();
    }

    public void cancelAppointment(String idUser, String modality, String date) {
        GregorianCalendar appointmentCancel = transformStringToDate(date);
        ArrayList<MedicalAppointment> medical = medicalAppointmentsListPresential.getListData();
        ArrayList<MedicalAppointment> medicalResidential = medicalAppointmentsListresidency.getListData();

        if (modality.equalsIgnoreCase("PRESENCIAL")) {
            for (MedicalAppointment medical2 : medical) {
                if (medical2.getDate().equals(appointmentCancel) && medical2.getIdUser().equalsIgnoreCase(idUser)) {
                    medical2.setPet(null);
                    medical2.setState(false);
                }
            }
        } else {
            for (MedicalAppointment medical3 : medicalResidential) {
                if (medical3.getDate().equals(appointmentCancel) && medical3.getIdUser().equalsIgnoreCase(idUser)) {
                    medical3.setPet(null);
                    medical3.setState(false);
                }
            }
        }

    }

    public String getInformationAppointment(String idUser) throws Exception {
        return foundUser(idUser).toString();
    }

    private int validateDates(GregorianCalendar o1, GregorianCalendar o2) {
        //  System.out.println(o1.get(Calendar.MONTH) + " " + o2.get(Calendar.MONTH) + " " + o1.get(Calendar.YEAR) + " " + o2.get(Calendar.YEAR) + " " + o1.get(Calendar.DAY_OF_MONTH) + " " + o2.get(Calendar.DAY_OF_MONTH) + " " + o1.get(Calendar.HOUR_OF_DAY) + " " + o2.get(Calendar.HOUR_OF_DAY));
        if (validateDateActual(o1, o2)) {
            return 0;
        } else if (o1.before(o2)) {
            return -1;
        } else {
            return 1;
        }
    }
}
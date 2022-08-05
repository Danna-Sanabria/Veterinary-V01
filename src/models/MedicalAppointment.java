package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MedicalAppointment {

    private Doctor doctor;
    private Pet pet;
    private GregorianCalendar date;
    private  boolean state;

    public MedicalAppointment(Doctor doctor, Pet pet, GregorianCalendar date, boolean state) {
        this.doctor = doctor;
        this.pet = pet;
        this.date = date;
        this.state = state;
    }

    public String getIdUser() {
        return pet.getIdUser();
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public String getNameOwner() {
        return pet.getNameUser();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Pet getPet() {
        return pet;
    }

    public boolean isState() {
        return state;
    }


    public String dateformat() {
        String dayS = (date.get(Calendar.DAY_OF_MONTH) >= 10) ? date.get(Calendar.DAY_OF_MONTH) + "" : "0" + date.get(Calendar.DAY_OF_MONTH);
        String monthS = ((date.get(Calendar.MONTH) + 1) >= 10) ? (date.get(Calendar.MONTH) + 1) + "" : "0" + (date.get(Calendar.MONTH) + 1);
        String hourS = (date.get(Calendar.HOUR) >= 10) ? date.get(Calendar.HOUR) + "" : "0" + date.get(Calendar.HOUR);
        return dayS + "/" + monthS + "/" + date.get(Calendar.YEAR)  + "/" + hourS + ":00";
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return dateformat() ;
    }
}

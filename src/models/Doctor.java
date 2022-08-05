package models;

public class Doctor {

    private String nameDoctor;
    private String idDoctor;
    private String typeModality;

    public Doctor(String nameDoctor, String idDoctor, String typeModality) {
        this.nameDoctor = nameDoctor;
        this.idDoctor = idDoctor;
        this.typeModality = typeModality;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public String getTypeModality() {
        return typeModality;
    }

}

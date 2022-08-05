package models;

public class Pet {

    private String namePet;
    private String idPet;
    private String typePet;
    private User user;

    public Pet(String namePet, String idPet, String typePet, User user) {
        this.namePet = namePet;
        this.idPet = idPet;
        this.typePet = typePet;
        this.user = user;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getIdPet() {
        return idPet;
    }

    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIdUser() {
        return user.getIdUser();
    }

    public String getNameUser() {
        return user.getNameUser();
    }

    @Override
    public String toString() {
        return "Mascota: " + namePet + " \n" +
                "Identificación mascota: " + idPet + " \n" +
                "Tipo de mascota: " + typePet + " \n" +
                "Propietario: " + user + " \n" +
                " \n" + "Citas agendadas: ";

    }
}



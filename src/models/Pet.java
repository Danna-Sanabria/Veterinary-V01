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

    public String getTypePet() {
        return typePet;
    }

    public String getIdUser() {
        return user.getIdUser();
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



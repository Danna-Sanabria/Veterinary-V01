package models;

public class User {

    private String nameUser;
    private String idUser;

    public User(String nameUser, String idUser) {
        this.nameUser = nameUser;
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    @Override
    public String toString() {
        return nameUser + "\n" +
                "Identificación: " + idUser;
    }
}

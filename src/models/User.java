package models;

public class User {

    private String nameUser;
    private String idUser;

    public User(String nameUser, String idUser) {
        this.nameUser = nameUser;
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return  nameUser + "\n" +
                "Identificación: " + idUser ;
    }
}

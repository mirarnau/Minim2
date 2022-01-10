package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String idUser;

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public User (String idUser){
        this.idUser = idUser;

    }

    public User(){};

}

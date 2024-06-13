package Model.Classes;

import java.util.Objects;

public class User {

    private String user;
    private String pass;
    private String correo;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    private boolean isAdmin;
    public User(String user, String correo, String pass, boolean isAdmin){
        this.user = user;
        this.correo = correo;
        this.pass = pass;
        this.isAdmin =isAdmin;
    }

    public String getId() {
        return user;
    }

    public void setId(String id) {
        this.user = user;
    }

    public String getName() {
        return correo;
    }

    public void setName(String name) {
        this.correo = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    @Override
    public String toString() {
        return "El user se llama "+this.user+" con correo: "+this.correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(this.user, user.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, correo, pass, isAdmin);
    }

}



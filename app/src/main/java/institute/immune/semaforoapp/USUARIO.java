package institute.immune.semaforoapp;

public class USUARIO {

    private int id;
    private String nombre, correo, password;

    public USUARIO(int id, String nombre, String correo, String password) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package Services.impl;

import Model.Classes.User;

import java.time.LocalDateTime;

public class ServiceLogger {
    private GestionFicheroLogger gestion;
    //establecemos  la ruta
    private String ruta = "C:\\Users\\aperrom1709\\Desktop\\defensa final\\ProyectoProgramacionDefinitivo\\src\\main\\resources\\loggers\\logs.txt";

    public ServiceLogger() {
        this.gestion = new GestionFicheroLogger();
    }
// metodo para añadir al fichero cada movimiento en forma d elog
public void registrarLog(String infoUser, String accion, String estado) {
    LocalDateTime time = LocalDateTime.now();
    String mensaje = "["+accion.toUpperCase()+"] " + time.toString()+" "+infoUser +"-"+ estado;
    anadirFicheroLogger(mensaje);
}
        



    public void anadirFicheroLogger(String mensaje) {
        this.gestion.anadirFichero(mensaje, this.ruta);
    }

}

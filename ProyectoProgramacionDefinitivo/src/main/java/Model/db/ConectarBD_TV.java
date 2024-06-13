package Model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD_TV {
    private String user,pass,dbName,url;
    private Connection connection;
    //este metodo conecta la base de datos por url
    public  ConectarBD_TV(String user, String pass,String dbName) {
        this.user=user;
        this.pass=pass;
        this.dbName=dbName;

        this.url="jdbc:mysql://localhost:3306/"+this.dbName+"?user="+this.user+"&password=" + this.pass;
    }



// siguiendo el como conecta
    public void realizarConexion(){

        try{
            if (this.connection==null){
                this.connection= DriverManager.getConnection(this.url);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    // como desconecta
    public void desconectarBD() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
// obtiene la conexion
    public Connection obtenerConexion() {
        return this.connection;

    }
}

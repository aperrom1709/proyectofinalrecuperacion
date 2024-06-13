package Services;

import Model.Classes.User;
import Model.db.ConectarBD_TV;
import Services.impl.ServiceLogger;
import Utils.CredentialsDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserServices {
    private ServiceLogger logger;
    public ConectarBD_TV conectarBDTv;

    public  UserServices() { // Realizar la conexión
        // 1. Crear objeto 'ConectarDB conectarDB = new ConectarDB()'
        conectarBDTv=new ConectarBD_TV(CredentialsDB.USER,CredentialsDB.PASS,CredentialsDB.DB_NAME);



        // 2. conectarDB.RealizarConexion()
        conectarBDTv.realizarConexion();


        // 3. conectarDB.DesconectarDB()

        this.logger=new ServiceLogger();
    }
// comprueba que el id_usuario y pass sean correctos en relacion a la base de datos para poder hacer login
    public boolean checkUserExists(String user,String pass) {
        boolean siono=false;
        try{
            PreparedStatement st=conectarBDTv.obtenerConexion().prepareStatement(CredentialsDB.QUERY_LOGIN);
            st.setString(1,user);
            st.setString(2,pass);
            ResultSet rs=st.executeQuery();
            if (rs.next()){
                siono=true;
                this.logger.registrarLog(user, "logeao", "si");
            }else {
                this.logger.registrarLog(user, "logeao", "no");
            }






        } catch (SQLException e) {
            e.printStackTrace();
        }


        return siono;
    }
    // hace la funcion del alta pidiendpo un correo un id_usuario y pass y ejecutando la query correspondiente
    public boolean registrarUsuario(String id_usuario, String pass, String correo,boolean isAdmin ) {
        boolean siono1=true;

        try{
            PreparedStatement st1=conectarBDTv.obtenerConexion().prepareStatement(CredentialsDB.QUERY_INSERT_ALTA);
            // Establecer los parámetros de la sentencia SQL
            st1.setString(1,id_usuario );
            st1.setString(2, pass);
            st1.setString(3, correo);
            st1.setBoolean(4,isAdmin);
            st1.executeUpdate();





        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siono1;



    }
    //Metodo para comprobar si el usuario existe con el id
    public boolean userExists(String id){
        boolean esonoes=false;
        try {
            PreparedStatement pst = conectarBDTv.obtenerConexion().prepareStatement(CredentialsDB.QUERY_LOGIN);

            pst.setString(1,id);

            ResultSet rs =pst.executeQuery();
            if (rs.next()){
                esonoes=true;
            }

        } catch (Exception var13) {
            var13.printStackTrace();
        }
        return esonoes;

    }
    //hace la funcion de baja usando el id_usuario para borrar el usuario registrado de la base de datos con la query correspoindiente
    public boolean bajausuario(String id_usuario){
        try {
            PreparedStatement st2=conectarBDTv.obtenerConexion().prepareStatement(CredentialsDB.QUERY_BAJA);
            st2.setString(1,id_usuario );


            Boolean r= st2.execute();
            if (r){
                System.out.println("borrao");
                this.logger.registrarLog(id_usuario, "borrau", "sa borrao");
                return  true;

            }else {
                this.logger.registrarLog(id_usuario, "borrau", "no sa borrao");


            }





        } catch (SQLException e) {
            e.printStackTrace();
        }


        return true;
    }
    // esta modifica el usuario pidiendo el id_usario y con la query correspondiente
    public boolean modificarusuario(User user,String id_usuario){
        boolean esono=false;

        try {
            if (userExists(id_usuario)){
                try {
                    PreparedStatement st4=conectarBDTv.obtenerConexion().prepareStatement(CredentialsDB.QUERY_MODIFICAR);
                    st4.setString(1,user.getId());
                    st4.setString(2,user.getCorreo());
                    st4.setString(3,user.getPass());
                    st4.setBoolean(4,user.isAdmin());
                    boolean rs=st4.execute();
                    if (rs=true){
                        esono = true;
                        this.logger.registrarLog(user.getId(), "Modificar", "si funciona");

                    } else {
                        this.logger.registrarLog(id_usuario, "Modificar", "no funciona");

                    }




                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }







        } catch (Exception e) {
            e.printStackTrace();
        }


        return esono;
    }
    // este metodo coge la query y hace un tostring del usuario que busques y te muestra id_user,correo,pass,y si es admin que no puede serlo
    public String consultausuario(User user){

        try {
            PreparedStatement st3=conectarBDTv.obtenerConexion().prepareStatement(CredentialsDB.QUERY_CONSULTA);
            st3.setString(1,user.getId());
            //este while hace que mientras se ejecute la query devuelva el mensaje que contiene todo el tostring con todos los datos

            ResultSet rs=st3.executeQuery();
            while (rs.next()){
               String usuarioid=rs.getString("id_usuario");
               String usuariocorreo=rs.getString("correo");
               String usuariopass=rs.getString("pass");
               String usuarioisadmin= String.valueOf((rs.getBoolean("isAdmin")));
               String mensaje="idUsuario "+usuarioid+"\n correo "+usuariocorreo+"\n pass "+usuariopass+"\nisAdmin "+usuarioisadmin;
               return mensaje;
            }
            if (rs.next()){
                this.logger.registrarLog(user.getId(), "Consulta", "OK");
            }else {
                this.logger.registrarLog(user.getId(), "Consulta", "NOT OK");
            }





        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }






}




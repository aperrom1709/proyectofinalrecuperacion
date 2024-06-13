package Utils;

public class CredentialsDB {
    //nombre contraseña y usuario de la base datos
    public static final String USER ="root";
    public static final String PASS= "";
    public static final String DB_NAME = "db_app";

    //Querys de la aplicacion que hacen las funciones como sus nombre indican
    public static String QUERY_LOGIN = "Select * from usuario WHERE id_usuario = ? and pass = ?";
    public static String QUERY_INSERT_ALTA = "INSERT INTO usuario  VALUES (?,?,?,?)";
    public static String QUERY_CONSULTA= "Select * from usuario WHERE id_usuario = ?";
    public static String QUERY_MODIFICAR="Update usuario set id_usuario=?,correo=?,pass=?,isAdmin=? where id_usuario=?";
    public static String QUERY_BAJA= "DELETE FROM usuario WHERE id_usuario= ?";


}

/**
 * @author David Gutierrez
 * @description Webservice que es utilizado para la inserción de mensajes en el sistema. / Webservice used for insert messages in the system. 
 */
package ws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.sql.DriverManager;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;

/**
 * @author David Gutierrez
 * @description Webservice que es utilizado para la inserción de mensajes en el sistema / Webservice used for insert messages in the system.
 */
@WebService(serviceName = "addMessage")
public class addMessage {
    @Resource(name = "miAplicacion")
    private DataSource miAplicacion;

    private final String messageRight = "El mensaje enviado ha sido almacenado correctamente.";
    private final String messageWrong = "El mensaje enviado no ha sido almacenado. ";
    
    @WebMethod(operationName = "introduceMensaje")
    public String introduceMensaje(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "Contenido") String Contenido) throws java.lang.Exception {
        String respuesta;
        String resultado;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");) {
            PreparedStatement stat = con.prepareStatement("SELECT ID_usuario FROM t_usuarios WHERE ID_usuario = ?");
            stat.setString(1, Usuario);
            try (ResultSet rs = stat.executeQuery()) {
                resultado = rs.getString(1);
                //Si la query ha resultado nula quiere decir que el usuario no existe, por tanto devolvemos un mensaje de error
                //If the query has no result means that the user does not exist, therefore we return an error message
                if (resultado == null) {
                    respuesta = messageWrong + "El usuario: " + Usuario + ". No consta en la BBDD.";
                 } 
                //Si la query ha resultado ha devuelto algo quiere decir que existe el usuario, intentaremos introducir el mensaje en el sistema
                //If the query has been returned something means that the user exists, we will try to enter the message system
                else { 
                    try {
                        stat = con.prepareStatement("INSERT INTO t_mensajes VALUES(?,?)");
                        stat.setString(1, Usuario);
                        stat.setString(2, Contenido);
                    
                        stat.executeUpdate();
                        respuesta = messageRight;
                    } catch (Exception e) {
                        System.err.printf(e.getMessage());
                        respuesta = messageWrong + "Ha habido algún problema a la hora de insertarlo en la BBDD.";
                    }
                 }
                //Cerramos las conexiones a BBDD abiertas / Close the connections
                rs.close();
                con.close();
                return respuesta;
            }
            catch (Exception ex){
                System.err.printf(ex.getMessage());
                return messageWrong;
            }
        }
        catch (Exception ex){
            System.err.printf(ex.getMessage());
            return messageWrong;
        }
    }
}

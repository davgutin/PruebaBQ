/**
 * @author David Gutierrez
 * @description Webservice que es utilizado para la inserción de usuarios en el sistema./ Webservice used for insert users in the system. 
 */
package ws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.lang.Exception;
import java.sql.DriverManager;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;


/**
 * @author David Gutierrez
 * @description Webservice que es utilizado para la inserción de usuarios en el sistema./ Webservice used for insert users in the system. 
 */
@WebService(serviceName = "insertaUsuarios")
@Stateless()
public class insertaUsuarios {

    @Resource(name = "miAplicacion")
    private DataSource miAplicacion;
    
    private final String messageRight = "El usuario ha sido introducido correctamente en el sistema, recibirá un email de confirmación. ";
    private final String messageWrong = "No ha sido posible introducir el nuevo usuario en el sistema. ";
    
    @WebMethod(operationName = "insertUsuario")
    public String insertUsuario(@WebParam(name = "Nombre") String Nombre, @WebParam(name = "Email") String Email, @WebParam(name = "Identificador") String Identificador) throws java.lang.Exception {
        String respuesta;
        String resultado;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");) {
            PreparedStatement st = con.prepareStatement("INSERT INTO t_usuarios VALUES(?,?,?)");
            st.setString(1, Identificador);
            st.setString(2, Nombre);
            st.setString(3, Email);
            st.executeUpdate();
            con.close();
            
            respuesta = messageRight;
            
        } catch (Exception e) {
            System.err.printf(e.getMessage());
            respuesta = messageWrong;
            
        }
        
        return respuesta;
    }
}
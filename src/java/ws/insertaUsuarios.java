/**
 * @author David Gutierrez
 * @description Webservice que es utilizado para la inserción de usuarios en el sistema./ Webservice used for insert users in the system. 
 */
package ws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.lang.Exception;
import java.sql.DriverManager;
import java.util.Properties;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
        //Abrimos la conexión/Open the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");) {
            //Preparamos la operación que queremos realizar sobre la BBDD/Prepare the operation we want to perform on the DB
            PreparedStatement st = con.prepareStatement("INSERT INTO t_usuarios VALUES(?,?,?)");
            st.setString(1, Identificador);
            st.setString(2, Nombre);
            st.setString(3, Email);
            st.executeUpdate();
            //Cerramos las conexiones a BBDD abiertas / Close the connections
            con.close();
            
            // Email receptor / Recipient's email ID needs to be mentioned.
            String to = Email;
            // Email desde el que se envía / Sender's email ID needs to be mentioned
            String from = "web@gmail.com";
            // Host, suponiendo que se envia desde localhost / Assuming you are sending email from localhost
            String host = "localhost";
            // Obtenemos las propiedades del sistema / Get system properties
            Properties properties = System.getProperties();
            // Configuramos el servidor del email / Setup mail server
            properties.setProperty("mail.smtp.host", host);
            // Obtenemos el objeto Session / Get the default Session object.
            Session session = Session.getDefaultInstance(properties);
            try{
               // Generamos un mensaje por defecto / Create a default MimeMessage object.
               MimeMessage message = new MimeMessage(session);
               // Configuramos el DESDE / Set From: header field of the header.
               message.setFrom(new InternetAddress(from));
               // Configuramos el PARA / Set To: header field of the header.
               message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
               // Configuramos el ASUNTO / Set Subject: header field
               message.setSubject("Confirmación Usuario Registrado");
               // Configuramos el contenido del email / Now set the actual message
               message.setText("Le confirmamos " + Nombre + ", que su registro ha sido realizado satisfactoriamente.");
               // Enviamos el email / Send message
               Transport.send(message);
               System.err.printf("Email enviado a " + Nombre + " correctamente.");
            }catch (MessagingException mex) {
               System.err.printf(mex.getMessage());
            }
      
            respuesta = messageRight;
        } catch (Exception e) {
            System.err.printf(e.getMessage());
            respuesta = messageWrong;
            
        }
        return respuesta;
    }
}

package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "addMessage", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AddMessage {


    /**
     * 
     * @param contenido
     * @param usuario
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "introduceMensaje", targetNamespace = "http://ws/", className = "ws.IntroduceMensaje")
    @ResponseWrapper(localName = "introduceMensajeResponse", targetNamespace = "http://ws/", className = "ws.IntroduceMensajeResponse")
    @Action(input = "http://ws/addMessage/introduceMensajeRequest", output = "http://ws/addMessage/introduceMensajeResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://ws/addMessage/introduceMensaje/Fault/Exception")
    })
    public String introduceMensaje(
        @WebParam(name = "Usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "Contenido", targetNamespace = "")
        String contenido)
        throws Exception_Exception
    ;

}
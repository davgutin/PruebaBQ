
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
@WebService(name = "insertaUsuarios", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InsertaUsuarios {


    /**
     * 
     * @param nombre
     * @param email
     * @param identificador
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertUsuario", targetNamespace = "http://ws/", className = "ws.InsertUsuario")
    @ResponseWrapper(localName = "insertUsuarioResponse", targetNamespace = "http://ws/", className = "ws.InsertUsuarioResponse")
    @Action(input = "http://ws/insertaUsuarios/insertUsuarioRequest", output = "http://ws/insertaUsuarios/insertUsuarioResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://ws/insertaUsuarios/insertUsuario/Fault/Exception")
    })
    public String insertUsuario(
        @WebParam(name = "Nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "Email", targetNamespace = "")
        String email,
        @WebParam(name = "Identificador", targetNamespace = "")
        String identificador)
        throws Exception_Exception
    ;

}
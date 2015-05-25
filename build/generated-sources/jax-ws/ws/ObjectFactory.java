
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InsertUsuario_QNAME = new QName("http://ws/", "insertUsuario");
    private final static QName _InsertUsuarioResponse_QNAME = new QName("http://ws/", "insertUsuarioResponse");
    private final static QName _Exception_QNAME = new QName("http://ws/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link InsertUsuarioResponse }
     * 
     */
    public InsertUsuarioResponse createInsertUsuarioResponse() {
        return new InsertUsuarioResponse();
    }

    /**
     * Create an instance of {@link InsertUsuario }
     * 
     */
    public InsertUsuario createInsertUsuario() {
        return new InsertUsuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "insertUsuario")
    public JAXBElement<InsertUsuario> createInsertUsuario(InsertUsuario value) {
        return new JAXBElement<InsertUsuario>(_InsertUsuario_QNAME, InsertUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "insertUsuarioResponse")
    public JAXBElement<InsertUsuarioResponse> createInsertUsuarioResponse(InsertUsuarioResponse value) {
        return new JAXBElement<InsertUsuarioResponse>(_InsertUsuarioResponse_QNAME, InsertUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}


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

    private final static QName _IntroduceMensaje_QNAME = new QName("http://ws/", "introduceMensaje");
    private final static QName _IntroduceMensajeResponse_QNAME = new QName("http://ws/", "introduceMensajeResponse");
    private final static QName _Exception_QNAME = new QName("http://ws/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IntroduceMensajeResponse }
     * 
     */
    public IntroduceMensajeResponse createIntroduceMensajeResponse() {
        return new IntroduceMensajeResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link IntroduceMensaje }
     * 
     */
    public IntroduceMensaje createIntroduceMensaje() {
        return new IntroduceMensaje();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntroduceMensaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "introduceMensaje")
    public JAXBElement<IntroduceMensaje> createIntroduceMensaje(IntroduceMensaje value) {
        return new JAXBElement<IntroduceMensaje>(_IntroduceMensaje_QNAME, IntroduceMensaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntroduceMensajeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "introduceMensajeResponse")
    public JAXBElement<IntroduceMensajeResponse> createIntroduceMensajeResponse(IntroduceMensajeResponse value) {
        return new JAXBElement<IntroduceMensajeResponse>(_IntroduceMensajeResponse_QNAME, IntroduceMensajeResponse.class, null, value);
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

package channel;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author ngadzheva
 */
public class Channel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            InputSource source = new InputSource("channel.xml");
            parser.setContentHandler(new SAXHandler(output));
            parser.parse(source);
        } catch (SAXException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Channel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}

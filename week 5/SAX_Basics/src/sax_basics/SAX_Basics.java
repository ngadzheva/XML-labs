package sax_basics;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author ngadzheva
 */
public class SAX_Basics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            OutputStreamWriter output = new OutputStreamWriter(System.out);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            InputSource source = new InputSource("company.xml");
            reader.setContentHandler(new SAXHandler(output));
            
            reader.parse(source);
            
            output.close();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

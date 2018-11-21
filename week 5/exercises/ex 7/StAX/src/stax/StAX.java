package stax;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author ngadzheva
 */
public class StAX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            StringWriter writer = new StringWriter();
            XMLOutputFactory xmlOutput = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlWriter = xmlOutput.createXMLStreamWriter(writer);
            
            xmlWriter.writeStartDocument();
            xmlWriter.writeStartElement("bookstore");
            xmlWriter.writeStartElement("book");
            xmlWriter.writeAttribute("category", "COOKING");
            
            createSimpleElement(xmlWriter, "title", "lang", "en", "Everyday Italian");
            createSimpleElement(xmlWriter, "author", null, null, "Giada De Laurentiis");
            createSimpleElement(xmlWriter, "year", null, null, "2005");
            createSimpleElement(xmlWriter, "price", null, null, "30.00");
            
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("book");
            xmlWriter.writeAttribute("category", "CHILDREN");
            
            createSimpleElement(xmlWriter, "title", "lang", "en", "Harry Potter");
            createSimpleElement(xmlWriter, "author", null, null, "J. K. Rowling");
            createSimpleElement(xmlWriter, "year", null, null, "2005");
            createSimpleElement(xmlWriter, "price", null, null, "29.99");
            
            xmlWriter.writeEndElement();
            xmlWriter.writeStartElement("book");
            xmlWriter.writeAttribute("category", "WEB");
            
            createSimpleElement(xmlWriter, "title", "lang", "en", "Learning XML");
            createSimpleElement(xmlWriter, "author", null, null, "Erik T. Ray");
            createSimpleElement(xmlWriter, "year", null, null, "2003");
            createSimpleElement(xmlWriter, "price", null, null, "39.95");
            
            xmlWriter.writeEndElement();
            xmlWriter.writeEndElement();
            xmlWriter.writeEndDocument();
            xmlWriter.flush();
            xmlWriter.close();
            
            String xmlString = writer.getBuffer().toString();
            writer.close();
            
            System.out.println(xmlString);
        } catch (XMLStreamException ex) {
            Logger.getLogger(StAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void createSimpleElement(XMLStreamWriter xmlWriter, 
            String elementName, String attributeName, String attributeValue, String strValue) throws XMLStreamException{
        if (xmlWriter != null && elementName != null) {
            xmlWriter.writeStartElement(elementName);
            if (attributeName != null) {
                xmlWriter.writeAttribute(attributeName, attributeValue);
            }
            if (strValue != null) {
                xmlWriter.writeCharacters(strValue);
            }
            xmlWriter.writeEndElement();
        }
    }
}

package stax_basics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author ngadzheva
 */
public class StAX_Basics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createXMLDocument();
        parseXMLDocument();
    }
    
    private static void createXMLDocument(){
        try {
            StringWriter writer = new StringWriter();
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter streamWriter = output.createXMLStreamWriter(writer);
            
            createTree(streamWriter);
            
            String xmlString = writer.getBuffer().toString();
            writer.close();
            
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("company.xml"));
            buffWriter.write(xmlString);
            buffWriter.close();
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void createTree(XMLStreamWriter writer){
        try {
            // Create the beginning of the document
            writer.writeStartDocument();
            // Create an opening tag of an element
            writer.writeStartElement("COMPANY");
            
            writer.writeStartElement("name");
            // Create the text content of the element
            writer.writeCharacters("XML Tech");
            // Create the closing tag of the element
            writer.writeEndElement();
            
            writer.writeStartElement("employeeList");
            
            writer.writeStartElement("employee");
            // Create attribute of the element
            writer.writeAttribute("empID", "E00001");
            
            writer.writeStartElement("img");
            writer.writeAttribute("src", "JohnSmith");
            writer.writeEndElement();
            
            writer.writeStartElement("name");
            writer.writeCharacters("John Smith");
            writer.writeEndElement();
            
            writer.writeStartElement("sector");
            writer.writeCharacters("Devs");
            writer.writeEndElement();
            
            writer.writeStartElement("hire-date");
            writer.writeCharacters("25 May 2015");
            writer.writeEndElement();
            
            // Closing tag of element "employee"
            writer.writeEndElement();
            
            // Closing tag of element "employeeList"
            writer.writeEndElement();
            
            writer.writeStartElement("careers");
            
            writer.writeStartElement("job");
            writer.writeAttribute("id", "J00001");
            
            writer.writeStartElement("position");
            writer.writeCharacters("XML &amp; HTML developer");
            writer.writeEndElement();
            
            writer.writeStartElement("status");
            writer.writeCharacters("Open");
            writer.writeEndElement();
            
            writer.writeStartElement("modified");
            writer.writeCharacters("Wed, 17 Oct 2018");
            writer.writeEndElement();
            
            writer.writeStartElement("salary");
            writer.writeCharacters("BGN 1500");
            writer.writeEndElement();
            
            // Closing tag of element "job"
            writer.writeEndElement();
            
            // Closing tag of element "careers"
            writer.writeEndElement();
            
            writer.writeStartElement("contact");
            
            writer.writeStartElement("person");
            
            writer.writeStartElement("first-name");
            writer.writeCharacters("Nathan");
            writer.writeEndElement();
            
            writer.writeStartElement("last-name");
            writer.writeCharacters("Clemons");
            writer.writeEndElement();
            
            // Closing tag of element "person"
            writer.writeEndElement();
            
            writer.writeStartElement("email");
            writer.writeCharacters("nathan@xmldevs.com");
            writer.writeEndElement();
            
            writer.writeStartElement("phone");
            writer.writeCharacters("0888-888-888");
            writer.writeEndElement();
            
            // Closing tag of element "contact"
            writer.writeEndElement();
            
            // Closing tag of element "COMPANY"
            writer.writeEndElement();
            
            // Create the end of the document
            writer.writeEndDocument();
            
            writer.flush();
            writer.close();
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void parseXMLDocument(){
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader("company.xml"));
            
            parseTree(streamReader);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void parseTree(XMLStreamReader reader) throws XMLStreamException{
        // While there are elements in the document, print them
        while(reader.hasNext()){
            printEvent(reader);
            // Move to next element
            reader.next();
        }
        
        reader.close();
    }
    
    private static void printEvent(XMLStreamReader reader){
        switch(reader.getEventType()){
            // If the current element is an opening tag, print its name with its attributes
            case XMLStreamConstants.START_ELEMENT: {
                System.out.print("<");
                printName(reader);
                printAttributes(reader);
                System.out.print(">");
                break;
            }
            // If the current element is a closing tag, print its name
            case XMLStreamConstants.END_ELEMENT: {
                System.out.print("</");
                printName(reader);
                System.out.println(">");
                break;
            }
            // If the current element is text content, print it
            case XMLStreamConstants.CHARACTERS: {
                int start = reader.getTextStart();
                int end = reader.getTextLength();

                System.out.print(new String(reader.getTextCharacters(), start, end));

                break;
            }
            // If the current element is the beginning of the document, print the xml declaration
            case XMLStreamConstants.START_DOCUMENT: {
                System.out.print("<?xml");
                System.out.printf(" version='%s' ", reader.getVersion());
                System.out.printf("encoding='%s' ", reader.getCharacterEncodingScheme());

                if (reader.isStandalone()) {
                    System.out.print("standalone='yes'");
                } else {
                    System.out.print("standalone='no'");
                }

                System.out.println("?>");

                break;
            }
        }
    }
    
    private static void printName(XMLStreamReader reader){
        if(reader.hasName()){
            // Get the local name of the tag element
            String localName = reader.getLocalName();
            
            if (localName != null) {
                System.out.print(localName);
            }
        }
    }
    
    private static void printAttributes(XMLStreamReader reader){
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            // Get the local name of the attribute
            String localName = reader.getAttributeLocalName(i);
            // Get the value of the attribute
            String value = reader.getAttributeValue(i);
            
            System.out.print(" ");
            
            System.out.printf("%s='%s'", localName, value);
        }
    }
}

package saxvalidator;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 *
 * @author ngadzheva
 */
public class SAXValidator implements ContentHandler{
    private Locator locator;
    private OutputStreamWriter output;
    private final Integer TAB_SIZE = 4;
    private String currentElementName;
    private boolean titleDetected = false;
    private int countOfTitle = 0;
    private boolean linkDetected = false;
    private int countOfLink = 0;
    private boolean descriptionDetected = false;
    private int countOfDescription = 0;
    private boolean itemDetected = false;
    private int countOfItem = 0;

    public SAXValidator(OutputStreamWriter output) {
        this.output = output;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    @Override
    public void startDocument() throws SAXException {
        
    }

    @Override
    public void endDocument() throws SAXException {
        
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        currentElementName = qName;
        validateVersion(atts);
        
        if(qName.equals("item")){
            titleDetected = false;
            linkDetected = false;
            descriptionDetected = false;
            itemDetected = true;
            
            countOfTitle = 0;
            countOfDescription = 0;
            countOfLink = 0;
            ++countOfItem;
        }
        
        if(qName.equals("title")){
            titleDetected = true;
            ++countOfTitle;
        }
        
        if (qName.equals("link")) {
            linkDetected = true;
            ++countOfLink;
        }
        
        if (qName.equals("description")) {
            descriptionDetected = true;
            ++countOfDescription;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("item")) {
            if (!(titleDetected && linkDetected && descriptionDetected && 
                    countOfTitle == 1 && countOfLink == 1 && countOfDescription == 1)) {
                reportError("Item must have one subset of the sequence title, link, description");
            }
        }
        
        if (localName.equals("channel")) {
            if (!(itemDetected && countOfItem >= 2 && countOfItem <= 10)) {
                reportError("Number of elements item must be between 2 and 10");
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        
    }
    
    private void printIndented(String what){
        try {
            output.write(what);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(SAXValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void reportError(String cause){
        printIndented(String.format("\r\nError: %s on line %d column %d.", 
                cause, locator.getLineNumber(), locator.getColumnNumber()));
    }
    
    private void validateVersion(Attributes atts){
        if (atts.getLength() > 0) {
            try{
                if (currentElementName.equals("rss") &&
                        Integer.parseInt(atts.getValue("version")) < 0) {
                    reportError("Attribute version is expected to have a positive integer value.");
                }
            } catch(NumberFormatException e){
                reportError(String.format("Wrong value for version %s. (Attribute"
                        + " version is expected to have a positive integer value)", 
                        atts.getValue("version")));
            }
        }
    }
}

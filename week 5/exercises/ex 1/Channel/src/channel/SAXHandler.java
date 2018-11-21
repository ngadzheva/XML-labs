package channel;

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
public class SAXHandler implements ContentHandler{
    private Locator locator;
    private Integer indent;
    private OutputStreamWriter output;
    private final Integer TAB_SIZE = 4;
    
    public SAXHandler(OutputStreamWriter output) {
        this.output = output;
        this.indent = 0;
    }
    
    @Override
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    @Override
    public void startDocument() throws SAXException {
        try {
            printIndented("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", false, false);
        } catch (IOException ex) {
            Logger.getLogger(SAXHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            printIndented(String.format("<%s", qName), true, false);
            printAttributes(atts);
            printIndented(">\r\n", false, true);
            
            ++indent;
        } catch (IOException ex) {
            Logger.getLogger(SAXHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        --indent;
        
        try {
            printIndented(String.format("</%s>", qName), true, false);
        } catch (IOException ex) {
            Logger.getLogger(SAXHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).toUpperCase().trim();
        
        if(s.length() > 0){
            try {
                printIndented(s, false, false);
            } catch (IOException ex) {
                Logger.getLogger(SAXHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    
    private void printIndented(String what, boolean isEndOfElement, boolean isElement) throws IOException{
        if(isEndOfElement){
            output.write("\r\n");
        }
        
        if(indent > 0 && !isElement){
            output.write(String.format("%1$" + (indent * TAB_SIZE) + "s", ""));
        }
        
        output.write(what);
        output.flush();
    }
    
    private void printAttributes(Attributes atts){
        if(atts.getLength() > 0){
            ++indent;
            
            for (int i = 0; i < atts.getLength(); i++) {
                String name = atts.getQName(i);
                try {
                    printIndented(String.format(" %s = \"%s\"", name, atts.getValue(i)), false, true);
                } catch (IOException ex) {
                    Logger.getLogger(SAXHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            --indent;
        }
    }
}

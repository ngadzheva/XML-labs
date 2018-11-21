package saxtransformato;

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
public class SAXTransformator implements ContentHandler{
    private class Item{
        String title;
        String link;
        String description;
    }
    
    private Locator locator;
    private OutputStreamWriter output;
    private final Integer TAB_SIZE = 4;
    private String currentElement;
    private Integer indent;
    private Item currentItem;
    boolean inItem = false;

    public SAXTransformator(OutputStreamWriter output) {
        this.output = output;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
        indent = 0;
    }

    @Override
    public void startDocument() throws SAXException {
        printIndented("<!DOCTYPE html>");
        printIndented("<html>");
        ++indent;
        
        printIndented("<head><title>List of items</title></head>");
        printIndented("<body>");
        ++indent;
        
        printIndented("<table style=\"border: 1px solid black;\">");
        ++indent;
        
        printIndented("<thead><tr><th>Title</th><th>Link</th><th>Description</th></tr></thead>");
        printIndented("<tbody>");
        ++indent;
    }

    @Override
    public void endDocument() throws SAXException {
        --indent;
        printIndented("</tbody>");
        
        --indent;
        printIndented("</table>");
        
        --indent;
        printIndented("</body>");
        
        --indent;
        printIndented("</html>");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        currentElement = qName;
        
        if ("item".equals(currentElement)) {
            currentItem = new Item();
            inItem = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("item".equals(localName)) {
            printIndented("<tr><td>" + currentItem.title + "</td><td>" + 
                    currentItem.link + "</td><td>" + currentItem.description + "</td></tr>");
            inItem = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        
        if (inItem && s.length() > 0) {
            if ("title".equals(currentElement)) {
                currentItem.title = s;
            }
            
            if ("link".equals(currentElement)) {
                currentItem.link = s;
            }
            
            if ("description".equals(currentElement)) {
                if(currentItem.description == null){
                    currentItem.description = s;
                } else {
                    currentItem.description += s;
                }
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
    
    private void printIndented(String what){
        if (indent > 0) {
            try {
                output.write(String.format("%1$" + (indent * TAB_SIZE) + "s", ""));
                output.write(what + "\r\n");
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(SAXTransformator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    
}

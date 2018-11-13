package sax_basics;

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
    
    Locator locator;
    Integer indent;
    OutputStreamWriter output;
    int TAB_SIZE = 2;

    public SAXHandler(OutputStreamWriter output) {
        this.output = output;
        this.indent = 0;
    }
    

    @Override
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    /**
     * If the current event is the beginning of the document,
     * print the XML declaration
     */
    @Override
    public void startDocument() throws SAXException {
        printIndented("<?xml version='1.0' encoding='utf-8'?>", false, false);
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

    /**
     * If the current event is the start of an element,
     * print the opening tag of the element with its attributes
     * @param uri -  the URI of the element's namespace
     * @param localName - the name of the element
     * @param qName - the prefix of the namepsace
     * @param atts - the attributes of the element
     * @throws SAXException 
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        printIndented(String.format("<%s", qName), true, false);
        printAttributes(atts);
        printIndented(">\r\n", false, true);
        
        ++indent;
    }

    /**
     * If the current event is the end of an element,
     * print its closing tag
     * @param uri - the URI of the element's namespace
     * @param localName - the name of the element
     * @param qName - the prefix of the element
     * @throws SAXException 
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        --indent;
        
        printIndented(String.format("</%s>", qName), true, false);
    }

    /**
     * If the current event is the text node of an element,
     * print its content
     * @param ch - the text content
     * @param start - the start position of the text content
     * @param length - the length of the text content
     * @throws SAXException 
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String textContent = new String(ch, start, length).trim();
        
        if (textContent.length() > 0) {
            printIndented(textContent, false, false);
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
    
    /**
     * Help function for printing the XML document structure indented
     * @param item
     * @param isEndOfElement
     * @param isElement 
     */
    private void printIndented(String item, boolean isEndOfElement, boolean isElement){
        try {
            if (isEndOfElement) {
                output.write("\r\n");
            }
            if (indent > 0 && !isElement) {
                output.write(String.format("%1$" + (indent * TAB_SIZE) + "s", ""));
            }
            
            output.write(item);
            output.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Help function for printing attributes
     * @param atts 
     */
    private void printAttributes(Attributes atts){
        if (atts.getLength() > 0) {
            ++indent;
            
            for (int i = 0; i < atts.getLength(); i++) {
                // Get the name of the attribute
                String name = atts.getQName(i);
                
                // Print the name and the value of the attribute
                printIndented(String.format(" %s = \"%s\"", name, atts.getValue(i)), false, true);
            }
            
            --indent;
        }
    }
}

package dom_basics;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author ngadzheva
 */
public class DOM_Basics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createXMLDocument();
        parseXMLDocument();
    }
    
    private static void createXMLDocument(){
        try {
            DocumentBuilder dBuilder = createDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            buildTree(doc);
            
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("company.xml"));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
    }
    
    private static DocumentBuilder createDocumentBuilder(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            return dBuilder;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    private static void buildTree(Document doc){
        // Create root element and add it to the document
        Element root = doc.createElement("COMPANY");
        doc.appendChild(root);
        
        Element companyName = doc.createElement("name");
        // Set text content (value) to the element
        companyName.setTextContent("XML Tech");
        root.appendChild(companyName);
        
        Element employeeList = doc.createElement("employeeList");
        root.appendChild(employeeList);
        
        Element employee = doc.createElement("employee");
        employeeList.appendChild(employee);
        
        // Create attribute
        Attr empID = doc.createAttribute("empID");
        // Set value to the attribute
        empID.setValue("E00001");
        // Add the attribute to the element
        employee.setAttributeNode(empID);
        
        Element img = doc.createElement("img");
        Attr src = doc.createAttribute("src");
        src.setValue("JohnSmith");
        img.setAttributeNode(src);
        employee.appendChild(img);
        
        Element empName = doc.createElement("name");
        empName.setTextContent("John Smith");
        employee.appendChild(empName);
        
        Element sector = doc.createElement("sector");
        sector.setTextContent("Devs");
        employee.appendChild(sector);
        
        Element hireDate = doc.createElement("hire-date");
        hireDate.setTextContent("25 May 2015");
        employee.appendChild(hireDate);
        
        Element favProgrammerQuote = doc.createElement("favProgrammerQuote");
        favProgrammerQuote.setTextContent("<![CDATA[\n" +
"                    while(noSuccess){\n" +
"                        tryAgain();\n" +
"                        if(Dead)\n" +
"                            break;\n" +
"                    }\n" +
"                ]]>");
        employee.appendChild(favProgrammerQuote);
        
        Element careers = doc.createElement("careers");
        root.appendChild(careers);
        
        Element job = doc.createElement("job");
        // Set attribute and its value to the element
        // If the attribute does not exist, new attribute is created
        job.setAttribute("id", "J00001");
        careers.appendChild(job);
        
        Element position = doc.createElement("position");
        // Create text node of the document
        Text title = doc.createTextNode("XML &amp; HTML developer");
        // Add the text node to the element (it is its text content / value)
        position.appendChild(title);
        job.appendChild(position);
        
        Element status = doc.createElement("status");
        Text statusType = doc.createTextNode("Open");
        status.appendChild(statusType);
        job.appendChild(status);
        
        Element modified = doc.createElement("modified");
        Text modifiedDate = doc.createTextNode("Wed, 17 Oct 2018");
        modified.appendChild(modifiedDate);
        job.appendChild(modified);
        
        Element salary = doc.createElement("salary");
        Text amount = doc.createTextNode("BGN 1500");
        salary.appendChild(amount);
        job.appendChild(salary);
        
        Element contact = doc.createElement("contact");
        root.appendChild(contact);
        
        Element person = doc.createElement("person");
        contact.appendChild(person);
        
        Element firstName = doc.createElement("first_name");
        firstName.setTextContent("Nathan");
        person.appendChild(firstName);
        
        Element lastName = doc.createElement("last_name");
        lastName.setTextContent("Clemons");
        person.appendChild(lastName);
        
        Element email = doc.createElement("email");
        email.setTextContent("nathan@xmldevs.com");
        contact.appendChild(email);
        
        Element phone = doc.createElement("phone");
        phone.setTextContent("0888-888-888");
        contact.appendChild(phone);
    }
    
    private static void parseXMLDocument(){
        try {
            File input = new File("company.xml");
            DocumentBuilder dBuilder = createDocumentBuilder();
            Document doc = dBuilder.parse(input);
            
            parseTree(doc);
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void parseTree(Document doc){
        // Get the root element of the document and print its name
        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());
        
        // Get the first element with tag name "name" and print its text content
        Node companyName = doc.getElementsByTagName("name").item(0);
        System.out.println("Company name: " + companyName.getTextContent());
        
        System.out.println("-------------------------------------------" +
                "-------------------------------------------");
        
        System.out.println("EMPLOYEES");
        System.out.println("Employee ID\t\tName\t\t\tSector\t\tHire Date\t\t\t");
        
        // Get all elements with tag name "employee"
        NodeList employees = doc.getElementsByTagName("employee");
        
        for (int i = 0; i < employees.getLength(); i++) {
            // Get the "employee" element on position i
            Element employee = (Element)employees.item(i);
            // Get all child nodes of the current employee element
            NodeList childNodes = employee.getChildNodes();
            // Get the "empID" attribute value of the current employee element
            String result = employee.getAttribute("empID") + "\t\t\t";
            
            for (int j = 0; j < childNodes.getLength(); j++) {
                Element child = (Element) childNodes.item(j);
                
                if(child.getTagName() != "favProgrammerQuote" && child.getTagName() != "img"){
                    // Get the text content of the current node
                    String childValue = child.getTextContent();
                    result += childValue + "\t\t";
                }
            }
            
            System.out.println(result);
        }
        
        System.out.println("-------------------------------------------" +
                "-------------------------------------------");
        
        System.out.println("JOBS");
        System.out.println("Job ID\t\t\tPosition\t\t\tSalary\t\t\t");
        
        NodeList jobs = doc.getElementsByTagName("job");
        
        for (int i = 0; i < jobs.getLength(); i++) {
            Element job = (Element) jobs.item(i);
            // Get the first child node of the current element
            Element position = (Element) job.getFirstChild();
            // Get the last child node of the current element
            Element salary = (Element) job.getLastChild();
            
            String result = job.getAttribute("id") +  "\t\t\t";
            
            result += position.getTextContent() + "\t";
            result += salary.getTextContent() + "\t\t\t";
            
            System.out.println(result);
        }
    }
}

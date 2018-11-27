<?xml version="1.0" encoding="UTF-8"?>

<!-- Declaration of the root element of the XSL document -->
<!-- The XSL elements are from xsl namespace -->
<!-- fo is the namespace of XSL-FO elements, if any -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <!-- This element defines the type of the output document -->
    <xsl:output method="html"/>

    <!-- This element defines a template starting from the root of the XML document -->
    <!-- The root is not the first element in the XML document, but the document itself -->
    <xsl:template match="/"> 
      <html> 
         <head> 
            <title>Company</title> 
         </head> 
         <body> 
            <h1><xsl:value-of select="COMPANY/name"/></h1> 
            <h3>Employees</h3>

            <table style="border: 2px solid black; padding: 5px; text-align: center;">
                <tr>
                    <th style="padding-right: 10px;">Name</th>
                    <th style="padding-left: 10px;">Sector</th>
                </tr>

                <!-- This element calls a template, matching the selected node -->
                <xsl:apply-templates select="//employeeList"/>
            </table>

            <h3>Jobs</h3>

            <table style="border: 2px solid black; padding: 5px; text-align: center;">
                <tr>
                    <th style="padding-right: 10px;">Position</th>
                    <th style="padding-left: 10px;">Salary</th>
                </tr>

                <!-- This element calls a named template -->
                <xsl:call-template name="jobs"/>
            </table>

            <h3>Contacts</h3>

            <!-- Calling a template with different modes -->
            <p><xsl:apply-templates select="//person" mode="firstName"/> <xsl:apply-templates select="//person" mode="lastName"/></p>
            <ul>
                <li>Email: <xsl:value-of select="//email"/></li>
                <li>Phone: <xsl:value-of select="//phone"/></li>
            </ul>
         </body> 
      </html> 
   </xsl:template> 

   <xsl:template match="//employeeList">
        <!-- Definition of loop -->
        <!-- The template inside the loop is executed for each selected node -->
        <xsl:for-each select="employee">
            <!-- This element sorts the selected nodes in asceding order -->
            <xsl:sort select="name"/>
            <tr>
                <td style="padding-right: 10px;"><xsl:value-of select="name"/></td>
                <td style="padding-left: 10px;"><xsl:value-of select="sector"/></td>
            </tr>
        </xsl:for-each>
    </xsl:template>

    <!-- Definition of named template -->
    <xsl:template name="jobs">
        <xsl:for-each select="//job">
            <!-- The template inside the if element is executed only if the condition
                in test attribute is true -->
            <xsl:if test="status = 'Open'">
                <tr>
                    <td style="padding-right: 10px;"><xsl:value-of select="position"/></td>
                    <td style="padding-left: 10px;"><xsl:value-of select="salary"/></td>
                </tr>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>

    <!-- Definition of template with mode attribute -->
    <xsl:template match="//person" mode="firstName">
        <!-- This element gets the value of the selected node -->
        <xsl:value-of select="first_name"/>
    </xsl:template>

    <xsl:template match="//person" mode="lastName">
        <xsl:value-of select="last_name"/>
    </xsl:template>
</xsl:stylesheet>
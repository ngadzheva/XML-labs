<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="html"/>

   <xsl:template match="/"> 
      <xsl:param name="param1" select="'Track title'"/>
      
      <html> 
         <body> 
            <table> 
               <tr> 
                  <td> 
                     <table border="2" bordercolor="blue" cellspacing="0" cellpadding="2">
                        <xsl:for-each select="//track"> 
                           <xsl:sort select="text()" order="descending"/> 
                           <tr>
                              <th> 
                                 <xsl:value-of select="$param1"/>
                              </th> 
                           </tr>
                           <tr>
                              <td> 
                                 <xsl:value-of select="."/> 
                              </td> 
                           </tr>
                        </xsl:for-each>
                     </table>
                  </td> 
               </tr> 
            </table>              
         </body> 
      </html> 
   </xsl:template> 
</xsl:stylesheet>
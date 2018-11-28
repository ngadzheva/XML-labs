<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <html>
            <header></header>

            <body>
                <p> Track elements with length 4:04 </p>
                <ul>
                    <xsl:for-each select="//track"> 
                        <xsl:if test="@length='4:04'"> 
                           <li><xsl:value-of select="text()"/> </li> 
                        </xsl:if> 
                     </xsl:for-each> 
                </ul>
                <br/>

                <p> Track elements with length less than 15 and their lengths </p>
                <ul>
                    <xsl:for-each select="//track"> 
                        <xsl:if test="string-length(.) &lt; 15"> 
                           <li><xsl:value-of select="text()"/> (<xsl:value-of select="string-length(.)"/>)</li> 
                        </xsl:if> 
                     </xsl:for-each> 
                </ul>
                <br/>

                <p> Track elements on odd position </p>
                <ul>
                    <xsl:for-each select="//track"> 
                        <xsl:if test="position() mod 2 = 0"> 
                           <li><xsl:value-of select="text()"/> </li> 
                        </xsl:if> 
                     </xsl:for-each> 
                </ul>
                <br/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
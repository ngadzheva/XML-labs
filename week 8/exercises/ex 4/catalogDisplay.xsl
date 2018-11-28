<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <header></header>

            <body>
                <xsl:variable name="header">Description</xsl:variable>
               
                <ol>
                    <xsl:for-each select="//track"> 
                        <xsl:sort select="text()" order="descending"/> 
                        <h4> 
                            <xsl:value-of select="$header"/> 
                        </h4> 
                        <li> 
                            <xsl:value-of select="."/> 
                        </li> 
                    </xsl:for-each> 
                </ol>
                <br/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
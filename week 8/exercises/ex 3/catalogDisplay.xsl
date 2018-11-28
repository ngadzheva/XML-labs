<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <header></header>

            <body>
                <p>Sort track elements ascending</p>
                <ol>
                    <xsl:for-each select="//track"> 
                           <xsl:sort select="."/> 
                           <li><xsl:value-of select="text()"/></li> 
                    </xsl:for-each> 
                </ol>
                <br/>

                <p>Sort track elements descending</p>
                <ol>
                    <xsl:for-each select="//track"> 
                           <xsl:sort select="." order="descending"/> 
                           <li><xsl:value-of select="text()"/></li> 
                    </xsl:for-each> 
                </ol>
                <br/>

                <p>Sort track elements formatted</p>
                <xsl:for-each select="//track"> 
                    <xsl:sort select="." order="descending"/> 
                    <xsl:value-of select="text()"/> 
                    <xsl:if test="position() != last()"> 
                        <xsl:text>, </xsl:text> 
                    </xsl:if> 
                </xsl:for-each> 
                <br/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
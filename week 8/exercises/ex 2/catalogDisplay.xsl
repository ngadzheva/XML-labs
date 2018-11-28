<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <header></header>

            <body>
                <xsl:for-each select="//track">
                    <xsl:choose>
                        <xsl:when test="string-length(.) &gt; 15">
                            <p>A big string</p>
                        </xsl:when>

                        <xsl:when test="string-length(.) &lt; 15">
                            <p>A small string</p>
                        </xsl:when>

                        <xsl:otherwise>
                            <p>A medium string</p>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
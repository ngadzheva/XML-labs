<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <header></header>

            <body>
                <p>Year: <xsl:call-template name="year"/></p>
                <p>Title: <xsl:call-template name="title"/></p>
                <p>Artisti: <xsl:call-template name="artist"/></p>
            </body>
        </html>
    </xsl:template>

    <xsl:template name="year">
        <xsl:value-of select="//year/text()"/>
    </xsl:template>

    <xsl:template name="title">
        <xsl:value-of select="//title/text()"/>
    </xsl:template>

    <xsl:template name="artist">
        <xsl:value-of select="//artist/text()"/>
    </xsl:template>
</xsl:stylesheet>
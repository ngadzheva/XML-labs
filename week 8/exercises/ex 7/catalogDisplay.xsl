<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <header></header>

            <body>
            <xsl:for-each select="catalog/cd">
                <p>
                    Year: 
                    <xsl:call-template name="year">
                        <xsl:with-param name="yearName" select="//year"/>
                    </xsl:call-template>
                </p>
                <p>
                    Title: 
                    <xsl:call-template name="title">
                        <xsl:with-param name="titleName" select="//title"/>
                    </xsl:call-template>
                </p>
                <p>
                    Artist: 
                    <xsl:call-template name="artist">
                        <xsl:with-param name="artistName" select="//artist"/>
                    </xsl:call-template>
                </p>
            </xsl:for-each>
            </body>
        </html>
    </xsl:template>

    <xsl:template name="year">
        <xsl:param name="yearName"/>
        <xsl:value-of select="$yearName"/>
    </xsl:template>

    <xsl:template name="title">
        <xsl:param name="titleName"/>
        <xsl:value-of select="$titleName"/>
    </xsl:template>

    <xsl:template name="artist">
        <xsl:param name="artistName"/>
        <xsl:value-of select="$artistName"/>
    </xsl:template>
</xsl:stylesheet>
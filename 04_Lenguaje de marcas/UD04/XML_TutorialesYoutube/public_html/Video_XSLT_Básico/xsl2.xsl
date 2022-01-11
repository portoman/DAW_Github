<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="ies/@nombre"/>
                </title>
                <meta charset="UTF-8"/>
            </head>
            <body>
                <h1>Ciclos formativos</h1>
                <ul>
                    <xsl:apply-templates select="ies/ciclos/ciclo"/>
                </ul>
            </body>
        </html>
    </xsl:template>

    <xsl:value-of select="ies/ciclos/ciclo/nombre"/>

    <xsl:template match="ciclo">
        <li><xsl:value-of select="@id"/>:  <xsl:value-of select="nombre"/></li>
    </xsl:template>
</xsl:stylesheet>

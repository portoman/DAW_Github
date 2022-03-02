<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>UD05_Lista.xsl</title>
            </head>
            <body>
                <xsl:for-each select="inventario/producto">
                    <ul>
                        <li>Producto <xsl:value-of select="@codigo"/></li>
                        <ul>
                            <li>Prezo <xsl:value-of select="precio"/> €</li>
                            <li>Aula <xsl:value-of select="lugar/aula"/></li>
                            <li>Nome <xsl:value-of select="nombre"/></li>
                        </ul>
                    </ul>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

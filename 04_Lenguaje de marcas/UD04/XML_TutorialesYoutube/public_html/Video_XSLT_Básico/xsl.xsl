<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        Este texto se muestra
        <xsl:apply-templates select="biblioteca/libro/autor"/>
    </xsl:template>
    
    <xsl:template match="libro">
        Obtener el valor de un nodo
        - <xsl:value-of select="autor"/>
        - <xsl:value-of select="titulo"/>
        - <xsl:value-of select="fechaPublicacion/@año"/>
    </xsl:template>
    
    
    
    <xsl:template match="autor">
        <p>Nombre: <xsl:value-of select="."/></p>
        <p>Fecha de nacimiento: <xsl:value-of select="@fechaNacimiento"/></p>
    </xsl:template>
    
</xsl:stylesheet>

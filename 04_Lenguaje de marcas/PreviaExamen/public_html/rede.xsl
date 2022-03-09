<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>rede.xsl</title>
                <style>
                    p{
                    font-weight:bold;
                    }
                    .bloque{
                    border:2px solid blue;
                    width:200px;
                    background:yellow;
                    }
                </style>
            </head>
            <body>
                <h1>Equipos de rede</h1>
                <p>Enumeración do almacenamento da red</p>
                <xsl:for-each select="Red/Maquina">
                    <ol>
                            <li>
                                <xsl:value-of select="@Nombre"/> - <xsl:value-of select="Info/Tipo"/>
                            </li>
                            <div class="bloque">
                                Tecnoloxia <xsl:value-of select="Info/Disco/@Tecnologia"/>
                                <br/>
                                Número de discos 
                                <xsl:choose>
                                    <xsl:when test="count(Info/Disco)=1">
                                        HOLA
                                </xsl:when>
                                <xsl:otherwise>
                                    ADIOS
                                </xsl:otherwise>
                                </xsl:choose>
                                
                                <xsl:value-of select="count(Info/Disco)"/> 
                                <br/>
                                Capacidade total <xsl:value-of select="sum(Info/Disco/@Capacidad)"/>
                                <br/>
                                <xsl:choose>
                                    <xsl:when test="Info/Tipo[text()='Servidor']">
                                        IP <xsl:value-of select="Config/IP"/>
                                </xsl:when>
                                </xsl:choose>
                                
                            </div>
                    </ol>
                    
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

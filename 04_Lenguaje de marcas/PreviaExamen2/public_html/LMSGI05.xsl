
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>LMSGI05.xsl</title>
                <style>
                    table{
                    border-collapse:collapse;
                    }
                </style>
            </head>
            <body>
                
                <table>
                    <tr>
                        <th>Convocatoria</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                    </tr>
                    <xsl:for-each select="notas/alumno">
                        <tr>
                            <td>
                                <xsl:value-of select="@convocatoria"/>
                            </td>
                            <td>
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td>
                                <xsl:value-of select="apellidos"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

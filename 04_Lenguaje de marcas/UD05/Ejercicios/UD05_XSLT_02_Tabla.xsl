<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>UD05_Tabla.xsl</title>
                <style>
                    table{
                    border-collapse: collapse;
                    }
                    th,td{
                    border: 2px solid black;
                    padding:10px;
                    text-align:center;
                    }
                    th{
                    background-color:cadetblue;
                    font-family: Verdana, Geneva, Tahoma, sans-serif;
                    }
                    td{
                    background-color: aquamarine;
                    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
                    }
                </style>
            </head>
            <body>
                <table aria-describedby="tabla1" >
                    <tr>
                        <th scope="col">Producto</th>
                        <th scope="col">Prezo</th>
                        <th scope="col">Aula</th>
                    </tr>
                    <xsl:for-each select="inventario/producto">
                        <tr>
                            <td>
                                <xsl:value-of select="@codigo"/>
                            </td>
                            <td>
                                <xsl:value-of select="precio"/>
                            </td>
                            <td>
                                <xsl:value-of select="lugar/aula"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <p id="tabla1" aria-hidden="true">
                    Tabla de la Tarea01 punto 2 de la UD05
                </p>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

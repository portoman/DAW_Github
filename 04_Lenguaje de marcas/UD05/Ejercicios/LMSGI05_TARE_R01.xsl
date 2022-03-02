<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>UD05_Tarefa02.xsl</title>
                <style>
                    table{
                    border-collapse: collapse;
                    }
                    th,td{
                    border: 1px solid black;
                    padding:5px;
                    text-align:center;
                    width:150px;
                    }
                    th{
                    background-color:rgb(153,204,255);
                    }
                    .titulos{
                    background-color:rgb(0,71,255);
                    color:white;
                    }
                    .fondoClaro{
                    background-color:rgb(255,255,153);
                    }
                    .fondoNaranja{
                    background-color:rgb(255,211,32);
                    font-weight: bold;
                    }
                </style>
            </head>
            <body>
                <table aria-describedby="tabla" >
                    <tr>
                        <th scope="col" colspan="2">Datos</th>
                        <th scope="col" colspan="4">Notas</th>
                    </tr>
                    <tr>
                        <td class="titulos">Nome</td>
                        <td class="titulos">Apelidos</td>
                        <td class="titulos">Tarefas</td>
                        <td class="titulos">Cuestionarios</td>
                        <td class="titulos">Exame</td>
                        <td class="titulos">Final</td>
                    </tr>
                    <xsl:for-each select="notas/alumno[@convocatoria='Junio']">
                        <tr>
                            <td>
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td>
                                <xsl:value-of select="apellidos"/>
                            </td>
                            <td class="fondoClaro">
                                <xsl:value-of select="tareas"/>
                            </td>
                            <td class="fondoClaro">
                                <xsl:value-of select="cuestionarios"/>
                            </td>
                            <td class="fondoClaro">
                                <xsl:value-of select="examen"/>
                            </td>
                            <td class="fondoNaranja">
                                <xsl:choose>
                                    <xsl:when test='final&gt;=9'>
                                        SOBRESALIENTE
                                    </xsl:when>
                                    <xsl:when test='final&gt;=7 and final&lt;9'>
                                        NOTABLE
                                    </xsl:when>
                                    <xsl:when test='final&gt;=6 and final&lt;7'>
                                        BEN
                                    </xsl:when>
                                    <xsl:when test='final&gt;=5 and final&lt;6'>
                                        SUFICIENTE
                                    </xsl:when>
                                    <xsl:otherwise>
                                        INSUFICIENTE
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <p id="tabla" aria-hidden="true">
                    Tabla de la Tarea02 de la UD05
                </p>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

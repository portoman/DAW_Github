<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>UD05_Condicional.xsl</title>
                <style>
                    .tablas{
                    display:flex;
                    justify-content: center;
                    gap: 10px;
                    }
                    .tabla1conjunto,.tabla2conjunto{
                    display:flex;
                    flex-direction:column;
                    }
                    table{
                    border-collapse: collapse;
                    }
                    caption{
                    background: blue;
                    color: white;
                    border: 1px solid black;
                    }
                    .tituloTabla{
                    margin: 1%;
                    line-height: 45px;
                    margin-left: 55px;
                    font-size:25px;
                    }
                    img{
                    width: 10%;
                    float: right;
                    margin-right: 9%;
                    margin-top:5px;
                    }
                    th,td{
                    border: 2px solid black;
                    padding:5px;
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
                <section class="tablas">
                    <div class="tabla1conjunto">
                        <table class="tabla1" aria-describedby="desc_tabla1" >
                            <caption>
                                <span class="tituloTabla">Edificio A</span>
                                <img src="img/colegio.png" alt="colegio" title="Icono colegio" longdesc="longdesc/icono.html"/> 
                            </caption>
                            <tr>
                                <th scope="col">Producto</th>
                                <th scope="col">Prezo</th>
                                <th scope="col">Aula</th>
                            </tr>
                            <xsl:for-each select="inventario/producto">
                                <xsl:if test="lugar[@edificio='A']">
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
                                </xsl:if>
                            </xsl:for-each>
                        </table>
                        <p id="desc_tabla1" aria-hidden="true">
                            Tabla del edificio A de la Tarea01 punto 3 de la UD05 
                        </p>
                    </div>
                    <div class="tabla2conjunto">
                        <table class="tabla2" aria-describedby="desc_tabla2" >
                            <caption>
                                <span class="tituloTabla">Edificio B</span>
                                <img src="img/colegio.png" alt="colegio" title="Icono colegio" longdesc="longdesc/icono.html"/> 
                            </caption>
                            <tr>
                                <th scope="col">Producto</th>
                                <th scope="col">Prezo</th>
                                <th scope="col">Aula</th>
                            </tr>
                            <xsl:for-each select="inventario/producto">
                                <xsl:if test="lugar[@edificio='B']">
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
                                </xsl:if>
                            </xsl:for-each>
                        </table>
                        <p id="desc_tabla2" aria-hidden="true">
                            Tabla del edificio B de la Tarea01 punto 3 de la UD05 
                        </p>
                    </div>
                </section>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

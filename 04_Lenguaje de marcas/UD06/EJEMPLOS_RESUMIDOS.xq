"1------------",
(: ejemplo 1 :)
doc("canciones.xml")/MiBibliotecaMP3/archivo/canción,

"2------------",

(: ejemplo 2 :)
doc("canciones.xml")/MiBibliotecaMP3/archivo[puntuacion=10],

"3------------",

(: ejemplo 3 :)
doc("canciones.xml")/MiBibliotecaMP3/archivo[puntuacion>8]/canción,

"4------------",

(: ejemplo 4 :)
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i/puntuacion>8
return $i/canción,

"5------------",

<html>
<head>
<title>Ejemplo 5</title>
</head>

<body>
<ol>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i/puntuacion>8
order by $i/puntuacion
return <li> {$i/canción}({$i/puntuacion}) </li>
}
</ol>
</body>
</html>,

"6------------",

<html>
<head>
<title>Ejemplo 6</title>
</head>

<body>
<ol>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i/puntuacion>8
order by $i/puntuacion
return <li> {data($i/canción)}({data($i/puntuacion)}) </li>
}
</ol>
</body>
</html>,

"7------------",

<html>
<head>
<title>Ejemplo 7</title>
</head>
<body>
<ol>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i/puntuacion>8
order by $i/puntuacion
return <li class="{data($i/@almacenado)}"> {data($i/canción)}({data($i/puntuacion)}) </li>
}
</ol>
</body>
</html>,

"8------------",

<html>
<head>
<title>Ejemplo 8</title>
</head>

<body>
<table>
<caption>DISCO 1 </caption>
<tr><td>Artista</td><td>Disco</td></tr>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
order by $i/puntuacion
return if ($i/@almacenado="DISCO1")
then <tr><td>{data($i/artista)}</td><td>{data($i/disco)}</td></tr>
else ()
}
</table>

<table>
<caption>DISCO 2 </caption>
<tr><td>Artista</td><td>Disco</td></tr>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
order by $i/puntuacion
return if ($i/@almacenado="DISCO2")
then <tr><td>{data($i/artista)}</td><td>{data($i/disco)}</td></tr>
else ()
}
</table>
</body>
</html>,

"9------------",

<html>
<head>
<title>Ejemplo 9</title>
</head>

<body>
<table>
<caption>CANCIONES POR DISCO </caption>
<tr><td>Artista</td><td>Nombre disco</td><td>Grabada en</td></tr>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
order by $i/puntuacion
return if ($i/@almacenado="DISCO1")
then <tr><td>{data($i/artista)}</td><td>{data($i/disco)}</td>
     <td>DISCO1</td></tr>
else <tr><td>{data($i/artista)}</td><td>{data($i/disco)}</td>
     <td>DISCO2</td></tr>
}
</table>
</body>
</html>,

"10------------",

<html>
<head>
<title>Ejemplo 10</title>
</head>

<body>
<table>
<caption>CANCIONES DE METALLICA </caption>
<tr><td>Canción</td><td>Disco</td><td>Grabada en</td></tr>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i/artista="Metallica"
order by $i/puntuacion
return <tr><td>{data($i/artista)}</td><td>{data($i/disco)}</td>
     <td>{data($i/@almacenado)}</td></tr>
}
</table>
</body>
</html>,

"11------------",

(: ejemplo 11 :)

for $i in (1 to 10)
return $i,

"12------------",

<html>
<head>
<title>Ejemplo 12</title>
</head>

<body>
<ul>
{
for $i at $j in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i/puntuacion>8
order by $i/puntuacion
return <li>{$j}. {data($i/canción)}({data($i/puntuacion)}) </li>
}
</ul>
</body>
</html>,

"13------------",

for $i in (1 to 5), $j in (1,2,3)
return <resultado>i es {$i} j es {$j}</resultado>,

"14------------",

let $i := (1 to 10)
let $j := (1,2,3)
let $k := 1 
return <resultado>i es {$i} j es {$j} k es {$k}</resultado>,

"15------------",

<html>
<head>
<title>Ejemplo 15</title>
</head>
<body>
<ol>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i/puntuacion=8 or $i/puntuacion=10
order by $i/puntuacion
return <li class="{data($i/@almacenado)}"> {data($i/canción)}({data($i/puntuacion)}) </li>
}
</ol>
</body>
</html>,

"16------------",
<html>
<head>
<title>Ejemplo 16</title>
</head>
<body>
<ol>
{
(: canciones de grupos cuyo nombre empieza por "M" y 
   tienen puntuación de 9	:)
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i[substring(artista,1,1)="M"] and $i/puntuacion=9
order by $i/puntuacion
return <li> {data($i/canción)}({data($i/artista)}) </li>
}
</ol>
</body>
</html>,

"17------------",

<html>
<head>
<title>Ejemplo 17</title>
</head>
<body>
<ol>
{
(: canciones de grupos cuyo nombre empieza por "M" y 
   NO tienen puntuación de 9	:)
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
where $i[substring(artista,1,1)="M"] and not($i/puntuacion=9)
order by $i/puntuacion
return <li> {data($i/canción)}({data($i/artista)}) </li>
}
</ol>
</body>
</html>,

"18------------",

<html>
<head>
<title>Ejemplo 18</title>
</head>

<body>
<table>
<caption>CANCIONES POR DISCO </caption>
<tr><td>Artista</td><td>Nombre</td><td>Grabada en</td></tr>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
order by $i/artista ascending, $i/canción descending
return <tr><td>{data($i/artista)}</td><td>{data($i/canción)}</td>
     <td>{data($i/@almacenado)}</td></tr>
}
</table>
</body>
</html>,

"19------------",

<html>
<head>
<title>Ejemplo 19</title>
</head>

<body>
<table>
<caption>CANCIONES POR DISCO </caption>
<tr><td>Artista</td><td>Nombre</td><td>Grabada en</td></tr>
{
for $i in doc("canciones.xml")/MiBibliotecaMP3/archivo
let $numero := (substring($i/@almacenado,6,1))
order by $i/artista ascending, $i/canción descending
return <tr><td>{upper-case(data($i/artista))}</td><td>{data($i/canción)}</td>
     <td>{$numero}</td></tr>
}
</table>
</body>
</html>,

"20------------"



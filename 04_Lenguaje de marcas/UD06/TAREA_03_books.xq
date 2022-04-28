(:1. Devuelve títulos de libros con un precio superior al precio medio de todos los libros.:)

for $libro in doc("books.xml")//catalog/book
let $precioMedio := avg(doc("books.xml")//catalog/book/price) 
where $libro/price>$precioMedio
return $libro/title,

"2-------------",

(:2. Devuelve una lista de los libros que no pertenezcan a la categoría "Fantasy". Para cada libro indicar el título, su tipo, su precio y su id (como un atributo). Los libros se presentarán en orden decreciente por precio.:)

for $libro in doc("books.xml")//catalog/book
where $libro/genre!='Fantasy' order by number($libro/price) descending
return 
<libro id="{data($libro/@id)}">
<titulo>{data($libro/title)}</titulo>
<tipo>{data($libro/genre)}</tipo>
<precio>{data($libro/price)}</precio>
</libro>,

"3-------------",

(:3.Devuelve la suma de los precios de todos los libros de la categoría "Fantasy" cuyo primer nombre del autor sea "Eva".:)

sum(for $libro in doc("books.xml")//catalog/book
where $libro/genre='Fantasy' and substring-after($libro/author[1], ', ')="Eva"
return $libro/price),

"4-------------",

(:4. Devuelve el libro con la fecha de publicación más antigua.:)

for $libro in doc("books.xml")//catalog/book
let $fechaMasAntigua:=min(for $libro in doc("books.xml")//catalog/book
return xs:date($libro/publish_date))
where $libro/publish_date=$fechaMasAntigua
return $libro,

"5-------------",

(:5. Devuelve el segundo libro que tiene el precio más bajo de todos los libros (puede haber más de uno con el precio más bajo) y que pertenece a la categoría "Romance".:)

(for $libro in doc("books.xml")//catalog/book
let $PrecioMasBajo := (for $libro in doc("books.xml")//catalog/book
let $precio := number($libro/price)
group by $precio
order by $precio ascending
return $precio)[1]
where $libro/price=$PrecioMasBajo and $libro/genre="Romance"
return $libro)[2],

"6-------------",

(:6. Devuelve un listado con todos los autores individuales (distintos) así como los libros que escribieron. :)

for $libro in doc("books.xml")//catalog/book
let $autor:=$libro/author[1]
group by $autor
return <autor>
<nombre>{$autor}</nombre>
<libros>{$libro/title}</libros>
</autor>,

"7-------------",

(:7. Devuelve los títulos de los libros agrupados por categoría o género.:)

for $libro in doc("books.xml")//catalog/book
let $genero:=$libro/genre
group by $genero
return <libros género="{$genero}">
<titulo>{$libro/title}</titulo>
</libros>



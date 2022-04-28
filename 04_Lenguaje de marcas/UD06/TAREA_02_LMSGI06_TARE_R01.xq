(:1. Obter o nome de todos os alumnos matriculados nalgún módulo.:)

for $alumno in doc("LMSGI06_TARE_R01.xml")/clase/alumnos/alumno
where $alumno/@cod = $alumno/../../notas/nota/@alum
return data(substring-after($alumno/apenom, ',')),

"2------------",

(:2. Obter as cualificacións do alumno de código "n43483437" en cada módulo.:)

for $nota in doc("LMSGI06_TARE_R01.xml")/clase/notas/nota,
$asignatura in $nota/../../asignaturas/asignatura
where $nota/@alum = "n43483437" and $asignatura/@cod=$nota/@asig
return <asignatura>{data($asignatura/nombre)}, nota: {data($nota/calificacion)}</asignatura>,

"3------------",
(:3. Obter o nome e o teléfono de cada alumno ordenado por apelidos de forma descendente.:)

for $alumno in doc("LMSGI06_TARE_R01.xml")/clase/alumnos/alumno
order by $alumno/apenom descending
return <alumno>Nome:{data(substring-after($alumno/apenom, ','))}, teléfono: {data($alumno/telef)}</alumno>,


"4------------",
(:4. Cantos módulos hai?:)

for $asignaturas in doc("LMSGI06_TARE_R01.xml")/clase/asignaturas
return <modulo>Cantidad: {data(count($asignaturas/asignatura))}</modulo>, 

"5------------",
(:5. Obter os nomes dos alumnos matriculados en LMSGI e as súas notas. ordenado por notas.:)

for $alumno in doc("LMSGI06_TARE_R01.xml")/clase/alumnos/alumno,
$nota in $alumno/../../notas/nota,
$asignatura in $alumno/../../asignaturas/asignatura
where $asignatura/nombre = "LMSGI" and 
$nota/@asig=$asignatura/@cod and 
$alumno/@cod=$nota/@alum
order by $nota 
return <alumno>{data(substring-after($alumno/apenom, ','))}, nota: {data($nota/calificacion)}</alumno>,

"6------------",
(:6. Obter os nomes e as cualificacións dos matriculados en FH que aprobaron.:)

for $alumno in doc("LMSGI06_TARE_R01.xml")/clase/alumnos/alumno,
$nota in $alumno/../../notas/nota,
$asignatura in $alumno/../../asignaturas/asignatura
where $asignatura/nombre = "FH" and 
$nota/@asig=$asignatura/@cod and 
$alumno/@cod=$nota/@alum and 
$nota/calificacion>=5
return <alumno>{data(substring-after($alumno/apenom, ','))}, nota: {data($nota/calificacion)}</alumno>
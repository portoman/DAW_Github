(:A partir do ficheiro artistas.xml, escribe consultas XQuery que devolvan:
1. Nome e país de todos os artistas.:)

for $artista in doc("artistas.xml")//artistas/artista
return <artista>{($artista/nombreCompleto,$artista/pais)}</artista>,

"2---------",
(:2. O nome (sen etiquetas) dos artistas que naceron antes de 1500.:)

for $artista in doc("artistas.xml")//artistas/artista
where $artista/nacimiento<1500
return $artista/nombreCompleto,

"3---------",

(:3. Nome dos artistas para os que non haxa ano de falecemento.:)

for $artista in doc("artistas.xml")//artistas/artista
where not($artista/fallecimiento)
return $artista/nombreCompleto,

"4---------",
(:4. Unha lista HTML co nome dos artistas nados en España.:)

<ul>
{
for $artista in doc("artistas.xml")//artistas/artista
where $artista/pais="España"
return <li>{data($artista/nombreCompleto)}</li>
}
</ul>,

"5---------",

(:O número de artistas nados antes de 1600.:)

count(for $artista in doc("artistas.xml")//artistas/artista
where number($artista/nacimiento)<1600
return $artista),

"1---------",
(:A partir do ficheiro impresoras.xml, escribe as consultas XQuery que devolvan:
1. Modelo das impresoras de tipo "láser".:)

for $impresora in doc("impresoras.xml")//impresoras/impresora
where $impresora/@tipo="láser"
return <impresora>{$impresora/modelo}</impresora>,

"2---------",
(:2. Marca e modelo das impresoras con máis dun tamaño .:)

for $impresora in doc("impresoras.xml")//impresoras/impresora
where count($impresora/tamaño)>1
return <impresora>{($impresora/marca,$impresora/modelo)}</impresora>,

"3---------",

(:3. Marca e modelo das impresoras con tamaño A3 (poden ter outros).:)

for $impresora in doc("impresoras.xml")//impresoras/impresora
where $impresora/tamaño="A3"
return <impresora>{($impresora/marca,$impresora/modelo)}</impresora>,

"4---------",
(:4. Marca e modelo das impresoras con tamaño A3 como único tamaño .:)

for $impresora in doc("impresoras.xml")//impresoras/impresora
where $impresora/tamaño="A3" and count($impresora/tamaño)=1
return <impresora>{($impresora/marca,$impresora/modelo)}</impresora>,

"5---------",
(:5. Modelo das impresoras en rede.:)

for $impresora in doc("impresoras.xml")//impresoras/impresora
where $impresora[enred]
return $impresora/modelo
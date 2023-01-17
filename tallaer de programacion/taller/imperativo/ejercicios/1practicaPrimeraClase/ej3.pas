{
2. Netflix ha publicado la lista de películas que estarán disponibles durante el mes de diciembre de 2021. De cada película se conoce: código de película, código de género (1: acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror)
y puntaje promedio otorgado por las críticas.
Implementar un programa modularizado que:
a. Lea los datos de películas y los almacene por orden de llegada y agrupados por código de género, en una estructura de datos adecuada. La lectura finaliza cuando se lee el código de la película -1.
b. Una vez almacenada la información, genere un vector que guarde, para cada género, el código de película con mayor puntaje obtenido entre todas las críticas.
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos métodos vistos en la teoría.
d. Luego de ordenar el vector, muestre el código de película con mayor puntaje y el código de película con menor puntaje
}


program ej3;
const
	maxCodGenero=8;
	
type
	
	rango=1..maxCodGenero;
	
	
	pelicula=record
		codPelicula:integer;
		codGenero:rango;
		puntajePromedio:real;
	end;
	
	
	lista=^nodo;
	nodo=record
		datos:pelicula;
		sig:lista;
	end;
	
	vec = array[rango] of lista;

	
	peliPuntaje = record
		puntaje:real;
		codigo:integer;
	end;
	
	vecProm = array[rango] of peliPuntaje;
		
procedure ingresarPeliculas(var v:vec);

	
	procedure inicializarListas(var v:vec);
	var
		i:integer;
	begin
		for i:= 1 to maxCodGenero do 
			v[i]:=nil;
	end;
	
	
	procedure agregarAlFinal(var pri,ult:lista; p:pelicula);
	var
		nue:lista;
	begin
		new(nue);
		nue^.datos:=p;
		nue^.sig:=nil;
		if(pri = nil) then
			pri:=nue
		else
			ult^.sig:=nue;
		ult:=nue;
	end;
	
	
	procedure leerPeli(var p:pelicula);
	begin
		writeln('Ingrese el codigode la pelicula: ');
		readln(p.codPelicula);
		if(p.codPelicula<>-1) then begin
			writeln('Ingrese el codigo de genero: ');
			readln(p.codGenero);
			writeln('Ingrese el promedio de la pelicula: ');
			readln(p.puntajePromedio);
		end;
	end;
	
var
	p:pelicula; ult:lista;
begin
	inicializarListas(v);
	leerPeli(p);
	while(p.codPelicula<>-1) do begin
		agregarAlFinal(v[p.codGenero],ult,p);
		leerPeli(p);
	end;
end;



procedure mayorPuntaje(var vec:vecProm; v:vec);

	procedure vecEnCero(var vec:vecProm);
	var
		i:integer;
	begin
		for i:=1 to maxCodGenero do
			vec[i].puntaje:=0;
	end;
	
	
var
	i:integer;
begin
	vecEnCero(vec);
	for i:=1 to maxCodGenero do begin
		while (v[i]<>nil) do begin
			if(v[i]^.datos.puntajePromedio>vec[i].puntaje) then begin
				vec[i].puntaje:= v[i]^.datos.puntajePromedio;
				vec[i].codigo:= v[i]^.datos.codPelicula;
			end;
			v[i]:=v[i]^.sig;
		end;
	end;
end;



procedure seleccion(var vec:vecProm; maxCodGenero:integer);
var
	i,p,j:integer;
	item:peliPuntaje;
begin
	for i:= 1 to maxCodGenero-1 do begin
		p:=i;
		for j:= i+1 to maxCodGenero do
			if (vec[j].puntaje < vec[p].puntaje) then p:=j;
		item:=vec[p];
		vec[p]:=vec[i];
		vec[i]:=item;
	end;
end;


var
	v:vec;
	v2:vecProm;
begin
	ingresarPeliculas(v);	//a
	mayorPuntaje(v2, v);	//b
	seleccion(v2,maxCodGenero);	//c
	writeln('Pelicula con menor puntaje: ',v2[1].codigo);
	writeln('Pelicula con mayor puntaje: ',v2[maxCodGenero].codigo)
end.

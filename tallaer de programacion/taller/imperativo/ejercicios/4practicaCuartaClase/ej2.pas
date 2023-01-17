program ej2;

const
	maxGen = 8;
	valorGrande=9999;
type
	pelicula = record
		codPelicula:integer;
		codGenero:1..maxGen;
		puntajePromedio:real;
	end;
	
	lista=^nodo;
	nodo=record
		datos:pelicula;
		sig:lista;
	end;
	
	vec=array [1..maxGen] of lista;


procedure InsertarElementoEnLista(var l: lista; p:pelicula);
var ant, nuevo, act: lista;
begin
	new (nuevo);
	nuevo^.datos:= p;
	act := l;
	{Recorro mientras no se termine la lista y no encuentro la posición correcta}
	while (act <> NIL) and (act^.datos.codPelicula < p.codPelicula) do begin
		ant := act;
		act := act^.sig ;
	end;
	if (act = l)  then l:= nuevo   {el dato va al principio}
				   else ant^.sig  := nuevo; {va entre otros dos o al final}
	 nuevo^.sig := act ;
end;


procedure crearListaQueSeDispone(var l:lista);
	procedure leer(var p:pelicula);
	begin
		writeln('Ingresar codPelicula: ');
		readln(p.codPelicula);
		if(p.codPelicula<>0)then begin
			writeln('Ingresar codGenero: ');
			p.codGenero:=random(7)+1;
			writeln('Ingresar puntaje promedio: ');
			p.puntajePromedio:=random(100)+1;
		end;
	end;
	
var
	p:pelicula;
begin
	l:=nil;
	leer(p);
	while(p.codPelicula <> -1) do begin
		InsertarElementoEnLista(l,p);
		leer(p);
	end;
end;

procedure leerLista(l:lista; var v:vec);

	
	procedure CrearListasEnVector (var v: vec);
	var i: integer;
	begin
		for i:= 1 to maxGen do v [i]:= nil
	end;
	
	
	procedure leerListaYOrdenarEnEstructura(l:lista);
	begin
		if(l=nil)then writeln('Lista vacia.')
		else begin
			InsertarElementoEnLista(v[l^.datos.codGenero], l^.datos);
			leerListaYOrdenarEnEstructura(l^.sig);
			end;
	end;

begin
	CrearListasEnVector(v);
	leerListaYOrdenarEnEstructura(l);
end;

procedure imprimirLista(l:lista);
begin
	if(l <> nil) then begin
		writeln('codPelicula: ', l^.datos.codPelicula,'. codGenero: ', l^.datos.codGenero,'. puntaje promedio: ',l^.datos.puntajePromedio:0:2,'.');
		imprimirLista(l^.sig);
	 end;
end;

procedure imprimirVecDeListas(v:vec);
var
	i:integer;
begin
	for i:=1 to maxGen do begin
		writeln('cod genero ', i);
		if(v[i]=nil)then writeln('cod genero ', i,' vacio.')
		else
			imprimirLista(v[i]);
	end;
end;

procedure merge(v:vec; var lm:lista);

	procedure AgregarAtras (var l, ult: lista; p:pelicula); 
	   var  nuevo: lista;
	   begin 
		 new (nuevo); nuevo^.datos:= p; nuevo^.sig := nil;
		 if (l = nil) then l:= nuevo
					  else ult^.sig := nuevo;
		 ult := nuevo;
	   end;
	
	procedure minimo(var v:vec; var pmin:pelicula);
	var
		indicemin,i:integer;
	begin
		pmin.codPelicula:=valorGrande;
		for i:=1 to maxGen do begin
			if(v[i]<>nil)then
				if(v[i]^.datos.codPelicula <= pmin.codPelicula) then begin
					indicemin:=i;
					pmin:=v[i]^.datos;
				end;
		end;
		if(pmin.codPelicula<>valorGrande)then v[indicemin]:=v[indicemin]^.sig;
	end;
var
	pmin:pelicula;
	ult:lista;
begin
	lm:=nil;
	minimo(v,pmin);
	while(pmin.codPelicula <> valorGrande)do begin
		agregarAtras(lm,ult,pmin);
		minimo(v,pmin);
	end;
end;
		

var
	l,lm:lista;
	v:vec;
begin
	Randomize;
	crearListaQueSeDispone(l);
	leerLista(l,v);
	imprimirVecDeListas(v);
	merge(v,lm);
	imprimirLista(lm);
end.

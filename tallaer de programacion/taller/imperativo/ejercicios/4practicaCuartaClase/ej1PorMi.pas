program ej1;
const
	dimF=12;
	valorGrande=9999;
type
	prestamo=record
		isbn:integer;
		numSocio:integer;
		dia:1..31;
		mes:1..dimF;
		diasP:integer;
	end;
	
	lista=^nodo;
	nodo=record
		datos:prestamo;
		sig:lista;
	end;
	
	vector=array[1..dimF] of lista;
	
	
	
	elemenAcumulador = record
		isbn:integer;
		total:integer;
	end;
	
	listaElemAcu=^nodoAcumulador;
	nodoAcumulador=record
		datos:elemenAcumulador;
		sig:listaElemAcu;
	end;
	
	

procedure puntoA(var v:vector);


	procedure ponerEnNil(var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to dimF do v[i]:=nil;
	end;
	
	procedure leerPrestamo( var p:prestamo);
	begin
		writeln('Ingrese isbn del libro: ');
		readln(p.isbn);
		if(p.isbn<>-1)then begin
			writeln('ingrese num socio: ');
			p.numSocio:= random(100) + 100;
			writeln(p.numSocio);
			writeln('Dia prestado: ');
			p.dia:= random(30)+1;
			writeln(p.dia);
			writeln('Mes prestado: ');
			p.mes:= random(13);
			writeln(p.mes);
			writeln('Cant de dias prestado: ');
			p.diasP:=random(15) + 1;
		end;
	end;
	
	procedure ingresarOrdenado( var l:lista; p:prestamo);
	var
		nue,act,ant:lista;
	begin
		new(nue);
		nue^.datos:=p;
		act:=l;
		ant:=l;
		while(act<>nil) and (act^.datos.isbn < p.isbn) do begin
			ant:=act;
			act:=act^.sig;
		end;
		if(act=ant)then 
			l:=nue
		else
			ant^.sig:=nue;
		nue^.sig:=act;
	end;
	
var
	p:prestamo;
begin
	ponerEnNil(v);
	leerPrestamo(p);
	while(p.isbn<>-1)do begin
		ingresarOrdenado(v[p.mes],p);
		leerPrestamo(p);
	end;
end;


procedure leer(l:lista);
begin
	if(l<>nil) then begin
		writeln('isbn: ',l^.datos.isbn);
		writeln('numSocio: ', l^.datos.numSocio);
		leer(l^.sig);
	end;
end;

procedure imprimirVectorDeListas(v:vector);
var
	i:integer;
begin
	for i:=1 to dimF do begin
		writeln('mes: ', i);
		if(v[i] = nil) then writeln('vacio el mes: ',i)
		else
			leer(v[i]);
	end;
end;




procedure merge(v:vector; var ln:lista);

	procedure agregarAtras(var l,ult:lista; p:prestamo);
	var
		nue:lista;
	begin
		new(nue);
		nue^.datos:=p;
		nue^.sig:=nil;
		if (l=nil) then
			l:=nue
		else
			ult^.sig:=nue;
		ult:=nue;
	end;
	
	
	
	procedure minimo(var v:vector; var prestamoMin:prestamo);
	var
		indiceMin,i:integer;
	begin
		prestamoMin.isbn:=valorGrande;
		for i:= 1 to dimF do begin
			if(v[i]<>nil)then
				if(v[i]^.datos.isbn <= prestamoMin.isbn) then begin
					indiceMin:=i;
					prestamoMin:=v[i]^.datos;
				end;
		end;
		if(prestamoMin.isbn<>valorGrande) then
			v[indiceMin]:=v[indiceMin]^.sig;
	end;
var
	prestamoMin:prestamo;
	ult:lista;
begin
	ln:=nil;
	minimo(v,prestamoMin);
	while(prestamoMin.isbn <> valorGrande) do begin
		agregarAtras(ln,ult,prestamoMin);
		minimo(v,prestamoMin);
	end;
	
end;

procedure leermerge(l:lista);
begin
	writeln('-----estructura merge-----');
	if(l=nil) then writeln('Vacio')
	else
		leer(l);
end;


procedure mergeAcumulativo(v:vector; var la:listaElemAcu);

	procedure agregarAtras2(var l,ult:listaElemAcu; e:elemenAcumulador);
	var
		nuevo:listaElemAcu;
	begin
		new(nuevo);
		nuevo^.datos:=e;
		nuevo^.sig:=nil;
		if (l=nil) then
			l:=nuevo
		else
			ult^.sig:=nuevo;
		ult:=nuevo;
	end;
	
	

	procedure minimo(var v:vector; var isbnMin:prestamo);
	var
		indiceMin,i:integer;
	begin
		isbnMin.isbn:=valorGrande;
		for i:=1 to dimF do
			if(v[i]<>nil)then
				if(v[i]^.datos.isbn <= isbnMin.isbn)then begin
					indiceMin:=i;
					isbnMin:=v[i]^.datos;
				end;
		if(isbnMin.isbn <> valorGrande) then
			v[indiceMin]:=v[indiceMin]^.sig;
	end;

var
	isbnMin:prestamo;
	actual:elemenAcumulador;
	ult:listaElemAcu;
begin
	la:=nil;
	minimo(v,isbnMin);
	while(isbnMin.isbn <> valorGrande)do begin
		actual.isbn:=isbnMin.isbn;
		actual.total:=0;
		while((isbnMin.isbn <> valorGrande)and(actual.isbn = isbnMin.isbn)) do begin
			actual.total:=actual.total+1;
			minimo(v,isbnMin);
		end;
	agregarAtras2(la,ult,actual)
	end;
end;

procedure imprimirEstructuraMergeAcumulativa(l:listaElemAcu);
	procedure imprimirListaAcumulador(l:listaElemAcu);
	begin
		if(l<>nil)then begin
			writeln('isbn: ', l^.datos.isbn,'. Total prestamos: ', l^.datos.total);
			imprimirListaAcumulador(l^.sig);
		end;
	end;
begin
	writeln('-----estructura merge acumulativa-----');
	if(l=nil) then writeln('Vacio')
	else
		imprimirListaAcumulador(l);
end;



var
	v:vector;
	ln:lista;
	la:listaElemAcu;
begin
	Randomize;
	puntoA(v);
	imprimirVectorDeListas(v);
	merge(v,ln);
	leermerge(ln);
	mergeAcumulativo(v,la);
	imprimirEstructuraMergeAcumulativa(la);
end.

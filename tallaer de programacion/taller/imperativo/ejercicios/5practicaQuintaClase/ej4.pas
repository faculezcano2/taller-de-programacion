program ej4;


const
	dimF=7;
	valorGrande=9999;
type
	entrada=record
		dia:1..dimF;
		codObra:integer;
		asiento:integer;
		monto:real;
	end;
	
	lista=^nodo;
	nodo=record
		datos:entrada;
		sig:lista;
	end;
	
	vec=array[1..dimF]of lista;
	
	acVenta=record
		codObra:integer;
		cant:integer;
	end;
	
	listaAc=^nodoAc;
	nodoAc=record
		datos:acVenta;
		sig:listaAc;
	end;
	

procedure puntoA(var v:vec);
	procedure ponerEnNil(var v:vec);
	var
		i:integer;
	begin
		for i:=1 to dimF do v[i]:=nil;
	end;
	
	procedure leerEntrada(var e:entrada);
	begin
		writeln('ingrese cod de obra: ');
		readln(e.codObra);
		if(e.codObra <> 0)then begin
			writeln('ingrese dia de la obra: ');
			e.dia:=random(6)+1;
			writeln('ingrese el asiento: ');
			e.asiento:=random(10)+1;
			writeln('ingrese el monto: ');
			e.monto:=random(100)+1;
		end;
	end;
	
	
	procedure ingresarOrdenado(var l: lista; e:entrada);
	var ant, nuevo, act: lista;
	begin
		new (nuevo);
		nuevo^.datos:= e;
		act := l;
		{Recorro mientras no se termine la lista y no encuentro la posición correcta}
		while (act <> NIL) and (act^.datos.codObra < e.codObra) do begin
			ant := act;
			act := act^.sig ;
		end;
		if (act = l)  then l:= nuevo   {el dato va al principio}
					   else ant^.sig  := nuevo; {va entre otros dos o al final}
		 nuevo^.sig := act ;
	end;

var
	e:entrada;
begin
	ponerEnNil(v);
	leerEntrada(e);
	while(e.codObra <> 0)do begin
		ingresarOrdenado(v[e.dia],e);
		leerEntrada(e);
	end;
end;


procedure leerLista(l:lista);
begin
	if(l<>nil)then begin
		writeln('cod de obra: ', l^.datos.codObra,'. dia de la obra: ',l^.datos.dia,'. asiento: ',l^.datos.asiento,'. monto: ',l^.datos.monto,'.');
		leerLista(l^.sig);
	end;
end;


procedure leerVecDeListas(v:vec);
var 
	i:integer;
begin
	for i:=1 to dimF do begin
		writeln('Dia: ',i);
		if(v[i] = nil) then writeln('Lista vacia.')
		else
			leerLista(v[i]);
	end;
end;


procedure puntoBMergeAcumulador(v:vec; var lm:listaAc);
	
	procedure agregarAtras(var l,ult:listaAc; av:acVenta);
	var
		nuevo:listaAc;
	begin
		new(nuevo);
		nuevo^.datos:=av;
		nuevo^.sig:=nil;
		if (l=nil) then
			l:=nuevo
		else
			ult^.sig:=nuevo;
		ult:=nuevo;
	end;
	
	procedure minimo(var v:vec; var emin:entrada);
	var
		indicemin,i:integer;
	begin
		emin.codObra:=valorGrande;
		for i:=1 to dimF do begin
			if(v[i]<>nil)then
				if(v[i]^.datos.codObra <= emin.codObra)then begin
					indicemin:=i;
					emin.codObra:=v[i]^.datos.codObra;
				end;
		end;
		if(emin.codObra<>valorGrande)then v[indicemin]:=v[indicemin]^.sig;
	end;

var
	emin:entrada;
	av:acVenta;
	ult:listaAc;
begin
	lm:=nil;
	minimo(v,emin);
	while(emin.codObra<>valorGrande)do begin
		av.codObra:=emin.codobra;
		av.cant:=0;
		while((emin.codObra<>valorGrande)and(av.codObra=emin.codobra))do begin
			av.cant:=av.cant+1;
			minimo(v,emin);
		end;
		agregarAtras(lm,ult,av);
	end;
end;

procedure leerlistamerge(lm:listaAc);
begin
	if(lm<>nil)then begin
		writeln('codObra: ',lm^.datos.codObra,'. totalVendido: ',lm^.datos.cant);
		leerlistamerge(lm^.sig);
	end;
end;

var
	v:vec;
	lm:listaAc;
begin
	randomize;
	puntoA(v);
	leerVecDeListas(v);
	puntoBMergeAcumulador(v,lm);
	leerlistamerge(lm);
end.

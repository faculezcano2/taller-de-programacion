program ej3;

const
	dimF=4;
	valorGrande=9999;
type
	venta=record
		fecha:integer;
		codProducto:integer;
		codSucursal:0..dimF;
		cantVendida:integer;
	end;
	
	
	lista=^nodo;
	nodo=record
		datos:venta;
		sig:lista;
	end;
	
	vec=array[1..dimF] of lista;
	
	totVenta=record
		codProducto:integer;
		total:integer;
	end;
	
	listaAc=^nodoAc;
	nodoAc=record
		datos:totVenta;
		sig:listaAc;
	end;
	
	
procedure ingresarOrdenado(var l: lista; ve:venta);
var ant, nuevo, act: lista;
begin
	new (nuevo);
	nuevo^.datos:= ve;
	act := l;
	{Recorro mientras no se termine la lista y no encuentro la posición correcta}
	while (act <> NIL) and (act^.datos.codProducto < ve.codProducto) do begin
		ant := act;
		act := act^.sig ;
	end;
	if (act = l)  then l:= nuevo   {el dato va al principio}
				   else ant^.sig  := nuevo; {va entre otros dos o al final}
	 nuevo^.sig := act ;
end;
	
procedure puntoA(var v:vec);
	procedure ponerEnNil(var v:vec);
	var
		i:integer;
	begin
		for i:=1 to dimF do v[i]:=nil;
	end;
	
	procedure leerVenta(var ve:venta);
	begin
		writeln('ingrese el codigo de la sucursal: ');
		readln(ve.codSucursal);
		if(ve.codSucursal <> 0) then begin
			writeln('Ingrese la fecha de la venta: ');
			ve.fecha:=random(30)+1;
			writeln('Ingrese el codigo de producto: ');
			ve.codProducto:=random(20)+1;
			writeln('ingrese la cantidad vendida: ');
			ve.cantVendida:=random(10)+1;
		end;
	end;
var
	ve:venta;
begin
	ponerEnNil(v);
	leerVenta(ve);
	while(ve.codSucursal <> 0)do begin
		ingresarOrdenado(v[ve.codSucursal],ve);
		leerVenta(ve);
	end;
end;

procedure leerLista(l:lista);
begin
	if(l<>nil)then begin
		writeln('codigo de la sucursal: ', l^.datos.codSucursal,'. fecha de la venta: ', l^.datos.fecha,'. codigo de producto: ', l^.datos.codProducto,'. cantidad vendida: ', l^.datos.cantVendida);
		leerLista(l^.sig);
	end;
end;

procedure leerVecDeListas(v:vec);
var
	i:integer;
begin
	for i:=1 to dimF do begin
		writeln('sucursal ',i);
		if(v[i]=nil)then writeln('Lista Vacia.')
		else
			leerLista(v[i]);
	end;	
end;


procedure puntoBMergeAcumulador(v:vec; var lm:listaAc);

	procedure agregarAtras(var l,ult:listaAc; tv:totVenta);
	var
		nuevo:listaAc;
	begin
		new(nuevo);
		nuevo^.datos:=tv;
		nuevo^.sig:=nil;
		if (l=nil) then
			l:=nuevo
		else
			ult^.sig:=nuevo;
		ult:=nuevo;
	end;


	procedure minimo(var v:vec; var vmin:venta);
	var
		indicemin,i:integer;
	begin
		vmin.codProducto:=valorGrande;
		indicemin:=-1;
		for i:=1 to dimF do begin
			if(v[i]<>nil)then
				if(v[i]^.datos.codProducto <= vmin.codProducto) then begin
					indicemin:=i;
					vmin:=v[i]^.datos;
				end;
		end;
		if(vmin.codProducto<>valorGrande)then begin
			v[indicemin]:=v[indicemin]^.sig;
		end;
	end;
var
	vmin:venta;
	ult:listaAc;
	
	actual:totVenta;
begin
	lm:=nil;
	minimo(v,vmin);
	while(vmin.codProducto <> valorGrande) do begin
		actual.codProducto:=vmin.codProducto; actual.total:=0;
		while((vmin.codProducto <> valorGrande)and(vmin.codProducto=actual.codProducto))do begin
			actual.total:=actual.total + vmin.cantVendida;
			minimo(v,vmin);
		end;
		agregarAtras(lm,ult,actual);
	end;
end;

procedure leerlistamerge(l:listaAc);
begin
	if(l<>nil)then begin
		writeln('codProducto: ', l^.datos.codProducto,'. totalVentasProducto: ', l^.datos.total,'.');
		leerlistamerge(l^.sig);
	end;
end;



var
	v:vec;
	lm:listaAc;
begin
	puntoA(v);
	leerVecDeListas(v);
	puntoBMergeAcumulador(v,lm);
	leerlistamerge(lm);
end.

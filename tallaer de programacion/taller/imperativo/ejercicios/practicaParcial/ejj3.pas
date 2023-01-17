program ej;

//Enunciado:

{Se lee información acerca de las ventas de productos realizadas en las 5 sucursales de una empresa.
De cada venta se conoce el código de producto, cantidad vendida y monto total de la venta. 
Las ventas de cada sucursal se leen de manera consecutiva y ordenadas por código de producto. 
La lectura por cada sucursal finaliza cuando se lee el código de producto -1, el cual no se procesa. 
Implementar un programa para que a partir de la información leida, resuelva los siguientes ítems:

a) Utilizando la técnica de merge o merge acumulador según corresponda, generar una lista que
contenga la cantidad total vendida para cada código de producto, ordenada por código de
producto.

b) Realizar un módulo recursivo que reciba la lista generada en el punto a y retorne la cantidad de
productos para los cuales la cantidad total vendida supera las 500 unidades.}

const
	valorGrande=9999;

type

	venta=record
		codProducto:integer;
		cantVendida:integer;
		montoVenta:integer;
	end;
	
	listaVentas=^nodoV;
	nodoV=record
		datos:venta;
		sig:listaVentas;
	end;
	
	vec = array [1..5] of listaVentas;
	
	
	datosMerge=record
		codProducto:integer;
		cantTotal:integer;
	end;
	
	listamerge=^nodomerge;
	nodoMerge=record
		datos:datosMerge;
		sig:listamerge;
	end;
	
	
procedure leerInfo( var v:vec);
	procedure leerVenta(var ve:venta);
	begin
		writeln('ingrese cod producto: ');
		readln(ve.codProducto);
		if(ve.codProducto <> -1) then begin
			writeln('Ingrese cant vendida: ');
			readln(ve.cantVendida);
			writeln('Ingrese el monto de la venta: ');
			readln(ve.montoVenta);
		end;
	end;
	
	procedure ingresarOrdenado(var l: listaVentas; ve:venta);
	var ant, nuevo, act: listaVentas;
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
var
	ve:venta;
	i:integer;
begin
	for i:=1 to 5 do begin
		v[i]:=nil;
		leerVenta(ve);
		while(ve.codProducto <> -1) do begin
			ingresarOrdenado(v[i],ve);
			leerVenta(ve);
		end;
	end;
end;

procedure incisoA(v:vec; var lm:listamerge);
	procedure minimo(var v:vec; var vmin:venta);
	var
		indicemin,i:integer;
	begin
		vmin.codProducto:=valorGrande;
		for i:=1 to 5 do begin
			if(v[i]<>nil)then
				if(v[i]^.datos.codProducto <= vmin.codProducto) then begin
					indicemin:=i;
					vmin.codProducto:=v[i]^.datos.codProducto;
				end;
		end;
		if(vmin.codProducto <> valorGrande) then v[indicemin]:=v[indicemin]^.sig;
	end;
	
	procedure agregarAtras(var l,ult:listamerge; d:datosMerge);
	var
		nuevo:listamerge;
	begin
		new(nuevo);
		nuevo^.datos:=d;
		nuevo^.sig:=nil;
		if (l=nil) then
			l:=nuevo
		else
			ult^.sig:=nuevo;
		ult:=nuevo;
	end;

var
	vmin:venta;
	d:datosMerge;
	ult:listamerge;
begin
	lm:=nil;
	minimo(v,vmin);
	while(vmin.codProducto<>valorGrande)do begin
		d.codProducto:=vmin.codProducto;
		d.cantTotal:=0;
		while((d.codProducto <> valorGrande) and (d.codProducto = vmin.codProducto))do begin
			d.cantTotal:= d.cantTotal + vmin.cantVendida;
			minimo(v,vmin);
		end;
		agregarAtras(lm,ult,d);
	end;
end;



procedure incisoB(lm:listamerge);
	procedure recorrer(lm:listamerge; var cant:integer);
	begin
		if( lm<>nil) then begin
			if(lm^.datos.cantTotal >= 500) then
				cant:=cant+1;
			recorrer(lm^.sig,cant);
		end;
	end;
var
	cant:integer;
begin
	cant:=0;
	recorrer(lm,cant);
	writeln('la cantidad de productos para los cuales la cantidad total vendida supera las 500 unidades: ',cant);
end;



var
	v:vec;
	lm:listamerge;
begin
	leerInfo(v);
	incisoA(v,lm);
	incisoB(lm);
end.

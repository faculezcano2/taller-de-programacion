program ej1;

const
	maxVentas = 20;
	maxVendido = 99;
	maxCod = 15;


type

	rango = 1..maxVentas;

	venta = record
		codProducto:0..maxCod;
		cantVenta:1..maxVendido;
	end;

	lista = ^nodo;
	nodo = record
		datos:venta;
		sig:lista;
	end;

	vecVentas = array [rango] of venta;
	vecOrdenado = array [rango] of venta;

//------------------------------------------------


procedure leerVenta(var ven:venta);
begin
	Randomize;
	ven.codProducto:=random(16);
	writeln('Codigo de producto: ',ven.codProducto);
	if(ven.codProducto <> 0) then begin
		writeln('Ingrese la cantidad del producto: ');
		readln(ven.cantVenta);
	end;
end;


procedure cargarVenta(var v:vecVentas; var dimL:integer);
var
	ven:venta;
begin
	leerVenta(ven);
	while (ven.codProducto <> 0) and (dimL < maxVentas)do begin
		dimL:=dimL+1;
		v[dimL]:= ven;
		leerVenta(ven);
	end;
end;


procedure leerVector(v:vecVentas; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do begin
		writeln('Venta ',i);
		writeln('Codigo del producto: ', v[i].codProducto);
		writeln('Cantidad vendida: ', v[i].cantVenta);
	end;
end;

procedure ordenarVector(var v:vecVentas; dimL:integer);
var
	i,j,p:integer;
	item:venta;
begin
	for i:= 1 to dimL-1 do begin
		p:=i;
		for j:=i+1 to dimL do
			if (v[j].codProducto < v[p].codProducto) then p:=j;
			
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;



procedure eliminarDelVector(var v:vecVentas; var dimL:integer; elemenDesde,elemenHasta:integer);
var
	i,j:integer;
begin
	i:=1;
	while((1<dimL) and (v[i].codProducto < elemenHasta))do begin
		if(v[i].codProducto>elemenDesde) then begin
			for j:= i to dimL-1 do 
				v[j]:=v[j+1];
			dimL:=dimL-1;
		end;
		i:=i+1;
	end;
end;


procedure agregarAtras( var l,ult:lista; ven:venta);
var
	nue:lista;
begin
	new(nue);
	nue^.datos:=ven;
	nue^.sig:=nil;
	if(l=nil)then
		l:=nue
	else
		ult^.sig:=nue;
	ult:=nue;
end;

procedure asignar(var ven:venta; codigo,venta:integer);
begin
	ven.codProducto:=codigo;
	ven.cantVenta:=venta;
end;

procedure cargarLista(v:vecVentas; dimL:integer ;var l:lista);
var
	//ven:venta; 
	ult:lista; 
	i:integer;
begin
	for i:=1 to dimL do begin
		if(((v[i].codProducto mod 2)=0))then begin
			//asignar(ven,v[i].codProducto,v[i].cantVenta);
			agregarAtras(l,ult,v[i]);
		end;
	end;
end;

procedure leerLista(l:lista);
begin
	while(l <> nil) do begin
		writeln('Codigo del producto: ',l^.datos.codProducto);
		writeln('Cantidad vendida: ', l^.datos.cantVenta);
		l:=l^.sig;
	end;
end;

var
	v:vecVentas;
	dimL:integer;
	desde,hasta:integer;
	l:lista;
begin
	l:=nil;
	dimL:=0;
	cargarVenta(v,dimL);	//A
	writeln('-----------------------------PRIMER LECTURA-----------------------------');
	leerVector(v,dimL);		//B
	ordenarVector(v,dimL);	//C
	writeln('-----------------------------ORDENADO-----------------------------');
	leerVector(v,dimL);		//D
	writeln('Ingrese posicion desde donde borrar: ');
	readln(desde);
	writeln('Ingrese posicion hasta donde borrar: ');
	readln(hasta);
	eliminarDelVector(v,dimL,desde,hasta);
	writeln('-----------------------------BORRADO-----------------------------');
	leerVector(v,dimL);
	cargarLista(v,dimL,l);
	writeln('-----------------------------LISTA-----------------------------');
	leerLista(l);
end.


program ej;
{//Enunciado:

Se lee información acerca de las ventas de productos realizadas en las sucursales de una empresa. De
cada venta se conoce fecha, código de producto, cantidad vendida y monto total de la venta. La lectura
finaliza cuando se lee el código de producto -1, el cual no se procesa. Implementar un programa para
que a partir de la información leida, resuelva los siguientes ítems:

a) Generar un árbol binario de búsqueda ordenado por código de producto, donde cada nodo
contenga el código del producto y la cantidad total vendida. El código de producto no puede
repetirse en el árbol.

b) Realizar un módulo que reciba el árbol generado en a. y dos códigos de producto y retorne la suma
de todas las cantidades vendidas para los códigos de productos comprendidos en el rango.

Nota: La información se lee en forma desordenada. Puede existir mas de una venta para un mismo
código de producto.}

type
	venta=record
		fecha:integer;
		codigo:integer;
		cant:integer;
		monto:real;
	end;
	
	
	totVen=record
		codigo:integer;
		cantTotal:integer;
	end;
	
	arbol=^nodo;
	nodo=record
		datos:totVen;
		hi:arbol;
		hd:arbol;
	end;
	
	
procedure puntoA(var a:arbol);
	procedure leerVenta(var v:venta);
	begin
		writeln('Ingrese codigo de producto: ');
		readln(v.codigo);
		if(v.codigo<>-1)then begin
			writeln('Ingrese la fecha de la venta: ');
			readln(v.fecha);
			writeln('Ingrese la cantidad vendida:' );
			readln(v.cant);
			writeln('Ingrese el monto total: ');
			readln(v.monto);
		end;
	end;
	
	procedure cargarArbol(var a:arbol; v:venta);
	begin
		if(a=nil)then begin
			new(a);
			a^.datos.codigo:=v.codigo;
			a^.datos.cantTotal:=v.cant;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if(a^.datos.codigo = v.codigo) then begin
			a^.datos.cantTotal:= a^.datos.cantTotal + v.cant;
		end
		else if(v.codigo < a^.datos.codigo) then cargarArbol(a^.hi,v)
		else
			cargarArbol(a^.hd,v);
	end;
var
	v:venta;
begin
	a:=nil;
	leerVenta(v);
	while(v.codigo <> -1) do begin
		cargarArbol(a,v);
		leerVenta(v);
	end;
end;



procedure leerArbol(a:arbol);
begin
	if(a<>nil) then begin
		writeln('codigo de producto: ', a^.datos.codigo);
		writeln('Total vendido: ', a^.datos.cantTotal);
		leerArbol(a^.hi);
		leerArbol(a^.hd);
	end;
end;


procedure puntoB(a:arbol);
	procedure entreDosVal(a:arbol; vi,vf:integer; var cant:integer);
	begin
		if(a<>nil)then
			if(vi <= a^.datos.codigo) then
				if(vf >= a^.datos.codigo) then begin
					cant:=cant+a^.datos.cantTotal;
					entreDosVal(a^.hi,vi,vf,cant);
					entreDosVal(a^.hd,vi,vf,cant);
				end
			else
				entreDosVal(a^.hi,vi,vf,cant)
			else
				entreDosVal(a^.hd,vi,vf,cant);
	end;
var
	vi,vf,cant:integer;
begin
	cant:=0;
	writeln('Ingrese el cod de producto desde donde empezar a sumar sus cant vendidas: ');
	readln(vi);
	writeln('Ingrese el cod de producto hasta donde sumar sus cant vendidas: ');
	readln(vf);
	entreDosVal(a,vi,vf,cant);
	writeln('la cantidad vendida de productos entre los dos codigos que ingresaste es de: ', cant);
end;


var
	a:arbol;
begin
	puntoA(a);
	leerArbol(a);
	puntoB(a);
end.

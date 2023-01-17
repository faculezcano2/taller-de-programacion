program ej2;

type

	venta=record
		codProducto:integer;
		fecha:integer;
		cant:integer;
	end;
	
	totalventa=record
		codProducto:integer;
		total:integer;
	end;
	
	arbol1=^nodo1;
	nodo1=record
		dato:venta;
		hi:arbol1;
		hd:arbol1;
	end;
	
	arbol2=^nodo2;
	nodo2=record
		dato:totalventa;
		hi:arbol2;
		hd:arbol2;
	end;
	
	
procedure generarArbol( var a1:arbol1; var a2:arbol2);
	procedure leerVenta( var v:venta);
		begin
			writeln('Ingrese el cod del producto: ');
			readln(v.codProducto);
			if(v.codProducto <> 0)then begin
				writeln('Ingrese fecha de la venta: ');
				readln(v.fecha);
				writeln('Ingrese la cantidad de la venta: ');
				readln(v.cant);
			end;
		end;
		
		
	procedure insertarElemento(var a1:arbol1; v:venta);
	begin
		if(a1=nil) then begin
			new(a1);
			a1^.dato:=v;
			a1^.hi:=nil;
			a1^.hd:=nil;
		end
		else if(v.codProducto < a1^.dato.codProducto) then insertarElemento(a1^.hi, v)
			else
				insertarElemento(a1^.hd,v);
	end;
	
	
	procedure insertarElemento2(var a2:arbol2; v:venta);
	begin
		if(a2=nil) then begin
			new(a2);
			a2^.dato.codProducto:=v.codProducto;
			a2^.dato.total:=v.cant;
			a2^.hi:=nil;
			a2^.hd:=nil;
		end
		else if(v.codProducto < a2^.dato.codProducto) then insertarElemento2(a2^.hi,v)
		else if(v.codProducto > a2^.dato.codProducto) then insertarElemento2(a2^.hd,v)
		else if(a2^.dato.codProducto = v.codProducto  ) then begin
			a2^.dato.codProducto:=v.codProducto;
			a2^.dato.total:= a2^.dato.total + v.cant;
			a2^.hi:=nil;
			a2^.hd:=nil;
		end
	end;
	
	
	
	
	procedure imprimirEnOrdenCreciete(a1:arbol1);
	begin
	if(a1<>nil) then begin
		imprimirEnOrdenCreciete(a1^.hi);
		writeln('codProducto a1: ',a1^.dato.codProducto);
		imprimirEnOrdenCreciete(a1^.hd);
	end;
	end;
	
	
	procedure imprimirEnOrdenCreciete2(a2:arbol2);
	begin
	if(a2<>nil) then begin
		imprimirEnOrdenCreciete2(a2^.hi);
		writeln('codProducto a2 :',a2^.dato.codProducto,' total productos a2: ',a2^.dato.total);
		imprimirEnOrdenCreciete2(a2^.hd);
	end;
	end;
	

var
	v:venta;
begin
	a1:=nil;
	a2:=nil;
	leerVenta(v);
	while(v.codProducto <> 0)do begin
		insertarElemento(a1,v);
		insertarElemento2(a2,v);
		leerVenta(v);
	end;
	imprimirEnOrdenCreciete(a1);
	imprimirEnOrdenCreciete2(a2);
end;

procedure cantEnPrimerArbol(a1:arbol1);
	procedure buscar(a1:arbol1; x:integer; var cant:integer);
	begin
		if(a1 = nil) then cant:=00
		else if (x = a1^.dato.codProducto) then cant:=cant + a1^.dato.cant
		else if(x < a1^.dato.codProducto) then buscar(a1^.HI,x,cant)
		else buscar(a1^.HD,x,cant);
	end;
var
	x,cant:integer;
begin
	writeln('ingrese el cod de producto a buscar y sumar sus cantidades vendidas: ');
	readln(x);
	buscar(a1,x,cant);
	writeln('La cantidad vendida de ese producto es de: ',cant);
end;



procedure cantEnSegundoArbol(a2:arbol2);
	procedure buscar(a2:arbol2; x:integer; var cant:integer);
	begin
		if(a2 = nil) then cant:=00
		else if (x = a2^.dato.codProducto) then cant:=cant + a2^.dato.total
		else if(x < a2^.dato.codProducto) then buscar(a2^.HI,x,cant)
		else buscar(a2^.HD,x,cant);
	end;
var
	x,cant:integer;
begin
	writeln('ingrese el cod de producto a buscar y sumar sus cantidades vendidas: ');
	readln(x);
	buscar(a2,x,cant);
	writeln('La cantidad vendida de ese producto es de: ',cant);
end;

var
	a1:arbol1;
	a2:arbol2;
begin
	generarArbol(a1,a2);
	cantEnPrimerArbol(a1);
	cantEnSegundoArbol(a2);
end.

program ej;

{Una perfumería dispone en papel de la información de las ventas de sus productos.
De cada venta se conoce código de producto, tipo de producto, fecha, cantidad vendida,
monto total de la venta.

Se pide realizar un programa que:
a) A partir de la información de ventas ingresadas por teclado, genere un ABB que almacene
    para cada código de producto, su tipo y la información de todas sus ventas (fecha,
    cantidad vendida, monto de la venta). El ABB debe estar ordenado por código de producto.
    El ingreso de información finaliza cuando se lee cantidad vendida -1.

b) Luego de generada la estructura, informar (debe implementar un módulo para cada inciso):
    i - El tipo de los productos cuyo código está comprendido entre los valores 1500 y 2200.
    ii – La cantidad de ventas cuyo monto total resultó superior a 100 p}


type
	venta=record
		cod:integer;
		tipo:string;
		fecha:string;
		cant:integer;
		total:real;
	end;
	
	reg1=record
		fecha:string;
		cantVen:integer;
		monto:real;
	end;
	
	lista=^nodo1;
	nodo1=record
		datos:reg1;
		sig:lista;
	end;
	
	reg2=record
		codPro:integer;
		tipo:string;
		ventas:lista;
	end;
	
	
	arbol=^nodo;
	nodo=record
		datos:reg2;
		hi:arbol;
		hd:arbol;
	end;
	

procedure generarArbol(var a:arbol);
	procedure leer(var v:venta);
	begin
		writeln('Ingrese la cantidad vendida: ');
		readln(v.cant);
		if(v.cant<>-1)then begin
			writeln('ingrese cod de producto: ');
			readln(v.cod);
			write('Ingrese tipo ');
			readln(v.tipo);
			write('Ingrese fecha ');
			readln(v.fecha);
			write('Ingrese monto ');
			readln(v.total);
		end;
	end;
	
	
	procedure agregarOrdenado(var l : lista; v : venta);
	var
	  aux, ant, act : lista;
	begin
	  new(aux);
	  aux^.datos.fecha := v.fecha;
	  aux^.datos.cantVen := v.cant;
	  aux^.datos.monto := v.total;
	  act := l;
	  ant := l;
	  while(act <> nil) and (v.fecha > act^.datos.fecha) do begin
		ant := act;
		act := act^.sig;
	  end;
	  if(act = ant) then
		l := aux
	  else
		ant^.sig := aux;
	  aux^.sig := act;
	end;
	
	
	procedure crearArbol(var a : arbol; v : venta);
	begin
	  if(a = nil) then begin
		new(a);
		a^.datos.codPro := v.cod;
		a^.datos.tipo := v.tipo;
		a^.datos.ventas := nil;
		agregarOrdenado(a^.datos.ventas,v);
	  end
	  else
		if(v.cod < a^.datos.codPro) then
		  crearArbol(a^.hi,v)
		else
		  if(v.cod > a^.datos.codPro) then
			crearArbol(a^.hd,v)
		  else
			if(v.cod = a^.datos.codPro) then
			  agregarOrdenado(a^.datos.ventas,v);
	end;
var
	v:venta;
begin
	a:=nil;
	leer(v);
	while(v.cant<>-1)do begin
		crearArbol(a,v);
		leer(v);
	end;
end;
	


procedure entreDosVal(a:arbol);
	procedure entre(a:arbol; vi,vf:integer);
	begin
		if(a<>nil) then begin
			if(a^.datos.codPro > vi)then
				if(a^.datos.codPro < vf) then begin
					writeln('tipo: ', a^.datos.tipo );
					entre(a^.hi,vi,vf);
					entre(a^.hd,vi,vf);
				end
			else
				entre(a^.hi,vi,vf)
			else
				entre(a^.hd,vi,vf);
		end;
	end;
var
	vi,vf:integer;
begin
	vi:=1500;
	vf:=2200;
	entre(a,vi,vf);
end;


procedure cantidad(a:arbol);
	procedure totalenl(l:lista; var cant:integer);
	begin
		if(l<>nil)then begin
			if(l^.datos.monto > 100) then cant:=cant+1;
			totalenl(l^.sig,cant);
		end;
	end;
	procedure totalEnA(a:arbol; var cant:integer);
	begin
		if(a<>nil)then begin
			totalenl(a^.datos.ventas,cant);
			totalEnA(a^.hi,cant);
			totalEnA(a^.hd,cant);
		end;
	end;
var
	cant:integer;
begin
	cant:=0;
	totalEnA(a,cant);
	writeln('cantidad totales que superan los 100 pesos: ', cant);
end;

	
var
	a:arbol;
begin
	generarArbol(a);
	entreDosVal(a);
	cantidad(a);
end.
	
	

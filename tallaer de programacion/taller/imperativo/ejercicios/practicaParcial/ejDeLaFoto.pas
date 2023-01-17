

type
	compra=record
		cod:integer;
		dia:integer;
		cantidadProd:integer;
		monto:real;
	end;
	
	lista = ^nodo;
	nodo=record
		datos:compra;
		sig:lista;
	end;
	
	compraar=record
		cod:integer;
		lis:lista;
	end;
	
	arbol = ^nodoar;
	nodoar=record
		datos:compraar;
		hi:arbol;
		hd:arbol;
	end;


procedure incisioA(var a:arbol);
	procedure leer(var c:compra);
	begin
		writeln('ingrese la cant de productos: ');
		c.cantidadProd:=random(30);
		writeln(c.cantidadProd);
		if(c.cantidadProd <> 0) then begin
			writeln('codCliente: ');
			readln(c.cod);
			//c.cod:=random(99)+1;
			writeln(c.cod);
			writeln('dia de la compra: ');
			c.dia:=random(31)+1;
			writeln(c.dia);
			writeln('Monto: ');
			c.monto:=random(800)+150.80;
			writeln(c.monto);
		end;
	end;
	
	procedure agregarOrdenado(var l : lista; c:compra);
	var
	  aux, ant, act : lista;
	begin
	  new(aux);
	  aux^.datos.cod := c.cod;
	  aux^.datos.dia := c.dia;
	  aux^.datos.cantidadProd:= c.cantidadProd;
	  aux^.datos.monto := c.monto;
	  act := l;
	  ant := l;
	  while(act <> nil) and (c.cod > act^.datos.cod) do begin
		ant := act;
		act := act^.sig;
	  end;
	  if(act = ant) then
		l := aux
	  else
		ant^.sig := aux;
	  aux^.sig := act;
	end;
	
	procedure crearArbol(var a:arbol; c:compra);
	begin
		if(a=nil)then begin
			new(a);
			a^.datos.cod:=c.cod;
			a^.datos.lis:=nil;
			agregarOrdenado(a^.datos.lis,c);
		end
		else if(c.cod < a^.datos.cod) then crearArbol(a^.hi,c)
		else if(c.cod > a^.datos.cod) then crearArbol(a^.hd,c)
		else if(c.cod = a^.datos.cod) then agregarOrdenado(a^.datos.lis,c);
	end;
	
var
	c:compra;
begin
	a:=nil;
	leer(c);
	while(c.cantidadProd <> 0) do begin
		crearArbol(a,c);
		leer(c);
	end;
end;


procedure incisoB(a:arbol; cod:integer; var lc:lista);
	procedure leerLista(l:lista);
	begin
		if(l<>nil)then begin
			writeln('cod: ',l^.datos.cod,'. di: ',l^.datos.dia,'. cantidad productos: ', l^.datos.cantidadProd,'. monto: ',l^.datos.monto);
			leerLista(l^.sig);
		end;
	end;
	
	procedure buscarcod(a:arbol; cod:integer; var lc:lista);
	begin
		if(a<>nil)then begin
			if(cod < a^.datos.cod) then buscarcod(a^.hi,cod,lc)
			else if(cod > a^.datos.cod) then buscarcod(a^.hd,cod,lc)
			else if(cod = a^.datos.cod) then begin lc:=a^.datos.lis;
					leerLista(a^.datos.lis);
				end;
		end;
	end;
begin
	buscarcod(a,cod,lc);
end;


procedure incisoC(lc:lista; var max:real);
	procedure maxi(lc:lista; cantProductos:integer);
	begin
		if(lc<>nil)then begin
			if(lc^.datos.cantidadProd > cantProductos) then begin
				cantProductos:=lc^.datos.cantidadProd;
				max:=lc^.datos.monto;
			end
			else
				maxi(lc^.sig,cantProductos);
		end;
	end;
var
	cantProductos:integer;
begin
	cantProductos:=0;
	maxi(lc,cantProductos);
end;

var
	a:arbol;
	cod:integer;
	lc:lista;
	max:real;
begin
	incisioA(a);
	writeln('ingrese el codigo de cliente a buscar y leer todas sus compras: ');
	readln(cod);
	incisoB(a,cod,lc);
	max:=0;
	incisoC(lc,max);
	writeln('el monto de la compra con mayor cant de productos es de: ',max:0:2);
end.

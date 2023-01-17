program facundolezcano;
//ej gimnasios
const
	maxGims=5;
type
	asistencia=record
		codSucursal:1..maxGims;
		dni:integer;
		codigo:integer;
		fecha:integer;
		cantMinutos:integer;
	end;
	
	totAsistencias=record
		dni:integer;
		cod:integer;
		totMin:integer;
	end;
	
	arbol=^nodo;
	nodo=record
		datos:totAsistencias;
		hi:arbol;
		hd:arbol;
	end;
	
	
	lista=^nodoLista;
	nodoLista=record
		dni:integer;
		sig:lista;
	end;
	
	
procedure generarArbol(var a:arbol);
	procedure leerAsistencia( var asi:asistencia);
	begin
		writeln('ingrese el dni: ');
		readln(asi.dni);
		if(asi.dni <> -1)then begin
			writeln('ingrese cod sucursal: ');
			readln(asi.codSucursal);
			writeln('ingrese codigo de cliente: ');
			readln(asi.codigo);
			writeln('ingrese fecha: ');
			readln(asi.fecha);
			writeln('Ingese cant de minutos: ');
			readln(asi.cantMinutos);
		end;
	end;
	
	procedure crearArbol(var a:arbol; asi:asistencia);
	begin
		if(a=nil)then begin
			new(a);
			a^.datos.dni:=asi.dni;
			a^.datos.cod:=asi.codigo;
			a^.datos.totMin:=asi.cantMinutos;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if(asi.dni < a^.datos.dni) then crearArbol(a^.hi,asi)
		else
			crearArbol(a^.hd,asi);
	end;
var
	asi:asistencia;
begin
	a:=nil;
	leerAsistencia(asi);
	while(asi.dni<>-1)do begin
		crearArbol(a,asi);
		leerAsistencia(asi);
	end;
end;


procedure generarLista(var l:lista; dniing:integer; a:arbol);
	procedure agregarAtras(var l,ult:lista; dni:integer);
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.dni:=dni;
		nuevo^.sig:=nil;
		if (l=nil) then
			l:=nuevo
		else
			ult^.sig:=nuevo;
		ult:=nuevo;
	end;
	
	procedure recorrer(a:arbol; var l:lista; dniing:integer);
	var
		ult:lista;
	begin
		if(a<>nil)then begin
			if(a^.datos.dni > dniing) then
				if(a^.datos.totMin mod 2 <> 0)then  begin
					agregarAtras(l,ult,a^.datos.dni);
					recorrer(a^.hi,l,dniing);
					recorrer(a^.hd,l,dniing);
				end
			else
				recorrer(a^.hd,l,dniing);
		end;
	end;
begin
	l:=nil;
	recorrer(a,l,dniing);
end;

var
	a:arbol;
	dniing:integer;
	l:lista;
begin
	generarArbol(a);
	writeln('ingrese dni a partir del cual se agregan a la lista: ');
	readln(dniing);
	generarLista(l,dniing,a);
end.

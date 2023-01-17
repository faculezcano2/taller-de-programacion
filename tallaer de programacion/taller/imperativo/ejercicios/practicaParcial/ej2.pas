program ej;
{Un psicólogo necesita un sistema para administrar a sus pacientes. De cada paciente registra: 
dni, cód. de paciente, obra social (1: ioma 2: pami 3: osde 4: galeno 5: no tiene) y costo abonado 
por sesión. 

Implemente un programa que: 

a) Genere un ABB ordenado por dni. Para ello, genere información hasta el paciente con dni 0. 

A partir del ABB, realice módulos (uno por inciso) para:

b) Generar una estructura con dni y cód de paciente de los pacientes de ioma, ordenados 
     por dni descendente.
c) Dado un dni, modificar la obra social de dicho paciente a una recibida. Considere que el 
     paciente puede no existir. 

NOTA: Realice el programa principal que invoque a los módulos desarrollados}

type
	paciente=record
		dni:integer;
		cod:integer;
		obra:1..5;
		costo:real;
	end;
	
	arbol=^nodo;
	nodo=record
		datos:paciente;
		hi:arbol;
		hd:arbol;
	end;
	
	pacIoma=record
		dni:integer;
		cod:integer;
	end;
	
	lista=^nodol;
	nodol=record
		datos:pacIoma;
		sig:lista;
	end;
	
	
procedure incisoA(var a:arbol);
	
	procedure leerP(var p:paciente);
	begin
		writeln('Ingrese dni del paciente: ');
		readln(p.dni);
		if(p.dni<>0)then begin
			writeln('ingrese el cod de paciente: ' );
			readln(p.cod);
			writeln('ingrese el numero de la obra del paciente (1: ioma 2: pami 3: osde 4: galeno 5: no tiene) :' );
			readln(p.obra);
			writeln('Ingrese el costo: ');
			readln(p.costo);
		end;
	end;
	
	procedure crearArbol(var a:arbol; p:paciente);
	begin
		if(a=nil)then begin
			new(a);
			a^.datos:=p;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if(p.dni < a^.datos.dni) then crearArbol(a^.hi,p)
		else
			crearArbol(a^.hd,p);
	end;
var
	p:paciente;
begin
	a:=nil;
	leerP(p);
	while(p.dni<>0)do begin
		crearArbol(a,p);
		leerP(p);
	end;
end;



procedure incisoB(var l:lista; a:arbol);

	procedure ingresarOrdenado(var l: lista; pi:pacIoma);
	var ant, nuevo, act: lista;
	begin
		new (nuevo);
		nuevo^.datos:= pi;
		act := l;
		{Recorro mientras no se termine la lista y no encuentro la posición correcta}
		while (act <> NIL) and (act^.datos.dni > pi.dni) do begin
			ant := act;
			act := act^.sig ;
		end;
		if (act = l)  then l:= nuevo   {el dato va al principio}
					   else ant^.sig  := nuevo; {va entre otros dos o al final}
		 nuevo^.sig := act ;
	end;
	
	procedure recorrerA(var l:lista; a:arbol);
	var 
		pi:pacIoma;
	begin
		if(a<>nil)then begin
			if(a^.datos.obra = 1) then begin
				pi.dni:= a^.datos.dni;
				pi.cod:= a^.datos.cod;
				ingresarOrdenado(l,pi);
				recorrerA(l,a^.hi);
				recorrerA(l,a^.hd);
			end
			else begin
				recorrerA(l,a^.hi);
				recorrerA(l,a^.hd);
			end;
		end;
	end;
begin
	l:=nil;
	recorrerA(l,a);
end;



procedure incisoC(var a:arbol);
	procedure buscar(var a:arbol; dni,obra:integer);
	begin
		if(a=nil) then writeln('El dni no existe!')
		else if(a<>nil)then begin
			if(a^.datos.dni = dni) then begin
				a^.datos.obra:=obra;
				writeln('Obra cambiada.');
			end
			else if(dni < a^.datos.dni) then buscar(a^.hi,dni,obra)
			else
				buscar(a^.hd,dni,obra);
		end;
	end;
var
	dni,obra:integer;
begin
	writeln('Ingrese el dni del paciente a cambiar la obra social: ');
	readln(dni);
	writeln('Ingese la nueva obra social (1: ioma 2: pami 3: osde 4: galeno 5: no tiene) : ');
	readln(obra);
	buscar(a, dni,obra);
end;


procedure imprimirLista(l:lista);
begin
	if(l<>nil) then begin
		writeln('dni: ',l^.datos.dni);
		writeln('cod: ',l^.datos.cod);
		imprimirLista(l^.sig);
	end;
end;



var
	a:arbol;
	l:lista;
begin
	incisoA(a);
	incisoB(l,a);
	incisoC(a);
	imprimirLista(l);
end.

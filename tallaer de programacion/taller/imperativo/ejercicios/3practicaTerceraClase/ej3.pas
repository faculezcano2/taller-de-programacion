program ej3;
const 
	ano = 2010;
type
	alumno=record
		legajo:integer;
		dni:integer;
		anoIngreso:integer;
	end;
	
	arbol=^nodo;
	nodo=record
		dato:alumno;
		hi:arbol;
		hd:arbol;
	end;
	
procedure generarArbol(var a:arbol);
	procedure leerAlumno(var al:alumno);
	begin
		writeln('Ingrese ano de ingreso: ');
		readln(al.anoIngreso);
		if(al.anoIngreso <> 0) then begin
			writeln('Ingrese el dni: ');
			readln(al.dni);
			writeln('Ingrese el numero de legajo: ');
			readln(al.legajo )
		end;
	end;
	
	procedure insertarElemento(var a:arbol; al:alumno);
	begin
		if (a=nil) then begin
			new(a);
			a^.dato:=al;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if (al.legajo < a^.dato.legajo) then insertarElemento(a^.hi,al)
		else
			insertarElemento(a^.hd,al)
	end;


var
	al:alumno;
begin
	a:=nil;
	leerAlumno(al);
	while(al.anoIngreso <> 0) do begin
		if(al.anoIngreso > ano) then
			insertarElemento(a,al);
		leerAlumno(al);
	end;
end;


procedure imprimirEnOrdenCreciete(a:arbol);
begin
	if(a<>nil) then begin
		imprimirEnOrdenCreciete(a^.hi);
		writeln('DNI: ',a^.dato.dni);
		writeln('ano ingreso: ',a^.dato.anoIngreso);
		imprimirEnOrdenCreciete(a^.hd);
	end;
end;


procedure imprimirMenorATalLegajo(a:arbol; num:integer);
begin
	if(a<>nil)then begin
		if(a^.dato.legajo > num) then imprimirMenorATalLegajo(a^.hi,num)
		else if (a^.dato.legajo < num) then begin
			imprimirMenorATalLegajo(a^.hi,num);
			writeln('DNI: ', a^.dato.dni);
			writeln('ano ingreso: ', a^.dato.anoIngreso);
			imprimirMenorATalLegajo(a^.hd,num);

		end;
	end;
end;


procedure informarEntreDosValores(a:arbol);
	procedure entre(a:arbol; vi,vf:integer);
	begin
		if(a=nil)then writeln('Lista vacia.');
		if(a <> nil)then begin
			if(a^.dato.legajo >= vi) then
				if(a^.dato.legajo <= vf) then begin
					writeln('DNI: ', a^.dato.dni,'. ano ingreso: ', a^.dato.anoIngreso);
					entre(a^.hi,vi,vf);
					entre(a^.hd,vi,vf);
				end
			else
				entre(a^.hi,vi,vf)
			else
				entre(a^.hd,vi,vf)
		end
	end;
var
	vi,vf:integer;
begin
	writeln('Ingrese el valor inicial: ');
	readln(vi);
	writeln('Ingrese el valor final: ');
	readln(vf);
	entre(a,vi,vf);
end;

function dniMasGrande(a:arbol):integer;
	function max(a,b:integer):integer;
	begin
		if(a>b)then 
			max:=a
		else
			max:=b;
	end;
begin
	if(a=nil) then 
		dniMasGrande:=-9999
	else
		dniMasGrande:=max(a^.dato.dni, dniMasGrande(a^.hd))
end;


procedure impar(a:arbol; var cant:integer);
begin
	if(a<>nil) then begin
		if((a^.dato.dni mod 2) <> 0) then
			cant:=cant+1;
		impar(a^.hi,cant);
		impar(a^.hd,cant);
	end;
end;

var
	a:arbol;
	num,cant:integer;
begin
	generarArbol(a);
	imprimirEnOrdenCreciete(a);
	writeln('ingrese el num de legajo para imprimir los menores a ese :');
	readln(num);
	imprimirMenorATalLegajo(a,num);
	informarEntreDosValores(a);
	writeln('El dni mas grande es: ', dniMasGrande(a));
	impar(a,cant);
	writeln('la cantidad de alumnos con dni impar es de: ', cant);
end.

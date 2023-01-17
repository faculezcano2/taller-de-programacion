type
	socio=record
		num:integer;
		nombre:string;
		edad:integer;
	end;
	
	arbol=^nodo;
	nodo=record
		dato:socio;
		HI:arbol;
		HD:arbol;
	end;


procedure generarArbol( var a:arbol);
	procedure leerSocio( var s:socio);
		begin
			writeln('Ingrese el numero de socio: ');
			readln(s.num);
			if(s.num <> 0)then begin
				writeln('Ingrese nombre del socio: ');
				readln(s.nombre);
				writeln('Ingrese la edad del socio: ');
				readln(s.edad);
			end;
		end;
		
		
	procedure insertarElemento(var a:arbol; s:socio);
	begin
		if(a=nil) then begin
			new(a);
			a^.dato:=s;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else if(s.num < a^.dato.num) then insertarElemento(a^.HI, s)
			else
				insertarElemento(a^.HD,s);
	end;
var
	so:socio;
begin
	a:=nil;
	leerSocio(so);
	while(so.num <> 0)do begin
		insertarElemento(a,so);
		leerSocio(so);
	end;
end;


procedure numSocioMasGrande(a:arbol);
	function masGrande(a:arbol):integer;
	begin
		if(a = nil) then masGrande:= -1
		else if( a^.HD = nil) then masGrande:= a^.dato.num
			else masGrande:=masGrande(a^.HD);
	end;
var
	max:integer;
begin
	max:=masGrande(a);
	if(max = -1) then writeln('Arbol sin elementos')
	else
		writeln('num mas grande: ', max);
end;


procedure infoSocioMasChico(a:arbol);
	function masChico(a:arbol):arbol;
	begin
		if ((a = nil) or (a^.HI = nil)) then masChico:= a
		else  masChico:= masChico(a^.HI)
	end;
var
	min:arbol;
begin
	min:=masChico(a);
	if(min = nil) then writeln('Arbol sin elementos')
	else
		writeln('num mas chico: ', min^.dato.num, '. edad socio mas chico: ', min^.dato.edad, '. nombre del socio mas chico: ', min^.dato.nombre,'.');
end;


procedure aumentarEdadDeSocios(var a:arbol);
begin
	if(a <> nil)then begin
		a^.dato.edad:= a^.dato.edad + 1;
		aumentarEdadDeSocios(a^.HI);
		aumentarEdadDeSocios(a^.HD);
	end;
end; 


procedure existeNumSocio(a:arbol);
	function buscar(a:arbol; x:integer):boolean;
	begin
		if(a = nil) then buscar:=false
		else if (x = a^.dato.num) then buscar:= true
			else
				if(x < a^.dato.num) then buscar:=buscar(a^.HI,x)
				else
					buscar:=buscar(a^.HD,x);
	end;
var
	n:integer;
	si:boolean;
begin
	writeln('Ingrese el numero de socio a buscar: ');
	readln(n);
	si:=buscar(a,n);
	if(si=false) then writeln('No existe')
	else
		writeln('si existe');
end;






procedure existeNomSocio(a:arbol);
	function buscar(a:arbol; nombre:string):boolean;
	begin
		if(a = nil) then buscar:=false
		else if (nombre = a^.dato.nombre) then buscar:= true
			else
				if(nombre <> a^.dato.nombre) then begin
					buscar:=buscar(a^.HI,nombre);
					buscar:=buscar(a^.HD,nombre);
				end;
	end;
var
	nombre:string;
	si:boolean;
begin
	writeln('Ingrese el nombre de socio a buscar: ');
	readln(nombre);
	si:=buscar(a,nombre);
	if(si=false) then writeln('No existe')
	else
		writeln('si existe');
end;


function sumarSocios(a:arbol):integer;
begin
	if(a <> nil) then begin
		sumarSocios:=sumarSocios(a^.HI) + 1;
		sumarSocios:= sumarSocios(a^.HD) +1;
	end
	else 
		sumarSocios:=0;
end;

procedure promedio(a:arbol);
	function sumaEdad(a:arbol):integer;
	begin
		if(a <> nil) then begin
			sumaEdad:=sumaEdad(a^.HI) + a^.dato.edad;
			sumaEdad:=sumaEdad(a^.HD) + a^.dato.edad;
		end
		else
			sumaEdad:=0;
	end;
var
	tot,cant:integer;
begin
	tot:=sumaEdad(a);
	cant:=sumarSocios(a);
	writeln('el promedio de edad es de:', tot/cant:2:2);
end;

procedure totalSociosEntreDosValores(a:arbol);
	function entre(a:arbol; vi,vf:integer):integer;
	begin
		if(a = nil) then entre:=0
		else if (a^.dato.num > vf) then entre:=entre(a^.HI,vi,vf)
		else if (a^.dato.num < vi) then entre:=entre(a^.HD,vi,vf)
		else if ((a^.dato.num >= vi) and (a^.dato.num<= vf))then
			entre:=entre(a^.HI,vi,vf) + entre(a^.HD,vi,vf) + 1;
	end;
var
	vf,vi:integer;
begin
	writeln('Ingrese el valor inicial: ');
	readln(vi);
	writeln('Ingrese el valor final: ');
	readln(vf);
	writeln('cant entre dos valores: ',entre(a,vi,vf));
end;


procedure imprimirEnOrdenCreciete(a:arbol);
begin
	if(a<>nil) then begin
		imprimirEnOrdenCreciete(a^.HI);
		writeln(a^.dato.num);
		imprimirEnOrdenCreciete(a^.HD);
	end;
end;

procedure imprimirEnOrdenDecrecieteLosPares(a:arbol);
begin
	if(a<>nil) then begin
		imprimirEnOrdenDecrecieteLosPares(a^.HI);
		imprimirEnOrdenDecrecieteLosPares(a^.HD);
		if((a^.dato.num mod 2 = 0)) then writeln(a^.dato.num);
	end;
end;


var
	a:arbol;
begin
	generarArbol(a);
	numSocioMasGrande(a);
	infoSocioMasChico(a);
	aumentarEdadDeSocios(a);
	existeNumSocio(a);
	existeNomSocio(a);
	writeln('la cant de socios es de: ',sumarSocios(a));
	promedio(a);
	totalSociosEntreDosValores(a);
	writeln('Orden creciente; ');
	imprimirEnOrdenCreciete(a);
	writeln('Orden decreciente los pares ');
	imprimirEnOrdenDecrecieteLosPares(a);
end.

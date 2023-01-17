program prueba;
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


function sumarSocios(a:arbol):integer;
begin
	if(a <> nil) then begin
		sumarSocios:=sumarSocios(a^.HI) + 1;
		sumarSocios:=sumarSocios(a^.HD) + 1;
	end
	else 
		sumarSocios:=0;
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


var
	a:arbol;
begin
	generarArbol(a);
	writeln('Orden creciente; ');
	imprimirEnOrdenCreciete(a);
	writeln('Orden decreciente los pares ');
	imprimirEnOrdenDecrecieteLosPares(a);
	writeln('la cant de socios es de: ',sumarSocios(a));
	totalSociosEntreDosValores(a);
end.

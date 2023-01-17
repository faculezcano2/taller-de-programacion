
program punto1;
type 
	socio= record
		num:integer;
		nom:string; 
		edad:integer;
	end;
	
	arbol= ^nodo;
	nodo= record
		dato:socio;
		HI:arbol;
		HD:arbol;
	end;
	
procedure cargar (var a:arbol);

	procedure leer (var s:socio);
	begin
		writeln ('numero de socio: '); readln (s.num);
		if (s.num <> 0) then begin
			writeln ('nombre: '); readln (s.nom);
			writeln ('edad: '); readln (s.edad);
			leer (s);
		end;
	end;
	
	procedure insertar (var a:arbol; s:socio);
	begin
		if (a = nil) then begin
			new (a);
			a^.dato:=s;
			a^.HI:= nil;
			a^.HD:= nil;
		end
		else
			if (s.num < a^.dato.num) then 
				insertar (a^.HI, s)
			else
			 insertar (a^.HD,s);
	end;
	
var
	s:socio;
begin
	leer (s);
	while (s.num <> 0) do begin
		insertar (a,s);
		leer (s);
	end;
end;

procedure masGrande (a:arbol);
	
	procedure max (a:arbol;var maxim:integer);
	begin
		if (a= nil) then 
			maxim:=0
		else
			if (a^.dato.num > maxim) then
				maxim:=a^.dato.num
			else 
				max(a^.HD, maxim);
		end;
var
	maxim:integer;
begin
	maxim:=-999;
	max (a,maxim);
	writeln ('el numero mas grande de los socios, fue el: ', maxim);
end;

procedure masChico (a:arbol);
	
	procedure min (a:arbol;var minim:integer; var s:socio);
	begin
		if (a= nil) then 
			minim:=0
		else
			if (a^.dato.num < minim) then
				minim:=a^.dato.num
			else 
				min(a^.HD, minim,s);
		end;
var
	s:socio;
	minim:integer;
begin
	minim:=999;
	min (a,minim,s);
	writeln ('datos del socio con el numero mas grande: ', s.num, ' ', s.nom, ' ', s.edad);
end;

procedure masGrande2 (a:arbol);
	
	procedure max (a:arbol;var num,maxim:integer);
	begin
		if (a= nil) then 
			maxim:=0
		else
			if (a^.dato.edad > maxim) then begin
				maxim:=a^.dato.edad;
				num:=a^.dato.num;
			end
			else 
				max(a^.HD, num , maxim);
		end;
var
	maxim,num:integer;
begin
	maxim:=-1;
	max (a,num,maxim);
	writeln ('el numero de socio con mayor edad es: ', num);
end;

procedure aumentar (var a:arbol);
	
	procedure aumenta (var a:arbol);
	begin
		if (a <> nil) then begin
			a^.dato.edad:= a^.dato.edad + 1;
			aumenta (a^.HI);
			aumenta (a^.HD);
		end;
	end;
begin
	aumenta(a);
end;

procedure existeNum(a:arbol);
	function buscar(a:arbol; x:integer):boolean;
		begin
			if(a=nil)then buscar:=false
			else if(x=a^.dato.num) then buscar:=true
			else
				if(x<a^.dato.num) then buscar:=buscar(a^.HI,x)
				else
					buscar:=buscar(a^.HD,x);
		end;
var
	x:integer;
begin
	writeln('ingrese un valor a buscar:');
	readln(x);
	if(buscar(a,x)) then writeln('existe')
		else writeln('no existe');
end;
		
		
procedure existenom(a:arbol);
	function buscar(a:arbol; x:string):boolean;
		begin
			if(a=nil)then buscar:=false
			else if(x=a^.dato.nom) then buscar:=true
			else
				if(x<a^.dato.nom) then buscar:=buscar(a^.HI,x)
				else
					buscar:=buscar(a^.HD,x);
		end;
var
	x:string;
begin
	writeln('ingrese un valor a buscar:');
	readln(x);
	if(buscar(a,x)) then writeln('existe')
		else writeln('no existe');
end;



procedure cantidad (var a:arbol; var cant:integer);
begin
	if (a <> nil) then begin
		cant:= cant + 1;
		cantidad (a^.HI,cant);
		cantidad(a^.HD,cant);
	end;
end;

procedure promedio (a:arbol);

	procedure sumaEdad(a:arbol; var edad:integer);
	begin
		if (a <> nil) then begin
			edad:= edad + a^.dato.edad;
			sumaEdad (a^.HI,edad);
			sumaEdad (a^.HD,edad);
		end;
	end;

var
	edad,cant:integer;
begin
	edad:=0;
	cant:=0;
	cantidad(a,cant);
	sumaEdad(a,edad);
	writeln('promedio: ', edad/cant)
end;





var
	cant:integer;
begin
	cant:=0;
	aumenta(a,cant);
	writeln('cant de socios',cant);
end;






program ej2;

type
	auto=record
		patente:integer;
		anoFabricacion:2010..2018;
		marca:string;
		modelo:string;
	end;
	
	arbol=^nodo;
	nodo=record
		datos:auto;
		hi:arbol;
		hd:arbol;
	end;
	
	vec=array[2010..2018] of arbol;
	
procedure generarArbol(var a:arbol);
	procedure leerAuto(var au:auto);
	begin
		writeln('Ingrese patente del auto: ');
		readln(au.patente);
		if(au.patente <> 0) then begin
			writeln('Ingrese año de fabricacion: ');
			readln(au.anoFabricacion);
			writeln('Ingrese marca: ');
			readln(au.marca);
			writeln('ingrese modelo: ');
			readln(au.modelo);
		end;
	end;
	
	procedure cargarArbol(var a:arbol; au:auto);
	begin
		if(a=nil) then begin
			new(a);
			a^.datos:=au;
			a^.hi:=nil;
			a^.hd:=nil
		end
		else
			if(a^.datos.patente < au.patente) then cargarArbol(a^.hi,au)
			else
				cargarArbol(a^.hd,au);
	end;
var
	au:auto;
begin
	leerAuto(au);
	while(au.patente <> 0)do begin
		cargarArbol(a,au);
		leerAuto(au);
	end;
end;


procedure cantAutosPorMarca(a:arbol);
	procedure es(a:arbol; mar:string; var cant:integer);
	begin
		if (a<>nil) then begin
			if(a^.datos.marca = mar) then cant:=cant+1;
			es(a^.hi,mar,cant);
			es(a^.hd,mar,cant)
		end;
	end;
var
	mar:string;
	cant:integer;
begin
	cant:=0;
	writeln('ingrese la marca a saber la cantidad de autos que hay: ');
	readln(mar);
	es(a,mar,cant);
	writeln('la cantidad e autos de esa marca es de: ', cant);
end;




procedure reorganizarInfo(a:arbol; var v:vec);
	procedure ponerEnNil(var v:vec);
	var i:integer;
	begin
		for i:= 2010 to 2018 do v[i]:=nil;
	end;


	procedure cargarArbol(var a:arbol; au:auto);
	begin
		if(a=nil) then begin
			new(a);
			a^.datos:=au;
			a^.hi:=nil;
			a^.hd:=nil
		end
		else
			if(a^.datos.patente < au.patente) then cargarArbol(a^.hi,au)
			else
				cargarArbol(a^.hd,au);
	end;

	procedure cargarVec(a:arbol; var v:vec);
	begin
		if(a=nil) then writeln('vacio')
		else if(a<>nil) then
			cargarArbol(v[a^.datos.anoFabricacion], a^.datos);
	end;

	procedure leerVec(v:vec);
	var
		i:integer;
	begin
		for i:=2010 to 2018 do begin
			writeln('año ',i);
			if(v[i]<>nil)then begin
				writeln('patente: ',v[i]^.datos.patente);
				writeln('año fab: ',v[i]^.datos.anoFabricacion);
				writeln('marca: ',v[i]^.datos.marca);
				writeln('modelo: ',v[i]^.datos.modelo);
			end;
		end;
	end;

begin
	ponerEnNil(v);
	cargarVec(a,v);
	leerVec(v);
end;


procedure puntoD(a:arbol);
	function buscar(a:arbol; pat:integer):boolean;
	begin
		if(a=nil)then buscar:=false
		else if(a^.datos.patente = pat) then begin 
				writeln('año de fabricacion de patente buscada: ',a^.datos.anoFabricacion);
				buscar:=true;
			end
			else if ( pat < a^.datos.patente) then buscar:=buscar(a^.hi,pat)
			else
				buscar:=buscar(a^.hd,pat);
	end;

var
	pat:integer;
begin
	writeln('ingrese la patente del auto a saber su año de fabricacion: ');
	readln(pat);
	buscar(a,pat);
end;


var
	a:arbol;
	v:vec;
begin
	generarArbol(a);
	cantAutosPorMarca(a);
	reorganizarInfo(a,v);
	puntoD(a);
end.

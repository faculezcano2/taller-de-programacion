type
	registro=record
		num:integer;
		dia:0..31;
		mes:1..12;
		cantHoras:0..8;
	end;
	
	
	arbol=^nodo;
	nodo=record
		datos:registro;
		hi:arbol;
		hd:arbol;
	end;
	
	
	lista=^nodo2;
	nodo2=record
		datos:registro;
		sig:lista;
	end;
	
procedure puntoA(var a:arbol);
	procedure leer(var r:registro);
	begin
		r.dia:=random(31);
		if(r.dia<>0)then begin
			r.num:=random(500);
			r.mes:=random(31);
			r.cantHoras:=random(8)+1;
		end;
	end;
	
	procedure crearArbol(var a:arbol; r:registro);
	begin
		if(a=nil)then begin
			new(a);
			a^.datos:=r;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if( r.num < a^.datos.num)then crearArbol(a^.hi,r)
		else
			crearArbol(a^.hd,r);
	end;
var
	r:registro;
begin	
	a:=nil;
	leer(r);
	while(r.dia<>0)do begin
		crearArbol(a,r);
		leer(r);
	end;
end;


procedure leerArbol(a:arbol);
begin
	if(a<>nil)then begin
		writeln('dia: ',a^.datos.dia,'. numempleado: ',a^.datos.num,'. mes: ',a^.datos.mes,'. horas: ',a^.datos.cantHoras);
		leerArbol(a^.hi);
		leerArbol(a^.hd);
	end;
end;



procedure puntoB(a:arbol; var l:lista);
	{procedure agregarAtras(var l,ult:lista; r:registro);
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.datos.dia:=r.dia;
		nuevo^.datos.num:=r.num;
		nuevo^.datos.mes:=r.mes;
		nuevo^.datos.cantHoras:=r.cantHoras;
		nuevo^.sig:=nil;
		if(l=nil) then l:=nuevo
		else
			ult^.sig:=nuevo;
		ult:=nuevo;
	end;
}
	procedure insertarOrdenado(var l:lista; r:registro);
	var
		nuevo,ant,act:lista;
	begin
		new(nuevo);
		nuevo^.datos.dia:=r.dia;
		nuevo^.datos.num:=r.num;
		nuevo^.datos.mes:=r.mes;
		nuevo^.datos.cantHoras:=r.cantHoras;
		act:=l;
		ant:=l;
		while(act<>nil) and (act^.datos.num<r.num)do begin
			ant:=act;
			act:=act^.sig;
		end;
		if(act=l)then l:=nuevo
			else ant^.sig:=nuevo;
		nuevo^.sig:=act;
	end;
	
	
	
	
	procedure entreDosVal(a:arbol; x,y:integer; var l:lista);
	begin
		if(a<>nil)then
			if(a^.datos.num > x) then 
				if(a^.datos.num <  y)then begin
					insertarOrdenado(l,a^.datos);
					entreDosVal(a^.hi,x,y,l);
					entreDosVal(a^.hd,x,y,l);
				end
			else
				entreDosVal(a^.hi,x,y,l)
			else
				entreDosVal(a^.hd,x,y,l);
	end;
var
	x,y:integer;
begin
	l:=nil;
	writeln('Empleado desde cual buscar: ');
	readln(x);
	writeln('Empleado hasta cual buscar: ');
	readln(y);
	entreDosVal(a,x,y,l);
end;

procedure leerL(l:lista);
begin
	if(l<>nil)then begin
		writeln('dia: ',l^.datos.dia,'. numempleado: ',l^.datos.num,'. mes: ',l^.datos.mes,'. horas: ',l^.datos.cantHoras);
		leerL(l^.sig);
	end;
end;


procedure puntoC(l:lista; var cant:integer);
begin
	if(l<>nil)then begin
		cant:=cant+l^.datos.cantHoras;
		puntoC(l^.sig,cant);
	end;
end;

var
	a:arbol;
	l:lista;
	cant:integer;
begin
	cant:=0;
	puntoA(a);
	leerArbol(a);
	puntoB(a,l);
	leerL(l);
	puntoC(l,cant);
	writeln('la cantidad de horas trabajadas es de: ', cant);
end.

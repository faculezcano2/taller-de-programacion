type
	lista=^nodo;
	nodo=record
		dato:integer;
		sig:lista;
	end;
	
procedure hace(var l:lista);

	procedure agregarAdelante(var l:lista; n:integer);
	var
		nue:lista;
	begin
		new(nue);
		nue^.dato:=n;
		nue^.sig:=l;
		l:=nue;
	end;
	
	procedure generarNum();
		var
			num:integer;
		begin
			writeln('num');
			num:= random(100);
			writeln(num);
			if(num<>0)then begin
				agregarAdelante(l,num);
				generarNum();
			end;
		end;
begin
	l:=nil;
	generarNum();
end;


function maximo(l:lista):integer;
	function mayor(a,b:integer):integer;
	begin
		if(a>b) then
			mayor:=a
		else
			mayor:=b;
	end;

begin
	if(l=nil) then
		maximo:=-9999
	else
		maximo:=mayor(l^.dato,maximo(l^.sig));
end;



function minimo(l:lista):integer;
	function menor(a,b:integer):integer;
	begin
		if(a<b) then
			menor:=a
		else
			menor:=b;
	end;

begin
	if(l=nil) then
		minimo:=9999
	else
		minimo:=menor(l^.dato,minimo(l^.sig));
end;

function esta(l:lista; n:integer):boolean;
begin
	if(l<>nil) then begin
		if (l^.dato = n) then
			esta:=true
		else
			esta:=esta(l^.sig,n);
		end
	else
		esta:=false;
end;
		
			
var
	l:lista;
	n:integer;
begin
	randomize;
	hace(l);
	writeln('maxi: ',maximo(l));
	writeln('min: ',minimo(l));
	writeln('ingrese un numero a buscar: ');
	readln(n);
	writeln(esta(l,n));
end.

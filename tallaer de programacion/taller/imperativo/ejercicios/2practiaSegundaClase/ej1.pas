program ej1;
const
	dimF=10;
type
	vec = array[1..dimF] of char;
	
	lista=^nodo;
	nodo=record
		dato:char;
		sig:lista;
	end;
	

procedure cargarVectorRecursivo(var v:vec; var dimL:integer);
var
	caracter:char;
begin
	writeln('Ingrese uncaracter: ');
	readLn(caracter);
	if(caracter <> '.') and (dimL<dimF) then begin
		dimL:=dimL+1;
		v[dimL]:=caracter;
		cargarVectorRecursivo(v,dimL);
	end;
end;


procedure leerVector(v:vec; dimL:integer);
var
	i:integer;
begin
	for i:=1 to dimL do
		writeln(v[i]);
end;
 

   
procedure leerVectorRecursivo(v:vec;dimL:integer;var i:integer);
begin
	if (dimL = 0) then writeln('--- Vector sin elementos ---')
	else if (i<=dimL)and(v[i]<>'.')then begin
		writeln(v[i]);
		i:=i+1;
		leerVectorRecursivo(v,dimL,i);
	end;
end;

procedure leerYContar(var v:vec; var dimL:integer);
var
	caracter:char;
begin
	writeln('Ingrese uncaracter: ');
	readLn(caracter);
	if(caracter <> '.') and (dimL<dimF) then begin
		dimL:=dimL+1;
		v[dimL]:=caracter;
		leerYContar(v,dimL);
	end;
end;


procedure puntoE(var l:lista);
	procedure agregarAlFinal(var pri,ult:lista; c:char);
	var
		nue:lista;
	begin
		new(nue);
		nue^.dato:=c;
		nue^.sig:=nil;
		if(pri = nil) then
			pri:=nue
		else
			ult^.sig:=nue;
		ult:=nue;
	end;
var
	c:char;
	ult:lista;
begin
	writeln('Ingrese uncaracter: ');
	readLn(c);
	if (c<>'.')then begin
		agregarAlFinal(l,ult,c);
		puntoE(l);
	end;
end;	
	
	
Procedure imprimir (l:lista);
Begin
    if (l <> nil) then begin
        writeln ('caracter: ',l^.dato);
        l:= l^.sig;
        imprimir (l);
    end;
End;



var
	v:vec;
	v2:vec;
	dimL,dimL2,i:integer;
	l:lista;
begin
	l:=nil;
	i:=1;
	dimL:=0;
	dimL2:=0;
	cargarVectorRecursivo(v,dimL);//a
	//leerVector(v, dimL);//b
	leerVectorRecursivo(v,dimL,i);//c
	leerYContar(v2,dimL2);//d
	writeln('la cantidad de caracteres ingresados es: ', dimL2);
	puntoE(l);
	imprimir(l);
end.




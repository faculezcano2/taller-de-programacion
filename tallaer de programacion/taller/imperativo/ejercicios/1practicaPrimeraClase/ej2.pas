program ej2;

const
	maxOf=6;
	
type
	rango=1..maxOf;
	
	oficina=record
		identificacion:rango;
		dni:integer;
		valor:real;
	end;

	vec=array[rango]of oficina;



procedure leerOficina(var ofi:oficina);
begin
	writeln('Ingrese la identificacion de la oficina: ');
	readln(ofi.identificacion);
	if(ofi.identificacion <> -1)then begin
		writeln('Ingrese el dni del propietario: ');
		readln(ofi.dni);
		writeln('Ingrese valor de la oficina: ');
		readln(ofi.valor);
	end;
end;


procedure cargarVector(var v:vec; var dimL:integer);
var
	ofi:oficina;
begin
	leerOficina(ofi);
	while (ofi.identificacion <> -1) and (dimL < maxOf) do begin
		dimL:=dimL+1;
		v[dimL]:=ofi;
		leerOficina(ofi);
	end;
end;

procedure imprimirVec(v:vec; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do begin
		writeln('Identificacion de la oficina ',i,': ', v[i].identificacion);
		writeln('Dni del propietario de la oficina: ', v[i].dni);
		writeln('Valor de la oficina: ', v[i].valor:2:2);
	end;
end;

procedure insercion(var v:vec; dimL:integer);
var
	i,j:integer; 
	actual:oficina;
begin
	for i:=2 to dimL do begin
		actual:=v[i];
		j:=i-1;
		while(j>0) and (v[j].identificacion>actual.identificacion) do begin
			v[j+1]:=v[j];
			j:=j-1
		end;
		v[j+1]:=actual;
	end;
end;


procedure seleccion(var v:vec; dimL:integer);
var
	i,p,j:integer;
	item:oficina;
begin
	for i:= 1 to dimL-1 do begin
		p:=i;
		for j:= i+1 to dimL do
			if (v[j].identificacion < v[p].identificacion) then p:=j;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;


//programa principal
var
	v:vec;
	dimL:integer;
begin
	dimL:=0;
	cargarVector(v,dimL);
	writeln('------------------vector sin orden-----------------');
	imprimirVec(v,dimL);
	//insercion(v,dimL);
	//writeln('------------------vector con orden-insercion-----------------');
	//imprimirVec(v,dimL);
	writeln('------------------vector con orden-seleccion-----------------');
	seleccion(v,dimL);
	imprimirVec(v,dimL);
end.    

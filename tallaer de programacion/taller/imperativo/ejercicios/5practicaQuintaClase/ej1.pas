program ej1;
const
	dimF=300;
type
	oficina=record
		codIdentificacion:integer;
		dni:integer;
		valor:integer;
	end;
	
	vec = array [1..dimF] of oficina;


procedure puntoa(var v:vec; var diml:integer);
	procedure leer(var off:oficina);
	begin
		writeln('Ingrese el cod identificacion: ' );
		off.codIdentificacion:=random(299)+1;
		if(off.codIdentificacion <> -1)then begin
			writeln('ingrese el dni del propietario: ');
			off.dni:=random(20)+1;
			writeln('Ingrese el valor de la oficina: ');
			off.valor:=random(100)+1;
		end;
	end;
	
	procedure cargar(var v:vec; var diml:integer);
	var
		off:oficina;
	begin
		leer(off);
		while(off.codIdentificacion <> -1) and (diml<=dimF)do begin
			diml:=diml+1;
			v[diml]:=off;
			leer(off);
		end;
	end;
begin
	diml:=0;
	cargar(v,diml)
end;

procedure leerv(v:vec; diml:integer; var i:integer);
	procedure leerVector(v:vec; diml:integer; var i:integer);
		begin
			if(diml = 0)then writeln('vec vacio.')
			else if(i<=diml) then begin
				writeln('identificacion: ',v[i].codIdentificacion,', dni: ',v[i].dni,', valor: ',v[i].valor);
				i:=i+1;
				leerVector(v,diml,i);
			end;
		end;
begin
	i:=1;
	leerVector(v,diml,i);
end;

procedure seleccion(var v:vec; diml:integer);
var
	i,p,j:integer;
	item:oficina;
begin
	for i:=1 to diml-1 do begin
		p:=i;
		for j:=i+1 to diml do
			if(v[j].codIdentificacion < v[p].codIdentificacion) then p:=j;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;

procedure busqueda(v: vec; diml:integer);
	procedure busquedaDicotomica (v: vec; ini,fin: integer; dato:integer; var pos: integer);
	var
		mid: integer;
	begin
		mid:=(fin+ini) div 2;
		if (ini>fin) then pos:=-1
		else if (v[mid].codIdentificacion<dato) then busquedaDicotomica(v,mid+1,fin,dato,pos)
		else if (v[mid].codIdentificacion>dato) then busquedaDicotomica(v,ini,mid-1,dato,pos)
		else pos:=mid;
	end;
var
	ini,fin,dato,pos:integer;
begin
	ini:=1; fin:=diml;
	write('Ingrese el numero a buscar: ');
	readln(dato);
	busquedaDicotomica(v,ini,fin,dato,pos);
	writeln('dni: ',v[pos].dni)
end;

procedure total(v:vec; diml:integer);
		procedure suma(v:vec;var total:real; var i:integer);
		begin
			if(i<=diml)then begin
				total:=total+v[i].valor;
				i:=i+1;
				suma(v,total,i);
			end;
		end;
var
	i:integer;
	total:real;
begin
	i:=1;
	total:=0;
	suma(v,total,i);
	writeln('total de expensas: ',total:0:2);
end;

var
	v:vec;
	diml,i:integer;
begin
	puntoA(v,diml);
	leerv(v,diml,i);
	seleccion(v,diml);
	writeln('-----nuevo vec-----');
	leerv(v,diml,i);
	busqueda(v,diml);
	total(v,diml);
end.

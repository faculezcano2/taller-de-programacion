program facundolezcano;
//programa aerolineas


const 
	maxCat=20;
	dimF=250;
type
	empleado=record
		legajo:integer;
		dni:integer;
		categoria:1..maxCat;
		anoIngreso:integer;
	end;
	
	
	arbol=^nodo;
	nodo=record
		datos:empleado;
		hi:arbol;
		hd:arbol;
	end;
	
	datosEmpVec=record
		dni:integer;
		legajo:integer;
	end;
	
	vec = array [1..dimF] of datosEmpVec;
	
	
procedure generarArbol(var a:arbol);
	procedure leerEmpleado(var e:empleado);
	begin
	end;
	
	procedure crearArbol( var a:arbol; e:empleado);
	begin
	end;
begin
end;

procedure incisoA(ab:arbol; var v:vec; var dimL:integer; a,b,cat:integer);
	procedure entreDosVal(ab:arbol; var dimL:integer; a,b,cat:integer);
	begin
		if(ab<>nil)then begin
			if(ab^.datos.categoria = cat)then begin
				if(a <= ab^.datos.dni)then
					if(b >= ab^.datos.dni) then begin 
						v[dimL].dni:=ab^.datos.dni;
						v[dimL].legajo:=ab^.datos.legajo;
						dimL:=dimL+1;
						entreDosVal(ab^.hi,dimL,a,b,cat);
						entreDosVal(ab^.hd,dimL,a,b,cat);
					end
				else
					entreDosVal(ab^.hi,dimL,a,b,cat)
				else
					entreDosVal(ab^.hd,dimL,a,b,cat);
			end;
		end;
	end;
	
	procedure ordenarVector(var v:vec; dimL:integer);
	var
		i,j,p:integer;
		item:datosEmpVec;
	begin
		for i:= 1 to dimL-1 do begin
			p:=i;
			for j:=i+1 to dimL do
				if (v[j].dni < v[p].dni) then p:=j;
				
			item:=v[p];
			v[p]:=v[i];
			v[i]:=item;
		end;
	end;

begin
	dimL:=1;
	entreDosVal(ab,dimL,a,b,cat);
	ordenarVector(v, dimL);
end;


procedure incisoB(v:vec; dimL:integer);
	procedure sumarLegajos(v:vec; dimL:integer; var tot,i:integer);
	begin
		if(i<=dimL)then begin
			tot:=tot+v[i].legajo;
			i:=i+1;
			sumarLegajos(v,dimL,tot,i);
		end;
	end;
var
	tot,i:integer;
begin
	tot:=0;
	i:=1;
	sumarLegajos(v,dimL,tot,i);
	writeln('El promedio de los numero de legajos es de: ', tot/dimL);
end;



var
	ab:arbol;
	v:vec;
	diml,a,b,cat:integer;
begin
	generarArbol(ab);
	writeln('primera pos entre: ');readln(a);
	writeln('ult pos entre: ');readln(b);
	writeln('cat: ');readln(cat);
	incisoA(ab,v,dimL,a,b,cat);
	incisoB(v,dimL);
end.

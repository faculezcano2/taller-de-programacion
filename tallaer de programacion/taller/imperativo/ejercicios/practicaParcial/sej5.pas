{La Organización Mundial de la Salud (OMS) necesita un sistema para obtener estadísticas
de las dosis de vacunas aplicadas contra el COVID-19 en cada país. Cada país notifica
diariamente a la OMS la cantidad de dosis aplicadas por tipo de vacuna. De cada
notificación se conoce: fecha, nombre del país, tipo de vacuna (1:Sinopharm, 2:CanSino,
3:AstraZeneca, 4:Sputnik) y cantidad de dosis aplicadas.

Se dispone una estructura que almacena las notificaciones agrupadas por tipo de vacuna.
Para cada tipo, las notificaciones realizadas se encuentran ordenadas por nombre de país.
Implemente un programa que:

a) Reciba la estructura que almacena las notificaciones y, usando la técnica de merge
     acumulador, genere un ABB (ordenado por cantidad de dosis) que contenga para
     cada país, la cantidad total de dosis aplicadas.

b) Implementar un módulo recursivo que reciba la estructura generada en a) y retorne
    el nombre del país que aplicó la mayor cantidad de dosis.

NOTA: Cada país puede aplicar más de un tipo de vacuna por día.
No es necesario implementar la carga de la estructura que se dispone. Alcanza con declarar
el encabezado del procedimiento e invocarlo para que el programa compile
satisfactoriamente.}

program ej;

const
	max=4;
	valorGrande='ZZZ';

type
	notificacion=record
		fecha:integer;
		pais:string;
		vac:1..max;
		cant:integer;
	end;
	
	
	lista=^nodo;
	nodo=record
		datos:notificacion;
		sig:lista;
	end;
	
	vec = array [1..max] of lista;

	datosmerge=record
		pais:string;
		total:integer;
	end;
	
	arbol=^nodom;
	nodom=record
		datos:datosmerge;
		hi:arbol;
		hd:arbol;
	end;
	

procedure cargaDeVecQueSeDispone(var v:vec);
begin
end;


procedure merge(v:vec; var a:arbol);
	procedure minimo(var v:vec; var minn:notificacion);
	var
		indicemin,i:integer;
	begin
		minn.pais:=valorGrande;
		for i:=1 to max do
			if(v[i]<>nil)then
				if(v[i]^.datos.pais <= minn.pais) then begin
					indicemin:=i;
					minn.pais:=v[i]^.datos.pais;
				end;
		if(minn.pais<>valorGrande)then v[indicemin]:=v[indicemin]^.sig;
	end;
	
	
	procedure generarArbol(var a:arbol; d:datosmerge);
	begin
		if(a=nil)then begin
			new(a);
			a^.datos:=d;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else if(d.total < a^.datos.total) then generarArbol(a^.hi,d)
		else
			generarArbol(a^.hd,d);
	end;

var
	d:datosmerge;
	minn:notificacion;
begin
	a:=nil;
	minimo(v,minn);
	while(minn.pais<>valorGrande)do begin
		d.pais:=minn.pais;
		d.total:=0;
		while((minn.pais <> valorGrande)and(d.pais = minn.pais)) do begin
			d.total:= d.total + minn.cant;
			minimo(v,minn);
		end;
		generarArbol(a,d);
	end;
end;


function mayorCantDosis(a:arbol):string;
begin
	if(a = nil) then mayorCantDosis:='vacio'
	else if (a^.hd = nil) then mayorCantDosis:=a^.datos.pais
		else
			mayorCantDosis(a^.hd);
end;

var
	a:arbol;
	v:vec;
begin
	cargaDeVecQueSeDispone(v);
	merge(v,a);
	writeln('El pais con mayor cantidad de vacunas es: ', mayorCantDosis(a) );
end.



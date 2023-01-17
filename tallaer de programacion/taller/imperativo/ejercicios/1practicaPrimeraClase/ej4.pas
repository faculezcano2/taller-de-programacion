program ej4;
const
	maxCodRubro = 8;
	dimF = 30;
type
	
	rango = 1..maxCodRubro;
	rango2 = 1..dimF;
	
	producto = record
		codProducto:integer;
		codRubro: rango;
		precio:real;
	end;
	
	lista=^nodo;
	nodo = record
		datos:producto;
		sig:lista;
	end;
	
	vec = array[rango] of lista;
	vecP = array[rango2] of producto;

procedure ingresarProductos(var v:vec);


	procedure inicializarListas(var v:vec);
	var
		i:integer;
	begin
		for i:= 1 to maxCodRubro do 
			v[i]:=nil;
	end;
	
	
	
	procedure ingresarOrdenado(var l:lista; p:producto);
	var
		nue,act,ant:lista;
	begin
		new(nue);
		nue^.datos:=p;
		act:=l;
		ant:=l;
		while(act<>nil) and (p.codProducto<act^.datos.codProducto)do begin
			ant:=act;
			act:=act^.sig;
		end;
		if(act=ant) then
			l:=nue
		else
			ant^.sig:=nue;
		nue^.sig:=act;
	end;
	
	
	
	procedure leerProducto(var p:producto);
	begin
		writeln('Ingrese el precio del producto: ');
		readln(p.precio);
		if(p.precio <> 0) then begin
			writeln('ingrese el codigo del producto: ');
			readln(p.codProducto);
			writeln('Ingrese el codigo de rubro: ');
			readln(p.codRubro);
		end;
	end;
	

var
	v1:vec;
	p:producto;
	
begin
	inicializarListas(v1);
	leerProducto(p);
	while(p.precio<>0)do begin
		ingresarOrdenado(v1[p.codRubro],p);
		leerProducto(p);
	end;
end;


procedure leer(v:vec);
var
	i:integer;
begin
	for i:=1 to maxCodRubro do begin
		writeln('Rubro ',i,': ');
		while(v[i]<>nil)do begin
			writeln('codigo de producto: ',v[i]^.datos.codProducto);
			v[i]:=v[i]^.sig;
		end;
	end;
end;


procedure vecProductos(v:vec; var v2:vecP; var dimL:integer);
begin
	dimL:=1;
	while(v[3]<>nil) and (dimL<dimF) do begin
		v2[dimL]:= v[3]^.datos;
		diml:=diml+1;
		v[3]:=v[3]^.sig;
	end;
end;


procedure insercion(var v:vecP; dimL:integer);
var
	i,j:integer; 
	actual:producto;
begin
	for i:=2 to dimL do begin
		actual:=v[i];
		j:=i-1;
		while(j>0) and (v[j].precio>actual.precio) do begin
			v[j+1]:=v[j];
			j:=j-1
		end;
		v[j+1]:=actual;
	end;
end;


procedure leerVector(v:vecP; dimL:integer);
var
	i:integer;
begin
	for i:=1 to dimL do begin
		writeln('Precio del producto ',i,':', v[i].precio);
	end;
end;


var
	v:vec;
	v2:vecP;
	dimL:integer;
begin
	ingresarProductos(v);	//a
	leer(v);	//b
	vecProductos(v,v2,dimL);	//c
	insercion(v2,dimL);		//d
	leerVector(v2,dimL);	//e
end.

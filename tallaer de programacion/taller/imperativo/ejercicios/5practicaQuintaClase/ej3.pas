program ej3;
const
	max=10;
type
	producto=record
		codigo:integer;
		rubro:1..max;
		stock:integer;
		precio:real;
	end;
	
	
	arbol=^nodo;
	nodo=record
		datos:producto;
		hi:arbol;
		hd:arbol;
	end;
	
	vec = array[1..max] of arbol;
	
	
	

procedure cargarVecDeArboles(var v:vec);
	procedure ponerEnNil(var v:vec);
	var
		i:integer;
	begin
		for i:=1 to max do v[i]:=nil;
	end;
	
	
	
	procedure leer(var p:producto);
	begin
		writeln('Ingrese el codigo de producto: ');
		readln(p.codigo);
		if(p.codigo<>-1)then begin
			writeln('Ingrese el rubro: ');
			p.rubro:=random(9)+1;
			writeln('Ingrese el stock : ');
			p.stock:=random(60)+1;
			writeln('ingrese el precio unitario del producto: ');
			p.precio:=random(100)+1;
		end;
	end;
	
	procedure cargarArbol(var a:arbol; p:producto);
	begin
		if(a = nil) then begin
			new(a);
			a^.datos:=p;
			a^.hi:=nil;
			a^.hd:=nil;
		end
		else 
			if(p.codigo < a^.datos.codigo) then cargarArbol(a^.hi,p)
			else
				cargarArbol(a^.hd,p);
	end;

var
	p:producto;
begin
	ponerEnNil(v);
	leer(p);
	while(p.codigo<>-1)do begin
		cargarArbol(v[p.rubro],p);
		leer(p);
	end;
end;


procedure existeProdEnRubro(v:vec);
	function buscar(v:vec; a:arbol; rubro:integer; codP:integer):boolean;
	begin
		if(v[rubro]=nil)then buscar:=false
		else
			if(v[rubro]^.datos.codigo = codP) then buscar:=true
			else if(v[rubro]^.datos.codigo < codP) then buscar(v,v[rubro]^.hd,rubro,codP)
			else
				buscar(v,v[rubro]^.hi,rubro,codP);
	end;
var
	rubro,codP:integer;
begin
	writeln('Ingrese el rubro a buscar: ');
	readln(rubro);
	writeln('Ingrese el codigo de producto a buscar: ');
	readln(codP);
	if(buscar(v,v[rubro],rubro,codP))then writeln('existe!')
	else
		writeln('no eciste!');
end;



procedure mayor(v:vec);
	procedure masGrande(a:arbol; var maxStock,maxCod:integer);
	begin
		if(a = nil) then begin
			maxStock:= -1;
			maxCod:=-1;
		end
		else if( a^.hd = nil) then begin
			maxCod:= a^.datos.codigo;
			maxStock:= a^.datos.stock;
		end
		else masGrande(a^.hd,maxStock,maxCod);
	end;
	

var
	i,maxStock,maxCod:integer;
begin
	for i:=1 to max do begin
		writeln('Rubro: ',i);
		if(v[i]<> nil) then
			masGrande(v[i],maxStock,maxCod);
		writeln('el stock del producto mas grande es: ', maxStock, '. su codigo es: ', maxCod)
	end;
end;

procedure informarEntreDosValores(v:vec);
	procedure entre(a:arbol; vi,vf:integer; var cant:integer);
	begin
		if(a=nil)then writeln('arbol vacia.');
		if(a <> nil)then begin
			if(a^.datos.codigo >= vi) then
				if(a^.datos.codigo <= vf) then begin
					cant:=cant+1;
					entre(a^.hi,vi,vf,cant);
					entre(a^.hd,vi,vf,cant);
				end
			else
				entre(a^.hi,vi,vf,cant)
			else
				entre(a^.hd,vi,vf,cant)
		end
	end;
var
	i,vi,vf,cant:integer;
begin
	writeln('Ingrese el codigo de producto inicial a partir de cual contar: ');
	readln(vi);
	writeln('Ingrese el codigo de producto final hasta cual contar: ');
	readln(vf);
	for i:=1 to max do begin
		cant:=0;
		entre(v[i],vi,vf,cant);
		writeln('La cantidad de productos que hay entre esos dos valores de codigo de producto es: ',cant);
	end;
end;

var
	v:vec;
begin
	cargarVecDeArboles(v);
	existeProdEnRubro(v);
	mayor(v);
end.

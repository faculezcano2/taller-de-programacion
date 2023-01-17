const
	dimF=20;
type
	vec=array[1..dimF] of integer;


procedure cargarvector (var v: vec; var dimL: integer);

  procedure CargarVectorRecursivo (var v: vec; var dimL: integer);
  var 
	n:integer;
  begin
	n:=random(100);
    if (dimL < dimF) then begin
		dimL:= dimL + 1;
		v[dimL]:= n;
		CargarVectorRecursivo (v, dimL);
	end;
  end;
  
begin
  dimL:= 0;
  CargarVectorRecursivo (v, dimL);
end;

procedure ImprimirVector (v: vec; dimL: integer);
var
   i: integer;
begin
     for i:= 1 to dimF do
         write ('----');
     writeln;
     write (' ');
     for i:= 1 to dimF do begin
        write(v[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimF do
         write ('----');
     writeln;
     writeln;
End; 

function maximo( v:vec; dimL:integer):integer;
	function max( var maxi,i:integer):integer;
	begin
		if(i<=dimL)then begin
			if(v[i]>maxi) then maxi:=v[i];
			i:=i+1;
			max(maxi,i);
		end;
	max:=maxi;
	end;
var
	i,maxi:integer;
begin
	i:=1;
	maxi:=-9999;
	maximo:=max(maxi,i);
end;

function contador(v:vec; dimL:integer):integer;
	function cont(var total,i:integer):integer;
	begin
		if(i<=dimL)then begin
			total:=total+v[i];
			i:=i+1;
			cont(total,i);
		cont:=total;
		end;
	end;
var
	total:integer;
	i:integer;
begin
	total:=0;
	i:=1;
	contador:=cont(total,i);
end;
		
		
		
		
		
		
var
	v:vec;
	dimL:integer;
begin
	randomize;
	cargarvector(v,dimL);
	ImprimirVector(v,dimL);
	writeln(maximo(v,dimL));
	writeln(contador(v,dimL))
end.

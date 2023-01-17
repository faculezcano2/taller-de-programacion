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

procedure busquedaDicotomica(v:vec; ini,fin:integer; dato:integer; var pos:integer);
	function pos():integer;


var
	v:vec;
	dimL:integer;
begin
	randomize;
	cargarvector(v,dimL);
	ImprimirVector(v,dimL);
end.

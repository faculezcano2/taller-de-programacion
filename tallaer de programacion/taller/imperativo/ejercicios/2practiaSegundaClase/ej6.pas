procedure prueba(numero:integer);
var
	resultado:integer;
begin
	if (numero <>0) then begin
		resultado:= numero mod 2;
		numero:=numero div 2;
		prueba(numero);
	end;
	writeln(resultado);
end;


begin
prueba(198);
end.

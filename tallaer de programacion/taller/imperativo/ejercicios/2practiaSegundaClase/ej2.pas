{2.- Realizar un programa que lea números hasta leer el valor 0 e imprima,
 para cada número leído, sus dígitos en el orden en que aparecen en el número. 
 Debe implementarse un módulo recursivo que reciba el número e 
imprima lo pedido. Ejemplo si se lee el valor 256, se debe imprimir 2  5  6}

program ej2;

procedure haceTodo();
	procedure imprimirDigitos (num:integer);
	 var
	 aux: integer;
	 begin
		aux:= num;
		if ( num <> 0) then begin
			aux:= num MOD 10;
			num:= num DIV 10;
			imprimirDigitos (num);
			writeln (aux);
		end;
	 end;
	
	var num:integer;
	begin
		readln(num);
		if(num<>0)then begin
			imprimirDigitos(num);
			haceTodo();
		end;
	end;
begin
	haceTodo();
end.

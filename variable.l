%option noyywrap
%{
	#include<stdio.h>
%}

%%
[\n\t] ;
[a-zA-z]+[_0-9]*+ {printf("Es una variable\n");}
%%

int main()
{

printf("Ingrese el nombre de una variable: ");

yylex();
	return 0;
}
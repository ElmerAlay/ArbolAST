package com.compi2.usac.analizadores;
import java_cup.runtime.Symbol; 

%% 

// ---------------------------------------------------------- 
// ...................... Directivas ........................
// ----------------------------------------------------------
%cupsym Simbolo
%class Lexico
%public 
%line
%column 
%char 
%cup 
%unicode


// ---------------------------------------------------------- 
// .......... Inicializamos fila y columna en 1 .............
// ----------------------------------------------------------
%init{ 
    yyline = 1; 
    yycolumn = 1; 
%init} 
 

// ---------------------------------------------------------- 
// ................ Expresiones Regulares ...................
// ----------------------------------------------------------
number = [0-9]+
id = [A-Za-z]+["_"0-9A-Za-z]*

%%

// ----------------------------------------------------------------------------- 
// ........................... Palabras reservadas .............................
// -----------------------------------------------------------------------------

// ................................ Simbolos ...................................
"="     {
            return new Symbol(Simbolo.equals, yyline, yycolumn, yytext());
        } 

// ............................... Tipos de Datos ..............................
"entero"    {
                return new Symbol(Simbolo.entero, yyline, yycolumn, yytext());
            }

// .......................... Operadores Aritméticos ...........................
"+"         {
                return new Symbol(Simbolo.plus, yyline, yycolumn, yytext());
            } 
"-"         {
                return new Symbol(Simbolo.minus, yyline, yycolumn, yytext());
            } 
"*"         {
                return new Symbol(Simbolo.by, yyline, yycolumn, yytext());
            } 
"/"         {
                return new Symbol(Simbolo.divided, yyline, yycolumn, yytext());
            }

// .................................. Signos ...................................
";"     {
            return new Symbol(Simbolo.semiColon, yyline, yycolumn, yytext());
        }
","     {
            return new Symbol(Simbolo.colon, yyline, yycolumn, yytext());
        }


// ----------------------------------------------------------------------------- 
// .......................... Expresiones Regulares ............................
// -----------------------------------------------------------------------------

// ........................... Expresiones Regulares ...........................
{id}        {
                return new Symbol(Simbolo.id,yyline,yychar, yytext());
            } 
{number}    {
                return new Symbol(Simbolo.number, yyline, yycolumn, yytext());
            }

// .............................. Saltos de linea ..............................
\n          {
                yycolumn = 1;
            }
// .................................. Blancos ..................................
[ \r\t]+ {} 

// --------------------------------------------------------------------------------------------------------------
// .................................................. Errores ...................................................
// --------------------------------------------------------------------------------------------------------------
.   {
        System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
    }

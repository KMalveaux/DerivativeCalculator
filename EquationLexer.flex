import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

%%

%unicode
%cup
%line
%column

%%

/* keywords */
<YYINITIAL> "Hello"     { System.out.println("Hi"); }
%{
#include <stdio.h>
#include <string.h>

int keywords = 0;
int comments = 0;
int variables = 0;
int constants = 0;
int arithmetic_ops = 0;
int logical_ops = 0;
int special_symbols = 0;

const char *keyword_list[] = {
    "auto", "break", "case", "char", "const", "continue", "default", "do", "double", "else", 
    "enum", "extern", "float", "for", "goto", "if", "inline", "int", "long", "namespace", 
    "operator", "private", "protected", "public", "register", "return", "short", "signed", 
    "sizeof", "static", "struct", "switch", "template", "this", "throw", "try", "typedef", 
    "union", "unsigned", "using", "virtual", "void", "volatile", "while"
};

int is_keyword(const char *word) {
    for (int i = 0; i < sizeof(keyword_list) / sizeof(keyword_list[0]); i++) {
        if (strcmp(keyword_list[i], word) == 0) {
            return 1;
        }
    }
    return 0;
}
%}

%%
"//".*                { comments++; } /* Comentario de una línea */
"/*"([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*"*/" { comments++; } /* Comentario multilínea */
[a-zA-Z_][a-zA-Z0-9_]* {
    if (is_keyword(yytext)) {
        keywords++;
    } else {
        variables++;
    }
}
[0-9]+               { constants++; }
[+\-*/%]             { arithmetic_ops++; }
"&&"|"||"|"!"        { logical_ops++; }
[{}()\[\],;:]        { special_symbols++; }
.                    ; /* Ignorar otros caracteres */
%%

int main(int argc, char **argv) {
    if (argc != 2) {
        printf("Uso: %s <archivo_c++>\n", argv[0]);
        return 1;
    }

    FILE *file = fopen(argv[1], "r");
    if (!file) {
        perror("No se pudo abrir el archivo");
        return 1;
    }

    yyin = file;
    yylex();

    fclose(file);

    printf("Resultados del análisis:\n");
    printf("Palabras reservadas: %d\n", keywords);
    printf("Comentarios: %d\n", comments);
    printf("Nombres de variables: %d\n", variables);
    printf("Constantes numéricas: %d\n", constants);
    printf("Operadores aritméticos: %d\n", arithmetic_ops);
    printf("Operadores lógicos: %d\n", logical_ops);
    printf("Símbolos especiales: %d\n", special_symbols);

    return 0;
}
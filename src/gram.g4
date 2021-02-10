grammar gram;

inputGrammar: gramName vars? allRules;

gramName: GRAMMAR WORD SEMICOLON;

vars: A_OPEN var+ A_CLOSE;

var: WORD WORD SEMICOLON;

allRules: curRule+;

curRule: parseRule
       | tokenRule
       ;

parseRule: WORD argInit? COLON curRules SEMICOLON;

argInit: S_OPEN WORD WORD S_CLOSE;

curRules: curRules OR curRules
        | name+ CODE?
        ;

name: TOKEN
    | WORD ARG?
    ;

tokenRule: TOKEN COLON REG_EXPR CODE? SEMICOLON;


GRAMMAR: 'grammar';

R_OPEN: '(';
S_OPEN: '[';
C_OPEN: '{';
A_OPEN: '<-';
R_CLOSE: ')';
S_CLOSE: ']';
C_CLOSE: '}';
A_CLOSE: '->';

COLON: ':';
SEMICOLON: ';';
OR: '|';

ARG: R_OPEN .+? R_CLOSE;
CODE: C_OPEN .+? C_CLOSE;

TOKEN: [A-Z_]+;

WORD: [A-Za-z]+;

REG_EXPR: '"'.*?'"';
WHITESPACES: [ \n\t\r]+ -> skip;
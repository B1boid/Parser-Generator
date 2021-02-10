# Automatic translator generator

Here is an implementation of a simplified analogue of the translator generator. 
It will automatically generate: Lexer and Parser for given grammar from the input file (*.gram)


#### Grammar class
* LL(1) grammars, top-down parsing 
#### Attributes 
* synthesized attributes 
* inherited attributes 
#### Testing the resulting generator 
* Generated with resulting generator - calculator 
* Generated with resulting generator - С++ variable declaration
* [Unit tests](tests/) 

The grammars given at the input must match [grammar](src/gram.g4)
Examples: [calc.gram](src/calc.gram) and [cdecl.gram](src/cdecl.gram)

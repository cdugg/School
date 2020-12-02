grammar cal;

program:             decl_list function_list main;
decl_list:           decl Semi decl_list
                    |
                    ;
decl:                var_decl
                    |const_decl
                    ;
var_decl:            Variable Id Colon type;
const_decl:          Constant Id Colon type Assign expression;
function_list:       function function_list
                    |
                    ;
function:            type Id LBR parameter_list RBR Is
                     decl_list
                     Begin
                     statement_block
                     Return LBR (expression | ) RBR Semi
                     End
                    ;
type:                Integer
                    |Boolean
                    |Void
                    ;
parameter_list:      nemp_parameter_list
                    |
                    ;
nemp_parameter_list: Id Colon type
                    |Id Colon type Comma nemp_parameter_list
                    ;
main:                Main
                     Begin
                     decl_list
                     statement_block
                     End
                    ;
statement_block:     statement statement_block
                    |
                    ;
statement:           Id Assign expression Semi
                    |Id LBR arg_list RBR Semi
                    |Begin statement_block End
                    |If condition Begin statement_block End
                     Else Begin statement_block End
                    |While condition Begin statement_block End
                    |Skip Semi
                    ;
expression:          frag binary_arith_op frag
                    |LBR expression RBR
                    |Id LBR arg_list RBR
                    |frag
                    ;
binary_arith_op:     Plus
                    |Minus
                    ;
frag:                Id
                    |Minus Id
                    |Num
                    |True
                    |False
                    |LBR expression RBR
                    ;
condition:           Negate condition
                    |LBR condition RBR
                    |expression comp_op expression
                    |condition (Or | And) condition
                    ;
comp_op:             Equal
                    |NotEqual
                    |Less
                    |LessEq
                    |Greater
                    |GreaterEq
                    ;
arg_list:            nemp_arg_list
                    |
                    ;
nemp_arg_list:       Id
                    |Id Comma nemp_arg_list
                    ;

fragment A: 'a' | 'A';
fragment B: 'b' | 'B';
fragment C: 'c' | 'C';
fragment D: 'd' | 'D';
fragment E: 'e' | 'E';
fragment F: 'f' | 'F';
fragment G: 'g' | 'G';
fragment H: 'h' | 'H';
fragment I: 'i' | 'I';
fragment J: 'j' | 'J';
fragment K: 'k' | 'K';
fragment L: 'l' | 'L';
fragment M: 'm' | 'M';
fragment N: 'n' | 'N';
fragment O: 'o' | 'O';
fragment P: 'p' | 'P';
fragment Q: 'q' | 'Q';
fragment R: 'r' | 'R';
fragment S: 's' | 'S';
fragment T: 't' | 'T';
fragment U: 'u' | 'U';
fragment V: 'v' | 'V';
fragment W: 'w' | 'W';
fragment X: 'x' | 'X';
fragment Y: 'y' | 'Y';
fragment Z: 'z' | 'Z';

Variable:   V A R I A B L E;
Constant:   C O N S T A N T;
Return:     R E T U R N;
Integer:    I N T E G E R;
Boolean:    B O O L E A N;
Void:       V O I D;
Main:       M A I N;
If:         I F;
Else:       E L S E;
True:       T R U E;
False:      F A L S E;
While:      W H I L E;
Begin:      B E G I N;
End:        E N D;
Is:         I S;
Skip:       S K I P;
Assign:        ':=';
Comma:         ',';
Semi:          ';';
Colon:         ':';
LBR:           '(';
RBR:           ')';
Plus:          '+';
Minus:         '-';
Negate:        '~';
Or:            '|';
And:           '&';
Equal:         '=';
NotEqual:      '!=';
LessEq:        '<=';
Less:          '<';
GreaterEq:     '>=';
Greater:       '>';
Num:           ('-'?[1-9][0-9]* | '0');
Id:            [a-zA-Z][a-zA-Z0-9_]*;
InLineComment: '/*'(InLineComment | .)*?'*/' -> skip;
LineComment:   '//'.*?('\n' | EOF) -> skip;
WS:            [ \t\n\r]+ -> skip;
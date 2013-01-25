grammar AsciiMath;

    options {
        // language=Python;
        ASTLabelType=CommonTree;
    }
 /*
   @init {self.memory = {}}
 */
/*Parsing ASCII math expressions with the following grammar
  v ::= [A-Za-z] | greek letters | numbers | other constant symbols
  u ::= sqrt | text | bb | other unary symbols for font commands
  b ::= frac | root | stackrel         binary symbols
  l ::= ( | [ | { | (: | {:            left brackets
  r ::= ) | ] | } | :) | :}            right brackets
  S ::= v | lEr | uS | bSS             Simple expression
  I ::= S_S | S^S | S_S^S | S          Intermediate expression
  E ::= IE | I/I                       Expression
  Each terminal symbol is translated into a corresponding mathml node.*/
expr       : (i '/' i | i)+;

i        :s '_' s '^' s | s '^' s | s'_'s |s;

s       :U s | B s s |V|L expr R ;

U       :'sqrt'
        |'sin';

B       :'frac'
        |'root';

L       :('('
        |'['
        |'{'
        |'(:'
        |'{:');

R       :(')'|']'|'}'|':)'|':}');
/* tokens */
V       :'a'..'z'
        |'A'..'Z'
        |GREEK;



// Greek symbols
fragment
GREEK    :    'alpha'
        |'beta'
        |'chi'
        |'delta'
        |'Delta'
        |'epsi'
        |'varepsilon'
        |'eta'
        |'gamma'
        |'Gamma'
        |'iota'
        |'kappa'
        |'lambda'
        |'Lambda'
        |'mu'
        |'nu'
        |'omega'
        |'Omega'
        |'phi'
        |'varphi'
        |'Phi'
        |'pi'
        |'Pi'
        |'psi'
        |'rho'
        |'sigma'
        |'Sigma'
        |'tau'
        |'theta'
        |'vartheta'
        |'Theta'
        |'upsilon'
        |'xi'
        |'zeta';

// Binary operation symbols
infix    :'*'
        |'**'
        |'//'
        |'\\\\'
        |'setminus'
        |'xx'
        |'-:' //divide
        |'divide'
        |'&deg;'
        |'@'
        |'o+'
        |'ox'
        |'o.'
        |'sum'
        |'prod'
        |'^^'
        |'^^^'
        |'vv'
        |'vvv'
        |'nn'
        |'nnn'
        |'uu'
        |'uuu';
// Binary relation symbols
relation
        :'!='
        |':='
        |'<'
        |'<='
        |'lt='
        |'>'
        |'>='
        |'gt='
        |'-<'
        |'-lt'
        |'>-'
        |'in'
        |'!in'
        |'sub'
        |'sup'
        |'sube'
        |'supe'
        |'-='
        |'~='
        |'cong'
        |'~~'
        |'prop';
// Logical symbols
logical
        :'and'
        |'or'
        |'not'
        |'=>'
        |'implies'
        |'if'
        |'<=>'
        |'iff'
        |'AA'
        |'EE'
        |'_|_'
        |'TT'
        |'|--';
// Miscellaneous symbols
misc    
        :'int'
        |'dx'
        |'dy'
        |'dz'
        |'dt'
        |'oint'
        |'del'
        |'grad'
        |'+-'
        |'O/'
        |'oo'
        |'aleph'
        |'...'
        |':.'
        |'/_'
        |'\\ '
        |'quad'
        |'qquad'
        |'cdots'
        |'vdots' 
        |'ddots' 
        |'diamond'
        |'square'
        |'|__'
        |'__|'
        |'|~'
        |'lceiling'
        |'~|'
        |'rceiling'
        |'CC'
        |'NN'
        |'QQ'
        |'RR'
        |'ZZ';
// Standard functions
fun
        :'lim'
        |'Lim';
// unary
unary        
        :'sin'
        |'cos'
        |'tanh'
        |'cot'
        |'sec'
        |'csc'
        |'coth'
        |'sech'
        |'csch'
        |'log'
        |'tan'
        |'arcsin'
        |'arccos'
        |'arctan'
        |'sinh'
        |'cosh'
                |'ln'
        |'Sin'
        |'Cos'
        |'Tan'
        |'Arcsin'
        |'Arccos'
        |'Arctan'
        |'Sinh'
        |'Cosh'
        |'Tanh'
        |'Cot'
        |'Sec'
        |'Csc'
        |'Coth'
        |'Sech'
        |'Csch'
        |'Log'
        |'Ln'
        |'abs'
        |'Abs'
        |'det'
        |'exp'
        |'dim'
        |'mod'
        |'gcd'
        |'lcm'
        |'lub'
        |'glb'
        |'min'
        |'max'
        |'f'
        |'g';
//|"''"
//|"'''"
//|"''''"

// Arrows
arrow    
        :'uarr'
        |'darr'
        |'rarr'
        |'->'
        |'|->'
        |'larr'
        |'harr'
        |'rArr'
        |'lArr'
        |'hArr';

// Commands with argument
binary    
        :'sqrt'
        |'Sqrt'
//        |'/'
        |'_'
        |'^'
        |'hat'
        |'bar'
        |'vec'
        |'tilde'
        |'dot'
        |'ddot'
        |'ul'
        |'text'
        |'mbox'
        |'"'
        |'stackrel'
        |'root'
        |'frac';

// Grouping brackets
bracket    
        :'('
        |')'
        |'['
        |']'
        |'{'
        |'}'
        |'|'
        |'(:'
        |':)'
        |'{:'
        |':}'
        |'<<'
        |'>>';

    //fonts
font    
        :'color'
        |'bb'
        |'sf'
        |'bbb'
        |'cc'
        |'tt'
        |'fr';


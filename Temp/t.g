grammar t;

/* http://www1.chapman.edu/~jipsen/mathml/asciimathsyntax.html */

e	:	(s|b)*;

b	:	s ('/'|'_'|'^') s;

s	:	(c|L e R|U s|B s s);

c	:	LATTIN|GREEK;

U	:	'-'|'sqrt'|'sin';

B	:	'root'|'frac';

L       :'('|'['|'{'|'(:'|'{:';

R       :')'|']'|'}'|':)'|':}';

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')+
    |   '.' ('0'..'9');

LOGICAL	:'and'
	|'or'
	|'neg'	|'not'	|'¬'
	|'implies'	|'=>'	|'⇒'
	|'if'
	|'iff'	|'<=>'	|'⇔'
	|'forall'	|'AA'	|'∀'
	|'exists'	|'EE'	|'∃'
	|'bot'	|'_|_'	|'⊥'
	|'top'	|'TT'	|'⊤'
	|'vdash'	'|--'	|'⊢'
	|'models'	|'|=='	|'⊨';

MISC	:'int'	|'∫'
	|'dx'
	|'dy'
	|'dz'
	|'dt'
	|'oint'	|'∮'
	|'del'	|'∂'
	|'grad'	|'∇'
	|'+-'	|'±'
	|'O/'	|'∅'
	|'oo'	|'∞'
	|'aleph'	|'ℵ'
	|'/_'	|'∠'
	|':.'	|'∴'
	|'...'	
	|'cdots'	|'⋯'
	|'vdots'	|'⋮'
	|'ddots'	|'⋱'
	|'\\ '	|' '
	|'quad'	|'\u00A0\u00A0'
	|'qquad'	|'\u00A0\u00A0\u00A0\u00A0'
	|'diamond'	|'⋄'
	|'square'	|'□'
	|'lfloor'	|'|__'	|'⌊'
	|'rfloor'	|'__|'	|'⌋'
	|'lceiling'	|'|~'	|'⌈'
	|'rceiling'	|'~|'	|'⌉'
	|'CC'	|'ℂ'
	|'NN'	|'ℕ'
	|'QQ'	|'ℚ'
	|'RR'	|'ℝ'
	|'ZZ'	|'ℤ'
	|'f'
	|'g'
	;

FUNCTIONS	:'sin'
	|'cos'
	|'tan'
	|'csc'
	|'sec'
	|'cot'
	|'sinh'
	|'cosh'
	|'tanh'
	|'log'
	|'ln'
	|'det'
	|'dim'
	|'lim'
	|'Lim'
	|'mod'
	|'gcd'
	|'lcm'
	|'min'
	|'max';



ARROW	:
	|'uparrow'	|'uarr'	|'↑'
	|'downarrow'|'darr'	|'↓'
	|'to'	|'rightarrow'|'rarr'	|'->'	|'→'
	|'>->'	|'\u21A0'
	|'->>'
	|'>->>'
	|'mapsto'	|'|->'	|'↦'
	|'leftarrow'	|'larr'	|'←'
	|'leftrightarrow'|'harr'	|'↔'
	|'Rightarrow'|'rArr'	|'⇒'
	|'Leftarrow'	|'lArr'	|'⇐'
	|'Leftrightarrow'|'hArr'	|'⇔'
	;
	
COMMANDS:	
	|'sqrt'
	|'root'
	|'frac'
	|'/'
	|'stackref'
	|'_'
	|'^'
	;
	
ACCENT	:'hat'	|'\u005E'
	'bar'	|'\u00AF'
	''
	|'bar'|'ul'|'vec'|'dot'|'ddot';

FONT	:'mathbf'	|'bb'
	|'mathbb'	|'bbb'
	|'mathcal'	|'cc'
	|'mathtt'	|'tt'
	|'mathfrak'	|'fr'
	|'mathsf'	|'sf'
	;
LATTIN	: 'A'..'Z'
	|'a'..'z';

GREEK		
	:'alpha'	|'α'
	|'beta'	|'β'
	|'chi'	|'χ'
	|'delta'	|'δ'
	|'Delta'	|'Δ'
	|'epsilon'	|'epsi'	|'ε'
	|'varepsilon'	|'ɛ'
	|'eta'	|'η'
	|'gamma'	|'γ'
	|'Gamma'	|'Γ'
	|'iota'	|'ι'
	|'kappa'	|'κ'
	|'lambda'	|'λ'
	|'Lambda'	|'Λ'
	|'mu'	|'μ'
	|'nu'	|'ν'
	|'omega'	|'ω'
	|'Omega'	|'Ω'
	|'phi'	|'φ'
	|'varphi'	|'ϕ'
	|'Phi'	|'Φ'
	|'pi'	|'π'
	|'Pi'	|'Π'
	|'psi'	|'ψ'
	|'Psi'	|'Ψ'
	|'rho'	|'ρ'
	|'sigma'	|'σ'
	|'Sigma'	|'Σ'
	|'tau'	|'τ'
	|'theta'	|'θ'
	|'vartheta'	|'ϑ'
	|'Theta'	|'Θ'
	|'upsilon'	|'υ'
	|'xi'	|'ξ'
	|'Xi'	|'Ξ'
	|'zeta'	|'ζ'
	;
/* ASCIIMATH	TEX	SEE */
OPERATION	:'+'
	|'-'	|'\u0096'
	|'cdot'	|'*'	|'⋅'
	|'star'	|'**'	|'⋆'
	|'//'
	|'backslash'	|'setminus'	|'\\\\'
	|'times'	|'xx'	|'×'
	|'divide'	|'-:'	|'÷'
	|'circ'	|'@'	|'∘'
	|'oplus'	|'o+'	|'⊕'
	|'otimes'	|'ox'	|'⊗'
	|'odot'	|'o.'	|'⊙'
	|'sum'		|'∑'
	|'prod'		|'∏'
	|'wedge'	|'^^'	|'∧'
	|'bigwedge'	|'^^^'	|'⋀'
	|'vee'	|'vv'	|'∨'
	|'bigvee'	|'vvv'	|'⋁'
	|'cap'	|'nn'	|'∩'
	|'bigcap'	|'nnn'	|'⋂'
	|'cup'	|'uu'	|'∪'
	|'bigcup'	|'uuu'	|'⋃';
RELATION:
	|'='
	|'ne'	|'!='	|'≠'
	|'lt'	|'<'
	|'gt'	|'>'
	|'lt='|'<='	|'≤'
	|'ge'	|'geq'	|'>='	|'≥'
	|'prec'	|'-lt'	|'-<'	|'≺'
	|'succ'	|'>-'	|'≻'
	|'preceq'	|'-<='	|'\u2AAF'
	|'succeq'	|'>-='	|'\u2AB0'
	|'in'	|'∈'
	|'notin'	|'!in'	|'∉'
	|'subset'	|'sub'	|'⊂'
	|'supset'	|'sup'	|'⊃'
	|'subseteq'	|'sube'	|'⊆'
	|'supseteq'	|'supe'	|'⊇'
	|'equiv'	|'-='	|'≡'
	|'cong'	|'~='	|'≅'
	|'approx'	|'~~'	|'≈'
	|'propto'	|'prop'	|'∝';

/* brackets */'
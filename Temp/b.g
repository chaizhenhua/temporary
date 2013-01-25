grammar b;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')+
    |   '.' ('0'..'9')+
    ;

s	:	CONST | LEFT s RIGHT| UNARY s | BINARY s s ;
e	:	(s ('_' s)? ('^'s)?)+;


/* CONST */
CONST	:	GREEK|LATTIN
	;
fragment
LATTIN	:	 'A'..'Z'
		|'a'..'z';
fragment
GREEK		:'alpha'	|'α'
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
		|'zeta'	|'ζ' ;


OPERATOR	:'cdot'	|'*'	|'⋅'
	|'star'	|'**'	|'⋆'
		|'//'	|'/'
	|'backslash'	|'\\'	
		|'setminus'	/*|'\'*/
	|'times'	|'xx'	|'×'
	|'divide'	|'-:'	|'÷'
	|'circ'	|'@'	|'⚬'
	|'oplus'	|'o+'	|'⊕'
	|'otimes'	|'ox'	|'⊗'
	|'odot'	|'o.'	|'⊙'
	|'wedge'	|'^^'	|'∧'
	|'vee'	|'vv'	|'∨'
	|'cap'	|'nn'	|'∩'
	|'cup'	|'uu'	|'∪'
	|'ne'	|'!='	|'≠'
		|':='
		|'lt'	|'<'
	|'le'	|'leq'	|'lt='	|'<='	|'≤'
	|'ge'	|'geq'	|'>='	|'≥'
	|'prec'	|'-lt'	|'-<'	|'≺'
	|'succ'	|'>-'	|'≻'
	|'preceq'	|'-<='	|'⪯'
	|'succeq'	|'>-='	|'⪰'
		|'in'	|'∈'
	|'notin'	|'!in'	|'∉'
	|'subset'	|'sub'	|'⊂'
	|'supset'	|'sup'	|'⊃'
	|'subseteq'	|'sube'	|'⊆'
	|'supseteq'	|'supe'	|'⊇'
	|'equiv'	|'-='	|'≡'
	|'cong'	|'~='	|'≅'
	|'approx'	|'~~'	|'≈'
	|'propto'	|'prop'	|'∝'
	|'neg'	|'not'	|'¬'
	|'forall'	|'AA'	|'∀'
	|'exists'	|'EE'	|'∃'
	|'bot'	|'_|_'	|'⊥'
	|'top'	|'TT'	|'⊤'
	|'vdash'	|'|--'	|'⊢'
	|'models'	|'|=='	|'⊨'
		|'int'	|'∫'
		|'oint'	|'∮'
	|'partial'	|'del'	|'∂'
	|'nabla'	|'grad'	|'∇'
	|'pm'	|'+-'	|'±'
	|'emptyset'	|'O/'	|'∅'
	|'infty'	|'oo'	|'∞'
		|'aleph'	|'ℵ'
	|'ldots'	|'...'	
	|'therefore'	|':.'	|'∴'
	|'angle'	|'/_'	|'∠'
		|'\ '	|' '
		|'quad'	|'  '
		|'qquad'	|'    '
		|'cdots'	|'⋯'
		|'vdots'	|'⋮'
		|'ddots'	|'⋱'
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
		|'dim'	
		|'mod'	
		|'lub'	
		|'glb'	
/* ARROW */	|'uparrow'		|'uarr'	|'↑'
	|'downarrow'	|'darr'	|'↓'
	|'rightarrow'	|'rarr'	|'to'	|'->'	|'→'
	/*|'rightarrowtail'*/	|'>->'	|'↣'
	/*|'twoheadrightarrow'*/	|'->>'	|'↠'
	/*|'twoheadrightarrowtail'*/	|'>->>'	|'⤖'
	|'mapsto'	|'|->'	|'↦'
	|'leftarrow'	|'larr'	|'←'
	|'leftrightarrow'	|'harr'	|'↔'
	|'Rightarrow'	|'rArr'	|'implies'	|'=>'	|'⇒'
	|'Leftarrow'	|'lArr'	|'⇐'
	|'Leftrightarrow'	|'hArr'	|'iff'	|'<=>'	|'⇔';
	
/* UNARY */
UNARY		:'f'	
		|'g'
		|'sin'
		|'cos'
		|'tan'
		|'sinh'
		|'cosh'
		|'tanh'
		|'cot'
		|'sec'
		|'csc'
		|'log'
		|'ln'
		|'det'
		|'gcd'
		|'lcm'
		|'sqrt'
		|'hat'	
	|'overline'	|'bar'	
		|'vec'	
		|'dot'	
		|'ddot'	
	|'underline'	|'ul'	
		|'bb'	
		|'mathbf'	
		|'sf'	
		|'mathsf'	
		|'bbb'	
		|'mathbb'	
		|'cc'	
		|'mathcal'	
		|'tt'	
		|'mathtt'	
		|'fr'	
		|'mathfrak'
	;
	
BINARY
	:	 'root'
		|'frac'	/* |'/' */
		|'stackrel'
	;
	
INFIX:
		|'/'
		|'_'
		|'^'
	;
	
LEFT
	:	 '('
		|'['
		|'{'
	|'langle'	|'(:'	|'<<'	|'〈'
		|'{:'
	;
RIGHT
	:	  ')'	
		|']'	
		|'}'	
	|'rangle'	|':)'	|'>>'	|'〉'
		|':}'	
	;
/* SPACE */
SPACE
	:	 'and'
		|'or'
		|'if'
	;
/* UNDEROVER */
UNDEROVER	:
		 'sum'	|'∑'
		|'prod'	|'∏'
	|'bigwedge'	|'^^^'	|'⋀'
	|'bigvee'	|'vvv'	|'⋁'
	|'bigcap'	|'nnn'	|'⋂'
	|'bigcup'	|'uuu'	|'⋃'
		|'lim'
		|'Lim'
		|'min'
		|'max'
	;
DEFINITION	:
		|'dx'	|'{:d x:}'
		|'dy'	|'{:d y:}'
		|'dz'	|'{:d z:}'
		|'dt'	|'{:d t:}'
	;
LEFTRIGHT
	:	
		|'|'
	;
TEXT	:
		|'text'
		|'mbox'
	;
		


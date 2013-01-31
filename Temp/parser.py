
CONST = 0
UNARY = 1
BINARY = 2
INFIX = 3
LEFTBRACKET = 4
RIGHTBRACKET = 5
SPACE = 6
UNDEROVER = 7
DEFINITION = 8
LEFTRIGHT = 9
TEXT = 10
BIG = 11
LONG = 12
STRETCHY = 13
MATRIX = 14

AMquote = {'input':"\"",   'tag':"mtext", 'output':"mbox", 'tex':None, 'ttype':TEXT}

AMsymbols = [{'tex': None, 'input': 'alpha', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b1'},
 {'tex': None, 'input': 'beta', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b2'},
 {'tex': None, 'input': 'chi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c7'},
 {'tex': None, 'input': 'delta', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b4'},
 {'tex': None, 'input': 'Delta', 'tag': 'mo', 'ttype': 0, 'output': u'\\u0394'},
 {'tex': 'epsilon', 'input': 'epsi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b5'},
 {'tex': None, 'input': 'varepsilon', 'tag': 'mi', 'ttype': 0, 'output': u'\\u025b'},
 {'tex': None, 'input': 'eta', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b7'},
 {'tex': None, 'input': 'gamma', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b3'},
 {'tex': None, 'input': 'Gamma', 'tag': 'mo', 'ttype': 0, 'output': u'\\u0393'},
 {'tex': None, 'input': 'iota', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b9'},
 {'tex': None, 'input': 'kappa', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03ba'},
 {'tex': None, 'input': 'lambda', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03bb'},
 {'tex': None, 'input': 'Lambda', 'tag': 'mo', 'ttype': 0, 'output': u'\\u039b'},
 {'tex': None, 'input': 'mu', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03bc'},
 {'tex': None, 'input': 'nu', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03bd'},
 {'tex': None, 'input': 'omega', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c9'},
 {'tex': None, 'input': 'Omega', 'tag': 'mo', 'ttype': 0, 'output': u'\\u03a9'},
 {'tex': None, 'input': 'phi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c6'},
 {'tex': None, 'input': 'varphi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03d5'},
 {'tex': None, 'input': 'Phi', 'tag': 'mo', 'ttype': 0, 'output': u'\\u03a6'},
 {'tex': None, 'input': 'pi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c0'},
 {'tex': None, 'input': 'Pi', 'tag': 'mo', 'ttype': 0, 'output': u'\\u03a0'},
 {'tex': None, 'input': 'psi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c8'},
 {'tex': None, 'input': 'Psi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03a8'},
 {'tex': None, 'input': 'rho', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c1'},
 {'tex': None, 'input': 'sigma', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c3'},
 {'tex': None, 'input': 'Sigma', 'tag': 'mo', 'ttype': 0, 'output': u'\\u03a3'},
 {'tex': None, 'input': 'tau', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c4'},
 {'tex': None, 'input': 'theta', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b8'},
 {'tex': None, 'input': 'vartheta', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03d1'},
 {'tex': None, 'input': 'Theta', 'tag': 'mo', 'ttype': 0, 'output': u'\\u0398'},
 {'tex': None, 'input': 'upsilon', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03c5'},
 {'tex': None, 'input': 'xi', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03be'},
 {'tex': None, 'input': 'Xi', 'tag': 'mo', 'ttype': 0, 'output': u'\\u039e'},
 {'tex': None, 'input': 'zeta', 'tag': 'mi', 'ttype': 0, 'output': u'\\u03b6'},
 {'tex': 'cdot', 'input': '*', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22c5'},
 {'tex': 'star', 'input': '**', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22c6'},
 {'tex': None, 'input': '//', 'tag': 'mo', 'ttype': 0, 'output': '/'},
 {'tex': 'backslash', 'input': '\\\\\\\\', 'tag': 'mo', 'ttype': 0, 'output': '\\\\'},
 {'tex': None, 'input': 'setminus', 'tag': 'mo', 'ttype': 0, 'output': '\\\\'},
 {'tex': 'times', 'input': 'xx', 'tag': 'mo', 'ttype': 0, 'output': u'\\xd7'},
 {'tex': 'divide', 'input': '-:', 'tag': 'mo', 'ttype': 0, 'output': u'\\xf7'},
 {'tex': 'circ', 'input': '@', 'tag': 'mo', 'ttype': 0, 'output': u'\\u26ac'},
 {'tex': 'oplus', 'input': 'o+', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2295'},
 {'tex': 'otimes', 'input': 'ox', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2297'},
 {'tex': 'odot', 'input': 'o.', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2299'},
 {'tex': None, 'input': 'sum', 'tag': 'mo', 'ttype': 7, 'output': u'\\u2211'},
 {'tex': None, 'input': 'prod', 'tag': 'mo', 'ttype': 7, 'output': u'\\u220f'},
 {'tex': 'wedge', 'input': '^^', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2227'},
 {'tex': 'bigwedge', 'input': '^^^', 'tag': 'mo', 'ttype': 7, 'output': u'\\u22c0'},
 {'tex': 'vee', 'input': 'vv', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2228'},
 {'tex': 'bigvee', 'input': 'vvv', 'tag': 'mo', 'ttype': 7, 'output': u'\\u22c1'},
 {'tex': 'cap', 'input': 'nn', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2229'},
 {'tex': 'bigcap', 'input': 'nnn', 'tag': 'mo', 'ttype': 7, 'output': u'\\u22c2'},
 {'tex': 'cup', 'input': 'uu', 'tag': 'mo', 'ttype': 0, 'output': u'\\u222a'},
 {'tex': 'bigcup', 'input': 'uuu', 'tag': 'mo', 'ttype': 7, 'output': u'\\u22c3'},
 {'tex': 'ne', 'input': '!=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2260'},
 {'tex': None, 'input': ':=', 'tag': 'mo', 'ttype': 0, 'output': ':='},
 {'tex': None, 'input': 'lt', 'tag': 'mo', 'ttype': 0, 'output': '<'},
 {'tex': 'le', 'input': '<=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2264'},
 {'tex': 'leq', 'input': 'lt=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2264'},
 {'tex': 'ge', 'input': '>=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2265'},
 {'tex': None, 'input': 'geq', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2265'},
 {'tex': 'prec', 'input': '-<', 'tag': 'mo', 'ttype': 0, 'output': u'\\u227a'},
 {'tex': None, 'input': '-lt', 'tag': 'mo', 'ttype': 0, 'output': u'\\u227a'},
 {'tex': 'succ', 'input': '>-', 'tag': 'mo', 'ttype': 0, 'output': u'\\u227b'},
 {'tex': 'preceq', 'input': '-<=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2aaf'},
 {'tex': 'succeq', 'input': '>-=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2ab0'},
 {'tex': None, 'input': 'in', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2208'},
 {'tex': 'notin', 'input': '!in', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2209'},
 {'tex': 'subset', 'input': 'sub', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2282'},
 {'tex': 'supset', 'input': 'sup', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2283'},
 {'tex': 'subseteq', 'input': 'sube', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2286'},
 {'tex': 'supseteq', 'input': 'supe', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2287'},
 {'tex': 'equiv', 'input': '-=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2261'},
 {'tex': 'cong', 'input': '~=', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2245'},
 {'tex': 'approx', 'input': '~~', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2248'},
 {'tex': 'propto', 'input': 'prop', 'tag': 'mo', 'ttype': 0, 'output': u'\\u221d'},
 {'tex': None, 'input': 'and', 'tag': 'mtext', 'ttype': 6, 'output': 'and'},
 {'tex': None, 'input': 'or', 'tag': 'mtext', 'ttype': 6, 'output': 'or'},
 {'tex': 'neg', 'input': 'not', 'tag': 'mo', 'ttype': 0, 'output': u'\\xac'},
 {'tex': 'implies', 'input': '=>', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21d2'},
 {'tex': None, 'input': 'if', 'tag': 'mo', 'ttype': 6, 'output': 'if'},
 {'tex': 'iff', 'input': '<=>', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21d4'},
 {'tex': 'forall', 'input': 'AA', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2200'},
 {'tex': 'exists', 'input': 'EE', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2203'},
 {'tex': 'bot', 'input': '_|_', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22a5'},
 {'tex': 'top', 'input': 'TT', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22a4'},
 {'tex': 'vdash', 'input': '|--', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22a2'},
 {'tex': 'models', 'input': '|==', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22a8'},
 {'tex': None, 'input': '(', 'tag': 'mo', 'ttype': 4, 'output': '('},
 {'tex': None, 'input': ')', 'tag': 'mo', 'ttype': 5, 'output': ')'},
 {'tex': None, 'input': '[', 'tag': 'mo', 'ttype': 4, 'output': '['},
 {'tex': None, 'input': ']', 'tag': 'mo', 'ttype': 5, 'output': ']'},
 {'tex': None, 'input': '{', 'tag': 'mo', 'ttype': 4, 'output': '{'},
 {'tex': None, 'input': '}', 'tag': 'mo', 'ttype': 5, 'output': '}'},
 {'tex': None, 'input': '|', 'tag': 'mo', 'ttype': 9, 'output': '|'},
 {'tex': 'langle', 'input': '(:', 'tag': 'mo', 'ttype': 4, 'output': u'\\u2329'},
 {'tex': 'rangle', 'input': ':)', 'tag': 'mo', 'ttype': 5, 'output': u'\\u232a'},
 {'tex': None, 'input': '<<', 'tag': 'mo', 'ttype': 4, 'output': u'\\u2329'},
 {'tex': None, 'input': '>>', 'tag': 'mo', 'ttype': 5, 'output': u'\\u232a'},
 {'output': '{:', 'tex': None, 'tag': 'mo', 'ttype': 4, 'invisible': True, 'input': '{:'},
 {'output': ':}', 'tex': None, 'tag': 'mo', 'ttype': 5, 'invisible': True, 'input': ':}'},
 {'tex': None, 'input': 'int', 'tag': 'mo', 'ttype': 0, 'output': u'\\u222b'},
 {'tex': None, 'input': 'dx', 'tag': 'mi', 'ttype': 8, 'output': '{:d x:}'},
 {'tex': None, 'input': 'dy', 'tag': 'mi', 'ttype': 8, 'output': '{:d y:}'},
 {'tex': None, 'input': 'dz', 'tag': 'mi', 'ttype': 8, 'output': '{:d z:}'},
 {'tex': None, 'input': 'dt', 'tag': 'mi', 'ttype': 8, 'output': '{:d t:}'},
 {'tex': None, 'input': 'oint', 'tag': 'mo', 'ttype': 0, 'output': u'\\u222e'},
 {'tex': 'partial', 'input': 'del', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2202'},
 {'tex': 'nabla', 'input': 'grad', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2207'},
 {'tex': 'pm', 'input': '+-', 'tag': 'mo', 'ttype': 0, 'output': u'\\xb1'},
 {'tex': 'emptyset', 'input': 'O/', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2205'},
 {'tex': 'infty', 'input': 'oo', 'tag': 'mo', 'ttype': 0, 'output': u'\\u221e'},
 {'tex': None, 'input': 'aleph', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2135'},
 {'tex': 'ldots', 'input': '...', 'tag': 'mo', 'ttype': 0, 'output': '...'},
 {'tex': 'therefore', 'input': ':.', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2234'},
 {'tex': 'angle', 'input': '/_', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2220'},
 {'tex': None, 'input': '\\\\ ', 'tag': 'mo', 'ttype': 0, 'output': u'\\xa0'},
 {'tex': None, 'input': 'quad', 'tag': 'mo', 'ttype': 0, 'output': u'\\xa0\\xa0'},
 {'tex': None, 'input': 'qquad', 'tag': 'mo', 'ttype': 0, 'output': u'\\xa0\\xa0\\xa0\\xa0'},
 {'tex': None, 'input': 'cdots', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22ef'},
 {'tex': None, 'input': 'vdots', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22ee'},
 {'tex': None, 'input': 'ddots', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22f1'},
 {'tex': None, 'input': 'diamond', 'tag': 'mo', 'ttype': 0, 'output': u'\\u22c4'},
 {'tex': None, 'input': 'square', 'tag': 'mo', 'ttype': 0, 'output': u'\\u25a1'},
 {'tex': 'lfloor', 'input': '|__', 'tag': 'mo', 'ttype': 0, 'output': u'\\u230a'},
 {'tex': 'rfloor', 'input': '__|', 'tag': 'mo', 'ttype': 0, 'output': u'\\u230b'},
 {'tex': 'lceiling', 'input': '|~', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2308'},
 {'tex': 'rceiling', 'input': '~|', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2309'},
 {'tex': None, 'input': 'CC', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2102'},
 {'tex': None, 'input': 'NN', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2115'},
 {'tex': None, 'input': 'QQ', 'tag': 'mo', 'ttype': 0, 'output': u'\\u211a'},
 {'tex': None, 'input': 'RR', 'tag': 'mo', 'ttype': 0, 'output': u'\\u211d'},
 {'tex': None, 'input': 'ZZ', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2124'},
 {'output': 'f', 'tex': None, 'tag': 'mi', 'FUNC': True, 'ttype': 1, 'input': 'f'},
 {'output': 'g', 'tex': None, 'tag': 'mi', 'FUNC': True, 'ttype': 1, 'input': 'g'},
 {'tex': None, 'input': 'lim', 'tag': 'mo', 'ttype': 7, 'output': 'lim'},
 {'tex': None, 'input': 'Lim', 'tag': 'mo', 'ttype': 7, 'output': 'Lim'},
 {'output': 'sin', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'sin'},
 {'output': 'cos', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'cos'},
 {'output': 'tan', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'tan'},
 {'output': 'sinh', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'sinh'},
 {'output': 'cosh', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'cosh'},
 {'output': 'tanh', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'tanh'},
 {'output': 'cot', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'cot'},
 {'output': 'sec', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'sec'},
 {'output': 'csc', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'csc'},
 {'output': 'log', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'log'},
 {'output': 'ln', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'ln'},
 {'output': 'det', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'det'},
 {'tex': None, 'input': 'dim', 'tag': 'mo', 'ttype': 0, 'output': 'dim'},
 {'tex': None, 'input': 'mod', 'tag': 'mo', 'ttype': 0, 'output': 'mod'},
 {'output': 'gcd', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'gcd'},
 {'output': 'lcm', 'tex': None, 'tag': 'mo', 'FUNC': True, 'ttype': 1, 'input': 'lcm'},
 {'tex': None, 'input': 'lub', 'tag': 'mo', 'ttype': 0, 'output': 'lub'},
 {'tex': None, 'input': 'glb', 'tag': 'mo', 'ttype': 0, 'output': 'glb'},
 {'tex': None, 'input': 'min', 'tag': 'mo', 'ttype': 7, 'output': 'min'},
 {'tex': None, 'input': 'max', 'tag': 'mo', 'ttype': 7, 'output': 'max'},
 {'tex': 'uparrow', 'input': 'uarr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2191'},
 {'tex': 'downarrow', 'input': 'darr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2193'},
 {'tex': 'rightarrow', 'input': 'rarr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2192'},
 {'tex': 'to', 'input': '->', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2192'},
 {'tex': 'rightarrowtail', 'input': '>->', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21a3'},
 {'tex': 'twoheadrightarrow', 'input': '->>', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21a0'},
 {'tex': 'twoheadrightarrowtail', 'input': '>->>', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2916'},
 {'tex': 'mapsto', 'input': '|->', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21a6'},
 {'tex': 'leftarrow', 'input': 'larr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2190'},
 {'tex': 'leftrightarrow', 'input': 'harr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u2194'},
 {'tex': 'Rightarrow', 'input': 'rArr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21d2'},
 {'tex': 'Leftarrow', 'input': 'lArr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21d0'},
 {'tex': 'Leftrightarrow', 'input': 'hArr', 'tag': 'mo', 'ttype': 0, 'output': u'\\u21d4'},
 {'tex': None, 'input': 'sqrt', 'tag': 'msqrt', 'ttype': 1, 'output': 'sqrt'},
 {'tex': None, 'input': 'root', 'tag': 'mroot', 'ttype': 2, 'output': 'root'},
 {'tex': None, 'input': 'frac', 'tag': 'mfrac', 'ttype': 2, 'output': '/'},
 {'tex': None, 'input': '/', 'tag': 'mfrac', 'ttype': 3, 'output': '/'},
 {'tex': None, 'input': 'stackrel', 'tag': 'mover', 'ttype': 2, 'output': 'stackrel'},
 {'tex': None, 'input': '_', 'tag': 'msub', 'ttype': 3, 'output': '_'},
 {'tex': None, 'input': '^', 'tag': 'msup', 'ttype': 3, 'output': '^'},
 {'acc': True, 'output': '^', 'tex': None, 'tag': 'mover', 'ttype': 1, 'input': 'hat'},
 {'acc': True, 'output': u'\\xaf', 'tex': 'overline', 'tag': 'mover', 'ttype': 1, 'input': 'bar'},
 {'acc': True, 'output': u'\\u2192', 'tex': None, 'tag': 'mover', 'ttype': 1, 'input': 'vec'},
 {'acc': True, 'output': '.', 'tex': None, 'tag': 'mover', 'ttype': 1, 'input': 'dot'},
 {'acc': True, 'output': '..', 'tex': None, 'tag': 'mover', 'ttype': 1, 'input': 'ddot'},
 {'acc': True, 'output': u'\\u0332', 'tex': 'underline', 'tag': 'munder', 'ttype': 1, 'input': 'ul'},
 {'tex': None, 'input': 'text', 'tag': 'mtext', 'ttype': 10, 'output': 'text'},
 {'tex': None, 'input': 'mbox', 'tag': 'mtext', 'ttype': 10, 'output': 'mbox'},
 {'atval': 'bold', 'atname': 'fontweight', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'bb', 'input': 'bb'},
 {'atval': 'bold', 'atname': 'fontweight', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'mathbf', 'input': 'mathbf'},
 {'atval': 'sans-serif', 'atname': 'fontfamily', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'sf', 'input': 'sf'},
 {'atval': 'sans-serif', 'atname': 'fontfamily', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'mathsf', 'input': 'mathsf'},
 {'atval': 'double-struck', 'codes': 'AMbbb', 'atname': 'mathvariant', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'bbb', 'input': 'bbb'},
 {'atval': 'double-struck', 'codes': 'AMbbb', 'atname': 'mathvariant', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'mathbb', 'input': 'mathbb'},
 {'atval': 'script', 'codes': 'AMcal', 'atname': 'mathvariant', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'cc', 'input': 'cc'},
 {'atval': 'script', 'codes': 'AMcal', 'atname': 'mathvariant', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'mathcal', 'input': 'mathcal'},
 {'atval': 'monospace', 'atname': 'fontfamily', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'tt', 'input': 'tt'},
 {'atval': 'monospace', 'atname': 'fontfamily', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'mathtt', 'input': 'mathtt'},
 {'atval': 'fraktur', 'codes': 'AMfrk', 'atname': 'mathvariant', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'fr', 'input': 'fr'},
 {'atval': 'fraktur', 'codes': 'AMfrk', 'atname': 'mathvariant', 'ttype': 1, 'tex': None, 'tag': 'mstyle', 'output': 'mathfrak', 'input': 'mathfrak'}]

AMnames = []

def initSymbols():
    texsymbols = [];
    global AMsymbols,AMnames
    for s in AMsymbols:
        if s['tex'] != None:
            texsymbols.append({'input':s['tex'], 'tag':s['tag'], 'output':s['output'], 'ttype':s['ttype']})
    AMsymbols = AMsymbols + texsymbols
    AMsymbols.sort(key=lambda x:x['input'])
    AMnames = [s['input'] for s in AMsymbols]

def AMremoveCharsAndBlanks(s, n):
    if s[n] == '\\' and s[n+1] != '\\' and s[n+1] != ' ':
        s = s[n+1:-1]
    else:
        s = s[n:-1]
    for i in (0,len(s)):
        if ord(s[i]) <= 32:
            break
    return s[i:-1]


def position(arr, s, n):
    if n == 0:
        n = -1;
        h = len(arr)
        while n + 1 < h:
            m = (n+h) >> 1;
            if attr[m] < s:
                n = m
            else:
                h = m
        return h
    else:


def AMgetSymbol(s):
    more = True
    for i in range(0,len(s)):
        if not more:
            break
        st = s[0:i]

# initSymbols()

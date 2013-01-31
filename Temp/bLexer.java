// $ANTLR 3.4 b.g 2013-01-27 19:14:42

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class bLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int BINARY=4;
    public static final int CONST=5;
    public static final int DEFINITION=6;
    public static final int FLOAT=7;
    public static final int GREEK=8;
    public static final int INFIX=9;
    public static final int INT=10;
    public static final int LATTIN=11;
    public static final int LEFT=12;
    public static final int LEFTRIGHT=13;
    public static final int OPERATOR=14;
    public static final int RIGHT=15;
    public static final int SPACE=16;
    public static final int TEXT=17;
    public static final int UNARY=18;
    public static final int UNDEROVER=19;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public bLexer() {} 
    public bLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public bLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "b.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:2:7: ( '^' )
            // b.g:2:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:3:7: ( '_' )
            // b.g:3:9: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:3:5: ( ( '0' .. '9' )+ )
            // b.g:3:7: ( '0' .. '9' )+
            {
            // b.g:3:7: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // b.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:7:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ | '.' ( '0' .. '9' )+ )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='.') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // b.g:7:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
                    {
                    // b.g:7:9: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // b.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    match('.'); 

                    // b.g:7:25: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // b.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // b.g:8:9: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // b.g:8:13: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // b.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "CONST"
    public final void mCONST() throws RecognitionException {
        try {
            int _type = CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:16:7: ( GREEK | LATTIN )
            int alt6=2;
            switch ( input.LA(1) ) {
            case 'a':
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='l') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case '\u025B':
            case '\u0393':
            case '\u0394':
            case '\u0398':
            case '\u039B':
            case '\u039E':
            case '\u03A0':
            case '\u03A3':
            case '\u03A6':
            case '\u03A8':
            case '\u03A9':
            case '\u03B1':
            case '\u03B2':
            case '\u03B3':
            case '\u03B4':
            case '\u03B5':
            case '\u03B6':
            case '\u03B7':
            case '\u03B8':
            case '\u03B9':
            case '\u03BA':
            case '\u03BB':
            case '\u03BC':
            case '\u03BD':
            case '\u03BE':
            case '\u03C0':
            case '\u03C1':
            case '\u03C3':
            case '\u03C4':
            case '\u03C5':
            case '\u03C6':
            case '\u03C7':
            case '\u03C8':
            case '\u03C9':
            case '\u03D1':
            case '\u03D5':
                {
                alt6=1;
                }
                break;
            case 'b':
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3=='e') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'c':
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4=='h') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'd':
                {
                int LA6_5 = input.LA(2);

                if ( (LA6_5=='e') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'D':
                {
                int LA6_6 = input.LA(2);

                if ( (LA6_6=='e') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'e':
                {
                int LA6_7 = input.LA(2);

                if ( (LA6_7=='p'||LA6_7=='t') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'v':
                {
                int LA6_8 = input.LA(2);

                if ( (LA6_8=='a') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'g':
                {
                int LA6_9 = input.LA(2);

                if ( (LA6_9=='a') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'G':
                {
                int LA6_10 = input.LA(2);

                if ( (LA6_10=='a') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'i':
                {
                int LA6_11 = input.LA(2);

                if ( (LA6_11=='o') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'k':
                {
                int LA6_12 = input.LA(2);

                if ( (LA6_12=='a') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'l':
                {
                int LA6_13 = input.LA(2);

                if ( (LA6_13=='a') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'L':
                {
                int LA6_14 = input.LA(2);

                if ( (LA6_14=='a') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'm':
                {
                int LA6_15 = input.LA(2);

                if ( (LA6_15=='u') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'n':
                {
                int LA6_16 = input.LA(2);

                if ( (LA6_16=='u') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'o':
                {
                int LA6_17 = input.LA(2);

                if ( (LA6_17=='m') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'O':
                {
                int LA6_18 = input.LA(2);

                if ( (LA6_18=='m') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'p':
                {
                int LA6_19 = input.LA(2);

                if ( ((LA6_19 >= 'h' && LA6_19 <= 'i')||LA6_19=='s') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'P':
                {
                int LA6_20 = input.LA(2);

                if ( ((LA6_20 >= 'h' && LA6_20 <= 'i')||LA6_20=='s') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'r':
                {
                int LA6_21 = input.LA(2);

                if ( (LA6_21=='h') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 's':
                {
                int LA6_22 = input.LA(2);

                if ( (LA6_22=='i') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'S':
                {
                int LA6_23 = input.LA(2);

                if ( (LA6_23=='i') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 't':
                {
                int LA6_24 = input.LA(2);

                if ( (LA6_24=='a'||LA6_24=='h') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'T':
                {
                int LA6_25 = input.LA(2);

                if ( (LA6_25=='h') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'u':
                {
                int LA6_26 = input.LA(2);

                if ( (LA6_26=='p') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'x':
                {
                int LA6_27 = input.LA(2);

                if ( (LA6_27=='i') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'X':
                {
                int LA6_28 = input.LA(2);

                if ( (LA6_28=='i') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'z':
                {
                int LA6_29 = input.LA(2);

                if ( (LA6_29=='e') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'E':
            case 'F':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'M':
            case 'N':
            case 'Q':
            case 'R':
            case 'U':
            case 'V':
            case 'W':
            case 'Y':
            case 'Z':
            case 'f':
            case 'h':
            case 'j':
            case 'q':
            case 'w':
            case 'y':
                {
                alt6=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // b.g:16:9: GREEK
                    {
                    mGREEK(); 


                    }
                    break;
                case 2 :
                    // b.g:16:15: LATTIN
                    {
                    mLATTIN(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONST"

    // $ANTLR start "LATTIN"
    public final void mLATTIN() throws RecognitionException {
        try {
            // b.g:20:8: ( 'A' .. 'Z' | 'a' .. 'z' )
            // b.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LATTIN"

    // $ANTLR start "GREEK"
    public final void mGREEK() throws RecognitionException {
        try {
            // b.g:23:8: ( 'alpha' | 'α' | 'beta' | 'β' | 'chi' | 'χ' | 'delta' | 'δ' | 'Delta' | 'Δ' | 'epsilon' | 'epsi' | 'ε' | 'varepsilon' | 'ɛ' | 'eta' | 'η' | 'gamma' | 'γ' | 'Gamma' | 'Γ' | 'iota' | 'ι' | 'kappa' | 'κ' | 'lambda' | 'λ' | 'Lambda' | 'Λ' | 'mu' | 'μ' | 'nu' | 'ν' | 'omega' | 'ω' | 'Omega' | 'Ω' | 'phi' | 'φ' | 'varphi' | 'ϕ' | 'Phi' | 'Φ' | 'pi' | 'π' | 'Pi' | 'Π' | 'psi' | 'ψ' | 'Psi' | 'Ψ' | 'rho' | 'ρ' | 'sigma' | 'σ' | 'Sigma' | 'Σ' | 'tau' | 'τ' | 'theta' | 'θ' | 'vartheta' | 'ϑ' | 'Theta' | 'Θ' | 'upsilon' | 'υ' | 'xi' | 'ξ' | 'Xi' | 'Ξ' | 'zeta' | 'ζ' )
            int alt7=73;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // b.g:23:9: 'alpha'
                    {
                    match("alpha"); 



                    }
                    break;
                case 2 :
                    // b.g:23:18: 'α'
                    {
                    match('\u03B1'); 

                    }
                    break;
                case 3 :
                    // b.g:24:4: 'beta'
                    {
                    match("beta"); 



                    }
                    break;
                case 4 :
                    // b.g:24:12: 'β'
                    {
                    match('\u03B2'); 

                    }
                    break;
                case 5 :
                    // b.g:25:4: 'chi'
                    {
                    match("chi"); 



                    }
                    break;
                case 6 :
                    // b.g:25:11: 'χ'
                    {
                    match('\u03C7'); 

                    }
                    break;
                case 7 :
                    // b.g:26:4: 'delta'
                    {
                    match("delta"); 



                    }
                    break;
                case 8 :
                    // b.g:26:13: 'δ'
                    {
                    match('\u03B4'); 

                    }
                    break;
                case 9 :
                    // b.g:27:4: 'Delta'
                    {
                    match("Delta"); 



                    }
                    break;
                case 10 :
                    // b.g:27:13: 'Δ'
                    {
                    match('\u0394'); 

                    }
                    break;
                case 11 :
                    // b.g:28:3: 'epsilon'
                    {
                    match("epsilon"); 



                    }
                    break;
                case 12 :
                    // b.g:28:14: 'epsi'
                    {
                    match("epsi"); 



                    }
                    break;
                case 13 :
                    // b.g:28:22: 'ε'
                    {
                    match('\u03B5'); 

                    }
                    break;
                case 14 :
                    // b.g:29:4: 'varepsilon'
                    {
                    match("varepsilon"); 



                    }
                    break;
                case 15 :
                    // b.g:29:18: 'ɛ'
                    {
                    match('\u025B'); 

                    }
                    break;
                case 16 :
                    // b.g:30:4: 'eta'
                    {
                    match("eta"); 



                    }
                    break;
                case 17 :
                    // b.g:30:11: 'η'
                    {
                    match('\u03B7'); 

                    }
                    break;
                case 18 :
                    // b.g:31:4: 'gamma'
                    {
                    match("gamma"); 



                    }
                    break;
                case 19 :
                    // b.g:31:13: 'γ'
                    {
                    match('\u03B3'); 

                    }
                    break;
                case 20 :
                    // b.g:32:4: 'Gamma'
                    {
                    match("Gamma"); 



                    }
                    break;
                case 21 :
                    // b.g:32:13: 'Γ'
                    {
                    match('\u0393'); 

                    }
                    break;
                case 22 :
                    // b.g:33:4: 'iota'
                    {
                    match("iota"); 



                    }
                    break;
                case 23 :
                    // b.g:33:12: 'ι'
                    {
                    match('\u03B9'); 

                    }
                    break;
                case 24 :
                    // b.g:34:4: 'kappa'
                    {
                    match("kappa"); 



                    }
                    break;
                case 25 :
                    // b.g:34:13: 'κ'
                    {
                    match('\u03BA'); 

                    }
                    break;
                case 26 :
                    // b.g:35:4: 'lambda'
                    {
                    match("lambda"); 



                    }
                    break;
                case 27 :
                    // b.g:35:14: 'λ'
                    {
                    match('\u03BB'); 

                    }
                    break;
                case 28 :
                    // b.g:36:4: 'Lambda'
                    {
                    match("Lambda"); 



                    }
                    break;
                case 29 :
                    // b.g:36:14: 'Λ'
                    {
                    match('\u039B'); 

                    }
                    break;
                case 30 :
                    // b.g:37:4: 'mu'
                    {
                    match("mu"); 



                    }
                    break;
                case 31 :
                    // b.g:37:10: 'μ'
                    {
                    match('\u03BC'); 

                    }
                    break;
                case 32 :
                    // b.g:38:4: 'nu'
                    {
                    match("nu"); 



                    }
                    break;
                case 33 :
                    // b.g:38:10: 'ν'
                    {
                    match('\u03BD'); 

                    }
                    break;
                case 34 :
                    // b.g:39:4: 'omega'
                    {
                    match("omega"); 



                    }
                    break;
                case 35 :
                    // b.g:39:13: 'ω'
                    {
                    match('\u03C9'); 

                    }
                    break;
                case 36 :
                    // b.g:40:4: 'Omega'
                    {
                    match("Omega"); 



                    }
                    break;
                case 37 :
                    // b.g:40:13: 'Ω'
                    {
                    match('\u03A9'); 

                    }
                    break;
                case 38 :
                    // b.g:41:4: 'phi'
                    {
                    match("phi"); 



                    }
                    break;
                case 39 :
                    // b.g:41:11: 'φ'
                    {
                    match('\u03C6'); 

                    }
                    break;
                case 40 :
                    // b.g:42:4: 'varphi'
                    {
                    match("varphi"); 



                    }
                    break;
                case 41 :
                    // b.g:42:14: 'ϕ'
                    {
                    match('\u03D5'); 

                    }
                    break;
                case 42 :
                    // b.g:43:4: 'Phi'
                    {
                    match("Phi"); 



                    }
                    break;
                case 43 :
                    // b.g:43:11: 'Φ'
                    {
                    match('\u03A6'); 

                    }
                    break;
                case 44 :
                    // b.g:44:4: 'pi'
                    {
                    match("pi"); 



                    }
                    break;
                case 45 :
                    // b.g:44:10: 'π'
                    {
                    match('\u03C0'); 

                    }
                    break;
                case 46 :
                    // b.g:45:4: 'Pi'
                    {
                    match("Pi"); 



                    }
                    break;
                case 47 :
                    // b.g:45:10: 'Π'
                    {
                    match('\u03A0'); 

                    }
                    break;
                case 48 :
                    // b.g:46:4: 'psi'
                    {
                    match("psi"); 



                    }
                    break;
                case 49 :
                    // b.g:46:11: 'ψ'
                    {
                    match('\u03C8'); 

                    }
                    break;
                case 50 :
                    // b.g:47:4: 'Psi'
                    {
                    match("Psi"); 



                    }
                    break;
                case 51 :
                    // b.g:47:11: 'Ψ'
                    {
                    match('\u03A8'); 

                    }
                    break;
                case 52 :
                    // b.g:48:4: 'rho'
                    {
                    match("rho"); 



                    }
                    break;
                case 53 :
                    // b.g:48:11: 'ρ'
                    {
                    match('\u03C1'); 

                    }
                    break;
                case 54 :
                    // b.g:49:4: 'sigma'
                    {
                    match("sigma"); 



                    }
                    break;
                case 55 :
                    // b.g:49:13: 'σ'
                    {
                    match('\u03C3'); 

                    }
                    break;
                case 56 :
                    // b.g:50:4: 'Sigma'
                    {
                    match("Sigma"); 



                    }
                    break;
                case 57 :
                    // b.g:50:13: 'Σ'
                    {
                    match('\u03A3'); 

                    }
                    break;
                case 58 :
                    // b.g:51:4: 'tau'
                    {
                    match("tau"); 



                    }
                    break;
                case 59 :
                    // b.g:51:11: 'τ'
                    {
                    match('\u03C4'); 

                    }
                    break;
                case 60 :
                    // b.g:52:4: 'theta'
                    {
                    match("theta"); 



                    }
                    break;
                case 61 :
                    // b.g:52:13: 'θ'
                    {
                    match('\u03B8'); 

                    }
                    break;
                case 62 :
                    // b.g:53:4: 'vartheta'
                    {
                    match("vartheta"); 



                    }
                    break;
                case 63 :
                    // b.g:53:16: 'ϑ'
                    {
                    match('\u03D1'); 

                    }
                    break;
                case 64 :
                    // b.g:54:4: 'Theta'
                    {
                    match("Theta"); 



                    }
                    break;
                case 65 :
                    // b.g:54:13: 'Θ'
                    {
                    match('\u0398'); 

                    }
                    break;
                case 66 :
                    // b.g:55:4: 'upsilon'
                    {
                    match("upsilon"); 



                    }
                    break;
                case 67 :
                    // b.g:55:15: 'υ'
                    {
                    match('\u03C5'); 

                    }
                    break;
                case 68 :
                    // b.g:56:4: 'xi'
                    {
                    match("xi"); 



                    }
                    break;
                case 69 :
                    // b.g:56:10: 'ξ'
                    {
                    match('\u03BE'); 

                    }
                    break;
                case 70 :
                    // b.g:57:4: 'Xi'
                    {
                    match("Xi"); 



                    }
                    break;
                case 71 :
                    // b.g:57:10: 'Ξ'
                    {
                    match('\u039E'); 

                    }
                    break;
                case 72 :
                    // b.g:58:4: 'zeta'
                    {
                    match("zeta"); 



                    }
                    break;
                case 73 :
                    // b.g:58:12: 'ζ'
                    {
                    match('\u03B6'); 

                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREEK"

    // $ANTLR start "OPERATOR"
    public final void mOPERATOR() throws RecognitionException {
        try {
            int _type = OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:60:10: ( 'cdot' | '*' | '⋅' | 'star' | '**' | '⋆' | '//' | '/' | 'backslash' | '\\\\' | 'setminus' | 'times' | 'xx' | '×' | 'divide' | '-:' | '÷' | 'circ' | '@' | '⚬' | 'oplus' | 'o+' | '⊕' | 'otimes' | 'ox' | '⊗' | 'odot' | 'o.' | '⊙' | 'wedge' | '^^' | '∧' | 'vee' | 'vv' | '∨' | 'cap' | 'nn' | '∩' | 'cup' | 'uu' | '∪' | 'ne' | '!=' | '≠' | ':=' | 'lt' | '<' | 'le' | 'leq' | 'lt=' | '<=' | '≤' | 'ge' | 'geq' | '>=' | '≥' | 'prec' | '-lt' | '-<' | '≺' | 'succ' | '>-' | '≻' | 'preceq' | '-<=' | '⪯' | 'succeq' | '>-=' | '⪰' | 'in' | '∈' | 'notin' | '!in' | '∉' | 'subset' | 'sub' | '⊂' | 'supset' | 'sup' | '⊃' | 'subseteq' | 'sube' | '⊆' | 'supseteq' | 'supe' | '⊇' | 'equiv' | '-=' | '≡' | 'cong' | '~=' | '≅' | 'approx' | '~~' | '≈' | 'propto' | 'prop' | '∝' | 'neg' | 'not' | '¬' | 'forall' | 'AA' | '∀' | 'exists' | 'EE' | '∃' | 'bot' | '_|_' | '⊥' | 'top' | 'TT' | '⊤' | 'vdash' | '|--' | '⊢' | 'models' | '|==' | '⊨' | 'int' | '∫' | 'oint' | '∮' | 'partial' | 'del' | '∂' | 'nabla' | 'grad' | '∇' | 'pm' | '+-' | '±' | 'emptyset' | 'O/' | '∅' | 'infty' | 'oo' | '∞' | 'aleph' | 'ℵ' | 'ldots' | '...' | 'therefore' | ':.' | '∴' | 'angle' | '/_' | '∠' | '\\ ' | ' ' | 'quad' | '  ' | 'qquad' | '    ' | 'cdots' | '⋯' | 'vdots' | '⋮' | 'ddots' | '⋱' | 'diamond' | '⋄' | 'square' | '□' | 'lfloor' | '|__' | '⌊' | 'rfloor' | '__|' | '⌋' | 'lceiling' | '|~' | '⌈' | 'rceiling' | '~|' | '⌉' | 'CC' | 'ℂ' | 'NN' | 'ℕ' | 'QQ' | 'ℚ' | 'RR' | 'ℝ' | 'ZZ' | 'ℤ' | 'dim' | 'mod' | 'lub' | 'glb' | 'uparrow' | 'uarr' | '↑' | 'downarrow' | 'darr' | '↓' | 'rightarrow' | 'rarr' | 'to' | '->' | '→' | '>->' | '↣' | '->>' | '↠' | '>->>' | '⤖' | 'mapsto' | '|->' | '↦' | 'leftarrow' | 'larr' | '←' | 'leftrightarrow' | 'harr' | '↔' | 'Rightarrow' | 'rArr' | 'implies' | '=>' | '⇒' | 'Leftarrow' | 'lArr' | '⇐' | 'Leftrightarrow' | 'hArr' | 'iff' | '<=>' | '⇔' )
            int alt8=229;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // b.g:60:11: 'cdot'
                    {
                    match("cdot"); 



                    }
                    break;
                case 2 :
                    // b.g:60:19: '*'
                    {
                    match('*'); 

                    }
                    break;
                case 3 :
                    // b.g:60:24: '⋅'
                    {
                    match('\u22C5'); 

                    }
                    break;
                case 4 :
                    // b.g:61:3: 'star'
                    {
                    match("star"); 



                    }
                    break;
                case 5 :
                    // b.g:61:11: '**'
                    {
                    match("**"); 



                    }
                    break;
                case 6 :
                    // b.g:61:17: '⋆'
                    {
                    match('\u22C6'); 

                    }
                    break;
                case 7 :
                    // b.g:62:4: '//'
                    {
                    match("//"); 



                    }
                    break;
                case 8 :
                    // b.g:62:10: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 9 :
                    // b.g:63:3: 'backslash'
                    {
                    match("backslash"); 



                    }
                    break;
                case 10 :
                    // b.g:63:16: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 11 :
                    // b.g:64:4: 'setminus'
                    {
                    match("setminus"); 



                    }
                    break;
                case 12 :
                    // b.g:65:3: 'times'
                    {
                    match("times"); 



                    }
                    break;
                case 13 :
                    // b.g:65:12: 'xx'
                    {
                    match("xx"); 



                    }
                    break;
                case 14 :
                    // b.g:65:18: '×'
                    {
                    match('\u00D7'); 

                    }
                    break;
                case 15 :
                    // b.g:66:3: 'divide'
                    {
                    match("divide"); 



                    }
                    break;
                case 16 :
                    // b.g:66:13: '-:'
                    {
                    match("-:"); 



                    }
                    break;
                case 17 :
                    // b.g:66:19: '÷'
                    {
                    match('\u00F7'); 

                    }
                    break;
                case 18 :
                    // b.g:67:3: 'circ'
                    {
                    match("circ"); 



                    }
                    break;
                case 19 :
                    // b.g:67:11: '@'
                    {
                    match('@'); 

                    }
                    break;
                case 20 :
                    // b.g:67:16: '⚬'
                    {
                    match('\u26AC'); 

                    }
                    break;
                case 21 :
                    // b.g:68:3: 'oplus'
                    {
                    match("oplus"); 



                    }
                    break;
                case 22 :
                    // b.g:68:12: 'o+'
                    {
                    match("o+"); 



                    }
                    break;
                case 23 :
                    // b.g:68:18: '⊕'
                    {
                    match('\u2295'); 

                    }
                    break;
                case 24 :
                    // b.g:69:3: 'otimes'
                    {
                    match("otimes"); 



                    }
                    break;
                case 25 :
                    // b.g:69:13: 'ox'
                    {
                    match("ox"); 



                    }
                    break;
                case 26 :
                    // b.g:69:19: '⊗'
                    {
                    match('\u2297'); 

                    }
                    break;
                case 27 :
                    // b.g:70:3: 'odot'
                    {
                    match("odot"); 



                    }
                    break;
                case 28 :
                    // b.g:70:11: 'o.'
                    {
                    match("o."); 



                    }
                    break;
                case 29 :
                    // b.g:70:17: '⊙'
                    {
                    match('\u2299'); 

                    }
                    break;
                case 30 :
                    // b.g:71:3: 'wedge'
                    {
                    match("wedge"); 



                    }
                    break;
                case 31 :
                    // b.g:71:12: '^^'
                    {
                    match("^^"); 



                    }
                    break;
                case 32 :
                    // b.g:71:18: '∧'
                    {
                    match('\u2227'); 

                    }
                    break;
                case 33 :
                    // b.g:72:3: 'vee'
                    {
                    match("vee"); 



                    }
                    break;
                case 34 :
                    // b.g:72:10: 'vv'
                    {
                    match("vv"); 



                    }
                    break;
                case 35 :
                    // b.g:72:16: '∨'
                    {
                    match('\u2228'); 

                    }
                    break;
                case 36 :
                    // b.g:73:3: 'cap'
                    {
                    match("cap"); 



                    }
                    break;
                case 37 :
                    // b.g:73:10: 'nn'
                    {
                    match("nn"); 



                    }
                    break;
                case 38 :
                    // b.g:73:16: '∩'
                    {
                    match('\u2229'); 

                    }
                    break;
                case 39 :
                    // b.g:74:3: 'cup'
                    {
                    match("cup"); 



                    }
                    break;
                case 40 :
                    // b.g:74:10: 'uu'
                    {
                    match("uu"); 



                    }
                    break;
                case 41 :
                    // b.g:74:16: '∪'
                    {
                    match('\u222A'); 

                    }
                    break;
                case 42 :
                    // b.g:75:3: 'ne'
                    {
                    match("ne"); 



                    }
                    break;
                case 43 :
                    // b.g:75:9: '!='
                    {
                    match("!="); 



                    }
                    break;
                case 44 :
                    // b.g:75:15: '≠'
                    {
                    match('\u2260'); 

                    }
                    break;
                case 45 :
                    // b.g:76:4: ':='
                    {
                    match(":="); 



                    }
                    break;
                case 46 :
                    // b.g:77:4: 'lt'
                    {
                    match("lt"); 



                    }
                    break;
                case 47 :
                    // b.g:77:10: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 48 :
                    // b.g:78:3: 'le'
                    {
                    match("le"); 



                    }
                    break;
                case 49 :
                    // b.g:78:9: 'leq'
                    {
                    match("leq"); 



                    }
                    break;
                case 50 :
                    // b.g:78:16: 'lt='
                    {
                    match("lt="); 



                    }
                    break;
                case 51 :
                    // b.g:78:23: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 52 :
                    // b.g:78:29: '≤'
                    {
                    match('\u2264'); 

                    }
                    break;
                case 53 :
                    // b.g:79:3: 'ge'
                    {
                    match("ge"); 



                    }
                    break;
                case 54 :
                    // b.g:79:9: 'geq'
                    {
                    match("geq"); 



                    }
                    break;
                case 55 :
                    // b.g:79:16: '>='
                    {
                    match(">="); 



                    }
                    break;
                case 56 :
                    // b.g:79:22: '≥'
                    {
                    match('\u2265'); 

                    }
                    break;
                case 57 :
                    // b.g:80:3: 'prec'
                    {
                    match("prec"); 



                    }
                    break;
                case 58 :
                    // b.g:80:11: '-lt'
                    {
                    match("-lt"); 



                    }
                    break;
                case 59 :
                    // b.g:80:18: '-<'
                    {
                    match("-<"); 



                    }
                    break;
                case 60 :
                    // b.g:80:24: '≺'
                    {
                    match('\u227A'); 

                    }
                    break;
                case 61 :
                    // b.g:81:3: 'succ'
                    {
                    match("succ"); 



                    }
                    break;
                case 62 :
                    // b.g:81:11: '>-'
                    {
                    match(">-"); 



                    }
                    break;
                case 63 :
                    // b.g:81:17: '≻'
                    {
                    match('\u227B'); 

                    }
                    break;
                case 64 :
                    // b.g:82:3: 'preceq'
                    {
                    match("preceq"); 



                    }
                    break;
                case 65 :
                    // b.g:82:13: '-<='
                    {
                    match("-<="); 



                    }
                    break;
                case 66 :
                    // b.g:82:20: '⪯'
                    {
                    match('\u2AAF'); 

                    }
                    break;
                case 67 :
                    // b.g:83:3: 'succeq'
                    {
                    match("succeq"); 



                    }
                    break;
                case 68 :
                    // b.g:83:13: '>-='
                    {
                    match(">-="); 



                    }
                    break;
                case 69 :
                    // b.g:83:20: '⪰'
                    {
                    match('\u2AB0'); 

                    }
                    break;
                case 70 :
                    // b.g:84:4: 'in'
                    {
                    match("in"); 



                    }
                    break;
                case 71 :
                    // b.g:84:10: '∈'
                    {
                    match('\u2208'); 

                    }
                    break;
                case 72 :
                    // b.g:85:3: 'notin'
                    {
                    match("notin"); 



                    }
                    break;
                case 73 :
                    // b.g:85:12: '!in'
                    {
                    match("!in"); 



                    }
                    break;
                case 74 :
                    // b.g:85:19: '∉'
                    {
                    match('\u2209'); 

                    }
                    break;
                case 75 :
                    // b.g:86:3: 'subset'
                    {
                    match("subset"); 



                    }
                    break;
                case 76 :
                    // b.g:86:13: 'sub'
                    {
                    match("sub"); 



                    }
                    break;
                case 77 :
                    // b.g:86:20: '⊂'
                    {
                    match('\u2282'); 

                    }
                    break;
                case 78 :
                    // b.g:87:3: 'supset'
                    {
                    match("supset"); 



                    }
                    break;
                case 79 :
                    // b.g:87:13: 'sup'
                    {
                    match("sup"); 



                    }
                    break;
                case 80 :
                    // b.g:87:20: '⊃'
                    {
                    match('\u2283'); 

                    }
                    break;
                case 81 :
                    // b.g:88:3: 'subseteq'
                    {
                    match("subseteq"); 



                    }
                    break;
                case 82 :
                    // b.g:88:15: 'sube'
                    {
                    match("sube"); 



                    }
                    break;
                case 83 :
                    // b.g:88:23: '⊆'
                    {
                    match('\u2286'); 

                    }
                    break;
                case 84 :
                    // b.g:89:3: 'supseteq'
                    {
                    match("supseteq"); 



                    }
                    break;
                case 85 :
                    // b.g:89:15: 'supe'
                    {
                    match("supe"); 



                    }
                    break;
                case 86 :
                    // b.g:89:23: '⊇'
                    {
                    match('\u2287'); 

                    }
                    break;
                case 87 :
                    // b.g:90:3: 'equiv'
                    {
                    match("equiv"); 



                    }
                    break;
                case 88 :
                    // b.g:90:12: '-='
                    {
                    match("-="); 



                    }
                    break;
                case 89 :
                    // b.g:90:18: '≡'
                    {
                    match('\u2261'); 

                    }
                    break;
                case 90 :
                    // b.g:91:3: 'cong'
                    {
                    match("cong"); 



                    }
                    break;
                case 91 :
                    // b.g:91:11: '~='
                    {
                    match("~="); 



                    }
                    break;
                case 92 :
                    // b.g:91:17: '≅'
                    {
                    match('\u2245'); 

                    }
                    break;
                case 93 :
                    // b.g:92:3: 'approx'
                    {
                    match("approx"); 



                    }
                    break;
                case 94 :
                    // b.g:92:13: '~~'
                    {
                    match("~~"); 



                    }
                    break;
                case 95 :
                    // b.g:92:19: '≈'
                    {
                    match('\u2248'); 

                    }
                    break;
                case 96 :
                    // b.g:93:3: 'propto'
                    {
                    match("propto"); 



                    }
                    break;
                case 97 :
                    // b.g:93:13: 'prop'
                    {
                    match("prop"); 



                    }
                    break;
                case 98 :
                    // b.g:93:21: '∝'
                    {
                    match('\u221D'); 

                    }
                    break;
                case 99 :
                    // b.g:94:3: 'neg'
                    {
                    match("neg"); 



                    }
                    break;
                case 100 :
                    // b.g:94:10: 'not'
                    {
                    match("not"); 



                    }
                    break;
                case 101 :
                    // b.g:94:17: '¬'
                    {
                    match('\u00AC'); 

                    }
                    break;
                case 102 :
                    // b.g:95:3: 'forall'
                    {
                    match("forall"); 



                    }
                    break;
                case 103 :
                    // b.g:95:13: 'AA'
                    {
                    match("AA"); 



                    }
                    break;
                case 104 :
                    // b.g:95:19: '∀'
                    {
                    match('\u2200'); 

                    }
                    break;
                case 105 :
                    // b.g:96:3: 'exists'
                    {
                    match("exists"); 



                    }
                    break;
                case 106 :
                    // b.g:96:13: 'EE'
                    {
                    match("EE"); 



                    }
                    break;
                case 107 :
                    // b.g:96:19: '∃'
                    {
                    match('\u2203'); 

                    }
                    break;
                case 108 :
                    // b.g:97:3: 'bot'
                    {
                    match("bot"); 



                    }
                    break;
                case 109 :
                    // b.g:97:10: '_|_'
                    {
                    match("_|_"); 



                    }
                    break;
                case 110 :
                    // b.g:97:17: '⊥'
                    {
                    match('\u22A5'); 

                    }
                    break;
                case 111 :
                    // b.g:98:3: 'top'
                    {
                    match("top"); 



                    }
                    break;
                case 112 :
                    // b.g:98:10: 'TT'
                    {
                    match("TT"); 



                    }
                    break;
                case 113 :
                    // b.g:98:16: '⊤'
                    {
                    match('\u22A4'); 

                    }
                    break;
                case 114 :
                    // b.g:99:3: 'vdash'
                    {
                    match("vdash"); 



                    }
                    break;
                case 115 :
                    // b.g:99:12: '|--'
                    {
                    match("|--"); 



                    }
                    break;
                case 116 :
                    // b.g:99:19: '⊢'
                    {
                    match('\u22A2'); 

                    }
                    break;
                case 117 :
                    // b.g:100:3: 'models'
                    {
                    match("models"); 



                    }
                    break;
                case 118 :
                    // b.g:100:13: '|=='
                    {
                    match("|=="); 



                    }
                    break;
                case 119 :
                    // b.g:100:20: '⊨'
                    {
                    match('\u22A8'); 

                    }
                    break;
                case 120 :
                    // b.g:101:4: 'int'
                    {
                    match("int"); 



                    }
                    break;
                case 121 :
                    // b.g:101:11: '∫'
                    {
                    match('\u222B'); 

                    }
                    break;
                case 122 :
                    // b.g:102:4: 'oint'
                    {
                    match("oint"); 



                    }
                    break;
                case 123 :
                    // b.g:102:12: '∮'
                    {
                    match('\u222E'); 

                    }
                    break;
                case 124 :
                    // b.g:103:3: 'partial'
                    {
                    match("partial"); 



                    }
                    break;
                case 125 :
                    // b.g:103:14: 'del'
                    {
                    match("del"); 



                    }
                    break;
                case 126 :
                    // b.g:103:21: '∂'
                    {
                    match('\u2202'); 

                    }
                    break;
                case 127 :
                    // b.g:104:3: 'nabla'
                    {
                    match("nabla"); 



                    }
                    break;
                case 128 :
                    // b.g:104:12: 'grad'
                    {
                    match("grad"); 



                    }
                    break;
                case 129 :
                    // b.g:104:20: '∇'
                    {
                    match('\u2207'); 

                    }
                    break;
                case 130 :
                    // b.g:105:3: 'pm'
                    {
                    match("pm"); 



                    }
                    break;
                case 131 :
                    // b.g:105:9: '+-'
                    {
                    match("+-"); 



                    }
                    break;
                case 132 :
                    // b.g:105:15: '±'
                    {
                    match('\u00B1'); 

                    }
                    break;
                case 133 :
                    // b.g:106:3: 'emptyset'
                    {
                    match("emptyset"); 



                    }
                    break;
                case 134 :
                    // b.g:106:15: 'O/'
                    {
                    match("O/"); 



                    }
                    break;
                case 135 :
                    // b.g:106:21: '∅'
                    {
                    match('\u2205'); 

                    }
                    break;
                case 136 :
                    // b.g:107:3: 'infty'
                    {
                    match("infty"); 



                    }
                    break;
                case 137 :
                    // b.g:107:12: 'oo'
                    {
                    match("oo"); 



                    }
                    break;
                case 138 :
                    // b.g:107:18: '∞'
                    {
                    match('\u221E'); 

                    }
                    break;
                case 139 :
                    // b.g:108:4: 'aleph'
                    {
                    match("aleph"); 



                    }
                    break;
                case 140 :
                    // b.g:108:13: 'ℵ'
                    {
                    match('\u2135'); 

                    }
                    break;
                case 141 :
                    // b.g:109:3: 'ldots'
                    {
                    match("ldots"); 



                    }
                    break;
                case 142 :
                    // b.g:109:12: '...'
                    {
                    match("..."); 



                    }
                    break;
                case 143 :
                    // b.g:110:3: 'therefore'
                    {
                    match("therefore"); 



                    }
                    break;
                case 144 :
                    // b.g:110:16: ':.'
                    {
                    match(":."); 



                    }
                    break;
                case 145 :
                    // b.g:110:22: '∴'
                    {
                    match('\u2234'); 

                    }
                    break;
                case 146 :
                    // b.g:111:3: 'angle'
                    {
                    match("angle"); 



                    }
                    break;
                case 147 :
                    // b.g:111:12: '/_'
                    {
                    match("/_"); 



                    }
                    break;
                case 148 :
                    // b.g:111:18: '∠'
                    {
                    match('\u2220'); 

                    }
                    break;
                case 149 :
                    // b.g:112:4: '\\ '
                    {
                    match(' '); 

                    }
                    break;
                case 150 :
                    // b.g:112:10: ' '
                    {
                    match('\u00A0'); 

                    }
                    break;
                case 151 :
                    // b.g:113:4: 'quad'
                    {
                    match("quad"); 



                    }
                    break;
                case 152 :
                    // b.g:113:12: '  '
                    {
                    match("  "); 



                    }
                    break;
                case 153 :
                    // b.g:114:4: 'qquad'
                    {
                    match("qquad"); 



                    }
                    break;
                case 154 :
                    // b.g:114:13: '    '
                    {
                    match("    "); 



                    }
                    break;
                case 155 :
                    // b.g:115:4: 'cdots'
                    {
                    match("cdots"); 



                    }
                    break;
                case 156 :
                    // b.g:115:13: '⋯'
                    {
                    match('\u22EF'); 

                    }
                    break;
                case 157 :
                    // b.g:116:4: 'vdots'
                    {
                    match("vdots"); 



                    }
                    break;
                case 158 :
                    // b.g:116:13: '⋮'
                    {
                    match('\u22EE'); 

                    }
                    break;
                case 159 :
                    // b.g:117:4: 'ddots'
                    {
                    match("ddots"); 



                    }
                    break;
                case 160 :
                    // b.g:117:13: '⋱'
                    {
                    match('\u22F1'); 

                    }
                    break;
                case 161 :
                    // b.g:118:4: 'diamond'
                    {
                    match("diamond"); 



                    }
                    break;
                case 162 :
                    // b.g:118:15: '⋄'
                    {
                    match('\u22C4'); 

                    }
                    break;
                case 163 :
                    // b.g:119:4: 'square'
                    {
                    match("square"); 



                    }
                    break;
                case 164 :
                    // b.g:119:14: '□'
                    {
                    match('\u25A1'); 

                    }
                    break;
                case 165 :
                    // b.g:120:3: 'lfloor'
                    {
                    match("lfloor"); 



                    }
                    break;
                case 166 :
                    // b.g:120:13: '|__'
                    {
                    match("|__"); 



                    }
                    break;
                case 167 :
                    // b.g:120:20: '⌊'
                    {
                    match('\u230A'); 

                    }
                    break;
                case 168 :
                    // b.g:121:3: 'rfloor'
                    {
                    match("rfloor"); 



                    }
                    break;
                case 169 :
                    // b.g:121:13: '__|'
                    {
                    match("__|"); 



                    }
                    break;
                case 170 :
                    // b.g:121:20: '⌋'
                    {
                    match('\u230B'); 

                    }
                    break;
                case 171 :
                    // b.g:122:3: 'lceiling'
                    {
                    match("lceiling"); 



                    }
                    break;
                case 172 :
                    // b.g:122:15: '|~'
                    {
                    match("|~"); 



                    }
                    break;
                case 173 :
                    // b.g:122:21: '⌈'
                    {
                    match('\u2308'); 

                    }
                    break;
                case 174 :
                    // b.g:123:3: 'rceiling'
                    {
                    match("rceiling"); 



                    }
                    break;
                case 175 :
                    // b.g:123:15: '~|'
                    {
                    match("~|"); 



                    }
                    break;
                case 176 :
                    // b.g:123:21: '⌉'
                    {
                    match('\u2309'); 

                    }
                    break;
                case 177 :
                    // b.g:124:4: 'CC'
                    {
                    match("CC"); 



                    }
                    break;
                case 178 :
                    // b.g:124:10: 'ℂ'
                    {
                    match('\u2102'); 

                    }
                    break;
                case 179 :
                    // b.g:125:4: 'NN'
                    {
                    match("NN"); 



                    }
                    break;
                case 180 :
                    // b.g:125:10: 'ℕ'
                    {
                    match('\u2115'); 

                    }
                    break;
                case 181 :
                    // b.g:126:4: 'QQ'
                    {
                    match("QQ"); 



                    }
                    break;
                case 182 :
                    // b.g:126:10: 'ℚ'
                    {
                    match('\u211A'); 

                    }
                    break;
                case 183 :
                    // b.g:127:4: 'RR'
                    {
                    match("RR"); 



                    }
                    break;
                case 184 :
                    // b.g:127:10: 'ℝ'
                    {
                    match('\u211D'); 

                    }
                    break;
                case 185 :
                    // b.g:128:4: 'ZZ'
                    {
                    match("ZZ"); 



                    }
                    break;
                case 186 :
                    // b.g:128:10: 'ℤ'
                    {
                    match('\u2124'); 

                    }
                    break;
                case 187 :
                    // b.g:129:4: 'dim'
                    {
                    match("dim"); 



                    }
                    break;
                case 188 :
                    // b.g:130:4: 'mod'
                    {
                    match("mod"); 



                    }
                    break;
                case 189 :
                    // b.g:131:4: 'lub'
                    {
                    match("lub"); 



                    }
                    break;
                case 190 :
                    // b.g:132:4: 'glb'
                    {
                    match("glb"); 



                    }
                    break;
                case 191 :
                    // b.g:133:14: 'uparrow'
                    {
                    match("uparrow"); 



                    }
                    break;
                case 192 :
                    // b.g:133:26: 'uarr'
                    {
                    match("uarr"); 



                    }
                    break;
                case 193 :
                    // b.g:133:34: '↑'
                    {
                    match('\u2191'); 

                    }
                    break;
                case 194 :
                    // b.g:134:3: 'downarrow'
                    {
                    match("downarrow"); 



                    }
                    break;
                case 195 :
                    // b.g:134:16: 'darr'
                    {
                    match("darr"); 



                    }
                    break;
                case 196 :
                    // b.g:134:24: '↓'
                    {
                    match('\u2193'); 

                    }
                    break;
                case 197 :
                    // b.g:135:3: 'rightarrow'
                    {
                    match("rightarrow"); 



                    }
                    break;
                case 198 :
                    // b.g:135:17: 'rarr'
                    {
                    match("rarr"); 



                    }
                    break;
                case 199 :
                    // b.g:135:25: 'to'
                    {
                    match("to"); 



                    }
                    break;
                case 200 :
                    // b.g:135:31: '->'
                    {
                    match("->"); 



                    }
                    break;
                case 201 :
                    // b.g:135:37: '→'
                    {
                    match('\u2192'); 

                    }
                    break;
                case 202 :
                    // b.g:136:25: '>->'
                    {
                    match(">->"); 



                    }
                    break;
                case 203 :
                    // b.g:136:32: '↣'
                    {
                    match('\u21A3'); 

                    }
                    break;
                case 204 :
                    // b.g:137:28: '->>'
                    {
                    match("->>"); 



                    }
                    break;
                case 205 :
                    // b.g:137:35: '↠'
                    {
                    match('\u21A0'); 

                    }
                    break;
                case 206 :
                    // b.g:138:32: '>->>'
                    {
                    match(">->>"); 



                    }
                    break;
                case 207 :
                    // b.g:138:40: '⤖'
                    {
                    match('\u2916'); 

                    }
                    break;
                case 208 :
                    // b.g:139:3: 'mapsto'
                    {
                    match("mapsto"); 



                    }
                    break;
                case 209 :
                    // b.g:139:13: '|->'
                    {
                    match("|->"); 



                    }
                    break;
                case 210 :
                    // b.g:139:20: '↦'
                    {
                    match('\u21A6'); 

                    }
                    break;
                case 211 :
                    // b.g:140:3: 'leftarrow'
                    {
                    match("leftarrow"); 



                    }
                    break;
                case 212 :
                    // b.g:140:16: 'larr'
                    {
                    match("larr"); 



                    }
                    break;
                case 213 :
                    // b.g:140:24: '←'
                    {
                    match('\u2190'); 

                    }
                    break;
                case 214 :
                    // b.g:141:3: 'leftrightarrow'
                    {
                    match("leftrightarrow"); 



                    }
                    break;
                case 215 :
                    // b.g:141:21: 'harr'
                    {
                    match("harr"); 



                    }
                    break;
                case 216 :
                    // b.g:141:29: '↔'
                    {
                    match('\u2194'); 

                    }
                    break;
                case 217 :
                    // b.g:142:3: 'Rightarrow'
                    {
                    match("Rightarrow"); 



                    }
                    break;
                case 218 :
                    // b.g:142:17: 'rArr'
                    {
                    match("rArr"); 



                    }
                    break;
                case 219 :
                    // b.g:142:25: 'implies'
                    {
                    match("implies"); 



                    }
                    break;
                case 220 :
                    // b.g:142:36: '=>'
                    {
                    match("=>"); 



                    }
                    break;
                case 221 :
                    // b.g:142:42: '⇒'
                    {
                    match('\u21D2'); 

                    }
                    break;
                case 222 :
                    // b.g:143:3: 'Leftarrow'
                    {
                    match("Leftarrow"); 



                    }
                    break;
                case 223 :
                    // b.g:143:16: 'lArr'
                    {
                    match("lArr"); 



                    }
                    break;
                case 224 :
                    // b.g:143:24: '⇐'
                    {
                    match('\u21D0'); 

                    }
                    break;
                case 225 :
                    // b.g:144:3: 'Leftrightarrow'
                    {
                    match("Leftrightarrow"); 



                    }
                    break;
                case 226 :
                    // b.g:144:21: 'hArr'
                    {
                    match("hArr"); 



                    }
                    break;
                case 227 :
                    // b.g:144:29: 'iff'
                    {
                    match("iff"); 



                    }
                    break;
                case 228 :
                    // b.g:144:36: '<=>'
                    {
                    match("<=>"); 



                    }
                    break;
                case 229 :
                    // b.g:144:43: '⇔'
                    {
                    match('\u21D4'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPERATOR"

    // $ANTLR start "UNARY"
    public final void mUNARY() throws RecognitionException {
        try {
            int _type = UNARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:147:8: ( 'f' | 'g' | 'sin' | 'cos' | 'tan' | 'sinh' | 'cosh' | 'tanh' | 'cot' | 'sec' | 'csc' | 'log' | 'ln' | 'det' | 'gcd' | 'lcm' | 'sqrt' | 'hat' | 'overline' | 'bar' | 'vec' | 'dot' | 'ddot' | 'underline' | 'ul' | 'bb' | 'mathbf' | 'sf' | 'mathsf' | 'bbb' | 'mathbb' | 'cc' | 'mathcal' | 'tt' | 'mathtt' | 'fr' | 'mathfrak' )
            int alt9=37;
            switch ( input.LA(1) ) {
            case 'f':
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='r') ) {
                    alt9=36;
                }
                else {
                    alt9=1;
                }
                }
                break;
            case 'g':
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2=='c') ) {
                    alt9=15;
                }
                else {
                    alt9=2;
                }
                }
                break;
            case 's':
                {
                switch ( input.LA(2) ) {
                case 'i':
                    {
                    int LA9_18 = input.LA(3);

                    if ( (LA9_18=='n') ) {
                        int LA9_38 = input.LA(4);

                        if ( (LA9_38=='h') ) {
                            alt9=6;
                        }
                        else {
                            alt9=3;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 18, input);

                        throw nvae;

                    }
                    }
                    break;
                case 'e':
                    {
                    alt9=10;
                    }
                    break;
                case 'q':
                    {
                    alt9=17;
                    }
                    break;
                case 'f':
                    {
                    alt9=28;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 3, input);

                    throw nvae;

                }

                }
                break;
            case 'c':
                {
                switch ( input.LA(2) ) {
                case 'o':
                    {
                    int LA9_22 = input.LA(3);

                    if ( (LA9_22=='s') ) {
                        int LA9_39 = input.LA(4);

                        if ( (LA9_39=='h') ) {
                            alt9=7;
                        }
                        else {
                            alt9=4;
                        }
                    }
                    else if ( (LA9_22=='t') ) {
                        alt9=9;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 22, input);

                        throw nvae;

                    }
                    }
                    break;
                case 's':
                    {
                    alt9=11;
                    }
                    break;
                case 'c':
                    {
                    alt9=32;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 4, input);

                    throw nvae;

                }

                }
                break;
            case 't':
                {
                int LA9_5 = input.LA(2);

                if ( (LA9_5=='a') ) {
                    int LA9_25 = input.LA(3);

                    if ( (LA9_25=='n') ) {
                        int LA9_41 = input.LA(4);

                        if ( (LA9_41=='h') ) {
                            alt9=8;
                        }
                        else {
                            alt9=5;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 25, input);

                        throw nvae;

                    }
                }
                else if ( (LA9_5=='t') ) {
                    alt9=34;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 5, input);

                    throw nvae;

                }
                }
                break;
            case 'l':
                {
                switch ( input.LA(2) ) {
                case 'o':
                    {
                    alt9=12;
                    }
                    break;
                case 'n':
                    {
                    alt9=13;
                    }
                    break;
                case 'c':
                    {
                    alt9=16;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 6, input);

                    throw nvae;

                }

                }
                break;
            case 'd':
                {
                switch ( input.LA(2) ) {
                case 'e':
                    {
                    alt9=14;
                    }
                    break;
                case 'o':
                    {
                    alt9=22;
                    }
                    break;
                case 'd':
                    {
                    alt9=23;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 7, input);

                    throw nvae;

                }

                }
                break;
            case 'h':
                {
                alt9=18;
                }
                break;
            case 'o':
                {
                alt9=19;
                }
                break;
            case 'b':
                {
                int LA9_10 = input.LA(2);

                if ( (LA9_10=='a') ) {
                    alt9=20;
                }
                else if ( (LA9_10=='b') ) {
                    int LA9_34 = input.LA(3);

                    if ( (LA9_34=='b') ) {
                        alt9=30;
                    }
                    else {
                        alt9=26;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 10, input);

                    throw nvae;

                }
                }
                break;
            case 'v':
                {
                alt9=21;
                }
                break;
            case 'u':
                {
                int LA9_12 = input.LA(2);

                if ( (LA9_12=='n') ) {
                    alt9=24;
                }
                else if ( (LA9_12=='l') ) {
                    alt9=25;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 12, input);

                    throw nvae;

                }
                }
                break;
            case 'm':
                {
                int LA9_13 = input.LA(2);

                if ( (LA9_13=='a') ) {
                    int LA9_37 = input.LA(3);

                    if ( (LA9_37=='t') ) {
                        int LA9_44 = input.LA(4);

                        if ( (LA9_44=='h') ) {
                            switch ( input.LA(5) ) {
                            case 'b':
                                {
                                int LA9_52 = input.LA(6);

                                if ( (LA9_52=='f') ) {
                                    alt9=27;
                                }
                                else if ( (LA9_52=='b') ) {
                                    alt9=31;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 9, 52, input);

                                    throw nvae;

                                }
                                }
                                break;
                            case 's':
                                {
                                alt9=29;
                                }
                                break;
                            case 'c':
                                {
                                alt9=33;
                                }
                                break;
                            case 't':
                                {
                                alt9=35;
                                }
                                break;
                            case 'f':
                                {
                                alt9=37;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 51, input);

                                throw nvae;

                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 44, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 37, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 13, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // b.g:147:9: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 2 :
                    // b.g:148:4: 'g'
                    {
                    match('g'); 

                    }
                    break;
                case 3 :
                    // b.g:149:4: 'sin'
                    {
                    match("sin"); 



                    }
                    break;
                case 4 :
                    // b.g:150:4: 'cos'
                    {
                    match("cos"); 



                    }
                    break;
                case 5 :
                    // b.g:151:4: 'tan'
                    {
                    match("tan"); 



                    }
                    break;
                case 6 :
                    // b.g:152:4: 'sinh'
                    {
                    match("sinh"); 



                    }
                    break;
                case 7 :
                    // b.g:153:4: 'cosh'
                    {
                    match("cosh"); 



                    }
                    break;
                case 8 :
                    // b.g:154:4: 'tanh'
                    {
                    match("tanh"); 



                    }
                    break;
                case 9 :
                    // b.g:155:4: 'cot'
                    {
                    match("cot"); 



                    }
                    break;
                case 10 :
                    // b.g:156:4: 'sec'
                    {
                    match("sec"); 



                    }
                    break;
                case 11 :
                    // b.g:157:4: 'csc'
                    {
                    match("csc"); 



                    }
                    break;
                case 12 :
                    // b.g:158:4: 'log'
                    {
                    match("log"); 



                    }
                    break;
                case 13 :
                    // b.g:159:4: 'ln'
                    {
                    match("ln"); 



                    }
                    break;
                case 14 :
                    // b.g:160:4: 'det'
                    {
                    match("det"); 



                    }
                    break;
                case 15 :
                    // b.g:161:4: 'gcd'
                    {
                    match("gcd"); 



                    }
                    break;
                case 16 :
                    // b.g:162:4: 'lcm'
                    {
                    match("lcm"); 



                    }
                    break;
                case 17 :
                    // b.g:163:4: 'sqrt'
                    {
                    match("sqrt"); 



                    }
                    break;
                case 18 :
                    // b.g:164:4: 'hat'
                    {
                    match("hat"); 



                    }
                    break;
                case 19 :
                    // b.g:165:3: 'overline'
                    {
                    match("overline"); 



                    }
                    break;
                case 20 :
                    // b.g:165:15: 'bar'
                    {
                    match("bar"); 



                    }
                    break;
                case 21 :
                    // b.g:166:4: 'vec'
                    {
                    match("vec"); 



                    }
                    break;
                case 22 :
                    // b.g:167:4: 'dot'
                    {
                    match("dot"); 



                    }
                    break;
                case 23 :
                    // b.g:168:4: 'ddot'
                    {
                    match("ddot"); 



                    }
                    break;
                case 24 :
                    // b.g:169:3: 'underline'
                    {
                    match("underline"); 



                    }
                    break;
                case 25 :
                    // b.g:169:16: 'ul'
                    {
                    match("ul"); 



                    }
                    break;
                case 26 :
                    // b.g:170:4: 'bb'
                    {
                    match("bb"); 



                    }
                    break;
                case 27 :
                    // b.g:171:4: 'mathbf'
                    {
                    match("mathbf"); 



                    }
                    break;
                case 28 :
                    // b.g:172:4: 'sf'
                    {
                    match("sf"); 



                    }
                    break;
                case 29 :
                    // b.g:173:4: 'mathsf'
                    {
                    match("mathsf"); 



                    }
                    break;
                case 30 :
                    // b.g:174:4: 'bbb'
                    {
                    match("bbb"); 



                    }
                    break;
                case 31 :
                    // b.g:175:4: 'mathbb'
                    {
                    match("mathbb"); 



                    }
                    break;
                case 32 :
                    // b.g:176:4: 'cc'
                    {
                    match("cc"); 



                    }
                    break;
                case 33 :
                    // b.g:177:4: 'mathcal'
                    {
                    match("mathcal"); 



                    }
                    break;
                case 34 :
                    // b.g:178:4: 'tt'
                    {
                    match("tt"); 



                    }
                    break;
                case 35 :
                    // b.g:179:4: 'mathtt'
                    {
                    match("mathtt"); 



                    }
                    break;
                case 36 :
                    // b.g:180:4: 'fr'
                    {
                    match("fr"); 



                    }
                    break;
                case 37 :
                    // b.g:181:4: 'mathfrak'
                    {
                    match("mathfrak"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNARY"

    // $ANTLR start "BINARY"
    public final void mBINARY() throws RecognitionException {
        try {
            int _type = BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:185:2: ( 'root' | 'frac' | 'stackrel' )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 'r':
                {
                alt10=1;
                }
                break;
            case 'f':
                {
                alt10=2;
                }
                break;
            case 's':
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // b.g:185:5: 'root'
                    {
                    match("root"); 



                    }
                    break;
                case 2 :
                    // b.g:186:4: 'frac'
                    {
                    match("frac"); 



                    }
                    break;
                case 3 :
                    // b.g:187:4: 'stackrel'
                    {
                    match("stackrel"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BINARY"

    // $ANTLR start "INFIX"
    public final void mINFIX() throws RecognitionException {
        try {
            int _type = INFIX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:190:6: (| '/' | '_' | '^' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case '/':
                {
                alt11=2;
                }
                break;
            case '_':
                {
                alt11=3;
                }
                break;
            case '^':
                {
                alt11=4;
                }
                break;
            default:
                alt11=1;
            }

            switch (alt11) {
                case 1 :
                    // b.g:191:3: 
                    {
                    }
                    break;
                case 2 :
                    // b.g:191:4: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 3 :
                    // b.g:192:4: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // b.g:193:4: '^'
                    {
                    match('^'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INFIX"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:197:2: ( '(' | '[' | '{' | 'langle' | '(:' | '<<' | '〈' | '{:' )
            int alt12=8;
            switch ( input.LA(1) ) {
            case '(':
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==':') ) {
                    alt12=5;
                }
                else {
                    alt12=1;
                }
                }
                break;
            case '[':
                {
                alt12=2;
                }
                break;
            case '{':
                {
                int LA12_3 = input.LA(2);

                if ( (LA12_3==':') ) {
                    alt12=8;
                }
                else {
                    alt12=3;
                }
                }
                break;
            case 'l':
                {
                alt12=4;
                }
                break;
            case '<':
                {
                alt12=6;
                }
                break;
            case '\u2329':
                {
                alt12=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // b.g:197:5: '('
                    {
                    match('('); 

                    }
                    break;
                case 2 :
                    // b.g:198:4: '['
                    {
                    match('['); 

                    }
                    break;
                case 3 :
                    // b.g:199:4: '{'
                    {
                    match('{'); 

                    }
                    break;
                case 4 :
                    // b.g:200:3: 'langle'
                    {
                    match("langle"); 



                    }
                    break;
                case 5 :
                    // b.g:200:13: '(:'
                    {
                    match("(:"); 



                    }
                    break;
                case 6 :
                    // b.g:200:19: '<<'
                    {
                    match("<<"); 



                    }
                    break;
                case 7 :
                    // b.g:200:25: '〈'
                    {
                    match('\u2329'); 

                    }
                    break;
                case 8 :
                    // b.g:201:4: '{:'
                    {
                    match("{:"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:204:2: ( ')' | ']' | '}' | 'rangle' | ':)' | '>>' | '〉' | ':}' )
            int alt13=8;
            switch ( input.LA(1) ) {
            case ')':
                {
                alt13=1;
                }
                break;
            case ']':
                {
                alt13=2;
                }
                break;
            case '}':
                {
                alt13=3;
                }
                break;
            case 'r':
                {
                alt13=4;
                }
                break;
            case ':':
                {
                int LA13_5 = input.LA(2);

                if ( (LA13_5==')') ) {
                    alt13=5;
                }
                else if ( (LA13_5=='}') ) {
                    alt13=8;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 5, input);

                    throw nvae;

                }
                }
                break;
            case '>':
                {
                alt13=6;
                }
                break;
            case '\u232A':
                {
                alt13=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // b.g:204:6: ')'
                    {
                    match(')'); 

                    }
                    break;
                case 2 :
                    // b.g:205:4: ']'
                    {
                    match(']'); 

                    }
                    break;
                case 3 :
                    // b.g:206:4: '}'
                    {
                    match('}'); 

                    }
                    break;
                case 4 :
                    // b.g:207:3: 'rangle'
                    {
                    match("rangle"); 



                    }
                    break;
                case 5 :
                    // b.g:207:13: ':)'
                    {
                    match(":)"); 



                    }
                    break;
                case 6 :
                    // b.g:207:19: '>>'
                    {
                    match(">>"); 



                    }
                    break;
                case 7 :
                    // b.g:207:25: '〉'
                    {
                    match('\u232A'); 

                    }
                    break;
                case 8 :
                    // b.g:208:4: ':}'
                    {
                    match(":}"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:212:2: ( 'and' | 'or' | 'if' )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt14=1;
                }
                break;
            case 'o':
                {
                alt14=2;
                }
                break;
            case 'i':
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // b.g:212:5: 'and'
                    {
                    match("and"); 



                    }
                    break;
                case 2 :
                    // b.g:213:4: 'or'
                    {
                    match("or"); 



                    }
                    break;
                case 3 :
                    // b.g:214:4: 'if'
                    {
                    match("if"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPACE"

    // $ANTLR start "UNDEROVER"
    public final void mUNDEROVER() throws RecognitionException {
        try {
            int _type = UNDEROVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:217:11: ( 'sum' | '∑' | 'prod' | '∏' | 'bigwedge' | '^^^' | '⋀' | 'bigvee' | 'vvv' | '⋁' | 'bigcap' | 'nnn' | '⋂' | 'bigcup' | 'uuu' | '⋃' | 'lim' | 'Lim' | 'min' | 'max' )
            int alt15=20;
            switch ( input.LA(1) ) {
            case 's':
                {
                alt15=1;
                }
                break;
            case '\u2211':
                {
                alt15=2;
                }
                break;
            case 'p':
                {
                alt15=3;
                }
                break;
            case '\u220F':
                {
                alt15=4;
                }
                break;
            case 'b':
                {
                int LA15_5 = input.LA(2);

                if ( (LA15_5=='i') ) {
                    int LA15_17 = input.LA(3);

                    if ( (LA15_17=='g') ) {
                        switch ( input.LA(4) ) {
                        case 'w':
                            {
                            alt15=5;
                            }
                            break;
                        case 'v':
                            {
                            alt15=8;
                            }
                            break;
                        case 'c':
                            {
                            int LA15_23 = input.LA(5);

                            if ( (LA15_23=='a') ) {
                                alt15=11;
                            }
                            else if ( (LA15_23=='u') ) {
                                alt15=14;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 15, 23, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 20, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 17, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 5, input);

                    throw nvae;

                }
                }
                break;
            case '^':
                {
                alt15=6;
                }
                break;
            case '\u22C0':
                {
                alt15=7;
                }
                break;
            case 'v':
                {
                alt15=9;
                }
                break;
            case '\u22C1':
                {
                alt15=10;
                }
                break;
            case 'n':
                {
                alt15=12;
                }
                break;
            case '\u22C2':
                {
                alt15=13;
                }
                break;
            case 'u':
                {
                alt15=15;
                }
                break;
            case '\u22C3':
                {
                alt15=16;
                }
                break;
            case 'l':
                {
                alt15=17;
                }
                break;
            case 'L':
                {
                alt15=18;
                }
                break;
            case 'm':
                {
                int LA15_16 = input.LA(2);

                if ( (LA15_16=='i') ) {
                    alt15=19;
                }
                else if ( (LA15_16=='a') ) {
                    alt15=20;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 16, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // b.g:218:4: 'sum'
                    {
                    match("sum"); 



                    }
                    break;
                case 2 :
                    // b.g:218:11: '∑'
                    {
                    match('\u2211'); 

                    }
                    break;
                case 3 :
                    // b.g:219:4: 'prod'
                    {
                    match("prod"); 



                    }
                    break;
                case 4 :
                    // b.g:219:12: '∏'
                    {
                    match('\u220F'); 

                    }
                    break;
                case 5 :
                    // b.g:220:3: 'bigwedge'
                    {
                    match("bigwedge"); 



                    }
                    break;
                case 6 :
                    // b.g:220:15: '^^^'
                    {
                    match("^^^"); 



                    }
                    break;
                case 7 :
                    // b.g:220:22: '⋀'
                    {
                    match('\u22C0'); 

                    }
                    break;
                case 8 :
                    // b.g:221:3: 'bigvee'
                    {
                    match("bigvee"); 



                    }
                    break;
                case 9 :
                    // b.g:221:13: 'vvv'
                    {
                    match("vvv"); 



                    }
                    break;
                case 10 :
                    // b.g:221:20: '⋁'
                    {
                    match('\u22C1'); 

                    }
                    break;
                case 11 :
                    // b.g:222:3: 'bigcap'
                    {
                    match("bigcap"); 



                    }
                    break;
                case 12 :
                    // b.g:222:13: 'nnn'
                    {
                    match("nnn"); 



                    }
                    break;
                case 13 :
                    // b.g:222:20: '⋂'
                    {
                    match('\u22C2'); 

                    }
                    break;
                case 14 :
                    // b.g:223:3: 'bigcup'
                    {
                    match("bigcup"); 



                    }
                    break;
                case 15 :
                    // b.g:223:13: 'uuu'
                    {
                    match("uuu"); 



                    }
                    break;
                case 16 :
                    // b.g:223:20: '⋃'
                    {
                    match('\u22C3'); 

                    }
                    break;
                case 17 :
                    // b.g:224:4: 'lim'
                    {
                    match("lim"); 



                    }
                    break;
                case 18 :
                    // b.g:225:4: 'Lim'
                    {
                    match("Lim"); 



                    }
                    break;
                case 19 :
                    // b.g:226:4: 'min'
                    {
                    match("min"); 



                    }
                    break;
                case 20 :
                    // b.g:227:4: 'max'
                    {
                    match("max"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNDEROVER"

    // $ANTLR start "DEFINITION"
    public final void mDEFINITION() throws RecognitionException {
        try {
            int _type = DEFINITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:229:12: (| 'dx' | '{:d x:}' | 'dy' | '{:d y:}' | 'dz' | '{:d z:}' | 'dt' | '{:d t:}' )
            int alt16=9;
            switch ( input.LA(1) ) {
            case 'd':
                {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt16=2;
                    }
                    break;
                case 'y':
                    {
                    alt16=4;
                    }
                    break;
                case 'z':
                    {
                    alt16=6;
                    }
                    break;
                case 't':
                    {
                    alt16=8;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 2, input);

                    throw nvae;

                }

                }
                break;
            case '{':
                {
                int LA16_3 = input.LA(2);

                if ( (LA16_3==':') ) {
                    int LA16_8 = input.LA(3);

                    if ( (LA16_8=='d') ) {
                        int LA16_9 = input.LA(4);

                        if ( (LA16_9==' ') ) {
                            switch ( input.LA(5) ) {
                            case 'x':
                                {
                                alt16=3;
                                }
                                break;
                            case 'y':
                                {
                                alt16=5;
                                }
                                break;
                            case 'z':
                                {
                                alt16=7;
                                }
                                break;
                            case 't':
                                {
                                alt16=9;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 16, 10, input);

                                throw nvae;

                            }

                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 9, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 8, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                alt16=1;
            }

            switch (alt16) {
                case 1 :
                    // b.g:230:3: 
                    {
                    }
                    break;
                case 2 :
                    // b.g:230:4: 'dx'
                    {
                    match("dx"); 



                    }
                    break;
                case 3 :
                    // b.g:230:10: '{:d x:}'
                    {
                    match("{:d x:}"); 



                    }
                    break;
                case 4 :
                    // b.g:231:4: 'dy'
                    {
                    match("dy"); 



                    }
                    break;
                case 5 :
                    // b.g:231:10: '{:d y:}'
                    {
                    match("{:d y:}"); 



                    }
                    break;
                case 6 :
                    // b.g:232:4: 'dz'
                    {
                    match("dz"); 



                    }
                    break;
                case 7 :
                    // b.g:232:10: '{:d z:}'
                    {
                    match("{:d z:}"); 



                    }
                    break;
                case 8 :
                    // b.g:233:4: 'dt'
                    {
                    match("dt"); 



                    }
                    break;
                case 9 :
                    // b.g:233:10: '{:d t:}'
                    {
                    match("{:d t:}"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFINITION"

    // $ANTLR start "LEFTRIGHT"
    public final void mLEFTRIGHT() throws RecognitionException {
        try {
            int _type = LEFTRIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:236:2: (| '|' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='|') ) {
                alt17=2;
            }
            else {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // b.g:237:3: 
                    {
                    }
                    break;
                case 2 :
                    // b.g:237:4: '|'
                    {
                    match('|'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFTRIGHT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // b.g:239:6: (| 'text' | 'mbox' )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt18=2;
                }
                break;
            case 'm':
                {
                alt18=3;
                }
                break;
            default:
                alt18=1;
            }

            switch (alt18) {
                case 1 :
                    // b.g:240:3: 
                    {
                    }
                    break;
                case 2 :
                    // b.g:240:4: 'text'
                    {
                    match("text"); 



                    }
                    break;
                case 3 :
                    // b.g:241:4: 'mbox'
                    {
                    match("mbox"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    public void mTokens() throws RecognitionException {
        // b.g:1:8: ( T__20 | T__21 | INT | FLOAT | CONST | OPERATOR | UNARY | BINARY | INFIX | LEFT | RIGHT | SPACE | UNDEROVER | DEFINITION | LEFTRIGHT | TEXT )
        int alt19=16;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // b.g:1:10: T__20
                {
                mT__20(); 


                }
                break;
            case 2 :
                // b.g:1:16: T__21
                {
                mT__21(); 


                }
                break;
            case 3 :
                // b.g:1:22: INT
                {
                mINT(); 


                }
                break;
            case 4 :
                // b.g:1:26: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 5 :
                // b.g:1:32: CONST
                {
                mCONST(); 


                }
                break;
            case 6 :
                // b.g:1:38: OPERATOR
                {
                mOPERATOR(); 


                }
                break;
            case 7 :
                // b.g:1:47: UNARY
                {
                mUNARY(); 


                }
                break;
            case 8 :
                // b.g:1:53: BINARY
                {
                mBINARY(); 


                }
                break;
            case 9 :
                // b.g:1:60: INFIX
                {
                mINFIX(); 


                }
                break;
            case 10 :
                // b.g:1:66: LEFT
                {
                mLEFT(); 


                }
                break;
            case 11 :
                // b.g:1:71: RIGHT
                {
                mRIGHT(); 


                }
                break;
            case 12 :
                // b.g:1:77: SPACE
                {
                mSPACE(); 


                }
                break;
            case 13 :
                // b.g:1:83: UNDEROVER
                {
                mUNDEROVER(); 


                }
                break;
            case 14 :
                // b.g:1:93: DEFINITION
                {
                mDEFINITION(); 


                }
                break;
            case 15 :
                // b.g:1:104: LEFTRIGHT
                {
                mLEFTRIGHT(); 


                }
                break;
            case 16 :
                // b.g:1:114: TEXT
                {
                mTEXT(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA7_eotS =
        "\116\uffff\1\123\5\uffff";
    static final String DFA7_eofS =
        "\124\uffff";
    static final String DFA7_minS =
        "\1\104\12\uffff\1\160\1\uffff\1\141\26\uffff\1\150\2\uffff\1\150"+
        "\13\uffff\1\141\15\uffff\1\163\1\uffff\1\162\10\uffff\1\151\1\145"+
        "\1\154\5\uffff";
    static final String DFA7_maxS =
        "\1\u03d5\12\uffff\1\164\1\uffff\1\141\26\uffff\1\163\2\uffff\1\163"+
        "\13\uffff\1\150\15\uffff\1\163\1\uffff\1\162\10\uffff\1\151\1\164"+
        "\1\154\5\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\uffff\1\15"+
        "\1\uffff\1\17\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
        "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\uffff"+
        "\1\47\1\51\1\uffff\1\53\1\55\1\57\1\61\1\63\1\64\1\65\1\66\1\67"+
        "\1\70\1\71\1\uffff\1\73\1\75\1\77\1\100\1\101\1\102\1\103\1\104"+
        "\1\105\1\106\1\107\1\110\1\111\1\uffff\1\20\1\uffff\1\46\1\54\1"+
        "\60\1\52\1\56\1\62\1\72\1\74\3\uffff\1\16\1\50\1\76\1\13\1\14";
    static final String DFA7_specialS =
        "\124\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\11\2\uffff\1\22\4\uffff\1\32\2\uffff\1\42\1\47\2\uffff\1"+
            "\61\1\67\3\uffff\1\75\10\uffff\1\1\1\3\1\5\1\7\1\13\1\uffff"+
            "\1\20\1\uffff\1\24\1\uffff\1\26\1\30\1\34\1\36\1\40\1\44\1\uffff"+
            "\1\55\1\57\1\63\1\71\1\15\1\uffff\1\73\1\uffff\1\77\u01e0\uffff"+
            "\1\16\u0137\uffff\1\23\1\12\3\uffff\1\70\2\uffff\1\33\2\uffff"+
            "\1\76\1\uffff\1\52\2\uffff\1\62\2\uffff\1\50\1\uffff\1\54\1"+
            "\43\7\uffff\1\2\1\4\1\21\1\10\1\14\1\100\1\17\1\65\1\25\1\27"+
            "\1\31\1\35\1\37\1\74\1\uffff\1\51\1\56\1\uffff\1\60\1\64\1\72"+
            "\1\45\1\6\1\53\1\41\7\uffff\1\66\3\uffff\1\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\101\3\uffff\1\102",
            "",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\104\1\105\11\uffff\1\106",
            "",
            "",
            "\1\107\1\110\11\uffff\1\111",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\112\6\uffff\1\113",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\114",
            "",
            "\1\115",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\116",
            "\1\117\12\uffff\1\120\3\uffff\1\121",
            "\1\122",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "23:1: fragment GREEK : ( 'alpha' | 'α' | 'beta' | 'β' | 'chi' | 'χ' | 'delta' | 'δ' | 'Delta' | 'Δ' | 'epsilon' | 'epsi' | 'ε' | 'varepsilon' | 'ɛ' | 'eta' | 'η' | 'gamma' | 'γ' | 'Gamma' | 'Γ' | 'iota' | 'ι' | 'kappa' | 'κ' | 'lambda' | 'λ' | 'Lambda' | 'Λ' | 'mu' | 'μ' | 'nu' | 'ν' | 'omega' | 'ω' | 'Omega' | 'Ω' | 'phi' | 'φ' | 'varphi' | 'ϕ' | 'Phi' | 'Φ' | 'pi' | 'π' | 'Pi' | 'Π' | 'psi' | 'ψ' | 'Psi' | 'Ψ' | 'rho' | 'ρ' | 'sigma' | 'σ' | 'Sigma' | 'Σ' | 'tau' | 'τ' | 'theta' | 'θ' | 'vartheta' | 'ϑ' | 'Theta' | 'Θ' | 'upsilon' | 'υ' | 'xi' | 'ξ' | 'Xi' | 'Ξ' | 'zeta' | 'ζ' );";
        }
    }
    static final String DFA8_eotS =
        "\2\uffff\1\u0081\3\uffff\1\u0088\33\uffff\1\u00b7\63\uffff\1\u00d5"+
        "\65\uffff\1\u00e7\10\uffff\1\u00ec\1\uffff\1\u00ee\14\uffff\1\u00f2"+
        "\11\uffff\1\u00f5\1\u00f8\6\uffff\1\u00fa\1\uffff\1\u00fc\3\uffff"+
        "\1\u00ff\3\uffff\1\u0104\23\uffff\1\u0109\17\uffff\1\u010f\1\u0112"+
        "\15\uffff\1\u0114\12\uffff\1\u0117\10\uffff\1\u011b\3\uffff\1\u011e"+
        "\1\u0120\13\uffff\1\u0126\1\u0128\21\uffff\1\u012e\1\u0130\4\uffff";
    static final String DFA8_eofS =
        "\u0131\uffff";
    static final String DFA8_minS =
        "\1\40\1\141\1\52\1\uffff\1\145\1\uffff\1\57\1\141\1\uffff\1\150"+
        "\2\uffff\1\141\1\72\3\uffff\1\53\6\uffff\1\144\1\uffff\1\141\1\uffff"+
        "\1\141\1\uffff\1\75\1\uffff\1\56\1\101\1\75\1\uffff\1\145\1\55\1"+
        "\uffff\1\141\4\uffff\1\146\6\uffff\1\155\1\uffff\1\75\1\uffff\1"+
        "\154\10\uffff\1\137\3\uffff\1\55\1\uffff\1\141\17\uffff\1\u00a0"+
        "\1\161\6\uffff\1\101\11\uffff\1\122\13\uffff\1\101\3\uffff\1\145"+
        "\2\uffff\1\157\10\uffff\1\142\7\uffff\1\160\1\uffff\1\141\6\uffff"+
        "\1\75\1\uffff\1\76\12\uffff\1\141\1\uffff\1\147\1\164\10\uffff\1"+
        "\75\1\146\6\uffff\1\76\1\uffff\1\161\3\uffff\1\75\1\145\2\uffff"+
        "\1\146\15\uffff\1\55\3\uffff\1\144\1\uffff\1\u00a0\14\uffff\1\146"+
        "\1\164\1\143\2\145\15\uffff\1\151\3\uffff\1\164\6\uffff\1\76\1\uffff"+
        "\1\143\1\160\5\uffff\1\145\2\uffff\1\164\1\163\2\145\2\uffff\1\145"+
        "\4\uffff\1\141\2\uffff\1\145\1\164\2\uffff\1\141\4\uffff\2\164\10"+
        "\uffff\2\145\4\uffff";
    static final String DFA8_maxS =
        "\1\u2ab0\1\165\1\52\1\uffff\1\165\1\uffff\1\137\1\157\1\uffff\1"+
        "\157\2\uffff\1\157\1\154\3\uffff\1\170\6\uffff\1\166\1\uffff\1\157"+
        "\1\uffff\1\165\1\uffff\1\151\1\uffff\1\75\1\165\1\75\1\uffff\1\162"+
        "\1\75\1\uffff\1\162\4\uffff\1\156\6\uffff\1\170\1\uffff\1\176\1"+
        "\uffff\1\160\10\uffff\1\174\3\uffff\1\176\1\uffff\1\157\17\uffff"+
        "\1\u00a0\1\165\6\uffff\1\151\11\uffff\1\151\13\uffff\1\141\3\uffff"+
        "\1\145\2\uffff\1\157\10\uffff\1\160\7\uffff\1\160\1\uffff\1\166"+
        "\6\uffff\1\75\1\uffff\1\76\12\uffff\1\157\1\uffff\1\147\1\164\10"+
        "\uffff\1\75\1\161\6\uffff\1\76\1\uffff\1\161\3\uffff\1\76\1\157"+
        "\2\uffff\1\164\15\uffff\1\76\3\uffff\1\144\1\uffff\1\u00a0\14\uffff"+
        "\1\146\1\164\1\143\2\163\15\uffff\1\151\3\uffff\1\164\6\uffff\1"+
        "\76\1\uffff\1\143\1\160\5\uffff\1\145\2\uffff\1\164\1\163\2\145"+
        "\2\uffff\1\145\4\uffff\1\162\2\uffff\1\145\1\164\2\uffff\1\162\4"+
        "\uffff\2\164\10\uffff\2\145\4\uffff";
    static final String DFA8_acceptS =
        "\3\uffff\1\3\1\uffff\1\6\2\uffff\1\12\1\uffff\1\15\1\16\2\uffff"+
        "\1\21\1\23\1\24\1\uffff\1\27\1\32\1\35\1\36\1\37\1\40\1\uffff\1"+
        "\43\1\uffff\1\46\1\uffff\1\51\1\uffff\1\54\3\uffff\1\64\2\uffff"+
        "\1\70\1\uffff\1\74\1\77\1\102\1\105\1\uffff\1\107\1\112\1\115\1"+
        "\120\1\123\1\126\1\uffff\1\131\1\uffff\1\134\1\uffff\1\137\1\142"+
        "\1\145\1\146\1\147\1\150\1\152\1\153\1\uffff\1\156\1\160\1\161\1"+
        "\uffff\1\164\1\uffff\1\167\1\171\1\173\1\176\1\u0081\1\u0083\1\u0084"+
        "\1\u0086\1\u0087\1\u008a\1\u008c\1\u008e\1\u0091\1\u0094\1\u0095"+
        "\2\uffff\1\u009c\1\u009e\1\u00a0\1\u00a2\1\u00a4\1\u00a7\1\uffff"+
        "\1\u00aa\1\u00ad\1\u00b0\1\u00b1\1\u00b2\1\u00b3\1\u00b4\1\u00b5"+
        "\1\u00b6\1\uffff\1\u00b8\1\u00b9\1\u00ba\1\u00c1\1\u00c4\1\u00c9"+
        "\1\u00cb\1\u00cd\1\u00cf\1\u00d2\1\u00d5\1\uffff\1\u00d8\1\u00dc"+
        "\1\u00dd\1\uffff\1\u00e0\1\u00e5\1\uffff\1\22\1\44\1\47\1\132\1"+
        "\5\1\2\1\4\1\13\1\uffff\1\u00a3\1\7\1\u0093\1\10\1\11\1\154\1\14"+
        "\1\uffff\1\u008f\1\uffff\1\175\1\u009f\1\u00c2\1\u00c3\1\20\1\72"+
        "\1\uffff\1\130\1\uffff\1\25\1\26\1\30\1\31\1\33\1\34\1\172\1\u0089"+
        "\1\41\1\42\1\uffff\1\45\2\uffff\1\177\1\50\1\u00bf\1\u00c0\1\53"+
        "\1\111\1\55\1\u0090\2\uffff\1\u008d\1\u00a5\1\u00ab\1\u00bd\1\u00d4"+
        "\1\u00df\1\uffff\1\57\1\uffff\1\u0080\1\u00be\1\67\2\uffff\1\174"+
        "\1\u0082\1\uffff\1\u00db\1\u00e3\1\127\1\151\1\u0085\1\133\1\136"+
        "\1\u00af\1\135\1\u008b\1\u0092\1\155\1\u00a9\1\uffff\1\166\1\u00a6"+
        "\1\u00ac\1\uffff\1\u00d0\1\uffff\1\u0096\1\u0097\1\u0099\1\u00a8"+
        "\1\u00ae\1\u00c5\1\u00c6\1\u00da\1\u00b7\1\u00d9\1\u00d7\1\u00e2"+
        "\5\uffff\1\157\1\u00c7\1\17\1\u00a1\1\u00bb\1\101\1\73\1\u00cc\1"+
        "\u00c8\1\162\1\u009d\1\143\1\52\1\uffff\1\62\1\56\1\61\1\uffff\1"+
        "\60\1\u00e4\1\63\1\66\1\65\1\104\1\uffff\1\76\2\uffff\1\170\1\u0088"+
        "\1\106\1\163\1\u00d1\1\uffff\1\u009a\1\u0098\4\uffff\1\122\1\114"+
        "\1\uffff\1\125\1\117\1\110\1\144\1\uffff\1\u00ce\1\u00ca\2\uffff"+
        "\1\165\1\u00bc\1\uffff\1\u009b\1\1\1\103\1\75\2\uffff\1\u00d3\1"+
        "\u00d6\1\100\1\71\1\140\1\141\1\u00de\1\u00e1\2\uffff\1\121\1\113"+
        "\1\124\1\116";
    static final String DFA8_specialS =
        "\u0131\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\125\1\36\10\uffff\1\2\1\114\1\uffff\1\15\1\122\1\6\12\uffff"+
            "\1\40\1\uffff\1\42\1\166\1\45\1\uffff\1\17\1\74\1\uffff\1\142"+
            "\1\uffff\1\76\6\uffff\1\170\1\uffff\1\144\1\116\1\uffff\1\146"+
            "\1\150\1\uffff\1\102\5\uffff\1\152\1\uffff\1\10\1\uffff\1\26"+
            "\1\100\1\uffff\1\67\1\7\1\1\1\14\1\63\1\73\1\44\1\164\1\54\2"+
            "\uffff\1\41\1\106\1\32\1\21\1\47\1\127\1\136\1\4\1\11\1\34\1"+
            "\30\1\25\1\12\3\uffff\1\104\1\uffff\1\65\41\uffff\1\126\13\uffff"+
            "\1\72\4\uffff\1\115\45\uffff\1\13\37\uffff\1\16\u200a\uffff"+
            "\1\143\22\uffff\1\145\4\uffff\1\147\2\uffff\1\151\6\uffff\1"+
            "\153\20\uffff\1\121\132\uffff\1\163\1\154\1\156\1\155\1\165"+
            "\13\uffff\1\160\2\uffff\1\157\2\uffff\1\162\51\uffff\1\171\1"+
            "\uffff\1\167\1\uffff\1\172\53\uffff\1\75\1\uffff\1\112\1\77"+
            "\1\uffff\1\117\1\uffff\1\113\1\55\1\56\23\uffff\1\71\1\120\1"+
            "\uffff\1\124\6\uffff\1\27\1\31\1\33\1\35\1\110\2\uffff\1\111"+
            "\5\uffff\1\123\20\uffff\1\66\2\uffff\1\70\27\uffff\1\37\1\64"+
            "\2\uffff\1\43\1\46\24\uffff\1\50\1\51\6\uffff\1\57\1\60\2\uffff"+
            "\1\61\1\62\15\uffff\1\22\1\uffff\1\23\1\uffff\1\24\10\uffff"+
            "\1\105\1\uffff\1\103\1\101\2\uffff\1\107\33\uffff\1\133\1\3"+
            "\1\5\47\uffff\1\131\1\130\1\uffff\1\132\26\uffff\1\140\1\141"+
            "\1\135\1\137\u0295\uffff\1\134\u010a\uffff\1\20\u0269\uffff"+
            "\1\161\u0198\uffff\1\52\1\53",
            "\1\175\2\uffff\1\173\4\uffff\1\174\5\uffff\1\177\5\uffff\1"+
            "\176",
            "\1\u0080",
            "",
            "\1\u0083\13\uffff\1\u0085\2\uffff\1\u0082\1\u0084",
            "",
            "\1\u0086\57\uffff\1\u0087",
            "\1\u0089\15\uffff\1\u008a",
            "",
            "\1\u008d\1\u008b\5\uffff\1\u008c",
            "",
            "",
            "\1\u0092\2\uffff\1\u0090\1\u008f\3\uffff\1\u008e\5\uffff\1"+
            "\u0091",
            "\1\u0093\1\uffff\1\u0095\1\u0096\1\u0097\55\uffff\1\u0094",
            "",
            "",
            "",
            "\1\u0099\2\uffff\1\u009d\65\uffff\1\u009c\4\uffff\1\u009e\5"+
            "\uffff\1\u009f\1\u0098\3\uffff\1\u009a\3\uffff\1\u009b",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a2\1\u00a0\20\uffff\1\u00a1",
            "",
            "\1\u00a6\3\uffff\1\u00a4\10\uffff\1\u00a3\1\u00a5",
            "",
            "\1\u00a9\16\uffff\1\u00a8\4\uffff\1\u00a7",
            "",
            "\1\u00aa\53\uffff\1\u00ab",
            "",
            "\1\u00ad\16\uffff\1\u00ac",
            "\1\u00b5\37\uffff\1\u00b4\1\uffff\1\u00b2\1\u00b0\1\u00af\1"+
            "\u00b1\15\uffff\1\u00ae\1\u00b3",
            "\1\u00b6",
            "",
            "\1\u00b8\6\uffff\1\u00ba\5\uffff\1\u00b9",
            "\1\u00bc\17\uffff\1\u00bb",
            "",
            "\1\u00be\13\uffff\1\u00bf\4\uffff\1\u00bd",
            "",
            "",
            "",
            "",
            "\1\u00c2\6\uffff\1\u00c1\1\u00c0",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c5\3\uffff\1\u00c3\6\uffff\1\u00c4",
            "",
            "\1\u00c6\76\uffff\1\u00c8\1\uffff\1\u00c7",
            "",
            "\1\u00ca\1\uffff\1\u00cb\1\uffff\1\u00c9",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00cd\34\uffff\1\u00cc",
            "",
            "",
            "",
            "\1\u00ce\17\uffff\1\u00cf\41\uffff\1\u00d0\36\uffff\1\u00d1",
            "",
            "\1\u00d3\15\uffff\1\u00d2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00d4",
            "\1\u00d7\3\uffff\1\u00d6",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00dc\37\uffff\1\u00db\1\uffff\1\u00d9\2\uffff\1\u00d8\2"+
            "\uffff\1\u00da",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00dd\26\uffff\1\u00de",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e0\37\uffff\1\u00df",
            "",
            "",
            "",
            "\1\u00e1",
            "",
            "",
            "\1\u00e2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e4\1\u00e3\14\uffff\1\u00e5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e6",
            "",
            "\1\u00e9\13\uffff\1\u00ea\10\uffff\1\u00e8",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00eb",
            "",
            "\1\u00ed",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00ef\15\uffff\1\u00f0",
            "",
            "\1\u00f1",
            "\1\u00f3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f4",
            "\1\u00f7\12\uffff\1\u00f6",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f9",
            "",
            "\1\u00fb",
            "",
            "",
            "",
            "\1\u00fd\1\u00fe",
            "\1\u0100\11\uffff\1\u0101",
            "",
            "",
            "\1\u0103\15\uffff\1\u0102",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0105\20\uffff\1\u0106",
            "",
            "",
            "",
            "\1\u0107",
            "",
            "\1\u0108",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010e\15\uffff\1\u010d",
            "\1\u0111\15\uffff\1\u0110",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0113",
            "",
            "",
            "",
            "\1\u0115",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0116",
            "",
            "\1\u0118",
            "\1\u0119",
            "",
            "",
            "",
            "",
            "",
            "\1\u011a",
            "",
            "",
            "\1\u011c",
            "\1\u011d",
            "\1\u011f",
            "\1\u0121",
            "",
            "",
            "\1\u0122",
            "",
            "",
            "",
            "",
            "\1\u0123\20\uffff\1\u0124",
            "",
            "",
            "\1\u0125",
            "\1\u0127",
            "",
            "",
            "\1\u0129\20\uffff\1\u012a",
            "",
            "",
            "",
            "",
            "\1\u012b",
            "\1\u012c",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u012d",
            "\1\u012f",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "60:1: OPERATOR : ( 'cdot' | '*' | '⋅' | 'star' | '**' | '⋆' | '//' | '/' | 'backslash' | '\\\\' | 'setminus' | 'times' | 'xx' | '×' | 'divide' | '-:' | '÷' | 'circ' | '@' | '⚬' | 'oplus' | 'o+' | '⊕' | 'otimes' | 'ox' | '⊗' | 'odot' | 'o.' | '⊙' | 'wedge' | '^^' | '∧' | 'vee' | 'vv' | '∨' | 'cap' | 'nn' | '∩' | 'cup' | 'uu' | '∪' | 'ne' | '!=' | '≠' | ':=' | 'lt' | '<' | 'le' | 'leq' | 'lt=' | '<=' | '≤' | 'ge' | 'geq' | '>=' | '≥' | 'prec' | '-lt' | '-<' | '≺' | 'succ' | '>-' | '≻' | 'preceq' | '-<=' | '⪯' | 'succeq' | '>-=' | '⪰' | 'in' | '∈' | 'notin' | '!in' | '∉' | 'subset' | 'sub' | '⊂' | 'supset' | 'sup' | '⊃' | 'subseteq' | 'sube' | '⊆' | 'supseteq' | 'supe' | '⊇' | 'equiv' | '-=' | '≡' | 'cong' | '~=' | '≅' | 'approx' | '~~' | '≈' | 'propto' | 'prop' | '∝' | 'neg' | 'not' | '¬' | 'forall' | 'AA' | '∀' | 'exists' | 'EE' | '∃' | 'bot' | '_|_' | '⊥' | 'top' | 'TT' | '⊤' | 'vdash' | '|--' | '⊢' | 'models' | '|==' | '⊨' | 'int' | '∫' | 'oint' | '∮' | 'partial' | 'del' | '∂' | 'nabla' | 'grad' | '∇' | 'pm' | '+-' | '±' | 'emptyset' | 'O/' | '∅' | 'infty' | 'oo' | '∞' | 'aleph' | 'ℵ' | 'ldots' | '...' | 'therefore' | ':.' | '∴' | 'angle' | '/_' | '∠' | '\\ ' | ' ' | 'quad' | '  ' | 'qquad' | '    ' | 'cdots' | '⋯' | 'vdots' | '⋮' | 'ddots' | '⋱' | 'diamond' | '⋄' | 'square' | '□' | 'lfloor' | '|__' | '⌊' | 'rfloor' | '__|' | '⌋' | 'lceiling' | '|~' | '⌈' | 'rceiling' | '~|' | '⌉' | 'CC' | 'ℂ' | 'NN' | 'ℕ' | 'QQ' | 'ℚ' | 'RR' | 'ℝ' | 'ZZ' | 'ℤ' | 'dim' | 'mod' | 'lub' | 'glb' | 'uparrow' | 'uarr' | '↑' | 'downarrow' | 'darr' | '↓' | 'rightarrow' | 'rarr' | 'to' | '->' | '→' | '>->' | '↣' | '->>' | '↠' | '>->>' | '⤖' | 'mapsto' | '|->' | '↦' | 'leftarrow' | 'larr' | '←' | 'leftrightarrow' | 'harr' | '↔' | 'Rightarrow' | 'rArr' | 'implies' | '=>' | '⇒' | 'Leftarrow' | 'lArr' | '⇐' | 'Leftrightarrow' | 'hArr' | 'iff' | '<=>' | '⇔' );";
        }
    }
    static final String DFA19_eotS =
        "\1\54\1\62\1\63\1\64\1\uffff\1\6\1\uffff\25\6\2\uffff\1\6\1\uffff"+
        "\1\34\1\uffff\3\6\1\125\6\6\2\uffff\1\55\2\uffff\1\34\16\uffff\1"+
        "\34\1\107\4\uffff\1\34\14\uffff\1\34\1\71\2\uffff\1\55\1\34\4\uffff"+
        "\1\71";
    static final String DFA19_eofS =
        "\136\uffff";
    static final String DFA19_minS =
        "\1\40\1\136\1\137\2\56\1\154\1\uffff\3\141\1\155\1\144\1\143\1\146"+
        "\1\101\1\145\2\141\1\53\1\57\1\141\1\101\1\145\1\141\1\124\1\141"+
        "\1\170\1\145\2\uffff\1\157\1\51\1\74\1\55\1\101\1\105\1\161\1\55"+
        "\1\103\1\116\1\121\1\122\1\132\1\101\2\uffff\1\72\2\uffff\1\136"+
        "\4\uffff\1\145\1\144\1\143\1\uffff\1\156\1\154\1\157\1\164\1\uffff"+
        "\1\143\1\166\1\146\1\155\1\145\1\160\1\uffff\1\156\1\uffff\1\145"+
        "\1\156\1\uffff\1\147\1\141\1\143\1\142\1\162\1\156\1\145\1\141\1"+
        "\165\1\141\1\uffff\1\162\1\144\2\164\1\144\1\143\1\162\1\163";
    static final String DFA19_maxS =
        "\1\u2ab0\1\136\1\174\2\71\1\160\1\uffff\1\157\1\165\1\172\1\170"+
        "\1\166\1\162\1\156\1\165\1\151\2\157\1\170\1\57\1\162\1\157\1\165"+
        "\1\164\1\124\1\165\1\170\1\145\2\uffff\1\162\1\175\1\74\1\76\1\101"+
        "\1\105\1\165\1\176\1\103\1\116\1\121\1\151\1\132\1\141\2\uffff\1"+
        "\72\2\uffff\1\136\4\uffff\1\160\1\147\1\162\1\uffff\2\164\1\157"+
        "\1\167\1\uffff\1\145\1\166\1\146\1\162\1\155\1\170\1\uffff\1\156"+
        "\1\uffff\1\157\1\162\1\uffff\1\156\1\141\1\164\1\160\2\165\1\145"+
        "\1\163\1\165\1\141\1\uffff\1\164\1\144\2\164\1\160\1\162\1\164\1"+
        "\163";
    static final String DFA19_acceptS =
        "\6\uffff\1\5\25\uffff\2\6\16\uffff\1\11\1\12\1\uffff\1\13\1\15\1"+
        "\uffff\1\1\1\2\1\3\1\4\3\uffff\1\7\4\uffff\1\16\6\uffff\1\20\1\uffff"+
        "\1\14\2\uffff\1\10\12\uffff\1\17\10\uffff";
    static final String DFA19_specialS =
        "\136\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\34\6\uffff\1\55\1\57\2\34\1\uffff\1\34\1\4\1\35\12\3\1\37"+
            "\1\uffff\1\40\1\34\1\41\1\uffff\1\34\1\42\1\6\1\46\1\6\1\43"+
            "\6\6\1\17\1\6\1\47\1\23\1\6\1\50\1\51\1\6\1\30\5\6\1\52\1\55"+
            "\1\34\1\57\1\1\1\2\1\uffff\1\5\1\7\1\10\1\11\1\12\1\36\1\14"+
            "\1\53\1\15\2\6\1\16\1\20\1\21\1\22\1\24\1\44\1\25\1\26\1\27"+
            "\1\31\1\13\1\33\1\32\2\6\1\56\1\45\1\57\1\34\41\uffff\1\34\13"+
            "\uffff\1\34\4\uffff\1\34\45\uffff\1\34\37\uffff\1\34\u0163\uffff"+
            "\1\6\u0137\uffff\2\6\3\uffff\1\6\2\uffff\1\6\2\uffff\1\6\1\uffff"+
            "\1\6\2\uffff\1\6\2\uffff\1\6\1\uffff\2\6\7\uffff\16\6\1\uffff"+
            "\2\6\1\uffff\7\6\7\uffff\1\6\3\uffff\1\6\u1d2c\uffff\1\34\22"+
            "\uffff\1\34\4\uffff\1\34\2\uffff\1\34\6\uffff\1\34\20\uffff"+
            "\1\34\132\uffff\5\34\13\uffff\1\34\2\uffff\1\34\2\uffff\1\34"+
            "\51\uffff\1\34\1\uffff\1\34\1\uffff\1\34\53\uffff\1\34\1\uffff"+
            "\2\34\1\uffff\1\34\1\uffff\3\34\5\uffff\1\60\1\uffff\1\60\13"+
            "\uffff\2\34\1\uffff\1\34\6\uffff\5\34\2\uffff\1\34\5\uffff\1"+
            "\34\20\uffff\1\34\2\uffff\1\34\27\uffff\2\34\2\uffff\2\34\24"+
            "\uffff\2\34\6\uffff\2\34\2\uffff\2\34\15\uffff\1\34\1\uffff"+
            "\1\34\1\uffff\1\34\10\uffff\1\34\1\uffff\2\34\2\uffff\1\34\27"+
            "\uffff\4\60\3\34\47\uffff\2\34\1\uffff\1\34\26\uffff\4\34\35"+
            "\uffff\1\55\1\57\u0276\uffff\1\34\u010a\uffff\1\34\u0269\uffff"+
            "\1\34\u0198\uffff\2\34",
            "\1\61",
            "\1\34\34\uffff\1\34",
            "\1\65\1\uffff\12\3",
            "\1\34\1\uffff\12\65",
            "\1\66\1\uffff\1\67\1\uffff\1\34",
            "",
            "\1\70\1\71\6\uffff\1\60\5\uffff\1\34",
            "\1\34\1\uffff\1\71\1\34\4\uffff\1\34\5\uffff\1\72\3\uffff\1"+
            "\71\1\uffff\1\34",
            "\1\34\2\uffff\1\74\1\73\3\uffff\1\34\5\uffff\1\75\4\uffff\1"+
            "\76\3\uffff\3\76",
            "\1\34\3\uffff\1\34\6\uffff\1\34",
            "\1\34\1\77\20\uffff\1\100",
            "\1\71\1\uffff\1\34\6\uffff\1\34\5\uffff\1\34",
            "\1\101\6\uffff\2\34",
            "\1\34\37\uffff\1\102\1\uffff\1\103\3\34\2\uffff\1\60\4\uffff"+
            "\2\71\4\uffff\2\34",
            "\1\34\3\uffff\1\60",
            "\1\104\1\105\6\uffff\1\60\5\uffff\1\34",
            "\1\34\3\uffff\1\34\10\uffff\1\106\1\34",
            "\1\34\2\uffff\1\34\65\uffff\1\34\4\uffff\1\34\5\uffff\2\34"+
            "\1\uffff\1\107\1\uffff\1\34\1\uffff\1\71\1\uffff\1\34",
            "\1\34",
            "\1\34\13\uffff\1\34\4\uffff\1\110",
            "\1\34\37\uffff\1\111\1\uffff\1\34\2\uffff\1\34\2\uffff\1\34"+
            "\5\uffff\1\112",
            "\1\115\1\71\2\uffff\1\113\7\uffff\1\117\2\uffff\1\114\1\116",
            "\1\120\3\uffff\1\105\2\uffff\1\121\1\34\5\uffff\1\34\4\uffff"+
            "\1\71",
            "\1\34",
            "\1\34\12\uffff\1\71\1\uffff\1\71\1\uffff\1\122\4\uffff\1\123",
            "\1\34",
            "\1\34",
            "",
            "",
            "\1\34\2\uffff\1\124",
            "\1\57\4\uffff\1\34\16\uffff\1\34\77\uffff\1\57",
            "\1\55",
            "\1\34\17\uffff\1\34\1\57",
            "\1\34",
            "\1\34",
            "\1\34\3\uffff\1\34",
            "\1\34\17\uffff\1\34\41\uffff\1\34\36\uffff\1\34",
            "\1\34",
            "\1\34",
            "\1\34",
            "\1\34\26\uffff\1\34",
            "\1\34",
            "\1\34\37\uffff\1\126",
            "",
            "",
            "\1\127",
            "",
            "",
            "\1\60",
            "",
            "",
            "",
            "",
            "\1\34\12\uffff\1\6",
            "\1\107\2\uffff\1\34",
            "\1\34\16\uffff\1\71",
            "",
            "\1\34\4\uffff\2\71",
            "\1\130\7\uffff\1\71",
            "\1\131",
            "\1\71\2\uffff\1\34",
            "",
            "\1\71\1\uffff\1\34",
            "\1\60",
            "\1\34",
            "\1\6\1\55\3\uffff\1\34",
            "\1\34\7\uffff\1\71",
            "\1\34\3\uffff\1\71\3\uffff\1\60",
            "",
            "\1\60",
            "",
            "\1\34\11\uffff\1\132",
            "\1\57\3\uffff\1\34",
            "",
            "\1\6\6\uffff\1\71",
            "\1\133",
            "\1\71\20\uffff\1\34",
            "\2\34\11\uffff\1\60\2\uffff\1\34",
            "\1\71\2\uffff\1\34",
            "\1\71\6\uffff\1\6",
            "\1\134",
            "\1\34\21\uffff\1\6",
            "\1\60",
            "\1\112",
            "",
            "\1\34\1\uffff\1\71",
            "\1\76",
            "\1\6",
            "\1\135",
            "\1\60\13\uffff\1\34",
            "\1\112\16\uffff\1\34",
            "\1\34\1\uffff\1\6",
            "\1\34"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__20 | T__21 | INT | FLOAT | CONST | OPERATOR | UNARY | BINARY | INFIX | LEFT | RIGHT | SPACE | UNDEROVER | DEFINITION | LEFTRIGHT | TEXT );";
        }
    }
 

}
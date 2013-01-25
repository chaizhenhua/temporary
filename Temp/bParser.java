// $ANTLR 3.4 b.g 2013-01-25 13:08:21

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class bParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BINARY", "CONST", "DEFINITION", "FLOAT", "GREEK", "INFIX", "INT", "LATTIN", "LEFT", "LEFTRIGHT", "OPERATOR", "RIGHT", "SPACE", "TEXT", "UNARY", "UNDEROVER", "'^'", "'_'"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public bParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public bParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return bParser.tokenNames; }
    public String getGrammarFileName() { return "b.g"; }



    // $ANTLR start "s"
    // b.g:11:1: s : ( CONST | LEFT s RIGHT | UNARY s | BINARY s s );
    public final void s() throws RecognitionException {
        try {
            // b.g:11:3: ( CONST | LEFT s RIGHT | UNARY s | BINARY s s )
            int alt1=4;
            switch ( input.LA(1) ) {
            case CONST:
                {
                alt1=1;
                }
                break;
            case LEFT:
                {
                alt1=2;
                }
                break;
            case UNARY:
                {
                alt1=3;
                }
                break;
            case BINARY:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // b.g:11:5: CONST
                    {
                    match(input,CONST,FOLLOW_CONST_in_s76); 

                    }
                    break;
                case 2 :
                    // b.g:11:13: LEFT s RIGHT
                    {
                    match(input,LEFT,FOLLOW_LEFT_in_s80); 

                    pushFollow(FOLLOW_s_in_s82);
                    s();

                    state._fsp--;


                    match(input,RIGHT,FOLLOW_RIGHT_in_s84); 

                    }
                    break;
                case 3 :
                    // b.g:11:27: UNARY s
                    {
                    match(input,UNARY,FOLLOW_UNARY_in_s87); 

                    pushFollow(FOLLOW_s_in_s89);
                    s();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // b.g:11:37: BINARY s s
                    {
                    match(input,BINARY,FOLLOW_BINARY_in_s93); 

                    pushFollow(FOLLOW_s_in_s95);
                    s();

                    state._fsp--;


                    pushFollow(FOLLOW_s_in_s97);
                    s();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "s"



    // $ANTLR start "e"
    // b.g:12:1: e : ( s ( '_' s )? ( '^' s )? )+ ;
    public final void e() throws RecognitionException {
        try {
            // b.g:12:3: ( ( s ( '_' s )? ( '^' s )? )+ )
            // b.g:12:5: ( s ( '_' s )? ( '^' s )? )+
            {
            // b.g:12:5: ( s ( '_' s )? ( '^' s )? )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= BINARY && LA4_0 <= CONST)||LA4_0==LEFT||LA4_0==UNARY) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // b.g:12:6: s ( '_' s )? ( '^' s )?
            	    {
            	    pushFollow(FOLLOW_s_in_e106);
            	    s();

            	    state._fsp--;


            	    // b.g:12:8: ( '_' s )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==21) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // b.g:12:9: '_' s
            	            {
            	            match(input,21,FOLLOW_21_in_e109); 

            	            pushFollow(FOLLOW_s_in_e111);
            	            s();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    // b.g:12:17: ( '^' s )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==20) ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // b.g:12:18: '^' s
            	            {
            	            match(input,20,FOLLOW_20_in_e116); 

            	            pushFollow(FOLLOW_s_in_e117);
            	            s();

            	            state._fsp--;


            	            }
            	            break;

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "e"

    // Delegated rules


 

    public static final BitSet FOLLOW_CONST_in_s76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_s80 = new BitSet(new long[]{0x0000000000041030L});
    public static final BitSet FOLLOW_s_in_s82 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RIGHT_in_s84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNARY_in_s87 = new BitSet(new long[]{0x0000000000041030L});
    public static final BitSet FOLLOW_s_in_s89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_s93 = new BitSet(new long[]{0x0000000000041030L});
    public static final BitSet FOLLOW_s_in_s95 = new BitSet(new long[]{0x0000000000041030L});
    public static final BitSet FOLLOW_s_in_s97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_s_in_e106 = new BitSet(new long[]{0x0000000000341032L});
    public static final BitSet FOLLOW_21_in_e109 = new BitSet(new long[]{0x0000000000041030L});
    public static final BitSet FOLLOW_s_in_e111 = new BitSet(new long[]{0x0000000000141032L});
    public static final BitSet FOLLOW_20_in_e116 = new BitSet(new long[]{0x0000000000041030L});
    public static final BitSet FOLLOW_s_in_e117 = new BitSet(new long[]{0x0000000000041032L});

}
package reprotool.txtspec.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTxtSpecLexer extends Lexer {
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int RULE_WORD=4;
    public static final int T__7=7;
    public static final int T__6=6;

    // delegates
    // delegators

    public InternalTxtSpecLexer() {;} 
    public InternalTxtSpecLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalTxtSpecLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:11:6: ( '(' )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:11:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:12:6: ( ')' )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:12:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:527:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:527:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:527:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_WORD"
    public final void mRULE_WORD() throws RecognitionException {
        try {
            int _type = RULE_WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:529:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | ',' | '@' | '.' | '&' | ':' | '/' | '?' | '%' | ';' | '-' )+ )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:529:13: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | ',' | '@' | '.' | '&' | ':' | '/' | '?' | '%' | ';' | '-' )+
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:529:13: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | ',' | '@' | '.' | '&' | ':' | '/' | '?' | '%' | ';' | '-' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='%' && LA2_0<='&')||(LA2_0>=',' && LA2_0<=';')||(LA2_0>='?' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:
            	    {
            	    if ( (input.LA(1)>='%' && input.LA(1)<='&')||(input.LA(1)>=',' && input.LA(1)<=';')||(input.LA(1)>='?' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WORD"

    public void mTokens() throws RecognitionException {
        // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:1:8: ( T__6 | T__7 | RULE_WS | RULE_WORD )
        int alt3=4;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt3=1;
            }
            break;
        case ')':
            {
            alt3=2;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=3;
            }
            break;
        case '%':
        case '&':
        case ',':
        case '-':
        case '.':
        case '/':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case ':':
        case ';':
        case '?':
        case '@':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:1:10: T__6
                {
                mT__6(); 

                }
                break;
            case 2 :
                // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:1:15: T__7
                {
                mT__7(); 

                }
                break;
            case 3 :
                // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:1:20: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 4 :
                // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:1:28: RULE_WORD
                {
                mRULE_WORD(); 

                }
                break;

        }

    }


 

}
package reprotool.txtspec.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import reprotool.txtspec.services.TxtSpecGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTxtSpecParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WORD", "RULE_WS", "'('", "')'"
    };
    public static final int RULE_WS=5;
    public static final int EOF=-1;
    public static final int RULE_WORD=4;
    public static final int T__7=7;
    public static final int T__6=6;

    // delegates
    // delegators


        public InternalTxtSpecParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTxtSpecParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTxtSpecParser.tokenNames; }
    public String getGrammarFileName() { return "../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g"; }


     
     	private TxtSpecGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TxtSpecGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleDocument"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:61:1: entryRuleDocument : ruleDocument EOF ;
    public final void entryRuleDocument() throws RecognitionException {
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:62:1: ( ruleDocument EOF )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:63:1: ruleDocument EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentRule()); 
            }
            pushFollow(FOLLOW_ruleDocument_in_entryRuleDocument67);
            ruleDocument();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocument74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDocument"


    // $ANTLR start "ruleDocument"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:70:1: ruleDocument : ( ( rule__Document__BlocksAssignment )* ) ;
    public final void ruleDocument() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:74:2: ( ( ( rule__Document__BlocksAssignment )* ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:75:1: ( ( rule__Document__BlocksAssignment )* )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:75:1: ( ( rule__Document__BlocksAssignment )* )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:76:1: ( rule__Document__BlocksAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentAccess().getBlocksAssignment()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:77:1: ( rule__Document__BlocksAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WORD||LA1_0==6) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:77:2: rule__Document__BlocksAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Document__BlocksAssignment_in_ruleDocument100);
            	    rule__Document__BlocksAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentAccess().getBlocksAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDocument"


    // $ANTLR start "entryRuleBlock"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:89:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:90:1: ( ruleBlock EOF )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:91:1: ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock128);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock135); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:98:1: ruleBlock : ( ( rule__Block__Alternatives ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:102:2: ( ( ( rule__Block__Alternatives ) ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:103:1: ( ( rule__Block__Alternatives ) )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:103:1: ( ( rule__Block__Alternatives ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:104:1: ( rule__Block__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlockAccess().getAlternatives()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:105:1: ( rule__Block__Alternatives )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:105:2: rule__Block__Alternatives
            {
            pushFollow(FOLLOW_rule__Block__Alternatives_in_ruleBlock161);
            rule__Block__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlockAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleModelElementBlock"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:117:1: entryRuleModelElementBlock : ruleModelElementBlock EOF ;
    public final void entryRuleModelElementBlock() throws RecognitionException {
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:118:1: ( ruleModelElementBlock EOF )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:119:1: ruleModelElementBlock EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockRule()); 
            }
            pushFollow(FOLLOW_ruleModelElementBlock_in_entryRuleModelElementBlock188);
            ruleModelElementBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElementBlock195); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelElementBlock"


    // $ANTLR start "ruleModelElementBlock"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:126:1: ruleModelElementBlock : ( ( rule__ModelElementBlock__Group__0 ) ) ;
    public final void ruleModelElementBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:130:2: ( ( ( rule__ModelElementBlock__Group__0 ) ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:131:1: ( ( rule__ModelElementBlock__Group__0 ) )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:131:1: ( ( rule__ModelElementBlock__Group__0 ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:132:1: ( rule__ModelElementBlock__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockAccess().getGroup()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:133:1: ( rule__ModelElementBlock__Group__0 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:133:2: rule__ModelElementBlock__Group__0
            {
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__0_in_ruleModelElementBlock221);
            rule__ModelElementBlock__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelElementBlock"


    // $ANTLR start "entryRuleModelElementBlockContent"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:145:1: entryRuleModelElementBlockContent : ruleModelElementBlockContent EOF ;
    public final void entryRuleModelElementBlockContent() throws RecognitionException {
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:146:1: ( ruleModelElementBlockContent EOF )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:147:1: ruleModelElementBlockContent EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockContentRule()); 
            }
            pushFollow(FOLLOW_ruleModelElementBlockContent_in_entryRuleModelElementBlockContent248);
            ruleModelElementBlockContent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockContentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElementBlockContent255); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelElementBlockContent"


    // $ANTLR start "ruleModelElementBlockContent"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:154:1: ruleModelElementBlockContent : ( ( rule__ModelElementBlockContent__Group__0 ) ) ;
    public final void ruleModelElementBlockContent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:158:2: ( ( ( rule__ModelElementBlockContent__Group__0 ) ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:159:1: ( ( rule__ModelElementBlockContent__Group__0 ) )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:159:1: ( ( rule__ModelElementBlockContent__Group__0 ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:160:1: ( rule__ModelElementBlockContent__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockContentAccess().getGroup()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:161:1: ( rule__ModelElementBlockContent__Group__0 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:161:2: rule__ModelElementBlockContent__Group__0
            {
            pushFollow(FOLLOW_rule__ModelElementBlockContent__Group__0_in_ruleModelElementBlockContent281);
            rule__ModelElementBlockContent__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockContentAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelElementBlockContent"


    // $ANTLR start "entryRuleUrlParam"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:173:1: entryRuleUrlParam : ruleUrlParam EOF ;
    public final void entryRuleUrlParam() throws RecognitionException {
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:174:1: ( ruleUrlParam EOF )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:175:1: ruleUrlParam EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUrlParamRule()); 
            }
            pushFollow(FOLLOW_ruleUrlParam_in_entryRuleUrlParam308);
            ruleUrlParam();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUrlParamRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUrlParam315); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUrlParam"


    // $ANTLR start "ruleUrlParam"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:182:1: ruleUrlParam : ( RULE_WORD ) ;
    public final void ruleUrlParam() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:186:2: ( ( RULE_WORD ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:187:1: ( RULE_WORD )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:187:1: ( RULE_WORD )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:188:1: RULE_WORD
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUrlParamAccess().getWORDTerminalRuleCall()); 
            }
            match(input,RULE_WORD,FOLLOW_RULE_WORD_in_ruleUrlParam341); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUrlParamAccess().getWORDTerminalRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUrlParam"


    // $ANTLR start "entryRuleTextBlock"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:201:1: entryRuleTextBlock : ruleTextBlock EOF ;
    public final void entryRuleTextBlock() throws RecognitionException {
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:202:1: ( ruleTextBlock EOF )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:203:1: ruleTextBlock EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextBlockRule()); 
            }
            pushFollow(FOLLOW_ruleTextBlock_in_entryRuleTextBlock367);
            ruleTextBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextBlockRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextBlock374); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextBlock"


    // $ANTLR start "ruleTextBlock"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:210:1: ruleTextBlock : ( ( ( rule__TextBlock__WordsAssignment ) ) ( ( rule__TextBlock__WordsAssignment )* ) ) ;
    public final void ruleTextBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:214:2: ( ( ( ( rule__TextBlock__WordsAssignment ) ) ( ( rule__TextBlock__WordsAssignment )* ) ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:215:1: ( ( ( rule__TextBlock__WordsAssignment ) ) ( ( rule__TextBlock__WordsAssignment )* ) )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:215:1: ( ( ( rule__TextBlock__WordsAssignment ) ) ( ( rule__TextBlock__WordsAssignment )* ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:216:1: ( ( rule__TextBlock__WordsAssignment ) ) ( ( rule__TextBlock__WordsAssignment )* )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:216:1: ( ( rule__TextBlock__WordsAssignment ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:217:1: ( rule__TextBlock__WordsAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextBlockAccess().getWordsAssignment()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:218:1: ( rule__TextBlock__WordsAssignment )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:218:2: rule__TextBlock__WordsAssignment
            {
            pushFollow(FOLLOW_rule__TextBlock__WordsAssignment_in_ruleTextBlock402);
            rule__TextBlock__WordsAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextBlockAccess().getWordsAssignment()); 
            }

            }

            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:221:1: ( ( rule__TextBlock__WordsAssignment )* )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:222:1: ( rule__TextBlock__WordsAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextBlockAccess().getWordsAssignment()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:223:1: ( rule__TextBlock__WordsAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_WORD) ) {
                    int LA2_2 = input.LA(2);

                    if ( (synpred2_InternalTxtSpec()) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:223:2: rule__TextBlock__WordsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__TextBlock__WordsAssignment_in_ruleTextBlock414);
            	    rule__TextBlock__WordsAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextBlockAccess().getWordsAssignment()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextBlock"


    // $ANTLR start "rule__Block__Alternatives"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:236:1: rule__Block__Alternatives : ( ( ruleTextBlock ) | ( ruleModelElementBlock ) );
    public final void rule__Block__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:240:1: ( ( ruleTextBlock ) | ( ruleModelElementBlock ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WORD) ) {
                alt3=1;
            }
            else if ( (LA3_0==6) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:241:1: ( ruleTextBlock )
                    {
                    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:241:1: ( ruleTextBlock )
                    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:242:1: ruleTextBlock
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBlockAccess().getTextBlockParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleTextBlock_in_rule__Block__Alternatives453);
                    ruleTextBlock();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBlockAccess().getTextBlockParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:247:6: ( ruleModelElementBlock )
                    {
                    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:247:6: ( ruleModelElementBlock )
                    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:248:1: ruleModelElementBlock
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBlockAccess().getModelElementBlockParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleModelElementBlock_in_rule__Block__Alternatives470);
                    ruleModelElementBlock();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBlockAccess().getModelElementBlockParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Alternatives"


    // $ANTLR start "rule__ModelElementBlock__Group__0"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:260:1: rule__ModelElementBlock__Group__0 : rule__ModelElementBlock__Group__0__Impl rule__ModelElementBlock__Group__1 ;
    public final void rule__ModelElementBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:264:1: ( rule__ModelElementBlock__Group__0__Impl rule__ModelElementBlock__Group__1 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:265:2: rule__ModelElementBlock__Group__0__Impl rule__ModelElementBlock__Group__1
            {
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__0__Impl_in_rule__ModelElementBlock__Group__0500);
            rule__ModelElementBlock__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__1_in_rule__ModelElementBlock__Group__0503);
            rule__ModelElementBlock__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__0"


    // $ANTLR start "rule__ModelElementBlock__Group__0__Impl"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:272:1: rule__ModelElementBlock__Group__0__Impl : ( '(' ) ;
    public final void rule__ModelElementBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:276:1: ( ( '(' ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:277:1: ( '(' )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:277:1: ( '(' )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:278:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,6,FOLLOW_6_in_rule__ModelElementBlock__Group__0__Impl531); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockAccess().getLeftParenthesisKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__0__Impl"


    // $ANTLR start "rule__ModelElementBlock__Group__1"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:291:1: rule__ModelElementBlock__Group__1 : rule__ModelElementBlock__Group__1__Impl rule__ModelElementBlock__Group__2 ;
    public final void rule__ModelElementBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:295:1: ( rule__ModelElementBlock__Group__1__Impl rule__ModelElementBlock__Group__2 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:296:2: rule__ModelElementBlock__Group__1__Impl rule__ModelElementBlock__Group__2
            {
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__1__Impl_in_rule__ModelElementBlock__Group__1562);
            rule__ModelElementBlock__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__2_in_rule__ModelElementBlock__Group__1565);
            rule__ModelElementBlock__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__1"


    // $ANTLR start "rule__ModelElementBlock__Group__1__Impl"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:303:1: rule__ModelElementBlock__Group__1__Impl : ( ( rule__ModelElementBlock__UrlAssignment_1 ) ) ;
    public final void rule__ModelElementBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:307:1: ( ( ( rule__ModelElementBlock__UrlAssignment_1 ) ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:308:1: ( ( rule__ModelElementBlock__UrlAssignment_1 ) )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:308:1: ( ( rule__ModelElementBlock__UrlAssignment_1 ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:309:1: ( rule__ModelElementBlock__UrlAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockAccess().getUrlAssignment_1()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:310:1: ( rule__ModelElementBlock__UrlAssignment_1 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:310:2: rule__ModelElementBlock__UrlAssignment_1
            {
            pushFollow(FOLLOW_rule__ModelElementBlock__UrlAssignment_1_in_rule__ModelElementBlock__Group__1__Impl592);
            rule__ModelElementBlock__UrlAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockAccess().getUrlAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__1__Impl"


    // $ANTLR start "rule__ModelElementBlock__Group__2"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:320:1: rule__ModelElementBlock__Group__2 : rule__ModelElementBlock__Group__2__Impl rule__ModelElementBlock__Group__3 ;
    public final void rule__ModelElementBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:324:1: ( rule__ModelElementBlock__Group__2__Impl rule__ModelElementBlock__Group__3 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:325:2: rule__ModelElementBlock__Group__2__Impl rule__ModelElementBlock__Group__3
            {
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__2__Impl_in_rule__ModelElementBlock__Group__2622);
            rule__ModelElementBlock__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__3_in_rule__ModelElementBlock__Group__2625);
            rule__ModelElementBlock__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__2"


    // $ANTLR start "rule__ModelElementBlock__Group__2__Impl"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:332:1: rule__ModelElementBlock__Group__2__Impl : ( ( rule__ModelElementBlock__ContentAssignment_2 ) ) ;
    public final void rule__ModelElementBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:336:1: ( ( ( rule__ModelElementBlock__ContentAssignment_2 ) ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:337:1: ( ( rule__ModelElementBlock__ContentAssignment_2 ) )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:337:1: ( ( rule__ModelElementBlock__ContentAssignment_2 ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:338:1: ( rule__ModelElementBlock__ContentAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockAccess().getContentAssignment_2()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:339:1: ( rule__ModelElementBlock__ContentAssignment_2 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:339:2: rule__ModelElementBlock__ContentAssignment_2
            {
            pushFollow(FOLLOW_rule__ModelElementBlock__ContentAssignment_2_in_rule__ModelElementBlock__Group__2__Impl652);
            rule__ModelElementBlock__ContentAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockAccess().getContentAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__2__Impl"


    // $ANTLR start "rule__ModelElementBlock__Group__3"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:349:1: rule__ModelElementBlock__Group__3 : rule__ModelElementBlock__Group__3__Impl ;
    public final void rule__ModelElementBlock__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:353:1: ( rule__ModelElementBlock__Group__3__Impl )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:354:2: rule__ModelElementBlock__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModelElementBlock__Group__3__Impl_in_rule__ModelElementBlock__Group__3682);
            rule__ModelElementBlock__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__3"


    // $ANTLR start "rule__ModelElementBlock__Group__3__Impl"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:360:1: rule__ModelElementBlock__Group__3__Impl : ( ')' ) ;
    public final void rule__ModelElementBlock__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:364:1: ( ( ')' ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:365:1: ( ')' )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:365:1: ( ')' )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:366:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,7,FOLLOW_7_in_rule__ModelElementBlock__Group__3__Impl710); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__Group__3__Impl"


    // $ANTLR start "rule__ModelElementBlockContent__Group__0"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:387:1: rule__ModelElementBlockContent__Group__0 : rule__ModelElementBlockContent__Group__0__Impl rule__ModelElementBlockContent__Group__1 ;
    public final void rule__ModelElementBlockContent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:391:1: ( rule__ModelElementBlockContent__Group__0__Impl rule__ModelElementBlockContent__Group__1 )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:392:2: rule__ModelElementBlockContent__Group__0__Impl rule__ModelElementBlockContent__Group__1
            {
            pushFollow(FOLLOW_rule__ModelElementBlockContent__Group__0__Impl_in_rule__ModelElementBlockContent__Group__0749);
            rule__ModelElementBlockContent__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModelElementBlockContent__Group__1_in_rule__ModelElementBlockContent__Group__0752);
            rule__ModelElementBlockContent__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlockContent__Group__0"


    // $ANTLR start "rule__ModelElementBlockContent__Group__0__Impl"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:399:1: rule__ModelElementBlockContent__Group__0__Impl : ( () ) ;
    public final void rule__ModelElementBlockContent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:403:1: ( ( () ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:404:1: ( () )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:404:1: ( () )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:405:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockContentAccess().getModelElementBlockContentAction_0()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:406:1: ()
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:408:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockContentAccess().getModelElementBlockContentAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlockContent__Group__0__Impl"


    // $ANTLR start "rule__ModelElementBlockContent__Group__1"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:418:1: rule__ModelElementBlockContent__Group__1 : rule__ModelElementBlockContent__Group__1__Impl ;
    public final void rule__ModelElementBlockContent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:422:1: ( rule__ModelElementBlockContent__Group__1__Impl )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:423:2: rule__ModelElementBlockContent__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ModelElementBlockContent__Group__1__Impl_in_rule__ModelElementBlockContent__Group__1810);
            rule__ModelElementBlockContent__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlockContent__Group__1"


    // $ANTLR start "rule__ModelElementBlockContent__Group__1__Impl"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:429:1: rule__ModelElementBlockContent__Group__1__Impl : ( ( rule__ModelElementBlockContent__BlocksAssignment_1 )* ) ;
    public final void rule__ModelElementBlockContent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:433:1: ( ( ( rule__ModelElementBlockContent__BlocksAssignment_1 )* ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:434:1: ( ( rule__ModelElementBlockContent__BlocksAssignment_1 )* )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:434:1: ( ( rule__ModelElementBlockContent__BlocksAssignment_1 )* )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:435:1: ( rule__ModelElementBlockContent__BlocksAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockContentAccess().getBlocksAssignment_1()); 
            }
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:436:1: ( rule__ModelElementBlockContent__BlocksAssignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_WORD||LA4_0==6) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:436:2: rule__ModelElementBlockContent__BlocksAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__ModelElementBlockContent__BlocksAssignment_1_in_rule__ModelElementBlockContent__Group__1__Impl837);
            	    rule__ModelElementBlockContent__BlocksAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockContentAccess().getBlocksAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlockContent__Group__1__Impl"


    // $ANTLR start "rule__Document__BlocksAssignment"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:451:1: rule__Document__BlocksAssignment : ( ruleBlock ) ;
    public final void rule__Document__BlocksAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:455:1: ( ( ruleBlock ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:456:1: ( ruleBlock )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:456:1: ( ruleBlock )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:457:1: ruleBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDocumentAccess().getBlocksBlockParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleBlock_in_rule__Document__BlocksAssignment877);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDocumentAccess().getBlocksBlockParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Document__BlocksAssignment"


    // $ANTLR start "rule__ModelElementBlock__UrlAssignment_1"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:466:1: rule__ModelElementBlock__UrlAssignment_1 : ( ruleUrlParam ) ;
    public final void rule__ModelElementBlock__UrlAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:470:1: ( ( ruleUrlParam ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:471:1: ( ruleUrlParam )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:471:1: ( ruleUrlParam )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:472:1: ruleUrlParam
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockAccess().getUrlUrlParamParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleUrlParam_in_rule__ModelElementBlock__UrlAssignment_1908);
            ruleUrlParam();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockAccess().getUrlUrlParamParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__UrlAssignment_1"


    // $ANTLR start "rule__ModelElementBlock__ContentAssignment_2"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:481:1: rule__ModelElementBlock__ContentAssignment_2 : ( ruleModelElementBlockContent ) ;
    public final void rule__ModelElementBlock__ContentAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:485:1: ( ( ruleModelElementBlockContent ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:486:1: ( ruleModelElementBlockContent )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:486:1: ( ruleModelElementBlockContent )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:487:1: ruleModelElementBlockContent
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockAccess().getContentModelElementBlockContentParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleModelElementBlockContent_in_rule__ModelElementBlock__ContentAssignment_2939);
            ruleModelElementBlockContent();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockAccess().getContentModelElementBlockContentParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlock__ContentAssignment_2"


    // $ANTLR start "rule__ModelElementBlockContent__BlocksAssignment_1"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:496:1: rule__ModelElementBlockContent__BlocksAssignment_1 : ( ruleBlock ) ;
    public final void rule__ModelElementBlockContent__BlocksAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:500:1: ( ( ruleBlock ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:501:1: ( ruleBlock )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:501:1: ( ruleBlock )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:502:1: ruleBlock
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelElementBlockContentAccess().getBlocksBlockParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleBlock_in_rule__ModelElementBlockContent__BlocksAssignment_1970);
            ruleBlock();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelElementBlockContentAccess().getBlocksBlockParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementBlockContent__BlocksAssignment_1"


    // $ANTLR start "rule__TextBlock__WordsAssignment"
    // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:511:1: rule__TextBlock__WordsAssignment : ( RULE_WORD ) ;
    public final void rule__TextBlock__WordsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:515:1: ( ( RULE_WORD ) )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:516:1: ( RULE_WORD )
            {
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:516:1: ( RULE_WORD )
            // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:517:1: RULE_WORD
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTextBlockAccess().getWordsWORDTerminalRuleCall_0()); 
            }
            match(input,RULE_WORD,FOLLOW_RULE_WORD_in_rule__TextBlock__WordsAssignment1001); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTextBlockAccess().getWordsWORDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextBlock__WordsAssignment"

    // $ANTLR start synpred2_InternalTxtSpec
    public final void synpred2_InternalTxtSpec_fragment() throws RecognitionException {   
        // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:223:2: ( rule__TextBlock__WordsAssignment )
        // ../reprotool.txtspec.ui/src-gen/reprotool/txtspec/ui/contentassist/antlr/internal/InternalTxtSpec.g:223:2: rule__TextBlock__WordsAssignment
        {
        pushFollow(FOLLOW_rule__TextBlock__WordsAssignment_in_synpred2_InternalTxtSpec414);
        rule__TextBlock__WordsAssignment();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalTxtSpec

    // Delegated rules

    public final boolean synpred2_InternalTxtSpec() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalTxtSpec_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleDocument_in_entryRuleDocument67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocument74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Document__BlocksAssignment_in_ruleDocument100 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Alternatives_in_ruleBlock161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElementBlock_in_entryRuleModelElementBlock188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElementBlock195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__0_in_ruleModelElementBlock221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElementBlockContent_in_entryRuleModelElementBlockContent248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElementBlockContent255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlockContent__Group__0_in_ruleModelElementBlockContent281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUrlParam_in_entryRuleUrlParam308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUrlParam315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WORD_in_ruleUrlParam341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextBlock_in_entryRuleTextBlock367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextBlock374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TextBlock__WordsAssignment_in_ruleTextBlock402 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__TextBlock__WordsAssignment_in_ruleTextBlock414 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTextBlock_in_rule__Block__Alternatives453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElementBlock_in_rule__Block__Alternatives470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__0__Impl_in_rule__ModelElementBlock__Group__0500 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__1_in_rule__ModelElementBlock__Group__0503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_6_in_rule__ModelElementBlock__Group__0__Impl531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__1__Impl_in_rule__ModelElementBlock__Group__1562 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__2_in_rule__ModelElementBlock__Group__1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__UrlAssignment_1_in_rule__ModelElementBlock__Group__1__Impl592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__2__Impl_in_rule__ModelElementBlock__Group__2622 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__3_in_rule__ModelElementBlock__Group__2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__ContentAssignment_2_in_rule__ModelElementBlock__Group__2__Impl652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlock__Group__3__Impl_in_rule__ModelElementBlock__Group__3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_rule__ModelElementBlock__Group__3__Impl710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlockContent__Group__0__Impl_in_rule__ModelElementBlockContent__Group__0749 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule__ModelElementBlockContent__Group__1_in_rule__ModelElementBlockContent__Group__0752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlockContent__Group__1__Impl_in_rule__ModelElementBlockContent__Group__1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModelElementBlockContent__BlocksAssignment_1_in_rule__ModelElementBlockContent__Group__1__Impl837 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__Document__BlocksAssignment877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUrlParam_in_rule__ModelElementBlock__UrlAssignment_1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElementBlockContent_in_rule__ModelElementBlock__ContentAssignment_2939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__ModelElementBlockContent__BlocksAssignment_1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WORD_in_rule__TextBlock__WordsAssignment1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TextBlock__WordsAssignment_in_synpred2_InternalTxtSpec414 = new BitSet(new long[]{0x0000000000000002L});

}
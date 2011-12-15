package reprotool.txtspec.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import reprotool.txtspec.services.TxtSpecGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTxtSpecParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g"; }



     	private TxtSpecGrammarAccess grammarAccess;
     	
        public InternalTxtSpecParser(TokenStream input, TxtSpecGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Document";	
       	}
       	
       	@Override
       	protected TxtSpecGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleDocument"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:67:1: entryRuleDocument returns [EObject current=null] : iv_ruleDocument= ruleDocument EOF ;
    public final EObject entryRuleDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocument = null;


        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:68:2: (iv_ruleDocument= ruleDocument EOF )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:69:2: iv_ruleDocument= ruleDocument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDocumentRule()); 
            }
            pushFollow(FOLLOW_ruleDocument_in_entryRuleDocument75);
            iv_ruleDocument=ruleDocument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDocument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocument85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocument"


    // $ANTLR start "ruleDocument"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:76:1: ruleDocument returns [EObject current=null] : ( (lv_blocks_0_0= ruleBlock ) )* ;
    public final EObject ruleDocument() throws RecognitionException {
        EObject current = null;

        EObject lv_blocks_0_0 = null;


         enterRule(); 
            
        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:79:28: ( ( (lv_blocks_0_0= ruleBlock ) )* )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:80:1: ( (lv_blocks_0_0= ruleBlock ) )*
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:80:1: ( (lv_blocks_0_0= ruleBlock ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WORD||LA1_0==6) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:81:1: (lv_blocks_0_0= ruleBlock )
            	    {
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:81:1: (lv_blocks_0_0= ruleBlock )
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:82:3: lv_blocks_0_0= ruleBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDocumentAccess().getBlocksBlockParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBlock_in_ruleDocument130);
            	    lv_blocks_0_0=ruleBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDocumentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"blocks",
            	              		lv_blocks_0_0, 
            	              		"Block");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocument"


    // $ANTLR start "entryRuleBlock"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:106:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:107:2: (iv_ruleBlock= ruleBlock EOF )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:108:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock166);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock176); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:115:1: ruleBlock returns [EObject current=null] : (this_TextBlock_0= ruleTextBlock | this_ModelElementBlock_1= ruleModelElementBlock ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        EObject this_TextBlock_0 = null;

        EObject this_ModelElementBlock_1 = null;


         enterRule(); 
            
        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:118:28: ( (this_TextBlock_0= ruleTextBlock | this_ModelElementBlock_1= ruleModelElementBlock ) )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:119:1: (this_TextBlock_0= ruleTextBlock | this_ModelElementBlock_1= ruleModelElementBlock )
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:119:1: (this_TextBlock_0= ruleTextBlock | this_ModelElementBlock_1= ruleModelElementBlock )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WORD) ) {
                alt2=1;
            }
            else if ( (LA2_0==6) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:120:5: this_TextBlock_0= ruleTextBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBlockAccess().getTextBlockParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTextBlock_in_ruleBlock223);
                    this_TextBlock_0=ruleTextBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TextBlock_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:130:5: this_ModelElementBlock_1= ruleModelElementBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBlockAccess().getModelElementBlockParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleModelElementBlock_in_ruleBlock250);
                    this_ModelElementBlock_1=ruleModelElementBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ModelElementBlock_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleModelElementBlock"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:146:1: entryRuleModelElementBlock returns [EObject current=null] : iv_ruleModelElementBlock= ruleModelElementBlock EOF ;
    public final EObject entryRuleModelElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElementBlock = null;


        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:147:2: (iv_ruleModelElementBlock= ruleModelElementBlock EOF )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:148:2: iv_ruleModelElementBlock= ruleModelElementBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelElementBlockRule()); 
            }
            pushFollow(FOLLOW_ruleModelElementBlock_in_entryRuleModelElementBlock285);
            iv_ruleModelElementBlock=ruleModelElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelElementBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElementBlock295); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelElementBlock"


    // $ANTLR start "ruleModelElementBlock"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:155:1: ruleModelElementBlock returns [EObject current=null] : (otherlv_0= '(' ( (lv_url_1_0= ruleUrlParam ) ) ( (lv_content_2_0= ruleModelElementBlockContent ) ) otherlv_3= ')' ) ;
    public final EObject ruleModelElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_url_1_0 = null;

        EObject lv_content_2_0 = null;


         enterRule(); 
            
        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:158:28: ( (otherlv_0= '(' ( (lv_url_1_0= ruleUrlParam ) ) ( (lv_content_2_0= ruleModelElementBlockContent ) ) otherlv_3= ')' ) )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:159:1: (otherlv_0= '(' ( (lv_url_1_0= ruleUrlParam ) ) ( (lv_content_2_0= ruleModelElementBlockContent ) ) otherlv_3= ')' )
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:159:1: (otherlv_0= '(' ( (lv_url_1_0= ruleUrlParam ) ) ( (lv_content_2_0= ruleModelElementBlockContent ) ) otherlv_3= ')' )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:159:3: otherlv_0= '(' ( (lv_url_1_0= ruleUrlParam ) ) ( (lv_content_2_0= ruleModelElementBlockContent ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,6,FOLLOW_6_in_ruleModelElementBlock332); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModelElementBlockAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:163:1: ( (lv_url_1_0= ruleUrlParam ) )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:164:1: (lv_url_1_0= ruleUrlParam )
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:164:1: (lv_url_1_0= ruleUrlParam )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:165:3: lv_url_1_0= ruleUrlParam
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelElementBlockAccess().getUrlUrlParamParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUrlParam_in_ruleModelElementBlock353);
            lv_url_1_0=ruleUrlParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModelElementBlockRule());
              	        }
                     		set(
                     			current, 
                     			"url",
                      		lv_url_1_0, 
                      		"UrlParam");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:181:2: ( (lv_content_2_0= ruleModelElementBlockContent ) )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:182:1: (lv_content_2_0= ruleModelElementBlockContent )
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:182:1: (lv_content_2_0= ruleModelElementBlockContent )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:183:3: lv_content_2_0= ruleModelElementBlockContent
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelElementBlockAccess().getContentModelElementBlockContentParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleModelElementBlockContent_in_ruleModelElementBlock374);
            lv_content_2_0=ruleModelElementBlockContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModelElementBlockRule());
              	        }
                     		set(
                     			current, 
                     			"content",
                      		lv_content_2_0, 
                      		"ModelElementBlockContent");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,7,FOLLOW_7_in_ruleModelElementBlock386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModelElementBlockAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelElementBlock"


    // $ANTLR start "entryRuleModelElementBlockContent"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:211:1: entryRuleModelElementBlockContent returns [EObject current=null] : iv_ruleModelElementBlockContent= ruleModelElementBlockContent EOF ;
    public final EObject entryRuleModelElementBlockContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElementBlockContent = null;


        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:212:2: (iv_ruleModelElementBlockContent= ruleModelElementBlockContent EOF )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:213:2: iv_ruleModelElementBlockContent= ruleModelElementBlockContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelElementBlockContentRule()); 
            }
            pushFollow(FOLLOW_ruleModelElementBlockContent_in_entryRuleModelElementBlockContent422);
            iv_ruleModelElementBlockContent=ruleModelElementBlockContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModelElementBlockContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelElementBlockContent432); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelElementBlockContent"


    // $ANTLR start "ruleModelElementBlockContent"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:220:1: ruleModelElementBlockContent returns [EObject current=null] : ( () ( (lv_blocks_1_0= ruleBlock ) )* ) ;
    public final EObject ruleModelElementBlockContent() throws RecognitionException {
        EObject current = null;

        EObject lv_blocks_1_0 = null;


         enterRule(); 
            
        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:223:28: ( ( () ( (lv_blocks_1_0= ruleBlock ) )* ) )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:224:1: ( () ( (lv_blocks_1_0= ruleBlock ) )* )
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:224:1: ( () ( (lv_blocks_1_0= ruleBlock ) )* )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:224:2: () ( (lv_blocks_1_0= ruleBlock ) )*
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:224:2: ()
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:225:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getModelElementBlockContentAccess().getModelElementBlockContentAction_0(),
                          current);
                  
            }

            }

            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:230:2: ( (lv_blocks_1_0= ruleBlock ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WORD||LA3_0==6) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:231:1: (lv_blocks_1_0= ruleBlock )
            	    {
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:231:1: (lv_blocks_1_0= ruleBlock )
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:232:3: lv_blocks_1_0= ruleBlock
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelElementBlockContentAccess().getBlocksBlockParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBlock_in_ruleModelElementBlockContent487);
            	    lv_blocks_1_0=ruleBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelElementBlockContentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"blocks",
            	              		lv_blocks_1_0, 
            	              		"Block");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelElementBlockContent"


    // $ANTLR start "entryRuleUrlParam"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:256:1: entryRuleUrlParam returns [String current=null] : iv_ruleUrlParam= ruleUrlParam EOF ;
    public final String entryRuleUrlParam() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUrlParam = null;


        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:257:2: (iv_ruleUrlParam= ruleUrlParam EOF )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:258:2: iv_ruleUrlParam= ruleUrlParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUrlParamRule()); 
            }
            pushFollow(FOLLOW_ruleUrlParam_in_entryRuleUrlParam525);
            iv_ruleUrlParam=ruleUrlParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUrlParam.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUrlParam536); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUrlParam"


    // $ANTLR start "ruleUrlParam"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:265:1: ruleUrlParam returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_WORD_0= RULE_WORD ;
    public final AntlrDatatypeRuleToken ruleUrlParam() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WORD_0=null;

         enterRule(); 
            
        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:268:28: (this_WORD_0= RULE_WORD )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:269:5: this_WORD_0= RULE_WORD
            {
            this_WORD_0=(Token)match(input,RULE_WORD,FOLLOW_RULE_WORD_in_ruleUrlParam575); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_WORD_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_WORD_0, grammarAccess.getUrlParamAccess().getWORDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUrlParam"


    // $ANTLR start "entryRuleTextBlock"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:284:1: entryRuleTextBlock returns [EObject current=null] : iv_ruleTextBlock= ruleTextBlock EOF ;
    public final EObject entryRuleTextBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextBlock = null;


        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:285:2: (iv_ruleTextBlock= ruleTextBlock EOF )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:286:2: iv_ruleTextBlock= ruleTextBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTextBlockRule()); 
            }
            pushFollow(FOLLOW_ruleTextBlock_in_entryRuleTextBlock619);
            iv_ruleTextBlock=ruleTextBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTextBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextBlock629); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextBlock"


    // $ANTLR start "ruleTextBlock"
    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:293:1: ruleTextBlock returns [EObject current=null] : ( ( ( RULE_WORD ) )=> (lv_words_0_0= RULE_WORD ) )+ ;
    public final EObject ruleTextBlock() throws RecognitionException {
        EObject current = null;

        Token lv_words_0_0=null;

         enterRule(); 
            
        try {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:296:28: ( ( ( ( RULE_WORD ) )=> (lv_words_0_0= RULE_WORD ) )+ )
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:297:1: ( ( ( RULE_WORD ) )=> (lv_words_0_0= RULE_WORD ) )+
            {
            // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:297:1: ( ( ( RULE_WORD ) )=> (lv_words_0_0= RULE_WORD ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_WORD) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred1_InternalTxtSpec()) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:297:2: ( ( RULE_WORD ) )=> (lv_words_0_0= RULE_WORD )
            	    {
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:303:1: (lv_words_0_0= RULE_WORD )
            	    // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:304:3: lv_words_0_0= RULE_WORD
            	    {
            	    lv_words_0_0=(Token)match(input,RULE_WORD,FOLLOW_RULE_WORD_in_ruleTextBlock681); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_words_0_0, grammarAccess.getTextBlockAccess().getWordsWORDTerminalRuleCall_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getTextBlockRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"words",
            	              		lv_words_0_0, 
            	              		"WORD");
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextBlock"

    // $ANTLR start synpred1_InternalTxtSpec
    public final void synpred1_InternalTxtSpec_fragment() throws RecognitionException {   
        // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:297:2: ( ( RULE_WORD ) )
        // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:298:1: ( RULE_WORD )
        {
        // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:298:1: ( RULE_WORD )
        // ../reprotool.txtspec/src-gen/reprotool/txtspec/parser/antlr/internal/InternalTxtSpec.g:299:1: RULE_WORD
        {
        match(input,RULE_WORD,FOLLOW_RULE_WORD_in_synpred1_InternalTxtSpec667); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalTxtSpec

    // Delegated rules

    public final boolean synpred1_InternalTxtSpec() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalTxtSpec_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleDocument_in_entryRuleDocument75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocument85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleDocument130 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextBlock_in_ruleBlock223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElementBlock_in_ruleBlock250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElementBlock_in_entryRuleModelElementBlock285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElementBlock295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_6_in_ruleModelElementBlock332 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUrlParam_in_ruleModelElementBlock353 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleModelElementBlockContent_in_ruleModelElementBlock374 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_ruleModelElementBlock386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelElementBlockContent_in_entryRuleModelElementBlockContent422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelElementBlockContent432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleModelElementBlockContent487 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_ruleUrlParam_in_entryRuleUrlParam525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUrlParam536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WORD_in_ruleUrlParam575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextBlock_in_entryRuleTextBlock619 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextBlock629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WORD_in_ruleTextBlock681 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_WORD_in_synpred1_InternalTxtSpec667 = new BitSet(new long[]{0x0000000000000002L});

}
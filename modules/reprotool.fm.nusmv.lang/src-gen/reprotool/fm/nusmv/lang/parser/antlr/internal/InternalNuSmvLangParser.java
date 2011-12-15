package reprotool.fm.nusmv.lang.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import reprotool.fm.nusmv.lang.services.NuSmvLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNuSmvLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NUMBER", "RULE_INT", "RULE_SL_COMMENT_BODY", "RULE_SL_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'MODULE'", "'main'", "'('", "','", "')'", "'VAR'", "'IVAR'", "'FROZENVAR'", "':'", "';'", "'DEFINE'", "':='", "'CONSTANTS'", "'ASSIGN'", "'init'", "'next'", "'TRANS'", "'INIT'", "'INVAR'", "'FAIRNESS'", "'JUSTICE'", "'COMPASSION ('", "'INVARSPEC'", "'CTLSPEC'", "'SPEC'", "'NAME'", "'LTLSPEC'", "'boolean'", "'word'", "'['", "']'", "'unsigned'", "'signed word'", "'{'", "'}'", "'..'", "'array'", "'of'", "'process'", "'case'", "'esac'", "'E'", "'A'", "'word1'", "'bool'", "'TRUE'", "'FALSE'", "'U'", "'V'", "'S'", "'T'", "'->'", "'<->'", "'&'", "'|'", "'xor'", "'xnor'", "'='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'::'", "'<<'", "'>>'", "'union'", "'in'", "'mod'", "'!'", "'X'", "'G'", "'F'", "'Y'", "'Z'", "'H'", "'O'", "'EG'", "'EX'", "'EF'", "'AG'", "'AX'", "'AF'", "'self'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT_BODY=7;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_STRING=9;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_NUMBER=5;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalNuSmvLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNuSmvLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNuSmvLangParser.tokenNames; }
    public String getGrammarFileName() { return "../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g"; }



     	private NuSmvLangGrammarAccess grammarAccess;
     	
        public InternalNuSmvLangParser(TokenStream input, NuSmvLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected NuSmvLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:72:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel91); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:82:1: ruleModel returns [EObject current=null] : ( (lv_modules_0_0= ruleModule ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_modules_0_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:86:28: ( ( (lv_modules_0_0= ruleModule ) )* )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:87:1: ( (lv_modules_0_0= ruleModule ) )*
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:87:1: ( (lv_modules_0_0= ruleModule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:88:1: (lv_modules_0_0= ruleModule )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:88:1: (lv_modules_0_0= ruleModule )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:89:3: lv_modules_0_0= ruleModule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getModulesModuleParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModule_in_ruleModel140);
            	    lv_modules_0_0=ruleModule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modules",
            	            		lv_modules_0_0, 
            	            		"Module");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModule"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:116:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:117:2: (iv_ruleModule= ruleModule EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:118:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule180);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule190); 

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
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:125:1: ruleModule returns [EObject current=null] : (otherlv_0= 'MODULE' (this_MainModule_1= ruleMainModule | this_OtherModule_2= ruleOtherModule ) ( (lv_moduleElement_3_0= ruleModuleElement ) )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_MainModule_1 = null;

        EObject this_OtherModule_2 = null;

        EObject lv_moduleElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:128:28: ( (otherlv_0= 'MODULE' (this_MainModule_1= ruleMainModule | this_OtherModule_2= ruleOtherModule ) ( (lv_moduleElement_3_0= ruleModuleElement ) )* ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:129:1: (otherlv_0= 'MODULE' (this_MainModule_1= ruleMainModule | this_OtherModule_2= ruleOtherModule ) ( (lv_moduleElement_3_0= ruleModuleElement ) )* )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:129:1: (otherlv_0= 'MODULE' (this_MainModule_1= ruleMainModule | this_OtherModule_2= ruleOtherModule ) ( (lv_moduleElement_3_0= ruleModuleElement ) )* )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:129:3: otherlv_0= 'MODULE' (this_MainModule_1= ruleMainModule | this_OtherModule_2= ruleOtherModule ) ( (lv_moduleElement_3_0= ruleModuleElement ) )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleModule227); 

                	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getMODULEKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:133:1: (this_MainModule_1= ruleMainModule | this_OtherModule_2= ruleOtherModule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:134:5: this_MainModule_1= ruleMainModule
                    {
                     
                            newCompositeNode(grammarAccess.getModuleAccess().getMainModuleParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleMainModule_in_ruleModule250);
                    this_MainModule_1=ruleMainModule();

                    state._fsp--;

                     
                            current = this_MainModule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:144:5: this_OtherModule_2= ruleOtherModule
                    {
                     
                            newCompositeNode(grammarAccess.getModuleAccess().getOtherModuleParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleOtherModule_in_ruleModule277);
                    this_OtherModule_2=ruleOtherModule();

                    state._fsp--;

                     
                            current = this_OtherModule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:152:2: ( (lv_moduleElement_3_0= ruleModuleElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=18 && LA3_0<=20)||LA3_0==23||(LA3_0>=25 && LA3_0<=26)||(LA3_0>=29 && LA3_0<=37)||LA3_0==39) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:153:1: (lv_moduleElement_3_0= ruleModuleElement )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:153:1: (lv_moduleElement_3_0= ruleModuleElement )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:154:3: lv_moduleElement_3_0= ruleModuleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleAccess().getModuleElementModuleElementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModuleElement_in_ruleModule298);
            	    lv_moduleElement_3_0=ruleModuleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"moduleElement",
            	            		lv_moduleElement_3_0, 
            	            		"ModuleElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleMainModule"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:178:1: entryRuleMainModule returns [EObject current=null] : iv_ruleMainModule= ruleMainModule EOF ;
    public final EObject entryRuleMainModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMainModule = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:179:2: (iv_ruleMainModule= ruleMainModule EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:180:2: iv_ruleMainModule= ruleMainModule EOF
            {
             newCompositeNode(grammarAccess.getMainModuleRule()); 
            pushFollow(FOLLOW_ruleMainModule_in_entryRuleMainModule335);
            iv_ruleMainModule=ruleMainModule();

            state._fsp--;

             current =iv_ruleMainModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMainModule345); 

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
    // $ANTLR end "entryRuleMainModule"


    // $ANTLR start "ruleMainModule"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:187:1: ruleMainModule returns [EObject current=null] : ( (lv_name_0_0= 'main' ) ) ;
    public final EObject ruleMainModule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:190:28: ( ( (lv_name_0_0= 'main' ) ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:191:1: ( (lv_name_0_0= 'main' ) )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:191:1: ( (lv_name_0_0= 'main' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:192:1: (lv_name_0_0= 'main' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:192:1: (lv_name_0_0= 'main' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:193:3: lv_name_0_0= 'main'
            {
            lv_name_0_0=(Token)match(input,14,FOLLOW_14_in_ruleMainModule387); 

                    newLeafNode(lv_name_0_0, grammarAccess.getMainModuleAccess().getNameMainKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMainModuleRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "main");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMainModule"


    // $ANTLR start "entryRuleOtherModule"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:214:1: entryRuleOtherModule returns [EObject current=null] : iv_ruleOtherModule= ruleOtherModule EOF ;
    public final EObject entryRuleOtherModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherModule = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:215:2: (iv_ruleOtherModule= ruleOtherModule EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:216:2: iv_ruleOtherModule= ruleOtherModule EOF
            {
             newCompositeNode(grammarAccess.getOtherModuleRule()); 
            pushFollow(FOLLOW_ruleOtherModule_in_entryRuleOtherModule435);
            iv_ruleOtherModule=ruleOtherModule();

            state._fsp--;

             current =iv_ruleOtherModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOtherModule445); 

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
    // $ANTLR end "entryRuleOtherModule"


    // $ANTLR start "ruleOtherModule"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:223:1: ruleOtherModule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_params_2_0= ruleFormalParameter ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )* otherlv_5= ')' )? ) ;
    public final EObject ruleOtherModule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:226:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_params_2_0= ruleFormalParameter ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )* otherlv_5= ')' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:227:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_params_2_0= ruleFormalParameter ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )* otherlv_5= ')' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:227:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_params_2_0= ruleFormalParameter ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )* otherlv_5= ')' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:227:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_params_2_0= ruleFormalParameter ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )* otherlv_5= ')' )?
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:227:2: ( (lv_name_0_0= RULE_ID ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:228:1: (lv_name_0_0= RULE_ID )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:228:1: (lv_name_0_0= RULE_ID )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:229:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOtherModule487); 

            			newLeafNode(lv_name_0_0, grammarAccess.getOtherModuleAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOtherModuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:245:2: (otherlv_1= '(' ( (lv_params_2_0= ruleFormalParameter ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )* otherlv_5= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:245:4: otherlv_1= '(' ( (lv_params_2_0= ruleFormalParameter ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )* otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleOtherModule505); 

                        	newLeafNode(otherlv_1, grammarAccess.getOtherModuleAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:249:1: ( (lv_params_2_0= ruleFormalParameter ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:250:1: (lv_params_2_0= ruleFormalParameter )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:250:1: (lv_params_2_0= ruleFormalParameter )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:251:3: lv_params_2_0= ruleFormalParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getOtherModuleAccess().getParamsFormalParameterParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormalParameter_in_ruleOtherModule526);
                    lv_params_2_0=ruleFormalParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOtherModuleRule());
                    	        }
                           		add(
                           			current, 
                           			"params",
                            		lv_params_2_0, 
                            		"FormalParameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:267:2: (otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==16) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:267:4: otherlv_3= ',' ( (lv_params_4_0= ruleFormalParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleOtherModule539); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getOtherModuleAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:271:1: ( (lv_params_4_0= ruleFormalParameter ) )
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:272:1: (lv_params_4_0= ruleFormalParameter )
                    	    {
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:272:1: (lv_params_4_0= ruleFormalParameter )
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:273:3: lv_params_4_0= ruleFormalParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getOtherModuleAccess().getParamsFormalParameterParserRuleCall_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFormalParameter_in_ruleOtherModule560);
                    	    lv_params_4_0=ruleFormalParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getOtherModuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"params",
                    	            		lv_params_4_0, 
                    	            		"FormalParameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleOtherModule574); 

                        	newLeafNode(otherlv_5, grammarAccess.getOtherModuleAccess().getRightParenthesisKeyword_1_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherModule"


    // $ANTLR start "entryRuleModuleElement"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:301:1: entryRuleModuleElement returns [EObject current=null] : iv_ruleModuleElement= ruleModuleElement EOF ;
    public final EObject entryRuleModuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleElement = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:305:2: (iv_ruleModuleElement= ruleModuleElement EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:306:2: iv_ruleModuleElement= ruleModuleElement EOF
            {
             newCompositeNode(grammarAccess.getModuleElementRule()); 
            pushFollow(FOLLOW_ruleModuleElement_in_entryRuleModuleElement618);
            iv_ruleModuleElement=ruleModuleElement();

            state._fsp--;

             current =iv_ruleModuleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleElement628); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleModuleElement"


    // $ANTLR start "ruleModuleElement"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:316:1: ruleModuleElement returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_IVariableDeclaration_1= ruleIVariableDeclaration | this_FrozenVariableDeclaration_2= ruleFrozenVariableDeclaration | this_DefineDeclaration_3= ruleDefineDeclaration | this_ConstantsDeclaration_4= ruleConstantsDeclaration | this_AssignConstraint_5= ruleAssignConstraint | this_TransConstraint_6= ruleTransConstraint | this_InitConstraint_7= ruleInitConstraint | this_InvarConstraint_8= ruleInvarConstraint | this_FairnessConstraint_9= ruleFairnessConstraint | this_CtlSpecification_10= ruleCtlSpecification | this_LtlSpecification_11= ruleLtlSpecification | this_InvarSpecification_12= ruleInvarSpecification ) ;
    public final EObject ruleModuleElement() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_IVariableDeclaration_1 = null;

        EObject this_FrozenVariableDeclaration_2 = null;

        EObject this_DefineDeclaration_3 = null;

        EObject this_ConstantsDeclaration_4 = null;

        EObject this_AssignConstraint_5 = null;

        EObject this_TransConstraint_6 = null;

        EObject this_InitConstraint_7 = null;

        EObject this_InvarConstraint_8 = null;

        EObject this_FairnessConstraint_9 = null;

        EObject this_CtlSpecification_10 = null;

        EObject this_LtlSpecification_11 = null;

        EObject this_InvarSpecification_12 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:320:28: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_IVariableDeclaration_1= ruleIVariableDeclaration | this_FrozenVariableDeclaration_2= ruleFrozenVariableDeclaration | this_DefineDeclaration_3= ruleDefineDeclaration | this_ConstantsDeclaration_4= ruleConstantsDeclaration | this_AssignConstraint_5= ruleAssignConstraint | this_TransConstraint_6= ruleTransConstraint | this_InitConstraint_7= ruleInitConstraint | this_InvarConstraint_8= ruleInvarConstraint | this_FairnessConstraint_9= ruleFairnessConstraint | this_CtlSpecification_10= ruleCtlSpecification | this_LtlSpecification_11= ruleLtlSpecification | this_InvarSpecification_12= ruleInvarSpecification ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:321:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_IVariableDeclaration_1= ruleIVariableDeclaration | this_FrozenVariableDeclaration_2= ruleFrozenVariableDeclaration | this_DefineDeclaration_3= ruleDefineDeclaration | this_ConstantsDeclaration_4= ruleConstantsDeclaration | this_AssignConstraint_5= ruleAssignConstraint | this_TransConstraint_6= ruleTransConstraint | this_InitConstraint_7= ruleInitConstraint | this_InvarConstraint_8= ruleInvarConstraint | this_FairnessConstraint_9= ruleFairnessConstraint | this_CtlSpecification_10= ruleCtlSpecification | this_LtlSpecification_11= ruleLtlSpecification | this_InvarSpecification_12= ruleInvarSpecification )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:321:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_IVariableDeclaration_1= ruleIVariableDeclaration | this_FrozenVariableDeclaration_2= ruleFrozenVariableDeclaration | this_DefineDeclaration_3= ruleDefineDeclaration | this_ConstantsDeclaration_4= ruleConstantsDeclaration | this_AssignConstraint_5= ruleAssignConstraint | this_TransConstraint_6= ruleTransConstraint | this_InitConstraint_7= ruleInitConstraint | this_InvarConstraint_8= ruleInvarConstraint | this_FairnessConstraint_9= ruleFairnessConstraint | this_CtlSpecification_10= ruleCtlSpecification | this_LtlSpecification_11= ruleLtlSpecification | this_InvarSpecification_12= ruleInvarSpecification )
            int alt6=13;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt6=1;
                }
                break;
            case 19:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=3;
                }
                break;
            case 23:
                {
                alt6=4;
                }
                break;
            case 25:
                {
                alt6=5;
                }
                break;
            case 26:
                {
                alt6=6;
                }
                break;
            case 29:
                {
                alt6=7;
                }
                break;
            case 30:
                {
                alt6=8;
                }
                break;
            case 31:
                {
                alt6=9;
                }
                break;
            case 32:
            case 33:
            case 34:
                {
                alt6=10;
                }
                break;
            case 36:
            case 37:
                {
                alt6=11;
                }
                break;
            case 39:
                {
                alt6=12;
                }
                break;
            case 35:
                {
                alt6=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:322:5: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getVariableDeclarationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleModuleElement679);
                    this_VariableDeclaration_0=ruleVariableDeclaration();

                    state._fsp--;

                     
                            current = this_VariableDeclaration_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:332:5: this_IVariableDeclaration_1= ruleIVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getIVariableDeclarationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIVariableDeclaration_in_ruleModuleElement706);
                    this_IVariableDeclaration_1=ruleIVariableDeclaration();

                    state._fsp--;

                     
                            current = this_IVariableDeclaration_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:342:5: this_FrozenVariableDeclaration_2= ruleFrozenVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getFrozenVariableDeclarationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleFrozenVariableDeclaration_in_ruleModuleElement733);
                    this_FrozenVariableDeclaration_2=ruleFrozenVariableDeclaration();

                    state._fsp--;

                     
                            current = this_FrozenVariableDeclaration_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:352:5: this_DefineDeclaration_3= ruleDefineDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getDefineDeclarationParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDefineDeclaration_in_ruleModuleElement760);
                    this_DefineDeclaration_3=ruleDefineDeclaration();

                    state._fsp--;

                     
                            current = this_DefineDeclaration_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:362:5: this_ConstantsDeclaration_4= ruleConstantsDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getConstantsDeclarationParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleConstantsDeclaration_in_ruleModuleElement787);
                    this_ConstantsDeclaration_4=ruleConstantsDeclaration();

                    state._fsp--;

                     
                            current = this_ConstantsDeclaration_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:372:5: this_AssignConstraint_5= ruleAssignConstraint
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getAssignConstraintParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleAssignConstraint_in_ruleModuleElement814);
                    this_AssignConstraint_5=ruleAssignConstraint();

                    state._fsp--;

                     
                            current = this_AssignConstraint_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:382:5: this_TransConstraint_6= ruleTransConstraint
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getTransConstraintParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleTransConstraint_in_ruleModuleElement841);
                    this_TransConstraint_6=ruleTransConstraint();

                    state._fsp--;

                     
                            current = this_TransConstraint_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:392:5: this_InitConstraint_7= ruleInitConstraint
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getInitConstraintParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleInitConstraint_in_ruleModuleElement868);
                    this_InitConstraint_7=ruleInitConstraint();

                    state._fsp--;

                     
                            current = this_InitConstraint_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:402:5: this_InvarConstraint_8= ruleInvarConstraint
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getInvarConstraintParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleInvarConstraint_in_ruleModuleElement895);
                    this_InvarConstraint_8=ruleInvarConstraint();

                    state._fsp--;

                     
                            current = this_InvarConstraint_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:412:5: this_FairnessConstraint_9= ruleFairnessConstraint
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getFairnessConstraintParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleFairnessConstraint_in_ruleModuleElement922);
                    this_FairnessConstraint_9=ruleFairnessConstraint();

                    state._fsp--;

                     
                            current = this_FairnessConstraint_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:422:5: this_CtlSpecification_10= ruleCtlSpecification
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getCtlSpecificationParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleCtlSpecification_in_ruleModuleElement949);
                    this_CtlSpecification_10=ruleCtlSpecification();

                    state._fsp--;

                     
                            current = this_CtlSpecification_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:432:5: this_LtlSpecification_11= ruleLtlSpecification
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getLtlSpecificationParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleLtlSpecification_in_ruleModuleElement976);
                    this_LtlSpecification_11=ruleLtlSpecification();

                    state._fsp--;

                     
                            current = this_LtlSpecification_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:442:5: this_InvarSpecification_12= ruleInvarSpecification
                    {
                     
                            newCompositeNode(grammarAccess.getModuleElementAccess().getInvarSpecificationParserRuleCall_12()); 
                        
                    pushFollow(FOLLOW_ruleInvarSpecification_in_ruleModuleElement1003);
                    this_InvarSpecification_12=ruleInvarSpecification();

                    state._fsp--;

                     
                            current = this_InvarSpecification_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleModuleElement"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:461:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:465:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:466:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1048);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration1058); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:476:1: ruleVariableDeclaration returns [EObject current=null] : (otherlv_0= 'VAR' ( (lv_vars_1_0= ruleVarBody ) )+ ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_vars_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:480:28: ( (otherlv_0= 'VAR' ( (lv_vars_1_0= ruleVarBody ) )+ ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:481:1: (otherlv_0= 'VAR' ( (lv_vars_1_0= ruleVarBody ) )+ )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:481:1: (otherlv_0= 'VAR' ( (lv_vars_1_0= ruleVarBody ) )+ )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:481:3: otherlv_0= 'VAR' ( (lv_vars_1_0= ruleVarBody ) )+
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleVariableDeclaration1099); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableDeclarationAccess().getVARKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:485:1: ( (lv_vars_1_0= ruleVarBody ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:486:1: (lv_vars_1_0= ruleVarBody )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:486:1: (lv_vars_1_0= ruleVarBody )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:487:3: lv_vars_1_0= ruleVarBody
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getVarsVarBodyParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVarBody_in_ruleVariableDeclaration1120);
            	    lv_vars_1_0=ruleVarBody();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"vars",
            	            		lv_vars_1_0, 
            	            		"VarBody");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleIVariableDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:514:1: entryRuleIVariableDeclaration returns [EObject current=null] : iv_ruleIVariableDeclaration= ruleIVariableDeclaration EOF ;
    public final EObject entryRuleIVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIVariableDeclaration = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:518:2: (iv_ruleIVariableDeclaration= ruleIVariableDeclaration EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:519:2: iv_ruleIVariableDeclaration= ruleIVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getIVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleIVariableDeclaration_in_entryRuleIVariableDeclaration1167);
            iv_ruleIVariableDeclaration=ruleIVariableDeclaration();

            state._fsp--;

             current =iv_ruleIVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIVariableDeclaration1177); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleIVariableDeclaration"


    // $ANTLR start "ruleIVariableDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:529:1: ruleIVariableDeclaration returns [EObject current=null] : (otherlv_0= 'IVAR' ( (lv_vars_1_0= ruleVarBody ) )+ ) ;
    public final EObject ruleIVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_vars_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:533:28: ( (otherlv_0= 'IVAR' ( (lv_vars_1_0= ruleVarBody ) )+ ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:534:1: (otherlv_0= 'IVAR' ( (lv_vars_1_0= ruleVarBody ) )+ )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:534:1: (otherlv_0= 'IVAR' ( (lv_vars_1_0= ruleVarBody ) )+ )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:534:3: otherlv_0= 'IVAR' ( (lv_vars_1_0= ruleVarBody ) )+
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleIVariableDeclaration1218); 

                	newLeafNode(otherlv_0, grammarAccess.getIVariableDeclarationAccess().getIVARKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:538:1: ( (lv_vars_1_0= ruleVarBody ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:539:1: (lv_vars_1_0= ruleVarBody )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:539:1: (lv_vars_1_0= ruleVarBody )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:540:3: lv_vars_1_0= ruleVarBody
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getIVariableDeclarationAccess().getVarsVarBodyParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVarBody_in_ruleIVariableDeclaration1239);
            	    lv_vars_1_0=ruleVarBody();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getIVariableDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"vars",
            	            		lv_vars_1_0, 
            	            		"VarBody");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleIVariableDeclaration"


    // $ANTLR start "entryRuleFrozenVariableDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:567:1: entryRuleFrozenVariableDeclaration returns [EObject current=null] : iv_ruleFrozenVariableDeclaration= ruleFrozenVariableDeclaration EOF ;
    public final EObject entryRuleFrozenVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFrozenVariableDeclaration = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:571:2: (iv_ruleFrozenVariableDeclaration= ruleFrozenVariableDeclaration EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:572:2: iv_ruleFrozenVariableDeclaration= ruleFrozenVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getFrozenVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleFrozenVariableDeclaration_in_entryRuleFrozenVariableDeclaration1286);
            iv_ruleFrozenVariableDeclaration=ruleFrozenVariableDeclaration();

            state._fsp--;

             current =iv_ruleFrozenVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFrozenVariableDeclaration1296); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFrozenVariableDeclaration"


    // $ANTLR start "ruleFrozenVariableDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:582:1: ruleFrozenVariableDeclaration returns [EObject current=null] : (otherlv_0= 'FROZENVAR' ( (lv_vars_1_0= ruleVarBody ) )+ ) ;
    public final EObject ruleFrozenVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_vars_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:586:28: ( (otherlv_0= 'FROZENVAR' ( (lv_vars_1_0= ruleVarBody ) )+ ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:587:1: (otherlv_0= 'FROZENVAR' ( (lv_vars_1_0= ruleVarBody ) )+ )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:587:1: (otherlv_0= 'FROZENVAR' ( (lv_vars_1_0= ruleVarBody ) )+ )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:587:3: otherlv_0= 'FROZENVAR' ( (lv_vars_1_0= ruleVarBody ) )+
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleFrozenVariableDeclaration1337); 

                	newLeafNode(otherlv_0, grammarAccess.getFrozenVariableDeclarationAccess().getFROZENVARKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:591:1: ( (lv_vars_1_0= ruleVarBody ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:592:1: (lv_vars_1_0= ruleVarBody )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:592:1: (lv_vars_1_0= ruleVarBody )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:593:3: lv_vars_1_0= ruleVarBody
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFrozenVariableDeclarationAccess().getVarsVarBodyParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVarBody_in_ruleFrozenVariableDeclaration1358);
            	    lv_vars_1_0=ruleVarBody();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFrozenVariableDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"vars",
            	            		lv_vars_1_0, 
            	            		"VarBody");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFrozenVariableDeclaration"


    // $ANTLR start "entryRuleVarBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:620:1: entryRuleVarBody returns [EObject current=null] : iv_ruleVarBody= ruleVarBody EOF ;
    public final EObject entryRuleVarBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:624:2: (iv_ruleVarBody= ruleVarBody EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:625:2: iv_ruleVarBody= ruleVarBody EOF
            {
             newCompositeNode(grammarAccess.getVarBodyRule()); 
            pushFollow(FOLLOW_ruleVarBody_in_entryRuleVarBody1405);
            iv_ruleVarBody=ruleVarBody();

            state._fsp--;

             current =iv_ruleVarBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarBody1415); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVarBody"


    // $ANTLR start "ruleVarBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:635:1: ruleVarBody returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeSpecifier ) ) otherlv_3= ';' ) ;
    public final EObject ruleVarBody() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:639:28: ( ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeSpecifier ) ) otherlv_3= ';' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:640:1: ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeSpecifier ) ) otherlv_3= ';' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:640:1: ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeSpecifier ) ) otherlv_3= ';' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:640:2: ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeSpecifier ) ) otherlv_3= ';'
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:640:2: ( (lv_varId_0_0= RULE_ID ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:641:1: (lv_varId_0_0= RULE_ID )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:641:1: (lv_varId_0_0= RULE_ID )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:642:3: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarBody1461); 

            			newLeafNode(lv_varId_0_0, grammarAccess.getVarBodyAccess().getVarIdIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVarBodyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"varId",
                    		lv_varId_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleVarBody1478); 

                	newLeafNode(otherlv_1, grammarAccess.getVarBodyAccess().getColonKeyword_1());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:662:1: ( (lv_type_2_0= ruleTypeSpecifier ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:663:1: (lv_type_2_0= ruleTypeSpecifier )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:663:1: (lv_type_2_0= ruleTypeSpecifier )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:664:3: lv_type_2_0= ruleTypeSpecifier
            {
             
            	        newCompositeNode(grammarAccess.getVarBodyAccess().getTypeTypeSpecifierParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeSpecifier_in_ruleVarBody1499);
            lv_type_2_0=ruleTypeSpecifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVarBodyRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_2_0, 
                    		"TypeSpecifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleVarBody1511); 

                	newLeafNode(otherlv_3, grammarAccess.getVarBodyAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVarBody"


    // $ANTLR start "entryRuleDefineDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:695:1: entryRuleDefineDeclaration returns [EObject current=null] : iv_ruleDefineDeclaration= ruleDefineDeclaration EOF ;
    public final EObject entryRuleDefineDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineDeclaration = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:699:2: (iv_ruleDefineDeclaration= ruleDefineDeclaration EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:700:2: iv_ruleDefineDeclaration= ruleDefineDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDefineDeclarationRule()); 
            pushFollow(FOLLOW_ruleDefineDeclaration_in_entryRuleDefineDeclaration1557);
            iv_ruleDefineDeclaration=ruleDefineDeclaration();

            state._fsp--;

             current =iv_ruleDefineDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefineDeclaration1567); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDefineDeclaration"


    // $ANTLR start "ruleDefineDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:710:1: ruleDefineDeclaration returns [EObject current=null] : (otherlv_0= 'DEFINE' ( (lv_defineBodies_1_0= ruleDefineBody ) )+ ) ;
    public final EObject ruleDefineDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_defineBodies_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:714:28: ( (otherlv_0= 'DEFINE' ( (lv_defineBodies_1_0= ruleDefineBody ) )+ ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:715:1: (otherlv_0= 'DEFINE' ( (lv_defineBodies_1_0= ruleDefineBody ) )+ )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:715:1: (otherlv_0= 'DEFINE' ( (lv_defineBodies_1_0= ruleDefineBody ) )+ )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:715:3: otherlv_0= 'DEFINE' ( (lv_defineBodies_1_0= ruleDefineBody ) )+
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleDefineDeclaration1608); 

                	newLeafNode(otherlv_0, grammarAccess.getDefineDeclarationAccess().getDEFINEKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:719:1: ( (lv_defineBodies_1_0= ruleDefineBody ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:720:1: (lv_defineBodies_1_0= ruleDefineBody )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:720:1: (lv_defineBodies_1_0= ruleDefineBody )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:721:3: lv_defineBodies_1_0= ruleDefineBody
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDefineDeclarationAccess().getDefineBodiesDefineBodyParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefineBody_in_ruleDefineDeclaration1629);
            	    lv_defineBodies_1_0=ruleDefineBody();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDefineDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"defineBodies",
            	            		lv_defineBodies_1_0, 
            	            		"DefineBody");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDefineDeclaration"


    // $ANTLR start "entryRuleDefineBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:748:1: entryRuleDefineBody returns [EObject current=null] : iv_ruleDefineBody= ruleDefineBody EOF ;
    public final EObject entryRuleDefineBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:752:2: (iv_ruleDefineBody= ruleDefineBody EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:753:2: iv_ruleDefineBody= ruleDefineBody EOF
            {
             newCompositeNode(grammarAccess.getDefineBodyRule()); 
            pushFollow(FOLLOW_ruleDefineBody_in_entryRuleDefineBody1676);
            iv_ruleDefineBody=ruleDefineBody();

            state._fsp--;

             current =iv_ruleDefineBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefineBody1686); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDefineBody"


    // $ANTLR start "ruleDefineBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:763:1: ruleDefineBody returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleDefineBody() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_assignment_2_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:767:28: ( ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:768:1: ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:768:1: ( ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:768:2: ( (lv_varId_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';'
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:768:2: ( (lv_varId_0_0= RULE_ID ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:769:1: (lv_varId_0_0= RULE_ID )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:769:1: (lv_varId_0_0= RULE_ID )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:770:3: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefineBody1732); 

            			newLeafNode(lv_varId_0_0, grammarAccess.getDefineBodyAccess().getVarIdIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefineBodyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"varId",
                    		lv_varId_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleDefineBody1749); 

                	newLeafNode(otherlv_1, grammarAccess.getDefineBodyAccess().getColonEqualsSignKeyword_1());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:790:1: ( (lv_assignment_2_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:791:1: (lv_assignment_2_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:791:1: (lv_assignment_2_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:792:3: lv_assignment_2_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDefineBodyAccess().getAssignmentSimpleExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleDefineBody1770);
            lv_assignment_2_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefineBodyRule());
            	        }
                   		set(
                   			current, 
                   			"assignment",
                    		lv_assignment_2_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleDefineBody1782); 

                	newLeafNode(otherlv_3, grammarAccess.getDefineBodyAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDefineBody"


    // $ANTLR start "entryRuleConstantsDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:823:1: entryRuleConstantsDeclaration returns [EObject current=null] : iv_ruleConstantsDeclaration= ruleConstantsDeclaration EOF ;
    public final EObject entryRuleConstantsDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantsDeclaration = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:827:2: (iv_ruleConstantsDeclaration= ruleConstantsDeclaration EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:828:2: iv_ruleConstantsDeclaration= ruleConstantsDeclaration EOF
            {
             newCompositeNode(grammarAccess.getConstantsDeclarationRule()); 
            pushFollow(FOLLOW_ruleConstantsDeclaration_in_entryRuleConstantsDeclaration1828);
            iv_ruleConstantsDeclaration=ruleConstantsDeclaration();

            state._fsp--;

             current =iv_ruleConstantsDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantsDeclaration1838); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleConstantsDeclaration"


    // $ANTLR start "ruleConstantsDeclaration"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:838:1: ruleConstantsDeclaration returns [EObject current=null] : (otherlv_0= 'CONSTANTS' ( (lv_constants_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_constants_3_0= RULE_ID ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleConstantsDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constants_1_0=null;
        Token otherlv_2=null;
        Token lv_constants_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:842:28: ( (otherlv_0= 'CONSTANTS' ( (lv_constants_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_constants_3_0= RULE_ID ) ) )* otherlv_4= ';' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:843:1: (otherlv_0= 'CONSTANTS' ( (lv_constants_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_constants_3_0= RULE_ID ) ) )* otherlv_4= ';' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:843:1: (otherlv_0= 'CONSTANTS' ( (lv_constants_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_constants_3_0= RULE_ID ) ) )* otherlv_4= ';' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:843:3: otherlv_0= 'CONSTANTS' ( (lv_constants_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_constants_3_0= RULE_ID ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleConstantsDeclaration1879); 

                	newLeafNode(otherlv_0, grammarAccess.getConstantsDeclarationAccess().getCONSTANTSKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:847:1: ( (lv_constants_1_0= RULE_ID ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:848:1: (lv_constants_1_0= RULE_ID )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:848:1: (lv_constants_1_0= RULE_ID )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:849:3: lv_constants_1_0= RULE_ID
            {
            lv_constants_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstantsDeclaration1896); 

            			newLeafNode(lv_constants_1_0, grammarAccess.getConstantsDeclarationAccess().getConstantsIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantsDeclarationRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"constants",
                    		lv_constants_1_0, 
                    		"ID");
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:865:2: (otherlv_2= ',' ( (lv_constants_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==16) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:865:4: otherlv_2= ',' ( (lv_constants_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleConstantsDeclaration1914); 

            	        	newLeafNode(otherlv_2, grammarAccess.getConstantsDeclarationAccess().getCommaKeyword_2_0());
            	        
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:869:1: ( (lv_constants_3_0= RULE_ID ) )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:870:1: (lv_constants_3_0= RULE_ID )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:870:1: (lv_constants_3_0= RULE_ID )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:871:3: lv_constants_3_0= RULE_ID
            	    {
            	    lv_constants_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstantsDeclaration1931); 

            	    			newLeafNode(lv_constants_3_0, grammarAccess.getConstantsDeclarationAccess().getConstantsIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getConstantsDeclarationRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"constants",
            	            		lv_constants_3_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleConstantsDeclaration1950); 

                	newLeafNode(otherlv_4, grammarAccess.getConstantsDeclarationAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleConstantsDeclaration"


    // $ANTLR start "entryRuleAssignConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:902:1: entryRuleAssignConstraint returns [EObject current=null] : iv_ruleAssignConstraint= ruleAssignConstraint EOF ;
    public final EObject entryRuleAssignConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignConstraint = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:906:2: (iv_ruleAssignConstraint= ruleAssignConstraint EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:907:2: iv_ruleAssignConstraint= ruleAssignConstraint EOF
            {
             newCompositeNode(grammarAccess.getAssignConstraintRule()); 
            pushFollow(FOLLOW_ruleAssignConstraint_in_entryRuleAssignConstraint1996);
            iv_ruleAssignConstraint=ruleAssignConstraint();

            state._fsp--;

             current =iv_ruleAssignConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignConstraint2006); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleAssignConstraint"


    // $ANTLR start "ruleAssignConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:917:1: ruleAssignConstraint returns [EObject current=null] : (otherlv_0= 'ASSIGN' ( (lv_bodies_1_0= ruleAssignBody ) )+ ) ;
    public final EObject ruleAssignConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_bodies_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:921:28: ( (otherlv_0= 'ASSIGN' ( (lv_bodies_1_0= ruleAssignBody ) )+ ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:922:1: (otherlv_0= 'ASSIGN' ( (lv_bodies_1_0= ruleAssignBody ) )+ )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:922:1: (otherlv_0= 'ASSIGN' ( (lv_bodies_1_0= ruleAssignBody ) )+ )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:922:3: otherlv_0= 'ASSIGN' ( (lv_bodies_1_0= ruleAssignBody ) )+
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleAssignConstraint2047); 

                	newLeafNode(otherlv_0, grammarAccess.getAssignConstraintAccess().getASSIGNKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:926:1: ( (lv_bodies_1_0= ruleAssignBody ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||(LA12_0>=27 && LA12_0<=28)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:927:1: (lv_bodies_1_0= ruleAssignBody )
            	    {
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:927:1: (lv_bodies_1_0= ruleAssignBody )
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:928:3: lv_bodies_1_0= ruleAssignBody
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssignConstraintAccess().getBodiesAssignBodyParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssignBody_in_ruleAssignConstraint2068);
            	    lv_bodies_1_0=ruleAssignBody();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssignConstraintRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bodies",
            	            		lv_bodies_1_0, 
            	            		"AssignBody");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleAssignConstraint"


    // $ANTLR start "entryRuleAssignBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:955:1: entryRuleAssignBody returns [EObject current=null] : iv_ruleAssignBody= ruleAssignBody EOF ;
    public final EObject entryRuleAssignBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:959:2: (iv_ruleAssignBody= ruleAssignBody EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:960:2: iv_ruleAssignBody= ruleAssignBody EOF
            {
             newCompositeNode(grammarAccess.getAssignBodyRule()); 
            pushFollow(FOLLOW_ruleAssignBody_in_entryRuleAssignBody2115);
            iv_ruleAssignBody=ruleAssignBody();

            state._fsp--;

             current =iv_ruleAssignBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignBody2125); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleAssignBody"


    // $ANTLR start "ruleAssignBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:970:1: ruleAssignBody returns [EObject current=null] : (this_VarBodyAssign_0= ruleVarBodyAssign | this_InitBody_1= ruleInitBody | this_NextBody_2= ruleNextBody ) ;
    public final EObject ruleAssignBody() throws RecognitionException {
        EObject current = null;

        EObject this_VarBodyAssign_0 = null;

        EObject this_InitBody_1 = null;

        EObject this_NextBody_2 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:974:28: ( (this_VarBodyAssign_0= ruleVarBodyAssign | this_InitBody_1= ruleInitBody | this_NextBody_2= ruleNextBody ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:975:1: (this_VarBodyAssign_0= ruleVarBodyAssign | this_InitBody_1= ruleInitBody | this_NextBody_2= ruleNextBody )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:975:1: (this_VarBodyAssign_0= ruleVarBodyAssign | this_InitBody_1= ruleInitBody | this_NextBody_2= ruleNextBody )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt13=1;
                }
                break;
            case 27:
                {
                alt13=2;
                }
                break;
            case 28:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:976:5: this_VarBodyAssign_0= ruleVarBodyAssign
                    {
                     
                            newCompositeNode(grammarAccess.getAssignBodyAccess().getVarBodyAssignParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVarBodyAssign_in_ruleAssignBody2176);
                    this_VarBodyAssign_0=ruleVarBodyAssign();

                    state._fsp--;

                     
                            current = this_VarBodyAssign_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:986:5: this_InitBody_1= ruleInitBody
                    {
                     
                            newCompositeNode(grammarAccess.getAssignBodyAccess().getInitBodyParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInitBody_in_ruleAssignBody2203);
                    this_InitBody_1=ruleInitBody();

                    state._fsp--;

                     
                            current = this_InitBody_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:996:5: this_NextBody_2= ruleNextBody
                    {
                     
                            newCompositeNode(grammarAccess.getAssignBodyAccess().getNextBodyParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNextBody_in_ruleAssignBody2230);
                    this_NextBody_2=ruleNextBody();

                    state._fsp--;

                     
                            current = this_NextBody_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleAssignBody"


    // $ANTLR start "entryRuleVarBodyAssign"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1015:1: entryRuleVarBodyAssign returns [EObject current=null] : iv_ruleVarBodyAssign= ruleVarBodyAssign EOF ;
    public final EObject entryRuleVarBodyAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarBodyAssign = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1019:2: (iv_ruleVarBodyAssign= ruleVarBodyAssign EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1020:2: iv_ruleVarBodyAssign= ruleVarBodyAssign EOF
            {
             newCompositeNode(grammarAccess.getVarBodyAssignRule()); 
            pushFollow(FOLLOW_ruleVarBodyAssign_in_entryRuleVarBodyAssign2275);
            iv_ruleVarBodyAssign=ruleVarBodyAssign();

            state._fsp--;

             current =iv_ruleVarBodyAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarBodyAssign2285); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVarBodyAssign"


    // $ANTLR start "ruleVarBodyAssign"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1030:1: ruleVarBodyAssign returns [EObject current=null] : ( ( (lv_varId_0_0= ruleVariableIdentifier ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleVarBodyAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_varId_0_0 = null;

        AntlrDatatypeRuleToken lv_assignment_2_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1034:28: ( ( ( (lv_varId_0_0= ruleVariableIdentifier ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1035:1: ( ( (lv_varId_0_0= ruleVariableIdentifier ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1035:1: ( ( (lv_varId_0_0= ruleVariableIdentifier ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1035:2: ( (lv_varId_0_0= ruleVariableIdentifier ) ) otherlv_1= ':=' ( (lv_assignment_2_0= ruleSimpleExpression ) ) otherlv_3= ';'
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1035:2: ( (lv_varId_0_0= ruleVariableIdentifier ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1036:1: (lv_varId_0_0= ruleVariableIdentifier )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1036:1: (lv_varId_0_0= ruleVariableIdentifier )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1037:3: lv_varId_0_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getVarBodyAssignAccess().getVarIdVariableIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleVarBodyAssign2335);
            lv_varId_0_0=ruleVariableIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVarBodyAssignRule());
            	        }
                   		set(
                   			current, 
                   			"varId",
                    		lv_varId_0_0, 
                    		"VariableIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleVarBodyAssign2347); 

                	newLeafNode(otherlv_1, grammarAccess.getVarBodyAssignAccess().getColonEqualsSignKeyword_1());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1057:1: ( (lv_assignment_2_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1058:1: (lv_assignment_2_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1058:1: (lv_assignment_2_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1059:3: lv_assignment_2_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getVarBodyAssignAccess().getAssignmentSimpleExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleVarBodyAssign2368);
            lv_assignment_2_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVarBodyAssignRule());
            	        }
                   		set(
                   			current, 
                   			"assignment",
                    		lv_assignment_2_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleVarBodyAssign2380); 

                	newLeafNode(otherlv_3, grammarAccess.getVarBodyAssignAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVarBodyAssign"


    // $ANTLR start "entryRuleInitBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1090:1: entryRuleInitBody returns [EObject current=null] : iv_ruleInitBody= ruleInitBody EOF ;
    public final EObject entryRuleInitBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1094:2: (iv_ruleInitBody= ruleInitBody EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1095:2: iv_ruleInitBody= ruleInitBody EOF
            {
             newCompositeNode(grammarAccess.getInitBodyRule()); 
            pushFollow(FOLLOW_ruleInitBody_in_entryRuleInitBody2426);
            iv_ruleInitBody=ruleInitBody();

            state._fsp--;

             current =iv_ruleInitBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitBody2436); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleInitBody"


    // $ANTLR start "ruleInitBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1105:1: ruleInitBody returns [EObject current=null] : (otherlv_0= 'init' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_initExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' ) ;
    public final EObject ruleInitBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_varId_2_0 = null;

        AntlrDatatypeRuleToken lv_initExpr_5_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1109:28: ( (otherlv_0= 'init' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_initExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1110:1: (otherlv_0= 'init' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_initExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1110:1: (otherlv_0= 'init' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_initExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1110:3: otherlv_0= 'init' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_initExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleInitBody2477); 

                	newLeafNode(otherlv_0, grammarAccess.getInitBodyAccess().getInitKeyword_0());
                
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleInitBody2489); 

                	newLeafNode(otherlv_1, grammarAccess.getInitBodyAccess().getLeftParenthesisKeyword_1());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1118:1: ( (lv_varId_2_0= ruleVariableIdentifier ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1119:1: (lv_varId_2_0= ruleVariableIdentifier )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1119:1: (lv_varId_2_0= ruleVariableIdentifier )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1120:3: lv_varId_2_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getInitBodyAccess().getVarIdVariableIdentifierParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleInitBody2510);
            lv_varId_2_0=ruleVariableIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInitBodyRule());
            	        }
                   		set(
                   			current, 
                   			"varId",
                    		lv_varId_2_0, 
                    		"VariableIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleInitBody2522); 

                	newLeafNode(otherlv_3, grammarAccess.getInitBodyAccess().getRightParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleInitBody2534); 

                	newLeafNode(otherlv_4, grammarAccess.getInitBodyAccess().getColonEqualsSignKeyword_4());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1144:1: ( (lv_initExpr_5_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1145:1: (lv_initExpr_5_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1145:1: (lv_initExpr_5_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1146:3: lv_initExpr_5_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getInitBodyAccess().getInitExprSimpleExpressionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleInitBody2555);
            lv_initExpr_5_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInitBodyRule());
            	        }
                   		set(
                   			current, 
                   			"initExpr",
                    		lv_initExpr_5_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleInitBody2567); 

                	newLeafNode(otherlv_6, grammarAccess.getInitBodyAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleInitBody"


    // $ANTLR start "entryRuleNextBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1177:1: entryRuleNextBody returns [EObject current=null] : iv_ruleNextBody= ruleNextBody EOF ;
    public final EObject entryRuleNextBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1181:2: (iv_ruleNextBody= ruleNextBody EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1182:2: iv_ruleNextBody= ruleNextBody EOF
            {
             newCompositeNode(grammarAccess.getNextBodyRule()); 
            pushFollow(FOLLOW_ruleNextBody_in_entryRuleNextBody2613);
            iv_ruleNextBody=ruleNextBody();

            state._fsp--;

             current =iv_ruleNextBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNextBody2623); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNextBody"


    // $ANTLR start "ruleNextBody"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1192:1: ruleNextBody returns [EObject current=null] : (otherlv_0= 'next' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_nextExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' ) ;
    public final EObject ruleNextBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_varId_2_0 = null;

        AntlrDatatypeRuleToken lv_nextExpr_5_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1196:28: ( (otherlv_0= 'next' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_nextExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1197:1: (otherlv_0= 'next' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_nextExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1197:1: (otherlv_0= 'next' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_nextExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1197:3: otherlv_0= 'next' otherlv_1= '(' ( (lv_varId_2_0= ruleVariableIdentifier ) ) otherlv_3= ')' otherlv_4= ':=' ( (lv_nextExpr_5_0= ruleSimpleExpression ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleNextBody2664); 

                	newLeafNode(otherlv_0, grammarAccess.getNextBodyAccess().getNextKeyword_0());
                
            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleNextBody2676); 

                	newLeafNode(otherlv_1, grammarAccess.getNextBodyAccess().getLeftParenthesisKeyword_1());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1205:1: ( (lv_varId_2_0= ruleVariableIdentifier ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1206:1: (lv_varId_2_0= ruleVariableIdentifier )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1206:1: (lv_varId_2_0= ruleVariableIdentifier )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1207:3: lv_varId_2_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getNextBodyAccess().getVarIdVariableIdentifierParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleNextBody2697);
            lv_varId_2_0=ruleVariableIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNextBodyRule());
            	        }
                   		set(
                   			current, 
                   			"varId",
                    		lv_varId_2_0, 
                    		"VariableIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleNextBody2709); 

                	newLeafNode(otherlv_3, grammarAccess.getNextBodyAccess().getRightParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleNextBody2721); 

                	newLeafNode(otherlv_4, grammarAccess.getNextBodyAccess().getColonEqualsSignKeyword_4());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1231:1: ( (lv_nextExpr_5_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1232:1: (lv_nextExpr_5_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1232:1: (lv_nextExpr_5_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1233:3: lv_nextExpr_5_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getNextBodyAccess().getNextExprSimpleExpressionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleNextBody2742);
            lv_nextExpr_5_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNextBodyRule());
            	        }
                   		set(
                   			current, 
                   			"nextExpr",
                    		lv_nextExpr_5_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleNextBody2754); 

                	newLeafNode(otherlv_6, grammarAccess.getNextBodyAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNextBody"


    // $ANTLR start "entryRuleTransConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1264:1: entryRuleTransConstraint returns [EObject current=null] : iv_ruleTransConstraint= ruleTransConstraint EOF ;
    public final EObject entryRuleTransConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransConstraint = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1268:2: (iv_ruleTransConstraint= ruleTransConstraint EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1269:2: iv_ruleTransConstraint= ruleTransConstraint EOF
            {
             newCompositeNode(grammarAccess.getTransConstraintRule()); 
            pushFollow(FOLLOW_ruleTransConstraint_in_entryRuleTransConstraint2800);
            iv_ruleTransConstraint=ruleTransConstraint();

            state._fsp--;

             current =iv_ruleTransConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransConstraint2810); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTransConstraint"


    // $ANTLR start "ruleTransConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1279:1: ruleTransConstraint returns [EObject current=null] : (otherlv_0= 'TRANS' ( (lv_transExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) ;
    public final EObject ruleTransConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_transExpr_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1283:28: ( (otherlv_0= 'TRANS' ( (lv_transExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1284:1: (otherlv_0= 'TRANS' ( (lv_transExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1284:1: (otherlv_0= 'TRANS' ( (lv_transExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1284:3: otherlv_0= 'TRANS' ( (lv_transExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleTransConstraint2851); 

                	newLeafNode(otherlv_0, grammarAccess.getTransConstraintAccess().getTRANSKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1288:1: ( (lv_transExpr_1_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1289:1: (lv_transExpr_1_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1289:1: (lv_transExpr_1_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1290:3: lv_transExpr_1_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getTransConstraintAccess().getTransExprSimpleExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleTransConstraint2872);
            lv_transExpr_1_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransConstraintRule());
            	        }
                   		set(
                   			current, 
                   			"transExpr",
                    		lv_transExpr_1_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1306:2: (otherlv_2= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1306:4: otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleTransConstraint2885); 

                        	newLeafNode(otherlv_2, grammarAccess.getTransConstraintAccess().getSemicolonKeyword_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTransConstraint"


    // $ANTLR start "entryRuleInitConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1321:1: entryRuleInitConstraint returns [EObject current=null] : iv_ruleInitConstraint= ruleInitConstraint EOF ;
    public final EObject entryRuleInitConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitConstraint = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1325:2: (iv_ruleInitConstraint= ruleInitConstraint EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1326:2: iv_ruleInitConstraint= ruleInitConstraint EOF
            {
             newCompositeNode(grammarAccess.getInitConstraintRule()); 
            pushFollow(FOLLOW_ruleInitConstraint_in_entryRuleInitConstraint2933);
            iv_ruleInitConstraint=ruleInitConstraint();

            state._fsp--;

             current =iv_ruleInitConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitConstraint2943); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleInitConstraint"


    // $ANTLR start "ruleInitConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1336:1: ruleInitConstraint returns [EObject current=null] : (otherlv_0= 'INIT' ( (lv_initExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) ;
    public final EObject ruleInitConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_initExpr_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1340:28: ( (otherlv_0= 'INIT' ( (lv_initExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1341:1: (otherlv_0= 'INIT' ( (lv_initExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1341:1: (otherlv_0= 'INIT' ( (lv_initExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1341:3: otherlv_0= 'INIT' ( (lv_initExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleInitConstraint2984); 

                	newLeafNode(otherlv_0, grammarAccess.getInitConstraintAccess().getINITKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1345:1: ( (lv_initExpr_1_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1346:1: (lv_initExpr_1_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1346:1: (lv_initExpr_1_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1347:3: lv_initExpr_1_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getInitConstraintAccess().getInitExprSimpleExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleInitConstraint3005);
            lv_initExpr_1_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInitConstraintRule());
            	        }
                   		set(
                   			current, 
                   			"initExpr",
                    		lv_initExpr_1_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1363:2: (otherlv_2= ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1363:4: otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleInitConstraint3018); 

                        	newLeafNode(otherlv_2, grammarAccess.getInitConstraintAccess().getSemicolonKeyword_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleInitConstraint"


    // $ANTLR start "entryRuleInvarConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1378:1: entryRuleInvarConstraint returns [EObject current=null] : iv_ruleInvarConstraint= ruleInvarConstraint EOF ;
    public final EObject entryRuleInvarConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvarConstraint = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1382:2: (iv_ruleInvarConstraint= ruleInvarConstraint EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1383:2: iv_ruleInvarConstraint= ruleInvarConstraint EOF
            {
             newCompositeNode(grammarAccess.getInvarConstraintRule()); 
            pushFollow(FOLLOW_ruleInvarConstraint_in_entryRuleInvarConstraint3066);
            iv_ruleInvarConstraint=ruleInvarConstraint();

            state._fsp--;

             current =iv_ruleInvarConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvarConstraint3076); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleInvarConstraint"


    // $ANTLR start "ruleInvarConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1393:1: ruleInvarConstraint returns [EObject current=null] : (otherlv_0= 'INVAR' ( (lv_invarExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) ;
    public final EObject ruleInvarConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_invarExpr_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1397:28: ( (otherlv_0= 'INVAR' ( (lv_invarExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1398:1: (otherlv_0= 'INVAR' ( (lv_invarExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1398:1: (otherlv_0= 'INVAR' ( (lv_invarExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1398:3: otherlv_0= 'INVAR' ( (lv_invarExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleInvarConstraint3117); 

                	newLeafNode(otherlv_0, grammarAccess.getInvarConstraintAccess().getINVARKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1402:1: ( (lv_invarExpr_1_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1403:1: (lv_invarExpr_1_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1403:1: (lv_invarExpr_1_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1404:3: lv_invarExpr_1_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getInvarConstraintAccess().getInvarExprSimpleExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleInvarConstraint3138);
            lv_invarExpr_1_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvarConstraintRule());
            	        }
                   		set(
                   			current, 
                   			"invarExpr",
                    		lv_invarExpr_1_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1420:2: (otherlv_2= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1420:4: otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleInvarConstraint3151); 

                        	newLeafNode(otherlv_2, grammarAccess.getInvarConstraintAccess().getSemicolonKeyword_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleInvarConstraint"


    // $ANTLR start "entryRuleFairnessConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1435:1: entryRuleFairnessConstraint returns [EObject current=null] : iv_ruleFairnessConstraint= ruleFairnessConstraint EOF ;
    public final EObject entryRuleFairnessConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFairnessConstraint = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1439:2: (iv_ruleFairnessConstraint= ruleFairnessConstraint EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1440:2: iv_ruleFairnessConstraint= ruleFairnessConstraint EOF
            {
             newCompositeNode(grammarAccess.getFairnessConstraintRule()); 
            pushFollow(FOLLOW_ruleFairnessConstraint_in_entryRuleFairnessConstraint3199);
            iv_ruleFairnessConstraint=ruleFairnessConstraint();

            state._fsp--;

             current =iv_ruleFairnessConstraint; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFairnessConstraint3209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFairnessConstraint"


    // $ANTLR start "ruleFairnessConstraint"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1450:1: ruleFairnessConstraint returns [EObject current=null] : (this_FairnessExpression_0= ruleFairnessExpression | this_JusticeExpression_1= ruleJusticeExpression | this_CompassionExpression_2= ruleCompassionExpression ) ;
    public final EObject ruleFairnessConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_FairnessExpression_0 = null;

        EObject this_JusticeExpression_1 = null;

        EObject this_CompassionExpression_2 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1454:28: ( (this_FairnessExpression_0= ruleFairnessExpression | this_JusticeExpression_1= ruleJusticeExpression | this_CompassionExpression_2= ruleCompassionExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1455:1: (this_FairnessExpression_0= ruleFairnessExpression | this_JusticeExpression_1= ruleJusticeExpression | this_CompassionExpression_2= ruleCompassionExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1455:1: (this_FairnessExpression_0= ruleFairnessExpression | this_JusticeExpression_1= ruleJusticeExpression | this_CompassionExpression_2= ruleCompassionExpression )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt17=1;
                }
                break;
            case 33:
                {
                alt17=2;
                }
                break;
            case 34:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1456:5: this_FairnessExpression_0= ruleFairnessExpression
                    {
                     
                            newCompositeNode(grammarAccess.getFairnessConstraintAccess().getFairnessExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFairnessExpression_in_ruleFairnessConstraint3260);
                    this_FairnessExpression_0=ruleFairnessExpression();

                    state._fsp--;

                     
                            current = this_FairnessExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1466:5: this_JusticeExpression_1= ruleJusticeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getFairnessConstraintAccess().getJusticeExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleJusticeExpression_in_ruleFairnessConstraint3287);
                    this_JusticeExpression_1=ruleJusticeExpression();

                    state._fsp--;

                     
                            current = this_JusticeExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1476:5: this_CompassionExpression_2= ruleCompassionExpression
                    {
                     
                            newCompositeNode(grammarAccess.getFairnessConstraintAccess().getCompassionExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCompassionExpression_in_ruleFairnessConstraint3314);
                    this_CompassionExpression_2=ruleCompassionExpression();

                    state._fsp--;

                     
                            current = this_CompassionExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFairnessConstraint"


    // $ANTLR start "entryRuleFairnessExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1495:1: entryRuleFairnessExpression returns [EObject current=null] : iv_ruleFairnessExpression= ruleFairnessExpression EOF ;
    public final EObject entryRuleFairnessExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFairnessExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1499:2: (iv_ruleFairnessExpression= ruleFairnessExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1500:2: iv_ruleFairnessExpression= ruleFairnessExpression EOF
            {
             newCompositeNode(grammarAccess.getFairnessExpressionRule()); 
            pushFollow(FOLLOW_ruleFairnessExpression_in_entryRuleFairnessExpression3359);
            iv_ruleFairnessExpression=ruleFairnessExpression();

            state._fsp--;

             current =iv_ruleFairnessExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFairnessExpression3369); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFairnessExpression"


    // $ANTLR start "ruleFairnessExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1510:1: ruleFairnessExpression returns [EObject current=null] : (otherlv_0= 'FAIRNESS' ( (lv_fairnessExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) ;
    public final EObject ruleFairnessExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_fairnessExpr_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1514:28: ( (otherlv_0= 'FAIRNESS' ( (lv_fairnessExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1515:1: (otherlv_0= 'FAIRNESS' ( (lv_fairnessExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1515:1: (otherlv_0= 'FAIRNESS' ( (lv_fairnessExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1515:3: otherlv_0= 'FAIRNESS' ( (lv_fairnessExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleFairnessExpression3410); 

                	newLeafNode(otherlv_0, grammarAccess.getFairnessExpressionAccess().getFAIRNESSKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1519:1: ( (lv_fairnessExpr_1_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1520:1: (lv_fairnessExpr_1_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1520:1: (lv_fairnessExpr_1_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1521:3: lv_fairnessExpr_1_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getFairnessExpressionAccess().getFairnessExprSimpleExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleFairnessExpression3431);
            lv_fairnessExpr_1_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFairnessExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"fairnessExpr",
                    		lv_fairnessExpr_1_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1537:2: (otherlv_2= ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==22) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1537:4: otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleFairnessExpression3444); 

                        	newLeafNode(otherlv_2, grammarAccess.getFairnessExpressionAccess().getSemicolonKeyword_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFairnessExpression"


    // $ANTLR start "entryRuleJusticeExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1552:1: entryRuleJusticeExpression returns [EObject current=null] : iv_ruleJusticeExpression= ruleJusticeExpression EOF ;
    public final EObject entryRuleJusticeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJusticeExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1556:2: (iv_ruleJusticeExpression= ruleJusticeExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1557:2: iv_ruleJusticeExpression= ruleJusticeExpression EOF
            {
             newCompositeNode(grammarAccess.getJusticeExpressionRule()); 
            pushFollow(FOLLOW_ruleJusticeExpression_in_entryRuleJusticeExpression3492);
            iv_ruleJusticeExpression=ruleJusticeExpression();

            state._fsp--;

             current =iv_ruleJusticeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJusticeExpression3502); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleJusticeExpression"


    // $ANTLR start "ruleJusticeExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1567:1: ruleJusticeExpression returns [EObject current=null] : (otherlv_0= 'JUSTICE' ( (lv_justiceExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) ;
    public final EObject ruleJusticeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_justiceExpr_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1571:28: ( (otherlv_0= 'JUSTICE' ( (lv_justiceExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1572:1: (otherlv_0= 'JUSTICE' ( (lv_justiceExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1572:1: (otherlv_0= 'JUSTICE' ( (lv_justiceExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1572:3: otherlv_0= 'JUSTICE' ( (lv_justiceExpr_1_0= ruleSimpleExpression ) ) (otherlv_2= ';' )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleJusticeExpression3543); 

                	newLeafNode(otherlv_0, grammarAccess.getJusticeExpressionAccess().getJUSTICEKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1576:1: ( (lv_justiceExpr_1_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1577:1: (lv_justiceExpr_1_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1577:1: (lv_justiceExpr_1_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1578:3: lv_justiceExpr_1_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getJusticeExpressionAccess().getJusticeExprSimpleExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleJusticeExpression3564);
            lv_justiceExpr_1_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJusticeExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"justiceExpr",
                    		lv_justiceExpr_1_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1594:2: (otherlv_2= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==22) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1594:4: otherlv_2= ';'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleJusticeExpression3577); 

                        	newLeafNode(otherlv_2, grammarAccess.getJusticeExpressionAccess().getSemicolonKeyword_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleJusticeExpression"


    // $ANTLR start "entryRuleCompassionExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1609:1: entryRuleCompassionExpression returns [EObject current=null] : iv_ruleCompassionExpression= ruleCompassionExpression EOF ;
    public final EObject entryRuleCompassionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompassionExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1613:2: (iv_ruleCompassionExpression= ruleCompassionExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1614:2: iv_ruleCompassionExpression= ruleCompassionExpression EOF
            {
             newCompositeNode(grammarAccess.getCompassionExpressionRule()); 
            pushFollow(FOLLOW_ruleCompassionExpression_in_entryRuleCompassionExpression3625);
            iv_ruleCompassionExpression=ruleCompassionExpression();

            state._fsp--;

             current =iv_ruleCompassionExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompassionExpression3635); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleCompassionExpression"


    // $ANTLR start "ruleCompassionExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1624:1: ruleCompassionExpression returns [EObject current=null] : (otherlv_0= 'COMPASSION (' ( (lv_firstCompassionExpr_1_0= ruleSimpleExpression ) ) otherlv_2= ',' ( (lv_secondCompassionExpr_3_0= ruleSimpleExpression ) ) otherlv_4= ')' (otherlv_5= ';' )? ) ;
    public final EObject ruleCompassionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_firstCompassionExpr_1_0 = null;

        AntlrDatatypeRuleToken lv_secondCompassionExpr_3_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1628:28: ( (otherlv_0= 'COMPASSION (' ( (lv_firstCompassionExpr_1_0= ruleSimpleExpression ) ) otherlv_2= ',' ( (lv_secondCompassionExpr_3_0= ruleSimpleExpression ) ) otherlv_4= ')' (otherlv_5= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1629:1: (otherlv_0= 'COMPASSION (' ( (lv_firstCompassionExpr_1_0= ruleSimpleExpression ) ) otherlv_2= ',' ( (lv_secondCompassionExpr_3_0= ruleSimpleExpression ) ) otherlv_4= ')' (otherlv_5= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1629:1: (otherlv_0= 'COMPASSION (' ( (lv_firstCompassionExpr_1_0= ruleSimpleExpression ) ) otherlv_2= ',' ( (lv_secondCompassionExpr_3_0= ruleSimpleExpression ) ) otherlv_4= ')' (otherlv_5= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1629:3: otherlv_0= 'COMPASSION (' ( (lv_firstCompassionExpr_1_0= ruleSimpleExpression ) ) otherlv_2= ',' ( (lv_secondCompassionExpr_3_0= ruleSimpleExpression ) ) otherlv_4= ')' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleCompassionExpression3676); 

                	newLeafNode(otherlv_0, grammarAccess.getCompassionExpressionAccess().getCOMPASSIONKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1633:1: ( (lv_firstCompassionExpr_1_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1634:1: (lv_firstCompassionExpr_1_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1634:1: (lv_firstCompassionExpr_1_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1635:3: lv_firstCompassionExpr_1_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getCompassionExpressionAccess().getFirstCompassionExprSimpleExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleCompassionExpression3697);
            lv_firstCompassionExpr_1_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompassionExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"firstCompassionExpr",
                    		lv_firstCompassionExpr_1_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleCompassionExpression3709); 

                	newLeafNode(otherlv_2, grammarAccess.getCompassionExpressionAccess().getCommaKeyword_2());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1655:1: ( (lv_secondCompassionExpr_3_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1656:1: (lv_secondCompassionExpr_3_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1656:1: (lv_secondCompassionExpr_3_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1657:3: lv_secondCompassionExpr_3_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getCompassionExpressionAccess().getSecondCompassionExprSimpleExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleCompassionExpression3730);
            lv_secondCompassionExpr_3_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompassionExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"secondCompassionExpr",
                    		lv_secondCompassionExpr_3_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleCompassionExpression3742); 

                	newLeafNode(otherlv_4, grammarAccess.getCompassionExpressionAccess().getRightParenthesisKeyword_4());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1677:1: (otherlv_5= ';' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==22) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1677:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleCompassionExpression3755); 

                        	newLeafNode(otherlv_5, grammarAccess.getCompassionExpressionAccess().getSemicolonKeyword_5());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleCompassionExpression"


    // $ANTLR start "entryRuleInvarSpecification"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1692:1: entryRuleInvarSpecification returns [EObject current=null] : iv_ruleInvarSpecification= ruleInvarSpecification EOF ;
    public final EObject entryRuleInvarSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvarSpecification = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1696:2: (iv_ruleInvarSpecification= ruleInvarSpecification EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1697:2: iv_ruleInvarSpecification= ruleInvarSpecification EOF
            {
             newCompositeNode(grammarAccess.getInvarSpecificationRule()); 
            pushFollow(FOLLOW_ruleInvarSpecification_in_entryRuleInvarSpecification3803);
            iv_ruleInvarSpecification=ruleInvarSpecification();

            state._fsp--;

             current =iv_ruleInvarSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvarSpecification3813); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleInvarSpecification"


    // $ANTLR start "ruleInvarSpecification"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1707:1: ruleInvarSpecification returns [EObject current=null] : (otherlv_0= 'INVARSPEC' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' )? ( (lv_invarExpr_3_0= ruleSimpleExpression ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleInvarSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_invarExpr_3_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1711:28: ( (otherlv_0= 'INVARSPEC' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' )? ( (lv_invarExpr_3_0= ruleSimpleExpression ) ) (otherlv_4= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1712:1: (otherlv_0= 'INVARSPEC' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' )? ( (lv_invarExpr_3_0= ruleSimpleExpression ) ) (otherlv_4= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1712:1: (otherlv_0= 'INVARSPEC' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' )? ( (lv_invarExpr_3_0= ruleSimpleExpression ) ) (otherlv_4= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1712:3: otherlv_0= 'INVARSPEC' ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' )? ( (lv_invarExpr_3_0= ruleSimpleExpression ) ) (otherlv_4= ';' )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleInvarSpecification3854); 

                	newLeafNode(otherlv_0, grammarAccess.getInvarSpecificationAccess().getINVARSPECKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1716:1: ( ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==24) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1716:2: ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':='
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1716:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1717:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1717:1: (lv_name_1_0= RULE_ID )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1718:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInvarSpecification3872); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getInvarSpecificationAccess().getNameIDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInvarSpecificationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleInvarSpecification3889); 

                        	newLeafNode(otherlv_2, grammarAccess.getInvarSpecificationAccess().getColonEqualsSignKeyword_1_1());
                        

                    }
                    break;

            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1738:3: ( (lv_invarExpr_3_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1739:1: (lv_invarExpr_3_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1739:1: (lv_invarExpr_3_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1740:3: lv_invarExpr_3_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getInvarSpecificationAccess().getInvarExprSimpleExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleInvarSpecification3912);
            lv_invarExpr_3_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvarSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"invarExpr",
                    		lv_invarExpr_3_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1756:2: (otherlv_4= ';' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==22) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1756:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleInvarSpecification3925); 

                        	newLeafNode(otherlv_4, grammarAccess.getInvarSpecificationAccess().getSemicolonKeyword_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleInvarSpecification"


    // $ANTLR start "entryRuleCtlSpecification"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1771:1: entryRuleCtlSpecification returns [EObject current=null] : iv_ruleCtlSpecification= ruleCtlSpecification EOF ;
    public final EObject entryRuleCtlSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCtlSpecification = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1775:2: (iv_ruleCtlSpecification= ruleCtlSpecification EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1776:2: iv_ruleCtlSpecification= ruleCtlSpecification EOF
            {
             newCompositeNode(grammarAccess.getCtlSpecificationRule()); 
            pushFollow(FOLLOW_ruleCtlSpecification_in_entryRuleCtlSpecification3973);
            iv_ruleCtlSpecification=ruleCtlSpecification();

            state._fsp--;

             current =iv_ruleCtlSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCtlSpecification3983); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleCtlSpecification"


    // $ANTLR start "ruleCtlSpecification"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1786:1: ruleCtlSpecification returns [EObject current=null] : ( (otherlv_0= 'CTLSPEC' | otherlv_1= 'SPEC' ) ( ( (lv_nameKeyWord_2_0= 'NAME' ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':=' )? ( (lv_ctlExpr_5_0= ruleSimpleExpression ) ) (otherlv_6= ';' )? ) ;
    public final EObject ruleCtlSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_nameKeyWord_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_ctlExpr_5_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1790:28: ( ( (otherlv_0= 'CTLSPEC' | otherlv_1= 'SPEC' ) ( ( (lv_nameKeyWord_2_0= 'NAME' ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':=' )? ( (lv_ctlExpr_5_0= ruleSimpleExpression ) ) (otherlv_6= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1791:1: ( (otherlv_0= 'CTLSPEC' | otherlv_1= 'SPEC' ) ( ( (lv_nameKeyWord_2_0= 'NAME' ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':=' )? ( (lv_ctlExpr_5_0= ruleSimpleExpression ) ) (otherlv_6= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1791:1: ( (otherlv_0= 'CTLSPEC' | otherlv_1= 'SPEC' ) ( ( (lv_nameKeyWord_2_0= 'NAME' ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':=' )? ( (lv_ctlExpr_5_0= ruleSimpleExpression ) ) (otherlv_6= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1791:2: (otherlv_0= 'CTLSPEC' | otherlv_1= 'SPEC' ) ( ( (lv_nameKeyWord_2_0= 'NAME' ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':=' )? ( (lv_ctlExpr_5_0= ruleSimpleExpression ) ) (otherlv_6= ';' )?
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1791:2: (otherlv_0= 'CTLSPEC' | otherlv_1= 'SPEC' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            else if ( (LA23_0==37) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1791:4: otherlv_0= 'CTLSPEC'
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleCtlSpecification4025); 

                        	newLeafNode(otherlv_0, grammarAccess.getCtlSpecificationAccess().getCTLSPECKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1796:7: otherlv_1= 'SPEC'
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleCtlSpecification4043); 

                        	newLeafNode(otherlv_1, grammarAccess.getCtlSpecificationAccess().getSPECKeyword_0_1());
                        

                    }
                    break;

            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1800:2: ( ( (lv_nameKeyWord_2_0= 'NAME' ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':=' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1800:3: ( (lv_nameKeyWord_2_0= 'NAME' ) ) ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':='
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1800:3: ( (lv_nameKeyWord_2_0= 'NAME' ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1801:1: (lv_nameKeyWord_2_0= 'NAME' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1801:1: (lv_nameKeyWord_2_0= 'NAME' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1802:3: lv_nameKeyWord_2_0= 'NAME'
                    {
                    lv_nameKeyWord_2_0=(Token)match(input,38,FOLLOW_38_in_ruleCtlSpecification4063); 

                            newLeafNode(lv_nameKeyWord_2_0, grammarAccess.getCtlSpecificationAccess().getNameKeyWordNAMEKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCtlSpecificationRule());
                    	        }
                           		setWithLastConsumed(current, "nameKeyWord", true, "NAME");
                    	    

                    }


                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1815:2: ( (lv_name_3_0= RULE_ID ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1816:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1816:1: (lv_name_3_0= RULE_ID )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1817:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCtlSpecification4093); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getCtlSpecificationAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCtlSpecificationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleCtlSpecification4110); 

                        	newLeafNode(otherlv_4, grammarAccess.getCtlSpecificationAccess().getColonEqualsSignKeyword_1_2());
                        

                    }
                    break;

            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1837:3: ( (lv_ctlExpr_5_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1838:1: (lv_ctlExpr_5_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1838:1: (lv_ctlExpr_5_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1839:3: lv_ctlExpr_5_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getCtlSpecificationAccess().getCtlExprSimpleExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleCtlSpecification4133);
            lv_ctlExpr_5_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCtlSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"ctlExpr",
                    		lv_ctlExpr_5_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1855:2: (otherlv_6= ';' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==22) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1855:4: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleCtlSpecification4146); 

                        	newLeafNode(otherlv_6, grammarAccess.getCtlSpecificationAccess().getSemicolonKeyword_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleCtlSpecification"


    // $ANTLR start "entryRuleLtlSpecification"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1870:1: entryRuleLtlSpecification returns [EObject current=null] : iv_ruleLtlSpecification= ruleLtlSpecification EOF ;
    public final EObject entryRuleLtlSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLtlSpecification = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1874:2: (iv_ruleLtlSpecification= ruleLtlSpecification EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1875:2: iv_ruleLtlSpecification= ruleLtlSpecification EOF
            {
             newCompositeNode(grammarAccess.getLtlSpecificationRule()); 
            pushFollow(FOLLOW_ruleLtlSpecification_in_entryRuleLtlSpecification4194);
            iv_ruleLtlSpecification=ruleLtlSpecification();

            state._fsp--;

             current =iv_ruleLtlSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLtlSpecification4204); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLtlSpecification"


    // $ANTLR start "ruleLtlSpecification"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1885:1: ruleLtlSpecification returns [EObject current=null] : (otherlv_0= 'LTLSPEC' ( ( (lv_nameId_1_0= 'NAME' ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' )? ( (lv_ltlExpr_4_0= ruleSimpleExpression ) ) (otherlv_5= ';' )? ) ;
    public final EObject ruleLtlSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_nameId_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_ltlExpr_4_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1889:28: ( (otherlv_0= 'LTLSPEC' ( ( (lv_nameId_1_0= 'NAME' ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' )? ( (lv_ltlExpr_4_0= ruleSimpleExpression ) ) (otherlv_5= ';' )? ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1890:1: (otherlv_0= 'LTLSPEC' ( ( (lv_nameId_1_0= 'NAME' ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' )? ( (lv_ltlExpr_4_0= ruleSimpleExpression ) ) (otherlv_5= ';' )? )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1890:1: (otherlv_0= 'LTLSPEC' ( ( (lv_nameId_1_0= 'NAME' ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' )? ( (lv_ltlExpr_4_0= ruleSimpleExpression ) ) (otherlv_5= ';' )? )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1890:3: otherlv_0= 'LTLSPEC' ( ( (lv_nameId_1_0= 'NAME' ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' )? ( (lv_ltlExpr_4_0= ruleSimpleExpression ) ) (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleLtlSpecification4245); 

                	newLeafNode(otherlv_0, grammarAccess.getLtlSpecificationAccess().getLTLSPECKeyword_0());
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1894:1: ( ( (lv_nameId_1_0= 'NAME' ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1894:2: ( (lv_nameId_1_0= 'NAME' ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':='
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1894:2: ( (lv_nameId_1_0= 'NAME' ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1895:1: (lv_nameId_1_0= 'NAME' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1895:1: (lv_nameId_1_0= 'NAME' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1896:3: lv_nameId_1_0= 'NAME'
                    {
                    lv_nameId_1_0=(Token)match(input,38,FOLLOW_38_in_ruleLtlSpecification4264); 

                            newLeafNode(lv_nameId_1_0, grammarAccess.getLtlSpecificationAccess().getNameIdNAMEKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLtlSpecificationRule());
                    	        }
                           		setWithLastConsumed(current, "nameId", true, "NAME");
                    	    

                    }


                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1909:2: ( (lv_name_2_0= RULE_ID ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1910:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1910:1: (lv_name_2_0= RULE_ID )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1911:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLtlSpecification4294); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getLtlSpecificationAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLtlSpecificationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleLtlSpecification4311); 

                        	newLeafNode(otherlv_3, grammarAccess.getLtlSpecificationAccess().getColonEqualsSignKeyword_1_2());
                        

                    }
                    break;

            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1931:3: ( (lv_ltlExpr_4_0= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1932:1: (lv_ltlExpr_4_0= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1932:1: (lv_ltlExpr_4_0= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1933:3: lv_ltlExpr_4_0= ruleSimpleExpression
            {
             
            	        newCompositeNode(grammarAccess.getLtlSpecificationAccess().getLtlExprSimpleExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleLtlSpecification4334);
            lv_ltlExpr_4_0=ruleSimpleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLtlSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"ltlExpr",
                    		lv_ltlExpr_4_0, 
                    		"SimpleExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1949:2: (otherlv_5= ';' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==22) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1949:4: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleLtlSpecification4347); 

                        	newLeafNode(otherlv_5, grammarAccess.getLtlSpecificationAccess().getSemicolonKeyword_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLtlSpecification"


    // $ANTLR start "entryRuleTypeSpecifier"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1964:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1968:2: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1969:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleTypeSpecifier_in_entryRuleTypeSpecifier4395);
            iv_ruleTypeSpecifier=ruleTypeSpecifier();

            state._fsp--;

             current =iv_ruleTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeSpecifier4405); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTypeSpecifier"


    // $ANTLR start "ruleTypeSpecifier"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1979:1: ruleTypeSpecifier returns [EObject current=null] : (this_SimpleType_0= ruleSimpleType | this_ModuleType_1= ruleModuleType ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleType_0 = null;

        EObject this_ModuleType_1 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1983:28: ( (this_SimpleType_0= ruleSimpleType | this_ModuleType_1= ruleModuleType ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1984:1: (this_SimpleType_0= ruleSimpleType | this_ModuleType_1= ruleModuleType )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1984:1: (this_SimpleType_0= ruleSimpleType | this_ModuleType_1= ruleModuleType )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_NUMBER||(LA28_0>=40 && LA28_0<=41)||(LA28_0>=44 && LA28_0<=46)||LA28_0==49) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID||LA28_0==51) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1985:5: this_SimpleType_0= ruleSimpleType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeSpecifierAccess().getSimpleTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleType_in_ruleTypeSpecifier4456);
                    this_SimpleType_0=ruleSimpleType();

                    state._fsp--;

                     
                            current = this_SimpleType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:1995:5: this_ModuleType_1= ruleModuleType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeSpecifierAccess().getModuleTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleModuleType_in_ruleTypeSpecifier4483);
                    this_ModuleType_1=ruleModuleType();

                    state._fsp--;

                     
                            current = this_ModuleType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTypeSpecifier"


    // $ANTLR start "entryRuleSimpleType"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2014:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2018:2: (iv_ruleSimpleType= ruleSimpleType EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2019:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             newCompositeNode(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType4528);
            iv_ruleSimpleType=ruleSimpleType();

            state._fsp--;

             current =iv_ruleSimpleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType4538); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleType"


    // $ANTLR start "ruleSimpleType"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2029:1: ruleSimpleType returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' ) ) | ( () (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' ) ) | ( () (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' ) ) | ( () otherlv_19= '{' ( (lv_value_20_0= ruleVal ) ) (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )* otherlv_23= '}' ) | ( () ( (lv_low_25_0= RULE_NUMBER ) ) otherlv_26= '..' ( (lv_high_27_0= RULE_NUMBER ) ) ) | ( () otherlv_29= 'array' ( (lv_bounds_30_0= ruleRange ) ) otherlv_31= 'of' ( (lv_type_32_0= ruleSimpleType ) ) ) ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_wordNumber_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_uWordNumber_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_signedNumber_16_0=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token lv_low_25_0=null;
        Token otherlv_26=null;
        Token lv_high_27_0=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        AntlrDatatypeRuleToken lv_value_20_0 = null;

        AntlrDatatypeRuleToken lv_value_22_0 = null;

        AntlrDatatypeRuleToken lv_bounds_30_0 = null;

        EObject lv_type_32_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2033:28: ( ( ( () otherlv_1= 'boolean' ) | ( () (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' ) ) | ( () (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' ) ) | ( () (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' ) ) | ( () otherlv_19= '{' ( (lv_value_20_0= ruleVal ) ) (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )* otherlv_23= '}' ) | ( () ( (lv_low_25_0= RULE_NUMBER ) ) otherlv_26= '..' ( (lv_high_27_0= RULE_NUMBER ) ) ) | ( () otherlv_29= 'array' ( (lv_bounds_30_0= ruleRange ) ) otherlv_31= 'of' ( (lv_type_32_0= ruleSimpleType ) ) ) ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2034:1: ( ( () otherlv_1= 'boolean' ) | ( () (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' ) ) | ( () (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' ) ) | ( () (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' ) ) | ( () otherlv_19= '{' ( (lv_value_20_0= ruleVal ) ) (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )* otherlv_23= '}' ) | ( () ( (lv_low_25_0= RULE_NUMBER ) ) otherlv_26= '..' ( (lv_high_27_0= RULE_NUMBER ) ) ) | ( () otherlv_29= 'array' ( (lv_bounds_30_0= ruleRange ) ) otherlv_31= 'of' ( (lv_type_32_0= ruleSimpleType ) ) ) )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2034:1: ( ( () otherlv_1= 'boolean' ) | ( () (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' ) ) | ( () (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' ) ) | ( () (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' ) ) | ( () otherlv_19= '{' ( (lv_value_20_0= ruleVal ) ) (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )* otherlv_23= '}' ) | ( () ( (lv_low_25_0= RULE_NUMBER ) ) otherlv_26= '..' ( (lv_high_27_0= RULE_NUMBER ) ) ) | ( () otherlv_29= 'array' ( (lv_bounds_30_0= ruleRange ) ) otherlv_31= 'of' ( (lv_type_32_0= ruleSimpleType ) ) ) )
            int alt30=7;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt30=1;
                }
                break;
            case 41:
                {
                alt30=2;
                }
                break;
            case 44:
                {
                alt30=3;
                }
                break;
            case 45:
                {
                alt30=4;
                }
                break;
            case 46:
                {
                alt30=5;
                }
                break;
            case RULE_NUMBER:
                {
                alt30=6;
                }
                break;
            case 49:
                {
                alt30=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2034:2: ( () otherlv_1= 'boolean' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2034:2: ( () otherlv_1= 'boolean' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2034:3: () otherlv_1= 'boolean'
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2034:3: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2035:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getSimpleTypeAccess().getBooleanTypeAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleSimpleType4589); 

                        	newLeafNode(otherlv_1, grammarAccess.getSimpleTypeAccess().getBooleanKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2045:6: ( () (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2045:6: ( () (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2045:7: () (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2045:7: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2046:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getSimpleTypeAccess().getWordTypeAction_1_0(),
                                current);
                        

                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2051:2: (otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2051:4: otherlv_3= 'word' otherlv_4= '[' ( (lv_wordNumber_5_0= RULE_NUMBER ) ) otherlv_6= ']'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_41_in_ruleSimpleType4619); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleTypeAccess().getWordKeyword_1_1_0());
                        
                    otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleSimpleType4631); 

                        	newLeafNode(otherlv_4, grammarAccess.getSimpleTypeAccess().getLeftSquareBracketKeyword_1_1_1());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2059:1: ( (lv_wordNumber_5_0= RULE_NUMBER ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2060:1: (lv_wordNumber_5_0= RULE_NUMBER )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2060:1: (lv_wordNumber_5_0= RULE_NUMBER )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2061:3: lv_wordNumber_5_0= RULE_NUMBER
                    {
                    lv_wordNumber_5_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSimpleType4648); 

                    			newLeafNode(lv_wordNumber_5_0, grammarAccess.getSimpleTypeAccess().getWordNumberNUMBERTerminalRuleCall_1_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"wordNumber",
                            		lv_wordNumber_5_0, 
                            		"NUMBER");
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,43,FOLLOW_43_in_ruleSimpleType4665); 

                        	newLeafNode(otherlv_6, grammarAccess.getSimpleTypeAccess().getRightSquareBracketKeyword_1_1_3());
                        

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2082:6: ( () (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2082:6: ( () (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2082:7: () (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2082:7: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2083:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getSimpleTypeAccess().getUnsignedWordTypeAction_2_0(),
                                current);
                        

                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2088:2: (otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2088:4: otherlv_8= 'unsigned' otherlv_9= 'word' otherlv_10= '[' ( (lv_uWordNumber_11_0= RULE_NUMBER ) ) otherlv_12= ']'
                    {
                    otherlv_8=(Token)match(input,44,FOLLOW_44_in_ruleSimpleType4696); 

                        	newLeafNode(otherlv_8, grammarAccess.getSimpleTypeAccess().getUnsignedKeyword_2_1_0());
                        
                    otherlv_9=(Token)match(input,41,FOLLOW_41_in_ruleSimpleType4708); 

                        	newLeafNode(otherlv_9, grammarAccess.getSimpleTypeAccess().getWordKeyword_2_1_1());
                        
                    otherlv_10=(Token)match(input,42,FOLLOW_42_in_ruleSimpleType4720); 

                        	newLeafNode(otherlv_10, grammarAccess.getSimpleTypeAccess().getLeftSquareBracketKeyword_2_1_2());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2100:1: ( (lv_uWordNumber_11_0= RULE_NUMBER ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2101:1: (lv_uWordNumber_11_0= RULE_NUMBER )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2101:1: (lv_uWordNumber_11_0= RULE_NUMBER )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2102:3: lv_uWordNumber_11_0= RULE_NUMBER
                    {
                    lv_uWordNumber_11_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSimpleType4737); 

                    			newLeafNode(lv_uWordNumber_11_0, grammarAccess.getSimpleTypeAccess().getUWordNumberNUMBERTerminalRuleCall_2_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"uWordNumber",
                            		lv_uWordNumber_11_0, 
                            		"NUMBER");
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,43,FOLLOW_43_in_ruleSimpleType4754); 

                        	newLeafNode(otherlv_12, grammarAccess.getSimpleTypeAccess().getRightSquareBracketKeyword_2_1_4());
                        

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2123:6: ( () (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2123:6: ( () (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2123:7: () (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2123:7: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2124:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getSimpleTypeAccess().getSignedWordTypeAction_3_0(),
                                current);
                        

                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2129:2: (otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2129:4: otherlv_14= 'signed word' otherlv_15= '[' ( (lv_signedNumber_16_0= RULE_NUMBER ) ) otherlv_17= ']'
                    {
                    otherlv_14=(Token)match(input,45,FOLLOW_45_in_ruleSimpleType4785); 

                        	newLeafNode(otherlv_14, grammarAccess.getSimpleTypeAccess().getSignedWordKeyword_3_1_0());
                        
                    otherlv_15=(Token)match(input,42,FOLLOW_42_in_ruleSimpleType4797); 

                        	newLeafNode(otherlv_15, grammarAccess.getSimpleTypeAccess().getLeftSquareBracketKeyword_3_1_1());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2137:1: ( (lv_signedNumber_16_0= RULE_NUMBER ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2138:1: (lv_signedNumber_16_0= RULE_NUMBER )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2138:1: (lv_signedNumber_16_0= RULE_NUMBER )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2139:3: lv_signedNumber_16_0= RULE_NUMBER
                    {
                    lv_signedNumber_16_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSimpleType4814); 

                    			newLeafNode(lv_signedNumber_16_0, grammarAccess.getSimpleTypeAccess().getSignedNumberNUMBERTerminalRuleCall_3_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"signedNumber",
                            		lv_signedNumber_16_0, 
                            		"NUMBER");
                    	    

                    }


                    }

                    otherlv_17=(Token)match(input,43,FOLLOW_43_in_ruleSimpleType4831); 

                        	newLeafNode(otherlv_17, grammarAccess.getSimpleTypeAccess().getRightSquareBracketKeyword_3_1_3());
                        

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2160:6: ( () otherlv_19= '{' ( (lv_value_20_0= ruleVal ) ) (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )* otherlv_23= '}' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2160:6: ( () otherlv_19= '{' ( (lv_value_20_0= ruleVal ) ) (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )* otherlv_23= '}' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2160:7: () otherlv_19= '{' ( (lv_value_20_0= ruleVal ) ) (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )* otherlv_23= '}'
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2160:7: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2161:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getSimpleTypeAccess().getEnumTypeAction_4_0(),
                                current);
                        

                    }

                    otherlv_19=(Token)match(input,46,FOLLOW_46_in_ruleSimpleType4861); 

                        	newLeafNode(otherlv_19, grammarAccess.getSimpleTypeAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2170:1: ( (lv_value_20_0= ruleVal ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2171:1: (lv_value_20_0= ruleVal )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2171:1: (lv_value_20_0= ruleVal )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2172:3: lv_value_20_0= ruleVal
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleTypeAccess().getValueValParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVal_in_ruleSimpleType4882);
                    lv_value_20_0=ruleVal();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSimpleTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"value",
                            		lv_value_20_0, 
                            		"Val");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2188:2: (otherlv_21= ',' ( (lv_value_22_0= ruleVal ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==16) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2188:4: otherlv_21= ',' ( (lv_value_22_0= ruleVal ) )
                    	    {
                    	    otherlv_21=(Token)match(input,16,FOLLOW_16_in_ruleSimpleType4895); 

                    	        	newLeafNode(otherlv_21, grammarAccess.getSimpleTypeAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2192:1: ( (lv_value_22_0= ruleVal ) )
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2193:1: (lv_value_22_0= ruleVal )
                    	    {
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2193:1: (lv_value_22_0= ruleVal )
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2194:3: lv_value_22_0= ruleVal
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSimpleTypeAccess().getValueValParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVal_in_ruleSimpleType4916);
                    	    lv_value_22_0=ruleVal();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSimpleTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"value",
                    	            		lv_value_22_0, 
                    	            		"Val");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,47,FOLLOW_47_in_ruleSimpleType4930); 

                        	newLeafNode(otherlv_23, grammarAccess.getSimpleTypeAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }


                    }
                    break;
                case 6 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2215:6: ( () ( (lv_low_25_0= RULE_NUMBER ) ) otherlv_26= '..' ( (lv_high_27_0= RULE_NUMBER ) ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2215:6: ( () ( (lv_low_25_0= RULE_NUMBER ) ) otherlv_26= '..' ( (lv_high_27_0= RULE_NUMBER ) ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2215:7: () ( (lv_low_25_0= RULE_NUMBER ) ) otherlv_26= '..' ( (lv_high_27_0= RULE_NUMBER ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2215:7: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2216:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getSimpleTypeAccess().getRangeTypeAction_5_0(),
                                current);
                        

                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2221:2: ( (lv_low_25_0= RULE_NUMBER ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2222:1: (lv_low_25_0= RULE_NUMBER )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2222:1: (lv_low_25_0= RULE_NUMBER )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2223:3: lv_low_25_0= RULE_NUMBER
                    {
                    lv_low_25_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSimpleType4964); 

                    			newLeafNode(lv_low_25_0, grammarAccess.getSimpleTypeAccess().getLowNUMBERTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"low",
                            		lv_low_25_0, 
                            		"NUMBER");
                    	    

                    }


                    }

                    otherlv_26=(Token)match(input,48,FOLLOW_48_in_ruleSimpleType4981); 

                        	newLeafNode(otherlv_26, grammarAccess.getSimpleTypeAccess().getFullStopFullStopKeyword_5_2());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2243:1: ( (lv_high_27_0= RULE_NUMBER ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2244:1: (lv_high_27_0= RULE_NUMBER )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2244:1: (lv_high_27_0= RULE_NUMBER )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2245:3: lv_high_27_0= RULE_NUMBER
                    {
                    lv_high_27_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSimpleType4998); 

                    			newLeafNode(lv_high_27_0, grammarAccess.getSimpleTypeAccess().getHighNUMBERTerminalRuleCall_5_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"high",
                            		lv_high_27_0, 
                            		"NUMBER");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2262:6: ( () otherlv_29= 'array' ( (lv_bounds_30_0= ruleRange ) ) otherlv_31= 'of' ( (lv_type_32_0= ruleSimpleType ) ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2262:6: ( () otherlv_29= 'array' ( (lv_bounds_30_0= ruleRange ) ) otherlv_31= 'of' ( (lv_type_32_0= ruleSimpleType ) ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2262:7: () otherlv_29= 'array' ( (lv_bounds_30_0= ruleRange ) ) otherlv_31= 'of' ( (lv_type_32_0= ruleSimpleType ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2262:7: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2263:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getSimpleTypeAccess().getArrayTypeAction_6_0(),
                                current);
                        

                    }

                    otherlv_29=(Token)match(input,49,FOLLOW_49_in_ruleSimpleType5032); 

                        	newLeafNode(otherlv_29, grammarAccess.getSimpleTypeAccess().getArrayKeyword_6_1());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2272:1: ( (lv_bounds_30_0= ruleRange ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2273:1: (lv_bounds_30_0= ruleRange )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2273:1: (lv_bounds_30_0= ruleRange )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2274:3: lv_bounds_30_0= ruleRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleTypeAccess().getBoundsRangeParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRange_in_ruleSimpleType5053);
                    lv_bounds_30_0=ruleRange();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSimpleTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"bounds",
                            		lv_bounds_30_0, 
                            		"Range");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_31=(Token)match(input,50,FOLLOW_50_in_ruleSimpleType5065); 

                        	newLeafNode(otherlv_31, grammarAccess.getSimpleTypeAccess().getOfKeyword_6_3());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2294:1: ( (lv_type_32_0= ruleSimpleType ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2295:1: (lv_type_32_0= ruleSimpleType )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2295:1: (lv_type_32_0= ruleSimpleType )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2296:3: lv_type_32_0= ruleSimpleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleTypeAccess().getTypeSimpleTypeParserRuleCall_6_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSimpleType_in_ruleSimpleType5086);
                    lv_type_32_0=ruleSimpleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSimpleTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_32_0, 
                            		"SimpleType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleModuleType"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2323:1: entryRuleModuleType returns [EObject current=null] : iv_ruleModuleType= ruleModuleType EOF ;
    public final EObject entryRuleModuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleType = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2327:2: (iv_ruleModuleType= ruleModuleType EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2328:2: iv_ruleModuleType= ruleModuleType EOF
            {
             newCompositeNode(grammarAccess.getModuleTypeRule()); 
            pushFollow(FOLLOW_ruleModuleType_in_entryRuleModuleType5133);
            iv_ruleModuleType=ruleModuleType();

            state._fsp--;

             current =iv_ruleModuleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleType5143); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleModuleType"


    // $ANTLR start "ruleModuleType"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2338:1: ruleModuleType returns [EObject current=null] : ( ( () (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? ) ) | ( () ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? ) ) ) ;
    public final EObject ruleModuleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_params_4_0 = null;

        AntlrDatatypeRuleToken lv_params_6_0 = null;

        AntlrDatatypeRuleToken lv_params_11_0 = null;

        AntlrDatatypeRuleToken lv_params_13_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2342:28: ( ( ( () (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? ) ) | ( () ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? ) ) ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2343:1: ( ( () (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? ) ) | ( () ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? ) ) )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2343:1: ( ( () (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? ) ) | ( () ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==51) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_ID) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2343:2: ( () (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2343:2: ( () (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2343:3: () (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2343:3: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2344:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getModuleTypeAccess().getAsyncrProcessTypeAction_0_0(),
                                current);
                        

                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2349:2: (otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )? )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2349:4: otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )?
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleModuleType5195); 

                        	newLeafNode(otherlv_1, grammarAccess.getModuleTypeAccess().getProcessKeyword_0_1_0());
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2353:1: ( (otherlv_2= RULE_ID ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2354:1: (otherlv_2= RULE_ID )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2354:1: (otherlv_2= RULE_ID )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2355:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getModuleTypeRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModuleType5215); 

                    		newLeafNode(otherlv_2, grammarAccess.getModuleTypeAccess().getModuleModuleCrossReference_0_1_1_0()); 
                    	

                    }


                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2366:2: (otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')' )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==15) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2366:4: otherlv_3= '(' ( (lv_params_4_0= ruleSimpleExpression ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )* otherlv_7= ')'
                            {
                            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleModuleType5228); 

                                	newLeafNode(otherlv_3, grammarAccess.getModuleTypeAccess().getLeftParenthesisKeyword_0_1_2_0());
                                
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2370:1: ( (lv_params_4_0= ruleSimpleExpression ) )
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2371:1: (lv_params_4_0= ruleSimpleExpression )
                            {
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2371:1: (lv_params_4_0= ruleSimpleExpression )
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2372:3: lv_params_4_0= ruleSimpleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getModuleTypeAccess().getParamsSimpleExpressionParserRuleCall_0_1_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleModuleType5249);
                            lv_params_4_0=ruleSimpleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModuleTypeRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"params",
                                    		lv_params_4_0, 
                                    		"SimpleExpression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2388:2: (otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) ) )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==16) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2388:4: otherlv_5= ',' ( (lv_params_6_0= ruleSimpleExpression ) )
                            	    {
                            	    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleModuleType5262); 

                            	        	newLeafNode(otherlv_5, grammarAccess.getModuleTypeAccess().getCommaKeyword_0_1_2_2_0());
                            	        
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2392:1: ( (lv_params_6_0= ruleSimpleExpression ) )
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2393:1: (lv_params_6_0= ruleSimpleExpression )
                            	    {
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2393:1: (lv_params_6_0= ruleSimpleExpression )
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2394:3: lv_params_6_0= ruleSimpleExpression
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getModuleTypeAccess().getParamsSimpleExpressionParserRuleCall_0_1_2_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSimpleExpression_in_ruleModuleType5283);
                            	    lv_params_6_0=ruleSimpleExpression();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getModuleTypeRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"params",
                            	            		lv_params_6_0, 
                            	            		"SimpleExpression");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop31;
                                }
                            } while (true);

                            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleModuleType5297); 

                                	newLeafNode(otherlv_7, grammarAccess.getModuleTypeAccess().getRightParenthesisKeyword_0_1_2_3());
                                

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2415:6: ( () ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? ) )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2415:6: ( () ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2415:7: () ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2415:7: ()
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2416:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getModuleTypeAccess().getSyncrProcessTypeAction_1_0(),
                                current);
                        

                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2421:2: ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )? )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2421:3: ( (otherlv_9= RULE_ID ) ) (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )?
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2421:3: ( (otherlv_9= RULE_ID ) )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2422:1: (otherlv_9= RULE_ID )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2422:1: (otherlv_9= RULE_ID )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2423:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getModuleTypeRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModuleType5338); 

                    		newLeafNode(otherlv_9, grammarAccess.getModuleTypeAccess().getModuleModuleCrossReference_1_1_0_0()); 
                    	

                    }


                    }

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2434:2: (otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==15) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2434:4: otherlv_10= '(' ( (lv_params_11_0= ruleSimpleExpression ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )* otherlv_14= ')'
                            {
                            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleModuleType5351); 

                                	newLeafNode(otherlv_10, grammarAccess.getModuleTypeAccess().getLeftParenthesisKeyword_1_1_1_0());
                                
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2438:1: ( (lv_params_11_0= ruleSimpleExpression ) )
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2439:1: (lv_params_11_0= ruleSimpleExpression )
                            {
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2439:1: (lv_params_11_0= ruleSimpleExpression )
                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2440:3: lv_params_11_0= ruleSimpleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getModuleTypeAccess().getParamsSimpleExpressionParserRuleCall_1_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleModuleType5372);
                            lv_params_11_0=ruleSimpleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModuleTypeRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"params",
                                    		lv_params_11_0, 
                                    		"SimpleExpression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2456:2: (otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==16) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2456:4: otherlv_12= ',' ( (lv_params_13_0= ruleSimpleExpression ) )
                            	    {
                            	    otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleModuleType5385); 

                            	        	newLeafNode(otherlv_12, grammarAccess.getModuleTypeAccess().getCommaKeyword_1_1_1_2_0());
                            	        
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2460:1: ( (lv_params_13_0= ruleSimpleExpression ) )
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2461:1: (lv_params_13_0= ruleSimpleExpression )
                            	    {
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2461:1: (lv_params_13_0= ruleSimpleExpression )
                            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2462:3: lv_params_13_0= ruleSimpleExpression
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getModuleTypeAccess().getParamsSimpleExpressionParserRuleCall_1_1_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleSimpleExpression_in_ruleModuleType5406);
                            	    lv_params_13_0=ruleSimpleExpression();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getModuleTypeRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"params",
                            	            		lv_params_13_0, 
                            	            		"SimpleExpression");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);

                            otherlv_14=(Token)match(input,17,FOLLOW_17_in_ruleModuleType5420); 

                                	newLeafNode(otherlv_14, grammarAccess.getModuleTypeAccess().getRightParenthesisKeyword_1_1_1_3());
                                

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleModuleType"


    // $ANTLR start "entryRuleFormalParameter"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2493:1: entryRuleFormalParameter returns [EObject current=null] : iv_ruleFormalParameter= ruleFormalParameter EOF ;
    public final EObject entryRuleFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormalParameter = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2494:2: (iv_ruleFormalParameter= ruleFormalParameter EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2495:2: iv_ruleFormalParameter= ruleFormalParameter EOF
            {
             newCompositeNode(grammarAccess.getFormalParameterRule()); 
            pushFollow(FOLLOW_ruleFormalParameter_in_entryRuleFormalParameter5464);
            iv_ruleFormalParameter=ruleFormalParameter();

            state._fsp--;

             current =iv_ruleFormalParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormalParameter5474); 

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
    // $ANTLR end "entryRuleFormalParameter"


    // $ANTLR start "ruleFormalParameter"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2502:1: ruleFormalParameter returns [EObject current=null] : ( (lv_paramId_0_0= RULE_ID ) ) ;
    public final EObject ruleFormalParameter() throws RecognitionException {
        EObject current = null;

        Token lv_paramId_0_0=null;

         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2505:28: ( ( (lv_paramId_0_0= RULE_ID ) ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2506:1: ( (lv_paramId_0_0= RULE_ID ) )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2506:1: ( (lv_paramId_0_0= RULE_ID ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2507:1: (lv_paramId_0_0= RULE_ID )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2507:1: (lv_paramId_0_0= RULE_ID )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2508:3: lv_paramId_0_0= RULE_ID
            {
            lv_paramId_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFormalParameter5515); 

            			newLeafNode(lv_paramId_0_0, grammarAccess.getFormalParameterAccess().getParamIdIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFormalParameterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"paramId",
                    		lv_paramId_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormalParameter"


    // $ANTLR start "entryRuleSimpleExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2532:1: entryRuleSimpleExpression returns [String current=null] : iv_ruleSimpleExpression= ruleSimpleExpression EOF ;
    public final String entryRuleSimpleExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpleExpression = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2536:2: (iv_ruleSimpleExpression= ruleSimpleExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2537:2: iv_ruleSimpleExpression= ruleSimpleExpression EOF
            {
             newCompositeNode(grammarAccess.getSimpleExpressionRule()); 
            pushFollow(FOLLOW_ruleSimpleExpression_in_entryRuleSimpleExpression5562);
            iv_ruleSimpleExpression=ruleSimpleExpression();

            state._fsp--;

             current =iv_ruleSimpleExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleExpression5573); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleExpression"


    // $ANTLR start "ruleSimpleExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2547:1: ruleSimpleExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BinaryExpression_0= ruleBinaryExpression ;
    public final AntlrDatatypeRuleToken ruleSimpleExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BinaryExpression_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2551:28: (this_BinaryExpression_0= ruleBinaryExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2553:5: this_BinaryExpression_0= ruleBinaryExpression
            {
             
                    newCompositeNode(grammarAccess.getSimpleExpressionAccess().getBinaryExpressionParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleBinaryExpression_in_ruleSimpleExpression5623);
            this_BinaryExpression_0=ruleBinaryExpression();

            state._fsp--;


            		current.merge(this_BinaryExpression_0);
                
             
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleSimpleExpression"


    // $ANTLR start "entryRuleBinaryExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2574:1: entryRuleBinaryExpression returns [String current=null] : iv_ruleBinaryExpression= ruleBinaryExpression EOF ;
    public final String entryRuleBinaryExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2575:2: (iv_ruleBinaryExpression= ruleBinaryExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2576:2: iv_ruleBinaryExpression= ruleBinaryExpression EOF
            {
             newCompositeNode(grammarAccess.getBinaryExpressionRule()); 
            pushFollow(FOLLOW_ruleBinaryExpression_in_entryRuleBinaryExpression5672);
            iv_ruleBinaryExpression=ruleBinaryExpression();

            state._fsp--;

             current =iv_ruleBinaryExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinaryExpression5683); 

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
    // $ANTLR end "entryRuleBinaryExpression"


    // $ANTLR start "ruleBinaryExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2583:1: ruleBinaryExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_TerminalSimpleExpression_0= ruleTerminalSimpleExpression (this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression )* ) ;
    public final AntlrDatatypeRuleToken ruleBinaryExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_TerminalSimpleExpression_0 = null;

        AntlrDatatypeRuleToken this_BinaryOperator_1 = null;

        AntlrDatatypeRuleToken this_TerminalSimpleExpression_2 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2586:28: ( (this_TerminalSimpleExpression_0= ruleTerminalSimpleExpression (this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression )* ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2587:1: (this_TerminalSimpleExpression_0= ruleTerminalSimpleExpression (this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression )* )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2587:1: (this_TerminalSimpleExpression_0= ruleTerminalSimpleExpression (this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression )* )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2588:5: this_TerminalSimpleExpression_0= ruleTerminalSimpleExpression (this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression )*
            {
             
                    newCompositeNode(grammarAccess.getBinaryExpressionAccess().getTerminalSimpleExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleTerminalSimpleExpression_in_ruleBinaryExpression5730);
            this_TerminalSimpleExpression_0=ruleTerminalSimpleExpression();

            state._fsp--;


            		current.merge(this_TerminalSimpleExpression_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2598:1: (this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2599:5: this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression
            	    {
            	     
            	            newCompositeNode(grammarAccess.getBinaryExpressionAccess().getBinaryOperatorParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_ruleBinaryOperator_in_ruleBinaryExpression5758);
            	    this_BinaryOperator_1=ruleBinaryOperator();

            	    state._fsp--;


            	    		current.merge(this_BinaryOperator_1);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        
            	     
            	            newCompositeNode(grammarAccess.getBinaryExpressionAccess().getTerminalSimpleExpressionParserRuleCall_1_1()); 
            	        
            	    pushFollow(FOLLOW_ruleTerminalSimpleExpression_in_ruleBinaryExpression5785);
            	    this_TerminalSimpleExpression_2=ruleTerminalSimpleExpression();

            	    state._fsp--;


            	    		current.merge(this_TerminalSimpleExpression_2);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryExpression"


    // $ANTLR start "entryRuleTerminalSimpleExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2628:1: entryRuleTerminalSimpleExpression returns [String current=null] : iv_ruleTerminalSimpleExpression= ruleTerminalSimpleExpression EOF ;
    public final String entryRuleTerminalSimpleExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTerminalSimpleExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2629:2: (iv_ruleTerminalSimpleExpression= ruleTerminalSimpleExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2630:2: iv_ruleTerminalSimpleExpression= ruleTerminalSimpleExpression EOF
            {
             newCompositeNode(grammarAccess.getTerminalSimpleExpressionRule()); 
            pushFollow(FOLLOW_ruleTerminalSimpleExpression_in_entryRuleTerminalSimpleExpression5833);
            iv_ruleTerminalSimpleExpression=ruleTerminalSimpleExpression();

            state._fsp--;

             current =iv_ruleTerminalSimpleExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalSimpleExpression5844); 

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
    // $ANTLR end "entryRuleTerminalSimpleExpression"


    // $ANTLR start "ruleTerminalSimpleExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2637:1: ruleTerminalSimpleExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NextExpression_2= ruleNextExpression | this_BracketExpression_3= ruleBracketExpression | this_UnaryExpression_4= ruleUnaryExpression | this_CaseExpression_5= ruleCaseExpression | this_SetExpression_6= ruleSetExpression | this_EAExpression_7= ruleEAExpression | this_BoolWordConvertExpression_8= ruleBoolWordConvertExpression ) ;
    public final AntlrDatatypeRuleToken ruleTerminalSimpleExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Literal_0 = null;

        AntlrDatatypeRuleToken this_Range_1 = null;

        AntlrDatatypeRuleToken this_NextExpression_2 = null;

        AntlrDatatypeRuleToken this_BracketExpression_3 = null;

        AntlrDatatypeRuleToken this_UnaryExpression_4 = null;

        AntlrDatatypeRuleToken this_CaseExpression_5 = null;

        AntlrDatatypeRuleToken this_SetExpression_6 = null;

        AntlrDatatypeRuleToken this_EAExpression_7 = null;

        AntlrDatatypeRuleToken this_BoolWordConvertExpression_8 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2640:28: ( (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NextExpression_2= ruleNextExpression | this_BracketExpression_3= ruleBracketExpression | this_UnaryExpression_4= ruleUnaryExpression | this_CaseExpression_5= ruleCaseExpression | this_SetExpression_6= ruleSetExpression | this_EAExpression_7= ruleEAExpression | this_BoolWordConvertExpression_8= ruleBoolWordConvertExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2641:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NextExpression_2= ruleNextExpression | this_BracketExpression_3= ruleBracketExpression | this_UnaryExpression_4= ruleUnaryExpression | this_CaseExpression_5= ruleCaseExpression | this_SetExpression_6= ruleSetExpression | this_EAExpression_7= ruleEAExpression | this_BoolWordConvertExpression_8= ruleBoolWordConvertExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2641:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NextExpression_2= ruleNextExpression | this_BracketExpression_3= ruleBracketExpression | this_UnaryExpression_4= ruleUnaryExpression | this_CaseExpression_5= ruleCaseExpression | this_SetExpression_6= ruleSetExpression | this_EAExpression_7= ruleEAExpression | this_BoolWordConvertExpression_8= ruleBoolWordConvertExpression )
            int alt37=9;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2642:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleTerminalSimpleExpression5891);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;


                    		current.merge(this_Literal_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2654:5: this_Range_1= ruleRange
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getRangeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRange_in_ruleTerminalSimpleExpression5924);
                    this_Range_1=ruleRange();

                    state._fsp--;


                    		current.merge(this_Range_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2666:5: this_NextExpression_2= ruleNextExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getNextExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNextExpression_in_ruleTerminalSimpleExpression5957);
                    this_NextExpression_2=ruleNextExpression();

                    state._fsp--;


                    		current.merge(this_NextExpression_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2678:5: this_BracketExpression_3= ruleBracketExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getBracketExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleBracketExpression_in_ruleTerminalSimpleExpression5990);
                    this_BracketExpression_3=ruleBracketExpression();

                    state._fsp--;


                    		current.merge(this_BracketExpression_3);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2690:5: this_UnaryExpression_4= ruleUnaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getUnaryExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleTerminalSimpleExpression6023);
                    this_UnaryExpression_4=ruleUnaryExpression();

                    state._fsp--;


                    		current.merge(this_UnaryExpression_4);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2702:5: this_CaseExpression_5= ruleCaseExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getCaseExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleCaseExpression_in_ruleTerminalSimpleExpression6056);
                    this_CaseExpression_5=ruleCaseExpression();

                    state._fsp--;


                    		current.merge(this_CaseExpression_5);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2714:5: this_SetExpression_6= ruleSetExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getSetExpressionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleSetExpression_in_ruleTerminalSimpleExpression6089);
                    this_SetExpression_6=ruleSetExpression();

                    state._fsp--;


                    		current.merge(this_SetExpression_6);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2726:5: this_EAExpression_7= ruleEAExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getEAExpressionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleEAExpression_in_ruleTerminalSimpleExpression6122);
                    this_EAExpression_7=ruleEAExpression();

                    state._fsp--;


                    		current.merge(this_EAExpression_7);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2738:5: this_BoolWordConvertExpression_8= ruleBoolWordConvertExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTerminalSimpleExpressionAccess().getBoolWordConvertExpressionParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleBoolWordConvertExpression_in_ruleTerminalSimpleExpression6155);
                    this_BoolWordConvertExpression_8=ruleBoolWordConvertExpression();

                    state._fsp--;


                    		current.merge(this_BoolWordConvertExpression_8);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalSimpleExpression"


    // $ANTLR start "entryRuleNextExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2756:1: entryRuleNextExpression returns [String current=null] : iv_ruleNextExpression= ruleNextExpression EOF ;
    public final String entryRuleNextExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNextExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2757:2: (iv_ruleNextExpression= ruleNextExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2758:2: iv_ruleNextExpression= ruleNextExpression EOF
            {
             newCompositeNode(grammarAccess.getNextExpressionRule()); 
            pushFollow(FOLLOW_ruleNextExpression_in_entryRuleNextExpression6201);
            iv_ruleNextExpression=ruleNextExpression();

            state._fsp--;

             current =iv_ruleNextExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNextExpression6212); 

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
    // $ANTLR end "entryRuleNextExpression"


    // $ANTLR start "ruleNextExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2765:1: ruleNextExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'next' kw= '(' this_SimpleExpression_2= ruleSimpleExpression kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleNextExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleExpression_2 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2768:28: ( (kw= 'next' kw= '(' this_SimpleExpression_2= ruleSimpleExpression kw= ')' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2769:1: (kw= 'next' kw= '(' this_SimpleExpression_2= ruleSimpleExpression kw= ')' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2769:1: (kw= 'next' kw= '(' this_SimpleExpression_2= ruleSimpleExpression kw= ')' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2770:2: kw= 'next' kw= '(' this_SimpleExpression_2= ruleSimpleExpression kw= ')'
            {
            kw=(Token)match(input,28,FOLLOW_28_in_ruleNextExpression6250); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNextExpressionAccess().getNextKeyword_0()); 
                
            kw=(Token)match(input,15,FOLLOW_15_in_ruleNextExpression6263); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNextExpressionAccess().getLeftParenthesisKeyword_1()); 
                
             
                    newCompositeNode(grammarAccess.getNextExpressionAccess().getSimpleExpressionParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleNextExpression6285);
            this_SimpleExpression_2=ruleSimpleExpression();

            state._fsp--;


            		current.merge(this_SimpleExpression_2);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,17,FOLLOW_17_in_ruleNextExpression6303); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNextExpressionAccess().getRightParenthesisKeyword_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextExpression"


    // $ANTLR start "entryRuleBracketExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2806:1: entryRuleBracketExpression returns [String current=null] : iv_ruleBracketExpression= ruleBracketExpression EOF ;
    public final String entryRuleBracketExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBracketExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2807:2: (iv_ruleBracketExpression= ruleBracketExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2808:2: iv_ruleBracketExpression= ruleBracketExpression EOF
            {
             newCompositeNode(grammarAccess.getBracketExpressionRule()); 
            pushFollow(FOLLOW_ruleBracketExpression_in_entryRuleBracketExpression6344);
            iv_ruleBracketExpression=ruleBracketExpression();

            state._fsp--;

             current =iv_ruleBracketExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBracketExpression6355); 

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
    // $ANTLR end "entryRuleBracketExpression"


    // $ANTLR start "ruleBracketExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2815:1: ruleBracketExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' this_SimpleExpression_1= ruleSimpleExpression kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleBracketExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleExpression_1 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2818:28: ( (kw= '(' this_SimpleExpression_1= ruleSimpleExpression kw= ')' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2819:1: (kw= '(' this_SimpleExpression_1= ruleSimpleExpression kw= ')' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2819:1: (kw= '(' this_SimpleExpression_1= ruleSimpleExpression kw= ')' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2820:2: kw= '(' this_SimpleExpression_1= ruleSimpleExpression kw= ')'
            {
            kw=(Token)match(input,15,FOLLOW_15_in_ruleBracketExpression6393); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getBracketExpressionAccess().getLeftParenthesisKeyword_0()); 
                
             
                    newCompositeNode(grammarAccess.getBracketExpressionAccess().getSimpleExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleBracketExpression6415);
            this_SimpleExpression_1=ruleSimpleExpression();

            state._fsp--;


            		current.merge(this_SimpleExpression_1);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,17,FOLLOW_17_in_ruleBracketExpression6433); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getBracketExpressionAccess().getRightParenthesisKeyword_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBracketExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2850:1: entryRuleUnaryExpression returns [String current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final String entryRuleUnaryExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2851:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2852:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6474);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6485); 

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2859:1: ruleUnaryExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnaryOperator_0= ruleUnaryOperator this_SimpleExpression_1= ruleSimpleExpression ) ;
    public final AntlrDatatypeRuleToken ruleUnaryExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_UnaryOperator_0 = null;

        AntlrDatatypeRuleToken this_SimpleExpression_1 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2862:28: ( (this_UnaryOperator_0= ruleUnaryOperator this_SimpleExpression_1= ruleSimpleExpression ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2863:1: (this_UnaryOperator_0= ruleUnaryOperator this_SimpleExpression_1= ruleSimpleExpression )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2863:1: (this_UnaryOperator_0= ruleUnaryOperator this_SimpleExpression_1= ruleSimpleExpression )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2864:5: this_UnaryOperator_0= ruleUnaryOperator this_SimpleExpression_1= ruleSimpleExpression
            {
             
                    newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOperatorParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6532);
            this_UnaryOperator_0=ruleUnaryOperator();

            state._fsp--;


            		current.merge(this_UnaryOperator_0);
                
             
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getUnaryExpressionAccess().getSimpleExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleUnaryExpression6559);
            this_SimpleExpression_1=ruleSimpleExpression();

            state._fsp--;


            		current.merge(this_SimpleExpression_1);
                
             
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleCaseExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2893:1: entryRuleCaseExpression returns [String current=null] : iv_ruleCaseExpression= ruleCaseExpression EOF ;
    public final String entryRuleCaseExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCaseExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2894:2: (iv_ruleCaseExpression= ruleCaseExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2895:2: iv_ruleCaseExpression= ruleCaseExpression EOF
            {
             newCompositeNode(grammarAccess.getCaseExpressionRule()); 
            pushFollow(FOLLOW_ruleCaseExpression_in_entryRuleCaseExpression6605);
            iv_ruleCaseExpression=ruleCaseExpression();

            state._fsp--;

             current =iv_ruleCaseExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExpression6616); 

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
    // $ANTLR end "entryRuleCaseExpression"


    // $ANTLR start "ruleCaseExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2902:1: ruleCaseExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'case' (this_SimpleExpression_1= ruleSimpleExpression kw= ':' this_SimpleExpression_3= ruleSimpleExpression kw= ';' )+ kw= 'esac' ) ;
    public final AntlrDatatypeRuleToken ruleCaseExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleExpression_1 = null;

        AntlrDatatypeRuleToken this_SimpleExpression_3 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2905:28: ( (kw= 'case' (this_SimpleExpression_1= ruleSimpleExpression kw= ':' this_SimpleExpression_3= ruleSimpleExpression kw= ';' )+ kw= 'esac' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2906:1: (kw= 'case' (this_SimpleExpression_1= ruleSimpleExpression kw= ':' this_SimpleExpression_3= ruleSimpleExpression kw= ';' )+ kw= 'esac' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2906:1: (kw= 'case' (this_SimpleExpression_1= ruleSimpleExpression kw= ':' this_SimpleExpression_3= ruleSimpleExpression kw= ';' )+ kw= 'esac' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2907:2: kw= 'case' (this_SimpleExpression_1= ruleSimpleExpression kw= ':' this_SimpleExpression_3= ruleSimpleExpression kw= ';' )+ kw= 'esac'
            {
            kw=(Token)match(input,52,FOLLOW_52_in_ruleCaseExpression6654); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getCaseExpressionAccess().getCaseKeyword_0()); 
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2912:1: (this_SimpleExpression_1= ruleSimpleExpression kw= ':' this_SimpleExpression_3= ruleSimpleExpression kw= ';' )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_NUMBER)||LA38_0==15||LA38_0==28||LA38_0==46||LA38_0==52||(LA38_0>=54 && LA38_0<=59)||(LA38_0>=76 && LA38_0<=77)||(LA38_0>=86 && LA38_0<=100)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2913:5: this_SimpleExpression_1= ruleSimpleExpression kw= ':' this_SimpleExpression_3= ruleSimpleExpression kw= ';'
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCaseExpressionAccess().getSimpleExpressionParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_ruleSimpleExpression_in_ruleCaseExpression6677);
            	    this_SimpleExpression_1=ruleSimpleExpression();

            	    state._fsp--;


            	    		current.merge(this_SimpleExpression_1);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    kw=(Token)match(input,21,FOLLOW_21_in_ruleCaseExpression6695); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getCaseExpressionAccess().getColonKeyword_1_1()); 
            	        
            	     
            	            newCompositeNode(grammarAccess.getCaseExpressionAccess().getSimpleExpressionParserRuleCall_1_2()); 
            	        
            	    pushFollow(FOLLOW_ruleSimpleExpression_in_ruleCaseExpression6717);
            	    this_SimpleExpression_3=ruleSimpleExpression();

            	    state._fsp--;


            	    		current.merge(this_SimpleExpression_3);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleCaseExpression6735); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getCaseExpressionAccess().getSemicolonKeyword_1_3()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            kw=(Token)match(input,53,FOLLOW_53_in_ruleCaseExpression6750); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getCaseExpressionAccess().getEsacKeyword_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseExpression"


    // $ANTLR start "entryRuleSetExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2960:1: entryRuleSetExpression returns [String current=null] : iv_ruleSetExpression= ruleSetExpression EOF ;
    public final String entryRuleSetExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSetExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2961:2: (iv_ruleSetExpression= ruleSetExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2962:2: iv_ruleSetExpression= ruleSetExpression EOF
            {
             newCompositeNode(grammarAccess.getSetExpressionRule()); 
            pushFollow(FOLLOW_ruleSetExpression_in_entryRuleSetExpression6791);
            iv_ruleSetExpression=ruleSetExpression();

            state._fsp--;

             current =iv_ruleSetExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSetExpression6802); 

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
    // $ANTLR end "entryRuleSetExpression"


    // $ANTLR start "ruleSetExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2969:1: ruleSetExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' this_SimpleExpression_1= ruleSimpleExpression (kw= ',' this_SimpleExpression_3= ruleSimpleExpression )* kw= '}' ) ;
    public final AntlrDatatypeRuleToken ruleSetExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleExpression_1 = null;

        AntlrDatatypeRuleToken this_SimpleExpression_3 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2972:28: ( (kw= '{' this_SimpleExpression_1= ruleSimpleExpression (kw= ',' this_SimpleExpression_3= ruleSimpleExpression )* kw= '}' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2973:1: (kw= '{' this_SimpleExpression_1= ruleSimpleExpression (kw= ',' this_SimpleExpression_3= ruleSimpleExpression )* kw= '}' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2973:1: (kw= '{' this_SimpleExpression_1= ruleSimpleExpression (kw= ',' this_SimpleExpression_3= ruleSimpleExpression )* kw= '}' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2974:2: kw= '{' this_SimpleExpression_1= ruleSimpleExpression (kw= ',' this_SimpleExpression_3= ruleSimpleExpression )* kw= '}'
            {
            kw=(Token)match(input,46,FOLLOW_46_in_ruleSetExpression6840); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSetExpressionAccess().getLeftCurlyBracketKeyword_0()); 
                
             
                    newCompositeNode(grammarAccess.getSetExpressionAccess().getSimpleExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleSetExpression6862);
            this_SimpleExpression_1=ruleSimpleExpression();

            state._fsp--;


            		current.merge(this_SimpleExpression_1);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2990:1: (kw= ',' this_SimpleExpression_3= ruleSimpleExpression )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==16) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:2991:2: kw= ',' this_SimpleExpression_3= ruleSimpleExpression
            	    {
            	    kw=(Token)match(input,16,FOLLOW_16_in_ruleSetExpression6881); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSetExpressionAccess().getCommaKeyword_2_0()); 
            	        
            	     
            	            newCompositeNode(grammarAccess.getSetExpressionAccess().getSimpleExpressionParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_ruleSimpleExpression_in_ruleSetExpression6903);
            	    this_SimpleExpression_3=ruleSimpleExpression();

            	    state._fsp--;


            	    		current.merge(this_SimpleExpression_3);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            kw=(Token)match(input,47,FOLLOW_47_in_ruleSetExpression6923); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSetExpressionAccess().getRightCurlyBracketKeyword_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetExpression"


    // $ANTLR start "entryRuleEAExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3021:1: entryRuleEAExpression returns [String current=null] : iv_ruleEAExpression= ruleEAExpression EOF ;
    public final String entryRuleEAExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEAExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3022:2: (iv_ruleEAExpression= ruleEAExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3023:2: iv_ruleEAExpression= ruleEAExpression EOF
            {
             newCompositeNode(grammarAccess.getEAExpressionRule()); 
            pushFollow(FOLLOW_ruleEAExpression_in_entryRuleEAExpression6964);
            iv_ruleEAExpression=ruleEAExpression();

            state._fsp--;

             current =iv_ruleEAExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEAExpression6975); 

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
    // $ANTLR end "entryRuleEAExpression"


    // $ANTLR start "ruleEAExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3030:1: ruleEAExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'E' | kw= 'A' ) kw= '[' this_SimpleExpression_3= ruleSimpleExpression kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleEAExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleExpression_3 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3033:28: ( ( (kw= 'E' | kw= 'A' ) kw= '[' this_SimpleExpression_3= ruleSimpleExpression kw= ']' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3034:1: ( (kw= 'E' | kw= 'A' ) kw= '[' this_SimpleExpression_3= ruleSimpleExpression kw= ']' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3034:1: ( (kw= 'E' | kw= 'A' ) kw= '[' this_SimpleExpression_3= ruleSimpleExpression kw= ']' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3034:2: (kw= 'E' | kw= 'A' ) kw= '[' this_SimpleExpression_3= ruleSimpleExpression kw= ']'
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3034:2: (kw= 'E' | kw= 'A' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==54) ) {
                alt40=1;
            }
            else if ( (LA40_0==55) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3035:2: kw= 'E'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleEAExpression7014); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEAExpressionAccess().getEKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3042:2: kw= 'A'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleEAExpression7033); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEAExpressionAccess().getAKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,42,FOLLOW_42_in_ruleEAExpression7047); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEAExpressionAccess().getLeftSquareBracketKeyword_1()); 
                
             
                    newCompositeNode(grammarAccess.getEAExpressionAccess().getSimpleExpressionParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleEAExpression7069);
            this_SimpleExpression_3=ruleSimpleExpression();

            state._fsp--;


            		current.merge(this_SimpleExpression_3);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,43,FOLLOW_43_in_ruleEAExpression7087); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEAExpressionAccess().getRightSquareBracketKeyword_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEAExpression"


    // $ANTLR start "entryRuleBoolWordConvertExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3078:1: entryRuleBoolWordConvertExpression returns [String current=null] : iv_ruleBoolWordConvertExpression= ruleBoolWordConvertExpression EOF ;
    public final String entryRuleBoolWordConvertExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBoolWordConvertExpression = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3079:2: (iv_ruleBoolWordConvertExpression= ruleBoolWordConvertExpression EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3080:2: iv_ruleBoolWordConvertExpression= ruleBoolWordConvertExpression EOF
            {
             newCompositeNode(grammarAccess.getBoolWordConvertExpressionRule()); 
            pushFollow(FOLLOW_ruleBoolWordConvertExpression_in_entryRuleBoolWordConvertExpression7128);
            iv_ruleBoolWordConvertExpression=ruleBoolWordConvertExpression();

            state._fsp--;

             current =iv_ruleBoolWordConvertExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolWordConvertExpression7139); 

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
    // $ANTLR end "entryRuleBoolWordConvertExpression"


    // $ANTLR start "ruleBoolWordConvertExpression"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3087:1: ruleBoolWordConvertExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= 'word1' | kw= 'bool' ) kw= '(' this_SimpleExpression_3= ruleSimpleExpression kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleBoolWordConvertExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleExpression_3 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3090:28: ( ( (kw= 'word1' | kw= 'bool' ) kw= '(' this_SimpleExpression_3= ruleSimpleExpression kw= ')' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3091:1: ( (kw= 'word1' | kw= 'bool' ) kw= '(' this_SimpleExpression_3= ruleSimpleExpression kw= ')' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3091:1: ( (kw= 'word1' | kw= 'bool' ) kw= '(' this_SimpleExpression_3= ruleSimpleExpression kw= ')' )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3091:2: (kw= 'word1' | kw= 'bool' ) kw= '(' this_SimpleExpression_3= ruleSimpleExpression kw= ')'
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3091:2: (kw= 'word1' | kw= 'bool' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==56) ) {
                alt41=1;
            }
            else if ( (LA41_0==57) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3092:2: kw= 'word1'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleBoolWordConvertExpression7178); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBoolWordConvertExpressionAccess().getWord1Keyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3099:2: kw= 'bool'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleBoolWordConvertExpression7197); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBoolWordConvertExpressionAccess().getBoolKeyword_0_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_15_in_ruleBoolWordConvertExpression7211); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getBoolWordConvertExpressionAccess().getLeftParenthesisKeyword_1()); 
                
             
                    newCompositeNode(grammarAccess.getBoolWordConvertExpressionAccess().getSimpleExpressionParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleSimpleExpression_in_ruleBoolWordConvertExpression7233);
            this_SimpleExpression_3=ruleSimpleExpression();

            state._fsp--;


            		current.merge(this_SimpleExpression_3);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,17,FOLLOW_17_in_ruleBoolWordConvertExpression7251); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getBoolWordConvertExpressionAccess().getRightParenthesisKeyword_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolWordConvertExpression"


    // $ANTLR start "entryRuleBooleanConstant"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3135:1: entryRuleBooleanConstant returns [String current=null] : iv_ruleBooleanConstant= ruleBooleanConstant EOF ;
    public final String entryRuleBooleanConstant() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBooleanConstant = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3136:2: (iv_ruleBooleanConstant= ruleBooleanConstant EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3137:2: iv_ruleBooleanConstant= ruleBooleanConstant EOF
            {
             newCompositeNode(grammarAccess.getBooleanConstantRule()); 
            pushFollow(FOLLOW_ruleBooleanConstant_in_entryRuleBooleanConstant7292);
            iv_ruleBooleanConstant=ruleBooleanConstant();

            state._fsp--;

             current =iv_ruleBooleanConstant.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanConstant7303); 

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
    // $ANTLR end "entryRuleBooleanConstant"


    // $ANTLR start "ruleBooleanConstant"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3144:1: ruleBooleanConstant returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'TRUE' | kw= 'FALSE' ) ;
    public final AntlrDatatypeRuleToken ruleBooleanConstant() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3147:28: ( (kw= 'TRUE' | kw= 'FALSE' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3148:1: (kw= 'TRUE' | kw= 'FALSE' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3148:1: (kw= 'TRUE' | kw= 'FALSE' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==58) ) {
                alt42=1;
            }
            else if ( (LA42_0==59) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3149:2: kw= 'TRUE'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleBooleanConstant7341); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanConstantAccess().getTRUEKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3156:2: kw= 'FALSE'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleBooleanConstant7360); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanConstantAccess().getFALSEKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanConstant"


    // $ANTLR start "entryRuleBinaryOperator"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3169:1: entryRuleBinaryOperator returns [String current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final String entryRuleBinaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOperator = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3170:2: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3171:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator7401);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinaryOperator7412); 

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
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3178:1: ruleBinaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'U' | kw= 'V' | kw= 'S' | kw= 'T' | kw= '->' | kw= '<->' | kw= '&' | kw= '|' | kw= 'xor' | kw= 'xnor' | kw= '=' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '::' | kw= '<<' | kw= '>>' | kw= 'union' | kw= 'in' | kw= 'mod' ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3181:28: ( (kw= 'U' | kw= 'V' | kw= 'S' | kw= 'T' | kw= '->' | kw= '<->' | kw= '&' | kw= '|' | kw= 'xor' | kw= 'xnor' | kw= '=' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '::' | kw= '<<' | kw= '>>' | kw= 'union' | kw= 'in' | kw= 'mod' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3182:1: (kw= 'U' | kw= 'V' | kw= 'S' | kw= 'T' | kw= '->' | kw= '<->' | kw= '&' | kw= '|' | kw= 'xor' | kw= 'xnor' | kw= '=' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '::' | kw= '<<' | kw= '>>' | kw= 'union' | kw= 'in' | kw= 'mod' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3182:1: (kw= 'U' | kw= 'V' | kw= 'S' | kw= 'T' | kw= '->' | kw= '<->' | kw= '&' | kw= '|' | kw= 'xor' | kw= 'xnor' | kw= '=' | kw= '!=' | kw= '<' | kw= '>' | kw= '<=' | kw= '>=' | kw= '+' | kw= '-' | kw= '*' | kw= '/' | kw= '::' | kw= '<<' | kw= '>>' | kw= 'union' | kw= 'in' | kw= 'mod' )
            int alt43=26;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt43=1;
                }
                break;
            case 61:
                {
                alt43=2;
                }
                break;
            case 62:
                {
                alt43=3;
                }
                break;
            case 63:
                {
                alt43=4;
                }
                break;
            case 64:
                {
                alt43=5;
                }
                break;
            case 65:
                {
                alt43=6;
                }
                break;
            case 66:
                {
                alt43=7;
                }
                break;
            case 67:
                {
                alt43=8;
                }
                break;
            case 68:
                {
                alt43=9;
                }
                break;
            case 69:
                {
                alt43=10;
                }
                break;
            case 70:
                {
                alt43=11;
                }
                break;
            case 71:
                {
                alt43=12;
                }
                break;
            case 72:
                {
                alt43=13;
                }
                break;
            case 73:
                {
                alt43=14;
                }
                break;
            case 74:
                {
                alt43=15;
                }
                break;
            case 75:
                {
                alt43=16;
                }
                break;
            case 76:
                {
                alt43=17;
                }
                break;
            case 77:
                {
                alt43=18;
                }
                break;
            case 78:
                {
                alt43=19;
                }
                break;
            case 79:
                {
                alt43=20;
                }
                break;
            case 80:
                {
                alt43=21;
                }
                break;
            case 81:
                {
                alt43=22;
                }
                break;
            case 82:
                {
                alt43=23;
                }
                break;
            case 83:
                {
                alt43=24;
                }
                break;
            case 84:
                {
                alt43=25;
                }
                break;
            case 85:
                {
                alt43=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3183:2: kw= 'U'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleBinaryOperator7450); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getUKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3190:2: kw= 'V'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleBinaryOperator7469); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getVKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3197:2: kw= 'S'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleBinaryOperator7488); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getSKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3204:2: kw= 'T'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleBinaryOperator7507); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getTKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3211:2: kw= '->'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleBinaryOperator7526); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3218:2: kw= '<->'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleBinaryOperator7545); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3225:2: kw= '&'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleBinaryOperator7564); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getAmpersandKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3232:2: kw= '|'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleBinaryOperator7583); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getVerticalLineKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3239:2: kw= 'xor'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleBinaryOperator7602); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getXorKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3246:2: kw= 'xnor'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleBinaryOperator7621); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getXnorKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3253:2: kw= '='
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleBinaryOperator7640); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getEqualsSignKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3260:2: kw= '!='
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleBinaryOperator7659); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getExclamationMarkEqualsSignKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3267:2: kw= '<'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleBinaryOperator7678); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getLessThanSignKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3274:2: kw= '>'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleBinaryOperator7697); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getGreaterThanSignKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3281:2: kw= '<='
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleBinaryOperator7716); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getLessThanSignEqualsSignKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3288:2: kw= '>='
                    {
                    kw=(Token)match(input,75,FOLLOW_75_in_ruleBinaryOperator7735); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getGreaterThanSignEqualsSignKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3295:2: kw= '+'
                    {
                    kw=(Token)match(input,76,FOLLOW_76_in_ruleBinaryOperator7754); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getPlusSignKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3302:2: kw= '-'
                    {
                    kw=(Token)match(input,77,FOLLOW_77_in_ruleBinaryOperator7773); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getHyphenMinusKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3309:2: kw= '*'
                    {
                    kw=(Token)match(input,78,FOLLOW_78_in_ruleBinaryOperator7792); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getAsteriskKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3316:2: kw= '/'
                    {
                    kw=(Token)match(input,79,FOLLOW_79_in_ruleBinaryOperator7811); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getSolidusKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3323:2: kw= '::'
                    {
                    kw=(Token)match(input,80,FOLLOW_80_in_ruleBinaryOperator7830); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getColonColonKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3330:2: kw= '<<'
                    {
                    kw=(Token)match(input,81,FOLLOW_81_in_ruleBinaryOperator7849); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getLessThanSignLessThanSignKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3337:2: kw= '>>'
                    {
                    kw=(Token)match(input,82,FOLLOW_82_in_ruleBinaryOperator7868); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getGreaterThanSignGreaterThanSignKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3344:2: kw= 'union'
                    {
                    kw=(Token)match(input,83,FOLLOW_83_in_ruleBinaryOperator7887); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getUnionKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3351:2: kw= 'in'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleBinaryOperator7906); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getInKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3358:2: kw= 'mod'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleBinaryOperator7925); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBinaryOperatorAccess().getModKeyword_25()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOperator"


    // $ANTLR start "entryRuleUnaryOperator"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3371:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3372:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3373:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator7966);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator7977); 

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
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3380:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= '-' | kw= '+' | kw= 'X' | kw= 'G' | kw= 'F' | kw= 'Y' | kw= 'Z' | kw= 'H' | kw= 'O' | kw= 'EG' | kw= 'EX' | kw= 'EF' | kw= 'AG' | kw= 'AX' | kw= 'AF' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3383:28: ( (kw= '!' | kw= '-' | kw= '+' | kw= 'X' | kw= 'G' | kw= 'F' | kw= 'Y' | kw= 'Z' | kw= 'H' | kw= 'O' | kw= 'EG' | kw= 'EX' | kw= 'EF' | kw= 'AG' | kw= 'AX' | kw= 'AF' ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3384:1: (kw= '!' | kw= '-' | kw= '+' | kw= 'X' | kw= 'G' | kw= 'F' | kw= 'Y' | kw= 'Z' | kw= 'H' | kw= 'O' | kw= 'EG' | kw= 'EX' | kw= 'EF' | kw= 'AG' | kw= 'AX' | kw= 'AF' )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3384:1: (kw= '!' | kw= '-' | kw= '+' | kw= 'X' | kw= 'G' | kw= 'F' | kw= 'Y' | kw= 'Z' | kw= 'H' | kw= 'O' | kw= 'EG' | kw= 'EX' | kw= 'EF' | kw= 'AG' | kw= 'AX' | kw= 'AF' )
            int alt44=16;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt44=1;
                }
                break;
            case 77:
                {
                alt44=2;
                }
                break;
            case 76:
                {
                alt44=3;
                }
                break;
            case 87:
                {
                alt44=4;
                }
                break;
            case 88:
                {
                alt44=5;
                }
                break;
            case 89:
                {
                alt44=6;
                }
                break;
            case 90:
                {
                alt44=7;
                }
                break;
            case 91:
                {
                alt44=8;
                }
                break;
            case 92:
                {
                alt44=9;
                }
                break;
            case 93:
                {
                alt44=10;
                }
                break;
            case 94:
                {
                alt44=11;
                }
                break;
            case 95:
                {
                alt44=12;
                }
                break;
            case 96:
                {
                alt44=13;
                }
                break;
            case 97:
                {
                alt44=14;
                }
                break;
            case 98:
                {
                alt44=15;
                }
                break;
            case 99:
                {
                alt44=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3385:2: kw= '!'
                    {
                    kw=(Token)match(input,86,FOLLOW_86_in_ruleUnaryOperator8015); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3392:2: kw= '-'
                    {
                    kw=(Token)match(input,77,FOLLOW_77_in_ruleUnaryOperator8034); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3399:2: kw= '+'
                    {
                    kw=(Token)match(input,76,FOLLOW_76_in_ruleUnaryOperator8053); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3406:2: kw= 'X'
                    {
                    kw=(Token)match(input,87,FOLLOW_87_in_ruleUnaryOperator8072); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getXKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3413:2: kw= 'G'
                    {
                    kw=(Token)match(input,88,FOLLOW_88_in_ruleUnaryOperator8091); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getGKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3420:2: kw= 'F'
                    {
                    kw=(Token)match(input,89,FOLLOW_89_in_ruleUnaryOperator8110); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getFKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3427:2: kw= 'Y'
                    {
                    kw=(Token)match(input,90,FOLLOW_90_in_ruleUnaryOperator8129); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getYKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3434:2: kw= 'Z'
                    {
                    kw=(Token)match(input,91,FOLLOW_91_in_ruleUnaryOperator8148); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getZKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3441:2: kw= 'H'
                    {
                    kw=(Token)match(input,92,FOLLOW_92_in_ruleUnaryOperator8167); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3448:2: kw= 'O'
                    {
                    kw=(Token)match(input,93,FOLLOW_93_in_ruleUnaryOperator8186); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getOKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3455:2: kw= 'EG'
                    {
                    kw=(Token)match(input,94,FOLLOW_94_in_ruleUnaryOperator8205); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getEGKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3462:2: kw= 'EX'
                    {
                    kw=(Token)match(input,95,FOLLOW_95_in_ruleUnaryOperator8224); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getEXKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3469:2: kw= 'EF'
                    {
                    kw=(Token)match(input,96,FOLLOW_96_in_ruleUnaryOperator8243); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getEFKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3476:2: kw= 'AG'
                    {
                    kw=(Token)match(input,97,FOLLOW_97_in_ruleUnaryOperator8262); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getAGKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3483:2: kw= 'AX'
                    {
                    kw=(Token)match(input,98,FOLLOW_98_in_ruleUnaryOperator8281); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getAXKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3490:2: kw= 'AF'
                    {
                    kw=(Token)match(input,99,FOLLOW_99_in_ruleUnaryOperator8300); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getAFKeyword_15()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRuleRange"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3503:1: entryRuleRange returns [String current=null] : iv_ruleRange= ruleRange EOF ;
    public final String entryRuleRange() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRange = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3504:2: (iv_ruleRange= ruleRange EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3505:2: iv_ruleRange= ruleRange EOF
            {
             newCompositeNode(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange8341);
            iv_ruleRange=ruleRange();

            state._fsp--;

             current =iv_ruleRange.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange8352); 

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
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3512:1: ruleRange returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUMBER_0= RULE_NUMBER kw= '..' this_NUMBER_2= RULE_NUMBER ) ;
    public final AntlrDatatypeRuleToken ruleRange() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NUMBER_0=null;
        Token kw=null;
        Token this_NUMBER_2=null;

         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3515:28: ( (this_NUMBER_0= RULE_NUMBER kw= '..' this_NUMBER_2= RULE_NUMBER ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3516:1: (this_NUMBER_0= RULE_NUMBER kw= '..' this_NUMBER_2= RULE_NUMBER )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3516:1: (this_NUMBER_0= RULE_NUMBER kw= '..' this_NUMBER_2= RULE_NUMBER )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3516:6: this_NUMBER_0= RULE_NUMBER kw= '..' this_NUMBER_2= RULE_NUMBER
            {
            this_NUMBER_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRange8392); 

            		current.merge(this_NUMBER_0);
                
             
                newLeafNode(this_NUMBER_0, grammarAccess.getRangeAccess().getNUMBERTerminalRuleCall_0()); 
                
            kw=(Token)match(input,48,FOLLOW_48_in_ruleRange8410); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getRangeAccess().getFullStopFullStopKeyword_1()); 
                
            this_NUMBER_2=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRange8425); 

            		current.merge(this_NUMBER_2);
                
             
                newLeafNode(this_NUMBER_2, grammarAccess.getRangeAccess().getNUMBERTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleVal"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3544:1: entryRuleVal returns [String current=null] : iv_ruleVal= ruleVal EOF ;
    public final String entryRuleVal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVal = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
        	
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3548:2: (iv_ruleVal= ruleVal EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3549:2: iv_ruleVal= ruleVal EOF
            {
             newCompositeNode(grammarAccess.getValRule()); 
            pushFollow(FOLLOW_ruleVal_in_entryRuleVal8477);
            iv_ruleVal=ruleVal();

            state._fsp--;

             current =iv_ruleVal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVal8488); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVal"


    // $ANTLR start "ruleVal"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3559:1: ruleVal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER | this_BooleanConstant_2= ruleBooleanConstant ) ;
    public final AntlrDatatypeRuleToken ruleVal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_NUMBER_1=null;
        AntlrDatatypeRuleToken this_BooleanConstant_2 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_COMMENT");
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3563:28: ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER | this_BooleanConstant_2= ruleBooleanConstant ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3564:1: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER | this_BooleanConstant_2= ruleBooleanConstant )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3564:1: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER | this_BooleanConstant_2= ruleBooleanConstant )
            int alt45=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt45=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt45=2;
                }
                break;
            case 58:
            case 59:
                {
                alt45=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3564:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVal8532); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getValAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3572:10: this_NUMBER_1= RULE_NUMBER
                    {
                    this_NUMBER_1=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleVal8558); 

                    		current.merge(this_NUMBER_1);
                        
                     
                        newLeafNode(this_NUMBER_1, grammarAccess.getValAccess().getNUMBERTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3581:5: this_BooleanConstant_2= ruleBooleanConstant
                    {
                     
                            newCompositeNode(grammarAccess.getValAccess().getBooleanConstantParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBooleanConstant_in_ruleVal8591);
                    this_BooleanConstant_2=ruleBooleanConstant();

                    state._fsp--;


                    		current.merge(this_BooleanConstant_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVal"


    // $ANTLR start "entryRuleLiteral"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3602:1: entryRuleLiteral returns [String current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final String entryRuleLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteral = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3603:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3604:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral8641);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral8652); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3611:1: ruleLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUMBER_0= RULE_NUMBER | kw= 'self' | this_BooleanConstant_2= ruleBooleanConstant | this_VariableIdentifier_3= ruleVariableIdentifier ) ;
    public final AntlrDatatypeRuleToken ruleLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NUMBER_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_BooleanConstant_2 = null;

        AntlrDatatypeRuleToken this_VariableIdentifier_3 = null;


         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3614:28: ( (this_NUMBER_0= RULE_NUMBER | kw= 'self' | this_BooleanConstant_2= ruleBooleanConstant | this_VariableIdentifier_3= ruleVariableIdentifier ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3615:1: (this_NUMBER_0= RULE_NUMBER | kw= 'self' | this_BooleanConstant_2= ruleBooleanConstant | this_VariableIdentifier_3= ruleVariableIdentifier )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3615:1: (this_NUMBER_0= RULE_NUMBER | kw= 'self' | this_BooleanConstant_2= ruleBooleanConstant | this_VariableIdentifier_3= ruleVariableIdentifier )
            int alt46=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt46=1;
                }
                break;
            case 100:
                {
                alt46=2;
                }
                break;
            case 58:
            case 59:
                {
                alt46=3;
                }
                break;
            case RULE_ID:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3615:6: this_NUMBER_0= RULE_NUMBER
                    {
                    this_NUMBER_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleLiteral8692); 

                    		current.merge(this_NUMBER_0);
                        
                     
                        newLeafNode(this_NUMBER_0, grammarAccess.getLiteralAccess().getNUMBERTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3624:2: kw= 'self'
                    {
                    kw=(Token)match(input,100,FOLLOW_100_in_ruleLiteral8716); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLiteralAccess().getSelfKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3631:5: this_BooleanConstant_2= ruleBooleanConstant
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanConstantParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBooleanConstant_in_ruleLiteral8744);
                    this_BooleanConstant_2=ruleBooleanConstant();

                    state._fsp--;


                    		current.merge(this_BooleanConstant_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3643:5: this_VariableIdentifier_3= ruleVariableIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getVariableIdentifierParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleLiteral8777);
                    this_VariableIdentifier_3=ruleVariableIdentifier();

                    state._fsp--;


                    		current.merge(this_VariableIdentifier_3);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleVariableIdentifier"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3661:1: entryRuleVariableIdentifier returns [String current=null] : iv_ruleVariableIdentifier= ruleVariableIdentifier EOF ;
    public final String entryRuleVariableIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableIdentifier = null;


        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3662:2: (iv_ruleVariableIdentifier= ruleVariableIdentifier EOF )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3663:2: iv_ruleVariableIdentifier= ruleVariableIdentifier EOF
            {
             newCompositeNode(grammarAccess.getVariableIdentifierRule()); 
            pushFollow(FOLLOW_ruleVariableIdentifier_in_entryRuleVariableIdentifier8823);
            iv_ruleVariableIdentifier=ruleVariableIdentifier();

            state._fsp--;

             current =iv_ruleVariableIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableIdentifier8834); 

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
    // $ANTLR end "entryRuleVariableIdentifier"


    // $ANTLR start "ruleVariableIdentifier"
    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3670:1: ruleVariableIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) | (this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+ ) | (this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']' ) ) ;
    public final AntlrDatatypeRuleToken ruleVariableIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_3=null;
        Token this_ID_5=null;
        Token this_NUMBER_7=null;
        Token this_ID_8=null;
        Token this_ID_10=null;
        Token this_ID_12=null;
        Token this_NUMBER_14=null;
        Token this_NUMBER_16=null;

         enterRule(); 
            
        try {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3673:28: ( ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) | (this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+ ) | (this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']' ) ) )
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3674:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) | (this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+ ) | (this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']' ) )
            {
            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3674:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) | (this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+ ) | (this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']' ) )
            int alt52=3;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3674:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3674:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3674:7: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier8875); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall_0_0()); 
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3681:1: (kw= '.' this_ID_2= RULE_ID )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==101) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3682:2: kw= '.' this_ID_2= RULE_ID
                    	    {
                    	    kw=(Token)match(input,101,FOLLOW_101_in_ruleVariableIdentifier8894); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getFullStopKeyword_0_1_0()); 
                    	        
                    	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier8909); 

                    	    		current.merge(this_ID_2);
                    	        
                    	     
                    	        newLeafNode(this_ID_2, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall_0_1_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3695:6: (this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+ )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3695:6: (this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+ )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3695:11: this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+
                    {
                    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier8939); 

                    		current.merge(this_ID_3);
                        
                     
                        newLeafNode(this_ID_3, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall_1_0()); 
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3702:1: (kw= '.' this_ID_5= RULE_ID )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==101) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3703:2: kw= '.' this_ID_5= RULE_ID
                    	    {
                    	    kw=(Token)match(input,101,FOLLOW_101_in_ruleVariableIdentifier8958); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getFullStopKeyword_1_1_0()); 
                    	        
                    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier8973); 

                    	    		current.merge(this_ID_5);
                    	        
                    	     
                    	        newLeafNode(this_ID_5, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall_1_1_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3715:3: (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==42) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3716:2: kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']'
                    	    {
                    	    kw=(Token)match(input,42,FOLLOW_42_in_ruleVariableIdentifier8994); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getLeftSquareBracketKeyword_1_2_0()); 
                    	        
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3721:1: (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID )
                    	    int alt49=2;
                    	    int LA49_0 = input.LA(1);

                    	    if ( (LA49_0==RULE_NUMBER) ) {
                    	        alt49=1;
                    	    }
                    	    else if ( (LA49_0==RULE_ID) ) {
                    	        alt49=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 49, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt49) {
                    	        case 1 :
                    	            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3721:6: this_NUMBER_7= RULE_NUMBER
                    	            {
                    	            this_NUMBER_7=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleVariableIdentifier9010); 

                    	            		current.merge(this_NUMBER_7);
                    	                
                    	             
                    	                newLeafNode(this_NUMBER_7, grammarAccess.getVariableIdentifierAccess().getNUMBERTerminalRuleCall_1_2_1_0()); 
                    	                

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3729:10: this_ID_8= RULE_ID
                    	            {
                    	            this_ID_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier9036); 

                    	            		current.merge(this_ID_8);
                    	                
                    	             
                    	                newLeafNode(this_ID_8, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall_1_2_1_1()); 
                    	                

                    	            }
                    	            break;

                    	    }

                    	    kw=(Token)match(input,43,FOLLOW_43_in_ruleVariableIdentifier9055); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getRightSquareBracketKeyword_1_2_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt50 >= 1 ) break loop50;
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3743:6: (this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']' )
                    {
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3743:6: (this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']' )
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3743:11: this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']'
                    {
                    this_ID_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier9080); 

                    		current.merge(this_ID_10);
                        
                     
                        newLeafNode(this_ID_10, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall_2_0()); 
                        
                    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3750:1: (kw= '.' this_ID_12= RULE_ID )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==101) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../reprotool.fm.nusmv.lang/src-gen/reprotool/fm/nusmv/lang/parser/antlr/internal/InternalNuSmvLang.g:3751:2: kw= '.' this_ID_12= RULE_ID
                    	    {
                    	    kw=(Token)match(input,101,FOLLOW_101_in_ruleVariableIdentifier9099); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getFullStopKeyword_2_1_0()); 
                    	        
                    	    this_ID_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier9114); 

                    	    		current.merge(this_ID_12);
                    	        
                    	     
                    	        newLeafNode(this_ID_12, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall_2_1_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    kw=(Token)match(input,42,FOLLOW_42_in_ruleVariableIdentifier9134); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getLeftSquareBracketKeyword_2_2()); 
                        
                    this_NUMBER_14=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleVariableIdentifier9149); 

                    		current.merge(this_NUMBER_14);
                        
                     
                        newLeafNode(this_NUMBER_14, grammarAccess.getVariableIdentifierAccess().getNUMBERTerminalRuleCall_2_3()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleVariableIdentifier9167); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getColonKeyword_2_4()); 
                        
                    this_NUMBER_16=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleVariableIdentifier9182); 

                    		current.merge(this_NUMBER_16);
                        
                     
                        newLeafNode(this_NUMBER_16, grammarAccess.getVariableIdentifierAccess().getNUMBERTerminalRuleCall_2_5()); 
                        
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleVariableIdentifier9200); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableIdentifierAccess().getRightSquareBracketKeyword_2_6()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableIdentifier"

    // Delegated rules


    protected DFA36 dfa36 = new DFA36(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA52 dfa52 = new DFA52(this);
    static final String DFA36_eotS =
        "\34\uffff";
    static final String DFA36_eofS =
        "\1\1\33\uffff";
    static final String DFA36_minS =
        "\1\15\33\uffff";
    static final String DFA36_maxS =
        "\1\125\33\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\2\32\1";
    static final String DFA36_specialS =
        "\34\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\2\uffff\10\1\1\uffff\2\1\2\uffff\11\1\1\uffff\1\1\3\uffff"+
            "\1\1\3\uffff\1\1\14\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
            "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
            "\1\26\1\27\1\30\1\31\1\32\1\33",
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
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 2598:1: (this_BinaryOperator_1= ruleBinaryOperator this_TerminalSimpleExpression_2= ruleTerminalSimpleExpression )*";
        }
    }
    static final String DFA37_eotS =
        "\13\uffff";
    static final String DFA37_eofS =
        "\1\uffff\1\2\11\uffff";
    static final String DFA37_minS =
        "\1\4\1\15\11\uffff";
    static final String DFA37_maxS =
        "\1\144\1\125\11\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\1\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\2";
    static final String DFA37_specialS =
        "\13\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\2\1\1\11\uffff\1\4\14\uffff\1\3\21\uffff\1\7\5\uffff\1\6"+
            "\1\uffff\2\10\2\11\2\2\20\uffff\2\5\10\uffff\16\5\1\2",
            "\1\2\2\uffff\10\2\1\uffff\2\2\2\uffff\11\2\1\uffff\1\2\3\uffff"+
            "\1\2\3\uffff\1\2\1\12\13\uffff\32\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "2641:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NextExpression_2= ruleNextExpression | this_BracketExpression_3= ruleBracketExpression | this_UnaryExpression_4= ruleUnaryExpression | this_CaseExpression_5= ruleCaseExpression | this_SetExpression_6= ruleSetExpression | this_EAExpression_7= ruleEAExpression | this_BoolWordConvertExpression_8= ruleBoolWordConvertExpression )";
        }
    }
    static final String DFA52_eotS =
        "\11\uffff";
    static final String DFA52_eofS =
        "\1\uffff\1\4\3\uffff\1\4\3\uffff";
    static final String DFA52_minS =
        "\1\4\1\15\2\4\1\uffff\1\15\1\25\2\uffff";
    static final String DFA52_maxS =
        "\1\4\1\145\1\4\1\5\1\uffff\1\145\1\53\2\uffff";
    static final String DFA52_acceptS =
        "\4\uffff\1\1\2\uffff\1\2\1\3";
    static final String DFA52_specialS =
        "\11\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\1",
            "\1\4\2\uffff\13\4\2\uffff\11\4\1\uffff\1\4\2\uffff\1\3\1\4"+
            "\3\uffff\1\4\14\uffff\32\4\17\uffff\1\2",
            "\1\5",
            "\1\7\1\6",
            "",
            "\1\4\2\uffff\13\4\2\uffff\11\4\1\uffff\1\4\2\uffff\1\3\1\4"+
            "\3\uffff\1\4\14\uffff\32\4\17\uffff\1\2",
            "\1\10\25\uffff\1\7",
            "",
            ""
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "3674:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) | (this_ID_3= RULE_ID (kw= '.' this_ID_5= RULE_ID )* (kw= '[' (this_NUMBER_7= RULE_NUMBER | this_ID_8= RULE_ID ) kw= ']' )+ ) | (this_ID_10= RULE_ID (kw= '.' this_ID_12= RULE_ID )* kw= '[' this_NUMBER_14= RULE_NUMBER kw= ':' this_NUMBER_16= RULE_NUMBER kw= ']' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModule_in_ruleModel140 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModule227 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleMainModule_in_ruleModule250 = new BitSet(new long[]{0x000000BFE69C0002L});
    public static final BitSet FOLLOW_ruleOtherModule_in_ruleModule277 = new BitSet(new long[]{0x000000BFE69C0002L});
    public static final BitSet FOLLOW_ruleModuleElement_in_ruleModule298 = new BitSet(new long[]{0x000000BFE69C0002L});
    public static final BitSet FOLLOW_ruleMainModule_in_entryRuleMainModule335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMainModule345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleMainModule387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOtherModule_in_entryRuleOtherModule435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOtherModule445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOtherModule487 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleOtherModule505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFormalParameter_in_ruleOtherModule526 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleOtherModule539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFormalParameter_in_ruleOtherModule560 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleOtherModule574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleElement_in_entryRuleModuleElement618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleElement628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleModuleElement679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIVariableDeclaration_in_ruleModuleElement706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFrozenVariableDeclaration_in_ruleModuleElement733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefineDeclaration_in_ruleModuleElement760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantsDeclaration_in_ruleModuleElement787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignConstraint_in_ruleModuleElement814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransConstraint_in_ruleModuleElement841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitConstraint_in_ruleModuleElement868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvarConstraint_in_ruleModuleElement895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFairnessConstraint_in_ruleModuleElement922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCtlSpecification_in_ruleModuleElement949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLtlSpecification_in_ruleModuleElement976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvarSpecification_in_ruleModuleElement1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVariableDeclaration1099 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarBody_in_ruleVariableDeclaration1120 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleIVariableDeclaration_in_entryRuleIVariableDeclaration1167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIVariableDeclaration1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIVariableDeclaration1218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarBody_in_ruleIVariableDeclaration1239 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleFrozenVariableDeclaration_in_entryRuleFrozenVariableDeclaration1286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFrozenVariableDeclaration1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFrozenVariableDeclaration1337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarBody_in_ruleFrozenVariableDeclaration1358 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleVarBody_in_entryRuleVarBody1405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarBody1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarBody1461 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleVarBody1478 = new BitSet(new long[]{0x000A730000000030L});
    public static final BitSet FOLLOW_ruleTypeSpecifier_in_ruleVarBody1499 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleVarBody1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefineDeclaration_in_entryRuleDefineDeclaration1557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefineDeclaration1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDefineDeclaration1608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDefineBody_in_ruleDefineDeclaration1629 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleDefineBody_in_entryRuleDefineBody1676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefineBody1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefineBody1732 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDefineBody1749 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleDefineBody1770 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDefineBody1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantsDeclaration_in_entryRuleConstantsDeclaration1828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantsDeclaration1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleConstantsDeclaration1879 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstantsDeclaration1896 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_16_in_ruleConstantsDeclaration1914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstantsDeclaration1931 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_22_in_ruleConstantsDeclaration1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignConstraint_in_entryRuleAssignConstraint1996 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignConstraint2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleAssignConstraint2047 = new BitSet(new long[]{0x0C00000018000030L,0x0000001000000000L});
    public static final BitSet FOLLOW_ruleAssignBody_in_ruleAssignConstraint2068 = new BitSet(new long[]{0x0C00000018000032L,0x0000001000000000L});
    public static final BitSet FOLLOW_ruleAssignBody_in_entryRuleAssignBody2115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignBody2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarBodyAssign_in_ruleAssignBody2176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitBody_in_ruleAssignBody2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNextBody_in_ruleAssignBody2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarBodyAssign_in_entryRuleVarBodyAssign2275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarBodyAssign2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleVarBodyAssign2335 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleVarBodyAssign2347 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleVarBodyAssign2368 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleVarBodyAssign2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitBody_in_entryRuleInitBody2426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitBody2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleInitBody2477 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInitBody2489 = new BitSet(new long[]{0x0C00000000000030L,0x0000001000000000L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleInitBody2510 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInitBody2522 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleInitBody2534 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleInitBody2555 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleInitBody2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNextBody_in_entryRuleNextBody2613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNextBody2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleNextBody2664 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNextBody2676 = new BitSet(new long[]{0x0C00000000000030L,0x0000001000000000L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleNextBody2697 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleNextBody2709 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNextBody2721 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleNextBody2742 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleNextBody2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransConstraint_in_entryRuleTransConstraint2800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransConstraint2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTransConstraint2851 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleTransConstraint2872 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleTransConstraint2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitConstraint_in_entryRuleInitConstraint2933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitConstraint2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleInitConstraint2984 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleInitConstraint3005 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleInitConstraint3018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvarConstraint_in_entryRuleInvarConstraint3066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvarConstraint3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleInvarConstraint3117 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleInvarConstraint3138 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleInvarConstraint3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFairnessConstraint_in_entryRuleFairnessConstraint3199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFairnessConstraint3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFairnessExpression_in_ruleFairnessConstraint3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJusticeExpression_in_ruleFairnessConstraint3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompassionExpression_in_ruleFairnessConstraint3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFairnessExpression_in_entryRuleFairnessExpression3359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFairnessExpression3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleFairnessExpression3410 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleFairnessExpression3431 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleFairnessExpression3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJusticeExpression_in_entryRuleJusticeExpression3492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJusticeExpression3502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleJusticeExpression3543 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleJusticeExpression3564 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleJusticeExpression3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompassionExpression_in_entryRuleCompassionExpression3625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompassionExpression3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleCompassionExpression3676 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleCompassionExpression3697 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCompassionExpression3709 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleCompassionExpression3730 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCompassionExpression3742 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleCompassionExpression3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvarSpecification_in_entryRuleInvarSpecification3803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvarSpecification3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleInvarSpecification3854 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInvarSpecification3872 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleInvarSpecification3889 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleInvarSpecification3912 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleInvarSpecification3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCtlSpecification_in_entryRuleCtlSpecification3973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCtlSpecification3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleCtlSpecification4025 = new BitSet(new long[]{0x0FD0404010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_37_in_ruleCtlSpecification4043 = new BitSet(new long[]{0x0FD0404010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_38_in_ruleCtlSpecification4063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCtlSpecification4093 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleCtlSpecification4110 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleCtlSpecification4133 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleCtlSpecification4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLtlSpecification_in_entryRuleLtlSpecification4194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLtlSpecification4204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleLtlSpecification4245 = new BitSet(new long[]{0x0FD0404010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_38_in_ruleLtlSpecification4264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLtlSpecification4294 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleLtlSpecification4311 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleLtlSpecification4334 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleLtlSpecification4347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeSpecifier_in_entryRuleTypeSpecifier4395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeSpecifier4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_ruleTypeSpecifier4456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleType_in_ruleTypeSpecifier4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType4528 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType4538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleSimpleType4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleSimpleType4619 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleSimpleType4631 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSimpleType4648 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleSimpleType4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleSimpleType4696 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleSimpleType4708 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleSimpleType4720 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSimpleType4737 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleSimpleType4754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleSimpleType4785 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleSimpleType4797 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSimpleType4814 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleSimpleType4831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleSimpleType4861 = new BitSet(new long[]{0x0C00000000000030L});
    public static final BitSet FOLLOW_ruleVal_in_ruleSimpleType4882 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_16_in_ruleSimpleType4895 = new BitSet(new long[]{0x0C00000000000030L});
    public static final BitSet FOLLOW_ruleVal_in_ruleSimpleType4916 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_47_in_ruleSimpleType4930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSimpleType4964 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleSimpleType4981 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSimpleType4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleSimpleType5032 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleRange_in_ruleSimpleType5053 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleSimpleType5065 = new BitSet(new long[]{0x0002730000000020L});
    public static final BitSet FOLLOW_ruleSimpleType_in_ruleSimpleType5086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleType_in_entryRuleModuleType5133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleType5143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleModuleType5195 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModuleType5215 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleModuleType5228 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleModuleType5249 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleModuleType5262 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleModuleType5283 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleModuleType5297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModuleType5338 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleModuleType5351 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleModuleType5372 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleModuleType5385 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleModuleType5406 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleModuleType5420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormalParameter_in_entryRuleFormalParameter5464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormalParameter5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFormalParameter5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_entryRuleSimpleExpression5562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleExpression5573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryExpression_in_ruleSimpleExpression5623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryExpression_in_entryRuleBinaryExpression5672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinaryExpression5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalSimpleExpression_in_ruleBinaryExpression5730 = new BitSet(new long[]{0xF000000000000002L,0x00000000003FFFFFL});
    public static final BitSet FOLLOW_ruleBinaryOperator_in_ruleBinaryExpression5758 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleTerminalSimpleExpression_in_ruleBinaryExpression5785 = new BitSet(new long[]{0xF000000000000002L,0x00000000003FFFFFL});
    public static final BitSet FOLLOW_ruleTerminalSimpleExpression_in_entryRuleTerminalSimpleExpression5833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalSimpleExpression5844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTerminalSimpleExpression5891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_ruleTerminalSimpleExpression5924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNextExpression_in_ruleTerminalSimpleExpression5957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracketExpression_in_ruleTerminalSimpleExpression5990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleTerminalSimpleExpression6023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExpression_in_ruleTerminalSimpleExpression6056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetExpression_in_ruleTerminalSimpleExpression6089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAExpression_in_ruleTerminalSimpleExpression6122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolWordConvertExpression_in_ruleTerminalSimpleExpression6155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNextExpression_in_entryRuleNextExpression6201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNextExpression6212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleNextExpression6250 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleNextExpression6263 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleNextExpression6285 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleNextExpression6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracketExpression_in_entryRuleBracketExpression6344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBracketExpression6355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleBracketExpression6393 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleBracketExpression6415 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleBracketExpression6433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6532 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleUnaryExpression6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExpression_in_entryRuleCaseExpression6605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExpression6616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleCaseExpression6654 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleCaseExpression6677 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleCaseExpression6695 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleCaseExpression6717 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCaseExpression6735 = new BitSet(new long[]{0x0FF0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_53_in_ruleCaseExpression6750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSetExpression_in_entryRuleSetExpression6791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSetExpression6802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleSetExpression6840 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleSetExpression6862 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_16_in_ruleSetExpression6881 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleSetExpression6903 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_47_in_ruleSetExpression6923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEAExpression_in_entryRuleEAExpression6964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEAExpression6975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleEAExpression7014 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_55_in_ruleEAExpression7033 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleEAExpression7047 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleEAExpression7069 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleEAExpression7087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolWordConvertExpression_in_entryRuleBoolWordConvertExpression7128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolWordConvertExpression7139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleBoolWordConvertExpression7178 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_57_in_ruleBoolWordConvertExpression7197 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleBoolWordConvertExpression7211 = new BitSet(new long[]{0x0FD0400010008030L,0x0000001FFFC03000L});
    public static final BitSet FOLLOW_ruleSimpleExpression_in_ruleBoolWordConvertExpression7233 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleBoolWordConvertExpression7251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanConstant_in_entryRuleBooleanConstant7292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanConstant7303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleBooleanConstant7341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleBooleanConstant7360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator7401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperator7412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleBinaryOperator7450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleBinaryOperator7469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleBinaryOperator7488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleBinaryOperator7507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleBinaryOperator7526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleBinaryOperator7545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleBinaryOperator7564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleBinaryOperator7583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleBinaryOperator7602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleBinaryOperator7621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleBinaryOperator7640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleBinaryOperator7659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleBinaryOperator7678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleBinaryOperator7697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleBinaryOperator7716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleBinaryOperator7735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleBinaryOperator7754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleBinaryOperator7773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleBinaryOperator7792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleBinaryOperator7811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleBinaryOperator7830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleBinaryOperator7849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleBinaryOperator7868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleBinaryOperator7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleBinaryOperator7906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleBinaryOperator7925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator7966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator7977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleUnaryOperator8015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleUnaryOperator8034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleUnaryOperator8053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleUnaryOperator8072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleUnaryOperator8091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleUnaryOperator8110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleUnaryOperator8129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleUnaryOperator8148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleUnaryOperator8167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleUnaryOperator8186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleUnaryOperator8205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleUnaryOperator8224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleUnaryOperator8243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleUnaryOperator8262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleUnaryOperator8281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleUnaryOperator8300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange8341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange8352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRange8392 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleRange8410 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRange8425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVal_in_entryRuleVal8477 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVal8488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVal8532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleVal8558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanConstant_in_ruleVal8591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral8641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral8652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleLiteral8692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleLiteral8716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanConstant_in_ruleLiteral8744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleLiteral8777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_entryRuleVariableIdentifier8823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableIdentifier8834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier8875 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleVariableIdentifier8894 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier8909 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier8939 = new BitSet(new long[]{0x0000040000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleVariableIdentifier8958 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier8973 = new BitSet(new long[]{0x0000040000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_42_in_ruleVariableIdentifier8994 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleVariableIdentifier9010 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier9036 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleVariableIdentifier9055 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier9080 = new BitSet(new long[]{0x0000040000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleVariableIdentifier9099 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier9114 = new BitSet(new long[]{0x0000040000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_42_in_ruleVariableIdentifier9134 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleVariableIdentifier9149 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleVariableIdentifier9167 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleVariableIdentifier9182 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleVariableIdentifier9200 = new BitSet(new long[]{0x0000000000000002L});

}
package reprotool.fm.nusmv.mapping;

import com.google.inject.Inject;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import reprotool.fm.nusmv.lang.nuSmvLang.AssignBody;
import reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.BooleanType;
import reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.MainModule;
import reprotool.fm.nusmv.lang.nuSmvLang.Model;
import reprotool.fm.nusmv.lang.nuSmvLang.Module;
import reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement;
import reprotool.fm.nusmv.lang.nuSmvLang.NextBody;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory;
import reprotool.fm.nusmv.lang.nuSmvLang.OtherModule;
import reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBody;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBodyAssign;
import reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration;
import reprotool.fm.nusmv.mapping.ReprotoolMappingExtensions;

@SuppressWarnings("all")
public class SampleSwprojBuilder {
  @Inject
  private ReprotoolMappingExtensions _reprotoolMappingExtensions;
  
  @Inject
  private NuSmvLangFactory factory;
  
  public Model createSampleModel() {
      OtherModule _createOtherModule = this.factory.createOtherModule();
      final Procedure1<OtherModule> _function = new Procedure1<OtherModule>() {
          public void apply(final OtherModule it) {
            {
              it.setName("UC1");
              EList<ModuleElement> _moduleElement = it.getModuleElement();
              InitConstraint _createInitConstraint = SampleSwprojBuilder.this.factory.createInitConstraint();
              final Procedure1<InitConstraint> _function = new Procedure1<InitConstraint>() {
                  public void apply(final InitConstraint it) {
                    it.setInitExpr("s=1");
                  }
                };
              InitConstraint _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<InitConstraint>$(_createInitConstraint, _function);
              CollectionExtensions.<InitConstraint>operator_add(_moduleElement, _$);
              EList<ModuleElement> _moduleElement_1 = it.getModuleElement();
              AssignConstraint _createAssignConstraint = SampleSwprojBuilder.this.factory.createAssignConstraint();
              final Procedure1<AssignConstraint> _function_1 = new Procedure1<AssignConstraint>() {
                  public void apply(final AssignConstraint it) {
                    {
                      EList<AssignBody> _bodies = it.getBodies();
                      VarBodyAssign _createVarBodyAssign = SampleSwprojBuilder.this.factory.createVarBodyAssign();
                      final Procedure1<VarBodyAssign> _function = new Procedure1<VarBodyAssign>() {
                          public void apply(final VarBodyAssign it) {
                            {
                              it.setVarId("x");
                              it.setAssignment("ahoj");
                            }
                          }
                        };
                      VarBodyAssign _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<VarBodyAssign>$(_createVarBodyAssign, _function);
                      CollectionExtensions.<VarBodyAssign>operator_add(_bodies, _$);
                      EList<AssignBody> _bodies_1 = it.getBodies();
                      NextBody _createNextBody = SampleSwprojBuilder.this.factory.createNextBody();
                      final Procedure1<NextBody> _function_1 = new Procedure1<NextBody>() {
                          public void apply(final NextBody it) {
                            {
                              it.setVarId("s");
                              it.setNextExpr("case s=1 : {2,3}; esac");
                            }
                          }
                        };
                      NextBody _$_1 = SampleSwprojBuilder.this._reprotoolMappingExtensions.<NextBody>$(_createNextBody, _function_1);
                      CollectionExtensions.<NextBody>operator_add(_bodies_1, _$_1);
                    }
                  }
                };
              AssignConstraint _$_1 = SampleSwprojBuilder.this._reprotoolMappingExtensions.<AssignConstraint>$(_createAssignConstraint, _function_1);
              CollectionExtensions.<AssignConstraint>operator_add(_moduleElement_1, _$_1);
            }
          }
        };
      OtherModule _$ = this._reprotoolMappingExtensions.<OtherModule>$(_createOtherModule, _function);
      final OtherModule X1 = _$;
      OtherModule _createOtherModule_1 = this.factory.createOtherModule();
      final Procedure1<OtherModule> _function_1 = new Procedure1<OtherModule>() {
          public void apply(final OtherModule it) {
            {
              it.setName("UC2");
              EList<ModuleElement> _moduleElement = it.getModuleElement();
              VariableDeclaration _createVariableDeclaration = SampleSwprojBuilder.this.factory.createVariableDeclaration();
              final Procedure1<VariableDeclaration> _function = new Procedure1<VariableDeclaration>() {
                  public void apply(final VariableDeclaration it) {
                    EList<VarBody> _vars = it.getVars();
                    VarBody _createVarBody = SampleSwprojBuilder.this.factory.createVarBody();
                    final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                        public void apply(final VarBody it) {
                          {
                            it.setVarId("s");
                            BooleanType _createBooleanType = SampleSwprojBuilder.this.factory.createBooleanType();
                            it.setType(_createBooleanType);
                          }
                        }
                      };
                    VarBody _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
                    CollectionExtensions.<VarBody>operator_add(_vars, _$);
                  }
                };
              VariableDeclaration _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration, _function);
              CollectionExtensions.<VariableDeclaration>operator_add(_moduleElement, _$);
              EList<ModuleElement> _moduleElement_1 = it.getModuleElement();
              InitConstraint _createInitConstraint = SampleSwprojBuilder.this.factory.createInitConstraint();
              final Procedure1<InitConstraint> _function_1 = new Procedure1<InitConstraint>() {
                  public void apply(final InitConstraint it) {
                    it.setInitExpr("s=1");
                  }
                };
              InitConstraint _$_1 = SampleSwprojBuilder.this._reprotoolMappingExtensions.<InitConstraint>$(_createInitConstraint, _function_1);
              CollectionExtensions.<InitConstraint>operator_add(_moduleElement_1, _$_1);
            }
          }
        };
      OtherModule _$_1 = this._reprotoolMappingExtensions.<OtherModule>$(_createOtherModule_1, _function_1);
      final OtherModule X2 = _$_1;
      Model _createModel = this.factory.createModel();
      final Procedure1<Model> _function_2 = new Procedure1<Model>() {
          public void apply(final Model it) {
            {
              EList<Module> _modules = it.getModules();
              MainModule _createMainModule = SampleSwprojBuilder.this.factory.createMainModule();
              final Procedure1<MainModule> _function = new Procedure1<MainModule>() {
                  public void apply(final MainModule it) {
                    {
                      it.setName("main");
                      EList<ModuleElement> _moduleElement = it.getModuleElement();
                      FairnessExpression _createFairnessExpression = SampleSwprojBuilder.this.factory.createFairnessExpression();
                      final Procedure1<FairnessExpression> _function = new Procedure1<FairnessExpression>() {
                          public void apply(final FairnessExpression it) {
                            it.setFairnessExpr("p=1");
                          }
                        };
                      FairnessExpression _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<FairnessExpression>$(_createFairnessExpression, _function);
                      CollectionExtensions.<FairnessExpression>operator_add(_moduleElement, _$);
                      EList<ModuleElement> _moduleElement_1 = it.getModuleElement();
                      FairnessExpression _createFairnessExpression_1 = SampleSwprojBuilder.this.factory.createFairnessExpression();
                      final Procedure1<FairnessExpression> _function_1 = new Procedure1<FairnessExpression>() {
                          public void apply(final FairnessExpression it) {
                            it.setFairnessExpr("p=2");
                          }
                        };
                      FairnessExpression _$_1 = SampleSwprojBuilder.this._reprotoolMappingExtensions.<FairnessExpression>$(_createFairnessExpression_1, _function_1);
                      CollectionExtensions.<FairnessExpression>operator_add(_moduleElement_1, _$_1);
                      EList<ModuleElement> _moduleElement_2 = it.getModuleElement();
                      CtlSpecification _createCtlSpecification = SampleSwprojBuilder.this.factory.createCtlSpecification();
                      final Procedure1<CtlSpecification> _function_2 = new Procedure1<CtlSpecification>() {
                          public void apply(final CtlSpecification it) {
                            it.setCtlExpr("AG( create_item -> AX(AG(!create_item)) )");
                          }
                        };
                      CtlSpecification _$_2 = SampleSwprojBuilder.this._reprotoolMappingExtensions.<CtlSpecification>$(_createCtlSpecification, _function_2);
                      CollectionExtensions.<CtlSpecification>operator_add(_moduleElement_2, _$_2);
                      EList<ModuleElement> _moduleElement_3 = it.getModuleElement();
                      VariableDeclaration _createVariableDeclaration = SampleSwprojBuilder.this.factory.createVariableDeclaration();
                      final Procedure1<VariableDeclaration> _function_3 = new Procedure1<VariableDeclaration>() {
                          public void apply(final VariableDeclaration it) {
                            {
                              EList<VarBody> _vars = it.getVars();
                              VarBody _createVarBody = SampleSwprojBuilder.this.factory.createVarBody();
                              final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                                  public void apply(final VarBody it) {
                                    {
                                      it.setVarId("x1");
                                      SyncrProcessType _createSyncrProcessType = SampleSwprojBuilder.this.factory.createSyncrProcessType();
                                      final Procedure1<SyncrProcessType> _function = new Procedure1<SyncrProcessType>() {
                                          public void apply(final SyncrProcessType it) {
                                            it.setModule(X1);
                                          }
                                        };
                                      SyncrProcessType _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<SyncrProcessType>$(_createSyncrProcessType, _function);
                                      it.setType(_$);
                                    }
                                  }
                                };
                              VarBody _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
                              CollectionExtensions.<VarBody>operator_add(_vars, _$);
                              EList<VarBody> _vars_1 = it.getVars();
                              VarBody _createVarBody_1 = SampleSwprojBuilder.this.factory.createVarBody();
                              final Procedure1<VarBody> _function_1 = new Procedure1<VarBody>() {
                                  public void apply(final VarBody it) {
                                    {
                                      it.setVarId("x2");
                                      SyncrProcessType _createSyncrProcessType = SampleSwprojBuilder.this.factory.createSyncrProcessType();
                                      final Procedure1<SyncrProcessType> _function = new Procedure1<SyncrProcessType>() {
                                          public void apply(final SyncrProcessType it) {
                                            it.setModule(X2);
                                          }
                                        };
                                      SyncrProcessType _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<SyncrProcessType>$(_createSyncrProcessType, _function);
                                      it.setType(_$);
                                    }
                                  }
                                };
                              VarBody _$_1 = SampleSwprojBuilder.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody_1, _function_1);
                              CollectionExtensions.<VarBody>operator_add(_vars_1, _$_1);
                            }
                          }
                        };
                      VariableDeclaration _$_3 = SampleSwprojBuilder.this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration, _function_3);
                      CollectionExtensions.<VariableDeclaration>operator_add(_moduleElement_3, _$_3);
                    }
                  }
                };
              MainModule _$ = SampleSwprojBuilder.this._reprotoolMappingExtensions.<MainModule>$(_createMainModule, _function);
              CollectionExtensions.<MainModule>operator_add(_modules, _$);
              EList<Module> _modules_1 = it.getModules();
              CollectionExtensions.<OtherModule>operator_add(_modules_1, X1);
              EList<Module> _modules_2 = it.getModules();
              CollectionExtensions.<OtherModule>operator_add(_modules_2, X2);
              HashMap<String,String> _hashMap = new HashMap<String,String>();
              final HashMap<String,String> x = _hashMap;
              Pair<String,String> _operator_mappedTo = ObjectExtensions.<String, String>operator_mappedTo("key", "value");
              SampleSwprojBuilder.this._reprotoolMappingExtensions.<String, String>operator_add(x, _operator_mappedTo);
            }
          }
        };
      Model _$_2 = this._reprotoolMappingExtensions.<Model>$(_createModel, _function_2);
      return _$_2;
  }
}

package reprotool.fm.nusmv.mapping;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import reprotool.fm.nusmv.AnnotationEntry;
import reprotool.fm.nusmv.NuSMVGenerator;
import reprotool.fm.nusmv.lang.nuSmvLang.AssignBody;
import reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.BooleanType;
import reprotool.fm.nusmv.lang.nuSmvLang.CtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.EnumType;
import reprotool.fm.nusmv.lang.nuSmvLang.FairnessExpression;
import reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.LtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvLang.MainModule;
import reprotool.fm.nusmv.lang.nuSmvLang.Model;
import reprotool.fm.nusmv.lang.nuSmvLang.Module;
import reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement;
import reprotool.fm.nusmv.lang.nuSmvLang.NextBody;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory;
import reprotool.fm.nusmv.lang.nuSmvLang.OtherModule;
import reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBody;
import reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.annotate.AnnotationGroup;
import reprotool.model.usecase.annotate.CTLFormula;
import reprotool.model.usecase.annotate.LTLFormula;
import reprotool.model.usecase.annotate.TemporalAnnotation;
import reprotool.model.usecase.annotate.TemporalAnnotationGroup;
import reprotool.model.usecase.annotate.TemporalLogicFormula;
import reprotool.model.utils.xtend.ReprotoolMappingExtensions;

@SuppressWarnings("all")
public class NuSMVProj {
  @Inject
  private ReprotoolMappingExtensions _reprotoolMappingExtensions;
  
  @Inject
  private MessageConsoleStream consoleOut;
  
  @Inject
  private NuSmvLangFactory factory;
  
  @Inject
  private SoftwareProject swproj;
  
  private List<NuSMVGenerator> generators;
  
  private List<TemporalLogicFormula> formulas;
  
  private HashMap<String,TemporalLogicFormula> expanded2Formula;
  
  private List<String> expandedCTLFormulas;
  
  private List<String> expandedLTLFormulas;
  
  private HashMap<String,List<AnnotationEntry>> globalTracker;
  
  private HashMap<UseCase,NuSMVGenerator> uc2gen;
  
  public void initializeSoftwareProject() {
      Assert.isNotNull(this.factory);
      Assert.isNotNull(this.swproj);
      ArrayList<NuSMVGenerator> _arrayList = new ArrayList<NuSMVGenerator>();
      this.generators = _arrayList;
      EList<UseCase> _useCases = this.swproj.getUseCases();
      final Function1<UseCase,NuSMVGenerator> _function = new Function1<UseCase,NuSMVGenerator>() {
          public NuSMVGenerator apply(final UseCase it) {
            NuSMVGenerator _xblockexpression = null;
            {
              String _name = it.getName();
              String _operator_plus = StringExtensions.operator_plus("Found usecase ", _name);
              NuSMVProj.this.consoleOut.println(_operator_plus);
              NuSMVGenerator _nuSMVGenerator = new NuSMVGenerator(it);
              _xblockexpression = (_nuSMVGenerator);
            }
            return _xblockexpression;
          }
        };
      List<NuSMVGenerator> _map = ListExtensions.<UseCase, NuSMVGenerator>map(_useCases, _function);
      CollectionExtensions.<NuSMVGenerator>operator_add(this.generators, _map);
      ArrayList<TemporalLogicFormula> _arrayList_1 = new ArrayList<TemporalLogicFormula>();
      this.formulas = _arrayList_1;
      EList<AnnotationGroup> _annotationGroups = this.swproj.getAnnotationGroups();
      Iterable<TemporalAnnotationGroup> _filter = IterableExtensions.<TemporalAnnotationGroup>filter(_annotationGroups, reprotool.model.usecase.annotate.TemporalAnnotationGroup.class);
      final Function1<TemporalAnnotationGroup,EList<TemporalLogicFormula>> _function_1 = new Function1<TemporalAnnotationGroup,EList<TemporalLogicFormula>>() {
          public EList<TemporalLogicFormula> apply(final TemporalAnnotationGroup annotGroup) {
            EList<TemporalLogicFormula> _formulas = annotGroup.getFormulas();
            return _formulas;
          }
        };
      Iterable<EList<TemporalLogicFormula>> _map_1 = IterableExtensions.<TemporalAnnotationGroup, EList<TemporalLogicFormula>>map(_filter, _function_1);
      Iterable<TemporalLogicFormula> _flatten = IterableExtensions.<TemporalLogicFormula>flatten(_map_1);
      CollectionExtensions.<TemporalLogicFormula>operator_add(this.formulas, _flatten);
      HashMap<String,List<AnnotationEntry>> _hashMap = new HashMap<String,List<AnnotationEntry>>();
      this.globalTracker = _hashMap;
      HashMap<UseCase,NuSMVGenerator> _hashMap_1 = new HashMap<UseCase,NuSMVGenerator>();
      this.uc2gen = _hashMap_1;
      HashMap<String,TemporalLogicFormula> _hashMap_2 = new HashMap<String,TemporalLogicFormula>();
      this.expanded2Formula = _hashMap_2;
      ArrayList<String> _arrayList_2 = new ArrayList<String>();
      this.expandedCTLFormulas = _arrayList_2;
      ArrayList<String> _arrayList_3 = new ArrayList<String>();
      this.expandedLTLFormulas = _arrayList_3;
      final Function1<NuSMVGenerator,Pair<UseCase,NuSMVGenerator>> _function_2 = new Function1<NuSMVGenerator,Pair<UseCase,NuSMVGenerator>>() {
          public Pair<UseCase,NuSMVGenerator> apply(final NuSMVGenerator it) {
            UseCase _useCase = it.getUseCase();
            Pair<UseCase,NuSMVGenerator> _operator_mappedTo = ObjectExtensions.<UseCase, NuSMVGenerator>operator_mappedTo(_useCase, it);
            return _operator_mappedTo;
          }
        };
      List<Pair<UseCase,NuSMVGenerator>> _map_2 = ListExtensions.<NuSMVGenerator, Pair<UseCase,NuSMVGenerator>>map(this.generators, _function_2);
      this._reprotoolMappingExtensions.<UseCase, NuSMVGenerator>operator_add(this.uc2gen, _map_2);
      this.processAnnotations();
      this.loadIncludedAnnotations();
      this.loadTLFormulas();
  }
  
  public SoftwareProject getSoftwareProject() {
    return this.swproj;
  }
  
  public TemporalLogicFormula getFormula(final String f) {
    TemporalLogicFormula _get = this.expanded2Formula.get(f);
    return _get;
  }
  
  public UseCase getUseCaseById(final String id) {
    final Function1<NuSMVGenerator,Boolean> _function = new Function1<NuSMVGenerator,Boolean>() {
        public Boolean apply(final NuSMVGenerator it) {
          String _useCaseId = it.getUseCaseId();
          boolean _equals = _useCaseId.equals(id);
          return Boolean.valueOf(_equals);
        }
      };
    NuSMVGenerator _findFirst = IterableExtensions.<NuSMVGenerator>findFirst(this.generators, _function);
    UseCase _useCase = _findFirst.getUseCase();
    return _useCase;
  }
  
  public NuSMVGenerator getGeneratorById(final String id) {
    final Function1<NuSMVGenerator,Boolean> _function = new Function1<NuSMVGenerator,Boolean>() {
        public Boolean apply(final NuSMVGenerator it) {
          String _useCaseId = it.getUseCaseId();
          boolean _equals = _useCaseId.equals(id);
          return Boolean.valueOf(_equals);
        }
      };
    NuSMVGenerator _findFirst = IterableExtensions.<NuSMVGenerator>findFirst(this.generators, _function);
    return _findFirst;
  }
  
  public boolean containsCTLFormulas() {
    boolean _isEmpty = this.expandedCTLFormulas.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    return _operator_not;
  }
  
  public boolean containsLTLFormulas() {
    boolean _isEmpty = this.expandedLTLFormulas.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    return _operator_not;
  }
  
  public Model getModel() {
    Model _createModel = this.factory.createModel();
    final Procedure1<Model> _function = new Procedure1<Model>() {
        public void apply(final Model it) {
          {
            EList<Module> _modules = it.getModules();
            MainModule _mainModule = NuSMVProj.this.getMainModule();
            CollectionExtensions.<MainModule>operator_add(_modules, _mainModule);
            EList<Module> _modules_1 = it.getModules();
            final Function1<NuSMVGenerator,OtherModule> _function = new Function1<NuSMVGenerator,OtherModule>() {
                public OtherModule apply(final NuSMVGenerator it) {
                  OtherModule _xblockexpression = null;
                  {
                    it.fillAutomaton(NuSMVProj.this.uc2gen);
                    OtherModule _module = it.getModule();
                    _xblockexpression = (_module);
                  }
                  return _xblockexpression;
                }
              };
            List<OtherModule> _map = ListExtensions.<NuSMVGenerator, OtherModule>map(NuSMVProj.this.generators, _function);
            CollectionExtensions.<Module>operator_add(_modules_1, _map);
          }
        }
      };
    Model _$ = this._reprotoolMappingExtensions.<Model>$(_createModel, _function);
    return _$;
  }
  
  private boolean addTraceAnnotation(final String tag, final EList<ModuleElement> moduleElement) {
    boolean _xblockexpression = false;
    {
      VariableDeclaration _createVariableDeclaration = this.factory.createVariableDeclaration();
      final Procedure1<VariableDeclaration> _function = new Procedure1<VariableDeclaration>() {
          public void apply(final VariableDeclaration it) {
            EList<VarBody> _vars = it.getVars();
            VarBody _createVarBody = NuSMVProj.this.factory.createVarBody();
            final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                public void apply(final VarBody it) {
                  {
                    it.setVarId(tag);
                    BooleanType _createBooleanType = NuSMVProj.this.factory.createBooleanType();
                    it.setType(_createBooleanType);
                  }
                }
              };
            VarBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
            CollectionExtensions.<VarBody>operator_add(_vars, _$);
          }
        };
      VariableDeclaration _$ = this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration, _function);
      CollectionExtensions.<VariableDeclaration>operator_add(moduleElement, _$);
      InitConstraint _createInitConstraint = this.factory.createInitConstraint();
      final Procedure1<InitConstraint> _function_1 = new Procedure1<InitConstraint>() {
          public void apply(final InitConstraint it) {
            String _operator_plus = StringExtensions.operator_plus(tag, " in FALSE");
            it.setInitExpr(_operator_plus);
          }
        };
      InitConstraint _$_1 = this._reprotoolMappingExtensions.<InitConstraint>$(_createInitConstraint, _function_1);
      CollectionExtensions.<InitConstraint>operator_add(moduleElement, _$_1);
      AssignConstraint _createAssignConstraint = this.factory.createAssignConstraint();
      final Procedure1<AssignConstraint> _function_2 = new Procedure1<AssignConstraint>() {
          public void apply(final AssignConstraint it) {
            EList<AssignBody> _bodies = it.getBodies();
            NextBody _createNextBody = NuSMVProj.this.factory.createNextBody();
            final Procedure1<NextBody> _function = new Procedure1<NextBody>() {
                public void apply(final NextBody it) {
                  {
                    it.setVarId(tag);
                    List<AnnotationEntry> _get = NuSMVProj.this.globalTracker.get(tag);
                    final Function1<AnnotationEntry,String> _function = new Function1<AnnotationEntry,String>() {
                        public String apply(final AnnotationEntry aEntry) {
                          List<String> _states = aEntry.getStates();
                          final Function1<String,String> _function = new Function1<String,String>() {
                              public String apply(final String it) {
                                String _automatonID = aEntry.getAutomatonID();
                                String _operator_plus = StringExtensions.operator_plus("\t\tx", _automatonID);
                                String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".s=");
                                String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, it);
                                String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "_ : TRUE;");
                                return _operator_plus_3;
                              }
                            };
                          List<String> _map = ListExtensions.<String, String>map(_states, _function);
                          String _join = IterableExtensions.join(_map, "\n");
                          return _join;
                        }
                      };
                    List<String> _map = ListExtensions.<AnnotationEntry, String>map(_get, _function);
                    String _join = IterableExtensions.join(_map, "\n");
                    String _operator_plus = StringExtensions.operator_plus("case\n", _join);
                    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\t\tTRUE : ");
                    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, tag);
                    String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ";\n\tesac");
                    it.setNextExpr(_operator_plus_3);
                  }
                }
              };
            NextBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<NextBody>$(_createNextBody, _function);
            CollectionExtensions.<NextBody>operator_add(_bodies, _$);
          }
        };
      AssignConstraint _$_2 = this._reprotoolMappingExtensions.<AssignConstraint>$(_createAssignConstraint, _function_2);
      boolean _operator_add = CollectionExtensions.<AssignConstraint>operator_add(moduleElement, _$_2);
      _xblockexpression = (_operator_add);
    }
    return _xblockexpression;
  }
  
  private void addAnnotations(final EList<ModuleElement> moduleElement) {
      boolean cont = false;
      Set<String> _keySet = this.globalTracker.keySet();
      for (final String tag : _keySet) {
        {
          cont = false;
          boolean _matches = tag.matches("trace_.*");
          if (_matches) {
            {
              this.addTraceAnnotation(tag, moduleElement);
              cont = true;
            }
          }
          boolean _matches_1 = tag.matches("on_.*");
          if (_matches_1) {
            cont = true;
          }
          boolean _operator_not = BooleanExtensions.operator_not(cont);
          if (_operator_not) {
            {
              VariableDeclaration _createVariableDeclaration = this.factory.createVariableDeclaration();
              final Procedure1<VariableDeclaration> _function = new Procedure1<VariableDeclaration>() {
                  public void apply(final VariableDeclaration it) {
                    EList<VarBody> _vars = it.getVars();
                    VarBody _createVarBody = NuSMVProj.this.factory.createVarBody();
                    final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                        public void apply(final VarBody it) {
                          {
                            it.setVarId(tag);
                            BooleanType _createBooleanType = NuSMVProj.this.factory.createBooleanType();
                            it.setType(_createBooleanType);
                          }
                        }
                      };
                    VarBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
                    CollectionExtensions.<VarBody>operator_add(_vars, _$);
                  }
                };
              VariableDeclaration _$ = this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration, _function);
              CollectionExtensions.<VariableDeclaration>operator_add(moduleElement, _$);
              InitConstraint _createInitConstraint = this.factory.createInitConstraint();
              final Procedure1<InitConstraint> _function_1 = new Procedure1<InitConstraint>() {
                  public void apply(final InitConstraint it) {
                    String _operator_plus = StringExtensions.operator_plus(tag, " in FALSE");
                    it.setInitExpr(_operator_plus);
                  }
                };
              InitConstraint _$_1 = this._reprotoolMappingExtensions.<InitConstraint>$(_createInitConstraint, _function_1);
              CollectionExtensions.<InitConstraint>operator_add(moduleElement, _$_1);
              AssignConstraint _createAssignConstraint = this.factory.createAssignConstraint();
              final Procedure1<AssignConstraint> _function_2 = new Procedure1<AssignConstraint>() {
                  public void apply(final AssignConstraint it) {
                    EList<AssignBody> _bodies = it.getBodies();
                    NextBody _createNextBody = NuSMVProj.this.factory.createNextBody();
                    final Procedure1<NextBody> _function = new Procedure1<NextBody>() {
                        public void apply(final NextBody it) {
                          {
                            it.setVarId(tag);
                            List<AnnotationEntry> _get = NuSMVProj.this.globalTracker.get(tag);
                            final Function1<AnnotationEntry,String> _function = new Function1<AnnotationEntry,String>() {
                                public String apply(final AnnotationEntry aEntry) {
                                  String _automatonID = aEntry.getAutomatonID();
                                  String _operator_plus = StringExtensions.operator_plus("\t\t| x", _automatonID);
                                  String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".s in {");
                                  List<String> _states = aEntry.getStates();
                                  final Function1<String,String> _function = new Function1<String,String>() {
                                      public String apply(final String it) {
                                        String _operator_plus = StringExtensions.operator_plus(it, "_");
                                        return _operator_plus;
                                      }
                                    };
                                  String _join = IterableExtensions.<String>join(_states, ",", _function);
                                  String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _join);
                                  String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "}\n");
                                  return _operator_plus_3;
                                }
                              };
                            List<String> _map = ListExtensions.<AnnotationEntry, String>map(_get, _function);
                            String _join = IterableExtensions.join(_map);
                            String _operator_plus = StringExtensions.operator_plus("FALSE\n", _join);
                            it.setNextExpr(_operator_plus);
                          }
                        }
                      };
                    NextBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<NextBody>$(_createNextBody, _function);
                    CollectionExtensions.<NextBody>operator_add(_bodies, _$);
                  }
                };
              AssignConstraint _$_2 = this._reprotoolMappingExtensions.<AssignConstraint>$(_createAssignConstraint, _function_2);
              CollectionExtensions.<AssignConstraint>operator_add(moduleElement, _$_2);
            }
          }
        }
      }
  }
  
  private MainModule getMainModule() {
    MainModule _createMainModule = this.factory.createMainModule();
    final Procedure1<MainModule> _function = new Procedure1<MainModule>() {
        public void apply(final MainModule it) {
          {
            it.setName("main");
            EList<ModuleElement> _moduleElement = it.getModuleElement();
            final Function1<String,CtlSpecification> _function = new Function1<String,CtlSpecification>() {
                public CtlSpecification apply(final String formula) {
                  CtlSpecification _createCtlSpecification = NuSMVProj.this.factory.createCtlSpecification();
                  final Procedure1<CtlSpecification> _function = new Procedure1<CtlSpecification>() {
                      public void apply(final CtlSpecification it) {
                        it.setCtlExpr(formula);
                      }
                    };
                  CtlSpecification _$ = NuSMVProj.this._reprotoolMappingExtensions.<CtlSpecification>$(_createCtlSpecification, _function);
                  return _$;
                }
              };
            List<CtlSpecification> _map = ListExtensions.<String, CtlSpecification>map(NuSMVProj.this.expandedCTLFormulas, _function);
            CollectionExtensions.<ModuleElement>operator_add(_moduleElement, _map);
            EList<ModuleElement> _moduleElement_1 = it.getModuleElement();
            final Function1<String,LtlSpecification> _function_1 = new Function1<String,LtlSpecification>() {
                public LtlSpecification apply(final String formula) {
                  LtlSpecification _createLtlSpecification = NuSMVProj.this.factory.createLtlSpecification();
                  final Procedure1<LtlSpecification> _function = new Procedure1<LtlSpecification>() {
                      public void apply(final LtlSpecification it) {
                        it.setLtlExpr(formula);
                      }
                    };
                  LtlSpecification _$ = NuSMVProj.this._reprotoolMappingExtensions.<LtlSpecification>$(_createLtlSpecification, _function);
                  return _$;
                }
              };
            List<LtlSpecification> _map_1 = ListExtensions.<String, LtlSpecification>map(NuSMVProj.this.expandedLTLFormulas, _function_1);
            CollectionExtensions.<ModuleElement>operator_add(_moduleElement_1, _map_1);
            EList<ModuleElement> _moduleElement_2 = it.getModuleElement();
            final Function1<NuSMVGenerator,FairnessExpression> _function_2 = new Function1<NuSMVGenerator,FairnessExpression>() {
                public FairnessExpression apply(final NuSMVGenerator g) {
                  FairnessExpression _createFairnessExpression = NuSMVProj.this.factory.createFairnessExpression();
                  final Procedure1<FairnessExpression> _function = new Procedure1<FairnessExpression>() {
                      public void apply(final FairnessExpression it) {
                        String _useCaseId = g.getUseCaseId();
                        String _operator_plus = StringExtensions.operator_plus("p=p", _useCaseId);
                        it.setFairnessExpr(_operator_plus);
                      }
                    };
                  FairnessExpression _$ = NuSMVProj.this._reprotoolMappingExtensions.<FairnessExpression>$(_createFairnessExpression, _function);
                  return _$;
                }
              };
            List<FairnessExpression> _map_2 = ListExtensions.<NuSMVGenerator, FairnessExpression>map(NuSMVProj.this.generators, _function_2);
            CollectionExtensions.<ModuleElement>operator_add(_moduleElement_2, _map_2);
            EList<ModuleElement> _moduleElement_3 = it.getModuleElement();
            VariableDeclaration _createVariableDeclaration = NuSMVProj.this.factory.createVariableDeclaration();
            final Procedure1<VariableDeclaration> _function_3 = new Procedure1<VariableDeclaration>() {
                public void apply(final VariableDeclaration it) {
                  EList<VarBody> _vars = it.getVars();
                  VarBody _createVarBody = NuSMVProj.this.factory.createVarBody();
                  final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                      public void apply(final VarBody it) {
                        {
                          it.setVarId("p");
                          EnumType _createEnumType = NuSMVProj.this.factory.createEnumType();
                          final Procedure1<EnumType> _function = new Procedure1<EnumType>() {
                              public void apply(final EnumType it) {
                                {
                                  EList<String> _value = it.getValue();
                                  CollectionExtensions.<String>operator_add(_value, "none");
                                  EList<String> _value_1 = it.getValue();
                                  final Function1<NuSMVGenerator,String> _function = new Function1<NuSMVGenerator,String>() {
                                      public String apply(final NuSMVGenerator g) {
                                        String _useCaseId = g.getUseCaseId();
                                        String _operator_plus = StringExtensions.operator_plus("p", _useCaseId);
                                        return _operator_plus;
                                      }
                                    };
                                  List<String> _map = ListExtensions.<NuSMVGenerator, String>map(NuSMVProj.this.generators, _function);
                                  CollectionExtensions.<String>operator_add(_value_1, _map);
                                }
                              }
                            };
                          EnumType _$ = NuSMVProj.this._reprotoolMappingExtensions.<EnumType>$(_createEnumType, _function);
                          it.setType(_$);
                        }
                      }
                    };
                  VarBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
                  CollectionExtensions.<VarBody>operator_add(_vars, _$);
                }
              };
            VariableDeclaration _$ = NuSMVProj.this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration, _function_3);
            CollectionExtensions.<VariableDeclaration>operator_add(_moduleElement_3, _$);
            EList<ModuleElement> _moduleElement_4 = it.getModuleElement();
            InitConstraint _createInitConstraint = NuSMVProj.this.factory.createInitConstraint();
            final Procedure1<InitConstraint> _function_4 = new Procedure1<InitConstraint>() {
                public void apply(final InitConstraint it) {
                  it.setInitExpr("p in none");
                }
              };
            InitConstraint _$_1 = NuSMVProj.this._reprotoolMappingExtensions.<InitConstraint>$(_createInitConstraint, _function_4);
            CollectionExtensions.<InitConstraint>operator_add(_moduleElement_4, _$_1);
            EList<ModuleElement> _moduleElement_5 = it.getModuleElement();
            AssignConstraint _createAssignConstraint = NuSMVProj.this.factory.createAssignConstraint();
            final Procedure1<AssignConstraint> _function_5 = new Procedure1<AssignConstraint>() {
                public void apply(final AssignConstraint it) {
                  EList<AssignBody> _bodies = it.getBodies();
                  NextBody _createNextBody = NuSMVProj.this.factory.createNextBody();
                  final Procedure1<NextBody> _function = new Procedure1<NextBody>() {
                      public void apply(final NextBody it) {
                        {
                          it.setVarId("p");
                          String _operator_plus = StringExtensions.operator_plus("case\n", "\t\tp=none : {");
                          final Function1<NuSMVGenerator,String> _function = new Function1<NuSMVGenerator,String>() {
                              public String apply(final NuSMVGenerator it) {
                                String _useCaseId = it.getUseCaseId();
                                String _operator_plus = StringExtensions.operator_plus("p", _useCaseId);
                                return _operator_plus;
                              }
                            };
                          String _join = IterableExtensions.<NuSMVGenerator>join(NuSMVProj.this.generators, ", ", _function);
                          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _join);
                          String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "};\n");
                          String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "\t\tTRUE : none;\n");
                          String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\tesac");
                          it.setNextExpr(_operator_plus_4);
                        }
                      }
                    };
                  NextBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<NextBody>$(_createNextBody, _function);
                  CollectionExtensions.<NextBody>operator_add(_bodies, _$);
                }
              };
            AssignConstraint _$_2 = NuSMVProj.this._reprotoolMappingExtensions.<AssignConstraint>$(_createAssignConstraint, _function_5);
            CollectionExtensions.<AssignConstraint>operator_add(_moduleElement_5, _$_2);
            EList<ModuleElement> _moduleElement_6 = it.getModuleElement();
            VariableDeclaration _createVariableDeclaration_1 = NuSMVProj.this.factory.createVariableDeclaration();
            final Procedure1<VariableDeclaration> _function_6 = new Procedure1<VariableDeclaration>() {
                public void apply(final VariableDeclaration it) {
                  EList<VarBody> _vars = it.getVars();
                  VarBody _createVarBody = NuSMVProj.this.factory.createVarBody();
                  final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                      public void apply(final VarBody it) {
                        {
                          it.setVarId("idle");
                          BooleanType _createBooleanType = NuSMVProj.this.factory.createBooleanType();
                          it.setType(_createBooleanType);
                        }
                      }
                    };
                  VarBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
                  CollectionExtensions.<VarBody>operator_add(_vars, _$);
                }
              };
            VariableDeclaration _$_3 = NuSMVProj.this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration_1, _function_6);
            CollectionExtensions.<VariableDeclaration>operator_add(_moduleElement_6, _$_3);
            EList<ModuleElement> _moduleElement_7 = it.getModuleElement();
            InitConstraint _createInitConstraint_1 = NuSMVProj.this.factory.createInitConstraint();
            final Procedure1<InitConstraint> _function_7 = new Procedure1<InitConstraint>() {
                public void apply(final InitConstraint it) {
                  it.setInitExpr("idle in TRUE");
                }
              };
            InitConstraint _$_4 = NuSMVProj.this._reprotoolMappingExtensions.<InitConstraint>$(_createInitConstraint_1, _function_7);
            CollectionExtensions.<InitConstraint>operator_add(_moduleElement_7, _$_4);
            EList<ModuleElement> _moduleElement_8 = it.getModuleElement();
            AssignConstraint _createAssignConstraint_1 = NuSMVProj.this.factory.createAssignConstraint();
            final Procedure1<AssignConstraint> _function_8 = new Procedure1<AssignConstraint>() {
                public void apply(final AssignConstraint it) {
                  EList<AssignBody> _bodies = it.getBodies();
                  NextBody _createNextBody = NuSMVProj.this.factory.createNextBody();
                  final Procedure1<NextBody> _function = new Procedure1<NextBody>() {
                      public void apply(final NextBody it) {
                        {
                          it.setVarId("idle");
                          String _operator_plus = StringExtensions.operator_plus("case\n", "\t\t");
                          final Function1<NuSMVGenerator,String> _function = new Function1<NuSMVGenerator,String>() {
                              public String apply(final NuSMVGenerator g) {
                                String _useCaseId = g.getUseCaseId();
                                String _operator_plus = StringExtensions.operator_plus("x", _useCaseId);
                                String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "run");
                                return _operator_plus_1;
                              }
                            };
                          String _join = IterableExtensions.<NuSMVGenerator>join(NuSMVProj.this.generators, " | ", _function);
                          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _join);
                          String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, " : FALSE;\n");
                          String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "\t\tTRUE : TRUE;\n");
                          String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "\tesac");
                          it.setNextExpr(_operator_plus_4);
                        }
                      }
                    };
                  NextBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<NextBody>$(_createNextBody, _function);
                  CollectionExtensions.<NextBody>operator_add(_bodies, _$);
                }
              };
            AssignConstraint _$_5 = NuSMVProj.this._reprotoolMappingExtensions.<AssignConstraint>$(_createAssignConstraint_1, _function_8);
            CollectionExtensions.<AssignConstraint>operator_add(_moduleElement_8, _$_5);
            EList<ModuleElement> _moduleElement_9 = it.getModuleElement();
            NuSMVProj.this.addProcesses(_moduleElement_9);
            EList<ModuleElement> _moduleElement_10 = it.getModuleElement();
            NuSMVProj.this.addAnnotations(_moduleElement_10);
          }
        }
      };
    MainModule _$ = this._reprotoolMappingExtensions.<MainModule>$(_createMainModule, _function);
    return _$;
  }
  
  private void addProcesses(final EList<ModuleElement> moduleElement) {
    for (final NuSMVGenerator nusmv : this.generators) {
      {
        VariableDeclaration _createVariableDeclaration = this.factory.createVariableDeclaration();
        final Procedure1<VariableDeclaration> _function = new Procedure1<VariableDeclaration>() {
            public void apply(final VariableDeclaration it) {
              EList<VarBody> _vars = it.getVars();
              VarBody _createVarBody = NuSMVProj.this.factory.createVarBody();
              final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                  public void apply(final VarBody it) {
                    {
                      String _useCaseId = nusmv.getUseCaseId();
                      String _operator_plus = StringExtensions.operator_plus("x", _useCaseId);
                      it.setVarId(_operator_plus);
                      SyncrProcessType _createSyncrProcessType = NuSMVProj.this.factory.createSyncrProcessType();
                      final Procedure1<SyncrProcessType> _function = new Procedure1<SyncrProcessType>() {
                          public void apply(final SyncrProcessType it) {
                            {
                              OtherModule _module = nusmv.getModule();
                              it.setModule(_module);
                              EList<String> _params = it.getParams();
                              CollectionExtensions.<String>operator_add(_params, "self");
                              EList<String> _params_1 = it.getParams();
                              String _useCaseId = nusmv.getUseCaseId();
                              String _operator_plus = StringExtensions.operator_plus("x", _useCaseId);
                              String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "run");
                              CollectionExtensions.<String>operator_add(_params_1, _operator_plus_1);
                            }
                          }
                        };
                      SyncrProcessType _$ = NuSMVProj.this._reprotoolMappingExtensions.<SyncrProcessType>$(_createSyncrProcessType, _function);
                      it.setType(_$);
                    }
                  }
                };
              VarBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
              CollectionExtensions.<VarBody>operator_add(_vars, _$);
            }
          };
        VariableDeclaration _$ = this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration, _function);
        CollectionExtensions.<VariableDeclaration>operator_add(moduleElement, _$);
        VariableDeclaration _createVariableDeclaration_1 = this.factory.createVariableDeclaration();
        final Procedure1<VariableDeclaration> _function_1 = new Procedure1<VariableDeclaration>() {
            public void apply(final VariableDeclaration it) {
              EList<VarBody> _vars = it.getVars();
              VarBody _createVarBody = NuSMVProj.this.factory.createVarBody();
              final Procedure1<VarBody> _function = new Procedure1<VarBody>() {
                  public void apply(final VarBody it) {
                    {
                      String _useCaseId = nusmv.getUseCaseId();
                      String _operator_plus = StringExtensions.operator_plus("x", _useCaseId);
                      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "run");
                      it.setVarId(_operator_plus_1);
                      BooleanType _createBooleanType = NuSMVProj.this.factory.createBooleanType();
                      it.setType(_createBooleanType);
                    }
                  }
                };
              VarBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<VarBody>$(_createVarBody, _function);
              CollectionExtensions.<VarBody>operator_add(_vars, _$);
            }
          };
        VariableDeclaration _$_1 = this._reprotoolMappingExtensions.<VariableDeclaration>$(_createVariableDeclaration_1, _function_1);
        CollectionExtensions.<VariableDeclaration>operator_add(moduleElement, _$_1);
        InitConstraint _createInitConstraint = this.factory.createInitConstraint();
        final Procedure1<InitConstraint> _function_2 = new Procedure1<InitConstraint>() {
            public void apply(final InitConstraint it) {
              String _useCaseId = nusmv.getUseCaseId();
              String _operator_plus = StringExtensions.operator_plus("x", _useCaseId);
              String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "run in FALSE");
              it.setInitExpr(_operator_plus_1);
            }
          };
        InitConstraint _$_2 = this._reprotoolMappingExtensions.<InitConstraint>$(_createInitConstraint, _function_2);
        CollectionExtensions.<InitConstraint>operator_add(moduleElement, _$_2);
        AssignConstraint _createAssignConstraint = this.factory.createAssignConstraint();
        final Procedure1<AssignConstraint> _function_3 = new Procedure1<AssignConstraint>() {
            public void apply(final AssignConstraint it) {
              EList<AssignBody> _bodies = it.getBodies();
              NextBody _createNextBody = NuSMVProj.this.factory.createNextBody();
              final Procedure1<NextBody> _function = new Procedure1<NextBody>() {
                  public void apply(final NextBody it) {
                    {
                      String _useCaseId = nusmv.getUseCaseId();
                      String _operator_plus = StringExtensions.operator_plus("x", _useCaseId);
                      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "run");
                      it.setVarId(_operator_plus_1);
                      boolean _operator_or = false;
                      UseCase _useCase = nusmv.getUseCase();
                      EList<UseCase> _precedingUseCases = _useCase.getPrecedingUseCases();
                      boolean _operator_equals = ObjectExtensions.operator_equals(_precedingUseCases, null);
                      if (_operator_equals) {
                        _operator_or = true;
                      } else {
                        UseCase _useCase_1 = nusmv.getUseCase();
                        EList<UseCase> _precedingUseCases_1 = _useCase_1.getPrecedingUseCases();
                        boolean _isEmpty = _precedingUseCases_1.isEmpty();
                        _operator_or = BooleanExtensions.operator_or(_operator_equals, _isEmpty);
                      }
                      if (_operator_or) {
                        String _operator_plus_2 = StringExtensions.operator_plus("case\n", "\t\tp=p");
                        String _useCaseId_1 = nusmv.getUseCaseId();
                        String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, _useCaseId_1);
                        String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, " & idle & x");
                        String _useCaseId_2 = nusmv.getUseCaseId();
                        String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, _useCaseId_2);
                        String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, ".s = s0 : TRUE;\n");
                        String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, "\t\tTRUE : x");
                        String _useCaseId_3 = nusmv.getUseCaseId();
                        String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, _useCaseId_3);
                        String _operator_plus_9 = StringExtensions.operator_plus(_operator_plus_8, "run & x");
                        String _useCaseId_4 = nusmv.getUseCaseId();
                        String _operator_plus_10 = StringExtensions.operator_plus(_operator_plus_9, _useCaseId_4);
                        String _operator_plus_11 = StringExtensions.operator_plus(_operator_plus_10, ".s != sFin;\n");
                        String _operator_plus_12 = StringExtensions.operator_plus(_operator_plus_11, "\tesac");
                        it.setNextExpr(_operator_plus_12);
                      } else {
                        String _operator_plus_13 = StringExtensions.operator_plus("case\n", "\t\tp=p");
                        String _useCaseId_5 = nusmv.getUseCaseId();
                        String _operator_plus_14 = StringExtensions.operator_plus(_operator_plus_13, _useCaseId_5);
                        String _operator_plus_15 = StringExtensions.operator_plus(_operator_plus_14, " & idle & x");
                        String _useCaseId_6 = nusmv.getUseCaseId();
                        String _operator_plus_16 = StringExtensions.operator_plus(_operator_plus_15, _useCaseId_6);
                        String _operator_plus_17 = StringExtensions.operator_plus(_operator_plus_16, ".s = s0 & ");
                        UseCase _useCase_2 = nusmv.getUseCase();
                        EList<UseCase> _precedingUseCases_2 = _useCase_2.getPrecedingUseCases();
                        final Function1<UseCase,String> _function = new Function1<UseCase,String>() {
                            public String apply(final UseCase it) {
                              String _uc2id = nusmv.uc2id(it);
                              String _operator_plus = StringExtensions.operator_plus("x", _uc2id);
                              String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".s = sFin");
                              return _operator_plus_1;
                            }
                          };
                        String _join = IterableExtensions.<UseCase>join(_precedingUseCases_2, " & ", _function);
                        String _operator_plus_18 = StringExtensions.operator_plus(_operator_plus_17, _join);
                        String _operator_plus_19 = StringExtensions.operator_plus(_operator_plus_18, " : TRUE;\n");
                        String _operator_plus_20 = StringExtensions.operator_plus(_operator_plus_19, "\t\tTRUE : x");
                        String _useCaseId_7 = nusmv.getUseCaseId();
                        String _operator_plus_21 = StringExtensions.operator_plus(_operator_plus_20, _useCaseId_7);
                        String _operator_plus_22 = StringExtensions.operator_plus(_operator_plus_21, "run & x");
                        String _useCaseId_8 = nusmv.getUseCaseId();
                        String _operator_plus_23 = StringExtensions.operator_plus(_operator_plus_22, _useCaseId_8);
                        String _operator_plus_24 = StringExtensions.operator_plus(_operator_plus_23, ".s != sFin;\n");
                        String _operator_plus_25 = StringExtensions.operator_plus(_operator_plus_24, "\tesac");
                        it.setNextExpr(_operator_plus_25);
                      }
                    }
                  }
                };
              NextBody _$ = NuSMVProj.this._reprotoolMappingExtensions.<NextBody>$(_createNextBody, _function);
              CollectionExtensions.<NextBody>operator_add(_bodies, _$);
            }
          };
        AssignConstraint _$_3 = this._reprotoolMappingExtensions.<AssignConstraint>$(_createAssignConstraint, _function_3);
        CollectionExtensions.<AssignConstraint>operator_add(moduleElement, _$_3);
      }
    }
  }
  
  private void loadIncludedAnnotations() {
    for (final NuSMVGenerator nusmv : this.generators) {
      {
        int c = 0;
        List<UseCase> _includedUseCases = nusmv.getIncludedUseCases();
        for (final UseCase uc : _includedUseCases) {
          {
            int _operator_plus = IntegerExtensions.operator_plus(c, 1);
            c = _operator_plus;
            String _string = Integer.toString(c);
            final String label = _string;
            NuSMVGenerator _get = this.uc2gen.get(uc);
            final NuSMVGenerator g = _get;
            boolean _operator_equals = ObjectExtensions.operator_equals(g, null);
            if (_operator_equals) {
              RuntimeException _runtimeException = new RuntimeException("Include of unknown use case found.");
              throw _runtimeException;
            }
            ArrayList<UseCase> _arrayList = new ArrayList<UseCase>();
            final ArrayList<UseCase> ucList = _arrayList;
            CollectionExtensions.<UseCase>operator_add(ucList, uc);
            String _useCaseId = nusmv.getUseCaseId();
            String _operator_plus_1 = StringExtensions.operator_plus(_useCaseId, ".y");
            String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, label);
            this.addPath(g, _operator_plus_2, ucList);
          }
        }
      }
    }
  }
  
  private void addPath(final NuSMVGenerator g, final String id, final List<UseCase> ucList) {
      HashMap<String,AnnotationEntry> _annotationsTracker = g.getAnnotationsTracker();
      final HashMap<String,AnnotationEntry> annotationTracker = _annotationsTracker;
      Set<String> _keySet = annotationTracker.keySet();
      for (final String tag : _keySet) {
        {
          List<AnnotationEntry> _get = this.globalTracker.get(tag);
          final List<AnnotationEntry> list = _get;
          Assert.isNotNull(list);
          AnnotationEntry _get_1 = annotationTracker.get(tag);
          AnnotationEntry _annotationEntry = new AnnotationEntry(_get_1);
          final AnnotationEntry a = _annotationEntry;
          a.setAutomatonID(id);
          CollectionExtensions.<AnnotationEntry>operator_add(list, a);
        }
      }
      int c = 0;
      List<UseCase> _includedUseCases = g.getIncludedUseCases();
      for (final UseCase uc : _includedUseCases) {
        boolean _contains = ucList.contains(uc);
        boolean _operator_not = BooleanExtensions.operator_not(_contains);
        if (_operator_not) {
          {
            int _operator_plus = IntegerExtensions.operator_plus(c, 1);
            c = _operator_plus;
            String _string = Integer.toString(c);
            final String label = _string;
            NuSMVGenerator _get_2 = this.uc2gen.get(uc);
            final NuSMVGenerator gen = _get_2;
            CollectionExtensions.<UseCase>operator_add(ucList, uc);
            String _operator_plus_1 = StringExtensions.operator_plus(id, ".y");
            String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, label);
            this.addPath(gen, _operator_plus_2, ucList);
          }
        } else {
          RuntimeException _runtimeException = new RuntimeException("UseCases are recursively defined.");
          throw _runtimeException;
        }
      }
  }
  
  private void loadTLFormulas() {
    for (final TemporalLogicFormula formula : this.formulas) {
      {
        EObject _eContainer = formula.eContainer();
        Assert.isTrue((_eContainer instanceof TemporalAnnotationGroup));
        EObject _eContainer_1 = formula.eContainer();
        final TemporalAnnotationGroup tGrp = ((TemporalAnnotationGroup) _eContainer_1);
        ArrayList<String> _arrayList = new ArrayList<String>();
        final ArrayList<String> annotations = _arrayList;
        EList<TemporalAnnotation> _members = tGrp.getMembers();
        final Function1<TemporalAnnotation,String> _function = new Function1<TemporalAnnotation,String>() {
            public String apply(final TemporalAnnotation it) {
              String _name = it.getName();
              return _name;
            }
          };
        List<String> _map = ListExtensions.<TemporalAnnotation, String>map(_members, _function);
        CollectionExtensions.<String>operator_add(annotations, _map);
        List<String> _annotatedVars = this.getAnnotatedVars(annotations);
        final List<String> annotatedVars = _annotatedVars;
        for (final String variable : annotatedVars) {
          {
            String _formula = formula.getFormula();
            String f = _formula;
            EList<TemporalAnnotation> _members_1 = tGrp.getMembers();
            for (final TemporalAnnotation annot : _members_1) {
              String _name = annot.getName();
              boolean _contains = f.contains(_name);
              if (_contains) {
                {
                  String _name_1 = annot.getName();
                  String _operator_plus = StringExtensions.operator_plus(_name_1, "_");
                  String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, variable);
                  final String varName = _operator_plus_1;
                  String _name_2 = annot.getName();
                  String _replaceAll = f.replaceAll(_name_2, varName);
                  f = _replaceAll;
                  boolean _containsKey = this.globalTracker.containsKey(varName);
                  boolean _operator_not = BooleanExtensions.operator_not(_containsKey);
                  if (_operator_not) {
                    {
                      ArrayList<AnnotationEntry> _arrayList_1 = new ArrayList<AnnotationEntry>();
                      final List<AnnotationEntry> dummy = _arrayList_1;
                      Pair<String,List<AnnotationEntry>> _operator_mappedTo = ObjectExtensions.<String, List<AnnotationEntry>>operator_mappedTo(varName, dummy);
                      this._reprotoolMappingExtensions.<String, List<AnnotationEntry>>operator_add(this.globalTracker, _operator_mappedTo);
                    }
                  }
                }
              }
            }
            String _replaceAll_1 = f.replaceAll("[()\\s]+", "");
            final String normalised = _replaceAll_1;
            Pair<String,TemporalLogicFormula> _operator_mappedTo_1 = ObjectExtensions.<String, TemporalLogicFormula>operator_mappedTo(normalised, formula);
            this._reprotoolMappingExtensions.<String, TemporalLogicFormula>operator_add(this.expanded2Formula, _operator_mappedTo_1);
            if ((formula instanceof CTLFormula)) {
              CollectionExtensions.<String>operator_add(this.expandedCTLFormulas, f);
            } else {
              if ((formula instanceof LTLFormula)) {
                CollectionExtensions.<String>operator_add(this.expandedLTLFormulas, f);
              }
            }
          }
        }
      }
    }
  }
  
  private List<String> getAnnotatedVars(final List<String> annotations) {
    Set<String> _keySet = this.globalTracker.keySet();
    final Function1<String,Iterable<String>> _function = new Function1<String,Iterable<String>>() {
        public Iterable<String> apply(final String tag) {
          final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
              public Boolean apply(final String it) {
                boolean _startsWith = tag.startsWith(it);
                return Boolean.valueOf(_startsWith);
              }
            };
          Iterable<String> _filter = IterableExtensions.<String>filter(annotations, _function);
          final Function1<String,String> _function_1 = new Function1<String,String>() {
              public String apply(final String it2) {
                int _length = it2.length();
                int _operator_plus = IntegerExtensions.operator_plus(_length, 1);
                String _substring = tag.substring(_operator_plus);
                return _substring;
              }
            };
          Iterable<String> _map = IterableExtensions.<String, String>map(_filter, _function_1);
          return _map;
        }
      };
    Iterable<Iterable<String>> _map = IterableExtensions.<String, Iterable<String>>map(_keySet, _function);
    Iterable<String> _flatten = IterableExtensions.<String>flatten(_map);
    Set<String> _set = IterableExtensions.<String>toSet(_flatten);
    List<String> _list = IterableExtensions.<String>toList(_set);
    return _list;
  }
  
  private void processAnnotations() {
    final Function1<NuSMVGenerator,HashMap<String,AnnotationEntry>> _function = new Function1<NuSMVGenerator,HashMap<String,AnnotationEntry>>() {
        public HashMap<String,AnnotationEntry> apply(final NuSMVGenerator it) {
          HashMap<String,AnnotationEntry> _annotationsTracker = it.getAnnotationsTracker();
          return _annotationsTracker;
        }
      };
    List<HashMap<String,AnnotationEntry>> _map = ListExtensions.<NuSMVGenerator, HashMap<String,AnnotationEntry>>map(this.generators, _function);
    Iterable<HashMap<String,AnnotationEntry>> _filterNull = IterableExtensions.<HashMap<String,AnnotationEntry>>filterNull(_map);
    final Procedure1<HashMap<String,AnnotationEntry>> _function_1 = new Procedure1<HashMap<String,AnnotationEntry>>() {
        public void apply(final HashMap<String,AnnotationEntry> localTracker) {
          Set<String> _keySet = localTracker.keySet();
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                {
                  List<AnnotationEntry> _get = NuSMVProj.this.globalTracker.get(it);
                  List<AnnotationEntry> list = _get;
                  boolean _operator_equals = ObjectExtensions.operator_equals(list, null);
                  if (_operator_equals) {
                    {
                      ArrayList<AnnotationEntry> _arrayList = new ArrayList<AnnotationEntry>();
                      list = _arrayList;
                      Pair<String,List<AnnotationEntry>> _operator_mappedTo = ObjectExtensions.<String, List<AnnotationEntry>>operator_mappedTo(it, list);
                      NuSMVProj.this._reprotoolMappingExtensions.<String, List<AnnotationEntry>>operator_add(NuSMVProj.this.globalTracker, _operator_mappedTo);
                    }
                  }
                  AnnotationEntry _get_1 = localTracker.get(it);
                  CollectionExtensions.<AnnotationEntry>operator_add(list, _get_1);
                }
              }
            };
          IterableExtensions.<String>forEach(_keySet, _function);
        }
      };
    IterableExtensions.<HashMap<String,AnnotationEntry>>forEach(_filterNull, _function_1);
  }
}

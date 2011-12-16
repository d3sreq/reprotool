package reprotool.uml.export.mapping;

import com.google.inject.Inject;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.utils.xtend.ReprotoolMappingExtensions;

@SuppressWarnings("all")
public class UMLUseCaseModelGenerator {
  @Inject
  private ReprotoolMappingExtensions _reprotoolMappingExtensions;
  
  private HashMap<Actor,org.eclipse.uml2.uml.Actor> actorMap;
  
  private HashMap<UseCase,org.eclipse.uml2.uml.UseCase> useCaseMap;
  
  private UMLFactory factory;
  
  private Model model;
  
  public Model generateUMLUCModel(final SoftwareProject swproj) {
      HashMap<Actor,org.eclipse.uml2.uml.Actor> _hashMap = new HashMap<Actor,org.eclipse.uml2.uml.Actor>();
      this.actorMap = _hashMap;
      HashMap<UseCase,org.eclipse.uml2.uml.UseCase> _hashMap_1 = new HashMap<UseCase,org.eclipse.uml2.uml.UseCase>();
      this.useCaseMap = _hashMap_1;
      this.factory = UMLFactory.eINSTANCE;
      Model _createModel = this.factory.createModel();
      this.model = _createModel;
      this.loadActors(swproj);
      EList<UseCase> _useCases = swproj.getUseCases();
      final Procedure1<UseCase> _function = new Procedure1<UseCase>() {
          public void apply(final UseCase useCase) {
            UMLUseCaseModelGenerator.this.processUseCase(useCase);
          }
        };
      IterableExtensions.<UseCase>forEach(_useCases, _function);
      EList<UseCase> _useCases_1 = swproj.getUseCases();
      final Procedure1<UseCase> _function_1 = new Procedure1<UseCase>() {
          public void apply(final UseCase useCase) {
            UMLUseCaseModelGenerator.this.processUseCaseInclude(useCase);
          }
        };
      IterableExtensions.<UseCase>forEach(_useCases_1, _function_1);
      return this.model;
  }
  
  private void loadActors(final SoftwareProject swproj) {
    EList<Actor> _actors = swproj.getActors();
    final Procedure1<Actor> _function = new Procedure1<Actor>() {
        public void apply(final Actor swprojactor) {
          org.eclipse.uml2.uml.Actor _createActor = UMLUseCaseModelGenerator.this.factory.createActor();
          final Procedure1<org.eclipse.uml2.uml.Actor> _function = new Procedure1<org.eclipse.uml2.uml.Actor>() {
              public void apply(final org.eclipse.uml2.uml.Actor it) {
                {
                  it.setPackage(UMLUseCaseModelGenerator.this.model);
                  String _name = swprojactor.getName();
                  it.setName(_name);
                  Pair<Actor,org.eclipse.uml2.uml.Actor> _operator_mappedTo = ObjectExtensions.<Actor, org.eclipse.uml2.uml.Actor>operator_mappedTo(swprojactor, it);
                  UMLUseCaseModelGenerator.this._reprotoolMappingExtensions.<Actor, org.eclipse.uml2.uml.Actor>operator_add(UMLUseCaseModelGenerator.this.actorMap, _operator_mappedTo);
                }
              }
            };
          UMLUseCaseModelGenerator.this._reprotoolMappingExtensions.<org.eclipse.uml2.uml.Actor>$(_createActor, _function);
        }
      };
    IterableExtensions.<Actor>forEach(_actors, _function);
  }
  
  private void processUseCase(final UseCase u) {
      org.eclipse.uml2.uml.UseCase _createUseCase = this.factory.createUseCase();
      final org.eclipse.uml2.uml.UseCase uc = _createUseCase;
      this.useCaseMap.put(u, uc);
      String _name = u.getName();
      uc.setName(_name);
      uc.setPackage(this.model);
      Actor _primaryActor = u.getPrimaryActor();
      org.eclipse.uml2.uml.Actor _get = this.actorMap.get(_primaryActor);
      final org.eclipse.uml2.uml.Actor a = _get;
      boolean _operator_equals = ObjectExtensions.operator_equals(a, null);
      if (_operator_equals) {
        return;
      }
      Association _createAssociation = this.factory.createAssociation();
      final Association link = _createAssociation;
      Property _createProperty = this.factory.createProperty();
      final Property p1 = _createProperty;
      p1.setName("src");
      p1.setType(a);
      EList<Property> _navigableOwnedEnds = link.getNavigableOwnedEnds();
      _navigableOwnedEnds.add(p1);
      Property _createProperty_1 = this.factory.createProperty();
      final Property p2 = _createProperty_1;
      p2.setName("dst");
      p2.setType(uc);
      EList<Property> _navigableOwnedEnds_1 = link.getNavigableOwnedEnds();
      _navigableOwnedEnds_1.add(p2);
      link.setPackage(this.model);
  }
  
  private Boolean processUseCaseStep(final UseCaseStep step, final org.eclipse.uml2.uml.UseCase srcUseCase) {
    Boolean _xifexpression = null;
    Action _action = step.getAction();
    if ((_action instanceof UseCaseInclude)) {
      boolean _xblockexpression = false;
      {
        Action _action_1 = step.getAction();
        final UseCaseInclude include = ((UseCaseInclude) _action_1);
        UseCase _includeTarget = include.getIncludeTarget();
        final UseCase target = _includeTarget;
        org.eclipse.uml2.uml.UseCase _get = this.useCaseMap.get(target);
        final org.eclipse.uml2.uml.UseCase dst = _get;
        Include _createInclude = this.factory.createInclude();
        final Include incl = _createInclude;
        incl.setAddition(dst);
        EList<Include> _includes = srcUseCase.getIncludes();
        boolean _add = _includes.add(incl);
        _xblockexpression = (_add);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  private void processScenario(final Scenario scenario, final org.eclipse.uml2.uml.UseCase u) {
    EList<UseCaseStep> _steps = scenario.getSteps();
    for (final UseCaseStep step : _steps) {
      {
        this.processUseCaseStep(step, u);
        EList<Scenario> _extensions = step.getExtensions();
        final Procedure1<Scenario> _function = new Procedure1<Scenario>() {
            public void apply(final Scenario ext) {
              UMLUseCaseModelGenerator.this.processScenario(ext, u);
            }
          };
        IterableExtensions.<Scenario>forEach(_extensions, _function);
        EList<Scenario> _variations = step.getVariations();
        final Procedure1<Scenario> _function_1 = new Procedure1<Scenario>() {
            public void apply(final Scenario variation) {
              UMLUseCaseModelGenerator.this.processScenario(variation, u);
            }
          };
        IterableExtensions.<Scenario>forEach(_variations, _function_1);
      }
    }
  }
  
  private void processUseCaseInclude(final UseCase u) {
    Scenario _mainScenario = u.getMainScenario();
    org.eclipse.uml2.uml.UseCase _get = this.useCaseMap.get(u);
    this.processScenario(_mainScenario, _get);
  }
}

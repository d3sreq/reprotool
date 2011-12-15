package reprotool.uml.export.mapping;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.FromSystem;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.actionpart.SentenceActivity;
import reprotool.model.linguistic.actionpart.SentenceActor;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

@SuppressWarnings("all")
public class UMLGen {
  private HashMap<Actor,org.eclipse.uml2.uml.Class> actor2UML;
  
  private org.eclipse.uml2.uml.Class umlSystem;
  
  public <K extends Object, V extends Object> boolean operator_add(final Map<K,V> map, final Pair<K,V> pair) {
      K _key = pair.getKey();
      V _value = pair.getValue();
      map.put(_key, _value);
      return true;
  }
  
  private void loadActors(final SoftwareProject swproj, final Model model) {
      org.eclipse.uml2.uml.Class _createOwnedClass = model.createOwnedClass("system", false);
      this.umlSystem = _createOwnedClass;
      EList<Actor> _actors = swproj.getActors();
      final Procedure1<Actor> _function = new Procedure1<Actor>() {
          public void apply(final Actor actor) {
            String _name = actor.getName();
            org.eclipse.uml2.uml.Class _createOwnedClass = model.createOwnedClass(_name, false);
            Pair<Actor,org.eclipse.uml2.uml.Class> _operator_mappedTo = ObjectExtensions.<Actor, org.eclipse.uml2.uml.Class>operator_mappedTo(actor, _createOwnedClass);
            UMLGen.this.<Actor, org.eclipse.uml2.uml.Class>operator_add(UMLGen.this.actor2UML, _operator_mappedTo);
          }
        };
      IterableExtensions.<Actor>forEach(_actors, _function);
  }
  
  private Operation processUseCaseStep(final UseCaseStep step) {
    Operation _xblockexpression = null;
    {
      Action _action = step.getAction();
      if ((_action instanceof ToSystem)) {
        {
          Action _action_1 = step.getAction();
          final ToSystem action = ((ToSystem) _action_1);
          SentenceActivity _sentenceActivity = action.getSentenceActivity();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_sentenceActivity, null);
          if (_operator_notEquals) {
            {
              SentenceActivity _sentenceActivity_1 = action.getSentenceActivity();
              TextRange _text = _sentenceActivity_1.getText();
              final TextRange text = _text;
              boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(text, null);
              if (_operator_notEquals_1) {
                String _content = text.getContent();
                this.umlSystem.createOwnedOperation(_content, null, null);
              }
            }
          }
        }
      }
      Operation _xifexpression = null;
      Action _action_2 = step.getAction();
      if ((_action_2 instanceof FromSystem)) {
        Operation _xblockexpression_1 = null;
        {
          Action _action_3 = step.getAction();
          final FromSystem action_1 = ((FromSystem) _action_3);
          Operation _xifexpression_1 = null;
          SentenceActivity _sentenceActivity_2 = action_1.getSentenceActivity();
          boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(_sentenceActivity_2, null);
          if (_operator_notEquals_2) {
            Operation _xblockexpression_2 = null;
            {
              SentenceActor _receiver = action_1.getReceiver();
              Actor _actor = _receiver.getActor();
              final Actor actor = _actor;
              org.eclipse.uml2.uml.Class _get = this.actor2UML.get(actor);
              SentenceActivity _sentenceActivity_3 = action_1.getSentenceActivity();
              TextRange _text_1 = _sentenceActivity_3.getText();
              String _content_1 = _text_1.getContent();
              Operation _createOwnedOperation = _get.createOwnedOperation(_content_1, null, null);
              _xblockexpression_2 = (_createOwnedOperation);
            }
            _xifexpression_1 = _xblockexpression_2;
          }
          _xblockexpression_1 = (_xifexpression_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private void processScenario(final Scenario scenario) {
    EList<UseCaseStep> _steps = scenario.getSteps();
    for (final UseCaseStep step : _steps) {
      {
        this.processUseCaseStep(step);
        EList<Scenario> _extensions = step.getExtensions();
        final Procedure1<Scenario> _function = new Procedure1<Scenario>() {
            public void apply(final Scenario ext) {
              UMLGen.this.processScenario(ext);
            }
          };
        IterableExtensions.<Scenario>forEach(_extensions, _function);
        EList<Scenario> _variations = step.getVariations();
        final Procedure1<Scenario> _function_1 = new Procedure1<Scenario>() {
            public void apply(final Scenario variation) {
              UMLGen.this.processScenario(variation);
            }
          };
        IterableExtensions.<Scenario>forEach(_variations, _function_1);
      }
    }
  }
  
  private void processUseCase(final UseCase uc) {
    Scenario _mainScenario = uc.getMainScenario();
    this.processScenario(_mainScenario);
  }
  
  public void generateUMLModel(final SoftwareProject swproj, final Model model) {
      HashMap<Actor,org.eclipse.uml2.uml.Class> _hashMap = new HashMap<Actor,org.eclipse.uml2.uml.Class>();
      this.actor2UML = _hashMap;
      this.loadActors(swproj, model);
      EList<UseCase> _useCases = swproj.getUseCases();
      final Procedure1<UseCase> _function = new Procedure1<UseCase>() {
          public void apply(final UseCase useCase) {
            UMLGen.this.processUseCase(useCase);
          }
        };
      IterableExtensions.<UseCase>forEach(_useCases, _function);
  }
}

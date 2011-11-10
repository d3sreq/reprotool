
package reprotool.fm.nusmv.lang.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Model;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Module;
import reprotool.fm.nusmv.lang.validation.NuSmvInputLanguageJavaValidator;

public class NuSmvInputLanguageQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(NuSmvInputLanguageJavaValidator.MISSING_MAIN_MODULE)
	public void addMainModule(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Add main module",
			"This will add MODULE main to the file",
			"Operation.gif",
			new IModification() {
				public void apply(IModificationContext context) throws BadLocationException {
					IXtextDocument xtextDocument = context.getXtextDocument();
					xtextDocument.set("MODULE main\n\n" + xtextDocument.get());
				}
			}
		);
	}

	@Fix(NuSmvInputLanguageJavaValidator.MISSING_MAIN_MODULE)
	public void renameFirstModule(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Rename first module to 'main'",
			"This will rename the first module in your code",
			"Operation.gif",
			new ISemanticModification() {
				
				public void apply(EObject element, IModificationContext context)
						throws Exception {
					Model model = (Model) element;
					Module firstModule = model.getModules().get(0);
					firstModule.setName("main");
				}
			}
		);
	}
	
	@Fix(NuSmvInputLanguageJavaValidator.PARAMETERS_NOT_ALLOWED)
	public void removeModuleParams(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Remove parameters",
			"Parameters will be removed from the module",
			"Operation.gif",
			new ISemanticModification() {
				public void apply(EObject element, IModificationContext context)
						throws Exception {
					Module module = (Module) element;
					module.getParams().clear();
				}
			}
		);
	}
	

}

package reprotool.ide.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;

import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import reprotool.ide.service.Service;
import reprotool.model.specification.UseCase;
import reprotool.model.specification.UseCaseStep;

public class UcStepView extends ViewPart {

	public static final String ID = "cz.cuni.mff.reprotool.ide.uc_step_view";

	private Label lblStepSentence = null;
	private Label lblActorDesc = null;
	private Composite parentComposite = null;

	public UcStepView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(final Composite parent) {
		parentComposite = parent;
		parent.setLayout(new FormLayout());

		Group grpStep = new Group(parent, SWT.NONE);
		grpStep.setText("Step");
		FillLayout fl_grpStep = new FillLayout(SWT.HORIZONTAL);
		fl_grpStep.marginWidth = 5;
		fl_grpStep.marginHeight = 5;
		grpStep.setLayout(fl_grpStep);
		FormData fd_grpStep = new FormData();
		fd_grpStep.left = new FormAttachment(0, 10);
		fd_grpStep.right = new FormAttachment(100, -10);
		fd_grpStep.top = new FormAttachment(0, 10);
		grpStep.setLayoutData(fd_grpStep);

		lblStepSentence = new Label(grpStep, SWT.WRAP);
		lblStepSentence.setText("No step selected");

		Group grpAnalysisResult = new Group(parent, SWT.NONE);
		grpAnalysisResult.setText("Analysis result");
		grpAnalysisResult.setLayout(new FillLayout(SWT.VERTICAL));
		FormData fd_grpAnalysisResult = new FormData();
		fd_grpAnalysisResult.top = new FormAttachment(grpStep, 10);
		fd_grpAnalysisResult.left = new FormAttachment(0, 10);
		fd_grpAnalysisResult.right = new FormAttachment(100, -10);
		grpAnalysisResult.setLayoutData(fd_grpAnalysisResult);

		Composite c_actiontype = new Composite(grpAnalysisResult, SWT.NONE);
		c_actiontype.setLayout(new FormLayout());

		Label lblStepIsA = new Label(c_actiontype, SWT.NONE);
		FormData fd_lblStepIsA = new FormData();
		fd_lblStepIsA.top = new FormAttachment(0, 7);
		fd_lblStepIsA.left = new FormAttachment(0, 5);
		lblStepIsA.setLayoutData(fd_lblStepIsA);
		lblStepIsA.setText("Step is a");
		Combo combo = new Combo(c_actiontype, SWT.NONE);
		FormData fd_combo = new FormData();
		fd_combo.right = new FormAttachment(lblStepIsA, 205);
		fd_combo.top = new FormAttachment(0, 3);
		fd_combo.left = new FormAttachment(lblStepIsA, 5);
		combo.setLayoutData(fd_combo);
		combo.setEnabled(false);
		combo.setText("internal");
		Label lblAction = new Label(c_actiontype, SWT.NONE);
		FormData fd_lblAction = new FormData();
		fd_lblAction.top = new FormAttachment(0, 7);
		fd_lblAction.left = new FormAttachment(combo, 5);
		lblAction.setLayoutData(fd_lblAction);
		lblAction.setText("action");

		Composite c_actor = new Composite(grpAnalysisResult, SWT.NONE);
		c_actor.setLayout(new FormLayout());
		Label lblActor = new Label(c_actor, SWT.NONE);
		FormData fd_lblActor = new FormData();
		fd_lblActor.top = new FormAttachment(0, 8);
		fd_lblActor.left = new FormAttachment(0, 5);
		lblActor.setLayoutData(fd_lblActor);
		lblActor.setText("Primary actor:");
		lblActorDesc = new Label(c_actor, SWT.WRAP);
		FormData fd_lblActorDesc = new FormData();
		fd_lblActorDesc.right = new FormAttachment(100, -10);
		fd_lblActorDesc.top = new FormAttachment(0, 8);
		fd_lblActorDesc.left = new FormAttachment(lblActor, 5);
		lblActorDesc.setLayoutData(fd_lblActorDesc);


		Group grpToken = new Group(parent, SWT.NONE);
		grpToken.setText("Token");
		FormData fd_grpToken = new FormData();
		fd_grpToken.top = new FormAttachment(grpAnalysisResult, 10);
		FillLayout fl_grpToken = new FillLayout(SWT.HORIZONTAL);
		fl_grpToken.marginWidth = 10;
		fl_grpToken.marginHeight = 10;
		grpToken.setLayout(fl_grpToken);
		fd_grpToken.left = new FormAttachment(0, 10);
		fd_grpToken.right = new FormAttachment(100, -10);
		grpToken.setLayoutData(fd_grpToken);

		Label lbltokentext = new Label(grpToken, SWT.WRAP);
		lbltokentext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TokenWizard tw = new TokenWizard(parent.getShell(), SWT.NONE);
				tw.open();
			}
		});
		lbltokentext.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		lbltokentext.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lbltokentext.setText("#tokenText");
	}

	public void setStep(UseCaseStep s) {
		lblStepSentence.setText(s.getDesc());
		// TODO reference from UCStep to UseCase?
		for (UseCase u : Service.INSTANCE.getSoftwareProject().getUseCases()) {
			if (u.getUseCaseSteps().contains(s)) {
				lblActorDesc.setText(u.getPrimaryActor().getName());
				break;
			}
		}
		parentComposite.layout();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}

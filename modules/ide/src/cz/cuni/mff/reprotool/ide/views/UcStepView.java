package cz.cuni.mff.reprotool.ide.views;

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

public class UcStepView extends ViewPart {
	
	public UcStepView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
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

        Group grpAnalysisResult = new Group(parent, SWT.NONE);
        grpAnalysisResult.setText("Analysis result");
        FormLayout fl_grpAnalysisResult = new FormLayout();
        fl_grpAnalysisResult.marginBottom = 5;
        fl_grpAnalysisResult.marginHeight = 5;
        grpAnalysisResult.setLayout(fl_grpAnalysisResult);
        FormData fd_grpAnalysisResult = new FormData();
        fd_grpAnalysisResult.top = new FormAttachment(grpStep, 10);
        fd_grpAnalysisResult.left = new FormAttachment(0, 10);
        fd_grpAnalysisResult.right = new FormAttachment(100, -10);
        grpAnalysisResult.setLayoutData(fd_grpAnalysisResult);
        
        Label lblStepSentence = new Label(grpStep, SWT.WRAP);
        lblStepSentence.setText("Step sentence - Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque feugiat, urna eu condimentum convallis, dui elit malesuada elit, id lacinia quam enim at nisl. Etiam faucibus nisi sit amet quam dignissim in sodales est elementum. In metus lorem, malesuada ac euismod sit amet, cursus nec neque.");
        
        Label lblStepIsA = new Label(grpAnalysisResult, SWT.NONE);
        FormData fd_lblStepIsA = new FormData();
        fd_lblStepIsA.bottom = new FormAttachment(0, 31);
        fd_lblStepIsA.right = new FormAttachment(0, 57);
        fd_lblStepIsA.top = new FormAttachment(0, 9);
        fd_lblStepIsA.left = new FormAttachment(0, 8);
        lblStepIsA.setLayoutData(fd_lblStepIsA);
        lblStepIsA.setText("Step is a");
        
        Combo combo = new Combo(grpAnalysisResult, SWT.NONE);
        FormData fd_combo = new FormData();
        fd_combo.right = new FormAttachment(0, 155);
        fd_combo.top = new FormAttachment(0, 6);
        fd_combo.left = new FormAttachment(0, 63);
        combo.setLayoutData(fd_combo);
        combo.setText("internal");
        
        Label lblAction = new Label(grpAnalysisResult, SWT.NONE);
        FormData fd_lblAction = new FormData();
        fd_lblAction.bottom = new FormAttachment(0, 22);
        fd_lblAction.right = new FormAttachment(0, 210);
        fd_lblAction.top = new FormAttachment(0, 9);
        fd_lblAction.left = new FormAttachment(0, 161);
        lblAction.setLayoutData(fd_lblAction);
        lblAction.setText("action");
        
        
        Group grpToken = new Group(parent, SWT.NONE);
        grpToken.setText("Token");
        FormData fd_grpToken = new FormData();
        fd_grpToken.top = new FormAttachment(grpStep, 120);
        
        Label lblActor = new Label(grpAnalysisResult, SWT.NONE);
        FormData fd_lblActor = new FormData();
        fd_lblActor.right = new FormAttachment(0, 106);
        fd_lblActor.top = new FormAttachment(0, 46);
        fd_lblActor.left = new FormAttachment(0, 8);
        lblActor.setLayoutData(fd_lblActor);
        lblActor.setText("Primary actor:");
        
        Label lblNewLabel = new Label(grpAnalysisResult, SWT.WRAP);
        FormData fd_lblNewLabel = new FormData();
        fd_lblNewLabel.right = new FormAttachment(0, 552);
        fd_lblNewLabel.top = new FormAttachment(0, 47);
        fd_lblNewLabel.left = new FormAttachment(0, 111);
        lblNewLabel.setLayoutData(fd_lblNewLabel);
        lblNewLabel.setText("<actor>");
        FillLayout fl_grpToken = new FillLayout(SWT.HORIZONTAL);
        fl_grpToken.marginWidth = 10;
        fl_grpToken.marginHeight = 10;
        grpToken.setLayout(fl_grpToken);
        fd_grpToken.left = new FormAttachment(0, 10);
        fd_grpToken.right = new FormAttachment(100, -10);
        grpToken.setLayoutData(fd_grpToken);

        
        Label lbltokentext = new Label(grpToken, SWT.WRAP);
        lbltokentext.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
        lbltokentext.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
        lbltokentext.setText("#tokenText");
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}

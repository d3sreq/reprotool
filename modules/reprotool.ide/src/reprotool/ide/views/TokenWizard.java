package reprotool.ide.views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

public class TokenWizard extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text txtManual;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TokenWizard(Shell parent, int style) {
		super(parent, style);
		setText("Token wizard");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);
		shell.setMinimumSize(new Point(400, 550));
		shell.setSize(550, 550);
		shell.setText(getText());
		shell.setLayout(new FormLayout());
		
		Group grpGeneratedToken = new Group(shell, SWT.NONE);
		grpGeneratedToken.setText("Generated token");
		FormData fd_grpGeneratedToken = new FormData();
		fd_grpGeneratedToken.left = new FormAttachment(0, 10);
		fd_grpGeneratedToken.right = new FormAttachment(100, -10);
		fd_grpGeneratedToken.top = new FormAttachment(0, 10);
		grpGeneratedToken.setLayoutData(fd_grpGeneratedToken);
		FillLayout fl_grpGeneratedToken = new FillLayout(SWT.HORIZONTAL);
		fl_grpGeneratedToken.marginWidth = 5;
		fl_grpGeneratedToken.marginHeight = 5;
		grpGeneratedToken.setLayout(fl_grpGeneratedToken);
		
		Label lbltoken = new Label(grpGeneratedToken, SWT.NONE);
		lbltoken.setText("#someToken");
		
		Group grpMerging = new Group(shell, SWT.NONE);
		grpMerging.setLayout(new FormLayout());
		FormData fd_grpMerging = new FormData();
		fd_grpMerging.top = new FormAttachment(grpGeneratedToken, 10);
		fd_grpMerging.left = new FormAttachment(0, 10);
		fd_grpMerging.right= new FormAttachment(100, -10);
		fd_grpMerging.bottom = new FormAttachment(50, -5);
		grpMerging.setLayoutData(fd_grpMerging);
		grpMerging.setText("Merging");
		
		Label lblMostSimilarTokens = new Label(grpMerging, SWT.NONE);
		FormData fd_lblMostSimilarTokens = new FormData();
		fd_lblMostSimilarTokens.top = new FormAttachment(0, 5);
		fd_lblMostSimilarTokens.left = new FormAttachment(0, 10);
		lblMostSimilarTokens.setLayoutData(fd_lblMostSimilarTokens);
		lblMostSimilarTokens.setText("Most similar tokens");
		
		Label lblTokensFromOpposite = new Label(grpMerging, SWT.NONE);
		FormData fd_lblTokensFromOpposite = new FormData();
		fd_lblTokensFromOpposite.top = new FormAttachment(0, 5);
		fd_lblTokensFromOpposite.left = new FormAttachment(50, 10);
		lblTokensFromOpposite.setLayoutData(fd_lblTokensFromOpposite);
		lblTokensFromOpposite.setText("Tokens from opposite entities");
		
		Button btnUse = new Button(grpMerging, SWT.NONE);
		FormData fd_btnUse = new FormData();
		fd_btnUse.right = new FormAttachment(100, -10);
		fd_btnUse.bottom = new FormAttachment(100, -5);
		btnUse.setLayoutData(fd_btnUse);
		btnUse.setText("Use");
		
		Button btnAllTokens = new Button(grpMerging, SWT.NONE);
		btnAllTokens.setAlignment(SWT.RIGHT);
		FormData fd_btnAllTokens = new FormData();
		fd_btnAllTokens.right = new FormAttachment(btnUse, -10);
		fd_btnAllTokens.bottom = new FormAttachment(100, -5);
		btnAllTokens.setLayoutData(fd_btnAllTokens);
		btnAllTokens.setText("All tokens");
		
		List listMostSimilar = new List(grpMerging, SWT.BORDER);
		FormData fd_listMostSimilar = new FormData();
		fd_listMostSimilar.left = new FormAttachment(0, 5);
		fd_listMostSimilar.right = new FormAttachment(50, -5);
		fd_listMostSimilar.bottom = new FormAttachment(btnUse, -5);
		fd_listMostSimilar.top = new FormAttachment(lblMostSimilarTokens, 3);
		listMostSimilar.setLayoutData(fd_listMostSimilar);
		
		List listFromOpposite = new List(grpMerging, SWT.BORDER);
		FormData fd_listFromOpposite = new FormData();
		fd_listFromOpposite.left = new FormAttachment(50, 10);
		fd_listFromOpposite.right = new FormAttachment(100, -5);
		fd_listFromOpposite.bottom = new FormAttachment(btnUse, -5);
		fd_listFromOpposite.top = new FormAttachment(lblTokensFromOpposite, 3);
		listFromOpposite.setLayoutData(fd_listFromOpposite);
		
		Group grpMixing = new Group(shell, SWT.NONE);
		grpMixing.setText("Mixing");
		grpMixing.setLayout(new FormLayout());
		FormData fd_grpMixing = new FormData();
		fd_grpMixing.top = new FormAttachment(50, 3);
		fd_grpMixing.right = new FormAttachment(100, -10);
		fd_grpMixing.left = new FormAttachment(0, 10);
		grpMixing.setLayoutData(fd_grpMixing);
		
		Group grpWriteByHand = new Group(shell, SWT.NONE);
		fd_grpMixing.bottom = new FormAttachment(grpWriteByHand, -10);
		
		Label lblInSentence = new Label(grpMixing, SWT.NONE);
		FormData fd_lblInSentence = new FormData();
		fd_lblInSentence.right = new FormAttachment(50, -10);
		fd_lblInSentence.top = new FormAttachment(0, 3);
		fd_lblInSentence.left = new FormAttachment(0, 10);
		lblInSentence.setLayoutData(fd_lblInSentence);
		lblInSentence.setText("Words used in sentence");
		
		Label lblInToken = new Label(grpMixing, SWT.NONE);
		FormData fd_lblInToken = new FormData();
		fd_lblInToken.right = new FormAttachment(100, -10);
		fd_lblInToken.top = new FormAttachment(0, 5);
		fd_lblInToken.left = new FormAttachment(50, 10);
		lblInToken.setLayoutData(fd_lblInToken);
		lblInToken.setText("Words used in token");
		
		List listInSentence = new List(grpMixing, SWT.BORDER);
		FormData fd_listInSentence = new FormData();
		fd_listInSentence.top = new FormAttachment(lblInToken, 3);
		fd_listInSentence.left = new FormAttachment(0, 10);
		fd_listInSentence.right = new FormAttachment(50, -60);
		fd_listInSentence.bottom = new FormAttachment(100, -10);
		listInSentence.setLayoutData(fd_listInSentence);
		
		List listInToken = new List(grpMixing, SWT.BORDER);
		FormData fd_listInToken = new FormData();
		fd_listInToken.top = new FormAttachment(lblInToken, 3);
		fd_listInToken.left = new FormAttachment(50, 10);
		fd_listInToken.right = new FormAttachment(100, -60);
		fd_listInToken.bottom = new FormAttachment(100, -10);
		listInToken.setLayoutData(fd_listInToken);
		
		Button btnRight = new Button(grpMixing, SWT.NONE);
		FormData fd_btnRight = new FormData();
		fd_btnRight.top = new FormAttachment(50, -20);
		fd_btnRight.right = new FormAttachment(50, -5);
		fd_btnRight.left = new FormAttachment(50, -45);
		btnRight.setLayoutData(fd_btnRight);
		btnRight.setText("->");
		
		Button btnLeft = new Button(grpMixing, SWT.NONE);
		FormData fd_btnLeft = new FormData();
		fd_btnLeft.top = new FormAttachment(btnRight, 0);
		fd_btnLeft.right = new FormAttachment(50, -5);
		fd_btnLeft.left = new FormAttachment(50, -45);
		btnLeft.setLayoutData(fd_btnLeft);
		btnLeft.setText("<-");
		
		Button btnUseWords = new Button(grpMixing, SWT.NONE);
		FormData fd_btnUseWords = new FormData();
		fd_btnUseWords.bottom = new FormAttachment(100, -10);
		fd_btnUseWords.left = new FormAttachment(listInToken, 10);
		fd_btnUseWords.right= new FormAttachment(100, -10);
		btnUseWords.setLayoutData(fd_btnUseWords);
		btnUseWords.setText("Use");
		
		Button btnUp = new Button(grpMixing, SWT.NONE);
		FormData fd_btnUp = new FormData();
		fd_btnUp.top = new FormAttachment(lblInToken, 10);
		fd_btnUp.right = new FormAttachment(100, -15);
		fd_btnUp.left = new FormAttachment(100, -45);
		btnUp.setLayoutData(fd_btnUp);
		btnUp.setText("^");
		
		Button btnDown = new Button(grpMixing, SWT.NONE);
		FormData fd_btnDown = new FormData();
		fd_btnDown.top = new FormAttachment(btnUp, 0);
		fd_btnDown.right = new FormAttachment(100, -15);
		fd_btnDown.left = new FormAttachment(100, -45);
		btnDown.setLayoutData(fd_btnDown);
		btnDown.setText("v");
		grpWriteByHand.setText("Write by hand");
		RowLayout rl_grpWriteByHand = new RowLayout(SWT.HORIZONTAL);
		rl_grpWriteByHand.marginWidth = 10;
		rl_grpWriteByHand.spacing = 8;
		rl_grpWriteByHand.center = true;
		grpWriteByHand.setLayout(rl_grpWriteByHand);
		FormData fd_grpWriteByHand = new FormData();
		fd_grpWriteByHand.right = new FormAttachment(100, -10);
		fd_grpWriteByHand.left = new FormAttachment(0, 10);
		fd_grpWriteByHand.bottom = new FormAttachment(100, -10);
		grpWriteByHand.setLayoutData(fd_grpWriteByHand);
		
		Label lblType = new Label(grpWriteByHand, SWT.NONE);
		lblType.setText("<type> .");
		
		txtManual = new Text(grpWriteByHand, SWT.BORDER);
		txtManual.setLayoutData(new RowData(200, SWT.DEFAULT));
		
		Button btnUseManual = new Button(grpWriteByHand, SWT.NONE);
		btnUseManual.setText("Use");
	}
}

package reprotool.ide.preferences;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import reprotool.ide.Activator;
import reprotool.ling.wordnet.WordNet;


public class LingToolsPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	private ComboFieldEditor comboDict;	

	private StringFieldEditor fieldDict; 
	private BooleanFieldEditor externalWordnet; 
	private Group wordnetGroup;
	private Group parserGroup;
	
	public LingToolsPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Linguistics tools settings");
	}
	

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PreferenceConstants.MODEL_LOC, 
				"&Model location:", getFieldEditorParent()));

		addField(new DirectoryFieldEditor(PreferenceConstants.MXPOST_MODEL, 
				"&MXPOS Tagger model:", getFieldEditorParent()));

		wordnetGroup = new Group(getFieldEditorParent(),SWT.NONE); 
		wordnetGroup.setText("WordNet settings");
		GridLayout wordnetLayout = new GridLayout();		
		wordnetLayout.verticalSpacing = 10;		
		wordnetGroup.setLayout(wordnetLayout);
		
		GridData wordnetLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		wordnetLayoutData.horizontalSpan = 3;
		wordnetGroup.setLayoutData(wordnetLayoutData);
			
		//IExtension[] allfield = Platform.getExtensionRegistry().getExtensions("reprotool.ide");

		//ArrayList<String[]> test = new ArrayList<String[]>();
		//List<String[]> test = new ArrayList<String[]>();
        //test.add(new String[] {"foo","foo"});
        
        /*int i = 0;
        for (IExtension ext : allfield) {
        	if((ext != null)&&(ext.getExtensionPointUniqueIdentifier().contains("org"))){
        		test.add(new String[] {"foo","foo"});
        		i++;
        	}
        	
        }*/
		
		
		comboDict = new ComboFieldEditor(PreferenceConstants.WORDNET_SELECTION,
			"Dictionary", //test.toArray(String[])
			new String[][] { { "Choice 1", "choice1" }, {"Choice 2", "choice2" }}
		, wordnetGroup);
		addField(comboDict);
		
		externalWordnet = new BooleanFieldEditor(PreferenceConstants.EXTERNAL_WORDNET,
				"&External WordNet dictionary",	wordnetGroup);
		addField(externalWordnet);
		
		fieldDict = new DirectoryFieldEditor(PreferenceConstants.WORDNET_DICT, 
				"&WordNet path:", wordnetGroup);
		fieldDict.setEnabled(false, wordnetGroup);
		
		addField(fieldDict);
		
		// parser properties
		parserGroup = new Group(getFieldEditorParent(),SWT.NONE); 
		parserGroup.setText("Dan Bikel's parser settings");
		GridLayout parserLayout = new GridLayout();		
		parserLayout.verticalSpacing = 10;		
		parserGroup.setLayout(wordnetLayout);
		
		GridData parserLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		parserLayoutData.horizontalSpan = 2;
		parserGroup.setLayoutData(wordnetLayoutData);
		
		addField(new FileFieldEditor(PreferenceConstants.PARSER_MODEL, 
				"&Parser model:", parserGroup));
		addField(new FileFieldEditor(PreferenceConstants.PARSER_SETTINGS, 
				"&Parser settings file:", parserGroup));
		
	}

	
	protected void checkState() {
        super.checkState();
        if(fieldDict.getStringValue()!= null && !fieldDict.getStringValue().equals("")){
            if(WordNet.validateDictionary(fieldDict.getStringValue())){
            	setErrorMessage(null);
                setValid(true);            	
            } else {
                setErrorMessage("Folder must contain WordNet dictionary!");
                setValid(false);           	
            }
        }else{
              setErrorMessage("Folder name cannot be blank!");
              setValid(false);
        }
        
        comboDict.setEnabled(!externalWordnet.getBooleanValue(), wordnetGroup);     
        fieldDict.setEnabled(externalWordnet.getBooleanValue(), wordnetGroup);      

	}
	
	public void propertyChange(PropertyChangeEvent event) {
        super.propertyChange(event);
        if (event.getProperty().equals(FieldEditor.VALUE)) {
        	checkState();
        }              
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}
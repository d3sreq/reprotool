package org.eclipse.wb.rcp.databinding;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import reprotool.model.specification.UseCaseStep;

public class UseCaseStepLabelProvider extends LabelProvider implements ITableLabelProvider {
    public Image getColumnImage(Object element, int columnIndex) {
       return null;
    }
    public String getColumnText(Object element, int columnIndex) {
    	UseCaseStep step = (UseCaseStep)element;
    	String result = "";
        switch(columnIndex){
            case 0:
            	// TODO
                result = "x";
                break;
            case 1:
                result = step.getLabel();
                break;
            case 2:
                result = step.getDesc();
                break;
            case 3:
            	// TODO inefficient and not working
            	if (step.getParentStep() != null)
	                result = step.getParentStep().getExtensions().contains(step) ? "extension" : "variation";
                break;
        }
        return result;
    }
    
	@Override
	public void addListener(ILabelProviderListener listener)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isLabelProperty(Object element, String property)
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void removeListener(ILabelProviderListener listener)
	{
		// TODO Auto-generated method stub
		
	}
}

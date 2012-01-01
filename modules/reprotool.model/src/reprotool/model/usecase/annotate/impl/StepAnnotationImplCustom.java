package reprotool.model.usecase.annotate.impl;


/**
 * @author Viliam Simko
 */
public class StepAnnotationImplCustom extends StepAnnotationImpl {

	@Override
	public String getDescription() {
		String typeName = getAnnotationType() == null ? "" : getAnnotationType().getName();
		return "#" + typeName + "_" + getId();
	}
}

package reprotool.model.usecase.annotate.impl;


/**
 * @author Viliam Simko
 */
public class StepAnnotationImplCustom extends StepAnnotationImpl {

	@Override
	public String getDescription() {
		return "#" + getAnnotationType().getName() + "_" + getId();
	}
}

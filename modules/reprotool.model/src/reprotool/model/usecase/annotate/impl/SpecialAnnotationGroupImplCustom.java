package reprotool.model.usecase.annotate.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.EcoreUtil2;

import reprotool.model.usecase.annotate.AnnotatePackage;

/**
 * @author Viliam Simko
 */
public class SpecialAnnotationGroupImplCustom extends SpecialAnnotationGroupImpl {

	@Override
	public String getDescription() {
		List<String> descrList = EcoreUtil2.collect(
				getMembers(),
				AnnotatePackage.STEP_ANNOTATION_TYPE__NAME,
				String.class);

		return StringUtils.join(descrList, "-");
	}
}

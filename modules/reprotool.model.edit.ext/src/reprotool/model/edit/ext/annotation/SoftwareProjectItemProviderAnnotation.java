package reprotool.model.edit.ext.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

/**
 * Guice annotation to distinguish adapter factories.
 * 
 * @author jvinarek
 *
 */
@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD })
@Retention(RUNTIME)
public @interface SoftwareProjectItemProviderAnnotation {
}

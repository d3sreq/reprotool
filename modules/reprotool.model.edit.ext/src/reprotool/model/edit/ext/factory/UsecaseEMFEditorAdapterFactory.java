package reprotool.model.edit.ext.factory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import reprotool.model.usecase.UsecasePackage;
import reprotool.model.usecase.provider.ScenarioItemProvider;
import reprotool.model.usecase.provider.ScenarioItemProviderExt;
import reprotool.model.usecase.provider.UseCaseItemProvider;
import reprotool.model.usecase.provider.UseCaseItemProviderExt;
import reprotool.model.usecase.provider.UseCaseStepItemProvider;
import reprotool.model.usecase.provider.UseCaseStepItemProviderExt;
import reprotool.model.usecase.provider.UsecaseItemProviderAdapterFactory;
import reprotool.model.usecase.provider.UsecaseItemProviderAdapterFactoryExt;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Provides item providers for use case editor.
 * 
 * @author jvinarek
 *
 */
public class UsecaseEMFEditorAdapterFactory extends ComposedAdapterFactory {
	
	public UsecaseEMFEditorAdapterFactory() {
		Injector injector = Guice.createInjector(new UsecaseEMFEditorModule());

		UsecaseItemProviderAdapterFactory usecaseItemProviderAdapterFactory = injector.getInstance(UsecaseItemProviderAdapterFactory.class);
		
		addAdapterFactory(new ResourceItemProviderAdapterFactory());
		addAdapterFactory(usecaseItemProviderAdapterFactory);
		addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	private static class UsecaseEMFEditorModule extends AbstractModule {

		@Override
		protected void configure() {
			// factory
			//
			bind(UsecaseItemProviderAdapterFactory.class).to(UsecaseItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
			
			// factory item providers
			//
			bind(UseCaseItemProvider.class).to(UseCaseItemProviderExt.class).in(Scopes.SINGLETON);
			bind(ScenarioItemProvider.class).to(ScenarioItemProviderExt.class).in(Scopes.SINGLETON);
			bind(UseCaseStepItemProvider.class).to(UseCaseStepItemProviderExt.class).in(Scopes.SINGLETON);
			
			// item providers dependencies
			//
			// use case item provider needs SwprojItemProviderAdapterFactoryExt as parent factory 
			bind(AdapterFactory.class).annotatedWith(Names.named(UseCaseItemProviderExt.USE_CASE_ITEM_PROVIDER_ANNOTATION)).to(UsecaseItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
			bindUseCaseStepItemProvider();
			bindScenarioItemProvider();
		}
		
		private void bindUseCaseStepItemProvider() {
			bind(AdapterFactory.class).annotatedWith(Names.named(UseCaseItemProviderExt.USE_CASE_ITEM_PROVIDER_ANNOTATION)).to(UsecaseItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
			
			List<EReference> customUseCaseStepChildren = new ArrayList<EReference>();
			customUseCaseStepChildren.add(UsecasePackage.Literals.USE_CASE_STEP__EXTENSIONS);
			customUseCaseStepChildren.add(UsecasePackage.Literals.USE_CASE_STEP__VARIATIONS);
		
			bind(new TypeLiteral<List<EReference>>() {}).annotatedWith(Names.named(UseCaseStepItemProviderExt.CUSTOM_CHILDREN_FEATURES_KEY)).toInstance(customUseCaseStepChildren);
		}

		private void bindScenarioItemProvider() {
			bind(AdapterFactory.class).annotatedWith(Names.named(ScenarioItemProviderExt.SCENARIO_ITEM_PROVIDER_ANNOTATION)).to(UsecaseItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);

			List<EReference> customUseCaseStepChildren = new ArrayList<EReference>();
			customUseCaseStepChildren.add(UsecasePackage.Literals.SCENARIO__STEPS);
			
			bind(new TypeLiteral<List<EReference>>() {}).annotatedWith(Names.named(ScenarioItemProviderExt.CUSTOM_CHILDREN_FEATURES_KEY)).toInstance(customUseCaseStepChildren);
		}

	}
	
}

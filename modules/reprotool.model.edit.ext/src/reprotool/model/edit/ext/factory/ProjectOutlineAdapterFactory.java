package reprotool.model.edit.ext.factory;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import reprotool.model.swproj.provider.ActorItemProvider;
import reprotool.model.swproj.provider.ActorItemProviderExt;
import reprotool.model.swproj.provider.ConceptualObjectItemProvider;
import reprotool.model.swproj.provider.ConceptualObjectItemProviderExt;
import reprotool.model.swproj.provider.SoftwareProjectItemProvider;
import reprotool.model.swproj.provider.SoftwareProjectItemProviderExt;
import reprotool.model.swproj.provider.SwprojItemProviderAdapterFactory;
import reprotool.model.swproj.provider.SwprojItemProviderAdapterFactoryExt;
import reprotool.model.swproj.provider.SwprojItemProviderAdapterFactoryExt.FactorySoftwareProject;
import reprotool.model.usecase.provider.UseCaseItemProvider;
import reprotool.model.usecase.provider.UseCaseItemProviderExt;
import reprotool.model.usecase.provider.UsecaseItemProviderAdapterFactory;
import reprotool.model.usecase.provider.UsecaseItemProviderAdapterFactoryExt;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Provides item providers for outline view in project editor.
 * 
 * @author jvinarek
 *
 */
public class ProjectOutlineAdapterFactory extends ComposedAdapterFactory {

	public static final String SOFTWARE_PROJECT_ITEM_PROVIDER_ANNOTATION = "SOFTWARE_PROJECT_ITEM_PROVIDER_ANNOTATION";
	
	public ProjectOutlineAdapterFactory() {
		Injector injector = Guice.createInjector(new ProjectOutlineModule());

		SwprojItemProviderAdapterFactory swprojItemProviderAdapterFactory = injector.getInstance(SwprojItemProviderAdapterFactory.class);
		UsecaseItemProviderAdapterFactory usecaseItemProviderAdapterFactory = injector.getInstance(UsecaseItemProviderAdapterFactory.class);
		
		addAdapterFactory(new ResourceItemProviderAdapterFactory());
		addAdapterFactory(swprojItemProviderAdapterFactory);
		addAdapterFactory(usecaseItemProviderAdapterFactory);
		addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	private static class ProjectOutlineModule extends AbstractModule {

		@Override
		protected void configure() {
			bindSwprojFactoryDependencies();
			bindUsecaseFactoryDependencies();
		}

		private void bindSwprojFactoryDependencies() {
			// factory
			//
			bind(SwprojItemProviderAdapterFactory.class).to(SwprojItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
			
			// factory item providers
			//
			bind(ActorItemProvider.class).to(ActorItemProviderExt.class).in(Scopes.SINGLETON);
			bind(ConceptualObjectItemProvider.class).to(ConceptualObjectItemProviderExt.class).in(Scopes.SINGLETON);
			// factory, because SoftwareProjectItemProviderExt is stateful
			bind(FactorySoftwareProject.class).to(FactorySoftwareProjectImpl.class).in(Scopes.SINGLETON);
			
			// item providers dependencies
			//
			bind(AdapterFactory.class).annotatedWith(Names.named(SoftwareProjectItemProviderExt.SOFTWARE_PROJECT_ITEM_PROVIDER_ANNOTATION)).to(SwprojItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
			bind(AdapterFactory.class).annotatedWith(Names.named(ActorItemProviderExt.ACTOR_ITEM_PROVIDER_ANNOTATION)).to(SwprojItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
			bind(AdapterFactory.class).annotatedWith(Names.named(ConceptualObjectItemProviderExt.CONCEPTUAL_OBJECT_ITEM_PROVIDER_ANNOTATION)).to(SwprojItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
		}

		private void bindUsecaseFactoryDependencies() {
			// factory
			//
			bind(UsecaseItemProviderAdapterFactory.class).to(UsecaseItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
			
			// factory item providers
			//
			bindUseCaseItemProvider();
		}

		private void bindUseCaseItemProvider() {
			// item provider
			//
			bind(UseCaseItemProvider.class).to(UseCaseItemProviderExt.class).in(Scopes.SINGLETON);
			
			// factory in item provider
			//
			// use case item provider needs SwprojItemProviderAdapterFactoryExt as parent factory 
			bind(AdapterFactory.class).annotatedWith(Names.named(UseCaseItemProviderExt.USE_CASE_ITEM_PROVIDER_ANNOTATION)).to(SwprojItemProviderAdapterFactoryExt.class).in(Scopes.SINGLETON);
		
			// item provider children features
			//
			// remove all child nodes from use case node 
			List<EReference> customUseCaseChildren = Collections.emptyList();
			bind(new TypeLiteral<List<EReference>>() {}).annotatedWith(Names.named(UseCaseItemProviderExt.CUSTOM_CHILDREN_FEATURES_KEY)).toInstance(customUseCaseChildren);
		}

	}
	
	static class FactorySoftwareProjectImpl implements FactorySoftwareProject {

		@Override
		public SoftwareProjectItemProvider create(SwprojItemProviderAdapterFactory adapterFactory) {
			return new SoftwareProjectItemProviderExt(adapterFactory);
		}
		
	}
	
}

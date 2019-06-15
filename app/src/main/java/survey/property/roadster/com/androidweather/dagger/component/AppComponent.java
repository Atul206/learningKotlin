package survey.property.roadster.com.androidweather.dagger.component;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import survey.property.roadster.com.androidweather.MainApplication;

@Singleton
@Component (modules = AndroidSupportInjectionModule.class)

public interface AppComponent extends AndroidInjector<MainApplication> {

    @Override
    void inject(MainApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder mainApplication(MainApplication mainApplication);
        AppComponent build();
    }

}

package survey.property.roadster.com.androidweather;

import survey.property.roadster.com.androidweather.dagger.component.AppComponent;
import survey.property.roadster.com.androidweather.dagger.component.BaseDaggerApplication;
import survey.property.roadster.com.androidweather.dagger.component.DaggerAppComponent;

public class MainApplication extends BaseDaggerApplication {


    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public AppComponent applicationInjector() {
        appComponent = DaggerAppComponent.builder().mainApplication(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}

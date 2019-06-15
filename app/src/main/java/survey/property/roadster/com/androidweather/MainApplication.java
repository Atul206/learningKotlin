package survey.property.roadster.com.androidweather;

import dagger.android.AndroidInjector;
import survey.property.roadster.com.androidweather.dagger.component.AppComponent;
import survey.property.roadster.com.androidweather.dagger.component.BaseDaggerApplication;

public class MainApplication extends BaseDaggerApplication {


    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public AppComponent applicationInjector() {
        return appComponent;
    }
}

package survey.property.roadster.com.androidweather.dagger.component;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasContentProviderInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.HasServiceInjector;

public abstract class BaseDaggerApplication extends Application
        implements HasActivityInjector, HasFragmentInjector, HasContentProviderInjector, HasBroadcastReceiverInjector, HasServiceInjector {


    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<ContentProvider> contentProviderDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        injectIfRequierd();
    }

    public abstract AndroidInjector<? extends BaseDaggerApplication> applicationInjector();

    //WE can create lazy intializing but
    // it have cost in multiple threading which creates issue on double check for respectively providers
    // @link https://proandroiddev.com/deep-dive-into-dagger-lazy-7a5860cca7cc
    private void injectIfRequierd(){
        AndroidInjector<BaseDaggerApplication> applicationInjector =
                (AndroidInjector<BaseDaggerApplication>) applicationInjector();
        applicationInjector.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
        return broadcastReceiverDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<ContentProvider> contentProviderInjector() {
        return contentProviderDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceDispatchingAndroidInjector;
    }
}

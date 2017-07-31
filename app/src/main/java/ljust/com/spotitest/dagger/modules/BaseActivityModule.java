package ljust.com.spotitest.dagger.modules;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ljust.com.spotitest.dagger.scopes.ActivityScope;

/**
 * Module for BaseActivity that provides dependencies at the Activity level
 */
@Module
public abstract class BaseActivityModule {

    @Binds
    @ActivityScope
    abstract Context activityContext(Activity activity);

    @Provides
    @Named("activityFragmentManager")
    @ActivityScope
    static FragmentManager activityFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }
}

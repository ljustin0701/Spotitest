package ljust.com.spotitest.dagger.modules;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ljust.com.spotitest.dagger.scopes.ActivityScope;

@Module
public class PicassoModule {
    @Provides
    @Named("defaultPicasso")
    @ActivityScope
    static Picasso picasso(Context context) {
        return new Picasso.Builder(context).build();
    }
}

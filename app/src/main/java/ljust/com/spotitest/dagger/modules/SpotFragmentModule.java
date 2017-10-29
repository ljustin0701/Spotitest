package ljust.com.spotitest.dagger.modules;

import dagger.Module;
import dagger.Provides;
import ljust.com.spotitest.interactor.SpotInteractor;
import ljust.com.spotitest.presenter.SpotPresenter;

/**
 * Provides dependencies for SpotFragment
 */
@Module(includes = BaseFragmentModule.class)
public abstract class SpotFragmentModule {

    @Provides
    static SpotPresenter presenter(SpotInteractor spotInteractor) {
        return new SpotPresenter(spotInteractor);
    }

}

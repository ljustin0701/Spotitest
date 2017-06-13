package ljust.com.spotitest.presenter;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import ljust.com.spotitest.interactor.SpotInteractor;
import ljust.com.spotitest.view.SpotViewbinder;

/**
 * Presenter for SpotFragment
 */
public class SpotPresenter {

    private SpotInteractor mSpotInteractor;

    @Inject
    public SpotPresenter(SpotInteractor interactor) {
        mSpotInteractor = interactor;
    }

    public void onViewAvailable(final SpotViewbinder viewbinder) {
        mSpotInteractor.getData()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        viewbinder.show(integer);
                    }
                });
    }
}

package ljust.com.spotitest.presenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ljust.com.spotitest.entity.NewReleases;
import ljust.com.spotitest.interactor.SpotInteractor;
import ljust.com.spotitest.view.SpotViewbinder;

/**
 * Presenter for SpotFragment
 */
public class SpotPresenter {

    private SpotInteractor mSpotInteractor;
    private CompositeDisposable mCompositeDisposable;
    private int OFFSET = 0;
    private final int LIMIT = 20;

    @Inject
    public SpotPresenter(SpotInteractor interactor) {
        mCompositeDisposable = new CompositeDisposable();
        mSpotInteractor = interactor;
    }

    public void onViewAvailable(final SpotViewbinder viewbinder) {
        mCompositeDisposable.add(mSpotInteractor.getData("US", OFFSET, LIMIT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onDataLoadSuccess(viewbinder)));
    }

    public void onViewUnavailable() {
        mCompositeDisposable.clear();
    }

    public void loadNextPage(final SpotViewbinder viewbinder) {
        OFFSET+=LIMIT;
        mCompositeDisposable.add(mSpotInteractor.getData("US", OFFSET, LIMIT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onDataLoadSuccess(viewbinder)));
    }

    private Consumer<NewReleases> onDataLoadSuccess(final SpotViewbinder viewbinder) {
        return new Consumer<NewReleases>() {
            @Override
            public void accept(@NonNull NewReleases newReleases) throws Exception {
                viewbinder.showData(newReleases);
            }
        };
    }

    public int getOffset() {
        return OFFSET;
    }

    public void setOffset(int offset) {
        OFFSET = offset;
    }
}

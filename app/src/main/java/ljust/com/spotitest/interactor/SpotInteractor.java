package ljust.com.spotitest.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Interactor for SpotPresenter which is the backend entry point
 */
public class SpotInteractor {

    @Inject
    public SpotInteractor(){}

    public Observable<Integer> getData() {
        return Observable.just(1, 2, 3);
    }
}

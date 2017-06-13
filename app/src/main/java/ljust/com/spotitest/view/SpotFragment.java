package ljust.com.spotitest.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import ljust.com.spotitest.BaseFragment;
import ljust.com.spotitest.R;
import ljust.com.spotitest.presenter.SpotPresenter;

public class SpotFragment extends BaseFragment implements SpotViewbinder {

    RecyclerView mRecyclerView;
    @Inject SpotPresenter mSpotPresenter;

    public static SpotFragment create() {
        return new SpotFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        mSpotPresenter.onViewAvailable(this);
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_spot, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void show(Integer number) {
        Log.d("tag", number.toString());
    }
}

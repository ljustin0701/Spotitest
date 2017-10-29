package ljust.com.spotitest.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ljust.com.spotitest.BaseFragment;
import ljust.com.spotitest.R;
import ljust.com.spotitest.entity.NewReleases;
import ljust.com.spotitest.entity.SimpleAlbum;
import ljust.com.spotitest.presenter.SpotPresenter;

public class SpotFragment extends BaseFragment implements SpotViewbinder {

    TextView mTitleView;
    RecyclerView mRecyclerView;
    SpotAdapter mAdapter;
    private boolean mLoading;
    private static final String LIST_ITEMS = "list-items";
    private static final String LIST_STATE = "list-state";
    private static final String LIST_OFFSET = "list-offset";

    @Inject Context mContext;
    @Inject SpotPresenter mSpotPresenter;
    @Inject @Named("defaultPicasso") Picasso mPicasso;

    public static SpotFragment create() {
        return new SpotFragment();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(LIST_ITEMS, mAdapter.getItems());
        outState.putParcelable(LIST_STATE, mRecyclerView.getLayoutManager().onSaveInstanceState());
        outState.putInt(LIST_OFFSET, mSpotPresenter.getOffset());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mSpotPresenter.setOffset(savedInstanceState.getInt(LIST_OFFSET));
            mLoading = false;
        } else {
            mSpotPresenter.onViewAvailable(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mSpotPresenter.onViewUnavailable();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_spot, container, false);

        mTitleView = (TextView) view.findViewById(R.id.page_title);
        mTitleView.setText(getString(R.string.new_releases));


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = new SpotAdapter(mContext, mPicasso);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayout.VERTICAL, false);
        if (savedInstanceState != null) {
            final List<SimpleAlbum> restoredList = savedInstanceState.getParcelableArrayList(LIST_ITEMS);
            layoutManager.onRestoreInstanceState(savedInstanceState.getParcelable(LIST_STATE));
            mAdapter.addAll(restoredList);
        }
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (dy > 0) {
                    if (!mLoading && (firstVisibleItemPosition + visibleItemCount) >= totalItemCount) {
                        mLoading = true;
                        mSpotPresenter.loadNextPage(SpotFragment.this);
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void showData(NewReleases newReleases) {
        mLoading = false;
        mAdapter.addAll(newReleases.albums().items());
    }
}

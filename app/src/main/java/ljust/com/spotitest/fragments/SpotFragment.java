package ljust.com.spotitest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ljust.com.spotitest.R;

public class SpotFragment extends Fragment{

    RecyclerView mRecyclerView;

    public static SpotFragment create() {
        return new SpotFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_spot, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        return view;
    }
}

package ljust.com.spotitest.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ljust.com.spotitest.R;
import ljust.com.spotitest.entity.SimpleAlbum;
import ljust.com.spotitest.entity.SimpleArtist;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.NewReleaseViewHolder> {

    private Context mContext;
    private Picasso mPicasso;
    private ArrayList<SimpleAlbum> mItems;

    class NewReleaseViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mAlbumType;
        TextView mAlbumTitle;
        TextView mAlbumArtists;

        NewReleaseViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.new_release_album_image);
            mAlbumType = (TextView) itemView.findViewById(R.id.new_release_album_type);
            mAlbumTitle = (TextView) itemView.findViewById(R.id.new_release_album_title);
            mAlbumArtists = (TextView) itemView.findViewById(R.id.new_release_album_artists);
        }
    }

    SpotAdapter(Context context, Picasso picasso) {
        mItems = new ArrayList<>();
        mContext = context;
        mPicasso = picasso;
    }

    @Override
    public NewReleaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(mContext).inflate(R.layout.new_releases_item_layout, parent, false);
        return new NewReleaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewReleaseViewHolder holder, int position) {
        final SimpleAlbum album = mItems.get(position);

        mPicasso.load(album.images().get(0).url()).fit().into(holder.mImageView);
        holder.mAlbumType.setText(determineAlbumTypeString(album.type()));
        holder.mAlbumTitle.setText(album.name());
        holder.mAlbumArtists.setText(mContext.getString(R.string.by_artist, determineArtistsString(album.artists())));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public ArrayList<SimpleAlbum> getItems() {
        return mItems;
    }

    void addAll(List<SimpleAlbum> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    private String determineArtistsString(List<SimpleArtist> artists) {
        if (artists.size() > 1) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < artists.size(); i++) {
                builder.append(artists.get(i).name())
                        .append(i == artists.size() - 1 ? "" : ", ");
            }
            return builder.toString();
        } else {
            return artists.get(0).name();
        }
    }

    private String determineAlbumTypeString(String albumType) {
        switch(albumType) {
            case "album" : return "Album";
            case "single" : return "Single";
            default :
                char first = albumType.charAt(0);
                return Character.toUpperCase(first) + albumType.substring(1);
        }
    }
}

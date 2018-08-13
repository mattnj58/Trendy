package caplan.innovations.trendy.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import caplan.innovations.trendy.R;
import caplan.innovations.trendy.model.NewsItem;

/**
 * Created by Matt Wong on 8/12/2018.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder {

    interface OnNewsActionListenerInternal{

        void onNewsClickInternal(int position);

    }

    @BindView(R.id.news_feed_image)
    ImageView mImageView;

    @BindView(R.id.news_feed_title_text_view)
    TextView mTitleTextView;

    @BindView(R.id.news_feed_author_text_view)
    TextView mAuthorTextView;

    private OnNewsActionListenerInternal mListenerInternal;

    NewsViewHolder(View itemView, OnNewsActionListenerInternal listenerInternal) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mListenerInternal = listenerInternal;
    }
    void bind(NewsItem newsItem) {
        mTitleTextView.setText(newsItem.getTitle());
        mAuthorTextView.setText(newsItem.getAuthor());
//        TODO image
    }

    @OnClick(R.id.news_feed_container)
    void onNewsItemClick() {
        // Use the adapter position to get the position of the click
        int position = getAdapterPosition();
        mListenerInternal.onNewsClickInternal(position);
    }

}

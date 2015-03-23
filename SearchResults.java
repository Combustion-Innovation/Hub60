package com.hub60.hub60;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Mike Ritacco Work PC on 3/21/2015.
 */
public class SearchResults extends LinearLayout {

    Context context;

    LinearLayout mainLayout, topTextHolder;
    RelativeLayout topResultsHolder, nextResultHolder;
    ImageView topImage, nextImage;
    TextView topTitle, topDate, topDesc, topSource, nextTitle, nextReplies, nextUpvotes;




    public SearchResults(Context context) {
        super(context);
        initItems(context);

    }
    public SearchResults(Context context, AttributeSet attrs) {
        super(context, attrs);
        initItems(context);
    }
    public SearchResults(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initItems(context);
    }

    public void initItems(Context context) {
        this.context = context;

        mainLayout = (LinearLayout)findViewById(R.id.results_main_layout);
        topTextHolder = (LinearLayout)findViewById(R.id.results_top_text_holder);

        topResultsHolder = (RelativeLayout)findViewById(R.id.results_top_result_holder);
        nextResultHolder = (RelativeLayout)findViewById(R.id.results_next_holder);

        topImage = (ImageView)findViewById(R.id.results_top_image);
        nextImage = (ImageView)findViewById(R.id.results_next_image);

        topTitle = (TextView)findViewById(R.id.results_top_title);
        topDate = (TextView)findViewById(R.id.results_top_date);
        topDesc = (TextView)findViewById(R.id.results_top_description);
        topSource = (TextView)findViewById(R.id.results_top_source);
        nextTitle = (TextView)findViewById(R.id.results_next_title);
        nextReplies = (TextView)findViewById(R.id.results_next_replies);
        nextUpvotes = (TextView)findViewById(R.id.results_next_upvotes);

        populateData();

    }

    public void populateData() {

    }


}

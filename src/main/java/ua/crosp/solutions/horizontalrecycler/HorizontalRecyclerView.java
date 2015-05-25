package ua.crosp.solutions.horizontalrecycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by crosp on 5/24/15.
 */
public class HorizontalRecyclerView extends RelativeLayout
{
    private RelativeLayout mHeaderLayout;
    private ImageView mImageIcon;
    private TextView mListTitle;
    private RecyclerView mRecyclerListView;
    public HorizontalRecyclerView(Context context) {
       this(context,null);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }
    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.horizontal_view_layout, this);
    }
    public void setOnHeaderClickListener(OnClickListener onClickListener) {
        this.mHeaderLayout.setOnClickListener(onClickListener);
    }
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerListView.addItemDecoration(itemDecoration);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mImageIcon = (ImageView) findViewById(R.id.more_icon);
        mListTitle = (TextView) findViewById(R.id.list_title);
        mRecyclerListView = (RecyclerView) findViewById(R.id.recycler_view);
        mHeaderLayout = (RelativeLayout) findViewById(R.id.header_layout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerListView.setLayoutManager(layoutManager);
    }
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mRecyclerListView.setLayoutManager(layoutManager);
    }
    public void setAdapter(RecyclerView.Adapter adapter) {
        this.mRecyclerListView.setAdapter(adapter);
    }
    public void setImageIconDrawable(Drawable drawable) {
        this.mImageIcon.setImageDrawable(drawable);
    }
    public void setImageIconResource(int drawableResource) {
        this.mImageIcon.setImageResource(drawableResource);
    }
    public void setListTitle(String title) {
        this.mListTitle.setText(title);
    }
    public RecyclerView getRecyclerView() {
        return this.mRecyclerListView;
    }
    public void setOnIconClickListener(OnClickListener onIconClickListener) {
        this.mImageIcon.setOnClickListener(onIconClickListener);
    }
    public void setImageIconSelector(StateListDrawable stateListDrawable) {
        this.mImageIcon.setImageDrawable(stateListDrawable);
    }
    public void setIconLayoutParams(int width,int height) {
        LayoutParams layoutParams = (LayoutParams) this.mImageIcon.getLayoutParams();
        layoutParams.height = height;
        layoutParams.width = width;
        this.mImageIcon.setLayoutParams(layoutParams);
        this.mImageIcon.requestLayout();
    }

    public void setHeaderBackground(Drawable drawableBackground) {
        int currentApiVersion = Build.VERSION.SDK_INT;
        if (currentApiVersion >= Build.VERSION_CODES.JELLY_BEAN){
            this.mHeaderLayout.setBackground(drawableBackground);
        } else{
            this.mHeaderLayout.setBackgroundDrawable(drawableBackground);
        }

    }
}

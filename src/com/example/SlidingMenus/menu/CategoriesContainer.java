package com.example.SlidingMenus.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by krasimir.karamazov on 7/21/2014.
 */
public class CategoriesContainer extends LinearLayout {

    private int mBackgroundColor;
    private int mWidth;

    public CategoriesContainer(Context context) {
        super(context);
        init();
    }

    public CategoriesContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CategoriesContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(mBackgroundColor);
    }

    public void setBackgroundColor(int backgroundColor){
        mBackgroundColor = backgroundColor;
    }
}

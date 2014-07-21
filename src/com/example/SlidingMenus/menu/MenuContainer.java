package com.example.SlidingMenus.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.example.SlidingMenus.R;

/**
 * Created by krasimir.karamazov on 7/21/2014.
 */
public class MenuContainer extends FrameLayout {

    private int mScreenWidth;
    private int mScreenHeight;
    private int mPartOfScreenForCategories;
    private int mCategoriesWidth;
    private int mCategoryMenuWidth;
    private int mCategoriesContainerColor;

    public MenuContainer(Context context) {
        super(context);
        init();
    }

    public MenuContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.MenuContainer, 0, 0);
        try{
            mPartOfScreenForCategories = arr.getInteger(R.styleable.MenuContainer_parts_of_screen_for_categories, 3);
            mCategoriesContainerColor = arr.getColor(R.styleable.MenuContainer_categories_container_background, Color.BLUE);
        }finally {
            arr.recycle();
        }
        init();
    }

    public MenuContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        mScreenHeight = metrics.heightPixels;
        mScreenWidth = metrics.widthPixels;
        mCategoriesWidth = mScreenWidth / mPartOfScreenForCategories;
        mCategoryMenuWidth = mScreenWidth - mCategoriesWidth;

        buildCategories();
    }

    private void buildCategories() {
        CategoriesContainer categoriesContainer = new CategoriesContainer(getContext());
        final LayoutParams params = new LayoutParams(mCategoriesWidth, mScreenHeight);
        categoriesContainer.setLayoutParams(params);
        addView(categoriesContainer);
    }
}

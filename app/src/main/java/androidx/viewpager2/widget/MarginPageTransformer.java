package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

public final class MarginPageTransformer implements PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(int arg2) {
        super();
        Preconditions.checkArgumentNonnegative(arg2, "Margin must be non-negative");
        this.mMarginPx = arg2;
    }

    private ViewPager2 requireViewPager(View arg1) {
        ViewParent v0 = arg1.getParent();
        ViewParent v1 = v0.getParent();
        if(((v0 instanceof RecyclerView)) && ((v1 instanceof ViewPager2))) {
            return ((ViewPager2)v1);
        }

        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    public void transformPage(View arg2, float arg3) {
        ViewPager2 v0 = this.requireViewPager(arg2);
        float v1 = (((float)this.mMarginPx)) * arg3;
        if(v0.getOrientation() == 0) {
            if(v0.isRtl()) {
                v1 = -v1;
            }

            arg2.setTranslationX(v1);
            return;
        }

        arg2.setTranslationY(v1);
    }
}


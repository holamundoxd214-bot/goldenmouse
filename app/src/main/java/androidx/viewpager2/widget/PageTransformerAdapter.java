package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

final class PageTransformerAdapter extends OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private PageTransformer mPageTransformer;

    PageTransformerAdapter(LinearLayoutManager arg1) {
        super();
        this.mLayoutManager = arg1;
    }

    PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    public void onPageScrollStateChanged(int arg1) {
    }

    public void onPageScrolled(int arg4, float arg5, int arg6) {
        if(this.mPageTransformer == null) {
        }
        else {
            arg5 = -arg5;
            arg6 = 0;
            while(true) {
                if(arg6 < this.mLayoutManager.getChildCount()) {
                    View v0 = this.mLayoutManager.getChildAt(arg6);
                    if(v0 != null) {
                        this.mPageTransformer.transformPage(v0, (((float)(this.mLayoutManager.getPosition(v0) - arg4))) + arg5);
                        ++arg6;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                return;
            }

            throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(arg6), Integer.valueOf(this.mLayoutManager.getChildCount())));
        }
    }

    public void onPageSelected(int arg1) {
    }

    void setPageTransformer(PageTransformer arg1) {
        this.mPageTransformer = arg1;
    }
}


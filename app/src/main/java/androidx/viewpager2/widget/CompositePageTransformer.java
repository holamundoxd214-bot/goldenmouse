package androidx.viewpager2.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CompositePageTransformer implements PageTransformer {
    private final List mTransformers;

    public CompositePageTransformer() {
        super();
        this.mTransformers = new ArrayList();
    }

    public void addTransformer(PageTransformer arg1) {
        this.mTransformers.add(arg1);
    }

    public void removeTransformer(PageTransformer arg1) {
        this.mTransformers.remove(arg1);
    }

    public void transformPage(View arg2, float arg3) {
        Iterator v1 = this.mTransformers.iterator();
        while(v1.hasNext()) {
            v1.next().transformPage(arg2, arg3);
        }
    }
}


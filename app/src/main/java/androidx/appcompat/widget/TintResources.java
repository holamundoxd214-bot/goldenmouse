package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper {
    private final WeakReference mContextRef;

    public TintResources(Context arg1, Resources arg2) {
        super(arg2);
        this.mContextRef = new WeakReference(arg1);
    }

    public Drawable getDrawable(int arg3) throws Resources$NotFoundException {
        Drawable v0 = this.getDrawableCanonical(arg3);
        Object v2 = this.mContextRef.get();
        if(v0 != null && v2 != null) {
            ResourceManagerInternal.get().tintDrawableUsingColorFilter(((Context)v2), arg3, v0);
        }

        return v0;
    }
}


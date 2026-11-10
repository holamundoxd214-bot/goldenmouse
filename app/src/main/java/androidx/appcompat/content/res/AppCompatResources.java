package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

public final class AppCompatResources {
    private AppCompatResources() {
        super();
    }

    public static ColorStateList getColorStateList(Context arg0, int arg1) {
        return ContextCompat.getColorStateList(arg0, arg1);
    }

    public static Drawable getDrawable(Context arg1, int arg2) {
        return ResourceManagerInternal.get().getDrawable(arg1, arg2);
    }
}


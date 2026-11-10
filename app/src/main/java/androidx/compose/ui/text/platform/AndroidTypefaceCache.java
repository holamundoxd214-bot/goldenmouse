package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import androidx.collection.SieveCache;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.AndroidPreloadedFont;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="Duplicate cache") @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ\u001A\u0010\r\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0002R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/platform/AndroidTypefaceCache;", "", "<init>", "()V", "cache", "Landroidx/collection/SieveCache;", "", "Landroid/graphics/Typeface;", "getOrCreate", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/Font;", "getKey", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidTypefaceCache {
    public static final int $stable;
    public static final AndroidTypefaceCache INSTANCE;
    private static final SieveCache cache;

    static {
        AndroidTypefaceCache.INSTANCE = new AndroidTypefaceCache();
        AndroidTypefaceCache.cache = new SieveCache(16, 16, null, null, null, 28, null);
        AndroidTypefaceCache.$stable = 8;
    }

    private AndroidTypefaceCache() {
        super();
    }

    private final String getKey(Context arg2, Font arg3) {
        Object v1_3;
        if((arg3 instanceof ResourceFont)) {
            TypedValue v1 = new TypedValue();
            arg2.getResources().getValue(((ResourceFont)arg3).getResId(), v1, true);
            StringBuilder v2 = new StringBuilder("res:");
            CharSequence v1_1 = v1.string;
            if(v1_1 != null) {
                String v1_2 = v1_1.toString();
            }
            else {
                v1_3 = null;
            }

            Intrinsics.checkNotNull(v1_3);
            return v2.append(((String)v1_3)).toString();
        }

        if((arg3 instanceof AndroidPreloadedFont)) {
            return ((AndroidPreloadedFont)arg3).getCacheKey();
        }

        throw new IllegalArgumentException("Unknown font type: " + arg3);
    }

    public final Typeface getOrCreate(Context arg3, Font arg4) {
        Typeface v3;
        String v2 = this.getKey(arg3, arg4);
        if(v2 != null) {
            Object v0 = AndroidTypefaceCache.cache.get(v2);
            if(v0 != null) {
                return ((Typeface)v0);
            }
        }

        if((arg4 instanceof ResourceFont)) {
            v3 = AndroidResourceFontLoaderHelper.INSTANCE.create(arg3, arg4.getResId());
        }
        else if((arg4 instanceof AndroidFont)) {
            v3 = arg4.getTypefaceLoader().loadBlocking(arg3, arg4);
        }
        else {
            goto label_31;
        }

        if(v3 != null) {
            if(v2 != null) {
                AndroidTypefaceCache.cache.put(v2, v3);
            }

            return v3;
        }

        throw new IllegalArgumentException("Unable to load font " + arg4);
    label_31:
        throw new IllegalArgumentException("Unknown font type: " + arg4);
    }
}


package androidx.compose.ui.text.platform.extensions;

import android.text.style.LocaleSpan;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/text/platform/extensions/LocaleListHelperMethods;", "", "<init>", "()V", "localeSpan", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setTextLocales", "", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LocaleListHelperMethods {
    public static final int $stable;
    public static final LocaleListHelperMethods INSTANCE;

    static {
        LocaleListHelperMethods.INSTANCE = new LocaleListHelperMethods();
    }

    private LocaleListHelperMethods() {
        super();
    }

    public final Object localeSpan(LocaleList arg2) {
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg2), 10));
        Iterator v2 = ((Iterable)arg2).iterator();
        while(v2.hasNext()) {
            ((Collection)v1).add(v2.next().getPlatformLocale());
        }

        Object[] v1_1 = ((Collection)v1).toArray(new Locale[0]);
        return new LocaleSpan(new android.os.LocaleList(Arrays.copyOf(v1_1, v1_1.length)));
    }

    public final void setTextLocales(AndroidTextPaint arg2, LocaleList arg3) {
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg3), 10));
        Iterator v3 = ((Iterable)arg3).iterator();
        while(v3.hasNext()) {
            ((Collection)v1).add(v3.next().getPlatformLocale());
        }

        Object[] v1_1 = ((Collection)v1).toArray(new Locale[0]);
        arg2.setTextLocales(new android.os.LocaleList(Arrays.copyOf(v1_1, v1_1.length)));
    }
}


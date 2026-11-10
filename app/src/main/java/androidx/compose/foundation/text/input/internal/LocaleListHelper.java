package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/compose/foundation/text/input/internal/LocaleListHelper;", "", "<init>", "()V", "setHintLocales", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LocaleListHelper {
    public static final int $stable;
    public static final LocaleListHelper INSTANCE;

    static {
        LocaleListHelper.INSTANCE = new LocaleListHelper();
    }

    private LocaleListHelper() {
        super();
    }

    public final void setHintLocales(EditorInfo arg2, LocaleList arg3) {
        if(Intrinsics.areEqual(arg3, LocaleList.Companion.getEmpty())) {
            arg2.hintLocales = null;
            return;
        }

        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg3), 10));
        Iterator v3 = ((Iterable)arg3).iterator();
        while(v3.hasNext()) {
            ((Collection)v1).add(v3.next().getPlatformLocale());
        }

        Object[] v1_1 = ((Collection)v1).toArray(new Locale[0]);
        arg2.hintLocales = new android.os.LocaleList(Arrays.copyOf(v1_1, v1_1.length));
    }
}


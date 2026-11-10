package androidx.compose.ui.text.intl;

import android.util.Log;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001A\u00060\tj\u0002`\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI23;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "<init>", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "parseLanguageTag", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidLocaleDelegateAPI23 implements PlatformLocaleDelegate {
    public static final int $stable;

    static {
    }

    public AndroidLocaleDelegateAPI23() {
        super();
    }

    public LocaleList getCurrent() {
        return new LocaleList(CollectionsKt.listOf(new Locale(java.util.Locale.getDefault())));
    }

    public java.util.Locale parseLanguageTag(String arg4) {
        java.util.Locale v3 = java.util.Locale.forLanguageTag(arg4);
        if(Intrinsics.areEqual(v3.toLanguageTag(), "und")) {
            Log.e(AndroidLocaleDelegate_androidKt.access$getTAG$p(), "The language tag " + arg4 + " is not well-formed. Locale is resolved to Undetermined. Note that underscore \'_\' is not a valid subtags delimiter and must be replaced with \'-\'.");
        }

        return v3;
    }
}


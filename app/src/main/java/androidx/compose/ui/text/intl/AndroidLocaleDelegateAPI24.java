package androidx.compose.ui.text.intl;

import android.util.Log;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\r\u001A\u00060\u000Ej\u0002`\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI24;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "<init>", "()V", "lastPlatformLocaleList", "Landroid/os/LocaleList;", "lastLocaleList", "Landroidx/compose/ui/text/intl/LocaleList;", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "current", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "parseLanguageTag", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {
    public static final int $stable = 8;
    private LocaleList lastLocaleList;
    private android.os.LocaleList lastPlatformLocaleList;
    private final SynchronizedObject lock;

    static {
    }

    public AndroidLocaleDelegateAPI24() {
        super();
        this.lock = new SynchronizedObject();
    }

    public LocaleList getCurrent() {
        LocaleList v2;
        android.os.LocaleList v0 = android.os.LocaleList.getDefault();
        SynchronizedObject v1 = this.lock;
        __monitor_enter(v1);
        try {
            v2 = this.lastLocaleList;
            if(v2 != null && v0 == this.lastPlatformLocaleList) {
                goto label_7;
            }

            goto label_9;
        }
        catch(Throwable v7) {
            goto label_27;
        }

    label_7:
        __monitor_exit(v1);
        return v2;
        try {
        label_9:
            int v2_1 = v0.size();
            ArrayList v3 = new ArrayList(v2_1);
            int v4;
            for(v4 = 0; v4 < v2_1; ++v4) {
                v3.add(new Locale(v0.get(v4)));
            }

            v2 = new LocaleList(((List)v3));
            this.lastPlatformLocaleList = v0;
            this.lastLocaleList = v2;
        }
        catch(Throwable v7) {
            goto label_27;
        }

        __monitor_exit(v1);
        return v2;
    label_27:
        __monitor_exit(v1);
        throw v7;
    }

    public java.util.Locale parseLanguageTag(String arg4) {
        java.util.Locale v3 = java.util.Locale.forLanguageTag(arg4);
        if(Intrinsics.areEqual(v3.toLanguageTag(), "und")) {
            Log.e(AndroidLocaleDelegate_androidKt.access$getTAG$p(), "The language tag " + arg4 + " is not well-formed. Locale is resolved to Undetermined. Note that underscore \'_\' is not a valid subtag delimiter and must be replaced with \'-\'.");
        }

        return v3;
    }
}


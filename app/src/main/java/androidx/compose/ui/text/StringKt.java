package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidStringDelegate_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0012\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0012\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0012\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b\u001A\u0012\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b\u001A\u0012\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b\u001A\u0012\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b\"\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"toUpperCase", "", "locale", "Landroidx/compose/ui/text/intl/Locale;", "toLowerCase", "capitalize", "decapitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "stringDelegate", "Landroidx/compose/ui/text/PlatformStringDelegate;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StringKt {
    private static final PlatformStringDelegate stringDelegate;

    static {
        StringKt.stringDelegate = AndroidStringDelegate_androidKt.ActualStringDelegate();
    }

    public static final String capitalize(String arg1, LocaleList arg2) {
        Locale v2 = arg2.isEmpty() ? Locale.Companion.getCurrent() : arg2.get(0);
        return StringKt.capitalize(arg1, v2);
    }

    public static final String capitalize(String arg1, Locale arg2) {
        return StringKt.stringDelegate.capitalize(arg1, arg2.getPlatformLocale());
    }

    public static final String decapitalize(String arg1, LocaleList arg2) {
        Locale v2 = arg2.isEmpty() ? Locale.Companion.getCurrent() : arg2.get(0);
        return StringKt.decapitalize(arg1, v2);
    }

    public static final String decapitalize(String arg1, Locale arg2) {
        return StringKt.stringDelegate.decapitalize(arg1, arg2.getPlatformLocale());
    }

    public static final String toLowerCase(String arg1, LocaleList arg2) {
        Locale v2 = arg2.isEmpty() ? Locale.Companion.getCurrent() : arg2.get(0);
        return StringKt.toLowerCase(arg1, v2);
    }

    public static final String toLowerCase(String arg1, Locale arg2) {
        return StringKt.stringDelegate.toLowerCase(arg1, arg2.getPlatformLocale());
    }

    public static final String toUpperCase(String arg1, Locale arg2) {
        return StringKt.stringDelegate.toUpperCase(arg1, arg2.getPlatformLocale());
    }

    public static final String toUpperCase(String arg1, LocaleList arg2) {
        Locale v2 = arg2.isEmpty() ? Locale.Companion.getCurrent() : arg2.get(0);
        return StringKt.toUpperCase(arg1, v2);
    }
}


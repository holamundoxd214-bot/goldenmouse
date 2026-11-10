package androidx.compose.ui.text.intl;

import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\b\u001A\u0010\u0010\u000B\u001A\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000\"\u001C\u0010\u0002\u001A\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\"\u001C\u0010\u0007\u001A\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0006\"\u001C\u0010\t\u001A\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u0006*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\f"}, d2={"PlatformLocale", "Ljava/util/Locale;", "language", "", "Landroidx/compose/ui/text/intl/PlatformLocale;", "getLanguage", "(Ljava/util/Locale;)Ljava/lang/String;", "script", "getScript", "region", "getRegion", "getLanguageTag", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlatformLocale_jvmKt {
    public static final String getLanguage(Locale arg0) {
        return arg0.getLanguage();
    }

    public static final String getLanguageTag(Locale arg0) {
        return arg0.toLanguageTag();
    }

    public static final String getRegion(Locale arg0) {
        return arg0.getCountry();
    }

    public static final String getScript(Locale arg0) {
        return arg0.getScript();
    }
}


package androidx.compose.ui.text.intl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u0015\b\u0000\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0006\u0010\u0014\u001A\u00020\bJ\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\bH\u0016R\u0017\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0012\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000F¨\u0006\u001C"}, d2={"Landroidx/compose/ui/text/intl/Locale;", "", "platformLocale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "<init>", "(Ljava/util/Locale;)V", "languageTag", "", "(Ljava/lang/String;)V", "getPlatformLocale", "()Ljava/util/Locale;", "Ljava/util/Locale;", "language", "getLanguage", "()Ljava/lang/String;", "script", "getScript", "region", "getRegion", "toLanguageTag", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Locale {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/intl/Locale$Companion;", "", "<init>", "()V", "current", "Landroidx/compose/ui/text/intl/Locale;", "getCurrent", "()Landroidx/compose/ui/text/intl/Locale;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Locale getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent().get(0);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final java.util.Locale platformLocale;

    static {
        Locale.Companion = new Companion(null);
    }

    public Locale(String arg2) {
        this(PlatformLocaleKt.getPlatformLocaleDelegate().parseLanguageTag(arg2));
    }

    public Locale(java.util.Locale arg1) {
        super();
        this.platformLocale = arg1;
    }

    public boolean equals(Object arg3) {
        if(arg3 == null) {
            return 0;
        }

        if(!(arg3 instanceof Locale)) {
            return 0;
        }

        if(this == (((Locale)arg3))) {
            return 1;
        }

        return Intrinsics.areEqual(this.toLanguageTag(), ((Locale)arg3).toLanguageTag());
    }

    public final String getLanguage() {
        return PlatformLocale_jvmKt.getLanguage(this.platformLocale);
    }

    public final java.util.Locale getPlatformLocale() {
        return this.platformLocale;
    }

    public final String getRegion() {
        return PlatformLocale_jvmKt.getRegion(this.platformLocale);
    }

    public final String getScript() {
        return PlatformLocale_jvmKt.getScript(this.platformLocale);
    }

    public int hashCode() {
        return this.toLanguageTag().hashCode();
    }

    public final String toLanguageTag() {
        return PlatformLocale_jvmKt.getLanguageTag(this.platformLocale);
    }

    public String toString() {
        return this.toLanguageTag();
    }
}


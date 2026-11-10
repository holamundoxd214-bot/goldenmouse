package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "<init>", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "load", "", "font", "Landroidx/compose/ui/text/font/Font;", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class DeprecatedBridgeFontResourceLoader implements ResourceLoader {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0006R&\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader$Companion;", "", "<init>", "()V", "cache", "", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getCache", "()Ljava/util/Map;", "setCache", "(Ljava/util/Map;)V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "from", "fontFamilyResolver", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ResourceLoader from(Resolver arg3) {
            Object v0;
            SynchronizedObject v2 = this.getLock();
            __monitor_enter(v2);
            try {
                v0 = DeprecatedBridgeFontResourceLoader.Companion.getCache().get(arg3);
                if(v0 == null) {
                    goto label_8;
                }
            }
            catch(Throwable v3) {
                goto label_17;
            }

            __monitor_exit(v2);
            return ((ResourceLoader)v0);
            try {
            label_8:
                DeprecatedBridgeFontResourceLoader v0_1 = new DeprecatedBridgeFontResourceLoader(arg3, null);
                DeprecatedBridgeFontResourceLoader.Companion.getCache().put(arg3, v0_1);
                __monitor_exit(v2);
                return ((ResourceLoader)v0_1);
            }
            catch(Throwable v3) {
            label_17:
                __monitor_exit(v2);
                throw v3;
            }
        }

        public final Map getCache() {
            return DeprecatedBridgeFontResourceLoader.cache;
        }

        public final SynchronizedObject getLock() {
            return DeprecatedBridgeFontResourceLoader.lock;
        }

        public final void setCache(Map arg1) {
            DeprecatedBridgeFontResourceLoader.cache = arg1;
        }
    }

    public static final Companion Companion;
    private static Map cache;
    private final Resolver fontFamilyResolver;
    private static final SynchronizedObject lock;

    static {
        DeprecatedBridgeFontResourceLoader.Companion = new Companion(null);
        DeprecatedBridgeFontResourceLoader.cache = new LinkedHashMap();
        DeprecatedBridgeFontResourceLoader.lock = new SynchronizedObject();
    }

    private DeprecatedBridgeFontResourceLoader(Resolver arg1) {
        super();
        this.fontFamilyResolver = arg1;
    }

    public DeprecatedBridgeFontResourceLoader(Resolver arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public static final Map access$getCache$cp() {
        return DeprecatedBridgeFontResourceLoader.cache;
    }

    public static final SynchronizedObject access$getLock$cp() {
        return DeprecatedBridgeFontResourceLoader.lock;
    }

    public static final void access$setCache$cp(Map arg0) {
        DeprecatedBridgeFontResourceLoader.cache = arg0;
    }

    @Deprecated(message="Replaced by FontFamily.Resolver, this method should not be called", replaceWith="<_subannotation>") public Object load(Font arg8) {
        return Resolver.resolve-DPcqOEQ$default(this.fontFamilyResolver, FontKt.toFontFamily(arg8), arg8.getWeight(), arg8.getStyle-_-LCdwA(), 0, 8, null).getValue();
    }
}


package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0002\u001A\u00020\u00038\u0007¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\u0082\u0001\u0003\f\r\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/font/FontFamily;", "", "canLoadSynchronously", "", "<init>", "(Z)V", "getCanLoadSynchronously$annotations", "()V", "getCanLoadSynchronously", "()Z", "Resolver", "Companion", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "Landroidx/compose/ui/text/font/LoadedFontFamily;", "Landroidx/compose/ui/text/font/SystemFontFamily;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class FontFamily {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u000E\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0010\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000B¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/font/FontFamily$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/font/SystemFontFamily;", "getDefault", "()Landroidx/compose/ui/text/font/SystemFontFamily;", "SansSerif", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getSansSerif", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Serif", "getSerif", "Monospace", "getMonospace", "Cursive", "getCursive", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GenericFontFamily getCursive() {
            return FontFamily.Cursive;
        }

        public final SystemFontFamily getDefault() {
            return FontFamily.Default;
        }

        public final GenericFontFamily getMonospace() {
            return FontFamily.Monospace;
        }

        public final GenericFontFamily getSansSerif() {
            return FontFamily.SansSerif;
        }

        public final GenericFontFamily getSerif() {
            return FontFamily.Serif;
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J?\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00010\b2\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000EH&¢\u0006\u0004\b\u000F\u0010\u0010\u0082\u0001\u0001\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/ui/text/font/FontFamily$Resolver;", "", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Resolver {
        Object preload(FontFamily arg1, Continuation arg2);

        State resolve-DPcqOEQ(FontFamily arg1, FontWeight arg2, int arg3, int arg4);

        static State resolve-DPcqOEQ$default(Resolver arg0, FontFamily arg1, FontWeight arg2, int arg3, int arg4, int arg5, Object arg6) {
            if(arg6 == null) {
                if((arg5 & 1) != 0) {
                    arg1 = null;
                }

                if((arg5 & 2) != 0) {
                    arg2 = FontWeight.Companion.getNormal();
                }

                if((arg5 & 4) != 0) {
                    arg3 = FontStyle.Companion.getNormal-_-LCdwA();
                }

                if((arg5 & 8) != 0) {
                    arg4 = FontSynthesis.Companion.getAll-GVVA2EU();
                }

                return arg0.resolve-DPcqOEQ(arg1, arg2, arg3, arg4);
            }

            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final GenericFontFamily Cursive;
    private static final SystemFontFamily Default;
    private static final GenericFontFamily Monospace;
    private static final GenericFontFamily SansSerif;
    private static final GenericFontFamily Serif;
    private final boolean canLoadSynchronously;

    static {
        FontFamily.Companion = new Companion(null);
        FontFamily.Default = new DefaultFontFamily();
        FontFamily.SansSerif = new GenericFontFamily("sans-serif", "FontFamily.SansSerif");
        FontFamily.Serif = new GenericFontFamily("serif", "FontFamily.Serif");
        FontFamily.Monospace = new GenericFontFamily("monospace", "FontFamily.Monospace");
        FontFamily.Cursive = new GenericFontFamily("cursive", "FontFamily.Cursive");
    }

    private FontFamily(boolean arg1) {
        super();
        this.canLoadSynchronously = arg1;
    }

    public FontFamily(boolean arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public static final GenericFontFamily access$getCursive$cp() {
        return FontFamily.Cursive;
    }

    public static final SystemFontFamily access$getDefault$cp() {
        return FontFamily.Default;
    }

    public static final GenericFontFamily access$getMonospace$cp() {
        return FontFamily.Monospace;
    }

    public static final GenericFontFamily access$getSansSerif$cp() {
        return FontFamily.SansSerif;
    }

    public static final GenericFontFamily access$getSerif$cp() {
        return FontFamily.Serif;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Unused property that has no meaning. Do not use.") public final boolean getCanLoadSynchronously() {
        return this.canLoadSynchronously;
    }

    public static void getCanLoadSynchronously$annotations() {
    }
}


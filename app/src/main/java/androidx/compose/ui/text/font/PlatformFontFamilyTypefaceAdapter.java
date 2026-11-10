package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.ui.text.platform.AndroidTypeface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\rH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "<init>", "()V", "platformTypefaceResolver", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "createDefaultTypeface", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    public static final int $stable = 8;
    private final PlatformTypefaces platformTypefaceResolver;

    static {
    }

    public PlatformFontFamilyTypefaceAdapter() {
        super();
        this.platformTypefaceResolver = PlatformTypefaces_androidKt.PlatformTypefaces();
    }

    public TypefaceResult resolve(TypefaceRequest arg1, PlatformFontLoader arg2, Function1 arg3, Function1 arg4) {
        Typeface v0;
        FontFamily v2 = arg1.getFontFamily();
        TypefaceResult v3 = null;
        if(v2 == null || ((v2 instanceof DefaultFontFamily))) {
            v0 = this.platformTypefaceResolver.createDefault-FO1MlWM(arg1.getFontWeight(), arg1.getFontStyle-_-LCdwA());
        }
        else if((v2 instanceof GenericFontFamily)) {
            v0 = this.platformTypefaceResolver.createNamed-RetOiIg(arg1.getFontFamily(), arg1.getFontWeight(), arg1.getFontStyle-_-LCdwA());
        }
        else if((v2 instanceof LoadedFontFamily)) {
            androidx.compose.ui.text.font.Typeface v0_1 = arg1.getFontFamily().getTypeface();
            Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            v0 = ((AndroidTypeface)v0_1).getNativeTypeface-PYhJU0U(arg1.getFontWeight(), arg1.getFontStyle-_-LCdwA(), arg1.getFontSynthesis-GVVA2EU());
        }
        else {
            return v3;
        }

        return new Immutable(v0, false, 2, ((DefaultConstructorMarker)v3));
    }
}


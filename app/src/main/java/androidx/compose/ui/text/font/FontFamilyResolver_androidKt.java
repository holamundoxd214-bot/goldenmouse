package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0016\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u001A\u0010\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007\u001AA\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2={"createFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "emptyCacheFontFamilyResolver", "resolveAsTypeface", "Landroidx/compose/runtime/State;", "Landroid/graphics/Typeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolveAsTypeface-Wqqsr6A", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FontFamilyResolver_androidKt {
    public static final Resolver createFontFamilyResolver(Context arg8) {
        return new FontFamilyResolverImpl(new AndroidFontLoader(arg8), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(arg8), null, null, null, 28, null);
    }

    public static final Resolver createFontFamilyResolver(Context arg8, CoroutineContext arg9) {
        return new FontFamilyResolverImpl(new AndroidFontLoader(arg8), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(arg8), FontFamilyResolverKt.getGlobalTypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), arg9), null, 16, null);
    }

    public static final Resolver emptyCacheFontFamilyResolver(Context arg8) {
        return new FontFamilyResolverImpl(new AndroidFontLoader(arg8), null, new TypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(new AsyncTypefaceCache(), null, 2, null), null, 18, null);
    }

    public static final State resolveAsTypeface-Wqqsr6A(Resolver arg0, FontFamily arg1, FontWeight arg2, int arg3, int arg4) {
        State v0 = arg0.resolve-DPcqOEQ(arg1, arg2, arg3, arg4);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.State<android.graphics.Typeface>");
        return v0;
    }

    public static State resolveAsTypeface-Wqqsr6A$default(Resolver arg0, FontFamily arg1, FontWeight arg2, int arg3, int arg4, int arg5, Object arg6) {
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

        return FontFamilyResolver_androidKt.resolveAsTypeface-Wqqsr6A(arg0, arg1, arg2, arg3, arg4);
    }
}


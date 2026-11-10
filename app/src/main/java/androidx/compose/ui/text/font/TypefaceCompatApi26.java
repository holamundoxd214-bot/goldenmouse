package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/font/TypefaceCompatApi26;", "", "<init>", "()V", "threadLocalPaint", "Ljava/lang/ThreadLocal;", "Landroid/graphics/Paint;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "typeface", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class TypefaceCompatApi26 {
    public static final TypefaceCompatApi26 INSTANCE;
    private static ThreadLocal threadLocalPaint;

    static {
        TypefaceCompatApi26.INSTANCE = new TypefaceCompatApi26();
        TypefaceCompatApi26.threadLocalPaint = new ThreadLocal();
    }

    private TypefaceCompatApi26() {
        super();
    }

    public final Typeface setFontVariationSettings(Typeface arg3, Settings arg4, Context arg5) {
        Typeface v2 = null;
        if(arg3 == null) {
            return v2;
        }

        if(arg4.getSettings().isEmpty()) {
            return arg3;
        }

        Object v0 = TypefaceCompatApi26.threadLocalPaint.get();
        if(v0 == null) {
            Paint v0_1 = new Paint();
            TypefaceCompatApi26.threadLocalPaint.set(v0_1);
        }

        ((Paint)v0).setFontVariationSettings(((String)v2));
        ((Paint)v0).setTypeface(arg3);
        ((Paint)v0).setFontVariationSettings(PlatformFontVariationSettings_androidKt.toAndroidString(arg4, arg5));
        return ((Paint)v0).getTypeface();
    }
}


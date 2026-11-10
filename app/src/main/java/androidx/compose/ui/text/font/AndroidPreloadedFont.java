package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B!\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0013\u001A\u0004\u0018\u00010\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H ¢\u0006\u0002\b\u0017J\u0017\u0010\u001F\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0000¢\u0006\u0002\b R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000F\u001A\u0004\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001A\u001A\u0004\u0018\u00010\u0014X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E\u0082\u0001\u0003!\"#¨\u0006$"}, d2={"Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "Landroidx/compose/ui/text/font/AndroidFont;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)V", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "()I", "I", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text", "didInitWithContext", "", "typeface", "getTypeface$ui_text", "()Landroid/graphics/Typeface;", "setTypeface$ui_text", "(Landroid/graphics/Typeface;)V", "loadCached", "loadCached$ui_text", "Landroidx/compose/ui/text/font/AndroidAssetFont;", "Landroidx/compose/ui/text/font/AndroidFileDescriptorFont;", "Landroidx/compose/ui/text/font/AndroidFileFont;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AndroidPreloadedFont extends AndroidFont {
    public static final int $stable;
    private boolean didInitWithContext;
    private final int style;
    private Typeface typeface;
    private final FontWeight weight;

    static {
    }

    private AndroidPreloadedFont(FontWeight arg4, int arg5, Settings arg6) {
        super(FontLoadingStrategy.Companion.getBlocking-PKNRLFQ(), AndroidPreloadedFontTypefaceLoader.INSTANCE, arg6, null);
        this.weight = arg4;
        this.style = arg5;
    }

    public AndroidPreloadedFont(FontWeight arg1, int arg2, Settings arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public abstract Typeface doLoad$ui_text(Context arg1);

    public abstract String getCacheKey();

    public final int getStyle-_-LCdwA() {
        return this.style;
    }

    public final Typeface getTypeface$ui_text() {
        return this.typeface;
    }

    public final FontWeight getWeight() {
        return this.weight;
    }

    public final Typeface loadCached$ui_text(Context arg2) {
        if(!this.didInitWithContext && this.typeface == null) {
            this.typeface = this.doLoad$ui_text(arg2);
        }

        this.didInitWithContext = true;
        return this.typeface;
    }

    public final void setTypeface$ui_text(Typeface arg1) {
        this.typeface = arg1;
    }
}


package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\'\u0018\u00002\u00020\u0001:\u0001\u0012B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nR\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/font/AndroidFont;", "Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "typefaceLoader", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(ILandroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;Landroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILandroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLoadingStrategy-PKNRLFQ", "()I", "I", "getTypefaceLoader", "()Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "getVariationSettings", "()Landroidx/compose/ui/text/font/FontVariation$Settings;", "TypefaceLoader", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AndroidFont implements Font {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001A\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J \u0010\b\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H¦@¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "", "loadBlocking", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "awaitLoad", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TypefaceLoader {
        Object awaitLoad(Context arg1, AndroidFont arg2, Continuation arg3);

        Typeface loadBlocking(Context arg1, AndroidFont arg2);
    }

    public static final int $stable;
    private final int loadingStrategy;
    private final TypefaceLoader typefaceLoader;
    private final Settings variationSettings;

    static {
    }

    private AndroidFont(int arg3, TypefaceLoader arg4) {
        this(arg3, arg4, new Settings(new Setting[0]), null);
    }

    public AndroidFont(int arg1, TypefaceLoader arg2, Settings arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private AndroidFont(int arg1, TypefaceLoader arg2, Settings arg3) {
        super();
        this.loadingStrategy = arg1;
        this.typefaceLoader = arg2;
        this.variationSettings = arg3;
    }

    @Deprecated(message="Replaced with fontVariation constructor", replaceWith="<_subannotation>") public AndroidFont(int arg1, TypefaceLoader arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public final int getLoadingStrategy-PKNRLFQ() {
        return this.loadingStrategy;
    }

    public final TypefaceLoader getTypefaceLoader() {
        return this.typefaceLoader;
    }

    public final Settings getVariationSettings() {
        return this.variationSettings;
    }
}


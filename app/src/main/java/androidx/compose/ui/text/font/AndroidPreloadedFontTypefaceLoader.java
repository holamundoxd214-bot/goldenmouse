package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u001E\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/ui/text/font/AndroidPreloadedFontTypefaceLoader;", "Landroidx/compose/ui/text/font/AndroidFont$TypefaceLoader;", "<init>", "()V", "loadBlocking", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "font", "Landroidx/compose/ui/text/font/AndroidFont;", "awaitLoad", "", "(Landroid/content/Context;Landroidx/compose/ui/text/font/AndroidFont;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidPreloadedFontTypefaceLoader implements TypefaceLoader {
    public static final AndroidPreloadedFontTypefaceLoader INSTANCE;

    static {
        AndroidPreloadedFontTypefaceLoader.INSTANCE = new AndroidPreloadedFontTypefaceLoader();
    }

    private AndroidPreloadedFontTypefaceLoader() {
        super();
    }

    public Object awaitLoad(Context arg1, AndroidFont arg2, Continuation arg3) {
        throw new UnsupportedOperationException("All preloaded fonts are blocking.");
    }

    public Typeface loadBlocking(Context arg2, AndroidFont arg3) {
        Typeface v0 = null;
        if((arg3 instanceof AndroidPreloadedFont)) {
        }
        else {
            arg3 = ((AndroidFont)v0);
        }

        if(arg3 != null) {
            return ((AndroidPreloadedFont)arg3).loadCached$ui_text(arg2);
        }

        return v0;
    }
}


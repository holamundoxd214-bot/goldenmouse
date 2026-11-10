package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0018\u0010\u0011\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000F\u001A\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/font/DelegatingFontLoaderForBridgeUsage;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "loader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "<init>", "(Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroid/content/Context;)V", "getLoader$ui_text", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "loadBlocking", "font", "Landroidx/compose/ui/text/font/Font;", "awaitLoad", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DelegatingFontLoaderForBridgeUsage implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;
    private final ResourceLoader loader;

    static {
    }

    public DelegatingFontLoaderForBridgeUsage(ResourceLoader arg1, Context arg2) {
        super();
        this.loader = arg1;
        this.context = arg2;
        this.cacheKey = new Object();
    }

    public Object awaitLoad(Font arg2, Continuation arg3) {
        if((arg2 instanceof AndroidFont)) {
            return ((AndroidFont)arg2).getTypefaceLoader().awaitLoad(this.context, ((AndroidFont)arg2), arg3);
        }

        return this.loader.load(arg2);
    }

    public Object getCacheKey() {
        return this.cacheKey;
    }

    public final ResourceLoader getLoader$ui_text() {
        return this.loader;
    }

    public Object loadBlocking(Font arg2) {
        if((arg2 instanceof AndroidFont)) {
            return ((AndroidFont)arg2).getTypefaceLoader().loadBlocking(this.context, ((AndroidFont)arg2));
        }

        return this.loader.load(arg2);
    }
}


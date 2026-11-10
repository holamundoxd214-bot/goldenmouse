package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0016\u0010\u000F\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000EH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/font/DelegatingFontLoaderForDeprecatedUsage;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "loader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "<init>", "(Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "getLoader$ui_text", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "loadBlocking", "font", "Landroidx/compose/ui/text/font/Font;", "awaitLoad", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DelegatingFontLoaderForDeprecatedUsage implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final ResourceLoader loader;

    static {
    }

    public DelegatingFontLoaderForDeprecatedUsage(ResourceLoader arg1) {
        super();
        this.loader = arg1;
        this.cacheKey = new Object();
    }

    public Object awaitLoad(Font arg1, Continuation arg2) {
        return this.loader.load(arg1);
    }

    public Object getCacheKey() {
        return this.cacheKey;
    }

    public final ResourceLoader getLoader$ui_text() {
        return this.loader;
    }

    public Object loadBlocking(Font arg1) {
        return this.loader.load(arg1);
    }
}


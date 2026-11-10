package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"GlobalTypefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "getGlobalTypefaceRequestCache", "()Landroidx/compose/ui/text/font/TypefaceRequestCache;", "GlobalAsyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "getGlobalAsyncTypefaceCache", "()Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FontFamilyResolverKt {
    private static final AsyncTypefaceCache GlobalAsyncTypefaceCache;
    private static final TypefaceRequestCache GlobalTypefaceRequestCache;

    static {
        FontFamilyResolverKt.GlobalTypefaceRequestCache = new TypefaceRequestCache();
        FontFamilyResolverKt.GlobalAsyncTypefaceCache = new AsyncTypefaceCache();
    }

    public static final AsyncTypefaceCache getGlobalAsyncTypefaceCache() {
        return FontFamilyResolverKt.GlobalAsyncTypefaceCache;
    }

    public static final TypefaceRequestCache getGlobalTypefaceRequestCache() {
        return FontFamilyResolverKt.GlobalTypefaceRequestCache;
    }
}


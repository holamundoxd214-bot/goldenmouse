package androidx.compose.ui.text;

import androidx.collection.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001A\u0004\u0018\u00010\t2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\tR\u001C\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/TextLayoutCache;", "", "capacity", "", "<init>", "(I)V", "cache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/CacheTextLayoutInput;", "Landroidx/compose/ui/text/TextLayoutResult;", "singleSizeCacheInput", "singleSizeCacheResult", "get", "key", "Landroidx/compose/ui/text/TextLayoutInput;", "put", "", "value", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLayoutCache {
    public static final int $stable = 8;
    private final LruCache cache;
    private CacheTextLayoutInput singleSizeCacheInput;
    private TextLayoutResult singleSizeCacheResult;

    static {
    }

    public TextLayoutCache() {
        this(0, 1, null);
    }

    public TextLayoutCache(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 8;
        }

        this(arg1);
    }

    public TextLayoutCache(int arg2) {
        super();
        LruCache v0 = arg2 != 1 ? new LruCache(arg2) : null;
        this.cache = v0;
    }

    public final TextLayoutResult get(TextLayoutInput arg3) {
        Object v2;
        CacheTextLayoutInput v0 = new CacheTextLayoutInput(arg3);
        LruCache v3 = this.cache;
        TextLayoutResult v1 = null;
        if(v3 != null) {
            v2 = v3.get(v0);
        }
        else if(Intrinsics.areEqual(this.singleSizeCacheInput, v0)) {
            TextLayoutResult v2_1 = this.singleSizeCacheResult;
        }
        else {
            return v1;
        }

        if(v2 == null) {
            return v1;
        }

        if(((TextLayoutResult)v2).getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return v1;
        }

        return ((TextLayoutResult)v2);
    }

    public final void put(TextLayoutInput arg2, TextLayoutResult arg3) {
        LruCache v0 = this.cache;
        if(v0 != null) {
            v0.put(new CacheTextLayoutInput(arg2), arg3);
            return;
        }

        this.singleSizeCacheInput = new CacheTextLayoutInput(arg2);
        this.singleSizeCacheResult = arg3;
    }
}


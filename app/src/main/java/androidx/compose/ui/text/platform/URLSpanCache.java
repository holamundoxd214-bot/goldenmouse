package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.UrlAnnotation;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0006J\u0014\u0010\u000E\u001A\u00020\u00072\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\f0\tR\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000B\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/ui/text/platform/URLSpanCache;", "", "<init>", "()V", "spansByAnnotation", "Ljava/util/WeakHashMap;", "Landroidx/compose/ui/text/UrlAnnotation;", "Landroid/text/style/URLSpan;", "urlSpansByAnnotation", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "linkSpansWithListenerByAnnotation", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/platform/ComposeClickableSpan;", "toURLSpan", "urlAnnotation", "urlRange", "toClickableSpan", "Landroid/text/style/ClickableSpan;", "linkRange", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class URLSpanCache {
    public static final int $stable = 8;
    private final WeakHashMap linkSpansWithListenerByAnnotation;
    private final WeakHashMap spansByAnnotation;
    private final WeakHashMap urlSpansByAnnotation;

    static {
    }

    public URLSpanCache() {
        super();
        this.spansByAnnotation = new WeakHashMap();
        this.urlSpansByAnnotation = new WeakHashMap();
        this.linkSpansWithListenerByAnnotation = new WeakHashMap();
    }

    public final ClickableSpan toClickableSpan(Range arg3) {
        ComposeClickableSpan v0_1;
        WeakHashMap v2 = this.linkSpansWithListenerByAnnotation;
        Object v0 = ((Map)v2).get(arg3);
        if(v0 == null) {
            v0_1 = new ComposeClickableSpan(arg3.getItem());
            ((Map)v2).put(arg3, v0_1);
        }

        return ((ClickableSpan)v0_1);
    }

    public final URLSpan toURLSpan(UrlAnnotation arg3) {
        URLSpan v0_1;
        WeakHashMap v2 = this.spansByAnnotation;
        Object v0 = ((Map)v2).get(arg3);
        if(v0 == null) {
            v0_1 = new URLSpan(arg3.getUrl());
            ((Map)v2).put(arg3, v0_1);
        }

        return v0_1;
    }

    public final URLSpan toURLSpan(Range arg3) {
        URLSpan v0_1;
        WeakHashMap v2 = this.urlSpansByAnnotation;
        Object v0 = ((Map)v2).get(arg3);
        if(v0 == null) {
            v0_1 = new URLSpan(arg3.getItem().getUrl());
            ((Map)v2).put(arg3, v0_1);
        }

        return v0_1;
    }
}


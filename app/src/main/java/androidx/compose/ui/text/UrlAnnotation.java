package androidx.compose.ui.text;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="Use LinkAnnotatation.Url(url) instead", replaceWith="<_subannotation>") @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/UrlAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UrlAnnotation implements Annotation {
    public static final int $stable;
    private final String url;

    static {
    }

    public UrlAnnotation(String arg1) {
        super();
        this.url = arg1;
    }

    public boolean equals(Object arg4) {
        if(this == (((UrlAnnotation)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof UrlAnnotation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.url, ((UrlAnnotation)arg4).url)) {
            return 0;
        }

        return 1;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "UrlAnnotation(url=" + this.url + ')';
    }
}


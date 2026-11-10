package androidx.compose.foundation.content;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/content/MediaType;", "", "representation", "", "<init>", "(Ljava/lang/String;)V", "getRepresentation", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MediaType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/content/MediaType$Companion;", "", "<init>", "()V", "Text", "Landroidx/compose/foundation/content/MediaType;", "getText", "()Landroidx/compose/foundation/content/MediaType;", "PlainText", "getPlainText", "HtmlText", "getHtmlText", "Image", "getImage", "All", "getAll", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final MediaType getAll() {
            return MediaType.All;
        }

        public final MediaType getHtmlText() {
            return MediaType.HtmlText;
        }

        public final MediaType getImage() {
            return MediaType.Image;
        }

        public final MediaType getPlainText() {
            return MediaType.PlainText;
        }

        public final MediaType getText() {
            return MediaType.Text;
        }
    }

    public static final int $stable;
    private static final MediaType All;
    public static final Companion Companion;
    private static final MediaType HtmlText;
    private static final MediaType Image;
    private static final MediaType PlainText;
    private static final MediaType Text;
    private final String representation;

    static {
        MediaType.Companion = new Companion(null);
        MediaType.Text = new MediaType("text/*");
        MediaType.PlainText = new MediaType("text/plain");
        MediaType.HtmlText = new MediaType("text/html");
        MediaType.Image = new MediaType("image/*");
        MediaType.All = new MediaType("*/*");
    }

    public MediaType(String arg1) {
        super();
        this.representation = arg1;
    }

    public static final MediaType access$getAll$cp() {
        return MediaType.All;
    }

    public static final MediaType access$getHtmlText$cp() {
        return MediaType.HtmlText;
    }

    public static final MediaType access$getImage$cp() {
        return MediaType.Image;
    }

    public static final MediaType access$getPlainText$cp() {
        return MediaType.PlainText;
    }

    public static final MediaType access$getText$cp() {
        return MediaType.Text;
    }

    public boolean equals(Object arg2) {
        if(this == (((MediaType)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof MediaType)) {
            return 0;
        }

        return Intrinsics.areEqual(this.representation, ((MediaType)arg2).representation);
    }

    public final String getRepresentation() {
        return this.representation;
    }

    public int hashCode() {
        return this.representation.hashCode();
    }

    public String toString() {
        return "MediaType(representation=\'" + this.representation + "\')";
    }
}


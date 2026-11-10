package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "<init>", "()V", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "Url", "Clickable", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LinkAnnotation implements Annotation {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "Landroidx/compose/ui/text/LinkAnnotation;", "tag", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getTag", "()Ljava/lang/String;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Clickable extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String tag;

        static {
        }

        public Clickable(String arg2, TextLinkStyles arg3, LinkInteractionListener arg4) {
            super(null);
            this.tag = arg2;
            this.styles = arg3;
            this.linkInteractionListener = arg4;
        }

        public Clickable(String arg1, TextLinkStyles arg2, LinkInteractionListener arg3, int arg4, DefaultConstructorMarker arg5) {
            if((arg4 & 2) != 0) {
                arg2 = null;
            }

            this(arg1, arg2, arg3);
        }

        public final Clickable copy(String arg1, TextLinkStyles arg2, LinkInteractionListener arg3) {
            return new Clickable(arg1, arg2, arg3);
        }

        public static Clickable copy$default(Clickable arg0, String arg1, TextLinkStyles arg2, LinkInteractionListener arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.tag;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.getStyles();
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.getLinkInteractionListener();
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((Clickable)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Clickable)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.tag, ((Clickable)arg5).tag)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.getStyles(), ((Clickable)arg5).getStyles())) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.getLinkInteractionListener(), ((Clickable)arg5).getLinkInteractionListener())) {
                return 0;
            }

            return 1;
        }

        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            int v0 = this.tag.hashCode() * 0x1F;
            TextLinkStyles v1 = this.getStyles();
            int v2 = 0;
            int v1_1 = v1 != null ? v1.hashCode() : 0;
            v0 = (v0 + v1_1) * 0x1F;
            LinkInteractionListener v3 = this.getLinkInteractionListener();
            if(v3 != null) {
                v2 = v3.hashCode();
            }

            return v0 + v2;
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.tag + ')';
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0018"}, d2={"Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "url", "", "styles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLinkStyles;Landroidx/compose/ui/text/LinkInteractionListener;)V", "getUrl", "()Ljava/lang/String;", "getStyles", "()Landroidx/compose/ui/text/TextLinkStyles;", "getLinkInteractionListener", "()Landroidx/compose/ui/text/LinkInteractionListener;", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Url extends LinkAnnotation {
        public static final int $stable = 8;
        private final LinkInteractionListener linkInteractionListener;
        private final TextLinkStyles styles;
        private final String url;

        static {
        }

        public Url(String arg2, TextLinkStyles arg3, LinkInteractionListener arg4) {
            super(null);
            this.url = arg2;
            this.styles = arg3;
            this.linkInteractionListener = arg4;
        }

        public Url(String arg2, TextLinkStyles arg3, LinkInteractionListener arg4, int arg5, DefaultConstructorMarker arg6) {
            TextLinkStyles v0 = null;
            if((arg5 & 2) != 0) {
                arg3 = v0;
            }

            if((arg5 & 4) != 0) {
                arg4 = ((LinkInteractionListener)v0);
            }

            this(arg2, arg3, arg4);
        }

        public final Url copy(String arg1, TextLinkStyles arg2, LinkInteractionListener arg3) {
            return new Url(arg1, arg2, arg3);
        }

        public static Url copy$default(Url arg0, String arg1, TextLinkStyles arg2, LinkInteractionListener arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.url;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.getStyles();
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.getLinkInteractionListener();
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((Url)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Url)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.url, ((Url)arg5).url)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.getStyles(), ((Url)arg5).getStyles())) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.getLinkInteractionListener(), ((Url)arg5).getLinkInteractionListener())) {
                return 0;
            }

            return 1;
        }

        public LinkInteractionListener getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        public TextLinkStyles getStyles() {
            return this.styles;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int v0 = this.url.hashCode() * 0x1F;
            TextLinkStyles v1 = this.getStyles();
            int v2 = 0;
            int v1_1 = v1 != null ? v1.hashCode() : 0;
            v0 = (v0 + v1_1) * 0x1F;
            LinkInteractionListener v3 = this.getLinkInteractionListener();
            if(v3 != null) {
                v2 = v3.hashCode();
            }

            return v0 + v2;
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.url + ')';
        }
    }

    public static final int $stable;

    static {
    }

    private LinkAnnotation() {
        super();
    }

    public LinkAnnotation(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract LinkInteractionListener getLinkInteractionListener();

    public abstract TextLinkStyles getStyles();
}


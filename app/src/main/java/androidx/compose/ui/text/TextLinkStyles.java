package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/TextLinkStyles;", "", "style", "Landroidx/compose/ui/text/SpanStyle;", "focusedStyle", "hoveredStyle", "pressedStyle", "<init>", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;)V", "getStyle", "()Landroidx/compose/ui/text/SpanStyle;", "getFocusedStyle", "getHoveredStyle", "getPressedStyle", "equals", "", "other", "hashCode", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLinkStyles {
    public static final int $stable;
    private final SpanStyle focusedStyle;
    private final SpanStyle hoveredStyle;
    private final SpanStyle pressedStyle;
    private final SpanStyle style;

    static {
    }

    public TextLinkStyles(SpanStyle arg2, SpanStyle arg3, SpanStyle arg4, SpanStyle arg5, int arg6, DefaultConstructorMarker arg7) {
        SpanStyle v0 = null;
        if((arg6 & 1) != 0) {
            arg2 = v0;
        }

        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = v0;
        }

        this(arg2, arg3, arg4, arg5);
    }

    public TextLinkStyles(SpanStyle arg1, SpanStyle arg2, SpanStyle arg3, SpanStyle arg4) {
        super();
        this.style = arg1;
        this.focusedStyle = arg2;
        this.hoveredStyle = arg3;
        this.pressedStyle = arg4;
    }

    public TextLinkStyles() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object arg5) {
        if(this == (((TextLinkStyles)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(!(arg5 instanceof TextLinkStyles)) {
            }
            else if(!Intrinsics.areEqual(this.style, ((TextLinkStyles)arg5).style)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.focusedStyle, ((TextLinkStyles)arg5).focusedStyle)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.hoveredStyle, ((TextLinkStyles)arg5).hoveredStyle)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.pressedStyle, ((TextLinkStyles)arg5).pressedStyle)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final SpanStyle getFocusedStyle() {
        return this.focusedStyle;
    }

    public final SpanStyle getHoveredStyle() {
        return this.hoveredStyle;
    }

    public final SpanStyle getPressedStyle() {
        return this.pressedStyle;
    }

    public final SpanStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        SpanStyle v0 = this.style;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        SpanStyle v2 = this.focusedStyle;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.hoveredStyle;
        v2_1 = v2 != null ? v2.hashCode() : 0;
        v0_1 = (v0_1 + v2_1) * 0x1F;
        SpanStyle v3 = this.pressedStyle;
        if(v3 != null) {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }
}


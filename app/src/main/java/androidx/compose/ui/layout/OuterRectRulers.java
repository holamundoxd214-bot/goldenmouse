package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000E\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0018\u0010\u0002\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000E¨\u0006\u0015"}, d2={"Landroidx/compose/ui/layout/OuterRectRulers;", "Landroidx/compose/ui/layout/RectRulers;", "rulers", "", "<init>", "([Landroidx/compose/ui/layout/RectRulers;)V", "[Landroidx/compose/ui/layout/RectRulers;", "left", "Landroidx/compose/ui/layout/VerticalRuler;", "getLeft", "()Landroidx/compose/ui/layout/VerticalRuler;", "top", "Landroidx/compose/ui/layout/HorizontalRuler;", "getTop", "()Landroidx/compose/ui/layout/HorizontalRuler;", "right", "getRight", "bottom", "getBottom", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class OuterRectRulers implements RectRulers {
    private final HorizontalRuler bottom;
    private final VerticalRuler left;
    private final VerticalRuler right;
    private final RectRulers[] rulers;
    private final HorizontalRuler top;

    public OuterRectRulers(RectRulers[] arg6) {
        super();
        this.rulers = arg6;
        Companion v0 = VerticalRuler.Companion;
        int v6 = arg6.length;
        VerticalRuler[] v1 = new VerticalRuler[v6];
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v6; ++v3) {
            v1[v3] = this.rulers[v3].getLeft();
        }

        this.left = v0.minOf(v1);
        androidx.compose.ui.layout.HorizontalRuler$Companion v6_1 = HorizontalRuler.Companion;
        int v0_1 = this.rulers.length;
        HorizontalRuler[] v1_1 = new HorizontalRuler[v0_1];
        for(v3 = 0; v3 < v0_1; ++v3) {
            v1_1[v3] = this.rulers[v3].getTop();
        }

        this.top = v6_1.minOf(v1_1);
        Companion v6_2 = VerticalRuler.Companion;
        v0_1 = this.rulers.length;
        v1 = new VerticalRuler[v0_1];
        for(v3 = 0; v3 < v0_1; ++v3) {
            v1[v3] = this.rulers[v3].getRight();
        }

        this.right = v6_2.maxOf(v1);
        v6_1 = HorizontalRuler.Companion;
        v0_1 = this.rulers.length;
        v1_1 = new HorizontalRuler[v0_1];
        while(v2 < v0_1) {
            v1_1[v2] = this.rulers[v2].getBottom();
            ++v2;
        }

        this.bottom = v6_1.maxOf(v1_1);
    }

    public HorizontalRuler getBottom() {
        return this.bottom;
    }

    public VerticalRuler getLeft() {
        return this.left;
    }

    public VerticalRuler getRight() {
        return this.right;
    }

    public HorizontalRuler getTop() {
        return this.top;
    }

    public String toString() {
        return ArraysKt.joinToString$default(this.rulers, null, "outermostOf(", ")", 0, null, null, 57, null);
    }
}


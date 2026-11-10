package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001A\u00020\u0003H\u0016R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u0007X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\rX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\u0007X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000BR\u001A\u0010\u0015\u001A\u00020\rX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u000F\"\u0004\b\u0017\u0010\u0011¨\u0006\u0019"}, d2={"Landroidx/compose/ui/layout/RectRulersImpl;", "Landroidx/compose/ui/layout/RectRulers;", "name", "", "<init>", "(Ljava/lang/String;)V", "left", "Landroidx/compose/ui/layout/VerticalRuler;", "getLeft", "()Landroidx/compose/ui/layout/VerticalRuler;", "setLeft", "(Landroidx/compose/ui/layout/VerticalRuler;)V", "top", "Landroidx/compose/ui/layout/HorizontalRuler;", "getTop", "()Landroidx/compose/ui/layout/HorizontalRuler;", "setTop", "(Landroidx/compose/ui/layout/HorizontalRuler;)V", "right", "getRight", "setRight", "bottom", "getBottom", "setBottom", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class RectRulersImpl implements RectRulers {
    private HorizontalRuler bottom;
    private VerticalRuler left;
    private final String name;
    private VerticalRuler right;
    private HorizontalRuler top;

    public RectRulersImpl(String arg1) {
        super();
        this.name = arg1;
        this.left = new VerticalRuler();
        this.top = new HorizontalRuler();
        this.right = new VerticalRuler();
        this.bottom = new HorizontalRuler();
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

    public void setBottom(HorizontalRuler arg1) {
        this.bottom = arg1;
    }

    public void setLeft(VerticalRuler arg1) {
        this.left = arg1;
    }

    public void setRight(VerticalRuler arg1) {
        this.right = arg1;
    }

    public void setTop(HorizontalRuler arg1) {
        this.top = arg1;
    }

    public String toString() {
        if(this.name != null) {
            return "RectRulers(" + this.name + ')';
        }

        return super.toString();
    }
}


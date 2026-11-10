package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/compose/ui/layout/WindowInsetsRulersImpl;", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "current", "Landroidx/compose/ui/layout/RectRulers;", "getCurrent", "()Landroidx/compose/ui/layout/RectRulers;", "maximum", "getMaximum", "getAnimation", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class WindowInsetsRulersImpl implements WindowInsetsRulers {
    private final RectRulers current;
    private final RectRulers maximum;
    private final String name;

    public WindowInsetsRulersImpl(String arg2) {
        super();
        this.name = arg2;
        this.current = RectRulersKt.RectRulers(arg2);
        this.maximum = RectRulersKt.RectRulers(arg2 + " maximum");
    }

    public WindowInsetsAnimation getAnimation(PlacementScope arg1) {
        return WindowInsetsRulers_androidKt.findInsetsAnimationProperties(arg1, ((WindowInsetsRulers)this));
    }

    public RectRulers getCurrent() {
        return this.current;
    }

    public RectRulers getMaximum() {
        return this.maximum;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}


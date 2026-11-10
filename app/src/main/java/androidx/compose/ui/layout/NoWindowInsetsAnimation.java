package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\fR\u0014\u0010\r\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\fR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2={"Landroidx/compose/ui/layout/NoWindowInsetsAnimation;", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "<init>", "()V", "source", "Landroidx/compose/ui/layout/RectRulers;", "getSource", "()Landroidx/compose/ui/layout/RectRulers;", "target", "getTarget", "isVisible", "", "()Z", "isAnimating", "fraction", "", "getFraction", "()F", "durationMillis", "", "getDurationMillis", "()J", "alpha", "getAlpha", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NoWindowInsetsAnimation implements WindowInsetsAnimation {
    public static final int $stable;
    public static final NoWindowInsetsAnimation INSTANCE;

    static {
        NoWindowInsetsAnimation.INSTANCE = new NoWindowInsetsAnimation();
    }

    private NoWindowInsetsAnimation() {
        super();
    }

    public float getAlpha() {
        return 1f;
    }

    public long getDurationMillis() {
        return 0;
    }

    public float getFraction() {
        return 0;
    }

    public RectRulers getSource() {
        return WindowInsetsRulersKt.getNeverProvidedRectRulers();
    }

    public RectRulers getTarget() {
        return WindowInsetsRulersKt.getNeverProvidedRectRulers();
    }

    public boolean isAnimating() {
        return 0;
    }

    public boolean isVisible() {
        return 1;
    }
}


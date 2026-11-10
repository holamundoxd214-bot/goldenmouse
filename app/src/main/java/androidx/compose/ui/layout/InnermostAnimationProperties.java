package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001B\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u001B¨\u0006\""}, d2={"Landroidx/compose/ui/layout/InnermostAnimationProperties;", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "rulers", "", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "<init>", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;[Landroidx/compose/ui/layout/WindowInsetsRulers;)V", "getScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getRulers", "()[Landroidx/compose/ui/layout/WindowInsetsRulers;", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "source", "Landroidx/compose/ui/layout/RectRulers;", "getSource", "()Landroidx/compose/ui/layout/RectRulers;", "target", "getTarget", "isVisible", "", "()Z", "isAnimating", "fraction", "", "getFraction", "()F", "durationMillis", "", "getDurationMillis", "()J", "alpha", "getAlpha", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class InnermostAnimationProperties implements WindowInsetsAnimation {
    private final WindowInsetsRulers[] rulers;
    private final PlacementScope scope;

    public InnermostAnimationProperties(PlacementScope arg1, WindowInsetsRulers[] arg2) {
        super();
        this.scope = arg1;
        this.rulers = arg2;
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

    public final WindowInsetsRulers[] getRulers() {
        return this.rulers;
    }

    public final PlacementScope getScope() {
        return this.scope;
    }

    public RectRulers getSource() {
        return WindowInsetsRulersKt.getNeverProvidedRectRulers();
    }

    public RectRulers getTarget() {
        return WindowInsetsRulersKt.getNeverProvidedRectRulers();
    }

    public boolean isAnimating() {
        WindowInsetsRulers[] v0 = this.rulers;
        int v1 = v0.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            if(v0[v3].getAnimation(this.scope).isAnimating()) {
                return 1;
            }
        }

        return 0;
    }

    public boolean isVisible() {
        WindowInsetsRulers[] v0 = this.rulers;
        int v1 = v0.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            if(v0[v3].getAnimation(this.scope).isVisible()) {
                return 1;
            }
        }

        return 0;
    }
}


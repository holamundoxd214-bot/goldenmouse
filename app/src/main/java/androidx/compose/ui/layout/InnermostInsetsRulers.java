package androidx.compose.ui.layout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0003H\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001B\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\r\u001A\u00020\u000EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u000EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010¨\u0006\u0018"}, d2={"Landroidx/compose/ui/layout/InnermostInsetsRulers;", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "name", "", "rulers", "", "<init>", "(Ljava/lang/String;[Landroidx/compose/ui/layout/WindowInsetsRulers;)V", "getName", "()Ljava/lang/String;", "getRulers", "()[Landroidx/compose/ui/layout/WindowInsetsRulers;", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "current", "Landroidx/compose/ui/layout/RectRulers;", "getCurrent", "()Landroidx/compose/ui/layout/RectRulers;", "maximum", "getMaximum", "getAnimation", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class InnermostInsetsRulers implements WindowInsetsRulers {
    private final RectRulers current;
    private final RectRulers maximum;
    private final String name;
    private final WindowInsetsRulers[] rulers;

    public InnermostInsetsRulers(String arg6, WindowInsetsRulers[] arg7) {
        super();
        this.name = arg6;
        this.rulers = arg7;
        Companion v6 = RectRulers.Companion;
        ArrayList v0 = new ArrayList(arg7.length);
        int v1 = arg7.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ((Collection)v0).add(arg7[v3].getCurrent());
        }

        Object[] v7 = ((Collection)v0).toArray(new RectRulers[0]);
        this.current = RectRulersKt.innermostOf(v6, Arrays.copyOf(v7, v7.length));
        v6 = RectRulers.Companion;
        arg7 = this.rulers;
        v0 = new ArrayList(arg7.length);
        v1 = arg7.length;
        for(v3 = 0; v3 < v1; ++v3) {
            ((Collection)v0).add(arg7[v3].getMaximum());
        }

        v7 = ((Collection)v0).toArray(new RectRulers[0]);
        this.maximum = RectRulersKt.innermostOf(v6, Arrays.copyOf(v7, v7.length));
    }

    public WindowInsetsAnimation getAnimation(PlacementScope arg2) {
        return new InnermostAnimationProperties(arg2, this.rulers);
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

    public final WindowInsetsRulers[] getRulers() {
        return this.rulers;
    }

    public String toString() {
        String v0 = this.name;
        if(v0 == null) {
            return ArraysKt.joinToString$default(this.rulers, null, "innermostOf(", ")", 0, null, null, 57, null);
        }

        return v0;
    }
}


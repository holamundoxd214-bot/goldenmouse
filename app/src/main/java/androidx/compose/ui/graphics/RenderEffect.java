package androidx.compose.ui.graphics;

import android.os.Build$VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0005H\u0007J\b\u0010\u0007\u001A\u00020\u0005H%J\b\u0010\b\u001A\u00020\tH\u0016R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0001\u0003\n\u000B\f¨\u0006\r"}, d2={"Landroidx/compose/ui/graphics/RenderEffect;", "", "<init>", "()V", "internalRenderEffect", "Landroid/graphics/RenderEffect;", "asAndroidRenderEffect", "createRenderEffect", "isSupported", "", "Landroidx/compose/ui/graphics/AndroidRenderEffect;", "Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/OffsetEffect;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class RenderEffect {
    public static final int $stable;
    private android.graphics.RenderEffect internalRenderEffect;

    static {
    }

    private RenderEffect() {
        super();
    }

    public RenderEffect(DefaultConstructorMarker arg1) {
        this();
    }

    public final android.graphics.RenderEffect asAndroidRenderEffect() {
        android.graphics.RenderEffect v0 = this.internalRenderEffect;
        if(v0 == null) {
            v0 = this.createRenderEffect();
            this.internalRenderEffect = v0;
        }

        return v0;
    }

    protected abstract android.graphics.RenderEffect createRenderEffect();

    public boolean isSupported() {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return 1;
        }

        return 0;
    }
}


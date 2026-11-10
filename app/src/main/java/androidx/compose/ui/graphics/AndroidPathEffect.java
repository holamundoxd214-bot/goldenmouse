package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/graphics/AndroidPathEffect;", "Landroidx/compose/ui/graphics/PathEffect;", "nativePathEffect", "Landroid/graphics/PathEffect;", "<init>", "(Landroid/graphics/PathEffect;)V", "getNativePathEffect", "()Landroid/graphics/PathEffect;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPathEffect implements PathEffect {
    public static final int $stable = 8;
    private final android.graphics.PathEffect nativePathEffect;

    static {
    }

    public AndroidPathEffect(android.graphics.PathEffect arg1) {
        super();
        this.nativePathEffect = arg1;
    }

    public final android.graphics.PathEffect getNativePathEffect() {
        return this.nativePathEffect;
    }
}


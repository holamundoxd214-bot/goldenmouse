package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB;\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fJ\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u001DH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0013\u0010\u0005\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0013\u0010\u0011R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u001F"}, d2={"Landroidx/compose/ui/graphics/drawscope/Stroke;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "width", "", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "<init>", "(FFIILandroidx/compose/ui/graphics/PathEffect;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getWidth", "()F", "getMiter", "getCap-KaPHkGw", "()I", "I", "getJoin-LxFBmk8", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Stroke extends DrawStyle {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0013\u0010\f\u001A\u00020\r¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\u000E\u0010\n¨\u0006\u000F"}, d2={"Landroidx/compose/ui/graphics/drawscope/Stroke$Companion;", "", "<init>", "()V", "HairlineWidth", "", "DefaultMiter", "DefaultCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultCap-KaPHkGw", "()I", "I", "DefaultJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultJoin-LxFBmk8", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getDefaultCap-KaPHkGw() {
            return Stroke.DefaultCap;
        }

        public final int getDefaultJoin-LxFBmk8() {
            return Stroke.DefaultJoin;
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int DefaultCap = 0;
    private static final int DefaultJoin = 0;
    public static final float DefaultMiter = 4f;
    public static final float HairlineWidth;
    private final int cap;
    private final int join;
    private final float miter;
    private final PathEffect pathEffect;
    private final float width;

    static {
        Stroke.Companion = new Companion(null);
        Stroke.$stable = 8;
        Stroke.DefaultCap = StrokeCap.Companion.getButt-KaPHkGw();
        Stroke.DefaultJoin = StrokeJoin.Companion.getMiter-LxFBmk8();
    }

    public Stroke(float arg8, float arg9, int arg10, int arg11, PathEffect arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 2) != 0) {
            arg9 = 4f;
        }

        float v2 = arg9;
        if((arg13 & 4) != 0) {
            arg10 = Stroke.DefaultCap;
        }

        int v3 = arg10;
        if((arg13 & 8) != 0) {
            arg11 = Stroke.DefaultJoin;
        }

        int v4 = arg11;
        if((arg13 & 16) != 0) {
            arg12 = null;
        }

        this(0f, v2, v3, v4, arg12, null);
    }

    private Stroke(float arg2, float arg3, int arg4, int arg5, PathEffect arg6) {
        super(null);
        this.width = arg2;
        this.miter = arg3;
        this.cap = arg4;
        this.join = arg5;
        this.pathEffect = arg6;
    }

    public Stroke(float arg1, float arg2, int arg3, int arg4, PathEffect arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public static final int access$getDefaultCap$cp() {
        return Stroke.DefaultCap;
    }

    public static final int access$getDefaultJoin$cp() {
        return Stroke.DefaultJoin;
    }

    public boolean equals(Object arg5) {
        if(this == (((Stroke)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Stroke)) {
            return 0;
        }

        if(this.width == ((Stroke)arg5).width && this.miter == ((Stroke)arg5).miter) {
            if(!StrokeCap.equals-impl0(this.cap, ((Stroke)arg5).cap)) {
                return 0;
            }
            else if(!StrokeJoin.equals-impl0(this.join, ((Stroke)arg5).join)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.pathEffect, ((Stroke)arg5).pathEffect)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final int getCap-KaPHkGw() {
        return this.cap;
    }

    public final int getJoin-LxFBmk8() {
        return this.join;
    }

    public final float getMiter() {
        return this.miter;
    }

    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int v0 = (((Float.hashCode(this.width) * 0x1F + Float.hashCode(this.miter)) * 0x1F + StrokeCap.hashCode-impl(this.cap)) * 0x1F + StrokeJoin.hashCode-impl(this.join)) * 0x1F;
        PathEffect v2 = this.pathEffect;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + StrokeCap.toString-impl(this.cap) + ", join=" + StrokeJoin.toString-impl(this.join) + ", pathEffect=" + this.pathEffect + ')';
    }
}


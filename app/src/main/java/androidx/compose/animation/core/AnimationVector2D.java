package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u000E\u001A\u00020\u000FH\u0010¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001A\u00020\u0000H\u0010¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0015H\u0090\u0002¢\u0006\u0002\b\u0016J\u001E\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0007\u001A\u00020\u0003H\u0090\u0002¢\u0006\u0002\b\u0018J\b\u0010\u001C\u001A\u00020\u001DH\u0016J\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001A\u00020\u0015H\u0016R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0003@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000BR\u0014\u0010\u0019\u001A\u00020\u0015X\u0090D¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006#"}, d2={"Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "<init>", "(FF)V", "value", "getV1", "()F", "setV1$animation_core", "(F)V", "getV2", "setV2$animation_core", "reset", "", "reset$animation_core", "newVector", "newVector$animation_core", "get", "index", "", "get$animation_core", "set", "set$animation_core", "size", "getSize$animation_core", "()I", "toString", "", "equals", "", "other", "", "hashCode", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimationVector2D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;
    private float v1;
    private float v2;

    static {
    }

    public AnimationVector2D(float arg2, float arg3) {
        super(null);
        this.v1 = arg2;
        this.v2 = arg3;
        this.size = 2;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof AnimationVector2D)) && ((AnimationVector2D)arg3).v1 == this.v1 && ((AnimationVector2D)arg3).v2 == this.v2) {
            return 1;
        }

        return 0;
    }

    public float get$animation_core(int arg2) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                return 0;
            }

            return this.v2;
        }

        return this.v1;
    }

    public int getSize$animation_core() {
        return this.size;
    }

    public final float getV1() {
        return this.v1;
    }

    public final float getV2() {
        return this.v2;
    }

    public int hashCode() {
        return Float.hashCode(this.v1) * 0x1F + Float.hashCode(this.v2);
    }

    public AnimationVector2D newVector$animation_core() {
        return new AnimationVector2D(0f, 0f);
    }

    public AnimationVector newVector$animation_core() {
        return this.newVector$animation_core();
    }

    public void reset$animation_core() {
        this.v1 = 0f;
        this.v2 = 0f;
    }

    public void set$animation_core(int arg2, float arg3) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                return;
            }

            this.v2 = arg3;
            return;
        }

        this.v1 = arg3;
    }

    public final void setV1$animation_core(float arg1) {
        this.v1 = arg1;
    }

    public final void setV2$animation_core(float arg1) {
        this.v2 = arg1;
    }

    public String toString() {
        return "AnimationVector2D: v1 = " + this.v1 + ", v2 = " + this.v2;
    }
}


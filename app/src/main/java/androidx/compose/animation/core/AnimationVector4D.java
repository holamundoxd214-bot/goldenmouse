package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0014\u001A\u00020\u0015H\u0010¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001A\u00020\u0000H\u0010¢\u0006\u0002\b\u0018J\u0016\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u001BH\u0090\u0002¢\u0006\u0002\b\u001CJ\u001E\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\t\u001A\u00020\u0003H\u0090\u0002¢\u0006\u0002\b\u001EJ\b\u0010\"\u001A\u00020#H\u0016J\u0013\u0010$\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u0096\u0002J\b\u0010(\u001A\u00020\u001BH\u0016R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000B\"\u0004\b\u000F\u0010\rR$\u0010\u0005\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u000B\"\u0004\b\u0011\u0010\rR$\u0010\u0006\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000B\"\u0004\b\u0013\u0010\rR\u0014\u0010\u001F\u001A\u00020\u001BX\u0090D¢\u0006\b\n\u0000\u001A\u0004\b \u0010!¨\u0006)"}, d2={"Landroidx/compose/animation/core/AnimationVector4D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "v3", "v4", "<init>", "(FFFF)V", "value", "getV1", "()F", "setV1$animation_core", "(F)V", "getV2", "setV2$animation_core", "getV3", "setV3$animation_core", "getV4", "setV4$animation_core", "reset", "", "reset$animation_core", "newVector", "newVector$animation_core", "get", "index", "", "get$animation_core", "set", "set$animation_core", "size", "getSize$animation_core", "()I", "toString", "", "equals", "", "other", "", "hashCode", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimationVector4D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;
    private float v1;
    private float v2;
    private float v3;
    private float v4;

    static {
    }

    public AnimationVector4D(float arg2, float arg3, float arg4, float arg5) {
        super(null);
        this.v1 = arg2;
        this.v2 = arg3;
        this.v3 = arg4;
        this.v4 = arg5;
        this.size = 4;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof AnimationVector4D)) && ((AnimationVector4D)arg3).v1 == this.v1 && ((AnimationVector4D)arg3).v2 == this.v2 && ((AnimationVector4D)arg3).v3 == this.v3 && ((AnimationVector4D)arg3).v4 == this.v4) {
            return 1;
        }

        return 0;
    }

    public float get$animation_core(int arg2) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                if(arg2 != 2) {
                    if(arg2 != 3) {
                        return 0;
                    }

                    return this.v4;
                }

                return this.v3;
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

    public final float getV3() {
        return this.v3;
    }

    public final float getV4() {
        return this.v4;
    }

    public int hashCode() {
        return ((Float.hashCode(this.v1) * 0x1F + Float.hashCode(this.v2)) * 0x1F + Float.hashCode(this.v3)) * 0x1F + Float.hashCode(this.v4);
    }

    public AnimationVector4D newVector$animation_core() {
        return new AnimationVector4D(0f, 0f, 0f, 0f);
    }

    public AnimationVector newVector$animation_core() {
        return this.newVector$animation_core();
    }

    public void reset$animation_core() {
        this.v1 = 0f;
        this.v2 = 0f;
        this.v3 = 0f;
        this.v4 = 0f;
    }

    public void set$animation_core(int arg2, float arg3) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                if(arg2 != 2) {
                    if(arg2 != 3) {
                        return;
                    }

                    this.v4 = arg3;
                    return;
                }

                this.v3 = arg3;
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

    public final void setV3$animation_core(float arg1) {
        this.v3 = arg1;
    }

    public final void setV4$animation_core(float arg1) {
        this.v4 = arg1;
    }

    public String toString() {
        return "AnimationVector4D: v1 = " + this.v1 + ", v2 = " + this.v2 + ", v3 = " + this.v3 + ", v4 = " + this.v4;
    }
}


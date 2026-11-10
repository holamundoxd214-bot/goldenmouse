package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\n\u001A\u00020\u000BH\u0010¢\u0006\u0002\b\fJ\r\u0010\r\u001A\u00020\u0000H\u0010¢\u0006\u0002\b\u000EJ\u0016\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0011H\u0090\u0002¢\u0006\u0002\b\u0012J\u001E\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0006\u001A\u00020\u0003H\u0090\u0002¢\u0006\u0002\b\u0014J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\b\u0010\u001E\u001A\u00020\u0011H\u0016R$\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u0014\u0010\u0015\u001A\u00020\u0011X\u0090D¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u001F"}, d2={"Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/AnimationVector;", "initVal", "", "<init>", "(F)V", "value", "getValue", "()F", "setValue$animation_core", "reset", "", "reset$animation_core", "newVector", "newVector$animation_core", "get", "index", "", "get$animation_core", "set", "set$animation_core", "size", "getSize$animation_core", "()I", "toString", "", "equals", "", "other", "", "hashCode", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimationVector1D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;
    private float value;

    static {
    }

    public AnimationVector1D(float arg2) {
        super(null);
        this.value = arg2;
        this.size = 1;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof AnimationVector1D)) && ((AnimationVector1D)arg2).value == this.value) {
            return 1;
        }

        return 0;
    }

    public float get$animation_core(int arg1) {
        if(arg1 == 0) {
            return this.value;
        }

        return 0;
    }

    public int getSize$animation_core() {
        return this.size;
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.hashCode(this.value);
    }

    public AnimationVector1D newVector$animation_core() {
        return new AnimationVector1D(0f);
    }

    public AnimationVector newVector$animation_core() {
        return this.newVector$animation_core();
    }

    public void reset$animation_core() {
        this.value = 0f;
    }

    public void set$animation_core(int arg1, float arg2) {
        if(arg1 == 0) {
            this.value = arg2;
        }
    }

    public final void setValue$animation_core(float arg1) {
        this.value = arg1;
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.value;
    }
}


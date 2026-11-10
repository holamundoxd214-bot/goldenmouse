package androidx.dynamicanimation.animation;

public final class FloatValueHolder {
    private float mValue;

    public FloatValueHolder() {
        super();
        this.mValue = 0f;
    }

    public FloatValueHolder(float arg2) {
        super();
        this.mValue = 0f;
        this.setValue(arg2);
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float arg1) {
        this.mValue = arg1;
    }
}


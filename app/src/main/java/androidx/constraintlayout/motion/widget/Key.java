package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Key {
    static final String ALPHA = "alpha";
    static final String CUSTOM = "CUSTOM";
    static final String ELEVATION = "elevation";
    static final String PIVOT_X = "transformPivotX";
    static final String PIVOT_Y = "transformPivotY";
    static final String PROGRESS = "progress";
    static final String ROTATION = "rotation";
    static final String ROTATION_X = "rotationX";
    static final String ROTATION_Y = "rotationY";
    static final String SCALE_X = "scaleX";
    static final String SCALE_Y = "scaleY";
    static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    static final String TRANSLATION_X = "translationX";
    static final String TRANSLATION_Y = "translationY";
    static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    static final String WAVE_OFFSET = "waveOffset";
    static final String WAVE_PERIOD = "wavePeriod";
    static final String WAVE_VARIES_BY = "waveVariesBy";
    HashMap mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    static {
    }

    public Key() {
        super();
        int v0 = Key.UNSET;
        this.mFramePosition = v0;
        this.mTargetId = v0;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap arg1);

    abstract void getAttributeNames(HashSet arg1);

    abstract void load(Context arg1, AttributeSet arg2);

    boolean matches(String arg1) {
        String v0 = this.mTargetString;
        if(v0 != null) {
            if(arg1 == null) {
            }
            else {
                return arg1.matches(v0);
            }
        }

        return 0;
    }

    public void setInterpolation(HashMap arg1) {
    }

    public abstract void setValue(String arg1, Object arg2);

    boolean toBoolean(Object arg1) {
        if((arg1 instanceof Boolean)) {
            return ((Boolean)arg1).booleanValue();
        }

        return Boolean.parseBoolean(arg1.toString());
    }

    float toFloat(Object arg1) {
        if((arg1 instanceof Float)) {
            return ((Float)arg1).floatValue();
        }

        return Float.parseFloat(arg1.toString());
    }

    int toInt(Object arg1) {
        if((arg1 instanceof Integer)) {
            return ((Integer)arg1).intValue();
        }

        return Integer.parseInt(arg1.toString());
    }
}


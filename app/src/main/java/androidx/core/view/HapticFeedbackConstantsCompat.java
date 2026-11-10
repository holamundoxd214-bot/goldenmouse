package androidx.core.view;

import android.os.Build$VERSION;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class HapticFeedbackConstantsCompat {
    @Retention(value=RetentionPolicy.SOURCE) @public interface HapticFeedbackFlags {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface HapticFeedbackType {
    }

    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    private HapticFeedbackConstantsCompat() {
        super();
    }

    static int getFeedbackConstantOrFallback(int arg5) {
        int v0 = -1;
        if(arg5 == v0) {
            return v0;
        }

        int v3 = 0;
        int v4 = 6;
        if(Build$VERSION.SDK_INT < 34) {
            switch(arg5) {
                case 25: {
                    goto label_10;
                }
                case 21: 
                case 23: 
                case 26: {
                    goto label_14;
                }
                case 22: 
                case 24: 
                case 27: {
                    goto label_12;
                }
            }

            goto label_15;
        label_10:
            arg5 = 0;
            goto label_15;
        label_12:
            arg5 = 4;
            goto label_15;
        label_14:
            arg5 = v4;
        }

    label_15:
        if(Build$VERSION.SDK_INT < 30) {
            if(arg5 != 12) {
                if(arg5 == 13) {
                    v3 = v4;
                    goto label_32;
                }
                else if(arg5 != 16) {
                    if(arg5 != 17) {
                        goto label_31;
                    }
                    else {
                        goto label_32;
                    }
                }
            }

            v3 = 1;
        }
        else {
        label_31:
            v3 = arg5;
        }

    label_32:
        if(Build$VERSION.SDK_INT < 27 && (v3 == 7 || v3 == 8 || v3 == 9)) {
            return v0;
        }

        return v3;
    }
}


package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import androidx.annotation.ReplaceWith;

public final class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 0x20;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 0x20;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    private AccessibilityServiceInfoCompat() {
        super();
    }

    public static String capabilityToString(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 4) {
                    if(arg1 != 8) {
                        return "UNKNOWN";
                    }

                    return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
                }

                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            }

            return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }

        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    }

    public static String feedbackTypeToString(int arg4) {
        StringBuilder v0 = new StringBuilder();
        v0.append("[");
        while(arg4 > 0) {
            int v1 = 1 << Integer.numberOfTrailingZeros(arg4);
            arg4 &= ~v1;
            if(v0.length() > 1) {
                v0.append(", ");
            }

            if(v1 != 1) {
                if(v1 != 2) {
                    if(v1 != 4) {
                        if(v1 != 8) {
                            if(v1 != 16) {
                                continue;
                            }

                            v0.append("FEEDBACK_GENERIC");
                            continue;
                        }

                        v0.append("FEEDBACK_VISUAL");
                        continue;
                    }

                    v0.append("FEEDBACK_AUDIBLE");
                    continue;
                }

                v0.append("FEEDBACK_HAPTIC");
                continue;
            }

            v0.append("FEEDBACK_SPOKEN");
        }

        v0.append("]");
        return v0.toString();
    }

    public static String flagToString(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 4) {
                    if(arg1 != 8) {
                        if(arg1 != 16) {
                            if(arg1 != 0x20) {
                                return null;
                            }

                            return "FLAG_REQUEST_FILTER_KEY_EVENTS";
                        }

                        return "FLAG_REPORT_VIEW_IDS";
                    }

                    return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                }

                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            }

            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }

        return "DEFAULT";
    }

    @ReplaceWith(expression="info.getCapabilities()") @Deprecated public static int getCapabilities(AccessibilityServiceInfo arg0) {
        return arg0.getCapabilities();
    }

    @ReplaceWith(expression="info.loadDescription(packageManager)") @Deprecated public static String loadDescription(AccessibilityServiceInfo arg0, PackageManager arg1) {
        return arg0.loadDescription(arg1);
    }
}


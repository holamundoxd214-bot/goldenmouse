package androidx.core.view.accessibility;

import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.ReplaceWith;
import java.util.List;

public final class AccessibilityManagerCompat {
    @Deprecated public interface AccessibilityStateChangeListener {
        @Deprecated void onAccessibilityStateChanged(boolean arg1);
    }

    @Deprecated public abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
        public AccessibilityStateChangeListenerCompat() {
            super();
        }
    }

    class AccessibilityStateChangeListenerWrapper implements AccessibilityManager$AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(AccessibilityStateChangeListener arg1) {
            super();
            this.mListener = arg1;
        }

        public boolean equals(Object arg2) {
            if(this == (((AccessibilityStateChangeListenerWrapper)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof AccessibilityStateChangeListenerWrapper)) {
                return 0;
            }

            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper)arg2).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public void onAccessibilityStateChanged(boolean arg1) {
            this.mListener.onAccessibilityStateChanged(arg1);
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static boolean isRequestFromAccessibilityTool(AccessibilityManager arg0) {
            return arg0.isRequestFromAccessibilityTool();
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean arg1);
    }

    final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager$TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(TouchExplorationStateChangeListener arg1) {
            super();
            this.mListener = arg1;
        }

        public boolean equals(Object arg2) {
            if(this == (((TouchExplorationStateChangeListenerWrapper)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof TouchExplorationStateChangeListenerWrapper)) {
                return 0;
            }

            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper)arg2).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean arg1) {
            this.mListener.onTouchExplorationStateChanged(arg1);
        }
    }

    private AccessibilityManagerCompat() {
        super();
    }

    @Deprecated public static boolean addAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListener arg2) {
        if(arg2 == null) {
            return 0;
        }

        return arg1.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(arg2));
    }

    @ReplaceWith(expression="manager.addTouchExplorationStateChangeListener(listener)") @Deprecated public static boolean addTouchExplorationStateChangeListener(AccessibilityManager arg1, TouchExplorationStateChangeListener arg2) {
        return arg1.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(arg2));
    }

    @ReplaceWith(expression="manager.getEnabledAccessibilityServiceList(feedbackTypeFlags)") @Deprecated public static List getEnabledAccessibilityServiceList(AccessibilityManager arg0, int arg1) {
        return arg0.getEnabledAccessibilityServiceList(arg1);
    }

    @ReplaceWith(expression="manager.getInstalledAccessibilityServiceList()") @Deprecated public static List getInstalledAccessibilityServiceList(AccessibilityManager arg0) {
        return arg0.getInstalledAccessibilityServiceList();
    }

    public static boolean isRequestFromAccessibilityTool(AccessibilityManager arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.isRequestFromAccessibilityTool(arg2);
        }

        return 1;
    }

    @ReplaceWith(expression="manager.isTouchExplorationEnabled()") @Deprecated public static boolean isTouchExplorationEnabled(AccessibilityManager arg0) {
        return arg0.isTouchExplorationEnabled();
    }

    @Deprecated public static boolean removeAccessibilityStateChangeListener(AccessibilityManager arg1, AccessibilityStateChangeListener arg2) {
        if(arg2 == null) {
            return 0;
        }

        return arg1.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(arg2));
    }

    @ReplaceWith(expression="manager.removeTouchExplorationStateChangeListener(listener)") @Deprecated public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager arg1, TouchExplorationStateChangeListener arg2) {
        return arg1.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(arg2));
    }
}


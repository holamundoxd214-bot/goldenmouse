package androidx.core.view.accessibility;

import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AccessibilityEventCompat {
    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static boolean isAccessibilityDataSensitive(AccessibilityEvent arg0) {
            return arg0.isAccessibilityDataSensitive();
        }

        static void setAccessibilityDataSensitive(AccessibilityEvent arg0, boolean arg1) {
            arg0.setAccessibilityDataSensitive(arg1);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ContentChangeType {
    }

    public static final int CONTENT_CHANGE_TYPE_CHECKED = 0x2000;
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_CONTENT_INVALID = 0x400;
    public static final int CONTENT_CHANGE_TYPE_DRAG_CANCELLED = 0x200;
    public static final int CONTENT_CHANGE_TYPE_DRAG_DROPPED = 0x100;
    public static final int CONTENT_CHANGE_TYPE_DRAG_STARTED = 0x80;
    public static final int CONTENT_CHANGE_TYPE_ENABLED = 0x1000;
    public static final int CONTENT_CHANGE_TYPE_ERROR = 0x800;
    public static final int CONTENT_CHANGE_TYPE_EXPANDED = 0x4000;
    public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16;
    public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 0x20;
    public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8;
    public static final int CONTENT_CHANGE_TYPE_SORT_DIRECTION = 0x10000;
    public static final int CONTENT_CHANGE_TYPE_STATE_DESCRIPTION = 0x40;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_SUPPLEMENTAL_DESCRIPTION = 0x8000;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 0x4000;
    public static final int TYPE_ASSIST_READING_CONTEXT = 0x1000000;
    public static final int TYPE_GESTURE_DETECTION_END = 0x80000;
    public static final int TYPE_GESTURE_DETECTION_START = 0x40000;
    @Deprecated public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 0x400;
    @Deprecated public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 0x200;
    public static final int TYPE_TOUCH_INTERACTION_END = 0x200000;
    public static final int TYPE_TOUCH_INTERACTION_START = 0x100000;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 0x8000;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 0x10000;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 0x800000;
    @Deprecated public static final int TYPE_VIEW_HOVER_ENTER = 0x80;
    @Deprecated public static final int TYPE_VIEW_HOVER_EXIT = 0x100;
    @Deprecated public static final int TYPE_VIEW_SCROLLED = 0x1000;
    public static final int TYPE_VIEW_TARGETED_BY_SCROLL = 0x4000000;
    @Deprecated public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 0x2000;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 0x20000;
    public static final int TYPE_WINDOWS_CHANGED = 0x400000;
    @Deprecated public static final int TYPE_WINDOW_CONTENT_CHANGED = 0x800;

    private AccessibilityEventCompat() {
        super();
    }

    @ReplaceWith(expression="event.appendRecord(record)") @Deprecated public static void appendRecord(AccessibilityEvent arg0, AccessibilityRecordCompat arg1) {
        arg0.appendRecord(arg1.getImpl());
    }

    @Deprecated public static AccessibilityRecordCompat asRecord(AccessibilityEvent arg1) {
        return new AccessibilityRecordCompat(arg1);
    }

    @ReplaceWith(expression="event.getAction()") @Deprecated public static int getAction(AccessibilityEvent arg0) {
        return arg0.getAction();
    }

    @ReplaceWith(expression="event.getContentChangeTypes()") @Deprecated public static int getContentChangeTypes(AccessibilityEvent arg0) {
        return arg0.getContentChangeTypes();
    }

    @ReplaceWith(expression="event.getMovementGranularity()") @Deprecated public static int getMovementGranularity(AccessibilityEvent arg0) {
        return arg0.getMovementGranularity();
    }

    @Deprecated public static AccessibilityRecordCompat getRecord(AccessibilityEvent arg1, int arg2) {
        return new AccessibilityRecordCompat(arg1.getRecord(arg2));
    }

    @ReplaceWith(expression="event.getRecordCount()") @Deprecated public static int getRecordCount(AccessibilityEvent arg0) {
        return arg0.getRecordCount();
    }

    public static boolean isAccessibilityDataSensitive(AccessibilityEvent arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.isAccessibilityDataSensitive(arg2);
        }

        return 0;
    }

    public static void setAccessibilityDataSensitive(AccessibilityEvent arg2, boolean arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setAccessibilityDataSensitive(arg2, arg3);
        }
    }

    @ReplaceWith(expression="event.setAction(action)") @Deprecated public static void setAction(AccessibilityEvent arg0, int arg1) {
        arg0.setAction(arg1);
    }

    @ReplaceWith(expression="event.setContentChangeTypes(changeTypes)") @Deprecated public static void setContentChangeTypes(AccessibilityEvent arg0, int arg1) {
        arg0.setContentChangeTypes(arg1);
    }

    @ReplaceWith(expression="event.setMovementGranularity(granularity)") @Deprecated public static void setMovementGranularity(AccessibilityEvent arg0, int arg1) {
        arg0.setMovementGranularity(arg1);
    }
}


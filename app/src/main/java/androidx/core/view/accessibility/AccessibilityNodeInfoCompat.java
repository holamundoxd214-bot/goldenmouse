package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo$Builder;
import android.view.accessibility.AccessibilityNodeInfo$CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo$Builder;
import android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo$ExtraRenderingInfo;
import android.view.accessibility.AccessibilityNodeInfo$MathInfo;
import android.view.accessibility.AccessibilityNodeInfo$RangeInfo;
import android.view.accessibility.AccessibilityNodeInfo$Selection;
import android.view.accessibility.AccessibilityNodeInfo$SelectionPosition;
import android.view.accessibility.AccessibilityNodeInfo$StructuredDataInfo;
import android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.core.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AccessibilityNodeInfoCompat {
    public class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COLLAPSE = null;
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COPY = null;
        public static final AccessibilityActionCompat ACTION_CUT = null;
        public static final AccessibilityActionCompat ACTION_DISMISS = null;
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL = null;
        public static final AccessibilityActionCompat ACTION_DRAG_DROP = null;
        public static final AccessibilityActionCompat ACTION_DRAG_START = null;
        public static final AccessibilityActionCompat ACTION_EXPAND = null;
        public static final AccessibilityActionCompat ACTION_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP = null;
        public static final AccessibilityActionCompat ACTION_IME_ENTER = null;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = null;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW = null;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN = null;
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_UP = null;
        public static final AccessibilityActionCompat ACTION_PASTE = null;
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP = null;
        public static final AccessibilityActionCompat ACTION_SELECT = null;
        public static final AccessibilityActionCompat ACTION_SET_EXTENDED_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS = null;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_SET_TEXT = null;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = null;
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS = null;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP = null;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class mViewCommandArgumentClass;

        static {
            AccessibilityNodeInfo$AccessibilityAction v4;
            Object v10_1;
            Object v9_1;
            Object v8_1;
            AccessibilityNodeInfo$AccessibilityAction v8;
            Object v7_1;
            AccessibilityNodeInfo$AccessibilityAction v7;
            Object v6_1;
            AccessibilityNodeInfo$AccessibilityAction v6;
            Object v5_1;
            AccessibilityNodeInfo$AccessibilityAction v5;
            CharSequence v2 = null;
            AccessibilityActionCompat.ACTION_FOCUS = new AccessibilityActionCompat(1, v2);
            AccessibilityActionCompat.ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, v2);
            AccessibilityActionCompat.ACTION_SELECT = new AccessibilityActionCompat(4, v2);
            AccessibilityActionCompat.ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, v2);
            AccessibilityActionCompat.ACTION_CLICK = new AccessibilityActionCompat(16, v2);
            int v1 = 0x20;
            AccessibilityActionCompat.ACTION_LONG_CLICK = new AccessibilityActionCompat(v1, v2);
            AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(0x40, v2);
            AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(0x80, v2);
            Class v3 = MoveAtGranularityArguments.class;
            AccessibilityActionCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(0x100, v2, v3);
            AccessibilityActionCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(0x200, v2, v3);
            v3 = MoveHtmlArguments.class;
            AccessibilityActionCompat.ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(0x400, v2, v3);
            AccessibilityActionCompat.ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(0x800, v2, v3);
            AccessibilityActionCompat.ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(0x1000, v2);
            AccessibilityActionCompat.ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(0x2000, v2);
            AccessibilityActionCompat.ACTION_COPY = new AccessibilityActionCompat(0x4000, v2);
            AccessibilityActionCompat.ACTION_PASTE = new AccessibilityActionCompat(0x8000, v2);
            AccessibilityActionCompat.ACTION_CUT = new AccessibilityActionCompat(0x10000, v2);
            AccessibilityActionCompat.ACTION_SET_SELECTION = new AccessibilityActionCompat(0x20000, v2, SetSelectionArguments.class);
            AccessibilityActionCompat.ACTION_EXPAND = new AccessibilityActionCompat(0x40000, v2);
            AccessibilityActionCompat.ACTION_COLLAPSE = new AccessibilityActionCompat(0x80000, v2);
            AccessibilityActionCompat.ACTION_DISMISS = new AccessibilityActionCompat(0x100000, v2);
            AccessibilityActionCompat.ACTION_SET_TEXT = new AccessibilityActionCompat(0x200000, v2, SetTextArguments.class);
            AccessibilityActionCompat.ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_ON_SCREEN, 0x1020036, null, null, null);
            AccessibilityActionCompat.ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_TO_POSITION, 0x1020037, null, null, ScrollToPositionArguments.class);
            AccessibilityActionCompat.ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_UP, 0x1020038, null, null, null);
            AccessibilityActionCompat.ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_LEFT, 0x1020039, null, null, null);
            AccessibilityActionCompat.ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_DOWN, 0x102003A, null, null, null);
            AccessibilityActionCompat.ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_RIGHT, 0x102003B, null, null, null);
            int v3_1 = 29;
            if(Build$VERSION.SDK_INT >= v3_1) {
                v5 = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_UP;
            }
            else {
                v5_1 = v2;
            }

            AccessibilityActionCompat.ACTION_PAGE_UP = new AccessibilityActionCompat(v5_1, 0x1020046, null, null, null);
            if(Build$VERSION.SDK_INT >= v3_1) {
                v6 = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_DOWN;
            }
            else {
                v6_1 = v2;
            }

            AccessibilityActionCompat.ACTION_PAGE_DOWN = new AccessibilityActionCompat(v6, 0x1020047, null, null, null);
            if(Build$VERSION.SDK_INT >= v3_1) {
                v7 = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_LEFT;
            }
            else {
                v7_1 = v2;
            }

            AccessibilityActionCompat.ACTION_PAGE_LEFT = new AccessibilityActionCompat(v7, 0x1020048, null, null, null);
            if(Build$VERSION.SDK_INT >= v3_1) {
                v8 = AccessibilityNodeInfo$AccessibilityAction.ACTION_PAGE_RIGHT;
            }
            else {
                v8_1 = v2;
            }

            AccessibilityActionCompat.ACTION_PAGE_RIGHT = new AccessibilityActionCompat(v8, 0x1020049, null, null, null);
            AccessibilityActionCompat.ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_CONTEXT_CLICK, 0x102003C, null, null, null);
            AccessibilityActionCompat.ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_SET_PROGRESS, 0x102003D, null, null, SetProgressArguments.class);
            AccessibilityActionCompat.ACTION_MOVE_WINDOW = new AccessibilityActionCompat(AccessibilityNodeInfo$AccessibilityAction.ACTION_MOVE_WINDOW, 0x1020042, null, null, MoveWindowArguments.class);
            v3_1 = 28;
            if(Build$VERSION.SDK_INT >= v3_1) {
                v5 = AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_TOOLTIP;
            }
            else {
                v5_1 = v2;
            }

            AccessibilityActionCompat.ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(v5_1, 0x1020044, null, null, null);
            if(Build$VERSION.SDK_INT >= v3_1) {
                v6 = AccessibilityNodeInfo$AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            else {
                v6_1 = v2;
            }

            AccessibilityActionCompat.ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(v6, 0x1020045, null, null, null);
            v3_1 = 30;
            if(Build$VERSION.SDK_INT >= v3_1) {
                v7 = AccessibilityNodeInfo$AccessibilityAction.ACTION_PRESS_AND_HOLD;
            }
            else {
                v7_1 = v2;
            }

            AccessibilityActionCompat.ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(v7, 0x102004A, null, null, null);
            if(Build$VERSION.SDK_INT >= v3_1) {
                v8 = AccessibilityNodeInfo$AccessibilityAction.ACTION_IME_ENTER;
            }
            else {
                v8_1 = v2;
            }

            AccessibilityActionCompat.ACTION_IME_ENTER = new AccessibilityActionCompat(v8, 0x1020054, null, null, null);
            if(Build$VERSION.SDK_INT >= v1) {
                AccessibilityNodeInfo$AccessibilityAction v9 = AccessibilityNodeInfo$AccessibilityAction.ACTION_DRAG_START;
            }
            else {
                v9_1 = v2;
            }

            AccessibilityActionCompat.ACTION_DRAG_START = new AccessibilityActionCompat(v9_1, 0x1020055, null, null, null);
            if(Build$VERSION.SDK_INT >= v1) {
                AccessibilityNodeInfo$AccessibilityAction v10 = AccessibilityNodeInfo$AccessibilityAction.ACTION_DRAG_DROP;
            }
            else {
                v10_1 = v2;
            }

            AccessibilityActionCompat.ACTION_DRAG_DROP = new AccessibilityActionCompat(v10_1, 0x1020056, null, null, null);
            if(Build$VERSION.SDK_INT >= v1) {
                v4 = AccessibilityNodeInfo$AccessibilityAction.ACTION_DRAG_CANCEL;
            }
            else {
                Object v4_1 = v2;
            }

            AccessibilityActionCompat.ACTION_DRAG_CANCEL = new AccessibilityActionCompat(v4, 0x1020057, null, null, null);
            if(Build$VERSION.SDK_INT >= 33) {
                v5 = AccessibilityNodeInfo$AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            }
            else {
                v5_1 = v2;
            }

            AccessibilityActionCompat.ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(v5_1, 0x1020058, null, null, null);
            if(Build$VERSION.SDK_INT >= 34) {
                v6 = Api34Impl.getActionScrollInDirection();
            }
            else {
                v6_1 = v2;
            }

            AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION = new AccessibilityActionCompat(v6_1, 0x102005E, null, null, null);
            if(BuildCompat.isAtLeastB_1()) {
                AccessibilityNodeInfo$AccessibilityAction v2_1 = Api36MinorImpl.getActionSetExtendedSelection();
            }

            AccessibilityActionCompat.ACTION_SET_EXTENDED_SELECTION = new AccessibilityActionCompat(((AccessibilityNodeInfo$AccessibilityAction)v2), 0x102005F, null, null, null);
        }

        public AccessibilityActionCompat(int arg7, CharSequence arg8) {
            this(null, arg7, arg8, null, null);
        }

        public AccessibilityActionCompat(int arg7, CharSequence arg8, AccessibilityViewCommand arg9) {
            this(null, arg7, arg8, arg9, null);
        }

        AccessibilityActionCompat(Object arg7) {
            this(arg7, 0, null, null, null);
        }

        private AccessibilityActionCompat(int arg7, CharSequence arg8, Class arg9) {
            this(null, arg7, arg8, null, arg9);
        }

        AccessibilityActionCompat(Object arg1, int arg2, CharSequence arg3, AccessibilityViewCommand arg4, Class arg5) {
            super();
            this.mId = arg2;
            this.mCommand = arg4;
            this.mAction = arg1 == null ? new AccessibilityNodeInfo$AccessibilityAction(arg2, arg3) : arg1;
            this.mViewCommandArgumentClass = arg5;
        }

        public AccessibilityActionCompat createReplacementAction(CharSequence arg7, AccessibilityViewCommand arg8) {
            return new AccessibilityActionCompat(null, this.mId, arg7, arg8, this.mViewCommandArgumentClass);
        }

        public boolean equals(Object arg3) {
            if(arg3 == null) {
                return 0;
            }

            if(!(arg3 instanceof AccessibilityActionCompat)) {
                return 0;
            }

            Object v2 = this.mAction;
            if(v2 == null) {
                if(((AccessibilityActionCompat)arg3).mAction != null) {
                    return 0;
                }
            }
            else if(!v2.equals(((AccessibilityActionCompat)arg3).mAction)) {
                return 0;
            }

            return 1;
        }

        public int getId() {
            return this.mAction.getId();
        }

        public CharSequence getLabel() {
            return this.mAction.getLabel();
        }

        public int hashCode() {
            Object v0 = this.mAction;
            if(v0 != null) {
                return v0.hashCode();
            }

            return 0;
        }

        public boolean perform(View arg5, Bundle arg6) {
            Object v2_1;
            Object v0_1;
            if(this.mCommand != null) {
                Class v0 = this.mViewCommandArgumentClass;
                CommandArguments v2 = null;
                if(v0 != null) {
                    try {
                        v0_1 = v0.getDeclaredConstructor().newInstance();
                        try {
                            ((CommandArguments)v0_1).setBundle(arg6);
                            v2_1 = v0_1;
                            goto label_29;
                        }
                        catch(Exception v6) {
                        }
                    }
                    catch(Exception v6) {
                        goto label_17;
                    }

                    v2_1 = v0_1;
                label_17:
                    v0 = this.mViewCommandArgumentClass;
                    String v0_2 = v0 == null ? "null" : v0.getName();
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + v0_2, ((Throwable)v6));
                }

            label_29:
                return this.mCommand.perform(arg5, v2);
            }

            return 0;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("AccessibilityActionCompat: ");
            String v1 = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if((v1.equals("ACTION_UNKNOWN")) && this.getLabel() != null) {
                v1 = this.getLabel().toString();
            }

            v0.append(v1);
            return v0.toString();
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        public static Object createRangeInfo(int arg1, float arg2, float arg3, float arg4) {
            return new AccessibilityNodeInfo$RangeInfo(arg1, arg2, arg3, arg4);
        }

        public static CharSequence getStateDescription(AccessibilityNodeInfo arg0) {
            return arg0.getStateDescription();
        }

        public static void setStateDescription(AccessibilityNodeInfo arg0, CharSequence arg1) {
            arg0.setStateDescription(arg1);
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean arg2, int arg3, int arg4, int arg5, int arg6, boolean arg7, String arg8, String arg9) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo$CollectionItemInfo$Builder().setHeading(arg2).setColumnIndex(arg3).setRowIndex(arg4).setColumnSpan(arg5).setRowSpan(arg6).setSelected(arg7).setRowTitle(arg8).setColumnTitle(arg9).build());
        }

        public static AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo arg0, int arg1, int arg2) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(arg0.getChild(arg1, arg2));
        }

        public static String getCollectionItemColumnTitle(Object arg0) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg0).getColumnTitle();
        }

        public static String getCollectionItemRowTitle(Object arg0) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg0).getRowTitle();
        }

        public static AccessibilityNodeInfo$ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo arg0) {
            return arg0.getExtraRenderingInfo();
        }

        public static AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo arg0, int arg1) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(arg0.getParent(arg1));
        }

        public static String getUniqueId(AccessibilityNodeInfo arg0) {
            return arg0.getUniqueId();
        }

        public static boolean isTextSelectable(AccessibilityNodeInfo arg0) {
            return arg0.isTextSelectable();
        }

        public static void setTextSelectable(AccessibilityNodeInfo arg0, boolean arg1) {
            arg0.setTextSelectable(arg1);
        }

        public static void setUniqueId(AccessibilityNodeInfo arg0, String arg1) {
            arg0.setUniqueId(arg1);
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        public static AccessibilityNodeInfo$AccessibilityAction getActionScrollInDirection() {
            return AccessibilityNodeInfo$AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void getBoundsInWindow(AccessibilityNodeInfo arg0, Rect arg1) {
            arg0.getBoundsInWindow(arg1);
        }

        public static CharSequence getContainerTitle(AccessibilityNodeInfo arg0) {
            return arg0.getContainerTitle();
        }

        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo arg2) {
            return arg2.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo arg0) {
            return arg0.hasRequestInitialAccessibilityFocus();
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo arg0) {
            return arg0.isAccessibilityDataSensitive();
        }

        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo arg0, boolean arg1) {
            arg0.setAccessibilityDataSensitive(arg1);
        }

        public static void setBoundsInWindow(AccessibilityNodeInfo arg0, Rect arg1) {
            arg0.setBoundsInWindow(arg1);
        }

        public static void setContainerTitle(AccessibilityNodeInfo arg0, CharSequence arg1) {
            arg0.setContainerTitle(arg1);
        }

        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo arg0, long arg1) {
            arg0.setMinDurationBetweenContentChanges(Duration.ofMillis(arg1));
        }

        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo arg0, View arg1, boolean arg2) {
            arg0.setQueryFromAppProcessEnabled(arg1, arg2);
        }

        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo arg0, boolean arg1) {
            arg0.setRequestInitialAccessibilityFocus(arg1);
        }
    }

    class Api35Impl {
        private Api35Impl() {
            super();
        }

        public static CollectionInfoCompat buildCollectionInfoCompat(int arg2, int arg3, boolean arg4, int arg5, int arg6, int arg7) {
            return new CollectionInfoCompat(new AccessibilityNodeInfo$CollectionInfo$Builder().setRowCount(arg2).setColumnCount(arg3).setHierarchical(arg4).setSelectionMode(arg5).setItemCount(arg6).setImportantForAccessibilityItemCount(arg7).build());
        }

        public static int getImportantForAccessibilityItemCount(Object arg0) {
            return ((AccessibilityNodeInfo$CollectionInfo)arg0).getImportantForAccessibilityItemCount();
        }

        public static int getItemCount(Object arg0) {
            return ((AccessibilityNodeInfo$CollectionInfo)arg0).getItemCount();
        }
    }

    class Api36Impl {
        static void -$$Nest$smaddLabeledBy(AccessibilityNodeInfo arg0, View arg1, int arg2) {
            Api36Impl.addLabeledBy(arg0, arg1, arg2);
        }

        static int -$$Nest$smgetChecked(AccessibilityNodeInfo arg0) {
            return Api36Impl.getChecked(arg0);
        }

        static List -$$Nest$smgetLabeledByList(AccessibilityNodeInfo arg0) {
            return Api36Impl.getLabeledByList(arg0);
        }

        static boolean -$$Nest$smremoveLabeledBy(AccessibilityNodeInfo arg0, View arg1, int arg2) {
            return Api36Impl.removeLabeledBy(arg0, arg1, arg2);
        }

        static void -$$Nest$smsetChecked(AccessibilityNodeInfo arg0, int arg1) {
            Api36Impl.setChecked(arg0, arg1);
        }

        private Api36Impl() {
            super();
        }

        private static void addLabeledBy(AccessibilityNodeInfo arg0, View arg1, int arg2) {
            arg0.addLabeledBy(arg1, arg2);
        }

        private static int getChecked(AccessibilityNodeInfo arg0) {
            return arg0.getChecked();
        }

        public static int getExpandedState(AccessibilityNodeInfo arg0) {
            return arg0.getExpandedState();
        }

        private static List getLabeledByList(AccessibilityNodeInfo arg2) {
            List v2 = arg2.getLabeledByList();
            ArrayList v0 = new ArrayList(v2.size());
            Iterator v2_1 = v2.iterator();
            while(v2_1.hasNext()) {
                Object v1 = v2_1.next();
                if(v1 == null) {
                    continue;
                }

                ((List)v0).add(AccessibilityNodeInfoCompat.wrap(((AccessibilityNodeInfo)v1)));
            }

            return ((List)v0);
        }

        public static CharSequence getSupplementalDescription(AccessibilityNodeInfo arg0) {
            return arg0.getSupplementalDescription();
        }

        public static boolean isFieldRequired(AccessibilityNodeInfo arg0) {
            return arg0.isFieldRequired();
        }

        private static boolean removeLabeledBy(AccessibilityNodeInfo arg0, View arg1, int arg2) {
            return arg0.removeLabeledBy(arg1, arg2);
        }

        private static void setChecked(AccessibilityNodeInfo arg0, int arg1) {
            arg0.setChecked(arg1);
        }

        public static void setExpandedState(AccessibilityNodeInfo arg0, int arg1) {
            arg0.setExpandedState(arg1);
        }

        public static void setFieldRequired(AccessibilityNodeInfo arg0, boolean arg1) {
            arg0.setFieldRequired(arg1);
        }

        public static void setSupplementalDescription(AccessibilityNodeInfo arg0, CharSequence arg1) {
            arg0.setSupplementalDescription(arg1);
        }
    }

    class Api36MinorImpl {
        private Api36MinorImpl() {
            super();
        }

        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean arg2, int arg3, int arg4, int arg5, int arg6, boolean arg7, String arg8, String arg9, int arg10) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo$CollectionItemInfo$Builder().setHeading(arg2).setColumnIndex(arg3).setRowIndex(arg4).setColumnSpan(arg5).setRowSpan(arg6).setSelected(arg7).setRowTitle(arg8).setColumnTitle(arg9).setSortDirection(arg10).build());
        }

        public static AccessibilityNodeInfo$AccessibilityAction getActionSetExtendedSelection() {
            return AccessibilityNodeInfo$AccessibilityAction.ACTION_SET_EXTENDED_SELECTION;
        }

        public static int getCollectionItemSortDirection(Object arg0) {
            return ((AccessibilityNodeInfo$CollectionItemInfo)arg0).getSortDirection();
        }
    }

    class Api37Impl {
        private Api37Impl() {
            super();
        }

        public static AccessibilityNodeInfo$MathInfo createMathInfo(String arg1) {
            return new AccessibilityNodeInfo$MathInfo(arg1);
        }

        public static AccessibilityNodeInfo$StructuredDataInfo getStructuredDataInfo(AccessibilityNodeInfo arg0) {
            if(arg0 == null) {
                return null;
            }

            return arg0.getStructuredDataInfo();
        }

        public static String getStructuredDataInfoAttribute(AccessibilityNodeInfo$StructuredDataInfo arg0, String arg1) {
            if(arg0 == null) {
                return null;
            }

            return arg0.getAttribute(arg1);
        }

        public static Map getStructuredDataInfoAttributes(AccessibilityNodeInfo$StructuredDataInfo arg0) {
            if(arg0 == null) {
                return Collections.emptyMap();
            }

            return arg0.getAttributes();
        }

        public static String getStructuredDataInfoTag(AccessibilityNodeInfo$StructuredDataInfo arg0) {
            if(arg0 == null) {
                return null;
            }

            return arg0.getTag();
        }

        public static View getView(AccessibilityNodeInfo$SelectionPosition arg0) {
            return arg0.getView();
        }

        public static int getVirtualDescendantId(AccessibilityNodeInfo$SelectionPosition arg0) {
            return arg0.getVirtualDescendantId();
        }

        public static void putStructuredDataInfoAttribute(AccessibilityNodeInfo$StructuredDataInfo arg0, String arg1, String arg2) {
            if(arg0 == null) {
                return;
            }

            arg0.putAttribute(arg1, arg2);
        }

        public static void removeStructuredDataInfoAttribute(AccessibilityNodeInfo$StructuredDataInfo arg0, String arg1) {
            if(arg0 == null) {
                return;
            }

            arg0.removeAttribute(arg1);
        }

        public static void setStructuredDataInfo(AccessibilityNodeInfo arg0, AccessibilityNodeInfo$StructuredDataInfo arg1) {
            if(arg0 == null) {
                return;
            }

            arg0.setStructuredDataInfo(arg1);
        }

        public static boolean structuredDataInfoEquals(Object arg0, Object arg1) {
            if(arg0 == null) {
                if(arg1 == null) {
                    return 1;
                }

                return 0;
            }

            return arg0.equals(arg1);
        }

        public static int structuredDataInfoHashCode(AccessibilityNodeInfo$StructuredDataInfo arg0) {
            if(arg0 == null) {
                return 0;
            }

            return arg0.hashCode();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface CheckedState {
    }

    public class CollectionInfoCompat {
        public final class Builder {
            private int mColumnCount;
            private boolean mHierarchical;
            private int mImportantForAccessibilityItemCount;
            private int mItemCount;
            private int mRowCount;
            private int mSelectionMode;

            public Builder() {
                super();
                this.mRowCount = 0;
                this.mColumnCount = 0;
                this.mHierarchical = false;
                this.mItemCount = -1;
                this.mImportantForAccessibilityItemCount = -1;
            }

            public CollectionInfoCompat build() {
                int v0 = Build$VERSION.SDK_INT;
                int v1 = this.mRowCount;
                if(v0 >= 35) {
                    return Api35Impl.buildCollectionInfoCompat(v1, this.mColumnCount, this.mHierarchical, this.mSelectionMode, this.mItemCount, this.mImportantForAccessibilityItemCount);
                }

                return CollectionInfoCompat.obtain(v1, this.mColumnCount, this.mHierarchical, this.mSelectionMode);
            }

            public Builder setColumnCount(int arg1) {
                this.mColumnCount = arg1;
                return this;
            }

            public Builder setHierarchical(boolean arg1) {
                this.mHierarchical = arg1;
                return this;
            }

            public Builder setImportantForAccessibilityItemCount(int arg1) {
                this.mImportantForAccessibilityItemCount = arg1;
                return this;
            }

            public Builder setItemCount(int arg1) {
                this.mItemCount = arg1;
                return this;
            }

            public Builder setRowCount(int arg1) {
                this.mRowCount = arg1;
                return this;
            }

            public Builder setSelectionMode(int arg1) {
                this.mSelectionMode = arg1;
                return this;
            }
        }

        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        public static final int UNDEFINED = -1;
        final Object mInfo;

        CollectionInfoCompat(Object arg1) {
            super();
            this.mInfo = arg1;
        }

        public int getColumnCount() {
            return this.mInfo.getColumnCount();
        }

        public int getImportantForAccessibilityItemCount() {
            if(Build$VERSION.SDK_INT >= 35) {
                return Api35Impl.getImportantForAccessibilityItemCount(this.mInfo);
            }

            return -1;
        }

        public int getItemCount() {
            if(Build$VERSION.SDK_INT >= 35) {
                return Api35Impl.getItemCount(this.mInfo);
            }

            return -1;
        }

        public int getRowCount() {
            return this.mInfo.getRowCount();
        }

        public int getSelectionMode() {
            return this.mInfo.getSelectionMode();
        }

        public boolean isHierarchical() {
            return this.mInfo.isHierarchical();
        }

        public static CollectionInfoCompat obtain(int arg1, int arg2, boolean arg3, int arg4) {
            return new CollectionInfoCompat(AccessibilityNodeInfo$CollectionInfo.obtain(arg1, arg2, arg3, arg4));
        }

        public static CollectionInfoCompat obtain(int arg1, int arg2, boolean arg3) {
            return new CollectionInfoCompat(AccessibilityNodeInfo$CollectionInfo.obtain(arg1, arg2, arg3));
        }
    }

    public class CollectionItemInfoCompat {
        public final class androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder {
            private int mColumnIndex;
            private int mColumnSpan;
            private String mColumnTitle;
            private boolean mHeading;
            private int mRowIndex;
            private int mRowSpan;
            private String mRowTitle;
            private boolean mSelected;
            private int mSortDirection;

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder() {
                super();
            }

            public CollectionItemInfoCompat build() {
                if(BuildCompat.isAtLeastB_1()) {
                    return Api36MinorImpl.buildCollectionItemInfoCompat(this.mHeading, this.mColumnIndex, this.mRowIndex, this.mColumnSpan, this.mRowSpan, this.mSelected, this.mRowTitle, this.mColumnTitle, this.mSortDirection);
                }

                if(Build$VERSION.SDK_INT >= 33) {
                    return Api33Impl.buildCollectionItemInfoCompat(this.mHeading, this.mColumnIndex, this.mRowIndex, this.mColumnSpan, this.mRowSpan, this.mSelected, this.mRowTitle, this.mColumnTitle);
                }

                return new CollectionItemInfoCompat(AccessibilityNodeInfo$CollectionItemInfo.obtain(this.mRowIndex, this.mRowSpan, this.mColumnIndex, this.mColumnSpan, this.mHeading, this.mSelected));
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setColumnIndex(int arg1) {
                this.mColumnIndex = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setColumnSpan(int arg1) {
                this.mColumnSpan = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setColumnTitle(String arg1) {
                this.mColumnTitle = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setHeading(boolean arg1) {
                this.mHeading = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setRowIndex(int arg1) {
                this.mRowIndex = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setRowSpan(int arg1) {
                this.mRowSpan = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setRowTitle(String arg1) {
                this.mRowTitle = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setSelected(boolean arg1) {
                this.mSelected = arg1;
                return this;
            }

            public androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat$Builder setSortDirection(int arg1) {
                this.mSortDirection = arg1;
                return this;
            }
        }

        @Retention(value=RetentionPolicy.SOURCE) @public interface SortDirection {
        }

        public static final int SORT_DIRECTION_ASCENDING = 1;
        public static final int SORT_DIRECTION_DESCENDING = 2;
        public static final int SORT_DIRECTION_NONE = 0;
        public static final int SORT_DIRECTION_OTHER = 3;
        final Object mInfo;

        CollectionItemInfoCompat(Object arg1) {
            super();
            this.mInfo = arg1;
        }

        public int getColumnIndex() {
            return this.mInfo.getColumnIndex();
        }

        public int getColumnSpan() {
            return this.mInfo.getColumnSpan();
        }

        public String getColumnTitle() {
            if(Build$VERSION.SDK_INT >= 33) {
                return Api33Impl.getCollectionItemColumnTitle(this.mInfo);
            }

            return null;
        }

        public int getRowIndex() {
            return this.mInfo.getRowIndex();
        }

        public int getRowSpan() {
            return this.mInfo.getRowSpan();
        }

        public String getRowTitle() {
            if(Build$VERSION.SDK_INT >= 33) {
                return Api33Impl.getCollectionItemRowTitle(this.mInfo);
            }

            return null;
        }

        public int getSortDirection() {
            if(BuildCompat.isAtLeastB_1()) {
                return Api36MinorImpl.getCollectionItemSortDirection(this.mInfo);
            }

            return 0;
        }

        @Deprecated public boolean isHeading() {
            return this.mInfo.isHeading();
        }

        public boolean isSelected() {
            return this.mInfo.isSelected();
        }

        public static CollectionItemInfoCompat obtain(int arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo$CollectionItemInfo.obtain(arg1, arg2, arg3, arg4, arg5, arg6));
        }

        public static CollectionItemInfoCompat obtain(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo$CollectionItemInfo.obtain(arg1, arg2, arg3, arg4, arg5));
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ExpandedState {
    }

    public class MathInfoCompat extends StructuredDataInfoCompat {
        @Retention(value=RetentionPolicy.SOURCE) @public interface MathAttribute {
        }

        @Retention(value=RetentionPolicy.SOURCE) @public interface MathTag {
        }

        public static final String MATH_ATTRIBUTE_ARG = "arg";
        public static final String MATH_ATTRIBUTE_INTENT = "intent";
        public static final String MATH_TAG_FRACTION = "mfrac";
        public static final String MATH_TAG_IDENTIFIER = "mi";
        public static final String MATH_TAG_MATH = "math";
        public static final String MATH_TAG_MULTISCRIPTS = "mmultiscripts";
        public static final String MATH_TAG_NONE_SCRIPT = "none";
        public static final String MATH_TAG_NUMBER = "mn";
        public static final String MATH_TAG_OPERATOR = "mo";
        public static final String MATH_TAG_OVER = "mover";
        public static final String MATH_TAG_PRESCRIPT_DELIMITER = "mprescripts";
        public static final String MATH_TAG_ROOT = "mroot";
        public static final String MATH_TAG_ROW = "mrow";
        public static final String MATH_TAG_SQUARE_ROOT = "msqrt";
        public static final String MATH_TAG_STRING_LITERAL = "ms";
        public static final String MATH_TAG_SUB = "msub";
        public static final String MATH_TAG_SUB_SUP = "msubsup";
        public static final String MATH_TAG_SUP = "msup";
        public static final String MATH_TAG_TABLE = "mtable";
        public static final String MATH_TAG_TABLE_CELL = "mtd";
        public static final String MATH_TAG_TABLE_ROW = "mtr";
        public static final String MATH_TAG_TEXT = "mtext";
        public static final String MATH_TAG_UNDER = "munder";
        public static final String MATH_TAG_UNDER_OVER = "munderover";

        public MathInfoCompat(AccessibilityNodeInfo$MathInfo arg3) {
            AccessibilityNodeInfo$StructuredDataInfo v3;
            if(Build$VERSION.SDK_INT >= 37) {
            }
            else {
                v3 = null;
            }

            super(v3);
        }

        public MathInfoCompat(String arg3) {
            AccessibilityNodeInfo$StructuredDataInfo v3_1;
            if(Build$VERSION.SDK_INT >= 37) {
                AccessibilityNodeInfo$MathInfo v3 = Api37Impl.createMathInfo(arg3);
            }
            else {
                v3_1 = null;
            }

            super(v3_1);
        }

        public String getAttribute(String arg1) {
            return super.getAttribute(arg1);
        }

        public String getTag() {
            return super.getTag();
        }

        public void putAttribute(String arg1, String arg2) {
            super.putAttribute(arg1, arg2);
        }

        public void removeAttribute(String arg1) {
            super.removeAttribute(arg1);
        }
    }

    public class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        RangeInfoCompat(Object arg1) {
            super();
            this.mInfo = arg1;
        }

        public RangeInfoCompat(int arg3, float arg4, float arg5, float arg6) {
            super();
            if(Build$VERSION.SDK_INT >= 30) {
                this.mInfo = Api30Impl.createRangeInfo(arg3, arg4, arg5, arg6);
                return;
            }

            this.mInfo = AccessibilityNodeInfo$RangeInfo.obtain(arg3, arg4, arg5, arg6);
        }

        public float getCurrent() {
            return this.mInfo.getCurrent();
        }

        public float getMax() {
            return this.mInfo.getMax();
        }

        public float getMin() {
            return this.mInfo.getMin();
        }

        public int getType() {
            return this.mInfo.getType();
        }

        public static RangeInfoCompat obtain(int arg1, float arg2, float arg3, float arg4) {
            return new RangeInfoCompat(AccessibilityNodeInfo$RangeInfo.obtain(arg1, arg2, arg3, arg4));
        }
    }

    public final class SelectionCompat {
        final AccessibilityNodeInfo$Selection mSelection;

        public SelectionCompat(AccessibilityNodeInfo$Selection arg2) {
            super();
            if(BuildCompat.isAtLeastB_1()) {
                this.mSelection = arg2;
                return;
            }

            this.mSelection = null;
        }

        public SelectionCompat(SelectionPositionCompat arg2, SelectionPositionCompat arg3) {
            super();
            if(BuildCompat.isAtLeastB_1()) {
                this.mSelection = new AccessibilityNodeInfo$Selection(arg2.mPosition, arg3.mPosition);
                return;
            }

            this.mSelection = null;
        }

        public boolean equals(Object arg3) {
            if(BuildCompat.isAtLeastB_1()) {
                if(!(arg3 instanceof SelectionCompat)) {
                    return 0;
                }

                AccessibilityNodeInfo$Selection v2 = this.mSelection;
                if(v2 != null) {
                    return v2.equals(((SelectionCompat)arg3).mSelection);
                }

                return 0;
            }

            if(this == (((SelectionCompat)arg3))) {
                return 1;
            }

            return 0;
        }

        public SelectionPositionCompat getEnd() {
            if(BuildCompat.isAtLeastB_1()) {
                return new SelectionPositionCompat(this.mSelection.getEnd());
            }

            return null;
        }

        public SelectionPositionCompat getStart() {
            if(BuildCompat.isAtLeastB_1()) {
                return new SelectionPositionCompat(this.mSelection.getStart());
            }

            return null;
        }

        public int hashCode() {
            if(BuildCompat.isAtLeastB_1()) {
                AccessibilityNodeInfo$Selection v2 = this.mSelection;
                if(v2 != null) {
                    return v2.hashCode();
                }
            }

            return 0;
        }

        public AccessibilityNodeInfo$Selection unwrap() {
            return this.mSelection;
        }
    }

    public final class SelectionPositionCompat {
        final AccessibilityNodeInfo$SelectionPosition mPosition;

        public SelectionPositionCompat(AccessibilityNodeInfo$SelectionPosition arg2) {
            super();
            if(BuildCompat.isAtLeastB_1()) {
                this.mPosition = arg2;
                return;
            }

            this.mPosition = null;
        }

        public SelectionPositionCompat(View arg2, int arg3) {
            super();
            if(BuildCompat.isAtLeastB_1()) {
                this.mPosition = new AccessibilityNodeInfo$SelectionPosition(arg2, arg3);
                return;
            }

            this.mPosition = null;
        }

        public SelectionPositionCompat(View arg2, int arg3, int arg4) {
            super();
            if(BuildCompat.isAtLeastB_1()) {
                this.mPosition = new AccessibilityNodeInfo$SelectionPosition(arg2, arg3, arg4);
                return;
            }

            this.mPosition = null;
        }

        public SelectionPositionCompat(AccessibilityNodeInfoCompat arg2, int arg3) {
            super();
            if(BuildCompat.isAtLeastB_1()) {
                this.mPosition = new AccessibilityNodeInfo$SelectionPosition(arg2.unwrap(), arg3);
                return;
            }

            this.mPosition = null;
        }

        public boolean equals(Object arg3) {
            if(BuildCompat.isAtLeastB_1()) {
                if(!(arg3 instanceof SelectionPositionCompat)) {
                    return 0;
                }

                AccessibilityNodeInfo$SelectionPosition v2 = this.mPosition;
                if(v2 != null) {
                    return v2.equals(((SelectionPositionCompat)arg3).mPosition);
                }

                return 0;
            }

            if(this == (((SelectionPositionCompat)arg3))) {
                return 1;
            }

            return 0;
        }

        public AccessibilityNodeInfoCompat getNode() {
            if(BuildCompat.isAtLeastB_1()) {
                return AccessibilityNodeInfoCompat.wrap(this.mPosition.getNode());
            }

            return null;
        }

        public int getOffset() {
            if(BuildCompat.isAtLeastB_1()) {
                return this.mPosition.getOffset();
            }

            return -1;
        }

        public View getView() {
            if(Build$VERSION.SDK_INT >= 37) {
                return Api37Impl.getView(this.mPosition);
            }

            return null;
        }

        public int getVirtualDescendantId() {
            if(Build$VERSION.SDK_INT >= 37) {
                return Api37Impl.getVirtualDescendantId(this.mPosition);
            }

            return -1;
        }

        public int hashCode() {
            if(BuildCompat.isAtLeastB_1()) {
                AccessibilityNodeInfo$SelectionPosition v2 = this.mPosition;
                if(v2 != null) {
                    return v2.hashCode();
                }
            }

            return 0;
        }
    }

    public abstract class StructuredDataInfoCompat {
        final AccessibilityNodeInfo$StructuredDataInfo mStructuredDataInfo;

        protected StructuredDataInfoCompat(AccessibilityNodeInfo$StructuredDataInfo arg1) {
            super();
            this.mStructuredDataInfo = arg1;
        }

        public boolean equals(Object arg3) {
            if(Build$VERSION.SDK_INT >= 37 && ((arg3 instanceof StructuredDataInfoCompat))) {
                return Api37Impl.structuredDataInfoEquals(this.mStructuredDataInfo, ((StructuredDataInfoCompat)arg3).mStructuredDataInfo);
            }

            if(this == (((StructuredDataInfoCompat)arg3))) {
                return 1;
            }

            return 0;
        }

        public String getAttribute(String arg3) {
            if(Build$VERSION.SDK_INT >= 37) {
                return Api37Impl.getStructuredDataInfoAttribute(this.mStructuredDataInfo, arg3);
            }

            return null;
        }

        public Map getAttributes() {
            if(Build$VERSION.SDK_INT >= 37) {
                return Api37Impl.getStructuredDataInfoAttributes(this.mStructuredDataInfo);
            }

            return Collections.emptyMap();
        }

        public String getTag() {
            if(Build$VERSION.SDK_INT >= 37) {
                return Api37Impl.getStructuredDataInfoTag(this.mStructuredDataInfo);
            }

            return null;
        }

        public int hashCode() {
            if(Build$VERSION.SDK_INT >= 37) {
                return Api37Impl.structuredDataInfoHashCode(this.mStructuredDataInfo);
            }

            return 0;
        }

        public void putAttribute(String arg3, String arg4) {
            if(Build$VERSION.SDK_INT >= 37) {
                Api37Impl.putStructuredDataInfoAttribute(this.mStructuredDataInfo, arg3, arg4);
            }
        }

        public void removeAttribute(String arg3) {
            if(Build$VERSION.SDK_INT >= 37) {
                Api37Impl.removeStructuredDataInfoAttribute(this.mStructuredDataInfo, arg3);
            }
        }
    }

    public final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo$TouchDelegateInfo mInfo;

        TouchDelegateInfoCompat(AccessibilityNodeInfo$TouchDelegateInfo arg1) {
            super();
            this.mInfo = arg1;
        }

        public TouchDelegateInfoCompat(Map arg3) {
            super();
            if(Build$VERSION.SDK_INT >= 29) {
                this.mInfo = new AccessibilityNodeInfo$TouchDelegateInfo(arg3);
                return;
            }

            this.mInfo = null;
        }

        public Region getRegionAt(int arg3) {
            if(Build$VERSION.SDK_INT >= 29) {
                return this.mInfo.getRegionAt(arg3);
            }

            return null;
        }

        public int getRegionCount() {
            if(Build$VERSION.SDK_INT >= 29) {
                return this.mInfo.getRegionCount();
            }

            return 0;
        }

        public AccessibilityNodeInfoCompat getTargetForRegion(Region arg3) {
            if(Build$VERSION.SDK_INT >= 29) {
                AccessibilityNodeInfo v2 = this.mInfo.getTargetForRegion(arg3);
                if(v2 != null) {
                    return AccessibilityNodeInfoCompat.wrap(v2);
                }
            }

            return null;
        }
    }

    public static final int ACTION_ACCESSIBILITY_FOCUS = 0x40;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_DIRECTION_INT = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_PARCELABLE = "android.view.accessibility.action.ARGUMENT_SELECTION_PARCELABLE";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 0x80;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 0x80000;
    public static final int ACTION_COPY = 0x4000;
    public static final int ACTION_CUT = 0x10000;
    public static final int ACTION_DISMISS = 0x100000;
    public static final int ACTION_EXPAND = 0x40000;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 0x20;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 0x100;
    public static final int ACTION_NEXT_HTML_ELEMENT = 0x400;
    public static final int ACTION_PASTE = 0x8000;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 0x200;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 0x800;
    public static final int ACTION_SCROLL_BACKWARD = 0x2000;
    public static final int ACTION_SCROLL_FORWARD = 0x1000;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 0x20000;
    public static final int ACTION_SET_TEXT = 0x200000;
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_DATA_SENSITIVE = 0x40;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 0x20;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    private static final int BOOLEAN_PROPERTY_SUPPORTS_GRANULAR_SCROLLING = 0x4000000;
    private static final int BOOLEAN_PROPERTY_TEXT_SELECTABLE = 0x800000;
    private static final String BOUNDS_IN_WINDOW_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY";
    private static final String CHECKED_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CHECKED_KEY";
    public static final int CHECKED_STATE_FALSE = 0;
    public static final int CHECKED_STATE_PARTIAL = 2;
    public static final int CHECKED_STATE_TRUE = 1;
    private static final String CONTAINER_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY";
    public static final int EXPANDED_STATE_COLLAPSED = 1;
    public static final int EXPANDED_STATE_FULL = 3;
    private static final String EXPANDED_STATE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.EXPANDED_STATE_KEY";
    public static final int EXPANDED_STATE_PARTIAL = 2;
    public static final int EXPANDED_STATE_UNDEFINED = 0;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_IN_WINDOW_KEY = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_IN_WINDOW_KEY";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FLAG_PREFETCH_ANCESTORS = 1;
    public static final int FLAG_PREFETCH_DESCENDANTS_BREADTH_FIRST = 16;
    public static final int FLAG_PREFETCH_DESCENDANTS_DEPTH_FIRST = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS_HYBRID = 4;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_PREFETCH_UNINTERRUPTIBLE = 0x20;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    private static final String IS_REQUIRED_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY";
    public static final int MAX_NUMBER_OF_PREFETCHED_NODES = 50;
    private static final String MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String SUPPLEMENTAL_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SUPPLEMENTAL_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId;
    private int mVirtualDescendantId;
    private static int sClickableSpanId;

    static {
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo arg2) {
        super();
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = arg2;
    }

    @Deprecated public AccessibilityNodeInfoCompat(Object arg2) {
        super();
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = ((AccessibilityNodeInfo)arg2);
    }

    public void addAction(int arg1) {
        this.mInfo.addAction(arg1);
    }

    public void addAction(AccessibilityActionCompat arg1) {
        this.mInfo.addAction(arg1.mAction);
    }

    public void addChild(View arg1) {
        this.mInfo.addChild(arg1);
    }

    public void addChild(View arg1, int arg2) {
        this.mInfo.addChild(arg1, arg2);
    }

    public void addLabeledBy(View arg2) {
        this.addLabeledBy(arg2, -1);
    }

    public void addLabeledBy(View arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 36) {
            Api36Impl.-$$Nest$smaddLabeledBy(this.mInfo, arg3, arg4);
            return;
        }

        this.setLabeledBy(arg3, arg4);
    }

    private void addSpanLocationToExtras(ClickableSpan arg3, Spanned arg4, int arg5) {
        this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(arg4.getSpanStart(arg3)));
        this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(arg4.getSpanEnd(arg3)));
        this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(arg4.getSpanFlags(arg3)));
        this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(arg5));
    }

    public void addSpansToExtras(CharSequence arg1, View arg2) {
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public boolean equals(Object arg5) {
        if(this == (((AccessibilityNodeInfoCompat)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(!(arg5 instanceof AccessibilityNodeInfoCompat)) {
            return 0;
        }

        AccessibilityNodeInfo v2 = this.mInfo;
        if(v2 == null) {
            if(((AccessibilityNodeInfoCompat)arg5).mInfo != null) {
                return 0;
            }
        }
        else if(!v2.equals(((AccessibilityNodeInfoCompat)arg5).mInfo)) {
            return 0;
        }

        if(this.mVirtualDescendantId != ((AccessibilityNodeInfoCompat)arg5).mVirtualDescendantId) {
            return 0;
        }

        if(this.mParentVirtualDescendantId != ((AccessibilityNodeInfoCompat)arg5).mParentVirtualDescendantId) {
            return 0;
        }

        return 1;
    }

    private List extrasIntList(String arg2) {
        ArrayList v0 = this.mInfo.getExtras().getIntegerArrayList(arg2);
        if(v0 == null) {
            v0 = new ArrayList();
            this.mInfo.getExtras().putIntegerArrayList(arg2, v0);
        }

        return ((List)v0);
    }

    public List findAccessibilityNodeInfosByText(String arg4) {
        ArrayList v0 = new ArrayList();
        List v3 = this.mInfo.findAccessibilityNodeInfosByText(arg4);
        int v4 = v3.size();
        int v1;
        for(v1 = 0; v1 < v4; ++v1) {
            ((List)v0).add(AccessibilityNodeInfoCompat.wrap(v3.get(v1)));
        }

        return ((List)v0);
    }

    public List findAccessibilityNodeInfosByViewId(String arg2) {
        List v1 = this.mInfo.findAccessibilityNodeInfosByViewId(arg2);
        ArrayList v2 = new ArrayList();
        Iterator v1_1 = v1.iterator();
        while(v1_1.hasNext()) {
            ((List)v2).add(AccessibilityNodeInfoCompat.wrap(v1_1.next()));
        }

        return ((List)v2);
    }

    public AccessibilityNodeInfoCompat findFocus(int arg1) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.findFocus(arg1));
    }

    public AccessibilityNodeInfoCompat focusSearch(int arg1) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.focusSearch(arg1));
    }

    public List getActionList() {
        List v5 = this.mInfo.getActionList();
        ArrayList v0 = new ArrayList();
        int v1 = v5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            ((List)v0).add(new AccessibilityActionCompat(v5.get(v2)));
        }

        return ((List)v0);
    }

    static String getActionSymbolicName(int arg1) {
        if(arg1 == 1) {
            return "ACTION_FOCUS";
        }

        if(arg1 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }

        switch(arg1) {
            case 4: {
                return "ACTION_SELECT";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 131072: {
                return "ACTION_SET_SELECTION";
            }
            case 262144: {
                return "ACTION_EXPAND";
            }
            case 524288: {
                return "ACTION_COLLAPSE";
            }
            case 2097152: {
                return "ACTION_SET_TEXT";
            }
            case 16908354: {
                return "ACTION_MOVE_WINDOW";
            }
        }

        switch(arg1) {
            case 16908342: {
                return "ACTION_SHOW_ON_SCREEN";
            }
            case 16908343: {
                return "ACTION_SCROLL_TO_POSITION";
            }
            case 16908344: {
                return "ACTION_SCROLL_UP";
            }
            case 16908345: {
                return "ACTION_SCROLL_LEFT";
            }
            case 16908346: {
                return "ACTION_SCROLL_DOWN";
            }
            case 16908347: {
                return "ACTION_SCROLL_RIGHT";
            }
            case 16908348: {
                return "ACTION_CONTEXT_CLICK";
            }
            case 16908349: {
                return "ACTION_SET_PROGRESS";
            }
        }

        switch(arg1) {
            case 16908356: {
                return "ACTION_SHOW_TOOLTIP";
            }
            case 16908357: {
                return "ACTION_HIDE_TOOLTIP";
            }
            case 16908358: {
                return "ACTION_PAGE_UP";
            }
            case 16908359: {
                return "ACTION_PAGE_DOWN";
            }
            case 16908360: {
                return "ACTION_PAGE_LEFT";
            }
            case 16908361: {
                return "ACTION_PAGE_RIGHT";
            }
            case 16908362: {
                return "ACTION_PRESS_AND_HOLD";
            }
        }

        switch(arg1) {
            case 16908372: {
                return "ACTION_IME_ENTER";
            }
            case 16908373: {
                return "ACTION_DRAG_START";
            }
            case 16908374: {
                return "ACTION_DRAG_DROP";
            }
            case 16908375: {
                return "ACTION_DRAG_CANCEL";
            }
        }

        switch(arg1) {
            case 16908382: {
                return "ACTION_SCROLL_IN_DIRECTION";
            }
            case 16908383: {
                return "ACTION_SET_EXTENDED_SELECTION";
            }
        }

        return "ACTION_UNKNOWN";
    }

    @Deprecated public int getActions() {
        return this.mInfo.getActions();
    }

    public List getAvailableExtraData() {
        return this.mInfo.getAvailableExtraData();
    }

    private boolean getBooleanProperty(int arg3) {
        Bundle v2 = this.getExtras();
        if(v2 == null) {
            return 0;
        }

        if((v2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & arg3) == arg3) {
            return 1;
        }

        return 0;
    }

    @Deprecated public void getBoundsInParent(Rect arg1) {
        this.mInfo.getBoundsInParent(arg1);
    }

    public void getBoundsInScreen(Rect arg1) {
        this.mInfo.getBoundsInScreen(arg1);
    }

    public void getBoundsInWindow(Rect arg4) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v3 = this.mInfo;
        if(v0 >= 34) {
            Api34Impl.getBoundsInWindow(v3, arg4);
            return;
        }

        Parcelable v3_1 = v3.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if(v3_1 != null) {
            arg4.set(((Rect)v3_1).left, ((Rect)v3_1).top, ((Rect)v3_1).right, ((Rect)v3_1).bottom);
        }
    }

    public int getChecked() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v1 = this.mInfo;
        if(v0 >= 36) {
            return Api36Impl.-$$Nest$smgetChecked(v1);
        }

        return v1.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.CHECKED_KEY", this.mInfo.isChecked());
    }

    private String getCheckedString() {
        int v1 = this.getChecked();
        if(v1 == 1) {
            return "TRUE";
        }

        if(v1 == 2) {
            return "PARTIAL";
        }

        return "FALSE";
    }

    public AccessibilityNodeInfoCompat getChild(int arg1) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getChild(arg1));
    }

    public AccessibilityNodeInfoCompat getChild(int arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getChild(this.mInfo, arg3, arg4);
        }

        return this.getChild(arg3);
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public static ClickableSpan[] getClickableSpans(CharSequence arg3) {
        if((arg3 instanceof Spanned)) {
            return arg3.getSpans(0, arg3.length(), ClickableSpan.class);
        }

        return null;
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo$CollectionInfo v1 = this.mInfo.getCollectionInfo();
        if(v1 != null) {
            return new CollectionInfoCompat(v1);
        }

        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo$CollectionItemInfo v1 = this.mInfo.getCollectionItemInfo();
        if(v1 != null) {
            return new CollectionItemInfoCompat(v1);
        }

        return null;
    }

    public CharSequence getContainerTitle() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 34) {
            return Api34Impl.getContainerTitle(v2);
        }

        return v2.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        return this.mInfo.getDrawingOrder();
    }

    public CharSequence getError() {
        return this.mInfo.getError();
    }

    public int getExpandedState() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 36) {
            return Api36Impl.getExpandedState(v2);
        }

        return v2.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.EXPANDED_STATE_KEY", 0);
    }

    static String getExpandedStateSymbolicName(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        return "UNKNOWN";
                    }

                    return "FULL";
                }

                return "PARTIAL";
            }

            return "COLLAPSED";
        }

        return "UNDEFINED";
    }

    public AccessibilityNodeInfo$ExtraRenderingInfo getExtraRenderingInfo() {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getExtraRenderingInfo(this.mInfo);
        }

        return null;
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    public CharSequence getHintText() {
        return this.mInfo.getHintText();
    }

    @Deprecated public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    @Deprecated public AccessibilityNodeInfoCompat getLabeledBy() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public List getLabeledByList() {
        if(Build$VERSION.SDK_INT >= 36) {
            return Api36Impl.-$$Nest$smgetLabeledByList(this.mInfo);
        }

        ArrayList v0 = new ArrayList(1);
        this = this.getLabeledBy();
        if(this != null) {
            ((List)v0).add(this);
        }

        return ((List)v0);
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 34) {
            return Api34Impl.getMinDurationBetweenContentChangeMillis(v2);
        }

        return v2.getExtras().getLong("androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY");
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    private SparseArray getOrCreateSpansFromViewTags(View arg2) {
        SparseArray v1 = this.getSpansFromViewTags(arg2);
        if(v1 == null) {
            v1 = new SparseArray();
            arg2.setTag(id.tag_accessibility_clickable_spans, v1);
        }

        return v1;
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    public CharSequence getPaneTitle() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 28) {
            return v2.getPaneTitle();
        }

        return v2.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY");
    }

    public AccessibilityNodeInfoCompat getParent() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getParent());
    }

    public AccessibilityNodeInfoCompat getParent(int arg3) {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getParent(this.mInfo, arg3);
        }

        return this.getParent();
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo$RangeInfo v1 = this.mInfo.getRangeInfo();
        if(v1 != null) {
            return new RangeInfoCompat(v1);
        }

        return null;
    }

    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence("AccessibilityNodeInfo.roleDescription");
    }

    public SelectionCompat getSelection() {
        if(BuildCompat.isAtLeastB_1()) {
            AccessibilityNodeInfo$Selection v1 = this.mInfo.getSelection();
            if(v1 != null) {
                return new SelectionCompat(v1);
            }
        }

        return null;
    }

    private SparseArray getSpansFromViewTags(View arg1) {
        return arg1.getTag(id.tag_accessibility_clickable_spans);
    }

    public CharSequence getStateDescription() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 30) {
            return Api30Impl.getStateDescription(v2);
        }

        return v2.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public StructuredDataInfoCompat getStructuredDataInfo() {
        StructuredDataInfoCompat v2 = null;
        if(Build$VERSION.SDK_INT >= 37) {
            AccessibilityNodeInfo$StructuredDataInfo v3 = Api37Impl.getStructuredDataInfo(this.mInfo);
            if(v3 == null) {
                return v2;
            }
            else if((v3 instanceof AccessibilityNodeInfo$MathInfo)) {
                return new MathInfoCompat(((AccessibilityNodeInfo$MathInfo)v3));
            }
        }

        return v2;
    }

    public CharSequence getSupplementalDescription() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 36) {
            return Api36Impl.getSupplementalDescription(v2);
        }

        return v2.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.SUPPLEMENTAL_DESCRIPTION_KEY");
    }

    public CharSequence getText() {
        if(this.hasSpans()) {
            List v0 = this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List v1 = this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List v2 = this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List v3 = this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            int v7 = 0;
            SpannableString v4 = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
            while(v7 < v0.size()) {
                ((Spannable)v4).setSpan(new AccessibilityClickableSpanCompat(v3.get(v7).intValue(), this, this.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), v0.get(v7).intValue(), v1.get(v7).intValue(), v2.get(v7).intValue());
                ++v7;
            }

            return ((CharSequence)v4);
        }

        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    public CharSequence getTooltipText() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 28) {
            return v2.getTooltipText();
        }

        return v2.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        if(Build$VERSION.SDK_INT >= 29) {
            AccessibilityNodeInfo$TouchDelegateInfo v2 = this.mInfo.getTouchDelegateInfo();
            if(v2 != null) {
                return new TouchDelegateInfoCompat(v2);
            }
        }

        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    public String getUniqueId() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 33) {
            return Api33Impl.getUniqueId(v2);
        }

        return v2.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public boolean hasRequestInitialAccessibilityFocus() {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.hasRequestInitialAccessibilityFocus(this.mInfo);
        }

        return this.getBooleanProperty(0x20);
    }

    private boolean hasSpans() {
        return this.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty() ^ 1;
    }

    public int hashCode() {
        AccessibilityNodeInfo v0 = this.mInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.hashCode();
    }

    private int idForClickableSpan(ClickableSpan arg2, SparseArray arg3) {
        int v1;
        if(arg3 != null) {
            v1 = 0;
            while(v1 < arg3.size()) {
                if(arg2.equals(arg3.valueAt(v1).get())) {
                    return arg3.keyAt(v1);
                }
                else {
                    ++v1;
                    continue;
                }

                break;
            }
        }

        v1 = AccessibilityNodeInfoCompat.sClickableSpanId;
        AccessibilityNodeInfoCompat.sClickableSpanId = v1 + 1;
        return v1;
    }

    public boolean isAccessibilityDataSensitive() {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.isAccessibilityDataSensitive(this.mInfo);
        }

        return this.getBooleanProperty(0x40);
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    @Deprecated public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFieldRequired() {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 36) {
            return Api36Impl.isFieldRequired(v2);
        }

        return v2.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY");
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isGranularScrollingSupported() {
        return this.getBooleanProperty(0x4000000);
    }

    public boolean isHeading() {
        if(Build$VERSION.SDK_INT >= 28) {
            return this.mInfo.isHeading();
        }

        if(this.getBooleanProperty(2)) {
            return 1;
        }

        CollectionItemInfoCompat v2 = this.getCollectionItemInfo();
        if(v2 != null && (v2.isHeading())) {
            return 1;
        }

        return 0;
    }

    public boolean isImportantForAccessibility() {
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        if(Build$VERSION.SDK_INT >= 28) {
            return this.mInfo.isScreenReaderFocusable();
        }

        return this.getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        return this.mInfo.isShowingHintText();
    }

    public boolean isTextEntryKey() {
        if(Build$VERSION.SDK_INT >= 29) {
            return this.mInfo.isTextEntryKey();
        }

        return this.getBooleanProperty(8);
    }

    public boolean isTextSelectable() {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.isTextSelectable(this.mInfo);
        }

        return this.getBooleanProperty(0x800000);
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(View arg0) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain(arg0));
    }

    public static AccessibilityNodeInfoCompat obtain(View arg0, int arg1) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfo.obtain(arg0, arg1));
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat arg0) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain(arg0.mInfo));
    }

    public boolean performAction(int arg1, Bundle arg2) {
        return this.mInfo.performAction(arg1, arg2);
    }

    public boolean performAction(int arg1) {
        return this.mInfo.performAction(arg1);
    }

    @Deprecated public void recycle() {
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat arg1) {
        return this.mInfo.removeAction(arg1.mAction);
    }

    public boolean removeChild(View arg1) {
        return this.mInfo.removeChild(arg1);
    }

    public boolean removeChild(View arg1, int arg2) {
        return this.mInfo.removeChild(arg1, arg2);
    }

    private void removeCollectedSpans(View arg4) {
        SparseArray v3 = this.getSpansFromViewTags(arg4);
        if(v3 != null) {
            ArrayList v4 = new ArrayList();
            int v0 = 0;
            int v1;
            for(v1 = 0; v1 < v3.size(); ++v1) {
                if(v3.valueAt(v1).get() == null) {
                    ((List)v4).add(Integer.valueOf(v1));
                }
            }

            while(v0 < ((List)v4).size()) {
                v3.remove(((List)v4).get(v0).intValue());
                ++v0;
            }
        }
    }

    public boolean removeLabeledBy(View arg2) {
        return this.removeLabeledBy(arg2, -1);
    }

    public boolean removeLabeledBy(View arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 36) {
            return Api36Impl.-$$Nest$smremoveLabeledBy(this.mInfo, arg3, arg4);
        }

        return 0;
    }

    public void setAccessibilityDataSensitive(boolean arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setAccessibilityDataSensitive(this.mInfo, arg3);
            return;
        }

        this.setBooleanProperty(0x40, arg3);
    }

    public void setAccessibilityFocused(boolean arg1) {
        this.mInfo.setAccessibilityFocused(arg1);
    }

    public void setAvailableExtraData(List arg1) {
        this.mInfo.setAvailableExtraData(arg1);
    }

    private void setBooleanProperty(int arg5, boolean arg6) {
        Bundle v4 = this.getExtras();
        if(v4 != null) {
            v4.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0 | v4.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & ~arg5);
        }
    }

    @Deprecated public void setBoundsInParent(Rect arg1) {
        this.mInfo.setBoundsInParent(arg1);
    }

    public void setBoundsInScreen(Rect arg1) {
        this.mInfo.setBoundsInScreen(arg1);
    }

    public void setBoundsInWindow(Rect arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 34) {
            Api34Impl.setBoundsInWindow(v2, arg3);
            return;
        }

        v2.getExtras().putParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY", ((Parcelable)arg3));
    }

    public void setCanOpenPopup(boolean arg1) {
        this.mInfo.setCanOpenPopup(arg1);
    }

    public void setCheckable(boolean arg1) {
        this.mInfo.setCheckable(arg1);
    }

    @Deprecated public void setChecked(boolean arg1) {
        this.mInfo.setChecked(arg1);
    }

    public void setChecked(int arg3) {
        if(Build$VERSION.SDK_INT >= 36) {
            Api36Impl.-$$Nest$smsetChecked(this.mInfo, arg3);
            return;
        }

        boolean v0 = true;
        if(arg3 != 1 && arg3 != 2) {
            if(arg3 == 0) {
            }
            else {
                throw new IllegalArgumentException("Unknown checked argument: " + arg3);
            }
        }

        AccessibilityNodeInfo v1 = this.mInfo;
        if(arg3 == 1) {
        }
        else {
            v0 = false;
        }

        v1.setChecked(v0);
        this.mInfo.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.CHECKED_KEY", arg3);
    }

    public void setClassName(CharSequence arg1) {
        this.mInfo.setClassName(arg1);
    }

    public void setClickable(boolean arg1) {
        this.mInfo.setClickable(arg1);
    }

    public void setCollectionInfo(Object arg1) {
        AccessibilityNodeInfo v0 = this.mInfo;
        if(arg1 == null) {
            AccessibilityNodeInfo$CollectionInfo v1 = null;
        }
        else {
            arg1 = ((CollectionInfoCompat)arg1).mInfo;
        }

        v0.setCollectionInfo(((AccessibilityNodeInfo$CollectionInfo)arg1));
    }

    public void setCollectionItemInfo(Object arg1) {
        AccessibilityNodeInfo v0 = this.mInfo;
        if(arg1 == null) {
            AccessibilityNodeInfo$CollectionItemInfo v1 = null;
        }
        else {
            arg1 = ((CollectionItemInfoCompat)arg1).mInfo;
        }

        v0.setCollectionItemInfo(((AccessibilityNodeInfo$CollectionItemInfo)arg1));
    }

    public void setContainerTitle(CharSequence arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 34) {
            Api34Impl.setContainerTitle(v2, arg3);
            return;
        }

        v2.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY", arg3);
    }

    public void setContentDescription(CharSequence arg1) {
        this.mInfo.setContentDescription(arg1);
    }

    public void setContentInvalid(boolean arg1) {
        this.mInfo.setContentInvalid(arg1);
    }

    public void setContextClickable(boolean arg1) {
        this.mInfo.setContextClickable(arg1);
    }

    public void setDismissable(boolean arg1) {
        this.mInfo.setDismissable(arg1);
    }

    public void setDrawingOrder(int arg1) {
        this.mInfo.setDrawingOrder(arg1);
    }

    public void setEditable(boolean arg1) {
        this.mInfo.setEditable(arg1);
    }

    public void setEnabled(boolean arg1) {
        this.mInfo.setEnabled(arg1);
    }

    public void setError(CharSequence arg1) {
        this.mInfo.setError(arg1);
    }

    public void setExpandedState(int arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 36) {
            Api36Impl.setExpandedState(v2, arg3);
            return;
        }

        v2.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.EXPANDED_STATE_KEY", arg3);
    }

    public void setFieldRequired(boolean arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 36) {
            Api36Impl.setFieldRequired(v2, arg3);
            return;
        }

        v2.getExtras().putBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY", arg3);
    }

    public void setFocusable(boolean arg1) {
        this.mInfo.setFocusable(arg1);
    }

    public void setFocused(boolean arg1) {
        this.mInfo.setFocused(arg1);
    }

    public void setGranularScrollingSupported(boolean arg2) {
        this.setBooleanProperty(0x4000000, arg2);
    }

    public void setHeading(boolean arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(arg3);
            return;
        }

        this.setBooleanProperty(2, arg3);
    }

    public void setHintText(CharSequence arg1) {
        this.mInfo.setHintText(arg1);
    }

    public void setImportantForAccessibility(boolean arg1) {
        this.mInfo.setImportantForAccessibility(arg1);
    }

    public void setInputType(int arg1) {
        this.mInfo.setInputType(arg1);
    }

    public void setLabelFor(View arg1) {
        this.mInfo.setLabelFor(arg1);
    }

    public void setLabelFor(View arg1, int arg2) {
        this.mInfo.setLabelFor(arg1, arg2);
    }

    @Deprecated public void setLabeledBy(View arg1, int arg2) {
        this.mInfo.setLabeledBy(arg1, arg2);
    }

    @Deprecated public void setLabeledBy(View arg1) {
        this.mInfo.setLabeledBy(arg1);
    }

    public void setLiveRegion(int arg1) {
        this.mInfo.setLiveRegion(arg1);
    }

    public void setLongClickable(boolean arg1) {
        this.mInfo.setLongClickable(arg1);
    }

    public void setMaxTextLength(int arg1) {
        this.mInfo.setMaxTextLength(arg1);
    }

    public void setMinDurationBetweenContentChangesMillis(long arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 34) {
            Api34Impl.setMinDurationBetweenContentChangeMillis(v2, arg3);
            return;
        }

        v2.getExtras().putLong("androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY", arg3);
    }

    public void setMovementGranularities(int arg1) {
        this.mInfo.setMovementGranularities(arg1);
    }

    public void setMultiLine(boolean arg1) {
        this.mInfo.setMultiLine(arg1);
    }

    public void setPackageName(CharSequence arg1) {
        this.mInfo.setPackageName(arg1);
    }

    public void setPaneTitle(CharSequence arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 28) {
            v2.setPaneTitle(arg3);
            return;
        }

        v2.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", arg3);
    }

    public void setParent(View arg2) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(arg2);
    }

    public void setParent(View arg1, int arg2) {
        this.mParentVirtualDescendantId = arg2;
        this.mInfo.setParent(arg1, arg2);
    }

    public void setPassword(boolean arg1) {
        this.mInfo.setPassword(arg1);
    }

    public void setQueryFromAppProcessEnabled(View arg3, boolean arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setQueryFromAppProcessEnabled(this.mInfo, arg3, arg4);
        }
    }

    public void setRangeInfo(RangeInfoCompat arg1) {
        this.mInfo.setRangeInfo(arg1.mInfo);
    }

    public void setRequestInitialAccessibilityFocus(boolean arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setRequestInitialAccessibilityFocus(this.mInfo, arg3);
            return;
        }

        this.setBooleanProperty(0x20, arg3);
    }

    public void setRoleDescription(CharSequence arg2) {
        this.mInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", arg2);
    }

    public void setScreenReaderFocusable(boolean arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(arg3);
            return;
        }

        this.setBooleanProperty(1, arg3);
    }

    public void setScrollable(boolean arg1) {
        this.mInfo.setScrollable(arg1);
    }

    public void setSelected(boolean arg1) {
        this.mInfo.setSelected(arg1);
    }

    public void setSelection(SelectionCompat arg2) {
        if(BuildCompat.isAtLeastB_1()) {
            AccessibilityNodeInfo v1 = this.mInfo;
            if(arg2 == null) {
                v1.setSelection(null);
                return;
            }
            else {
                v1.setSelection(arg2.mSelection);
            }
        }
    }

    public void setShowingHintText(boolean arg1) {
        this.mInfo.setShowingHintText(arg1);
    }

    public void setSource(View arg1, int arg2) {
        this.mVirtualDescendantId = arg2;
        this.mInfo.setSource(arg1, arg2);
    }

    public void setSource(View arg2) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(arg2);
    }

    public void setStateDescription(CharSequence arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 30) {
            Api30Impl.setStateDescription(v2, arg3);
            return;
        }

        v2.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", arg3);
    }

    public void setStructuredDataInfo(StructuredDataInfoCompat arg3) {
        if(Build$VERSION.SDK_INT >= 37) {
            AccessibilityNodeInfo v2 = this.mInfo;
            AccessibilityNodeInfo$StructuredDataInfo v3 = arg3 == null ? null : arg3.mStructuredDataInfo;
            Api37Impl.setStructuredDataInfo(v2, v3);
        }
    }

    public void setSupplementalDescription(CharSequence arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 36) {
            Api36Impl.setSupplementalDescription(v2, arg3);
            return;
        }

        v2.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.SUPPLEMENTAL_DESCRIPTION_KEY", arg3);
    }

    public void setText(CharSequence arg1) {
        this.mInfo.setText(arg1);
    }

    public void setTextEntryKey(boolean arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(arg3);
            return;
        }

        this.setBooleanProperty(8, arg3);
    }

    public void setTextSelectable(boolean arg3) {
        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.setTextSelectable(this.mInfo, arg3);
            return;
        }

        this.setBooleanProperty(0x800000, arg3);
    }

    public void setTextSelection(int arg1, int arg2) {
        this.mInfo.setTextSelection(arg1, arg2);
    }

    public void setTooltipText(CharSequence arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 28) {
            v2.setTooltipText(arg3);
            return;
        }

        v2.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY", arg3);
    }

    public void setTouchDelegateInfo(TouchDelegateInfoCompat arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            this.mInfo.setTouchDelegateInfo(arg3.mInfo);
        }
    }

    public void setTraversalAfter(View arg1) {
        this.mInfo.setTraversalAfter(arg1);
    }

    public void setTraversalAfter(View arg1, int arg2) {
        this.mInfo.setTraversalAfter(arg1, arg2);
    }

    public void setTraversalBefore(View arg1) {
        this.mInfo.setTraversalBefore(arg1);
    }

    public void setTraversalBefore(View arg1, int arg2) {
        this.mInfo.setTraversalBefore(arg1, arg2);
    }

    public void setUniqueId(String arg3) {
        int v0 = Build$VERSION.SDK_INT;
        AccessibilityNodeInfo v2 = this.mInfo;
        if(v0 >= 33) {
            Api33Impl.setUniqueId(v2, arg3);
            return;
        }

        v2.getExtras().putString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY", arg3);
    }

    public void setViewIdResourceName(String arg1) {
        this.mInfo.setViewIdResourceName(arg1);
    }

    public void setVisibleToUser(boolean arg1) {
        this.mInfo.setVisibleToUser(arg1);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder();
        v0.append(super.toString());
        Rect v1 = new Rect();
        this.getBoundsInParent(v1);
        v0.append("; boundsInParent: " + v1);
        this.getBoundsInScreen(v1);
        v0.append("; boundsInScreen: " + v1);
        this.getBoundsInWindow(v1);
        v0.append("; boundsInWindow: " + v1);
        v0.append("; packageName: ").append(this.getPackageName());
        v0.append("; className: ").append(this.getClassName());
        v0.append("; text: ").append(this.getText());
        v0.append("; error: ").append(this.getError());
        v0.append("; maxTextLength: ").append(this.getMaxTextLength());
        v0.append("; stateDescription: ").append(this.getStateDescription());
        v0.append("; contentDescription: ").append(this.getContentDescription());
        v0.append("; supplementalDescription: ").append(this.getSupplementalDescription());
        v0.append("; tooltipText: ").append(this.getTooltipText());
        v0.append("; viewIdResName: ").append(this.getViewIdResourceName());
        v0.append("; uniqueId: ").append(this.getUniqueId());
        v0.append("; checkable: ").append(this.isCheckable());
        v0.append("; checked: ").append(this.getCheckedString());
        v0.append("; fieldRequired: ").append(this.isFieldRequired());
        v0.append("; focusable: ").append(this.isFocusable());
        v0.append("; focused: ").append(this.isFocused());
        v0.append("; selected: ").append(this.isSelected());
        v0.append("; clickable: ").append(this.isClickable());
        v0.append("; longClickable: ").append(this.isLongClickable());
        v0.append("; contextClickable: ").append(this.isContextClickable());
        v0.append("; expandedState: ").append(AccessibilityNodeInfoCompat.getExpandedStateSymbolicName(this.getExpandedState()));
        v0.append("; enabled: ").append(this.isEnabled());
        v0.append("; password: ").append(this.isPassword());
        v0.append("; scrollable: " + this.isScrollable());
        v0.append("; containerTitle: ").append(this.getContainerTitle());
        v0.append("; granularScrollingSupported: ").append(this.isGranularScrollingSupported());
        v0.append("; importantForAccessibility: ").append(this.isImportantForAccessibility());
        v0.append("; visible: ").append(this.isVisibleToUser());
        v0.append("; isTextSelectable: ").append(this.isTextSelectable());
        v0.append("; accessibilityDataSensitive: ").append(this.isAccessibilityDataSensitive());
        v0.append("; [");
        List v5 = this.getActionList();
        int v1_1;
        for(v1_1 = 0; v1_1 < v5.size(); ++v1_1) {
            Object v2 = v5.get(v1_1);
            String v3 = AccessibilityNodeInfoCompat.getActionSymbolicName(((AccessibilityActionCompat)v2).getId());
            if((v3.equals("ACTION_UNKNOWN")) && ((AccessibilityActionCompat)v2).getLabel() != null) {
                v3 = ((AccessibilityActionCompat)v2).getLabel().toString();
            }

            v0.append(v3);
            if(v1_1 != v5.size() - 1) {
                v0.append(", ");
            }
        }

        v0.append("]");
        return v0.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo arg1) {
        return new AccessibilityNodeInfoCompat(arg1);
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object arg1) {
        if(arg1 != null) {
            return new AccessibilityNodeInfoCompat(arg1);
        }

        return null;
    }
}


package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT;

    static {
        BadgeUtils.USE_COMPAT_PARENT = false;
    }

    private BadgeUtils() {
        super();
    }

    static void access$000(BadgeDrawable arg0, View arg1) {
        BadgeUtils.attachBadgeContentDescription(arg0, arg1);
    }

    private static void attachBadgeContentDescription(BadgeDrawable arg2, View arg3) {
        if(Build$VERSION.SDK_INT >= 29 && (ViewCompat.hasAccessibilityDelegate(arg3))) {
            ViewCompat.setAccessibilityDelegate(arg3, new AccessibilityDelegateCompat(arg3.getAccessibilityDelegate(), arg2) {
                public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                    super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                    arg2.setContentDescription(this.val$badgeDrawable.getContentDescription());
                }
            });
            return;
        }

        ViewCompat.setAccessibilityDelegate(arg3, new AccessibilityDelegateCompat(arg2) {
            public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                arg2.setContentDescription(this.val$badgeDrawable.getContentDescription());
            }
        });
    }

    public static void attachBadgeDrawable(BadgeDrawable arg1, View arg2) {
        BadgeUtils.attachBadgeDrawable(arg1, arg2, null);
    }

    public static void attachBadgeDrawable(BadgeDrawable arg0, View arg1, FrameLayout arg2) {
        BadgeUtils.setBadgeDrawableBounds(arg0, arg1, arg2);
        if(arg0.getCustomBadgeParent() != null) {
            arg0.getCustomBadgeParent().setForeground(((Drawable)arg0));
            return;
        }

        if(!BadgeUtils.USE_COMPAT_PARENT) {
            arg1.getOverlay().add(((Drawable)arg0));
            return;
        }

        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    public static void attachBadgeDrawable(BadgeDrawable arg1, Toolbar arg2, int arg3) {
        BadgeUtils.attachBadgeDrawable(arg1, arg2, arg3, null);
    }

    public static void attachBadgeDrawable(BadgeDrawable arg1, Toolbar arg2, int arg3, FrameLayout arg4) {
        arg2.post(new Runnable(arg2, arg3, arg1, arg4) {
            public void run() {
                ActionMenuItemView v0 = ToolbarUtils.getActionMenuItemView(this.val$toolbar, this.val$menuItemId);
                if(v0 != null) {
                    BadgeUtils.setToolbarOffset(this.val$badgeDrawable, this.val$toolbar.getResources());
                    BadgeUtils.attachBadgeDrawable(this.val$badgeDrawable, ((View)v0), this.val$customBadgeParent);
                    BadgeUtils.attachBadgeContentDescription(this.val$badgeDrawable, ((View)v0));
                }
            }
        });
    }

    public static SparseArray createBadgeDrawablesFromSavedStates(Context arg4, ParcelableSparseArray arg5) {
        BadgeDrawable v3_1;
        SparseArray v0 = new SparseArray(arg5.size());
        int v1;
        for(v1 = 0; v1 < arg5.size(); ++v1) {
            int v2 = arg5.keyAt(v1);
            Object v3 = arg5.valueAt(v1);
            if(v3 != null) {
                v3_1 = BadgeDrawable.createFromSavedState(arg4, ((State)v3));
            }
            else {
                v3 = null;
            }

            v0.put(v2, v3_1);
        }

        return v0;
    }

    public static ParcelableSparseArray createParcelableBadgeStates(SparseArray arg4) {
        State v3_1;
        ParcelableSparseArray v0 = new ParcelableSparseArray();
        int v1;
        for(v1 = 0; v1 < arg4.size(); ++v1) {
            int v2 = arg4.keyAt(v1);
            Object v3 = arg4.valueAt(v1);
            if(v3 != null) {
                v3_1 = ((BadgeDrawable)v3).getSavedState();
            }
            else {
                v3 = null;
            }

            v0.put(v2, v3_1);
        }

        return v0;
    }

    private static void detachBadgeContentDescription(View arg2) {
        if(Build$VERSION.SDK_INT >= 29 && (ViewCompat.hasAccessibilityDelegate(arg2))) {
            ViewCompat.setAccessibilityDelegate(arg2, new AccessibilityDelegateCompat(arg2.getAccessibilityDelegate()) {
                public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                    super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                    arg2.setContentDescription(null);
                }
            });
            return;
        }

        ViewCompat.setAccessibilityDelegate(arg2, null);
    }

    public static void detachBadgeDrawable(BadgeDrawable arg1, View arg2) {
        if(arg1 == null) {
            return;
        }

        if(!BadgeUtils.USE_COMPAT_PARENT) {
            if(arg1.getCustomBadgeParent() != null) {
            }
            else {
                arg2.getOverlay().remove(((Drawable)arg1));
                return;
            }
        }

        arg1.getCustomBadgeParent().setForeground(null);
    }

    public static void detachBadgeDrawable(BadgeDrawable arg0, Toolbar arg1, int arg2) {
        if(arg0 == null) {
            return;
        }

        ActionMenuItemView v1 = ToolbarUtils.getActionMenuItemView(arg1, arg2);
        if(v1 != null) {
            BadgeUtils.removeToolbarOffset(arg0);
            BadgeUtils.detachBadgeDrawable(arg0, ((View)v1));
            BadgeUtils.detachBadgeContentDescription(((View)v1));
            return;
        }

        Log.w("BadgeUtils", "Trying to remove badge from a null menuItemView: " + arg2);
    }

    static void removeToolbarOffset(BadgeDrawable arg1) {
        arg1.setAdditionalHorizontalOffset(0);
        arg1.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(BadgeDrawable arg1, View arg2, FrameLayout arg3) {
        Rect v0 = new Rect();
        arg2.getDrawingRect(v0);
        arg1.setBounds(v0);
        arg1.updateBadgeCoordinates(arg2, arg3);
    }

    static void setToolbarOffset(BadgeDrawable arg1, Resources arg2) {
        arg1.setAdditionalHorizontalOffset(arg2.getDimensionPixelOffset(dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        arg1.setAdditionalVerticalOffset(arg2.getDimensionPixelOffset(dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(Rect arg2, float arg3, float arg4, float arg5, float arg6) {
        arg2.set(((int)(arg3 - arg5)), ((int)(arg4 - arg6)), ((int)(arg3 + arg5)), ((int)(arg4 + arg6)));
    }
}


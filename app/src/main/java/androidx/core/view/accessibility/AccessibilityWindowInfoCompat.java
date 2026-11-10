package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build$VERSION;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;

public class AccessibilityWindowInfoCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo arg0) {
            return arg0.getAnchor();
        }

        static CharSequence getTitle(AccessibilityWindowInfo arg0) {
            return arg0.getTitle();
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static boolean isInPictureInPictureMode(AccessibilityWindowInfo arg0) {
            return arg0.isInPictureInPictureMode();
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static AccessibilityWindowInfo instantiateAccessibilityWindowInfo() {
            return new AccessibilityWindowInfo();
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static int getDisplayId(AccessibilityWindowInfo arg0) {
            return arg0.getDisplayId();
        }

        static void getRegionInScreen(AccessibilityWindowInfo arg0, Region arg1) {
            arg0.getRegionInScreen(arg1);
        }

        public static AccessibilityNodeInfoCompat getRoot(Object arg0, int arg1) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)arg0).getRoot(arg1));
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static LocaleList getLocales(AccessibilityWindowInfo arg0) {
            return arg0.getLocales();
        }

        public static long getTransitionTimeMillis(AccessibilityWindowInfo arg2) {
            return arg2.getTransitionTimeMillis();
        }
    }

    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private final AccessibilityWindowInfo mInfo;

    public AccessibilityWindowInfoCompat() {
        super();
        if(Build$VERSION.SDK_INT >= 30) {
            this.mInfo = Api30Impl.instantiateAccessibilityWindowInfo();
            return;
        }

        this.mInfo = null;
    }

    private AccessibilityWindowInfoCompat(AccessibilityWindowInfo arg1) {
        super();
        this.mInfo = arg1;
    }

    public boolean equals(Object arg4) {
        if(this == (((AccessibilityWindowInfoCompat)arg4))) {
            return 1;
        }

        if(arg4 == null) {
            return 0;
        }

        if(!(arg4 instanceof AccessibilityWindowInfoCompat)) {
            return 0;
        }

        AccessibilityWindowInfo v3 = this.mInfo;
        if(v3 == null) {
            if(((AccessibilityWindowInfoCompat)arg4).mInfo == null) {
                return 1;
            }

            return 0;
        }

        return v3.equals(((AccessibilityWindowInfoCompat)arg4).mInfo);
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor(this.mInfo));
    }

    public void getBoundsInScreen(Rect arg1) {
        this.mInfo.getBoundsInScreen(arg1);
    }

    public AccessibilityWindowInfoCompat getChild(int arg1) {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getChild(arg1));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public int getDisplayId() {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getDisplayId(this.mInfo);
        }

        return 0;
    }

    public int getId() {
        return this.mInfo.getId();
    }

    public int getLayer() {
        return this.mInfo.getLayer();
    }

    public LocaleListCompat getLocales() {
        if(Build$VERSION.SDK_INT >= 34) {
            return LocaleListCompat.wrap(Api34Impl.getLocales(this.mInfo));
        }

        return LocaleListCompat.getEmptyLocaleList();
    }

    public AccessibilityWindowInfoCompat getParent() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getParent());
    }

    public void getRegionInScreen(Region arg3) {
        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.getRegionInScreen(this.mInfo, arg3);
            return;
        }

        Rect v0 = new Rect();
        this.mInfo.getBoundsInScreen(v0);
        arg3.set(v0);
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getRoot());
    }

    public AccessibilityNodeInfoCompat getRoot(int arg3) {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.getRoot(this.mInfo, arg3);
        }

        return this.getRoot();
    }

    public CharSequence getTitle() {
        return Api24Impl.getTitle(this.mInfo);
    }

    public long getTransitionTimeMillis() {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getTransitionTimeMillis(this.mInfo);
        }

        return 0;
    }

    public int getType() {
        return this.mInfo.getType();
    }

    public int hashCode() {
        AccessibilityWindowInfo v0 = this.mInfo;
        if(v0 == null) {
            return 0;
        }

        return v0.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isActive() {
        return this.mInfo.isActive();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isInPictureInPictureMode() {
        return Api26Impl.isInPictureInPictureMode(this.mInfo);
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfo.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat arg0) {
        if(arg0 == null) {
            return null;
        }

        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfo.obtain(arg0.mInfo));
    }

    @Deprecated public void recycle() {
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect v1 = new Rect();
        this.getBoundsInScreen(v1);
        v0.append(this.getId());
        v0.append(", type=").append(AccessibilityWindowInfoCompat.typeToString(this.getType()));
        v0.append(", layer=").append(this.getLayer());
        v0.append(", bounds=").append(v1);
        v0.append(", focused=").append(this.isFocused());
        v0.append(", active=").append(this.isActive());
        StringBuilder v1_1 = v0.append(", hasParent=");
        boolean v3 = true;
        boolean v2 = this.getParent() != null ? true : false;
        v1_1.append(v2);
        v1_1 = v0.append(", hasChildren=");
        if(this.getChildCount() > 0) {
        }
        else {
            v3 = false;
        }

        v1_1.append(v3);
        v0.append(", transitionTime=").append(this.getTransitionTimeMillis());
        v0.append(", locales=").append(this.getLocales());
        v0.append(']');
        return v0.toString();
    }

    private static String typeToString(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 3) {
                    if(arg1 != 4) {
                        return "<UNKNOWN>";
                    }

                    return "TYPE_ACCESSIBILITY_OVERLAY";
                }

                return "TYPE_SYSTEM";
            }

            return "TYPE_INPUT_METHOD";
        }

        return "TYPE_APPLICATION";
    }

    public AccessibilityWindowInfo unwrap() {
        return this.mInfo;
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(AccessibilityWindowInfo arg1) {
        if(arg1 != null) {
            return new AccessibilityWindowInfoCompat(arg1);
        }

        return null;
    }
}


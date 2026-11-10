package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat arg1) {
            super();
            this.mCompat = arg1;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int arg1) {
            AccessibilityNodeInfoCompat v0 = this.mCompat.createAccessibilityNodeInfo(arg1);
            if(v0 == null) {
                return null;
            }

            return v0.unwrap();
        }

        public List findAccessibilityNodeInfosByText(String arg3, int arg4) {
            List v2 = this.mCompat.findAccessibilityNodeInfosByText(arg3, arg4);
            if(v2 == null) {
                return null;
            }

            ArrayList v3 = new ArrayList();
            arg4 = v2.size();
            int v0;
            for(v0 = 0; v0 < arg4; ++v0) {
                ((List)v3).add(v2.get(v0).unwrap());
            }

            return ((List)v3);
        }

        public AccessibilityNodeInfo findFocus(int arg1) {
            AccessibilityNodeInfoCompat v0 = this.mCompat.findFocus(arg1);
            if(v0 == null) {
                return null;
            }

            return v0.unwrap();
        }

        public boolean performAction(int arg1, int arg2, Bundle arg3) {
            return this.mCompat.performAction(arg1, arg2, arg3);
        }
    }

    class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat arg1) {
            super(arg1);
        }

        public void addExtraDataToAccessibilityNodeInfo(int arg1, AccessibilityNodeInfo arg2, String arg3, Bundle arg4) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(arg1, AccessibilityNodeInfoCompat.wrap(arg2), arg3, arg4);
        }
    }

    public static final int HOST_VIEW_ID = -1;
    private final Object mProvider;

    public AccessibilityNodeProviderCompat(Object arg1) {
        super();
        this.mProvider = arg1;
    }

    public AccessibilityNodeProviderCompat() {
        super();
        this.mProvider = new AccessibilityNodeProviderApi26(this);
    }

    public void addExtraDataToAccessibilityNodeInfo(int arg1, AccessibilityNodeInfoCompat arg2, String arg3, Bundle arg4) {
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int arg1) {
        return null;
    }

    public List findAccessibilityNodeInfosByText(String arg1, int arg2) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int arg1) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int arg1, int arg2, Bundle arg3) {
        return 0;
    }
}


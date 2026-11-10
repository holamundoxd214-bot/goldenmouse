package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View$AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    final class AccessibilityDelegateAdapter extends View$AccessibilityDelegate {
        final AccessibilityDelegateCompat mCompat;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat arg1) {
            super();
            this.mCompat = arg1;
        }

        public boolean dispatchPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(arg1, arg2);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View arg1) {
            AccessibilityNodeProviderCompat v0 = this.mCompat.getAccessibilityNodeProvider(arg1);
            if(v0 != null) {
                return v0.getProvider();
            }

            return null;
        }

        public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            this.mCompat.onInitializeAccessibilityEvent(arg1, arg2);
        }

        public void onInitializeAccessibilityNodeInfo(View arg3, AccessibilityNodeInfo arg4) {
            AccessibilityNodeInfoCompat v0 = AccessibilityNodeInfoCompat.wrap(arg4);
            v0.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(arg3));
            v0.setHeading(ViewCompat.isAccessibilityHeading(arg3));
            v0.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(arg3));
            v0.setStateDescription(ViewCompat.getStateDescription(arg3));
            this.mCompat.onInitializeAccessibilityNodeInfo(arg3, v0);
            v0.addSpansToExtras(arg4.getText(), arg3);
            List v2 = AccessibilityDelegateCompat.getActionList(arg3);
            int v3;
            for(v3 = 0; v3 < v2.size(); ++v3) {
                v0.addAction(v2.get(v3));
            }
        }

        public void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            this.mCompat.onPopulateAccessibilityEvent(arg1, arg2);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup arg1, View arg2, AccessibilityEvent arg3) {
            return this.mCompat.onRequestSendAccessibilityEvent(arg1, arg2, arg3);
        }

        public boolean performAccessibilityAction(View arg1, int arg2, Bundle arg3) {
            return this.mCompat.performAccessibilityAction(arg1, arg2, arg3);
        }

        public void sendAccessibilityEvent(View arg1, int arg2) {
            this.mCompat.sendAccessibilityEvent(arg1, arg2);
        }

        public void sendAccessibilityEventUnchecked(View arg1, AccessibilityEvent arg2) {
            this.mCompat.sendAccessibilityEventUnchecked(arg1, arg2);
        }
    }

    private static final View$AccessibilityDelegate DEFAULT_DELEGATE;
    private final View$AccessibilityDelegate mBridge;
    private final View$AccessibilityDelegate mOriginalDelegate;

    static {
        AccessibilityDelegateCompat.DEFAULT_DELEGATE = new View$AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        this(AccessibilityDelegateCompat.DEFAULT_DELEGATE);
    }

    public AccessibilityDelegateCompat(View$AccessibilityDelegate arg1) {
        super();
        this.mOriginalDelegate = arg1;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(arg1, arg2);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg1) {
        AccessibilityNodeProvider v0 = this.mOriginalDelegate.getAccessibilityNodeProvider(arg1);
        if(v0 != null) {
            return new AccessibilityNodeProviderCompat(v0);
        }

        return null;
    }

    static List getActionList(View arg1) {
        List v1_1;
        Object v1 = arg1.getTag(id.tag_accessibility_actions);
        if(v1 == null) {
            v1_1 = Collections.emptyList();
        }

        return v1_1;
    }

    View$AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    private boolean isSpanStillValid(ClickableSpan arg3, View arg4) {
        if(arg3 != null) {
            ClickableSpan[] v4 = AccessibilityNodeInfoCompat.getClickableSpans(arg4.createAccessibilityNodeInfo().getText());
            int v0 = 0;
            while(v4 != null) {
                if(v0 >= v4.length) {
                    return 0;
                }

                if(arg3.equals(v4[v0])) {
                    return 1;
                }
                else {
                    ++v0;
                    continue;
                }

                return 0;
            }
        }

        return 0;
    }

    public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(arg1, arg2);
    }

    public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(arg1, arg2.unwrap());
    }

    public void onPopulateAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(arg1, arg2);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup arg1, View arg2, AccessibilityEvent arg3) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(arg1, arg2, arg3);
    }

    public boolean performAccessibilityAction(View arg6, int arg7, Bundle arg8) {
        List v0 = AccessibilityDelegateCompat.getActionList(arg6);
        boolean v1 = false;
        int v2 = 0;
        while(v2 < v0.size()) {
            Object v3 = v0.get(v2);
            if(((AccessibilityActionCompat)v3).getId() == arg7) {
                v1 = ((AccessibilityActionCompat)v3).perform(arg6, arg8);
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        if(!v1) {
            v1 = this.mOriginalDelegate.performAccessibilityAction(arg6, arg7, arg8);
        }

        if(!v1 && arg7 == id.accessibility_action_clickable_span && arg8 != null) {
            return this.performClickableSpanAction(arg8.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), arg6);
        }

        return v1;
    }

    private boolean performClickableSpanAction(int arg2, View arg3) {
        Object v0 = arg3.getTag(id.tag_accessibility_clickable_spans);
        if(v0 != null) {
            Object v2 = ((SparseArray)v0).get(arg2);
            if(v2 != null) {
                v2 = ((WeakReference)v2).get();
                if(this.isSpanStillValid(((ClickableSpan)v2), arg3)) {
                    ((ClickableSpan)v2).onClick(arg3);
                    return 1;
                }
            }
        }

        return 0;
    }

    public void sendAccessibilityEvent(View arg1, int arg2) {
        this.mOriginalDelegate.sendAccessibilityEvent(arg1, arg2);
    }

    public void sendAccessibilityEventUnchecked(View arg1, AccessibilityEvent arg2) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(arg1, arg2);
    }
}


package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    public class ItemDelegate extends AccessibilityDelegateCompat {
        private Map mOriginalItemDelegates;
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(RecyclerViewAccessibilityDelegate arg2) {
            super();
            this.mOriginalItemDelegates = new WeakHashMap();
            this.mRecyclerViewDelegate = arg2;
        }

        public boolean dispatchPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
            Object v0 = this.mOriginalItemDelegates.get(arg2);
            if(v0 != null) {
                return ((AccessibilityDelegateCompat)v0).dispatchPopulateAccessibilityEvent(arg2, arg3);
            }

            return super.dispatchPopulateAccessibilityEvent(arg2, arg3);
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg2) {
            Object v0 = this.mOriginalItemDelegates.get(arg2);
            if(v0 != null) {
                return ((AccessibilityDelegateCompat)v0).getAccessibilityNodeProvider(arg2);
            }

            return super.getAccessibilityNodeProvider(arg2);
        }

        AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View arg1) {
            return this.mOriginalItemDelegates.remove(arg1);
        }

        public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
            Object v0 = this.mOriginalItemDelegates.get(arg2);
            if(v0 != null) {
                ((AccessibilityDelegateCompat)v0).onInitializeAccessibilityEvent(arg2, arg3);
                return;
            }

            super.onInitializeAccessibilityEvent(arg2, arg3);
        }

        public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
            if(!this.mRecyclerViewDelegate.shouldIgnore() && this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null) {
                this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(arg2, arg3);
                Object v0 = this.mOriginalItemDelegates.get(arg2);
                if(v0 != null) {
                    ((AccessibilityDelegateCompat)v0).onInitializeAccessibilityNodeInfo(arg2, arg3);
                    return;
                }
                else {
                    super.onInitializeAccessibilityNodeInfo(arg2, arg3);
                    return;
                }
            }

            super.onInitializeAccessibilityNodeInfo(arg2, arg3);
        }

        public void onPopulateAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
            Object v0 = this.mOriginalItemDelegates.get(arg2);
            if(v0 != null) {
                ((AccessibilityDelegateCompat)v0).onPopulateAccessibilityEvent(arg2, arg3);
                return;
            }

            super.onPopulateAccessibilityEvent(arg2, arg3);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
            Object v0 = this.mOriginalItemDelegates.get(arg2);
            if(v0 != null) {
                return ((AccessibilityDelegateCompat)v0).onRequestSendAccessibilityEvent(arg2, arg3, arg4);
            }

            return super.onRequestSendAccessibilityEvent(arg2, arg3, arg4);
        }

        public boolean performAccessibilityAction(View arg3, int arg4, Bundle arg5) {
            if(!this.mRecyclerViewDelegate.shouldIgnore() && this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null) {
                Object v0 = this.mOriginalItemDelegates.get(arg3);
                if(v0 != null) {
                    if(((AccessibilityDelegateCompat)v0).performAccessibilityAction(arg3, arg4, arg5)) {
                        return 1;
                    }
                }
                else if(super.performAccessibilityAction(arg3, arg4, arg5)) {
                    return 1;
                }

                return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(arg3, arg4, arg5);
            }

            return super.performAccessibilityAction(arg3, arg4, arg5);
        }

        void saveOriginalDelegate(View arg2) {
            AccessibilityDelegateCompat v0 = ViewCompat.getAccessibilityDelegate(arg2);
            if(v0 != null && (((ItemDelegate)v0)) != this) {
                this.mOriginalItemDelegates.put(arg2, v0);
            }
        }

        public void sendAccessibilityEvent(View arg2, int arg3) {
            Object v0 = this.mOriginalItemDelegates.get(arg2);
            if(v0 != null) {
                ((AccessibilityDelegateCompat)v0).sendAccessibilityEvent(arg2, arg3);
                return;
            }

            super.sendAccessibilityEvent(arg2, arg3);
        }

        public void sendAccessibilityEventUnchecked(View arg2, AccessibilityEvent arg3) {
            Object v0 = this.mOriginalItemDelegates.get(arg2);
            if(v0 != null) {
                ((AccessibilityDelegateCompat)v0).sendAccessibilityEventUnchecked(arg2, arg3);
                return;
            }

            super.sendAccessibilityEventUnchecked(arg2, arg3);
        }
    }

    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView arg2) {
        super();
        this.mRecyclerView = arg2;
        AccessibilityDelegateCompat v2 = this.getItemDelegate();
        if(v2 != null && ((v2 instanceof ItemDelegate))) {
            this.mItemDelegate = ((ItemDelegate)v2);
            return;
        }

        this.mItemDelegate = new ItemDelegate(this);
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
        super.onInitializeAccessibilityEvent(arg2, arg3);
        if(((arg2 instanceof RecyclerView)) && !this.shouldIgnore() && ((RecyclerView)arg2).getLayoutManager() != null) {
            ((RecyclerView)arg2).getLayoutManager().onInitializeAccessibilityEvent(arg3);
        }
    }

    public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
        super.onInitializeAccessibilityNodeInfo(arg1, arg2);
        if(!this.shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(arg2);
        }
    }

    public boolean performAccessibilityAction(View arg1, int arg2, Bundle arg3) {
        if(super.performAccessibilityAction(arg1, arg2, arg3)) {
            return 1;
        }

        if(!this.shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            return this.mRecyclerView.getLayoutManager().performAccessibilityAction(arg2, arg3);
        }

        return 0;
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}


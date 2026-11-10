package androidx.core.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View$AccessibilityDelegate;
import android.view.View$DragShadowBuilder;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.ReplaceWith;
import androidx.collection.SimpleArrayMap;
import androidx.core.R$id;
import androidx.core.util.Preconditions;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import androidx.core.viewtree.ViewTree;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.WeakHashMap;

public class ViewCompat {
    class AccessibilityPaneVisibilityManager implements View$OnAttachStateChangeListener, ViewTreeObserver$OnGlobalLayoutListener {
        private final WeakHashMap mPanesToVisible;

        AccessibilityPaneVisibilityManager() {
            super();
            this.mPanesToVisible = new WeakHashMap();
        }

        void addAccessibilityPane(View arg3) {
            WeakHashMap v0 = this.mPanesToVisible;
            boolean v1 = !arg3.isShown() || arg3.getWindowVisibility() != 0 ? false : true;
            v0.put(arg3, Boolean.valueOf(v1));
            arg3.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
            if(arg3.isAttachedToWindow()) {
                this.registerForLayoutCallback(arg3);
            }
        }

        private void checkPaneVisibility(Map$Entry arg3) {
            Object v2 = arg3.getKey();
            boolean v0 = arg3.getValue().booleanValue();
            boolean v1 = !((View)v2).isShown() || ((View)v2).getWindowVisibility() != 0 ? false : true;
            if(v0 != v1) {
                int v0_1 = v1 ? 16 : 0x20;
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(((View)v2), v0_1);
                arg3.setValue(Boolean.valueOf(v1));
            }
        }

        public void onGlobalLayout() {
            if(Build$VERSION.SDK_INT < 28) {
                Iterator v0 = this.mPanesToVisible.entrySet().iterator();
                while(v0.hasNext()) {
                    this.checkPaneVisibility(v0.next());
                }
            }
        }

        public void onViewAttachedToWindow(View arg1) {
            this.registerForLayoutCallback(arg1);
        }

        public void onViewDetachedFromWindow(View arg1) {
        }

        private void registerForLayoutCallback(View arg1) {
            arg1.getViewTreeObserver().addOnGlobalLayoutListener(((ViewTreeObserver$OnGlobalLayoutListener)this));
        }

        void removeAccessibilityPane(View arg2) {
            this.mPanesToVisible.remove(arg2);
            arg2.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
            this.unregisterForLayoutCallback(arg2);
        }

        private void unregisterForLayoutCallback(View arg1) {
            arg1.getViewTreeObserver().removeOnGlobalLayoutListener(((ViewTreeObserver$OnGlobalLayoutListener)this));
        }
    }

    abstract class AccessibilityViewProperty {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class mType;

        AccessibilityViewProperty(int arg2, Class arg3, int arg4) {
            this(arg2, arg3, 0, arg4);
        }

        AccessibilityViewProperty(int arg1, Class arg2, int arg3, int arg4) {
            super();
            this.mTagKey = arg1;
            this.mType = arg2;
            this.mContentChangeType = arg3;
            this.mFrameworkMinimumSdk = arg4;
        }

        boolean booleanNullToFalseEquals(Boolean arg2, Boolean arg3) {
            int v2 = arg2 == null || !arg2.booleanValue() ? 0 : 1;
            int v3 = arg3 == null || !arg3.booleanValue() ? 0 : 1;
            if(v2 == v3) {
                return 1;
            }

            return 0;
        }

        private boolean frameworkAvailable() {
            if(Build$VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                return 1;
            }

            return 0;
        }

        abstract Object frameworkGet(View arg1);

        abstract void frameworkSet(View arg1, Object arg2);

        Object get(View arg2) {
            if(this.frameworkAvailable()) {
                return this.frameworkGet(arg2);
            }

            Object v2 = arg2.getTag(this.mTagKey);
            if(this.mType.isInstance(v2)) {
                return v2;
            }

            return null;
        }

        void set(View arg2, Object arg3) {
            if(this.frameworkAvailable()) {
                this.frameworkSet(arg2, arg3);
                return;
            }

            if(this.shouldUpdate(this.get(arg2), arg3)) {
                ViewCompat.ensureAccessibilityDelegateCompat(arg2);
                arg2.setTag(this.mTagKey, arg3);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(arg2, this.mContentChangeType);
            }
        }

        boolean shouldUpdate(Object arg1, Object arg2) {
            return arg2.equals(arg1) ^ 1;
        }
    }

    class Api20Impl {
        private Api20Impl() {
            super();
        }

        static WindowInsets dispatchApplyWindowInsets(View arg1, WindowInsets arg2) {
            if(ViewGroupCompat.sCompatInsetsDispatchInstalled) {
                return ViewGroupCompat.dispatchApplyWindowInsets(arg1, arg2);
            }

            return arg1.dispatchApplyWindowInsets(arg2);
        }
    }

    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static void callCompatInsetAnimationCallback(WindowInsets arg1, View arg2) {
            Object v0 = arg2.getTag(id.tag_window_insets_animation_callback);
            if(v0 != null) {
                ((View$OnApplyWindowInsetsListener)v0).onApplyWindowInsets(arg2, arg1);
            }
        }

        static WindowInsetsCompat computeSystemWindowInsets(View arg1, WindowInsetsCompat arg2, Rect arg3) {
            WindowInsets v0 = arg2.toWindowInsets();
            if(v0 != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(arg1.computeSystemWindowInsets(v0, arg3), arg1);
            }

            arg3.setEmpty();
            return arg2;
        }

        static void setOnApplyWindowInsetsListener(View arg2, OnApplyWindowInsetsListener arg3) {
            androidx.core.view.ViewCompat$Api21Impl$1 v0;
            if(arg3 != null) {
                v0 = new View$OnApplyWindowInsetsListener(arg2, arg3) {
                    WindowInsetsCompat mLastInsets;

                    public WindowInsets onApplyWindowInsets(View arg4, WindowInsets arg5) {
                        WindowInsetsCompat v0 = WindowInsetsCompat.toWindowInsetsCompat(arg5, arg4);
                        int v2 = 30;
                        if(Build$VERSION.SDK_INT < v2) {
                            Api21Impl.callCompatInsetAnimationCallback(arg5, this.val$v);
                            if(v0.equals(this.mLastInsets)) {
                                return this.val$listener.onApplyWindowInsets(arg4, v0).toWindowInsets();
                            }
                        }

                        this.mLastInsets = v0;
                        WindowInsetsCompat v3 = this.val$listener.onApplyWindowInsets(arg4, v0);
                        if(Build$VERSION.SDK_INT >= v2) {
                            return v3.toWindowInsets();
                        }

                        ViewCompat.requestApplyInsets(arg4);
                        return v3.toWindowInsets();
                    }
                };
            }
            else {
                Object v0_1 = null;
            }

            if(Build$VERSION.SDK_INT < 30) {
                arg2.setTag(id.tag_on_apply_window_listener, v0);
            }

            if(arg2.getTag(id.tag_compat_insets_dispatch) != null) {
                return;
            }

            if(v0 != null) {
                arg2.setOnApplyWindowInsetsListener(((View$OnApplyWindowInsetsListener)v0));
                return;
            }

            arg2.setOnApplyWindowInsetsListener(arg2.getTag(id.tag_window_insets_animation_callback));
        }
    }

    class Api23Impl {
        private Api23Impl() {
            super();
        }

        public static WindowInsetsCompat getRootWindowInsets(View arg1) {
            WindowInsets v0 = arg1.getRootWindowInsets();
            if(v0 == null) {
                return null;
            }

            WindowInsetsCompat v0_1 = WindowInsetsCompat.toWindowInsetsCompat(v0);
            v0_1.setRootWindowInsets(v0_1);
            v0_1.init(arg1.getRootView());
            return v0_1;
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void cancelDragAndDrop(View arg0) {
            arg0.cancelDragAndDrop();
        }

        static void dispatchFinishTemporaryDetach(View arg0) {
            arg0.dispatchFinishTemporaryDetach();
        }

        static void dispatchStartTemporaryDetach(View arg0) {
            arg0.dispatchStartTemporaryDetach();
        }

        static void setPointerIcon(View arg0, PointerIcon arg1) {
            arg0.setPointerIcon(arg1);
        }

        static boolean startDragAndDrop(View arg0, ClipData arg1, View$DragShadowBuilder arg2, Object arg3, int arg4) {
            return arg0.startDragAndDrop(arg1, arg2, arg3, arg4);
        }

        static void updateDragShadow(View arg0, View$DragShadowBuilder arg1) {
            arg0.updateDragShadow(arg1);
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static void addKeyboardNavigationClusters(View arg0, Collection arg1, int arg2) {
            arg0.addKeyboardNavigationClusters(arg1, arg2);
        }

        public static AutofillId getAutofillId(View arg0) {
            return arg0.getAutofillId();
        }

        static int getImportantForAutofill(View arg0) {
            return arg0.getImportantForAutofill();
        }

        static int getNextClusterForwardId(View arg0) {
            return arg0.getNextClusterForwardId();
        }

        static boolean hasExplicitFocusable(View arg0) {
            return arg0.hasExplicitFocusable();
        }

        static boolean isFocusedByDefault(View arg0) {
            return arg0.isFocusedByDefault();
        }

        static boolean isImportantForAutofill(View arg0) {
            return arg0.isImportantForAutofill();
        }

        static boolean isKeyboardNavigationCluster(View arg0) {
            return arg0.isKeyboardNavigationCluster();
        }

        static View keyboardNavigationClusterSearch(View arg0, View arg1, int arg2) {
            return arg0.keyboardNavigationClusterSearch(arg1, arg2);
        }

        static boolean restoreDefaultFocus(View arg0) {
            return arg0.restoreDefaultFocus();
        }

        static void setAutofillHints(View arg0, String[] arg1) {
            arg0.setAutofillHints(arg1);
        }

        static void setFocusedByDefault(View arg0, boolean arg1) {
            arg0.setFocusedByDefault(arg1);
        }

        static void setImportantForAutofill(View arg0, int arg1) {
            arg0.setImportantForAutofill(arg1);
        }

        static void setKeyboardNavigationCluster(View arg0, boolean arg1) {
            arg0.setKeyboardNavigationCluster(arg1);
        }

        static void setNextClusterForwardId(View arg0, int arg1) {
            arg0.setNextClusterForwardId(arg1);
        }

        static void setTooltipText(View arg0, CharSequence arg1) {
            arg0.setTooltipText(arg1);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static void addOnUnhandledKeyEventListener(View arg2, OnUnhandledKeyEventListenerCompat arg3) {
            SimpleArrayMap v0_1;
            Object v0 = arg2.getTag(id.tag_unhandled_key_listeners);
            if(v0 == null) {
                v0_1 = new SimpleArrayMap();
                arg2.setTag(id.tag_unhandled_key_listeners, v0_1);
            }

            Objects.requireNonNull(arg3);
            ViewCompat$Api28Impl$$ExternalSyntheticLambda0 v1 = new ViewCompat$Api28Impl$$ExternalSyntheticLambda0(arg3);
            v0_1.put(arg3, v1);
            arg2.addOnUnhandledKeyEventListener(((View$OnUnhandledKeyEventListener)v1));
        }

        static CharSequence getAccessibilityPaneTitle(View arg0) {
            return arg0.getAccessibilityPaneTitle();
        }

        static boolean isAccessibilityHeading(View arg0) {
            return arg0.isAccessibilityHeading();
        }

        static boolean isScreenReaderFocusable(View arg0) {
            return arg0.isScreenReaderFocusable();
        }

        static void removeOnUnhandledKeyEventListener(View arg1, OnUnhandledKeyEventListenerCompat arg2) {
            Object v0 = arg1.getTag(id.tag_unhandled_key_listeners);
            if(v0 == null) {
            }
            else {
                Object v2 = ((SimpleArrayMap)v0).get(arg2);
                if(v2 != null) {
                    arg1.removeOnUnhandledKeyEventListener(((View$OnUnhandledKeyEventListener)v2));
                }
            }
        }

        static Object requireViewById(View arg0, int arg1) {
            return arg0.requireViewById(arg1);
        }

        static void setAccessibilityHeading(View arg0, boolean arg1) {
            arg0.setAccessibilityHeading(arg1);
        }

        static void setAccessibilityPaneTitle(View arg0, CharSequence arg1) {
            arg0.setAccessibilityPaneTitle(arg1);
        }

        public static void setAutofillId(View arg0, AutofillIdCompat arg1) {
            AutofillId v1 = arg1 == null ? null : arg1.toAutofillId();
            arg0.setAutofillId(v1);
        }

        static void setScreenReaderFocusable(View arg0, boolean arg1) {
            arg0.setScreenReaderFocusable(arg1);
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static View$AccessibilityDelegate getAccessibilityDelegate(View arg0) {
            return arg0.getAccessibilityDelegate();
        }

        static ContentCaptureSession getContentCaptureSession(View arg0) {
            return arg0.getContentCaptureSession();
        }

        static List getSystemGestureExclusionRects(View arg0) {
            return arg0.getSystemGestureExclusionRects();
        }

        static void saveAttributeDataForStyleable(View arg0, Context arg1, int[] arg2, AttributeSet arg3, TypedArray arg4, int arg5, int arg6) {
            arg0.saveAttributeDataForStyleable(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        static void setContentCaptureSession(View arg0, ContentCaptureSessionCompat arg1) {
            ContentCaptureSession v1 = arg1 == null ? null : arg1.toContentCaptureSession();
            arg0.setContentCaptureSession(v1);
        }

        static void setSystemGestureExclusionRects(View arg0, List arg1) {
            arg0.setSystemGestureExclusionRects(arg1);
        }

        static void transformMatrixToGlobal(View arg0, Matrix arg1) {
            arg0.transformMatrixToGlobal(arg1);
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static WindowInsets dispatchApplyWindowInsets(View arg0, WindowInsets arg1) {
            return arg0.dispatchApplyWindowInsets(arg1);
        }

        static int getImportantForContentCapture(View arg0) {
            return arg0.getImportantForContentCapture();
        }

        static CharSequence getStateDescription(View arg0) {
            return arg0.getStateDescription();
        }

        public static WindowInsetsControllerCompat getWindowInsetsController(View arg0) {
            WindowInsetsController v0 = arg0.getWindowInsetsController();
            if(v0 != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(v0);
            }

            return null;
        }

        static boolean isImportantForContentCapture(View arg0) {
            return arg0.isImportantForContentCapture();
        }

        static void setImportantForContentCapture(View arg0, int arg1) {
            arg0.setImportantForContentCapture(arg1);
        }

        static void setStateDescription(View arg0, CharSequence arg1) {
            arg0.setStateDescription(arg1);
        }
    }

    final class Api31Impl {
        private Api31Impl() {
            super();
        }

        public static String[] getReceiveContentMimeTypes(View arg0) {
            return arg0.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View arg1, ContentInfoCompat arg2) {
            ContentInfo v0 = arg2.toContentInfo();
            ContentInfo v1 = arg1.performReceiveContent(v0);
            if(v1 == null) {
                return null;
            }

            if(v1 == v0) {
                return arg2;
            }

            return ContentInfoCompat.toContentInfoCompat(v1);
        }

        public static void setOnReceiveContentListener(View arg1, String[] arg2, OnReceiveContentListener arg3) {
            if(arg3 == null) {
                arg1.setOnReceiveContentListener(arg2, null);
                return;
            }

            arg1.setOnReceiveContentListener(arg2, new OnReceiveContentListenerAdapter(arg3));
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FocusDirection {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FocusRealDirection {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FocusRelativeDirection {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface NestedScrollType {
    }

    final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        private final OnReceiveContentListener mJetpackListener;

        OnReceiveContentListenerAdapter(OnReceiveContentListener arg1) {
            super();
            this.mJetpackListener = arg1;
        }

        public ContentInfo onReceiveContent(View arg2, ContentInfo arg3) {
            ContentInfoCompat v0 = ContentInfoCompat.toContentInfoCompat(arg3);
            ContentInfoCompat v1 = this.mJetpackListener.onReceiveContent(arg2, v0);
            if(v1 == null) {
                return null;
            }

            if(v1 == v0) {
                return arg3;
            }

            return v1.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View arg1, KeyEvent arg2);
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ScrollAxis {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ScrollIndicators {
    }

    class UnhandledKeyEventManager {
        private SparseArray mCapturedKeys;
        private WeakReference mLastDispatchedPreViewKeyEvent;
        private WeakHashMap mViewsContainingListeners;
        private static final ArrayList sViewsWithListeners;

        static {
            UnhandledKeyEventManager.sViewsWithListeners = new ArrayList();
        }

        UnhandledKeyEventManager() {
            super();
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        static UnhandledKeyEventManager at(View arg2) {
            Object v0 = arg2.getTag(id.tag_unhandled_key_event_manager);
            if(v0 == null) {
                UnhandledKeyEventManager v0_1 = new UnhandledKeyEventManager();
                arg2.setTag(id.tag_unhandled_key_event_manager, v0_1);
            }

            return ((UnhandledKeyEventManager)v0);
        }

        boolean dispatch(View arg2, KeyEvent arg3) {
            if(arg3.getAction() == 0) {
                this.recalcViewsWithUnhandled();
            }

            arg2 = this.dispatchInOrder(arg2, arg3);
            if(arg3.getAction() == 0) {
                int v3 = arg3.getKeyCode();
                if(arg2 != null && !KeyEvent.isModifierKey(v3)) {
                    this.getCapturedKeys().put(v3, new WeakReference(arg2));
                }
            }

            if(arg2 != null) {
                return 1;
            }

            return 0;
        }

        private View dispatchInOrder(View arg5, KeyEvent arg6) {
            WeakHashMap v0 = this.mViewsContainingListeners;
            View v1 = null;
            if(v0 != null) {
                if(!v0.containsKey(arg5)) {
                }
                else {
                    if((arg5 instanceof ViewGroup)) {
                        View v0_1 = arg5;
                        int v2 = ((ViewGroup)v0_1).getChildCount() - 1;
                        while(v2 >= 0) {
                            View v3 = this.dispatchInOrder(((ViewGroup)v0_1).getChildAt(v2), arg6);
                            if(v3 != null) {
                                return v3;
                            }
                            else {
                                --v2;
                                continue;
                            }

                            break;
                        }
                    }

                    if(!this.onUnhandledKeyEvent(arg5, arg6)) {
                        return v1;
                    }

                    return arg5;
                }
            }

            return v1;
        }

        private SparseArray getCapturedKeys() {
            SparseArray v0 = this.mCapturedKeys;
            if(v0 == null) {
                v0 = new SparseArray();
                this.mCapturedKeys = v0;
            }

            return v0;
        }

        private boolean onUnhandledKeyEvent(View arg4, KeyEvent arg5) {
            Object v3 = arg4.getTag(id.tag_unhandled_key_listeners);
            if(v3 != null) {
                int v0 = ((ArrayList)v3).size() - 1;
                while(v0 >= 0) {
                    if(((ArrayList)v3).get(v0).onUnhandledKeyEvent(arg4, arg5)) {
                        return 1;
                    }
                    else {
                        --v0;
                        continue;
                    }

                    return 0;
                }
            }

            return 0;
        }

        boolean preDispatch(KeyEvent arg6) {
            Object v4;
            WeakReference v0 = this.mLastDispatchedPreViewKeyEvent;
            if(v0 != null && v0.get() == arg6) {
                return 0;
            }

            this.mLastDispatchedPreViewKeyEvent = new WeakReference(arg6);
            SparseArray v0_1 = this.getCapturedKeys();
            if(arg6.getAction() == 1) {
                int v2 = v0_1.indexOfKey(arg6.getKeyCode());
                if(v2 >= 0) {
                    v4 = v0_1.valueAt(v2);
                    v0_1.removeAt(v2);
                }
                else {
                    goto label_19;
                }
            }
            else {
            label_19:
                v4 = null;
            }

            if(v4 == null) {
                v4 = v0_1.get(arg6.getKeyCode());
            }

            if(v4 != null) {
                Object v0_2 = ((WeakReference)v4).get();
                if(v0_2 != null && (((View)v0_2).isAttachedToWindow())) {
                    this.onUnhandledKeyEvent(((View)v0_2), arg6);
                }

                return 1;
            }

            return 0;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap v0 = this.mViewsContainingListeners;
            if(v0 != null) {
                v0.clear();
            }

            ArrayList v0_1 = UnhandledKeyEventManager.sViewsWithListeners;
            if(v0_1.isEmpty()) {
                return;
            }

            __monitor_enter(v0_1);
            try {
                if(this.mViewsContainingListeners == null) {
                    this.mViewsContainingListeners = new WeakHashMap();
                }

                int v1;
                for(v1 = v0_1.size() - 1; v1 >= 0; --v1) {
                    ArrayList v2 = UnhandledKeyEventManager.sViewsWithListeners;
                    Object v3 = v2.get(v1).get();
                    if(v3 == null) {
                        v2.remove(v1);
                    }
                    else {
                        this.mViewsContainingListeners.put(v3, Boolean.TRUE);
                        ViewParent v2_1;
                        for(v2_1 = ((View)v3).getParent(); (v2_1 instanceof View); v2_1 = v2_1.getParent()) {
                            this.mViewsContainingListeners.put(v2_1, Boolean.TRUE);
                        }
                    }
                }

                __monitor_exit(v0_1);
                return;
            label_39:
                __monitor_exit(v0_1);
            }
            catch(Throwable v6) {
                goto label_39;
            }

            throw v6;
        }

        static void registerListeningView(View arg3) {
            ArrayList v0 = UnhandledKeyEventManager.sViewsWithListeners;
            __monitor_enter(v0);
            try {
                Iterator v1 = v0.iterator();
                do {
                    if(!v1.hasNext()) {
                        goto label_10;
                    }
                }
                while(v1.next().get() != arg3);

                __monitor_exit(v0);
                return;
            label_10:
                UnhandledKeyEventManager.sViewsWithListeners.add(new WeakReference(arg3));
                __monitor_exit(v0);
                return;
            label_17:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_17;
            }

            throw v3;
        }

        static void unregisterListeningView(View arg4) {
            ArrayList v0 = UnhandledKeyEventManager.sViewsWithListeners;
            __monitor_enter(v0);
            int v1 = 0;
            try {
                while(true) {
                    ArrayList v2 = UnhandledKeyEventManager.sViewsWithListeners;
                    if(v1 >= v2.size()) {
                        break;
                    }

                    if(v2.get(v1).get() == arg4) {
                        v2.remove(v1);
                        __monitor_exit(v0);
                        return;
                    }

                    ++v1;
                }

                __monitor_exit(v0);
                return;
            label_17:
                __monitor_exit(v0);
            }
            catch(Throwable v4) {
                goto label_17;
            }

            throw v4;
        }
    }

    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    @Deprecated public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    @Deprecated public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    @Deprecated public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    @Deprecated public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;
    @Deprecated public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated public static final int LAYER_TYPE_NONE = 0;
    @Deprecated public static final int LAYER_TYPE_SOFTWARE = 1;
    @Deprecated public static final int LAYOUT_DIRECTION_INHERIT = 2;
    @Deprecated public static final int LAYOUT_DIRECTION_LOCALE = 3;
    @Deprecated public static final int LAYOUT_DIRECTION_LTR = 0;
    @Deprecated public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated public static final int MEASURED_SIZE_MASK = 0xFFFFFF;
    @Deprecated public static final int MEASURED_STATE_MASK = 0xFF000000;
    @Deprecated public static final int MEASURED_STATE_TOO_SMALL = 0x1000000;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = null;
    @Deprecated public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 0x20;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static Field sAccessibilityDelegateField = null;
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = null;
    private static Method sChildrenDrawingOrderMethod = null;
    private static Method sDispatchFinishTemporaryDetach = null;
    private static Method sDispatchStartTemporaryDetach = null;
    private static boolean sTempDetachBound = false;
    private static boolean sTryHiddenViewTransformMatrixToGlobal = true;
    private static WeakHashMap sViewPropertyAnimatorMap;

    static {
        ViewCompat.ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{id.accessibility_custom_action_0, id.accessibility_custom_action_1, id.accessibility_custom_action_2, id.accessibility_custom_action_3, id.accessibility_custom_action_4, id.accessibility_custom_action_5, id.accessibility_custom_action_6, id.accessibility_custom_action_7, id.accessibility_custom_action_8, id.accessibility_custom_action_9, id.accessibility_custom_action_10, id.accessibility_custom_action_11, id.accessibility_custom_action_12, id.accessibility_custom_action_13, id.accessibility_custom_action_14, id.accessibility_custom_action_15, id.accessibility_custom_action_16, id.accessibility_custom_action_17, id.accessibility_custom_action_18, id.accessibility_custom_action_19, id.accessibility_custom_action_20, id.accessibility_custom_action_21, id.accessibility_custom_action_22, id.accessibility_custom_action_23, id.accessibility_custom_action_24, id.accessibility_custom_action_25, id.accessibility_custom_action_26, id.accessibility_custom_action_27, id.accessibility_custom_action_28, id.accessibility_custom_action_29, id.accessibility_custom_action_30, id.accessibility_custom_action_31};
        ViewCompat.NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new ViewCompat$$ExternalSyntheticLambda0();
        ViewCompat.sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    @Deprecated protected ViewCompat() {
        super();
    }

    private static AccessibilityViewProperty accessibilityHeadingProperty() {
        return new AccessibilityViewProperty(id.tag_accessibility_heading, Boolean.class, 28) {
            Boolean frameworkGet(View arg1) {
                return Boolean.valueOf(Api28Impl.isAccessibilityHeading(arg1));
            }

            Object frameworkGet(View arg1) {
                return this.frameworkGet(arg1);
            }

            void frameworkSet(View arg1, Boolean arg2) {
                Api28Impl.setAccessibilityHeading(arg1, arg2.booleanValue());
            }

            void frameworkSet(View arg1, Object arg2) {
                this.frameworkSet(arg1, ((Boolean)arg2));
            }

            boolean shouldUpdate(Boolean arg1, Boolean arg2) {
                return this.booleanNullToFalseEquals(arg1, arg2) ^ 1;
            }

            boolean shouldUpdate(Object arg1, Object arg2) {
                return this.shouldUpdate(((Boolean)arg1), ((Boolean)arg2));
            }
        };
    }

    public static int addAccessibilityAction(View arg2, CharSequence arg3, AccessibilityViewCommand arg4) {
        int v0 = ViewCompat.getAvailableActionIdFromResources(arg2, arg3);
        if(v0 != -1) {
            ViewCompat.addAccessibilityAction(arg2, new AccessibilityActionCompat(v0, arg3, arg4));
        }

        return v0;
    }

    private static void addAccessibilityAction(View arg1, AccessibilityActionCompat arg2) {
        ViewCompat.ensureAccessibilityDelegateCompat(arg1);
        ViewCompat.removeActionWithId(arg2.getId(), arg1);
        ViewCompat.getActionList(arg1).add(arg2);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(arg1, 0);
    }

    public static void addKeyboardNavigationClusters(View arg0, Collection arg1, int arg2) {
        Api26Impl.addKeyboardNavigationClusters(arg0, arg1, arg2);
    }

    public static void addOnUnhandledKeyEventListener(View arg2, OnUnhandledKeyEventListenerCompat arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.addOnUnhandledKeyEventListener(arg2, arg3);
            return;
        }

        Object v0 = arg2.getTag(id.tag_unhandled_key_listeners);
        if(v0 == null) {
            ArrayList v0_1 = new ArrayList();
            arg2.setTag(id.tag_unhandled_key_listeners, v0_1);
        }

        ((ArrayList)v0).add(arg3);
        if(((ArrayList)v0).size() == 1) {
            UnhandledKeyEventManager.registerListeningView(arg2);
        }
    }

    public static void addOverlayView(ViewGroup arg1, View arg2) {
        arg1.getOverlay().add(arg2);
        ViewTree.setViewTreeDisjointParent(arg2.getParent(), ((ViewParent)arg1));
    }

    @Deprecated public static ViewPropertyAnimatorCompat animate(View arg2) {
        ViewPropertyAnimatorCompat v0_2;
        WeakHashMap v0 = ViewCompat.sViewPropertyAnimatorMap;
        if(v0 == null) {
            v0 = new WeakHashMap();
            ViewCompat.sViewPropertyAnimatorMap = v0;
        }

        Object v0_1 = v0.get(arg2);
        if(v0_1 == null) {
            v0_2 = new ViewPropertyAnimatorCompat(arg2);
            ViewCompat.sViewPropertyAnimatorMap.put(arg2, v0_2);
        }

        return v0_2;
    }

    private static void bindTempDetach() {
        try {
            Class v0_1 = View.class;
            ViewCompat.sDispatchStartTemporaryDetach = v0_1.getDeclaredMethod("dispatchStartTemporaryDetach");
            ViewCompat.sDispatchFinishTemporaryDetach = v0_1.getDeclaredMethod("dispatchFinishTemporaryDetach");
        }
        catch(NoSuchMethodException v0) {
            Log.e("ViewCompat", "Couldn\'t find method", ((Throwable)v0));
        }

        ViewCompat.sTempDetachBound = true;
    }

    @ReplaceWith(expression="view.canScrollHorizontally(direction)") @Deprecated public static boolean canScrollHorizontally(View arg0, int arg1) {
        return arg0.canScrollHorizontally(arg1);
    }

    @ReplaceWith(expression="view.canScrollVertically(direction)") @Deprecated public static boolean canScrollVertically(View arg0, int arg1) {
        return arg0.canScrollVertically(arg1);
    }

    public static void cancelDragAndDrop(View arg0) {
        Api24Impl.cancelDragAndDrop(arg0);
    }

    @Deprecated public static int combineMeasuredStates(int arg0, int arg1) {
        return View.combineMeasuredStates(arg0, arg1);
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View arg0, WindowInsetsCompat arg1, Rect arg2) {
        return Api21Impl.computeSystemWindowInsets(arg0, arg1, arg2);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View arg3, WindowInsetsCompat arg4) {
        WindowInsets v0 = arg4.toWindowInsets();
        if(v0 != null) {
            WindowInsets v1 = Build$VERSION.SDK_INT >= 30 ? Api30Impl.dispatchApplyWindowInsets(arg3, v0) : Api20Impl.dispatchApplyWindowInsets(arg3, v0);
            if(v1.equals(v0)) {
                return arg4;
            }

            return WindowInsetsCompat.toWindowInsetsCompat(v1, arg3);
        }

        return arg4;
    }

    public static void dispatchFinishTemporaryDetach(View arg0) {
        Api24Impl.dispatchFinishTemporaryDetach(arg0);
    }

    public static boolean dispatchNestedFling(View arg0, float arg1, float arg2, boolean arg3) {
        return arg0.dispatchNestedFling(arg1, arg2, arg3);
    }

    public static boolean dispatchNestedPreFling(View arg0, float arg1, float arg2) {
        return arg0.dispatchNestedPreFling(arg1, arg2);
    }

    public static boolean dispatchNestedPreScroll(View arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
        return arg0.dispatchNestedPreScroll(arg1, arg2, arg3, arg4);
    }

    public static boolean dispatchNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4, int[] arg5, int arg6) {
        if((arg1 instanceof NestedScrollingChild2)) {
            return ((NestedScrollingChild2)arg1).dispatchNestedPreScroll(arg2, arg3, arg4, arg5, arg6);
        }

        if(arg6 == 0) {
            return ViewCompat.dispatchNestedPreScroll(arg1, arg2, arg3, arg4, arg5);
        }

        return 0;
    }

    public static void dispatchNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6, int arg7, int[] arg8) {
        if((arg1 instanceof NestedScrollingChild3)) {
            ((NestedScrollingChild3)arg1).dispatchNestedScroll(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
            return;
        }

        ViewCompat.dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static boolean dispatchNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int[] arg6, int arg7) {
        if((arg1 instanceof NestedScrollingChild2)) {
            return ((NestedScrollingChild2)arg1).dispatchNestedScroll(arg2, arg3, arg4, arg5, arg6, arg7);
        }

        if(arg7 == 0) {
            return ViewCompat.dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        return 0;
    }

    public static boolean dispatchNestedScroll(View arg0, int arg1, int arg2, int arg3, int arg4, int[] arg5) {
        return arg0.dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5);
    }

    public static void dispatchStartTemporaryDetach(View arg0) {
        Api24Impl.dispatchStartTemporaryDetach(arg0);
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View arg2, KeyEvent arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return 0;
        }

        return UnhandledKeyEventManager.at(arg2).dispatch(arg2, arg3);
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View arg2, KeyEvent arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return 0;
        }

        return UnhandledKeyEventManager.at(arg2).preDispatch(arg3);
    }

    public static void enableAccessibleClickableSpanSupport(View arg0) {
        ViewCompat.ensureAccessibilityDelegateCompat(arg0);
    }

    static void ensureAccessibilityDelegateCompat(View arg1) {
        AccessibilityDelegateCompat v0 = ViewCompat.getAccessibilityDelegate(arg1);
        if(v0 == null) {
            v0 = new AccessibilityDelegateCompat();
        }

        ViewCompat.setAccessibilityDelegate(arg1, v0);
    }

    static void fallbackTransformMatrixToGlobal(View arg2, Matrix arg3) {
        ViewParent v0 = arg2.getParent();
        if((v0 instanceof View)) {
            ViewCompat.fallbackTransformMatrixToGlobal(((View)v0), arg3);
            arg3.preTranslate(((float)(-((View)v0).getScrollX())), ((float)(-((View)v0).getScrollY())));
        }

        arg3.preTranslate(((float)arg2.getLeft()), ((float)arg2.getTop()));
        arg3.preConcat(arg2.getMatrix());
    }

    @Deprecated public static int generateViewId() {
        return View.generateViewId();
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View arg1) {
        View$AccessibilityDelegate v1 = ViewCompat.getAccessibilityDelegateInternal(arg1);
        if(v1 == null) {
            return null;
        }

        if((v1 instanceof AccessibilityDelegateAdapter)) {
            return ((AccessibilityDelegateAdapter)v1).mCompat;
        }

        return new AccessibilityDelegateCompat(v1);
    }

    private static View$AccessibilityDelegate getAccessibilityDelegateInternal(View arg2) {
        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.getAccessibilityDelegate(arg2);
        }

        return ViewCompat.getAccessibilityDelegateThroughReflection(arg2);
    }

    private static View$AccessibilityDelegate getAccessibilityDelegateThroughReflection(View arg4) {
        View$AccessibilityDelegate v1 = null;
        if(ViewCompat.sAccessibilityDelegateCheckFailed) {
            return v1;
        }

        if(ViewCompat.sAccessibilityDelegateField == null) {
            try {
                Field v0 = View.class.getDeclaredField("mAccessibilityDelegate");
                ViewCompat.sAccessibilityDelegateField = v0;
                v0.setAccessible(true);
            }
            catch(Throwable ) {
                ViewCompat.sAccessibilityDelegateCheckFailed = true;
                return v1;
            }
        }

        try {
            Object v4 = ViewCompat.sAccessibilityDelegateField.get(arg4);
            if(!(v4 instanceof View$AccessibilityDelegate)) {
                return v1;
            }

            return ((View$AccessibilityDelegate)v4);
        }
        catch(Throwable ) {
            ViewCompat.sAccessibilityDelegateCheckFailed = true;
            return v1;
        }

        return v1;
    }

    @ReplaceWith(expression="view.getAccessibilityLiveRegion()") @Deprecated public static int getAccessibilityLiveRegion(View arg0) {
        return arg0.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg1) {
        AccessibilityNodeProvider v1 = arg1.getAccessibilityNodeProvider();
        if(v1 != null) {
            return new AccessibilityNodeProviderCompat(v1);
        }

        return null;
    }

    public static CharSequence getAccessibilityPaneTitle(View arg1) {
        return ViewCompat.paneTitleProperty().get(arg1);
    }

    private static List getActionList(View arg2) {
        Object v0 = arg2.getTag(id.tag_accessibility_actions);
        if(v0 == null) {
            ArrayList v0_1 = new ArrayList();
            arg2.setTag(id.tag_accessibility_actions, v0_1);
        }

        return ((List)v0);
    }

    @ReplaceWith(expression="view.getAlpha()") @Deprecated public static float getAlpha(View arg0) {
        return arg0.getAlpha();
    }

    public static AutofillIdCompat getAutofillId(View arg0) {
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(arg0));
    }

    private static int getAvailableActionIdFromResources(View arg8, CharSequence arg9) {
        List v8 = ViewCompat.getActionList(arg8);
        int v1;
        for(v1 = 0; v1 < v8.size(); ++v1) {
            if(TextUtils.equals(arg9, v8.get(v1).getLabel())) {
                return v8.get(v1).getId();
            }
        }

        int v9 = -1;
        int v2 = v9;
        v1 = 0;
        while(true) {
            int[] v3 = ViewCompat.ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if(v1 < v3.length && v2 == v9) {
                int v3_1 = v3[v1];
                int v5 = 0;
                int v6 = 1;
                while(v5 < v8.size()) {
                    int v7 = v8.get(v5).getId() != v3_1 ? 1 : 0;
                    v6 &= v7;
                    ++v5;
                }

                if(v6 != 0) {
                    v2 = v3_1;
                }

                ++v1;
                continue;
            }

            return v2;
        }

        return v2;
    }

    public static ColorStateList getBackgroundTintList(View arg0) {
        return arg0.getBackgroundTintList();
    }

    public static PorterDuff$Mode getBackgroundTintMode(View arg0) {
        return arg0.getBackgroundTintMode();
    }

    @ReplaceWith(expression="view.getClipBounds()") @Deprecated public static Rect getClipBounds(View arg0) {
        return arg0.getClipBounds();
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View arg3) {
        ContentCaptureSessionCompat v2 = null;
        if(Build$VERSION.SDK_INT >= 29) {
            ContentCaptureSession v0 = Api29Impl.getContentCaptureSession(arg3);
            if(v0 == null) {
                return v2;
            }

            return ContentCaptureSessionCompat.toContentCaptureSessionCompat(v0, arg3);
        }

        return v2;
    }

    @ReplaceWith(expression="view.getDisplay()") @Deprecated public static Display getDisplay(View arg0) {
        return arg0.getDisplay();
    }

    public static float getElevation(View arg0) {
        return arg0.getElevation();
    }

    private static OnReceiveContentViewBehavior getFallback(View arg1) {
        if((arg1 instanceof OnReceiveContentViewBehavior)) {
            return arg1;
        }

        return ViewCompat.NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    @ReplaceWith(expression="view.getFitsSystemWindows()") @Deprecated public static boolean getFitsSystemWindows(View arg0) {
        return arg0.getFitsSystemWindows();
    }

    @ReplaceWith(expression="view.getImportantForAccessibility()") @Deprecated public static int getImportantForAccessibility(View arg0) {
        return arg0.getImportantForAccessibility();
    }

    public static int getImportantForAutofill(View arg0) {
        return Api26Impl.getImportantForAutofill(arg0);
    }

    public static int getImportantForContentCapture(View arg2) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getImportantForContentCapture(arg2);
        }

        return 0;
    }

    @ReplaceWith(expression="view.getLabelFor()") @Deprecated public static int getLabelFor(View arg0) {
        return arg0.getLabelFor();
    }

    @ReplaceWith(expression="view.getLayerType()") @Deprecated public static int getLayerType(View arg0) {
        return arg0.getLayerType();
    }

    @ReplaceWith(expression="view.getLayoutDirection()") @Deprecated public static int getLayoutDirection(View arg0) {
        return arg0.getLayoutDirection();
    }

    @ReplaceWith(expression="view.getMatrix()") @Deprecated public static Matrix getMatrix(View arg0) {
        return arg0.getMatrix();
    }

    @ReplaceWith(expression="view.getMeasuredHeightAndState()") @Deprecated public static int getMeasuredHeightAndState(View arg0) {
        return arg0.getMeasuredHeightAndState();
    }

    @ReplaceWith(expression="view.getMeasuredState()") @Deprecated public static int getMeasuredState(View arg0) {
        return arg0.getMeasuredState();
    }

    @ReplaceWith(expression="view.getMeasuredWidthAndState()") @Deprecated public static int getMeasuredWidthAndState(View arg0) {
        return arg0.getMeasuredWidthAndState();
    }

    @ReplaceWith(expression="view.getMinimumHeight()") @Deprecated public static int getMinimumHeight(View arg0) {
        return arg0.getMinimumHeight();
    }

    @ReplaceWith(expression="view.getMinimumWidth()") @Deprecated public static int getMinimumWidth(View arg0) {
        return arg0.getMinimumWidth();
    }

    public static int getNextClusterForwardId(View arg0) {
        return Api26Impl.getNextClusterForwardId(arg0);
    }

    public static String[] getOnReceiveContentMimeTypes(View arg2) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.getReceiveContentMimeTypes(arg2);
        }

        return arg2.getTag(id.tag_on_receive_content_mime_types);
    }

    @ReplaceWith(expression="view.getOverScrollMode()") @Deprecated public static int getOverScrollMode(View arg0) {
        return arg0.getOverScrollMode();
    }

    @ReplaceWith(expression="view.getPaddingEnd()") @Deprecated public static int getPaddingEnd(View arg0) {
        return arg0.getPaddingEnd();
    }

    @ReplaceWith(expression="view.getPaddingStart()") @Deprecated public static int getPaddingStart(View arg0) {
        return arg0.getPaddingStart();
    }

    @ReplaceWith(expression="view.getParentForAccessibility()") @Deprecated public static ViewParent getParentForAccessibility(View arg0) {
        return arg0.getParentForAccessibility();
    }

    @ReplaceWith(expression="view.getPivotX()") @Deprecated public static float getPivotX(View arg0) {
        return arg0.getPivotX();
    }

    @ReplaceWith(expression="view.getPivotY()") @Deprecated public static float getPivotY(View arg0) {
        return arg0.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View arg0) {
        return Api23Impl.getRootWindowInsets(arg0);
    }

    @ReplaceWith(expression="view.getRotation()") @Deprecated public static float getRotation(View arg0) {
        return arg0.getRotation();
    }

    @ReplaceWith(expression="view.getRotationX()") @Deprecated public static float getRotationX(View arg0) {
        return arg0.getRotationX();
    }

    @ReplaceWith(expression="view.getRotationY()") @Deprecated public static float getRotationY(View arg0) {
        return arg0.getRotationY();
    }

    @ReplaceWith(expression="view.getScaleX()") @Deprecated public static float getScaleX(View arg0) {
        return arg0.getScaleX();
    }

    @ReplaceWith(expression="view.getScaleY()") @Deprecated public static float getScaleY(View arg0) {
        return arg0.getScaleY();
    }

    public static int getScrollIndicators(View arg0) {
        return arg0.getScrollIndicators();
    }

    public static CharSequence getStateDescription(View arg1) {
        return ViewCompat.stateDescriptionProperty().get(arg1);
    }

    public static List getSystemGestureExclusionRects(View arg2) {
        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.getSystemGestureExclusionRects(arg2);
        }

        return Collections.emptyList();
    }

    public static String getTransitionName(View arg0) {
        return arg0.getTransitionName();
    }

    @ReplaceWith(expression="view.getTranslationX()") @Deprecated public static float getTranslationX(View arg0) {
        return arg0.getTranslationX();
    }

    @ReplaceWith(expression="view.getTranslationY()") @Deprecated public static float getTranslationY(View arg0) {
        return arg0.getTranslationY();
    }

    public static float getTranslationZ(View arg0) {
        return arg0.getTranslationZ();
    }

    @Deprecated public static WindowInsetsControllerCompat getWindowInsetsController(View arg3) {
        WindowInsetsControllerCompat v2;
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController(arg3);
        }

        Context v0;
        for(v0 = arg3.getContext(); true; v0 = ((ContextWrapper)v0).getBaseContext()) {
            v2 = null;
            if(!(v0 instanceof ContextWrapper)) {
                return v2;
            }

            if((v0 instanceof Activity)) {
                Window v0_1 = ((Activity)v0).getWindow();
                if(v0_1 != null) {
                    return WindowCompat.getInsetsController(v0_1, arg3);
                }

                return v2;
            }
        }

        return v2;
    }

    @ReplaceWith(expression="view.getWindowSystemUiVisibility()") @Deprecated public static int getWindowSystemUiVisibility(View arg0) {
        return arg0.getWindowSystemUiVisibility();
    }

    @ReplaceWith(expression="view.getX()") @Deprecated public static float getX(View arg0) {
        return arg0.getX();
    }

    @ReplaceWith(expression="view.getY()") @Deprecated public static float getY(View arg0) {
        return arg0.getY();
    }

    public static float getZ(View arg0) {
        return arg0.getZ();
    }

    public static boolean hasAccessibilityDelegate(View arg0) {
        if(ViewCompat.getAccessibilityDelegateInternal(arg0) != null) {
            return 1;
        }

        return 0;
    }

    public static boolean hasExplicitFocusable(View arg0) {
        return Api26Impl.hasExplicitFocusable(arg0);
    }

    public static boolean hasNestedScrollingParent(View arg0) {
        return arg0.hasNestedScrollingParent();
    }

    public static boolean hasNestedScrollingParent(View arg1, int arg2) {
        if((arg1 instanceof NestedScrollingChild2)) {
            ((NestedScrollingChild2)arg1).hasNestedScrollingParent(arg2);
        }
        else if(arg2 == 0) {
            return ViewCompat.hasNestedScrollingParent(arg1);
        }

        return 0;
    }

    @ReplaceWith(expression="view.hasOnClickListeners()") @Deprecated public static boolean hasOnClickListeners(View arg0) {
        return arg0.hasOnClickListeners();
    }

    @ReplaceWith(expression="view.hasOverlappingRendering()") @Deprecated public static boolean hasOverlappingRendering(View arg0) {
        return arg0.hasOverlappingRendering();
    }

    @ReplaceWith(expression="view.hasTransientState()") @Deprecated public static boolean hasTransientState(View arg0) {
        return arg0.hasTransientState();
    }

    public static boolean isAccessibilityHeading(View arg1) {
        Object v1 = ViewCompat.accessibilityHeadingProperty().get(arg1);
        if(v1 != null && (((Boolean)v1).booleanValue())) {
            return 1;
        }

        return 0;
    }

    @ReplaceWith(expression="view.isAttachedToWindow()") @Deprecated public static boolean isAttachedToWindow(View arg0) {
        return arg0.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(View arg0) {
        return Api26Impl.isFocusedByDefault(arg0);
    }

    public static boolean isImportantForAccessibility(View arg0) {
        return arg0.isImportantForAccessibility();
    }

    public static boolean isImportantForAutofill(View arg0) {
        return Api26Impl.isImportantForAutofill(arg0);
    }

    public static boolean isImportantForContentCapture(View arg2) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.isImportantForContentCapture(arg2);
        }

        return 0;
    }

    @ReplaceWith(expression="view.isInLayout()") @Deprecated public static boolean isInLayout(View arg0) {
        return arg0.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(View arg0) {
        return Api26Impl.isKeyboardNavigationCluster(arg0);
    }

    @ReplaceWith(expression="view.isLaidOut()") @Deprecated public static boolean isLaidOut(View arg0) {
        return arg0.isLaidOut();
    }

    @ReplaceWith(expression="view.isLayoutDirectionResolved()") @Deprecated public static boolean isLayoutDirectionResolved(View arg0) {
        return arg0.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(View arg0) {
        return arg0.isNestedScrollingEnabled();
    }

    @ReplaceWith(expression="view.isOpaque()") @Deprecated public static boolean isOpaque(View arg0) {
        return arg0.isOpaque();
    }

    @ReplaceWith(expression="view.isPaddingRelative()") @Deprecated public static boolean isPaddingRelative(View arg0) {
        return arg0.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View arg1) {
        Object v1 = ViewCompat.screenReaderFocusableProperty().get(arg1);
        if(v1 != null && (((Boolean)v1).booleanValue())) {
            return 1;
        }

        return 0;
    }

    @ReplaceWith(expression="view.jumpDrawablesToCurrentState()") @Deprecated public static void jumpDrawablesToCurrentState(View arg0) {
        arg0.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View arg0, View arg1, int arg2) {
        return Api26Impl.keyboardNavigationClusterSearch(arg0, arg1, arg2);
    }

    static ContentInfoCompat lambda$static$0(ContentInfoCompat arg0) {
        return arg0;
    }

    static void notifyViewAccessibilityStateChangedIfNeeded(View arg4, int arg5) {
        Object v0 = arg4.getContext().getSystemService("accessibility");
        if(!((AccessibilityManager)v0).isEnabled()) {
            return;
        }

        int v1 = ViewCompat.getAccessibilityPaneTitle(arg4) == null || !arg4.isShown() || arg4.getWindowVisibility() != 0 ? 0 : 1;
        int v3 = 0x20;
        if(arg4.getAccessibilityLiveRegion() == 0) {
            if(v1 != 0) {
            }
            else if(arg5 == v3) {
                AccessibilityEvent v1_1 = AccessibilityEvent.obtain();
                arg4.onInitializeAccessibilityEvent(v1_1);
                v1_1.setEventType(v3);
                v1_1.setContentChangeTypes(arg5);
                v1_1.setSource(arg4);
                arg4.onPopulateAccessibilityEvent(v1_1);
                v1_1.getText().add(ViewCompat.getAccessibilityPaneTitle(arg4));
                ((AccessibilityManager)v0).sendAccessibilityEvent(v1_1);
                return;
            }
            else if(arg4.getParent() != null) {
                ViewParent v0_1 = arg4.getParent();
                try {
                    v0_1.notifySubtreeAccessibilityStateChanged(arg4, arg4, arg5);
                    return;
                }
                catch(AbstractMethodError v5) {
                    Log.e("ViewCompat", arg4.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", ((Throwable)v5));
                    return;
                }
            }
            else {
                return;
            }
        }

        AccessibilityEvent v0_2 = AccessibilityEvent.obtain();
        if(v1 != 0) {
        }
        else {
            v3 = 0x800;
        }

        v0_2.setEventType(v3);
        v0_2.setContentChangeTypes(arg5);
        if(v1 != 0) {
            v0_2.getText().add(ViewCompat.getAccessibilityPaneTitle(arg4));
            ViewCompat.setImportantForAccessibilityIfNeeded(arg4);
        }

        arg4.sendAccessibilityEventUnchecked(v0_2);
    }

    public static void offsetLeftAndRight(View arg0, int arg1) {
        arg0.offsetLeftAndRight(arg1);
    }

    public static void offsetTopAndBottom(View arg0, int arg1) {
        arg0.offsetTopAndBottom(arg1);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View arg2, WindowInsetsCompat arg3) {
        WindowInsets v0 = arg3.toWindowInsets();
        if(v0 != null) {
            WindowInsets v1 = arg2.onApplyWindowInsets(v0);
            if(!v1.equals(v0)) {
                return WindowInsetsCompat.toWindowInsetsCompat(v1, arg2);
            }
        }

        return arg3;
    }

    @ReplaceWith(expression="v.onInitializeAccessibilityEvent(event)") @Deprecated public static void onInitializeAccessibilityEvent(View arg0, AccessibilityEvent arg1) {
        arg0.onInitializeAccessibilityEvent(arg1);
    }

    @ReplaceWith(expression="v.onInitializeAccessibilityNodeInfo(info.unwrap())") @Deprecated public static void onInitializeAccessibilityNodeInfo(View arg0, AccessibilityNodeInfoCompat arg1) {
        arg0.onInitializeAccessibilityNodeInfo(arg1.unwrap());
    }

    @ReplaceWith(expression="v.onPopulateAccessibilityEvent(event)") @Deprecated public static void onPopulateAccessibilityEvent(View arg0, AccessibilityEvent arg1) {
        arg0.onPopulateAccessibilityEvent(arg1);
    }

    private static AccessibilityViewProperty paneTitleProperty() {
        return new AccessibilityViewProperty(id.tag_accessibility_pane_title, CharSequence.class, 8, 28) {
            CharSequence frameworkGet(View arg1) {
                return Api28Impl.getAccessibilityPaneTitle(arg1);
            }

            Object frameworkGet(View arg1) {
                return this.frameworkGet(arg1);
            }

            void frameworkSet(View arg1, CharSequence arg2) {
                Api28Impl.setAccessibilityPaneTitle(arg1, arg2);
            }

            void frameworkSet(View arg1, Object arg2) {
                this.frameworkSet(arg1, ((CharSequence)arg2));
            }

            boolean shouldUpdate(CharSequence arg1, CharSequence arg2) {
                return TextUtils.equals(arg1, arg2) ^ 1;
            }

            boolean shouldUpdate(Object arg1, Object arg2) {
                return this.shouldUpdate(((CharSequence)arg1), ((CharSequence)arg2));
            }
        };
    }

    @ReplaceWith(expression="view.performAccessibilityAction(action, arguments)") @Deprecated public static boolean performAccessibilityAction(View arg0, int arg1, Bundle arg2) {
        return arg0.performAccessibilityAction(arg1, arg2);
    }

    public static boolean performHapticFeedback(View arg1, int arg2) {
        arg2 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(arg2);
        if(arg2 == -1) {
            return 0;
        }

        return arg1.performHapticFeedback(arg2);
    }

    public static boolean performHapticFeedback(View arg1, int arg2, int arg3) {
        arg2 = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(arg2);
        if(arg2 == -1) {
            return 0;
        }

        return arg1.performHapticFeedback(arg2, arg3);
    }

    public static ContentInfoCompat performReceiveContent(View arg3, ContentInfoCompat arg4) {
        String v1 = "ViewCompat";
        if(Log.isLoggable(v1, 3)) {
            Log.d(v1, "performReceiveContent: " + arg4 + ", view=" + arg3.getClass().getSimpleName() + "[" + arg3.getId() + "]");
        }

        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.performReceiveContent(arg3, arg4);
        }

        Object v0 = arg3.getTag(id.tag_on_receive_content_listener);
        if(v0 != null) {
            arg4 = ((OnReceiveContentListener)v0).onReceiveContent(arg3, arg4);
            if(arg4 == null) {
                return null;
            }

            return ViewCompat.getFallback(arg3).onReceiveContent(arg4);
        }

        return ViewCompat.getFallback(arg3).onReceiveContent(arg4);
    }

    @ReplaceWith(expression="view.postInvalidateOnAnimation()") @Deprecated public static void postInvalidateOnAnimation(View arg0) {
        arg0.postInvalidateOnAnimation();
    }

    @ReplaceWith(expression="view.postInvalidateOnAnimation(left, top, right, bottom)") @Deprecated public static void postInvalidateOnAnimation(View arg0, int arg1, int arg2, int arg3, int arg4) {
        arg0.postInvalidateOnAnimation(arg1, arg2, arg3, arg4);
    }

    @ReplaceWith(expression="view.postOnAnimation(action)") @Deprecated public static void postOnAnimation(View arg0, Runnable arg1) {
        arg0.postOnAnimation(arg1);
    }

    @ReplaceWith(expression="view.postOnAnimationDelayed(action, delayMillis)") @Deprecated public static void postOnAnimationDelayed(View arg0, Runnable arg1, long arg2) {
        arg0.postOnAnimationDelayed(arg1, arg2);
    }

    public static void removeAccessibilityAction(View arg0, int arg1) {
        ViewCompat.removeActionWithId(arg1, arg0);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(arg0, 0);
    }

    private static void removeActionWithId(int arg2, View arg3) {
        List v3 = ViewCompat.getActionList(arg3);
        int v0;
        for(v0 = 0; v0 < v3.size(); ++v0) {
            if(v3.get(v0).getId() == arg2) {
                v3.remove(v0);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(View arg2, OnUnhandledKeyEventListenerCompat arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.removeOnUnhandledKeyEventListener(arg2, arg3);
            return;
        }

        Object v0 = arg2.getTag(id.tag_unhandled_key_listeners);
        if(v0 != null) {
            ((ArrayList)v0).remove(arg3);
            if(((ArrayList)v0).size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(arg2);
            }
        }
    }

    public static void replaceAccessibilityAction(View arg0, AccessibilityActionCompat arg1, CharSequence arg2, AccessibilityViewCommand arg3) {
        if(arg3 == null && arg2 == null) {
            ViewCompat.removeAccessibilityAction(arg0, arg1.getId());
            return;
        }

        ViewCompat.addAccessibilityAction(arg0, arg1.createReplacementAction(arg2, arg3));
    }

    public static void requestApplyInsets(View arg0) {
        arg0.requestApplyInsets();
    }

    public static View requireViewById(View arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.requireViewById(arg2, arg3);
        }

        arg2 = arg2.findViewById(arg3);
        if(arg2 != null) {
            return arg2;
        }

        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated public static int resolveSizeAndState(int arg0, int arg1, int arg2) {
        return View.resolveSizeAndState(arg0, arg1, arg2);
    }

    public static boolean restoreDefaultFocus(View arg0) {
        return Api26Impl.restoreDefaultFocus(arg0);
    }

    public static void saveAttributeDataForStyleable(View arg2, Context arg3, int[] arg4, AttributeSet arg5, TypedArray arg6, int arg7, int arg8) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        }
    }

    private static AccessibilityViewProperty screenReaderFocusableProperty() {
        return new AccessibilityViewProperty(id.tag_screen_reader_focusable, Boolean.class, 28) {
            Boolean frameworkGet(View arg1) {
                return Boolean.valueOf(Api28Impl.isScreenReaderFocusable(arg1));
            }

            Object frameworkGet(View arg1) {
                return this.frameworkGet(arg1);
            }

            void frameworkSet(View arg1, Boolean arg2) {
                Api28Impl.setScreenReaderFocusable(arg1, arg2.booleanValue());
            }

            void frameworkSet(View arg1, Object arg2) {
                this.frameworkSet(arg1, ((Boolean)arg2));
            }

            boolean shouldUpdate(Boolean arg1, Boolean arg2) {
                return this.booleanNullToFalseEquals(arg1, arg2) ^ 1;
            }

            boolean shouldUpdate(Object arg1, Object arg2) {
                return this.shouldUpdate(((Boolean)arg1), ((Boolean)arg2));
            }
        };
    }

    public static void setAccessibilityDelegate(View arg1, AccessibilityDelegateCompat arg2) {
        if(arg2 == null && ((ViewCompat.getAccessibilityDelegateInternal(arg1) instanceof AccessibilityDelegateAdapter))) {
            arg2 = new AccessibilityDelegateCompat();
        }

        ViewCompat.setImportantForAccessibilityIfNeeded(arg1);
        View$AccessibilityDelegate v2 = arg2 == null ? null : arg2.getBridge();
        arg1.setAccessibilityDelegate(v2);
    }

    public static void setAccessibilityHeading(View arg1, boolean arg2) {
        ViewCompat.accessibilityHeadingProperty().set(arg1, Boolean.valueOf(arg2));
    }

    @ReplaceWith(expression="view.setAccessibilityLiveRegion(mode)") @Deprecated public static void setAccessibilityLiveRegion(View arg0, int arg1) {
        arg0.setAccessibilityLiveRegion(arg1);
    }

    public static void setAccessibilityPaneTitle(View arg1, CharSequence arg2) {
        ViewCompat.paneTitleProperty().set(arg1, arg2);
        if(arg2 != null) {
            ViewCompat.sAccessibilityPaneVisibilityManager.addAccessibilityPane(arg1);
            return;
        }

        ViewCompat.sAccessibilityPaneVisibilityManager.removeAccessibilityPane(arg1);
    }

    @ReplaceWith(expression="view.setActivated(activated)") @Deprecated public static void setActivated(View arg0, boolean arg1) {
        arg0.setActivated(arg1);
    }

    @ReplaceWith(expression="view.setAlpha(value)") @Deprecated public static void setAlpha(View arg0, float arg1) {
        arg0.setAlpha(arg1);
    }

    public static void setAutofillHints(View arg0, String[] arg1) {
        Api26Impl.setAutofillHints(arg0, arg1);
    }

    public static void setAutofillId(View arg2, AutofillIdCompat arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setAutofillId(arg2, arg3);
        }
    }

    @ReplaceWith(expression="view.setBackground(background)") @Deprecated public static void setBackground(View arg0, Drawable arg1) {
        arg0.setBackground(arg1);
    }

    public static void setBackgroundTintList(View arg0, ColorStateList arg1) {
        arg0.setBackgroundTintList(arg1);
    }

    public static void setBackgroundTintMode(View arg0, PorterDuff$Mode arg1) {
        arg0.setBackgroundTintMode(arg1);
    }

    @Deprecated public static void setChildrenDrawingOrderEnabled(ViewGroup arg8, boolean arg9) {
        String v0 = "Unable to invoke childrenDrawingOrderEnabled";
        String v2 = "ViewCompat";
        if(ViewCompat.sChildrenDrawingOrderMethod != null) {
            goto label_19;
        }

        try {
            ViewCompat.sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
        }
        catch(NoSuchMethodException v3) {
            Log.e(v2, "Unable to find childrenDrawingOrderEnabled", ((Throwable)v3));
        }

        ViewCompat.sChildrenDrawingOrderMethod.setAccessible(true);
        try {
        label_19:
            ViewCompat.sChildrenDrawingOrderMethod.invoke(arg8, Boolean.valueOf(arg9));
        }
        catch(InvocationTargetException v8) {
            Log.e(v2, v0, ((Throwable)v8));
        }
        catch(IllegalArgumentException v8_1) {
            Log.e(v2, v0, ((Throwable)v8_1));
        }
        catch(IllegalAccessException v8_2) {
            Log.e(v2, v0, ((Throwable)v8_2));
        }
    }

    @ReplaceWith(expression="view.setClipBounds(clipBounds)") @Deprecated public static void setClipBounds(View arg0, Rect arg1) {
        arg0.setClipBounds(arg1);
    }

    public static void setContentCaptureSession(View arg2, ContentCaptureSessionCompat arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.setContentCaptureSession(arg2, arg3);
        }
    }

    public static void setElevation(View arg0, float arg1) {
        arg0.setElevation(arg1);
    }

    @ReplaceWith(expression="view.setFitsSystemWindows(fitSystemWindows)") @Deprecated public static void setFitsSystemWindows(View arg0, boolean arg1) {
        arg0.setFitsSystemWindows(arg1);
    }

    public static void setFocusedByDefault(View arg0, boolean arg1) {
        Api26Impl.setFocusedByDefault(arg0, arg1);
    }

    @ReplaceWith(expression="view.setHasTransientState(hasTransientState)") @Deprecated public static void setHasTransientState(View arg0, boolean arg1) {
        arg0.setHasTransientState(arg1);
    }

    @ReplaceWith(expression="view.setImportantForAccessibility(mode)") @Deprecated public static void setImportantForAccessibility(View arg0, int arg1) {
        arg0.setImportantForAccessibility(arg1);
    }

    private static void setImportantForAccessibilityIfNeeded(View arg1) {
        if(arg1.getImportantForAccessibility() == 0) {
            arg1.setImportantForAccessibility(1);
        }
    }

    public static void setImportantForAutofill(View arg0, int arg1) {
        Api26Impl.setImportantForAutofill(arg0, arg1);
    }

    public static void setImportantForContentCapture(View arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            Api30Impl.setImportantForContentCapture(arg2, arg3);
        }
    }

    public static void setKeyboardNavigationCluster(View arg0, boolean arg1) {
        Api26Impl.setKeyboardNavigationCluster(arg0, arg1);
    }

    @ReplaceWith(expression="view.setLabelFor(labeledId)") @Deprecated public static void setLabelFor(View arg0, int arg1) {
        arg0.setLabelFor(arg1);
    }

    @ReplaceWith(expression="view.setLayerPaint(paint)") @Deprecated public static void setLayerPaint(View arg0, Paint arg1) {
        arg0.setLayerPaint(arg1);
    }

    @ReplaceWith(expression="view.setLayerType(layerType, paint)") @Deprecated public static void setLayerType(View arg0, int arg1, Paint arg2) {
        arg0.setLayerType(arg1, arg2);
    }

    @ReplaceWith(expression="view.setLayoutDirection(layoutDirection)") @Deprecated public static void setLayoutDirection(View arg0, int arg1) {
        arg0.setLayoutDirection(arg1);
    }

    public static void setNestedScrollingEnabled(View arg0, boolean arg1) {
        arg0.setNestedScrollingEnabled(arg1);
    }

    public static void setNextClusterForwardId(View arg0, int arg1) {
        Api26Impl.setNextClusterForwardId(arg0, arg1);
    }

    public static void setOnApplyWindowInsetsListener(View arg0, OnApplyWindowInsetsListener arg1) {
        Api21Impl.setOnApplyWindowInsetsListener(arg0, arg1);
    }

    public static void setOnReceiveContentListener(View arg6, String[] arg7, OnReceiveContentListener arg8) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            Api31Impl.setOnReceiveContentListener(arg6, arg7, arg8);
            return;
        }

        if(arg7 == null || arg7.length == 0) {
            arg7 = null;
        }

        int v0 = 0;
        if(arg8 != null) {
            boolean v2 = 0 != 0 ? true : false;
            Preconditions.checkArgument(v2, "When the listener is set, MIME types must also be set");
        }

        if(0 != 0) {
            int v2_1 = arg7.length;
            int v3 = 0;
            while(v3 < v2_1) {
                if(arg7[v3].startsWith("*")) {
                    v0 = 1;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }

            Preconditions.checkArgument(v0 ^ 1, "A MIME type set here must not start with *: " + Arrays.toString(((Object[])arg7)));
        }

        arg6.setTag(id.tag_on_receive_content_mime_types, arg7);
        arg6.setTag(id.tag_on_receive_content_listener, arg8);
    }

    @ReplaceWith(expression="view.setOverScrollMode(overScrollMode)") @Deprecated public static void setOverScrollMode(View arg0, int arg1) {
        arg0.setOverScrollMode(arg1);
    }

    @ReplaceWith(expression="view.setPaddingRelative(start, top, end, bottom)") @Deprecated public static void setPaddingRelative(View arg0, int arg1, int arg2, int arg3, int arg4) {
        arg0.setPaddingRelative(arg1, arg2, arg3, arg4);
    }

    @ReplaceWith(expression="view.setPivotX(value)") @Deprecated public static void setPivotX(View arg0, float arg1) {
        arg0.setPivotX(arg1);
    }

    @ReplaceWith(expression="view.setPivotY(value)") @Deprecated public static void setPivotY(View arg0, float arg1) {
        arg0.setPivotY(arg1);
    }

    public static void setPointerIcon(View arg0, PointerIconCompat arg1) {
        Object v1;
        if(arg1 != null) {
            v1 = arg1.getPointerIcon();
        }
        else {
            PointerIcon v1_1 = null;
        }

        Api24Impl.setPointerIcon(arg0, ((PointerIcon)v1));
    }

    @ReplaceWith(expression="view.setRotation(value)") @Deprecated public static void setRotation(View arg0, float arg1) {
        arg0.setRotation(arg1);
    }

    @ReplaceWith(expression="view.setRotationX(value)") @Deprecated public static void setRotationX(View arg0, float arg1) {
        arg0.setRotationX(arg1);
    }

    @ReplaceWith(expression="view.setRotationY(value)") @Deprecated public static void setRotationY(View arg0, float arg1) {
        arg0.setRotationY(arg1);
    }

    @ReplaceWith(expression="view.setSaveFromParentEnabled(enabled)") @Deprecated public static void setSaveFromParentEnabled(View arg0, boolean arg1) {
        arg0.setSaveFromParentEnabled(arg1);
    }

    @ReplaceWith(expression="view.setScaleX(value)") @Deprecated public static void setScaleX(View arg0, float arg1) {
        arg0.setScaleX(arg1);
    }

    @ReplaceWith(expression="view.setScaleY(value)") @Deprecated public static void setScaleY(View arg0, float arg1) {
        arg0.setScaleY(arg1);
    }

    public static void setScreenReaderFocusable(View arg1, boolean arg2) {
        ViewCompat.screenReaderFocusableProperty().set(arg1, Boolean.valueOf(arg2));
    }

    public static void setScrollIndicators(View arg0, int arg1, int arg2) {
        arg0.setScrollIndicators(arg1, arg2);
    }

    public static void setScrollIndicators(View arg0, int arg1) {
        arg0.setScrollIndicators(arg1);
    }

    public static void setStateDescription(View arg1, CharSequence arg2) {
        ViewCompat.stateDescriptionProperty().set(arg1, arg2);
    }

    public static void setSystemGestureExclusionRects(View arg2, List arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.setSystemGestureExclusionRects(arg2, arg3);
        }
    }

    public static void setTooltipText(View arg0, CharSequence arg1) {
        Api26Impl.setTooltipText(arg0, arg1);
    }

    public static void setTransitionName(View arg0, String arg1) {
        arg0.setTransitionName(arg1);
    }

    @ReplaceWith(expression="view.setTranslationX(value)") @Deprecated public static void setTranslationX(View arg0, float arg1) {
        arg0.setTranslationX(arg1);
    }

    @ReplaceWith(expression="view.setTranslationY(value)") @Deprecated public static void setTranslationY(View arg0, float arg1) {
        arg0.setTranslationY(arg1);
    }

    public static void setTranslationZ(View arg0, float arg1) {
        arg0.setTranslationZ(arg1);
    }

    public static void setWindowInsetsAnimationCallback(View arg0, Callback arg1) {
        WindowInsetsAnimationCompat.setCallback(arg0, arg1);
    }

    @ReplaceWith(expression="view.setX(value)") @Deprecated public static void setX(View arg0, float arg1) {
        arg0.setX(arg1);
    }

    @ReplaceWith(expression="view.setY(value)") @Deprecated public static void setY(View arg0, float arg1) {
        arg0.setY(arg1);
    }

    public static void setZ(View arg0, float arg1) {
        arg0.setZ(arg1);
    }

    public static boolean startDragAndDrop(View arg0, ClipData arg1, View$DragShadowBuilder arg2, Object arg3, int arg4) {
        return Api24Impl.startDragAndDrop(arg0, arg1, arg2, arg3, arg4);
    }

    public static boolean startNestedScroll(View arg0, int arg1) {
        return arg0.startNestedScroll(arg1);
    }

    public static boolean startNestedScroll(View arg1, int arg2, int arg3) {
        if((arg1 instanceof NestedScrollingChild2)) {
            return ((NestedScrollingChild2)arg1).startNestedScroll(arg2, arg3);
        }

        if(arg3 == 0) {
            return ViewCompat.startNestedScroll(arg1, arg2);
        }

        return 0;
    }

    private static AccessibilityViewProperty stateDescriptionProperty() {
        return new AccessibilityViewProperty(id.tag_state_description, CharSequence.class, 0x40, 30) {
            CharSequence frameworkGet(View arg1) {
                return Api30Impl.getStateDescription(arg1);
            }

            Object frameworkGet(View arg1) {
                return this.frameworkGet(arg1);
            }

            void frameworkSet(View arg1, CharSequence arg2) {
                Api30Impl.setStateDescription(arg1, arg2);
            }

            void frameworkSet(View arg1, Object arg2) {
                this.frameworkSet(arg1, ((CharSequence)arg2));
            }

            boolean shouldUpdate(CharSequence arg1, CharSequence arg2) {
                return TextUtils.equals(arg1, arg2) ^ 1;
            }

            boolean shouldUpdate(Object arg1, Object arg2) {
                return this.shouldUpdate(((CharSequence)arg1), ((CharSequence)arg2));
            }
        };
    }

    public static void stopNestedScroll(View arg0) {
        arg0.stopNestedScroll();
    }

    public static void stopNestedScroll(View arg1, int arg2) {
        if((arg1 instanceof NestedScrollingChild2)) {
            ((NestedScrollingChild2)arg1).stopNestedScroll(arg2);
            return;
        }

        if(arg2 == 0) {
            ViewCompat.stopNestedScroll(arg1);
        }
    }

    public static void transformMatrixToGlobal(View arg2, Matrix arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.transformMatrixToGlobal(arg2, arg3);
            return;
        }

        if(ViewCompat.sTryHiddenViewTransformMatrixToGlobal) {
            try {
                Api29Impl.transformMatrixToGlobal(arg2, arg3);
                return;
            }
            catch(NoSuchMethodError ) {
                ViewCompat.sTryHiddenViewTransformMatrixToGlobal = false;
            }
        }

        ViewCompat.fallbackTransformMatrixToGlobal(arg2, arg3);
    }

    public static void updateDragShadow(View arg0, View$DragShadowBuilder arg1) {
        Api24Impl.updateDragShadow(arg0, arg1);
    }
}


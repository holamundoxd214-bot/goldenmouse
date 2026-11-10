package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build$VERSION;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode$Callback;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window$Callback;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper$CallbackWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout$OnAttachListener;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat$ThemeCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends AppCompatDelegate implements LayoutInflater$Factory2, Callback {
    class androidx.appcompat.app.AppCompatDelegateImpl$1 implements Thread$UncaughtExceptionHandler {
        androidx.appcompat.app.AppCompatDelegateImpl$1(Thread$UncaughtExceptionHandler arg1) {
            this.val$defHandler = arg1;
            super();
        }

        private boolean shouldWrapException(Throwable arg2) {
            if((arg2 instanceof Resources$NotFoundException)) {
                String v1 = arg2.getMessage();
                if(v1 != null) {
                    if(!v1.contains("drawable") && !v1.contains("Drawable")) {
                        return 0;
                    }

                    return 1;
                }
            }

            return 0;
        }

        public void uncaughtException(Thread arg4, Throwable arg5) {
            if(this.shouldWrapException(arg5)) {
                Resources$NotFoundException v0 = new Resources$NotFoundException(arg5.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                ((Throwable)v0).initCause(arg5.getCause());
                ((Throwable)v0).setStackTrace(arg5.getStackTrace());
                this.val$defHandler.uncaughtException(arg4, ((Throwable)v0));
                return;
            }

            this.val$defHandler.uncaughtException(arg4, arg5);
        }
    }

    class androidx.appcompat.app.AppCompatDelegateImpl$2 implements Runnable {
        androidx.appcompat.app.AppCompatDelegateImpl$2(AppCompatDelegateImpl arg1) {
            AppCompatDelegateImpl.this = arg1;
            super();
        }

        public void run() {
            if((AppCompatDelegateImpl.this.mInvalidatePanelMenuFeatures & 1) != 0) {
                AppCompatDelegateImpl.this.doInvalidatePanelMenu(0);
            }

            if((AppCompatDelegateImpl.this.mInvalidatePanelMenuFeatures & 0x1000) != 0) {
                AppCompatDelegateImpl.this.doInvalidatePanelMenu(108);
            }

            AppCompatDelegateImpl.this.mInvalidatePanelMenuPosted = false;
            AppCompatDelegateImpl.this.mInvalidatePanelMenuFeatures = 0;
        }
    }

    class ActionBarDrawableToggleImpl implements Delegate {
        ActionBarDrawableToggleImpl(AppCompatDelegateImpl arg1) {
            AppCompatDelegateImpl.this = arg1;
            super();
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.getActionBarThemedContext();
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray v2 = TintTypedArray.obtainStyledAttributes(this.getActionBarThemedContext(), null, new int[]{attr.homeAsUpIndicator});
            Drawable v0 = v2.getDrawable(0);
            v2.recycle();
            return v0;
        }

        public boolean isNavigationVisible() {
            ActionBar v0 = AppCompatDelegateImpl.this.getSupportActionBar();
            if(v0 != null && (v0.getDisplayOptions() & 4) != 0) {
                return 1;
            }

            return 0;
        }

        public void setActionBarDescription(int arg1) {
            ActionBar v0 = AppCompatDelegateImpl.this.getSupportActionBar();
            if(v0 != null) {
                v0.setHomeActionContentDescription(arg1);
            }
        }

        public void setActionBarUpIndicator(Drawable arg1, int arg2) {
            ActionBar v0 = AppCompatDelegateImpl.this.getSupportActionBar();
            if(v0 != null) {
                v0.setHomeAsUpIndicator(arg1);
                v0.setHomeActionContentDescription(arg2);
            }
        }
    }

    interface ActionBarMenuCallback {
        View onCreatePanelView(int arg1);

        boolean onPreparePanel(int arg1);
    }

    final class ActionMenuPresenterCallback implements androidx.appcompat.view.menu.MenuPresenter$Callback {
        ActionMenuPresenterCallback(AppCompatDelegateImpl arg1) {
            AppCompatDelegateImpl.this = arg1;
            super();
        }

        public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
            AppCompatDelegateImpl.this.checkCloseActionMenu(arg1);
        }

        public boolean onOpenSubMenu(MenuBuilder arg2) {
            Window$Callback v1 = AppCompatDelegateImpl.this.getWindowCallback();
            if(v1 != null) {
                v1.onMenuOpened(108, ((Menu)arg2));
            }

            return 1;
        }
    }

    class ActionModeCallbackWrapperV9 implements androidx.appcompat.view.ActionMode$Callback {
        private androidx.appcompat.view.ActionMode$Callback mWrapped;

        public ActionModeCallbackWrapperV9(AppCompatDelegateImpl arg1, androidx.appcompat.view.ActionMode$Callback arg2) {
            AppCompatDelegateImpl.this = arg1;
            super();
            this.mWrapped = arg2;
        }

        public boolean onActionItemClicked(ActionMode arg1, MenuItem arg2) {
            return this.mWrapped.onActionItemClicked(arg1, arg2);
        }

        public boolean onCreateActionMode(ActionMode arg1, Menu arg2) {
            return this.mWrapped.onCreateActionMode(arg1, arg2);
        }

        public void onDestroyActionMode(ActionMode arg3) {
            this.mWrapped.onDestroyActionMode(arg3);
            if(AppCompatDelegateImpl.this.mActionModePopup != null) {
                AppCompatDelegateImpl.this.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.mShowActionModePopup);
            }

            if(AppCompatDelegateImpl.this.mActionModeView != null) {
                AppCompatDelegateImpl.this.endOnGoingFadeAnimation();
                AppCompatDelegateImpl.this.mFadeAnim = ViewCompat.animate(AppCompatDelegateImpl.this.mActionModeView).alpha(0f);
                AppCompatDelegateImpl.this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationEnd(View arg2) {
                        this.this$1.this$0.mActionModeView.setVisibility(8);
                        PopupWindow v2 = this.this$1.this$0.mActionModePopup;
                        ActionModeCallbackWrapperV9 v0 = this.this$1;
                        if(v2 != null) {
                            v0.this$0.mActionModePopup.dismiss();
                        }
                        else if((v0.this$0.mActionModeView.getParent() instanceof View)) {
                            ViewCompat.requestApplyInsets(this.this$1.this$0.mActionModeView.getParent());
                        }

                        this.this$1.this$0.mActionModeView.killMode();
                        this.this$1.this$0.mFadeAnim.setListener(null);
                        this.this$1.this$0.mFadeAnim = null;
                        ViewCompat.requestApplyInsets(this.this$1.this$0.mSubDecor);
                    }
                });
            }

            if(AppCompatDelegateImpl.this.mAppCompatCallback != null) {
                AppCompatDelegateImpl.this.mAppCompatCallback.onSupportActionModeFinished(AppCompatDelegateImpl.this.mActionMode);
            }

            AppCompatDelegateImpl.this.mActionMode = null;
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.mSubDecor);
            AppCompatDelegateImpl.this.updateBackInvokedCallbackState();
        }

        public boolean onPrepareActionMode(ActionMode arg2, Menu arg3) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.mSubDecor);
            return this.mWrapped.onPrepareActionMode(arg2, arg3);
        }
    }

    class Api17Impl {
        private Api17Impl() {
            super();
        }

        static Context createConfigurationContext(Context arg0, Configuration arg1) {
            return arg0.createConfigurationContext(arg1);
        }

        static void generateConfigDelta_densityDpi(Configuration arg1, Configuration arg2, Configuration arg3) {
            if(arg1.densityDpi != arg2.densityDpi) {
                arg3.densityDpi = arg2.densityDpi;
            }
        }

        static void setLayoutDirection(Configuration arg0, Locale arg1) {
            arg0.setLayoutDirection(arg1);
        }

        static void setLocale(Configuration arg0, Locale arg1) {
            arg0.setLocale(arg1);
        }
    }

    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static boolean isPowerSaveMode(PowerManager arg0) {
            return arg0.isPowerSaveMode();
        }

        static String toLanguageTag(Locale arg0) {
            return arg0.toLanguageTag();
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void generateConfigDelta_locale(Configuration arg1, Configuration arg2, Configuration arg3) {
            LocaleList v1 = arg1.getLocales();
            LocaleList v0 = arg2.getLocales();
            if(!v1.equals(v0)) {
                arg3.setLocales(v0);
                arg3.locale = arg2.locale;
            }
        }

        static LocaleListCompat getLocales(Configuration arg0) {
            return LocaleListCompat.forLanguageTags(arg0.getLocales().toLanguageTags());
        }

        public static void setDefaultLocales(LocaleListCompat arg0) {
            LocaleList.setDefault(LocaleList.forLanguageTags(arg0.toLanguageTags()));
        }

        static void setLocales(Configuration arg0, LocaleListCompat arg1) {
            arg0.setLocales(LocaleList.forLanguageTags(arg1.toLanguageTags()));
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static void generateConfigDelta_colorMode(Configuration arg2, Configuration arg3, Configuration arg4) {
            if((arg2.colorMode & 3) != (arg3.colorMode & 3)) {
                arg4.colorMode |= arg3.colorMode & 3;
            }

            if((arg2.colorMode & 12) != (arg3.colorMode & 12)) {
                arg4.colorMode |= arg3.colorMode & 12;
            }
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity arg0) {
            return arg0.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback registerOnBackPressedCallback(Object arg1, AppCompatDelegateImpl arg2) {
            Objects.requireNonNull(arg2);
            AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0 v0 = new AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0(arg2);
            ((OnBackInvokedDispatcher)arg1).registerOnBackInvokedCallback(1000000, ((OnBackInvokedCallback)v0));
            return ((OnBackInvokedCallback)v0);
        }

        static void unregisterOnBackInvokedCallback(Object arg0, Object arg1) {
            ((OnBackInvokedDispatcher)arg0).unregisterOnBackInvokedCallback(((OnBackInvokedCallback)arg1));
        }
    }

    class AppCompatWindowCallback extends WindowCallbackWrapper {
        private ActionBarMenuCallback mActionBarCallback;
        private boolean mDispatchKeyEventBypassEnabled;
        private boolean mOnContentChangedBypassEnabled;
        private boolean mOnPanelClosedBypassEnabled;

        AppCompatWindowCallback(AppCompatDelegateImpl arg1, Window$Callback arg2) {
            AppCompatDelegateImpl.this = arg1;
            super(arg2);
        }

        public boolean bypassDispatchKeyEvent(Window$Callback arg3, KeyEvent arg4) {
            boolean v3_1;
            try {
                this.mDispatchKeyEventBypassEnabled = true;
                v3_1 = arg3.dispatchKeyEvent(arg4);
            }
            catch(Throwable v3) {
                this.mDispatchKeyEventBypassEnabled = false;
                throw v3;
            }

            this.mDispatchKeyEventBypassEnabled = false;
            return v3_1;
        }

        public void bypassOnContentChanged(Window$Callback arg3) {
            try {
                this.mOnContentChangedBypassEnabled = true;
                arg3.onContentChanged();
            }
            catch(Throwable v3) {
                this.mOnContentChangedBypassEnabled = false;
                throw v3;
            }

            this.mOnContentChangedBypassEnabled = false;
        }

        public void bypassOnPanelClosed(Window$Callback arg3, int arg4, Menu arg5) {
            try {
                this.mOnPanelClosedBypassEnabled = true;
                arg3.onPanelClosed(arg4, arg5);
            }
            catch(Throwable v3) {
                this.mOnPanelClosedBypassEnabled = false;
                throw v3;
            }

            this.mOnPanelClosedBypassEnabled = false;
        }

        public boolean dispatchKeyEvent(KeyEvent arg2) {
            if(this.mDispatchKeyEventBypassEnabled) {
                return this.getWrapped().dispatchKeyEvent(arg2);
            }

            if(!AppCompatDelegateImpl.this.dispatchKeyEvent(arg2)) {
                if(super.dispatchKeyEvent(arg2)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent arg2) {
            if(!super.dispatchKeyShortcutEvent(arg2)) {
                if(AppCompatDelegateImpl.this.onKeyShortcut(arg2.getKeyCode(), arg2)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public void onContentChanged() {
            if(this.mOnContentChangedBypassEnabled) {
                this.getWrapped().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int arg2, Menu arg3) {
            if(arg2 == 0 && !(arg3 instanceof MenuBuilder)) {
                return 0;
            }

            return super.onCreatePanelMenu(arg2, arg3);
        }

        public View onCreatePanelView(int arg2) {
            ActionBarMenuCallback v0 = this.mActionBarCallback;
            if(v0 != null) {
                View v0_1 = v0.onCreatePanelView(arg2);
                if(v0_1 != null) {
                    return v0_1;
                }
            }

            return super.onCreatePanelView(arg2);
        }

        public boolean onMenuOpened(int arg1, Menu arg2) {
            super.onMenuOpened(arg1, arg2);
            AppCompatDelegateImpl.this.onMenuOpened(arg1);
            return 1;
        }

        public void onPanelClosed(int arg2, Menu arg3) {
            if(this.mOnPanelClosedBypassEnabled) {
                this.getWrapped().onPanelClosed(arg2, arg3);
                return;
            }

            super.onPanelClosed(arg2, arg3);
            AppCompatDelegateImpl.this.onPanelClosed(arg2);
        }

        public boolean onPreparePanel(int arg5, View arg6, Menu arg7) {
            Menu v0 = (arg7 instanceof MenuBuilder) ? arg7 : null;
            if(arg5 == 0 && v0 == null) {
                return 0;
            }

            boolean v2 = true;
            if(v0 != null) {
                ((MenuBuilder)v0).setOverrideVisibleItems(true);
            }

            ActionBarMenuCallback v3 = this.mActionBarCallback;
            if(v3 == null || !v3.onPreparePanel(arg5)) {
                v2 = false;
            }
            else {
            }

            if(!v2) {
                v2 = super.onPreparePanel(arg5, arg6, arg7);
            }

            if(v0 != null) {
                ((MenuBuilder)v0).setOverrideVisibleItems(false);
            }

            return v2;
        }

        public void onProvideKeyboardShortcuts(List arg4, Menu arg5, int arg6) {
            PanelFeatureState v0 = AppCompatDelegateImpl.this.getPanelState(0, true);
            if(v0 != null && v0.menu != null) {
                super.onProvideKeyboardShortcuts(arg4, v0.menu, arg6);
                return;
            }

            super.onProvideKeyboardShortcuts(arg4, arg5, arg6);
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode$Callback arg1) {
            return null;
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode$Callback arg2, int arg3) {
            if(AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled()) {
                if(arg3 != 0) {
                }
                else {
                    return this.startAsSupportActionMode(arg2);
                }
            }

            return super.onWindowStartingActionMode(arg2, arg3);
        }

        void setActionBarCallback(ActionBarMenuCallback arg1) {
            this.mActionBarCallback = arg1;
        }

        final android.view.ActionMode startAsSupportActionMode(ActionMode$Callback arg3) {
            CallbackWrapper v0 = new CallbackWrapper(AppCompatDelegateImpl.this.mContext, arg3);
            ActionMode v2 = AppCompatDelegateImpl.this.startSupportActionMode(((androidx.appcompat.view.ActionMode$Callback)v0));
            if(v2 != null) {
                return v0.getActionModeWrapper(v2);
            }

            return null;
        }
    }

    class AutoBatteryNightModeManager extends AutoNightModeManager {
        private final PowerManager mPowerManager;

        AutoBatteryNightModeManager(AppCompatDelegateImpl arg1, Context arg2) {
            AppCompatDelegateImpl.this = arg1;
            super(arg1);
            this.mPowerManager = arg2.getApplicationContext().getSystemService("power");
        }

        IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter v1 = new IntentFilter();
            v1.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return v1;
        }

        public int getApplyableNightMode() {
            if(Api21Impl.isPowerSaveMode(this.mPowerManager)) {
                return 2;
            }

            return 1;
        }

        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    abstract class AutoNightModeManager {
        private BroadcastReceiver mReceiver;

        AutoNightModeManager(AppCompatDelegateImpl arg1) {
            AppCompatDelegateImpl.this = arg1;
            super();
        }

        void cleanup() {
            if(this.mReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.mContext.unregisterReceiver(this.mReceiver);
                    goto label_6;
                }
                catch(IllegalArgumentException ) {
                label_6:
                    this.mReceiver = null;
                }
            }
        }

        abstract IntentFilter createIntentFilterForBroadcastReceiver();

        abstract int getApplyableNightMode();

        boolean isListening() {
            if(this.mReceiver != null) {
                return 1;
            }

            return 0;
        }

        abstract void onChange();

        void setup() {
            this.cleanup();
            IntentFilter v0 = this.createIntentFilterForBroadcastReceiver();
            if(v0 != null) {
                if(v0.countActions() == 0) {
                }
                else {
                    if(this.mReceiver == null) {
                        this.mReceiver = new BroadcastReceiver() {
                            public void onReceive(Context arg1, Intent arg2) {
                                this.this$1.onChange();
                            }
                        };
                    }

                    AppCompatDelegateImpl.this.mContext.registerReceiver(this.mReceiver, v0);
                }
            }
        }
    }

    class AutoTimeNightModeManager extends AutoNightModeManager {
        private final TwilightManager mTwilightManager;

        AutoTimeNightModeManager(AppCompatDelegateImpl arg1, TwilightManager arg2) {
            AppCompatDelegateImpl.this = arg1;
            super(arg1);
            this.mTwilightManager = arg2;
        }

        IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter v1 = new IntentFilter();
            v1.addAction("android.intent.action.TIME_SET");
            v1.addAction("android.intent.action.TIMEZONE_CHANGED");
            v1.addAction("android.intent.action.TIME_TICK");
            return v1;
        }

        public int getApplyableNightMode() {
            if(this.mTwilightManager.isNight()) {
                return 2;
            }

            return 1;
        }

        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
            super();
        }

        static void applyOverrideConfiguration(ContextThemeWrapper arg0, Configuration arg1) {
            arg0.applyOverrideConfiguration(arg1);
        }
    }

    class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(AppCompatDelegateImpl arg1, Context arg2) {
            AppCompatDelegateImpl.this = arg1;
            super(arg2);
        }

        public boolean dispatchKeyEvent(KeyEvent arg2) {
            if(!AppCompatDelegateImpl.this.dispatchKeyEvent(arg2)) {
                if(super.dispatchKeyEvent(arg2)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        private boolean isOutOfBounds(int arg2, int arg3) {
            int v0 = -5;
            if(arg2 >= v0 && arg3 >= v0 && arg2 <= this.getWidth() + 5) {
                if(arg3 > this.getHeight() + 5) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public boolean onInterceptTouchEvent(MotionEvent arg3) {
            if(arg3.getAction() == 0 && (this.isOutOfBounds(((int)arg3.getX()), ((int)arg3.getY())))) {
                AppCompatDelegateImpl.this.closePanel(0);
                return 1;
            }

            return super.onInterceptTouchEvent(arg3);
        }

        public void setBackgroundResource(int arg2) {
            this.setBackgroundDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
        }
    }

    public final class PanelFeatureState {
        class SavedState implements Parcelable {
            class androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1 implements Parcelable$ClassLoaderCreator {
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1() {
                    super();
                }

                public SavedState createFromParcel(Parcel arg1) {
                    return SavedState.readFromParcel(arg1, null);
                }

                public SavedState createFromParcel(Parcel arg1, ClassLoader arg2) {
                    return SavedState.readFromParcel(arg1, arg2);
                }

                public Object createFromParcel(Parcel arg1) {
                    return this.createFromParcel(arg1);
                }

                public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
                    return this.createFromParcel(arg1, arg2);
                }

                public SavedState[] newArray(int arg1) {
                    return new SavedState[arg1];
                }

                public Object[] newArray(int arg1) {
                    return this.newArray(arg1);
                }
            }

            public static final Parcelable$Creator CREATOR;
            int featureId;
            boolean isOpen;
            Bundle menuState;

            static {
                SavedState.CREATOR = new androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1();
            }

            SavedState() {
                super();
            }

            public int describeContents() {
                return 0;
            }

            static SavedState readFromParcel(Parcel arg3, ClassLoader arg4) {
                SavedState v0 = new SavedState();
                v0.featureId = arg3.readInt();
                boolean v2 = true;
                if(arg3.readInt() == 1) {
                }
                else {
                    v2 = false;
                }

                v0.isOpen = v2;
                if(v2) {
                    v0.menuState = arg3.readBundle(arg4);
                }

                return v0;
            }

            public void writeToParcel(Parcel arg1, int arg2) {
                arg1.writeInt(this.featureId);
                arg1.writeInt(this.isOpen);
                if(this.isOpen) {
                    arg1.writeBundle(this.menuState);
                }
            }
        }

        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;
        int x;
        int y;

        PanelFeatureState(int arg1) {
            super();
            this.featureId = arg1;
            this.refreshDecorView = false;
        }

        void applyFrozenState() {
            MenuBuilder v0 = this.menu;
            if(v0 != null) {
                Bundle v1 = this.frozenMenuState;
                if(v1 != null) {
                    v0.restorePresenterStates(v1);
                    this.frozenMenuState = null;
                }
            }
        }

        public void clearMenuPresenters() {
            MenuBuilder v0 = this.menu;
            if(v0 != null) {
                v0.removeMenuPresenter(this.listMenuPresenter);
            }

            this.listMenuPresenter = null;
        }

        MenuView getListMenuView(androidx.appcompat.view.menu.MenuPresenter$Callback arg4) {
            if(this.menu == null) {
                return null;
            }

            if(this.listMenuPresenter == null) {
                ListMenuPresenter v0 = new ListMenuPresenter(this.listPresenterContext, layout.abc_list_menu_item_layout);
                this.listMenuPresenter = v0;
                v0.setCallback(arg4);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }

            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            if(this.shownPanelView == null) {
                return 0;
            }

            if(this.createdPanelView != null) {
                return 1;
            }

            if(this.listMenuPresenter.getAdapter().getCount() > 0) {
                return 1;
            }

            return 0;
        }

        void onRestoreInstanceState(Parcelable arg2) {
            this.featureId = ((SavedState)arg2).featureId;
            this.wasLastOpen = ((SavedState)arg2).isOpen;
            this.frozenMenuState = ((SavedState)arg2).menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        Parcelable onSaveInstanceState() {
            SavedState v0 = new SavedState();
            v0.featureId = this.featureId;
            v0.isOpen = this.isOpen;
            if(this.menu != null) {
                v0.menuState = new Bundle();
                this.menu.savePresenterStates(v0.menuState);
            }

            return ((Parcelable)v0);
        }

        void setMenu(MenuBuilder arg3) {
            MenuBuilder v0 = this.menu;
            if(arg3 == v0) {
            }
            else {
                if(v0 != null) {
                    v0.removeMenuPresenter(this.listMenuPresenter);
                }

                this.menu = arg3;
                if(arg3 == null) {
                    return;
                }

                ListMenuPresenter v2 = this.listMenuPresenter;
                if(v2 == null) {
                    return;
                }

                arg3.addMenuPresenter(((MenuPresenter)v2));
            }
        }

        void setStyle(Context arg5) {
            TypedValue v0 = new TypedValue();
            Resources$Theme v1 = arg5.getResources().newTheme();
            v1.setTo(arg5.getTheme());
            v1.resolveAttribute(attr.actionBarPopupTheme, v0, true);
            if(v0.resourceId != 0) {
                v1.applyStyle(v0.resourceId, true);
            }

            v1.resolveAttribute(attr.panelMenuListTheme, v0, true);
            if(v0.resourceId != 0) {
                v1.applyStyle(v0.resourceId, true);
            }
            else {
                v1.applyStyle(style.Theme_AppCompat_CompactMenu, true);
            }

            androidx.appcompat.view.ContextThemeWrapper v0_1 = new androidx.appcompat.view.ContextThemeWrapper(arg5, 0);
            ((Context)v0_1).getTheme().setTo(v1);
            this.listPresenterContext = ((Context)v0_1);
            TypedArray v5 = ((Context)v0_1).obtainStyledAttributes(styleable.AppCompatTheme);
            this.background = v5.getResourceId(styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = v5.getResourceId(styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            v5.recycle();
        }
    }

    final class PanelMenuPresenterCallback implements androidx.appcompat.view.menu.MenuPresenter$Callback {
        PanelMenuPresenterCallback(AppCompatDelegateImpl arg1) {
            AppCompatDelegateImpl.this = arg1;
            super();
        }

        public void onCloseMenu(MenuBuilder arg5, boolean arg6) {
            MenuBuilder v0 = arg5.getRootMenu();
            int v2 = v0 != arg5 ? 1 : 0;
            AppCompatDelegateImpl v3 = AppCompatDelegateImpl.this;
            if(v2 != 0) {
                arg5 = v0;
            }

            PanelFeatureState v5 = v3.findMenuPanel(((Menu)arg5));
            if(v5 != null) {
                v3 = AppCompatDelegateImpl.this;
                if(v2 != 0) {
                    v3.callOnPanelClosed(v5.featureId, v5, ((Menu)v0));
                    AppCompatDelegateImpl.this.closePanel(v5, true);
                    return;
                }
                else {
                    v3.closePanel(v5, arg6);
                }
            }
        }

        public boolean onOpenSubMenu(MenuBuilder arg2) {
            if(arg2 == arg2.getRootMenu() && (AppCompatDelegateImpl.this.mHasActionBar)) {
                Window$Callback v0 = AppCompatDelegateImpl.this.getWindowCallback();
                if(v0 != null && !AppCompatDelegateImpl.this.mDestroyed) {
                    v0.onMenuOpened(108, ((Menu)arg2));
                }
            }

            return 1;
        }
    }

    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP;
    ActionBar mActionBar;
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private int mActivityHandlesConfigFlags;
    private boolean mActivityHandlesConfigFlagsChecked;
    final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private AutoNightModeManager mAutoBatteryNightModeManager;
    private AutoNightModeManager mAutoTimeNightModeManager;
    private OnBackInvokedCallback mBackCallback;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    boolean mDestroyed;
    private OnBackInvokedDispatcher mDispatcher;
    private Configuration mEffectiveConfiguration;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    boolean mHasActionBar;
    final Object mHost;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    boolean mIsFloating;
    private LayoutIncludeDetector mLayoutIncludeDetector;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    Window mWindow;
    boolean mWindowNoTitle;
    private static final boolean sCanApplyOverrideConfiguration;
    private static final boolean sCanReturnDifferentContext;
    private static boolean sInstalledExceptionHandler;
    private static final SimpleArrayMap sLocalNightModes;
    private static final int[] sWindowBackgroundStyleable;

    static {
        AppCompatDelegateImpl.sLocalNightModes = new SimpleArrayMap();
        AppCompatDelegateImpl.IS_PRE_LOLLIPOP = false;
        AppCompatDelegateImpl.sWindowBackgroundStyleable = new int[]{0x1010054};
        AppCompatDelegateImpl.sCanReturnDifferentContext = "robolectric".equals(Build.FINGERPRINT) ^ 1;
        AppCompatDelegateImpl.sCanApplyOverrideConfiguration = true;
    }

    AppCompatDelegateImpl(Activity arg2, AppCompatCallback arg3) {
        this(((Context)arg2), null, arg3, arg2);
    }

    AppCompatDelegateImpl(Dialog arg3, AppCompatCallback arg4) {
        this(arg3.getContext(), arg3.getWindow(), arg4, arg3);
    }

    AppCompatDelegateImpl(Context arg2, Activity arg3, AppCompatCallback arg4) {
        this(arg2, null, arg4, arg3);
    }

    AppCompatDelegateImpl(Context arg1, Window arg2, AppCompatCallback arg3) {
        this(arg1, arg2, arg3, arg1);
    }

    private AppCompatDelegateImpl(Context arg3, Window arg4, AppCompatCallback arg5, Object arg6) {
        super();
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        int v0 = -100;
        this.mLocalNightMode = v0;
        this.mInvalidatePanelMenuRunnable = new androidx.appcompat.app.AppCompatDelegateImpl$2(this);
        this.mContext = arg3;
        this.mAppCompatCallback = arg5;
        this.mHost = arg6;
        if(this.mLocalNightMode == v0 && ((arg6 instanceof Dialog))) {
            AppCompatActivity v3 = this.tryUnwrapContext();
            if(v3 != null) {
                this.mLocalNightMode = v3.getDelegate().getLocalNightMode();
            }
        }

        if(this.mLocalNightMode == v0) {
            SimpleArrayMap v3_1 = AppCompatDelegateImpl.sLocalNightModes;
            Object v5 = v3_1.get(arg6.getClass().getName());
            if(v5 != null) {
                this.mLocalNightMode = ((Integer)v5).intValue();
                v3_1.remove(arg6.getClass().getName());
            }
        }

        if(arg4 != null) {
            this.attachToWindow(arg4);
        }

        AppCompatDrawableManager.preload();
    }

    public void addContentView(View arg3, ViewGroup$LayoutParams arg4) {
        this.ensureSubDecor();
        this.mSubDecor.findViewById(0x1020002).addView(arg3, arg4);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    boolean applyAppLocales() {
        if((AppCompatDelegateImpl.isAutoStorageOptedIn(this.mContext)) && AppCompatDelegateImpl.getRequestedAppLocales() != null && !AppCompatDelegateImpl.getRequestedAppLocales().equals(AppCompatDelegateImpl.getStoredAppLocales())) {
            this.asyncExecuteSyncRequestedAndStoredLocales(this.mContext);
        }

        return this.applyApplicationSpecificConfig(true);
    }

    private boolean applyApplicationSpecificConfig(boolean arg2) {
        return this.applyApplicationSpecificConfig(arg2, true);
    }

    private boolean applyApplicationSpecificConfig(boolean arg5, boolean arg6) {
        if(this.mDestroyed) {
            return 0;
        }

        int v0 = this.calculateNightMode();
        int v1 = this.mapNightMode(this.mContext, v0);
        LocaleListCompat v2 = Build$VERSION.SDK_INT < 33 ? this.calculateApplicationLocales(this.mContext) : null;
        if(!arg6 && v2 != null) {
            v2 = this.getConfigurationLocales(this.mContext.getResources().getConfiguration());
        }

        arg5 = this.updateAppConfiguration(v1, v2, arg5);
        if(v0 == 0) {
            this.getAutoTimeNightModeManager(this.mContext).setup();
        }
        else {
            AutoNightModeManager v6 = this.mAutoTimeNightModeManager;
            if(v6 != null) {
                v6.cleanup();
            }
        }

        if(v0 == 3) {
            this.getAutoBatteryNightModeManager(this.mContext).setup();
            return arg5;
        }

        AutoNightModeManager v4 = this.mAutoBatteryNightModeManager;
        if(v4 != null) {
            v4.cleanup();
        }

        return arg5;
    }

    public boolean applyDayNight() {
        return this.applyApplicationSpecificConfig(true);
    }

    private void applyFixedSizeWindow() {
        View v0 = this.mSubDecor.findViewById(0x1020002);
        View v1 = this.mWindow.getDecorView();
        ((ContentFrameLayout)v0).setDecorPadding(v1.getPaddingLeft(), v1.getPaddingTop(), v1.getPaddingRight(), v1.getPaddingBottom());
        TypedArray v5 = this.mContext.obtainStyledAttributes(styleable.AppCompatTheme);
        v5.getValue(styleable.AppCompatTheme_windowMinWidthMajor, ((ContentFrameLayout)v0).getMinWidthMajor());
        v5.getValue(styleable.AppCompatTheme_windowMinWidthMinor, ((ContentFrameLayout)v0).getMinWidthMinor());
        if(v5.hasValue(styleable.AppCompatTheme_windowFixedWidthMajor)) {
            v5.getValue(styleable.AppCompatTheme_windowFixedWidthMajor, ((ContentFrameLayout)v0).getFixedWidthMajor());
        }

        if(v5.hasValue(styleable.AppCompatTheme_windowFixedWidthMinor)) {
            v5.getValue(styleable.AppCompatTheme_windowFixedWidthMinor, ((ContentFrameLayout)v0).getFixedWidthMinor());
        }

        if(v5.hasValue(styleable.AppCompatTheme_windowFixedHeightMajor)) {
            v5.getValue(styleable.AppCompatTheme_windowFixedHeightMajor, ((ContentFrameLayout)v0).getFixedHeightMajor());
        }

        if(v5.hasValue(styleable.AppCompatTheme_windowFixedHeightMinor)) {
            v5.getValue(styleable.AppCompatTheme_windowFixedHeightMinor, ((ContentFrameLayout)v0).getFixedHeightMinor());
        }

        v5.recycle();
        ((ContentFrameLayout)v0).requestLayout();
    }

    public Context attachBaseContext2(Context arg8) {
        Configuration v7;
        Context v2;
        AppCompatDelegateImpl v1;
        this.mBaseContextAttached = true;
        int v3 = this.mapNightMode(arg8, this.calculateNightMode());
        if(AppCompatDelegateImpl.isAutoStorageOptedIn(arg8)) {
            AppCompatDelegateImpl.syncRequestedAndStoredLocales(arg8);
        }

        LocaleListCompat v4 = this.calculateApplicationLocales(arg8);
        if((AppCompatDelegateImpl.sCanApplyOverrideConfiguration) && ((arg8 instanceof ContextThemeWrapper))) {
            v1 = this;
            v2 = arg8;
            v7 = v1.createOverrideAppConfiguration(v2, v3, v4, null, false);
            try {
                ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration(v2, v7);
                return v2;
            }
            catch(IllegalStateException ) {
                goto label_22;
            }
        }

        v1 = this;
        v2 = arg8;
    label_22:
        if(!(v2 instanceof androidx.appcompat.view.ContextThemeWrapper)) {
            goto label_30;
        }

        v7 = v1.createOverrideAppConfiguration(v2, v3, v4, null, false);
        try {
            v2.applyOverrideConfiguration(v7);
            return v2;
        }
        catch(IllegalStateException ) {
        label_30:
            if(!AppCompatDelegateImpl.sCanReturnDifferentContext) {
                return super.attachBaseContext2(v2);
            }

            v7 = new Configuration();
            v7.uiMode = -1;
            v7.fontScale = 0f;
            v7 = Api17Impl.createConfigurationContext(v2, v7).getResources().getConfiguration();
            Configuration v8 = v2.getResources().getConfiguration();
            v7.uiMode = v8.uiMode;
            v7 = !v7.equals(v8) ? AppCompatDelegateImpl.generateConfigDelta(v7, v8) : null;
            v7 = v1.createOverrideAppConfiguration(v2, v3, v4, v7, true);
            androidx.appcompat.view.ContextThemeWrapper v8_1 = new androidx.appcompat.view.ContextThemeWrapper(v2, style.Theme_AppCompat_Empty);
            v8_1.applyOverrideConfiguration(v7);
            try {
                if(v2.getTheme() != null) {
                    goto label_61;
                }
            }
            catch(NullPointerException ) {
            }

            goto label_63;
        label_61:
            ThemeCompat.rebase(v8_1.getTheme());
        label_63:
            return super.attachBaseContext2(((Context)v8_1));
        }
    }

    private void attachToWindow(Window arg4) {
        String v1 = "AppCompat has already installed itself into the Window";
        if(this.mWindow == null) {
            Window$Callback v0 = arg4.getCallback();
            if(!(v0 instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback v1_1 = new AppCompatWindowCallback(this, v0);
                this.mAppCompatWindowCallback = v1_1;
                arg4.setCallback(((Window$Callback)v1_1));
                AttributeSet v2 = null;
                TintTypedArray v0_1 = TintTypedArray.obtainStyledAttributes(this.mContext, v2, AppCompatDelegateImpl.sWindowBackgroundStyleable);
                Drawable v1_2 = v0_1.getDrawableIfKnown(0);
                if(v1_2 != null) {
                    arg4.setBackgroundDrawable(v1_2);
                }

                v0_1.recycle();
                this.mWindow = arg4;
                if(Build$VERSION.SDK_INT >= 33 && this.mDispatcher == null) {
                    this.setOnBackInvokedDispatcher(((OnBackInvokedDispatcher)v2));
                }

                return;
            }

            throw new IllegalStateException(v1);
        }

        throw new IllegalStateException(v1);
    }

    LocaleListCompat calculateApplicationLocales(Context arg4) {
        LocaleListCompat v2 = null;
        if(Build$VERSION.SDK_INT >= 33) {
            return v2;
        }

        LocaleListCompat v0 = AppCompatDelegateImpl.getRequestedAppLocales();
        if(v0 == null) {
            return v2;
        }

        LocaleListCompat v3 = this.getConfigurationLocales(arg4.getApplicationContext().getResources().getConfiguration());
        LocaleListCompat v4 = LocaleOverlayHelper.combineLocalesIfOverlayExists(v0, v3);
        if(v4.isEmpty()) {
            return v3;
        }

        return v4;
    }

    private int calculateNightMode() {
        int v1 = this.mLocalNightMode;
        if(v1 != -100) {
            return v1;
        }

        return AppCompatDelegateImpl.getDefaultNightMode();
    }

    void callOnPanelClosed(int arg3, PanelFeatureState arg4, Menu arg5) {
        MenuBuilder v5;
        if(arg5 == null) {
            if(arg4 == null && arg3 >= 0) {
                PanelFeatureState[] v0 = this.mPanels;
                if(arg3 < v0.length) {
                    arg4 = v0[arg3];
                }
            }

            if(arg4 == null) {
                goto label_9;
            }

            v5 = arg4.menu;
        }

    label_9:
        if(arg4 != null && !arg4.isOpen) {
        }
        else if(!this.mDestroyed) {
            this.mAppCompatWindowCallback.bypassOnPanelClosed(this.mWindow.getCallback(), arg3, ((Menu)v5));
        }
    }

    void checkCloseActionMenu(MenuBuilder arg3) {
        if(this.mClosingActionMenu) {
            return;
        }

        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window$Callback v0 = this.getWindowCallback();
        if(v0 != null && !this.mDestroyed) {
            v0.onPanelClosed(108, ((Menu)arg3));
        }

        this.mClosingActionMenu = false;
    }

    private void cleanupAutoManagers() {
        AutoNightModeManager v0 = this.mAutoTimeNightModeManager;
        if(v0 != null) {
            v0.cleanup();
        }

        AutoNightModeManager v1 = this.mAutoBatteryNightModeManager;
        if(v1 != null) {
            v1.cleanup();
        }
    }

    void closePanel(PanelFeatureState arg4, boolean arg5) {
        if((arg5) && arg4.featureId == 0) {
            DecorContentParent v0 = this.mDecorContentParent;
            if(v0 != null && (v0.isOverflowMenuShowing())) {
                this.checkCloseActionMenu(arg4.menu);
                return;
            }
        }

        Object v0_1 = this.mContext.getSystemService("window");
        Menu v1 = null;
        if(v0_1 != null && (arg4.isOpen) && arg4.decorView != null) {
            ((WindowManager)v0_1).removeView(arg4.decorView);
            if(arg5) {
                this.callOnPanelClosed(arg4.featureId, arg4, v1);
            }
        }

        arg4.isPrepared = false;
        arg4.isHandled = false;
        arg4.isOpen = false;
        arg4.shownPanelView = ((View)v1);
        arg4.refreshDecorView = true;
        if(this.mPreparedPanel == arg4) {
            this.mPreparedPanel = ((PanelFeatureState)v1);
        }

        if(arg4.featureId == 0) {
            this.updateBackInvokedCallbackState();
        }
    }

    void closePanel(int arg2) {
        this.closePanel(this.getPanelState(arg2, true), true);
    }

    private Configuration createOverrideAppConfiguration(Context arg2, int arg3, LocaleListCompat arg4, Configuration arg5, boolean arg6) {
        int v2;
        if(arg3 == 1) {
            v2 = 16;
        }
        else if(arg3 == 2) {
            v2 = 0x20;
        }
        else if(arg6) {
            v2 = 0;
        }
        else {
            v2 = arg2.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
        }

        Configuration v3 = new Configuration();
        v3.fontScale = 0f;
        if(arg5 != null) {
            v3.setTo(arg5);
        }

        v3.uiMode = v2 | v3.uiMode & -49;
        if(arg4 != null) {
            this.setConfigurationLocales(v3, arg4);
        }

        return v3;
    }

    private ViewGroup createSubDecor() {
        View v1_2;
        androidx.appcompat.view.ContextThemeWrapper v1;
        View v0_2;
        TypedArray v0 = this.mContext.obtainStyledAttributes(styleable.AppCompatTheme);
        if(v0.hasValue(styleable.AppCompatTheme_windowActionBar)) {
            if(v0.getBoolean(styleable.AppCompatTheme_windowNoTitle, false)) {
                this.requestWindowFeature(1);
            }
            else if(v0.getBoolean(styleable.AppCompatTheme_windowActionBar, false)) {
                this.requestWindowFeature(108);
            }

            int v4 = 109;
            if(v0.getBoolean(styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                this.requestWindowFeature(v4);
            }

            if(v0.getBoolean(styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                this.requestWindowFeature(10);
            }

            this.mIsFloating = v0.getBoolean(styleable.AppCompatTheme_android_windowIsFloating, false);
            v0.recycle();
            this.ensureWindow();
            this.mWindow.getDecorView();
            LayoutInflater v0_1 = LayoutInflater.from(this.mContext);
            ViewGroup v5 = null;
            if(this.mWindowNoTitle) {
                if(this.mOverlayActionMode) {
                    v0_2 = v0_1.inflate(layout.abc_screen_simple_overlay_action_mode, v5);
                    goto label_95;
                }

                v0_2 = v0_1.inflate(layout.abc_screen_simple, v5);
            }
            else if(this.mIsFloating) {
                v0_2 = v0_1.inflate(layout.abc_dialog_title_material, v5);
                this.mOverlayActionBar = false;
                this.mHasActionBar = false;
            }
            else if(this.mHasActionBar) {
                TypedValue v0_3 = new TypedValue();
                this.mContext.getTheme().resolveAttribute(attr.actionBarTheme, v0_3, true);
                if(v0_3.resourceId != 0) {
                    v1 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, v0_3.resourceId);
                }
                else {
                    Context v1_1 = this.mContext;
                }

                v0_2 = LayoutInflater.from(((Context)v1)).inflate(layout.abc_screen_toolbar, v5);
                v1_2 = ((ViewGroup)v0_2).findViewById(id.decor_content_parent);
                this.mDecorContentParent = ((DecorContentParent)v1_2);
                ((DecorContentParent)v1_2).setWindowCallback(this.getWindowCallback());
                if(this.mOverlayActionBar) {
                    this.mDecorContentParent.initFeature(v4);
                }

                if(this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }

                if(!this.mFeatureIndeterminateProgress) {
                    goto label_95;
                }

                this.mDecorContentParent.initFeature(5);
            }
            else {
                v0_2 = ((View)v5);
            }

        label_95:
            if(v0_2 != null) {
                ViewCompat.setOnApplyWindowInsetsListener(v0_2, new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View arg4, WindowInsetsCompat arg5) {
                        int v0 = arg5.getSystemWindowInsetTop();
                        int v3 = AppCompatDelegateImpl.this.updateStatusGuard(arg5, null);
                        if(v0 != v3) {
                            arg5 = arg5.replaceSystemWindowInsets(arg5.getSystemWindowInsetLeft(), v3, arg5.getSystemWindowInsetRight(), arg5.getSystemWindowInsetBottom());
                        }

                        return ViewCompat.onApplyWindowInsets(arg4, arg5);
                    }
                });
                if(this.mDecorContentParent == null) {
                    this.mTitleView = ((ViewGroup)v0_2).findViewById(id.title);
                }

                ViewUtils.makeOptionalFitsSystemWindows(v0_2);
                v1_2 = ((ViewGroup)v0_2).findViewById(id.action_bar_activity_content);
                v4 = 0x1020002;
                View v3 = this.mWindow.findViewById(v4);
                if(v3 != null) {
                    while(((ViewGroup)v3).getChildCount() > 0) {
                        View v6 = ((ViewGroup)v3).getChildAt(0);
                        ((ViewGroup)v3).removeViewAt(0);
                        ((ContentFrameLayout)v1_2).addView(v6);
                    }

                    ((ViewGroup)v3).setId(-1);
                    ((ContentFrameLayout)v1_2).setId(v4);
                    if((v3 instanceof FrameLayout)) {
                        ((FrameLayout)v3).setForeground(((Drawable)v5));
                    }
                }

                this.mWindow.setContentView(v0_2);
                ((ContentFrameLayout)v1_2).setAttachListener(new OnAttachListener() {
                    public void onAttachedFromWindow() {
                    }

                    public void onDetachedFromWindow() {
                        AppCompatDelegateImpl.this.dismissPopups();
                    }
                });
                return ((ViewGroup)v0_2);
            }

            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        }

        v0.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public View createView(View arg12, String arg13, Context arg14, AttributeSet arg15) {
        boolean v7;
        boolean v1 = false;
        if(this.mAppCompatViewInflater == null) {
            String v2 = this.mContext.obtainStyledAttributes(styleable.AppCompatTheme).getString(styleable.AppCompatTheme_viewInflaterClass);
            if(v2 == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
                goto label_35;
            }

            try {
                this.mAppCompatViewInflater = this.mContext.getClassLoader().loadClass(v2).getDeclaredConstructor().newInstance();
            }
            catch(Throwable v0) {
                Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + v2 + ". Falling back to default.", v0);
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            }
        }

    label_35:
        boolean v8 = AppCompatDelegateImpl.IS_PRE_LOLLIPOP;
        if(v8) {
            LayoutIncludeDetector v0_1 = this.mLayoutIncludeDetector;
            if(v0_1 == null) {
                v0_1 = new LayoutIncludeDetector();
                this.mLayoutIncludeDetector = v0_1;
            }

            if(v0_1.detect(arg15)) {
                v7 = true;
                goto label_58;
            }

            if((arg15 instanceof XmlPullParser)) {
                if(arg15.getDepth() <= 1) {
                    goto label_57;
                }

                v1 = true;
                goto label_57;
            }

            v1 = this.shouldInheritContext(arg12);
            goto label_57;
        }
        else {
        label_57:
            v7 = v1;
        }

    label_58:
        return this.mAppCompatViewInflater.createView(arg12, arg13, arg14, arg15, v7, v8, true, VectorEnabledTintResources.shouldBeUsed());
    }

    void dismissPopups() {
        DecorContentParent v0 = this.mDecorContentParent;
        if(v0 != null) {
            v0.dismissPopups();
        }

        if(this.mActionModePopup != null) {
            this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
            if(this.mActionModePopup.isShowing()) {
                try {
                    this.mActionModePopup.dismiss();
                    goto label_14;
                }
                catch(IllegalArgumentException ) {
                label_14:
                    this.mActionModePopup = null;
                    goto label_16;
                }
            }

            goto label_14;
        }

    label_16:
        this.endOnGoingFadeAnimation();
        PanelFeatureState v2 = this.getPanelState(0, false);
        if(v2 != null && v2.menu != null) {
            v2.menu.close();
        }
    }

    boolean dispatchKeyEvent(KeyEvent arg4) {
        Object v0 = this.mHost;
        if(((v0 instanceof Component)) || ((v0 instanceof AppCompatDialog))) {
            View v0_1 = this.mWindow.getDecorView();
            if(v0_1 != null && (KeyEventDispatcher.dispatchBeforeHierarchy(v0_1, arg4))) {
                return 1;
            }
        }

        if(arg4.getKeyCode() == 82 && (this.mAppCompatWindowCallback.bypassDispatchKeyEvent(this.mWindow.getCallback(), arg4))) {
            return 1;
        }

        int v0_2 = arg4.getKeyCode();
        if(arg4.getAction() == 0) {
            return this.onKeyDown(v0_2, arg4);
        }

        return this.onKeyUp(v0_2, arg4);
    }

    void doInvalidatePanelMenu(int arg5) {
        PanelFeatureState v1 = this.getPanelState(arg5, true);
        if(v1.menu != null) {
            Bundle v2 = new Bundle();
            v1.menu.saveActionViewStates(v2);
            if(v2.size() > 0) {
                v1.frozenActionViewState = v2;
            }

            v1.menu.stopDispatchingItemsChanged();
            v1.menu.clear();
        }

        v1.refreshMenuContent = true;
        v1.refreshDecorView = true;
        if((arg5 == 108 || arg5 == 0) && this.mDecorContentParent != null) {
            PanelFeatureState v0 = this.getPanelState(0, false);
            if(v0 != null) {
                v0.isPrepared = false;
                this.preparePanel(v0, null);
            }
        }
    }

    void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat v0 = this.mFadeAnim;
        if(v0 != null) {
            v0.cancel();
        }
    }

    private void ensureSubDecor() {
        if(!this.mSubDecorInstalled) {
            this.mSubDecor = this.createSubDecor();
            CharSequence v0 = this.getTitle();
            if(!TextUtils.isEmpty(v0)) {
                DecorContentParent v1 = this.mDecorContentParent;
                if(v1 != null) {
                    v1.setWindowTitle(v0);
                }
                else if(this.peekSupportActionBar() != null) {
                    this.peekSupportActionBar().setWindowTitle(v0);
                }
                else {
                    TextView v1_1 = this.mTitleView;
                    if(v1_1 != null) {
                        v1_1.setText(v0);
                    }
                }
            }

            this.applyFixedSizeWindow();
            this.onSubDecorInstalled(this.mSubDecor);
            this.mSubDecorInstalled = true;
            PanelFeatureState v0_1 = this.getPanelState(0, false);
            if(this.mDestroyed) {
                return;
            }

            if(v0_1 != null && v0_1.menu != null) {
                return;
            }

            this.invalidatePanelMenu(108);
        }
    }

    private void ensureWindow() {
        if(this.mWindow == null) {
            Object v0 = this.mHost;
            if((v0 instanceof Activity)) {
                this.attachToWindow(((Activity)v0).getWindow());
            }
        }

        if(this.mWindow != null) {
            return;
        }

        throw new IllegalStateException("We have not been given a Window");
    }

    PanelFeatureState findMenuPanel(Menu arg5) {
        PanelFeatureState[] v4 = this.mPanels;
        int v0 = 0;
        int v1 = v4 != null ? v4.length : 0;
        while(v0 < v1) {
            PanelFeatureState v2 = v4[v0];
            if(v2 != null && v2.menu == arg5) {
                return v2;
            }

            ++v0;
        }

        return null;
    }

    public View findViewById(int arg1) {
        this.ensureSubDecor();
        return this.mWindow.findViewById(arg1);
    }

    private static Configuration generateConfigDelta(Configuration arg3, Configuration arg4) {
        Configuration v0 = new Configuration();
        v0.fontScale = 0f;
        if(arg4 != null) {
            if(arg3.diff(arg4) == 0) {
            }
            else {
                if(arg3.fontScale != arg4.fontScale) {
                    v0.fontScale = arg4.fontScale;
                }

                if(arg3.mcc != arg4.mcc) {
                    v0.mcc = arg4.mcc;
                }

                if(arg3.mnc != arg4.mnc) {
                    v0.mnc = arg4.mnc;
                }

                Api24Impl.generateConfigDelta_locale(arg3, arg4, v0);
                if(arg3.touchscreen != arg4.touchscreen) {
                    v0.touchscreen = arg4.touchscreen;
                }

                if(arg3.keyboard != arg4.keyboard) {
                    v0.keyboard = arg4.keyboard;
                }

                if(arg3.keyboardHidden != arg4.keyboardHidden) {
                    v0.keyboardHidden = arg4.keyboardHidden;
                }

                if(arg3.navigation != arg4.navigation) {
                    v0.navigation = arg4.navigation;
                }

                if(arg3.navigationHidden != arg4.navigationHidden) {
                    v0.navigationHidden = arg4.navigationHidden;
                }

                if(arg3.orientation != arg4.orientation) {
                    v0.orientation = arg4.orientation;
                }

                if((arg3.screenLayout & 15) != (arg4.screenLayout & 15)) {
                    v0.screenLayout |= arg4.screenLayout & 15;
                }

                if((arg3.screenLayout & 0xC0) != (arg4.screenLayout & 0xC0)) {
                    v0.screenLayout |= arg4.screenLayout & 0xC0;
                }

                if((arg3.screenLayout & 0x30) != (arg4.screenLayout & 0x30)) {
                    v0.screenLayout |= arg4.screenLayout & 0x30;
                }

                if((arg3.screenLayout & 0x300) != (arg4.screenLayout & 0x300)) {
                    v0.screenLayout |= arg4.screenLayout & 0x300;
                }

                Api26Impl.generateConfigDelta_colorMode(arg3, arg4, v0);
                if((arg3.uiMode & 15) != (arg4.uiMode & 15)) {
                    v0.uiMode |= arg4.uiMode & 15;
                }

                if((arg3.uiMode & 0x30) != (arg4.uiMode & 0x30)) {
                    v0.uiMode |= arg4.uiMode & 0x30;
                }

                if(arg3.screenWidthDp != arg4.screenWidthDp) {
                    v0.screenWidthDp = arg4.screenWidthDp;
                }

                if(arg3.screenHeightDp != arg4.screenHeightDp) {
                    v0.screenHeightDp = arg4.screenHeightDp;
                }

                if(arg3.smallestScreenWidthDp != arg4.smallestScreenWidthDp) {
                    v0.smallestScreenWidthDp = arg4.smallestScreenWidthDp;
                }

                Api17Impl.generateConfigDelta_densityDpi(arg3, arg4, v0);
            }
        }

        return v0;
    }

    final Context getActionBarThemedContext() {
        ActionBar v0 = this.getSupportActionBar();
        Context v0_1 = v0 != null ? v0.getThemedContext() : null;
        if(v0_1 == null) {
            return this.mContext;
        }

        return v0_1;
    }

    private int getActivityHandlesConfigChangesFlags(Context arg6) {
        if(!this.mActivityHandlesConfigFlagsChecked && ((this.mHost instanceof Activity))) {
            PackageManager v0 = arg6.getPackageManager();
            if(v0 == null) {
                return 0;
            }

            try {
                int v2 = Build$VERSION.SDK_INT >= 29 ? 0x100C0000 : 0xC0000;
                ActivityInfo v6_1 = v0.getActivityInfo(new ComponentName(arg6, this.mHost.getClass()), v2);
                if(v6_1 == null) {
                    goto label_29;
                }

                this.mActivityHandlesConfigFlags = v6_1.configChanges;
            }
            catch(PackageManager$NameNotFoundException v6) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", ((Throwable)v6));
                this.mActivityHandlesConfigFlags = 0;
            }
        }

    label_29:
        this.mActivityHandlesConfigFlagsChecked = true;
        return this.mActivityHandlesConfigFlags;
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(Context arg2) {
        if(this.mAutoBatteryNightModeManager == null) {
            this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, arg2);
        }

        return this.mAutoBatteryNightModeManager;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(Context arg2) {
        if(this.mAutoTimeNightModeManager == null) {
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(arg2));
        }

        return this.mAutoTimeNightModeManager;
    }

    final AutoNightModeManager getAutoTimeNightModeManager() {
        return this.getAutoTimeNightModeManager(this.mContext);
    }

    LocaleListCompat getConfigurationLocales(Configuration arg1) {
        return Api24Impl.getLocales(arg1);
    }

    public Context getContextForDelegate() {
        return this.mContext;
    }

    public final Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl(this);
    }

    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    public MenuInflater getMenuInflater() {
        if(this.mMenuInflater == null) {
            this.initWindowDecorActionBar();
            ActionBar v1 = this.mActionBar;
            Context v1_1 = v1 != null ? v1.getThemedContext() : this.mContext;
            this.mMenuInflater = new SupportMenuInflater(v1_1);
        }

        return this.mMenuInflater;
    }

    protected PanelFeatureState getPanelState(int arg4, boolean arg5) {
        PanelFeatureState[] v5 = this.mPanels;
        if(v5 == null || v5.length <= arg4) {
            PanelFeatureState[] v0 = new PanelFeatureState[arg4 + 1];
            if(v5 != null) {
                System.arraycopy(v5, 0, v0, 0, v5.length);
            }

            this.mPanels = v0;
            v5 = v0;
        }

        PanelFeatureState v3 = v5[arg4];
        if(v3 == null) {
            v3 = new PanelFeatureState(arg4);
            v5[arg4] = v3;
        }

        return v3;
    }

    ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    public ActionBar getSupportActionBar() {
        this.initWindowDecorActionBar();
        return this.mActionBar;
    }

    final CharSequence getTitle() {
        Object v0 = this.mHost;
        if((v0 instanceof Activity)) {
            return ((Activity)v0).getTitle();
        }

        return this.mTitle;
    }

    final Window$Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public boolean hasWindowFeature(int arg5) {
        boolean v0_1;
        int v0 = this.sanitizeWindowFeatureId(arg5);
        if(v0 == 1) {
            v0_1 = this.mWindowNoTitle;
        }
        else if(v0 == 2) {
            v0_1 = this.mFeatureProgress;
        }
        else if(v0 == 5) {
            v0_1 = this.mFeatureIndeterminateProgress;
        }
        else if(v0 == 10) {
            v0_1 = this.mOverlayActionMode;
        }
        else if(v0 == 108) {
            v0_1 = this.mHasActionBar;
        }
        else if(v0 != 109) {
            v0_1 = false;
        }
        else {
            v0_1 = this.mOverlayActionBar;
        }

        if(!v0_1) {
            if(this.mWindow.hasFeature(arg5)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private void initWindowDecorActionBar() {
        this.ensureSubDecor();
        if(this.mHasActionBar) {
            if(this.mActionBar != null) {
            }
            else {
                Object v0 = this.mHost;
                if((v0 instanceof Activity)) {
                    this.mActionBar = new WindowDecorActionBar(this.mHost, this.mOverlayActionBar);
                }
                else if((v0 instanceof Dialog)) {
                    this.mActionBar = new WindowDecorActionBar(this.mHost);
                }

                ActionBar v0_1 = this.mActionBar;
                if(v0_1 == null) {
                    return;
                }

                v0_1.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    private boolean initializePanelContent(PanelFeatureState arg4) {
        if(arg4.createdPanelView != null) {
            arg4.shownPanelView = arg4.createdPanelView;
            return 1;
        }

        if(arg4.menu == null) {
            return 0;
        }

        PanelMenuPresenterCallback v0 = this.mPanelMenuPresenterCallback;
        if(v0 == null) {
            v0 = new PanelMenuPresenterCallback(this);
            this.mPanelMenuPresenterCallback = v0;
        }

        arg4.shownPanelView = arg4.getListMenuView(((androidx.appcompat.view.menu.MenuPresenter$Callback)v0));
        if(arg4.shownPanelView != null) {
            return 1;
        }

        return 0;
    }

    private boolean initializePanelDecor(PanelFeatureState arg3) {
        arg3.setStyle(this.getActionBarThemedContext());
        arg3.decorView = new ListMenuDecorView(this, arg3.listPresenterContext);
        arg3.gravity = 81;
        return 1;
    }

    private boolean initializePanelMenu(PanelFeatureState arg7) {
        Resources$Theme v4;
        Context v0 = this.mContext;
        if((arg7.featureId == 0 || arg7.featureId == 108) && this.mDecorContentParent != null) {
            TypedValue v1 = new TypedValue();
            Resources$Theme v3 = v0.getTheme();
            v3.resolveAttribute(attr.actionBarTheme, v1, true);
            if(v1.resourceId != 0) {
                v4 = v0.getResources().newTheme();
                v4.setTo(v3);
                v4.applyStyle(v1.resourceId, true);
                v4.resolveAttribute(attr.actionBarWidgetTheme, v1, true);
            }
            else {
                v3.resolveAttribute(attr.actionBarWidgetTheme, v1, true);
                v4 = null;
            }

            if(v1.resourceId != 0) {
                if(v4 == null) {
                    v4 = v0.getResources().newTheme();
                    v4.setTo(v3);
                }

                v4.applyStyle(v1.resourceId, true);
            }

            if(v4 == null) {
                goto label_42;
            }

            androidx.appcompat.view.ContextThemeWrapper v1_1 = new androidx.appcompat.view.ContextThemeWrapper(v0, 0);
            ((Context)v1_1).getTheme().setTo(v4);
            androidx.appcompat.view.ContextThemeWrapper v0_1 = v1_1;
        }

    label_42:
        MenuBuilder v1_2 = new MenuBuilder(v0);
        v1_2.setCallback(((Callback)this));
        arg7.setMenu(v1_2);
        return 1;
    }

    public void installViewFactory() {
        LayoutInflater v0 = LayoutInflater.from(this.mContext);
        if(v0.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(v0, ((LayoutInflater$Factory2)this));
            return;
        }

        if(!(v0.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity\'s LayoutInflater already has a Factory installed so we can not install AppCompat\'s");
        }
    }

    public void invalidateOptionsMenu() {
        if(this.peekSupportActionBar() != null) {
            if(this.getSupportActionBar().invalidateOptionsMenu()) {
            }
            else {
                this.invalidatePanelMenu(0);
            }
        }
    }

    private void invalidatePanelMenu(int arg3) {
        this.mInvalidatePanelMenuFeatures |= 1 << arg3;
        if(!this.mInvalidatePanelMenuPosted) {
            ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    int mapNightMode(Context arg3, int arg4) {
        int v1 = -1;
        if(arg4 != -100) {
            if(arg4 != v1) {
                if(arg4 != 0) {
                    if(arg4 != 1 && arg4 != 2) {
                        if(arg4 == 3) {
                            return this.getAutoBatteryNightModeManager(arg3).getApplyableNightMode();
                        }
                        else {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                    }
                }
                else if(arg3.getApplicationContext().getSystemService("uimode").getNightMode() == 0) {
                    return v1;
                }
                else {
                    return this.getAutoTimeNightModeManager(arg3).getApplyableNightMode();
                }
            }

            return arg4;
        }

        return v1;
    }

    boolean onBackPressed() {
        boolean v0 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState v2 = this.getPanelState(0, false);
        if(v2 != null && (v2.isOpen)) {
            if(!v0) {
                this.closePanel(v2, true);
            }

            return 1;
        }

        ActionMode v0_1 = this.mActionMode;
        if(v0_1 != null) {
            v0_1.finish();
            return 1;
        }

        ActionBar v5 = this.getSupportActionBar();
        if(v5 != null && (v5.collapseActionView())) {
            return 1;
        }

        return 0;
    }

    public void onConfigurationChanged(Configuration arg2) {
        if((this.mHasActionBar) && (this.mSubDecorInstalled)) {
            ActionBar v0 = this.getSupportActionBar();
            if(v0 != null) {
                v0.onConfigurationChanged(arg2);
            }
        }

        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.applyApplicationSpecificConfig(false, false);
    }

    public void onCreate(Bundle arg3) {
        String v0_1;
        this.mBaseContextAttached = true;
        this.applyApplicationSpecificConfig(false);
        this.ensureWindow();
        Object v0 = this.mHost;
        if((v0 instanceof Activity)) {
            try {
                v0_1 = NavUtils.getParentActivityName(((Activity)v0));
            }
            catch(IllegalArgumentException ) {
                v0_1 = null;
            }

            if(v0_1 != null) {
                ActionBar v0_2 = this.peekSupportActionBar();
                if(v0_2 == null) {
                    this.mEnableDefaultActionBarUp = true;
                }
                else {
                    v0_2.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }

            AppCompatDelegateImpl.addActiveDelegate(((AppCompatDelegate)this));
        }

        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    public final View onCreateView(View arg1, String arg2, Context arg3, AttributeSet arg4) {
        return this.createView(arg1, arg2, arg3, arg4);
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        return this.onCreateView(null, arg2, arg3, arg4);
    }

    public void onDestroy() {
        if((this.mHost instanceof Activity)) {
            AppCompatDelegateImpl.removeActivityDelegate(((AppCompatDelegate)this));
        }

        if(this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }

        this.mDestroyed = true;
        if(this.mLocalNightMode != -100) {
            Object v0 = this.mHost;
            if(!(v0 instanceof Activity)) {
                goto label_28;
            }
            else if(((Activity)v0).isChangingConfigurations()) {
                AppCompatDelegateImpl.sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
            }
            else {
                goto label_28;
            }
        }
        else {
        label_28:
            AppCompatDelegateImpl.sLocalNightModes.remove(this.mHost.getClass().getName());
        }

        ActionBar v0_1 = this.mActionBar;
        if(v0_1 != null) {
            v0_1.onDestroy();
        }

        this.cleanupAutoManagers();
    }

    boolean onKeyDown(int arg4, KeyEvent arg5) {
        boolean v1 = true;
        if(arg4 == 4) {
            if((arg5.getFlags() & 0x80) != 0) {
            }
            else {
                v1 = false;
            }

            this.mLongPressBackDown = v1;
        }
        else if(arg4 != 82) {
        }
        else {
            this.onKeyDownPanel(0, arg5);
            return 1;
        }

        return 0;
    }

    private boolean onKeyDownPanel(int arg2, KeyEvent arg3) {
        if(arg3.getRepeatCount() == 0) {
            PanelFeatureState v2 = this.getPanelState(arg2, true);
            if(!v2.isOpen) {
                return this.preparePanel(v2, arg3);
            }
        }

        return 0;
    }

    boolean onKeyShortcut(int arg4, KeyEvent arg5) {
        ActionBar v0 = this.getSupportActionBar();
        if(v0 != null && (v0.onKeyShortcut(arg4, arg5))) {
            return 1;
        }

        PanelFeatureState v4 = this.mPreparedPanel;
        if(v4 != null && (this.performPanelShortcut(v4, arg5.getKeyCode(), arg5, 1))) {
            PanelFeatureState v3 = this.mPreparedPanel;
            if(v3 != null) {
                v3.isHandled = true;
            }

            return 1;
        }

        if(this.mPreparedPanel == null) {
            v4 = this.getPanelState(0, true);
            this.preparePanel(v4, arg5);
            boolean v3_1 = this.performPanelShortcut(v4, arg5.getKeyCode(), arg5, 1);
            v4.isPrepared = false;
            if(v3_1) {
                return 1;
            }
        }

        return 0;
    }

    boolean onKeyUp(int arg4, KeyEvent arg5) {
        if(arg4 != 4) {
            if(arg4 != 82) {
            }
            else {
                this.onKeyUpPanel(0, arg5);
                return 1;
            }
        }
        else if(this.onBackPressed()) {
            return 1;
        }

        return 0;
    }

    private boolean onKeyUpPanel(int arg4, KeyEvent arg5) {
        boolean v4_1;
        if(this.mActionMode != null) {
            return 0;
        }

        boolean v0 = true;
        PanelFeatureState v2 = this.getPanelState(arg4, true);
        if(arg4 == 0) {
            DecorContentParent v4 = this.mDecorContentParent;
            if(v4 == null) {
                goto label_28;
            }
            else if(!v4.canShowOverflowMenu()) {
                goto label_28;
            }
            else if(ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                goto label_28;
            }
            else if(this.mDecorContentParent.isOverflowMenuShowing()) {
                v0 = this.mDecorContentParent.hideOverflowMenu();
            }
            else if(this.mDestroyed) {
                goto label_44;
            }
            else if(this.preparePanel(v2, arg5)) {
                v0 = this.mDecorContentParent.showOverflowMenu();
            }
            else {
                goto label_44;
            }
        }
        else {
        label_28:
            if(!v2.isOpen) {
                if(v2.isHandled) {
                }
                else {
                    if(v2.isPrepared) {
                        if(v2.refreshMenuContent) {
                            v2.isPrepared = false;
                            v4_1 = this.preparePanel(v2, arg5);
                        }
                        else {
                            v4_1 = true;
                        }

                        if(!v4_1) {
                            goto label_44;
                        }

                        this.openPanel(v2, arg5);
                    }
                    else {
                    label_44:
                        v0 = false;
                    }

                    goto label_49;
                }
            }

            v4_1 = v2.isOpen;
            this.closePanel(v2, true);
            v0 = v4_1;
        }

    label_49:
        if(v0) {
            Object v3 = this.mContext.getApplicationContext().getSystemService("audio");
            if(v3 != null) {
                ((AudioManager)v3).playSoundEffect(0);
                return v0;
            }
            else {
                Log.w("AppCompatDelegate", "Couldn\'t get audio manager");
            }
        }

        return v0;
    }

    public boolean onMenuItemSelected(MenuBuilder arg3, MenuItem arg4) {
        Window$Callback v0 = this.getWindowCallback();
        if(v0 != null && !this.mDestroyed) {
            PanelFeatureState v2 = this.findMenuPanel(arg3.getRootMenu());
            if(v2 != null) {
                return v0.onMenuItemSelected(v2.featureId, arg4);
            }
        }

        return 0;
    }

    public void onMenuModeChange(MenuBuilder arg1) {
        this.reopenMenu(true);
    }

    void onMenuOpened(int arg2) {
        if(arg2 == 108) {
            ActionBar v1 = this.getSupportActionBar();
            if(v1 != null) {
                v1.dispatchMenuVisibilityChanged(true);
            }
        }
    }

    void onPanelClosed(int arg3) {
        if(arg3 == 108) {
            ActionBar v2 = this.getSupportActionBar();
            if(v2 != null) {
                v2.dispatchMenuVisibilityChanged(false);
                return;
            }
        }
        else if(arg3 == 0) {
            PanelFeatureState v3 = this.getPanelState(arg3, true);
            if(v3.isOpen) {
                this.closePanel(v3, false);
            }
        }
    }

    public void onPostCreate(Bundle arg1) {
        this.ensureSubDecor();
    }

    public void onPostResume() {
        ActionBar v1 = this.getSupportActionBar();
        if(v1 != null) {
            v1.setShowHideAnimationEnabled(true);
        }
    }

    public void onSaveInstanceState(Bundle arg1) {
    }

    public void onStart() {
        this.applyApplicationSpecificConfig(true, false);
    }

    public void onStop() {
        ActionBar v1 = this.getSupportActionBar();
        if(v1 != null) {
            v1.setShowHideAnimationEnabled(false);
        }
    }

    void onSubDecorInstalled(ViewGroup arg1) {
    }

    private void openPanel(PanelFeatureState arg12, KeyEvent arg13) {
        int v4;
        ViewGroup$LayoutParams v13;
        if(!arg12.isOpen) {
            if(this.mDestroyed) {
            }
            else {
                if(arg12.featureId == 0 && (this.mContext.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }

                Window$Callback v0 = this.getWindowCallback();
                if(v0 != null && !v0.onMenuOpened(arg12.featureId, arg12.menu)) {
                    this.closePanel(arg12, true);
                    return;
                }

                Object v0_1 = this.mContext.getSystemService("window");
                if(v0_1 == null) {
                    return;
                }

                if(!this.preparePanel(arg12, arg13)) {
                    return;
                }

                int v2 = -2;
                if(arg12.decorView == null || (arg12.refreshDecorView)) {
                    if(arg12.decorView == null) {
                        if(!this.initializePanelDecor(arg12)) {
                            return;
                        }
                        else if(arg12.decorView == null) {
                            return;
                        }
                    }
                    else if((arg12.refreshDecorView) && arg12.decorView.getChildCount() > 0) {
                        arg12.decorView.removeAllViews();
                    }

                    if(this.initializePanelContent(arg12)) {
                        if(!arg12.hasPanelItems()) {
                        }
                        else {
                            v13 = arg12.shownPanelView.getLayoutParams();
                            if(v13 == null) {
                                v13 = new ViewGroup$LayoutParams(v2, v2);
                            }

                            arg12.decorView.setBackgroundResource(arg12.background);
                            ViewParent v3_1 = arg12.shownPanelView.getParent();
                            if((v3_1 instanceof ViewGroup)) {
                                ((ViewGroup)v3_1).removeView(arg12.shownPanelView);
                            }

                            arg12.decorView.addView(arg12.shownPanelView, v13);
                            if(!arg12.shownPanelView.hasFocus()) {
                                arg12.shownPanelView.requestFocus();
                            }

                        label_89:
                            v4 = v2;
                            goto label_90;
                        }
                    }

                    goto label_111;
                }
                else if(arg12.createdPanelView != null) {
                    v13 = arg12.createdPanelView.getLayoutParams();
                    if(v13 != null) {
                        int v3 = -1;
                        if(v13.width == v3) {
                            v4 = v3;
                        }
                        else {
                            goto label_89;
                        }
                    }
                    else {
                        goto label_89;
                    }
                }
                else {
                    goto label_89;
                }

            label_90:
                arg12.isHandled = false;
                WindowManager$LayoutParams v3_2 = new WindowManager$LayoutParams(v4, -2, arg12.x, arg12.y, 1002, 0x820000, -3);
                v3_2.gravity = arg12.gravity;
                v3_2.windowAnimations = arg12.windowAnimations;
                ((WindowManager)v0_1).addView(arg12.decorView, ((ViewGroup$LayoutParams)v3_2));
                arg12.isOpen = true;
                if(arg12.featureId != 0) {
                    return;
                }

                this.updateBackInvokedCallbackState();
                return;
            label_111:
                arg12.refreshDecorView = true;
            }
        }
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    private boolean performPanelShortcut(PanelFeatureState arg3, int arg4, KeyEvent arg5, int arg6) {
        boolean v1 = false;
        if(arg5.isSystem()) {
            return 0;
        }

        if(((arg3.isPrepared) || (this.preparePanel(arg3, arg5))) && arg3.menu != null) {
            v1 = arg3.menu.performShortcut(arg4, arg5, arg6);
        }

        if((v1) && (arg6 & 1) == 0 && this.mDecorContentParent == null) {
            this.closePanel(arg3, true);
        }

        return v1;
    }

    private boolean preparePanel(PanelFeatureState arg9, KeyEvent arg10) {
        if(this.mDestroyed) {
            return 0;
        }

        if(arg9.isPrepared) {
            return 1;
        }

        PanelFeatureState v0 = this.mPreparedPanel;
        if(v0 != null && v0 != arg9) {
            this.closePanel(v0, false);
        }

        Window$Callback v0_1 = this.getWindowCallback();
        if(v0_1 != null) {
            arg9.createdPanelView = v0_1.onCreatePanelView(arg9.featureId);
        }

        int v3 = arg9.featureId == 0 || arg9.featureId == 108 ? 1 : 0;
        if(v3 != 0) {
            DecorContentParent v4 = this.mDecorContentParent;
            if(v4 != null) {
                v4.setMenuPrepared();
            }
        }

        if(arg9.createdPanelView == null && (v3 == 0 || !(this.peekSupportActionBar() instanceof ToolbarActionBar))) {
            MenuBuilder v5 = null;
            if(arg9.menu == null || (arg9.refreshMenuContent)) {
                if(arg9.menu == null && (!this.initializePanelMenu(arg9) || arg9.menu == null)) {
                    return 0;
                }

                if(v3 != 0 && this.mDecorContentParent != null) {
                    if(this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
                    }

                    this.mDecorContentParent.setMenu(arg9.menu, this.mActionMenuPresenterCallback);
                }

                arg9.menu.stopDispatchingItemsChanged();
                if(!v0_1.onCreatePanelMenu(arg9.featureId, arg9.menu)) {
                    arg9.setMenu(v5);
                    if(v3 != 0) {
                        DecorContentParent v9 = this.mDecorContentParent;
                        if(v9 != null) {
                            v9.setMenu(((Menu)v5), this.mActionMenuPresenterCallback);
                        }
                    }

                    return 0;
                }

                arg9.refreshMenuContent = false;
            }

            arg9.menu.stopDispatchingItemsChanged();
            if(arg9.frozenActionViewState != null) {
                arg9.menu.restoreActionViewStates(arg9.frozenActionViewState);
                arg9.frozenActionViewState = ((Bundle)v5);
            }

            if(!v0_1.onPreparePanel(0, arg9.createdPanelView, arg9.menu)) {
                if(v3 != 0) {
                    DecorContentParent v10 = this.mDecorContentParent;
                    if(v10 != null) {
                        v10.setMenu(((Menu)v5), this.mActionMenuPresenterCallback);
                    }
                }

                arg9.menu.startDispatchingItemsChanged();
                return 0;
            }

            int v10_1 = arg10 != null ? arg10.getDeviceId() : -1;
            boolean v10_2 = KeyCharacterMap.load(v10_1).getKeyboardType() != 1 ? true : false;
            arg9.qwertyMode = v10_2;
            arg9.menu.setQwertyMode(arg9.qwertyMode);
            arg9.menu.startDispatchingItemsChanged();
        }

        arg9.isPrepared = true;
        arg9.isHandled = false;
        this.mPreparedPanel = arg9;
        return 1;
    }

    private void reopenMenu(boolean arg6) {
        PanelFeatureState v6;
        DecorContentParent v0 = this.mDecorContentParent;
        if(v0 != null && (v0.canShowOverflowMenu()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey() || (this.mDecorContentParent.isOverflowMenuShowPending()))) {
            Window$Callback v0_1 = this.getWindowCallback();
            int v4 = 108;
            if((this.mDecorContentParent.isOverflowMenuShowing()) && (arg6)) {
                this.mDecorContentParent.hideOverflowMenu();
                if(!this.mDestroyed) {
                    v0_1.onPanelClosed(v4, this.getPanelState(0, true).menu);
                    return;
                }
            }
            else if(v0_1 != null && !this.mDestroyed) {
                if((this.mInvalidatePanelMenuPosted) && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                    this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                    this.mInvalidatePanelMenuRunnable.run();
                }

                v6 = this.getPanelState(0, true);
                if(v6.menu == null) {
                    return;
                }

                if(v6.refreshMenuContent) {
                    return;
                }

                if(!v0_1.onPreparePanel(0, v6.createdPanelView, v6.menu)) {
                    return;
                }

                v0_1.onMenuOpened(v4, v6.menu);
                this.mDecorContentParent.showOverflowMenu();
            }

            return;
        }

        v6 = this.getPanelState(0, true);
        v6.refreshDecorView = true;
        this.closePanel(v6, false);
        this.openPanel(v6, null);
    }

    public boolean requestWindowFeature(int arg5) {
        arg5 = this.sanitizeWindowFeatureId(arg5);
        int v2 = 108;
        if((this.mWindowNoTitle) && arg5 == v2) {
            return 0;
        }

        if((this.mHasActionBar) && arg5 == 1) {
            this.mHasActionBar = false;
        }

        if(arg5 != 1) {
            if(arg5 != 2) {
                if(arg5 != 5) {
                    if(arg5 != 10) {
                        if(arg5 != v2) {
                            if(arg5 != 109) {
                                return this.mWindow.requestFeature(arg5);
                            }

                            this.throwFeatureRequestIfSubDecorInstalled();
                            this.mOverlayActionBar = true;
                            return 1;
                        }

                        this.throwFeatureRequestIfSubDecorInstalled();
                        this.mHasActionBar = true;
                        return 1;
                    }

                    this.throwFeatureRequestIfSubDecorInstalled();
                    this.mOverlayActionMode = true;
                    return 1;
                }

                this.throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = true;
                return 1;
            }

            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return 1;
        }

        this.throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return 1;
    }

    private int sanitizeWindowFeatureId(int arg2) {
        String v0 = "AppCompatDelegate";
        if(arg2 == 8) {
            Log.i(v0, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }

        if(arg2 == 9) {
            Log.i(v0, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }

        return arg2;
    }

    void setConfigurationLocales(Configuration arg1, LocaleListCompat arg2) {
        Api24Impl.setLocales(arg1, arg2);
    }

    public void setContentView(int arg3) {
        this.ensureSubDecor();
        View v0 = this.mSubDecor.findViewById(0x1020002);
        ((ViewGroup)v0).removeAllViews();
        LayoutInflater.from(this.mContext).inflate(arg3, ((ViewGroup)v0));
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    public void setContentView(View arg3) {
        this.ensureSubDecor();
        View v0 = this.mSubDecor.findViewById(0x1020002);
        ((ViewGroup)v0).removeAllViews();
        ((ViewGroup)v0).addView(arg3);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    public void setContentView(View arg3, ViewGroup$LayoutParams arg4) {
        this.ensureSubDecor();
        View v0 = this.mSubDecor.findViewById(0x1020002);
        ((ViewGroup)v0).removeAllViews();
        ((ViewGroup)v0).addView(arg3, arg4);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    void setDefaultLocalesForLocaleList(LocaleListCompat arg1) {
        Api24Impl.setDefaultLocales(arg1);
    }

    public void setHandleNativeActionModesEnabled(boolean arg1) {
        this.mHandleNativeActionModes = arg1;
    }

    public void setLocalNightMode(int arg2) {
        if(this.mLocalNightMode != arg2) {
            this.mLocalNightMode = arg2;
            if(this.mBaseContextAttached) {
                this.applyDayNight();
            }
        }
    }

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher arg3) {
        super.setOnBackInvokedDispatcher(arg3);
        OnBackInvokedDispatcher v0 = this.mDispatcher;
        if(v0 != null) {
            OnBackInvokedCallback v1 = this.mBackCallback;
            if(v1 != null) {
                Api33Impl.unregisterOnBackInvokedCallback(v0, v1);
                this.mBackCallback = null;
            }
        }

        if(arg3 == null) {
            Object v0_1 = this.mHost;
            if(!(v0_1 instanceof Activity)) {
                goto label_18;
            }
            else if(((Activity)v0_1).getWindow() != null) {
                this.mDispatcher = Api33Impl.getOnBackInvokedDispatcher(this.mHost);
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            this.mDispatcher = arg3;
        }

        this.updateBackInvokedCallbackState();
    }

    public void setSupportActionBar(Toolbar arg4) {
        if(!(this.mHost instanceof Activity)) {
            return;
        }

        ActionBar v0 = this.getSupportActionBar();
        if(!(v0 instanceof WindowDecorActionBar)) {
            MenuInflater v1 = null;
            this.mMenuInflater = v1;
            if(v0 != null) {
                v0.onDestroy();
            }

            this.mActionBar = ((ActionBar)v1);
            if(arg4 != null) {
                ToolbarActionBar v0_1 = new ToolbarActionBar(arg4, this.getTitle(), this.mAppCompatWindowCallback);
                this.mActionBar = ((ActionBar)v0_1);
                this.mAppCompatWindowCallback.setActionBarCallback(v0_1.mMenuCallback);
                arg4.setBackInvokedCallbackEnabled(true);
            }
            else {
                this.mAppCompatWindowCallback.setActionBarCallback(((ActionBarMenuCallback)v1));
            }

            this.invalidateOptionsMenu();
            return;
        }

        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    public void setTheme(int arg1) {
        this.mThemeResId = arg1;
    }

    public final void setTitle(CharSequence arg2) {
        this.mTitle = arg2;
        DecorContentParent v0 = this.mDecorContentParent;
        if(v0 != null) {
            v0.setWindowTitle(arg2);
            return;
        }

        if(this.peekSupportActionBar() != null) {
            this.peekSupportActionBar().setWindowTitle(arg2);
            return;
        }

        TextView v1 = this.mTitleView;
        if(v1 != null) {
            v1.setText(arg2);
        }
    }

    final boolean shouldAnimateActionModeView() {
        if(this.mSubDecorInstalled) {
            ViewGroup v1 = this.mSubDecor;
            if(v1 != null && (ViewCompat.isLaidOut(((View)v1)))) {
                return 1;
            }
        }

        return 0;
    }

    private boolean shouldInheritContext(ViewParent arg3) {
        if(arg3 == null) {
            return 0;
        }

        View v2 = this.mWindow.getDecorView();
        while(true) {
            if(arg3 == null) {
                return 1;
            }

            if(arg3 != (((ViewParent)v2)) && ((arg3 instanceof View))) {
                if(ViewCompat.isAttachedToWindow(arg3)) {
                }
                else {
                    arg3 = arg3.getParent();
                    continue;
                }
            }

            return 0;
        }

        return 0;
    }

    boolean shouldRegisterBackInvokedCallback() {
        if(this.mDispatcher == null) {
            return 0;
        }

        PanelFeatureState v0 = this.getPanelState(0, false);
        if(v0 != null && (v0.isOpen)) {
            return 1;
        }

        if(this.mActionMode != null) {
            return 1;
        }

        return 0;
    }

    public ActionMode startSupportActionMode(androidx.appcompat.view.ActionMode$Callback arg3) {
        if(arg3 != null) {
            ActionMode v0 = this.mActionMode;
            if(v0 != null) {
                v0.finish();
            }

            ActionModeCallbackWrapperV9 v0_1 = new ActionModeCallbackWrapperV9(this, arg3);
            ActionBar v3 = this.getSupportActionBar();
            if(v3 != null) {
                ActionMode v3_1 = v3.startActionMode(((androidx.appcompat.view.ActionMode$Callback)v0_1));
                this.mActionMode = v3_1;
                if(v3_1 != null) {
                    AppCompatCallback v1 = this.mAppCompatCallback;
                    if(v1 != null) {
                        v1.onSupportActionModeStarted(v3_1);
                    }
                }
            }

            if(this.mActionMode == null) {
                this.mActionMode = this.startSupportActionModeFromWindow(((androidx.appcompat.view.ActionMode$Callback)v0_1));
            }

            this.updateBackInvokedCallbackState();
            return this.mActionMode;
        }

        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    ActionMode startSupportActionModeFromWindow(androidx.appcompat.view.ActionMode$Callback arg8) {
        ActionModeCallbackWrapperV9 v8;
        this.endOnGoingFadeAnimation();
        ActionMode v0 = this.mActionMode;
        if(v0 != null) {
            v0.finish();
        }

        if(!(arg8 instanceof ActionModeCallbackWrapperV9)) {
            v8 = new ActionModeCallbackWrapperV9(this, arg8);
        }

        AppCompatCallback v0_1 = this.mAppCompatCallback;
        AttributeSet v1 = null;
        if(v0_1 == null) {
            goto label_16;
        }
        else if(!this.mDestroyed) {
            try {
                v0 = v0_1.onWindowStartingSupportActionMode(((androidx.appcompat.view.ActionMode$Callback)v8));
            }
            catch(AbstractMethodError ) {
            label_16:
                v0 = ((ActionMode)v1);
            }
        }
        else {
            goto label_16;
        }

        if(v0 != null) {
            this.mActionMode = v0;
        }
        else {
            boolean v3 = true;
            if(this.mActionModeView == null) {
                if(this.mIsFloating) {
                    TypedValue v0_2 = new TypedValue();
                    Resources$Theme v4 = this.mContext.getTheme();
                    v4.resolveAttribute(attr.actionBarTheme, v0_2, true);
                    int v5 = v0_2.resourceId;
                    Context v6 = this.mContext;
                    if(v5 != 0) {
                        Resources$Theme v5_1 = v6.getResources().newTheme();
                        v5_1.setTo(v4);
                        v5_1.applyStyle(v0_2.resourceId, true);
                        androidx.appcompat.view.ContextThemeWrapper v6_1 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
                        ((Context)v6_1).getTheme().setTo(v5_1);
                    }

                    this.mActionModeView = new ActionBarContextView(v6);
                    PopupWindow v4_1 = new PopupWindow(v6, v1, attr.actionModePopupWindowStyle);
                    this.mActionModePopup = v4_1;
                    PopupWindowCompat.setWindowLayoutType(v4_1, 2);
                    this.mActionModePopup.setContentView(this.mActionModeView);
                    this.mActionModePopup.setWidth(-1);
                    v6.getTheme().resolveAttribute(attr.actionBarSize, v0_2, true);
                    this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(v0_2.data, v6.getResources().getDisplayMetrics()));
                    this.mActionModePopup.setHeight(-2);
                    this.mShowActionModePopup = new Runnable() {
                        public void run() {
                            AppCompatDelegateImpl.this.mActionModePopup.showAtLocation(AppCompatDelegateImpl.this.mActionModeView, 55, 0, 0);
                            AppCompatDelegateImpl.this.endOnGoingFadeAnimation();
                            boolean v0 = AppCompatDelegateImpl.this.shouldAnimateActionModeView();
                            AppCompatDelegateImpl v1 = AppCompatDelegateImpl.this;
                            float v2 = 1f;
                            if(v0) {
                                v1.mActionModeView.setAlpha(0f);
                                AppCompatDelegateImpl.this.mFadeAnim = ViewCompat.animate(AppCompatDelegateImpl.this.mActionModeView).alpha(v2);
                                AppCompatDelegateImpl.this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter() {
                                    public void onAnimationEnd(View arg2) {
                                        this.this$1.this$0.mActionModeView.setAlpha(1f);
                                        this.this$1.this$0.mFadeAnim.setListener(null);
                                        this.this$1.this$0.mFadeAnim = null;
                                    }

                                    public void onAnimationStart(View arg1) {
                                        this.this$1.this$0.mActionModeView.setVisibility(0);
                                    }
                                });
                                return;
                            }

                            v1.mActionModeView.setAlpha(v2);
                            AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
                        }
                    };
                }
                else {
                    View v0_3 = this.mSubDecor.findViewById(id.action_mode_bar_stub);
                    if(v0_3 == null) {
                        goto label_85;
                    }

                    ((ViewStubCompat)v0_3).setLayoutInflater(LayoutInflater.from(this.getActionBarThemedContext()));
                    this.mActionModeView = ((ViewStubCompat)v0_3).inflate();
                }
            }

        label_85:
            if(this.mActionModeView == null) {
                goto label_138;
            }

            this.endOnGoingFadeAnimation();
            this.mActionModeView.killMode();
            Context v4_2 = this.mActionModeView.getContext();
            ActionBarContextView v5_2 = this.mActionModeView;
            if(this.mActionModePopup == null) {
            }
            else {
                v3 = false;
            }

            StandaloneActionMode v0_4 = new StandaloneActionMode(v4_2, v5_2, ((androidx.appcompat.view.ActionMode$Callback)v8), v3);
            if(((androidx.appcompat.view.ActionMode$Callback)v8).onCreateActionMode(((ActionMode)v0_4), ((ActionMode)v0_4).getMenu())) {
                ((ActionMode)v0_4).invalidate();
                this.mActionModeView.initForMode(((ActionMode)v0_4));
                this.mActionMode = ((ActionMode)v0_4);
                boolean v8_1 = this.shouldAnimateActionModeView();
                ActionBarContextView v0_5 = this.mActionModeView;
                float v1_1 = 1f;
                if(v8_1) {
                    v0_5.setAlpha(0f);
                    ViewPropertyAnimatorCompat v8_2 = ViewCompat.animate(this.mActionModeView).alpha(v1_1);
                    this.mFadeAnim = v8_2;
                    v8_2.setListener(new ViewPropertyAnimatorListenerAdapter() {
                        public void onAnimationEnd(View arg2) {
                            AppCompatDelegateImpl.this.mActionModeView.setAlpha(1f);
                            AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                            AppCompatDelegateImpl.this.mFadeAnim = null;
                        }

                        public void onAnimationStart(View arg2) {
                            AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
                            if((AppCompatDelegateImpl.this.mActionModeView.getParent() instanceof View)) {
                                ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.mActionModeView.getParent());
                            }
                        }
                    });
                }
                else {
                    v0_5.setAlpha(v1_1);
                    this.mActionModeView.setVisibility(0);
                    if((this.mActionModeView.getParent() instanceof View)) {
                        ViewCompat.requestApplyInsets(this.mActionModeView.getParent());
                    }
                }

                if(this.mActionModePopup == null) {
                    goto label_138;
                }

                this.mWindow.getDecorView().post(this.mShowActionModePopup);
                goto label_138;
            }

            this.mActionMode = ((ActionMode)v1);
        }

    label_138:
        ActionMode v8_3 = this.mActionMode;
        if(v8_3 != null) {
            v0_1 = this.mAppCompatCallback;
            if(v0_1 != null) {
                v0_1.onSupportActionModeStarted(v8_3);
            }
        }

        this.updateBackInvokedCallbackState();
        return this.mActionMode;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if(!this.mSubDecorInstalled) {
            return;
        }

        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private AppCompatActivity tryUnwrapContext() {
        AppCompatActivity v0;
        Context v2 = this.mContext;
        while(true) {
            v0 = null;
            if(v2 != null) {
                if((v2 instanceof AppCompatActivity)) {
                    return ((AppCompatActivity)v2);
                }
                else if((v2 instanceof ContextWrapper)) {
                    v2 = ((ContextWrapper)v2).getBaseContext();
                    continue;
                }
            }

            return v0;
        }

        return v0;
    }

    private void updateActivityConfiguration(Configuration arg3) {
        Object v0 = this.mHost;
        if((v0 instanceof LifecycleOwner)) {
            if(v0.getLifecycle().getCurrentState().isAtLeast(State.CREATED)) {
                ((Activity)v0).onConfigurationChanged(arg3);
                return;
            }
        }
        else if((this.mCreated) && !this.mDestroyed) {
            ((Activity)v0).onConfigurationChanged(arg3);
        }
    }

    private boolean updateAppConfiguration(int arg9, LocaleListCompat arg10, boolean arg11) {
        boolean v10_2;
        AppCompatDelegateImpl v0 = this;
        int v2 = arg9;
        LocaleListCompat v3 = arg10;
        Configuration v8 = v0.createOverrideAppConfiguration(this.mContext, v2, v3, null, false);
        arg9 = v0.getActivityHandlesConfigChangesFlags(v0.mContext);
        Configuration v10 = v0.mEffectiveConfiguration;
        if(v10 == null) {
            v10 = v0.mContext.getResources().getConfiguration();
        }

        int v1 = v10.uiMode & 0x30;
        int v4 = v8.uiMode & 0x30;
        arg10 = v0.getConfigurationLocales(v10);
        Configuration v5 = null;
        LocaleListCompat v8_1 = v3 == null ? ((LocaleListCompat)v5) : v0.getConfigurationLocales(v8);
        boolean v6 = false;
        v1 = v1 != v4 ? 0x200 : 0;
        if(v8_1 != null && !arg10.equals(v8_1)) {
            v1 |= 0x2004;
        }

        boolean v7 = true;
        if((~arg9 & v1) == 0 || !arg11 || !v0.mBaseContextAttached) {
        label_53:
            v10_2 = false;
        }
        else {
            if(!AppCompatDelegateImpl.sCanReturnDifferentContext && !v0.mCreated) {
                goto label_53;
            }

            Object v10_1 = v0.mHost;
            if(!(v10_1 instanceof Activity)) {
                goto label_53;
            }

            if(((Activity)v10_1).isChild()) {
                goto label_53;
            }

            ActivityCompat.recreate(v0.mHost);
            v10_2 = true;
        }

        if((v10_2) || v1 == 0) {
            v7 = v10_2;
        }
        else {
            if((arg9 & v1) == v1) {
                v6 = true;
            }

            v0.updateResourcesConfiguration(v4, v8_1, v6, v5);
        }

        if(v7) {
            Object v9 = v0.mHost;
            if((v9 instanceof AppCompatActivity)) {
                if((v1 & 0x200) != 0) {
                    ((AppCompatActivity)v9).onNightModeChanged(v2);
                }

                if((v1 & 4) == 0) {
                    goto label_73;
                }

                v0.mHost.onLocalesChanged(v3);
            }
        }

    label_73:
        if((v7) && v8_1 != null) {
            v0.setDefaultLocalesForLocaleList(v0.getConfigurationLocales(v0.mContext.getResources().getConfiguration()));
        }

        return v7;
    }

    void updateBackInvokedCallbackState() {
        if(Build$VERSION.SDK_INT >= 33) {
            boolean v0 = this.shouldRegisterBackInvokedCallback();
            if((v0) && this.mBackCallback == null) {
                this.mBackCallback = Api33Impl.registerOnBackPressedCallback(this.mDispatcher, this);
                return;
            }

            if(v0) {
                return;
            }

            OnBackInvokedCallback v0_1 = this.mBackCallback;
            if(v0_1 == null) {
                return;
            }

            Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, v0_1);
        }
    }

    private void updateResourcesConfiguration(int arg4, LocaleListCompat arg5, boolean arg6, Configuration arg7) {
        Resources v0 = this.mContext.getResources();
        Configuration v1 = new Configuration(v0.getConfiguration());
        if(arg7 != null) {
            v1.updateFrom(arg7);
        }

        v1.uiMode = arg4 | v0.getConfiguration().uiMode & -49;
        if(arg5 != null) {
            this.setConfigurationLocales(v1, arg5);
        }

        v0.updateConfiguration(v1, null);
        arg4 = this.mThemeResId;
        if(arg4 != 0) {
            this.mContext.setTheme(arg4);
            this.mContext.getTheme().applyStyle(this.mThemeResId, true);
        }

        if((arg6) && ((this.mHost instanceof Activity))) {
            this.updateActivityConfiguration(v1);
        }
    }

    final int updateStatusGuard(WindowInsetsCompat arg11, Rect arg12) {
        View v11_1;
        int v11;
        int v1;
        int v0 = 0;
        if(arg11 != null) {
            v1 = arg11.getSystemWindowInsetTop();
        }
        else if(arg12 != null) {
            v1 = arg12.top;
        }
        else {
            v1 = 0;
        }

        ActionBarContextView v2 = this.mActionModeView;
        int v3 = 8;
        if(v2 == null || !(v2.getLayoutParams() instanceof ViewGroup$MarginLayoutParams)) {
            v11 = 0;
        }
        else {
            ViewGroup$LayoutParams v2_1 = this.mActionModeView.getLayoutParams();
            int v5 = 1;
            if(this.mActionModeView.isShown()) {
                if(this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }

                Rect v4 = this.mTempRect1;
                Rect v6 = this.mTempRect2;
                if(arg11 == null) {
                    v4.set(arg12);
                }
                else {
                    v4.set(arg11.getSystemWindowInsetLeft(), arg11.getSystemWindowInsetTop(), arg11.getSystemWindowInsetRight(), arg11.getSystemWindowInsetBottom());
                }

                ViewUtils.computeFitSystemWindows(this.mSubDecor, v4, v6);
                v11 = v4.top;
                int v12 = v4.left;
                int v4_1 = v4.right;
                WindowInsetsCompat v6_1 = ViewCompat.getRootWindowInsets(this.mSubDecor);
                int v7 = v6_1 == null ? 0 : v6_1.getSystemWindowInsetLeft();
                int v6_2 = v6_1 == null ? 0 : v6_1.getSystemWindowInsetRight();
                if(((ViewGroup$MarginLayoutParams)v2_1).topMargin != v11 || ((ViewGroup$MarginLayoutParams)v2_1).leftMargin != v12 || ((ViewGroup$MarginLayoutParams)v2_1).rightMargin != v4_1) {
                    ((ViewGroup$MarginLayoutParams)v2_1).topMargin = v11;
                    ((ViewGroup$MarginLayoutParams)v2_1).leftMargin = v12;
                    ((ViewGroup$MarginLayoutParams)v2_1).rightMargin = v4_1;
                    v12 = 1;
                }
                else {
                    v12 = 0;
                }

                if(v11 <= 0 || this.mStatusGuard != null) {
                    v11_1 = this.mStatusGuard;
                    if(v11_1 != null) {
                        ViewGroup$LayoutParams v11_3 = v11_1.getLayoutParams();
                        if(((ViewGroup$MarginLayoutParams)v11_3).height == ((ViewGroup$MarginLayoutParams)v2_1).topMargin && ((ViewGroup$MarginLayoutParams)v11_3).leftMargin == v7 && ((ViewGroup$MarginLayoutParams)v11_3).rightMargin == v6_2) {
                            goto label_101;
                        }

                        ((ViewGroup$MarginLayoutParams)v11_3).height = ((ViewGroup$MarginLayoutParams)v2_1).topMargin;
                        ((ViewGroup$MarginLayoutParams)v11_3).leftMargin = v7;
                        ((ViewGroup$MarginLayoutParams)v11_3).rightMargin = v6_2;
                        this.mStatusGuard.setLayoutParams(v11_3);
                    }
                }
                else {
                    v11_1 = new View(this.mContext);
                    this.mStatusGuard = v11_1;
                    v11_1.setVisibility(v3);
                    FrameLayout$LayoutParams v11_2 = new FrameLayout$LayoutParams(-1, ((ViewGroup$MarginLayoutParams)v2_1).topMargin, 51);
                    v11_2.leftMargin = v7;
                    v11_2.rightMargin = v6_2;
                    this.mSubDecor.addView(this.mStatusGuard, -1, ((ViewGroup$LayoutParams)v11_2));
                }

            label_101:
                v11_1 = this.mStatusGuard;
                if(v11_1 != null) {
                }
                else {
                    v5 = 0;
                }

                if(v5 != 0 && v11_1.getVisibility() != 0) {
                    this.updateStatusGuardColor(this.mStatusGuard);
                }

                if(!this.mOverlayActionMode && v5 != 0) {
                    v1 = 0;
                }

                v11 = v5;
                v5 = v12;
            }
            else {
                if(((ViewGroup$MarginLayoutParams)v2_1).topMargin != 0) {
                    ((ViewGroup$MarginLayoutParams)v2_1).topMargin = 0;
                    v11 = 0;
                    goto label_124;
                }

                v11 = 0;
                v5 = 0;
            }

        label_124:
            if(v5 == 0) {
                goto label_129;
            }

            this.mActionModeView.setLayoutParams(v2_1);
        }

    label_129:
        View v10 = this.mStatusGuard;
        if(v10 != null) {
            if(v11 != 0) {
            }
            else {
                v0 = v3;
            }

            v10.setVisibility(v0);
        }

        return v1;
    }

    private void updateStatusGuardColor(View arg2) {
        int v0 = ViewCompat.getWindowSystemUiVisibility(arg2) & 0x2000;
        Context v1 = this.mContext;
        int v1_1 = v0 != 0 ? ContextCompat.getColor(v1, color.abc_decor_view_status_guard_light) : ContextCompat.getColor(v1, color.abc_decor_view_status_guard);
        arg2.setBackgroundColor(v1_1);
    }
}


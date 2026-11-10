package androidx.core.view;

import android.os.Build$VERSION;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;

public final class WindowInsetsControllerCompat {
    class Impl20 extends Impl {
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected final Window mWindow;

        Impl20(Window arg1, SoftwareKeyboardControllerCompat arg2) {
            super();
            this.mWindow = arg1;
            this.mSoftwareKeyboardControllerCompat = arg2;
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg1) {
        }

        void controlWindowInsetsAnimation(int arg1, long arg2, Interpolator arg4, CancellationSignal arg5, WindowInsetsAnimationControlListenerCompat arg6) {
        }

        int getSystemBarsBehavior() {
            Object v1 = this.mWindow.getDecorView().getTag(356039078);
            if(v1 != null) {
                return ((Integer)v1).intValue();
            }

            return 1;
        }

        void hide(int arg3) {
            int v0;
            for(v0 = 1; v0 <= 0x200; v0 <<= 1) {
                if((arg3 & v0) == 0) {
                }
                else {
                    this.hideForType(v0);
                }
            }
        }

        private void hideForType(int arg2) {
            if(arg2 != 1) {
                int v0 = 2;
                if(arg2 != v0) {
                    if(arg2 != 8) {
                        return;
                    }

                    this.mSoftwareKeyboardControllerCompat.hide();
                    return;
                }

                this.setSystemUiFlag(v0);
                return;
            }

            this.setSystemUiFlag(4);
        }

        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg1) {
        }

        void setSystemBarsBehavior(int arg4) {
            this.mWindow.getDecorView().setTag(356039078, Integer.valueOf(arg4));
            if(arg4 != 0) {
                int v1 = 0x800;
                int v2 = 0x1000;
                if(arg4 != 1) {
                    if(arg4 != 2) {
                        return;
                    }

                    this.unsetSystemUiFlag(v1);
                    this.setSystemUiFlag(v2);
                    return;
                }

                this.unsetSystemUiFlag(v2);
                this.setSystemUiFlag(v1);
                return;
            }

            this.unsetSystemUiFlag(0x1800);
        }

        protected void setSystemUiFlag(int arg2) {
            View v1 = this.mWindow.getDecorView();
            v1.setSystemUiVisibility(arg2 | v1.getSystemUiVisibility());
        }

        protected void setWindowFlag(int arg1) {
            this.mWindow.addFlags(arg1);
        }

        void show(int arg3) {
            int v0;
            for(v0 = 1; v0 <= 0x200; v0 <<= 1) {
                if((arg3 & v0) == 0) {
                }
                else {
                    this.showForType(v0);
                }
            }
        }

        private void showForType(int arg2) {
            if(arg2 != 1) {
                int v0 = 2;
                if(arg2 != v0) {
                    if(arg2 != 8) {
                        return;
                    }

                    this.mSoftwareKeyboardControllerCompat.show();
                    return;
                }

                this.unsetSystemUiFlag(v0);
                return;
            }

            this.unsetSystemUiFlag(4);
            this.unsetWindowFlag(0x400);
        }

        protected void unsetSystemUiFlag(int arg2) {
            View v1 = this.mWindow.getDecorView();
            v1.setSystemUiVisibility(~arg2 & v1.getSystemUiVisibility());
        }

        protected void unsetWindowFlag(int arg1) {
            this.mWindow.clearFlags(arg1);
        }
    }

    class Impl23 extends Impl20 {
        Impl23(Window arg1, SoftwareKeyboardControllerCompat arg2) {
            super(arg1, arg2);
        }

        public boolean isAppearanceLightStatusBars() {
            if((this.mWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0) {
                return 1;
            }

            return 0;
        }

        public void setAppearanceLightStatusBars(boolean arg2) {
            int v0 = 0x2000;
            if(arg2) {
                this.unsetWindowFlag(0x4000000);
                this.setWindowFlag(0x80000000);
                this.setSystemUiFlag(v0);
                return;
            }

            this.unsetSystemUiFlag(v0);
        }
    }

    class Impl26 extends Impl23 {
        Impl26(Window arg1, SoftwareKeyboardControllerCompat arg2) {
            super(arg1, arg2);
        }

        public boolean isAppearanceLightNavigationBars() {
            if((this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0) {
                return 1;
            }

            return 0;
        }

        public void setAppearanceLightNavigationBars(boolean arg2) {
            int v0 = 16;
            if(arg2) {
                this.unsetWindowFlag(0x8000000);
                this.setWindowFlag(0x80000000);
                this.setSystemUiFlag(v0);
                return;
            }

            this.unsetSystemUiFlag(v0);
        }
    }

    class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap mListeners;
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        Impl30(Window arg2, WindowInsetsControllerCompat arg3, SoftwareKeyboardControllerCompat arg4) {
            this(arg2.getInsetsController(), arg3, arg4);
            this.mWindow = arg2;
        }

        Impl30(WindowInsetsController arg2, WindowInsetsControllerCompat arg3, SoftwareKeyboardControllerCompat arg4) {
            super();
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = arg2;
            this.mCompatController = arg3;
            this.mSoftwareKeyboardControllerCompat = arg4;
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg3) {
            if(this.mListeners.containsKey(arg3)) {
                return;
            }

            WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0 v0 = new WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0(this, arg3);
            this.mListeners.put(arg3, v0);
            this.mInsetsController.addOnControllableInsetsChangedListener(((WindowInsetsController$OnControllableInsetsChangedListener)v0));
        }

        void controlWindowInsetsAnimation(int arg2, long arg3, Interpolator arg5, CancellationSignal arg6, WindowInsetsAnimationControlListenerCompat arg7) {
            this.mInsetsController.controlWindowInsetsAnimation(arg2, arg3, arg5, arg6, new WindowInsetsAnimationControlListener(arg7) {
                private WindowInsetsAnimationControllerCompat mCompatAnimController;

                public void onCancelled(WindowInsetsAnimationController arg2) {
                    WindowInsetsAnimationControlListenerCompat v0 = this.val$listener;
                    WindowInsetsAnimationControllerCompat v1 = arg2 == null ? null : this.mCompatAnimController;
                    v0.onCancelled(v1);
                }

                public void onFinished(WindowInsetsAnimationController arg1) {
                    this.val$listener.onFinished(this.mCompatAnimController);
                }

                public void onReady(WindowInsetsAnimationController arg2, int arg3) {
                    WindowInsetsAnimationControllerCompat v0 = new WindowInsetsAnimationControllerCompat(arg2);
                    this.mCompatAnimController = v0;
                    this.val$listener.onReady(v0, arg3);
                }
            });
        }

        int getSystemBarsBehavior() {
            Window v0 = this.mWindow;
            if(v0 != null) {
                Object v1 = v0.getDecorView().getTag(356039078);
                if(v1 != null) {
                    return ((Integer)v1).intValue();
                }

                return 1;
            }

            return this.mInsetsController.getSystemBarsBehavior();
        }

        void hide(int arg2) {
            if((arg2 & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.hide();
            }

            this.mInsetsController.hide(arg2 & -9);
        }

        private boolean isAppearanceLight(int arg4, int arg5) {
            Window v0 = this.mWindow;
            if(v0 != null) {
                if((v0.getDecorView().getSystemUiVisibility() & arg4) != 0) {
                    return 1;
                }

                return 0;
            }

            this.mInsetsController.setSystemBarsAppearance(0, 0);
            if((this.mInsetsController.getSystemBarsAppearance() & arg5) != 0) {
                return 1;
            }

            return 0;
        }

        public boolean isAppearanceLightNavigationBars() {
            return this.isAppearanceLight(16, 16);
        }

        public boolean isAppearanceLightStatusBars() {
            return this.isAppearanceLight(0x2000, 8);
        }

        void lambda$addOnControllableInsetsChangedListener$0$androidx-core-view-WindowInsetsControllerCompat$Impl30(OnControllableInsetsChangedListener arg1, WindowInsetsController arg2, int arg3) {
            arg1.onControllableInsetsChanged(this.mCompatController, arg3);
        }

        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg2) {
            Object v2 = this.mListeners.remove(arg2);
            if(v2 != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(((WindowInsetsController$OnControllableInsetsChangedListener)v2));
            }
        }

        private void setAppearanceLight(boolean arg2, int arg3, int arg4) {
            if(this.mWindow != null) {
                if(arg2) {
                    this.setSystemUiFlag(arg3);
                    return;
                }

                this.unsetSystemUiFlag(arg3);
                return;
            }

            WindowInsetsController v1 = this.mInsetsController;
            if(arg2) {
                v1.setSystemBarsAppearance(arg4, arg4);
                return;
            }

            v1.setSystemBarsAppearance(0, arg4);
        }

        public void setAppearanceLightNavigationBars(boolean arg2) {
            this.setAppearanceLight(arg2, 16, 16);
        }

        public void setAppearanceLightStatusBars(boolean arg3) {
            this.setAppearanceLight(arg3, 0x2000, 8);
        }

        void setSystemBarsBehavior(int arg4) {
            Window v0 = this.mWindow;
            if(v0 != null) {
                v0.getDecorView().setTag(356039078, Integer.valueOf(arg4));
                if(arg4 != 0) {
                    int v1 = 0x800;
                    int v2 = 0x1000;
                    if(arg4 != 1) {
                        if(arg4 != 2) {
                            return;
                        }

                        this.unsetSystemUiFlag(v1);
                        this.setSystemUiFlag(v2);
                        return;
                    }

                    this.unsetSystemUiFlag(v2);
                    this.setSystemUiFlag(v1);
                    return;
                }

                this.unsetSystemUiFlag(0x1800);
                return;
            }

            this.mInsetsController.setSystemBarsBehavior(arg4);
        }

        protected void setSystemUiFlag(int arg2) {
            View v1 = this.mWindow.getDecorView();
            v1.setSystemUiVisibility(arg2 | v1.getSystemUiVisibility());
        }

        void show(int arg2) {
            if((arg2 & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.show();
            }

            this.mInsetsController.show(arg2 & -9);
        }

        protected void unsetSystemUiFlag(int arg2) {
            View v1 = this.mWindow.getDecorView();
            v1.setSystemUiVisibility(~arg2 & v1.getSystemUiVisibility());
        }
    }

    class Impl31 extends Impl30 {
        Impl31(Window arg1, WindowInsetsControllerCompat arg2, SoftwareKeyboardControllerCompat arg3) {
            super(arg1, arg2, arg3);
        }

        Impl31(WindowInsetsController arg1, WindowInsetsControllerCompat arg2, SoftwareKeyboardControllerCompat arg3) {
            super(arg1, arg2, arg3);
        }

        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        void setSystemBarsBehavior(int arg1) {
            this.mInsetsController.setSystemBarsBehavior(arg1);
        }
    }

    class Impl35 extends Impl31 {
        Impl35(Window arg1, WindowInsetsControllerCompat arg2, SoftwareKeyboardControllerCompat arg3) {
            super(arg1, arg2, arg3);
        }

        Impl35(WindowInsetsController arg1, WindowInsetsControllerCompat arg2, SoftwareKeyboardControllerCompat arg3) {
            super(arg1, arg2, arg3);
        }

        public boolean isAppearanceLightNavigationBars() {
            if((this.mInsetsController.getSystemBarsAppearance() & 16) != 0) {
                return 1;
            }

            return 0;
        }

        public boolean isAppearanceLightStatusBars() {
            if((this.mInsetsController.getSystemBarsAppearance() & 8) != 0) {
                return 1;
            }

            return 0;
        }

        public void setAppearanceLightNavigationBars(boolean arg2) {
            WindowInsetsController v1 = this.mInsetsController;
            int v0 = 16;
            int v2 = arg2 ? v0 : 0;
            v1.setSystemBarsAppearance(v2, v0);
        }

        public void setAppearanceLightStatusBars(boolean arg2) {
            WindowInsetsController v1 = this.mInsetsController;
            int v0 = 8;
            int v2 = arg2 ? v0 : 0;
            v1.setSystemBarsAppearance(v2, v0);
        }
    }

    class Impl {
        static final int KEY_BEHAVIOR = 356039078;

        Impl() {
            super();
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg1) {
        }

        void controlWindowInsetsAnimation(int arg1, long arg2, Interpolator arg4, CancellationSignal arg5, WindowInsetsAnimationControlListenerCompat arg6) {
        }

        int getSystemBarsBehavior() {
            return 1;
        }

        void hide(int arg1) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return 0;
        }

        public boolean isAppearanceLightStatusBars() {
            return 0;
        }

        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg1) {
        }

        public void setAppearanceLightNavigationBars(boolean arg1) {
        }

        public void setAppearanceLightStatusBars(boolean arg1) {
        }

        void setSystemBarsBehavior(int arg1) {
        }

        void show(int arg1) {
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat arg1, int arg2);
    }

    public static final int BEHAVIOR_DEFAULT = 1;
    @Deprecated public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    @Deprecated public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public WindowInsetsControllerCompat(Window arg3, View arg4) {
        super();
        SoftwareKeyboardControllerCompat v0 = new SoftwareKeyboardControllerCompat(arg4);
        if(Build$VERSION.SDK_INT >= 35) {
            this.mImpl = new Impl35(arg3, this, v0);
            return;
        }

        if(Build$VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(arg3, this, v0);
            return;
        }

        this.mImpl = new Impl26(arg3, v0);
    }

    @Deprecated private WindowInsetsControllerCompat(WindowInsetsController arg3) {
        super();
        if(Build$VERSION.SDK_INT >= 35) {
            this.mImpl = new Impl35(arg3, this, new SoftwareKeyboardControllerCompat(arg3));
            return;
        }

        this.mImpl = new Impl30(arg3, this, new SoftwareKeyboardControllerCompat(arg3));
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg1) {
        this.mImpl.addOnControllableInsetsChangedListener(arg1);
    }

    public void controlWindowInsetsAnimation(int arg1, long arg2, Interpolator arg4, CancellationSignal arg5, WindowInsetsAnimationControlListenerCompat arg6) {
        this.mImpl.controlWindowInsetsAnimation(arg1, arg2, arg4, arg5, arg6);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int arg1) {
        this.mImpl.hide(arg1);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener arg1) {
        this.mImpl.removeOnControllableInsetsChangedListener(arg1);
    }

    public void setAppearanceLightNavigationBars(boolean arg1) {
        this.mImpl.setAppearanceLightNavigationBars(arg1);
    }

    public void setAppearanceLightStatusBars(boolean arg1) {
        this.mImpl.setAppearanceLightStatusBars(arg1);
    }

    public void setSystemBarsBehavior(int arg1) {
        this.mImpl.setSystemBarsBehavior(arg1);
    }

    public void show(int arg1) {
        this.mImpl.show(arg1);
    }

    @Deprecated public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController arg1) {
        return new WindowInsetsControllerCompat(arg1);
    }
}


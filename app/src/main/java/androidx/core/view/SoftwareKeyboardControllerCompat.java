package androidx.core.view;

import android.os.Build$VERSION;
import android.view.View;
import android.view.WindowInsets$Type;
import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import android.view.WindowInsetsController;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat {
    class Impl20 extends Impl {
        private final View mView;

        Impl20(View arg1) {
            super();
            this.mView = arg1;
        }

        void hide() {
            View v0 = this.mView;
            if(v0 != null) {
                v0.getContext().getSystemService("input_method").hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
        }

        static void lambda$show$0(View arg2) {
            arg2.getContext().getSystemService("input_method").showSoftInput(arg2, 0);
        }

        void show() {
            View v0 = this.mView;
            if(v0 == null) {
            }
            else {
                if((v0.isInEditMode()) || (v0.onCheckIsTextEditor())) {
                    v0.requestFocus();
                }
                else {
                    v0 = v0.getRootView().findFocus();
                }

                if(v0 == null) {
                    v0 = this.mView.getRootView().findViewById(0x1020002);
                }

                if(v0 == null) {
                    return;
                }

                if(!v0.hasWindowFocus()) {
                    return;
                }

                v0.post(new SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0(v0));
            }
        }
    }

    class Impl30 extends Impl20 {
        private View mView;
        private WindowInsetsController mWindowInsetsController;

        Impl30(View arg1) {
            super(arg1);
            this.mView = arg1;
        }

        Impl30(WindowInsetsController arg2) {
            super(null);
            this.mWindowInsetsController = arg2;
        }

        void hide() {
            WindowInsetsController v0 = this.mWindowInsetsController;
            if(v0 != null) {
            }
            else {
                View v0_1 = this.mView;
                v0 = v0_1 != null ? v0_1.getWindowInsetsController() : null;
            }

            if(v0 != null) {
                AtomicBoolean v1 = new AtomicBoolean(false);
                SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0 v3 = new SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0(v1);
                v0.addOnControllableInsetsChangedListener(((WindowInsetsController$OnControllableInsetsChangedListener)v3));
                if(!v1.get()) {
                    View v1_1 = this.mView;
                    if(v1_1 != null) {
                        v1_1.getContext().getSystemService("input_method").hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
                    }
                }

                v0.removeOnControllableInsetsChangedListener(((WindowInsetsController$OnControllableInsetsChangedListener)v3));
                v0.hide(WindowInsets$Type.ime());
                return;
            }

            super.hide();
        }

        static void lambda$hide$0(AtomicBoolean arg0, WindowInsetsController arg1, int arg2) {
            boolean v1 = (arg2 & 8) != 0 ? true : false;
            arg0.set(v1);
        }

        void show() {
            if(this.mView != null && Build$VERSION.SDK_INT < 33) {
                this.mView.getContext().getSystemService("input_method").isActive();
            }

            WindowInsetsController v0 = this.mWindowInsetsController;
            if(v0 != null) {
            }
            else {
                View v0_1 = this.mView;
                v0 = v0_1 != null ? v0_1.getWindowInsetsController() : null;
            }

            if(v0 != null) {
                v0.show(WindowInsets$Type.ime());
            }

            super.show();
        }
    }

    class Impl {
        Impl() {
            super();
        }

        void hide() {
        }

        void show() {
        }
    }

    private final Impl mImpl;

    public SoftwareKeyboardControllerCompat(View arg3) {
        super();
        if(Build$VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(arg3);
            return;
        }

        this.mImpl = new Impl20(arg3);
    }

    @Deprecated SoftwareKeyboardControllerCompat(WindowInsetsController arg2) {
        super();
        this.mImpl = new Impl30(arg2);
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }
}


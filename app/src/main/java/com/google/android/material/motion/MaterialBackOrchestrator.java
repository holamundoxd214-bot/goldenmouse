package com.google.android.material.motion;

import android.os.Build$VERSION;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import java.util.Objects;

public final class MaterialBackOrchestrator {
    class com.google.android.material.motion.MaterialBackOrchestrator$1 {
    }

    class Api33BackCallbackDelegate implements BackCallbackDelegate {
        private OnBackInvokedCallback onBackInvokedCallback;

        Api33BackCallbackDelegate(com.google.android.material.motion.MaterialBackOrchestrator$1 arg1) {
            this();
        }

        private Api33BackCallbackDelegate() {
            super();
        }

        OnBackInvokedCallback createOnBackInvokedCallback(MaterialBackHandler arg1) {
            Objects.requireNonNull(arg1);
            return new MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0(arg1);
        }

        boolean isListeningForBackCallbacks() {
            if(this.onBackInvokedCallback != null) {
                return 1;
            }

            return 0;
        }

        public void startListeningForBackCallbacks(MaterialBackHandler arg2, View arg3, boolean arg4) {
            OnBackInvokedDispatcher v3;
            if(this.onBackInvokedCallback != null) {
            }
            else {
                v3 = arg3.findOnBackInvokedDispatcher();
                if(v3 == null) {
                    return;
                }

                goto label_6;
            }

            return;
        label_6:
            OnBackInvokedCallback v2 = this.createOnBackInvokedCallback(arg2);
            this.onBackInvokedCallback = v2;
            int v1 = arg4 ? 1000000 : 0;
            v3.registerOnBackInvokedCallback(v1, v2);
        }

        public void stopListeningForBackCallbacks(View arg2) {
            OnBackInvokedDispatcher v2 = arg2.findOnBackInvokedDispatcher();
            if(v2 == null) {
                return;
            }

            v2.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.onBackInvokedCallback = null;
        }
    }

    class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        Api34BackCallbackDelegate(com.google.android.material.motion.MaterialBackOrchestrator$1 arg1) {
            this();
        }

        private Api34BackCallbackDelegate() {
            super(null);
        }

        OnBackInvokedCallback createOnBackInvokedCallback(MaterialBackHandler arg2) {
            return new OnBackAnimationCallback(arg2) {
                public void onBackCancelled() {
                    if(!Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        return;
                    }

                    this.val$backHandler.cancelBackProgress();
                }

                public void onBackInvoked() {
                    this.val$backHandler.handleBackInvoked();
                }

                public void onBackProgressed(BackEvent arg2) {
                    if(!Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        return;
                    }

                    this.val$backHandler.updateBackProgress(new BackEventCompat(arg2));
                }

                public void onBackStarted(BackEvent arg2) {
                    if(!Api34BackCallbackDelegate.this.isListeningForBackCallbacks()) {
                        return;
                    }

                    this.val$backHandler.startBackProgress(new BackEventCompat(arg2));
                }
            };
        }
    }

    interface BackCallbackDelegate {
        void startListeningForBackCallbacks(MaterialBackHandler arg1, View arg2, boolean arg3);

        void stopListeningForBackCallbacks(View arg1);
    }

    private final BackCallbackDelegate backCallbackDelegate;
    private final MaterialBackHandler backHandler;
    private final View view;

    public MaterialBackOrchestrator(MaterialBackHandler arg2, View arg3) {
        super();
        this.backCallbackDelegate = MaterialBackOrchestrator.createBackCallbackDelegate();
        this.backHandler = arg2;
        this.view = arg3;
    }

    public MaterialBackOrchestrator(View arg2) {
        this(arg2, arg2);
    }

    private static BackCallbackDelegate createBackCallbackDelegate() {
        com.google.android.material.motion.MaterialBackOrchestrator$1 v2 = null;
        if(Build$VERSION.SDK_INT >= 34) {
            return new Api34BackCallbackDelegate(v2);
        }

        if(Build$VERSION.SDK_INT >= 33) {
            return new Api33BackCallbackDelegate(v2);
        }

        return ((BackCallbackDelegate)v2);
    }

    public boolean shouldListenForBackCallbacks() {
        if(this.backCallbackDelegate != null) {
            return 1;
        }

        return 0;
    }

    public void startListeningForBackCallbacks() {
        this.startListeningForBackCallbacks(false);
    }

    private void startListeningForBackCallbacks(boolean arg3) {
        BackCallbackDelegate v0 = this.backCallbackDelegate;
        if(v0 != null) {
            v0.startListeningForBackCallbacks(this.backHandler, this.view, arg3);
        }
    }

    public void startListeningForBackCallbacksWithPriorityOverlay() {
        this.startListeningForBackCallbacks(true);
    }

    public void stopListeningForBackCallbacks() {
        BackCallbackDelegate v0 = this.backCallbackDelegate;
        if(v0 != null) {
            v0.stopListeningForBackCallbacks(this.view);
        }
    }
}


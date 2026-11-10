package androidx.core.view.insets;

import android.graphics.RectF;
import androidx.core.graphics.Insets;
import java.util.ArrayList;
import java.util.List;

class ProtectionGroup implements Callback {
    private int mAnimationCount;
    private boolean mDisposed;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;
    private final SystemBarStateMonitor mMonitor;
    private final ArrayList mProtections;

    ProtectionGroup(SystemBarStateMonitor arg2, List arg3) {
        super();
        this.mProtections = new ArrayList();
        this.mInsets = Insets.NONE;
        this.mInsetsIgnoringVisibility = Insets.NONE;
        this.addProtections(arg3, false);
        this.addProtections(arg3, true);
        arg2.addCallback(((Callback)this));
        this.mMonitor = arg2;
    }

    private void addProtections(List arg5, boolean arg6) {
        Object v3;
        Object v2;
        int v0 = arg5.size();
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 >= v0) {
                return;
            }

            v2 = arg5.get(v1);
            if(((Protection)v2).occupiesCorners() != arg6) {
            }
            else {
                v3 = ((Protection)v2).getController();
                if(v3 == null) {
                    ((Protection)v2).setController(this);
                    this.mProtections.add(v2);
                }
                else {
                    break;
                }
            }
        }

        throw new IllegalStateException(v2 + " (" + (v1 + 1) + "/" + v0 + ") is already controlled by " + v3 + " but is still added to " + this);
    }

    void dispose() {
        ArrayList v0;
        if(this.mDisposed) {
            return;
        }

        this.mDisposed = true;
        this.mMonitor.removeCallback(((Callback)this));
        int v1;
        for(v1 = this.mProtections.size() - 1; true; --v1) {
            v0 = this.mProtections;
            if(v1 < 0) {
                break;
            }

            v0.get(v1).setController(null);
        }

        v0.clear();
    }

    Protection getProtection(int arg1) {
        return this.mProtections.get(arg1);
    }

    public void onAnimationEnd() {
        int v0 = this.mAnimationCount;
        int v2 = v0 > 0 ? 1 : 0;
        --v0;
        this.mAnimationCount = v0;
        if(v2 != 0 && v0 == 0) {
            this.updateInsets();
        }
    }

    public void onAnimationProgress(int arg7, Insets arg8, RectF arg9) {
        Insets v0 = this.mInsetsIgnoringVisibility;
        int v1;
        for(v1 = this.mProtections.size() - 1; v1 >= 0; --v1) {
            Object v3 = this.mProtections.get(v1);
            int v4 = ((Protection)v3).getSide();
            if((v4 & arg7) == 0) {
            }
            else {
                ((Protection)v3).setSystemVisible(true);
                if(v4 == 1) {
                    if(v0.left > 0) {
                        ((Protection)v3).setSystemInsetAmount((((float)arg8.left)) / (((float)v0.left)));
                    }

                    ((Protection)v3).setSystemAlpha(arg9.left);
                }
                else if(v4 == 2) {
                    if(v0.top > 0) {
                        ((Protection)v3).setSystemInsetAmount((((float)arg8.top)) / (((float)v0.top)));
                    }

                    ((Protection)v3).setSystemAlpha(arg9.top);
                }
                else if(v4 == 4) {
                    if(v0.right > 0) {
                        ((Protection)v3).setSystemInsetAmount((((float)arg8.right)) / (((float)v0.right)));
                    }

                    ((Protection)v3).setSystemAlpha(arg9.right);
                }
                else if(v4 != 8) {
                }
                else {
                    if(v0.bottom > 0) {
                        ((Protection)v3).setSystemInsetAmount((((float)arg8.bottom)) / (((float)v0.bottom)));
                    }

                    ((Protection)v3).setSystemAlpha(arg9.bottom);
                }
            }
        }
    }

    public void onAnimationStart() {
        ++this.mAnimationCount;
    }

    public void onColorHintChanged(int arg3) {
        int v0;
        for(v0 = this.mProtections.size() - 1; v0 >= 0; --v0) {
            this.mProtections.get(v0).dispatchColorHint(arg3);
        }
    }

    public void onInsetsChanged(Insets arg1, Insets arg2) {
        this.mInsets = arg1;
        this.mInsetsIgnoringVisibility = arg2;
        this.updateInsets();
    }

    int size() {
        return this.mProtections.size();
    }

    private void updateInsets() {
        Insets v0 = Insets.NONE;
        int v1;
        for(v1 = this.mProtections.size() - 1; v1 >= 0; --v1) {
            v0 = Insets.max(v0, this.mProtections.get(v1).dispatchInsets(this.mInsets, this.mInsetsIgnoringVisibility, v0));
        }
    }
}


package androidx.compose.foundation.layout;

import android.os.Build$VERSION;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u0018\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001FH\u0016J\u001E\u0010!\u001A\u00020\u00152\u0006\u0010\"\u001A\u00020\u00152\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u001D0$H\u0016J\u0010\u0010%\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u0018\u0010&\u001A\u00020\u00152\u0006\u0010\'\u001A\u00020(2\u0006\u0010\"\u001A\u00020\u0015H\u0016J\b\u0010)\u001A\u00020\u001BH\u0016J\u0010\u0010*\u001A\u00020\u001B2\u0006\u0010\'\u001A\u00020(H\u0016J\u0010\u0010+\u001A\u00020\u001B2\u0006\u0010,\u001A\u00020(H\u0016R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2={"Landroidx/compose/foundation/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeInsets", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsetsHolder;)V", "getComposeInsets", "()Landroidx/compose/foundation/layout/WindowInsetsHolder;", "prepared", "", "getPrepared", "()Z", "setPrepared", "(Z)V", "runningAnimation", "getRunningAnimation", "setRunningAnimation", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "getSavedInsets", "()Landroidx/core/view/WindowInsetsCompat;", "setSavedInsets", "(Landroidx/core/view/WindowInsetsCompat;)V", "onPrepare", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onProgress", "insets", "runningAnimations", "", "onEnd", "onApplyWindowInsets", "view", "Landroid/view/View;", "run", "onViewAttachedToWindow", "onViewDetachedFromWindow", "v", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class InsetsListener extends Callback implements View$OnAttachStateChangeListener, OnApplyWindowInsetsListener, Runnable {
    private final WindowInsetsHolder composeInsets;
    private boolean prepared;
    private boolean runningAnimation;
    private WindowInsetsCompat savedInsets;

    public InsetsListener(WindowInsetsHolder arg2) {
        super(arg2.getConsumes() ^ 1);
        this.composeInsets = arg2;
    }

    public final WindowInsetsHolder getComposeInsets() {
        return this.composeInsets;
    }

    public final boolean getPrepared() {
        return this.prepared;
    }

    public final boolean getRunningAnimation() {
        return this.runningAnimation;
    }

    public final WindowInsetsCompat getSavedInsets() {
        return this.savedInsets;
    }

    public WindowInsetsCompat onApplyWindowInsets(View arg4, WindowInsetsCompat arg5) {
        this.savedInsets = arg5;
        this.composeInsets.updateImeAnimationTarget(arg5);
        if(this.prepared) {
            if(Build$VERSION.SDK_INT == 30) {
                arg4.post(this);
            }
        }
        else if(!this.runningAnimation) {
            this.composeInsets.updateImeAnimationSource(arg5);
            WindowInsetsHolder.update$default(this.composeInsets, arg5, 0, 2, null);
        }

        if(this.composeInsets.getConsumes()) {
            return WindowInsetsCompat.CONSUMED;
        }

        return arg5;
    }

    public void onEnd(WindowInsetsAnimationCompat arg7) {
        this.prepared = false;
        this.runningAnimation = false;
        WindowInsetsCompat v1 = this.savedInsets;
        Object v3 = null;
        if(Long.compare(arg7.getDurationMillis(), 0) > 0 && v1 != null) {
            this.composeInsets.updateImeAnimationSource(v1);
            this.composeInsets.updateImeAnimationTarget(v1);
            WindowInsetsHolder.update$default(this.composeInsets, v1, 0, 2, v3);
        }

        this.savedInsets = ((WindowInsetsCompat)v3);
        super.onEnd(arg7);
    }

    public void onPrepare(WindowInsetsAnimationCompat arg2) {
        this.prepared = true;
        this.runningAnimation = true;
        super.onPrepare(arg2);
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat arg4, List arg5) {
        WindowInsetsHolder.update$default(this.composeInsets, arg4, 0, 2, null);
        if(this.composeInsets.getConsumes()) {
            return WindowInsetsCompat.CONSUMED;
        }

        return arg4;
    }

    public BoundsCompat onStart(WindowInsetsAnimationCompat arg2, BoundsCompat arg3) {
        this.prepared = false;
        return super.onStart(arg2, arg3);
    }

    public void onViewAttachedToWindow(View arg1) {
        arg1.requestApplyInsets();
    }

    public void onViewDetachedFromWindow(View arg1) {
    }

    public void run() {
        if(this.prepared) {
            this.prepared = false;
            this.runningAnimation = false;
            WindowInsetsCompat v1 = this.savedInsets;
            if(v1 != null) {
                this.composeInsets.updateImeAnimationSource(v1);
                WindowInsetsHolder.update$default(this.composeInsets, v1, 0, 2, null);
                this.savedInsets = null;
            }
        }
    }

    public final void setPrepared(boolean arg1) {
        this.prepared = arg1;
    }

    public final void setRunningAnimation(boolean arg1) {
        this.runningAnimation = arg1;
    }

    public final void setSavedInsets(WindowInsetsCompat arg1) {
        this.savedInsets = arg1;
    }
}


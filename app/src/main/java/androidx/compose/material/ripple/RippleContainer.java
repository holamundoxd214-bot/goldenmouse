package androidx.compose.material.ripple;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.R$id;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0007H\u0014J\u0018\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u0007H\u0014J\b\u0010\u001A\u001A\u00020\u0010H\u0016J\n\u0010\u001B\u001A\u00020\n*\u00020\u001CJ\n\u0010\u001D\u001A\u00020\u0010*\u00020\u001CR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/compose/material/ripple/RippleContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "MaxRippleHosts", "", "rippleHosts", "", "Landroidx/compose/material/ripple/RippleHostView;", "unusedRippleHosts", "rippleHostMap", "Landroidx/compose/material/ripple/RippleHostMap;", "nextHostIndex", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "getRippleHostView", "Landroidx/compose/material/ripple/RippleHostKey;", "disposeRippleIfNeeded", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RippleContainer extends ViewGroup {
    public static final int $stable = 8;
    private final int MaxRippleHosts;
    private int nextHostIndex;
    private final RippleHostMap rippleHostMap;
    private final List rippleHosts;
    private final List unusedRippleHosts;

    static {
    }

    public RippleContainer(Context arg4) {
        super(arg4);
        this.MaxRippleHosts = 5;
        ArrayList v0 = new ArrayList();
        this.rippleHosts = ((List)v0);
        ArrayList v1 = new ArrayList();
        this.unusedRippleHosts = ((List)v1);
        this.rippleHostMap = new RippleHostMap();
        this.setClipChildren(false);
        RippleHostView v2 = new RippleHostView(arg4);
        this.addView(v2);
        ((List)v0).add(v2);
        ((List)v1).add(v2);
        this.nextHostIndex = 1;
        this.setTag(id.hide_in_inspector_tag, Boolean.valueOf(true));
    }

    public final void disposeRippleIfNeeded(RippleHostKey arg3) {
        arg3.onResetRippleHostView();
        RippleHostView v0 = this.rippleHostMap.get(arg3);
        if(v0 != null) {
            v0.disposeRipple();
            this.rippleHostMap.remove(arg3);
            this.unusedRippleHosts.add(v0);
        }
    }

    public final RippleHostView getRippleHostView(RippleHostKey arg4) {
        RippleHostView v0 = this.rippleHostMap.get(arg4);
        if(v0 != null) {
            return v0;
        }

        Object v0_1 = CollectionsKt.removeFirstOrNull(this.unusedRippleHosts);
        if(v0_1 == null) {
            if(this.nextHostIndex > CollectionsKt.getLastIndex(this.rippleHosts)) {
                v0 = new RippleHostView(this.getContext());
                this.addView(v0);
                this.rippleHosts.add(v0);
            }
            else {
                v0_1 = this.rippleHosts.get(this.nextHostIndex);
                RippleHostKey v1 = this.rippleHostMap.get(((RippleHostView)v0_1));
                if(v1 != null) {
                    v1.onResetRippleHostView();
                    this.rippleHostMap.remove(v1);
                    ((RippleHostView)v0_1).disposeRipple();
                }
            }

            int v1_1 = this.nextHostIndex;
            if(v1_1 < this.MaxRippleHosts - 1) {
                this.nextHostIndex = v1_1 + 1;
                goto label_38;
            }

            this.nextHostIndex = 0;
        }

    label_38:
        this.rippleHostMap.set(arg4, v0);
        return v0;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    protected void onMeasure(int arg1, int arg2) {
        this.setMeasuredDimension(0, 0);
    }

    public void requestLayout() {
    }
}


package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u000F\u001A\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0012H\u0007\u001A\n\u0010\u0013\u001A\u00020\u0010*\u00020\u0006\u001A\n\u0010\u0014\u001A\u00020\u0010*\u00020\u0015\u001A\u0014\u0010\u0016\u001A\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0012H\u0007\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001A\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\"\u0015\u0010\n\u001A\u00020\u0004*\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\n\u0010\u0007\"\u0018\u0010\u000B\u001A\u00020\f*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0017"}, d2={"IsPoolingContainerTag", "", "PoolingContainerListenerHolderTag", "value", "", "isPoolingContainer", "Landroid/view/View;", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "poolingContainerListenerHolder", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "addPoolingContainerListener", "", "listener", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "callPoolingContainerOnRelease", "callPoolingContainerOnReleaseForChildren", "Landroid/view/ViewGroup;", "removePoolingContainerListener", "customview-poolingcontainer_release"}, k=2, mv={1, 6, 0}, xi=0x30) public final class PoolingContainer {
    private static final int IsPoolingContainerTag;
    private static final int PoolingContainerListenerHolderTag;

    static {
        PoolingContainer.PoolingContainerListenerHolderTag = id.pooling_container_listener_holder_tag;
        PoolingContainer.IsPoolingContainerTag = id.is_pooling_container_tag;
    }

    public static final void addPoolingContainerListener(View arg1, PoolingContainerListener arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "listener");
        PoolingContainer.getPoolingContainerListenerHolder(arg1).addListener(arg2);
    }

    public static final void callPoolingContainerOnRelease(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Iterator v1 = ViewKt.getAllViews(arg1).iterator();
        while(v1.hasNext()) {
            PoolingContainer.getPoolingContainerListenerHolder(v1.next()).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Iterator v1 = ViewGroupKt.getChildren(arg1).iterator();
        while(v1.hasNext()) {
            PoolingContainer.getPoolingContainerListenerHolder(v1.next()).onRelease();
        }
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View arg2) {
        PoolingContainerListenerHolder v1_1;
        int v0 = PoolingContainer.PoolingContainerListenerHolderTag;
        Object v1 = arg2.getTag(v0);
        if(v1 == null) {
            v1_1 = new PoolingContainerListenerHolder();
            arg2.setTag(v0, v1_1);
        }

        return v1_1;
    }

    public static final boolean isPoolingContainer(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Object v1 = arg1.getTag(PoolingContainer.IsPoolingContainerTag);
        if((v1 instanceof Boolean)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((Boolean)v1).booleanValue();
        }

        return 0;
    }

    public static final boolean isWithinPoolingContainer(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Iterator v2 = ViewKt.getAncestors(arg2).iterator();
        do {
        label_4:
            if(!v2.hasNext()) {
                return 0;
            }

            Object v0 = v2.next();
            if(!(v0 instanceof View)) {
                goto label_4;
            }
        }
        while(!PoolingContainer.isPoolingContainer(((View)v0)));

        return 1;
    }

    public static final void removePoolingContainerListener(View arg1, PoolingContainerListener arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "listener");
        PoolingContainer.getPoolingContainerListenerHolder(arg1).removeListener(arg2);
    }

    public static final void setPoolingContainer(View arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setTag(PoolingContainer.IsPoolingContainerTag, Boolean.valueOf(arg2));
    }
}


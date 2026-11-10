package androidx.window.layout.adapter.extensions;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build$VERSION;
import androidx.window.core.Bounds;
import androidx.window.extensions.layout.SupportedWindowFeatures;
import androidx.window.layout.FoldingFeature$State;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature$Type;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.SupportedPosture;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculatorCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\nJ\u001D\u0010\u0004\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0000¢\u0006\u0002\b\nJ\u001D\u0010\u0004\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000FH\u0000¢\u0006\u0002\b\nJ\u001B\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\nJ\u0018\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0017H\u0002¨\u0006\u0018"}, d2={"Landroidx/window/layout/adapter/extensions/ExtensionsWindowLayoutInfoAdapter;", "", "<init>", "()V", "translate", "Landroidx/window/layout/FoldingFeature;", "windowMetrics", "Landroidx/window/layout/WindowMetrics;", "oemFeature", "Landroidx/window/extensions/layout/FoldingFeature;", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "context", "Landroid/content/Context;", "info", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "", "Landroidx/window/layout/SupportedPosture;", "features", "Landroidx/window/extensions/layout/SupportedWindowFeatures;", "validBounds", "", "bounds", "Landroidx/window/core/Bounds;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExtensionsWindowLayoutInfoAdapter {
    public static final ExtensionsWindowLayoutInfoAdapter INSTANCE;

    static {
        ExtensionsWindowLayoutInfoAdapter.INSTANCE = new ExtensionsWindowLayoutInfoAdapter();
    }

    private ExtensionsWindowLayoutInfoAdapter() {
        super();
    }

    public final WindowLayoutInfo translate$window_release(WindowMetrics arg3, androidx.window.extensions.layout.WindowLayoutInfo arg4) {
        Intrinsics.checkNotNullParameter(arg3, "windowMetrics");
        Intrinsics.checkNotNullParameter(arg4, "info");
        List v2 = arg4.getDisplayFeatures();
        Intrinsics.checkNotNullExpressionValue(v2, "getDisplayFeatures(...)");
        ArrayList v4 = new ArrayList();
        Iterator v2_1 = ((Iterable)v2).iterator();
        while(v2_1.hasNext()) {
            Object v0 = v2_1.next();
            FoldingFeature v0_1 = (v0 instanceof androidx.window.extensions.layout.FoldingFeature) ? ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(arg3, ((androidx.window.extensions.layout.FoldingFeature)v0)) : null;
            if(v0_1 == null) {
                continue;
            }

            ((Collection)v4).add(v0_1);
        }

        return new WindowLayoutInfo(((List)v4));
    }

    public final List translate$window_release(SupportedWindowFeatures arg2) {
        Intrinsics.checkNotNullParameter(arg2, "features");
        List v1 = arg2.getDisplayFoldFeatures();
        Intrinsics.checkNotNullExpressionValue(v1, "getDisplayFoldFeatures(...)");
        if(!(v1 instanceof Collection) || !v1.isEmpty()) {
            Iterator v1_1 = ((Iterable)v1).iterator();
            do {
                if(v1_1.hasNext()) {
                    if(!v1_1.next().hasProperties(new int[]{1})) {
                        continue;
                    }

                    break;
                }

                goto label_22;
            }
            while(true);

            return CollectionsKt.listOf(SupportedPosture.TABLETOP);
        }
        else {
        }

    label_22:
        return CollectionsKt.emptyList();
    }

    public final WindowLayoutInfo translate$window_release(Context arg4, androidx.window.extensions.layout.WindowLayoutInfo arg5) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        Intrinsics.checkNotNullParameter(arg5, "info");
        WindowMetricsCalculatorCompat v0 = new WindowMetricsCalculatorCompat(null, 1, null);
        if(Build$VERSION.SDK_INT >= 30) {
            return this.translate$window_release(v0.computeCurrentWindowMetrics(arg4), arg5);
        }

        if(Build$VERSION.SDK_INT >= 29 && ((arg4 instanceof Activity))) {
            return this.translate$window_release(v0.computeCurrentWindowMetrics(((Activity)arg4)), arg5);
        }

        throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
    }

    public final FoldingFeature translate$window_release(WindowMetrics arg7, androidx.window.extensions.layout.FoldingFeature arg8) {
        State v1_1;
        Type v0_1;
        Intrinsics.checkNotNullParameter(arg7, "windowMetrics");
        Intrinsics.checkNotNullParameter(arg8, "oemFeature");
        int v0 = arg8.getType();
        int v1 = 2;
        FoldingFeature v2 = null;
        if(v0 == 1) {
            v0_1 = Type.Companion.getFOLD();
        }
        else if(v0 != v1) {
            return v2;
        }
        else {
            v0_1 = Type.Companion.getHINGE();
        }

        int v4 = arg8.getState();
        if(v4 == 1) {
            v1_1 = State.FLAT;
        }
        else if(v4 != v1) {
            return v2;
        }
        else {
            v1_1 = State.HALF_OPENED;
        }

        Rect v4_1 = arg8.getBounds();
        String v5 = "getBounds(...)";
        Intrinsics.checkNotNullExpressionValue(v4_1, v5);
        if(this.validBounds(arg7, new Bounds(v4_1))) {
            Rect v8 = arg8.getBounds();
            Intrinsics.checkNotNullExpressionValue(v8, v5);
            return new HardwareFoldingFeature(new Bounds(v8), v0_1, v1_1);
        }

        return v2;
    }

    private final boolean validBounds(WindowMetrics arg3, Bounds arg4) {
        Rect v2 = arg3.getBounds();
        if(arg4.isZero()) {
            return 0;
        }

        if(arg4.getWidth() != v2.width() && arg4.getHeight() != v2.height()) {
            return 0;
        }

        if(arg4.getWidth() < v2.width() && arg4.getHeight() < v2.height()) {
            return 0;
        }

        if(arg4.getWidth() == v2.width() && arg4.getHeight() == v2.height()) {
            return 0;
        }

        return 1;
    }
}


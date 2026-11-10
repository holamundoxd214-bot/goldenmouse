package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2={"Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "", "parentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "parentConfiguration", "Landroid/content/res/Configuration;", "parentWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "overlayTag", "", "defaultOverlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "<init>", "(Landroidx/window/layout/WindowMetrics;Landroid/content/res/Configuration;Landroidx/window/layout/WindowLayoutInfo;Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "getParentWindowMetrics", "()Landroidx/window/layout/WindowMetrics;", "getParentConfiguration", "()Landroid/content/res/Configuration;", "getParentWindowLayoutInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "getOverlayTag", "()Ljava/lang/String;", "getDefaultOverlayAttributes", "()Landroidx/window/embedding/OverlayAttributes;", "toString", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OverlayAttributesCalculatorParams {
    private final OverlayAttributes defaultOverlayAttributes;
    private final String overlayTag;
    private final Configuration parentConfiguration;
    private final WindowLayoutInfo parentWindowLayoutInfo;
    private final WindowMetrics parentWindowMetrics;

    public OverlayAttributesCalculatorParams(WindowMetrics arg2, Configuration arg3, WindowLayoutInfo arg4, String arg5, OverlayAttributes arg6) {
        Intrinsics.checkNotNullParameter(arg2, "parentWindowMetrics");
        Intrinsics.checkNotNullParameter(arg3, "parentConfiguration");
        Intrinsics.checkNotNullParameter(arg4, "parentWindowLayoutInfo");
        Intrinsics.checkNotNullParameter(arg5, "overlayTag");
        Intrinsics.checkNotNullParameter(arg6, "defaultOverlayAttributes");
        super();
        this.parentWindowMetrics = arg2;
        this.parentConfiguration = arg3;
        this.parentWindowLayoutInfo = arg4;
        this.overlayTag = arg5;
        this.defaultOverlayAttributes = arg6;
    }

    public final OverlayAttributes getDefaultOverlayAttributes() {
        return this.defaultOverlayAttributes;
    }

    public final String getOverlayTag() {
        return this.overlayTag;
    }

    public final Configuration getParentConfiguration() {
        return this.parentConfiguration;
    }

    public final WindowLayoutInfo getParentWindowLayoutInfo() {
        return this.parentWindowLayoutInfo;
    }

    public final WindowMetrics getParentWindowMetrics() {
        return this.parentWindowMetrics;
    }

    public String toString() {
        return OverlayAttributesCalculatorParams.class + ":{parentWindowMetrics=" + this.parentWindowMetrics + "parentConfiguration=" + this.parentConfiguration + "parentWindowLayoutInfo=" + this.parentWindowLayoutInfo + "overlayTag=" + this.overlayTag + "defaultOverlayAttributes=" + this.defaultOverlayAttributes;
    }
}


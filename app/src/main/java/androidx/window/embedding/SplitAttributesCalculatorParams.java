package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u001B\u001A\u00020\rH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001A\u00020\u000B8G¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0018R\u0013\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2={"Landroidx/window/embedding/SplitAttributesCalculatorParams;", "", "parentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "parentConfiguration", "Landroid/content/res/Configuration;", "parentWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "areDefaultConstraintsSatisfied", "", "splitRuleTag", "", "<init>", "(Landroidx/window/layout/WindowMetrics;Landroid/content/res/Configuration;Landroidx/window/layout/WindowLayoutInfo;Landroidx/window/embedding/SplitAttributes;ZLjava/lang/String;)V", "getParentWindowMetrics", "()Landroidx/window/layout/WindowMetrics;", "getParentConfiguration", "()Landroid/content/res/Configuration;", "getParentWindowLayoutInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "getDefaultSplitAttributes", "()Landroidx/window/embedding/SplitAttributes;", "()Z", "getSplitRuleTag", "()Ljava/lang/String;", "toString", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitAttributesCalculatorParams {
    private final boolean areDefaultConstraintsSatisfied;
    private final SplitAttributes defaultSplitAttributes;
    private final Configuration parentConfiguration;
    private final WindowLayoutInfo parentWindowLayoutInfo;
    private final WindowMetrics parentWindowMetrics;
    private final String splitRuleTag;

    public SplitAttributesCalculatorParams(WindowMetrics arg2, Configuration arg3, WindowLayoutInfo arg4, SplitAttributes arg5, boolean arg6, String arg7) {
        Intrinsics.checkNotNullParameter(arg2, "parentWindowMetrics");
        Intrinsics.checkNotNullParameter(arg3, "parentConfiguration");
        Intrinsics.checkNotNullParameter(arg4, "parentWindowLayoutInfo");
        Intrinsics.checkNotNullParameter(arg5, "defaultSplitAttributes");
        super();
        this.parentWindowMetrics = arg2;
        this.parentConfiguration = arg3;
        this.parentWindowLayoutInfo = arg4;
        this.defaultSplitAttributes = arg5;
        this.areDefaultConstraintsSatisfied = arg6;
        this.splitRuleTag = arg7;
    }

    public final boolean areDefaultConstraintsSatisfied() {
        return this.areDefaultConstraintsSatisfied;
    }

    public final SplitAttributes getDefaultSplitAttributes() {
        return this.defaultSplitAttributes;
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

    public final String getSplitRuleTag() {
        return this.splitRuleTag;
    }

    public String toString() {
        return "SplitAttributesCalculatorParams:{windowMetrics=" + this.parentWindowMetrics + ", configuration=" + this.parentConfiguration + ", windowLayoutInfo=" + this.parentWindowLayoutInfo + ", defaultSplitAttributes=" + this.defaultSplitAttributes + ", areDefaultConstraintsSatisfied=" + this.areDefaultConstraintsSatisfied + ", tag=" + this.splitRuleTag + '}';
    }
}


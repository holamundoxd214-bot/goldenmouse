package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001A\u00020\tHÆ\u0003J1\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2={"Landroidx/window/embedding/ParentContainerInfo;", "", "windowBounds", "Landroidx/window/core/Bounds;", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "configuration", "Landroid/content/res/Configuration;", "density", "", "<init>", "(Landroidx/window/core/Bounds;Landroidx/window/layout/WindowLayoutInfo;Landroid/content/res/Configuration;F)V", "getWindowBounds", "()Landroidx/window/core/Bounds;", "getWindowLayoutInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "getConfiguration", "()Landroid/content/res/Configuration;", "getDensity", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParentContainerInfo {
    private final Configuration configuration;
    private final float density;
    private final Bounds windowBounds;
    private final WindowLayoutInfo windowLayoutInfo;

    public ParentContainerInfo(Bounds arg2, WindowLayoutInfo arg3, Configuration arg4, float arg5) {
        Intrinsics.checkNotNullParameter(arg2, "windowBounds");
        Intrinsics.checkNotNullParameter(arg3, "windowLayoutInfo");
        Intrinsics.checkNotNullParameter(arg4, "configuration");
        super();
        this.windowBounds = arg2;
        this.windowLayoutInfo = arg3;
        this.configuration = arg4;
        this.density = arg5;
    }

    public final Bounds component1() {
        return this.windowBounds;
    }

    public final WindowLayoutInfo component2() {
        return this.windowLayoutInfo;
    }

    public final Configuration component3() {
        return this.configuration;
    }

    public final float component4() {
        return this.density;
    }

    public final ParentContainerInfo copy(Bounds arg1, WindowLayoutInfo arg2, Configuration arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg1, "windowBounds");
        Intrinsics.checkNotNullParameter(arg2, "windowLayoutInfo");
        Intrinsics.checkNotNullParameter(arg3, "configuration");
        return new ParentContainerInfo(arg1, arg2, arg3, arg4);
    }

    public static ParentContainerInfo copy$default(ParentContainerInfo arg0, Bounds arg1, WindowLayoutInfo arg2, Configuration arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.windowBounds;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.windowLayoutInfo;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.configuration;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.density;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((ParentContainerInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ParentContainerInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.windowBounds, ((ParentContainerInfo)arg5).windowBounds)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.windowLayoutInfo, ((ParentContainerInfo)arg5).windowLayoutInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.configuration, ((ParentContainerInfo)arg5).configuration)) {
            return 0;
        }

        if(Float.compare(this.density, ((ParentContainerInfo)arg5).density) != 0) {
            return 0;
        }

        return 1;
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final float getDensity() {
        return this.density;
    }

    public final Bounds getWindowBounds() {
        return this.windowBounds;
    }

    public final WindowLayoutInfo getWindowLayoutInfo() {
        return this.windowLayoutInfo;
    }

    public int hashCode() {
        return ((this.windowBounds.hashCode() * 0x1F + this.windowLayoutInfo.hashCode()) * 0x1F + this.configuration.hashCode()) * 0x1F + Float.hashCode(this.density);
    }

    public String toString() {
        return "ParentContainerInfo(windowBounds=" + this.windowBounds + ", windowLayoutInfo=" + this.windowLayoutInfo + ", configuration=" + this.configuration + ", density=" + this.density + ')';
    }
}


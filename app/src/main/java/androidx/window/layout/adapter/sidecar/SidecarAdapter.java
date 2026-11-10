package androidx.window.layout.adapter.sidecar;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature$State;
import androidx.window.layout.HardwareFoldingFeature$Type;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\b\u0000\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000B\u001A\u00020\fJ\u0018\u0010\u0006\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\fJ\u001A\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\f2\b\u0010\u0014\u001A\u0004\u0018\u00010\fJ\u001A\u0010\u0015\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0014\u001A\u0004\u0018\u00010\u000FJ(\u0010\u0016\u001A\u00020\u00122\u000E\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u000E\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\u0002J\u001C\u0010\u0017\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\n2\b\u0010\u0014\u001A\u0004\u0018\u00010\nH\u0002J\u001F\u0010\u0006\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0000¢\u0006\u0002\b\u0019R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarAdapter;", "", "verificationMode", "Landroidx/window/core/VerificationMode;", "<init>", "(Landroidx/window/core/VerificationMode;)V", "translate", "", "Landroidx/window/layout/DisplayFeature;", "sidecarDisplayFeatures", "Landroidx/window/sidecar/SidecarDisplayFeature;", "deviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "Landroidx/window/layout/WindowLayoutInfo;", "extensionInfo", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "state", "isEqualSidecarDeviceState", "", "first", "second", "isEqualSidecarWindowLayoutInfo", "isEqualSidecarDisplayFeatures", "isEqualSidecarDisplayFeature", "feature", "translate$window_release", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SidecarAdapter {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001A\u00020\u000BH\u0007J \u0010\f\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u000B2\u000E\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007J\u0015\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0007J\u0018\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0010H\u0007R\u0016\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/window/layout/adapter/sidecar/SidecarAdapter$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getSidecarDisplayFeatures", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "info", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "setSidecarDisplayFeatures", "", "displayFeatures", "getSidecarDevicePosture", "", "sidecarDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "getSidecarDevicePosture$window_release", "getRawSidecarDevicePosture", "setSidecarDevicePosture", "posture", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getRawSidecarDevicePosture(SidecarDeviceState arg4) {
            int v3;
            Intrinsics.checkNotNullParameter(arg4, "sidecarDeviceState");
            try {
                return arg4.posture;
            }
            catch(NoSuchFieldError ) {
                try {
                    Object v4 = SidecarDeviceState.class.getMethod("getPosture").invoke(arg4);
                    Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.Int");
                    v3 = ((Integer)v4).intValue();
                    return v3;
                }
                catch(InvocationTargetException ) {
                    return v3;
                }
            }
        }

        public final int getSidecarDevicePosture$window_release(SidecarDeviceState arg2) {
            Intrinsics.checkNotNullParameter(arg2, "sidecarDeviceState");
            int v1 = this.getRawSidecarDevicePosture(arg2);
            if(v1 >= 0) {
                if(v1 > 4) {
                }
                else {
                    return v1;
                }
            }

            return 0;
        }

        public final List getSidecarDisplayFeatures(SidecarWindowLayoutInfo arg4) {
            List v3;
            Intrinsics.checkNotNullParameter(arg4, "info");
            try {
                v3 = arg4.displayFeatures;
                if(v3 == null) {
                    v3 = CollectionsKt.emptyList();
                }
            }
            catch(NoSuchFieldError ) {
                try {
                    Object v3_1 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures").invoke(arg4);
                    Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return ((List)v3_1);
                }
                catch(InvocationTargetException ) {
                    return CollectionsKt.emptyList();
                }
            }

            return v3;
        }

        public final void setSidecarDevicePosture(SidecarDeviceState arg5, int arg6) {
            Intrinsics.checkNotNullParameter(arg5, "sidecarDeviceState");
            try {
                arg5.posture = arg6;
                return;
            }
            catch(NoSuchFieldError ) {
                try {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(arg5, Integer.valueOf(arg6));
                }
                catch(InvocationTargetException ) {
                }
                catch(IllegalAccessException ) {
                }
                catch(NoSuchMethodException ) {
                }

                return;
            }
        }

        public final void setSidecarDisplayFeatures(SidecarWindowLayoutInfo arg5, List arg6) {
            Intrinsics.checkNotNullParameter(arg5, "info");
            Intrinsics.checkNotNullParameter(arg6, "displayFeatures");
            try {
                arg5.displayFeatures = arg6;
                return;
            }
            catch(NoSuchFieldError ) {
                try {
                    SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(arg5, arg6);
                }
                catch(InvocationTargetException ) {
                }
                catch(IllegalAccessException ) {
                }
                catch(NoSuchMethodException ) {
                }

                return;
            }
        }
    }

    public static final Companion Companion;
    private static final String TAG;
    private final VerificationMode verificationMode;

    static {
        SidecarAdapter.Companion = new Companion(null);
        SidecarAdapter.TAG = "SidecarAdapter";
    }

    public SidecarAdapter() {
        this(null, 1, null);
    }

    public SidecarAdapter(VerificationMode arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = VerificationMode.QUIET;
        }

        this(arg1);
    }

    public SidecarAdapter(VerificationMode arg2) {
        Intrinsics.checkNotNullParameter(arg2, "verificationMode");
        super();
        this.verificationMode = arg2;
    }

    public final boolean isEqualSidecarDeviceState(SidecarDeviceState arg3, SidecarDeviceState arg4) {
        if(Intrinsics.areEqual(arg3, arg4)) {
            return 1;
        }

        if(arg3 == null) {
            return 0;
        }

        if(arg4 == null) {
            return 0;
        }

        if(SidecarAdapter.Companion.getSidecarDevicePosture$window_release(arg3) == SidecarAdapter.Companion.getSidecarDevicePosture$window_release(arg4)) {
            return 1;
        }

        return 0;
    }

    private final boolean isEqualSidecarDisplayFeature(SidecarDisplayFeature arg3, SidecarDisplayFeature arg4) {
        if(Intrinsics.areEqual(arg3, arg4)) {
            return 1;
        }

        if(arg3 == null) {
            return 0;
        }

        if(arg4 == null) {
            return 0;
        }

        if(arg3.getType() != arg4.getType()) {
            return 0;
        }

        return Intrinsics.areEqual(arg3.getRect(), arg4.getRect());
    }

    private final boolean isEqualSidecarDisplayFeatures(List arg7, List arg8) {
        if(arg7 == arg8) {
            return 1;
        }

        if(arg7 == null) {
            return 0;
        }

        if(arg8 == null) {
            return 0;
        }

        if(arg7.size() != arg8.size()) {
            return 0;
        }

        int v2 = arg7.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            if(!this.isEqualSidecarDisplayFeature(arg7.get(v3), arg8.get(v3))) {
                return 0;
            }
        }

        return 1;
    }

    public final boolean isEqualSidecarWindowLayoutInfo(SidecarWindowLayoutInfo arg2, SidecarWindowLayoutInfo arg3) {
        if(Intrinsics.areEqual(arg2, arg3)) {
            return 1;
        }

        if(arg2 == null) {
            return 0;
        }

        if(arg3 == null) {
            return 0;
        }

        return this.isEqualSidecarDisplayFeatures(SidecarAdapter.Companion.getSidecarDisplayFeatures(arg2), SidecarAdapter.Companion.getSidecarDisplayFeatures(arg3));
    }

    public final WindowLayoutInfo translate(SidecarWindowLayoutInfo arg3, SidecarDeviceState arg4) {
        Intrinsics.checkNotNullParameter(arg4, "state");
        if(arg3 == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }

        SidecarDeviceState v0 = new SidecarDeviceState();
        Companion v1 = SidecarAdapter.Companion;
        v1.setSidecarDevicePosture(v0, v1.getSidecarDevicePosture$window_release(arg4));
        return new WindowLayoutInfo(this.translate(v1.getSidecarDisplayFeatures(arg3), v0));
    }

    public final List translate(List arg3, SidecarDeviceState arg4) {
        Intrinsics.checkNotNullParameter(arg3, "sidecarDisplayFeatures");
        Intrinsics.checkNotNullParameter(arg4, "deviceState");
        ArrayList v0 = new ArrayList();
        Iterator v3 = ((Iterable)arg3).iterator();
        while(v3.hasNext()) {
            DisplayFeature v1 = this.translate$window_release(v3.next(), arg4);
            if(v1 == null) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        return ((List)v0);
    }

    static final boolean translate$lambda$1(SidecarDisplayFeature arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$require");
        if(arg2.getType() != 1) {
            if(arg2.getType() == 2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final boolean translate$lambda$2(SidecarDisplayFeature arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$require");
        if(arg1.getRect().width() == 0) {
            if(arg1.getRect().height() != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final boolean translate$lambda$3(SidecarDisplayFeature arg2) {
        Intrinsics.checkNotNullParameter(arg2, "$this$require");
        if(arg2.getType() == 1 && arg2.getRect().width() != 0) {
            if(arg2.getRect().height() == 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final boolean translate$lambda$4(SidecarDisplayFeature arg1) {
        Intrinsics.checkNotNullParameter(arg1, "$this$require");
        if(arg1.getRect().left != 0) {
            if(arg1.getRect().top == 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final DisplayFeature translate$window_release(SidecarDisplayFeature arg9, SidecarDeviceState arg10) {
        State v9_1;
        Type v8_2;
        Intrinsics.checkNotNullParameter(arg9, "feature");
        Intrinsics.checkNotNullParameter(arg10, "deviceState");
        androidx.window.core.SpecificationComputer$Companion v1 = SpecificationComputer.Companion;
        String v3 = SidecarAdapter.TAG;
        Intrinsics.checkNotNullExpressionValue(v3, "TAG");
        SidecarDisplayFeature v2 = arg9;
        Object v8 = androidx.window.core.SpecificationComputer$Companion.startSpecification$default(v1, v2, v3, this.verificationMode, null, 4, null).require("Type must be either TYPE_FOLD or TYPE_HINGE", new SidecarAdapter$$ExternalSyntheticLambda0()).require("Feature bounds must not be 0", new SidecarAdapter$$ExternalSyntheticLambda1()).require("TYPE_FOLD must have 0 area", new SidecarAdapter$$ExternalSyntheticLambda2()).require("Feature be pinned to either left or top", new SidecarAdapter$$ExternalSyntheticLambda3()).compute();
        DisplayFeature v9 = null;
        if(v8 == null) {
            return v9;
        }

        int v8_1 = ((SidecarDisplayFeature)v8).getType();
        int v0 = 2;
        if(v8_1 == 1) {
            v8_2 = Type.Companion.getFOLD();
        }
        else if(v8_1 != v0) {
            return v9;
        }
        else {
            v8_2 = Type.Companion.getHINGE();
        }

        int v10 = SidecarAdapter.Companion.getSidecarDevicePosture$window_release(arg10);
        if(v10 != 0 && v10 != 1) {
            if(v10 == v0) {
                v9_1 = State.HALF_OPENED;
            }
            else if(v10 == 3) {
                v9_1 = State.FLAT;
            }
            else if(v10 != 4) {
                v9_1 = State.FLAT;
            }
            else {
                return v9;
            }

            Rect v1_1 = v2.getRect();
            Intrinsics.checkNotNullExpressionValue(v1_1, "getRect(...)");
            return new HardwareFoldingFeature(new Bounds(v1_1), v8_2, v9_1);
        }

        return v9;
    }
}


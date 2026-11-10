package androidx.window.area;

import android.os.Binder;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.layout.WindowMetrics;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\'B)\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u0016J\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u001C\u001A\u00020\u0016J\u0010\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001C\u001A\u00020\u0016H\u0002J\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001A\u00020$H\u0016J\b\u0010%\u001A\u00020&H\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0014\u001A\u001E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001A¨\u0006("}, d2={"Landroidx/window/area/WindowAreaInfo;", "", "metrics", "Landroidx/window/layout/WindowMetrics;", "type", "Landroidx/window/area/WindowAreaInfo$Type;", "token", "Landroid/os/Binder;", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "<init>", "(Landroidx/window/layout/WindowMetrics;Landroidx/window/area/WindowAreaInfo$Type;Landroid/os/Binder;Landroidx/window/extensions/area/WindowAreaComponent;)V", "getMetrics", "()Landroidx/window/layout/WindowMetrics;", "setMetrics", "(Landroidx/window/layout/WindowMetrics;)V", "getType", "()Landroidx/window/area/WindowAreaInfo$Type;", "getToken", "()Landroid/os/Binder;", "capabilityMap", "Ljava/util/HashMap;", "Landroidx/window/area/WindowAreaCapability$Operation;", "Landroidx/window/area/WindowAreaCapability;", "Lkotlin/collections/HashMap;", "getCapabilityMap$window_release", "()Ljava/util/HashMap;", "getCapability", "operation", "getActiveSession", "Landroidx/window/area/WindowAreaSession;", "createRearFacingSession", "equals", "", "other", "hashCode", "", "toString", "", "Type", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowAreaInfo {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/area/WindowAreaInfo$Type;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Type {
        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/window/area/WindowAreaInfo$Type$Companion;", "", "<init>", "()V", "TYPE_REAR_FACING", "Landroidx/window/area/WindowAreaInfo$Type;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }
        }

        public static final Companion Companion;
        public static final Type TYPE_REAR_FACING;
        private final String description;

        static {
            Type.Companion = new Companion(null);
            Type.TYPE_REAR_FACING = new Type("REAR FACING");
        }

        private Type(String arg1) {
            super();
            this.description = arg1;
        }

        public String toString() {
            return this.description;
        }
    }

    private final HashMap capabilityMap;
    private WindowMetrics metrics;
    private final Binder token;
    private final Type type;
    private final WindowAreaComponent windowAreaComponent;

    public WindowAreaInfo(WindowMetrics arg2, Type arg3, Binder arg4, WindowAreaComponent arg5) {
        Intrinsics.checkNotNullParameter(arg2, "metrics");
        Intrinsics.checkNotNullParameter(arg3, "type");
        Intrinsics.checkNotNullParameter(arg4, "token");
        Intrinsics.checkNotNullParameter(arg5, "windowAreaComponent");
        super();
        this.metrics = arg2;
        this.type = arg3;
        this.token = arg4;
        this.windowAreaComponent = arg5;
        this.capabilityMap = new HashMap();
    }

    private final WindowAreaSession createRearFacingSession(Operation arg3) {
        if(Intrinsics.areEqual(arg3, Operation.OPERATION_TRANSFER_ACTIVITY_TO_AREA)) {
            return new RearDisplaySessionImpl(this.windowAreaComponent);
        }

        if(Intrinsics.areEqual(arg3, Operation.OPERATION_PRESENT_ON_AREA)) {
            WindowAreaComponent v2 = this.windowAreaComponent;
            ExtensionWindowAreaPresentation v0 = v2.getRearDisplayPresentation();
            Intrinsics.checkNotNull(v0);
            return new RearDisplayPresentationSessionPresenterImpl(v2, v0, ExtensionsUtil.INSTANCE.getSafeVendorApiLevel());
        }

        throw new IllegalArgumentException("Invalid operation provided");
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof WindowAreaInfo)) && (Intrinsics.areEqual(this.metrics, ((WindowAreaInfo)arg3).metrics)) && (Intrinsics.areEqual(this.type, ((WindowAreaInfo)arg3).type)) && (Intrinsics.areEqual(this.capabilityMap.entrySet(), ((WindowAreaInfo)arg3).capabilityMap.entrySet()))) {
            return 1;
        }

        return 0;
    }

    public final WindowAreaSession getActiveSession(Operation arg3) {
        Intrinsics.checkNotNullParameter(arg3, "operation");
        if(Intrinsics.areEqual(this.getCapability(arg3).getStatus(), Status.WINDOW_AREA_STATUS_ACTIVE)) {
            if(Intrinsics.areEqual(this.type, Type.TYPE_REAR_FACING)) {
                return this.createRearFacingSession(arg3);
            }

            return null;
        }

        throw new IllegalStateException("No session is currently active");
    }

    public final WindowAreaCapability getCapability(Operation arg2) {
        Intrinsics.checkNotNullParameter(arg2, "operation");
        Object v1 = this.capabilityMap.get(arg2);
        if(v1 == null) {
            WindowAreaCapability v1_1 = new WindowAreaCapability(arg2, Status.WINDOW_AREA_STATUS_UNSUPPORTED);
        }

        return ((WindowAreaCapability)v1);
    }

    public final HashMap getCapabilityMap$window_release() {
        return this.capabilityMap;
    }

    public final WindowMetrics getMetrics() {
        return this.metrics;
    }

    public final Binder getToken() {
        return this.token;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.metrics.hashCode() * 0x1F + this.type.hashCode()) * 0x1F + this.capabilityMap.entrySet().hashCode();
    }

    public final void setMetrics(WindowMetrics arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.metrics = arg2;
    }

    public String toString() {
        return "WindowAreaInfo{ Metrics: " + this.metrics + ", type: " + this.type + ", Capabilities: " + this.capabilityMap.entrySet() + " }";
    }
}


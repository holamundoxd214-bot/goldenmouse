package com.TryJeanPc.goldenmouse.profile;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000BJ\u0006\u0010\u0012\u001A\u00020\u0013J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000F\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J=\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "", "targetPackage", "", "name", "controls", "", "Lcom/TryJeanPc/goldenmouse/profile/ProfileControl;", "visualControls", "Lcom/TryJeanPc/goldenmouse/profile/VistaLibreMarker;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getTargetPackage", "()Ljava/lang/String;", "getName", "getControls", "()Ljava/util/List;", "getVisualControls", "cameraSettings", "Lcom/TryJeanPc/goldenmouse/profile/FpsCameraSettings;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameProfile {
    public static final int $stable = 8;
    private final List controls;
    private final String name;
    private final String targetPackage;
    private final List visualControls;

    static {
    }

    public GameProfile(String arg2, String arg3, List arg4, List arg5) {
        Intrinsics.checkNotNullParameter(arg2, "targetPackage");
        Intrinsics.checkNotNullParameter(arg3, "name");
        Intrinsics.checkNotNullParameter(arg4, "controls");
        Intrinsics.checkNotNullParameter(arg5, "visualControls");
        super();
        this.targetPackage = arg2;
        this.name = arg3;
        this.controls = arg4;
        this.visualControls = arg5;
    }

    public GameProfile(String arg1, String arg2, List arg3, List arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 2) != 0) {
            arg2 = arg1;
        }

        if((arg5 & 4) != 0) {
            arg3 = CollectionsKt.emptyList();
        }

        if((arg5 & 8) != 0) {
            arg4 = CollectionsKt.emptyList();
        }

        this(arg1, arg2, arg3, arg4);
    }

    public final FpsCameraSettings cameraSettings() {
        ControlComponent v1;
        Iterator v12 = this.controls.iterator();
        do {
            v1 = null;
            if(!v12.hasNext()) {
                break;
            }

            ControlComponent v0 = v12.next().getComponent();
            if((v0 instanceof ViewComponent)) {
                v1 = v0;
            }
        }
        while(v1 == null);

        if(v1 != null) {
            FpsCameraSettings v12_1 = ((ViewComponent)v1).toCameraSettings();
            if(v12_1 == null) {
            }
            else {
                return v12_1;
            }
        }

        return new FpsCameraSettings(true, 0f, 0f, 0f, 0f, 0f, false, 0f, false, 510, null);
    }

    public final String component1() {
        return this.targetPackage;
    }

    public final String component2() {
        return this.name;
    }

    public final List component3() {
        return this.controls;
    }

    public final List component4() {
        return this.visualControls;
    }

    public final GameProfile copy(String arg1, String arg2, List arg3, List arg4) {
        Intrinsics.checkNotNullParameter(arg1, "targetPackage");
        Intrinsics.checkNotNullParameter(arg2, "name");
        Intrinsics.checkNotNullParameter(arg3, "controls");
        Intrinsics.checkNotNullParameter(arg4, "visualControls");
        return new GameProfile(arg1, arg2, arg3, arg4);
    }

    public static GameProfile copy$default(GameProfile arg0, String arg1, String arg2, List arg3, List arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.targetPackage;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.name;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.controls;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.visualControls;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((GameProfile)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GameProfile)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.targetPackage, ((GameProfile)arg5).targetPackage)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((GameProfile)arg5).name)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.controls, ((GameProfile)arg5).controls)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.visualControls, ((GameProfile)arg5).visualControls)) {
            return 0;
        }

        return 1;
    }

    public final List getControls() {
        return this.controls;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTargetPackage() {
        return this.targetPackage;
    }

    public final List getVisualControls() {
        return this.visualControls;
    }

    public int hashCode() {
        return ((this.targetPackage.hashCode() * 0x1F + this.name.hashCode()) * 0x1F + this.controls.hashCode()) * 0x1F + this.visualControls.hashCode();
    }

    public String toString() {
        return "GameProfile(targetPackage=" + this.targetPackage + ", name=" + this.name + ", controls=" + this.controls + ", visualControls=" + this.visualControls + ")";
    }
}


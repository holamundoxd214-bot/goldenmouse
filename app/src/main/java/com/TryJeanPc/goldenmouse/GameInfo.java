package com.TryJeanPc.goldenmouse;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/GameInfo;", "", "name", "", "packageName", "icon", "Landroid/graphics/drawable/Drawable;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "getName", "()Ljava/lang/String;", "getPackageName", "getIcon", "()Landroid/graphics/drawable/Drawable;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameInfo {
    public static final int $stable = 8;
    private final Drawable icon;
    private final String name;
    private final String packageName;

    static {
    }

    public GameInfo(String arg2, String arg3, Drawable arg4) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Intrinsics.checkNotNullParameter(arg3, "packageName");
        Intrinsics.checkNotNullParameter(arg4, "icon");
        super();
        this.name = arg2;
        this.packageName = arg3;
        this.icon = arg4;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.packageName;
    }

    public final Drawable component3() {
        return this.icon;
    }

    public final GameInfo copy(String arg1, String arg2, Drawable arg3) {
        Intrinsics.checkNotNullParameter(arg1, "name");
        Intrinsics.checkNotNullParameter(arg2, "packageName");
        Intrinsics.checkNotNullParameter(arg3, "icon");
        return new GameInfo(arg1, arg2, arg3);
    }

    public static GameInfo copy$default(GameInfo arg0, String arg1, String arg2, Drawable arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.name;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.packageName;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.icon;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((GameInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GameInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((GameInfo)arg5).name)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.packageName, ((GameInfo)arg5).packageName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.icon, ((GameInfo)arg5).icon)) {
            return 0;
        }

        return 1;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (this.name.hashCode() * 0x1F + this.packageName.hashCode()) * 0x1F + this.icon.hashCode();
    }

    public String toString() {
        return "GameInfo(name=" + this.name + ", packageName=" + this.packageName + ", icon=" + this.icon + ")";
    }
}


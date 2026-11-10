package com.TryJeanPc.goldenmouse.graphicsui;

import com.TryJeanPc.goldenmouse.graphics.GraphicsProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsInspectionKey;", "", "pkg", "", "profile", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "revision", "", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;J)V", "getPkg", "()Ljava/lang/String;", "getProfile", "()Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "getRevision", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsInspectionKey {
    public static final int $stable;
    private final String pkg;
    private final GraphicsProfile profile;
    private final long revision;

    static {
    }

    public GraphicsInspectionKey(String arg2, GraphicsProfile arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "pkg");
        Intrinsics.checkNotNullParameter(arg3, "profile");
        super();
        this.pkg = arg2;
        this.profile = arg3;
        this.revision = arg4;
    }

    public final String component1() {
        return this.pkg;
    }

    public final GraphicsProfile component2() {
        return this.profile;
    }

    public final long component3() {
        return this.revision;
    }

    public final GraphicsInspectionKey copy(String arg1, GraphicsProfile arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg1, "pkg");
        Intrinsics.checkNotNullParameter(arg2, "profile");
        return new GraphicsInspectionKey(arg1, arg2, arg3);
    }

    public static GraphicsInspectionKey copy$default(GraphicsInspectionKey arg0, String arg1, GraphicsProfile arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.pkg;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.profile;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.revision;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg6) {
        if(this == (((GraphicsInspectionKey)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof GraphicsInspectionKey)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.pkg, ((GraphicsInspectionKey)arg6).pkg)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.profile, ((GraphicsInspectionKey)arg6).profile)) {
            return 0;
        }

        if(this.revision != ((GraphicsInspectionKey)arg6).revision) {
            return 0;
        }

        return 1;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final GraphicsProfile getProfile() {
        return this.profile;
    }

    public final long getRevision() {
        return this.revision;
    }

    public int hashCode() {
        return (this.pkg.hashCode() * 0x1F + this.profile.hashCode()) * 0x1F + Long.hashCode(this.revision);
    }

    public String toString() {
        return "GraphicsInspectionKey(pkg=" + this.pkg + ", profile=" + this.profile + ", revision=" + this.revision + ")";
    }
}


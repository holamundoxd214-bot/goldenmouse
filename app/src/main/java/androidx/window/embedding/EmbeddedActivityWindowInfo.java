package androidx.window.embedding;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001A\u00020\u00032\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "", "isEmbedded", "", "parentHostBounds", "Landroid/graphics/Rect;", "boundsInParentHost", "<init>", "(ZLandroid/graphics/Rect;Landroid/graphics/Rect;)V", "()Z", "getParentHostBounds", "()Landroid/graphics/Rect;", "getBoundsInParentHost", "equals", "other", "hashCode", "", "toString", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddedActivityWindowInfo {
    private final Rect boundsInParentHost;
    private final boolean isEmbedded;
    private final Rect parentHostBounds;

    public EmbeddedActivityWindowInfo(boolean arg2, Rect arg3, Rect arg4) {
        Intrinsics.checkNotNullParameter(arg3, "parentHostBounds");
        Intrinsics.checkNotNullParameter(arg4, "boundsInParentHost");
        super();
        this.isEmbedded = arg2;
        this.parentHostBounds = arg3;
        this.boundsInParentHost = arg4;
    }

    public boolean equals(Object arg5) {
        if(this == (((EmbeddedActivityWindowInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof EmbeddedActivityWindowInfo)) {
            return 0;
        }

        if(this.isEmbedded != ((EmbeddedActivityWindowInfo)arg5).isEmbedded) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.parentHostBounds, ((EmbeddedActivityWindowInfo)arg5).parentHostBounds)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.boundsInParentHost, ((EmbeddedActivityWindowInfo)arg5).boundsInParentHost)) {
            return 0;
        }

        return 1;
    }

    public final Rect getBoundsInParentHost() {
        return this.boundsInParentHost;
    }

    public final Rect getParentHostBounds() {
        return this.parentHostBounds;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isEmbedded) * 0x1F + this.parentHostBounds.hashCode()) * 0x1F + this.boundsInParentHost.hashCode();
    }

    public final boolean isEmbedded() {
        return this.isEmbedded;
    }

    public String toString() {
        return "EmbeddedActivityWindowInfo{isEmbedded=" + this.isEmbedded + ", parentHostBounds=" + this.parentHostBounds + ", boundsInParentHost=" + this.boundsInParentHost + '}';
    }
}


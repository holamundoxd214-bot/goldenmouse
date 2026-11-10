package androidx.compose.foundation.content;

import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001B\b\u0000\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/content/PlatformTransferableContent;", "", "linkUri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "<init>", "(Landroid/net/Uri;Landroid/os/Bundle;)V", "getLinkUri", "()Landroid/net/Uri;", "getExtras", "()Landroid/os/Bundle;", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformTransferableContent {
    public static final int $stable = 8;
    private final Bundle extras;
    private final Uri linkUri;

    static {
    }

    public PlatformTransferableContent(Uri arg1, Bundle arg2) {
        super();
        this.linkUri = arg1;
        this.extras = arg2;
    }

    public boolean equals(Object arg5) {
        if(this == (((PlatformTransferableContent)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PlatformTransferableContent)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.linkUri, ((PlatformTransferableContent)arg5).linkUri)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.extras, ((PlatformTransferableContent)arg5).extras)) {
            return 0;
        }

        return 1;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public int hashCode() {
        Uri v0 = this.linkUri;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        return v0_1 * 0x1F + this.extras.hashCode();
    }

    public String toString() {
        return "PlatformTransferableContent(linkUri=" + this.linkUri + ", extras=" + this.extras + ')';
    }
}


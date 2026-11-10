package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0080\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"findOwner", "T", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "activity-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ActivityComposeUtilsKt {
    public static final Object findOwner(Context arg2) {
        while((arg2 instanceof ContextWrapper)) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if((arg2 instanceof Object)) {
                return arg2;
            }

            arg2 = ((ContextWrapper)arg2).getBaseContext();
        }

        return null;
    }
}


package androidx.lifecycle;

import android.view.View;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¨\u0006\u0004"}, d2={"findViewTreeLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "lifecycle-runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced by View.findViewTreeLifecycleOwner() from lifecycle module", replaceWith="<_subannotation>") public static final LifecycleOwner findViewTreeLifecycleOwner(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "view");
        return ViewTreeLifecycleOwner.get(arg1);
    }
}


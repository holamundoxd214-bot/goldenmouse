package androidx.savedstate;

import android.view.View;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¨\u0006\u0004"}, d2={"findViewTreeSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "view", "Landroid/view/View;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ViewKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced by View.findViewTreeSavedStateRegistryOwner() from savedstate module", replaceWith="<_subannotation>") public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View arg1) {
        Intrinsics.checkNotNullParameter(arg1, "view");
        return ViewTreeSavedStateRegistryOwner.get(arg1);
    }
}


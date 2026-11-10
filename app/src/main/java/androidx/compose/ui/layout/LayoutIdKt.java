package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u0002H\u0007\"\u0017\u0010\u0000\u001A\u0004\u0018\u00010\u0002*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"layoutId", "Landroidx/compose/ui/Modifier;", "", "Landroidx/compose/ui/layout/Measurable;", "getLayoutId", "(Landroidx/compose/ui/layout/Measurable;)Ljava/lang/Object;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutIdKt {
    public static final Object getLayoutId(Measurable arg2) {
        Object v2 = arg2.getParentData();
        Object v1 = null;
        if((v2 instanceof LayoutIdParentData)) {
        }
        else {
            v2 = v1;
        }

        if(v2 != null) {
            return ((LayoutIdParentData)v2).getLayoutId();
        }

        return v1;
    }

    public static final Modifier layoutId(Modifier arg1, Object arg2) {
        return arg1.then(new LayoutIdElement(arg2));
    }
}


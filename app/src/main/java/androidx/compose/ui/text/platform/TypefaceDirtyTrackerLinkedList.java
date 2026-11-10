package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;", "", "resolveResult", "Landroidx/compose/runtime/State;", "next", "<init>", "(Landroidx/compose/runtime/State;Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;)V", "initial", "getInitial", "()Ljava/lang/Object;", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "isStaleResolvedFont", "", "()Z", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class TypefaceDirtyTrackerLinkedList {
    private final Object initial;
    private final TypefaceDirtyTrackerLinkedList next;
    private final State resolveResult;

    public TypefaceDirtyTrackerLinkedList(State arg1, TypefaceDirtyTrackerLinkedList arg2) {
        super();
        this.resolveResult = arg1;
        this.next = arg2;
        this.initial = arg1.getValue();
    }

    public TypefaceDirtyTrackerLinkedList(State arg1, TypefaceDirtyTrackerLinkedList arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public final Object getInitial() {
        return this.initial;
    }

    public final Typeface getTypeface() {
        Object v1 = this.initial;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type android.graphics.Typeface");
        return ((Typeface)v1);
    }

    public final boolean isStaleResolvedFont() {
        if(this.resolveResult.getValue() == this.initial) {
            this = this.next;
            if(this != null && (this.isStaleResolvedFont())) {
                return 1;
            }

            return 0;
        }

        return 1;
    }
}


package androidx.window.layout;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\nH\u0016J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2={"Landroidx/window/layout/WindowLayoutInfo;", "", "displayFeatures", "", "Landroidx/window/layout/DisplayFeature;", "<init>", "(Ljava/util/List;)V", "getDisplayFeatures", "()Ljava/util/List;", "toString", "", "equals", "", "other", "hashCode", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowLayoutInfo {
    private final List displayFeatures;

    public WindowLayoutInfo(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "displayFeatures");
        super();
        this.displayFeatures = arg2;
    }

    public boolean equals(Object arg3) {
        if(this == (((WindowLayoutInfo)arg3))) {
            return 1;
        }

        if(arg3 != null) {
            if(!Intrinsics.areEqual(this.getClass(), arg3.getClass())) {
            }
            else {
                return Intrinsics.areEqual(this.displayFeatures, ((WindowLayoutInfo)arg3).displayFeatures);
            }
        }

        return 0;
    }

    public final List getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}


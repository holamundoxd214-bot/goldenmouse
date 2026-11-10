package androidx.window.core.layout;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004\u001A \u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0006\u001A \u0010\u0007\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\b"}, d2={"computeWindowSizeClass", "Landroidx/window/core/layout/WindowSizeClass;", "", "widthDp", "", "heightDp", "", "computeWindowSizeClassPreferHeight", "window-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowSizeClassSelectors {
    public static final WindowSizeClass computeWindowSizeClass(Set arg1, float arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return WindowSizeClassSelectors.computeWindowSizeClass(arg1, ((int)arg2), ((int)arg3));
    }

    public static final WindowSizeClass computeWindowSizeClass(Set arg5, int arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Iterator v0 = ((Iterable)arg5).iterator();
        int v2;
        for(v2 = 0; v0.hasNext(); v2 = ((WindowSizeClass)v3).getMinWidthDp()) {
            Object v3 = v0.next();
            if(((WindowSizeClass)v3).getMinWidthDp() > arg6) {
                continue;
            }

            if(((WindowSizeClass)v3).getMinWidthDp() <= v2) {
                continue;
            }
        }

        WindowSizeClass v6 = new WindowSizeClass(0, 0);
        Iterator v5 = ((Iterable)arg5).iterator();
        while(v5.hasNext()) {
            Object v0_1 = v5.next();
            if(((WindowSizeClass)v0_1).getMinWidthDp() != v2) {
                continue;
            }

            if(((WindowSizeClass)v0_1).getMinHeightDp() > arg7) {
                continue;
            }

            if(v6.getMinHeightDp() > ((WindowSizeClass)v0_1).getMinHeightDp()) {
                continue;
            }

            Object v6_1 = v0_1;
        }

        return v6;
    }

    public static final WindowSizeClass computeWindowSizeClassPreferHeight(Set arg5, int arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Iterator v0 = ((Iterable)arg5).iterator();
        int v2;
        for(v2 = 0; v0.hasNext(); v2 = ((WindowSizeClass)v3).getMinHeightDp()) {
            Object v3 = v0.next();
            if(((WindowSizeClass)v3).getMinHeightDp() > arg7) {
                continue;
            }

            if(((WindowSizeClass)v3).getMinHeightDp() <= v2) {
                continue;
            }
        }

        WindowSizeClass v7 = new WindowSizeClass(0, 0);
        Iterator v5 = ((Iterable)arg5).iterator();
        while(v5.hasNext()) {
            Object v0_1 = v5.next();
            if(((WindowSizeClass)v0_1).getMinHeightDp() != v2) {
                continue;
            }

            if(((WindowSizeClass)v0_1).getMinWidthDp() > arg6) {
                continue;
            }

            if(v7.getMinWidthDp() > ((WindowSizeClass)v0_1).getMinWidthDp()) {
                continue;
            }

            Object v7_1 = v0_1;
        }

        return v7;
    }
}


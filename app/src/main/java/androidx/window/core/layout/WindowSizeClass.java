package androidx.window.core.layout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\nJ\u000E\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0003J\u000E\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u0003J\u0016\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u0003J\u0013\u0010\u001F\u001A\u00020\u001A2\b\u0010 \u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001A\u00020\u0003H\u0016J\b\u0010\"\u001A\u00020#H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u001A\u0010\u000E\u001A\u00020\u000F8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0011\u001A\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2={"Landroidx/window/core/layout/WindowSizeClass;", "", "minWidthDp", "", "minHeightDp", "<init>", "(II)V", "widthDp", "", "heightDp", "(FF)V", "getMinWidthDp", "()I", "getMinHeightDp", "windowWidthSizeClass", "Landroidx/window/core/layout/WindowWidthSizeClass;", "getWindowWidthSizeClass$annotations", "()V", "getWindowWidthSizeClass", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "windowHeightSizeClass", "Landroidx/window/core/layout/WindowHeightSizeClass;", "getWindowHeightSizeClass$annotations", "getWindowHeightSizeClass", "()Landroidx/window/core/layout/WindowHeightSizeClass;", "isWidthAtLeastBreakpoint", "", "widthDpBreakpoint", "isHeightAtLeastBreakpoint", "heightDpBreakpoint", "isAtLeastBreakpoint", "equals", "other", "hashCode", "toString", "", "Companion", "window-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowSizeClass {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00050\fH\u0002J\u0018\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/window/core/layout/WindowSizeClass$Companion;", "", "<init>", "()V", "WIDTH_DP_MEDIUM_LOWER_BOUND", "", "WIDTH_DP_EXPANDED_LOWER_BOUND", "WIDTH_DP_LARGE_LOWER_BOUND", "WIDTH_DP_EXTRA_LARGE_LOWER_BOUND", "HEIGHT_DP_MEDIUM_LOWER_BOUND", "HEIGHT_DP_EXPANDED_LOWER_BOUND", "WIDTH_DP_BREAKPOINTS_V1", "", "WIDTH_DP_BREAKPOINTS_V2", "HEIGHT_DP_BREAKPOINTS_V1", "HEIGHT_DP_BREAKPOINTS_V2", "createBreakpointSet", "", "Landroidx/window/core/layout/WindowSizeClass;", "widthBreakpoints", "heightBreakpoints", "BREAKPOINTS_V1", "BREAKPOINTS_V2", "compute", "dpWidth", "", "dpHeight", "window-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final Set access$createBreakpointSet(Companion arg0, List arg1, List arg2) {
            return arg0.createBreakpointSet(arg1, arg2);
        }

        @Deprecated(message="Use computeWindowSizeClass instead.", replaceWith="<_subannotation>") @JvmStatic public final WindowSizeClass compute(float arg2, float arg3) {
            int v1;
            int v0 = 0;
            if(Float.compare(arg2, 840f) >= 0) {
                v1 = 840;
            }
            else if(arg2 >= 600f) {
                v1 = 600;
            }
            else {
                v1 = 0;
            }

            if(arg3 >= 900f) {
                v0 = 900;
            }
            else if(arg3 >= 480f) {
                v0 = 480;
            }

            return new WindowSizeClass(v1, v0);
        }

        private final Set createBreakpointSet(List arg6, List arg7) {
            ArrayList v5 = new ArrayList();
            Iterator v6 = ((Iterable)arg6).iterator();
            while(v6.hasNext()) {
                int v0 = v6.next().intValue();
                ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arg7, 10));
                Iterator v1 = arg7.iterator();
                while(v1.hasNext()) {
                    ((Collection)v2).add(new WindowSizeClass(v0, v1.next().intValue()));
                }

                CollectionsKt.addAll(((Collection)v5), ((Iterable)v2));
            }

            return CollectionsKt.toSet(((Iterable)v5));
        }
    }

    public static final Set BREAKPOINTS_V1 = null;
    public static final Set BREAKPOINTS_V2 = null;
    public static final Companion Companion = null;
    private static final List HEIGHT_DP_BREAKPOINTS_V1 = null;
    private static final List HEIGHT_DP_BREAKPOINTS_V2 = null;
    public static final int HEIGHT_DP_EXPANDED_LOWER_BOUND = 900;
    public static final int HEIGHT_DP_MEDIUM_LOWER_BOUND = 480;
    private static final List WIDTH_DP_BREAKPOINTS_V1 = null;
    private static final List WIDTH_DP_BREAKPOINTS_V2 = null;
    public static final int WIDTH_DP_EXPANDED_LOWER_BOUND = 840;
    public static final int WIDTH_DP_EXTRA_LARGE_LOWER_BOUND = 1600;
    public static final int WIDTH_DP_LARGE_LOWER_BOUND = 1200;
    public static final int WIDTH_DP_MEDIUM_LOWER_BOUND = 600;
    private final int minHeightDp;
    private final int minWidthDp;

    static {
        Companion v0 = new Companion(null);
        WindowSizeClass.Companion = v0;
        Integer[] v2 = new Integer[3];
        Integer v4 = Integer.valueOf(0);
        v2[0] = v4;
        v2[1] = Integer.valueOf(600);
        v2[2] = Integer.valueOf(840);
        List v2_1 = CollectionsKt.listOf(((Object[])v2));
        WindowSizeClass.WIDTH_DP_BREAKPOINTS_V1 = v2_1;
        List v5 = CollectionsKt.plus(v2_1, CollectionsKt.listOf(new Integer[]{Integer.valueOf(1200), Integer.valueOf(1600)}));
        WindowSizeClass.WIDTH_DP_BREAKPOINTS_V2 = v5;
        List v1 = CollectionsKt.listOf(new Integer[]{v4, Integer.valueOf(480), Integer.valueOf(900)});
        WindowSizeClass.HEIGHT_DP_BREAKPOINTS_V1 = v1;
        WindowSizeClass.HEIGHT_DP_BREAKPOINTS_V2 = v1;
        WindowSizeClass.BREAKPOINTS_V1 = Companion.access$createBreakpointSet(v0, v2_1, v1);
        WindowSizeClass.BREAKPOINTS_V2 = Companion.access$createBreakpointSet(v0, v5, v1);
    }

    public WindowSizeClass(float arg1, float arg2) {
        this(((int)arg1), ((int)arg2));
    }

    public WindowSizeClass(int arg2, int arg3) {
        super();
        this.minWidthDp = arg2;
        this.minHeightDp = arg3;
        char v1 = '.';
        if(arg2 >= 0) {
            if(arg3 >= 0) {
                return;
            }

            throw new IllegalArgumentException("Expected minHeightDp to be at least 0, minHeightDp: " + arg3 + v1.toString());
        }

        throw new IllegalArgumentException("Expected minWidthDp to be at least 0, minWidthDp: " + arg2 + v1.toString());
    }

    @Deprecated(message="Use computeWindowSizeClass instead.", replaceWith="<_subannotation>") @JvmStatic public static final WindowSizeClass compute(float arg1, float arg2) {
        return WindowSizeClass.Companion.compute(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((WindowSizeClass)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(this.minWidthDp != ((WindowSizeClass)arg5).minWidthDp) {
                return 0;
            }
            else if(this.minHeightDp != ((WindowSizeClass)arg5).minHeightDp) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final int getMinHeightDp() {
        return this.minHeightDp;
    }

    public final int getMinWidthDp() {
        return this.minWidthDp;
    }

    public final WindowHeightSizeClass getWindowHeightSizeClass() {
        return WindowHeightSizeClass.Companion.compute$window_core(((float)this.minHeightDp));
    }

    @Deprecated(message="Use either isHeightAtLeastBreakpoint or isAtLeastBreakpoint to check matching bounds.") public static void getWindowHeightSizeClass$annotations() {
    }

    public final WindowWidthSizeClass getWindowWidthSizeClass() {
        return WindowWidthSizeClass.Companion.compute$window_core(((float)this.minWidthDp));
    }

    @Deprecated(message="Use either isWidthAtLeastBreakpoint or isAtLeastBreakpoint to check matching bounds.") public static void getWindowWidthSizeClass$annotations() {
    }

    public int hashCode() {
        return this.minWidthDp * 0x1F + this.minHeightDp;
    }

    public final boolean isAtLeastBreakpoint(int arg1, int arg2) {
        if((this.isWidthAtLeastBreakpoint(arg1)) && (this.isHeightAtLeastBreakpoint(arg2))) {
            return 1;
        }

        return 0;
    }

    public final boolean isHeightAtLeastBreakpoint(int arg1) {
        if(this.minHeightDp >= arg1) {
            return 1;
        }

        return 0;
    }

    public final boolean isWidthAtLeastBreakpoint(int arg1) {
        if(this.minWidthDp >= arg1) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return "WindowSizeClass(minWidthDp=" + this.minWidthDp + ", minHeightDp=" + this.minHeightDp + ')';
    }
}


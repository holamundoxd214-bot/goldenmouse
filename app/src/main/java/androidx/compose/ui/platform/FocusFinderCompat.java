package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000E\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0013J \u0010\u0014\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0013J\u001A\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\fH\u0002J\"\u0010\u0017\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J$\u0010\u000E\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0015\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001A\u00020\u0013H\u0002JF\u0010\u000E\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\f2\b\u0010\u0015\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001A\u00020\u00132\u0016\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00020\f0\u000Bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J<\u0010\u0019\u001A\u0004\u0018\u00010\f2\u0016\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00020\f0\u000Bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001A\u00020\u0013H\u0003J\u0018\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0005H\u0002J\u0018\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0005H\u0002JD\u0010\u001D\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001A\u00020\u00052\u0016\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00020\f0\u000Bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J4\u0010\u001E\u001A\u0004\u0018\u00010\f2\b\u0010\u0011\u001A\u0004\u0018\u00010\f2\u0016\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00020\f0\u000Bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u001F\u001A\u00020\u0013H\u0002J4\u0010 \u001A\u0004\u0018\u00010\f2\b\u0010\u0011\u001A\u0004\u0018\u00010\f2\u0016\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00020\f0\u000Bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u001F\u001A\u00020\u0013H\u0002J\u0010\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0013H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\n\u001A\u0012\u0012\u0004\u0012\u00020\f0\u000Bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/compose/ui/platform/FocusFinderCompat;", "", "<init>", "()V", "cachedFocusedRect", "Landroid/graphics/Rect;", "bestCandidateRect", "otherRect", "userSpecifiedFocusComparator", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "tmpList", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "findNextFocus", "root", "Landroid/view/ViewGroup;", "focused", "direction", "", "findNextFocusFromRect", "focusedRect", "getEffectiveRoot", "findNextUserSpecifiedFocus", "focusables", "findNextFocusInRelativeDirection", "setFocusBottomRight", "", "setFocusTopLeft", "findNextFocusInAbsoluteDirection", "getNextFocusable", "count", "getPreviousFocusable", "isValidId", "", "id", "Companion", "UserSpecifiedFocusComparator", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusFinderCompat {
    @Metadata(d1={"\u0000\u001B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"Landroidx/compose/ui/platform/FocusFinderCompat$Companion;", "", "<init>", "()V", "FocusFinderThreadLocal", "androidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1", "Landroidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1;", "instance", "Landroidx/compose/ui/platform/FocusFinderCompat;", "getInstance", "()Landroidx/compose/ui/platform/FocusFinderCompat;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final FocusFinderCompat getInstance() {
            Object v0 = FocusFinderCompat.FocusFinderThreadLocal.get();
            Intrinsics.checkNotNull(v0);
            return ((FocusFinderCompat)v0);
        }
    }

    @Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003:\u0001\u001CB\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001A\u00020\u0011J&\u0010\u0012\u001A\u00020\u00112\u0016\u0010\u0013\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u0014j\b\u0012\u0004\u0012\u00020\u0002`\u00152\u0006\u0010\u000F\u001A\u00020\u0002J\u000E\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0002J\u001C\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u00022\b\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0002X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "Ljava/util/Comparator;", "Landroid/view/View;", "Lkotlin/Comparator;", "mNextFocusGetter", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "<init>", "(Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;)V", "nextFoci", "Landroidx/collection/MutableScatterMap;", "isConnectedTo", "Landroidx/collection/MutableScatterSet;", "headsOfChains", "originalOrdinal", "Landroidx/collection/MutableObjectIntMap;", "root", "recycle", "", "setFocusables", "focusables", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setHeadOfChain", "head", "compare", "", "first", "second", "NextFocusGetter", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class UserSpecifiedFocusComparator implements Comparator {
        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001A\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "", "get", "Landroid/view/View;", "root", "view", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface NextFocusGetter {
            View get(View arg1, View arg2);
        }

        private final MutableScatterMap headsOfChains;
        private final MutableScatterSet isConnectedTo;
        private final NextFocusGetter mNextFocusGetter;
        private final MutableScatterMap nextFoci;
        private final MutableObjectIntMap originalOrdinal;
        private View root;

        public UserSpecifiedFocusComparator(NextFocusGetter arg1) {
            super();
            this.mNextFocusGetter = arg1;
            this.nextFoci = ScatterMapKt.mutableScatterMapOf();
            this.isConnectedTo = ScatterSetKt.mutableScatterSetOf();
            this.headsOfChains = ScatterMapKt.mutableScatterMapOf();
            this.originalOrdinal = ObjectIntMapKt.mutableObjectIntMapOf();
        }

        public int compare(View arg6, View arg7) {
            if(arg6 == arg7) {
                return 0;
            }

            int v1 = -1;
            if(arg6 == null) {
                return v1;
            }

            if(arg7 == null) {
                return 1;
            }

            Object v3 = this.headsOfChains.get(arg6);
            Object v4 = this.headsOfChains.get(arg7);
            if(v3 == v4 && v3 != null) {
                if(arg6 == (((View)v3))) {
                    return v1;
                }
                else if(arg7 == (((View)v3))) {
                    return 1;
                }
                else if(this.nextFoci.get(arg6) != null) {
                    return v1;
                }
                else {
                    return 1;
                }
            }

            if(v3 == null) {
            }
            else {
                Object v6 = v3;
            }

            if(v4 == null) {
            }
            else {
                Object v7 = v4;
            }

            if(v3 == null) {
                if(v4 != null) {
                }
                else {
                    return 0;
                }
            }

            if(this.originalOrdinal.get(v6) < this.originalOrdinal.get(v7)) {
                return v1;
            }

            return 1;
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((View)arg1), ((View)arg2));
        }

        public final void recycle() {
            this.root = null;
            this.headsOfChains.clear();
            this.isConnectedTo.clear();
            this.originalOrdinal.clear();
            this.nextFoci.clear();
        }

        public final void setFocusables(ArrayList arg6, View arg7) {
            this.root = arg7;
            ArrayList v0 = arg6;
            int v1 = ((Collection)v0).size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                this.originalOrdinal.set(((List)arg6).get(v2), v2);
            }

            v1 = ((Collection)v0).size() - 1;
            if(v1 >= 0) {
                while(true) {
                    v2 = v1 - 1;
                    Object v1_1 = ((List)arg6).get(v1);
                    View v3 = this.mNextFocusGetter.get(arg7, ((View)v1_1));
                    if(v3 != null && (this.originalOrdinal.containsKey(v3))) {
                        this.nextFoci.set(v1_1, v3);
                        this.isConnectedTo.add(v3);
                    }

                    if(v2 < 0) {
                        break;
                    }

                    v1 = v2;
                }
            }

            int v7 = ((Collection)v0).size() - 1;
            if(v7 >= 0) {
                while(true) {
                    int v0_1 = v7 - 1;
                    Object v7_1 = ((List)arg6).get(v7);
                    if(this.nextFoci.get(v7_1) != null && !this.isConnectedTo.contains(v7_1)) {
                        this.setHeadOfChain(((View)v7_1));
                    }

                    if(v0_1 < 0) {
                        return;
                    }

                    v7 = v0_1;
                }
            }
        }

        public final void setHeadOfChain(View arg3) {
            View v0 = arg3;
            while(arg3 != null) {
                Object v1 = this.headsOfChains.get(arg3);
                if(v1 != null) {
                    if((((View)v1)) == v0) {
                        return;
                    }
                    else {
                        arg3 = v0;
                        Object v0_1 = v1;
                    }
                }

                this.headsOfChains.set(arg3, v0);
                Object v3 = this.nextFoci.get(arg3);
            }
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final FocusFinderCompat$Companion$FocusFinderThreadLocal$1 FocusFinderThreadLocal;
    private final Rect bestCandidateRect;
    private final Rect cachedFocusedRect;
    private final Rect otherRect;
    private final ArrayList tmpList;
    private final UserSpecifiedFocusComparator userSpecifiedFocusComparator;

    static {
        FocusFinderCompat.Companion = new Companion(null);
        FocusFinderCompat.$stable = 8;
        FocusFinderCompat.FocusFinderThreadLocal = new FocusFinderCompat$Companion$FocusFinderThreadLocal$1();
    }

    public FocusFinderCompat() {
        super();
        this.cachedFocusedRect = new Rect();
        this.bestCandidateRect = new Rect();
        this.otherRect = new Rect();
        this.userSpecifiedFocusComparator = new UserSpecifiedFocusComparator(new FocusFinderCompat$$ExternalSyntheticLambda0(this));
        this.tmpList = new ArrayList();
    }

    public static final FocusFinderCompat$Companion$FocusFinderThreadLocal$1 access$getFocusFinderThreadLocal$cp() {
        return FocusFinderCompat.FocusFinderThreadLocal;
    }

    public final View findNextFocus(ViewGroup arg7, View arg8, int arg9) {
        ViewGroup v1 = this.getEffectiveRoot(arg7, arg8);
        View v7 = this.findNextUserSpecifiedFocus(v1, arg8, arg9);
        if(v7 != null) {
            return v7;
        }

        ArrayList v5 = this.tmpList;
        try {
            v5.clear();
            FocusFinderCompat_androidKt.access$addFocusableViews(v1, v5, arg9);
            if(!v5.isEmpty()) {
                v7 = this.findNextFocus(v1, arg8, null, arg9, v5);
            }
        }
        catch(Throwable v0) {
            v5.clear();
            throw v0;
        }

        v5.clear();
        return v7;
    }

    private final View findNextFocus(ViewGroup arg8, Rect arg9, int arg10) {
        View v7;
        View v0 = null;
        ViewGroup v2 = this.getEffectiveRoot(arg8, v0);
        ArrayList v6 = this.tmpList;
        try {
            v6.clear();
            FocusFinderCompat_androidKt.access$addFocusableViews(v2, v6, arg10);
            if(v6.isEmpty()) {
                goto label_15;
            }

            v7 = this.findNextFocus(v2, null, arg9, arg10, v6);
        }
        catch(Throwable v0_1) {
            v6.clear();
            throw v0_1;
        }

        v6.clear();
        return v7;
    label_15:
        v6.clear();
        return v0;
    }

    private final View findNextFocus(ViewGroup arg9, View arg10, Rect arg11, int arg12, ArrayList arg13) {
        Rect v0 = arg11;
        arg11 = this.cachedFocusedRect;
        int v1 = 130;
        int v2 = 66;
        int v3 = 33;
        int v4 = 17;
        int v5 = 2;
        if(arg10 != null) {
            arg10.getFocusedRect(arg11);
            arg9.offsetDescendantRectToMyCoords(arg10, arg11);
        }
        else if(v0 != null) {
            arg11.set(v0);
        }
        else if(arg12 == 1) {
            if(arg9.getLayoutDirection() == 1) {
                this.setFocusTopLeft(arg9, arg11);
                goto label_37;
            }

            this.setFocusBottomRight(arg9, arg11);
        }
        else if(arg12 != v5) {
            if(arg12 != v4 && arg12 != v3) {
                if(arg12 != v2 && arg12 != v1) {
                    goto label_37;
                }

                this.setFocusTopLeft(arg9, arg11);
                goto label_37;
            }

            this.setFocusBottomRight(arg9, arg11);
        }
        else {
            if(arg9.getLayoutDirection() == 1) {
                this.setFocusBottomRight(arg9, arg11);
                goto label_37;
            }

            this.setFocusTopLeft(arg9, arg11);
        }

    label_37:
        if(arg12 != 1 && arg12 != v5) {
            if(arg12 != v4 && arg12 != v3 && arg12 != v2 && arg12 != v1) {
                throw new IllegalArgumentException("Unknown direction: " + arg12);
            }

            ArrayList v7 = arg13;
            int v13 = arg12;
            ArrayList v12 = v7;
            return this.findNextFocusInAbsoluteDirection(arg9, arg10, arg11, v12, v13);
        }

        return this.findNextFocusInRelativeDirection(arg13, arg9, arg10, arg12);
    }

    public final View findNextFocusFromRect(ViewGroup arg2, Rect arg3, int arg4) {
        this.cachedFocusedRect.set(arg3);
        return this.findNextFocus(arg2, this.cachedFocusedRect, arg4);
    }

    private final View findNextFocusInAbsoluteDirection(ViewGroup arg9, View arg10, Rect arg11, ArrayList arg12, int arg13) {
        this.bestCandidateRect.set(arg11);
        int v1 = 0;
        if(arg13 == 17) {
            this.bestCandidateRect.offset(arg11.width() + 1, 0);
        }
        else if(arg13 == 33) {
            this.bestCandidateRect.offset(0, arg11.height() + 1);
        }
        else if(arg13 == 66) {
            this.bestCandidateRect.offset(-arg11.width() - 1, 0);
        }
        else if(arg13 != 130) {
        }
        else {
            this.bestCandidateRect.offset(0, -arg11.height() - 1);
        }

        int v0 = arg12.size();
        View v2 = null;
        while(v1 < v0) {
            Object v3 = ((List)arg12).get(v1);
            if(!Intrinsics.areEqual(v3, arg10) && !Intrinsics.areEqual(v3, arg9)) {
                ((View)v3).getFocusedRect(this.otherRect);
                arg9.offsetDescendantRectToMyCoords(((View)v3), this.otherRect);
                androidx.compose.ui.geometry.Rect v4 = RectHelper_androidKt.toComposeRect(this.otherRect);
                androidx.compose.ui.geometry.Rect v5 = RectHelper_androidKt.toComposeRect(this.bestCandidateRect);
                androidx.compose.ui.geometry.Rect v6 = RectHelper_androidKt.toComposeRect(arg11);
                FocusDirection v7 = FocusInteropUtils_androidKt.toFocusDirection(arg13);
                int v7_1 = v7 != null ? v7.unbox-impl() : FocusDirection.Companion.getNext-dhqQ-8s();
                if(!TwoDimensionalFocusSearchKt.isBetterCandidate-I7lrPNg(v4, v5, v6, v7_1)) {
                    goto label_63;
                }

                this.bestCandidateRect.set(this.otherRect);
                Object v2_1 = v3;
            }

        label_63:
            ++v1;
        }

        return v2;
    }

    private final View findNextFocusInRelativeDirection(ArrayList arg11, ViewGroup arg12, View arg13, int arg14) {
        ArrayList v8;
        try {
            this.userSpecifiedFocusComparator.setFocusables(arg11, arg12);
            Collections.sort(arg11, this.userSpecifiedFocusComparator);
        }
        catch(Throwable v0) {
            this.userSpecifiedFocusComparator.recycle();
            throw v0;
        }

        this.userSpecifiedFocusComparator.recycle();
        int v0_1 = arg11.size();
        View v1 = null;
        int v2 = 2;
        if(v0_1 < v2) {
            return v1;
        }

        if(arg14 == 1) {
            v8 = arg11;
            v1 = this.getPreviousFocusable(arg13, v8, v0_1);
        }
        else if(arg14 != v2) {
            if(arg14 != 17 && arg14 != 33 && arg14 != 66 && arg14 != 130) {
                v8 = arg11;
                goto label_43;
            }

            v8 = arg11;
            v1 = this.findNextFocusInAbsoluteDirection(arg12, arg13, this.cachedFocusedRect, v8, arg14);
        }
        else {
            v8 = arg11;
            v1 = this.getNextFocusable(arg13, v8, v0_1);
        }

    label_43:
        if(v1 == null) {
            return v8.get(v0_1 - 1);
        }

        return v1;
    }

    private final View findNextUserSpecifiedFocus(ViewGroup arg4, View arg5, int arg6) {
        View v1;
        View v3 = FocusFinderCompat_androidKt.access$findUserSetNextFocus(arg5, ((View)arg4), arg6);
        int v0 = 1;
        arg5 = v3;
        while(true) {
            v1 = null;
            if(v3 != null) {
                if((v3.isFocusable()) && v3.getVisibility() == 0 && (!v3.isInTouchMode() || (v3.isFocusableInTouchMode()))) {
                    return v3;
                }

                v3 = FocusFinderCompat_androidKt.access$findUserSetNextFocus(v3, ((View)arg4), arg6);
                int v2 = v0 ^ 1;
                if(v0 == 0) {
                    arg5 = arg5 != null ? FocusFinderCompat_androidKt.access$findUserSetNextFocus(arg5, ((View)arg4), arg6) : v1;
                    if(arg5 != v3) {
                        goto label_24;
                    }

                    return v1;
                }

            label_24:
                v0 = v2;
                continue;
            }

            return v1;
        }

        return v1;
    }

    private final ViewGroup getEffectiveRoot(ViewGroup arg4, View arg5) {
        if(arg5 != null) {
            if((((ViewGroup)arg5)) == arg4) {
            }
            else {
                ViewParent v3 = arg5.getParent();
                ViewParent v0 = null;
                while((v3 instanceof ViewGroup)) {
                    if((((ViewGroup)v3)) != arg4) {
                        if((((ViewGroup)v3).getTouchscreenBlocksFocus()) && (arg5.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen"))) {
                            v0 = v3;
                        }

                        v3 = ((ViewGroup)v3).getParent();
                        continue;
                    }
                    else if(v0 == null) {
                    }
                    else {
                        return ((ViewGroup)v0);
                    }

                    return arg4;
                }
            }
        }

        return arg4;
    }

    private final View getNextFocusable(View arg1, ArrayList arg2, int arg3) {
        if(arg3 < 2) {
            return null;
        }

        if(arg1 != null) {
            int v0 = arg2.lastIndexOf(arg1);
            if(v0 >= 0) {
                ++v0;
                if(v0 < arg3) {
                    return arg2.get(v0);
                }
            }
        }

        return arg2.get(0);
    }

    private final View getPreviousFocusable(View arg1, ArrayList arg2, int arg3) {
        if(arg3 < 2) {
            return null;
        }

        if(arg1 != null) {
            int v0 = arg2.indexOf(arg1);
            if(v0 > 0) {
                return arg2.get(v0 - 1);
            }
        }

        return arg2.get(arg3 - 1);
    }

    private final boolean isValidId(int arg1) {
        if(arg1 != 0 && arg1 != -1) {
            return 1;
        }

        return 0;
    }

    private final void setFocusBottomRight(ViewGroup arg2, Rect arg3) {
        int v1 = arg2.getScrollY() + arg2.getHeight();
        int v0 = arg2.getScrollX() + arg2.getWidth();
        arg3.set(v0, v1, v0, v1);
    }

    private final void setFocusTopLeft(ViewGroup arg1, Rect arg2) {
        int v0 = arg1.getScrollY();
        int v1 = arg1.getScrollX();
        arg2.set(v1, v0, v1, v0);
    }

    static final View userSpecifiedFocusComparator$lambda$0(FocusFinderCompat arg1, View arg2, View arg3) {
        if(arg1.isValidId(arg3.getNextFocusForwardId())) {
            return FocusFinderCompat_androidKt.access$findUserSetNextFocus(arg3, arg2, 2);
        }

        return null;
    }
}


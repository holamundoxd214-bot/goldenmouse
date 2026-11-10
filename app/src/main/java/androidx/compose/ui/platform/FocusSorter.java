package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u001E\u001A\u00020\u001F2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00140!2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020%¢\u0006\u0002\u0010&R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000ER\u001D\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001A\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u0019¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR!\u0010\u001C\u001A\u0012\u0012\u0004\u0012\u00020\u00140\u0018j\b\u0012\u0004\u0012\u00020\u0014`\u0019¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001B¨\u0006\'"}, d2={"Landroidx/compose/ui/platform/FocusSorter;", "", "<init>", "()V", "rectPool", "Landroidx/collection/MutableObjectList;", "Landroid/graphics/Rect;", "getRectPool", "()Landroidx/collection/MutableObjectList;", "lastPoolIndex", "", "getLastPoolIndex", "()I", "setLastPoolIndex", "(I)V", "rtlMult", "getRtlMult", "setRtlMult", "rectByView", "Landroidx/collection/MutableScatterMap;", "Landroid/view/View;", "getRectByView", "()Landroidx/collection/MutableScatterMap;", "topsComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getTopsComparator", "()Ljava/util/Comparator;", "sidesComparator", "getSidesComparator", "sort", "", "views", "", "root", "Landroid/view/ViewGroup;", "isRtl", "", "([Landroid/view/View;Landroid/view/ViewGroup;Z)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusSorter {
    public static final FocusSorter INSTANCE;
    private static int lastPoolIndex;
    private static final MutableScatterMap rectByView;
    private static final MutableObjectList rectPool;
    private static int rtlMult;
    private static final Comparator sidesComparator;
    private static final Comparator topsComparator;

    static {
        FocusSorter.INSTANCE = new FocusSorter();
        FocusSorter.rectPool = new MutableObjectList(0, 1, null);
        FocusSorter.rtlMult = 1;
        FocusSorter.rectByView = ScatterMapKt.mutableScatterMapOf();
        FocusSorter.topsComparator = new FocusSorter$$ExternalSyntheticLambda0();
        FocusSorter.sidesComparator = new FocusSorter$$ExternalSyntheticLambda1();
    }

    private FocusSorter() {
        super();
    }

    public final int getLastPoolIndex() {
        return FocusSorter.lastPoolIndex;
    }

    public final MutableScatterMap getRectByView() {
        return FocusSorter.rectByView;
    }

    public final MutableObjectList getRectPool() {
        return FocusSorter.rectPool;
    }

    public final int getRtlMult() {
        return FocusSorter.rtlMult;
    }

    public final Comparator getSidesComparator() {
        return FocusSorter.sidesComparator;
    }

    public final Comparator getTopsComparator() {
        return FocusSorter.topsComparator;
    }

    public final void setLastPoolIndex(int arg1) {
        FocusSorter.lastPoolIndex = arg1;
    }

    public final void setRtlMult(int arg1) {
        FocusSorter.rtlMult = arg1;
    }

    static final int sidesComparator$lambda$0(View arg2, View arg3) {
        if(arg2 == arg3) {
            return 0;
        }

        MutableScatterMap v0 = FocusSorter.rectByView;
        Object v2 = v0.get(arg2);
        Intrinsics.checkNotNull(v2);
        Object v3 = v0.get(arg3);
        Intrinsics.checkNotNull(v3);
        int v0_1 = ((Rect)v2).left - ((Rect)v3).left;
        if(v0_1 == 0) {
            return (((Rect)v2).right - ((Rect)v3).right) * FocusSorter.rtlMult;
        }

        return v0_1 * FocusSorter.rtlMult;
    }

    public final void sort(View[] arg8, ViewGroup arg9, boolean arg10) {
        int v7 = arg8.length;
        if(v7 < 2) {
            return;
        }

        int v0 = v7 - FocusSorter.rectPool.getSize();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            FocusSorter.rectPool.add(new Rect());
        }

        v0 = arg8.length;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = arg8[v2];
            MutableObjectList v4 = FocusSorter.rectPool;
            int v5 = FocusSorter.lastPoolIndex;
            FocusSorter.lastPoolIndex = v5 + 1;
            Object v4_1 = v4.get(v5);
            v3.getDrawingRect(((Rect)v4_1));
            arg9.offsetDescendantRectToMyCoords(v3, ((Rect)v4_1));
            FocusSorter.rectByView.set(v3, v4_1);
        }

        ArraysKt.sortWith(((Object[])arg8), FocusSorter.topsComparator);
        Object v9 = FocusSorter.rectByView.get(arg8[0]);
        Intrinsics.checkNotNull(v9);
        int v9_1 = ((Rect)v9).bottom;
        int v10 = arg10 ? -1 : 1;
        FocusSorter.rtlMult = v10;
        v10 = 0;
        v2 = 0;
        while(v10 < v7) {
            Object v3_1 = FocusSorter.rectByView.get(arg8[v10]);
            Intrinsics.checkNotNull(v3_1);
            if(((Rect)v3_1).top >= v9_1) {
                if(v10 - v2 > 1) {
                    ArraysKt.sortWith(((Object[])arg8), FocusSorter.sidesComparator, v2, v10);
                }

                v9_1 = ((Rect)v3_1).bottom;
                v2 = v10;
            }
            else {
                v9_1 = Math.max(v9_1, ((Rect)v3_1).bottom);
            }

            ++v10;
        }

        if(v7 - v2 > 1) {
            ArraysKt.sortWith(((Object[])arg8), FocusSorter.sidesComparator, v2, v7);
        }

        FocusSorter.lastPoolIndex = 0;
        FocusSorter.rectByView.clear();
    }

    static final int topsComparator$lambda$0(View arg2, View arg3) {
        if(arg2 == arg3) {
            return 0;
        }

        MutableScatterMap v0 = FocusSorter.rectByView;
        Object v2 = v0.get(arg2);
        Intrinsics.checkNotNull(v2);
        Object v3 = v0.get(arg3);
        Intrinsics.checkNotNull(v3);
        int v0_1 = ((Rect)v2).top - ((Rect)v3).top;
        if(v0_1 == 0) {
            return ((Rect)v2).bottom - ((Rect)v3).bottom;
        }

        return v0_1;
    }
}


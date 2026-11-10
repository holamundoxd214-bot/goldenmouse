package androidx.core.view;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\u0002\u001A\u0015\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\n\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\n\u001A\r\u0010\u000E\u001A\u00020\u0006*\u00020\u0002H\u0086\b\u001A\r\u0010\u000F\u001A\u00020\u0006*\u00020\u0002H\u0086\b\u001A3\u0010\u0010\u001A\u00020\t*\u00020\u00022!\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t0\u0012H\u0086\bø\u0001\u0000\u001AH\u0010\u0015\u001A\u00020\t*\u00020\u000226\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t0\u0016H\u0086\bø\u0001\u0000\u001A\u0013\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00010\u001C*\u00020\u0002H\u0086\u0002\u001A\u0017\u0010#\u001A\u00020\t*\u00020$2\b\b\u0001\u0010\u000B\u001A\u00020\u0004H\u0086\b\u001A5\u0010%\u001A\u00020\t*\u00020$2\b\b\u0003\u0010&\u001A\u00020\u00042\b\b\u0003\u0010\'\u001A\u00020\u00042\b\b\u0003\u0010(\u001A\u00020\u00042\b\b\u0003\u0010)\u001A\u00020\u0004H\u0086\b\u001A5\u0010*\u001A\u00020\t*\u00020$2\b\b\u0003\u0010+\u001A\u00020\u00042\b\b\u0003\u0010\'\u001A\u00020\u00042\b\b\u0003\u0010,\u001A\u00020\u00042\b\b\u0003\u0010)\u001A\u00020\u0004H\u0086\b\"\u0016\u0010\u000B\u001A\u00020\u0004*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\f\u0010\r\"\u0016\u0010\u0017\u001A\u00020\u0018*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A\"\u001B\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00010\u001E*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 \"\u001B\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00010\u001E*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\"\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, d2={"get", "Landroid/view/View;", "Landroid/view/ViewGroup;", "index", "", "contains", "", "view", "plusAssign", "", "minusAssign", "size", "getSize", "(Landroid/view/ViewGroup;)I", "isEmpty", "isNotEmpty", "forEach", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Landroid/view/ViewGroup;)Lkotlin/ranges/IntRange;", "iterator", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewGroupKt {
    public static final boolean contains(ViewGroup arg1, View arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "view");
        if(arg1.indexOfChild(arg2) != -1) {
            return 1;
        }

        return 0;
    }

    public static final void forEach(ViewGroup arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        int v0 = arg4.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg4.getChildAt(v1);
            Intrinsics.checkNotNullExpressionValue(v2, "getChildAt(...)");
            arg5.invoke(v2);
        }
    }

    public static final void forEachIndexed(ViewGroup arg5, Function2 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "action");
        int v0 = arg5.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Integer v2 = Integer.valueOf(v1);
            View v3 = arg5.getChildAt(v1);
            Intrinsics.checkNotNullExpressionValue(v3, "getChildAt(...)");
            arg6.invoke(v2, v3);
        }
    }

    public static final View get(ViewGroup arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        View v0 = arg3.getChildAt(arg4);
        if(v0 != null) {
            return v0;
        }

        throw new IndexOutOfBoundsException("Index: " + arg4 + ", Size: " + arg3.getChildCount());
    }

    public static final Sequence getChildren(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ViewGroupKt$children$1(arg1);
    }

    public static final Sequence getDescendants(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ViewGroupKt$special$$inlined$Sequence$1(arg1);
    }

    public static final IntRange getIndices(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.until(0, arg1.getChildCount());
    }

    public static final int getSize(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.getChildCount() == 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNotEmpty(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.getChildCount() != 0) {
            return 1;
        }

        return 0;
    }

    public static final Iterator iterator(ViewGroup arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ViewGroupKt$iterator$1(arg1);
    }

    public static final void minusAssign(ViewGroup arg1, View arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "view");
        arg1.removeView(arg2);
    }

    public static final void plusAssign(ViewGroup arg1, View arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "view");
        arg1.addView(arg2);
    }

    public static final void setMargins(ViewGroup$MarginLayoutParams arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setMargins(arg2, arg2, arg2, arg2);
    }

    public static final void updateMargins(ViewGroup$MarginLayoutParams arg1, int arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setMargins(arg2, arg3, arg4, arg5);
    }

    public static void updateMargins$default(ViewGroup$MarginLayoutParams arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.leftMargin;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.topMargin;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.rightMargin;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.bottomMargin;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        arg0.setMargins(arg1, arg2, arg3, arg4);
    }

    public static final void updateMarginsRelative(ViewGroup$MarginLayoutParams arg1, int arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setMarginStart(arg2);
        arg1.topMargin = arg3;
        arg1.setMarginEnd(arg4);
        arg1.bottomMargin = arg5;
    }

    public static void updateMarginsRelative$default(ViewGroup$MarginLayoutParams arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.getMarginStart();
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.topMargin;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.getMarginEnd();
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.bottomMargin;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        arg0.setMarginStart(arg1);
        arg0.topMargin = arg2;
        arg0.setMarginEnd(arg3);
        arg0.bottomMargin = arg4;
    }
}


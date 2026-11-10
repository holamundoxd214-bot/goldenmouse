package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A,\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u001E\u0010\u0000\u001A\u001A\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001A*\u0010\u0005\u001A\u00020\u00062\u0012\u0010\u0007\u001A\u000E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00040\u000BH\u0002¨\u0006\f"}, d2={"transform", "Landroidx/compose/ui/text/AnnotatedString;", "Lkotlin/Function3;", "", "", "collectRangeTransitions", "", "ranges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "target", "Ljava/util/SortedSet;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class JvmAnnotatedString_jvmKt {
    private static final void collectRangeTransitions(List arg4, SortedSet arg5) {
        if(arg4 != null) {
            int v0 = arg4.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                Object v2 = arg4.get(v1);
                arg5.add(Integer.valueOf(((Range)v2).getStart()));
                arg5.add(Integer.valueOf(((Range)v2).getEnd()));
            }
        }
    }

    public static final AnnotatedString transform(AnnotatedString arg11, Function3 arg12) {
        List v12_1;
        Integer[] v0 = new Integer[2];
        int v1 = 0;
        Integer v2 = Integer.valueOf(0);
        v0[0] = v2;
        v0[1] = Integer.valueOf(arg11.getText().length());
        TreeSet v0_1 = SetsKt.sortedSetOf(((Object[])v0));
        JvmAnnotatedString_jvmKt.collectRangeTransitions(arg11.getAnnotations$ui_text(), v0_1);
        ObjectRef v3 = new ObjectRef();
        v3.element = "";
        Map v2_1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(v2, v2)});
        CollectionsKt.windowed$default(v0_1, 2, 0, false, new JvmAnnotatedString_jvmKt$$ExternalSyntheticLambda0(v3, arg12, arg11, v2_1), 6, null);
        List v11 = arg11.getAnnotations$ui_text();
        if(v11 != null) {
            ArrayList v12 = new ArrayList(v11.size());
            int v0_2 = v11.size();
            while(v1 < v0_2) {
                Object v4 = v11.get(v1);
                Object v7 = ((Range)v4).getItem();
                Object v8 = v2_1.get(Integer.valueOf(((Range)v4).getStart()));
                Intrinsics.checkNotNull(v8);
                int v8_1 = ((Number)v8).intValue();
                v4 = v2_1.get(Integer.valueOf(((Range)v4).getEnd()));
                Intrinsics.checkNotNull(v4);
                v12.add(new Range(v7, v8_1, ((Number)v4).intValue()));
                ++v1;
            }
        }
        else {
            v12_1 = null;
        }

        return new AnnotatedString(v12_1, v3.element);
    }

    static final Integer transform$lambda$0(ObjectRef arg3, Function3 arg4, AnnotatedString arg5, Map arg6, List arg7) {
        int v0 = arg7.get(0).intValue();
        int v7 = arg7.get(1).intValue();
        arg3.element = arg3.element + arg4.invoke(arg5.getText(), Integer.valueOf(v0), Integer.valueOf(v7));
        return arg6.put(Integer.valueOf(v7), Integer.valueOf(arg3.element.length()));
    }
}


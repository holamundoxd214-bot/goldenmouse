package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000F\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001A9\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080\b\u001A3\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0005H\u0080\b\u001A-\u0010\t\u001A\u00020\b\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0005H\u0080\b\u001A\u001E\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00030\u000B\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0000\u001AD\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003\"\u000E\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000E*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0005H\u0000\u001A>\u0010\u0010\u001A\u00020\b\"\u0004\b\u0000\u0010\u0003\"\u000E\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000E*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0005H\u0000\u001A>\u0010\u0011\u001A\u00020\u0012\"\u0004\b\u0000\u0010\u0003\"\u000E\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000E*\b\u0012\u0004\u0012\u0002H\u00030\u000B2\u0014\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0005H\u0000\u001A\u001D\u0010\u0013\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u000BH\u0000¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2={"fastMap", "Landroidx/collection/ObjectList;", "R", "T", "transform", "Lkotlin/Function1;", "fastFilter", "predicate", "", "all", "toMutableObjectList", "Landroidx/collection/MutableObjectList;", "sortedBy", "K", "", "selector", "isSorted", "sortBy", "", "removeLast", "(Landroidx/collection/MutableObjectList;)Ljava/lang/Object;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ExtensionsKt {
    public static final boolean all(ObjectList arg4, Function1 arg5) {
        Object[] v0 = arg4.content;
        int v4 = arg4._size;
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            if(!arg5.invoke(v0[v2]).booleanValue()) {
                return 0;
            }
        }

        return 1;
    }

    public static final ObjectList fastFilter(ObjectList arg5, Function1 arg6) {
        Object[] v1_1;
        MutableObjectList v0_1;
        Object[] v0 = arg5.content;
        int v1 = arg5._size;
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            if(!arg6.invoke(v0[v3]).booleanValue()) {
                v0_1 = new MutableObjectList(0, 1, null);
                v1_1 = arg5.content;
                int v5 = arg5._size;
                goto label_15;
            }
        }

        return arg5;
    label_15:
        while(v2 < v5) {
            Object v3_1 = v1_1[v2];
            if(arg6.invoke(v3_1).booleanValue()) {
                v0_1.add(v3_1);
            }

            ++v2;
        }

        return ((ObjectList)v0_1);
    }

    public static final ObjectList fastMap(ObjectList arg4, Function1 arg5) {
        MutableObjectList v0 = new MutableObjectList(arg4.getSize());
        Object[] v1 = arg4.content;
        int v4 = arg4._size;
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            v0.add(arg5.invoke(v1[v2]));
        }

        return ((ObjectList)v0);
    }

    public static final boolean isSorted(ObjectList arg6, Function1 arg7) {
        if(arg6.getSize() <= 1) {
            return 1;
        }

        Object v2 = arg7.invoke(arg6.get(0));
        if(v2 == null) {
            return 0;
        }

        int v3 = arg6.getSize();
        int v4 = 1;
        while(v4 < v3) {
            Object v5 = arg7.invoke(arg6.get(v4));
            if(v5 == null) {
                return 0;
            }

            if(((Comparable)v2).compareTo(v5) > 0) {
                return 0;
            }

            ++v4;
            v2 = v5;
        }

        return 1;
    }

    public static final Object removeLast(MutableObjectList arg2) {
        if(!arg2.isEmpty()) {
            int v0 = arg2.getSize() - 1;
            Object v1 = arg2.get(v0);
            arg2.removeAt(v0);
            return v1;
        }

        throw new NoSuchElementException("List is empty.");
    }

    public static final void sortBy(MutableObjectList arg2, Function1 arg3) {
        List v2 = arg2.asMutableList();
        if(v2.size() > 1) {
            CollectionsKt.sortWith(v2, new ExtensionsKt$sortBy$$inlined$sortBy$1(arg3));
        }
    }

    public static final ObjectList sortedBy(ObjectList arg1, Function1 arg2) {
        if(ExtensionsKt.isSorted(arg1, arg2)) {
            return arg1;
        }

        MutableObjectList v1 = ExtensionsKt.toMutableObjectList(arg1);
        ExtensionsKt.sortBy(v1, arg2);
        return ((ObjectList)v1);
    }

    public static final MutableObjectList toMutableObjectList(ObjectList arg4) {
        MutableObjectList v0 = new MutableObjectList(arg4.getSize());
        Object[] v1 = arg4.content;
        int v4 = arg4._size;
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            v0.add(v1[v2]);
        }

        return v0;
    }
}


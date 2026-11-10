package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001A\u0012\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u0007\u001A\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u0007H\u0086\b\u001A\u001F\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001A\u0002H\u0007¢\u0006\u0002\u0010\u000B\u001A\'\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001A\u0002H\u00072\u0006\u0010\f\u001A\u0002H\u0007¢\u0006\u0002\u0010\r\u001A/\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001A\u0002H\u00072\u0006\u0010\f\u001A\u0002H\u00072\u0006\u0010\u000E\u001A\u0002H\u0007¢\u0006\u0002\u0010\u000F\u001A.\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00070\t\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0010\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0001\"\u0002H\u0007H\u0086\b¢\u0006\u0002\u0010\u0011\u001A\u0012\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u0007\u001A\u001F\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001A\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001A\'\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001A\u0002H\u00072\u0006\u0010\f\u001A\u0002H\u0007¢\u0006\u0002\u0010\u0014\u001A/\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0006\u0010\n\u001A\u0002H\u00072\u0006\u0010\f\u001A\u0002H\u00072\u0006\u0010\u000E\u001A\u0002H\u0007¢\u0006\u0002\u0010\u0015\u001A+\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0010\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0001\"\u0002H\u0007¢\u0006\u0002\u0010\u0016\u001A\u0018\u0010\u0017\u001A\u00020\u0018*\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0002\u001A \u0010\u001C\u001A\u00020\u0018*\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001BH\u0002\"\u0018\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"EmptyArray", "", "", "[Ljava/lang/Object;", "EmptyObjectList", "Landroidx/collection/ObjectList;", "emptyObjectList", "E", "mutableObjectListOf", "Landroidx/collection/MutableObjectList;", "element1", "(Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "elements", "([Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "objectListOf", "(Ljava/lang/Object;)Landroidx/collection/ObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "([Ljava/lang/Object;)Landroidx/collection/ObjectList;", "checkIndex", "", "", "index", "", "checkSubIndex", "fromIndex", "toIndex", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class ObjectListKt {
    private static final Object[] EmptyArray;
    private static final ObjectList EmptyObjectList;

    static {
        ObjectListKt.EmptyArray = new Object[0];
        ObjectListKt.EmptyObjectList = new MutableObjectList(0);
    }

    public static final void access$checkIndex(List arg0, int arg1) {
        ObjectListKt.checkIndex(arg0, arg1);
    }

    public static final void access$checkSubIndex(List arg0, int arg1, int arg2) {
        ObjectListKt.checkSubIndex(arg0, arg1, arg2);
    }

    public static final Object[] access$getEmptyArray$p() {
        return ObjectListKt.EmptyArray;
    }

    private static final void checkIndex(List arg2, int arg3) {
        int v2 = arg2.size();
        if(arg3 >= 0) {
            if(arg3 >= v2) {
            }
            else {
                return;
            }
        }

        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index " + arg3 + " is out of bounds. The list has " + v2 + " elements.");
    }

    private static final void checkSubIndex(List arg2, int arg3, int arg4) {
        int v2 = arg2.size();
        if(arg3 > arg4) {
            RuntimeHelpersKt.throwIllegalArgumentException("Indices are out of order. fromIndex (" + arg3 + ") is greater than toIndex (" + arg4 + ").");
        }

        if(arg3 < 0) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("fromIndex (" + arg3 + ") is less than 0.");
        }

        if(arg4 > v2) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("toIndex (" + arg4 + ") is more than than the list size (" + v2 + ')');
        }
    }

    public static final ObjectList emptyObjectList() {
        ObjectList v0 = ObjectListKt.EmptyObjectList;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return v0;
    }

    public static final MutableObjectList mutableObjectListOf() {
        return new MutableObjectList(0, 1, null);
    }

    public static final MutableObjectList mutableObjectListOf(Object arg2) {
        MutableObjectList v0 = new MutableObjectList(1);
        v0.add(arg2);
        return v0;
    }

    public static final MutableObjectList mutableObjectListOf(Object arg2, Object arg3) {
        MutableObjectList v0 = new MutableObjectList(2);
        v0.add(arg2);
        v0.add(arg3);
        return v0;
    }

    public static final MutableObjectList mutableObjectListOf(Object arg2, Object arg3, Object arg4) {
        MutableObjectList v0 = new MutableObjectList(3);
        v0.add(arg2);
        v0.add(arg3);
        v0.add(arg4);
        return v0;
    }

    public static final MutableObjectList mutableObjectListOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableObjectList v0 = new MutableObjectList(arg2.length);
        v0.plusAssign(arg2);
        return v0;
    }

    public static final ObjectList objectListOf() {
        ObjectList v0 = ObjectListKt.EmptyObjectList;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return v0;
    }

    public static final ObjectList objectListOf(Object arg0) {
        return ObjectListKt.mutableObjectListOf(arg0);
    }

    public static final ObjectList objectListOf(Object arg0, Object arg1) {
        return ObjectListKt.mutableObjectListOf(arg0, arg1);
    }

    public static final ObjectList objectListOf(Object arg0, Object arg1, Object arg2) {
        return ObjectListKt.mutableObjectListOf(arg0, arg1, arg2);
    }

    public static final ObjectList objectListOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        MutableObjectList v0 = new MutableObjectList(arg2.length);
        v0.plusAssign(arg2);
        return ((ObjectList)v0);
    }
}


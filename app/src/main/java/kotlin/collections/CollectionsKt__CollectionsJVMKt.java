package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0006\u001A#\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001A1\u0010\u0005\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\u0007\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\bH\u0081\u0088\u0004¢\u0006\u0002\u0010\t\u001A8\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0004\b\u0000\u0010\u000B2\u001D\u0010\f\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0081\u0088\u0004ø\u0001\u0000\u001A@\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0004\b\u0000\u0010\u000B2\u0006\u0010\u0011\u001A\u00020\u00122\u001D\u0010\f\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000B0\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0081\u0088\u0004ø\u0001\u0000\u001A\u0016\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000E\"\u0004\b\u0000\u0010\u000BH\u0081\u0080\u0004\u001A\u001E\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000E\"\u0004\b\u0000\u0010\u000B2\u0006\u0010\u0011\u001A\u00020\u0012H\u0081\u0080\u0004\u001A$\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0001\"\u0004\b\u0000\u0010\u000B2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000EH\u0081\u0080\u0004\u001A \u0010\u0016\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0087\u0088\u0004\u001A \u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\u0080\u0004\u001A(\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0087\u0080\u0004\u001A#\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001D0\b2\n\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001FH\u0081\u0088\u0004¢\u0006\u0002\u0010 \u001A5\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\n\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001F2\f\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00020\bH\u0081\u0088\u0004¢\u0006\u0002\u0010\"\u001A1\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001A\u00020\u00122\f\u0010!\u001A\b\u0012\u0004\u0012\u0002H\u00020\bH\u0080\u0080\u0004¢\u0006\u0002\u0010%\u001A3\u0010&\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001D0\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\b2\u0006\u0010\'\u001A\u00020(H\u0080\u0080\u0004¢\u0006\u0002\u0010)\u001A\u0012\u0010*\u001A\u00020\u00122\u0006\u0010+\u001A\u00020\u0012H\u0081\u0088\b\u001A\u0012\u0010,\u001A\u00020\u00122\u0006\u0010-\u001A\u00020\u0012H\u0081\u0088\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2={"listOf", "", "T", "element", "(Ljava/lang/Object;)Ljava/util/List;", "asArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildListInternal", "E", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "createListBuilder", "build", "builder", "toList", "Ljava/util/Enumeration;", "shuffled", "", "random", "Ljava/util/Random;", "collectionToArray", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "checkIndexOverflow", "index", "checkCountOverflow", "count", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt__CollectionsJVMKt {
    public CollectionsKt__CollectionsJVMKt() {
        super();
    }

    private static final ArrayList asArrayList(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new ArrayList(CollectionsKt.asCollection(arg2, true));
    }

    public static final List build(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builder");
        return ((ListBuilder)arg1).build();
    }

    private static final List buildListInternal(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        List v1 = CollectionsKt.createListBuilder(arg1);
        arg2.invoke(v1);
        return CollectionsKt.build(v1);
    }

    private static final List buildListInternal(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        List v0 = CollectionsKt.createListBuilder();
        arg1.invoke(v0);
        return CollectionsKt.build(v0);
    }

    @IgnorableReturnValue private static final int checkCountOverflow(int arg0) {
        if(arg0 < 0) {
            CollectionsKt.throwCountOverflow();
        }

        return arg0;
    }

    @IgnorableReturnValue private static final int checkIndexOverflow(int arg0) {
        if(arg0 < 0) {
            CollectionsKt.throwIndexOverflow();
        }

        return arg0;
    }

    private static final Object[] collectionToArray(Collection arg1) {
        Intrinsics.checkNotNullParameter(arg1, "collection");
        return CollectionToArray.toArray(arg1);
    }

    private static final Object[] collectionToArray(Collection arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "collection");
        Intrinsics.checkNotNullParameter(arg2, "array");
        return CollectionToArray.toArray(arg1, arg2);
    }

    public static final Object[] copyToArrayOfAny(Object[] arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg2) && (Intrinsics.areEqual(arg1.getClass(), Object[].class))) {
            return arg1;
        }

        arg1 = Arrays.copyOf(arg1, arg1.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(arg1, "copyOf(...)");
        return arg1;
    }

    public static final List createListBuilder() {
        return new ListBuilder(0, 1, null);
    }

    public static final List createListBuilder(int arg1) {
        return new ListBuilder(arg1);
    }

    public static final List listOf(Object arg1) {
        List v1 = Collections.singletonList(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "singletonList(...)");
        return v1;
    }

    public static final List shuffled(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        List v1 = CollectionsKt.toMutableList(arg1);
        Collections.shuffle(v1);
        return v1;
    }

    public static final List shuffled(Iterable arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        List v1 = CollectionsKt.toMutableList(arg1);
        Collections.shuffle(v1, arg2);
        return v1;
    }

    public static final Object[] terminateCollectionToArray(int arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        if(arg1 < arg2.length) {
            arg2[arg1] = null;
        }

        return arg2;
    }

    private static final List toList(Enumeration arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        ArrayList v1 = Collections.list(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "list(...)");
        return ((List)v1);
    }
}


package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001F\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001C\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001A.\u0010\u0000\u001A\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u0002H\u0002H\u0087\u0088\b¢\u0006\u0002\u0010\u0006\u001A/\u0010\u0007\u001A\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\tH\u0087\u0088\b\u001A/\u0010\n\u001A\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\tH\u0087\u0088\b\u001A)\u0010\u000B\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u0002H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010\r\u001A*\u0010\u000B\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000EH\u0087\u008A\u0004\u001A/\u0010\u000B\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000FH\u0087\u008A\u0004¢\u0006\u0002\u0010\u0010\u001A*\u0010\u000B\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u008A\u0004\u001A)\u0010\u0012\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u0002H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010\r\u001A*\u0010\u0012\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000EH\u0087\u008A\u0004\u001A/\u0010\u0012\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000FH\u0087\u008A\u0004¢\u0006\u0002\u0010\u0010\u001A*\u0010\u0012\u001A\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u008A\u0004\u001A*\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000EH\u0087\u0080\b\u001A*\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u0080\b\u001A1\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u000FH\u0087\u0080\b¢\u0006\u0002\u0010\u0014\u001A \u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000EH\u0080\u0080\u0004\u001A*\u0010\u0007\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000EH\u0087\u0080\b\u001A*\u0010\u0007\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u0080\b\u001A1\u0010\u0007\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u000FH\u0087\u0080\b¢\u0006\u0002\u0010\u0014\u001A*\u0010\n\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000EH\u0087\u0080\b\u001A1\u0010\n\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u000FH\u0087\u0080\b¢\u0006\u0002\u0010\u0014\u001A*\u0010\n\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u0080\b\u001A\u0017\u0010\u0016\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0004H\u0083\u0080\b¢\u0006\u0002\b\u0017\u001A.\u0010\u0007\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00182\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001AH\u0087\u0080\b\u001A.\u0010\n\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00182\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001AH\u0087\u0080\b\u001A;\u0010\u001B\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00182\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001A2\u0006\u0010\u001C\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001D\u001A\'\u0010\u0000\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0087\u0088\u0004¢\u0006\u0002\u0010!\u001A\u001F\u0010\"\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001EH\u0087\u0080\b¢\u0006\u0002\u0010#\u001A!\u0010$\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001EH\u0087\u0080\b¢\u0006\u0002\u0010#\u001A\u001F\u0010%\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001EH\u0087\u0080\b¢\u0006\u0002\u0010#\u001A!\u0010&\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001EH\u0087\u0080\b¢\u0006\u0002\u0010#\u001A.\u0010\u0007\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001E2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001AH\u0087\u0080\b\u001A.\u0010\n\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001E2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001AH\u0087\u0080\b\u001A;\u0010\u001B\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001E2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001A2\u0006\u0010\u001C\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001D¨\u0006\'"}, d2={"remove", "", "T", "Lkotlin/internal/OnlyInputTypes;", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "removeAll", "elements", "", "retainAll", "plusAssign", "", "(Ljava/util/Collection;Ljava/lang/Object;)V", "", "", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lkotlin/sequences/Sequence;", "minusAssign", "addAll", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "convertToListIfNotCollection", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "", "predicate", "Lkotlin/Function1;", "filterInPlace", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public CollectionsKt__MutableCollectionsKt() {
        super();
    }

    @IgnorableReturnValue public static final boolean addAll(Collection arg2, Iterable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "elements");
        if((arg3 instanceof Collection)) {
            return arg2.addAll(((Collection)arg3));
        }

        Iterator v3 = arg3.iterator();
        boolean v0;
        for(v0 = false; v3.hasNext(); v0 = true) {
            if(!arg2.add(v3.next())) {
                continue;
            }
        }

        return v0;
    }

    @IgnorableReturnValue public static final boolean addAll(Collection arg2, Sequence arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "elements");
        Iterator v3 = arg3.iterator();
        boolean v0;
        for(v0 = false; v3.hasNext(); v0 = true) {
            if(!arg2.add(v3.next())) {
                continue;
            }
        }

        return v0;
    }

    @IgnorableReturnValue public static final boolean addAll(Collection arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return arg1.addAll(ArraysKt.asList(arg2));
    }

    public static final Collection convertToListIfNotCollection(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof Collection)) {
            return arg1;
        }

        return CollectionsKt.toList(arg1);
    }

    private static final boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable arg2, Function1 arg3, boolean arg4) {
        Iterator v2 = arg2.iterator();
        boolean v0;
        for(v0 = false; v2.hasNext(); v0 = true) {
            if(arg3.invoke(v2.next()).booleanValue() != arg4) {
                continue;
            }

            v2.remove();
        }

        return v0;
    }

    private static final boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List arg6, Function1 arg7, boolean arg8) {
        int v3;
        if(!(arg6 instanceof RandomAccess)) {
            Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(arg6), arg7, arg8);
        }

        int v0 = CollectionsKt.getLastIndex(arg6);
        if(v0 >= 0) {
            int v2 = 0;
            v3 = 0;
            while(true) {
                Object v4 = arg6.get(v2);
                if(arg7.invoke(v4).booleanValue() == arg8) {
                }
                else {
                    if(v3 != v2) {
                        arg6.set(v3, v4);
                    }

                    ++v3;
                }

                if(v2 == v0) {
                    break;
                }

                ++v2;
            }
        }
        else {
            v3 = 0;
        }

        if(v3 < arg6.size()) {
            int v7 = CollectionsKt.getLastIndex(arg6);
            if(v3 <= v7) {
                while(true) {
                    arg6.remove(v7);
                    if(v7 != v3) {
                        --v7;
                        continue;
                    }

                    return 1;
                }
            }

            return 1;
        }

        return 0;
    }

    private static final void minusAssign(Collection arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        CollectionsKt.removeAll(arg1, arg2);
    }

    private static final void minusAssign(Collection arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.remove(arg2);
    }

    private static final void minusAssign(Collection arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        CollectionsKt.removeAll(arg1, arg2);
    }

    private static final void minusAssign(Collection arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        CollectionsKt.removeAll(arg1, arg2);
    }

    private static final void plusAssign(Collection arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        CollectionsKt.addAll(arg1, arg2);
    }

    private static final void plusAssign(Collection arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.add(arg2);
    }

    private static final void plusAssign(Collection arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        CollectionsKt.addAll(arg1, arg2);
    }

    private static final void plusAssign(Collection arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        CollectionsKt.addAll(arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use removeAt(index) instead.", replaceWith="<_subannotation>") private static final Object remove(List arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.remove(arg2);
    }

    @IgnorableReturnValue private static final boolean remove(Collection arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return TypeIntrinsics.asMutableCollection(arg1).remove(arg2);
    }

    @IgnorableReturnValue public static final boolean removeAll(Iterable arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(arg1, arg2, true);
    }

    @IgnorableReturnValue public static final boolean removeAll(Collection arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return arg1.removeAll(CollectionsKt.convertToListIfNotCollection(arg2));
    }

    @IgnorableReturnValue private static final boolean removeAll(Collection arg1, Collection arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return TypeIntrinsics.asMutableCollection(arg1).removeAll(arg2);
    }

    @IgnorableReturnValue public static final boolean removeAll(Collection arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        List v2 = SequencesKt.toList(arg2);
        if(!((Collection)v2).isEmpty() && (arg1.removeAll(((Collection)v2)))) {
            return 1;
        }

        return 0;
    }

    @IgnorableReturnValue public static final boolean removeAll(Collection arg3, Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "elements");
        int v0 = arg4.length == 0 ? 1 : 0;
        if(v0 == 0 && (arg3.removeAll(ArraysKt.asList(arg4)))) {
            return 1;
        }

        return 0;
    }

    @IgnorableReturnValue public static final boolean removeAll(List arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(arg1, arg2, true);
    }

    @IgnorableReturnValue public static final Object removeFirst(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.isEmpty()) {
            return arg1.remove(0);
        }

        throw new NoSuchElementException("List is empty.");
    }

    @IgnorableReturnValue public static final Object removeFirstOrNull(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return arg1.remove(0);
    }

    @IgnorableReturnValue public static final Object removeLast(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.isEmpty()) {
            return arg1.remove(CollectionsKt.getLastIndex(arg1));
        }

        throw new NoSuchElementException("List is empty.");
    }

    @IgnorableReturnValue public static final Object removeLastOrNull(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return arg1.remove(CollectionsKt.getLastIndex(arg1));
    }

    @IgnorableReturnValue public static final boolean retainAll(Iterable arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(arg1, arg2, false);
    }

    @IgnorableReturnValue public static final boolean retainAll(Collection arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return arg1.retainAll(CollectionsKt.convertToListIfNotCollection(arg2));
    }

    @IgnorableReturnValue private static final boolean retainAll(Collection arg1, Collection arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return TypeIntrinsics.asMutableCollection(arg1).retainAll(arg2);
    }

    @IgnorableReturnValue public static final boolean retainAll(Collection arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        List v2 = SequencesKt.toList(arg2);
        if(!((Collection)v2).isEmpty()) {
            return arg1.retainAll(((Collection)v2));
        }

        return CollectionsKt__MutableCollectionsKt.retainNothing$CollectionsKt__MutableCollectionsKt(arg1);
    }

    @IgnorableReturnValue public static final boolean retainAll(Collection arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        int v0 = arg2.length == 0 ? 1 : 0;
        if(v0 == 0) {
            return arg1.retainAll(ArraysKt.asList(arg2));
        }

        return CollectionsKt__MutableCollectionsKt.retainNothing$CollectionsKt__MutableCollectionsKt(arg1);
    }

    @IgnorableReturnValue public static final boolean retainAll(List arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(arg1, arg2, false);
    }

    @IgnorableReturnValue private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection arg1) {
        int v0 = arg1.isEmpty() ^ 1;
        arg1.clear();
        return ((boolean)v0);
    }
}


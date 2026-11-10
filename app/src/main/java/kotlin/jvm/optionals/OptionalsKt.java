package kotlin.jvm.optionals;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u00002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A%\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0004\u001A.\u0010\u0005\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00010\u00032\u0006\u0010\u0006\u001A\u0002H\u0001H\u0087\u0080\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001AD\u0010\b\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00010\u00032\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00010\tH\u0087\u0088\u0004ø\u0001\u0001ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\n\u001A=\u0010\u000B\u001A\u0002H\f\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\r*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u000E\u001A\u0002H\fH\u0087\u0080\b¢\u0006\u0002\u0010\u000F\u001A&\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004\u001A&\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0013\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004\u001A&\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004\u0082\u0002\u000B\n\u0002\b9\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2={"getOrNull", "T", "", "Ljava/util/Optional;", "(Ljava/util/Optional;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toCollection", "C", "", "destination", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "toList", "", "toSet", "", "asSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk8"}, k=2, mv={2, 3, 0}, xi=0x30) public final class OptionalsKt {
    public static final Sequence asSequence(Optional arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isPresent()) {
            return SequencesKt.sequenceOf(arg1.get());
        }

        return SequencesKt.emptySequence();
    }

    public static final Object getOrDefault(Optional arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isPresent()) {
            return arg1.get();
        }

        return arg2;
    }

    public static final Object getOrElse(Optional arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if(arg1.isPresent()) {
            return arg1.get();
        }

        return arg2.invoke();
    }

    public static final Object getOrNull(Optional arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.orElse(null);
    }

    @IgnorableReturnValue public static final Collection toCollection(Optional arg1, Collection arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        if(arg1.isPresent()) {
            Object v1 = arg1.get();
            Intrinsics.checkNotNullExpressionValue(v1, "get(...)");
            arg2.add(v1);
        }

        return arg2;
    }

    public static final List toList(Optional arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isPresent()) {
            return CollectionsKt.listOf(arg1.get());
        }

        return CollectionsKt.emptyList();
    }

    public static final Set toSet(Optional arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isPresent()) {
            return SetsKt.setOf(arg1.get());
        }

        return SetsKt.emptySet();
    }
}


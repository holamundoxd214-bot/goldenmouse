package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u001C\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001A/\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0088\u0004ø\u0001\u0000\u001A \u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\u0080\u0004\u001A/\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\t\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\n\u001A#\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000B\u001A\u0002H\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\f\u001A\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001A\"\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004\u001A4\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0010\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0087\u0080\u0004\u001A&\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001H\u0086\u0080\u0004\u001A+\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00120\u0001H\u0087\u0080\u0004¢\u0006\u0002\b\u0013\u001AE\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00050\u0015H\u0082\u0080\u0004¢\u0006\u0002\b\u0016\u001AD\u0010\u0017\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00190\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00140\u00180\u0001H\u0086\u0080\u0004\u001A \u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0080\u0004\u001A(\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001B\u001A\u00020\u001CH\u0087\u0080\u0004\u001Ad\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001E\"\u0004\b\u0002\u0010\u00142\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010 \u001A\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001E0!2\u0018\u0010\u0003\u001A\u0014\u0012\u0004\u0012\u0002H\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00050\u0015H\u0080\u0080\u0004\u001A \u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001A*\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\u000E\u0010&\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\u0086\u0080\u0004\u001A?\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\b\u0010\'\u001A\u0004\u0018\u0001H\u00022\u0014\u0010&\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0015H\u0087\u0080\u0004¢\u0006\u0002\u0010(\u001A@\u0010$\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\u000E\u0010)\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010&\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0015H\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "asSequence", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "element", "(Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "emptySequence", "orEmpty", "ifEmpty", "defaultValue", "flatten", "", "flattenSequenceOfIterable", "R", "Lkotlin/Function1;", "flatten$SequencesKt__SequencesKt", "unzip", "Lkotlin/Pair;", "", "shuffled", "random", "Lkotlin/random/Random;", "flatMapIndexed", "C", "source", "transform", "Lkotlin/Function2;", "", "constrainOnce", "generateSequence", "", "nextFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seedFunction", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/sequences/SequencesKt") class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    public static Object $r8$lambda$8HblPkoO8vE-XEU8raYk3YnY_qE(Function0 arg0, Object arg1) {
        return SequencesKt__SequencesKt.generateSequence$lambda$0$SequencesKt__SequencesKt(arg0, arg1);
    }

    public static Object $r8$lambda$cseudtdU4zbCeV6Mg-lp-bs1JX0(Object arg0) {
        return SequencesKt__SequencesKt.flatten$lambda$2$SequencesKt__SequencesKt(arg0);
    }

    public static Object $r8$lambda$eiRiKARCOo2Ht_MuMlAffn7d6hs(Object arg0) {
        return SequencesKt__SequencesKt.generateSequence$lambda$1$SequencesKt__SequencesKt(arg0);
    }

    public static Iterator $r8$lambda$hPordbPC5Xw5w6MUApwugbNlZ1I(Sequence arg0) {
        return SequencesKt__SequencesKt.flatten$lambda$0$SequencesKt__SequencesKt(arg0);
    }

    public static Iterator $r8$lambda$nt0hwWaA4ppGj455MJPoEqIa3SU(Iterable arg0) {
        return SequencesKt__SequencesKt.flatten$lambda$1$SequencesKt__SequencesKt(arg0);
    }

    public SequencesKt__SequencesKt() {
        super();
    }

    private static final Sequence Sequence(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "iterator");
        return new SequencesKt__SequencesKt$Sequence$1(arg1);
    }

    public static final Sequence asSequence(Iterator arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(arg1));
    }

    public static final Sequence constrainOnce(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof ConstrainedOnceSequence)) {
            return arg1;
        }

        return new ConstrainedOnceSequence(arg1);
    }

    public static final Sequence emptySequence() {
        return EmptySequence.INSTANCE;
    }

    public static final Sequence flatMapIndexed(Sequence arg2, Function2 arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        Intrinsics.checkNotNullParameter(arg4, "iterator");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$flatMapIndexed$1(arg2, arg3, arg4, null));
    }

    public static final Sequence flatten(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt__SequencesKt.flatten$SequencesKt__SequencesKt(arg1, new SequencesKt__SequencesKt$$ExternalSyntheticLambda2());
    }

    private static final Sequence flatten$SequencesKt__SequencesKt(Sequence arg2, Function1 arg3) {
        if((arg2 instanceof TransformingSequence)) {
            return ((TransformingSequence)arg2).flatten$kotlin_stdlib(arg3);
        }

        return new FlatteningSequence(arg2, new SequencesKt__SequencesKt$$ExternalSyntheticLambda4(), arg3);
    }

    private static final Iterator flatten$lambda$0$SequencesKt__SequencesKt(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.iterator();
    }

    private static final Iterator flatten$lambda$1$SequencesKt__SequencesKt(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.iterator();
    }

    private static final Object flatten$lambda$2$SequencesKt__SequencesKt(Object arg0) {
        return arg0;
    }

    public static final Sequence flattenSequenceOfIterable(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt__SequencesKt.flatten$SequencesKt__SequencesKt(arg1, new SequencesKt__SequencesKt$$ExternalSyntheticLambda3());
    }

    public static final Sequence generateSequence(Object arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "nextFunction");
        if(arg2 == null) {
            return EmptySequence.INSTANCE;
        }

        return new GeneratorSequence(new SequencesKt__SequencesKt$$ExternalSyntheticLambda0(arg2), arg3);
    }

    public static final Sequence generateSequence(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "nextFunction");
        return SequencesKt.constrainOnce(new GeneratorSequence(arg2, new SequencesKt__SequencesKt$$ExternalSyntheticLambda1(arg2)));
    }

    public static final Sequence generateSequence(Function0 arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "seedFunction");
        Intrinsics.checkNotNullParameter(arg2, "nextFunction");
        return new GeneratorSequence(arg1, arg2);
    }

    private static final Object generateSequence$lambda$0$SequencesKt__SequencesKt(Function0 arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg1.invoke();
    }

    private static final Object generateSequence$lambda$1$SequencesKt__SequencesKt(Object arg0) {
        return arg0;
    }

    public static final Sequence ifEmpty(Sequence arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$ifEmpty$1(arg2, arg3, null));
    }

    private static final Sequence orEmpty(Sequence arg0) {
        if(arg0 == null) {
            arg0 = SequencesKt.emptySequence();
        }

        return arg0;
    }

    private static final Sequence sequenceOf() {
        return SequencesKt.emptySequence();
    }

    public static final Sequence sequenceOf(Object arg1) {
        return new SequencesKt__SequencesKt$sequenceOf$$inlined$Sequence$1(arg1);
    }

    public static final Sequence sequenceOf(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        return ArraysKt.asSequence(arg1);
    }

    public static final Sequence shuffled(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.shuffled(arg1, Random.Default);
    }

    public static final Sequence shuffled(Sequence arg2, Random arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "random");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$shuffled$1(arg2, arg3, null));
    }

    public static final Pair unzip(Sequence arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        ArrayList v0 = new ArrayList();
        ArrayList v1 = new ArrayList();
        Iterator v4 = arg4.iterator();
        while(v4.hasNext()) {
            Object v2 = v4.next();
            v0.add(((Pair)v2).getFirst());
            v1.add(((Pair)v2).getSecond());
        }

        return TuplesKt.to(v0, v1);
    }
}


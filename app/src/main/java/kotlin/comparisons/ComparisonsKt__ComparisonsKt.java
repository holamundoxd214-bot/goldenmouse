package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u001A]\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\u0006\u0010\u0004\u001A\u0002H\u000226\u0010\u0005\u001A\u001C\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\t\u001AI\u0010\n\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\u0006\u0010\u0004\u001A\u0002H\u00022 \u0010\u0005\u001A\u001C\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006H\u0082\u0080\u0004¢\u0006\u0004\b\u000B\u0010\t\u001AB\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\u0006\u0010\u0004\u001A\u0002H\u00022\u0018\u0010\f\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\r\u001A^\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000E2\u0006\u0010\u0003\u001A\u0002H\u00022\u0006\u0010\u0004\u001A\u0002H\u00022\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000E0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000E`\u00112\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000E0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001A1\u0010\u0013\u001A\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0003\u001A\u0004\u0018\u0001H\u00022\b\u0010\u0004\u001A\u0004\u0018\u0001H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A]\u0010\u0015\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u000226\u0010\u0005\u001A\u001C\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0016\u001AD\u0010\u0015\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u00022\u001A\b\u0004\u0010\f\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001A`\u0010\u0015\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000E2\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000E0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000E`\u00112\u0014\b\u0004\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000E0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001AD\u0010\u0019\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u00022\u001A\b\u0004\u0010\f\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001A`\u0010\u0019\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000E2\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000E0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000E`\u00112\u0014\b\u0004\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000E0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001AX\u0010\u001A\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001A\b\u0004\u0010\f\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001At\u0010\u001A\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000E*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000E0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000E`\u00112\u0014\b\u0004\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000E0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001B\u001AX\u0010\u001C\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001A\b\u0004\u0010\f\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001At\u0010\u001C\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000E*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000E0\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u000E`\u00112\u0014\b\u0004\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000E0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001B\u001Av\u0010\u001D\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u001128\b\u0004\u0010\u001E\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00010\u001FH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\"\u001AU\u0010#\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011H\u0086\u0084\u0004¢\u0006\u0002\u0010$\u001AU\u0010%\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u00112\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011H\u0086\u0084\u0004¢\u0006\u0002\u0010$\u001AI\u0010&\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\b\b\u0000\u0010\u0002*\u00020\'2\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011H\u0086\u0080\u0004¢\u0006\u0002\u0010(\u001A3\u0010&\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0088\u0004¢\u0006\u0002\u0010)\u001AI\u0010*\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\b\b\u0000\u0010\u0002*\u00020\'2\u001A\u0010\u000F\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0011H\u0086\u0080\u0004¢\u0006\u0002\u0010(\u001A3\u0010*\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0010j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0011\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0088\u0004¢\u0006\u0002\u0010)\u001A/\u0010+\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0080\u0004¢\u0006\u0002\u0010)\u001A/\u0010,\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0080\u0004¢\u0006\u0002\u0010)\u001A9\u0010-\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0010j\b\u0012\u0004\u0012\u0002H\u0002`\u0011H\u0086\u0080\u0004¢\u0006\u0002\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2={"compareValuesBy", "", "T", "a", "b", "selectors", "", "Lkotlin/Function1;", "", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "selector", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "K", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareBy", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "compareByDescending", "thenBy", "(Ljava/util/Comparator;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function2;)Ljava/util/Comparator;", "then", "(Ljava/util/Comparator;Ljava/util/Comparator;)Ljava/util/Comparator;", "thenDescending", "nullsFirst", "", "(Ljava/util/Comparator;)Ljava/util/Comparator;", "()Ljava/util/Comparator;", "nullsLast", "naturalOrder", "reverseOrder", "reversed", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/comparisons/ComparisonsKt") class ComparisonsKt__ComparisonsKt {
    public static int $r8$lambda$-MbX4z8CFx5TpRwNxE9nSXf5OwI(Comparator arg0, Object arg1, Object arg2) {
        return ComparisonsKt__ComparisonsKt.nullsFirst$lambda$0$ComparisonsKt__ComparisonsKt(arg0, arg1, arg2);
    }

    public static int $r8$lambda$1mcY3I3psryq10EiJDhzZ3FmDqQ(Comparator arg0, Comparator arg1, Object arg2, Object arg3) {
        return ComparisonsKt__ComparisonsKt.thenDescending$lambda$0$ComparisonsKt__ComparisonsKt(arg0, arg1, arg2, arg3);
    }

    public static int $r8$lambda$32O0jCX-4SgDnV0fJ9Osa-rSqVE(Comparator arg0, Comparator arg1, Object arg2, Object arg3) {
        return ComparisonsKt__ComparisonsKt.then$lambda$0$ComparisonsKt__ComparisonsKt(arg0, arg1, arg2, arg3);
    }

    public static int $r8$lambda$W8AWSBCuy65sMGWfMo6pJ3RDjRw(Function1[] arg0, Object arg1, Object arg2) {
        return ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt(arg0, arg1, arg2);
    }

    public static int $r8$lambda$YRWd_6HkL2oB1v97rx6oiJ1kPMk(Comparator arg0, Object arg1, Object arg2) {
        return ComparisonsKt__ComparisonsKt.nullsLast$lambda$0$ComparisonsKt__ComparisonsKt(arg0, arg1, arg2);
    }

    public ComparisonsKt__ComparisonsKt() {
        super();
    }

    private static final Comparator compareBy(Comparator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "comparator");
        Intrinsics.checkNotNullParameter(arg2, "selector");
        return new ComparisonsKt__ComparisonsKt$compareBy$3(arg1, arg2);
    }

    private static final Comparator compareBy(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareBy$2(arg1);
    }

    public static final Comparator compareBy(Function1[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "selectors");
        if(arg1.length > 0) {
            return new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda3(arg1);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] arg0, Object arg1, Object arg2) {
        return ComparisonsKt__ComparisonsKt.compareValuesByImpl$ComparisonsKt__ComparisonsKt(arg1, arg2, arg0);
    }

    private static final Comparator compareByDescending(Comparator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "comparator");
        Intrinsics.checkNotNullParameter(arg2, "selector");
        return new ComparisonsKt__ComparisonsKt$compareByDescending$2(arg1, arg2);
    }

    private static final Comparator compareByDescending(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareByDescending$1(arg1);
    }

    public static final int compareValues(Comparable arg0, Comparable arg1) {
        if(arg0 == arg1) {
            return 0;
        }

        if(arg0 == null) {
            return -1;
        }

        if(arg1 == null) {
            return 1;
        }

        return arg0.compareTo(arg1);
    }

    private static final int compareValuesBy(Object arg1, Object arg2, Comparator arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "comparator");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        return arg3.compare(arg4.invoke(arg1), arg4.invoke(arg2));
    }

    private static final int compareValuesBy(Object arg1, Object arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "selector");
        return ComparisonsKt.compareValues(arg3.invoke(arg1), arg3.invoke(arg2));
    }

    public static final int compareValuesBy(Object arg1, Object arg2, Function1[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "selectors");
        if(arg3.length > 0) {
            return ComparisonsKt__ComparisonsKt.compareValuesByImpl$ComparisonsKt__ComparisonsKt(arg1, arg2, arg3);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final int compareValuesByImpl$ComparisonsKt__ComparisonsKt(Object arg5, Object arg6, Function1[] arg7) {
        int v0 = arg7.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            int v3 = ComparisonsKt.compareValues(arg7[v2].invoke(arg5), arg7[v2].invoke(arg6));
            if(v3 != 0) {
                return v3;
            }
        }

        return 0;
    }

    public static final Comparator naturalOrder() {
        NaturalOrderComparator v0 = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>");
        return ((Comparator)v0);
    }

    private static final Comparator nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    public static final Comparator nullsFirst(Comparator arg1) {
        Intrinsics.checkNotNullParameter(arg1, "comparator");
        return new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda4(arg1);
    }

    private static final int nullsFirst$lambda$0$ComparisonsKt__ComparisonsKt(Comparator arg0, Object arg1, Object arg2) {
        if(arg1 == arg2) {
            return 0;
        }

        if(arg1 == null) {
            return -1;
        }

        if(arg2 == null) {
            return 1;
        }

        return arg0.compare(arg1, arg2);
    }

    private static final Comparator nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }

    public static final Comparator nullsLast(Comparator arg1) {
        Intrinsics.checkNotNullParameter(arg1, "comparator");
        return new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0(arg1);
    }

    private static final int nullsLast$lambda$0$ComparisonsKt__ComparisonsKt(Comparator arg0, Object arg1, Object arg2) {
        if(arg1 == arg2) {
            return 0;
        }

        if(arg1 == null) {
            return 1;
        }

        if(arg2 == null) {
            return -1;
        }

        return arg0.compare(arg1, arg2);
    }

    public static final Comparator reverseOrder() {
        ReverseOrderComparator v0 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>");
        return ((Comparator)v0);
    }

    public static final Comparator reversed(Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if((arg2 instanceof ReversedComparator)) {
            return ((ReversedComparator)arg2).getComparator();
        }

        String v1 = "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>";
        if(Intrinsics.areEqual(arg2, NaturalOrderComparator.INSTANCE)) {
            ReverseOrderComparator v2 = ReverseOrderComparator.INSTANCE;
            Intrinsics.checkNotNull(v2, v1);
            return ((Comparator)v2);
        }

        if(Intrinsics.areEqual(arg2, ReverseOrderComparator.INSTANCE)) {
            NaturalOrderComparator v2_1 = NaturalOrderComparator.INSTANCE;
            Intrinsics.checkNotNull(v2_1, v1);
            return ((Comparator)v2_1);
        }

        return new ReversedComparator(arg2);
    }

    public static final Comparator then(Comparator arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda2(arg1, arg2);
    }

    private static final int then$lambda$0$ComparisonsKt__ComparisonsKt(Comparator arg0, Comparator arg1, Object arg2, Object arg3) {
        int v0 = arg0.compare(arg2, arg3);
        if(v0 != 0) {
            return v0;
        }

        return arg1.compare(arg2, arg3);
    }

    private static final Comparator thenBy(Comparator arg1, Comparator arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        return new ComparisonsKt__ComparisonsKt$thenBy$2(arg1, arg2, arg3);
    }

    private static final Comparator thenBy(Comparator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "selector");
        return new ComparisonsKt__ComparisonsKt$thenBy$1(arg1, arg2);
    }

    private static final Comparator thenByDescending(Comparator arg1, Comparator arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        return new ComparisonsKt__ComparisonsKt$thenByDescending$2(arg1, arg2, arg3);
    }

    private static final Comparator thenByDescending(Comparator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "selector");
        return new ComparisonsKt__ComparisonsKt$thenByDescending$1(arg1, arg2);
    }

    private static final Comparator thenComparator(Comparator arg1, Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparison");
        return new ComparisonsKt__ComparisonsKt$thenComparator$1(arg1, arg2);
    }

    public static final Comparator thenDescending(Comparator arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda1(arg1, arg2);
    }

    private static final int thenDescending$lambda$0$ComparisonsKt__ComparisonsKt(Comparator arg0, Comparator arg1, Object arg2, Object arg3) {
        int v0 = arg0.compare(arg2, arg3);
        if(v0 != 0) {
            return v0;
        }

        return arg1.compare(arg3, arg2);
    }
}


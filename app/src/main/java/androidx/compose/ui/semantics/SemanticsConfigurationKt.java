package androidx.compose.ui.semantics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A%\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"getOrNull", "T", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "key", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsConfigurationKt {
    public static final Object getOrNull(SemanticsConfiguration arg1, SemanticsPropertyKey arg2) {
        return arg1.getOrElseNullable(arg2, SemanticsConfigurationKt$getOrNull$1.INSTANCE);
    }
}


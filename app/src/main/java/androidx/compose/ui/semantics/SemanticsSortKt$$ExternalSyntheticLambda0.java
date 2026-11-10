package androidx.compose.ui.semantics;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

public final class SemanticsSortKt$$ExternalSyntheticLambda0 implements Comparator {
    public SemanticsSortKt$$ExternalSyntheticLambda0(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final int compare(Object arg1, Object arg2) {
        return SemanticsSortKt.sortByGeometryGroupings$lambda$1(this.f$0, arg1, arg2);
    }
}


package androidx.compose.foundation.text.selection;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

public final class SelectionRegistrarImpl$$ExternalSyntheticLambda3 implements Comparator {
    public SelectionRegistrarImpl$$ExternalSyntheticLambda3(Function2 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final int compare(Object arg1, Object arg2) {
        return SelectionRegistrarImpl.sort$lambda$1(this.f$0, arg1, arg2);
    }
}


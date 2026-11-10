package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.functions.Function3;

public final class EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda4 implements Function3 {
    public EnterAlwaysSearchBarScrollBehavior$$ExternalSyntheticLambda4(EnterAlwaysSearchBarScrollBehavior arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2, Object arg3) {
        return EnterAlwaysSearchBarScrollBehavior.searchBarScrollBehavior$lambda$2(this.f$0, ((MeasureScope)arg1), ((Measurable)arg2), ((Constraints)arg3));
    }
}


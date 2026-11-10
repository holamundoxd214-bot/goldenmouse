package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda0(Function0 arg1, int arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange$lambda$1(this.f$0, this.f$1, ((Composer)arg2), ((Integer)arg3).intValue());
    }
}


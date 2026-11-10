package androidx.compose.material3;

import android.view.View;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda2 implements Function2 {
    public ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda2(View arg1, Density arg2, Function0 arg3, int arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg7, Object arg8) {
        return ExposedDropdownMenu_androidKt.SoftKeyboardListener$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, arg7, ((Integer)arg8).intValue());
    }
}


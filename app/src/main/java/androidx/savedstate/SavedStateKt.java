package androidx.savedstate;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"androidx/savedstate/SavedStateKt__SavedStateKt", "androidx/savedstate/SavedStateKt__SavedState_androidKt"}, k=4, mv={2, 0, 0}, xi=0x30) public final class SavedStateKt {
    public static final Object read(Bundle arg0, Function1 arg1) {
        return SavedStateKt__SavedStateKt.read(arg0, arg1);
    }

    public static final Bundle savedState(Bundle arg0, Function1 arg1) {
        return SavedStateKt__SavedState_androidKt.savedState(arg0, arg1);
    }

    public static final Bundle savedState(Map arg0, Function1 arg1) {
        return SavedStateKt__SavedState_androidKt.savedState(arg0, arg1);
    }

    public static Bundle savedState$default(Bundle arg0, Function1 arg1, int arg2, Object arg3) {
        return SavedStateKt__SavedState_androidKt.savedState$default(arg0, arg1, arg2, arg3);
    }

    public static Bundle savedState$default(Map arg0, Function1 arg1, int arg2, Object arg3) {
        return SavedStateKt__SavedState_androidKt.savedState$default(arg0, arg1, arg2, arg3);
    }

    public static final Object write(Bundle arg0, Function1 arg1) {
        return SavedStateKt__SavedStateKt.write(arg0, arg1);
    }
}


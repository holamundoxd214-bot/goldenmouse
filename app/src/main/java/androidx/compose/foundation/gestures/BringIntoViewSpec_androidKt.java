package androidx.compose.foundation.gestures;

import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"\"\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u001A\u0010\u0007\u001A\u00020\u0002X\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\b\u0010\u0004\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"LocalBringIntoViewSpec", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getLocalBringIntoViewSpec$annotations", "()V", "getLocalBringIntoViewSpec", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "PivotBringIntoViewSpec", "getPivotBringIntoViewSpec$annotations", "getPivotBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BringIntoViewSpec_androidKt {
    private static final ProvidableCompositionLocal LocalBringIntoViewSpec;
    private static final BringIntoViewSpec PivotBringIntoViewSpec;

    static {
        BringIntoViewSpec_androidKt.LocalBringIntoViewSpec = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new BringIntoViewSpec_androidKt$$ExternalSyntheticLambda0());
        BringIntoViewSpec_androidKt.PivotBringIntoViewSpec = new BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1();
    }

    static final BringIntoViewSpec LocalBringIntoViewSpec$lambda$0(CompositionLocalAccessorScope arg1) {
        if(!arg1.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext()).getPackageManager().hasSystemFeature("android.software.leanback")) {
            return BringIntoViewSpec.Companion.getDefaultBringIntoViewSpec$foundation();
        }

        return BringIntoViewSpec_androidKt.PivotBringIntoViewSpec;
    }

    public static final ProvidableCompositionLocal getLocalBringIntoViewSpec() {
        return BringIntoViewSpec_androidKt.LocalBringIntoViewSpec;
    }

    public static void getLocalBringIntoViewSpec$annotations() {
    }

    public static final BringIntoViewSpec getPivotBringIntoViewSpec() {
        return BringIntoViewSpec_androidKt.PivotBringIntoViewSpec;
    }

    public static void getPivotBringIntoViewSpec$annotations() {
    }
}


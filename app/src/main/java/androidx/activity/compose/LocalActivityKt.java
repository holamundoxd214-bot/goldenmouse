package androidx.activity.compose;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalActivity", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/app/Activity;", "getLocalActivity", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "activity-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LocalActivityKt {
    private static final ProvidableCompositionLocal LocalActivity;

    static {
        LocalActivityKt.LocalActivity = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new LocalActivityKt$$ExternalSyntheticLambda0());
    }

    static final Activity LocalActivity$lambda$0(CompositionLocalAccessorScope arg1) {
        Context v1_1;
        Object v1 = arg1.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext());
        while(true) {
            if(!(v1 instanceof ContextWrapper)) {
                break;
            }
            else if((v1 instanceof Activity)) {
            }
            else {
                v1_1 = ((ContextWrapper)v1_1).getBaseContext();
                continue;
            }

            goto label_10;
        }

        Activity v1_2 = null;
    label_10:
        return ((Activity)v1_1);
    }

    public static final ProvidableCompositionLocal getLocalActivity() {
        return LocalActivityKt.LocalActivity;
    }
}


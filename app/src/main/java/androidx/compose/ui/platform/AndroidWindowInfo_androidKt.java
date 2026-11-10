package androidx.compose.ui.platform;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.view.View;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0002¨\u0006\u0007"}, d2={"calculateWindowSize", "Landroidx/compose/ui/platform/DerivedSize;", "view", "Landroid/view/View;", "tryUnwrapContext", "Landroid/content/Context;", "context", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidWindowInfo_androidKt {
    public static final DerivedSize calculateWindowSize(View arg8) {
        Context v8 = arg8.getContext();
        Context v0 = AndroidWindowInfo_androidKt.tryUnwrapContext(v8);
        if(v0 != null) {
            WindowMetrics v8_1 = WindowMetricsCalculator.Companion.getOrCreate().computeCurrentWindowMetrics(v0);
            return DerivedSize.Companion.fromPxSize-viCIZxY(IntSize.constructor-impl((((long)v8_1.getBounds().width())) << 0x20 | (((long)v8_1.getBounds().height())) & 0xFFFFFFFFL), AndroidDensity_androidKt.Density(v0));
        }

        Configuration v0_1 = v8.getResources().getConfiguration();
        return DerivedSize.Companion.fromDpSize-itqla9I(DpKt.DpSize-YgX7TsA(Dp.constructor-impl(((float)v0_1.screenWidthDp)), Dp.constructor-impl(((float)v0_1.screenHeightDp))), AndroidDensity_androidKt.Density(v8));
    }

    private static final Context tryUnwrapContext(Context arg2) {
        Context v1;
        while(true) {
            v1 = null;
            if(!(arg2 instanceof ContextWrapper)) {
                return v1;
            }

            if((arg2 instanceof Activity)) {
            }
            else if((arg2 instanceof InputMethodService)) {
            }
            else {
                if((arg2 instanceof Application)) {
                    return arg2;
                }

                goto label_12;
            }

            return arg2;
        label_12:
            if(((ContextWrapper)arg2).getBaseContext() == null) {
                return v1;
            }

            arg2 = ((ContextWrapper)arg2).getBaseContext();
        }

        return v1;
    }
}


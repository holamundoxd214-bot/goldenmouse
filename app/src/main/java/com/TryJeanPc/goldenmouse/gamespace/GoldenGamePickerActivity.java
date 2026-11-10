package com.TryJeanPc.goldenmouse.gamespace;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.TryJeanPc.goldenmouse.AddGameScreenKt;
import com.TryJeanPc.goldenmouse.ui.theme.ThemeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u0005H\u0016J\b\u0010\r\u001A\u00020\bH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenGamePickerActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "saving", "", "finishAfterSave", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "hideSystemBars", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenGamePickerActivity extends ComponentActivity {
    public static final int $stable = 8;
    private boolean finishAfterSave;
    private boolean saving;

    static {
    }

    public GoldenGamePickerActivity() {
        super();
    }

    public static final boolean access$getFinishAfterSave$p(GoldenGamePickerActivity arg0) {
        return arg0.finishAfterSave;
    }

    public static final void access$setSaving$p(GoldenGamePickerActivity arg0, boolean arg1) {
        arg0.saving = arg1;
    }

    private final void hideSystemBars() {
        WindowInsetsControllerCompat v1 = WindowCompat.getInsetsController(this.getWindow(), this.getWindow().getDecorView());
        v1.setSystemBarsBehavior(2);
        v1.hide(Type.systemBars());
    }

    protected void onCreate(Bundle arg9) {
        super.onCreate(arg9);
        GoldenGamePickerActivity v9 = this;
        SystemBarStyle v0 = null;
        int v1 = 3;
        EdgeToEdge.enable$default(((ComponentActivity)v9), v0, v0, v1, v0);
        if(Build$VERSION.SDK_INT >= 28) {
            Window v2 = this.getWindow();
            WindowManager$LayoutParams v3 = this.getWindow().getAttributes();
            if(Build$VERSION.SDK_INT >= 30) {
            }
            else {
                v1 = 1;
            }

            v3.layoutInDisplayCutoutMode = v1;
            v2.setAttributes(v3);
        }

        this.hideSystemBars();
        MutableState v1_1 = SnapshotStateKt.mutableStateOf$default(v0, ((SnapshotMutationPolicy)v0), 2, v0);
        ComponentActivityKt.setContent$default(((ComponentActivity)v9), ((CompositionContext)v0), ComposableLambdaKt.composableLambdaInstance(-903371045, true, new GoldenGamePickerActivity$$ExternalSyntheticLambda3(v1_1, this)), 1, v0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GoldenGamePickerActivity$onCreate$3(v1_1, this, ((Continuation)v0)), 3, null);
    }

    static final Unit onCreate$lambda$6(MutableState arg6, GoldenGamePickerActivity arg7, Composer arg8, int arg9) {
        ComposerKt.sourceInformation(arg8, "C40@1713L1101,40@1693L1121:GoldenGamePickerActivity.kt#lw4xdv");
        boolean v0 = (arg9 & 3) != 2 ? true : false;
        if(arg8.shouldExecute(v0, arg9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903371045, arg9, -1, "com.TryJeanPc.goldenmouse.gamespace.GoldenGamePickerActivity.onCreate.<anonymous> (GoldenGamePickerActivity.kt:40)");
            }

            ThemeKt.GoldenMouseProTheme(false, false, ComposableLambdaKt.rememberComposableLambda(0xDCF24750, true, new GoldenGamePickerActivity$$ExternalSyntheticLambda2(arg6, arg7), arg8, 54), arg8, 0x180, 3);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_36;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_36:
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$6$lambda$5(MutableState arg12, GoldenGamePickerActivity arg13, Composer arg14, int arg15) {
        GoldenGamePickerActivity$$ExternalSyntheticLambda0 v0_3;
        List v0_2;
        ComposerKt.sourceInformation(arg14, "C46@2002L697,61@2730L52,42@1775L1025:GoldenGamePickerActivity.kt#lw4xdv");
        boolean v0 = (arg15 & 3) != 2 ? true : false;
        if(arg14.shouldExecute(v0, arg15 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xDCF24750, arg15, -1, "com.TryJeanPc.goldenmouse.gamespace.GoldenGamePickerActivity.onCreate.<anonymous>.<anonymous> (GoldenGamePickerActivity.kt:41)");
            }

            Object v12 = arg12.getValue();
            Object v15 = null;
            Object v0_1 = v12 != null ? ((Pair)v12).getFirst() : v15;
            if(v0_1 == null) {
                v0_2 = CollectionsKt.emptyList();
            }

            Object v4 = v0_2;
            if(v12 != null) {
                v15 = ((Pair)v12).getSecond();
            }

            if(v15 == null) {
                List v15_1 = CollectionsKt.emptyList();
            }

            Object v5 = v15;
            boolean v8 = v12 == null ? true : false;
            String v15_2 = "CC(remember):GoldenGamePickerActivity.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg14, 0x697DDA29, v15_2);
            boolean v12_1 = arg14.changedInstance(arg13);
            v0_1 = arg14.rememberedValue();
            if((v12_1) || v0_1 == Composer.Companion.getEmpty()) {
                v0_3 = new GoldenGamePickerActivity$$ExternalSyntheticLambda0(arg13);
                arg14.updateRememberedValue(v0_3);
            }

            Object v6 = v0_3;
            ComposerKt.sourceInformationMarkerEnd(arg14);
            ComposerKt.sourceInformationMarkerStart(arg14, 1769878180, v15_2);
            v12_1 = arg14.changedInstance(arg13);
            v15 = arg14.rememberedValue();
            if((v12_1) || v15 == Composer.Companion.getEmpty()) {
                GoldenGamePickerActivity$$ExternalSyntheticLambda1 v15_3 = new GoldenGamePickerActivity$$ExternalSyntheticLambda1(arg13);
                arg14.updateRememberedValue(v15_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg14);
            AddGameScreenKt.AddGameScreen(((List)v4), ((List)v5), ((Function2)v6), v15, v8, arg14, 0, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_74;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg14.skipToGroupEnd();
        }

    label_74:
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$6$lambda$5$lambda$2$lambda$1(GoldenGamePickerActivity arg7, List arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg8, "games");
        Intrinsics.checkNotNullParameter(arg9, "done");
        if(arg7.saving) {
            arg9.invoke(Boolean.valueOf(false));
        }
        else {
            arg7.saving = true;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(arg7), null, null, new GoldenGamePickerActivity$onCreate$2$1$1$1$1(arg7, arg9, arg8, null), 3, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$6$lambda$5$lambda$4$lambda$3(GoldenGamePickerActivity arg1) {
        if(arg1.saving) {
            arg1.finishAfterSave = true;
        }
        else {
            arg1.finish();
        }

        return Unit.INSTANCE;
    }

    public void onWindowFocusChanged(boolean arg1) {
        super.onWindowFocusChanged(arg1);
        if(arg1) {
            this.hideSystemBars();
        }
    }
}


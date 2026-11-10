package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001AM\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ActivityResultRegistryKt {
    public static void $r8$lambda$3CvmGOvkwZLY6ksF4ULs20ma2UE(State arg0, Object arg1) {
        ActivityResultRegistryKt.rememberLauncherForActivityResult$lambda$4$0$0(arg0, arg1);
    }

    public static DisposableEffectResult $r8$lambda$YAfMonS2ROkWVWyfbsXWPpLpnb0(ActivityResultLauncherHolder arg0, ActivityResultRegistry arg1, String arg2, ActivityResultContract arg3, State arg4, DisposableEffectScope arg5) {
        return ActivityResultRegistryKt.rememberLauncherForActivityResult$lambda$4$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static String $r8$lambda$gcIK6Em3026em-cFeXEknnn_tB4() {
        return ActivityResultRegistryKt.rememberLauncherForActivityResult$lambda$0$0();
    }

    public static final ManagedActivityResultLauncher rememberLauncherForActivityResult(ActivityResultContract arg10, Function1 arg11, Composer arg12, int arg13) {
        ActivityResultRegistry v2;
        ManagedActivityResultLauncher v8_1;
        ActivityResultLauncherHolder v7_1;
        ActivityResultRegistryKt$$ExternalSyntheticLambda0 v3_1;
        int v1 = 0xAC0BEC09;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(rememberLauncherForActivityResult)N(contract,onResult)84@3542L30,85@3599L30,89@3785L32,89@3768L49,92@3906L7,96@4089L46,97@4163L73,101@4419L176,101@4363L232:ActivityResultRegistry.kt#q1dkbc");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.activity.compose.rememberLauncherForActivityResult (ActivityResultRegistry.kt:82)");
        }

        State v0 = SnapshotStateKt.rememberUpdatedState(arg10, arg12, arg13 & 14);
        State v5 = SnapshotStateKt.rememberUpdatedState(arg11, arg12, arg13 >> 3 & 14);
        Object[] v1_1 = new Object[0];
        String v4 = "CC(remember):ActivityResultRegistry.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg12, -658420919, v4);
        Object v3 = arg12.rememberedValue();
        if(v3 == Composer.Companion.getEmpty()) {
            v3_1 = new ActivityResultRegistryKt$$ExternalSyntheticLambda0();
            arg12.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        Object v1_2 = RememberSaveableKt.rememberSaveable(v1_1, ((Function0)v3_1), arg12, 0x30);
        ActivityResultRegistryOwner v3_2 = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(arg12, 6);
        if(v3_2 != null) {
            ActivityResultRegistry v3_3 = v3_2.getActivityResultRegistry();
            ComposerKt.sourceInformationMarkerStart(arg12, 0xD8C17157, v4);
            Object v7 = arg12.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                v7_1 = new ActivityResultLauncherHolder();
                arg12.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            ComposerKt.sourceInformationMarkerStart(arg12, -658408782, v4);
            Object v8 = arg12.rememberedValue();
            if(v8 == Composer.Companion.getEmpty()) {
                v8_1 = new ManagedActivityResultLauncher(v7_1, v0);
                arg12.updateRememberedValue(v8_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            ComposerKt.sourceInformationMarkerStart(arg12, -658400487, v4);
            int v0_1 = arg12.changedInstance(v7_1) | arg12.changedInstance(v3_3) | arg12.changed(v1_2) | arg12.changedInstance(arg10) | arg12.changed(v5);
            Object v4_1 = arg12.rememberedValue();
            if(v0_1 != 0 || v4_1 == Composer.Companion.getEmpty()) {
                v2 = v3_3;
                ActivityResultRegistryKt$$ExternalSyntheticLambda1 v0_2 = new ActivityResultRegistryKt$$ExternalSyntheticLambda1(v7_1, v2, v1_2, arg10, v5);
                v1_2 = v1_2;
                arg12.updateRememberedValue(v0_2);
                ActivityResultRegistryKt$$ExternalSyntheticLambda1 v4_2 = v0_2;
            }
            else {
                v2 = v3_3;
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            EffectsKt.DisposableEffect(v2, v1_2, arg10, v4_1, arg12, arg13 << 6 & 0x380);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            return v8_1;
        }

        throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
    }

    private static final String rememberLauncherForActivityResult$lambda$0$0() {
        return UUID.randomUUID().toString();
    }

    private static final DisposableEffectResult rememberLauncherForActivityResult$lambda$4$0(ActivityResultLauncherHolder arg0, ActivityResultRegistry arg1, String arg2, ActivityResultContract arg3, State arg4, DisposableEffectScope arg5) {
        arg0.setLauncher(arg1.register(arg2, arg3, new ActivityResultRegistryKt$$ExternalSyntheticLambda2(arg4)));
        return new ActivityResultRegistryKt$rememberLauncherForActivityResult$lambda$4$0$$inlined$onDispose$1(arg0);
    }

    private static final void rememberLauncherForActivityResult$lambda$4$0$0(State arg0, Object arg1) {
        arg0.getValue().invoke(arg1);
    }
}


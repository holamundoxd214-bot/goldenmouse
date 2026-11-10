package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001Am\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032*\u0010\u0006\u001A&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\b\b\u0002\u0010\f\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"AddGameScreen", "", "installedApps", "", "Lcom/TryJeanPc/goldenmouse/GameInfo;", "selectedGames", "onSelectionChange", "Lkotlin/Function2;", "Lkotlin/Function1;", "", "onBack", "Lkotlin/Function0;", "loading", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class AddGameScreenKt {
    public static final void AddGameScreen(List arg16, List arg17, Function2 arg18, Function0 arg19, boolean arg20, Composer arg21, int arg22, int arg23) {
        boolean v5_2;
        AddGameScreenKt$$ExternalSyntheticLambda1 v0_3;
        AddGameScreenKt$$ExternalSyntheticLambda0 v0_2;
        boolean v12;
        int v7;
        int v5;
        List v1 = arg16;
        List v2 = arg17;
        Function2 v3 = arg18;
        Function0 v4 = arg19;
        int v6 = arg22;
        Intrinsics.checkNotNullParameter(v1, "installedApps");
        Intrinsics.checkNotNullParameter(v2, "selectedGames");
        Intrinsics.checkNotNullParameter(v3, "onSelectionChange");
        Intrinsics.checkNotNullParameter(v4, "onBack");
        int v0 = -1901936285;
        Composer v10 = arg21.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(AddGameScreen)N(installedApps,selectedGames,onSelectionChange,onBack,loading)33@1087L28,36@1194L136,39@1349L174,34@1120L409:AddGameScreen.kt#ax6bx3");
        if((v6 & 6) == 0) {
            v5 = v10.changedInstance(v1) ? 4 : 2;
            v5 |= v6;
        }
        else {
            v5 = v6;
        }

        if((v6 & 0x30) == 0) {
            v7 = v10.changedInstance(v2) ? 0x20 : 16;
            v5 |= v7;
        }

        int v8 = 0x100;
        if((v6 & 0x180) == 0) {
            v7 = v10.changedInstance(v3) ? v8 : 0x80;
            v5 |= v7;
        }

        int v9 = 0x800;
        if((v6 & 0xC00) == 0) {
            v7 = v10.changedInstance(v4) ? v9 : 0x400;
            v5 |= v7;
        }

        v7 = arg23 & 16;
        if(v7 != 0) {
            v5 |= 0x6000;
            goto label_68;
        }
        else if((v6 & 0x6000) == 0) {
            v12 = arg20;
            int v13 = v10.changed(v12) ? 0x4000 : 0x2000;
            v5 |= v13;
        }
        else {
        label_68:
            v12 = arg20;
        }

        int v15 = 0;
        boolean v13_1 = (v5 & 9363) != 9362 ? true : false;
        if(v10.shouldExecute(v13_1, v5 & 1)) {
            if(v7 != 0) {
                v12 = false;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v5, -1, "com.TryJeanPc.goldenmouse.AddGameScreen (AddGameScreen.kt:32)");
            }

            BackHandlerKt.BackHandler(false, v4, v10, v5 >> 6 & 0x70, 1);
            Modifier v7_1 = SizeKt.fillMaxSize$default(Modifier.Companion, 0f, 1, null);
            String v13_2 = "CC(remember):AddGameScreen.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v10, 0x70F81F4B, v13_2);
            Object v0_1 = v10.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = new AddGameScreenKt$$ExternalSyntheticLambda0();
                v10.updateRememberedValue(v0_2);
            }

            Object v14 = v0_2;
            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerStart(v10, 0x70F832D1, v13_2);
            v0 = (v5 & 0x380) == v8 ? 1 : 0;
            v8 = (v5 & 0x1C00) == v9 ? 1 : 0;
            v0 = v0 | v8 | v10.changedInstance(v1) | v10.changedInstance(v2);
            if((v5 & 0xE000) == 0x4000) {
                v15 = 1;
            }

            Object v5_1 = v10.rememberedValue();
            if((v0 | v15) != 0 || v5_1 == Composer.Companion.getEmpty()) {
                Function2 v5_3 = v3;
                List v3_1 = v1;
                Function2 v1_1 = v5_3;
                Function0 v5_4 = v4;
                List v4_1 = v2;
                Function0 v2_1 = v5_4;
                v5_2 = v12;
                v0_3 = new AddGameScreenKt$$ExternalSyntheticLambda1(v1_1, v2_1, v3_1, v4_1, v5_2);
                v10.updateRememberedValue(v0_3);
            }
            else {
                v0_1 = v5_1;
                v5_2 = v12;
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            AndroidView_androidKt.AndroidView(v14, v7_1, v0_3, v10, 54, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_161;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v10.skipToGroupEnd();
            v5_2 = v12;
        }

    label_161:
        ScopeUpdateScope v8_1 = v10.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new AddGameScreenKt$$ExternalSyntheticLambda2(arg16, arg17, arg18, arg19, v5_2, v6, arg23));
        }
    }

    static final GoldenGamePickerView AddGameScreen$lambda$1$lambda$0(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        View v3 = LayoutInflater.from(arg3).inflate(layout.gp_rm_add_content, null, false);
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.GoldenGamePickerView");
        return ((GoldenGamePickerView)v3);
    }

    static final Unit AddGameScreen$lambda$3$lambda$2(Function2 arg1, Function0 arg2, List arg3, List arg4, boolean arg5, GoldenGamePickerView arg6) {
        Intrinsics.checkNotNullParameter(arg6, "view");
        arg6.setOnSelectionChange(arg1);
        arg6.setOnBack(arg2);
        arg6.submitApps(arg3, arg4, arg5);
        return Unit.INSTANCE;
    }

    static final Unit AddGameScreen$lambda$4(List arg8, List arg9, Function2 arg10, Function0 arg11, boolean arg12, int arg13, int arg14, Composer arg15, int arg16) {
        AddGameScreenKt.AddGameScreen(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }
}


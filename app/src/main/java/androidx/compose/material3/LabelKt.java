package androidx.compose.material3;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A^\u0010\u0000\u001A\u00020\u00012\u001C\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\u0011\u0010\r\u001A\r\u0012\u0004\u0012\u00020\u00010\u000E¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0002\u0010\u000F\u001A%\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\t\u001A\u00020\nH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2={"Label", "", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPersistent", "", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "HandleInteractions", "enabled", "state", "Landroidx/compose/material3/TooltipState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LabelKt {
    private static final void HandleInteractions(boolean arg8, TooltipState arg9, MutableInteractionSource arg10, Composer arg11, int arg12) {
        LabelKt$HandleInteractions$1$1 v2_3;
        int v2_1;
        boolean v2;
        int v1;
        int v0 = 0xDA9CCD03;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(HandleInteractions)N(enabled,state,interactionSource):Label.kt#uh7d8r");
        if((arg12 & 6) == 0) {
            v1 = arg11.changed(arg8) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        int v3 = 0x20;
        if((arg12 & 0x30) == 0) {
            v2 = (arg12 & 0x40) == 0 ? arg11.changed(arg9) : arg11.changedInstance(arg9);
            v2_1 = v2 ? v3 : 16;
            v1 |= v2_1;
        }

        int v4 = 0x100;
        if((arg12 & 0x180) == 0) {
            v2_1 = arg11.changed(arg10) ? v4 : 0x80;
            v1 |= v2_1;
        }

        int v6 = 0;
        v2 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
            }

            if(arg8) {
                arg11.startReplaceGroup(0x2D18C822);
                ComposerKt.sourceInformation(arg11, "110@4434L587,110@4400L621");
                ComposerKt.sourceInformationMarkerStart(arg11, 0xA69DB92E, "CC(remember):Label.kt#9igjgp");
                v0 = (v1 & 0x380) == v4 ? 1 : 0;
                if((v1 & 0x70) == v3 || (v1 & 0x40) != 0 && (arg11.changedInstance(arg9))) {
                    v6 = 1;
                }

                Object v2_2 = arg11.rememberedValue();
                if((v0 | v6) != 0 || v2_2 == Composer.Companion.getEmpty()) {
                    v2_3 = new LabelKt$HandleInteractions$1$1(arg10, arg9, null);
                    arg11.updateRememberedValue(v2_3);
                }

                ComposerKt.sourceInformationMarkerEnd(arg11);
                EffectsKt.LaunchedEffect(arg10, ((Function2)v2_3), arg11, v1 >> 6 & 14);
                arg11.endReplaceGroup();
            }
            else {
                arg11.startReplaceGroup(0x2D221F5F);
                arg11.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_97;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_97:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new LabelKt$$ExternalSyntheticLambda0(arg8, arg9, arg10, arg12));
        }
    }

    static final Unit HandleInteractions$lambda$7(boolean arg0, TooltipState arg1, MutableInteractionSource arg2, int arg3, Composer arg4, int arg5) {
        LabelKt.HandleInteractions(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void Label(Function3 arg21, Modifier arg22, MutableInteractionSource arg23, boolean arg24, Function2 arg25, Composer arg26, int arg27, int arg28) {
        boolean v4_3;
        MutableInteractionSource v3;
        Companion v2_1;
        MutableState v8_4;
        TooltipState v8_3;
        PopupPositionProvider v15;
        Object v8_1;
        MutableInteractionSource v14_1;
        Modifier v4_2;
        int v13;
        boolean v12;
        int v11;
        MutableInteractionSource v9;
        int v8;
        Modifier v7;
        int v2;
        Function3 v1 = arg21;
        Function2 v5 = arg25;
        int v6 = arg27;
        int v0 = 0xE4AAB008;
        Composer v10 = arg26.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(Label)N(label,modifier,interactionSource,isPersistent,content)74@3260L60,79@3521L33,80@3571L71,82@3693L103,88@3882L17,86@3802L250,95@4057L128:Label.kt#uh7d8r");
        if((arg28 & 1) != 0) {
            v2 = v6 | 6;
        }
        else if((v6 & 6) == 0) {
            v2 = v10.changedInstance(v1) ? 4 : 2;
            v2 |= v6;
        }
        else {
            v2 = v6;
        }

        int v4 = arg28 & 2;
        if(v4 != 0) {
            v2 |= 0x30;
            goto label_36;
        }
        else if((v6 & 0x30) == 0) {
            v7 = arg22;
            v8 = v10.changed(v7) ? 0x20 : 16;
            v2 |= v8;
        }
        else {
        label_36:
            v7 = arg22;
        }

        v8 = arg28 & 4;
        if(v8 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v6 & 0x180) == 0) {
            v9 = arg23;
            v11 = v10.changed(v9) ? 0x100 : 0x80;
            v2 |= v11;
        }
        else {
        label_51:
            v9 = arg23;
        }

        v11 = arg28 & 8;
        if(v11 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v6 & 0xC00) == 0) {
            v12 = arg24;
            v13 = v10.changed(v12) ? 0x800 : 0x400;
            v2 |= v13;
        }
        else {
        label_66:
            v12 = arg24;
        }

        if((arg28 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v6 & 0x6000) == 0) {
            v13 = v10.changedInstance(v5) ? 0x4000 : 0x2000;
            v2 |= v13;
        }

        boolean v13_1 = (v2 & 9363) != 9362 ? true : false;
        if(v10.shouldExecute(v13_1, v2 & 1)) {
            if(v4 != 0) {
                Companion v4_1 = Modifier.Companion;
            }
            else {
                v4_2 = v7;
            }

            DefaultConstructorMarker v13_2 = null;
            MutableInteractionSource v19 = v8 != 0 ? ((MutableInteractionSource)v13_2) : v9;
            boolean v20 = v11 != 0 ? false : v12;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.Label (Label.kt:69)");
            }

            String v0_1 = "CC(remember):Label.kt#9igjgp";
            if(v19 == null) {
                v10.startReplaceGroup(0x33203473);
                ComposerKt.sourceInformation(v10, "71@3114L39");
                ComposerKt.sourceInformationMarkerStart(v10, 0x64BEF96F, v0_1);
                Object v7_1 = v10.rememberedValue();
                if(v7_1 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v7_2 = InteractionSourceKt.MutableInteractionSource();
                    v10.updateRememberedValue(v7_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                v10.endReplaceGroup();
                Object v14 = v7_1;
            }
            else {
                v10.startReplaceGroup(0x64BEF6E4);
                v10.endReplaceGroup();
                v14_1 = v19;
            }

            PopupPositionProvider v7_3 = TooltipDefaults.INSTANCE.rememberTooltipPositionProvider-Hu5FAss(TooltipAnchorPosition.Companion.getAbove-lOKsHw4(), 0f, v10, 390, 2);
            if(v20) {
                v10.startReplaceGroup(0x3323F81D);
                ComposerKt.sourceInformation(v10, "76@3363L29");
                ComposerKt.sourceInformationMarkerStart(v10, 0x64BF1885, v0_1);
                v8_1 = v10.rememberedValue();
                if(v8_1 == Composer.Companion.getEmpty()) {
                    LabelStateImpl v8_2 = new LabelStateImpl(false, false, 3, v13_2);
                    v10.updateRememberedValue(v8_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v10);
                v10.endReplaceGroup();
                v15 = v7_3;
            }
            else {
                v10.startReplaceGroup(0x64BF1E00);
                ComposerKt.sourceInformation(v10, "77@3406L56");
                v15 = v7_3;
                v8_3 = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), v10, 0, 3);
                v10.endReplaceGroup();
            }

            Object v9_1 = v8_3;
            ObjectRef v7_4 = new ObjectRef();
            ComposerKt.sourceInformationMarkerStart(v10, 1690250313, v0_1);
            v8_1 = v10.rememberedValue();
            if(v8_1 == Composer.Companion.getEmpty()) {
                v8_4 = SnapshotStateKt.mutableStateOf$default(v13_2, ((SnapshotMutationPolicy)v13_2), 2, v13_2);
                v10.updateRememberedValue(v8_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            v7_4.element = v8_4;
            ComposerKt.sourceInformationMarkerStart(v10, 0x64BF32AF, v0_1);
            Object v0_2 = v10.rememberedValue();
            if(v0_2 == Composer.Companion.getEmpty()) {
                TooltipScopeImpl v0_3 = new TooltipScopeImpl(new LabelKt$$ExternalSyntheticLambda1(v7_4), v15);
                v10.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            BasicTooltipKt.BasicTooltipBox(v15, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new LabelKt$Label$1(v1, ((TooltipScopeImpl)v0_2)), v10, 54), ((TooltipState)v9_1), ((Companion)v4_2), null, false, false, false, ComposableLambdaKt.rememberComposableLambda(0xFD5EB976, true, new LabelKt$Label$wrappedContent$1(v7_4, v5), v10, 54), v10, v2 << 6 & 0x1C00 | 0x61B0030, 0x90);
            v10 = v10;
            LabelKt.HandleInteractions((((int)v20)) ^ 1, ((TooltipState)v9_1), v14_1, v10, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Companion)v4_2);
            v3 = v19;
            v4_3 = v20;
        }
        else {
            v10.skipToGroupEnd();
            Modifier v2_2 = v7;
            v3 = v9;
            v4_3 = v12;
        }

        ScopeUpdateScope v8_5 = v10.endRestartGroup();
        if(v8_5 != null) {
            v8_5.updateScope(new LabelKt$$ExternalSyntheticLambda2(v1, ((Modifier)v2_1), v3, v4_3, v5, v6, arg28));
        }
    }

    static final LayoutCoordinates Label$lambda$4$lambda$3(ObjectRef arg0) {
        return arg0.element.getValue();
    }

    static final Unit Label$lambda$5(Function3 arg8, Modifier arg9, MutableInteractionSource arg10, boolean arg11, Function2 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        LabelKt.Label(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }
}


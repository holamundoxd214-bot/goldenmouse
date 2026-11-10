package androidx.compose.material3;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.DragInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\u001AA\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0002\u0010\f\u001A0\u0010\r\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00010\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00010\u000FH\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001A\u00020\u0013X\u008A\u0084\u0002²\u0006\n\u0010\u0014\u001A\u00020\u0013X\u008A\u008E\u0002"}, d2={"VerticalDragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "colors", "Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DragHandleSizes;Landroidx/compose/material3/DragHandleColors;Landroidx/compose/material3/DragHandleShapes;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "pressable", "onPressed", "Lkotlin/Function0;", "onReleasedOrCancelled", "material3", "isDragged", "", "isPressed"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DragHandleKt {
    public static final void VerticalDragHandle(Modifier arg25, DragHandleSizes arg26, DragHandleColors arg27, DragHandleShapes arg28, MutableInteractionSource arg29, Composer arg30, int arg31, int arg32) {
        DragHandleSizes v2_5;
        DragHandleKt$$ExternalSyntheticLambda4 v7_5;
        DragHandleKt$$ExternalSyntheticLambda2 v8_1;
        MutableInteractionSource v7_2;
        Object v7_1;
        DragHandleSizes v4_1;
        Modifier v2_1;
        Companion v2_2;
        MutableInteractionSource v14;
        int v13;
        DragHandleShapes v11_1;
        int v11;
        DragHandleColors v9_1;
        int v9;
        DragHandleSizes v7;
        Modifier v4;
        int v5;
        int v6 = arg31;
        int v0 = 0x64F32703;
        Composer v1 = arg30.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(VerticalDragHandle)N(modifier,sizes,colors,shapes,interactionSource)81@3988L25,82@4035L34,88@4262L20,88@4284L21,89@4338L307,98@4670L796,115@5495L299,83@4074L1783:DragHandle.kt#uh7d8r");
        int v2 = arg32 & 1;
        int v3 = 2;
        if(v2 != 0) {
            v5 = v6 | 6;
            v4 = arg25;
        }
        else if((v6 & 6) == 0) {
            v4 = arg25;
            v5 = v1.changed(v4) ? 4 : v3;
            v5 |= v6;
        }
        else {
            v4 = arg25;
            v5 = v6;
        }

        if((v6 & 0x30) == 0) {
            if((arg32 & 2) == 0) {
                v7 = arg26;
                if(v1.changed(v7)) {
                    v9 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v7 = arg26;
            label_35:
                v9 = 16;
            }

            v5 |= v9;
        }
        else {
            v7 = arg26;
        }

        if((v6 & 0x180) == 0) {
            if((arg32 & 4) == 0) {
                v9_1 = arg27;
                if(v1.changed(v9_1)) {
                    v11 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v9_1 = arg27;
            label_49:
                v11 = 0x80;
            }

            v5 |= v11;
        }
        else {
            v9_1 = arg27;
        }

        if((v6 & 0xC00) == 0) {
            if((arg32 & 8) == 0) {
                v11_1 = arg28;
                if(v1.changed(v11_1)) {
                    v13 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v11_1 = arg28;
            label_63:
                v13 = 0x400;
            }

            v5 |= v13;
        }
        else {
            v11_1 = arg28;
        }

        v13 = arg32 & 16;
        if(v13 != 0) {
            v5 |= 0x6000;
            goto label_81;
        }
        else if((v6 & 0x6000) == 0) {
            v14 = arg29;
            int v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v5 |= v15;
        }
        else {
        label_81:
            v14 = arg29;
        }

        int v16 = 1;
        boolean v10 = (v5 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v10, v5 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "75@3689L8,76@3757L8");
            SnapshotMutationPolicy v15_1 = null;
            if((v6 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v4;
                }

                if((arg32 & 2) != 0) {
                    v4_1 = VerticalDragHandleDefaults.INSTANCE.sizes();
                    v5 &= 0xFFFFFF8F;
                }
                else {
                    v4_1 = v7;
                }

                int v10_1 = 6;
                if((arg32 & 4) != 0) {
                    v5 &= -897;
                    v9_1 = VerticalDragHandleDefaults.INSTANCE.colors(v1, v10_1);
                }

                if((arg32 & 8) != 0) {
                    v5 &= 0xFFFFE3FF;
                    v11_1 = VerticalDragHandleDefaults.INSTANCE.shapes(v1, v10_1);
                }

                if(v13 == 0) {
                    goto label_141;
                }

                v14 = ((MutableInteractionSource)v15_1);
            }
            else {
                v1.skipToGroupEnd();
                if((arg32 & 2) != 0) {
                    v5 &= 0xFFFFFF8F;
                }

                if((arg32 & 4) != 0) {
                    v5 &= -897;
                }

                if((arg32 & 8) != 0) {
                    v5 &= 0xFFFFE3FF;
                }

                v2_1 = v4;
                v4_1 = v7;
            }

        label_141:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v5, -1, "androidx.compose.material3.VerticalDragHandle (DragHandle.kt:78)");
            }

            String v0_1 = "CC(remember):DragHandle.kt#9igjgp";
            if(v14 == null) {
                v1.startReplaceGroup(0xA3EF1F18);
                ComposerKt.sourceInformation(v1, "80@3909L39");
                ComposerKt.sourceInformationMarkerStart(v1, 0xF4C5A62A, v0_1);
                v7_1 = v1.rememberedValue();
                if(v7_1 == Composer.Companion.getEmpty()) {
                    v7_2 = InteractionSourceKt.MutableInteractionSource();
                    v1.updateRememberedValue(v7_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v1);
                v1.endReplaceGroup();
            }
            else {
                v1.startReplaceGroup(0xF4C5A39F);
                v1.endReplaceGroup();
                v7_2 = v14;
            }

            Object v10_2 = v7_1;
            State v13_1 = DragInteractionKt.collectIsDraggedAsState(((InteractionSource)v10_2), v1, 0);
            ComposerKt.sourceInformationMarkerStart(v1, 0xF4C5B5E5, v0_1);
            Object v12 = v1.rememberedValue();
            if(v12 == Composer.Companion.getEmpty()) {
                MutableState v12_1 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), v15_1, v3, v15_1);
                v1.updateRememberedValue(v12_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            arg25 = ((Modifier)v2_2);
            Modifier v3_1 = HoverableKt.hoverable$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(((Modifier)v2_2)), ((MutableInteractionSource)v7_1), false, v3, v15_1);
            ComposerKt.sourceInformationMarkerStart(v1, 0xF4C5D237, v0_1);
            Object v2_3 = v1.rememberedValue();
            if(v2_3 == Composer.Companion.getEmpty()) {
                DragHandleKt$$ExternalSyntheticLambda1 v2_4 = new DragHandleKt$$ExternalSyntheticLambda1(((MutableState)v12));
                v1.updateRememberedValue(v2_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 0xF4C5D4F8, v0_1);
            Object v8 = v1.rememberedValue();
            if(v8 == Composer.Companion.getEmpty()) {
                v8_1 = new DragHandleKt$$ExternalSyntheticLambda2(((MutableState)v12));
                v1.updateRememberedValue(v8_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v2_1 = DragHandleKt.pressable(v3_1, ((MutableInteractionSource)v7_1), ((Function0)v2_3), ((Function0)v8_1));
            ComposerKt.sourceInformationMarkerStart(v1, 0xF4C5DCD6, v0_1);
            boolean v3_2 = v1.changed(v13_1);
            int v8_2 = 0x800;
            int v7_3 = (v5 & 0x1C00 ^ 0xC00) > v8_2 && (v1.changed(v11_1)) || (v5 & 0xC00) == v8_2 ? 1 : 0;
            v3 = (((int)v3_2)) | v7_3;
            v7_1 = v1.rememberedValue();
            if(v3 != 0 || v7_1 == Composer.Companion.getEmpty()) {
                DragHandleKt$$ExternalSyntheticLambda3 v7_4 = new DragHandleKt$$ExternalSyntheticLambda3(v11_1, v13_1, ((MutableState)v12));
                v1.updateRememberedValue(v7_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v2_1 = GraphicsLayerModifierKt.graphicsLayer(v2_1, ((Function1)v7_1));
            ComposerKt.sourceInformationMarkerStart(v1, 0xF4C6083F, v0_1);
            v3_2 = v1.changed(v13_1);
            v8_2 = 0x20;
            v7_3 = (v5 & 0x70 ^ 0x30) > v8_2 && (v1.changed(v4_1)) || (v5 & 0x30) == v8_2 ? 1 : 0;
            v3 = (((int)v3_2)) | v7_3;
            v7_1 = v1.rememberedValue();
            if(v3 != 0 || v7_1 == Composer.Companion.getEmpty()) {
                v7_5 = new DragHandleKt$$ExternalSyntheticLambda4(v4_1, v13_1, ((MutableState)v12));
                v1.updateRememberedValue(v7_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v2_1 = LayoutModifierKt.layout(v2_1, ((Function3)v7_5));
            ComposerKt.sourceInformationMarkerStart(v1, -188322450, v0_1);
            boolean v0_2 = v1.changed(v13_1);
            v7_3 = 0x100;
            if((v5 & 0x380 ^ 0x180) <= v7_3 || !v1.changed(v9_1)) {
                if((v5 & 0x180) == v7_3) {
                }
                else {
                    v16 = 0;
                }
            }

            Object v3_3 = v1.rememberedValue();
            if(((((int)v0_2)) | v16) != 0 || v3_3 == Composer.Companion.getEmpty()) {
                DragHandleKt$$ExternalSyntheticLambda5 v3_4 = new DragHandleKt$$ExternalSyntheticLambda5(v9_1, v13_1, ((MutableState)v12));
                v1.updateRememberedValue(v3_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            BoxKt.Box(IndicationKt.indication(DrawModifierKt.drawBehind(v2_1, ((Function1)v3_3)), ((InteractionSource)v10_2), RippleKt.ripple-H2RKhps$default(false, 0f, 0, 7, null)), v1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_5 = v4_1;
            v4 = arg25;
        }
        else {
            v1.skipToGroupEnd();
            v2_5 = v7;
        }

        DragHandleColors v3_5 = v9_1;
        MutableInteractionSource v5_1 = v14;
        ScopeUpdateScope v8_3 = v1.endRestartGroup();
        if(v8_3 != null) {
            v8_3.updateScope(new DragHandleKt$$ExternalSyntheticLambda6(v4, v2_5, v3_5, v11_1, v5_1, v6, arg32));
        }
    }

    private static final boolean VerticalDragHandle$lambda$1(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit VerticalDragHandle$lambda$10$lambda$9(DragHandleShapes arg0, State arg1, MutableState arg2, GraphicsLayerScope arg3) {
        Shape v0;
        if(DragHandleKt.VerticalDragHandle$lambda$1(arg1)) {
            v0 = arg0.getDraggedShape();
        }
        else if(DragHandleKt.VerticalDragHandle$lambda$3(arg2)) {
            v0 = arg0.getPressedShape();
        }
        else {
            v0 = arg0.getShape();
        }

        arg3.setShape(v0);
        arg3.setClip(true);
        return Unit.INSTANCE;
    }

    static final MeasureResult VerticalDragHandle$lambda$13$lambda$12(DragHandleSizes arg7, State arg8, MutableState arg9, MeasureScope arg10, Measurable arg11, Constraints arg12) {
        long v7;
        if(DragHandleKt.VerticalDragHandle$lambda$1(arg8)) {
            v7 = arg7.getDraggedSize-MYxV2XQ();
        }
        else if(DragHandleKt.VerticalDragHandle$lambda$3(arg9)) {
            v7 = arg7.getPressedSize-MYxV2XQ();
        }
        else {
            v7 = arg7.getSize-MYxV2XQ();
        }

        v7 = arg10.toSize-XkaWNTQ(v7);
        Placeable v7_1 = arg11.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(Math.round(Float.intBitsToFloat(((int)(v7 >> 0x20)))), Math.round(Float.intBitsToFloat(((int)(v7 & 0xFFFFFFFFL))))));
        return MeasureScope.layout$default(arg10, v7_1.getWidth(), v7_1.getHeight(), null, new DragHandleKt$$ExternalSyntheticLambda0(v7_1), 4, null);
    }

    static final Unit VerticalDragHandle$lambda$13$lambda$12$lambda$11(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDragHandle$lambda$15$lambda$14(DragHandleColors arg15, State arg16, MutableState arg17, DrawScope arg18) {
        long v0;
        if(DragHandleKt.VerticalDragHandle$lambda$1(arg16)) {
            v0 = arg15.getDraggedColor-0d7_KjU();
        }
        else if(DragHandleKt.VerticalDragHandle$lambda$3(arg17)) {
            v0 = arg15.getPressedColor-0d7_KjU();
        }
        else {
            v0 = arg15.getColor-0d7_KjU();
        }

        long v3 = v0;
        DrawScope.drawRect-n-J9OG0$default(arg18, v3, 0, 0, 0f, null, null, 0, 0x7E, null);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDragHandle$lambda$16(Modifier arg8, DragHandleSizes arg9, DragHandleColors arg10, DragHandleShapes arg11, MutableInteractionSource arg12, int arg13, int arg14, Composer arg15, int arg16) {
        DragHandleKt.VerticalDragHandle(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    private static final boolean VerticalDragHandle$lambda$3(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void VerticalDragHandle$lambda$4(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    static final Unit VerticalDragHandle$lambda$6$lambda$5(MutableState arg1) {
        DragHandleKt.VerticalDragHandle$lambda$4(arg1, true);
        return Unit.INSTANCE;
    }

    static final Unit VerticalDragHandle$lambda$8$lambda$7(MutableState arg1) {
        DragHandleKt.VerticalDragHandle$lambda$4(arg1, false);
        return Unit.INSTANCE;
    }

    private static final Modifier pressable(Modifier arg1, MutableInteractionSource arg2, Function0 arg3, Function0 arg4) {
        return SuspendingPointerInputFilterKt.pointerInput(arg1, arg2, new DragHandleKt$pressable$1(arg3, arg4));
    }
}


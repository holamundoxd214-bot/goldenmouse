package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState$NotifyImeListener;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0001\u0018\u0000 `2\u00020\u0001:\u0002_`B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010!\u001A\u00020\"2\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u000E\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020%J\u0015\u0010&\u001A\u00020\"2\u0006\u0010\'\u001A\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001A\u00020\"2\u0006\u0010,\u001A\u00020(¢\u0006\u0004\b-\u0010*J\u001D\u0010.\u001A\u00020\"2\u0006\u0010/\u001A\u0002002\u0006\u0010\'\u001A\u00020(¢\u0006\u0004\b1\u00102J\u000E\u00103\u001A\u00020\"2\u0006\u00104\u001A\u000205J\u0006\u00106\u001A\u00020\"J\u0006\u00107\u001A\u00020\"J1\u00108\u001A\u00020\"2\u0006\u00104\u001A\u0002052\u0006\u00109\u001A\u00020(2\b\b\u0002\u0010:\u001A\u00020;2\b\b\u0002\u0010<\u001A\u00020=¢\u0006\u0004\b>\u0010?J,\u0010@\u001A\u00020\"2\u0006\u00104\u001A\u0002052\b\b\u0002\u0010A\u001A\u00020=2\b\b\u0002\u0010:\u001A\u00020;2\b\b\u0002\u0010<\u001A\u00020=J\u0006\u0010B\u001A\u00020\"J\u0006\u0010C\u001A\u00020\"J\u0006\u0010D\u001A\u00020\"J\u0006\u0010E\u001A\u00020\"J,\u0010F\u001A\u00020\"2\b\b\u0002\u0010<\u001A\u00020=2\u0017\u0010G\u001A\u0013\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\"0H¢\u0006\u0002\bJH\u0086\bJ\f\u0010K\u001A\u00020\"*\u00020IH\u0002J\u0015\u0010L\u001A\u00020(2\u0006\u0010M\u001A\u00020%¢\u0006\u0004\bN\u0010OJ\u0015\u0010L\u001A\u00020(2\u0006\u00109\u001A\u00020(¢\u0006\u0004\bP\u0010QJ\u0015\u0010R\u001A\u00020(2\u0006\u0010M\u001A\u00020%¢\u0006\u0004\bS\u0010OJ\u0015\u0010R\u001A\u00020(2\u0006\u00109\u001A\u00020(¢\u0006\u0004\bT\u0010QJ\u0016\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u00020XH\u0086@¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001A\u00020=2\b\u0010[\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\\\u001A\u00020%H\u0016J\b\u0010]\u001A\u00020^H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000F\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0013R+\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u00198F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006a"}, d2={"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "outputTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "codepointTransformedText", "untransformedText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getUntransformedText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputText", "getOutputText", "visualText", "getVisualText", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "placeCursorBeforeCharAt", "transformedOffset", "", "selectCharsIn", "transformedRange", "Landroidx/compose/ui/text/TextRange;", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightCharsIn-7RAjNK8", "(IJ)V", "replaceAll", "newText", "", "selectAll", "deleteSelectedText", "replaceText", "range", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "restartImeIfContentChanges", "", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "replaceSelectedText", "clearComposition", "collapseSelectionToMax", "collapseSelectionToEnd", "undo", "redo", "editUntransformedTextAsUser", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Lkotlin/ExtensionFunctionType;", "updateWedgeAffinity", "mapToTransformed", "offset", "mapToTransformed--jx7JFs", "(I)J", "mapToTransformed-GEjPoXI", "(J)J", "mapFromTransformed", "mapFromTransformed--jx7JFs", "mapFromTransformed-GEjPoXI", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "TransformedText", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransformedTextFieldState {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0003J\"\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u000BH\u0003J+\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u00122\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u000BH\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0016\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u0012H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "<init>", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapToTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "selectionWedgeAffinity", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "mapFromTransformed", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
            static {
                int[] v0 = new int[WedgeAffinity.values().length];
                try {
                    v0[WedgeAffinity.Start.ordinal()] = 1;
                    goto label_7;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_7:
                        v0[WedgeAffinity.End.ordinal()] = 2;
                        goto label_11;
                    }
                    catch(NoSuchFieldError ) {
                    label_11:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final TransformedText access$calculateTransformedText(Companion arg0, TextFieldCharSequence arg1, OutputTransformation arg2, SelectionWedgeAffinity arg3) {
            return arg0.calculateTransformedText(arg1, arg2, arg3);
        }

        public static final TransformedText access$calculateTransformedText(Companion arg0, TextFieldCharSequence arg1, CodepointTransformation arg2, SelectionWedgeAffinity arg3) {
            return arg0.calculateTransformedText(arg1, arg2, arg3);
        }

        public static final long access$mapFromTransformed-xdX6-G0(Companion arg0, long arg1, OffsetMappingCalculator arg3) {
            return arg0.mapFromTransformed-xdX6-G0(arg1, arg3);
        }

        public static final long access$mapToTransformed-XGyztTk(Companion arg0, long arg1, OffsetMappingCalculator arg3, SelectionWedgeAffinity arg4) {
            return arg0.mapToTransformed-XGyztTk(arg1, arg3, arg4);
        }

        @JvmStatic private final TransformedText calculateTransformedText(TextFieldCharSequence arg15, OutputTransformation arg16, SelectionWedgeAffinity arg17) {
            TextRange v3_1;
            SelectionWedgeAffinity v0 = arg17;
            OffsetMappingCalculator v5 = new OffsetMappingCalculator();
            ChangeTracker v3 = null;
            TextFieldBuffer v1 = new TextFieldBuffer(arg15, v3, null, v5, 6, null);
            v1.setCanCallAddStyle$foundation(true);
            arg16.transformOutput(v1);
            v1.setCanCallAddStyle$foundation(false);
            List v11 = v1.getOutputTransformationAnnotations$foundation();
            if(v1.getChanges().getChangeCount() == 0) {
                List v2 = v11;
                if(v2 != null && !((Collection)v2).isEmpty()) {
                    goto label_25;
                }

                return ((TransformedText)v3);
            }

        label_25:
            long v7 = this.mapToTransformed-XGyztTk(arg15.getSelection-d9O1mEE(), v5, v0);
            TextRange v14 = arg15.getComposition-MzsxiRA();
            if(v14 != null) {
                v3_1 = TextRange.box-impl(TransformedTextFieldState.Companion.mapToTransformed-XGyztTk(v14.unbox-impl(), v5, v0));
            }

            return new TransformedText(TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(v1, v7, v3_1, null, v11, 4, null), v5);
        }

        @JvmStatic private final TransformedText calculateTransformedText(TextFieldCharSequence arg12, CodepointTransformation arg13, SelectionWedgeAffinity arg14) {
            OffsetMappingCalculator v0 = new OffsetMappingCalculator();
            CharSequence v2 = CodepointTransformationKt.toVisualText(arg12, arg13, v0);
            TransformedText v13 = null;
            if((((TextFieldCharSequence)v2)) == arg12) {
                return v13;
            }

            long v3 = this.mapToTransformed-XGyztTk(arg12.getSelection-d9O1mEE(), v0, arg14);
            TextRange v11 = arg12.getComposition-MzsxiRA();
            if(v11 != null) {
                TextRange v13_1 = TextRange.box-impl(TransformedTextFieldState.Companion.mapToTransformed-XGyztTk(v11.unbox-impl(), v0, arg14));
            }

            return new TransformedText(new TextFieldCharSequence(v2, v3, ((TextRange)v13), null, null, null, 56, null), v0);
        }

        @JvmStatic private final long mapFromTransformed-xdX6-G0(long arg5, OffsetMappingCalculator arg7) {
            long v0 = arg7.mapFromDest--jx7JFs(TextRange.getStart-impl(arg5));
            long v2 = TextRange.getCollapsed-impl(arg5) ? v0 : arg7.mapFromDest--jx7JFs(TextRange.getEnd-impl(arg5));
            int v4 = Math.min(TextRange.getMin-impl(v0), TextRange.getMin-impl(v2));
            int v7 = Math.max(TextRange.getMax-impl(v0), TextRange.getMax-impl(v2));
            if(TextRange.getReversed-impl(arg5)) {
                return TextRangeKt.TextRange(v7, v4);
            }

            return TextRangeKt.TextRange(v4, v7);
        }

        @JvmStatic private final long mapToTransformed-XGyztTk(long arg7, OffsetMappingCalculator arg9, SelectionWedgeAffinity arg10) {
            long v9_2;
            int v6_1;
            int v9_1;
            long v0 = arg9.mapFromSource--jx7JFs(TextRange.getStart-impl(arg7));
            long v2 = TextRange.getCollapsed-impl(arg7) ? v0 : arg9.mapFromSource--jx7JFs(TextRange.getEnd-impl(arg7));
            WedgeAffinity v6 = null;
            WedgeAffinity v9 = arg10 != null ? arg10.getStartAffinity() : v6;
            if(TextRange.getCollapsed-impl(arg7)) {
                v6 = v9;
            }
            else if(arg10 != null) {
                v6 = arg10.getEndAffinity();
            }

            int v10 = 2;
            if(v9 != null && !TextRange.getCollapsed-impl(v0)) {
                v9_1 = WhenMappings.$EnumSwitchMapping$0[v9.ordinal()];
                if(v9_1 == 1) {
                    v0 = TextRangeKt.TextRange(TextRange.getStart-impl(v0));
                }
                else if(v9_1 == v10) {
                    v0 = TextRangeKt.TextRange(TextRange.getEnd-impl(v0));
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            if(v6 != null && !TextRange.getCollapsed-impl(v2)) {
                v6_1 = WhenMappings.$EnumSwitchMapping$0[v6.ordinal()];
                if(v6_1 == 1) {
                    v9_2 = TextRangeKt.TextRange(TextRange.getStart-impl(v2));
                }
                else if(v6_1 == v10) {
                    v9_2 = TextRangeKt.TextRange(TextRange.getEnd-impl(v2));
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }

                v2 = v9_2;
            }

            v6_1 = Math.min(TextRange.getMin-impl(v0), TextRange.getMin-impl(v2));
            v9_1 = Math.max(TextRange.getMax-impl(v0), TextRange.getMax-impl(v2));
            if(TextRange.getReversed-impl(arg7)) {
                return TextRangeKt.TextRange(v9_1, v6_1);
            }

            return TextRangeKt.TextRange(v6_1, v9_1);
        }

        static long mapToTransformed-XGyztTk$default(Companion arg0, long arg1, OffsetMappingCalculator arg3, SelectionWedgeAffinity arg4, int arg5, Object arg6) {
            if((arg5 & 4) != 0) {
                arg4 = null;
            }

            return arg0.mapToTransformed-XGyztTk(arg1, arg3, arg4);
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public TransformedText(TextFieldCharSequence arg1, OffsetMappingCalculator arg2) {
            super();
            this.text = arg1;
            this.offsetMapping = arg2;
        }

        public final TextFieldCharSequence component1() {
            return this.text;
        }

        public final OffsetMappingCalculator component2() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence arg1, OffsetMappingCalculator arg2) {
            return new TransformedText(arg1, arg2);
        }

        public static TransformedText copy$default(TransformedText arg0, TextFieldCharSequence arg1, OffsetMappingCalculator arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.text;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.offsetMapping;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((TransformedText)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof TransformedText)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.text, ((TransformedText)arg5).text)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.offsetMapping, ((TransformedText)arg5).offsetMapping)) {
                return 0;
            }

            return 1;
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode() * 0x1F + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + this.text + ", offsetMapping=" + this.offsetMapping + ')';
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private final CodepointTransformation codepointTransformation;
    private final State codepointTransformedText;
    private InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    private final State outputTransformedText;
    private final MutableState selectionWedgeAffinity$delegate;
    private final TextFieldState textFieldState;

    public static TransformedText $r8$lambda$0gOvt5vGmAbtxux9b89F_pmNnXA(TransformedTextFieldState arg0, CodepointTransformation arg1) {
        return TransformedTextFieldState.codepointTransformedText$lambda$0$0(arg0, arg1);
    }

    public static TransformedText $r8$lambda$lMfolSC_2xrepVuFR8qmkwYcnjk(TransformedTextFieldState arg0, OutputTransformation arg1) {
        return TransformedTextFieldState.outputTransformedText$lambda$0$0(arg0, arg1);
    }

    static {
        TransformedTextFieldState.Companion = new Companion(null);
    }

    public TransformedTextFieldState(TextFieldState arg1, InputTransformation arg2, CodepointTransformation arg3, OutputTransformation arg4) {
        super();
        this.textFieldState = arg1;
        this.inputTransformation = arg2;
        this.codepointTransformation = arg3;
        this.outputTransformation = arg4;
        SnapshotMutationPolicy v1 = null;
        State v2 = arg4 != null ? SnapshotStateKt.derivedStateOf(new TransformedTextFieldState$$ExternalSyntheticLambda1(this, arg4)) : ((State)v1);
        this.outputTransformedText = v2;
        v2 = arg3 != null ? SnapshotStateKt.derivedStateOf(new TransformedTextFieldState$$ExternalSyntheticLambda2(this, arg3)) : ((State)v1);
        this.codepointTransformedText = v2;
        this.selectionWedgeAffinity$delegate = SnapshotStateKt.mutableStateOf$default(new SelectionWedgeAffinity(WedgeAffinity.Start), v1, 2, v1);
    }

    public TransformedTextFieldState(TextFieldState arg2, InputTransformation arg3, CodepointTransformation arg4, OutputTransformation arg5, int arg6, DefaultConstructorMarker arg7) {
        InputTransformation v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = ((CodepointTransformation)v0);
        }

        if((arg6 & 8) != 0) {
            arg5 = ((OutputTransformation)v0);
        }

        this(arg2, arg3, arg4, arg5);
    }

    public static final Companion access$getCompanion$p() {
        return TransformedTextFieldState.Companion;
    }

    public static final InputTransformation access$getInputTransformation$p(TransformedTextFieldState arg0) {
        return arg0.inputTransformation;
    }

    public static final TextFieldState access$getTextFieldState$p(TransformedTextFieldState arg0) {
        return arg0.textFieldState;
    }

    public static final void access$updateWedgeAffinity(TransformedTextFieldState arg0, TextFieldBuffer arg1) {
        arg0.updateWedgeAffinity(arg1);
    }

    @JvmStatic private static final TransformedText calculateTransformedText(TextFieldCharSequence arg1, OutputTransformation arg2, SelectionWedgeAffinity arg3) {
        return Companion.access$calculateTransformedText(TransformedTextFieldState.Companion, arg1, arg2, arg3);
    }

    @JvmStatic private static final TransformedText calculateTransformedText(TextFieldCharSequence arg1, CodepointTransformation arg2, SelectionWedgeAffinity arg3) {
        return Companion.access$calculateTransformedText(TransformedTextFieldState.Companion, arg1, arg2, arg3);
    }

    private static final TransformedText codepointTransformedText$lambda$0$0(TransformedTextFieldState arg2, CodepointTransformation arg3) {
        TextFieldCharSequence v1_2;
        Companion v0 = TransformedTextFieldState.Companion;
        State v1 = arg2.outputTransformedText;
        if(v1 != null) {
            Object v1_1 = v1.getValue();
            if(v1_1 != null) {
                v1_2 = ((TransformedText)v1_1).getText();
                if(v1_2 == null) {
                    goto label_7;
                }
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            v1_2 = arg2.textFieldState.getValue$foundation();
        }

        return Companion.access$calculateTransformedText(v0, v1_2, arg3, arg2.getSelectionWedgeAffinity());
    }

    public final void collapseSelectionToEnd() {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v7 = this.inputTransformation;
        TextFieldEditUndoBehavior v1 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v2 = v0.getMainBuffer$foundation();
        TextFieldBufferKt.setSelectionCoerced$default(v2, TextRange.getEnd-impl(v2.getSelection-d9O1mEE()), 0, 2, null);
        v0.commitEditAsUser(v7, true, v1);
    }

    public final void collapseSelectionToMax() {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v7 = this.inputTransformation;
        TextFieldEditUndoBehavior v1 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v2 = v0.getMainBuffer$foundation();
        TextFieldBufferKt.setSelectionCoerced$default(v2, TextRange.getMax-impl(v2.getSelection-d9O1mEE()), 0, 2, null);
        v0.commitEditAsUser(v7, true, v1);
    }

    public final Object collectImeNotifications(NotifyImeListener arg5, Continuation arg6) {
        TransformedTextFieldState$$ExternalSyntheticLambda0 v5;
        TransformedTextFieldState$collectImeNotifications$1 v0_1;
        int v2;
        if((arg6 instanceof TransformedTextFieldState$collectImeNotifications$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((TransformedTextFieldState$collectImeNotifications$1)v0).label & v2) != 0) {
                ((TransformedTextFieldState$collectImeNotifications$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TransformedTextFieldState$collectImeNotifications$1(this, arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            if(this.outputTransformation != null) {
                v5 = new TransformedTextFieldState$$ExternalSyntheticLambda0(arg5, this);
            }

            v0_1.L$0 = v5;
            v0_1.label = 1;
            CancellableContinuationImpl v6_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(((Continuation)v0_1)), 1);
            v6_1.initCancellability();
            this.textFieldState.addNotifyImeListener$foundation(((NotifyImeListener)v5));
            v6_1.invokeOnCancellation(new TransformedTextFieldState$collectImeNotifications$2$1(this, ((NotifyImeListener)v5)));
            Object v4 = v6_1.getResult();
            if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(((Continuation)v0_1));
            }

            if(v4 != v1) {
                goto label_50;
            }

            return v1;
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v6);
        }

    label_50:
        throw new KotlinNothingValueException();
    }

    static final void collectImeNotifications$lambda$0(NotifyImeListener arg2, TransformedTextFieldState arg3, TextFieldCharSequence arg4, TextFieldCharSequence arg5, boolean arg6) {
        TransformedText v5 = Companion.access$calculateTransformedText(TransformedTextFieldState.Companion, arg4, arg3.outputTransformation, arg3.getSelectionWedgeAffinity());
        if(v5 != null) {
            arg5 = v5.getText();
            if(arg5 != null) {
                arg4 = arg5;
            }
        }

        arg2.onChange(arg4, arg3.getVisualText(), arg6);
    }

    public final void deleteSelectedText() {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v1 = this.inputTransformation;
        TextFieldEditUndoBehavior v2 = TextFieldEditUndoBehavior.NeverMerge;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v3 = v0.getMainBuffer$foundation();
        TextFieldBufferKt.delete(v3, TextRange.getMin-impl(v3.getSelection-d9O1mEE()), TextRange.getMax-impl(v3.getSelection-d9O1mEE()));
        TextFieldBufferKt.setSelectionCoerced$default(v3, TextRange.getMin-impl(v3.getSelection-d9O1mEE()), 0, 2, null);
        this.updateWedgeAffinity(v3);
        v0.commitEditAsUser(v1, true, v2);
    }

    public final void editUntransformedTextAsUser(boolean arg5, Function1 arg6) {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v1 = this.inputTransformation;
        TextFieldEditUndoBehavior v2 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v3 = v0.getMainBuffer$foundation();
        arg6.invoke(v3);
        this.updateWedgeAffinity(v3);
        v0.commitEditAsUser(v1, arg5, v2);
    }

    public static void editUntransformedTextAsUser$default(TransformedTextFieldState arg2, boolean arg3, Function1 arg4, int arg5, Object arg6) {
        TextFieldState v5 = arg2.textFieldState;
        InputTransformation v6 = arg2.inputTransformation;
        TextFieldEditUndoBehavior v0 = TextFieldEditUndoBehavior.MergeIfPossible;
        v5.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v1 = v5.getMainBuffer$foundation();
        arg4.invoke(v1);
        arg2.updateWedgeAffinity(v1);
        v5.commitEditAsUser(v6, true, v0);
    }

    public boolean equals(Object arg4) {
        if(this == (((TransformedTextFieldState)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof TransformedTextFieldState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textFieldState, ((TransformedTextFieldState)arg4).textFieldState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.codepointTransformation, ((TransformedTextFieldState)arg4).codepointTransformation)) {
            return 0;
        }

        return Intrinsics.areEqual(this.outputTransformation, ((TransformedTextFieldState)arg4).outputTransformation);
    }

    public final TextFieldCharSequence getOutputText() {
        State v0 = this.outputTransformedText;
        if(v0 != null) {
            Object v0_1 = v0.getValue();
            if(v0_1 != null) {
                TextFieldCharSequence v0_2 = ((TransformedText)v0_1).getText();
                if(v0_2 == null) {
                }
                else {
                    return v0_2;
                }
            }
        }

        return this.getUntransformedText();
    }

    public final SelectionWedgeAffinity getSelectionWedgeAffinity() {
        return this.selectionWedgeAffinity$delegate.getValue();
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation();
    }

    public final TextFieldCharSequence getVisualText() {
        State v0 = this.codepointTransformedText;
        if(v0 != null) {
            Object v0_1 = v0.getValue();
            if(v0_1 != null) {
                TextFieldCharSequence v0_2 = ((TransformedText)v0_1).getText();
                if(v0_2 == null) {
                }
                else {
                    return v0_2;
                }
            }
        }

        return this.getOutputText();
    }

    public int hashCode() {
        int v0 = this.textFieldState.hashCode() * 0x1F;
        CodepointTransformation v1 = this.codepointTransformation;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        OutputTransformation v3 = this.outputTransformation;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public final void highlightCharsIn-7RAjNK8(int arg5, long arg6) {
        arg6 = this.mapFromTransformed-GEjPoXI(arg6);
        TextFieldState v0 = this.textFieldState;
        InputTransformation v4 = this.inputTransformation;
        TextFieldEditUndoBehavior v1 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        v0.getMainBuffer$foundation().setHighlight-K7f2yys$foundation(arg5, TextRange.getStart-impl(arg6), TextRange.getEnd-impl(arg6));
        v0.commitEditAsUser(v4, true, v1);
    }

    public final long mapFromTransformed--jx7JFs(int arg3) {
        OffsetMappingCalculator v0_2;
        State v0 = this.outputTransformedText;
        OffsetMappingCalculator v1 = null;
        if(v0 != null) {
            Object v0_1 = v0.getValue();
            if(v0_1 != null) {
                v0_2 = ((TransformedText)v0_1).getOffsetMapping();
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            v0_2 = v1;
        }

        State v2 = this.codepointTransformedText;
        if(v2 != null) {
            Object v2_1 = v2.getValue();
            if(v2_1 != null) {
                v1 = ((TransformedText)v2_1).getOffsetMapping();
            }
        }

        long v2_2 = v1 != null ? v1.mapFromDest--jx7JFs(arg3) : TextRangeKt.TextRange(arg3);
        if(v0_2 != null) {
            v2_2 = Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, v2_2, v0_2);
        }

        return v2_2;
    }

    public final long mapFromTransformed-GEjPoXI(long arg3) {
        OffsetMappingCalculator v0_2;
        State v0 = this.outputTransformedText;
        OffsetMappingCalculator v1 = null;
        if(v0 != null) {
            Object v0_1 = v0.getValue();
            if(v0_1 != null) {
                v0_2 = ((TransformedText)v0_1).getOffsetMapping();
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            v0_2 = v1;
        }

        State v2 = this.codepointTransformedText;
        if(v2 != null) {
            Object v2_1 = v2.getValue();
            if(v2_1 != null) {
                v1 = ((TransformedText)v2_1).getOffsetMapping();
            }
        }

        if(v1 != null) {
            arg3 = Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, arg3, v1);
        }

        if(v0_2 != null) {
            return Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, arg3, v0_2);
        }

        return arg3;
    }

    @JvmStatic private static final long mapFromTransformed-xdX6-G0(long arg1, OffsetMappingCalculator arg3) {
        return Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, arg1, arg3);
    }

    public final long mapToTransformed--jx7JFs(int arg5) {
        OffsetMappingCalculator v0_2;
        State v0 = this.outputTransformedText;
        OffsetMappingCalculator v1 = null;
        if(v0 != null) {
            Object v0_1 = v0.getValue();
            if(v0_1 != null) {
                v0_2 = ((TransformedText)v0_1).getOffsetMapping();
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            v0_2 = v1;
        }

        State v2 = this.codepointTransformedText;
        if(v2 != null) {
            Object v2_1 = v2.getValue();
            if(v2_1 != null) {
                v1 = ((TransformedText)v2_1).getOffsetMapping();
            }
        }

        long v2_2 = v0_2 != null ? v0_2.mapFromSource--jx7JFs(arg5) : TextRangeKt.TextRange(arg5);
        if(v1 != null) {
            return Companion.access$mapToTransformed-XGyztTk(TransformedTextFieldState.Companion, v2_2, v1, this.getSelectionWedgeAffinity());
        }

        return v2_2;
    }

    public final long mapToTransformed-GEjPoXI(long arg10) {
        OffsetMappingCalculator v5;
        Object v0_1;
        State v0 = this.outputTransformedText;
        OffsetMappingCalculator v1 = null;
        if(v0 != null) {
            v0_1 = v0.getValue();
            if(v0_1 != null) {
                v5 = ((TransformedText)v0_1).getOffsetMapping();
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v5 = v1;
        }

        v0 = this.codepointTransformedText;
        if(v0 != null) {
            v0_1 = v0.getValue();
            if(v0_1 != null) {
                v1 = ((TransformedText)v0_1).getOffsetMapping();
            }
        }

        if(v5 != null) {
            arg10 = Companion.mapToTransformed-XGyztTk$default(TransformedTextFieldState.Companion, arg10, v5, null, 4, null);
        }

        if(v1 != null) {
            return Companion.access$mapToTransformed-XGyztTk(TransformedTextFieldState.Companion, arg10, v1, this.getSelectionWedgeAffinity());
        }

        return arg10;
    }

    @JvmStatic private static final long mapToTransformed-XGyztTk(long arg1, OffsetMappingCalculator arg3, SelectionWedgeAffinity arg4) {
        return Companion.access$mapToTransformed-XGyztTk(TransformedTextFieldState.Companion, arg1, arg3, arg4);
    }

    private static final TransformedText outputTransformedText$lambda$0$0(TransformedTextFieldState arg2, OutputTransformation arg3) {
        return Companion.access$calculateTransformedText(TransformedTextFieldState.Companion, arg2.textFieldState.getValue$foundation(), arg3, arg2.getSelectionWedgeAffinity());
    }

    public final void placeCursorBeforeCharAt(int arg3) {
        this.selectCharsIn-5zc-tL8(TextRangeKt.TextRange(arg3));
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public final void replaceAll(CharSequence arg7) {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v1 = this.inputTransformation;
        TextFieldEditUndoBehavior v2 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v3 = v0.getMainBuffer$foundation();
        TextFieldBufferKt.delete(v3, 0, v3.getLength());
        v3.append(arg7.toString());
        this.updateWedgeAffinity(v3);
        v0.commitEditAsUser(v1, true, v2);
    }

    public final void replaceSelectedText(CharSequence arg7, boolean arg8, TextFieldEditUndoBehavior arg9, boolean arg10) {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v1 = this.inputTransformation;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v2 = v0.getMainBuffer$foundation();
        if(arg8) {
            v2.commitComposition$foundation();
        }

        long v3 = v2.getSelection-d9O1mEE();
        v2.replace(TextRange.getMin-impl(v3), TextRange.getMax-impl(v3), arg7);
        TextFieldBufferKt.setSelectionCoerced$default(v2, TextRange.getMin-impl(v3) + arg7.length(), 0, 2, null);
        this.updateWedgeAffinity(v2);
        v0.commitEditAsUser(v1, arg10, arg9);
    }

    public static void replaceSelectedText$default(TransformedTextFieldState arg0, CharSequence arg1, boolean arg2, TextFieldEditUndoBehavior arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = TextFieldEditUndoBehavior.MergeIfPossible;
        }

        arg0.replaceSelectedText(arg1, false, arg3, true);
    }

    public final void replaceText-M8tDOmk(CharSequence arg6, long arg7, TextFieldEditUndoBehavior arg9, boolean arg10) {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v1 = this.inputTransformation;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v2 = v0.getMainBuffer$foundation();
        arg7 = this.mapFromTransformed-GEjPoXI(arg7);
        v2.replace(TextRange.getMin-impl(arg7), TextRange.getMax-impl(arg7), arg6);
        TextFieldBufferKt.setSelectionCoerced$default(v2, TextRange.getMin-impl(arg7) + arg6.length(), 0, 2, null);
        this.updateWedgeAffinity(v2);
        v0.commitEditAsUser(v1, arg10, arg9);
    }

    public static void replaceText-M8tDOmk$default(TransformedTextFieldState arg6, CharSequence arg7, long arg8, TextFieldEditUndoBehavior arg10, boolean arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg10 = TextFieldEditUndoBehavior.MergeIfPossible;
        }

        arg6.replaceText-M8tDOmk(arg7, arg8, arg10, true);
    }

    public final void selectAll() {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v5 = this.inputTransformation;
        TextFieldEditUndoBehavior v1 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v2 = v0.getMainBuffer$foundation();
        TextFieldBufferKt.setSelectionCoerced(v2, 0, v2.getLength());
        v0.commitEditAsUser(v5, true, v1);
    }

    public final void selectCharsIn-5zc-tL8(long arg1) {
        this.selectUntransformedCharsIn-5zc-tL8(this.mapFromTransformed-GEjPoXI(arg1));
    }

    public final void selectUntransformedCharsIn-5zc-tL8(long arg5) {
        TextFieldState v0 = this.textFieldState;
        InputTransformation v4 = this.inputTransformation;
        TextFieldEditUndoBehavior v1 = TextFieldEditUndoBehavior.MergeIfPossible;
        v0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBufferKt.setSelectionCoerced(v0.getMainBuffer$foundation(), TextRange.getStart-impl(arg5), TextRange.getEnd-impl(arg5));
        v0.commitEditAsUser(v4, true, v1);
    }

    public final void setSelectionWedgeAffinity(SelectionWedgeAffinity arg1) {
        this.selectionWedgeAffinity$delegate.setValue(arg1);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", outputTransformation=" + this.outputTransformation + ", outputTransformedText=" + this.outputTransformedText + ", codepointTransformation=" + this.codepointTransformation + ", codepointTransformedText=" + this.codepointTransformedText + ", outputText=\"" + this.getOutputText() + "\", visualText=\"" + this.getVisualText() + "\")";
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void update(InputTransformation arg1) {
        this.inputTransformation = arg1;
    }

    private final void updateWedgeAffinity(TextFieldBuffer arg3) {
        if(arg3.getChangeTracker$foundation().getChangeCount() > 0 && (TextRange.getCollapsed-impl(arg3.getSelection-d9O1mEE()))) {
            this.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
        }
    }
}


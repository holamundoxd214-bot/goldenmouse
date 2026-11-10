package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequesterNode;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004Bg\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u00126\u0010\r\u001A2\u0012\u0004\u0012\u00020\u000F\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000E¢\u0006\u0002\b\u0016\u0012\u0006\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001AJf\u0010#\u001A\u00020\u00152\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f26\u0010\r\u001A2\u0012\u0004\u0012\u00020\u000F\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000E¢\u0006\u0002\b\u00162\u0006\u0010\u0017\u001A\u00020\u0018J\u0010\u0010$\u001A\u00020\u00152\u0006\u0010%\u001A\u00020&H\u0016J#\u0010\'\u001A\u00020(*\u00020)2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-H\u0016¢\u0006\u0004\b.\u0010/R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020 \u0018\u00010\u001EX\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"¨\u00060"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldTextLayoutModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "", "Lkotlin/ExtensionFunctionType;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/KeyboardOptions;)V", "bringIntoViewRequesterNode", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getBaselineCache$annotations", "()V", "updateNode", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldTextLayoutModifierNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Map baselineCache;
    private final BringIntoViewRequesterNode bringIntoViewRequesterNode;
    private boolean singleLine;
    private TextLayoutState textLayoutState;

    static {
    }

    public TextFieldTextLayoutModifierNode(TextLayoutState arg7, TransformedTextFieldState arg8, TextStyle arg9, boolean arg10, Function2 arg11, KeyboardOptions arg12) {
        super();
        this.textLayoutState = arg7;
        this.singleLine = arg10;
        this.bringIntoViewRequesterNode = this.delegate(new BringIntoViewRequesterNode(this.textLayoutState.getBringIntoViewRequester()));
        this.textLayoutState.setOnTextLayout(arg11);
        this.textLayoutState.updateNonMeasureInputs(arg8, arg9, this.singleLine, this.singleLine ^ 1, arg12);
    }

    private static void getBaselineCache$annotations() {
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg10, Measurable arg11, long arg12) {
        LinkedHashMap v13_2;
        TextLayoutResult v12 = this.textLayoutState.layoutWithNewMeasureInputs--hBUhpc(arg10, arg10.getLayoutDirection(), CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFontFamilyResolver()), arg12);
        int v2 = 0x20;
        long v5 = 0xFFFFFFFFL;
        Placeable v11 = arg11.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(((int)(v12.getSize-YbymL2g() >> v2)), ((int)(v12.getSize-YbymL2g() >> v2)), ((int)(v12.getSize-YbymL2g() & v5)), ((int)(v12.getSize-YbymL2g() & v5))));
        TextLayoutState v13 = this.textLayoutState;
        float v0 = this.singleLine ? arg10.toDp-u2uoSUM(TextDelegateKt.ceilToIntPx(v12.getLineBottom(0))) : Dp.constructor-impl(0f);
        v13.setMinHeightForSingleLineField-0680j_4(v0);
        Map v13_1 = this.baselineCache;
        if(v13_1 == null) {
            v13_2 = new LinkedHashMap(2);
        }

        ((Map)v13_2).put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(v12.getFirstBaseline())));
        ((Map)v13_2).put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(v12.getLastBaseline())));
        this.baselineCache = ((Map)v13_2);
        int v13_3 = ((int)(v12.getSize-YbymL2g() >> v2));
        int v12_1 = ((int)(v12.getSize-YbymL2g() & v5));
        Map v9 = this.baselineCache;
        Intrinsics.checkNotNull(v9);
        return arg10.layout(v13_3, v12_1, v9, new TextFieldTextLayoutModifierNode$$ExternalSyntheticLambda0(v11));
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public void onGloballyPositioned(LayoutCoordinates arg1) {
        this.textLayoutState.setTextLayoutNodeCoordinates(arg1);
    }

    public final void updateNode(TextLayoutState arg8, TransformedTextFieldState arg9, TextStyle arg10, boolean arg11, Function2 arg12, KeyboardOptions arg13) {
        TextLayoutState v0 = this.textLayoutState;
        this.textLayoutState = arg8;
        arg8.setOnTextLayout(arg12);
        this.singleLine = arg11;
        this.textLayoutState.updateNonMeasureInputs(arg9, arg10, arg11, (((int)arg11)) ^ 1, arg13);
        if(!Intrinsics.areEqual(v0, arg8)) {
            this.bringIntoViewRequesterNode.updateRequester(arg8.getBringIntoViewRequester());
        }
    }
}


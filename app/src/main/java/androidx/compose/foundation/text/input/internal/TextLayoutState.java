package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u00102\u001A\u00020\u000B2\u0006\u00103\u001A\u0002042\u0006\u00105\u001A\u0002062\u0006\u00107\u001A\u0002082\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020;J-\u0010<\u001A\u00020\n2\u0006\u0010=\u001A\u00020\b2\u0006\u0010>\u001A\u00020?2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020C¢\u0006\u0004\bD\u0010EJ\u001F\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020I2\b\b\u0002\u0010J\u001A\u000208¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001A\u0002082\u0006\u0010N\u001A\u00020I¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001A\u00020I2\u0006\u0010N\u001A\u00020IH\u0000¢\u0006\u0004\bR\u0010SR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R;\u0010\u0006\u001A#\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0007¢\u0006\u0002\b\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001D\u0010\u0011\u001A\u0004\u0018\u00010\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0012\u0010\u0013R/\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u00178F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR/\u0010\u001F\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u00178F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u001E\u001A\u0004\b \u0010\u001A\"\u0004\b!\u0010\u001CR/\u0010#\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u00178F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b&\u0010\u001E\u001A\u0004\b$\u0010\u001A\"\u0004\b%\u0010\u001CR+\u0010(\u001A\u00020\'2\u0006\u0010\u0016\u001A\u00020\'8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001E\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010.\u001A\u00020/¢\u0006\b\n\u0000\u001A\u0004\b0\u00101¨\u0006T"}, d2={"Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "", "<init>", "()V", "layoutCache", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "Lkotlin/ExtensionFunctionType;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function2;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function2;)V", "layoutResult", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult$delegate", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutNodeCoordinates", "getTextLayoutNodeCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setTextLayoutNodeCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "textLayoutNodeCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "coreNodeCoordinates", "getCoreNodeCoordinates", "setCoreNodeCoordinates", "coreNodeCoordinates$delegate", "decoratorNodeCoordinates", "getDecoratorNodeCoordinates", "setDecoratorNodeCoordinates", "decoratorNodeCoordinates$delegate", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "bringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getBringIntoViewRequester", "()Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "layoutWithNewMeasureInputs", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation", "(J)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLayoutState {
    public static final int $stable = 8;
    private final BringIntoViewRequester bringIntoViewRequester;
    private final MutableState coreNodeCoordinates$delegate;
    private final MutableState decoratorNodeCoordinates$delegate;
    private TextFieldLayoutStateCache layoutCache;
    private final TextFieldLayoutStateCache layoutResult$delegate;
    private final MutableState minHeightForSingleLineField$delegate;
    private Function2 onTextLayout;
    private final MutableState textLayoutNodeCoordinates$delegate;

    public static TextLayoutResult $r8$lambda$p34E_Bmt_Rtn4rcQNgd5K46Mdf4(TextLayoutState arg0) {
        return TextLayoutState.layoutWithNewMeasureInputs__hBUhpc$lambda$0$0(arg0);
    }

    static {
    }

    public TextLayoutState() {
        super();
        TextFieldLayoutStateCache v0 = new TextFieldLayoutStateCache();
        this.layoutCache = v0;
        this.layoutResult$delegate = v0;
        this.textLayoutNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.coreNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.decoratorNodeCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.minHeightForSingleLineField$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0f)), null, 2, null);
        this.bringIntoViewRequester = BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public final long coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation(long arg5) {
        Rect v1_1;
        LayoutCoordinates v0 = this.getTextLayoutNodeCoordinates();
        if(v0 != null) {
            if(v0.isAttached()) {
                LayoutCoordinates v4 = this.getDecoratorNodeCoordinates();
                Object v1 = null;
                if(v4 != null) {
                    v1_1 = LayoutCoordinates.localBoundingBoxOf$default(v4, v0, false, 2, v1);
                }
            }
            else {
                v1_1 = Rect.Companion.getZero();
            }

            if(v1_1 != null) {
                goto label_16;
            }

            goto label_14;
        }
        else {
        label_14:
            v1_1 = Rect.Companion.getZero();
        }

    label_16:
        return TextLayoutStateKt.coerceIn-3MmeM6k(arg5, v1_1);
    }

    public final BringIntoViewRequester getBringIntoViewRequester() {
        return this.bringIntoViewRequester;
    }

    public final LayoutCoordinates getCoreNodeCoordinates() {
        return this.coreNodeCoordinates$delegate.getValue();
    }

    public final LayoutCoordinates getDecoratorNodeCoordinates() {
        return this.decoratorNodeCoordinates$delegate.getValue();
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult$delegate.getValue();
    }

    public final float getMinHeightForSingleLineField-D9Ej5fM() {
        return this.minHeightForSingleLineField$delegate.getValue().unbox-impl();
    }

    public final int getOffsetForPosition-3MmeM6k(long arg2, boolean arg4) {
        TextLayoutResult v0 = this.getLayoutResult();
        if(v0 == null) {
            return -1;
        }

        if(arg4) {
            arg2 = this.coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation(arg2);
        }

        return v0.getOffsetForPosition-k-4lQ0M(TextLayoutStateKt.fromDecorationToTextLayout-Uv8p0NA(this, arg2));
    }

    public static int getOffsetForPosition-3MmeM6k$default(TextLayoutState arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        return arg0.getOffsetForPosition-3MmeM6k(arg1, true);
    }

    public final Function2 getOnTextLayout() {
        return this.onTextLayout;
    }

    public final LayoutCoordinates getTextLayoutNodeCoordinates() {
        return this.textLayoutNodeCoordinates$delegate.getValue();
    }

    public final boolean isPositionOnText-k-4lQ0M(long arg5) {
        TextLayoutResult v0 = this.getLayoutResult();
        if(v0 == null) {
            return 0;
        }

        long v4 = TextLayoutStateKt.fromDecorationToTextLayout-Uv8p0NA(this, this.coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation(arg5));
        int v6 = v0.getLineForVerticalPosition(Float.intBitsToFloat(((int)(0xFFFFFFFFL & v4))));
        int v4_1 = ((int)(v4 >> 0x20));
        if(Float.intBitsToFloat(v4_1) >= v0.getLineLeft(v6) && Float.intBitsToFloat(v4_1) <= v0.getLineRight(v6)) {
            return 1;
        }

        return 0;
    }

    public final TextLayoutResult layoutWithNewMeasureInputs--hBUhpc(Density arg7, LayoutDirection arg8, Resolver arg9, long arg10) {
        Density v1 = arg7;
        TextLayoutResult v7 = this.layoutCache.layoutWithNewMeasureInputs--hBUhpc(v1, arg8, arg9, arg10);
        Function2 v8 = this.onTextLayout;
        if(v8 != null) {
            v8.invoke(v1, new TextLayoutState$$ExternalSyntheticLambda0(this));
        }

        return v7;
    }

    private static final TextLayoutResult layoutWithNewMeasureInputs__hBUhpc$lambda$0$0(TextLayoutState arg0) {
        return arg0.layoutCache.getValue();
    }

    public final void setCoreNodeCoordinates(LayoutCoordinates arg1) {
        this.coreNodeCoordinates$delegate.setValue(arg1);
    }

    public final void setDecoratorNodeCoordinates(LayoutCoordinates arg1) {
        this.decoratorNodeCoordinates$delegate.setValue(arg1);
    }

    public final void setMinHeightForSingleLineField-0680j_4(float arg1) {
        this.minHeightForSingleLineField$delegate.setValue(Dp.box-impl(arg1));
    }

    public final void setOnTextLayout(Function2 arg1) {
        this.onTextLayout = arg1;
    }

    public final void setTextLayoutNodeCoordinates(LayoutCoordinates arg1) {
        this.textLayoutNodeCoordinates$delegate.setValue(arg1);
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState arg1, TextStyle arg2, boolean arg3, boolean arg4, KeyboardOptions arg5) {
        this.layoutCache.updateNonMeasureInputs(arg1, arg2, arg3, arg4, arg5);
    }
}


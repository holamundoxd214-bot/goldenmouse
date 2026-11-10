package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0016\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u0003H\u0000\u001A\u0016\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\u0003H\u0000\u001A\u0016\u0010\b\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001A\u00020\u0003H\u0000\u001A\u0014\u0010\n\u001A\u00020\u000B*\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0000\"\u0018\u0010\r\u001A\u00020\u000B*\u00020\u000E8AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010\"\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2={"top", "Landroidx/compose/foundation/shape/CornerBasedShape;", "bottomSize", "Landroidx/compose/foundation/shape/CornerSize;", "bottom", "topSize", "start", "endSize", "end", "startSize", "fromToken", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/Shapes;", "value", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ShapeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ShapesKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ShapeKeyTokens.values().length];
            try {
                v0[ShapeKeyTokens.CornerExtraLarge.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ShapeKeyTokens.CornerExtraLargeIncreased.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ShapeKeyTokens.CornerExtraExtraLarge.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[ShapeKeyTokens.CornerExtraLargeTop.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[ShapeKeyTokens.CornerExtraSmall.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[ShapeKeyTokens.CornerExtraSmallTop.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[ShapeKeyTokens.CornerFull.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_31:
                                            v0[ShapeKeyTokens.CornerLarge.ordinal()] = 8;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[ShapeKeyTokens.CornerLargeIncreased.ordinal()] = 9;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_39:
                                                    v0[ShapeKeyTokens.CornerLargeEnd.ordinal()] = 10;
                                                    goto label_43;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_43:
                                                        v0[ShapeKeyTokens.CornerLargeTop.ordinal()] = 11;
                                                        goto label_47;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_47:
                                                            v0[ShapeKeyTokens.CornerMedium.ordinal()] = 12;
                                                            goto label_51;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_51:
                                                                v0[ShapeKeyTokens.CornerNone.ordinal()] = 13;
                                                                goto label_55;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_55:
                                                                    v0[ShapeKeyTokens.CornerSmall.ordinal()] = 14;
                                                                    goto label_59;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_59:
                                                                        v0[ShapeKeyTokens.CornerLargeStart.ordinal()] = 15;
                                                                        goto label_63;
                                                                    }
                                                                    catch(NoSuchFieldError ) {
                                                                    label_63:
                                                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                                                        return;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final ProvidableCompositionLocal LocalShapes;

    static {
        ShapesKt.LocalShapes = CompositionLocalKt.staticCompositionLocalOf(new ShapesKt$$ExternalSyntheticLambda0());
    }

    static final Shapes LocalShapes$lambda$0() {
        return new Shapes(null, null, null, null, null, 0x1F, null);
    }

    public static final CornerBasedShape bottom(CornerBasedShape arg7, CornerSize arg8) {
        return CornerBasedShape.copy$default(arg7, arg8, arg8, null, null, 12, null);
    }

    public static CornerBasedShape bottom$default(CornerBasedShape arg0, CornerSize arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
        }

        return ShapesKt.bottom(arg0, arg1);
    }

    public static final CornerBasedShape end(CornerBasedShape arg7, CornerSize arg8) {
        return CornerBasedShape.copy$default(arg7, arg8, null, null, arg8, 6, null);
    }

    public static CornerBasedShape end$default(CornerBasedShape arg0, CornerSize arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
        }

        return ShapesKt.end(arg0, arg1);
    }

    public static final Shape fromToken(Shapes arg2, ShapeKeyTokens arg3) {
        CornerSize v1 = null;
        switch(WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()]) {
            case 1: {
                goto label_42;
            }
            case 2: {
                goto label_40;
            }
            case 3: {
                goto label_38;
            }
            case 4: {
                goto label_35;
            }
            case 5: {
                goto label_33;
            }
            case 6: {
                goto label_30;
            }
            case 7: {
                goto label_28;
            }
            case 8: {
                goto label_26;
            }
            case 9: {
                goto label_24;
            }
            case 10: {
                goto label_21;
            }
            case 11: {
                goto label_18;
            }
            case 12: {
                goto label_16;
            }
            case 13: {
                goto label_14;
            }
            case 14: {
                goto label_12;
            }
            case 15: {
                goto label_9;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_33:
        return arg2.getExtraSmall();
    label_35:
        return ShapesKt.top$default(arg2.getExtraLarge(), v1, 1, v1);
    label_38:
        return arg2.getExtraExtraLarge$material3();
    label_40:
        return arg2.getExtraLargeIncreased$material3();
    label_9:
        return ShapesKt.start$default(arg2.getLarge(), v1, 1, v1);
    label_42:
        return arg2.getExtraLarge();
    label_12:
        return arg2.getSmall();
    label_14:
        return RectangleShapeKt.getRectangleShape();
    label_16:
        return arg2.getMedium();
    label_18:
        return ShapesKt.top$default(arg2.getLarge(), v1, 1, v1);
    label_21:
        return ShapesKt.end$default(arg2.getLarge(), v1, 1, v1);
    label_24:
        return arg2.getLargeIncreased$material3();
    label_26:
        return arg2.getLarge();
    label_28:
        return RoundedCornerShapeKt.getCircleShape();
    label_30:
        return ShapesKt.top$default(arg2.getExtraSmall(), v1, 1, v1);
    }

    public static final ProvidableCompositionLocal getLocalShapes() {
        return ShapesKt.LocalShapes;
    }

    public static final Shape getValue(ShapeKeyTokens arg3, Composer arg4, int arg5) {
        int v1 = 0x611B333F;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-value>)358@15672L6:Shapes.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.<get-value> (Shapes.kt:358)");
        }

        Shape v3 = ShapesKt.fromToken(MaterialTheme.INSTANCE.getShapes(arg4, 6), arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static final CornerBasedShape start(CornerBasedShape arg7, CornerSize arg8) {
        return CornerBasedShape.copy$default(arg7, null, arg8, arg8, null, 9, null);
    }

    public static CornerBasedShape start$default(CornerBasedShape arg0, CornerSize arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
        }

        return ShapesKt.start(arg0, arg1);
    }

    public static final CornerBasedShape top(CornerBasedShape arg7, CornerSize arg8) {
        return CornerBasedShape.copy$default(arg7, null, null, arg8, arg8, 3, null);
    }

    public static CornerBasedShape top$default(CornerBasedShape arg0, CornerSize arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = ShapeDefaults.INSTANCE.getCornerNone$material3();
        }

        return ShapesKt.top(arg0, arg1);
    }
}


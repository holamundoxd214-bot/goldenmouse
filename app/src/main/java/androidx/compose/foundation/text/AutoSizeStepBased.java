package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001A\u00020\u0003*\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\f\u0010\u0011\u001A\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001A\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0015\u001A\u00020\u0012*\u00020\u0013H\u0002J\u0013\u0010\u0016\u001A\u00020\u00122\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u0010\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "didOverflow", "", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AutoSizeStepBased implements TextAutoSize {
    private final long maxFontSize;
    private long minFontSize;
    private final long stepSize;

    public AutoSizeStepBased(long arg1, long arg3, long arg5, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5);
    }

    private AutoSizeStepBased(long arg3, long arg5, long arg7) {
        super();
        this.minFontSize = arg3;
        this.maxFontSize = arg5;
        this.stepSize = arg7;
        if(!TextUnit.equals-impl0(arg3, TextUnit.Companion.getUnspecified-XSAIIZE())) {
            if(!TextUnit.equals-impl0(arg5, TextUnit.Companion.getUnspecified-XSAIIZE())) {
                if(!TextUnit.equals-impl0(arg7, TextUnit.Companion.getUnspecified-XSAIIZE())) {
                    if(TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(this.minFontSize), TextUnit.getType-UIouoOA(arg5))) {
                        arg3 = this.minFontSize;
                        TextUnitKt.checkArithmetic-NB67dxo(arg3, arg5);
                        if(Float.compare(TextUnit.getValue-impl(arg3), TextUnit.getValue-impl(arg5)) > 0) {
                            this.minFontSize = arg5;
                        }
                    }

                    if(TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg7), TextUnitType.Companion.getSp-UIouoOA())) {
                        arg3 = TextUnitKt.getSp(0.0001f);
                        TextUnitKt.checkArithmetic-NB67dxo(arg7, arg3);
                        if(Float.compare(TextUnit.getValue-impl(arg7), TextUnit.getValue-impl(arg3)) >= 0) {
                        }
                        else {
                            throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
                        }
                    }

                    if(TextUnit.getValue-impl(this.minFontSize) >= 0f) {
                        if(TextUnit.getValue-impl(arg5) >= 0f) {
                            return;
                        }

                        throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
                    }

                    throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
                }

                throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
            }

            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
        }

        throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
    }

    private final boolean didOverflow(TextLayoutResult arg3) {
        int v0 = arg3.getLayoutInput().getOverflow-gIe3tQ8();
        if(!TextOverflow.equals-impl0(v0, TextOverflow.Companion.getClip-gIe3tQ8())) {
            if(TextOverflow.equals-impl0(v0, TextOverflow.Companion.getVisible-gIe3tQ8())) {
            }
            else {
                if(!TextOverflow.equals-impl0(v0, TextOverflow.Companion.getStartEllipsis-gIe3tQ8()) && !TextOverflow.equals-impl0(v0, TextOverflow.Companion.getMiddleEllipsis-gIe3tQ8())) {
                    if(TextOverflow.equals-impl0(v0, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                    }
                    else {
                        throw new IllegalArgumentException("TextOverflow type " + TextOverflow.toString-impl(arg3.getLayoutInput().getOverflow-gIe3tQ8()) + " is not supported.");
                    }
                }

                return this.didOverflowByEllipsize(arg3);
            }
        }

        return this.didOverflowBounds(arg3);
    }

    private final boolean didOverflowBounds(TextLayoutResult arg1) {
        if(!arg1.getDidOverflowWidth()) {
            if(arg1.getDidOverflowHeight()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final boolean didOverflowByEllipsize(TextLayoutResult arg5) {
        int v0 = arg5.getLineCount();
        if(v0 != 0) {
            if(v0 != 1) {
                v0 = arg5.getLayoutInput().getOverflow-gIe3tQ8();
                if(!TextOverflow.equals-impl0(v0, TextOverflow.Companion.getStartEllipsis-gIe3tQ8())) {
                    if(TextOverflow.equals-impl0(v0, TextOverflow.Companion.getMiddleEllipsis-gIe3tQ8())) {
                    }
                    else if(TextOverflow.equals-impl0(v0, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
                        return arg5.isLineEllipsized(arg5.getLineCount() - 1);
                    }
                    else {
                        return 0;
                    }
                }

                return this.didOverflowBounds(arg5);
            }

            return arg5.isLineEllipsized(0);
        }

        return 0;
    }

    public boolean equals(Object arg7) {
        if((((AutoSizeStepBased)arg7)) == this) {
            return 1;
        }

        if(arg7 == null) {
            return 0;
        }

        if(!(arg7 instanceof AutoSizeStepBased)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(((AutoSizeStepBased)arg7).minFontSize, this.minFontSize)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(((AutoSizeStepBased)arg7).maxFontSize, this.maxFontSize)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(((AutoSizeStepBased)arg7).stepSize, this.stepSize)) {
            return 0;
        }

        return 1;
    }

    public long getFontSize-Ci0_558(TextAutoSizeLayoutScope arg15, long arg16, AnnotatedString arg18) {
        float v0 = arg15.toPx--R2X_6o(this.stepSize);
        float v1 = arg15.toPx--R2X_6o(this.minFontSize);
        float v2 = arg15.toPx--R2X_6o(this.maxFontSize);
        float v4 = 2f;
        float v3 = (v1 + v2) / v4;
        float v6 = v1;
        float v5 = v2;
        while(v5 - v6 >= v0) {
            if(this.didOverflow(arg15.performLayout-5ZSfY2I(arg16, arg18, arg15.toSp-kPz2Gy4(v3)))) {
                v5 = v3;
            }
            else {
                v6 = v3;
            }

            v3 = (v6 + v5) / v4;
        }

        v3 = (((float)Math.floor(((double)((v6 - v1) / v0))))) * v0 + v1;
        v0 += v3;
        if(v0 <= v2 && !this.didOverflow(arg15.performLayout-5ZSfY2I(arg16, arg18, arg15.toSp-kPz2Gy4(v0)))) {
            v3 = v0;
        }

        return arg15.toSp-kPz2Gy4(v3);
    }

    public int hashCode() {
        return (TextUnit.hashCode-impl(this.minFontSize) * 0x1F + TextUnit.hashCode-impl(this.maxFontSize)) * 0x1F + TextUnit.hashCode-impl(this.stepSize);
    }
}


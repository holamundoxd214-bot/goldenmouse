package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007J\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fJ\u0015\u0010\n\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\n\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0010J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0015J\u0015\u0010\n\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\n\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u001B¢\u0006\u0004\b\u001C\u0010\u0019J\u0015\u0010\n\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u001E¢\u0006\u0004\b\u001F\u0010 J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010!\u001A\u00020\"J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010#\u001A\u00020$J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010%\u001A\u00020&J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010\'\u001A\u00020(J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010)\u001A\u00020*J\u000E\u0010\n\u001A\u00020\u00072\u0006\u0010+\u001A\u00020,J\u0015\u0010\n\u001A\u00020\u00072\u0006\u0010-\u001A\u00020.¢\u0006\u0004\b/\u0010\u0010J\u000E\u0010\n\u001A\u00020\u00072\u0006\u00100\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00061"}, d2={"Landroidx/compose/foundation/internal/EncodeHelper;", "", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "reset", "", "encodedString", "", "encode", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "byte", "", "int", "", "float", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "string", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel;

    static {
    }

    public EncodeHelper() {
        super();
        this.parcel = Parcel.obtain();
    }

    public final void encode(SpanStyle arg5) {
        int v0_2;
        if(!Color.equals-impl0(arg5.getColor-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU())) {
            this.encode(1);
            this.encode-8_81llA(arg5.getColor-0d7_KjU());
        }

        if(!TextUnit.equals-impl0(arg5.getFontSize-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) {
            this.encode(2);
            this.encode--R2X_6o(arg5.getFontSize-XSAIIZE());
        }

        FontWeight v0 = arg5.getFontWeight();
        if(v0 != null) {
            this.encode(3);
            this.encode(v0);
        }

        FontStyle v0_1 = arg5.getFontStyle-4Lr2A7w();
        if(v0_1 != null) {
            v0_2 = v0_1.unbox-impl();
            this.encode(4);
            this.encode-nzbMABs(v0_2);
        }

        FontSynthesis v0_3 = arg5.getFontSynthesis-ZQGJjVo();
        if(v0_3 != null) {
            v0_2 = v0_3.unbox-impl();
            this.encode(5);
            this.encode-6p3vJLY(v0_2);
        }

        String v0_4 = arg5.getFontFeatureSettings();
        if(v0_4 != null) {
            this.encode(6);
            this.encode(v0_4);
        }

        if(!TextUnit.equals-impl0(arg5.getLetterSpacing-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) {
            this.encode(7);
            this.encode--R2X_6o(arg5.getLetterSpacing-XSAIIZE());
        }

        BaselineShift v0_5 = arg5.getBaselineShift-5SSeXJ0();
        if(v0_5 != null) {
            float v0_6 = v0_5.unbox-impl();
            this.encode(8);
            this.encode-4Dl_Bck(v0_6);
        }

        TextGeometricTransform v0_7 = arg5.getTextGeometricTransform();
        if(v0_7 != null) {
            this.encode(9);
            this.encode(v0_7);
        }

        if(!Color.equals-impl0(arg5.getBackground-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU())) {
            this.encode(10);
            this.encode-8_81llA(arg5.getBackground-0d7_KjU());
        }

        TextDecoration v0_8 = arg5.getTextDecoration();
        if(v0_8 != null) {
            this.encode(11);
            this.encode(v0_8);
        }

        Shadow v5 = arg5.getShadow();
        if(v5 != null) {
            this.encode(12);
            this.encode(v5);
        }
    }

    public final void encode(byte arg1) {
        this.parcel.writeByte(arg1);
    }

    public final void encode(float arg1) {
        this.parcel.writeFloat(arg1);
    }

    public final void encode(int arg1) {
        this.parcel.writeInt(arg1);
    }

    public final void encode(Shadow arg5) {
        this.encode-8_81llA(arg5.getColor-0d7_KjU());
        this.encode(Float.intBitsToFloat(((int)(arg5.getOffset-F1C5BW0() >> 0x20))));
        this.encode(Float.intBitsToFloat(((int)(arg5.getOffset-F1C5BW0() & 0xFFFFFFFFL))));
        this.encode(arg5.getBlurRadius());
    }

    public final void encode(FontWeight arg1) {
        this.encode(arg1.getWeight());
    }

    public final void encode(String arg1) {
        this.parcel.writeString(arg1);
    }

    public final void encode(TextGeometricTransform arg2) {
        this.encode(arg2.getScaleX());
        this.encode(arg2.getSkewX());
    }

    public final void encode(TextDecoration arg1) {
        this.encode(arg1.getMask());
    }

    public final void encode--R2X_6o(long arg7) {
        long v0 = TextUnit.getType-UIouoOA(arg7);
        byte v3 = 0;
        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getUnspecified-UIouoOA())) {
        }
        else if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getSp-UIouoOA())) {
            v3 = 1;
        }
        else if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getEm-UIouoOA())) {
            v3 = 2;
        }

        this.encode(v3);
        if(!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg7), TextUnitType.Companion.getUnspecified-UIouoOA())) {
            this.encode(TextUnit.getValue-impl(arg7));
        }
    }

    public final void encode-4Dl_Bck(float arg1) {
        this.encode(arg1);
    }

    public final void encode-6p3vJLY(int arg3) {
        byte v1 = 0;
        if(FontSynthesis.equals-impl0(arg3, FontSynthesis.Companion.getNone-GVVA2EU())) {
        }
        else if(FontSynthesis.equals-impl0(arg3, FontSynthesis.Companion.getAll-GVVA2EU())) {
            v1 = 1;
        }
        else if(FontSynthesis.equals-impl0(arg3, FontSynthesis.Companion.getWeight-GVVA2EU())) {
            v1 = 2;
        }
        else if(FontSynthesis.equals-impl0(arg3, FontSynthesis.Companion.getStyle-GVVA2EU())) {
            v1 = 3;
        }

        this.encode(v1);
    }

    public final void encode-8_81llA(long arg1) {
        this.encode-VKZWuLQ(arg1);
    }

    public final void encode-VKZWuLQ(long arg1) {
        this.parcel.writeLong(arg1);
    }

    public final void encode-nzbMABs(int arg3) {
        byte v1 = 0;
        if(FontStyle.equals-impl0(arg3, FontStyle.Companion.getNormal-_-LCdwA())) {
        }
        else if(FontStyle.equals-impl0(arg3, FontStyle.Companion.getItalic-_-LCdwA())) {
            v1 = 1;
        }

        this.encode(v1);
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }
}


package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidColor_androidKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.ULong;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001A\u00020\tJ\r\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\rJ\u0006\u0010\u0011\u001A\u00020\u0012J\r\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u0016J\u000F\u0010\u001A\u001A\u00020\u001BH\u0002¢\u0006\u0004\b\u001C\u0010\u001DJ\b\u0010\u001E\u001A\u00020\u001FH\u0002J\b\u0010 \u001A\u00020!H\u0002J\b\u0010\"\u001A\u00020#H\u0002J\b\u0010$\u001A\u00020%H\u0002J\b\u0010&\u001A\u00020\'H\u0002J\u000F\u0010(\u001A\u00020)H\u0002¢\u0006\u0004\b*\u0010\rJ\b\u0010+\u001A\u00020,H\u0002J\n\u0010-\u001A\u0004\u0018\u00010\u0003H\u0002J\b\u0010.\u001A\u00020\'H\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"Landroidx/compose/ui/platform/DecodeHelper;", "", "string", "", "<init>", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeByte", "", "decodeInt", "", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "decodeFloat", "", "decodeString", "dataAvailable", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    static {
    }

    public DecodeHelper(String arg3) {
        super();
        Parcel v0 = Parcel.obtain();
        this.parcel = v0;
        byte[] v3 = Base64.decode(arg3, 0);
        v0.unmarshall(v3, 0, v3.length);
        v0.setDataPosition(0);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    private final float decodeBaselineShift-y9eOQZs() {
        return BaselineShift.constructor-impl(this.decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    public final long decodeColor-0d7_KjU() {
        return AndroidColor_androidKt.fromColorLong(Color.Companion, this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    public final int decodeFontStyle-_-LCdwA() {
        int v1 = this.decodeByte();
        if(v1 == 0) {
            return FontStyle.Companion.getNormal-_-LCdwA();
        }

        if(v1 == 1) {
            return FontStyle.Companion.getItalic-_-LCdwA();
        }

        return FontStyle.Companion.getNormal-_-LCdwA();
    }

    public final int decodeFontSynthesis-GVVA2EU() {
        int v1 = this.decodeByte();
        if(v1 == 0) {
            return FontSynthesis.Companion.getNone-GVVA2EU();
        }

        if(v1 == 1) {
            return FontSynthesis.Companion.getAll-GVVA2EU();
        }

        if(v1 == 3) {
            return FontSynthesis.Companion.getStyle-GVVA2EU();
        }

        if(v1 == 2) {
            return FontSynthesis.Companion.getWeight-GVVA2EU();
        }

        return FontSynthesis.Companion.getNone-GVVA2EU();
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(this.decodeInt());
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        return new Shadow(this.decodeColor-0d7_KjU(), Offset.constructor-impl((((long)Float.floatToRawIntBits(this.decodeFloat()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.decodeFloat()))) << 0x20), this.decodeFloat(), null);
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle v0 = new MutableSpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, 0x3FFF, null);
        DecodeHelper v1 = this;
        while(v1.parcel.dataAvail() > 1) {
            int v2 = v1.decodeByte();
            int v4 = 8;
            if(v2 != 1) {
                int v6 = 5;
                if(v2 != 2) {
                    int v7 = 4;
                    if(v2 == 3) {
                        if(v1.dataAvailable() >= v7) {
                            v0.setFontWeight(v1.decodeFontWeight());
                            continue;
                        }
                    }
                    else if(v2 == v7) {
                        if(v1.dataAvailable() >= 1) {
                            v0.setFontStyle-mLjRB2g(FontStyle.box-impl(v1.decodeFontStyle-_-LCdwA()));
                            continue;
                        }
                    }
                    else if(v2 == v6) {
                        if(v1.dataAvailable() >= 1) {
                            v0.setFontSynthesis-tDdu0R4(FontSynthesis.box-impl(v1.decodeFontSynthesis-GVVA2EU()));
                            continue;
                        }
                    }
                    else if(v2 == 6) {
                        v0.setFontFeatureSettings(v1.decodeString());
                        continue;
                    }
                    else if(v2 == 7) {
                        if(v1.dataAvailable() >= v6) {
                            v0.setLetterSpacing--R2X_6o(v1.decodeTextUnit-XSAIIZE());
                            continue;
                        }
                    }
                    else if(v2 == v4) {
                        if(v1.dataAvailable() >= v7) {
                            v0.setBaselineShift-_isdbwI(BaselineShift.box-impl(v1.decodeBaselineShift-y9eOQZs()));
                            continue;
                        }
                    }
                    else if(v2 == 9) {
                        if(v1.dataAvailable() >= v4) {
                            v0.setTextGeometricTransform(v1.decodeTextGeometricTransform());
                            continue;
                        }
                    }
                    else if(v2 == 10) {
                        if(v1.dataAvailable() >= v4) {
                            v0.setBackground-8_81llA(v1.decodeColor-0d7_KjU());
                            continue;
                        }
                    }
                    else if(v2 != 11) {
                        if(v2 != 12) {
                            continue;
                        }

                        if(v1.dataAvailable() >= 20) {
                            v0.setShadow(v1.decodeShadow());
                            continue;
                        }
                    }
                    else if(v1.dataAvailable() >= v7) {
                        v0.setTextDecoration(v1.decodeTextDecoration());
                        continue;
                    }
                }
                else if(v1.dataAvailable() >= v6) {
                    v0.setFontSize--R2X_6o(v1.decodeTextUnit-XSAIIZE());
                    continue;
                }
            }
            else if(v1.dataAvailable() >= v4) {
                v0.setColor-8_81llA(v1.decodeColor-0d7_KjU());
                continue;
            }

            break;
        }

        return v0.toSpanStyle();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        return TextDecoration.Companion.valueOf(this.decodeInt());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(this.decodeFloat(), this.decodeFloat());
    }

    public final long decodeTextUnit-XSAIIZE() {
        long v0_1;
        int v0 = this.decodeByte();
        if(v0 == 1) {
            v0_1 = TextUnitType.Companion.getSp-UIouoOA();
        }
        else if(v0 == 2) {
            v0_1 = TextUnitType.Companion.getEm-UIouoOA();
        }
        else {
            v0_1 = TextUnitType.Companion.getUnspecified-UIouoOA();
        }

        if(TextUnitType.equals-impl0(v0_1, TextUnitType.Companion.getUnspecified-UIouoOA())) {
            return TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        return TextUnitKt.TextUnit-anM5pPY(this.decodeFloat(), v0_1);
    }

    private final long decodeULong-s-VKNKU() {
        return ULong.constructor-impl(this.parcel.readLong());
    }
}


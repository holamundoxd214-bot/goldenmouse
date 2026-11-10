package androidx.compose.ui.unit.fontscaling;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016J\u0010\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0010H\u0016J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\u001C\u0010\u0007\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001C\u0010\f\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\t\u001A\u0004\b\u000E\u0010\u000B¨\u0006\u001D"}, d2={"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fromSp", "", "toDp", "<init>", "([F[F)V", "mFromSpValues", "getMFromSpValues$annotations", "()V", "getMFromSpValues", "()[F", "mToDpValues", "getMToDpValues$annotations", "getMToDpValues", "convertDpToSp", "", "dp", "convertSpToDp", "sp", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontScaleConverterTable implements FontScaleConverter {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0002¨\u0006\n"}, d2={"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterTable$Companion;", "", "<init>", "()V", "lookupAndInterpolate", "", "sourceValue", "sourceValues", "", "targetValues", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final float access$lookupAndInterpolate(Companion arg0, float arg1, float[] arg2, float[] arg3) {
            return arg0.lookupAndInterpolate(arg1, arg2, arg3);
        }

        private final float lookupAndInterpolate(float arg7, float[] arg8, float[] arg9) {
            float v1_1;
            float v2;
            float v8;
            float v5 = Math.abs(arg7);
            float v6 = Math.signum(arg7);
            int v0 = Arrays.binarySearch(arg8, v5);
            if(v0 >= 0) {
                arg7 = arg9[v0];
            }
            else {
                v0 = -(v0 + 1);
                int v1 = v0 - 1;
                float v3 = 0f;
                if(v1 >= arg8.length - 1) {
                    v6 = arg8[arg8.length - 1];
                    v8 = arg9[arg8.length - 1];
                    if(v6 == 0f) {
                        return 0;
                    }
                    else {
                        return arg7 * (v8 / v6);
                    }
                }
                else {
                    if(v1 == -1) {
                        v8 = arg8[0];
                        v2 = arg9[0];
                        v1_1 = 0f;
                    }
                    else {
                        v3 = arg8[v1];
                        v8 = arg8[v0];
                        v1_1 = arg9[v1];
                        v2 = arg9[v0];
                    }

                    arg7 = MathUtils.INSTANCE.constrainedMap(v1_1, v2, v3, v8, v5);
                }
            }

            return v6 * arg7;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final float[] mFromSpValues;
    private final float[] mToDpValues;

    static {
        FontScaleConverterTable.Companion = new Companion(null);
        FontScaleConverterTable.$stable = 8;
    }

    public FontScaleConverterTable(float[] arg3, float[] arg4) {
        super();
        if(arg3.length == arg4.length && arg3.length != 0) {
            this.mFromSpValues = arg3;
            this.mToDpValues = arg4;
            return;
        }

        throw new IllegalArgumentException("Array lengths must match and be nonzero".toString());
    }

    public float convertDpToSp(float arg3) {
        return Companion.access$lookupAndInterpolate(FontScaleConverterTable.Companion, arg3, this.mToDpValues, this.mFromSpValues);
    }

    public float convertSpToDp(float arg3) {
        return Companion.access$lookupAndInterpolate(FontScaleConverterTable.Companion, arg3, this.mFromSpValues, this.mToDpValues);
    }

    public boolean equals(Object arg5) {
        if(this == (((FontScaleConverterTable)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(!(arg5 instanceof FontScaleConverterTable)) {
            return 0;
        }

        if((Arrays.equals(this.mFromSpValues, ((FontScaleConverterTable)arg5).mFromSpValues)) && (Arrays.equals(this.mToDpValues, ((FontScaleConverterTable)arg5).mToDpValues))) {
            return 1;
        }

        return 0;
    }

    public final float[] getMFromSpValues() {
        return this.mFromSpValues;
    }

    public static void getMFromSpValues$annotations() {
    }

    public final float[] getMToDpValues() {
        return this.mToDpValues;
    }

    public static void getMToDpValues$annotations() {
    }

    public int hashCode() {
        return Arrays.hashCode(this.mFromSpValues) * 0x1F + Arrays.hashCode(this.mToDpValues);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("FontScaleConverter{fromSpValues=");
        String v1 = Arrays.toString(this.mFromSpValues);
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        v0 = v0.append(v1).append(", toDpValues=");
        String v3 = Arrays.toString(this.mToDpValues);
        Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
        return v0.append(v3).append('}').toString();
    }
}


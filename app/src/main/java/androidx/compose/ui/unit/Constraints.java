package androidx.compose.ui.unit;

import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0087@\u0018\u0000 /2\u00020\u0001:\u0001/B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\f\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\t2\b\b\u0002\u0010\u0012\u001A\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\u0000H\u0086\b¢\u0006\u0004\b\'\u0010\u0005J\u000F\u0010(\u001A\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001A\u00020\u00152\b\u0010-\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001A\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001A\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u000E\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0010\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000BR\u0011\u0010\u0012\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000BR\u0011\u0010\u0014\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0017R\u001A\u0010\u001A\u001A\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001B\u0010\u0007\u001A\u0004\b\u001C\u0010\u0017R\u001A\u0010\u001D\u001A\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001E\u0010\u0007\u001A\u0004\b\u001F\u0010\u0017R\u001A\u0010 \u001A\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001A\u0004\b\"\u0010\u0017\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u00060"}, d2={"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "getValue$annotations", "()V", "focusIndex", "", "getFocusIndex-impl", "(J)I", "minWidth", "getMinWidth-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "maxHeight", "getMaxHeight-impl", "hasBoundedWidth", "", "getHasBoundedWidth-impl", "(J)Z", "hasBoundedHeight", "getHasBoundedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "getHasFixedHeight-impl", "isZero", "isZero$annotations", "isZero-impl", "copy", "copy-Zbe2FdA", "(JIIII)J", "copyMaxDimensions", "copyMaxDimensions-msEJaDk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "other", "hashCode", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Constraints {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u000EJ9\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u00052\b\b\u0002\u0010\u0016\u001A\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u001B\u0010\u001CJ/\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u001E\u0010\u001CR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/ui/unit/Constraints$Companion;", "", "<init>", "()V", "Infinity", "", "fixed", "Landroidx/compose/ui/unit/Constraints;", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedWidth", "fixedWidth-OenEA2s", "(I)J", "fixedHeight", "fixedHeight-OenEA2s", "restrictConstraints", "minWidth", "maxWidth", "minHeight", "maxHeight", "prioritizeWidth", "", "restrictConstraints-xF2OJ5Q", "(IIIIZ)J", "fitPrioritizingWidth", "fitPrioritizingWidth-Zbe2FdA", "(IIII)J", "fitPrioritizingHeight", "fitPrioritizingHeight-Zbe2FdA", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long fitPrioritizingHeight-Zbe2FdA(int arg4, int arg5, int arg6, int arg7) {
            int v3 = 0x3FFFE;
            arg6 = Math.min(arg6, v3);
            int v0 = 0x7FFFFFFF;
            arg7 = arg7 == v0 ? v0 : Math.min(arg7, v3);
            int v1 = arg7 == v0 ? arg6 : arg7;
            if(v1 < 0x1FFF) {
            }
            else if(v1 < 0x7FFF) {
                v3 = 0xFFFE;
            }
            else if(v1 < 0xFFFF) {
                v3 = 0x7FFE;
            }
            else if(v1 < 0x3FFFF) {
                v3 = 0x1FFE;
            }
            else {
                goto label_31;
            }

            if(arg5 == v0) {
            }
            else {
                v0 = Math.min(v3, arg5);
            }

            return ConstraintsKt.Constraints(Math.min(v3, arg4), v0, arg6, arg7);
        label_31:
            ConstraintsKt.throwInvalidConstraintsSizeException(v1);
            throw new KotlinNothingValueException();
        }

        public final long fitPrioritizingWidth-Zbe2FdA(int arg4, int arg5, int arg6, int arg7) {
            int v3 = 0x3FFFE;
            arg4 = Math.min(arg4, v3);
            int v0 = 0x7FFFFFFF;
            arg5 = arg5 == v0 ? v0 : Math.min(arg5, v3);
            int v1 = arg5 == v0 ? arg4 : arg5;
            if(v1 < 0x1FFF) {
            }
            else if(v1 < 0x7FFF) {
                v3 = 0xFFFE;
            }
            else if(v1 < 0xFFFF) {
                v3 = 0x7FFE;
            }
            else if(v1 < 0x3FFFF) {
                v3 = 0x1FFE;
            }
            else {
                goto label_31;
            }

            if(arg7 == v0) {
            }
            else {
                v0 = Math.min(v3, arg7);
            }

            return ConstraintsKt.Constraints(arg4, arg5, Math.min(v3, arg6), v0);
        label_31:
            ConstraintsKt.throwInvalidConstraintsSizeException(v1);
            throw new KotlinNothingValueException();
        }

        public final long fixed-JhjzzOo(int arg3, int arg4) {
            int v2 = 1;
            int v1 = arg3 >= 0 ? 1 : 0;
            if(arg4 >= 0) {
            }
            else {
                v2 = 0;
            }

            if((v2 & v1) == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
            }

            return ConstraintsKt.createConstraints(arg3, arg3, arg4, arg4);
        }

        public final long fixedHeight-OenEA2s(int arg2) {
            int v0 = arg2 >= 0 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("height must be >= 0");
            }

            return ConstraintsKt.createConstraints(0, 0x7FFFFFFF, arg2, arg2);
        }

        public final long fixedWidth-OenEA2s(int arg2) {
            int v0 = arg2 >= 0 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("width must be >= 0");
            }

            return ConstraintsKt.createConstraints(arg2, arg2, 0, 0x7FFFFFFF);
        }

        @Deprecated(message="Replace with fitPrioritizingWidth", replaceWith="<_subannotation>") public final long restrictConstraints-xF2OJ5Q(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
            if(arg5) {
                return this.fitPrioritizingWidth-Zbe2FdA(arg1, arg2, arg3, arg4);
            }

            return this.fitPrioritizingHeight-Zbe2FdA(arg1, arg2, arg3, arg4);
        }

        public static long restrictConstraints-xF2OJ5Q$default(Companion arg6, int arg7, int arg8, int arg9, int arg10, boolean arg11, int arg12, Object arg13) {
            return arg6.restrictConstraints-xF2OJ5Q(arg7, arg8, arg9, arg10, true);
        }
    }

    public static final Companion Companion = null;
    public static final int Infinity = 0x7FFFFFFF;
    private final long value;

    static {
        Constraints.Companion = new Companion(null);
    }

    private Constraints(long arg1) {
        super();
        this.value = arg1;
    }

    public static final Constraints box-impl(long arg1) {
        return new Constraints(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long copy-Zbe2FdA(long arg0, int arg2, int arg3, int arg4, int arg5) {
        int v0 = arg3 < arg2 || arg5 < arg4 || arg2 < 0 || arg4 < 0 ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }

        return ConstraintsKt.createConstraints(arg2, arg3, arg4, arg5);
    }

    public static long copy-Zbe2FdA$default(long arg6, int arg8, int arg9, int arg10, int arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg8 = Constraints.getMinWidth-impl(arg6);
        }

        int v2 = arg8;
        if((arg12 & 2) != 0) {
            arg9 = Constraints.getMaxWidth-impl(arg6);
        }

        int v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = Constraints.getMinHeight-impl(arg6);
        }

        int v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = Constraints.getMaxHeight-impl(arg6);
        }

        return Constraints.copy-Zbe2FdA(arg6, v2, v3, v4, arg11);
    }

    public static final long copyMaxDimensions-msEJaDk(long arg2) {
        return Constraints.constructor-impl(arg2 & -8589934589L);
    }

    public boolean equals(Object arg3) {
        return Constraints.equals-impl(this.value, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof Constraints)) {
            return 0;
        }

        if(arg4 != ((Constraints)arg6).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(long arg0, long arg2) {
        if(arg0 == arg2) {
            return 1;
        }

        return 0;
    }

    private static final int getFocusIndex-impl(long arg2) {
        return ((int)(arg2 & 3));
    }

    public static final boolean getHasBoundedHeight-impl(long arg3) {
        int v0 = ((int)(3 & arg3));
        int v1 = ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3;
        if(((((int)(arg3 >> v1 + 46))) & (1 << 18 - v1) - 1) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean getHasBoundedWidth-impl(long arg3) {
        int v0 = ((int)(3 & arg3));
        if(((((int)(arg3 >> 33))) & (1 << ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3 + 13) - 1) != 0) {
            return 1;
        }

        return 0;
    }

    public static void getHasFixedHeight$annotations() {
    }

    public static final boolean getHasFixedHeight-impl(long arg5) {
        int v0 = ((int)(3 & arg5));
        int v1 = ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3;
        v0 = (1 << 18 - v1) - 1;
        int v3 = (((int)(arg5 >> v1 + 15))) & v0;
        int v5 = (((int)(arg5 >> v1 + 46))) & v0;
        if(v5 == 0) {
            v5 = 0x7FFFFFFF;
        }
        else {
            --v5;
        }

        if(v3 == v5) {
            return 1;
        }

        return 0;
    }

    public static void getHasFixedWidth$annotations() {
    }

    public static final boolean getHasFixedWidth-impl(long arg5) {
        int v0 = ((int)(3 & arg5));
        v0 = (1 << ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3 + 13) - 1;
        int v1 = (((int)(arg5 >> 2))) & v0;
        int v5 = (((int)(arg5 >> 33))) & v0;
        if(v5 == 0) {
            v5 = 0x7FFFFFFF;
        }
        else {
            --v5;
        }

        if(v1 == v5) {
            return 1;
        }

        return 0;
    }

    public static final int getMaxHeight-impl(long arg3) {
        int v0 = ((int)(3 & arg3));
        int v1 = ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3;
        int v3 = (((int)(arg3 >> v1 + 46))) & (1 << 18 - v1) - 1;
        if(v3 == 0) {
            return 0x7FFFFFFF;
        }

        return v3 - 1;
    }

    public static final int getMaxWidth-impl(long arg3) {
        int v0 = ((int)(3 & arg3));
        int v3 = (((int)(arg3 >> 33))) & (1 << ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3 + 13) - 1;
        if(v3 == 0) {
            return 0x7FFFFFFF;
        }

        return v3 - 1;
    }

    public static final int getMinHeight-impl(long arg3) {
        int v0 = ((int)(3 & arg3));
        int v1 = ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3;
        return (((int)(arg3 >> v1 + 15))) & (1 << 18 - v1) - 1;
    }

    public static final int getMinWidth-impl(long arg4) {
        int v0 = ((int)(3 & arg4));
        return (((int)(arg4 >> 2))) & (1 << ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3 + 13) - 1;
    }

    public static void getValue$annotations() {
    }

    public int hashCode() {
        return Constraints.hashCode-impl(this.value);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static void isZero$annotations() {
    }

    public static final boolean isZero-impl(long arg5) {
        int v0 = ((int)(3 & arg5));
        int v2 = 1;
        int v1 = ((v0 & 1) << 1) + ((v0 & 2) >> 1) * 3;
        v0 = ((((int)(arg5 >> 33))) & (1 << v1 + 13) - 1) - 1;
        int v5 = ((((int)(arg5 >> v1 + 46))) & (1 << 18 - v1) - 1) - 1;
        v0 = v0 == 0 ? 1 : 0;
        if(v5 == 0) {
        }
        else {
            v2 = 0;
        }

        return v0 | v2;
    }

    public String toString() {
        return Constraints.toString-impl(this.value);
    }

    public static String toString-impl(long arg4) {
        int v0 = Constraints.getMaxWidth-impl(arg4);
        String v1 = "Infinity";
        int v2 = 0x7FFFFFFF;
        String v0_1 = v0 == v2 ? v1 : String.valueOf(v0);
        int v3 = Constraints.getMaxHeight-impl(arg4);
        if(v3 == v2) {
        }
        else {
            v1 = String.valueOf(v3);
        }

        return "Constraints(minWidth = " + Constraints.getMinWidth-impl(arg4) + ", maxWidth = " + v0_1 + ", minHeight = " + Constraints.getMinHeight-impl(arg4) + ", maxHeight = " + v1 + ')';
    }

    public final long unbox-impl() {
        return this.value;
    }
}


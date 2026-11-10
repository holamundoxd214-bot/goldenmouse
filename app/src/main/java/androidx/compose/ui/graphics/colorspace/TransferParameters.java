package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0003HÆ\u0003J\t\u0010 \u001A\u00020\u0003HÆ\u0003JO\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001A\u00020\u00152\b\u0010#\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001A\u00020%HÖ\u0001J\t\u0010&\u001A\u00020\'HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001A\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0017¨\u0006("}, d2={"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "<init>", "(DDDDDDD)V", "getGamma", "()D", "getA", "getB", "getC", "getD", "getE", "getF", "isHLGish", "", "isHLGish$ui_graphics", "()Z", "isPQish", "isPQish$ui_graphics", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransferParameters {
    public static final int $stable;
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;

    static {
    }

    public TransferParameters(double arg1, double arg3, double arg5, double arg7, double arg9, double arg11, double arg13) {
        super();
        this.gamma = arg1;
        this.a = arg3;
        this.b = arg5;
        this.c = arg7;
        this.d = arg9;
        this.e = arg11;
        this.f = arg13;
        if(!Double.isNaN(arg3) && !Double.isNaN(arg5) && !Double.isNaN(arg7) && !Double.isNaN(arg9) && !Double.isNaN(arg11) && !Double.isNaN(arg13) && !Double.isNaN(arg1)) {
            if(!TransferParametersKt.access$isSpecialG(arg1)) {
                arg5 = 0;
                if(arg9 >= arg5) {
                    arg11 = 1;
                    if(arg9 <= arg11) {
                        if(arg9 == arg5 && (arg3 == arg5 || arg1 == arg5)) {
                            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
                        }

                        if(arg9 >= arg11) {
                            if(arg7 != arg5) {
                            }
                            else {
                                throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
                            }
                        }

                        if(arg3 == arg5 || arg1 == arg5) {
                            if(arg7 != arg5) {
                            }
                            else {
                                throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
                            }
                        }

                        if(arg7 >= arg5) {
                            if(arg3 >= arg5 && arg1 >= arg5) {
                                return;
                            }

                            throw new IllegalArgumentException("The transfer function must be positive or increasing");
                        }

                        throw new IllegalArgumentException("The transfer function must be increasing");
                    }
                }

                throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + arg9);
            }

            return;
        }

        throw new IllegalArgumentException("Parameters cannot be NaN");
    }

    public TransferParameters(double arg19, double arg21, double arg23, double arg25, double arg27, double arg29, double arg31, int arg33, DefaultConstructorMarker arg34) {
        double v1 = 0;
        double v14 = (arg33 & 0x20) != 0 ? v1 : arg29;
        double v16 = (arg33 & 0x40) != 0 ? v1 : arg31;
        this(arg19, arg21, arg23, arg25, arg27, v14, v16);
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.a;
    }

    public final double component3() {
        return this.b;
    }

    public final double component4() {
        return this.c;
    }

    public final double component5() {
        return this.d;
    }

    public final double component6() {
        return this.e;
    }

    public final double component7() {
        return this.f;
    }

    public final TransferParameters copy(double arg1, double arg3, double arg5, double arg7, double arg9, double arg11, double arg13) {
        return new TransferParameters(arg1, arg3, arg5, arg7, arg9, arg11, arg13);
    }

    public static TransferParameters copy$default(TransferParameters arg14, double arg15, double arg17, double arg19, double arg21, double arg23, double arg25, double arg27, int arg29, Object arg30) {
        double v0 = (arg29 & 1) != 0 ? arg14.gamma : arg15;
        double v2 = (arg29 & 2) != 0 ? arg14.a : arg17;
        double v4 = (arg29 & 4) != 0 ? arg14.b : arg19;
        double v6 = (arg29 & 8) != 0 ? arg14.c : arg21;
        double v8 = (arg29 & 16) != 0 ? arg14.d : arg23;
        double v10 = (arg29 & 0x20) != 0 ? arg14.e : arg25;
        double v28 = (arg29 & 0x40) != 0 ? arg14.f : arg27;
        return arg14.copy(v0, v2, v4, v6, v8, v10, v28);
    }

    public boolean equals(Object arg8) {
        if(this == (((TransferParameters)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TransferParameters)) {
            return 0;
        }

        if(Double.compare(this.gamma, ((TransferParameters)arg8).gamma) != 0) {
            return 0;
        }

        if(Double.compare(this.a, ((TransferParameters)arg8).a) != 0) {
            return 0;
        }

        if(Double.compare(this.b, ((TransferParameters)arg8).b) != 0) {
            return 0;
        }

        if(Double.compare(this.c, ((TransferParameters)arg8).c) != 0) {
            return 0;
        }

        if(Double.compare(this.d, ((TransferParameters)arg8).d) != 0) {
            return 0;
        }

        if(Double.compare(this.e, ((TransferParameters)arg8).e) != 0) {
            return 0;
        }

        if(Double.compare(this.f, ((TransferParameters)arg8).f) != 0) {
            return 0;
        }

        return 1;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }

    public final double getGamma() {
        return this.gamma;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.gamma) * 0x1F + Double.hashCode(this.a)) * 0x1F + Double.hashCode(this.b)) * 0x1F + Double.hashCode(this.c)) * 0x1F + Double.hashCode(this.d)) * 0x1F + Double.hashCode(this.e)) * 0x1F + Double.hashCode(this.f);
    }

    public final boolean isHLGish$ui_graphics() {
        if(this.gamma == -3) {
            return 1;
        }

        return 0;
    }

    public final boolean isPQish$ui_graphics() {
        if(this.gamma == -2) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }
}


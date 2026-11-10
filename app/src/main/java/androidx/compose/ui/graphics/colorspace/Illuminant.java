package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001C\u001A\u00020\u0019H\u0000¢\u0006\u0002\b\u001DR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007R\u0011\u0010\u0010\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001A\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006\u001E"}, d2={"Landroidx/compose/ui/graphics/colorspace/Illuminant;", "", "<init>", "()V", "A", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getA", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "B", "getB", "C", "getC", "D50", "getD50", "D55", "getD55", "D60", "getD60", "D65", "getD65", "D75", "getD75", "E", "getE", "D50Xyz", "", "getD50Xyz$ui_graphics", "()[F", "newD50Xyz", "newD50Xyz$ui_graphics", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Illuminant {
    public static final int $stable;
    private static final WhitePoint A;
    private static final WhitePoint B;
    private static final WhitePoint C;
    private static final WhitePoint D50;
    private static final float[] D50Xyz;
    private static final WhitePoint D55;
    private static final WhitePoint D60;
    private static final WhitePoint D65;
    private static final WhitePoint D75;
    private static final WhitePoint E;
    public static final Illuminant INSTANCE;

    static {
        Illuminant.INSTANCE = new Illuminant();
        Illuminant.A = new WhitePoint(0.44757f, 0.40745f);
        Illuminant.B = new WhitePoint(0.34842f, 0.35161f);
        Illuminant.C = new WhitePoint(0.31006f, 0.31616f);
        Illuminant.D50 = new WhitePoint(0.34567f, 0.3585f);
        Illuminant.D55 = new WhitePoint(0.33242f, 0.34743f);
        Illuminant.D60 = new WhitePoint(0.32168f, 0.33767f);
        Illuminant.D65 = new WhitePoint(0.31271f, 0.32902f);
        Illuminant.D75 = new WhitePoint(0.29902f, 0.31485f);
        Illuminant.E = new WhitePoint(0.33333f, 0.33333f);
        Illuminant.D50Xyz = new float[]{0.964212f, 1f, 0.825188f};
        Illuminant.$stable = 8;
    }

    private Illuminant() {
        super();
    }

    public final WhitePoint getA() {
        return Illuminant.A;
    }

    public final WhitePoint getB() {
        return Illuminant.B;
    }

    public final WhitePoint getC() {
        return Illuminant.C;
    }

    public final WhitePoint getD50() {
        return Illuminant.D50;
    }

    public final float[] getD50Xyz$ui_graphics() {
        return Illuminant.D50Xyz;
    }

    public final WhitePoint getD55() {
        return Illuminant.D55;
    }

    public final WhitePoint getD60() {
        return Illuminant.D60;
    }

    public final WhitePoint getD65() {
        return Illuminant.D65;
    }

    public final WhitePoint getD75() {
        return Illuminant.D75;
    }

    public final WhitePoint getE() {
        return Illuminant.E;
    }

    public final float[] newD50Xyz$ui_graphics() {
        return new float[]{0.964212f, 1f, 0.825188f};
    }
}


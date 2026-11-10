package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\b\'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/colorspace/Adaptation;", "", "transform", "", "<init>", "([F)V", "getTransform$ui_graphics", "()[F", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Adaptation {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007¨\u0006\f"}, d2={"Landroidx/compose/ui/graphics/colorspace/Adaptation$Companion;", "", "<init>", "()V", "Bradford", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "getBradford", "()Landroidx/compose/ui/graphics/colorspace/Adaptation;", "VonKries", "getVonKries", "Ciecat02", "getCiecat02", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Adaptation getBradford() {
            return Adaptation.Bradford;
        }

        public final Adaptation getCiecat02() {
            return Adaptation.Ciecat02;
        }

        public final Adaptation getVonKries() {
            return Adaptation.VonKries;
        }
    }

    public static final int $stable;
    private static final Adaptation Bradford;
    private static final Adaptation Ciecat02;
    public static final Companion Companion;
    private static final Adaptation VonKries;
    private final float[] transform;

    static {
        Adaptation.Companion = new Companion(null);
        Adaptation.$stable = 8;
        Adaptation.Bradford = new Adaptation$Companion$Bradford$1(new float[]{0.8951f, -0.7502f, 0.0389f, 0.2664f, 1.7135f, -0.0685f, -0.1614f, 0.0367f, 1.0296f});
        Adaptation.VonKries = new Adaptation$Companion$VonKries$1(new float[]{0.40024f, -0.2263f, 0f, 0.7076f, 1.16532f, 0f, -0.08081f, 0.0457f, 0.91822f});
        Adaptation.Ciecat02 = new Adaptation$Companion$Ciecat02$1(new float[]{0.7328f, -0.7036f, 0.003f, 0.4296f, 1.6975f, 0.0136f, -0.1624f, 0.0061f, 0.9834f});
    }

    private Adaptation(float[] arg1) {
        super();
        this.transform = arg1;
    }

    public Adaptation(float[] arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public static final Adaptation access$getBradford$cp() {
        return Adaptation.Bradford;
    }

    public static final Adaptation access$getCiecat02$cp() {
        return Adaptation.Ciecat02;
    }

    public static final Adaptation access$getVonKries$cp() {
        return Adaptation.VonKries;
    }

    public final float[] getTransform$ui_graphics() {
        return this.transform;
    }
}


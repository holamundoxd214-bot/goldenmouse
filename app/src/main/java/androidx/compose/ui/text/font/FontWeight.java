package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0000H\u0096\u0002J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\t\u001A\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001A\u00020\u0003H\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/font/FontWeight;", "", "weight", "", "<init>", "(I)V", "getWeight", "()I", "compareTo", "other", "equals", "", "", "hashCode", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FontWeight implements Comparable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\bR\u001C\u0010\f\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\bR\u001C\u0010\u000F\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001A\u0004\b\u0011\u0010\bR\u001C\u0010\u0012\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001A\u0004\b\u0014\u0010\bR\u001C\u0010\u0015\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001A\u0004\b\u0017\u0010\bR\u001C\u0010\u0018\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001A\u0004\b\u001A\u0010\bR\u001C\u0010\u001B\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001C\u0010\u0003\u001A\u0004\b\u001D\u0010\bR\u001C\u0010\u001E\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001F\u0010\u0003\u001A\u0004\b \u0010\bR\u001C\u0010!\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\"\u0010\u0003\u001A\u0004\b#\u0010\bR\u001C\u0010$\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b%\u0010\u0003\u001A\u0004\b&\u0010\bR\u001C\u0010\'\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b(\u0010\u0003\u001A\u0004\b)\u0010\bR\u001C\u0010*\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b+\u0010\u0003\u001A\u0004\b,\u0010\bR\u001C\u0010-\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b.\u0010\u0003\u001A\u0004\b/\u0010\bR\u001C\u00100\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b1\u0010\u0003\u001A\u0004\b2\u0010\bR\u001C\u00103\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b4\u0010\u0003\u001A\u0004\b5\u0010\bR\u001C\u00106\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b7\u0010\u0003\u001A\u0004\b8\u0010\bR\u001C\u00109\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b:\u0010\u0003\u001A\u0004\b;\u0010\bR\u001A\u0010<\u001A\b\u0012\u0004\u0012\u00020\u00050=X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b>\u0010?¨\u0006@"}, d2={"Landroidx/compose/ui/text/font/FontWeight$Companion;", "", "<init>", "()V", "W100", "Landroidx/compose/ui/text/font/FontWeight;", "getW100$annotations", "getW100", "()Landroidx/compose/ui/text/font/FontWeight;", "W200", "getW200$annotations", "getW200", "W300", "getW300$annotations", "getW300", "W400", "getW400$annotations", "getW400", "W500", "getW500$annotations", "getW500", "W600", "getW600$annotations", "getW600", "W700", "getW700$annotations", "getW700", "W800", "getW800$annotations", "getW800", "W900", "getW900$annotations", "getW900", "Thin", "getThin$annotations", "getThin", "ExtraLight", "getExtraLight$annotations", "getExtraLight", "Light", "getLight$annotations", "getLight", "Normal", "getNormal$annotations", "getNormal", "Medium", "getMedium$annotations", "getMedium", "SemiBold", "getSemiBold$annotations", "getSemiBold", "Bold", "getBold$annotations", "getBold", "ExtraBold", "getExtraBold$annotations", "getExtraBold", "Black", "getBlack$annotations", "getBlack", "values", "", "getValues$ui_text", "()Ljava/util/List;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final FontWeight getBlack() {
            return FontWeight.Black;
        }

        public static void getBlack$annotations() {
        }

        public final FontWeight getBold() {
            return FontWeight.Bold;
        }

        public static void getBold$annotations() {
        }

        public final FontWeight getExtraBold() {
            return FontWeight.ExtraBold;
        }

        public static void getExtraBold$annotations() {
        }

        public final FontWeight getExtraLight() {
            return FontWeight.ExtraLight;
        }

        public static void getExtraLight$annotations() {
        }

        public final FontWeight getLight() {
            return FontWeight.Light;
        }

        public static void getLight$annotations() {
        }

        public final FontWeight getMedium() {
            return FontWeight.Medium;
        }

        public static void getMedium$annotations() {
        }

        public final FontWeight getNormal() {
            return FontWeight.Normal;
        }

        public static void getNormal$annotations() {
        }

        public final FontWeight getSemiBold() {
            return FontWeight.SemiBold;
        }

        public static void getSemiBold$annotations() {
        }

        public final FontWeight getThin() {
            return FontWeight.Thin;
        }

        public static void getThin$annotations() {
        }

        public final List getValues$ui_text() {
            return FontWeight.values;
        }

        public final FontWeight getW100() {
            return FontWeight.W100;
        }

        public static void getW100$annotations() {
        }

        public final FontWeight getW200() {
            return FontWeight.W200;
        }

        public static void getW200$annotations() {
        }

        public final FontWeight getW300() {
            return FontWeight.W300;
        }

        public static void getW300$annotations() {
        }

        public final FontWeight getW400() {
            return FontWeight.W400;
        }

        public static void getW400$annotations() {
        }

        public final FontWeight getW500() {
            return FontWeight.W500;
        }

        public static void getW500$annotations() {
        }

        public final FontWeight getW600() {
            return FontWeight.W600;
        }

        public static void getW600$annotations() {
        }

        public final FontWeight getW700() {
            return FontWeight.W700;
        }

        public static void getW700$annotations() {
        }

        public final FontWeight getW800() {
            return FontWeight.W800;
        }

        public static void getW800$annotations() {
        }

        public final FontWeight getW900() {
            return FontWeight.W900;
        }

        public static void getW900$annotations() {
        }
    }

    public static final int $stable;
    private static final FontWeight Black;
    private static final FontWeight Bold;
    public static final Companion Companion;
    private static final FontWeight ExtraBold;
    private static final FontWeight ExtraLight;
    private static final FontWeight Light;
    private static final FontWeight Medium;
    private static final FontWeight Normal;
    private static final FontWeight SemiBold;
    private static final FontWeight Thin;
    private static final FontWeight W100;
    private static final FontWeight W200;
    private static final FontWeight W300;
    private static final FontWeight W400;
    private static final FontWeight W500;
    private static final FontWeight W600;
    private static final FontWeight W700;
    private static final FontWeight W800;
    private static final FontWeight W900;
    private static final List values;
    private final int weight;

    static {
        FontWeight.Companion = new Companion(null);
        FontWeight v2 = new FontWeight(100);
        FontWeight.W100 = v2;
        FontWeight v3 = new FontWeight(200);
        FontWeight.W200 = v3;
        FontWeight v4 = new FontWeight(300);
        FontWeight.W300 = v4;
        FontWeight v5 = new FontWeight(400);
        FontWeight.W400 = v5;
        FontWeight v6 = new FontWeight(500);
        FontWeight.W500 = v6;
        FontWeight v7 = new FontWeight(600);
        FontWeight.W600 = v7;
        FontWeight v8 = new FontWeight(700);
        FontWeight.W700 = v8;
        FontWeight v9 = new FontWeight(800);
        FontWeight.W800 = v9;
        FontWeight v10 = new FontWeight(900);
        FontWeight.W900 = v10;
        FontWeight.Thin = v2;
        FontWeight.ExtraLight = v3;
        FontWeight.Light = v4;
        FontWeight.Normal = v5;
        FontWeight.Medium = v6;
        FontWeight.SemiBold = v7;
        FontWeight.Bold = v8;
        FontWeight.ExtraBold = v9;
        FontWeight.Black = v10;
        FontWeight.values = CollectionsKt.listOf(new FontWeight[]{v2, v3, v4, v5, v6, v7, v8, v9, v10});
    }

    public FontWeight(int arg3) {
        super();
        this.weight = arg3;
        int v2 = 0;
        if(1 <= arg3 && arg3 < 1001) {
            v2 = 1;
        }

        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Font weight can be in range [1, 1000]. Current value: " + arg3);
        }
    }

    public static final FontWeight access$getBlack$cp() {
        return FontWeight.Black;
    }

    public static final FontWeight access$getBold$cp() {
        return FontWeight.Bold;
    }

    public static final FontWeight access$getExtraBold$cp() {
        return FontWeight.ExtraBold;
    }

    public static final FontWeight access$getExtraLight$cp() {
        return FontWeight.ExtraLight;
    }

    public static final FontWeight access$getLight$cp() {
        return FontWeight.Light;
    }

    public static final FontWeight access$getMedium$cp() {
        return FontWeight.Medium;
    }

    public static final FontWeight access$getNormal$cp() {
        return FontWeight.Normal;
    }

    public static final FontWeight access$getSemiBold$cp() {
        return FontWeight.SemiBold;
    }

    public static final FontWeight access$getThin$cp() {
        return FontWeight.Thin;
    }

    public static final List access$getValues$cp() {
        return FontWeight.values;
    }

    public static final FontWeight access$getW100$cp() {
        return FontWeight.W100;
    }

    public static final FontWeight access$getW200$cp() {
        return FontWeight.W200;
    }

    public static final FontWeight access$getW300$cp() {
        return FontWeight.W300;
    }

    public static final FontWeight access$getW400$cp() {
        return FontWeight.W400;
    }

    public static final FontWeight access$getW500$cp() {
        return FontWeight.W500;
    }

    public static final FontWeight access$getW600$cp() {
        return FontWeight.W600;
    }

    public static final FontWeight access$getW700$cp() {
        return FontWeight.W700;
    }

    public static final FontWeight access$getW800$cp() {
        return FontWeight.W800;
    }

    public static final FontWeight access$getW900$cp() {
        return FontWeight.W900;
    }

    public int compareTo(FontWeight arg1) {
        return Intrinsics.compare(this.weight, arg1.weight);
    }

    public int compareTo(Object arg1) {
        return this.compareTo(((FontWeight)arg1));
    }

    public boolean equals(Object arg4) {
        if(this == (((FontWeight)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FontWeight)) {
            return 0;
        }

        if(this.weight != ((FontWeight)arg4).weight) {
            return 0;
        }

        return 1;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return this.weight;
    }

    public String toString() {
        return "FontWeight(weight=" + this.weight + ')';
    }
}


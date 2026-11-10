package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000E\b\'\u0018\u0000 82\u00020\u0001:\u00018B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\u0012\u0010\u0018\u001A\u00020\u00192\b\b\u0001\u0010\u001A\u001A\u00020\u0007H&J\u0012\u0010\u001B\u001A\u00020\u00192\b\b\u0001\u0010\u001A\u001A\u00020\u0007H&J \u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u00192\u0006\u0010\u001F\u001A\u00020\u00192\u0006\u0010 \u001A\u00020\u0019H\u0007J\u0012\u0010\u001C\u001A\u00020\u001D2\b\b\u0001\u0010!\u001A\u00020\u001DH\'J%\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u00192\u0006\u0010%\u001A\u00020\u00192\u0006\u0010&\u001A\u00020\u0019H\u0010¢\u0006\u0002\b\'J%\u0010(\u001A\u00020\u00192\u0006\u0010$\u001A\u00020\u00192\u0006\u0010%\u001A\u00020\u00192\u0006\u0010&\u001A\u00020\u0019H\u0010¢\u0006\u0002\b)J7\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020\u00192\u0006\u0010-\u001A\u00020\u00192\u0006\u0010.\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u00192\u0006\u00100\u001A\u00020\u0000H\u0010¢\u0006\u0004\b1\u00102J \u00103\u001A\u00020\u001D2\u0006\u0010,\u001A\u00020\u00192\u0006\u0010-\u001A\u00020\u00192\u0006\u0010.\u001A\u00020\u0019H\u0007J\u0012\u00103\u001A\u00020\u001D2\b\b\u0001\u0010!\u001A\u00020\u001DH\'J\b\u00104\u001A\u00020\u0003H\u0016J\u0013\u00105\u001A\u00020\u00152\b\u00106\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00107\u001A\u00020\u0007H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u0006\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u00078G¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0016¨\u00069"}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", "name", "", "model", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "id", "", "<init>", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getModel-xdoWZVw", "()J", "J", "getId$ui_graphics", "()I", "componentCount", "getComponentCount", "isWideGamut", "", "()Z", "isSrgb", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "r", "g", "b", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics", "toZ", "toZ$ui_graphics", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "toString", "equals", "other", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ColorSpace {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorSpace$Companion;", "", "<init>", "()V", "MinId", "", "MaxId", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int MaxId = 0x3F;
    public static final int MinId = -1;
    private final int id;
    private final long model;
    private final String name;

    static {
        ColorSpace.Companion = new Companion(null);
    }

    private ColorSpace(String arg7, long arg8) {
        this(arg7, arg8, -1, null);
    }

    public ColorSpace(String arg1, long arg2, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    private ColorSpace(String arg1, long arg2, int arg4) {
        super();
        this.name = arg1;
        this.model = arg2;
        this.id = arg4;
        if(((CharSequence)arg1).length() != 0) {
            if(arg4 >= -1 && arg4 <= 0x3F) {
                return;
            }

            throw new IllegalArgumentException("The id must be between -1 and 63");
        }

        throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
    }

    public ColorSpace(String arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    public boolean equals(Object arg4) {
        if(this == (((ColorSpace)arg4))) {
            return 1;
        }

        if(arg4 != null) {
            if(this.getClass() != arg4.getClass()) {
            }
            else if(this.id != ((ColorSpace)arg4).id) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.name, ((ColorSpace)arg4).name)) {
                return 0;
            }
            else {
                return ColorModel.equals-impl0(this.model, ((ColorSpace)arg4).model);
            }
        }

        return 0;
    }

    public final float[] fromXyz(float arg3, float arg4, float arg5) {
        float[] v0 = new float[ColorModel.getComponentCount-impl(this.model)];
        v0[0] = arg3;
        v0[1] = arg4;
        v0[2] = arg5;
        return this.fromXyz(v0);
    }

    public abstract float[] fromXyz(float[] arg1);

    public final int getComponentCount() {
        return ColorModel.getComponentCount-impl(this.model);
    }

    public final int getId$ui_graphics() {
        return this.id;
    }

    public abstract float getMaxValue(int arg1);

    public abstract float getMinValue(int arg1);

    public final long getModel-xdoWZVw() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 0x1F + ColorModel.hashCode-impl(this.model)) * 0x1F + this.id;
    }

    public boolean isSrgb() {
        return 0;
    }

    public abstract boolean isWideGamut();

    public String toString() {
        return this.name + " (id=" + this.id + ", model=" + ColorModel.toString-impl(this.model) + ')';
    }

    public long toXy$ui_graphics(float arg3, float arg4, float arg5) {
        float[] v2 = this.toXyz(arg3, arg4, arg5);
        return (((long)Float.floatToRawIntBits(v2[0]))) << 0x20 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(v2[1])));
    }

    public final float[] toXyz(float arg3, float arg4, float arg5) {
        return this.toXyz(new float[]{arg3, arg4, arg5});
    }

    public abstract float[] toXyz(float[] arg1);

    public float toZ$ui_graphics(float arg1, float arg2, float arg3) {
        return this.toXyz(arg1, arg2, arg3)[2];
    }

    public long xyzaToColor-JlNiLsg$ui_graphics(float arg1, float arg2, float arg3, float arg4, ColorSpace arg5) {
        float[] v0 = this.fromXyz(arg1, arg2, arg3);
        return ColorKt.Color(v0[0], v0[1], v0[2], arg4, arg5);
    }
}


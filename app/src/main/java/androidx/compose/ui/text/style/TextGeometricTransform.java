package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001A\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/style/TextGeometricTransform;", "", "scaleX", "", "skewX", "<init>", "(FF)V", "getScaleX", "()F", "getSkewX", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextGeometricTransform {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "getNone$ui_text$annotations", "getNone$ui_text", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TextGeometricTransform getNone$ui_text() {
            return TextGeometricTransform.None;
        }

        public static void getNone$ui_text$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TextGeometricTransform None;
    private final float scaleX;
    private final float skewX;

    static {
        TextGeometricTransform.Companion = new Companion(null);
        TextGeometricTransform.None = new TextGeometricTransform(1f, 0f);
    }

    public TextGeometricTransform(float arg1, float arg2) {
        super();
        this.scaleX = arg1;
        this.skewX = arg2;
    }

    public TextGeometricTransform() {
        this(0f, 0f, 3, null);
    }

    public TextGeometricTransform(float arg1, float arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 1f;
        }

        this(arg1, 0f);
    }

    public static final TextGeometricTransform access$getNone$cp() {
        return TextGeometricTransform.None;
    }

    public final TextGeometricTransform copy(float arg1, float arg2) {
        return new TextGeometricTransform(arg1, arg2);
    }

    public static TextGeometricTransform copy$default(TextGeometricTransform arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.scaleX;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.skewX;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((TextGeometricTransform)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof TextGeometricTransform)) {
            return 0;
        }

        if(this.scaleX == ((TextGeometricTransform)arg5).scaleX && this.skewX == ((TextGeometricTransform)arg5).skewX) {
            return 1;
        }

        return 0;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getSkewX() {
        return this.skewX;
    }

    public int hashCode() {
        return Float.hashCode(this.scaleX) * 0x1F + Float.hashCode(this.skewX);
    }

    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.scaleX + ", skewX=" + this.skewX + ')';
    }
}


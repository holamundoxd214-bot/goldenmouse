package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/text/font/GenericFontFamily;", "Landroidx/compose/ui/text/font/SystemFontFamily;", "name", "", "fontFamilyName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GenericFontFamily extends SystemFontFamily {
    public static final int $stable;
    private final String fontFamilyName;
    private final String name;

    static {
    }

    public GenericFontFamily(String arg2, String arg3) {
        super(null);
        this.name = arg2;
        this.fontFamilyName = arg3;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.fontFamilyName;
    }
}


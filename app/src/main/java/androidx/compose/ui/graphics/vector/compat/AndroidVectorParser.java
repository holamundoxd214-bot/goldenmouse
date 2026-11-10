package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0005H\u0002J,\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\f\u0010\u0017\u001A\b\u0018\u00010\u0018R\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CJ(\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020 2\b\b\u0001\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u0005J(\u0010#\u001A\u00020$2\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020 2\b\b\u0001\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020$J(\u0010%\u001A\u00020&2\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020 2\b\b\u0001\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020&J\u001E\u0010\'\u001A\u00020$2\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010(\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020$J\u001E\u0010)\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010(\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u0005J\u0018\u0010*\u001A\u0004\u0018\u00010 2\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010(\u001A\u00020\u0005J\u001E\u0010+\u001A\u00020$2\u0006\u0010\u001E\u001A\u00020\u00142\u0006\u0010(\u001A\u00020\u00052\u0006\u0010,\u001A\u00020$J8\u0010-\u001A\u00020.2\u0006\u0010\u001E\u001A\u00020\u00142\f\u0010\u0017\u001A\b\u0018\u00010\u0018R\u00020\u00162\u0006\u0010\u001F\u001A\u00020 2\b\b\u0001\u0010!\u001A\u00020\u00052\b\b\u0001\u0010\"\u001A\u00020\u0005J0\u0010/\u001A\u0004\u0018\u0001002\u0006\u0010\u001E\u001A\u00020\u00142\f\u0010\u0017\u001A\b\u0018\u00010\u0018R\u00020\u00162\u0006\u0010\u001F\u001A\u00020 2\b\b\u0001\u0010!\u001A\u00020\u0005J\t\u00101\u001A\u00020\u0003HÆ\u0003J\t\u00102\u001A\u00020\u0005HÆ\u0003J\u001D\u00103\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u00104\u001A\u00020&2\b\u00105\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001A\u00020\u0005HÖ\u0001J\t\u00107\u001A\u00020 HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0010\u0010\u000E\u001A\u00020\u000F8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2={"Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "", "xmlParser", "Lorg/xmlpull/v1/XmlPullParser;", "config", "", "<init>", "(Lorg/xmlpull/v1/XmlPullParser;I)V", "getXmlParser", "()Lorg/xmlpull/v1/XmlPullParser;", "getConfig", "()I", "setConfig", "(I)V", "pathParser", "Landroidx/compose/ui/graphics/vector/PathParser;", "updateConfig", "", "resConfig", "obtainAttributes", "Landroid/content/res/TypedArray;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "set", "Landroid/util/AttributeSet;", "attrs", "", "getNamedInt", "typedArray", "attrName", "", "resId", "defaultValue", "getNamedFloat", "", "getNamedBoolean", "", "getFloat", "index", "getInt", "getString", "getDimension", "defValue", "getNamedComplexColor", "Landroidx/core/content/res/ComplexColorCompat;", "getNamedColorStateList", "Landroid/content/res/ColorStateList;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidVectorParser {
    public static final int $stable = 8;
    private int config;
    public final PathParser pathParser;
    private final XmlPullParser xmlParser;

    static {
    }

    public AndroidVectorParser(XmlPullParser arg1, int arg2) {
        super();
        this.xmlParser = arg1;
        this.config = arg2;
        this.pathParser = new PathParser();
    }

    public AndroidVectorParser(XmlPullParser arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, 0);
    }

    public final XmlPullParser component1() {
        return this.xmlParser;
    }

    public final int component2() {
        return this.config;
    }

    public final AndroidVectorParser copy(XmlPullParser arg1, int arg2) {
        return new AndroidVectorParser(arg1, arg2);
    }

    public static AndroidVectorParser copy$default(AndroidVectorParser arg0, XmlPullParser arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.xmlParser;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.config;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((AndroidVectorParser)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AndroidVectorParser)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.xmlParser, ((AndroidVectorParser)arg5).xmlParser)) {
            return 0;
        }

        if(this.config != ((AndroidVectorParser)arg5).config) {
            return 0;
        }

        return 1;
    }

    public final int getConfig() {
        return this.config;
    }

    public final float getDimension(TypedArray arg1, int arg2, float arg3) {
        float v2 = arg1.getDimension(arg2, arg3);
        this.updateConfig(arg1.getChangingConfigurations());
        return v2;
    }

    public final float getFloat(TypedArray arg1, int arg2, float arg3) {
        float v2 = arg1.getFloat(arg2, arg3);
        this.updateConfig(arg1.getChangingConfigurations());
        return v2;
    }

    public final int getInt(TypedArray arg1, int arg2, int arg3) {
        arg2 = arg1.getInt(arg2, arg3);
        this.updateConfig(arg1.getChangingConfigurations());
        return arg2;
    }

    public final boolean getNamedBoolean(TypedArray arg2, String arg3, int arg4, boolean arg5) {
        boolean v3 = TypedArrayUtils.getNamedBoolean(arg2, this.xmlParser, arg3, arg4, arg5);
        this.updateConfig(arg2.getChangingConfigurations());
        return v3;
    }

    public final ColorStateList getNamedColorStateList(TypedArray arg2, Resources$Theme arg3, String arg4, int arg5) {
        ColorStateList v3 = TypedArrayUtils.getNamedColorStateList(arg2, this.xmlParser, arg3, arg4, arg5);
        this.updateConfig(arg2.getChangingConfigurations());
        return v3;
    }

    public final ComplexColorCompat getNamedComplexColor(TypedArray arg7, Resources$Theme arg8, String arg9, int arg10, int arg11) {
        TypedArray v0 = arg7;
        ComplexColorCompat v7 = TypedArrayUtils.getNamedComplexColor(v0, this.xmlParser, arg8, arg9, arg10, arg11);
        this.updateConfig(v0.getChangingConfigurations());
        return v7;
    }

    public final float getNamedFloat(TypedArray arg2, String arg3, int arg4, float arg5) {
        float v3 = TypedArrayUtils.getNamedFloat(arg2, this.xmlParser, arg3, arg4, arg5);
        this.updateConfig(arg2.getChangingConfigurations());
        return v3;
    }

    public final int getNamedInt(TypedArray arg2, String arg3, int arg4, int arg5) {
        int v3 = TypedArrayUtils.getNamedInt(arg2, this.xmlParser, arg3, arg4, arg5);
        this.updateConfig(arg2.getChangingConfigurations());
        return v3;
    }

    public final String getString(TypedArray arg1, int arg2) {
        String v2 = arg1.getString(arg2);
        this.updateConfig(arg1.getChangingConfigurations());
        return v2;
    }

    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    public int hashCode() {
        return this.xmlParser.hashCode() * 0x1F + Integer.hashCode(this.config);
    }

    public final TypedArray obtainAttributes(Resources arg1, Resources$Theme arg2, AttributeSet arg3, int[] arg4) {
        TypedArray v1 = TypedArrayUtils.obtainAttributes(arg1, arg2, arg3, arg4);
        this.updateConfig(v1.getChangingConfigurations());
        return v1;
    }

    public final void setConfig(int arg1) {
        this.config = arg1;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.xmlParser + ", config=" + this.config + ')';
    }

    private final void updateConfig(int arg2) {
        this.config |= arg2;
    }
}


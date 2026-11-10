package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader arg1, ColorStateList arg2, int arg3) {
        super();
        this.mShader = arg1;
        this.mColorStateList = arg2;
        this.mColor = arg3;
    }

    private static ComplexColorCompat createFromXml(Resources arg4, int arg5, Resources$Theme arg6) throws IOException, XmlPullParserException {
        XmlResourceParser v5 = arg4.getXml(arg5);
        AttributeSet v0 = Xml.asAttributeSet(((XmlPullParser)v5));
        while(true) {
            int v1 = ((XmlPullParser)v5).next();
            int v2 = 2;
            if(v1 != v2 && v1 != 1) {
                continue;
            }

            break;
        }

        if(v1 == v2) {
            String v1_1 = ((XmlPullParser)v5).getName();
            v1_1.hashCode();
            if(!v1_1.equals("gradient")) {
                if(v1_1.equals("selector")) {
                    return ComplexColorCompat.from(ColorStateListInflaterCompat.createFromXmlInner(arg4, ((XmlPullParser)v5), v0, arg6));
                }

                throw new XmlPullParserException(((XmlPullParser)v5).getPositionDescription() + ": unsupported complex color tag " + v1_1);
            }

            return ComplexColorCompat.from(GradientColorInflaterCompat.createFromXmlInner(arg4, ((XmlPullParser)v5), v0, arg6));
        }

        throw new XmlPullParserException("No start tag found");
    }

    static ComplexColorCompat from(ColorStateList arg3) {
        return new ComplexColorCompat(null, arg3, arg3.getDefaultColor());
    }

    static ComplexColorCompat from(Shader arg3) {
        return new ComplexColorCompat(arg3, null, 0);
    }

    static ComplexColorCompat from(int arg2) {
        return new ComplexColorCompat(null, null, arg2);
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public static ComplexColorCompat inflate(Resources arg0, int arg1, Resources$Theme arg2) {
        try {
            return ComplexColorCompat.createFromXml(arg0, arg1, arg2);
        }
        catch(Exception v0) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", ((Throwable)v0));
            return null;
        }
    }

    public boolean isGradient() {
        if(this.mShader != null) {
            return 1;
        }

        return 0;
    }

    public boolean isStateful() {
        if(this.mShader == null) {
            ColorStateList v1 = this.mColorStateList;
            if(v1 != null && (v1.isStateful())) {
                return 1;
            }
        }

        return 0;
    }

    public boolean onStateChanged(int[] arg3) {
        if(this.isStateful()) {
            int v3 = this.mColorStateList.getColorForState(arg3, this.mColorStateList.getDefaultColor());
            if(v3 != this.mColor) {
                this.mColor = v3;
                return 1;
            }
        }

        return 0;
    }

    public void setColor(int arg1) {
        this.mColor = arg1;
    }

    public boolean willDraw() {
        if(!this.isGradient()) {
            if(this.mColor != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}


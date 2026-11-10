package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class Compatibility {
    public class Api15Impl {
        private Api15Impl() {
            super();
        }

        public static void getValueForDensity(Resources arg0, int arg1, int arg2, TypedValue arg3, boolean arg4) {
            arg0.getValueForDensity(arg1, arg2, arg3, arg4);
        }
    }

    public class Api18Impl {
        private Api18Impl() {
            super();
        }

        public static void setAutoCancel(ObjectAnimator arg0, boolean arg1) {
            arg0.setAutoCancel(arg1);
        }
    }

    public class Api21Impl {
        private Api21Impl() {
            super();
        }

        public static Drawable createFromXmlInner(Resources arg0, XmlPullParser arg1, AttributeSet arg2, Resources$Theme arg3) throws IOException, XmlPullParserException {
            return Drawable.createFromXmlInner(arg0, arg1, arg2, arg3);
        }

        public static int getChangingConfigurations(TypedArray arg0) {
            return arg0.getChangingConfigurations();
        }

        public static void inflate(Drawable arg0, Resources arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) throws IOException, XmlPullParserException {
            arg0.inflate(arg1, arg2, arg3, arg4);
        }
    }

    private Compatibility() {
        super();
    }
}


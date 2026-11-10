package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector$Companion;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorParser;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0018\u00010\u0007R\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0004\u001A0\u0010\u000B\u001A\u00020\f2\u000E\b\u0002\u0010\u0006\u001A\b\u0018\u00010\u0007R\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0004H\u0000¨\u0006\u0010"}, d2={"vectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "id", "", "(Landroidx/compose/ui/graphics/vector/ImageVector$Companion;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "res", "resId", "loadVectorResourceInner", "Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "parser", "Landroid/content/res/XmlResourceParser;", "changingConfigurations", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class VectorResources_androidKt {
    public static final ImageVectorEntry loadVectorResourceInner(Resources$Theme arg7, Resources arg8, XmlResourceParser arg9, int arg10) throws XmlPullParserException {
        XmlResourceParser v0 = arg9;
        AttributeSet v3 = Xml.asAttributeSet(((XmlPullParser)v0));
        AndroidVectorParser v1 = new AndroidVectorParser(((XmlPullParser)v0), 0, 2, null);
        Builder v5 = XmlVectorParser_androidKt.createVectorImageBuilder(v1, arg8, arg7, v3);
        int v6 = 0;
        while(!XmlVectorParser_androidKt.isAtEnd(((XmlPullParser)v0))) {
            v6 = XmlVectorParser_androidKt.parseCurrentVectorNode(v1, arg8, v3, arg7, v5, v6);
            arg9.next();
        }

        return new ImageVectorEntry(v5.build(), v1.getConfig() | arg10);
    }

    public static ImageVectorEntry loadVectorResourceInner$default(Resources$Theme arg0, Resources arg1, XmlResourceParser arg2, int arg3, int arg4, Object arg5) throws XmlPullParserException {
        if((arg4 & 1) != 0) {
            arg0 = null;
        }

        return VectorResources_androidKt.loadVectorResourceInner(arg0, arg1, arg2, arg3);
    }

    public static final ImageVector vectorResource(Companion arg5, int arg6, Composer arg7, int arg8) {
        ImageVector v2_2;
        int v1 = 44534090;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(vectorResource)49@2017L7,50@2054L7,53@2104L78:VectorResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.ui.res.vectorResource (VectorResources.android.kt:48)");
        }

        ProvidableCompositionLocal v0 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_1 = arg7.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        ProvidableCompositionLocal v3 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = arg7.consume(((CompositionLocal)v3));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        Resources$Theme v0_2 = ((Context)v0_1).getTheme();
        Configuration v2 = ((Resources)v1_1).getConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg7, -152406120, "CC(remember):VectorResources.android.kt#9igjgp");
        int v4 = 0x20;
        arg8 = (arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4 ? 1 : 0;
        arg8 = arg8 | arg7.changed(v1_1) | arg7.changed(v0_2) | arg7.changed(v2);
        Object v2_1 = arg7.rememberedValue();
        if(arg8 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            v2_2 = VectorResources_androidKt.vectorResource(arg5, v0_2, ((Resources)v1_1), arg6);
            arg7.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return v2_2;
    }

    public static final ImageVector vectorResource(Companion arg1, Resources$Theme arg2, Resources arg3, int arg4) throws XmlPullParserException {
        TypedValue v1 = new TypedValue();
        arg3.getValue(arg4, v1, true);
        XmlResourceParser v4 = arg3.getXml(arg4);
        XmlVectorParser_androidKt.seekToStartTag(v4);
        return VectorResources_androidKt.loadVectorResourceInner(arg2, arg3, v4, v1.changingConfigurations).getImageVector();
    }

    public static ImageVector vectorResource$default(Companion arg0, Resources$Theme arg1, Resources arg2, int arg3, int arg4, Object arg5) throws XmlPullParserException {
        if((arg4 & 1) != 0) {
            arg1 = null;
        }

        return VectorResources_androidKt.vectorResource(arg0, arg1, arg2, arg3);
    }
}


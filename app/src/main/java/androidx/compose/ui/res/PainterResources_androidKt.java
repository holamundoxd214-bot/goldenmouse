package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001A1\u0010\u0005\u001A\u00020\u00062\n\u0010\u0007\u001A\u00060\bR\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003H\u0003¢\u0006\u0002\u0010\f\u001A \u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002\"\u000E\u0010\u0011\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "id", "", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "res", "changingConfigurations", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;IILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "path", "", "errorMessage", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PainterResources_androidKt {
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP";

    private static final ImageBitmap loadImageBitmapResource(CharSequence arg2, Resources arg3, int arg4) {
        ImageBitmap v2;
        try {
            v2 = ImageResources_androidKt.imageResource(ImageBitmap.Companion, arg3, arg4);
            return v2;
        }
        catch(Exception v3) {
            throw new ResourceResolutionException("Error attempting to load resource: " + v2, ((Throwable)v3));
        }
    }

    private static final ImageVector loadVectorResource(Resources$Theme arg3, Resources arg4, int arg5, int arg6, Composer arg7, int arg8) {
        int v1 = 0x14D7D89;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(loadVectorResource)P(3,2,1)88@3590L7:PainterResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:87)");
        }

        ProvidableCompositionLocal v8 = AndroidCompositionLocals_androidKt.getLocalImageVectorCache();
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v8_1 = arg7.consume(((CompositionLocal)v8));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        Key v0 = new Key(arg3, arg5);
        ImageVectorEntry v1_1 = ((ImageVectorCache)v8_1).get(v0);
        if(v1_1 == null) {
            XmlResourceParser v5 = arg4.getXml(arg5);
            if(Intrinsics.areEqual(XmlVectorParser_androidKt.seekToStartTag(v5).getName(), "vector")) {
                v1_1 = VectorResources_androidKt.loadVectorResourceInner(arg3, arg4, v5, arg6);
                ((ImageVectorCache)v8_1).set(v0, v1_1);
            }
            else {
                throw new IllegalArgumentException("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
            }
        }

        ImageVector v3 = v1_1.getImageVector();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return v3;
    }

    public static final Painter painterResource(int arg11, Composer arg12, int arg13) {
        VectorPainter v11;
        Composer v8;
        int v1 = 0x1C403A8F;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(painterResource)57@2480L7,59@2518L7,60@2573L7:PainterResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.ui.res.painterResource (PainterResources.android.kt:56)");
        }

        ProvidableCompositionLocal v0 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_1 = arg12.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        ProvidableCompositionLocal v3 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v3_1 = arg12.consume(((CompositionLocal)v3));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        Object v5 = v3_1;
        v3 = AndroidCompositionLocals_androidKt.getLocalResourceIdCache();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_1 = arg12.consume(((CompositionLocal)v3));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        TypedValue v1_2 = ((ResourceIdCache)v1_1).resolveResourcePath(((Resources)v5), arg11);
        CharSequence v2 = v1_2.string;
        int v3_2 = 1;
        if(v2 == null || !StringsKt.endsWith$default(v2, ".xml", false, 2, null)) {
            int v6 = arg11;
            v8 = arg12;
            v8.startReplaceGroup(-1771643000);
            ComposerKt.sourceInformation(v8, "71@3027L76");
            Resources$Theme v11_1 = ((Context)v0_1).getTheme();
            ComposerKt.sourceInformationMarkerStart(v8, 0xD1C21FB, "CC(remember):PainterResources.android.kt#9igjgp");
            boolean v12 = v8.changed(v2);
            v1 = 4;
            if((arg13 & 14 ^ 6) <= v1 || !v8.changed(v6)) {
                if((arg13 & 6) == v1) {
                }
                else {
                    v3_2 = 0;
                }
            }

            arg11 = v8.changed(v11_1) | ((((int)v12)) | v3_2);
            Object v12_1 = v8.rememberedValue();
            if(arg11 != 0 || v12_1 == Composer.Companion.getEmpty()) {
                ImageBitmap v12_2 = PainterResources_androidKt.loadImageBitmapResource(v2, ((Resources)v5), v6);
                v8.updateRememberedValue(v12_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            BitmapPainter v0_2 = new BitmapPainter(v12_1, 0, 0, 6, null);
            v8.endReplaceGroup();
            BitmapPainter v11_2 = v0_2;
        }
        else {
            arg12.startReplaceGroup(0x9664805E);
            ComposerKt.sourceInformation(arg12, "66@2814L72,67@2895L34");
            v8 = arg12;
            v11 = VectorPainterKt.rememberVectorPainter(PainterResources_androidKt.loadVectorResource(((Context)v0_1).getTheme(), ((Resources)v5), arg11, v1_2.changingConfigurations, v8, arg13 << 6 & 0x380), v8, 0);
            v8.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v8);
        return ((Painter)v11);
    }
}


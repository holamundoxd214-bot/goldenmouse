package androidx.compose.ui.res;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap$Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0001\u0010\u0005\u001A\u00020\u0006\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"imageResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/graphics/ImageBitmap$Companion;", "res", "Landroid/content/res/Resources;", "id", "", "(Landroidx/compose/ui/graphics/ImageBitmap$Companion;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/ImageBitmap;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ImageResources_androidKt {
    public static final ImageBitmap imageResource(Companion arg3, int arg4, Composer arg5, int arg6) {
        int v1 = -304919470;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(imageResource)53@2050L7,54@2074L25,57@2234L46:ImageResources.android.kt#ccshc7");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.ui.res.imageResource (ImageResources.android.kt:52)");
        }

        ProvidableCompositionLocal v6 = AndroidCompositionLocals_androidKt.getLocalResources();
        ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v6_1 = arg5.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        String v1_1 = "CC(remember):ImageResources.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg5, 0xC63190EB, v1_1);
        Object v0 = arg5.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            TypedValue v0_1 = new TypedValue();
            arg5.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        ((Resources)v6_1).getValue(arg4, ((TypedValue)v0), true);
        CharSequence v0_2 = ((TypedValue)v0).string;
        Intrinsics.checkNotNull(v0_2);
        String v0_3 = v0_2.toString();
        ComposerKt.sourceInformationMarkerStart(arg5, 0xC631A500, v1_1);
        boolean v0_4 = arg5.changed(v0_3);
        Object v1_2 = arg5.rememberedValue();
        if((v0_4) || v1_2 == Composer.Companion.getEmpty()) {
            ImageBitmap v1_3 = ImageResources_androidKt.imageResource(arg3, ((Resources)v6_1), arg4);
            arg5.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return ((ImageBitmap)v1_2);
    }

    public static final ImageBitmap imageResource(Companion arg0, Resources arg1, int arg2) {
        Drawable v0 = arg1.getDrawable(arg2, null);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        return AndroidImageBitmap_androidKt.asImageBitmap(((BitmapDrawable)v0).getBitmap());
    }
}


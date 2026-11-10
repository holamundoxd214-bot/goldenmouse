package androidx.compose.material3.carousel;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\n*\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0017¢\u0006\u0002\u0010\rJ!\u0010\u000E\u001A\u00020\n*\u00020\n2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\fH\u0017¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000B\u001A\u00020\fH\u0017¢\u0006\u0002\u0010\u0014R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/material3/carousel/CarouselItemScopeImpl;", "Landroidx/compose/material3/carousel/CarouselItemScope;", "itemInfo", "Landroidx/compose/material3/carousel/CarouselItemDrawInfo;", "<init>", "(Landroidx/compose/material3/carousel/CarouselItemDrawInfo;)V", "carouselItemDrawInfo", "getCarouselItemDrawInfo", "()Landroidx/compose/material3/carousel/CarouselItemDrawInfo;", "maskClip", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "maskBorder", "border", "Landroidx/compose/foundation/BorderStroke;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "rememberMaskShape", "Landroidx/compose/foundation/shape/GenericShape;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/GenericShape;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CarouselItemScopeImpl implements CarouselItemScope {
    public static final int $stable = 8;
    private final CarouselItemDrawInfo itemInfo;

    static {
    }

    public CarouselItemScopeImpl(CarouselItemDrawInfo arg1) {
        super();
        this.itemInfo = arg1;
    }

    public CarouselItemDrawInfo getCarouselItemDrawInfo() {
        return this.itemInfo;
    }

    public Modifier maskBorder(Modifier arg4, BorderStroke arg5, Shape arg6, Composer arg7, int arg8) {
        int v0 = 0x24698F68;
        arg7.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(maskBorder)N(border,shape)85@3421L32:CarouselItemScope.kt#dcf9yb");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg8, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.maskBorder (CarouselItemScope.kt:85)");
        }

        Modifier v3 = BorderKt.border(arg4, arg5, this.rememberMaskShape(arg6, arg7, arg8 >> 6 & 0x7E));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg7.endReplaceGroup();
        return v3;
    }

    public Modifier maskClip(Modifier arg4, Shape arg5, Composer arg6, int arg7) {
        int v0 = 440683050;
        arg6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(maskClip)N(shape)81@3262L32:CarouselItemScope.kt#dcf9yb");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg7, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.maskClip (CarouselItemScope.kt:81)");
        }

        Modifier v3 = ClipKt.clip(arg4, this.rememberMaskShape(arg5, arg6, arg7 >> 3 & 0x7E));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg6.endReplaceGroup();
        return v3;
    }

    public GenericShape rememberMaskShape(Shape arg4, Composer arg5, int arg6) {
        int v0 = 0x91838A8;
        arg5.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(rememberMaskShape)N(shape)89@3572L7,90@3595L327:CarouselItemScope.kt#dcf9yb");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.material3.carousel.CarouselItemScopeImpl.rememberMaskShape (CarouselItemScope.kt:88)");
        }

        ProvidableCompositionLocal v6 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v6_1 = arg5.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(arg5);
        CarouselItemDrawInfo v0_1 = this.getCarouselItemDrawInfo();
        ComposerKt.sourceInformationMarkerStart(arg5, 0x23ECC0CF, "CC(remember):CarouselItemScope.kt#9igjgp");
        v0 = arg5.changed(v0_1) | arg5.changed(v6_1);
        Object v1 = arg5.rememberedValue();
        if(v0 != 0 || v1 == Composer.Companion.getEmpty()) {
            GenericShape v1_1 = new GenericShape(new CarouselItemScopeImpl$$ExternalSyntheticLambda0(this, arg4, ((Density)v6_1)));
            arg5.updateRememberedValue(v1_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return ((GenericShape)v1);
    }

    static final Unit rememberMaskShape$lambda$1$lambda$0(CarouselItemScopeImpl arg2, Shape arg3, Density arg4, Path arg5, Size arg6, LayoutDirection arg7) {
        Rect v2 = arg2.getCarouselItemDrawInfo().getMaskRect().intersect(SizeKt.toRect-uvyYCjk(arg6.unbox-impl()));
        OutlineKt.addOutline(arg5, arg3.createOutline-Pq9zytI(v2.getSize-NH-jbRc(), arg7, arg4));
        arg5.translate-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(v2.getLeft()))) << 0x20 | (((long)Float.floatToRawIntBits(v2.getTop()))) & 0xFFFFFFFFL));
        return Unit.INSTANCE;
    }
}


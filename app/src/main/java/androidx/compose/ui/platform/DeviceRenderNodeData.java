package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\ba\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000E\u001A\u00020\f\u0012\u0006\u0010\u000F\u001A\u00020\f\u0012\u0006\u0010\u0010\u001A\u00020\f\u0012\u0006\u0010\u0011\u001A\u00020\u0005\u0012\u0006\u0010\u0012\u001A\u00020\u0005\u0012\u0006\u0010\u0013\u001A\u00020\f\u0012\u0006\u0010\u0014\u001A\u00020\f\u0012\u0006\u0010\u0015\u001A\u00020\f\u0012\u0006\u0010\u0016\u001A\u00020\f\u0012\u0006\u0010\u0017\u001A\u00020\f\u0012\u0006\u0010\u0018\u001A\u00020\f\u0012\u0006\u0010\u0019\u001A\u00020\u001A\u0012\u0006\u0010\u001B\u001A\u00020\u001A\u0012\u0006\u0010\u001C\u001A\u00020\f\u0012\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E\u0012\u0006\u0010\u001F\u001A\u00020 \u0012\b\u0010!\u001A\u0004\u0018\u00010\"\u0012\u0006\u0010#\u001A\u00020$¢\u0006\u0004\b%\u0010&J\t\u0010b\u001A\u00020\u0003HÆ\u0003J\t\u0010c\u001A\u00020\u0005HÆ\u0003J\t\u0010d\u001A\u00020\u0005HÆ\u0003J\t\u0010e\u001A\u00020\u0005HÆ\u0003J\t\u0010f\u001A\u00020\u0005HÆ\u0003J\t\u0010g\u001A\u00020\u0005HÆ\u0003J\t\u0010h\u001A\u00020\u0005HÆ\u0003J\t\u0010i\u001A\u00020\fHÆ\u0003J\t\u0010j\u001A\u00020\fHÆ\u0003J\t\u0010k\u001A\u00020\fHÆ\u0003J\t\u0010l\u001A\u00020\fHÆ\u0003J\t\u0010m\u001A\u00020\fHÆ\u0003J\t\u0010n\u001A\u00020\u0005HÆ\u0003J\t\u0010o\u001A\u00020\u0005HÆ\u0003J\t\u0010p\u001A\u00020\fHÆ\u0003J\t\u0010q\u001A\u00020\fHÆ\u0003J\t\u0010r\u001A\u00020\fHÆ\u0003J\t\u0010s\u001A\u00020\fHÆ\u0003J\t\u0010t\u001A\u00020\fHÆ\u0003J\t\u0010u\u001A\u00020\fHÆ\u0003J\t\u0010v\u001A\u00020\u001AHÆ\u0003J\t\u0010w\u001A\u00020\u001AHÆ\u0003J\t\u0010x\u001A\u00020\fHÆ\u0003J\u000B\u0010y\u001A\u0004\u0018\u00010\u001EHÆ\u0003J\u0010\u0010z\u001A\u00020 HÆ\u0003¢\u0006\u0004\b{\u0010*J\u000B\u0010|\u001A\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010}\u001A\u00020$HÆ\u0003¢\u0006\u0004\b~\u0010*J¤\u0002\u0010\u007F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\f2\b\b\u0002\u0010\u000F\u001A\u00020\f2\b\b\u0002\u0010\u0010\u001A\u00020\f2\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0012\u001A\u00020\u00052\b\b\u0002\u0010\u0013\u001A\u00020\f2\b\b\u0002\u0010\u0014\u001A\u00020\f2\b\b\u0002\u0010\u0015\u001A\u00020\f2\b\b\u0002\u0010\u0016\u001A\u00020\f2\b\b\u0002\u0010\u0017\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\f2\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001A2\b\b\u0002\u0010\u001C\u001A\u00020\f2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\b\b\u0002\u0010\u001F\u001A\u00020 2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001A\u00020$HÆ\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0015\u0010\u0082\u0001\u001A\u00020\u001A2\t\u0010\u0083\u0001\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0084\u0001\u001A\u00020\u0005HÖ\u0001J\u000B\u0010\u0085\u0001\u001A\u00030\u0086\u0001HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b+\u0010*R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b,\u0010*R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b-\u0010*R\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b.\u0010*R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b/\u0010*R\u001A\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u00101\"\u0004\b2\u00103R\u001A\u0010\r\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b4\u00101\"\u0004\b5\u00103R\u001A\u0010\u000E\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u00101\"\u0004\b7\u00103R\u001A\u0010\u000F\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b8\u00101\"\u0004\b9\u00103R\u001A\u0010\u0010\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b:\u00101\"\u0004\b;\u00103R\u001A\u0010\u0011\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b<\u0010*\"\u0004\b=\u0010>R\u001A\u0010\u0012\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b?\u0010*\"\u0004\b@\u0010>R\u001A\u0010\u0013\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bA\u00101\"\u0004\bB\u00103R\u001A\u0010\u0014\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bC\u00101\"\u0004\bD\u00103R\u001A\u0010\u0015\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bE\u00101\"\u0004\bF\u00103R\u001A\u0010\u0016\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bG\u00101\"\u0004\bH\u00103R\u001A\u0010\u0017\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bI\u00101\"\u0004\bJ\u00103R\u001A\u0010\u0018\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bK\u00101\"\u0004\bL\u00103R\u001A\u0010\u0019\u001A\u00020\u001AX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001A\u0010\u001B\u001A\u00020\u001AX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bQ\u0010N\"\u0004\bR\u0010PR\u001A\u0010\u001C\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bS\u00101\"\u0004\bT\u00103R\u001C\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001C\u0010\u001F\u001A\u00020 X\u0086\u000E¢\u0006\u0010\n\u0002\u0010[\u001A\u0004\bY\u0010*\"\u0004\bZ\u0010>R\u001C\u0010!\u001A\u0004\u0018\u00010\"X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001C\u0010#\u001A\u00020$X\u0086\u000E¢\u0006\u0010\n\u0002\u0010[\u001A\u0004\b`\u0010*\"\u0004\ba\u0010>¨\u0006\u0087\u0001"}, d2={"Landroidx/compose/ui/platform/DeviceRenderNodeData;", "", "uniqueId", "", "left", "", "top", "right", "bottom", "width", "height", "scaleX", "", "scaleY", "translationX", "translationY", "elevation", "ambientShadowColor", "spotShadowColor", "rotationZ", "rotationX", "rotationY", "cameraDistance", "pivotX", "pivotY", "clipToOutline", "", "clipToBounds", "alpha", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "<init>", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;ILandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUniqueId", "()J", "getLeft", "()I", "getTop", "getRight", "getBottom", "getWidth", "getHeight", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getElevation", "setElevation", "getAmbientShadowColor", "setAmbientShadowColor", "(I)V", "getSpotShadowColor", "setSpotShadowColor", "getRotationZ", "setRotationZ", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getCameraDistance", "setCameraDistance", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "getClipToBounds", "setClipToBounds", "getAlpha", "setAlpha", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "I", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component25-0nO6VwU", "component26", "component27", "component27--NrFUSI", "copy", "copy-qCc9W8c", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;ILandroidx/compose/ui/graphics/ColorFilter;I)Landroidx/compose/ui/platform/DeviceRenderNodeData;", "equals", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DeviceRenderNodeData {
    public static final int $stable = 8;
    private float alpha;
    private int ambientShadowColor;
    private int blendMode;
    private final int bottom;
    private float cameraDistance;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private float elevation;
    private final int height;
    private final int left;
    private float pivotX;
    private float pivotY;
    private RenderEffect renderEffect;
    private final int right;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private int spotShadowColor;
    private final int top;
    private float translationX;
    private float translationY;
    private final long uniqueId;
    private final int width;

    static {
    }

    private DeviceRenderNodeData(long arg1, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, float arg9, float arg10, float arg11, float arg12, float arg13, int arg14, int arg15, float arg16, float arg17, float arg18, float arg19, float arg20, float arg21, boolean arg22, boolean arg23, float arg24, RenderEffect arg25, int arg26, ColorFilter arg27, int arg28) {
        super();
        this.uniqueId = arg1;
        this.left = arg3;
        this.top = arg4;
        this.right = arg5;
        this.bottom = arg6;
        this.width = arg7;
        this.height = arg8;
        this.scaleX = arg9;
        this.scaleY = arg10;
        this.translationX = arg11;
        this.translationY = arg12;
        this.elevation = arg13;
        this.ambientShadowColor = arg14;
        this.spotShadowColor = arg15;
        this.rotationZ = arg16;
        this.rotationX = arg17;
        this.rotationY = arg18;
        this.cameraDistance = arg19;
        this.pivotX = arg20;
        this.pivotY = arg21;
        this.clipToOutline = arg22;
        this.clipToBounds = arg23;
        this.alpha = arg24;
        this.renderEffect = arg25;
        this.blendMode = arg26;
        this.colorFilter = arg27;
        this.compositingStrategy = arg28;
    }

    public DeviceRenderNodeData(long arg1, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, float arg9, float arg10, float arg11, float arg12, float arg13, int arg14, int arg15, float arg16, float arg17, float arg18, float arg19, float arg20, float arg21, boolean arg22, boolean arg23, float arg24, RenderEffect arg25, int arg26, ColorFilter arg27, int arg28, DefaultConstructorMarker arg29) {
        this(arg1, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28);
    }

    public final long component1() {
        return this.uniqueId;
    }

    public final float component10() {
        return this.translationX;
    }

    public final float component11() {
        return this.translationY;
    }

    public final float component12() {
        return this.elevation;
    }

    public final int component13() {
        return this.ambientShadowColor;
    }

    public final int component14() {
        return this.spotShadowColor;
    }

    public final float component15() {
        return this.rotationZ;
    }

    public final float component16() {
        return this.rotationX;
    }

    public final float component17() {
        return this.rotationY;
    }

    public final float component18() {
        return this.cameraDistance;
    }

    public final float component19() {
        return this.pivotX;
    }

    public final int component2() {
        return this.left;
    }

    public final float component20() {
        return this.pivotY;
    }

    public final boolean component21() {
        return this.clipToOutline;
    }

    public final boolean component22() {
        return this.clipToBounds;
    }

    public final float component23() {
        return this.alpha;
    }

    public final RenderEffect component24() {
        return this.renderEffect;
    }

    public final int component25-0nO6VwU() {
        return this.blendMode;
    }

    public final ColorFilter component26() {
        return this.colorFilter;
    }

    public final int component27--NrFUSI() {
        return this.compositingStrategy;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.right;
    }

    public final int component5() {
        return this.bottom;
    }

    public final int component6() {
        return this.width;
    }

    public final int component7() {
        return this.height;
    }

    public final float component8() {
        return this.scaleX;
    }

    public final float component9() {
        return this.scaleY;
    }

    public final DeviceRenderNodeData copy-qCc9W8c(long arg31, int arg33, int arg34, int arg35, int arg36, int arg37, int arg38, float arg39, float arg40, float arg41, float arg42, float arg43, int arg44, int arg45, float arg46, float arg47, float arg48, float arg49, float arg50, float arg51, boolean arg52, boolean arg53, float arg54, RenderEffect arg55, int arg56, ColorFilter arg57, int arg58) {
        return new DeviceRenderNodeData(arg31, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg52, arg53, arg54, arg55, arg56, arg57, arg58, null);
    }

    public static DeviceRenderNodeData copy-qCc9W8c$default(DeviceRenderNodeData arg19, long arg20, int arg22, int arg23, int arg24, int arg25, int arg26, int arg27, float arg28, float arg29, float arg30, float arg31, float arg32, int arg33, int arg34, float arg35, float arg36, float arg37, float arg38, float arg39, float arg40, boolean arg41, boolean arg42, float arg43, RenderEffect arg44, int arg45, ColorFilter arg46, int arg47, int arg48, Object arg49) {
        ColorFilter v47;
        DeviceRenderNodeData v0 = arg19;
        int v1 = arg48;
        long v2 = (v1 & 1) != 0 ? v0.uniqueId : arg20;
        int v4 = (v1 & 2) != 0 ? v0.left : arg22;
        int v5 = (v1 & 4) != 0 ? v0.top : arg23;
        int v6 = (v1 & 8) != 0 ? v0.right : arg24;
        int v7 = (v1 & 16) != 0 ? v0.bottom : arg25;
        int v8 = (v1 & 0x20) != 0 ? v0.width : arg26;
        int v9 = (v1 & 0x40) != 0 ? v0.height : arg27;
        float v10 = (v1 & 0x80) != 0 ? v0.scaleX : arg28;
        float v11 = (v1 & 0x100) != 0 ? v0.scaleY : arg29;
        float v12 = (v1 & 0x200) != 0 ? v0.translationX : arg30;
        float v13 = (v1 & 0x400) != 0 ? v0.translationY : arg31;
        float v14 = (v1 & 0x800) != 0 ? v0.elevation : arg32;
        int v15 = (v1 & 0x1000) != 0 ? v0.ambientShadowColor : arg33;
        long v16 = v2;
        int v2_1 = (v1 & 0x2000) != 0 ? v0.spotShadowColor : arg34;
        float v3 = (v1 & 0x4000) != 0 ? v0.rotationZ : arg35;
        float v1_1 = (v1 & 0x8000) != 0 ? v0.rotationX : arg36;
        float v20 = v1_1;
        v1_1 = (arg48 & 0x10000) != 0 ? v0.rotationY : arg37;
        float v21 = v1_1;
        v1_1 = (arg48 & 0x20000) != 0 ? v0.cameraDistance : arg38;
        float v22 = v1_1;
        v1_1 = (arg48 & 0x40000) != 0 ? v0.pivotX : arg39;
        float v23 = v1_1;
        v1_1 = (arg48 & 0x80000) != 0 ? v0.pivotY : arg40;
        float v24 = v1_1;
        boolean v1_2 = (arg48 & 0x100000) != 0 ? v0.clipToOutline : arg41;
        boolean v25 = v1_2;
        v1_2 = (arg48 & 0x200000) != 0 ? v0.clipToBounds : arg42;
        boolean v26 = v1_2;
        v1_1 = (arg48 & 0x400000) != 0 ? v0.alpha : arg43;
        float v27 = v1_1;
        RenderEffect v1_3 = (arg48 & 0x800000) != 0 ? v0.renderEffect : arg44;
        RenderEffect v28 = v1_3;
        v1 = (arg48 & 0x1000000) != 0 ? v0.blendMode : arg45;
        int v29 = v1;
        ColorFilter v1_4 = (arg48 & 0x2000000) != 0 ? v0.colorFilter : arg46;
        if((arg48 & 0x4000000) != 0) {
            v47 = v1_4;
            arg48 = v0.compositingStrategy;
        }
        else {
            arg48 = arg47;
            v47 = v1_4;
        }

        return v0.copy-qCc9W8c(v16, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v2_1, v3, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v47, arg48);
    }

    public boolean equals(Object arg8) {
        if(this == (((DeviceRenderNodeData)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof DeviceRenderNodeData)) {
            return 0;
        }

        if(this.uniqueId != ((DeviceRenderNodeData)arg8).uniqueId) {
            return 0;
        }

        if(this.left != ((DeviceRenderNodeData)arg8).left) {
            return 0;
        }

        if(this.top != ((DeviceRenderNodeData)arg8).top) {
            return 0;
        }

        if(this.right != ((DeviceRenderNodeData)arg8).right) {
            return 0;
        }

        if(this.bottom != ((DeviceRenderNodeData)arg8).bottom) {
            return 0;
        }

        if(this.width != ((DeviceRenderNodeData)arg8).width) {
            return 0;
        }

        if(this.height != ((DeviceRenderNodeData)arg8).height) {
            return 0;
        }

        if(Float.compare(this.scaleX, ((DeviceRenderNodeData)arg8).scaleX) != 0) {
            return 0;
        }

        if(Float.compare(this.scaleY, ((DeviceRenderNodeData)arg8).scaleY) != 0) {
            return 0;
        }

        if(Float.compare(this.translationX, ((DeviceRenderNodeData)arg8).translationX) != 0) {
            return 0;
        }

        if(Float.compare(this.translationY, ((DeviceRenderNodeData)arg8).translationY) != 0) {
            return 0;
        }

        if(Float.compare(this.elevation, ((DeviceRenderNodeData)arg8).elevation) != 0) {
            return 0;
        }

        if(this.ambientShadowColor != ((DeviceRenderNodeData)arg8).ambientShadowColor) {
            return 0;
        }

        if(this.spotShadowColor != ((DeviceRenderNodeData)arg8).spotShadowColor) {
            return 0;
        }

        if(Float.compare(this.rotationZ, ((DeviceRenderNodeData)arg8).rotationZ) != 0) {
            return 0;
        }

        if(Float.compare(this.rotationX, ((DeviceRenderNodeData)arg8).rotationX) != 0) {
            return 0;
        }

        if(Float.compare(this.rotationY, ((DeviceRenderNodeData)arg8).rotationY) != 0) {
            return 0;
        }

        if(Float.compare(this.cameraDistance, ((DeviceRenderNodeData)arg8).cameraDistance) != 0) {
            return 0;
        }

        if(Float.compare(this.pivotX, ((DeviceRenderNodeData)arg8).pivotX) != 0) {
            return 0;
        }

        if(Float.compare(this.pivotY, ((DeviceRenderNodeData)arg8).pivotY) != 0) {
            return 0;
        }

        if(this.clipToOutline != ((DeviceRenderNodeData)arg8).clipToOutline) {
            return 0;
        }

        if(this.clipToBounds != ((DeviceRenderNodeData)arg8).clipToBounds) {
            return 0;
        }

        if(Float.compare(this.alpha, ((DeviceRenderNodeData)arg8).alpha) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.renderEffect, ((DeviceRenderNodeData)arg8).renderEffect)) {
            return 0;
        }

        if(!BlendMode.equals-impl0(this.blendMode, ((DeviceRenderNodeData)arg8).blendMode)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colorFilter, ((DeviceRenderNodeData)arg8).colorFilter)) {
            return 0;
        }

        if(!CompositingStrategy.equals-impl0(this.compositingStrategy, ((DeviceRenderNodeData)arg8).compositingStrategy)) {
            return 0;
        }

        return 1;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    public final int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final boolean getClipToOutline() {
        return this.clipToOutline;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final int getCompositingStrategy--NrFUSI() {
        return this.compositingStrategy;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final int getRight() {
        return this.right;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final int getSpotShadowColor() {
        return this.spotShadowColor;
    }

    public final int getTop() {
        return this.top;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final long getUniqueId() {
        return this.uniqueId;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int v0 = ((((((((((((((((((((((Long.hashCode(this.uniqueId) * 0x1F + Integer.hashCode(this.left)) * 0x1F + Integer.hashCode(this.top)) * 0x1F + Integer.hashCode(this.right)) * 0x1F + Integer.hashCode(this.bottom)) * 0x1F + Integer.hashCode(this.width)) * 0x1F + Integer.hashCode(this.height)) * 0x1F + Float.hashCode(this.scaleX)) * 0x1F + Float.hashCode(this.scaleY)) * 0x1F + Float.hashCode(this.translationX)) * 0x1F + Float.hashCode(this.translationY)) * 0x1F + Float.hashCode(this.elevation)) * 0x1F + Integer.hashCode(this.ambientShadowColor)) * 0x1F + Integer.hashCode(this.spotShadowColor)) * 0x1F + Float.hashCode(this.rotationZ)) * 0x1F + Float.hashCode(this.rotationX)) * 0x1F + Float.hashCode(this.rotationY)) * 0x1F + Float.hashCode(this.cameraDistance)) * 0x1F + Float.hashCode(this.pivotX)) * 0x1F + Float.hashCode(this.pivotY)) * 0x1F + Boolean.hashCode(this.clipToOutline)) * 0x1F + Boolean.hashCode(this.clipToBounds)) * 0x1F + Float.hashCode(this.alpha)) * 0x1F;
        RenderEffect v1 = this.renderEffect;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = ((v0 + v1_1) * 0x1F + BlendMode.hashCode-impl(this.blendMode)) * 0x1F;
        ColorFilter v1_2 = this.colorFilter;
        if(v1_2 == null) {
        }
        else {
            v2 = v1_2.hashCode();
        }

        return (v0 + v2) * 0x1F + CompositingStrategy.hashCode-impl(this.compositingStrategy);
    }

    public final void setAlpha(float arg1) {
        this.alpha = arg1;
    }

    public final void setAmbientShadowColor(int arg1) {
        this.ambientShadowColor = arg1;
    }

    public final void setBlendMode-s9anfk8(int arg1) {
        this.blendMode = arg1;
    }

    public final void setCameraDistance(float arg1) {
        this.cameraDistance = arg1;
    }

    public final void setClipToBounds(boolean arg1) {
        this.clipToBounds = arg1;
    }

    public final void setClipToOutline(boolean arg1) {
        this.clipToOutline = arg1;
    }

    public final void setColorFilter(ColorFilter arg1) {
        this.colorFilter = arg1;
    }

    public final void setCompositingStrategy-aDBOjCE(int arg1) {
        this.compositingStrategy = arg1;
    }

    public final void setElevation(float arg1) {
        this.elevation = arg1;
    }

    public final void setPivotX(float arg1) {
        this.pivotX = arg1;
    }

    public final void setPivotY(float arg1) {
        this.pivotY = arg1;
    }

    public final void setRenderEffect(RenderEffect arg1) {
        this.renderEffect = arg1;
    }

    public final void setRotationX(float arg1) {
        this.rotationX = arg1;
    }

    public final void setRotationY(float arg1) {
        this.rotationY = arg1;
    }

    public final void setRotationZ(float arg1) {
        this.rotationZ = arg1;
    }

    public final void setScaleX(float arg1) {
        this.scaleX = arg1;
    }

    public final void setScaleY(float arg1) {
        this.scaleY = arg1;
    }

    public final void setSpotShadowColor(int arg1) {
        this.spotShadowColor = arg1;
    }

    public final void setTranslationX(float arg1) {
        this.translationX = arg1;
    }

    public final void setTranslationY(float arg1) {
        this.translationY = arg1;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("DeviceRenderNodeData(uniqueId=");
        v0.append(this.uniqueId).append(", left=").append(this.left).append(", top=").append(this.top).append(", right=").append(this.right).append(", bottom=").append(this.bottom).append(", width=").append(this.width).append(", height=").append(this.height).append(", scaleX=").append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", elevation=");
        v0.append(this.elevation).append(", ambientShadowColor=").append(this.ambientShadowColor).append(", spotShadowColor=").append(this.spotShadowColor).append(", rotationZ=").append(this.rotationZ).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", cameraDistance=").append(this.cameraDistance).append(", pivotX=").append(this.pivotX).append(", pivotY=").append(this.pivotY).append(", clipToOutline=").append(this.clipToOutline).append(", clipToBounds=").append(this.clipToBounds).append(", alpha=").append(this.alpha);
        v0.append(", renderEffect=").append(this.renderEffect).append(", blendMode=").append(BlendMode.toString-impl(this.blendMode)).append(", colorFilter=").append(this.colorFilter).append(", compositingStrategy=").append(CompositingStrategy.toString-impl(this.compositingStrategy)).append(')');
        return v0.toString();
    }
}


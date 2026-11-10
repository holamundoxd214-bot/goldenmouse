package androidx.compose.material.ripple;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0011H\u0016J\f\u0010\u001D\u001A\u00020\u0014*\u00020\u001EH\u0016J\b\u0010\u001F\u001A\u00020\u0014H\u0016R\u001A\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/material/ripple/CommonRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ripples", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "addRipple", "", "interaction", "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", "", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onDetach", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CommonRippleNode extends RippleNode {
    public static final int $stable = 8;
    private final MutableScatterMap ripples;

    static {
    }

    private CommonRippleNode(InteractionSource arg8, boolean arg9, float arg10, ColorProducer arg11, Function0 arg12) {
        super(arg8, arg9, arg10, arg11, arg12, null);
        this.ripples = new MutableScatterMap(0, 1, null);
    }

    public CommonRippleNode(InteractionSource arg1, boolean arg2, float arg3, ColorProducer arg4, Function0 arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public static final MutableScatterMap access$getRipples$p(CommonRippleNode arg0) {
        return arg0.ripples;
    }

    public void addRipple-12SF9DM(Press arg18, long arg19, float arg21) {
        CommonRippleNode v0 = this;
        Press v1 = arg18;
        MutableScatterMap v2 = v0.ripples;
        Object[] v3 = ((ScatterMap)v2).keys;
        Object[] v4 = ((ScatterMap)v2).values;
        long[] v2_1 = ((ScatterMap)v2).metadata;
        int v5 = v2_1.length - 2;
        if(v5 >= 0) {
            int v7;
            for(v7 = 0; true; ++v7) {
                long v8 = v2_1[v7];
                if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11 = 8;
                    int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                    int v12;
                    for(v12 = 0; v12 < v10; ++v12) {
                        if((0xFF & v8) < 0x80) {
                            v4[(v7 << 3) + v12].finish();
                        }

                        v8 >>= v11;
                    }

                    if(v10 != v11) {
                        break;
                    }
                }

                if(v7 == v5) {
                    break;
                }
            }
        }

        DefaultConstructorMarker v3_1 = null;
        Offset v2_2 = v0.getBounded() ? Offset.box-impl(v1.getPressPosition-F1C5BW0()) : ((Offset)v3_1);
        RippleAnimation v4_1 = new RippleAnimation(v2_2, arg21, v0.getBounded(), v3_1);
        v0.ripples.set(v1, v4_1);
        BuildersKt.launch$default(v0.getCoroutineScope(), null, null, new CommonRippleNode$addRipple$2(v4_1, v0, v1, ((Continuation)v3_1)), 3, null);
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)v0));
    }

    public void drawRipples(DrawScope arg22) {
        float v4_1;
        int v18;
        int v13;
        int v19;
        float v3 = this.getRippleAlpha().invoke().getPressedAlpha();
        if(v3 == 0f) {
            return;
        }

        CommonRippleNode v0 = this;
        MutableScatterMap v1 = v0.ripples;
        Object[] v9 = ((ScatterMap)v1).keys;
        Object[] v10 = ((ScatterMap)v1).values;
        long[] v11 = ((ScatterMap)v1).metadata;
        int v12 = v11.length - 2;
        if(v12 >= 0) {
            int v14 = 0;
            while(true) {
                long v1_1 = v11[v14];
                if((~v1_1 << 7 & v1_1 & -9187201950435737472L) != -9187201950435737472L) {
                    int v15 = 8;
                    int v4 = 8 - (~(v14 - v12) >>> 0x1F);
                    long v16 = v1_1;
                    int v1_2 = 0;
                    while(v1_2 < v4) {
                        if((v16 & 0xFF) < 0x80) {
                            v19 = v1_2;
                            v13 = v4;
                            v18 = v15;
                            v4_1 = v3;
                            v10[(v14 << 3) + v1_2].draw-4WTKRHQ(arg22, Color.copy-wmQWz5c$default(v0.getRippleColor-0d7_KjU(), v3, 0f, 0f, 0f, 14, null));
                        }
                        else {
                            v19 = v1_2;
                            v13 = v4;
                            v18 = v15;
                            v4_1 = v3;
                        }

                        v16 >>= v18;
                        v1_2 = v19 + 1;
                        v3 = v4_1;
                        v4 = v13;
                        v15 = v18;
                    }

                    v13 = v4;
                    v4_1 = v3;
                    if(v13 != v15) {
                        return;
                    }
                }
                else {
                    v4_1 = v3;
                }

                if(v14 == v12) {
                    return;
                }

                ++v14;
                v3 = v4_1;
            }
        }
    }

    public void onDetach() {
        this.ripples.clear();
    }

    public void removeRipple(Press arg1) {
        Object v0 = this.ripples.get(arg1);
        if(v0 != null) {
            ((RippleAnimation)v0).finish();
        }
    }
}


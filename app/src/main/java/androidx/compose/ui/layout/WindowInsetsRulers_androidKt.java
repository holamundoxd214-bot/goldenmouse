package androidx.compose.ui.layout;

import android.graphics.Rect;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeKindKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.core.view.WindowInsetsCompat$Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0016\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\tH\u0000\u001A\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0000\u001A3\u0010\u0010\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\"\u000E\u0010\u000E\u001A\u00020\u000FX\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\r0\u001AX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\r0\u001CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001D¨\u0006\u001E"}, d2={"provideWindowInsetsRulers", "", "Landroidx/compose/ui/layout/RulerScope;", "rulerProvider", "Landroidx/compose/ui/layout/WindowInsetsRulerProvider;", "findDisplayCutouts", "", "Landroidx/compose/ui/layout/RectRulers;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "findInsetsAnimationProperties", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "windowInsetsRulers", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "RulerKey", "", "provideInsetsValues", "rulers", "insets", "Landroidx/compose/ui/layout/ValueInsets;", "width", "", "height", "provideInsetsValues-cytEWk0", "(Landroidx/compose/ui/layout/RulerScope;Landroidx/compose/ui/layout/RectRulers;JII)V", "WindowInsetsTypeMap", "Landroidx/collection/IntObjectMap;", "AnimatableInsetsRulers", "", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsRulers_androidKt {
    private static final WindowInsetsRulers[] AnimatableInsetsRulers = null;
    public static final String RulerKey = "androidx.compose.ui.layout.WindowInsetsRulers";
    private static final IntObjectMap WindowInsetsTypeMap;

    static {
        MutableIntObjectMap v0 = new MutableIntObjectMap(8);
        v0.set(Type.statusBars(), WindowInsetsRulers.Companion.getStatusBars());
        v0.set(Type.navigationBars(), WindowInsetsRulers.Companion.getNavigationBars());
        v0.set(Type.captionBar(), WindowInsetsRulers.Companion.getCaptionBar());
        v0.set(Type.ime(), WindowInsetsRulers.Companion.getIme());
        v0.set(Type.systemGestures(), WindowInsetsRulers.Companion.getSystemGestures());
        v0.set(Type.mandatorySystemGestures(), WindowInsetsRulers.Companion.getMandatorySystemGestures());
        v0.set(Type.tappableElement(), WindowInsetsRulers.Companion.getTappableElement());
        v0.set(Type.displayCutout(), WindowInsetsRulers.Companion.getDisplayCutout());
        WindowInsetsRulers_androidKt.WindowInsetsTypeMap = ((IntObjectMap)v0);
        WindowInsetsRulers_androidKt.AnimatableInsetsRulers = new WindowInsetsRulers[]{WindowInsetsRulers.Companion.getStatusBars(), WindowInsetsRulers.Companion.getNavigationBars(), WindowInsetsRulers.Companion.getCaptionBar(), WindowInsetsRulers.Companion.getTappableElement(), WindowInsetsRulers.Companion.getSystemGestures(), WindowInsetsRulers.Companion.getMandatorySystemGestures(), WindowInsetsRulers.Companion.getIme(), WindowInsetsRulers.Companion.getWaterfall(), WindowInsetsRulers.Companion.getDisplayCutout()};
    }

    public static final IntObjectMap access$getWindowInsetsTypeMap$p() {
        return WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
    }

    public static final List findDisplayCutouts(PlacementScope arg11) {
        LayoutCoordinates v11 = arg11.getCoordinates();
        Node v0 = null;
        v11 = v11 != null ? LayoutCoordinatesKt.findRootCoordinates(v11) : ((LayoutCoordinates)v0);
        if((v11 instanceof NodeCoordinator)) {
        }
        else {
            v11 = ((LayoutCoordinates)v0);
        }

        while(v11 != null) {
            int v1 = NodeKind.constructor-impl(0x40000);
            boolean v2 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(v1);
            Node v3 = ((NodeCoordinator)v11).getTail();
            if(v2) {
                goto label_20;
            }
            else {
                v3 = v3.getParent$ui();
                if(v3 == null) {
                }
                else {
                label_20:
                    Node v2_1;
                    for(v2_1 = NodeCoordinator.access$headNode(((NodeCoordinator)v11), v2); v2_1 != null; v2_1 = v2_1.getChild$ui()) {
                        if((v2_1.getAggregateChildKindSet$ui() & v1) == 0) {
                            break;
                        }

                        if((v2_1.getKindSet$ui() & v1) != 0) {
                            MutableVector v5 = ((MutableVector)v0);
                            Node v4 = v2_1;
                            while(true) {
                            label_30:
                                if(v4 != null) {
                                    if((v4 instanceof TraversableNode)) {
                                        if(((TraversableNode)v4).getTraverseKey() == "androidx.compose.ui.layout.WindowInsetsRulers") {
                                            return ((WindowInsetsRulerProvider)v4).getCutoutRulers();
                                        }
                                    }
                                    else if((v4.getKindSet$ui() & v1) != 0 && ((v4 instanceof DelegatingNode))) {
                                        Node v6 = v4.getDelegate$ui();
                                        int v8 = 0;
                                        while(v6 != null) {
                                            if((v6.getKindSet$ui() & v1) != 0) {
                                                ++v8;
                                                if(v8 == 1) {
                                                    v4 = v6;
                                                }
                                                else {
                                                    if(v5 == null) {
                                                        v5 = new MutableVector(new Node[16], 0);
                                                    }

                                                    if(v4 != null) {
                                                        if(v5 != null) {
                                                            v5.add(v4);
                                                        }

                                                        v4 = v0;
                                                    }

                                                    if(v5 == null) {
                                                        goto label_67;
                                                    }

                                                    v5.add(v6);
                                                }
                                            }

                                        label_67:
                                            v6 = v6.getChild$ui();
                                        }

                                        if(v8 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_73;
                            }

                            v4 = DelegatableNodeKt.access$pop(v5);
                            goto label_30;
                        }

                    label_73:
                        if(v2_1 == v3) {
                            break;
                        }
                    }
                }
            }

            NodeCoordinator v11_1 = v11_1.getWrapped$ui();
        }

        return CollectionsKt.emptyList();
    }

    public static final WindowInsetsAnimation findInsetsAnimationProperties(PlacementScope arg11, WindowInsetsRulers arg12) {
        LayoutCoordinates v11 = arg11.getCoordinates();
        Node v0 = null;
        v11 = v11 != null ? LayoutCoordinatesKt.findRootCoordinates(v11) : ((LayoutCoordinates)v0);
        if((v11 instanceof NodeCoordinator)) {
        }
        else {
            v11 = ((LayoutCoordinates)v0);
        }

        while(v11 != null) {
            int v1 = NodeKind.constructor-impl(0x40000);
            boolean v2 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(v1);
            Node v3 = ((NodeCoordinator)v11).getTail();
            if(v2) {
                goto label_20;
            }
            else {
                v3 = v3.getParent$ui();
                if(v3 == null) {
                }
                else {
                label_20:
                    Node v2_1;
                    for(v2_1 = NodeCoordinator.access$headNode(((NodeCoordinator)v11), v2); v2_1 != null; v2_1 = v2_1.getChild$ui()) {
                        if((v2_1.getAggregateChildKindSet$ui() & v1) == 0) {
                            break;
                        }

                        if((v2_1.getKindSet$ui() & v1) != 0) {
                            MutableVector v5 = ((MutableVector)v0);
                            Node v4 = v2_1;
                            while(true) {
                            label_30:
                                if(v4 != null) {
                                    if((v4 instanceof TraversableNode)) {
                                        if(((TraversableNode)v4).getTraverseKey() == "androidx.compose.ui.layout.WindowInsetsRulers") {
                                            Object v11_1 = ((WindowInsetsRulerProvider)v4).getInsetsValues().get(arg12);
                                            if(v11_1 != null) {
                                                return ((WindowInsetsAnimation)v11_1);
                                            }
                                            else {
                                                return NoWindowInsetsAnimation.INSTANCE;
                                            }
                                        }
                                    }
                                    else if((v4.getKindSet$ui() & v1) != 0 && ((v4 instanceof DelegatingNode))) {
                                        Node v6 = v4.getDelegate$ui();
                                        int v8 = 0;
                                        while(v6 != null) {
                                            if((v6.getKindSet$ui() & v1) != 0) {
                                                ++v8;
                                                if(v8 == 1) {
                                                    v4 = v6;
                                                }
                                                else {
                                                    if(v5 == null) {
                                                        v5 = new MutableVector(new Node[16], 0);
                                                    }

                                                    if(v4 != null) {
                                                        if(v5 != null) {
                                                            v5.add(v4);
                                                        }

                                                        v4 = v0;
                                                    }

                                                    if(v5 == null) {
                                                        goto label_71;
                                                    }

                                                    v5.add(v6);
                                                }
                                            }

                                        label_71:
                                            v6 = v6.getChild$ui();
                                        }

                                        if(v8 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_77;
                            }

                            v4 = DelegatableNodeKt.access$pop(v5);
                            goto label_30;
                        }

                    label_77:
                        if(v2_1 == v3) {
                            break;
                        }
                    }
                }
            }

            NodeCoordinator v11_2 = ((NodeCoordinator)v11).getWrapped$ui();
        }

        return NoWindowInsetsAnimation.INSTANCE;
    }

    private static final void provideInsetsValues-cytEWk0(RulerScope arg6, RectRulers arg7, long arg8, int arg10, int arg11) {
        if(!ValueInsets.equals-impl0(arg8, ValueInsets_androidKt.getUnsetValueInsets())) {
            arg6.provides(arg7.getLeft(), ((float)(((int)(arg8 >>> 0x30 & 0xFFFF)))));
            arg6.provides(arg7.getTop(), ((float)(((int)(arg8 >>> 0x20 & 0xFFFF)))));
            arg6.provides(arg7.getRight(), ((float)(arg10 - (((int)(arg8 >>> 16 & 0xFFFF))))));
            arg6.provides(arg7.getBottom(), ((float)(arg11 - (((int)(arg8 & 0xFFFF))))));
        }
    }

    public static final void provideWindowInsetsRulers(RulerScope arg13, WindowInsetsRulerProvider arg14) {
        RulerScope v5_1;
        long v0 = arg13.getCoordinates().getSize-YbymL2g();
        ScatterMap v2 = arg14.getInsetsListener().getInsetsValues();
        int v9 = ((int)(v0 >> 0x20));
        int v10 = ((int)(v0 & 0xFFFFFFFFL));
        WindowInsetsRulers[] v0_1 = WindowInsetsRulers_androidKt.AnimatableInsetsRulers;
        int v1 = v0_1.length;
        int v3 = 0;
        int v4 = 0;
        while(v4 < v1) {
            WindowInsetsRulers v11 = v0_1[v4];
            Object v5 = v2.get(v11);
            Intrinsics.checkNotNull(v5);
            Object v12 = v5;
            v5_1 = arg13;
            WindowInsetsRulers_androidKt.provideInsetsValues-cytEWk0(v5_1, v11.getCurrent(), ((WindowWindowInsetsAnimationValues)v12).getCurrent-hdzbrEE(), v9, v10);
            if(((WindowWindowInsetsAnimationValues)v12).isAnimating()) {
                WindowInsetsRulers_androidKt.provideInsetsValues-cytEWk0(v5_1, ((WindowWindowInsetsAnimationValues)v12).getSource(), ((WindowWindowInsetsAnimationValues)v12).getSourceValueInsets-hdzbrEE(), v9, v10);
                WindowInsetsRulers_androidKt.provideInsetsValues-cytEWk0(v5_1, ((WindowWindowInsetsAnimationValues)v12).getTarget(), ((WindowWindowInsetsAnimationValues)v12).getTargetValueInsets-hdzbrEE(), v9, v10);
            }

            WindowInsetsRulers_androidKt.provideInsetsValues-cytEWk0(v5_1, v11.getMaximum(), ((WindowWindowInsetsAnimationValues)v12).getMaximum-hdzbrEE(), v9, v10);
            ++v4;
            arg13 = v5_1;
        }

        v5_1 = arg13;
        MutableObjectList v13 = arg14.getCutoutRects();
        if(v13.isNotEmpty()) {
            List v14 = arg14.getCutoutRulers();
            Object[] v0_2 = ((ObjectList)v13).content;
            int v13_1 = ((ObjectList)v13)._size;
            while(v3 < v13_1) {
                Object v1_1 = v0_2[v3];
                Object v2_1 = v14.get(v3);
                v1_1 = ((MutableState)v1_1).getValue();
                v5_1.provides(((RectRulers)v2_1).getLeft(), ((float)((Rect)v1_1).left));
                v5_1.provides(((RectRulers)v2_1).getTop(), ((float)((Rect)v1_1).top));
                v5_1.provides(((RectRulers)v2_1).getRight(), ((float)((Rect)v1_1).right));
                v5_1.provides(((RectRulers)v2_1).getBottom(), ((float)((Rect)v1_1).bottom));
                ++v3;
            }
        }
    }
}


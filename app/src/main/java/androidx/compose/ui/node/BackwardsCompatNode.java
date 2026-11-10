package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000B2\u00020\f2\u00020\r2\u00020\u000E2\u00020\u000FB\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u0019H\u0016J\b\u0010\u001B\u001A\u00020\u0019H\u0002J\u0010\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u001EH\u0002J\b\u0010,\u001A\u00020\u0019H\u0016J\b\u0010-\u001A\u00020\u0019H\u0002J\r\u0010.\u001A\u00020\u0019H\u0000¢\u0006\u0002\b/J\u0006\u0010B\u001A\u00020\u0019J\u0014\u0010C\u001A\u00020\u00192\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030DH\u0002J#\u0010G\u001A\u00020H*\u00020I2\u0006\u0010J\u001A\u00020K2\u0006\u0010L\u001A\u00020MH\u0016¢\u0006\u0004\bN\u0010OJ\u001C\u0010P\u001A\u00020Q*\u00020R2\u0006\u0010J\u001A\u00020S2\u0006\u0010T\u001A\u00020QH\u0016J\u001C\u0010U\u001A\u00020Q*\u00020R2\u0006\u0010J\u001A\u00020S2\u0006\u0010V\u001A\u00020QH\u0016J\u001C\u0010W\u001A\u00020Q*\u00020R2\u0006\u0010J\u001A\u00020S2\u0006\u0010T\u001A\u00020QH\u0016J\u001C\u0010X\u001A\u00020Q*\u00020R2\u0006\u0010J\u001A\u00020S2\u0006\u0010V\u001A\u00020QH\u0016J\f\u0010Y\u001A\u00020\u0019*\u00020ZH\u0016J\f\u0010[\u001A\u00020\u0019*\u00020\\H\u0016J\'\u0010]\u001A\u00020\u00192\u0006\u0010^\u001A\u00020_2\u0006\u0010`\u001A\u00020a2\u0006\u0010b\u001A\u00020cH\u0016¢\u0006\u0004\bd\u0010eJ\b\u0010f\u001A\u00020\u0019H\u0016J\b\u0010g\u001A\u00020\u0019H\u0016J\b\u0010h\u001A\u00020\u001EH\u0016J\b\u0010i\u001A\u00020\u001EH\u0016J\u0018\u0010j\u001A\u0004\u0018\u00010k*\u00020 2\b\u0010l\u001A\u0004\u0018\u00010kH\u0016J\u0010\u0010m\u001A\u00020\u00192\u0006\u0010n\u001A\u00020oH\u0016J\u0017\u0010p\u001A\u00020\u00192\u0006\u0010\'\u001A\u00020cH\u0016¢\u0006\u0004\bq\u0010rJ\u0010\u0010t\u001A\u00020\u00192\u0006\u0010n\u001A\u00020oH\u0016J\u0010\u0010u\u001A\u00020\u00192\u0006\u0010v\u001A\u00020wH\u0016J\u0010\u0010x\u001A\u00020\u00192\u0006\u0010y\u001A\u00020zH\u0016J\b\u0010{\u001A\u00020|H\u0016R$\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0011@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001F\u001A\u00020 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020(8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b)\u0010*R\u000E\u0010+\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00100\u001A\u0004\u0018\u000101X\u0082\u000E¢\u0006\u0002\n\u0000R2\u00102\u001A\u001A\u0012\b\u0012\u0006\u0012\u0002\b\u00030403j\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304`5X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001A\u00020;8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b<\u0010=R$\u0010>\u001A\u0002H?\"\u0004\b\u0000\u0010?*\b\u0012\u0004\u0012\u0002H?048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b@\u0010AR\u0014\u0010E\u001A\u00020\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bE\u0010FR\u0010\u0010s\u001A\u0004\u0018\u00010oX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006}"}, d2={"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "<init>", "(Landroidx/compose/ui/Modifier$Element;)V", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "onAttach", "", "onDetach", "unInitializeModifier", "initializeModifier", "duringAttach", "", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "invalidateCache", "onMeasureResultChanged", "updateDrawCache", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "isValidOwnerScope", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onDensityChange", "onCancelPointerInput", "sharePointerInputWithSiblings", "interceptOutOfBoundsChildEvents", "modifyParentData", "", "parentData", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "lastOnPlacedCoordinates", "onPlaced", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BackwardsCompatNode extends Node implements BuildDrawCacheParams, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, ModifierLocalModifierNode, ModifierLocalReadScope, DrawModifierNode, GlobalPositionAwareModifierNode, LayoutAwareModifierNode, LayoutModifierNode, OwnerScope, ParentDataModifierNode, PointerInputModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private BackwardsCompatLocalMap _providedValues;
    private Element element;
    private boolean invalidateCache;
    private LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet readValues;

    static {
    }

    public BackwardsCompatNode(Element arg2) {
        super();
        this.setKindSet$ui(NodeKindKt.calculateNodeKindSetFrom(arg2));
        this.element = arg2;
        this.invalidateCache = true;
        this.readValues = new HashSet();
    }

    public static final LayoutCoordinates access$getLastOnPlacedCoordinates$p(BackwardsCompatNode arg0) {
        return arg0.lastOnPlacedCoordinates;
    }

    public void applyFocusProperties(FocusProperties arg2) {
        Element v1 = this.element;
        if(!(v1 instanceof FocusOrderModifier)) {
            InlineClassHelperKt.throwIllegalStateException("applyFocusProperties called on wrong node");
        }

        ((FocusOrderModifier)v1).populateFocusOrder(new FocusOrder(arg2));
    }

    public void applySemantics(SemanticsPropertyReceiver arg2) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        SemanticsConfiguration v1_1 = ((SemanticsModifier)v1).getSemanticsConfiguration();
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsConfiguration");
        ((SemanticsConfiguration)arg2).collapsePeer$ui(v1_1);
    }

    public void draw(ContentDrawScope arg4) {
        Element v0 = this.element;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        Element v1 = v0;
        if((this.invalidateCache) && ((v0 instanceof DrawCacheModifier))) {
            this.updateDrawCache();
        }

        ((DrawModifier)v1).draw(arg4);
    }

    public Object getCurrent(ModifierLocal arg11) {
        this.readValues.add(arg11);
        int v0 = NodeKind.constructor-impl(0x20);
        if(!((DelegatableNode)this).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v1 = ((DelegatableNode)this).getNode().getParent$ui();
        LayoutNode v10 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this));
        while(v10 != null) {
            Node v3 = null;
            if((v10.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                while(v1 != null) {
                    if((v1.getKindSet$ui() & v0) != 0) {
                        Node v2 = v1;
                        MutableVector v4 = ((MutableVector)v3);
                        while(true) {
                        label_25:
                            if(v2 != null) {
                                if((v2 instanceof ModifierLocalModifierNode)) {
                                    if(((ModifierLocalModifierNode)v2).getProvidedValues().contains$ui(arg11)) {
                                        return ((ModifierLocalModifierNode)v2).getProvidedValues().get$ui(arg11);
                                    }
                                }
                                else if((v2.getKindSet$ui() & v0) != 0 && ((v2 instanceof DelegatingNode))) {
                                    Node v5 = v2.getDelegate$ui();
                                    int v7 = 0;
                                    while(v5 != null) {
                                        if((v5.getKindSet$ui() & v0) != 0) {
                                            ++v7;
                                            if(v7 == 1) {
                                                v2 = v5;
                                            }
                                            else {
                                                if(v4 == null) {
                                                    v4 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v2 != null) {
                                                    if(v4 != null) {
                                                        v4.add(v2);
                                                    }

                                                    v2 = v3;
                                                }

                                                if(v4 == null) {
                                                    goto label_63;
                                                }

                                                v4.add(v5);
                                            }
                                        }

                                    label_63:
                                        v5 = v5.getChild$ui();
                                    }

                                    if(v7 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_69;
                        }

                        v2 = DelegatableNodeKt.access$pop(v4);
                        goto label_25;
                    }

                label_69:
                    v1 = v1.getParent$ui();
                }
            }

            v10 = v10.getParent$ui();
            if(v10 != null) {
                NodeChain v1_1 = v10.getNodes$ui();
                if(v1_1 != null) {
                    v1 = v1_1.getTail$ui();
                    continue;
                }
            }

            v1 = v3;
        }

        return arg11.getDefaultFactory$ui().invoke();
    }

    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this)).getDensity();
    }

    public final Element getElement() {
        return this.element;
    }

    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this)).getLayoutDirection();
    }

    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap v0 = this._providedValues;
        if(v0 != null) {
            return ((ModifierLocalMap)v0);
        }

        return ModifierLocalModifierNodeKt.modifierLocalMapOf();
    }

    public final HashSet getReadValues() {
        return this.readValues;
    }

    public long getSize-NH-jbRc() {
        return IntSizeKt.toSize-ozmzZPI(DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)this), NodeKind.constructor-impl(0x80)).getSize-YbymL2g());
    }

    private final void initializeModifier(boolean arg6) {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("initializeModifier called on unattached node");
        }

        Element v0 = this.element;
        BackwardsCompatNode v1 = this;
        if((NodeKind.constructor-impl(0x20) & ((Node)v1).getKindSet$ui()) != 0) {
            if((v0 instanceof ModifierLocalConsumer)) {
                this.sideEffect(new BackwardsCompatNode$initializeModifier$2(this));
            }

            if(!(v0 instanceof ModifierLocalProvider)) {
                goto label_20;
            }

            this.updateModifierLocalProvider(v0);
        }

    label_20:
        if((NodeKind.constructor-impl(4) & ((Node)v1).getKindSet$ui()) != 0) {
            if((v0 instanceof DrawCacheModifier)) {
                this.invalidateCache = true;
            }

            if(arg6) {
                goto label_32;
            }

            LayoutModifierNodeKt.invalidateLayer(this);
        }

    label_32:
        if((NodeKind.constructor-impl(2) & ((Node)v1).getKindSet$ui()) != 0) {
            if(BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                NodeCoordinator v2 = this.getCoordinator$ui();
                Intrinsics.checkNotNull(v2);
                v2.setLayoutModifierNode$ui(this);
                v2.onLayoutModifierNodeChanged();
            }

            if(arg6) {
                goto label_51;
            }

            LayoutModifierNodeKt.invalidateLayer(this);
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui();
        }

    label_51:
        if((v0 instanceof RemeasurementModifier)) {
            v0.onRemeasurementAvailable(DelegatableNodeKt.requireLayoutNode(this));
        }

        if((NodeKind.constructor-impl(0x80) & ((Node)v1).getKindSet$ui()) != 0 && ((v0 instanceof OnRemeasuredModifier)) && (BackwardsCompatNodeKt.access$isChainUpdate(this))) {
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui();
        }

        if((NodeKind.constructor-impl(0x400000) & ((Node)v1).getKindSet$ui()) != 0 && ((v0 instanceof OnPlacedModifier))) {
            this.lastOnPlacedCoordinates = null;
            if(BackwardsCompatNodeKt.access$isChainUpdate(this)) {
                DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new BackwardsCompatNode$initializeModifier$3(this));
            }
        }

        if((NodeKind.constructor-impl(0x100) & ((Node)v1).getKindSet$ui()) != 0 && ((v0 instanceof OnGloballyPositionedModifier)) && (BackwardsCompatNodeKt.access$isChainUpdate(this))) {
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui();
        }

        if((v0 instanceof FocusRequesterModifier)) {
            v0.getFocusRequester().getFocusRequesterNodes$ui().add(this);
        }

        if((NodeKind.constructor-impl(16) & ((Node)v1).getKindSet$ui()) != 0 && ((v0 instanceof PointerInputModifier))) {
            ((PointerInputModifier)v0).getPointerInputFilter().setLayoutCoordinates$ui(this.getCoordinator$ui());
        }

        if((NodeKind.constructor-impl(8) & ((Node)v1).getKindSet$ui()) != 0) {
            DelegatableNodeKt.requireOwner(((DelegatableNode)this)).onSemanticsChange();
        }
    }

    public boolean interceptOutOfBoundsChildEvents() {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier)v1).getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    public boolean isValidOwnerScope() {
        return this.isAttached();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier)v1).maxIntrinsicHeight(arg2, arg3, arg4);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier)v1).maxIntrinsicWidth(arg2, arg3, arg4);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg2, Measurable arg3, long arg4) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier)v1).measure-3p2s80s(arg2, arg3, arg4);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier)v1).minIntrinsicHeight(arg2, arg3, arg4);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg2, IntrinsicMeasurable arg3, int arg4) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier)v1).minIntrinsicWidth(arg2, arg3, arg4);
    }

    public Object modifyParentData(Density arg2, Object arg3) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier)v1).modifyParentData(arg2, arg3);
    }

    public void onAttach() {
        this.initializeModifier(true);
    }

    public void onCancelPointerInput() {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier)v1).getPointerInputFilter().onCancel();
    }

    public void onDensityChange() {
        if((this.element instanceof PointerInputModifier)) {
            this.onCancelPointerInput();
        }
    }

    public void onDetach() {
        this.unInitializeModifier();
    }

    public final void onDrawCacheReadsChanged$ui() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    public void onFocusEvent(FocusState arg2) {
        Element v1 = this.element;
        if(!(v1 instanceof FocusEventModifier)) {
            InlineClassHelperKt.throwIllegalStateException("onFocusEvent called on wrong node");
        }

        ((FocusEventModifier)v1).onFocusEvent(arg2);
    }

    public void onGloballyPositioned(LayoutCoordinates arg2) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier)v1).onGloballyPositioned(arg2);
    }

    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    public void onPlaced(LayoutCoordinates arg2) {
        this.lastOnPlacedCoordinates = arg2;
        Element v1 = this.element;
        if((v1 instanceof OnPlacedModifier)) {
            ((OnPlacedModifier)v1).onPlaced(arg2);
        }
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg2, PointerEventPass arg3, long arg4) {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier)v1).getPointerInputFilter().onPointerEvent-H0pRuoY(arg2, arg3, arg4);
    }

    public void onRemeasured-ozmzZPI(long arg2) {
        Element v1 = this.element;
        if((v1 instanceof OnRemeasuredModifier)) {
            ((OnRemeasuredModifier)v1).onRemeasured-ozmzZPI(arg2);
        }
    }

    public final void setElement(Element arg2) {
        if(this.isAttached()) {
            this.unInitializeModifier();
        }

        this.element = arg2;
        this.setKindSet$ui(NodeKindKt.calculateNodeKindSetFrom(arg2));
        if(this.isAttached()) {
            this.initializeModifier(false);
        }
    }

    public final void setReadValues(HashSet arg1) {
        this.readValues = arg1;
    }

    public boolean sharePointerInputWithSiblings() {
        Element v1 = this.element;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier)v1).getPointerInputFilter().getShareWithSiblings();
    }

    public String toString() {
        return this.element.toString();
    }

    private final void unInitializeModifier() {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("unInitializeModifier called on unattached node");
        }

        Element v0 = this.element;
        BackwardsCompatNode v1 = this;
        if((NodeKind.constructor-impl(0x20) & ((Node)v1).getKindSet$ui()) != 0) {
            if((v0 instanceof ModifierLocalProvider)) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, v0.getKey());
            }

            if(!(v0 instanceof ModifierLocalConsumer)) {
                goto label_24;
            }

            v0.onModifierLocalsUpdated(BackwardsCompatNodeKt.access$getDetachedModifierLocalReadScope$p());
        }

    label_24:
        if((((Node)v1).getKindSet$ui() & NodeKind.constructor-impl(8)) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }

        if((v0 instanceof FocusRequesterModifier)) {
            ((FocusRequesterModifier)v0).getFocusRequester().getFocusRequesterNodes$ui().remove(this);
        }
    }

    private final void updateDrawCache() {
        Element v0 = this.element;
        if((v0 instanceof DrawCacheModifier)) {
            OwnerSnapshotObserver.access$getObserver$p(DelegatableNodeKt.requireOwner(this).getSnapshotObserver()).observeReads(this, BackwardsCompatNodeKt.access$getOnDrawCacheReadsChanged$p(), new BackwardsCompatNode$updateDrawCache$1(v0, this));
        }

        this.invalidateCache = false;
    }

    public final void updateModifierLocalConsumer() {
        if(this.isAttached()) {
            this.readValues.clear();
            OwnerSnapshotObserver.access$getObserver$p(DelegatableNodeKt.requireOwner(this).getSnapshotObserver()).observeReads(this, BackwardsCompatNodeKt.access$getUpdateModifierLocalConsumer$p(), new BackwardsCompatNode$updateModifierLocalConsumer$1(this));
        }
    }

    private final void updateModifierLocalProvider(ModifierLocalProvider arg3) {
        BackwardsCompatLocalMap v0 = this._providedValues;
        if(v0 != null && (v0.contains$ui(arg3.getKey()))) {
            v0.setElement(arg3);
            DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, arg3.getKey());
            return;
        }

        this._providedValues = new BackwardsCompatLocalMap(arg3);
        if(BackwardsCompatNodeKt.access$isChainUpdate(this)) {
            DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, arg3.getKey());
        }
    }
}


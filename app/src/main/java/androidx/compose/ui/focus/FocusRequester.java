package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001A\u00020\nH\u0007J\u0017\u0010\t\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0010\u001A\u00020\u000B2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000B0\u0012H\u0000¢\u0006\u0002\b\u0014J\u0006\u0010\u0015\u001A\u00020\u000BJ\u0006\u0010\u0016\u001A\u00020\u000BJ\u0006\u0010\u0017\u001A\u00020\u000BJ\u0006\u0010\u0018\u001A\u00020\u000BJ\"\u0010\u0019\u001A\u00020\u000B2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000B0\u0012H\u0080\b¢\u0006\u0002\b\u001AR\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u001C"}, d2={"Landroidx/compose/ui/focus/FocusRequester;", "", "<init>", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui", "()Landroidx/compose/runtime/collection/MutableVector;", "requestFocus", "", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "requestFocus-3ESFkO8", "(I)Z", "findFocusTargetNode", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "findFocusTargetNode$ui", "captureFocus", "freeFocus", "saveFocusedChild", "restoreFocusedChild", "findFocusTarget", "findFocusTarget$ui", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusRequester {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001A\u00020\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/focus/FocusRequester;", "getDefault", "()Landroidx/compose/ui/focus/FocusRequester;", "Cancel", "getCancel", "Redirect", "getRedirect$ui", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u0006\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u0007\u001A\u00020\u0005H\u0086\u0002J\t\u0010\b\u001A\u00020\u0005H\u0086\u0002J\t\u0010\t\u001A\u00020\u0005H\u0086\u0002J\t\u0010\n\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u000B\u001A\u00020\u0005H\u0086\u0002J\t\u0010\f\u001A\u00020\u0005H\u0086\u0002J\t\u0010\r\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u000E\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u000F\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u0010\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u0011\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u0012\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u0013\u001A\u00020\u0005H\u0086\u0002J\t\u0010\u0014\u001A\u00020\u0005H\u0086\u0002¨\u0006\u0015"}, d2={"Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "", "<init>", "()V", "component1", "Landroidx/compose/ui/focus/FocusRequester;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FocusRequesterFactory {
            public static final int $stable;
            public static final FocusRequesterFactory INSTANCE;

            static {
                FocusRequesterFactory.INSTANCE = new FocusRequesterFactory();
            }

            private FocusRequesterFactory() {
                super();
            }

            public final FocusRequester component1() {
                return new FocusRequester();
            }

            public final FocusRequester component10() {
                return new FocusRequester();
            }

            public final FocusRequester component11() {
                return new FocusRequester();
            }

            public final FocusRequester component12() {
                return new FocusRequester();
            }

            public final FocusRequester component13() {
                return new FocusRequester();
            }

            public final FocusRequester component14() {
                return new FocusRequester();
            }

            public final FocusRequester component15() {
                return new FocusRequester();
            }

            public final FocusRequester component16() {
                return new FocusRequester();
            }

            public final FocusRequester component2() {
                return new FocusRequester();
            }

            public final FocusRequester component3() {
                return new FocusRequester();
            }

            public final FocusRequester component4() {
                return new FocusRequester();
            }

            public final FocusRequester component5() {
                return new FocusRequester();
            }

            public final FocusRequester component6() {
                return new FocusRequester();
            }

            public final FocusRequester component7() {
                return new FocusRequester();
            }

            public final FocusRequester component8() {
                return new FocusRequester();
            }

            public final FocusRequester component9() {
                return new FocusRequester();
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        public final FocusRequester getRedirect$ui() {
            return FocusRequester.Redirect;
        }
    }

    public static final int $stable;
    private static final FocusRequester Cancel;
    public static final Companion Companion;
    private static final FocusRequester Default;
    private static final FocusRequester Redirect;
    private final MutableVector focusRequesterNodes;

    static {
        FocusRequester.Companion = new Companion(null);
        FocusRequester.Default = new FocusRequester();
        FocusRequester.Cancel = new FocusRequester();
        FocusRequester.Redirect = new FocusRequester();
    }

    public FocusRequester() {
        super();
        this.focusRequesterNodes = new MutableVector(new FocusRequesterModifierNode[16], 0);
    }

    public static final FocusRequester access$getCancel$cp() {
        return FocusRequester.Cancel;
    }

    public static final FocusRequester access$getDefault$cp() {
        return FocusRequester.Default;
    }

    public static final FocusRequester access$getRedirect$cp() {
        return FocusRequester.Redirect;
    }

    public final boolean captureFocus() {
        if(this.focusRequesterNodes.getSize() == 0) {
            System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
            return 0;
        }

        MutableVector v4 = this.focusRequesterNodes;
        Object[] v0 = v4.content;
        int v4_1 = v4.getSize();
        int v2;
        for(v2 = 0; v2 < v4_1; ++v2) {
            if(FocusRequesterModifierNodeKt.captureFocus(v0[v2])) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean findFocusTarget$ui(Function1 arg15) {
        Node v4_1;
        MutableVector v10;
        Object v9;
        Companion v0 = FocusRequester.Companion;
        String v2 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if(this != v0.getDefault()) {
            if(this != v0.getCancel()) {
                if(this.getFocusRequesterNodes$ui().getSize() == 0) {
                    System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                    return 0;
                }

                MutableVector v14 = this.getFocusRequesterNodes$ui();
                Object[] v0_1 = v14.content;
                int v14_1 = v14.getSize();
                int v2_1 = 0;
                boolean v3 = false;
                while(v2_1 < v14_1) {
                    Object v4 = v0_1[v2_1];
                    int v5 = NodeKind.constructor-impl(0x400);
                    if(!((DelegatableNode)v4).getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                    }

                    int v7 = 16;
                    MutableVector v6 = new MutableVector(new Node[v7], 0);
                    Node v8 = ((DelegatableNode)v4).getNode().getChild$ui();
                    if(v8 == null) {
                        DelegatableNodeKt.access$addLayoutNodeChildren(v6, ((DelegatableNode)v4).getNode(), false);
                    }
                    else {
                        v6.add(v8);
                    }

                    while(true) {
                    label_39:
                        if(v6.getSize() != 0) {
                            v4 = v6.removeAt(v6.getSize() - 1);
                            if((((Node)v4).getAggregateChildKindSet$ui() & v5) == 0) {
                                DelegatableNodeKt.access$addLayoutNodeChildren(v6, ((Node)v4), false);
                                continue;
                            }

                            break;
                        }

                        goto label_98;
                    }

                    while(true) {
                        if(v4 == null) {
                            goto label_39;
                        }

                        if((((Node)v4).getKindSet$ui() & v5) != 0) {
                            v9 = null;
                            v10 = ((MutableVector)v9);
                            break;
                        }

                        v4_1 = v4_1.getChild$ui();
                    }

                    while(true) {
                    label_56:
                        if(v4_1 == null) {
                            goto label_39;
                        }

                        if((v4_1 instanceof FocusTargetNode)) {
                            if(arg15.invoke(v4_1).booleanValue()) {
                                v3 = true;
                                goto label_98;
                            }
                        }
                        else if((v4_1.getKindSet$ui() & v5) != 0 && ((v4_1 instanceof DelegatingNode))) {
                            Node v11 = v4_1.getDelegate$ui();
                            int v12 = 0;
                            while(v11 != null) {
                                if((v11.getKindSet$ui() & v5) != 0) {
                                    ++v12;
                                    if(v12 == 1) {
                                        v4_1 = v11;
                                    }
                                    else {
                                        if(v10 == null) {
                                            v10 = new MutableVector(new Node[v7], 0);
                                        }

                                        if(v4_1 != null) {
                                            if(v10 != null) {
                                                v10.add(v4_1);
                                            }

                                            v4 = v9;
                                        }

                                        if(v10 == null) {
                                            goto label_90;
                                        }

                                        v10.add(v11);
                                    }
                                }

                            label_90:
                                v11 = v11.getChild$ui();
                            }

                            if(v12 != 1) {
                                break;
                            }

                            continue;
                        }

                        break;
                    }

                    v4_1 = DelegatableNodeKt.access$pop(v10);
                    goto label_56;
                label_98:
                    ++v2_1;
                }

                return v3;
            }

            throw new IllegalStateException(v2.toString());
        }

        throw new IllegalStateException(v2.toString());
    }

    public final boolean findFocusTargetNode$ui(Function1 arg15) {
        Node v4_1;
        MutableVector v10;
        Object v9;
        Companion v0 = FocusRequester.Companion;
        String v2 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if(this != v0.getDefault()) {
            if(this != v0.getCancel()) {
                if(this.getFocusRequesterNodes$ui().getSize() == 0) {
                    System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                    return 0;
                }

                MutableVector v14 = this.getFocusRequesterNodes$ui();
                Object[] v0_1 = v14.content;
                int v14_1 = v14.getSize();
                int v2_1 = 0;
                boolean v3 = false;
                while(v2_1 < v14_1) {
                    Object v4 = v0_1[v2_1];
                    int v5 = NodeKind.constructor-impl(0x400);
                    if(!((DelegatableNode)v4).getNode().isAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                    }

                    int v7 = 16;
                    MutableVector v6 = new MutableVector(new Node[v7], 0);
                    Node v8 = ((DelegatableNode)v4).getNode().getChild$ui();
                    if(v8 == null) {
                        DelegatableNodeKt.access$addLayoutNodeChildren(v6, ((DelegatableNode)v4).getNode(), false);
                    }
                    else {
                        v6.add(v8);
                    }

                    while(true) {
                    label_39:
                        if(v6.getSize() != 0) {
                            v4 = v6.removeAt(v6.getSize() - 1);
                            if((((Node)v4).getAggregateChildKindSet$ui() & v5) == 0) {
                                DelegatableNodeKt.access$addLayoutNodeChildren(v6, ((Node)v4), false);
                                continue;
                            }

                            break;
                        }

                        goto label_105;
                    }

                    while(true) {
                        if(v4 == null) {
                            goto label_39;
                        }

                        if((((Node)v4).getKindSet$ui() & v5) != 0) {
                            v9 = null;
                            v10 = ((MutableVector)v9);
                            break;
                        }

                        v4_1 = ((Node)v4).getChild$ui();
                    }

                    while(true) {
                    label_56:
                        if(v4 == null) {
                            goto label_39;
                        }

                        if((v4 instanceof FocusTargetNode)) {
                            boolean v4_2 = ((FocusTargetNode)v4).fetchFocusProperties$ui().getCanFocus() ? arg15.invoke(v4).booleanValue() : TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(((FocusTargetNode)v4), FocusDirection.Companion.getEnter-dhqQ-8s(), arg15);
                            if(!v4_2) {
                                break;
                            }

                            v3 = true;
                            goto label_105;
                        }
                        else {
                            if((((Node)v4).getKindSet$ui() & v5) == 0) {
                                break;
                            }

                            if(!(v4 instanceof DelegatingNode)) {
                                break;
                            }

                            Node v11 = v4.getDelegate$ui();
                            int v12 = 0;
                            while(v11 != null) {
                                if((v11.getKindSet$ui() & v5) != 0) {
                                    ++v12;
                                    if(v12 == 1) {
                                        v4_1 = v11;
                                    }
                                    else {
                                        if(v10 == null) {
                                            v10 = new MutableVector(new Node[v7], 0);
                                        }

                                        if(v4 != null) {
                                            if(v10 != null) {
                                                v10.add(v4);
                                            }

                                            v4 = v9;
                                        }

                                        if(v10 == null) {
                                            goto label_97;
                                        }

                                        v10.add(v11);
                                    }
                                }

                            label_97:
                                v11 = v11.getChild$ui();
                            }

                            if(v12 != 1) {
                                break;
                            }

                            continue;
                        }
                    }

                    v4_1 = DelegatableNodeKt.access$pop(v10);
                    goto label_56;
                label_105:
                    ++v2_1;
                }

                return v3;
            }

            throw new IllegalStateException(v2.toString());
        }

        throw new IllegalStateException(v2.toString());
    }

    public final boolean freeFocus() {
        if(this.focusRequesterNodes.getSize() == 0) {
            System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
            return 0;
        }

        MutableVector v4 = this.focusRequesterNodes;
        Object[] v0 = v4.content;
        int v4_1 = v4.getSize();
        int v2;
        for(v2 = 0; v2 < v4_1; ++v2) {
            if(FocusRequesterModifierNodeKt.freeFocus(v0[v2])) {
                return 1;
            }
        }

        return 0;
    }

    public final MutableVector getFocusRequesterNodes$ui() {
        return this.focusRequesterNodes;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="use the version the has a FocusDirection", replaceWith="<_subannotation>") public final void requestFocus() {
        this.requestFocus-3ESFkO8(FocusDirection.Companion.getEnter-dhqQ-8s());
    }

    public final boolean requestFocus-3ESFkO8(int arg15) {
        Node v4_1;
        MutableVector v10;
        Object v9;
        if(ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled) {
            Companion v0 = FocusRequester.Companion;
            String v2 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
            if(this != v0.getDefault()) {
                if(this != v0.getCancel()) {
                    if(this.getFocusRequesterNodes$ui().getSize() == 0) {
                        System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                        return 0;
                    }

                    MutableVector v14 = this.getFocusRequesterNodes$ui();
                    Object[] v0_1 = v14.content;
                    int v14_1 = v14.getSize();
                    int v2_1 = 0;
                    boolean v3 = false;
                    while(v2_1 < v14_1) {
                        Object v4 = v0_1[v2_1];
                        int v5 = NodeKind.constructor-impl(0x400);
                        if(!((DelegatableNode)v4).getNode().isAttached()) {
                            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                        }

                        int v7 = 16;
                        MutableVector v6 = new MutableVector(new Node[v7], 0);
                        Node v8 = ((DelegatableNode)v4).getNode().getChild$ui();
                        if(v8 == null) {
                            DelegatableNodeKt.access$addLayoutNodeChildren(v6, ((DelegatableNode)v4).getNode(), false);
                        }
                        else {
                            v6.add(v8);
                        }

                        while(true) {
                        label_41:
                            if(v6.getSize() != 0) {
                                v4 = v6.removeAt(v6.getSize() - 1);
                                if((((Node)v4).getAggregateChildKindSet$ui() & v5) == 0) {
                                    DelegatableNodeKt.access$addLayoutNodeChildren(v6, ((Node)v4), false);
                                    continue;
                                }

                                break;
                            }

                            goto label_99;
                        }

                        while(true) {
                            if(v4 == null) {
                                goto label_41;
                            }

                            if((((Node)v4).getKindSet$ui() & v5) != 0) {
                                v9 = null;
                                v10 = ((MutableVector)v9);
                                break;
                            }

                            v4_1 = v4_1.getChild$ui();
                        }

                        while(true) {
                        label_58:
                            if(v4_1 == null) {
                                goto label_41;
                            }

                            if((v4_1 instanceof FocusTargetNode)) {
                                if(((FocusTargetNode)v4_1).requestFocus-3ESFkO8(arg15)) {
                                    v3 = true;
                                    goto label_99;
                                }
                            }
                            else if((v4_1.getKindSet$ui() & v5) != 0 && ((v4_1 instanceof DelegatingNode))) {
                                Node v11 = v4_1.getDelegate$ui();
                                int v12 = 0;
                                while(v11 != null) {
                                    if((v11.getKindSet$ui() & v5) != 0) {
                                        ++v12;
                                        if(v12 == 1) {
                                            v4_1 = v11;
                                        }
                                        else {
                                            if(v10 == null) {
                                                v10 = new MutableVector(new Node[v7], 0);
                                            }

                                            if(v4_1 != null) {
                                                if(v10 != null) {
                                                    v10.add(v4_1);
                                                }

                                                v4 = v9;
                                            }

                                            if(v10 == null) {
                                                goto label_91;
                                            }

                                            v10.add(v11);
                                        }
                                    }

                                label_91:
                                    v11 = v11.getChild$ui();
                                }

                                if(v12 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        v4_1 = DelegatableNodeKt.access$pop(v10);
                        goto label_58;
                    label_99:
                        ++v2_1;
                    }

                    return v3;
                }

                throw new IllegalStateException(v2.toString());
            }

            throw new IllegalStateException(v2.toString());
        }

        return this.findFocusTargetNode$ui(new FocusRequester$requestFocus$2(arg15));
    }

    public static boolean requestFocus-3ESFkO8$default(FocusRequester arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = FocusDirection.Companion.getEnter-dhqQ-8s();
        }

        return arg0.requestFocus-3ESFkO8(arg1);
    }

    public final boolean restoreFocusedChild() {
        if(this.focusRequesterNodes.getSize() == 0) {
            System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
            return 0;
        }

        MutableVector v5 = this.focusRequesterNodes;
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v2 = 0;
        boolean v3 = false;
        while(v2 < v5_1) {
            v3 = (FocusRequesterModifierNodeKt.restoreFocusedChild(v0[v2])) || (v3) ? true : false;
            ++v2;
        }

        return v3;
    }

    public final boolean saveFocusedChild() {
        if(this.focusRequesterNodes.getSize() == 0) {
            System.out.println("FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
            return 0;
        }

        MutableVector v4 = this.focusRequesterNodes;
        Object[] v0 = v4.content;
        int v4_1 = v4.getSize();
        int v2;
        for(v2 = 0; v2 < v4_1; ++v2) {
            if(FocusRequesterModifierNodeKt.saveFocusedChild(v0[v2])) {
                return 1;
            }
        }

        return 0;
    }
}


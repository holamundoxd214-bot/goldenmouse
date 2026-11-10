package androidx.compose.ui.viewinterop;

import android.view.View;
import android.view.ViewTreeObserver$OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\b\u0010\u001E\u001A\u00020\u001FH\u0002J\u001C\u0010 \u001A\u00020\u00152\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001A\u00020\u0015H\u0016J\b\u0010$\u001A\u00020\u0015H\u0016R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001C\u0010\f\u001A\u0004\u0018\u00010\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001A\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001A\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018¨\u0006%"}, d2={"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "<init>", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "attachedViewTreeObserver", "Landroid/view/ViewTreeObserver;", "getAttachedViewTreeObserver", "()Landroid/view/ViewTreeObserver;", "setAttachedViewTreeObserver", "(Landroid/view/ViewTreeObserver;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "getOnEnter", "()Lkotlin/jvm/functions/Function1;", "onExit", "getOnExit", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onGlobalFocusChanged", "oldFocus", "newFocus", "onAttach", "onDetach", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusGroupPropertiesNode extends Node implements ViewTreeObserver$OnGlobalFocusChangeListener, FocusPropertiesModifierNode {
    private ViewTreeObserver attachedViewTreeObserver;
    private View focusedChild;
    private final Function1 onEnter;
    private final Function1 onExit;

    public FocusGroupPropertiesNode() {
        super();
        this.onEnter = new FocusGroupPropertiesNode$onEnter$1(this);
        this.onExit = new FocusGroupPropertiesNode$onExit$1(this);
    }

    public void applyFocusProperties(FocusProperties arg2) {
        arg2.setCanFocus(false);
        arg2.setOnEnter(this.onEnter);
        arg2.setOnExit(this.onExit);
    }

    public final ViewTreeObserver getAttachedViewTreeObserver() {
        return this.attachedViewTreeObserver;
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int v0 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)this).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }

        Node v10 = ((DelegatableNode)this).getNode();
        if((v10.getAggregateChildKindSet$ui() & v0) != 0) {
            v10 = v10.getChild$ui();
            int v2 = 0;
            while(v10 != null) {
                if((v10.getKindSet$ui() & v0) != 0) {
                    Node v3 = null;
                    Node v4 = v10;
                    MutableVector v5 = ((MutableVector)v3);
                    while(true) {
                    label_21:
                        if(v4 != null) {
                            if((v4 instanceof FocusTargetNode)) {
                                if(v2 != 0) {
                                    return ((FocusTargetNode)v4);
                                }
                                else {
                                    v2 = 1;
                                }
                            }
                            else if((v4.getKindSet$ui() & v0) != 0 && ((v4 instanceof DelegatingNode))) {
                                Node v6 = v4.getDelegate$ui();
                                int v8 = 0;
                                while(v6 != null) {
                                    if((v6.getKindSet$ui() & v0) != 0) {
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

                                                v4 = v3;
                                            }

                                            if(v5 == null) {
                                                goto label_56;
                                            }

                                            v5.add(v6);
                                        }
                                    }

                                label_56:
                                    v6 = v6.getChild$ui();
                                }

                                if(v8 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_62;
                    }

                    v4 = DelegatableNodeKt.pop(v5);
                    goto label_21;
                }

            label_62:
                v10 = v10.getChild$ui();
            }
        }

        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final Function1 getOnEnter() {
        return this.onEnter;
    }

    public final Function1 getOnExit() {
        return this.onExit;
    }

    public void onAttach() {
        super.onAttach();
        ViewTreeObserver v0 = DelegatableNode_androidKt.requireView(this).getViewTreeObserver();
        this.attachedViewTreeObserver = v0;
        v0.addOnGlobalFocusChangeListener(((ViewTreeObserver$OnGlobalFocusChangeListener)this));
    }

    public void onDetach() {
        ViewTreeObserver v0 = this.attachedViewTreeObserver;
        if(v0 != null && (v0.isAlive())) {
            v0.removeOnGlobalFocusChangeListener(this);
        }

        this.attachedViewTreeObserver = null;
        DelegatableNode_androidKt.requireView(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    public void onGlobalFocusChanged(View arg7, View arg8) {
        FocusGroupPropertiesNode v0 = this;
        if(DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v0)).getOwner$ui() == null) {
        }
        else {
            View v1 = FocusGroupNode_androidKt.getEmbeddedView(this);
            FocusOwner v2 = DelegatableNodeKt.requireOwner(((DelegatableNode)v0)).getFocusOwner();
            Owner v0_1 = DelegatableNodeKt.requireOwner(((DelegatableNode)v0));
            int v7 = arg7 == null || (Intrinsics.areEqual(arg7, v0_1)) || !FocusGroupNode_androidKt.containsDescendant(v1, arg7) ? 0 : 1;
            int v0_2 = arg8 == null || (Intrinsics.areEqual(arg8, v0_1)) || !FocusGroupNode_androidKt.containsDescendant(v1, arg8) ? 0 : 1;
            if(v7 != 0 && v0_2 != 0) {
                this.focusedChild = arg8;
                return;
            }

            if(v0_2 != 0) {
                this.focusedChild = arg8;
                FocusTargetNode v6 = this.getFocusTargetOfEmbeddedViewWrapper();
                if(v6.getFocusState().getHasFocus()) {
                    return;
                }

                FocusTransactionsKt.performRequestFocus(v6);
                return;
            }

            arg8 = null;
            if(v7 == 0) {
                goto label_51;
            }

            this.focusedChild = arg8;
            if(!this.getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                return;
            }

            v2.clearFocus-I7lrPNg(false, true, false, FocusDirection.Companion.getExit-dhqQ-8s());
        }

        return;
    label_51:
        this.focusedChild = arg8;
    }

    public final void setAttachedViewTreeObserver(ViewTreeObserver arg1) {
        this.attachedViewTreeObserver = arg1;
    }

    public final void setFocusedChild(View arg1) {
        this.focusedChild = arg1;
    }
}


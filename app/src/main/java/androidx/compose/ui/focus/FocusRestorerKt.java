package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.PinnableContainer$PinnedHandle;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0004H\u0000\u001A\f\u0010\u0005\u001A\u00020\u0003*\u00020\u0004H\u0000\u001A\u000E\u0010\u0006\u001A\u0004\u0018\u00010\u0007*\u00020\u0004H\u0000\u001A\u0014\u0010\b\u001A\u00020\t*\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B\u001A\u001C\u0010\b\u001A\u00020\t*\u00020\t2\u000E\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\rH\u0007\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"PrevFocusedChild", "", "saveFocusedChild", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "restoreFocusedChild", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "focusRestorer", "Landroidx/compose/ui/Modifier;", "fallback", "Landroidx/compose/ui/focus/FocusRequester;", "onRestoreFailed", "Lkotlin/Function0;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusRestorerKt {
    private static final String PrevFocusedChild = "previouslyFocusedChildHash";

    public static final Modifier focusRestorer(Modifier arg1, FocusRequester arg2) {
        return arg1.then(new FocusRestorerElement(arg2));
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use focusRestorer(FocusRequester) instead", replaceWith="<_subannotation>") public static final Modifier focusRestorer(Modifier arg0, Function0 arg1) {
        FocusRequester v1_1;
        if(arg1 != null) {
            Object v1 = arg1.invoke();
            if(v1 == null) {
                goto label_3;
            }
        }
        else {
        label_3:
            v1_1 = FocusRequester.Companion.getDefault();
        }

        return FocusRestorerKt.focusRestorer(arg0, v1_1);
    }

    public static Modifier focusRestorer$default(Modifier arg0, FocusRequester arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = FocusRequester.Companion.getDefault();
        }

        return FocusRestorerKt.focusRestorer(arg0, arg1);
    }

    public static final PinnedHandle pinFocusedChild(FocusTargetNode arg1) {
        arg1 = FocusTraversalKt.findActiveFocusNode(arg1);
        if(arg1 != null) {
            Object v1 = CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)arg1), PinnableContainerKt.getLocalPinnableContainer());
            if(v1 != null) {
                return ((PinnableContainer)v1).pin();
            }
        }

        return null;
    }

    public static final boolean restoreFocusedChild(FocusTargetNode arg11) {
        Node v0_2;
        MutableVector v7;
        Object v6;
        Object v0;
        if(arg11.getPreviouslyFocusedChildHash() == 0) {
            v0 = CompositionLocalConsumerModifierNodeKt.currentValueOf(arg11, SaveableStateRegistryKt.getLocalSaveableStateRegistry());
            if(v0 != null) {
                v0 = ((SaveableStateRegistry)v0).consumeRestored("previouslyFocusedChildHash");
                if(v0 != null) {
                    arg11.setPreviouslyFocusedChildHash(((Integer)v0).intValue());
                }
            }
        }

        if(arg11.getPreviouslyFocusedChildHash() == 0) {
            return 0;
        }

        FocusTargetNode v0_1 = arg11;
        int v2 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)v0_1).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v4 = 16;
        MutableVector v3 = new MutableVector(new Node[v4], 0);
        Node v5 = ((DelegatableNode)v0_1).getNode().getChild$ui();
        if(v5 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v3, ((DelegatableNode)v0_1).getNode(), false);
        }
        else {
            v3.add(v5);
        }

    label_34:
        while(v3.getSize() != 0) {
            v0 = v3.removeAt(v3.getSize() - 1);
            if((((Node)v0).getAggregateChildKindSet$ui() & v2) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v3, ((Node)v0), false);
                continue;
            }

            goto label_45;
        }

        return 0;
        while(true) {
        label_45:
            if(v0 == null) {
                goto label_34;
            }

            if((((Node)v0).getKindSet$ui() & v2) != 0) {
                v6 = null;
                v7 = ((MutableVector)v6);
                break;
            }

            v0_2 = ((Node)v0).getChild$ui();
        }

        while(true) {
        label_51:
            if(v0 == null) {
                goto label_34;
            }

            if(!(v0 instanceof FocusTargetNode)) {
                if((((Node)v0).getKindSet$ui() & v2) == 0) {
                    break;
                }

                if(!(v0 instanceof DelegatingNode)) {
                    break;
                }

                Node v8 = v0.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & v2) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v0_2 = v8;
                        }
                        else {
                            if(v7 == null) {
                                v7 = new MutableVector(new Node[v4], 0);
                            }

                            if(v0 != null) {
                                if(v7 != null) {
                                    v7.add(v0);
                                }

                                v0 = v6;
                            }

                            if(v7 == null) {
                                goto label_106;
                            }

                            v7.add(v8);
                        }
                    }

                label_106:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }
            else if((((FocusTargetNode)v0).isAttached()) && DelegatableNodeKt.requireLayoutNode(v0).getCompositeKeyHash() == arg11.getPreviouslyFocusedChildHash()) {
                if(ComposeUiFlags.isRequestFocusOnNonFocusableFocusTargetEnabled) {
                    if(!FocusRestorerKt.restoreFocusedChild(((FocusTargetNode)v0)) && (!((FocusTargetNode)v0).fetchFocusProperties$ui().getCanFocus() || !FocusTargetModifierNode.requestFocus-3ESFkO8$default(((FocusTargetModifierNode)v0), 0, 1, v6))) {
                        return 0;
                    }

                    return 1;
                }
                else {
                    if(!FocusRestorerKt.restoreFocusedChild(((FocusTargetNode)v0))) {
                        if(FocusTargetModifierNode.requestFocus-3ESFkO8$default(((FocusTargetModifierNode)v0), 0, 1, v6)) {
                        }
                        else {
                            return 0;
                        }
                    }

                    return 1;
                }
            }

            break;
        }

        v0_2 = DelegatableNodeKt.access$pop(v7);
        goto label_51;
    }

    public static final boolean saveFocusedChild(FocusTargetNode arg11) {
        Node v0_2;
        MutableVector v7;
        Object v6;
        Object v0_1;
        if(!arg11.getFocusState().getHasFocus()) {
            return 0;
        }

        FocusTargetNode v0 = arg11;
        int v2 = NodeKind.constructor-impl(0x400);
        if(!((DelegatableNode)v0).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v4 = 16;
        MutableVector v3 = new MutableVector(new Node[v4], 0);
        Node v5 = ((DelegatableNode)v0).getNode().getChild$ui();
        if(v5 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v3, ((DelegatableNode)v0).getNode(), false);
        }
        else {
            v3.add(v5);
        }

    label_24:
        while(v3.getSize() != 0) {
            v0_1 = v3.removeAt(v3.getSize() - 1);
            if((((Node)v0_1).getAggregateChildKindSet$ui() & v2) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v3, ((Node)v0_1), false);
                continue;
            }

            goto label_35;
        }

        return 0;
        while(true) {
        label_35:
            if(v0_1 == null) {
                goto label_24;
            }

            if((((Node)v0_1).getKindSet$ui() & v2) != 0) {
                v6 = null;
                v7 = ((MutableVector)v6);
                break;
            }

            v0_2 = v0_2.getChild$ui();
        }

        while(true) {
        label_41:
            if(v0_2 == null) {
                goto label_24;
            }

            if(!(v0_2 instanceof FocusTargetNode)) {
                if((v0_2.getKindSet$ui() & v2) == 0) {
                    break;
                }

                if(!(v0_2 instanceof DelegatingNode)) {
                    break;
                }

                Node v8 = v0_2.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & v2) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v0_2 = v8;
                        }
                        else {
                            if(v7 == null) {
                                v7 = new MutableVector(new Node[v4], 0);
                            }

                            if(v0_2 != null) {
                                if(v7 != null) {
                                    v7.add(v0_2);
                                }

                                v0_1 = v6;
                            }

                            if(v7 == null) {
                                goto label_85;
                            }

                            v7.add(v8);
                        }
                    }

                label_85:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }
            else if(((FocusTargetNode)v0_2).getFocusState().getHasFocus()) {
                arg11.setPreviouslyFocusedChildHash(DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v0_2)).getCompositeKeyHash());
                v0_1 = CompositionLocalConsumerModifierNodeKt.currentValueOf(arg11, SaveableStateRegistryKt.getLocalSaveableStateRegistry());
                if(v0_1 != null) {
                    ((SaveableStateRegistry)v0_1).registerProvider("previouslyFocusedChildHash", new FocusRestorerKt$saveFocusedChild$1$1(arg11));
                }

                return 1;
            }

            break;
        }

        v0_2 = DelegatableNodeKt.access$pop(v7);
        goto label_41;
    }
}


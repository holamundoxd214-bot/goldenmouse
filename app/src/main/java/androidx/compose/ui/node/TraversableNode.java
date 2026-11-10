package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TraversableNode extends DelegatableNode {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/compose/ui/node/TraversableNode$Companion;", "", "<init>", "()V", "TraverseDescendantsAction", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "", "<init>", "(Ljava/lang/String;I)V", "ContinueTraversal", "SkipSubtreeAndContinueTraversal", "CancelTraversal", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TraverseDescendantsAction {
            public static final enum TraverseDescendantsAction CancelTraversal;
            public static final enum TraverseDescendantsAction ContinueTraversal;
            public static final enum TraverseDescendantsAction SkipSubtreeAndContinueTraversal;

            private static final TraverseDescendantsAction[] $values() {
                return new TraverseDescendantsAction[]{TraverseDescendantsAction.ContinueTraversal, TraverseDescendantsAction.SkipSubtreeAndContinueTraversal, TraverseDescendantsAction.CancelTraversal};
            }

            static {
                TraverseDescendantsAction.ContinueTraversal = new TraverseDescendantsAction("ContinueTraversal", 0);
                TraverseDescendantsAction.SkipSubtreeAndContinueTraversal = new TraverseDescendantsAction("SkipSubtreeAndContinueTraversal", 1);
                TraverseDescendantsAction.CancelTraversal = new TraverseDescendantsAction("CancelTraversal", 2);
                TraverseDescendantsAction[] v0 = TraverseDescendantsAction.$values();
                TraverseDescendantsAction.$VALUES = v0;
                TraverseDescendantsAction.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
            }

            private TraverseDescendantsAction(String arg1, int arg2) {
                super(arg1, arg2);
            }

            public static EnumEntries getEntries() {
                return TraverseDescendantsAction.$ENTRIES;
            }

            public static TraverseDescendantsAction valueOf(String arg1) {
                return Enum.valueOf(TraverseDescendantsAction.class, arg1);
            }

            public static TraverseDescendantsAction[] values() {
                return TraverseDescendantsAction.$VALUES.clone();
            }
        }

        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;

    static {
        TraversableNode.Companion = Companion.$$INSTANCE;
    }

    Object getTraverseKey();
}


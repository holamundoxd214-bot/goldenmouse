package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\t\nB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u0006*\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0006H&\u0082\u0001\u0002\u000B\f¨\u0006\r"}, d2={"Landroidx/compose/foundation/layout/SiblingsAlignedNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "WithAlignmentLineBlockNode", "WithAlignmentLineNode", "Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineBlockNode;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineNode;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class SiblingsAlignedNode extends Node implements ParentDataModifierNode {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000B\u001A\u00020\f*\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\fH\u0016R&\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineBlockNode;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "setBlock", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WithAlignmentLineBlockNode extends SiblingsAlignedNode {
        public static final int $stable = 8;
        private Function1 block;

        static {
        }

        public WithAlignmentLineBlockNode(Function1 arg2) {
            super(null);
            this.block = arg2;
        }

        public final Function1 getBlock() {
            return this.block;
        }

        public Object modifyParentData(Density arg8, Object arg9) {
            RowColumnParentData v9;
            if((arg9 instanceof RowColumnParentData)) {
            }
            else {
                v9 = null;
            }

            if(0 == 0) {
                v9 = new RowColumnParentData(0f, false, null, null, 15, null);
            }

            v9.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout(new Block(this.block)));
            return v9;
        }

        public final void setBlock(Function1 arg1) {
            this.block = arg1;
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001A\u00020\n*\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\nH\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\r"}, d2={"Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineNode;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "setAlignmentLine", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WithAlignmentLineNode extends SiblingsAlignedNode {
        public static final int $stable = 8;
        private AlignmentLine alignmentLine;

        static {
        }

        public WithAlignmentLineNode(AlignmentLine arg2) {
            super(null);
            this.alignmentLine = arg2;
        }

        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public Object modifyParentData(Density arg8, Object arg9) {
            RowColumnParentData v9;
            if((arg9 instanceof RowColumnParentData)) {
            }
            else {
                v9 = null;
            }

            if(0 == 0) {
                v9 = new RowColumnParentData(0f, false, null, null, 15, null);
            }

            v9.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout(new Value(this.alignmentLine)));
            return v9;
        }

        public final void setAlignmentLine(AlignmentLine arg1) {
            this.alignmentLine = arg1;
        }
    }

    public static final int $stable;

    static {
        SiblingsAlignedNode.$stable = Node.$stable;
    }

    private SiblingsAlignedNode() {
        super();
    }

    public SiblingsAlignedNode(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract Object modifyParentData(Density arg1, Object arg2);
}


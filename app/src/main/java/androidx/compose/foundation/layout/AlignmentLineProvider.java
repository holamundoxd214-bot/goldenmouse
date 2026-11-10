package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&\u0082\u0001\u0002\n\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/layout/AlignmentLineProvider;", "", "<init>", "()V", "calculateAlignmentLinePosition", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "Block", "Value", "Landroidx/compose/foundation/layout/AlignmentLineProvider$Block;", "Landroidx/compose/foundation/layout/AlignmentLineProvider$Value;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AlignmentLineProvider {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0015\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001F\u0010\u000E\u001A\u00020\u00002\u0014\b\u0002\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/layout/AlignmentLineProvider$Block;", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "lineProviderBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getLineProviderBlock", "()Lkotlin/jvm/functions/Function1;", "calculateAlignmentLinePosition", "placeable", "Landroidx/compose/ui/layout/Placeable;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Block extends AlignmentLineProvider {
        public static final int $stable;
        private final Function1 lineProviderBlock;

        static {
        }

        public Block(Function1 arg2) {
            super(null);
            this.lineProviderBlock = arg2;
        }

        public int calculateAlignmentLinePosition(Placeable arg1) {
            return this.lineProviderBlock.invoke(arg1).intValue();
        }

        public final Function1 component1() {
            return this.lineProviderBlock;
        }

        public final Block copy(Function1 arg1) {
            return new Block(arg1);
        }

        public static Block copy$default(Block arg0, Function1 arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.lineProviderBlock;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Block)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Block)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.lineProviderBlock, ((Block)arg4).lineProviderBlock)) {
                return 0;
            }

            return 1;
        }

        public final Function1 getLineProviderBlock() {
            return this.lineProviderBlock;
        }

        public int hashCode() {
            return this.lineProviderBlock.hashCode();
        }

        public String toString() {
            return "Block(lineProviderBlock=" + this.lineProviderBlock + ')';
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001A\u00020\tHÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/layout/AlignmentLineProvider$Value;", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLinePosition", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Value extends AlignmentLineProvider {
        public static final int $stable;
        private final AlignmentLine alignmentLine;

        static {
        }

        public Value(AlignmentLine arg2) {
            super(null);
            this.alignmentLine = arg2;
        }

        public int calculateAlignmentLinePosition(Placeable arg1) {
            return arg1.get(this.alignmentLine);
        }

        public final AlignmentLine component1() {
            return this.alignmentLine;
        }

        public final Value copy(AlignmentLine arg1) {
            return new Value(arg1);
        }

        public static Value copy$default(Value arg0, AlignmentLine arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.alignmentLine;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Value)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Value)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.alignmentLine, ((Value)arg4).alignmentLine)) {
                return 0;
            }

            return 1;
        }

        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        public String toString() {
            return "Value(alignmentLine=" + this.alignmentLine + ')';
        }
    }

    public static final int $stable;

    static {
    }

    private AlignmentLineProvider() {
        super();
    }

    public AlignmentLineProvider(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract int calculateAlignmentLinePosition(Placeable arg1);
}


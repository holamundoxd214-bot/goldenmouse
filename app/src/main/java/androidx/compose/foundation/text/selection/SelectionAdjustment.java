package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SelectionAdjustment {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getNone", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "Character", "getCharacter", "Word", "getWord", "Paragraph", "getParagraph", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final SelectionAdjustment Character;
        private static final SelectionAdjustment CharacterWithWordAccelerate;
        private static final SelectionAdjustment None;
        private static final SelectionAdjustment Paragraph;
        private static final SelectionAdjustment Word;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.None = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0();
            Companion.Character = new SelectionAdjustment$Companion$$ExternalSyntheticLambda1();
            Companion.Word = new SelectionAdjustment$Companion$$ExternalSyntheticLambda2();
            Companion.Paragraph = new SelectionAdjustment$Companion$$ExternalSyntheticLambda3();
            Companion.CharacterWithWordAccelerate = new SelectionAdjustment$Companion$$ExternalSyntheticLambda4();
        }

        private Companion() {
            super();
        }

        static final Selection Character$lambda$0(SelectionLayout arg1) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(Companion.None.adjust(arg1), arg1);
        }

        static final Selection CharacterWithWordAccelerate$lambda$0(SelectionLayout arg5) {
            boolean v0_1;
            AnchorInfo v3;
            AnchorInfo v4;
            AnchorInfo v2;
            AnchorInfo v1;
            Selection v0 = arg5.getPreviousSelection();
            if(v0 == null) {
                return Companion.Word.adjust(arg5);
            }

            if(arg5.isStartHandle()) {
                v1 = v0.getStart();
                v2 = SelectionAdjustmentKt.access$updateSelectionBoundary(arg5, arg5.getStartInfo(), v1);
                v4 = v0.getEnd();
                v3 = v2;
            }
            else {
                v1 = v0.getEnd();
                v2 = SelectionAdjustmentKt.access$updateSelectionBoundary(arg5, arg5.getEndInfo(), v1);
                v3 = v0.getStart();
                v4 = v2;
            }

            if(Intrinsics.areEqual(v2, v1)) {
                return v0;
            }

            if(arg5.getCrossStatus() != CrossStatus.CROSSED) {
                if(arg5.getCrossStatus() == CrossStatus.COLLAPSED && v3.getOffset() > v4.getOffset()) {
                    goto label_34;
                }

                v0_1 = false;
            }
            else {
            label_34:
                v0_1 = true;
            }

            return SelectionAdjustmentKt.ensureAtLeastOneChar(new Selection(v3, v4, v0_1), arg5);
        }

        static final Selection None$lambda$0(SelectionLayout arg4) {
            AnchorInfo v1 = arg4.getStartInfo().anchorForOffset(arg4.getStartInfo().getRawStartHandleOffset());
            AnchorInfo v2 = arg4.getEndInfo().anchorForOffset(arg4.getEndInfo().getRawEndHandleOffset());
            boolean v4 = arg4.getCrossStatus() == CrossStatus.CROSSED ? true : false;
            return new Selection(v1, v2, v4);
        }

        static final Selection Paragraph$lambda$0(SelectionLayout arg1) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(arg1, SelectionAdjustment$Companion$Paragraph$1$1.INSTANCE);
        }

        static final Selection Word$lambda$0(SelectionLayout arg1) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(arg1, SelectionAdjustment$Companion$Word$1$1.INSTANCE);
        }

        public final SelectionAdjustment getCharacter() {
            return Companion.Character;
        }

        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return Companion.CharacterWithWordAccelerate;
        }

        public final SelectionAdjustment getNone() {
            return Companion.None;
        }

        public final SelectionAdjustment getParagraph() {
            return Companion.Paragraph;
        }

        public final SelectionAdjustment getWord() {
            return Companion.Word;
        }
    }

    public static final Companion Companion;

    static {
        SelectionAdjustment.Companion = Companion.$$INSTANCE;
    }

    Selection adjust(SelectionLayout arg1);
}


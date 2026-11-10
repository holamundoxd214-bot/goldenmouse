package androidx.compose.foundation;

import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001A\u00020\t*\u00020\nH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/IndicationModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "indicationInstance", "Landroidx/compose/foundation/IndicationInstance;", "<init>", "(Landroidx/compose/foundation/IndicationInstance;)V", "getIndicationInstance", "()Landroidx/compose/foundation/IndicationInstance;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class IndicationModifier implements DrawModifier {
    private final IndicationInstance indicationInstance;

    public IndicationModifier(IndicationInstance arg1) {
        super();
        this.indicationInstance = arg1;
    }

    public void draw(ContentDrawScope arg1) {
        this.indicationInstance.drawIndication(arg1);
    }

    public final IndicationInstance getIndicationInstance() {
        return this.indicationInstance;
    }
}


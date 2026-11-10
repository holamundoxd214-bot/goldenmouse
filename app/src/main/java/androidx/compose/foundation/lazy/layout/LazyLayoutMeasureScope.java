package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.MeasureScope;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001A\u00020\u0006H&J%\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\nH\'¢\u0006\u0004\b\u000B\u0010\f\u0082\u0001\u0001\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "compose", "", "Landroidx/compose/ui/layout/Measurable;", "index", "", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyLayoutMeasureScope extends MeasureScope {
    List compose(int arg1);

    @Deprecated(message="Please use compose and call Measurable.measure", replaceWith="<_subannotation>") List measure-0kLqBqw(int arg1, long arg2);
}


package androidx.compose.material3.carousel;

import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u00126\u0010\u0002\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0006\u0010\n\u001A\u00020\u0004\u0012\u0006\u0010\u000B\u001A\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001C\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u0007\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001AH\u0016R>\u0010\u0002\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000F8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0012¨\u0006\u001D"}, d2={"Landroidx/compose/material3/carousel/CarouselPageSize;", "Landroidx/compose/foundation/pager/PageSize;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "beforeContentPadding", "afterContentPadding", "<init>", "(Lkotlin/jvm/functions/Function2;FF)V", "<set-?>", "Landroidx/compose/material3/carousel/Strategy;", "strategyState", "getStrategyState", "()Landroidx/compose/material3/carousel/Strategy;", "setStrategyState", "(Landroidx/compose/material3/carousel/Strategy;)V", "strategyState$delegate", "Landroidx/compose/runtime/MutableState;", "strategy", "getStrategy", "calculateMainAxisPageSize", "", "Landroidx/compose/ui/unit/Density;", "pageSpacing", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CarouselPageSize implements PageSize {
    public static final int $stable;
    private final float afterContentPadding;
    private final float beforeContentPadding;
    private final Function2 keylineList;
    private final MutableState strategyState$delegate;

    static {
    }

    public CarouselPageSize(Function2 arg1, float arg2, float arg3) {
        super();
        this.keylineList = arg1;
        this.beforeContentPadding = arg2;
        this.afterContentPadding = arg3;
        this.strategyState$delegate = SnapshotStateKt.mutableStateOf$default(Strategy.Companion.getEmpty(), null, 2, null);
    }

    public int calculateMainAxisPageSize(Density arg7, int arg8, int arg9) {
        float v2 = ((float)arg8);
        float v3 = ((float)arg9);
        this.setStrategyState(new Strategy(this.keylineList.invoke(Float.valueOf(v2), Float.valueOf(v3)), v2, v3, this.beforeContentPadding, this.afterContentPadding));
        if(this.getStrategy().isValid()) {
            return MathKt.roundToInt(this.getStrategy().getItemMainAxisSize());
        }

        return arg8;
    }

    public final Strategy getStrategy() {
        return this.getStrategyState();
    }

    private final Strategy getStrategyState() {
        return this.strategyState$delegate.getValue();
    }

    private final void setStrategyState(Strategy arg1) {
        this.strategyState$delegate.setValue(arg1);
    }
}


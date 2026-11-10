package androidx.compose.ui.platform;

import android.view.View;
import java.util.Comparator;

public final class FocusSorter$$ExternalSyntheticLambda1 implements Comparator {
    public FocusSorter$$ExternalSyntheticLambda1() {
        super();
    }

    public final int compare(Object arg1, Object arg2) {
        return FocusSorter.sidesComparator$lambda$0(((View)arg1), ((View)arg2));
    }
}


package androidx.compose.ui.platform;

import android.view.View;
import java.util.Comparator;

public final class FocusSorter$$ExternalSyntheticLambda0 implements Comparator {
    public FocusSorter$$ExternalSyntheticLambda0() {
        super();
    }

    public final int compare(Object arg1, Object arg2) {
        return FocusSorter.topsComparator$lambda$0(((View)arg1), ((View)arg2));
    }
}


package androidx.window.area.reflectionguard;

import android.app.Activity;
import android.util.DisplayMetrics;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.core.util.function.Consumer;

public interface WindowAreaComponentApi3Requirements {
    void addRearDisplayPresentationStatusListener(Consumer arg1);

    void addRearDisplayStatusListener(Consumer arg1);

    void endRearDisplayPresentationSession();

    void endRearDisplaySession();

    DisplayMetrics getRearDisplayMetrics();

    ExtensionWindowAreaPresentation getRearDisplayPresentation();

    void removeRearDisplayPresentationStatusListener(Consumer arg1);

    void removeRearDisplayStatusListener(Consumer arg1);

    void startRearDisplayPresentationSession(Activity arg1, Consumer arg2);

    void startRearDisplaySession(Activity arg1, Consumer arg2);
}


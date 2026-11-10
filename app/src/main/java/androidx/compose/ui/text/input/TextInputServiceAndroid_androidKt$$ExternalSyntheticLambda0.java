package androidx.compose.ui.text.input;

import android.view.Choreographer;
import java.util.concurrent.Executor;

public final class TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 implements Executor {
    public TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(Choreographer arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void execute(Runnable arg1) {
        TextInputServiceAndroid_androidKt.asExecutor$lambda$0(this.f$0, arg1);
    }
}


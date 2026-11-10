package androidx.window.area;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.window.area.utils.PresentationWindowCompatUtils;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.WindowAreaComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u0013H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2={"Landroidx/window/area/RearDisplayPresentationSessionPresenterImpl;", "Landroidx/window/area/WindowAreaSessionPresenter;", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "presentation", "Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;", "vendorApiLevel", "", "<init>", "(Landroidx/window/extensions/area/WindowAreaComponent;Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;I)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "window", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "setContentView", "", "view", "Landroid/view/View;", "close", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RearDisplayPresentationSessionPresenterImpl implements WindowAreaSessionPresenter {
    private final Context context;
    private final ExtensionWindowAreaPresentation presentation;
    private final Window window;
    private final WindowAreaComponent windowAreaComponent;

    public RearDisplayPresentationSessionPresenterImpl(WindowAreaComponent arg2, ExtensionWindowAreaPresentation arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "windowAreaComponent");
        Intrinsics.checkNotNullParameter(arg3, "presentation");
        super();
        this.windowAreaComponent = arg2;
        this.presentation = arg3;
        Context v2 = arg3.getPresentationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getPresentationContext(...)");
        this.context = v2;
        Window v2_1 = arg4 >= 4 ? arg3.getWindow() : PresentationWindowCompatUtils.INSTANCE.getWindowBeforeVendorApiLevel4(arg3);
        this.window = v2_1;
    }

    public void close() {
        this.windowAreaComponent.endRearDisplayPresentationSession();
    }

    public Context getContext() {
        return this.context;
    }

    public Window getWindow() {
        return this.window;
    }

    public void setContentView(View arg2) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        this.presentation.setPresentationView(arg2);
    }
}


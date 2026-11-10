package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001A\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00050\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"Landroidx/lifecycle/viewmodel/internal/JvmViewModelProviders;", "", "<init>", "()V", "createViewModel", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class JvmViewModelProviders {
    public static final JvmViewModelProviders INSTANCE;

    static {
        JvmViewModelProviders.INSTANCE = new JvmViewModelProviders();
    }

    private JvmViewModelProviders() {
        super();
    }

    public final ViewModel createViewModel(Class arg4) {
        Constructor v1;
        String v3 = "Cannot create an instance of ";
        Intrinsics.checkNotNullParameter(arg4, "modelClass");
        try {
            v1 = arg4.getDeclaredConstructor();
        }
        catch(NoSuchMethodException v0) {
            throw new RuntimeException(v3 + arg4, ((Throwable)v0));
        }

        if(Modifier.isPublic(v1.getModifiers())) {
            try {
                Object v0_3 = v1.newInstance();
                Intrinsics.checkNotNull(v0_3);
                return ((ViewModel)v0_3);
            }
            catch(IllegalAccessException v0_1) {
                throw new RuntimeException(v3 + arg4, ((Throwable)v0_1));
            }
            catch(InstantiationException v0_2) {
                throw new RuntimeException(v3 + arg4, ((Throwable)v0_2));
            }
        }

        throw new RuntimeException(v3 + arg4);
    }
}


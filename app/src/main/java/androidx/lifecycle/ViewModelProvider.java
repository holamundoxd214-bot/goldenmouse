package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras$Empty;
import androidx.lifecycle.viewmodel.CreationExtras$Key;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import androidx.lifecycle.viewmodel.internal.ViewModelProviderImpl;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0016\u0018\u0000 !2\u00020\u0001:\u0005\u001D\u001E\u001F !B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\u0004\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u0004\u0010\u000FB\u0019\b\u0016\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u0010J&\u0010\u0011\u001A\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0087\u0002¢\u0006\u0002\u0010\u0016J&\u0010\u0011\u001A\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018J.\u0010\u0011\u001A\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u001A2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0087\u0002¢\u0006\u0002\u0010\u001BJ.\u0010\u0011\u001A\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u001A2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0002¢\u0006\u0002\u0010\u001CR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/lifecycle/ViewModelProvider;", "", "impl", "Landroidx/lifecycle/viewmodel/internal/ViewModelProviderImpl;", "<init>", "(Landroidx/lifecycle/viewmodel/internal/ViewModelProviderImpl;)V", "store", "Landroidx/lifecycle/ViewModelStore;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "get", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Landroidx/lifecycle/ViewModel;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Factory", "OnRequeryFactory", "NewInstanceFactory", "AndroidViewModelFactory", "Companion", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public class ViewModelProvider {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001B\b\u0002\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tJ-\u0010\n\u001A\u0002H\u000B\"\b\b\u0000\u0010\u000B*\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J%\u0010\n\u001A\u0002H\u000B\"\b\b\u0000\u0010\u000B*\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000EH\u0016¢\u0006\u0002\u0010\u0012J-\u0010\n\u001A\u0002H\u000B\"\b\b\u0000\u0010\u000B*\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u000E2\u0006\u0010\u0013\u001A\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "application", "Landroid/app/Application;", "unused", "", "<init>", "(Landroid/app/Application;I)V", "()V", "(Landroid/app/Application;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public class AndroidViewModelFactory extends NewInstanceFactory {
        @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH\u0007R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion;", "", "<init>", "()V", "_instance", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "getInstance", "application", "Landroid/app/Application;", "APPLICATION_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            @JvmStatic public final AndroidViewModelFactory getInstance(Application arg1) {
                Intrinsics.checkNotNullParameter(arg1, "application");
                if(AndroidViewModelFactory._instance == null) {
                    AndroidViewModelFactory._instance = new AndroidViewModelFactory(arg1);
                }

                AndroidViewModelFactory v0 = AndroidViewModelFactory._instance;
                Intrinsics.checkNotNull(v0);
                return v0;
            }
        }

        public static final Key APPLICATION_KEY;
        public static final Companion Companion;
        private static AndroidViewModelFactory _instance;
        private final Application application;

        static {
            AndroidViewModelFactory.Companion = new Companion(null);
            AndroidViewModelFactory.APPLICATION_KEY = new ViewModelProvider$AndroidViewModelFactory$special$$inlined$Key$1();
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        private AndroidViewModelFactory(Application arg1, int arg2) {
            super();
            this.application = arg1;
        }

        public AndroidViewModelFactory(Application arg2) {
            Intrinsics.checkNotNullParameter(arg2, "application");
            this(arg2, 0);
        }

        public static final AndroidViewModelFactory access$get_instance$cp() {
            return AndroidViewModelFactory._instance;
        }

        public static final void access$set_instance$cp(AndroidViewModelFactory arg0) {
            AndroidViewModelFactory._instance = arg0;
        }

        private final ViewModel create(Class arg4, Application arg5) {
            String v0 = "Cannot create an instance of ";
            if(AndroidViewModel.class.isAssignableFrom(arg4)) {
                try {
                    Object v3_4 = arg4.getConstructor(Application.class).newInstance(arg5);
                    Intrinsics.checkNotNull(v3_4);
                    return ((ViewModel)v3_4);
                }
                catch(InvocationTargetException v3) {
                    throw new RuntimeException(v0 + arg4, ((Throwable)v3));
                }
                catch(InstantiationException v3_1) {
                    throw new RuntimeException(v0 + arg4, ((Throwable)v3_1));
                }
                catch(IllegalAccessException v3_2) {
                    throw new RuntimeException(v0 + arg4, ((Throwable)v3_2));
                }
                catch(NoSuchMethodException v3_3) {
                    throw new RuntimeException(v0 + arg4, ((Throwable)v3_3));
                }
            }

            return super.create(arg4);
        }

        public ViewModel create(Class arg2) {
            Intrinsics.checkNotNullParameter(arg2, "modelClass");
            Application v0 = this.application;
            if(v0 != null) {
                return this.create(arg2, v0);
            }

            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public ViewModel create(Class arg2, CreationExtras arg3) {
            Intrinsics.checkNotNullParameter(arg2, "modelClass");
            Intrinsics.checkNotNullParameter(arg3, "extras");
            if(this.application != null) {
                return this.create(arg2);
            }

            Object v3 = arg3.get(AndroidViewModelFactory.APPLICATION_KEY);
            if(v3 != null) {
                return this.create(arg2, ((Application)v3));
            }

            if(!AndroidViewModel.class.isAssignableFrom(arg2)) {
                return super.create(arg2);
            }

            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        @JvmStatic public static final AndroidViewModelFactory getInstance(Application arg1) {
            return AndroidViewModelFactory.Companion.getInstance(arg1);
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007J$\u0010\u0004\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007R\u0016\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/lifecycle/ViewModelProvider$Companion;", "", "<init>", "()V", "create", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "store", "Landroidx/lifecycle/ViewModelStore;", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.lifecycle.ViewModelProvider$Companion {
        public androidx.lifecycle.ViewModelProvider$Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private androidx.lifecycle.ViewModelProvider$Companion() {
            super();
        }

        @JvmStatic public final ViewModelProvider create(ViewModelStore arg1, Factory arg2, CreationExtras arg3) {
            Intrinsics.checkNotNullParameter(arg1, "store");
            Intrinsics.checkNotNullParameter(arg2, "factory");
            Intrinsics.checkNotNullParameter(arg3, "extras");
            return new ViewModelProvider(arg1, arg2, arg3);
        }

        @JvmStatic public final ViewModelProvider create(ViewModelStoreOwner arg1, Factory arg2, CreationExtras arg3) {
            Intrinsics.checkNotNullParameter(arg1, "owner");
            Intrinsics.checkNotNullParameter(arg2, "factory");
            Intrinsics.checkNotNullParameter(arg3, "extras");
            return new ViewModelProvider(arg1.getViewModelStore(), arg2, arg3);
        }

        public static ViewModelProvider create$default(androidx.lifecycle.ViewModelProvider$Companion arg0, ViewModelStore arg1, Factory arg2, CreationExtras arg3, int arg4, Object arg5) {
            Empty v3;
            DefaultViewModelProviderFactory v2;
            if((arg4 & 2) != 0) {
                v2 = DefaultViewModelProviderFactory.INSTANCE;
            }

            if((arg4 & 4) != 0) {
                v3 = Empty.INSTANCE;
            }

            return arg0.create(arg1, ((Factory)v2), ((CreationExtras)v3));
        }

        public static ViewModelProvider create$default(androidx.lifecycle.ViewModelProvider$Companion arg0, ViewModelStoreOwner arg1, Factory arg2, CreationExtras arg3, int arg4, Object arg5) {
            if((arg4 & 2) != 0) {
                arg2 = ViewModelStoreOwnerDefaults.getViewModelProviderFactory(arg1);
            }

            if((arg4 & 4) != 0) {
                arg3 = ViewModelStoreOwnerDefaults.getViewModelCreationExtras(arg1);
            }

            return arg0.create(arg1, arg2, arg3);
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ%\u0010\u0002\u001A\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J-\u0010\u0002\u001A\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0002\u0010\nJ-\u0010\u0002\u001A\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u000B2\u0006\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0002\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0001"}, d2={"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Factory {
        @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u00052\u001A\u0010\u0006\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0007\"\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"Landroidx/lifecycle/ViewModelProvider$Factory$Companion;", "", "<init>", "()V", "from", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.lifecycle.ViewModelProvider$Factory$Companion {
            static {
                androidx.lifecycle.ViewModelProvider$Factory$Companion.$$INSTANCE = new androidx.lifecycle.ViewModelProvider$Factory$Companion();
            }

            private androidx.lifecycle.ViewModelProvider$Factory$Companion() {
                super();
            }

            @JvmStatic public final Factory from(ViewModelInitializer[] arg2) {
                Intrinsics.checkNotNullParameter(arg2, "initializers");
                return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel(Arrays.copyOf(((Object[])arg2), arg2.length));
            }
        }

        public static final androidx.lifecycle.ViewModelProvider$Factory$Companion Companion;

        static {
            Factory.Companion = androidx.lifecycle.ViewModelProvider$Factory$Companion.$$INSTANCE;
        }

        default ViewModel create(Class arg2, CreationExtras arg3) {
            Intrinsics.checkNotNullParameter(arg2, "modelClass");
            Intrinsics.checkNotNullParameter(arg3, "extras");
            return this.create(arg2);
        }

        default ViewModel create(Class arg1) {
            Intrinsics.checkNotNullParameter(arg1, "modelClass");
            return ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel();
        }

        default ViewModel create(KClass arg2, CreationExtras arg3) {
            Intrinsics.checkNotNullParameter(arg2, "modelClass");
            Intrinsics.checkNotNullParameter(arg3, "extras");
            return this.create(JvmClassMappingKt.getJavaClass(arg2), arg3);
        }

        @JvmStatic static Factory from(ViewModelInitializer[] arg1) {
            return Factory.Companion.from(arg1);
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001A\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\tJ-\u0010\u0004\u001A\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0002\u0010\fJ-\u0010\u0004\u001A\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00050\r2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0002\u0010\u000E¨\u0006\u0010"}, d2={"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public class NewInstanceFactory implements Factory {
        @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001A\u0004\b\b\u0010\tR\u0016\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion;", "", "<init>", "()V", "_instance", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "instance", "getInstance$annotations", "getInstance", "()Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.lifecycle.ViewModelProvider$NewInstanceFactory$Companion {
            public androidx.lifecycle.ViewModelProvider$NewInstanceFactory$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.lifecycle.ViewModelProvider$NewInstanceFactory$Companion() {
                super();
            }

            public final NewInstanceFactory getInstance() {
                if(NewInstanceFactory._instance == null) {
                    NewInstanceFactory._instance = new NewInstanceFactory();
                }

                NewInstanceFactory v0 = NewInstanceFactory._instance;
                Intrinsics.checkNotNull(v0);
                return v0;
            }

            @JvmStatic public static void getInstance$annotations() {
            }
        }

        public static final androidx.lifecycle.ViewModelProvider$NewInstanceFactory$Companion Companion;
        public static final Key VIEW_MODEL_KEY;
        private static NewInstanceFactory _instance;

        static {
            NewInstanceFactory.Companion = new androidx.lifecycle.ViewModelProvider$NewInstanceFactory$Companion(null);
            NewInstanceFactory.VIEW_MODEL_KEY = ViewModelProvider.VIEW_MODEL_KEY;
        }

        public NewInstanceFactory() {
            super();
        }

        public static final NewInstanceFactory access$get_instance$cp() {
            return NewInstanceFactory._instance;
        }

        public static final void access$set_instance$cp(NewInstanceFactory arg0) {
            NewInstanceFactory._instance = arg0;
        }

        public ViewModel create(Class arg1) {
            Intrinsics.checkNotNullParameter(arg1, "modelClass");
            return JvmViewModelProviders.INSTANCE.createViewModel(arg1);
        }

        public ViewModel create(Class arg2, CreationExtras arg3) {
            Intrinsics.checkNotNullParameter(arg2, "modelClass");
            Intrinsics.checkNotNullParameter(arg3, "extras");
            return this.create(arg2);
        }

        public ViewModel create(KClass arg2, CreationExtras arg3) {
            Intrinsics.checkNotNullParameter(arg2, "modelClass");
            Intrinsics.checkNotNullParameter(arg3, "extras");
            return this.create(JvmClassMappingKt.getJavaClass(arg2), arg3);
        }

        public static final NewInstanceFactory getInstance() {
            return NewInstanceFactory.Companion.getInstance();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\b"}, d2={"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "<init>", "()V", "onRequery", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public class OnRequeryFactory {
        public OnRequeryFactory() {
            super();
        }

        public void onRequery(ViewModel arg1) {
            Intrinsics.checkNotNullParameter(arg1, "viewModel");
        }
    }

    public static final androidx.lifecycle.ViewModelProvider$Companion Companion;
    public static final Key VIEW_MODEL_KEY;
    private final ViewModelProviderImpl impl;

    static {
        ViewModelProvider.Companion = new androidx.lifecycle.ViewModelProvider$Companion(null);
        ViewModelProvider.VIEW_MODEL_KEY = new ViewModelProvider$special$$inlined$Key$1();
    }

    public ViewModelProvider(ViewModelStore arg8, Factory arg9) {
        Intrinsics.checkNotNullParameter(arg8, "store");
        Intrinsics.checkNotNullParameter(arg9, "factory");
        this(arg8, arg9, null, 4, null);
    }

    public ViewModelProvider(ViewModelStore arg1, Factory arg2, CreationExtras arg3, int arg4, DefaultConstructorMarker arg5) {
        Empty v3;
        if((arg4 & 4) != 0) {
            v3 = Empty.INSTANCE;
        }

        this(arg1, arg2, ((CreationExtras)v3));
    }

    public ViewModelProvider(ViewModelStore arg2, Factory arg3, CreationExtras arg4) {
        Intrinsics.checkNotNullParameter(arg2, "store");
        Intrinsics.checkNotNullParameter(arg3, "factory");
        Intrinsics.checkNotNullParameter(arg4, "defaultCreationExtras");
        this(new ViewModelProviderImpl(arg2, arg3, arg4));
    }

    private ViewModelProvider(ViewModelProviderImpl arg1) {
        super();
        this.impl = arg1;
    }

    public ViewModelProvider(ViewModelStoreOwner arg3) {
        Intrinsics.checkNotNullParameter(arg3, "owner");
        this(arg3.getViewModelStore(), ViewModelStoreOwnerDefaults.getViewModelProviderFactory(arg3), ViewModelStoreOwnerDefaults.getViewModelCreationExtras(arg3));
    }

    public ViewModelProvider(ViewModelStoreOwner arg2, Factory arg3) {
        Intrinsics.checkNotNullParameter(arg2, "owner");
        Intrinsics.checkNotNullParameter(arg3, "factory");
        this(arg2.getViewModelStore(), arg3, ViewModelStoreOwnerDefaults.getViewModelCreationExtras(arg2));
    }

    @JvmStatic public static final ViewModelProvider create(ViewModelStore arg1, Factory arg2, CreationExtras arg3) {
        return ViewModelProvider.Companion.create(arg1, arg2, arg3);
    }

    @JvmStatic public static final ViewModelProvider create(ViewModelStoreOwner arg1, Factory arg2, CreationExtras arg3) {
        return ViewModelProvider.Companion.create(arg1, arg2, arg3);
    }

    public final ViewModel get(KClass arg3) {
        Intrinsics.checkNotNullParameter(arg3, "modelClass");
        return ViewModelProviderImpl.getViewModel$lifecycle_viewmodel$default(this.impl, arg3, null, 2, null);
    }

    public ViewModel get(Class arg2) {
        Intrinsics.checkNotNullParameter(arg2, "modelClass");
        return this.get(JvmClassMappingKt.getKotlinClass(arg2));
    }

    public final ViewModel get(String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "modelClass");
        return this.impl.getViewModel$lifecycle_viewmodel(arg3, arg2);
    }

    public ViewModel get(String arg2, Class arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "modelClass");
        return this.impl.getViewModel$lifecycle_viewmodel(JvmClassMappingKt.getKotlinClass(arg3), arg2);
    }
}


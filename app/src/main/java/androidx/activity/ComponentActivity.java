package androidx.activity;

import android.app.Application;
import android.app.PictureInPictureUiState;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewTreeObserver$OnDrawListener;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.app.PictureInPictureParamsCompat;
import androidx.core.app.PictureInPictureProvider;
import androidx.core.app.PictureInPictureUiStateCompat;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigationevent.DirectNavigationEventInput;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.ViewTreeNavigationEventDispatcherOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008E\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0016\u0018\u0000 Ò\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000B2\u00020\f2\u00020\r2\u00020\u000E2\u00020\u000F2\u00020\u00102\u00020\u0011:\bÏ\u0001Ð\u0001Ñ\u0001Ò\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013B\u0013\b\u0017\u0012\b\b\u0001\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0012\u0010\u0016J\u0012\u0010F\u001A\u00020G2\b\u0010H\u001A\u0004\u0018\u00010IH\u0014J\u0010\u0010J\u001A\u00020G2\u0006\u0010K\u001A\u00020IH\u0015J\b\u0010L\u001A\u0004\u0018\u00010MJ\n\u0010N\u001A\u0004\u0018\u00010MH\u0017J\u0012\u0010R\u001A\u00020G2\b\b\u0001\u0010S\u001A\u00020\u0015H\u0016J\u0012\u0010R\u001A\u00020G2\b\u0010T\u001A\u0004\u0018\u00010UH\u0016J\u001C\u0010R\u001A\u00020G2\b\u0010T\u001A\u0004\u0018\u00010U2\b\u0010V\u001A\u0004\u0018\u00010WH\u0016J\u001C\u0010X\u001A\u00020G2\b\u0010T\u001A\u0004\u0018\u00010U2\b\u0010V\u001A\u0004\u0018\u00010WH\u0016J\b\u0010Y\u001A\u00020GH\u0017J\n\u0010Z\u001A\u0004\u0018\u00010[H\u0016J\u000E\u0010\\\u001A\u00020G2\u0006\u0010]\u001A\u00020^J\u000E\u0010_\u001A\u00020G2\u0006\u0010]\u001A\u00020^J\"\u0010`\u001A\u00020>2\u0006\u0010a\u001A\u00020\u00152\b\u0010T\u001A\u0004\u0018\u00010U2\u0006\u0010b\u001A\u00020cH\u0016J\u0018\u0010d\u001A\u00020>2\u0006\u0010a\u001A\u00020\u00152\u0006\u0010b\u001A\u00020cH\u0016J\u0018\u0010e\u001A\u00020>2\u0006\u0010a\u001A\u00020\u00152\u0006\u0010f\u001A\u00020gH\u0016J\u0018\u0010h\u001A\u00020G2\u0006\u0010a\u001A\u00020\u00152\u0006\u0010b\u001A\u00020cH\u0016J\u0010\u0010i\u001A\u00020G2\u0006\u0010j\u001A\u00020kH\u0016J\u0018\u0010i\u001A\u00020G2\u0006\u0010j\u001A\u00020k2\u0006\u0010l\u001A\u00020\u0003H\u0016J \u0010i\u001A\u00020G2\u0006\u0010j\u001A\u00020k2\u0006\u0010l\u001A\u00020\u00032\u0006\u0010m\u001A\u00020nH\u0017J\u0010\u0010o\u001A\u00020G2\u0006\u0010j\u001A\u00020kH\u0016J\b\u0010p\u001A\u00020GH\u0016J\b\u0010x\u001A\u00020GH\u0002J\t\u0010\u0082\u0001\u001A\u00020GH\u0017J\u0013\u0010\u008C\u0001\u001A\u00020G2\b\u0010\u008D\u0001\u001A\u00030\u0084\u0001H\u0003J\u001B\u0010\u0092\u0001\u001A\u00020G2\u0007\u0010\u0093\u0001\u001A\u0002042\u0007\u0010\u0094\u0001\u001A\u00020\u0015H\u0017J&\u0010\u0092\u0001\u001A\u00020G2\u0007\u0010\u0093\u0001\u001A\u0002042\u0007\u0010\u0094\u0001\u001A\u00020\u00152\t\u0010\u0095\u0001\u001A\u0004\u0018\u00010IH\u0017JB\u0010\u0096\u0001\u001A\u00020G2\b\u0010\u0093\u0001\u001A\u00030\u0097\u00012\u0007\u0010\u0094\u0001\u001A\u00020\u00152\t\u0010\u0098\u0001\u001A\u0004\u0018\u0001042\u0007\u0010\u0099\u0001\u001A\u00020\u00152\u0007\u0010\u009A\u0001\u001A\u00020\u00152\u0007\u0010\u009B\u0001\u001A\u00020\u0015H\u0017JM\u0010\u0096\u0001\u001A\u00020G2\b\u0010\u0093\u0001\u001A\u00030\u0097\u00012\u0007\u0010\u0094\u0001\u001A\u00020\u00152\t\u0010\u0098\u0001\u001A\u0004\u0018\u0001042\u0007\u0010\u0099\u0001\u001A\u00020\u00152\u0007\u0010\u009A\u0001\u001A\u00020\u00152\u0007\u0010\u009B\u0001\u001A\u00020\u00152\t\u0010\u0095\u0001\u001A\u0004\u0018\u00010IH\u0017J&\u0010\u009C\u0001\u001A\u00020G2\u0007\u0010\u0094\u0001\u001A\u00020\u00152\u0007\u0010\u009D\u0001\u001A\u00020\u00152\t\u0010\u009E\u0001\u001A\u0004\u0018\u000104H\u0015J3\u0010\u009F\u0001\u001A\u00020G2\u0007\u0010\u0094\u0001\u001A\u00020\u00152\u000F\u0010 \u0001\u001A\n\u0012\u0005\u0012\u00030¢\u00010¡\u00012\b\u0010£\u0001\u001A\u00030¤\u0001H\u0017¢\u0006\u0003\u0010¥\u0001JO\u0010¦\u0001\u001A\n\u0012\u0005\u0012\u0003H¨\u00010§\u0001\"\u0005\b\u0000\u0010¨\u0001\"\u0005\b\u0001\u0010©\u00012\u0016\u0010ª\u0001\u001A\u0011\u0012\u0005\u0012\u0003H¨\u0001\u0012\u0005\u0012\u0003H©\u00010«\u00012\u0007\u0010¬\u0001\u001A\u00020+2\u000F\u0010­\u0001\u001A\n\u0012\u0005\u0012\u0003H©\u00010®\u0001JF\u0010¦\u0001\u001A\n\u0012\u0005\u0012\u0003H¨\u00010§\u0001\"\u0005\b\u0000\u0010¨\u0001\"\u0005\b\u0001\u0010©\u00012\u0016\u0010ª\u0001\u001A\u0011\u0012\u0005\u0012\u0003H¨\u0001\u0012\u0005\u0012\u0003H©\u00010«\u00012\u000F\u0010­\u0001\u001A\n\u0012\u0005\u0012\u0003H©\u00010®\u0001J\u0012\u0010¯\u0001\u001A\u00020G2\u0007\u0010°\u0001\u001A\u000201H\u0017J\u0015\u0010±\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020100J\u0015\u0010²\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020100J\u0012\u0010³\u0001\u001A\u00020G2\u0007\u0010´\u0001\u001A\u00020\u0015H\u0017J\u0015\u0010µ\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020\u001500J\u0015\u0010¶\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020\u001500J\u0012\u0010·\u0001\u001A\u00020G2\u0007\u0010\u0093\u0001\u001A\u000204H\u0015J\u0015\u0010¸\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020400J\u0015\u0010¹\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020400J\u0012\u0010º\u0001\u001A\u00020G2\u0007\u0010»\u0001\u001A\u00020>H\u0017J\u001B\u0010º\u0001\u001A\u00020G2\u0007\u0010»\u0001\u001A\u00020>2\u0007\u0010°\u0001\u001A\u000201H\u0017J\u0015\u0010¼\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020600J\u0015\u0010½\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020600J\u0012\u0010¾\u0001\u001A\u00020G2\u0007\u0010¿\u0001\u001A\u00020>H\u0017J\u001B\u0010¾\u0001\u001A\u00020G2\u0007\u0010¿\u0001\u001A\u00020>2\u0007\u0010°\u0001\u001A\u000201H\u0017J\u0013\u0010À\u0001\u001A\u00020G2\b\u0010Á\u0001\u001A\u00030Â\u0001H\u0017J\u0015\u0010Ã\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020800J\u0015\u0010Ä\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020800J\u0015\u0010Å\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020:00J\u0015\u0010Æ\u0001\u001A\u00020G2\f\u0010]\u001A\b\u0012\u0004\u0012\u00020:00J\u0010\u0010Ç\u0001\u001A\u00020G2\u0007\u0010V\u001A\u00030È\u0001J\u0010\u0010É\u0001\u001A\u00020G2\u0007\u0010V\u001A\u00030È\u0001J\t\u0010Ê\u0001\u001A\u00020GH\u0015J\u000F\u0010Ë\u0001\u001A\u00020G2\u0006\u0010]\u001A\u00020<J\u000F\u0010Ì\u0001\u001A\u00020G2\u0006\u0010]\u001A\u00020<J\t\u0010Í\u0001\u001A\u00020GH\u0016J\t\u0010Î\u0001\u001A\u00020!H\u0002R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001D\u0010\u0013R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010\"\u001A\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b$\u0010%R\u0012\u0010\u0014\u001A\u00020\u00158\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010*\u001A\u00020+¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u001A\u0010.\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u000201000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u00102\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0015000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u00103\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u000204000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u00105\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u000206000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u00107\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u000208000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u00109\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020:000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001A\b\u0012\u0004\u0012\u00020<0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010=\u001A\u00020>X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020>X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010@\u001A\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\'\u001A\u0004\bB\u0010CR\u000E\u0010E\u001A\u00020>X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010O\u001A\u0004\u0018\u00010M8WX\u0096\u0004¢\u0006\u0006\u001A\u0004\bP\u0010QR\u0014\u0010q\u001A\u00020r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bs\u0010tR\u0014\u0010u\u001A\u00020\u001F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bv\u0010wR\u001B\u0010y\u001A\u00020z8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\'\u001A\u0004\b{\u0010|R\u0016\u0010~\u001A\u00020\u007F8WX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0083\u0001\u001A\u00030\u0084\u00018FX\u0086\u0084\u0002¢\u0006\u000F\n\u0005\b\u0087\u0001\u0010\'\u001A\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0088\u0001\u001A\u00030\u0089\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u008A\u0001\u0010\u008B\u0001R\u0015\u0010\u008E\u0001\u001A\u00030\u008F\u00018F¢\u0006\b\u001A\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006Ó\u0001"}, d2={"Landroidx/activity/ComponentActivity;", "Landroidx/core/app/ComponentActivity;", "Landroidx/activity/contextaware/ContextAware;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/navigationevent/NavigationEventDispatcherOwner;", "Landroidx/activity/result/ActivityResultRegistryOwner;", "Landroidx/activity/result/ActivityResultCaller;", "Landroidx/core/content/OnConfigurationChangedProvider;", "Landroidx/core/content/OnTrimMemoryProvider;", "Landroidx/core/app/OnNewIntentProvider;", "Landroidx/core/app/OnMultiWindowModeChangedProvider;", "Landroidx/core/app/PictureInPictureProvider;", "Landroidx/core/view/MenuHost;", "Landroidx/activity/FullyDrawnReporterOwner;", "<init>", "()V", "contentLayoutId", "", "(I)V", "contextAwareHelper", "Landroidx/activity/contextaware/ContextAwareHelper;", "menuHostHelper", "Landroidx/core/view/MenuHostHelper;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "getSavedStateRegistryController$annotations", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "reportFullyDrawnExecutor", "Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "fullyDrawnReporter", "Landroidx/activity/FullyDrawnReporter;", "getFullyDrawnReporter", "()Landroidx/activity/FullyDrawnReporter;", "fullyDrawnReporter$delegate", "Lkotlin/Lazy;", "nextLocalRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "activityResultRegistry", "Landroidx/activity/result/ActivityResultRegistry;", "getActivityResultRegistry", "()Landroidx/activity/result/ActivityResultRegistry;", "onConfigurationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/core/util/Consumer;", "Landroid/content/res/Configuration;", "onTrimMemoryListeners", "onNewIntentListeners", "Landroid/content/Intent;", "onMultiWindowModeChangedListeners", "Landroidx/core/app/MultiWindowModeChangedInfo;", "onPictureInPictureModeChangedListeners", "Landroidx/core/app/PictureInPictureModeChangedInfo;", "onPictureInPictureUiStateChangedListeners", "Landroidx/core/app/PictureInPictureUiStateCompat;", "onUserLeaveHintListeners", "Ljava/lang/Runnable;", "dispatchingOnMultiWindowModeChanged", "", "dispatchingOnPictureInPictureModeChanged", "onBackPressedInput", "Landroidx/navigationevent/DirectNavigationEventInput;", "getOnBackPressedInput", "()Landroidx/navigationevent/DirectNavigationEventInput;", "onBackPressedInput$delegate", "hasPictureInPictureSystemFeature", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onRetainNonConfigurationInstance", "", "onRetainCustomNonConfigurationInstance", "lastCustomNonConfigurationInstance", "getLastCustomNonConfigurationInstance", "()Ljava/lang/Object;", "setContentView", "layoutResID", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "addContentView", "initializeViewTreeOwners", "peekAvailableContext", "Landroid/content/Context;", "addOnContextAvailableListener", "listener", "Landroidx/activity/contextaware/OnContextAvailableListener;", "removeOnContextAvailableListener", "onPreparePanel", "featureId", "menu", "Landroid/view/Menu;", "onCreatePanelMenu", "onMenuItemSelected", "item", "Landroid/view/MenuItem;", "onPanelClosed", "addMenuProvider", "provider", "Landroidx/core/view/MenuProvider;", "owner", "state", "Landroidx/lifecycle/Lifecycle$State;", "removeMenuProvider", "invalidateMenu", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "ensureViewModelStore", "defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultViewModelProviderFactory$delegate", "defaultViewModelCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultViewModelCreationExtras", "()Landroidx/lifecycle/viewmodel/CreationExtras;", "onBackPressed", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher$delegate", "navigationEventDispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getNavigationEventDispatcher", "()Landroidx/navigationevent/NavigationEventDispatcher;", "addObserverForBackInvoker", "dispatcher", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "startActivityForResult", "intent", "requestCode", "options", "startIntentSenderForResult", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "onActivityResult", "resultCode", "data", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "registry", "callback", "Landroidx/activity/result/ActivityResultCallback;", "onConfigurationChanged", "newConfig", "addOnConfigurationChangedListener", "removeOnConfigurationChangedListener", "onTrimMemory", "level", "addOnTrimMemoryListener", "removeOnTrimMemoryListener", "onNewIntent", "addOnNewIntentListener", "removeOnNewIntentListener", "onMultiWindowModeChanged", "isInMultiWindowMode", "addOnMultiWindowModeChangedListener", "removeOnMultiWindowModeChangedListener", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "onPictureInPictureUiStateChanged", "pipState", "Landroid/app/PictureInPictureUiState;", "addOnPictureInPictureModeChangedListener", "removeOnPictureInPictureModeChangedListener", "addOnPictureInPictureUiStateChangedListener", "removeOnPictureInPictureUiStateChangedListener", "enterPictureInPictureMode", "Landroidx/core/app/PictureInPictureParamsCompat;", "setPictureInPictureParams", "onUserLeaveHint", "addOnUserLeaveHintListener", "removeOnUserLeaveHintListener", "reportFullyDrawn", "createFullyDrawnExecutor", "NonConfigurationInstances", "ReportFullyDrawnExecutor", "ReportFullyDrawnExecutorImpl", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public class ComponentActivity extends androidx.core.app.ComponentActivity implements FullyDrawnReporterOwner, OnBackPressedDispatcherOwner, ContextAware, ActivityResultCaller, ActivityResultRegistryOwner, OnMultiWindowModeChangedProvider, OnNewIntentProvider, PictureInPictureProvider, OnConfigurationChangedProvider, OnTrimMemoryProvider, MenuHost, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, NavigationEventDispatcherOwner, SavedStateRegistryOwner {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/activity/ComponentActivity$Companion;", "", "<init>", "()V", "ACTIVITY_RESULT_TAG", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/activity/ComponentActivity$NonConfigurationInstances;", "", "<init>", "()V", "custom", "getCustom", "()Ljava/lang/Object;", "setCustom", "(Ljava/lang/Object;)V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NonConfigurationInstances {
        private Object custom;
        private ViewModelStore viewModelStore;

        public NonConfigurationInstances() {
            super();
        }

        public final Object getCustom() {
            return this.custom;
        }

        public final ViewModelStore getViewModelStore() {
            return this.viewModelStore;
        }

        public final void setCustom(Object arg1) {
            this.custom = arg1;
        }

        public final void setViewModelStore(ViewModelStore arg1) {
            this.viewModelStore = arg1;
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\b\u0010\u0006\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "Ljava/util/concurrent/Executor;", "viewCreated", "", "view", "Landroid/view/View;", "activityDestroyed", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) interface ReportFullyDrawnExecutor extends Executor {
        void activityDestroyed();

        void viewCreated(View arg1);
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u0016H\u0016J\u0010\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u0003H\u0016J\b\u0010\u001C\u001A\u00020\u0016H\u0016J\b\u0010\u001D\u001A\u00020\u0016H\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001E"}, d2={"Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorImpl;", "Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Ljava/lang/Runnable;", "<init>", "(Landroidx/activity/ComponentActivity;)V", "endWatchTimeMillis", "", "getEndWatchTimeMillis", "()J", "currentRunnable", "getCurrentRunnable", "()Ljava/lang/Runnable;", "setCurrentRunnable", "(Ljava/lang/Runnable;)V", "onDrawScheduled", "", "getOnDrawScheduled", "()Z", "setOnDrawScheduled", "(Z)V", "viewCreated", "", "view", "Landroid/view/View;", "activityDestroyed", "execute", "runnable", "onDraw", "run", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class ReportFullyDrawnExecutorImpl implements ViewTreeObserver$OnDrawListener, ReportFullyDrawnExecutor, Runnable {
        private Runnable currentRunnable;
        private final long endWatchTimeMillis;
        private boolean onDrawScheduled;

        public ReportFullyDrawnExecutorImpl(ComponentActivity arg5) {
            ComponentActivity.this = arg5;
            super();
            this.endWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
        }

        public void activityDestroyed() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(((ViewTreeObserver$OnDrawListener)this));
        }

        public void execute(Runnable arg2) {
            Intrinsics.checkNotNullParameter(arg2, "runnable");
            this.currentRunnable = arg2;
            View v2 = ComponentActivity.this.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(v2, "getDecorView(...)");
            if(this.onDrawScheduled) {
                if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    v2.invalidate();
                    return;
                }

                v2.postInvalidate();
                return;
            }

            v2.postOnAnimation(new ComponentActivity$ReportFullyDrawnExecutorImpl$$ExternalSyntheticLambda0(this));
        }

        static final void execute$lambda$0(ReportFullyDrawnExecutorImpl arg1) {
            Runnable v0 = arg1.currentRunnable;
            if(v0 != null) {
                Intrinsics.checkNotNull(v0);
                v0.run();
                arg1.currentRunnable = null;
            }
        }

        public final Runnable getCurrentRunnable() {
            return this.currentRunnable;
        }

        public final long getEndWatchTimeMillis() {
            return this.endWatchTimeMillis;
        }

        public final boolean getOnDrawScheduled() {
            return this.onDrawScheduled;
        }

        public void onDraw() {
            Runnable v0 = this.currentRunnable;
            if(v0 != null) {
                v0.run();
                this.currentRunnable = null;
                if(ComponentActivity.this.getFullyDrawnReporter().isFullyDrawnReported()) {
                    this.onDrawScheduled = false;
                    ComponentActivity.this.getWindow().getDecorView().post(((Runnable)this));
                    return;
                }
            }
            else if(SystemClock.uptimeMillis() > this.endWatchTimeMillis) {
                this.onDrawScheduled = false;
                ComponentActivity.this.getWindow().getDecorView().post(((Runnable)this));
            }
        }

        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(((ViewTreeObserver$OnDrawListener)this));
        }

        public final void setCurrentRunnable(Runnable arg1) {
            this.currentRunnable = arg1;
        }

        public final void setOnDrawScheduled(boolean arg1) {
            this.onDrawScheduled = arg1;
        }

        public void viewCreated(View arg2) {
            Intrinsics.checkNotNullParameter(arg2, "view");
            if(!this.onDrawScheduled) {
                this.onDrawScheduled = true;
                arg2.getViewTreeObserver().addOnDrawListener(((ViewTreeObserver$OnDrawListener)this));
            }
        }
    }

    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final Companion Companion;
    private ViewModelStore _viewModelStore;
    private final ActivityResultRegistry activityResultRegistry;
    private int contentLayoutId;
    private final ContextAwareHelper contextAwareHelper;
    private final Lazy defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final Lazy fullyDrawnReporter$delegate;
    private boolean hasPictureInPictureSystemFeature;
    private final MenuHostHelper menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final Lazy onBackPressedDispatcher$delegate;
    private final Lazy onBackPressedInput$delegate;
    private final CopyOnWriteArrayList onConfigurationChangedListeners;
    private final CopyOnWriteArrayList onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList onNewIntentListeners;
    private final CopyOnWriteArrayList onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList onPictureInPictureUiStateChangedListeners;
    private final CopyOnWriteArrayList onTrimMemoryListeners;
    private final CopyOnWriteArrayList onUserLeaveHintListeners;
    private final ReportFullyDrawnExecutor reportFullyDrawnExecutor;
    private final SavedStateRegistryController savedStateRegistryController;

    public static void $r8$lambda$7IJBVrN0sHyidCAZufWEJFc7-yY(ComponentActivity arg0, OnBackPressedDispatcher arg1) {
        ComponentActivity.onBackPressedDispatcher_delegate$lambda$0$1$0(arg0, arg1);
    }

    public static void $r8$lambda$vCwjfXDiSGcirCy4I008VOiJ_lw(ComponentActivity arg0) {
        ComponentActivity.onBackPressedDispatcher_delegate$lambda$0$0(arg0);
    }

    public static Unit $r8$lambda$wJ5MHcSJed_CjC7r4OWD0UxyJsQ(ComponentActivity arg0) {
        return ComponentActivity.fullyDrawnReporter_delegate$lambda$0$0(arg0);
    }

    static {
        ComponentActivity.Companion = new Companion(null);
    }

    public ComponentActivity() {
        super();
        this.contextAwareHelper = new ContextAwareHelper();
        this.menuHostHelper = new MenuHostHelper(new ComponentActivity$$ExternalSyntheticLambda0(this));
        ComponentActivity v1 = this;
        SavedStateRegistryController v0 = SavedStateRegistryController.Companion.create(((SavedStateRegistryOwner)v1));
        this.savedStateRegistryController = v0;
        this.reportFullyDrawnExecutor = this.createFullyDrawnExecutor();
        this.fullyDrawnReporter$delegate = LazyKt.lazy(new ComponentActivity$$ExternalSyntheticLambda4(this));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new ComponentActivity$activityResultRegistry$1(this);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList();
        this.onNewIntentListeners = new CopyOnWriteArrayList();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.onPictureInPictureUiStateChangedListeners = new CopyOnWriteArrayList();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList();
        this.onBackPressedInput$delegate = LazyKt.lazy(new ComponentActivity$$ExternalSyntheticLambda5(this));
        if(this.getLifecycle() != null) {
            this.getLifecycle().addObserver(new ComponentActivity$$ExternalSyntheticLambda6(this));
            this.getLifecycle().addObserver(new ComponentActivity$$ExternalSyntheticLambda7(this));
            this.getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner arg2, Event arg3) {
                    Intrinsics.checkNotNullParameter(arg2, "source");
                    Intrinsics.checkNotNullParameter(arg3, "event");
                    ComponentActivity.access$ensureViewModelStore(ComponentActivity.this);
                    ComponentActivity.this.getLifecycle().removeObserver(((LifecycleObserver)this));
                }
            });
            v0.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(((SavedStateRegistryOwner)v1));
            this.getSavedStateRegistry().registerSavedStateProvider("android:support:activity-result", new ComponentActivity$$ExternalSyntheticLambda8(this));
            this.addOnContextAvailableListener(new ComponentActivity$$ExternalSyntheticLambda9(this));
            this.defaultViewModelProviderFactory$delegate = LazyKt.lazy(new ComponentActivity$$ExternalSyntheticLambda10(this));
            this.onBackPressedDispatcher$delegate = LazyKt.lazy(new ComponentActivity$$ExternalSyntheticLambda11(this));
            return;
        }

        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity\'s constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.".toString());
    }

    public ComponentActivity(int arg1) {
        this();
        this.contentLayoutId = arg1;
    }

    static final void _init_$lambda$1(ComponentActivity arg1, LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(arg3 == Event.ON_STOP) {
            Window v1 = arg1.getWindow();
            if(v1 != null) {
                View v1_1 = v1.peekDecorView();
                if(v1_1 != null) {
                    v1_1.cancelPendingInputEvents();
                }
            }
        }
    }

    static final void _init_$lambda$2(ComponentActivity arg1, LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(arg3 == Event.ON_DESTROY) {
            arg1.contextAwareHelper.clearAvailableContext();
            if(!arg1.isChangingConfigurations()) {
                arg1.getViewModelStore().clear();
            }

            arg1.reportFullyDrawnExecutor.activityDestroyed();
        }
    }

    static final Bundle _init_$lambda$3(ComponentActivity arg1) {
        Bundle v0 = new Bundle();
        arg1.activityResultRegistry.onSaveInstanceState(v0);
        return v0;
    }

    static final void _init_$lambda$4(ComponentActivity arg1, Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        Bundle v2 = arg1.getSavedStateRegistry().consumeRestoredStateForKey("android:support:activity-result");
        if(v2 != null) {
            arg1.activityResultRegistry.onRestoreInstanceState(v2);
        }
    }

    public static final void access$ensureViewModelStore(ComponentActivity arg0) {
        arg0.ensureViewModelStore();
    }

    public void addContentView(View arg4, ViewGroup$LayoutParams arg5) {
        this.initializeViewTreeOwners();
        ReportFullyDrawnExecutor v0 = this.reportFullyDrawnExecutor;
        View v1 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v1, "getDecorView(...)");
        v0.viewCreated(v1);
        super.addContentView(arg4, arg5);
    }

    public void addMenuProvider(MenuProvider arg2) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        this.menuHostHelper.addMenuProvider(arg2);
    }

    public void addMenuProvider(MenuProvider arg2, LifecycleOwner arg3) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        Intrinsics.checkNotNullParameter(arg3, "owner");
        this.menuHostHelper.addMenuProvider(arg2, arg3);
    }

    public void addMenuProvider(MenuProvider arg2, LifecycleOwner arg3, State arg4) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        Intrinsics.checkNotNullParameter(arg3, "owner");
        Intrinsics.checkNotNullParameter(arg4, "state");
        this.menuHostHelper.addMenuProvider(arg2, arg3, arg4);
    }

    private final void addObserverForBackInvoker(OnBackPressedDispatcher arg3) {
        this.getLifecycle().addObserver(new ComponentActivity$$ExternalSyntheticLambda2(arg3, this));
    }

    static final void addObserverForBackInvoker$lambda$0(OnBackPressedDispatcher arg1, ComponentActivity arg2, LifecycleOwner arg3, Event arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<unused var>");
        Intrinsics.checkNotNullParameter(arg4, "event");
        if(arg4 == Event.ON_CREATE) {
            OnBackInvokedDispatcher v2 = arg2.getOnBackInvokedDispatcher();
            Intrinsics.checkNotNullExpressionValue(v2, "getOnBackInvokedDispatcher(...)");
            arg1.setOnBackInvokedDispatcher(v2);
        }
    }

    public final void addOnConfigurationChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onConfigurationChangedListeners.add(arg2);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.contextAwareHelper.addOnContextAvailableListener(arg2);
    }

    public final void addOnMultiWindowModeChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onMultiWindowModeChangedListeners.add(arg2);
    }

    public final void addOnNewIntentListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onNewIntentListeners.add(arg2);
    }

    public final void addOnPictureInPictureModeChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onPictureInPictureModeChangedListeners.add(arg2);
    }

    public final void addOnPictureInPictureUiStateChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onPictureInPictureUiStateChangedListeners.add(arg2);
    }

    public final void addOnTrimMemoryListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onTrimMemoryListeners.add(arg2);
    }

    public final void addOnUserLeaveHintListener(Runnable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onUserLeaveHintListeners.add(arg2);
    }

    private final ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new ReportFullyDrawnExecutorImpl(this);
    }

    static final SavedStateViewModelFactory defaultViewModelProviderFactory_delegate$lambda$0(ComponentActivity arg4) {
        Application v1 = arg4.getApplication();
        ComponentActivity v2 = arg4;
        Bundle v4 = arg4.getIntent() != null ? arg4.getIntent().getExtras() : null;
        return new SavedStateViewModelFactory(v1, ((SavedStateRegistryOwner)v2), v4);
    }

    private final void ensureViewModelStore() {
        if(this._viewModelStore == null) {
            Object v0 = this.getLastNonConfigurationInstance();
            if(v0 != null) {
                this._viewModelStore = ((NonConfigurationInstances)v0).getViewModelStore();
            }

            if(this._viewModelStore != null) {
                return;
            }

            this._viewModelStore = new ViewModelStore();
        }
    }

    public final void enterPictureInPictureMode(PictureInPictureParamsCompat arg2) {
        Intrinsics.checkNotNullParameter(arg2, "params");
        if((this.hasPictureInPictureSystemFeature) && (arg2.isEnabled())) {
            this.enterPictureInPictureMode(arg2.toPictureInPictureParams());
        }
    }

    static final FullyDrawnReporter fullyDrawnReporter_delegate$lambda$0(ComponentActivity arg3) {
        return new FullyDrawnReporter(arg3.reportFullyDrawnExecutor, new ComponentActivity$$ExternalSyntheticLambda3(arg3));
    }

    private static final Unit fullyDrawnReporter_delegate$lambda$0$0(ComponentActivity arg0) {
        arg0.reportFullyDrawn();
        return Unit.INSTANCE;
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        Bundle v2_1;
        CreationExtras v2 = null;
        MutableCreationExtras v0 = new MutableCreationExtras(v2, 1, ((DefaultConstructorMarker)v2));
        if(this.getApplication() != null) {
            v0.set(AndroidViewModelFactory.APPLICATION_KEY, this.getApplication());
        }

        v0.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        v0.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        Intent v4 = this.getIntent();
        if(v4 != null) {
            v2_1 = v4.getExtras();
        }

        if(v2_1 != null) {
            v0.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, v2_1);
        }

        return ((CreationExtras)v0);
    }

    public Factory getDefaultViewModelProviderFactory() {
        return this.defaultViewModelProviderFactory$delegate.getValue();
    }

    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.fullyDrawnReporter$delegate.getValue();
    }

    @Deprecated(message="Use a {@link androidx.lifecycle.ViewModel} to store non config state.") public Object getLastCustomNonConfigurationInstance() {
        Object v0 = this.getLastNonConfigurationInstance();
        if(v0 != null) {
            return ((NonConfigurationInstances)v0).getCustom();
        }

        return null;
    }

    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    public NavigationEventDispatcher getNavigationEventDispatcher() {
        return this.getOnBackPressedDispatcher().getEventDispatcher$activity();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher$delegate.getValue();
    }

    private final DirectNavigationEventInput getOnBackPressedInput() {
        return this.onBackPressedInput$delegate.getValue();
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    private static void getSavedStateRegistryController$annotations() {
    }

    public ViewModelStore getViewModelStore() {
        if(this.getApplication() != null) {
            this.ensureViewModelStore();
            ViewModelStore v1 = this._viewModelStore;
            Intrinsics.checkNotNull(v1);
            return v1;
        }

        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can\'t request ViewModel before onCreate call.".toString());
    }

    public void initializeViewTreeOwners() {
        View v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        ViewTreeLifecycleOwner.set(v0, this);
        v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        ViewTreeViewModelStoreOwner.set(v0, this);
        v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        ViewTreeSavedStateRegistryOwner.set(v0, this);
        v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        ViewTreeOnBackPressedDispatcherOwner.set(v0, this);
        v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        ViewTreeFullyDrawnReporterOwner.set(v0, this);
        v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        ViewTreeNavigationEventDispatcherOwner.set(v0, ((NavigationEventDispatcherOwner)this));
    }

    public void invalidateMenu() {
        this.invalidateOptionsMenu();
    }

    static final void menuHostHelper$lambda$0(ComponentActivity arg0) {
        arg0.invalidateMenu();
    }

    @Deprecated(message="This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.") protected void onActivityResult(int arg2, int arg3, Intent arg4) {
        if(!this.activityResultRegistry.dispatchResult(arg2, arg3, arg4)) {
            super.onActivityResult(arg2, arg3, arg4);
        }
    }

    @Deprecated(message="This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.") public void onBackPressed() {
        this.getOnBackPressedInput().backCompleted();
    }

    static final OnBackPressedDispatcher onBackPressedDispatcher_delegate$lambda$0(ComponentActivity arg3) {
        OnBackPressedDispatcher v0 = new OnBackPressedDispatcher(new ComponentActivity$$ExternalSyntheticLambda12(arg3));
        if(Build$VERSION.SDK_INT >= 33) {
            if(!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                new Handler(Looper.getMainLooper()).post(new ComponentActivity$$ExternalSyntheticLambda1(arg3, v0));
                return v0;
            }
            else {
                arg3.addObserverForBackInvoker(v0);
            }
        }

        return v0;
    }

    private static final void onBackPressedDispatcher_delegate$lambda$0$0(ComponentActivity arg2) {
        try {
            super.onBackPressed();
            return;
        }
        catch(NullPointerException v2) {
            if(!Intrinsics.areEqual(v2.getMessage(), "Attempt to invoke virtual method \'android.os.Handler android.app.FragmentHostCallback.getHandler()\' on a null object reference")) {
                goto label_8;
            }
        }
        catch(IllegalStateException v2_1) {
            if(Intrinsics.areEqual(v2_1.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                return;
            }

            throw v2_1;
        }

        return;
    label_8:
        throw v2;
    }

    private static final void onBackPressedDispatcher_delegate$lambda$0$1$0(ComponentActivity arg0, OnBackPressedDispatcher arg1) {
        arg0.addObserverForBackInvoker(arg1);
    }

    static final DirectNavigationEventInput onBackPressedInput_delegate$lambda$0(ComponentActivity arg2) {
        DirectNavigationEventInput v0 = new DirectNavigationEventInput();
        arg2.getNavigationEventDispatcher().addInput(v0);
        return v0;
    }

    public void onConfigurationChanged(Configuration arg2) {
        Intrinsics.checkNotNullParameter(arg2, "newConfig");
        super.onConfigurationChanged(arg2);
        Iterator v1 = this.onConfigurationChangedListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(v1, "iterator(...)");
        while(v1.hasNext()) {
            v1.next().accept(arg2);
        }
    }

    protected void onCreate(Bundle arg3) {
        this.savedStateRegistryController.performRestore(arg3);
        this.contextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(arg3);
        ReportFragment.Companion.injectIfNeededIn(this);
        int v3 = this.contentLayoutId;
        if(v3 != 0) {
            this.setContentView(v3);
        }

        this.hasPictureInPictureSystemFeature = this.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public boolean onCreatePanelMenu(int arg2, Menu arg3) {
        Intrinsics.checkNotNullParameter(arg3, "menu");
        if(arg2 == 0) {
            super.onCreatePanelMenu(arg2, arg3);
            this.menuHostHelper.onCreateMenu(arg3, this.getMenuInflater());
        }

        return 1;
    }

    public boolean onMenuItemSelected(int arg2, MenuItem arg3) {
        Intrinsics.checkNotNullParameter(arg3, "item");
        if(super.onMenuItemSelected(arg2, arg3)) {
            return 1;
        }

        if(arg2 == 0) {
            return this.menuHostHelper.onMenuItemSelected(arg3);
        }

        return 0;
    }

    @Deprecated(message="Deprecated in android.app.Activity") public void onMultiWindowModeChanged(boolean arg3) {
        if(this.dispatchingOnMultiWindowModeChanged) {
        }
        else {
            Iterator v2 = this.onMultiWindowModeChangedListeners.iterator();
            Intrinsics.checkNotNullExpressionValue(v2, "iterator(...)");
            while(v2.hasNext()) {
                v2.next().accept(new MultiWindowModeChangedInfo(arg3));
            }
        }
    }

    public void onMultiWindowModeChanged(boolean arg3, Configuration arg4) {
        Intrinsics.checkNotNullParameter(arg4, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(arg3, arg4);
        }
        catch(Throwable v3) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw v3;
        }

        this.dispatchingOnMultiWindowModeChanged = false;
        Iterator v2 = this.onMultiWindowModeChangedListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(v2, "iterator(...)");
        while(v2.hasNext()) {
            v2.next().accept(new MultiWindowModeChangedInfo(arg3, arg4));
        }
    }

    protected void onNewIntent(Intent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "intent");
        super.onNewIntent(arg2);
        Iterator v1 = this.onNewIntentListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(v1, "iterator(...)");
        while(v1.hasNext()) {
            v1.next().accept(arg2);
        }
    }

    public void onPanelClosed(int arg2, Menu arg3) {
        Intrinsics.checkNotNullParameter(arg3, "menu");
        this.menuHostHelper.onMenuClosed(arg3);
        super.onPanelClosed(arg2, arg3);
    }

    @Deprecated(message="Deprecated in android.app.Activity") public void onPictureInPictureModeChanged(boolean arg3) {
        if(this.dispatchingOnPictureInPictureModeChanged) {
        }
        else {
            Iterator v2 = this.onPictureInPictureModeChangedListeners.iterator();
            Intrinsics.checkNotNullExpressionValue(v2, "iterator(...)");
            while(v2.hasNext()) {
                v2.next().accept(new PictureInPictureModeChangedInfo(arg3));
            }
        }
    }

    public void onPictureInPictureModeChanged(boolean arg3, Configuration arg4) {
        Intrinsics.checkNotNullParameter(arg4, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(arg3, arg4);
        }
        catch(Throwable v3) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw v3;
        }

        this.dispatchingOnPictureInPictureModeChanged = false;
        Iterator v2 = this.onPictureInPictureModeChangedListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(v2, "iterator(...)");
        while(v2.hasNext()) {
            v2.next().accept(new PictureInPictureModeChangedInfo(arg3, arg4));
        }
    }

    public void onPictureInPictureUiStateChanged(PictureInPictureUiState arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pipState");
        super.onPictureInPictureUiStateChanged(arg2);
        PictureInPictureUiStateCompat v2 = PictureInPictureUiStateCompat.Companion.fromPictureInPictureUiState(arg2);
        Iterator v1 = this.onPictureInPictureUiStateChangedListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(v1, "iterator(...)");
        while(v1.hasNext()) {
            v1.next().accept(v2);
        }
    }

    public boolean onPreparePanel(int arg2, View arg3, Menu arg4) {
        Intrinsics.checkNotNullParameter(arg4, "menu");
        if(arg2 == 0) {
            super.onPreparePanel(arg2, arg3, arg4);
            this.menuHostHelper.onPrepareMenu(arg4);
        }

        return 1;
    }

    @Deprecated(message="This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)} passing\n      in a {@link RequestMultiplePermissions} object for the {@link ActivityResultContract} and\n      handling the result in the {@link ActivityResultCallback#onActivityResult(Object) callback}.") public void onRequestPermissionsResult(int arg4, String[] arg5, int[] arg6) {
        Intrinsics.checkNotNullParameter(arg5, "permissions");
        Intrinsics.checkNotNullParameter(arg6, "grantResults");
        if(!this.activityResultRegistry.dispatchResult(arg4, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", arg5).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", arg6))) {
            super.onRequestPermissionsResult(arg4, arg5, arg6);
        }
    }

    @Deprecated(message="Use a {@link androidx.lifecycle.ViewModel} to store non config state.") public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        Object v0 = this.onRetainCustomNonConfigurationInstance();
        ViewModelStore v1 = this._viewModelStore;
        if(v1 == null) {
            Object v2 = this.getLastNonConfigurationInstance();
            if(v2 != null) {
                v1 = ((NonConfigurationInstances)v2).getViewModelStore();
            }
        }

        if(v1 == null && v0 == null) {
            return null;
        }

        NonConfigurationInstances v2_1 = new NonConfigurationInstances();
        v2_1.setCustom(v0);
        v2_1.setViewModelStore(v1);
        return v2_1;
    }

    protected void onSaveInstanceState(Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg3, "outState");
        if((this.getLifecycle() instanceof LifecycleRegistry)) {
            Lifecycle v0 = this.getLifecycle();
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((LifecycleRegistry)v0).setCurrentState(State.CREATED);
        }

        super.onSaveInstanceState(arg3);
        this.savedStateRegistryController.performSave(arg3);
    }

    public void onTrimMemory(int arg3) {
        super.onTrimMemory(arg3);
        Iterator v2 = this.onTrimMemoryListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(v2, "iterator(...)");
        while(v2.hasNext()) {
            v2.next().accept(Integer.valueOf(arg3));
        }
    }

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator v1 = this.onUserLeaveHintListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(v1, "iterator(...)");
        while(v1.hasNext()) {
            v1.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.peekAvailableContext();
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract arg2, ActivityResultCallback arg3) {
        Intrinsics.checkNotNullParameter(arg2, "contract");
        Intrinsics.checkNotNullParameter(arg3, "callback");
        return this.registerForActivityResult(arg2, this.activityResultRegistry, arg3);
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract arg3, ActivityResultRegistry arg4, ActivityResultCallback arg5) {
        Intrinsics.checkNotNullParameter(arg3, "contract");
        Intrinsics.checkNotNullParameter(arg4, "registry");
        Intrinsics.checkNotNullParameter(arg5, "callback");
        return arg4.register("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), ((LifecycleOwner)this), arg3, arg5);
    }

    public void removeMenuProvider(MenuProvider arg2) {
        Intrinsics.checkNotNullParameter(arg2, "provider");
        this.menuHostHelper.removeMenuProvider(arg2);
    }

    public final void removeOnConfigurationChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onConfigurationChangedListeners.remove(arg2);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.contextAwareHelper.removeOnContextAvailableListener(arg2);
    }

    public final void removeOnMultiWindowModeChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onMultiWindowModeChangedListeners.remove(arg2);
    }

    public final void removeOnNewIntentListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onNewIntentListeners.remove(arg2);
    }

    public final void removeOnPictureInPictureModeChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onPictureInPictureModeChangedListeners.remove(arg2);
    }

    public final void removeOnPictureInPictureUiStateChangedListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onPictureInPictureUiStateChangedListeners.remove(arg2);
    }

    public final void removeOnTrimMemoryListener(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onTrimMemoryListeners.remove(arg2);
    }

    public final void removeOnUserLeaveHintListener(Runnable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "listener");
        this.onUserLeaveHintListeners.remove(arg2);
    }

    public void reportFullyDrawn() {
        try {
            if(Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }

            super.reportFullyDrawn();
            this.getFullyDrawnReporter().fullyDrawnReported();
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

        Trace.endSection();
    }

    public void setContentView(int arg4) {
        this.initializeViewTreeOwners();
        ReportFullyDrawnExecutor v0 = this.reportFullyDrawnExecutor;
        View v1 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v1, "getDecorView(...)");
        v0.viewCreated(v1);
        super.setContentView(arg4);
    }

    public void setContentView(View arg4) {
        this.initializeViewTreeOwners();
        ReportFullyDrawnExecutor v0 = this.reportFullyDrawnExecutor;
        View v1 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v1, "getDecorView(...)");
        v0.viewCreated(v1);
        super.setContentView(arg4);
    }

    public void setContentView(View arg4, ViewGroup$LayoutParams arg5) {
        this.initializeViewTreeOwners();
        ReportFullyDrawnExecutor v0 = this.reportFullyDrawnExecutor;
        View v1 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v1, "getDecorView(...)");
        v0.viewCreated(v1);
        super.setContentView(arg4, arg5);
    }

    public final void setPictureInPictureParams(PictureInPictureParamsCompat arg2) {
        Intrinsics.checkNotNullParameter(arg2, "params");
        if(this.hasPictureInPictureSystemFeature) {
            this.setPictureInPictureParams(arg2.toPictureInPictureParams());
        }
    }

    @Deprecated(message="This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.") public void startActivityForResult(Intent arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "intent");
        super.startActivityForResult(arg2, arg3);
    }

    @Deprecated(message="This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.") public void startActivityForResult(Intent arg2, int arg3, Bundle arg4) {
        Intrinsics.checkNotNullParameter(arg2, "intent");
        super.startActivityForResult(arg2, arg3, arg4);
    }

    @Deprecated(message="This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.") public void startIntentSenderForResult(IntentSender arg2, int arg3, Intent arg4, int arg5, int arg6, int arg7) throws IntentSender$SendIntentException {
        Intrinsics.checkNotNullParameter(arg2, "intent");
        super.startIntentSenderForResult(arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @Deprecated(message="This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.") public void startIntentSenderForResult(IntentSender arg2, int arg3, Intent arg4, int arg5, int arg6, int arg7, Bundle arg8) throws IntentSender$SendIntentException {
        Intrinsics.checkNotNullParameter(arg2, "intent");
        super.startIntentSenderForResult(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
}


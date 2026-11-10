package com.TryJeanPc.goldenmouse.service;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.ActivityManager$MemoryInfo;
import android.app.ActivityManager;
import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.provider.Settings$System;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View$OnGenericMotionListener;
import android.view.View$OnKeyListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.TryJeanPc.goldenmouse.CpuIndicatorView;
import com.TryJeanPc.goldenmouse.MainActivity;
import com.TryJeanPc.goldenmouse.PanelVisual;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.RamIndicatorView;
import com.TryJeanPc.goldenmouse.aim.CameraDiagnostics;
import com.TryJeanPc.goldenmouse.bridge.ShizukuBridge;
import com.TryJeanPc.goldenmouse.controls.BotonDisparoBlueStacks;
import com.TryJeanPc.goldenmouse.controls.BotonMacroScript;
import com.TryJeanPc.goldenmouse.controls.BotonTapBlueStacks;
import com.TryJeanPc.goldenmouse.controls.BotonVistaBlueStacks;
import com.TryJeanPc.goldenmouse.controls.ComponentPlacement;
import com.TryJeanPc.goldenmouse.controls.ControlConTecla;
import com.TryJeanPc.goldenmouse.controls.ControlEliminable;
import com.TryJeanPc.goldenmouse.controls.ControlVisual;
import com.TryJeanPc.goldenmouse.controls.ControlVisualFactory;
import com.TryJeanPc.goldenmouse.controls.ControlVisualState;
import com.TryJeanPc.goldenmouse.controls.ControlVisualStateSerializer;
import com.TryJeanPc.goldenmouse.controls.EditorControlGeometry;
import com.TryJeanPc.goldenmouse.controls.EditorHitDispatcher;
import com.TryJeanPc.goldenmouse.controls.FireComponentSettingsDialog;
import com.TryJeanPc.goldenmouse.controls.JoystickBlueStacks;
import com.TryJeanPc.goldenmouse.controls.JoystickComponentSettingsDialog$EditorPreview;
import com.TryJeanPc.goldenmouse.controls.JoystickComponentSettingsDialog;
import com.TryJeanPc.goldenmouse.controls.JoystickSettingsEdit;
import com.TryJeanPc.goldenmouse.controls.ProfileComponentControl;
import com.TryJeanPc.goldenmouse.controls.TapComponentSettingsDialog;
import com.TryJeanPc.goldenmouse.controls.TapSettingsEdit;
import com.TryJeanPc.goldenmouse.controls.TeclaEditorView;
import com.TryJeanPc.goldenmouse.controls.ViewComponentSettingsDialog;
import com.TryJeanPc.goldenmouse.controls.VistaActivationCapture;
import com.TryJeanPc.goldenmouse.controls.VistaLibreVisual;
import com.TryJeanPc.goldenmouse.cursor.CursorImagePickerActivity;
import com.TryJeanPc.goldenmouse.cursor.CursorMotionSettings;
import com.TryJeanPc.goldenmouse.cursor.CursorOverlayHost;
import com.TryJeanPc.goldenmouse.cursor.GoldenCursorRenderer;
import com.TryJeanPc.goldenmouse.cursor.MousePanelController;
import com.TryJeanPc.goldenmouse.cursor.MouseWheelSettings;
import com.TryJeanPc.goldenmouse.engine.GoldenCoreController;
import com.TryJeanPc.goldenmouse.injector.TouchInjector;
import com.TryJeanPc.goldenmouse.input.GameForegroundMonitor;
import com.TryJeanPc.goldenmouse.license.LicenseManager;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.macro.editor.MacroEditorController;
import com.TryJeanPc.goldenmouse.mapper.GameProfileCompiler;
import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import com.TryJeanPc.goldenmouse.profile.FireComponent;
import com.TryJeanPc.goldenmouse.profile.GameProfile;
import com.TryJeanPc.goldenmouse.profile.GameProfileLoadResult;
import com.TryJeanPc.goldenmouse.profile.GameProfileStorage$IdRepairPlan;
import com.TryJeanPc.goldenmouse.profile.GameProfileStorage;
import com.TryJeanPc.goldenmouse.profile.JoystickComponent;
import com.TryJeanPc.goldenmouse.profile.MacroScriptComponent;
import com.TryJeanPc.goldenmouse.profile.ProfileControl;
import com.TryJeanPc.goldenmouse.profile.ProfileIdentities;
import com.TryJeanPc.goldenmouse.profile.TapComponent;
import com.TryJeanPc.goldenmouse.profile.ViewComponent;
import com.TryJeanPc.goldenmouse.profile.VistaLibreMarker;
import com.TryJeanPc.goldenmouse.recoil.RecoilSettings;
import com.TryJeanPc.goldenmouse.recoil.RecoilSettingsForm;
import com.TryJeanPc.goldenmouse.recoil.RecoilSettingsStore;
import com.TryJeanPc.goldenmouse.stretch.physical.GoldenStretchGameLifecycle;
import com.TryJeanPc.goldenmouse.telemetry.TelemetryManager;
import com.TryJeanPc.goldenmouse.ui.BlueMagicVisualModeController;
import com.TryJeanPc.goldenmouse.ui.DecorativeAnimationPreferences;
import com.TryJeanPc.goldenmouse.ui.DecorativeEffect;
import com.TryJeanPc.goldenmouse.ui.GoldenStretchVisualController;
import com.TryJeanPc.goldenmouse.ui.MonitoringPanelFactory;
import com.TryJeanPc.goldenmouse.ui.MousePanelFactory;
import com.TryJeanPc.goldenmouse.ui.RecoilPanelFactory;
import com.TryJeanPc.goldenmouse.ui.SettingsPanelFactory;
import com.TryJeanPc.goldenmouse.ui.VisualVisibilityObserver;
import com.TryJeanPc.goldenmouse.ui.VisualWorkSession;
import com.TryJeanPc.goldenmouse.ui.WindowFocusPolicy;
import com.google.android.material.R$style;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;

@Metadata(d1={"\u0000\u0081\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b *\u0001V\b\u0007\u0018\u0000 ü\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0004ü\u0002ý\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010É\u0001\u001A\u00020\u000EH\u0002J\t\u0010Ê\u0001\u001A\u00020%H\u0002J\u0012\u0010Ë\u0001\u001A\u00020%2\u0007\u0010Ì\u0001\u001A\u00020\u000EH\u0002J\t\u0010Í\u0001\u001A\u00020%H\u0016J\t\u0010Î\u0001\u001A\u00020%H\u0002J\t\u0010Ï\u0001\u001A\u00020%H\u0002J\u001D\u0010Ò\u0001\u001A\u00020%2\u0007\u0010Ó\u0001\u001A\u00020\u000E2\t\b\u0002\u0010Ô\u0001\u001A\u00020\u000EH\u0002J\u0013\u0010Õ\u0001\u001A\u00020%2\b\u0010Ö\u0001\u001A\u00030×\u0001H\u0016J\t\u0010Ø\u0001\u001A\u00020%H\u0016J\t\u0010Ù\u0001\u001A\u00020%H\u0002J\u0018\u0010Ú\u0001\u001A\u0005\u0018\u00010Û\u00012\n\u0010Ü\u0001\u001A\u0005\u0018\u00010Ý\u0001H\u0016J\'\u0010Þ\u0001\u001A\u00020\u001D2\n\u0010Ü\u0001\u001A\u0005\u0018\u00010Ý\u00012\u0007\u0010ß\u0001\u001A\u00020\u001D2\u0007\u0010à\u0001\u001A\u00020\u001DH\u0016J\t\u0010á\u0001\u001A\u00020%H\u0002J\t\u0010â\u0001\u001A\u00020%H\u0002J\u0014\u0010ã\u0001\u001A\u00020\u000E2\t\b\u0002\u0010ä\u0001\u001A\u00020\u000EH\u0002J\u0014\u0010å\u0001\u001A\u0004\u0018\u00010z2\u0007\u0010æ\u0001\u001A\u00020zH\u0002J\t\u0010ç\u0001\u001A\u00020%H\u0002J\u001B\u0010è\u0001\u001A\u00020z2\u0007\u0010é\u0001\u001A\u00020\u001B2\u0007\u0010ê\u0001\u001A\u00020zH\u0002J\n\u0010ë\u0001\u001A\u00030ì\u0001H\u0002J\t\u0010í\u0001\u001A\u00020\u000EH\u0002J\f\u0010î\u0001\u001A\u0005\u0018\u00010·\u0001H\u0002J\u0017\u0010ï\u0001\u001A\u00020%2\f\b\u0002\u0010ð\u0001\u001A\u0005\u0018\u00010·\u0001H\u0002J\u0013\u0010ñ\u0001\u001A\u00020%2\b\u0010ð\u0001\u001A\u00030·\u0001H\u0002J\u0016\u0010ò\u0001\u001A\u000F\u0012\u0004\u0012\u00020\u001D\u0012\u0004\u0012\u00020\u001D0\u009C\u0001H\u0002J\u001C\u0010ó\u0001\u001A\u00020%2\u0007\u0010ô\u0001\u001A\u00020\u001B2\b\u0010õ\u0001\u001A\u00030ö\u0001H\u0002J\t\u0010÷\u0001\u001A\u00020%H\u0002J\t\u0010ø\u0001\u001A\u00020%H\u0002J\t\u0010ù\u0001\u001A\u00020\u000EH\u0002J\u0014\u0010ú\u0001\u001A\u00020%2\t\b\u0002\u0010û\u0001\u001A\u00020\u000EH\u0002J\t\u0010ü\u0001\u001A\u00020%H\u0002J\t\u0010ý\u0001\u001A\u00020%H\u0002J\u0014\u0010þ\u0001\u001A\u00020%2\t\b\u0002\u0010ÿ\u0001\u001A\u00020\u000EH\u0002J\u0014\u0010\u0080\u0002\u001A\u00020%2\t\b\u0002\u0010ÿ\u0001\u001A\u00020\u000EH\u0002J\u001C\u0010\u0083\u0002\u001A\u00020%2\u0011\b\u0002\u0010\u0084\u0002\u001A\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002J\t\u0010\u0085\u0002\u001A\u00020%H\u0002J\t\u0010\u0086\u0002\u001A\u00020%H\u0002J\u0012\u0010\u0087\u0002\u001A\u00020%2\u0007\u0010\u0088\u0002\u001A\u00020HH\u0002J\u0018\u0010\u0089\u0002\u001A\u00020%2\r\u0010\u008A\u0002\u001A\b\u0012\u0004\u0012\u00020%0$H\u0002J*\u0010\u008B\u0002\u001A\u00020%2\u0007\u0010ô\u0001\u001A\u00020\u001B2\u0007\u0010\u008C\u0002\u001A\u00020\u000E2\r\u0010\u008A\u0002\u001A\b\u0012\u0004\u0012\u00020%0$H\u0002J\t\u0010\u008D\u0002\u001A\u00020%H\u0002J\t\u0010\u008E\u0002\u001A\u00020%H\u0002J\t\u0010\u008F\u0002\u001A\u00020%H\u0002J\t\u0010\u0090\u0002\u001A\u00020%H\u0002J\u0012\u0010\u0091\u0002\u001A\u00020%2\u0007\u0010\u0092\u0002\u001A\u00020\u001DH\u0002J\u0012\u0010\u0093\u0002\u001A\u00020%2\u0007\u0010\u0092\u0002\u001A\u00020\u001DH\u0002J\t\u0010\u0094\u0002\u001A\u00020%H\u0002J\t\u0010\u0095\u0002\u001A\u00020%H\u0002J\t\u0010\u0096\u0002\u001A\u00020%H\u0002J\t\u0010\u0097\u0002\u001A\u00020%H\u0002J\t\u0010\u0098\u0002\u001A\u00020%H\u0002J\t\u0010\u0099\u0002\u001A\u00020%H\u0002J$\u0010\u009A\u0002\u001A\u00020%2\u0007\u0010\u009B\u0002\u001A\u00020\u001B2\u0007\u0010\u009C\u0002\u001A\u00020\t2\u0007\u0010\u009D\u0002\u001A\u000206H\u0002J\u0012\u0010\u009E\u0002\u001A\u00020%2\u0007\u0010\u009D\u0002\u001A\u000206H\u0002J\t\u0010\u009F\u0002\u001A\u00020%H\u0002J\u001D\u0010 \u0002\u001A\u00020%2\f\b\u0002\u0010õ\u0001\u001A\u0005\u0018\u00010ö\u0001H\u0003¢\u0006\u0003\u0010¡\u0002J\u0012\u0010¢\u0002\u001A\u00020%2\u0007\u0010£\u0002\u001A\u00020\u000EH\u0002J\u0013\u0010¤\u0002\u001A\u00020\u000E2\b\u0010õ\u0001\u001A\u00030ö\u0001H\u0002J\t\u0010¥\u0002\u001A\u00020%H\u0002J+\u0010¦\u0002\u001A\u00020%2\u0007\u0010é\u0001\u001A\u00020\u001B2\b\u0010õ\u0001\u001A\u00030ö\u00012\r\u0010§\u0002\u001A\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0013\u0010¨\u0002\u001A\u00020%2\b\u0010õ\u0001\u001A\u00030ö\u0001H\u0002J%\u0010©\u0002\u001A\u00020%2\u0007\u0010é\u0001\u001A\u00020\u001B2\b\u0010õ\u0001\u001A\u00030ö\u00012\u0007\u0010ª\u0002\u001A\u00020\u000EH\u0002JA\u0010«\u0002\u001A\u00020%2\b\u0010õ\u0001\u001A\u00030ö\u00012\u0014\u0010¬\u0002\u001A\u000F\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L0\u009C\u00012\u0016\u0010­\u0002\u001A\u0011\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L\u0018\u00010\u009C\u0001H\u0002JC\u0010®\u0002\u001A\u00020%2\b\u0010õ\u0001\u001A\u00030ö\u00012\n\u0010¯\u0002\u001A\u0005\u0018\u00010°\u00022\n\u0010±\u0002\u001A\u0005\u0018\u00010°\u00022\n\u0010²\u0002\u001A\u0005\u0018\u00010³\u00022\n\u0010´\u0002\u001A\u0005\u0018\u00010µ\u0002H\u0002J\t\u0010¶\u0002\u001A\u00020%H\u0002J\u0016\u0010·\u0002\u001A\u000F\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L0\u009C\u0001H\u0002J\u0018\u0010¸\u0002\u001A\u0011\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L\u0018\u00010\u009C\u0001H\u0002J^\u0010¹\u0002\u001A\u0004\u0018\u00010\u001B2\u0007\u0010\u0088\u0002\u001A\u00020H2\u0007\u0010æ\u0001\u001A\u00020z2\u000B\b\u0002\u0010º\u0002\u001A\u0004\u0018\u00010L2\u000B\b\u0002\u0010»\u0002\u001A\u0004\u0018\u00010L2\t\b\u0002\u0010¼\u0002\u001A\u00020z2\t\b\u0002\u0010½\u0002\u001A\u00020\u001D2\t\b\u0002\u0010¾\u0002\u001A\u00020\u001DH\u0002¢\u0006\u0003\u0010¿\u0002J\u001C\u0010À\u0002\u001A\u00020%2\u0007\u0010é\u0001\u001A\u00020\u001B2\b\u0010Á\u0002\u001A\u00030Â\u0002H\u0002J%\u0010Ã\u0002\u001A\u00020%2\u0007\u0010Ä\u0002\u001A\u00020\u000E2\u0007\u0010é\u0001\u001A\u00020\u001B2\b\u0010Á\u0002\u001A\u00030Â\u0002H\u0002J4\u0010Å\u0002\u001A\u00020%2\u0007\u0010\u009B\u0002\u001A\u00020\u001B2\r\u0010Æ\u0002\u001A\b\u0012\u0004\u0012\u00020%0$2\u0007\u0010é\u0001\u001A\u00020\u001B2\b\u0010Á\u0002\u001A\u00030Â\u0002H\u0002J\u001C\u0010Ç\u0002\u001A\u00020%2\u0007\u0010\u009B\u0002\u001A\u00020\u001B2\b\u0010È\u0002\u001A\u00030É\u0002H\u0002J4\u0010Ê\u0002\u001A\u00020%2\u0007\u0010Ë\u0002\u001A\u00020\u001D2 \u0010Ì\u0002\u001A\u001B\u0012\u0004\u0012\u00020\u001B\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020%0Í\u0002H\u0002J\t\u0010Î\u0002\u001A\u00020%H\u0002J\u001C\u0010Ï\u0002\u001A\u00020%2\u0007\u0010é\u0001\u001A\u00020\u001B2\b\u0010Á\u0002\u001A\u00030Â\u0002H\u0002J\'\u0010Ð\u0002\u001A\u00030·\u00012\b\u0010ð\u0001\u001A\u00030·\u00012\u0007\u0010Ñ\u0002\u001A\u00020z2\b\u0010Ò\u0002\u001A\u00030Ó\u0002H\u0002J&\u0010Ô\u0002\u001A\u00030·\u00012\b\u0010ð\u0001\u001A\u00030·\u00012\u0007\u0010Ñ\u0002\u001A\u00020z2\u0007\u0010é\u0001\u001A\u00020\u001BH\u0002J\'\u0010Õ\u0002\u001A\u00020\u000E2\b\u0010Ö\u0002\u001A\u00030×\u00022\b\u0010Ø\u0002\u001A\u00030Ù\u00022\b\u0010Ú\u0002\u001A\u00030Û\u0002H\u0002J\u001D\u0010Ü\u0002\u001A\u00020\u000E2\b\u0010Ö\u0002\u001A\u00030×\u00022\b\u0010Ý\u0002\u001A\u00030Þ\u0002H\u0002J\u001B\u0010ß\u0002\u001A\u00020\u000E2\u0007\u0010Ö\u0002\u001A\u00020\\2\u0007\u0010à\u0002\u001A\u00020zH\u0002J\u001B\u0010á\u0002\u001A\u00020%2\u0007\u0010Ö\u0002\u001A\u00020\\2\u0007\u0010â\u0002\u001A\u00020zH\u0002J\u0012\u0010ã\u0002\u001A\u00020\u000E2\u0007\u0010é\u0001\u001A\u00020\u001BH\u0002J\u001D\u0010ä\u0002\u001A\u00020\u000E2\u0007\u0010Ö\u0002\u001A\u00020\\2\t\u0010å\u0002\u001A\u0004\u0018\u00010xH\u0002J\u0012\u0010æ\u0002\u001A\u00020%2\u0007\u0010à\u0002\u001A\u00020zH\u0002J\u0012\u0010ç\u0002\u001A\u00020%2\u0007\u0010Ö\u0002\u001A\u00020\\H\u0002J\u0014\u0010è\u0002\u001A\u00020%2\t\b\u0002\u0010é\u0002\u001A\u00020\u000EH\u0002J%\u0010ê\u0002\u001A\u00020%2\u0007\u0010\u0088\u0002\u001A\u00020H2\u0007\u0010ë\u0002\u001A\u00020\u001B2\b\u0010ì\u0002\u001A\u00030\u0081\u0001H\u0002J\u001B\u0010í\u0002\u001A\u00020%2\u0007\u0010\u0088\u0002\u001A\u00020H2\u0007\u0010ë\u0002\u001A\u00020\u001BH\u0002J\t\u0010î\u0002\u001A\u00020%H\u0002J\u0013\u0010ï\u0002\u001A\u00020%2\b\u0010ð\u0002\u001A\u00030\u0085\u0001H\u0002J\t\u0010ñ\u0002\u001A\u00020%H\u0002J\u0010\u0010ò\u0002\u001A\u00020%2\u0007\u0010ó\u0002\u001A\u00020LJ\u0007\u0010ô\u0002\u001A\u00020LJ\u001B\u0010õ\u0002\u001A\u00020L2\u0007\u0010\u009D\u0002\u001A\u0002062\u0007\u0010æ\u0001\u001A\u00020zH\u0002J\u001C\u0010ö\u0002\u001A\u00020%2\b\u0010÷\u0002\u001A\u00030\u0085\u00012\u0007\u0010ø\u0002\u001A\u00020\u001BH\u0002J\t\u0010ù\u0002\u001A\u00020%H\u0002J\t\u0010ú\u0002\u001A\u00020%H\u0002J\t\u0010û\u0002\u001A\u00020%H\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\u000F\u001A\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0011\u0010\u0012R\u001B\u0010\u0015\u001A\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001A\u0004\b\u0017\u0010\u0018R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001BX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010!\u001A\u0004\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010#\u001A\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u001BX\u0082.¢\u0006\u0002\n\u0000R\u001B\u0010\'\u001A\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0014\u001A\u0004\b)\u0010*R\u000E\u0010,\u001A\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010.\u001A\u0004\u0018\u00010/X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00100\u001A\u0004\u0018\u000101X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00102\u001A\u0004\u0018\u000101X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00103\u001A\u0004\u0018\u000104X\u0082\u000E¢\u0006\u0002\n\u0000R#\u00105\u001A\n 7*\u0004\u0018\u000106068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0014\u001A\u0004\b8\u00109R\u001B\u0010;\u001A\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0014\u001A\u0004\b=\u0010>R\u000E\u0010@\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010A\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010B\u001A\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010C\u001A\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010E\u001A\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010G\u001A\u0004\u0018\u00010HX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010I\u001A\u0004\u0018\u00010JX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010K\u001A\u00020LX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010M\u001A\u0004\u0018\u00010NX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010O\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010Q\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020\u000E@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\bR\u0010SR\u0010\u0010T\u001A\u0004\u0018\u00010-X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010U\u001A\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0010\u0010X\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001A\u0004\u0018\u00010ZX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010[\u001A\u0004\u0018\u00010\\X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010]\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010^\u001A\u0004\u0018\u00010_X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010`\u001A\u0004\u0018\u00010aX\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010b\u001A\u0004\u0018\u00010_2\b\u0010P\u001A\u0004\u0018\u00010_@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\bc\u0010dR\"\u0010f\u001A\u0004\u0018\u00010e2\b\u0010P\u001A\u0004\u0018\u00010e@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\bg\u0010hR\u001B\u0010i\u001A\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u0014\u001A\u0004\bk\u0010lR\u0010\u0010n\u001A\u0004\u0018\u00010oX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010p\u001A\u0004\u0018\u00010qX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010r\u001A\u0004\u0018\u00010sX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010t\u001A\u0004\u0018\u00010uX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010v\u001A\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010w\u001A\u0004\u0018\u00010xX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010y\u001A\u0004\u0018\u00010zX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010{\u001A\u00020|8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007F\u0010\u0014\u001A\u0004\b}\u0010~R\u0012\u0010\u0080\u0001\u001A\u0005\u0018\u00010\u0081\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0083\u0001\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001A\u0005\u0018\u00010\u0085\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u0086\u0001\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020\u000E@BX\u0082\u000E¢\u0006\t\n\u0000\"\u0005\b\u0087\u0001\u0010SR \u0010\u0088\u0001\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020\u000E@BX\u0082\u000E¢\u0006\t\n\u0000\"\u0005\b\u0089\u0001\u0010SR \u0010\u008A\u0001\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020\u000E@BX\u0082\u000E¢\u0006\t\n\u0000\"\u0005\b\u008B\u0001\u0010SR\u0010\u0010\u008C\u0001\u001A\u00030\u008D\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u008E\u0001\u001A\u0004\u0018\u00010\u001B2\b\u0010P\u001A\u0004\u0018\u00010\u001B@BX\u0082\u000E¢\u0006\n\n\u0000\"\u0006\b\u008F\u0001\u0010\u0090\u0001R \u0010\u0091\u0001\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020\u000E@BX\u0082\u000E¢\u0006\t\n\u0000\"\u0005\b\u0092\u0001\u0010SR%\u0010\u0093\u0001\u001A\u0004\u0018\u00010\u001B2\b\u0010P\u001A\u0004\u0018\u00010\u001B@BX\u0082\u000E¢\u0006\n\n\u0000\"\u0006\b\u0094\u0001\u0010\u0090\u0001R \u0010\u0095\u0001\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020\u000E@BX\u0082\u000E¢\u0006\t\n\u0000\"\u0005\b\u0096\u0001\u0010SR\u0011\u0010\u0097\u0001\u001A\u0004\u0018\u00010NX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0098\u0001\u001A\u00030\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u009A\u0001\u001A\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001B\u0012\u0005\u0012\u00030\u009D\u00010\u009C\u00010\u009B\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u009E\u0001\u001A\u0011\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L\u0018\u00010\u009C\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u009F\u0001\u001A\u0011\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L\u0018\u00010\u009C\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010 \u0001\u001A\u00030¡\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000F\u0010¢\u0001\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R \u0010£\u0001\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020\u000E@BX\u0082\u000E¢\u0006\t\n\u0000\"\u0005\b¤\u0001\u0010SR\u000F\u0010¥\u0001\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010¦\u0001\u001A\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010¨\u0001\u001A\u00030©\u00018BX\u0082\u0084\u0002¢\u0006\u000F\n\u0005\b¬\u0001\u0010\u0014\u001A\u0006\bª\u0001\u0010«\u0001R \u0010­\u0001\u001A\u00030®\u00018BX\u0082\u0084\u0002¢\u0006\u000F\n\u0005\b±\u0001\u0010\u0014\u001A\u0006\b¯\u0001\u0010°\u0001R\u001C\u0010²\u0001\u001A\u000F\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001D0³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010´\u0001\u001A\u000F\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001D0³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010µ\u0001\u001A\u0004\u0018\u00010zX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010¶\u0001\u001A\u0005\u0018\u00010·\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010¸\u0001\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010¹\u0001\u001A\u0005\u0018\u00010º\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010»\u0001\u001A\n\u0012\u0005\u0012\u00030½\u00010¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010¾\u0001\u001A\u00030½\u00018BX\u0082\u0084\u0002¢\u0006\u0010\u001A\u0006\bÁ\u0001\u0010Â\u0001*\u0006\b¿\u0001\u0010À\u0001R\u0011\u0010Ã\u0001\u001A\u0004\u0018\u00010zX\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010Ä\u0001\u001A\u00020LX\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010Å\u0001\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010Æ\u0001\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0005\n\u0003\u0010Ç\u0001R\u0010\u0010È\u0001\u001A\u00030\u009D\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ð\u0001\u001A\u00030Ñ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u0081\u0002\u001A\u0004\u0018\u00010\u001B2\b\u0010P\u001A\u0004\u0018\u00010\u001B@BX\u0082\u000E¢\u0006\n\n\u0000\"\u0006\b\u0082\u0002\u0010\u0090\u0001¨\u0006þ\u0002"}, d2={"Lcom/TryJeanPc/goldenmouse/service/FloatingService;", "Landroid/app/Service;", "Lcom/TryJeanPc/goldenmouse/cursor/CursorOverlayHost;", "Lcom/TryJeanPc/goldenmouse/service/SessionOverlayHost;", "<init>", "()V", "windowManager", "Lcom/TryJeanPc/goldenmouse/service/SessionOverlayWindows;", "screenMetricsContext", "Landroid/content/Context;", "sessionOverlayWindows", "getSessionOverlayWindows", "()Lcom/TryJeanPc/goldenmouse/service/SessionOverlayWindows;", "gameObservedForeground", "", "stretchGameLifecycle", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle;", "getStretchGameLifecycle", "()Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle;", "stretchGameLifecycle$delegate", "Lkotlin/Lazy;", "foregroundMonitor", "Lcom/TryJeanPc/goldenmouse/input/GameForegroundMonitor;", "getForegroundMonitor", "()Lcom/TryJeanPc/goldenmouse/input/GameForegroundMonitor;", "foregroundMonitor$delegate", "floatingIconView", "Landroid/view/View;", "floatingIconBaseSizePx", "", "hudView", "blueMagicVisualMode", "Lcom/TryJeanPc/goldenmouse/ui/BlueMagicVisualModeController;", "hudVisibilityObserver", "Lcom/TryJeanPc/goldenmouse/ui/VisualVisibilityObserver;", "refrescarSlidersHud", "Lkotlin/Function0;", "", "mapeoView", "editorGeometry", "Lcom/TryJeanPc/goldenmouse/controls/EditorControlGeometry;", "getEditorGeometry", "()Lcom/TryJeanPc/goldenmouse/controls/EditorControlGeometry;", "editorGeometry$delegate", "iconParams", "Landroid/view/WindowManager$LayoutParams;", "iconSnapAnimator", "Landroid/animation/ValueAnimator;", "cpuRingAnimator", "Landroid/animation/ObjectAnimator;", "ramRingAnimator", "tachometerAnimator", "Landroid/animation/Animator;", "decorativePreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getDecorativePreferences", "()Landroid/content/SharedPreferences;", "decorativePreferences$delegate", "decorativeOptions", "Lcom/TryJeanPc/goldenmouse/ui/DecorativeAnimationPreferences;", "getDecorativeOptions", "()Lcom/TryJeanPc/goldenmouse/ui/DecorativeAnimationPreferences;", "decorativeOptions$delegate", "cpuOpeningEnabled", "ramOpeningEnabled", "updateHudAnimationOptions", "decorativePreferenceListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "hudParams", "mapeoParams", "cursorOverlayView", "Landroid/widget/FrameLayout;", "cursorView", "Landroid/widget/ImageView;", "cursorOpacity", "", "cursorImageJob", "Lkotlinx/coroutines/Job;", "hasCustomCursorImage", "value", "isCursorPickerOpen", "setCursorPickerOpen", "(Z)V", "cursorPickerPanelParams", "cursorImageReceiver", "com/TryJeanPc/goldenmouse/service/FloatingService$cursorImageReceiver$1", "Lcom/TryJeanPc/goldenmouse/service/FloatingService$cursorImageReceiver$1;", "controlesJuegoView", "cursorRenderer", "Lcom/TryJeanPc/goldenmouse/cursor/GoldenCursorRenderer;", "botonEnEdicion", "Lcom/TryJeanPc/goldenmouse/controls/ControlConTecla;", "subMenuVista", "macroScriptDialog", "Landroid/app/Dialog;", "cameraDiagnosticsDialog", "Landroid/app/AlertDialog;", "retrocesoDialog", "setRetrocesoDialog", "(Landroid/app/Dialog;)V", "Lcom/TryJeanPc/goldenmouse/ui/GoldenStretchVisualController;", "goldenStretchVisual", "setGoldenStretchVisual", "(Lcom/TryJeanPc/goldenmouse/ui/GoldenStretchVisualController;)V", "recoilSettingsStore", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettingsStore;", "getRecoilSettingsStore", "()Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettingsStore;", "recoilSettingsStore$delegate", "recoilSettings", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "macroEditorController", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorController;", "teclaEditorView", "Lcom/TryJeanPc/goldenmouse/controls/TeclaEditorView;", "capturaTeclaVista", "Lcom/TryJeanPc/goldenmouse/controls/VistaActivationCapture;", "cancelarCapturaTeclaVista", "sesionCapturaEditor", "", "paqueteCapturaEditor", "", "dobleClicEditor", "Lcom/TryJeanPc/goldenmouse/service/EditorDoubleClick;", "getDobleClicEditor", "()Lcom/TryJeanPc/goldenmouse/service/EditorDoubleClick;", "dobleClicEditor$delegate", "controlEliminableSeleccionado", "Lcom/TryJeanPc/goldenmouse/controls/ControlEliminable;", "vistaControlEliminableSeleccionado", "vistaEliminarSeleccionada", "controlSeleccionado", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisual;", "isHudVisible", "setHudVisible", "isFpsSettingsVisible", "setFpsSettingsVisible", "isPanelTransitioning", "setPanelTransitioning", "hubTransitions", "Lcom/TryJeanPc/goldenmouse/service/HubWindowTransition;", "settingsPanelView", "setSettingsPanelView", "(Landroid/view/View;)V", "isSettingsTransitioning", "setSettingsTransitioning", "mousePanelView", "setMousePanelView", "isMousePanelTransitioning", "setMousePanelTransitioning", "monitoreoJob", "hudVisualSession", "Lcom/TryJeanPc/goldenmouse/ui/VisualWorkSession;", "hudRingStarts", "", "Lkotlin/Pair;", "Ljava/lang/Runnable;", "lastRamData", "lastCpuData", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "isActive", "isMapeoVisible", "setMapeoVisible", "isMenuMapeoMinimizado", "goldenCoreController", "Lcom/TryJeanPc/goldenmouse/engine/GoldenCoreController;", "mousePanelController", "Lcom/TryJeanPc/goldenmouse/cursor/MousePanelController;", "getMousePanelController", "()Lcom/TryJeanPc/goldenmouse/cursor/MousePanelController;", "mousePanelController$delegate", "profileStorage", "Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage;", "getProfileStorage", "()Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage;", "profileStorage$delegate", "controlSourceIndices", "Ljava/util/WeakHashMap;", "visualSourceIndices", "editorIdentitySource", "editorIdentityBaseline", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "loadingIdentityProfile", "identityRepairDialog", "Lcom/TryJeanPc/goldenmouse/service/ProfileIdentityRepairDialog;", "telemetryManagerDelegate", "Lkotlin/Lazy;", "Lcom/TryJeanPc/goldenmouse/telemetry/TelemetryManager;", "telemetryManager", "getTelemetryManager$delegate", "(Lcom/TryJeanPc/goldenmouse/service/FloatingService;)Ljava/lang/Object;", "getTelemetryManager", "()Lcom/TryJeanPc/goldenmouse/telemetry/TelemetryManager;", "targetPackage", "globalOverlayAlpha", "lastAimActiveState", "uiInteractionActive", "Ljava/lang/Boolean;", "liberarInteraccionUi", "hayInteraccionUi", "actualizarAutorizacionUi", "aplicarInteraccionUi", "enabled", "onCreate", "iniciarModoForeground", "prepararCursor", "mainHandler", "Landroid/os/Handler;", "actualizarVisibilidadCursor", "isAimActive", "recenter", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "bringCursorToFront", "mantenerCursorAlFrente", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "flags", "startId", "mostrarDiagnosticoCamara", "verificarEstadoBackends", "guardarConfiguracion", "saveProfile", "convertirTipoLegacy", "tipo", "cargarConfiguracion", "identidadControl", "view", "type", "prepararReparacionIds", "Lcom/TryJeanPc/goldenmouse/profile/GameProfileStorage$IdRepairPlan;", "solicitarReparacionIds", "construirPerfilActual", "aplicarPerfilActualAlMotor", "profile", "cargarPerfilEnEditor", "obtenerTamanoRealPantalla", "vigilarCancelacionPanel", "panel", "token", "", "recuperarAccesoHub", "volverAlHubTrasPanel", "mostrarHudXML", "ocultarHudXML", "volverAlJuego", "mostrarMapeo", "ocultarMapeo", "minimizarMenuMapeo", "animar", "maximizarMenuMapeo", "fpsSettingsView", "setFpsSettingsView", "cerrarPanelFpsConAnimacion", "onCompletado", "mostrarPanelFps", "inflarPanelFps", "mostrarMenuTipos", "lienzo", "ocultarHudParaPanel", "alTerminar", "animarPanelLateral", "mostrar", "mostrarGoldenStretch", "mostrarRetrocesoVisual", "mostrarPanelAjustes", "cerrarPanelAjustes", "aplicarTamanoPuntero", "porcentaje", "aplicarTransparenciaPuntero", "cargarImagenPuntero", "actualizarNombreImagenPuntero", "abrirSelectorImagenPuntero", "restaurarPanelMouseTrasSelector", "mostrarPanelMouse", "cerrarPanelMouse", "enlazarControlesAjustes", "root", "themedContext", "prefs", "aplicarAjustesLogo", "aplicarAnimacionesDecorativas", "detenerMonitoreo", "(Ljava/lang/Long;)V", "suspenderVentanas", "suspended", "monitoreoActual", "iniciarMonitoreo", "postHudRingStart", "action", "actualizarGirosDecorativos", "iniciarGiroDecorativo", "cpu", "animarMonitoreo", "initialRamData", "initialCpuData", "iniciarLoopMonitoreo", "txtCpu", "Landroid/widget/TextView;", "txtRam", "cpuLuz", "Lcom/TryJeanPc/goldenmouse/CpuIndicatorView;", "ramLuz", "Lcom/TryJeanPc/goldenmouse/RamIndicatorView;", "configurarSliders", "leerRamUsada", "leerFrecuenciaCpu", "crearControlArrastrable", "posX", "posY", "teclaGuardada", "widthGuardado", "heightGuardado", "(Landroid/widget/FrameLayout;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;II)Landroid/view/View;", "abrirConfiguracionMacroScript", "configurable", "Lcom/TryJeanPc/goldenmouse/controls/ProfileComponentControl;", "abrirVentanaConfiguracionMacroScript", "esScript", "conectarEditorVisualMacro", "cerrar", "conectarModosVisualesMacroScript", "ids", "", "mostrarVentanaMacroScript", "layout", "conectar", "Lkotlin/Function2;", "cerrarVentanaMacroScript", "conectarConfiguracionAvanzada", "perfilConGeometria", "id", "state", "Lcom/TryJeanPc/goldenmouse/controls/ControlVisualState;", "limitarPosicionEnPerfil", "guardarAjustesVista", "control", "Lcom/TryJeanPc/goldenmouse/controls/BotonVistaBlueStacks;", "position", "Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "settings", "Lcom/TryJeanPc/goldenmouse/profile/ViewComponent;", "guardarBindingVista", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "esEntradaRechazadaParaTocar", "tecla", "actualizarBindingDelEditor", "teclaRecibida", "usaDobleClicEditor", "capturaEditorVigente", "sesion", "registrarEntradaDelEditor", "abrirEditorTecla", "cerrarEditorTecla", "restaurarFocoVentana", "mostrarVistaEliminar", "vistaControl", "controlEliminable", "posicionarVistaEliminar", "ocultarVistaEliminar", "seleccionarControl", "nuevoControl", "deseleccionarControl", "aplicarOpacidadGlobal", "alpha", "obtenerOpacidadGlobal", "resolverEscalaControl", "aplicarEstiloAControl", "controlVisual", "controlView", "actualizarControlesEnJuego", "aplicarAjustesVisualesBotones", "onDestroy", "Companion", "ControlesVisualesView", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FloatingService extends Service implements CursorOverlayHost, SessionOverlayHost {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/service/FloatingService$Companion;", "", "<init>", "()V", "EXTRA_TARGET_PACKAGE", "", "EXTRA_START_RECEIVER", "EXTRA_START_ERROR", "START_OBSERVATION_READY", "", "START_OBSERVATION_FAILED", "COORD_TAG", "UI_TAG", "CONFIG_TAG", "CONFIG_PREFERENCES", "CONFIG_KEY_LEGACY", "CONFIG_KEY_V2", "DEFAULT_PACKAGE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0014¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/service/FloatingService$ControlesVisualesView;", "Landroid/view/View;", "<init>", "(Lcom/TryJeanPc/goldenmouse/service/FloatingService;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class ControlesVisualesView extends View {
        public ControlesVisualesView(FloatingService arg1) {
            FloatingService.this = arg1;
            super(((Context)arg1));
            this.setClickable(false);
            this.setLongClickable(false);
            this.setFocusable(false);
            this.setImportantForAccessibility(2);
            this.setVisibility(8);
        }

        protected void onDraw(Canvas arg13) {
            Canvas v6;
            Intrinsics.checkNotNullParameter(arg13, "canvas");
            super.onDraw(arg13);
            View v12 = FloatingService.this.mapeoView;
            View v0 = null;
            if(v12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
                v12 = v0;
            }

            v12 = v12.findViewById(id.lienzoMapeo);
            if(v12 == null) {
            }
            else {
                int v1 = ((FrameLayout)v12).getChildCount();
                int v2 = 0;
                while(v2 < v1) {
                    View v3 = ((FrameLayout)v12).getChildAt(v2);
                    View v4 = (v3 instanceof ControlVisual) ? v3 : v0;
                    if(v4 != null) {
                        String v4_1 = ControlVisualFactory.INSTANCE.normalizarTipo(((ControlVisual)v4).obtenerTipo());
                        switch(v4_1.hashCode()) {
                            case -1905230500: {
                                goto label_52;
                            }
                            case -854989634: {
                                goto label_48;
                            }
                            case -225966439: {
                                goto label_44;
                            }
                            case -155485892: {
                                goto label_40;
                            }
                            case 82819: {
                                goto label_36;
                            }
                            case 1980540961: {
                                goto label_32;
                            }
                        }

                        goto label_24;
                    label_36:
                        if(!v4_1.equals("TAP")) {
                            goto label_24;
                        label_52:
                            if(!v4_1.equals("DISPARO")) {
                                goto label_24;
                            label_40:
                                if(!v4_1.equals("JOYSTICK")) {
                                    goto label_24;
                                label_44:
                                    if(!v4_1.equals("VISTA_LIBRE_VISUAL")) {
                                        goto label_24;
                                    label_48:
                                        if(!v4_1.equals("MACRO_SCRIPT")) {
                                            goto label_24;
                                        label_32:
                                            if(v4_1.equals("CAMARA")) {
                                                goto label_56;
                                            }
                                            else {
                                                goto label_24;
                                            }
                                        }
                                        else {
                                            goto label_56;
                                        }
                                    }
                                    else {
                                        goto label_56;
                                    }
                                }
                                else {
                                    goto label_56;
                                }
                            }
                            else {
                                goto label_56;
                            }
                        }
                        else {
                        label_56:
                            if(v3.getVisibility() != 0) {
                                goto label_24;
                            }
                            else if(v3.getAlpha() <= 0f) {
                                goto label_24;
                            }
                            else {
                                int v4_2 = arg13.save();
                                arg13.translate(((FrameLayout)v12).getX() + v3.getX(), ((FrameLayout)v12).getY() + v3.getY());
                                if(!(v3 instanceof BotonVistaBlueStacks)) {
                                    v6 = arg13;
                                    v6.saveLayerAlpha(-(((float)v3.getWidth())), -(((float)v3.getHeight())), (((float)v3.getWidth())) * 2f, (((float)v3.getHeight())) * 2f, ((int)(v3.getAlpha() * 255f)));
                                }
                                else {
                                    v6 = arg13;
                                }

                                if((v3 instanceof VistaLibreVisual)) {
                                    ((VistaLibreVisual)v3).dibujarMarcador(v6);
                                }
                                else {
                                    v3.draw(v6);
                                }

                                v6.restoreToCount(v4_2);
                            }
                        }
                    }
                    else {
                    label_24:
                        v6 = arg13;
                    }

                    ++v2;
                    arg13 = v6;
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final String CONFIG_KEY_LEGACY = "mapeo_guardado";
    public static final String CONFIG_KEY_V2 = "mapeo_guardado_v2";
    public static final String CONFIG_PREFERENCES = "GoldenMouseConfig";
    public static final String CONFIG_TAG = "GOLDEN_CONFIG";
    public static final String COORD_TAG = "GOLDEN_COORD";
    public static final Companion Companion = null;
    public static final String DEFAULT_PACKAGE = "com.TryJeanPc.default";
    public static final String EXTRA_START_ERROR = "start_error";
    public static final String EXTRA_START_RECEIVER = "start_receiver";
    public static final String EXTRA_TARGET_PACKAGE = "target_package";
    public static final int START_OBSERVATION_FAILED = 2;
    public static final int START_OBSERVATION_READY = 1;
    public static final String UI_TAG = "GOLDEN_UI";
    private BlueMagicVisualModeController blueMagicVisualMode;
    private ControlConTecla botonEnEdicion;
    private AlertDialog cameraDiagnosticsDialog;
    private Function0 cancelarCapturaTeclaVista;
    private VistaActivationCapture capturaTeclaVista;
    private ControlEliminable controlEliminableSeleccionado;
    private ControlVisual controlSeleccionado;
    private final WeakHashMap controlSourceIndices;
    private View controlesJuegoView;
    private boolean cpuOpeningEnabled;
    private ObjectAnimator cpuRingAnimator;
    private Job cursorImageJob;
    private final FloatingService$cursorImageReceiver$1 cursorImageReceiver;
    private float cursorOpacity;
    private FrameLayout cursorOverlayView;
    private WindowManager$LayoutParams cursorPickerPanelParams;
    private GoldenCursorRenderer cursorRenderer;
    private ImageView cursorView;
    private final Lazy decorativeOptions$delegate;
    private final SharedPreferences$OnSharedPreferenceChangeListener decorativePreferenceListener;
    private final Lazy decorativePreferences$delegate;
    private final Lazy dobleClicEditor$delegate;
    private final Lazy editorGeometry$delegate;
    private GameProfile editorIdentityBaseline;
    private String editorIdentitySource;
    private int floatingIconBaseSizePx;
    private View floatingIconView;
    private final Lazy foregroundMonitor$delegate;
    private View fpsSettingsView;
    private boolean gameObservedForeground;
    private float globalOverlayAlpha;
    private final GoldenCoreController goldenCoreController;
    private GoldenStretchVisualController goldenStretchVisual;
    private boolean hasCustomCursorImage;
    private final HubWindowTransition hubTransitions;
    private WindowManager$LayoutParams hudParams;
    private final List hudRingStarts;
    private View hudView;
    private VisualVisibilityObserver hudVisibilityObserver;
    private final VisualWorkSession hudVisualSession;
    private WindowManager$LayoutParams iconParams;
    private ValueAnimator iconSnapAnimator;
    private ProfileIdentityRepairDialog identityRepairDialog;
    private volatile boolean isActive;
    private boolean isCursorPickerOpen;
    private boolean isFpsSettingsVisible;
    private boolean isHudVisible;
    private boolean isMapeoVisible;
    private boolean isMenuMapeoMinimizado;
    private boolean isMousePanelTransitioning;
    private boolean isPanelTransitioning;
    private boolean isSettingsTransitioning;
    private boolean lastAimActiveState;
    private Pair lastCpuData;
    private Pair lastRamData;
    private final Runnable liberarInteraccionUi;
    private boolean loadingIdentityProfile;
    private MacroEditorController macroEditorController;
    private Dialog macroScriptDialog;
    private final Handler mainHandler;
    private WindowManager$LayoutParams mapeoParams;
    private View mapeoView;
    private Job monitoreoJob;
    private final Lazy mousePanelController$delegate;
    private View mousePanelView;
    private String paqueteCapturaEditor;
    private final Lazy profileStorage$delegate;
    private boolean ramOpeningEnabled;
    private ObjectAnimator ramRingAnimator;
    private RecoilSettings recoilSettings;
    private final Lazy recoilSettingsStore$delegate;
    private Function0 refrescarSlidersHud;
    private Dialog retrocesoDialog;
    private Context screenMetricsContext;
    private final CoroutineScope serviceScope;
    private Object sesionCapturaEditor;
    private View settingsPanelView;
    private final Lazy stretchGameLifecycle$delegate;
    private View subMenuVista;
    private Animator tachometerAnimator;
    private String targetPackage;
    private TeclaEditorView teclaEditorView;
    private final Lazy telemetryManagerDelegate;
    private Boolean uiInteractionActive;
    private Function0 updateHudAnimationOptions;
    private View vistaControlEliminableSeleccionado;
    private View vistaEliminarSeleccionada;
    private final WeakHashMap visualSourceIndices;
    private SessionOverlayWindows windowManager;

    static {
        FloatingService.Companion = new Companion(null);
        FloatingService.$stable = 8;
    }

    public FloatingService() {
        super();
        this.stretchGameLifecycle$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda141(this));
        this.foregroundMonitor$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda144(this));
        this.editorGeometry$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda145(this));
        this.decorativePreferences$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda146(this));
        this.decorativeOptions$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda147(this));
        this.cpuOpeningEnabled = true;
        this.ramOpeningEnabled = true;
        this.decorativePreferenceListener = new FloatingService$$ExternalSyntheticLambda148(this);
        this.cursorOpacity = 1f;
        this.cursorImageReceiver = new FloatingService$cursorImageReceiver$1(this);
        this.recoilSettingsStore$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda150(this));
        this.dobleClicEditor$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda151(this));
        this.hubTransitions = new HubWindowTransition();
        this.hudVisualSession = new VisualWorkSession();
        this.hudRingStarts = new ArrayList();
        this.serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(JobKt.Job$default(null, 1, null)));
        this.isActive = true;
        this.goldenCoreController = new GoldenCoreController();
        this.mousePanelController$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda152(this));
        this.profileStorage$delegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda153(this));
        this.controlSourceIndices = new WeakHashMap();
        this.visualSourceIndices = new WeakHashMap();
        this.telemetryManagerDelegate = LazyKt.lazy(new FloatingService$$ExternalSyntheticLambda142(this));
        this.globalOverlayAlpha = 1f;
        this.liberarInteraccionUi = new FloatingService$$ExternalSyntheticLambda143(this);
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private final void abrirConfiguracionMacroScript(View arg4, ProfileComponentControl arg5) {
        FloatingService.cerrarEditorTecla$default(this, false, 1, null);
        this.mostrarVentanaMacroScript(layout.elegir_macro, new FloatingService$$ExternalSyntheticLambda181(this, arg4, arg5));
    }

    static final Unit abrirConfiguracionMacroScript$lambda$236(FloatingService arg1, View arg2, ProfileComponentControl arg3, View arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "root");
        Intrinsics.checkNotNullParameter(arg5, "cerrar");
        arg4.setOnClickListener(new FloatingService$$ExternalSyntheticLambda81(arg5));
        arg4.findViewById(id.panelContainer).setClickable(true);
        arg4.findViewById(id.btnTipoScript).setOnClickListener(new FloatingService$$ExternalSyntheticLambda82(arg1, arg2, arg3));
        arg4.findViewById(id.btnTipoMacro).setOnClickListener(new FloatingService$$ExternalSyntheticLambda83(arg1, arg2, arg3));
        return Unit.INSTANCE;
    }

    static final void abrirConfiguracionMacroScript$lambda$236$lambda$233(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    static final void abrirConfiguracionMacroScript$lambda$236$lambda$234(FloatingService arg0, View arg1, ProfileComponentControl arg2, View arg3) {
        arg0.abrirVentanaConfiguracionMacroScript(true, arg1, arg2);
    }

    static final void abrirConfiguracionMacroScript$lambda$236$lambda$235(FloatingService arg0, View arg1, ProfileComponentControl arg2, View arg3) {
        arg0.abrirVentanaConfiguracionMacroScript(false, arg1, arg2);
    }

    private final void abrirEditorTecla(ControlConTecla arg19) {
        View v6_2;
        ControlConTecla v13;
        FloatingService v1 = this;
        ControlConTecla v2 = arg19;
        if((v2 instanceof BotonDisparoBlueStacks)) {
        }
        else {
            ControlConTecla v0 = (v2 instanceof View) ? v2 : null;
            if(v0 == null) {
                return;
            }

            View v3 = v1.mapeoView;
            String v7 = "mapeoView";
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v7);
                v3 = null;
            }

            View v8 = v3.findViewById(id.lienzoMapeo);
            if(v8 == null) {
                return;
            }

            if(!v1.isActive) {
                return;
            }

            if(!v1.isMapeoVisible) {
                return;
            }

            SessionOverlayWindows v3_1 = v1.windowManager;
            String v9 = "windowManager";
            if(v3_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v9);
                v3_1 = null;
            }

            View v4 = v1.mapeoView;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v7);
                v4 = null;
            }

            if(!v3_1.isManaged(v4)) {
                return;
            }

            if(((View)v0).getParent() != v8) {
                return;
            }

            if(v1.botonEnEdicion == v2) {
                TeclaEditorView v3_2 = v1.teclaEditorView;
                if(v3_2 == null && v1.capturaTeclaVista == null) {
                    goto label_49;
                }

                if(v3_2 == null) {
                    return;
                }

                v3_2.requestFocus();
                return;
            }

        label_49:
            v1.cerrarEditorTecla(false);
            v1.botonEnEdicion = v2;
            Object v3_3 = new Object();
            v1.sesionCapturaEditor = v3_3;
            v1.paqueteCapturaEditor = v1.targetPackage;
            boolean v10 = v2 instanceof BotonVistaBlueStacks;
            VistaActivationCapture v4_1 = v10 ? new VistaActivationCapture(new FloatingService$$ExternalSyntheticLambda168(v1, v2, v3_3)) : null;
            v1.capturaTeclaVista = v4_1;
            ObjectRef v11 = new ObjectRef();
            GoldenCoreController v12 = v1.goldenCoreController;
            if(v4_1 != null) {
                ControlConTecla v1_1 = v0;
                FloatingService$$ExternalSyntheticLambda169 v0_1 = new FloatingService$$ExternalSyntheticLambda169(((View)v1_1), this, v2, v3_3, v4_1);
                v13 = v1_1;
                v1 = this;
                v2 = v2;
                v3_3 = v3_3;
                v4_1 = v4_1;
                v1.cancelarCapturaTeclaVista = v12.captureInputBindingForVista(((Function1)v0_1));
            }
            else {
                v13 = v0;
                v12.setInputBindingCaptureListener(new FloatingService$$ExternalSyntheticLambda170(v11, v1, v2, v3_3));
            }

            ObjectRef v5 = v11;
            FloatingService$$ExternalSyntheticLambda172 v0_2 = new FloatingService$$ExternalSyntheticLambda172(v1, v2, v3_3, v4_1, v5);
            FloatingService$$ExternalSyntheticLambda173 v11_1 = new FloatingService$$ExternalSyntheticLambda173(v1, v2, v3_3, new BooleanRef());
            FloatingService$$ExternalSyntheticLambda174 v4_2 = new FloatingService$$ExternalSyntheticLambda174(v1, v2, v3_3);
            if(v10) {
                v2.activarEdicionTecla(true);
            }
            else {
                Context v12_1 = ((View)v13).getContext();
                Intrinsics.checkNotNullExpressionValue(v12_1, "getContext(...)");
                TeclaEditorView v10_1 = new TeclaEditorView(v12_1, new FloatingService$$ExternalSyntheticLambda175(v1, v2, v3_3));
                float v12_2 = ((View)v13).getResources().getDisplayMetrics().density;
                int v14 = ((int)(30f * v12_2));
                v10_1.setLayoutParams(new FrameLayout$LayoutParams(v14, v14));
                float v16 = 38f;
                float v15 = ((View)v13).getWidth() > 0 ? ((float)((View)v13).getWidth()) : v12_2 * v16;
                if(((View)v13).getHeight() > 0) {
                    v12_2 = ((float)((View)v13).getHeight());
                }
                else {
                    v12_2 *= v16;
                }

                v10_1.setElevation(40f);
                v10_1.setTranslationZ(40f);
                float v14_1 = ((float)v14);
                v10_1.setX(((View)v13).getX() + (v15 - v14_1) / 2f);
                v10_1.setY(((View)v13).getY() + (v12_2 - v14_1) / 2f);
                ((FrameLayout)v8).addView(v10_1);
                v10_1.bringToFront();
                v1.teclaEditorView = v10_1;
                v5.element = v10_1;
                v10_1.setOnKeyListener(((View$OnKeyListener)v0_2));
            }

            View v5_1 = v1.mapeoView;
            if(v5_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v7);
                v5_1 = null;
            }

            v5_1.setOnKeyListener(((View$OnKeyListener)v0_2));
            View v0_3 = v1.mapeoView;
            if(v0_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v7);
                v0_3 = null;
            }

            v0_3.setOnTouchListener(((View$OnTouchListener)v11_1));
            v0_3 = v1.mapeoView;
            if(v0_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v7);
                v0_3 = null;
            }

            v0_3.setOnGenericMotionListener(((View$OnGenericMotionListener)v4_2));
            WindowManager$LayoutParams v0_4 = v1.mapeoParams;
            String v4_3 = "mapeoParams";
            if(v0_4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4_3);
                v0_4 = null;
            }

            WindowManager$LayoutParams v5_2 = v1.mapeoParams;
            if(v5_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4_3);
                v5_2 = null;
            }

            v0_4.flags = v5_2.flags & -9;
            SessionOverlayWindows v0_5 = v1.windowManager;
            if(v0_5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v9);
                v0_5 = null;
            }

            v5_1 = v1.mapeoView;
            if(v5_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v7);
                v5_1 = null;
            }

            WindowManager$LayoutParams v6 = v1.mapeoParams;
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4_3);
                ViewGroup$LayoutParams v6_1 = null;
            }

            v0_5.updateViewLayout(v5_1, ((ViewGroup$LayoutParams)v6));
            v0_3 = v1.mapeoView;
            if(v0_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v7);
                v6_2 = null;
            }
            else {
                v6_2 = v0_3;
            }

            v6_2.post(new FloatingService$$ExternalSyntheticLambda176(v1, v2, v3_3));
        }
    }

    private static final void abrirEditorTecla$actualizarTecla(FloatingService arg0, ControlConTecla arg1, Object arg2, String arg3) {
        if(arg0.capturaEditorVigente(arg1, arg2)) {
            arg0.actualizarBindingDelEditor(arg1, arg3);
        }
    }

    static final Unit abrirEditorTecla$lambda$300(FloatingService arg1, ControlConTecla arg2, Object arg3, InputBinding arg4) {
        Intrinsics.checkNotNullParameter(arg4, "it");
        FloatingService.abrirEditorTecla$actualizarTecla(arg1, arg2, arg3, arg4.displayName());
        return Unit.INSTANCE;
    }

    static final Unit abrirEditorTecla$lambda$302(View arg7, FloatingService arg8, ControlConTecla arg9, Object arg10, VistaActivationCapture arg11, InputBinding arg12) {
        Intrinsics.checkNotNullParameter(arg12, "binding");
        arg7.post(new FloatingService$$ExternalSyntheticLambda154(arg8, arg9, arg10, arg11, arg12));
        return Unit.INSTANCE;
    }

    static final void abrirEditorTecla$lambda$302$lambda$301(FloatingService arg0, ControlConTecla arg1, Object arg2, VistaActivationCapture arg3, InputBinding arg4) {
        if(!arg0.capturaEditorVigente(arg1, arg2)) {
        }
        else if(arg0.botonEnEdicion == arg1 && arg0.capturaTeclaVista == arg3) {
            arg3.accept(arg4);
        }
    }

    static final Unit abrirEditorTecla$lambda$304(ObjectRef arg8, FloatingService arg9, ControlConTecla arg10, Object arg11, InputBinding arg12) {
        Intrinsics.checkNotNullParameter(arg12, "binding");
        Object v4 = arg8.element;
        if(v4 == null) {
            return Unit.INSTANCE;
        }

        String v6 = arg12.displayName();
        TeclaEditorView v12 = arg9.teclaEditorView;
        if(v12 != null) {
            v12.post(new FloatingService$$ExternalSyntheticLambda54(arg9, arg10, ((TeclaEditorView)v4), arg11, v6, arg8));
        }

        return Unit.INSTANCE;
    }

    static final void abrirEditorTecla$lambda$304$lambda$303(FloatingService arg1, ControlConTecla arg2, TeclaEditorView arg3, Object arg4, String arg5, ObjectRef arg6) {
        if(arg1.botonEnEdicion == arg2) {
            if(arg1.teclaEditorView != arg3) {
            }
            else if(!arg1.capturaEditorVigente(arg2, arg4)) {
            }
            else {
                FloatingService.abrirEditorTecla$registrarEntrada(arg1, arg2, arg6, arg4, arg5);
            }
        }
    }

    static final boolean abrirEditorTecla$lambda$306(FloatingService arg3, ControlConTecla arg4, Object arg5, VistaActivationCapture arg6, ObjectRef arg7, View arg8, int arg9, KeyEvent arg10) {
        if(!arg3.capturaEditorVigente(arg4, arg5)) {
            return 0;
        }

        Object v2 = null;
        if((arg4 instanceof BotonVistaBlueStacks)) {
            com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion v3 = VistaActivationCapture.Companion;
            Intrinsics.checkNotNull(arg10);
            InputBinding v3_1 = v3.fromKeyEvent(arg10);
            if(v3_1 != null) {
                if(arg6 != null) {
                    Boolean v2_1 = Boolean.valueOf(arg6.accept(v3_1));
                }

                return Intrinsics.areEqual(v2, Boolean.valueOf(true));
            }

            return 0;
        }

        ControlConTecla v6 = (arg4 instanceof ProfileComponentControl) ? arg4 : ((ControlConTecla)v2);
        if(v6 != null) {
            ControlComponent v2_2 = ((ProfileComponentControl)v6).currentComponent();
        }

        if((v2_2 instanceof TapComponent)) {
            com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion v6_1 = VistaActivationCapture.Companion;
            Intrinsics.checkNotNull(arg10);
            InputBinding v6_2 = v6_1.fromKeyEvent(arg10);
            if(v6_2 == null) {
                return 0;
            }

            FloatingService.abrirEditorTecla$registrarEntrada(arg3, arg4, arg7, arg5, v6_2.displayName());
            return 1;
        }

        if(arg10.getAction() == 0) {
            String v6_3 = KeyEvent.keyCodeToString(arg9);
            Intrinsics.checkNotNullExpressionValue(v6_3, "keyCodeToString(...)");
            FloatingService.abrirEditorTecla$registrarEntrada(arg3, arg4, arg7, arg5, StringsKt.removePrefix(v6_3, "KEYCODE_"));
            return 1;
        }

        return 0;
    }

    static final boolean abrirEditorTecla$lambda$307(FloatingService arg1, ControlConTecla arg2, Object arg3, BooleanRef arg4, View arg5, MotionEvent arg6) {
        String v2_2;
        if(!arg1.capturaEditorVigente(arg2, arg3)) {
            return 0;
        }

        if((arg2 instanceof BotonVistaBlueStacks)) {
            com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion v2 = VistaActivationCapture.Companion;
            Intrinsics.checkNotNull(arg6);
            InputBinding v2_1 = v2.fromMotionEvent(arg6);
            v2_2 = v2_1 != null ? v2_1.displayName() : null;
        }
        else {
            com.TryJeanPc.goldenmouse.controls.TeclaEditorView$Companion v2_3 = TeclaEditorView.Companion;
            Intrinsics.checkNotNull(arg6);
            v2_2 = v2_3.resolverNombreBotonRaton(arg6);
        }

        if(v2_2 != null && arg1.botonEnEdicion != null) {
            arg4.element = true;
            arg1.registrarEntradaDelEditor(v2_2);
            return 1;
        }

        if(arg4.element) {
            if(arg6.getActionMasked() == 1 || arg6.getActionMasked() == 3 || arg6.getActionMasked() == 6) {
                arg4.element = false;
            }

            return 1;
        }

        return 0;
    }

    static final boolean abrirEditorTecla$lambda$308(FloatingService arg0, ControlConTecla arg1, Object arg2, View arg3, MotionEvent arg4) {
        String v1_2;
        if(!arg0.capturaEditorVigente(arg1, arg2)) {
            return 0;
        }

        if((arg1 instanceof BotonVistaBlueStacks)) {
            com.TryJeanPc.goldenmouse.controls.VistaActivationCapture$Companion v1 = VistaActivationCapture.Companion;
            Intrinsics.checkNotNull(arg4);
            InputBinding v1_1 = v1.fromMotionEvent(arg4);
            v1_2 = v1_1 != null ? v1_1.displayName() : null;
        }
        else {
            com.TryJeanPc.goldenmouse.controls.TeclaEditorView$Companion v1_3 = TeclaEditorView.Companion;
            Intrinsics.checkNotNull(arg4);
            v1_2 = v1_3.resolverNombreBotonRaton(arg4);
            if(v1_2 == null) {
                v1_2 = TeclaEditorView.Companion.resolverNombreScroll(arg4);
            }
        }

        if(v1_2 == null) {
            return 0;
        }

        arg0.registrarEntradaDelEditor(v1_2);
        return 1;
    }

    static final Unit abrirEditorTecla$lambda$309(FloatingService arg1, ControlConTecla arg2, Object arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg4, "tecla");
        FloatingService.abrirEditorTecla$actualizarTecla(arg1, arg2, arg3, arg4);
        return Unit.INSTANCE;
    }

    static final void abrirEditorTecla$lambda$310(FloatingService arg2, ControlConTecla arg3, Object arg4) {
        if(!arg2.capturaEditorVigente(arg3, arg4)) {
        }
        else {
            View v3 = arg2.mapeoView;
            View v4 = null;
            String v0 = "mapeoView";
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0);
                v3 = v4;
            }

            v3.setFocusable(true);
            v3 = arg2.mapeoView;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0);
                v3 = v4;
            }

            v3.setFocusableInTouchMode(true);
            v3 = arg2.mapeoView;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0);
            }
            else {
                v4 = v3;
            }

            v4.requestFocus();
            TeclaEditorView v3_1 = arg2.teclaEditorView;
            if(v3_1 != null) {
                v3_1.setFocusable(true);
            }

            v3_1 = arg2.teclaEditorView;
            if(v3_1 != null) {
                v3_1.setFocusableInTouchMode(true);
            }

            TeclaEditorView v2 = arg2.teclaEditorView;
            if(v2 == null) {
                return;
            }

            v2.requestFocus();
        }
    }

    private static final void abrirEditorTecla$registrarEntrada(FloatingService arg2, ControlConTecla arg3, ObjectRef arg4, Object arg5, String arg6) {
        ControlConTecla v4;
        TeclaEditorView v0 = arg2.teclaEditorView;
        if(arg2.botonEnEdicion == arg3) {
            if(v0 != arg4.element) {
            }
            else if(!arg2.capturaEditorVigente(arg3, arg5)) {
            }
            else {
                if(v0 != null) {
                    v4 = arg2.botonEnEdicion;
                    if(v4 == null) {
                        goto label_12;
                    }
                }
                else {
                label_12:
                    v4 = arg3;
                }

                if(arg2.esEntradaRechazadaParaTocar(arg3, arg6)) {
                    return;
                }

                if(arg2.esEntradaRechazadaParaTocar(v4, arg6)) {
                    return;
                }

                if(v0 != null) {
                    v0.recibirTecla(arg6);
                    return;
                }

                FloatingService.abrirEditorTecla$actualizarTecla(arg2, arg3, arg5, arg6);
            }
        }
    }

    private final void abrirSelectorImagenPuntero() {
        if(!this.isCursorPickerOpen && !this.isMousePanelTransitioning) {
            View v0 = this.mousePanelView;
            if(v0 == null) {
                return;
            }

            ViewGroup$LayoutParams v1 = v0.getLayoutParams();
            SessionOverlayWindows v3 = null;
            if((v1 instanceof WindowManager$LayoutParams)) {
            }
            else {
                v1 = ((ViewGroup$LayoutParams)v3);
            }

            if(v1 == null) {
                return;
            }

            this.cursorPickerPanelParams = ((WindowManager$LayoutParams)v1);
            this.setCursorPickerOpen(true);
            try {
                SessionOverlayWindows v2 = this.windowManager;
                if(v2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                }
                else {
                    v3 = v2;
                }

                v3.removeViewImmediate(v0);
                this.startActivity(new Intent(this, CursorImagePickerActivity.class).addFlags(0x18000000));
                return;
            }
            catch(Exception ) {
                this.restaurarPanelMouseTrasSelector();
                Toast.makeText(((Context)this), "No se pudo abrir el selector del cursor", 1).show();
            }
        }
    }

    private final void abrirVentanaConfiguracionMacroScript(boolean arg3, View arg4, ProfileComponentControl arg5) {
        int v0 = arg3 ? layout.configurar_script : layout.configurar_macro;
        this.mostrarVentanaMacroScript(v0, new FloatingService$$ExternalSyntheticLambda98(arg3, this, arg4, arg5));
    }

    static final Unit abrirVentanaConfiguracionMacroScript$lambda$240(boolean arg1, FloatingService arg2, View arg3, ProfileComponentControl arg4, View arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "root");
        Intrinsics.checkNotNullParameter(arg6, "cerrar");
        if(!arg1) {
            arg2.conectarEditorVisualMacro(arg5, arg6, arg3, arg4);
            return Unit.INSTANCE;
        }

        arg5.setOnClickListener(new FloatingService$$ExternalSyntheticLambda7(arg6));
        arg5.findViewById(id.panelContainer).setClickable(true);
        int[] v1 = new int[]{id.btnCerrarScript, id.btnCancelarScript, id.btnGuardarScript};
        int v3;
        for(v3 = 0; v3 < 3; ++v3) {
            arg5.findViewById(v1[v3]).setOnClickListener(new FloatingService$$ExternalSyntheticLambda8(arg6));
        }

        arg2.conectarModosVisualesMacroScript(arg5, new int[]{id.btnModoUnaVez, id.btnModoBucle, id.btnModoMantener, id.btnModoPresionarSoltar});
        return Unit.INSTANCE;
    }

    static final void abrirVentanaConfiguracionMacroScript$lambda$240$lambda$237(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    static final void abrirVentanaConfiguracionMacroScript$lambda$240$lambda$239$lambda$238(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    public static final void access$actualizarAutorizacionUi(FloatingService arg0) {
        arg0.actualizarAutorizacionUi();
    }

    public static final void access$actualizarControlesEnJuego(FloatingService arg0) {
        arg0.actualizarControlesEnJuego();
    }

    public static final void access$actualizarNombreImagenPuntero(FloatingService arg0) {
        arg0.actualizarNombreImagenPuntero();
    }

    public static final void access$animarMonitoreo(FloatingService arg0, long arg1, Pair arg3, Pair arg4) {
        arg0.animarMonitoreo(arg1, arg3, arg4);
    }

    public static final void access$animarMonitoreo$terminarBarridoApertura(FloatingService arg0, long arg1, CpuIndicatorView arg3, float arg4, RamIndicatorView arg5, float arg6, TextView arg7, TextView arg8) {
        FloatingService.animarMonitoreo$terminarBarridoApertura(arg0, arg1, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static final void access$aplicarTamanoPuntero(FloatingService arg0, int arg1) {
        arg0.aplicarTamanoPuntero(arg1);
    }

    public static final void access$aplicarTransparenciaPuntero(FloatingService arg0, int arg1) {
        arg0.aplicarTransparenciaPuntero(arg1);
    }

    public static final void access$cargarImagenPuntero(FloatingService arg0) {
        arg0.cargarImagenPuntero();
    }

    public static final void access$detenerMonitoreo(FloatingService arg0, Long arg1) {
        arg0.detenerMonitoreo(arg1);
    }

    public static final GoldenCursorRenderer access$getCursorRenderer$p(FloatingService arg0) {
        return arg0.cursorRenderer;
    }

    public static final ImageView access$getCursorView$p(FloatingService arg0) {
        return arg0.cursorView;
    }

    public static final View access$getFloatingIconView$p(FloatingService arg0) {
        return arg0.floatingIconView;
    }

    public static final boolean access$getGameObservedForeground$p(FloatingService arg0) {
        return arg0.gameObservedForeground;
    }

    public static final GoldenCoreController access$getGoldenCoreController$p(FloatingService arg0) {
        return arg0.goldenCoreController;
    }

    public static final WindowManager$LayoutParams access$getIconParams$p(FloatingService arg0) {
        return arg0.iconParams;
    }

    public static final ValueAnimator access$getIconSnapAnimator$p(FloatingService arg0) {
        return arg0.iconSnapAnimator;
    }

    public static final Pair access$getLastCpuData$p(FloatingService arg0) {
        return arg0.lastCpuData;
    }

    public static final Pair access$getLastRamData$p(FloatingService arg0) {
        return arg0.lastRamData;
    }

    public static final Handler access$getMainHandler$p(FloatingService arg0) {
        return arg0.mainHandler;
    }

    public static final View access$getMapeoView$p(FloatingService arg0) {
        return arg0.mapeoView;
    }

    public static final String access$getTargetPackage$p(FloatingService arg0) {
        return arg0.targetPackage;
    }

    public static final SessionOverlayWindows access$getWindowManager$p(FloatingService arg0) {
        return arg0.windowManager;
    }

    public static final boolean access$isActive$p(FloatingService arg0) {
        return arg0.isActive;
    }

    public static final Pair access$leerFrecuenciaCpu(FloatingService arg0) {
        return arg0.leerFrecuenciaCpu();
    }

    public static final Pair access$leerRamUsada(FloatingService arg0) {
        return arg0.leerRamUsada();
    }

    public static final boolean access$monitoreoActual(FloatingService arg0, long arg1) {
        return arg0.monitoreoActual(arg1);
    }

    public static final boolean access$mostrarHudXML(FloatingService arg0) {
        return arg0.mostrarHudXML();
    }

    public static final Pair access$obtenerTamanoRealPantalla(FloatingService arg0) {
        return arg0.obtenerTamanoRealPantalla();
    }

    public static final IdRepairPlan access$prepararReparacionIds(FloatingService arg0) {
        return arg0.prepararReparacionIds();
    }

    public static final void access$restaurarPanelMouseTrasSelector(FloatingService arg0) {
        arg0.restaurarPanelMouseTrasSelector();
    }

    public static final void access$setHasCustomCursorImage$p(FloatingService arg0, boolean arg1) {
        arg0.hasCustomCursorImage = arg1;
    }

    public static final void access$setIconSnapAnimator$p(FloatingService arg0, ValueAnimator arg1) {
        arg0.iconSnapAnimator = arg1;
    }

    public static final void access$setLastCpuData$p(FloatingService arg0, Pair arg1) {
        arg0.lastCpuData = arg1;
    }

    public static final void access$setLastRamData$p(FloatingService arg0, Pair arg1) {
        arg0.lastRamData = arg1;
    }

    public static final void access$suspenderVentanas(FloatingService arg0, boolean arg1) {
        arg0.suspenderVentanas(arg1);
    }

    public static final void access$vigilarCancelacionPanel$cancelar(FloatingService arg0, long arg1) {
        FloatingService.vigilarCancelacionPanel$cancelar(arg0, arg1);
    }

    private final void actualizarAutorizacionUi() {
        if(this.isActive) {
            if(this.windowManager == null) {
            }
            else {
                this.mainHandler.removeCallbacks(this.liberarInteraccionUi);
                if(this.hayInteraccionUi()) {
                    this.aplicarInteraccionUi(true);
                    return;
                }
                else {
                    this.mainHandler.post(this.liberarInteraccionUi);
                }
            }
        }
    }

    private final void actualizarBindingDelEditor(ControlConTecla arg13, String arg14) {
        int v8;
        if(this.esEntradaRechazadaParaTocar(arg13, arg14)) {
        }
        else {
            boolean v0 = arg13 instanceof BotonVistaBlueStacks;
            Object v3 = null;
            if(v0) {
                InputBinding v14 = InputBinding.Companion.fromDisplayName(arg14);
                if(v14 == null) {
                }
                else if(!GameProfileCompiler.INSTANCE.isVistaInputAllowed(v14)) {
                }
                else {
                    this.guardarBindingVista(arg13, v14);
                    if(this.botonEnEdicion == arg13) {
                        FloatingService.cerrarEditorTecla$default(this, false, 1, v3);
                        return;
                    }
                }
            }
            else {
                arg14 = StringsKt.trim(((CharSequence)arg14)).toString().toUpperCase(Locale.ROOT);
                String v4 = "toUpperCase(...)";
                Intrinsics.checkNotNullExpressionValue(arg14, v4);
                View v5 = this.mapeoView;
                if(v5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
                    v5 = ((View)v3);
                }

                v5 = v5.findViewById(id.lienzoMapeo);
                if(arg14.length() <= 0 || v5 == null) {
                    v8 = 0;
                }
                else {
                    int v6 = ((FrameLayout)v5).getChildCount();
                    int v7 = 0;
                    v8 = 0;
                    while(v7 < v6) {
                        View v9 = ((FrameLayout)v5).getChildAt(v7);
                        if((((ControlConTecla)v9)) != arg13 && ((v9 instanceof ControlConTecla))) {
                            String v10 = StringsKt.trim(((ControlConTecla)v9).obtenerTeclaActual()).toString().toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(v10, v4);
                            if(v10.length() > 0 && (Intrinsics.areEqual(v10, arg14))) {
                                ((ControlConTecla)v9).actualizarTecla("");
                                v8 = 1;
                            }
                        }

                        ++v7;
                    }
                }

                arg13.actualizarTecla(arg14);
                ControlConTecla v4_1 = (arg13 instanceof ProfileComponentControl) ? arg13 : ((ControlConTecla)v3);
                if(v4_1 != null) {
                    InputBinding v5_1 = InputBinding.Companion.fromDisplayName(arg14);
                    if(v5_1 != null) {
                        ((ProfileComponentControl)v4_1).updateBinding("PRIMARY", v5_1);
                    }
                }

                arg14 = v8 != 0 ? "Reasignado a: " + arg14 : "TECLA: " + arg14;
                if(!FloatingService.guardarConfiguracion$default(this, false, 1, v3)) {
                    return;
                }

                Toast.makeText(this, ((CharSequence)arg14), 0).show();
                FloatingService.aplicarPerfilActualAlMotor$default(this, ((GameProfile)v3), 1, v3);
                if(!v0) {
                    return;
                }

                if(this.botonEnEdicion != arg13) {
                    return;
                }

                FloatingService.cerrarEditorTecla$default(this, false, 1, v3);
            }
        }
    }

    private final void actualizarControlesEnJuego() {
        ControlesVisualesView v10_1;
        Object v8;
        View v6_1;
        SessionOverlayWindows v0 = this.windowManager;
        String v1 = "windowManager";
        View v2 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = ((SessionOverlayWindows)v2);
        }

        if(v0.getSuspended()) {
        }
        else {
            View v0_1 = this.controlesJuegoView;
            if(v0_1 == null) {
            }
            else {
                SharedPreferences v3 = this.getSharedPreferences("GoldenMouseVisual", 0);
                View[] v5 = new View[5];
                Dialog v6 = this.retrocesoDialog;
                if(v6 != null) {
                    if(v6.isShowing()) {
                    }
                    else {
                        v6 = ((Dialog)v2);
                    }

                    if(v6 == null) {
                        goto label_27;
                    }

                    v6_1 = v6.findViewById(0x1020002);
                }
                else {
                label_27:
                    v6_1 = v2;
                }

                v5[0] = v6_1;
                v6_1 = this.hudView;
                if(v6_1 == null) {
                label_34:
                    v6_1 = v2;
                }
                else if(v6_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hudView");
                    goto label_34;
                }

                int v7 = 1;
                v5[1] = v6_1;
                v5[2] = this.fpsSettingsView;
                v5[3] = this.settingsPanelView;
                v5[4] = this.mousePanelView;
                List v5_1 = CollectionsKt.listOfNotNull(((Object[])v5));
                ArrayList v6_2 = new ArrayList();
                Iterator v5_2 = ((Iterable)v5_1).iterator();
                while(v5_2.hasNext()) {
                    v8 = v5_2.next();
                    if(!(v8 instanceof FrameLayout)) {
                        continue;
                    }

                    ((Collection)v6_2).add(v8);
                }

                v5_2 = ((Iterable)v6_2).iterator();
                do {
                    if(v5_2.hasNext()) {
                        v8 = v5_2.next();
                        if(v8.getParent() == null) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_65;
                    }
                }
                while(true);

                goto label_66;
            label_65:
                v8 = v2;
            label_66:
                String v9 = "mapeoView";
                if(!this.isMapeoVisible) {
                    View v5_3 = this.mapeoView;
                    if(v5_3 != null) {
                        if(v5_3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v9);
                            v5_3 = v2;
                        }

                        if(v5_3.getParent() == null) {
                            goto label_77;
                        }

                        goto label_81;
                    }

                label_77:
                    if(!v3.getBoolean("mostrar_controles", true)) {
                        goto label_81;
                    }
                }
                else {
                label_81:
                    v7 = 0;
                }

                v0_1.setAlpha(1f);
                int v3_1 = 8;
                int v5_4 = v7 == 0 || v8 != null ? v3_1 : 0;
                v0_1.setVisibility(v5_4);
                v5_2 = ((Iterable)v6_2).iterator();
                while(v5_2.hasNext()) {
                    Object v6_3 = v5_2.next();
                    View v10 = ((FrameLayout)v6_3).getChildAt(0);
                    if((v10 instanceof ControlesVisualesView)) {
                    }
                    else {
                        v10 = v2;
                    }

                    if(v7 != 0 && v6_3 == v8 && v10 == null) {
                        v10_1 = new ControlesVisualesView(this);
                        ((FrameLayout)v6_3).addView(v10_1, 0, new FrameLayout$LayoutParams(-1, -1));
                    }

                    if((((View)v10_1)) == null) {
                        continue;
                    }

                    FrameLayout v11 = this.cursorOverlayView;
                    ViewGroup$LayoutParams v11_1 = v11 != null ? v11.getLayoutParams() : ((ViewGroup$LayoutParams)v2);
                    if((v11_1 instanceof WindowManager$LayoutParams)) {
                    }
                    else {
                        v11_1 = ((ViewGroup$LayoutParams)v2);
                    }

                    float v11_2 = v11_1 != null ? ((WindowManager$LayoutParams)v11_1).alpha : 0.8f;
                    v10_1.setAlpha(v11_2);
                    int v6_4 = v7 == 0 || v6_3 != v8 ? v3_1 : 0;
                    v10_1.setVisibility(v6_4);
                    if(v10_1.getVisibility() != 0) {
                        continue;
                    }

                    v10_1.invalidate();
                }

                if(v7 == 0) {
                    return;
                }

                Pair v3_2 = this.obtenerTamanoRealPantalla();
                v5_4 = v3_2.component1().intValue();
                v3_1 = v3_2.component2().intValue();
                SessionOverlayWindows v6_5 = this.windowManager;
                if(v6_5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v6_5 = ((SessionOverlayWindows)v2);
                }

                View v1_1 = this.mapeoView;
                if(v1_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v9);
                    v1_1 = v2;
                }

                if(!v6_5.isManaged(v1_1)) {
                    v1_1 = this.mapeoView;
                    if(v1_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v9);
                        v1_1 = v2;
                    }

                    if(!v1_1.isLayoutRequested()) {
                        v1_1 = this.mapeoView;
                        if(v1_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v9);
                            v1_1 = v2;
                        }

                        if(v1_1.getWidth() != v5_4) {
                            goto label_170;
                        }

                        v1_1 = this.mapeoView;
                        if(v1_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v9);
                            v1_1 = v2;
                        }

                        if(v1_1.getHeight() == v3_1) {
                            goto label_184;
                        }
                    }

                label_170:
                    v1_1 = this.mapeoView;
                    if(v1_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v9);
                        v1_1 = v2;
                    }

                    v1_1.measure(View$MeasureSpec.makeMeasureSpec(v5_4, 0x40000000), View$MeasureSpec.makeMeasureSpec(v3_1, 0x40000000));
                    View v14 = this.mapeoView;
                    if(v14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v9);
                    }
                    else {
                        v2 = v14;
                    }

                    v2.layout(0, 0, v5_4, v3_1);
                }

            label_184:
                if(v0_1.getVisibility() != 0) {
                    return;
                }

                v0_1.invalidate();
            }
        }
    }

    private final void actualizarGirosDecorativos(long arg5) {
        View v3_1;
        View v0_1;
        boolean v0 = this.getDecorativeOptions().isEnabled(DecorativeEffect.CPU_RING);
        ObjectAnimator v1 = this.cpuRingAnimator;
        String v2 = "hudView";
        ObjectAnimator v3 = null;
        if(!v0) {
            if(v1 != null) {
                v1.cancel();
            }

            this.cpuRingAnimator = v3;
        }
        else {
            if(v1 != null) {
                goto label_21;
            }

            v0_1 = this.hudView;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v0_1 = ((View)v3);
            }

            v0_1 = v0_1.findViewById(id.bgCircleCpuCountTop);
            if(v0_1 == null) {
                goto label_21;
            }

            this.iniciarGiroDecorativo(v0_1, arg5, true);
        }

    label_21:
        v0 = this.getDecorativeOptions().isEnabled(DecorativeEffect.RAM_RING);
        v1 = this.ramRingAnimator;
        if(!v0) {
            if(v1 != null) {
                v1.cancel();
            }

            this.ramRingAnimator = v3;
            return;
        }

        if(v1 == null) {
            v0_1 = this.hudView;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
            }
            else {
                v3_1 = v0_1;
            }

            v0_1 = v3_1.findViewById(id.bgCircleRamCountTop);
            if(v0_1 == null) {
                return;
            }

            this.iniciarGiroDecorativo(v0_1, arg5, false);
        }
    }

    private final void actualizarNombreImagenPuntero() {
        View v0 = this.mousePanelView;
        if(v0 != null) {
            v0 = v0.findViewById(id.txtImagenPuntero);
            if(v0 != null) {
                String v2 = this.hasCustomCursorImage ? "Personalizado  ›" : "Default  ›";
                ((TextView)v0).setText(((CharSequence)v2));
            }
        }
    }

    private final void actualizarVisibilidadCursor(boolean arg10, boolean arg11) {
        if(this.isActive) {
            SessionOverlayWindows v0 = this.windowManager;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v0 = null;
            }

            if(v0.getSuspended()) {
                return;
            }

            Pair v0_1 = this.obtenerTamanoRealPantalla();
            int v1 = v0_1.component1().intValue();
            int v0_2 = v0_1.component2().intValue();
            TouchInjector.Companion.updateScreenDimensions(v1, v0_2);
            GoldenCursorRenderer v2 = this.cursorRenderer;
            if(v2 != null) {
                v2.updateBounds(((float)v1), ((float)v0_2));
            }

            float v6 = (((float)v1)) / 2f;
            float v7 = (((float)v0_2)) / 2f;
            if((arg10) || (arg11)) {
                GoldenCursorRenderer v0_3 = this.cursorRenderer;
                if(v0_3 != null) {
                    v0_3.moveTo(v6, v7);
                }
            }

            FloatingService v4 = this;
            FloatingService$$ExternalSyntheticLambda95 v3 = new FloatingService$$ExternalSyntheticLambda95(v4, arg10, v6, v7, arg11);
            if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                ((Runnable)v3).run();
                return;
            }

            v4.mainHandler.post(((Runnable)v3));
        }
    }

    static void actualizarVisibilidadCursor$default(FloatingService arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        arg0.actualizarVisibilidadCursor(arg1, false);
    }

    static final void actualizarVisibilidadCursor$lambda$53(FloatingService arg4, boolean arg5, float arg6, float arg7, boolean arg8) {
        Pair v5_1;
        GoldenCursorRenderer v5;
        if(arg4.isActive) {
            SessionOverlayWindows v0 = arg4.windowManager;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v0 = null;
            }

            if(v0.getSuspended()) {
                return;
            }

            ImageView v0_1 = arg4.cursorView;
            if(v0_1 == null) {
                return;
            }

            FrameLayout v1 = arg4.cursorOverlayView;
            if(v1 == null) {
                return;
            }

            v1.setVisibility(0);
            if(arg5) {
                GoldenCursorRenderer v4 = arg4.cursorRenderer;
                if(v4 != null) {
                    v4.moveTo(arg6, arg7);
                }

                v0_1.setVisibility(4);
                v0_1.setAlpha(0f);
                return;
            }

            if(arg8) {
                v5 = arg4.cursorRenderer;
                if(v5 != null) {
                    v5.moveTo(arg6, arg7);
                }
            }
            else {
                v5 = arg4.cursorRenderer;
                if(v5 != null) {
                    v5_1 = v5.currentHotspot();
                    if(v5_1 == null) {
                        goto label_36;
                    }
                }
                else {
                label_36:
                    v5_1 = new Pair(Float.valueOf(0f), Float.valueOf(0f));
                }

                float v8 = v5_1.component1().floatValue();
                float v5_2 = v5_1.component2().floatValue();
                float v1_1 = 1f;
                if(v8 <= v1_1 && v5_2 <= v1_1) {
                    v5 = arg4.cursorRenderer;
                    if(v5 != null) {
                        v5.moveTo(arg6, arg7);
                    }
                    else {
                    }

                    goto label_54;
                }

                GoldenCursorRenderer v6 = arg4.cursorRenderer;
                if(v6 == null) {
                    goto label_54;
                }

                v6.moveTo(v8, v5_2);
            }

        label_54:
            v0_1.setVisibility(0);
            v0_1.setAlpha(arg4.cursorOpacity);
        }
    }

    private final void animarMonitoreo(long arg16, Pair arg18, Pair arg19) {
        View v0 = this.hudView;
        View v1 = null;
        String v2 = "hudView";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        View v11 = v0.findViewById(id.textCpuPercent);
        v0 = this.hudView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        View v12 = v0.findViewById(id.textRamPercent);
        v0 = this.hudView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        View v7 = v0.findViewById(id.cpuView);
        v0 = this.hudView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        View v9 = v0.findViewById(id.ramView);
        v0 = this.hudView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        v0 = v0.findViewById(id.bgCircleCpuCountBottom);
        View v3 = this.hudView;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            v1 = v3;
        }

        v1 = v1.findViewById(id.bgCircleRamCountBottom);
        float v2_1 = 0f;
        if(v0 != null) {
            v0.setRotation(0f);
        }

        if(v0 != null) {
            v0.setRotationY(0f);
        }

        if(v1 != null) {
            v1.setRotation(0f);
        }

        if(v1 != null) {
            v1.setRotationY(0f);
        }

        this.actualizarGirosDecorativos(arg16);
        String v0_1 = "format(...)";
        String v1_1 = "%.2f";
        if(v12 != null) {
            String v3_1 = String.format(Locale.US, v1_1, Arrays.copyOf(new Object[]{arg18.getFirst()}, 1));
            Intrinsics.checkNotNullExpressionValue(v3_1, v0_1);
            ((TextView)v12).setText(((CharSequence)v3_1));
        }

        if(v11 != null) {
            if(arg19 != null) {
                v1_1 = String.format(Locale.US, v1_1, Arrays.copyOf(new Object[]{arg19.getFirst()}, 1));
                Intrinsics.checkNotNullExpressionValue(v1_1, v0_1);
                if(v1_1 != null) {
                }
                else {
                    goto label_76;
                }
            }
            else {
            label_76:
                v1_1 = "—";
            }

            ((TextView)v11).setText(((CharSequence)v1_1));
        }

        if(arg19 != null) {
            v2_1 = arg19.getSecond().floatValue();
        }

        float v8 = v2_1;
        float v10 = arg18.getSecond().floatValue();
        this.updateHudAnimationOptions = new FloatingService$$ExternalSyntheticLambda72(this, arg16, ((CpuIndicatorView)v7), v8, ((RamIndicatorView)v9), v10, ((TextView)v11), ((TextView)v12));
        if(!this.cpuOpeningEnabled && v7 != null) {
            ((CpuIndicatorView)v7).setProgressInstant(v8);
        }

        if(!this.ramOpeningEnabled && v9 != null) {
            ((RamIndicatorView)v9).setProgressInstant(v10);
        }

        if(!this.cpuOpeningEnabled && !this.ramOpeningEnabled) {
            FloatingService.animarMonitoreo$terminarBarridoApertura(this, arg16, v7, v8, v9, v10, v11, v12);
            return;
        }

        ValueAnimator v1_2 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v1_2.setDuration(650);
        v1_2.setInterpolator(new DecelerateInterpolator());
        v1_2.addUpdateListener(new FloatingService$$ExternalSyntheticLambda73(this, arg16, ((CpuIndicatorView)v7), v9));
        ValueAnimator v14 = ValueAnimator.ofFloat(new float[]{1f, 0f});
        v14.setDuration(550);
        v14.setInterpolator(new AccelerateDecelerateInterpolator());
        v14.addUpdateListener(new FloatingService$$ExternalSyntheticLambda74(this, arg16, ((CpuIndicatorView)v7), v8, ((RamIndicatorView)v9), v10));
        AnimatorSet v2_2 = new AnimatorSet();
        v2_2.playSequentially(new Animator[]{v1_2, v14});
        v2_2.addListener(new FloatingService$animarMonitoreo$animatorSet$1$1(this, arg16, ((CpuIndicatorView)v7), v8, ((RamIndicatorView)v9), v10, ((TextView)v11), ((TextView)v12)));
        this.tachometerAnimator = v2_2;
        v2_2.start();
    }

    static final Unit animarMonitoreo$lambda$204(FloatingService arg1, long arg2, CpuIndicatorView arg4, float arg5, RamIndicatorView arg6, float arg7, TextView arg8, TextView arg9) {
        if(arg1.monitoreoActual(arg2)) {
            arg1.actualizarGirosDecorativos(arg2);
            if(arg1.tachometerAnimator != null) {
                if(!arg1.cpuOpeningEnabled && arg4 != null) {
                    arg4.setProgressInstant(arg5);
                }

                if(!arg1.ramOpeningEnabled && arg6 != null) {
                    arg6.setProgressInstant(arg7);
                }

                if(arg1.cpuOpeningEnabled) {
                    goto label_21;
                }

                if(arg1.ramOpeningEnabled) {
                    goto label_21;
                }

                Animator v0 = arg1.tachometerAnimator;
                if(v0 != null) {
                    v0.cancel();
                }

                FloatingService.animarMonitoreo$terminarBarridoApertura(arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9);
            }
        }

    label_21:
        return Unit.INSTANCE;
    }

    static final void animarMonitoreo$lambda$206$lambda$205(FloatingService arg1, long arg2, CpuIndicatorView arg4, RamIndicatorView arg5, ValueAnimator arg6) {
        Intrinsics.checkNotNullParameter(arg6, "animator");
        if(!arg1.monitoreoActual(arg2)) {
        }
        else {
            Object v2 = arg6.getAnimatedValue();
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Float");
            float v2_1 = ((Float)v2).floatValue();
            if((arg1.cpuOpeningEnabled) && arg4 != null) {
                arg4.setProgressInstant(v2_1);
            }

            if(!arg1.ramOpeningEnabled) {
                return;
            }

            if(arg5 == null) {
                return;
            }

            arg5.setProgressInstant(v2_1);
        }
    }

    static final void animarMonitoreo$lambda$208$lambda$207(FloatingService arg1, long arg2, CpuIndicatorView arg4, float arg5, RamIndicatorView arg6, float arg7, ValueAnimator arg8) {
        Intrinsics.checkNotNullParameter(arg8, "animator");
        if(!arg1.monitoreoActual(arg2)) {
        }
        else {
            float v2 = arg8.getAnimatedFraction();
            float v8 = 1f;
            if((arg1.cpuOpeningEnabled) && arg4 != null) {
                arg4.setProgressInstant(v8 - (v8 - arg5) * v2);
            }

            if(!arg1.ramOpeningEnabled) {
                return;
            }

            if(arg6 == null) {
                return;
            }

            arg6.setProgressInstant(v8 - (v8 - arg7) * v2);
        }
    }

    private static final void animarMonitoreo$terminarBarridoApertura(FloatingService arg1, long arg2, CpuIndicatorView arg4, float arg5, RamIndicatorView arg6, float arg7, TextView arg8, TextView arg9) {
        if(!arg1.monitoreoActual(arg2)) {
            arg1.detenerMonitoreo(Long.valueOf(arg2));
            return;
        }

        arg1.tachometerAnimator = null;
        if(arg4 != null) {
            arg4.setProgressInstant(arg5);
        }

        if(arg6 != null) {
            arg6.setProgressInstant(arg7);
        }

        arg1.iniciarLoopMonitoreo(arg2, arg8, arg9, arg4, arg6);
    }

    private final void animarPanelLateral(View arg3, boolean arg4, Function0 arg5) {
        DecelerateInterpolator v3_1;
        Integer v0 = Integer.valueOf(arg3.getWidth());
        if(v0.intValue() > 0) {
        }
        else {
            v0 = null;
        }

        float v2 = v0 != null ? ((float)v0.intValue()) : this.getResources().getDisplayMetrics().density * 300f;
        ViewPropertyAnimator v3 = arg3.animate();
        float v0_1 = 0f;
        if(arg4) {
            v2 = 0f;
        }

        ViewPropertyAnimator v2_1 = v3.translationX(v2);
        if(arg4) {
            v0_1 = 1f;
        }

        v2_1 = v2_1.alpha(v0_1);
        long v0_2 = arg4 ? 260 : 220;
        v2_1 = v2_1.setDuration(v0_2);
        if(arg4) {
            v3_1 = new DecelerateInterpolator();
        }
        else {
            AccelerateInterpolator v3_2 = new AccelerateInterpolator();
        }

        v2_1.setInterpolator(((TimeInterpolator)v3_1)).withEndAction(new FloatingService$$ExternalSyntheticLambda113(arg5)).start();
    }

    static final void animarPanelLateral$lambda$138(Function0 arg0) {
        arg0.invoke();
    }

    private final void aplicarAjustesLogo(SharedPreferences arg9) {
        WindowManager$LayoutParams v2_1;
        View v0 = this.floatingIconView;
        if(v0 != null && this.iconParams != null) {
            String v1 = "floatingIconView";
            ViewGroup$LayoutParams v2 = null;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0 = ((View)v2);
            }

            v0.setAlpha((((float)RangesKt.coerceIn(arg9.getInt("alpha_logo", 100), 0, 100))) / 100f);
            int v9 = RangesKt.coerceAtLeast(((int)((((float)(this.floatingIconBaseSizePx * RangesKt.coerceIn(arg9.getInt("tamano_logo", 100), 50, 150)))) / 100f)), 1);
            WindowManager$LayoutParams v0_1 = this.iconParams;
            String v3 = "iconParams";
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0_1 = ((WindowManager$LayoutParams)v2);
            }

            if(v0_1.width == v9) {
                v0_1 = this.iconParams;
                if(v0_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                    v0_1 = ((WindowManager$LayoutParams)v2);
                }

                if(v0_1.height != v9) {
                    goto label_45;
                }

                return;
            }

        label_45:
            v0_1 = this.iconParams;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0_1 = ((WindowManager$LayoutParams)v2);
            }

            v0_1.width = v9;
            v0_1 = this.iconParams;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0_1 = ((WindowManager$LayoutParams)v2);
            }

            v0_1.height = v9;
            Pair v0_2 = this.obtenerTamanoRealPantalla();
            int v4 = v0_2.component1().intValue();
            int v0_3 = v0_2.component2().intValue();
            WindowManager$LayoutParams v6 = this.iconParams;
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v6 = ((WindowManager$LayoutParams)v2);
            }

            WindowManager$LayoutParams v7 = this.iconParams;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v7 = ((WindowManager$LayoutParams)v2);
            }

            v6.x = RangesKt.coerceIn(v7.x, 0, RangesKt.coerceAtLeast(v4 - v9, 0));
            WindowManager$LayoutParams v4_1 = this.iconParams;
            if(v4_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v4_1 = ((WindowManager$LayoutParams)v2);
            }

            v6 = this.iconParams;
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v6 = ((WindowManager$LayoutParams)v2);
            }

            v4_1.y = RangesKt.coerceIn(v6.y, -(v9 / 2), RangesKt.coerceAtLeast(v0_3 - v9, 0));
            SessionOverlayWindows v9_1 = this.windowManager;
            String v0_4 = "windowManager";
            if(v9_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0_4);
                v9_1 = ((SessionOverlayWindows)v2);
            }

            View v4_2 = this.floatingIconView;
            if(v4_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v4_2 = ((View)v2);
            }

            if(v9_1.isManaged(v4_2)) {
                try {
                    v9_1 = this.windowManager;
                    if(v9_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v0_4);
                        v9_1 = ((SessionOverlayWindows)v2);
                    }

                    v0 = this.floatingIconView;
                    if(v0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1);
                        v0 = ((View)v2);
                    }

                    WindowManager$LayoutParams v8_1 = this.iconParams;
                    if(v8_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3);
                    }
                    else {
                        v2_1 = v8_1;
                    }

                    v9_1.updateViewLayout(v0, ((ViewGroup$LayoutParams)v2_1));
                    Result.constructor-impl(Unit.INSTANCE);
                    return;
                }
                catch(Throwable v8) {
                    Result.constructor-impl(ResultKt.createFailure(v8));
                }
            }
        }
    }

    private final void aplicarAjustesVisualesBotones() {
        SessionOverlayWindows v0_5;
        float v0_2;
        if(this.mapeoView == null) {
            return;
        }

        int v1 = 0;
        SharedPreferences v0 = this.getSharedPreferences("GoldenMouseVisual", 0);
        boolean v2 = v0.getBoolean("mostrar_controles", true);
        int v0_1 = RangesKt.coerceIn(v0.getInt("alpha_botones", 100), 0, 100);
        float v4 = 100f;
        if(this.isMapeoVisible) {
            v0_2 = RangesKt.coerceAtLeast((((float)v0_1)) / v4, 0.35f);
        }
        else if(v2) {
            v0_2 = (((float)v0_1)) / v4;
        }
        else {
            v0_2 = 0f;
        }

        this.aplicarOpacidadGlobal(v0_2);
        View v0_3 = this.mapeoView;
        String v2_1 = "mapeoView";
        View v3 = null;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2_1);
            v0_3 = v3;
        }

        v0_3 = v0_3.findViewById(id.lienzoMapeo);
        if(v0_3 != null) {
            int v4_1 = ((FrameLayout)v0_3).getChildCount();
            while(v1 < v4_1) {
                View v5 = ((FrameLayout)v0_3).getChildAt(v1);
                if(v5 == null) {
                }
                else {
                    View v6 = (v5 instanceof ControlVisual) ? v5 : v3;
                    if(v6 == null) {
                        goto label_49;
                    }

                    this.aplicarEstiloAControl(((ControlVisual)v6), v5);
                }

            label_49:
                ++v1;
            }
        }

        if(!this.isMapeoVisible) {
            try {
                v0_5 = this.windowManager;
            }
            catch(Exception v0_4) {
                goto label_78;
            }

            String v1_1 = "windowManager";
            if(v0_5 == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                    v0_5 = ((SessionOverlayWindows)v3);
                label_58:
                    View v4_2 = this.mapeoView;
                    if(v4_2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                        v4_2 = v3;
                    }

                    if(!v0_5.isManaged(v4_2)) {
                        goto label_79;
                    }

                    v0_5 = this.windowManager;
                    if(v0_5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                        v0_5 = ((SessionOverlayWindows)v3);
                    }

                    View v1_2 = this.mapeoView;
                    if(v1_2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                    }
                    else {
                        v3 = v1_2;
                    }

                    v0_5.removeViewImmediate(v3);
                }
                catch(Exception v0_4) {
                label_78:
                    Log.e("GOLDEN_UI", "No se pudo retirar el editor al volver al juego", ((Throwable)v0_4));
                }

                goto label_79;
            }

            goto label_58;
        }

    label_79:
        this.actualizarControlesEnJuego();
    }

    private final void aplicarAnimacionesDecorativas() {
        this.cpuOpeningEnabled = this.getDecorativeOptions().isEnabled(DecorativeEffect.CPU_OPENING);
        this.ramOpeningEnabled = this.getDecorativeOptions().isEnabled(DecorativeEffect.RAM_OPENING);
        View v0 = this.hudView;
        View v1 = null;
        String v2 = "hudView";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        v0 = v0.findViewById(id.cpuView);
        if(v0 != null) {
            ((CpuIndicatorView)v0).setProgressAnimationEnabled(this.getDecorativeOptions().isEnabled(DecorativeEffect.CPU_PROGRESS));
        }

        v0 = this.hudView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            v1 = v0;
        }

        v0 = v1.findViewById(id.ramView);
        if(v0 != null) {
            ((RamIndicatorView)v0).setProgressAnimationEnabled(this.getDecorativeOptions().isEnabled(DecorativeEffect.RAM_PROGRESS));
        }

        BlueMagicVisualModeController v0_1 = this.blueMagicVisualMode;
        if(v0_1 != null) {
            v0_1.updateAnimationOptions();
        }

        Function0 v5 = this.updateHudAnimationOptions;
        if(v5 != null) {
            v5.invoke();
        }
    }

    private final void aplicarEstiloAControl(ControlVisual arg6, View arg7) {
        float v5;
        SharedPreferences v0 = this.getSharedPreferences("GoldenMouseVisual", 0);
        boolean v2 = v0.getBoolean("mostrar_controles", true);
        int v1 = RangesKt.coerceIn(v0.getInt("alpha_botones", 100), 0, 100);
        String v4 = "Dorado";
        String v3 = v0.getString("tema_botones", v4);
        if(v3 == null) {
        }
        else {
            v4 = v3;
        }

        Intrinsics.checkNotNull(v0);
        float v0_1 = this.resolverEscalaControl(v0, arg6.obtenerTipo());
        Integer v3_1 = PanelVisual.Companion.resolverColorTema(v4);
        float v4_1 = 100f;
        if(this.isMapeoVisible) {
            v5 = RangesKt.coerceAtLeast((((float)v1)) / v4_1, 0.35f);
        }
        else if(v2) {
            v5 = (((float)v1)) / v4_1;
        }
        else {
            v5 = 0f;
        }

        arg7.setAlpha(v5);
        arg6.aplicarEstiloVisual(v0_1, v3_1);
    }

    private final void aplicarInteraccionUi(boolean arg3) {
        if(Intrinsics.areEqual(this.uiInteractionActive, Boolean.valueOf(arg3))) {
        }
        else {
            this.uiInteractionActive = Boolean.valueOf(arg3);
            this.goldenCoreController.setUiInteractionMode(arg3);
            this.goldenCoreController.setAimInputEnabled((((int)arg3)) ^ 1);
            if(arg3) {
                this.goldenCoreController.setAimActive(false);
            }
        }
    }

    public final void aplicarOpacidadGlobal(float arg5) {
        arg5 = RangesKt.coerceIn(arg5, 0f, 1f);
        this.globalOverlayAlpha = arg5;
        View v4 = this.mapeoView;
        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v4 = null;
        }

        v4 = v4.findViewById(id.lienzoMapeo);
        if(v4 == null) {
            return;
        }

        int v0 = ((FrameLayout)v4).getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = ((FrameLayout)v4).getChildAt(v2);
            if(v3 == null) {
            }
            else {
                v3.setAlpha(arg5);
            }
        }

        String v4_1 = arg5 == 0f ? "MODO FANTASMA" : "visible";
        Log.d("GOLDEN_UI", "Opacidad global aplicada: alpha=" + arg5 + " (" + v4_1 + ")");
    }

    private final void aplicarPerfilActualAlMotor(GameProfile arg4) {
        if(arg4 == null) {
        }
        else {
            Pair v0 = this.obtenerTamanoRealPantalla();
            this.goldenCoreController.applyGameProfile(arg4, v0.component1().intValue(), v0.component2().intValue());
            if(!this.loadingIdentityProfile) {
                this.mainHandler.post(new FloatingService$$ExternalSyntheticLambda127(this));
            }
        }
    }

    static void aplicarPerfilActualAlMotor$default(FloatingService arg0, GameProfile arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.construirPerfilActual();
        }

        arg0.aplicarPerfilActualAlMotor(arg1);
    }

    static final void aplicarPerfilActualAlMotor$lambda$88(FloatingService arg0) {
        arg0.solicitarReparacionIds();
    }

    private final void aplicarTamanoPuntero(int arg5) {
        ImageView v0 = this.cursorView;
        if(v0 == null) {
            return;
        }

        int v4 = RangesKt.coerceAtLeast(((int)((((float)(RangesKt.coerceAtLeast(((int)(32f * this.getResources().getDisplayMetrics().density)), 1) * RangesKt.coerceIn(arg5, 0, 200)))) / 100f)), 1);
        ViewGroup$LayoutParams v5 = v0.getLayoutParams();
        v5.width = v4;
        v5.height = v4;
        v0.setLayoutParams(v5);
    }

    private final void aplicarTransparenciaPuntero(int arg3) {
        this.cursorOpacity = (((float)RangesKt.coerceIn(arg3, 0, 100))) / 100f;
        ImageView v3 = this.cursorView;
        if(v3 != null) {
            float v2 = v3.getVisibility() == 0 ? this.cursorOpacity : 0f;
            v3.setAlpha(v2);
        }
    }

    public void bringCursorToFront() {
        if(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.mantenerCursorAlFrente();
            return;
        }

        this.mainHandler.post(new FloatingService$$ExternalSyntheticLambda164(this));
    }

    static final void bringCursorToFront$lambda$54(FloatingService arg0) {
        arg0.mantenerCursorAlFrente();
    }

    private final boolean capturaEditorVigente(ControlConTecla arg5, Object arg6) {
        View v1 = null;
        ControlConTecla v0 = (arg5 instanceof View) ? arg5 : ((ControlConTecla)v1);
        if(v0 == null) {
            return 0;
        }

        if(arg6 != null && this.sesionCapturaEditor == arg6 && this.botonEnEdicion == arg5 && (this.isActive) && (this.isMapeoVisible) && (Intrinsics.areEqual(this.paqueteCapturaEditor, this.targetPackage)) && this.mapeoView != null) {
            SessionOverlayWindows v5 = this.windowManager;
            if(v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v5 = ((SessionOverlayWindows)v1);
            }

            View v6 = this.mapeoView;
            String v3 = "mapeoView";
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v6 = v1;
            }

            if(!v5.isManaged(v6)) {
                return 0;
            }

            ViewParent v5_1 = ((View)v0).getParent();
            View v4 = this.mapeoView;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
            }
            else {
                v1 = v4;
            }

            if(v5_1 != v1.findViewById(id.lienzoMapeo)) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final void cargarConfiguracion() {
        Float v5;
        Object v3_3;
        View v1_1;
        List v2_2;
        FloatingService v0 = this;
        int v10 = 0;
        Object v1 = null;
        FloatingService.cerrarEditorTecla$default(v0, false, 1, v1);
        String v2 = v0.targetPackage;
        if(v2 == null) {
            v2 = "com.TryJeanPc.default";
        }

        GameProfile v3 = v0.getProfileStorage().load(v2);
        String v8 = "GOLDEN_CONFIG";
        if(v3 != null) {
            v0.cargarPerfilEnEditor(v3);
            Log.d(v8, "Carga directa desde GameProfile package=" + v2);
            return;
        }

        SharedPreferences v2_1 = v0.getSharedPreferences("GoldenMouseConfig", 0);
        String v3_1 = v2_1.getString("mapeo_guardado_v2", ((String)v1));
        String v4 = "mapeoView";
        String v12 = "";
        if(v3_1 != null) {
            v2_2 = ControlVisualStateSerializer.INSTANCE.deserialize(v3_1);
            View v3_2 = v0.mapeoView;
            if(v3_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
            }
            else {
                v1_1 = v3_2;
            }

            v1_1 = ((View)v1).findViewById(id.lienzoMapeo);
            if(v1_1 == null) {
                return;
            }

            Iterator v9 = ((Iterable)v2_2).iterator();
            while(v9.hasNext()) {
                v3_3 = v9.next();
                v2 = ((ControlVisualState)v3_3).getTipo();
                Float v4_1 = Float.valueOf(((ControlVisualState)v3_3).getX());
                v5 = Float.valueOf(((ControlVisualState)v3_3).getY());
                String v6 = ((ControlVisualState)v3_3).getTecla();
                if(v6 == null) {
                    v6 = v12;
                }

                if(v0.crearControlArrastrable(((FrameLayout)v1_1), v2, v4_1, v5, v6, ((ControlVisualState)v3_3).getWidth(), ((ControlVisualState)v3_3).getHeight()) == null) {
                    continue;
                }

                ++v10;
            }

            Log.d(v8, "Carga V2 controles=" + v10);
            return;
        }
        else {
            v2 = v2_1.getString("mapeo_guardado", v12);
            if(v2 == null) {
                v2 = v12;
            }

            String v13 = v2;
            if(((CharSequence)v13).length() <= 0) {
                return;
            }

            View v2_3 = v0.mapeoView;
            if(v2_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
            }
            else {
                v1_1 = v2_3;
            }

            v1_1 = ((View)v1).findViewById(id.lienzoMapeo);
            if(v1_1 == null) {
                return;
            }

            Iterator v13_1 = StringsKt.split$default(((CharSequence)v13), new String[]{";"}, false, 0, 6, null).iterator();
            while(v13_1.hasNext()) {
                v3_3 = v13_1.next();
                if(!StringsKt.isBlank(((CharSequence)v3_3))) {
                    v2_2 = StringsKt.split$default(((CharSequence)v3_3), new String[]{","}, false, 4, 2, null);
                    int v4_2 = 3;
                    if(v2_2.size() >= v4_2) {
                        v3_3 = v2_2.get(0);
                        v5 = StringsKt.toFloatOrNull(v2_2.get(1));
                        if(v5 != null) {
                            float v5_1 = v5.floatValue();
                            Float v6_1 = StringsKt.toFloatOrNull(v2_2.get(2));
                            if(v6_1 != null) {
                                float v6_2 = v6_1.floatValue();
                                if(v4_2 < v2_2.size()) {
                                    Object v2_4 = v2_2.get(v4_2);
                                }
                                else {
                                    v2 = v12;
                                }

                                FloatingService.crearControlArrastrable$default(v0, ((FrameLayout)v1_1), v3_3, Float.valueOf(v5_1), Float.valueOf(v6_2), v2, 0, 0, 0x60, null);
                            }
                        }
                    }
                }

                v0 = this;
            }
        }
    }

    private final void cargarImagenPuntero() {
        Job v0 = this.cursorImageJob;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.cursorImageJob = BuildersKt.launch$default(this.serviceScope, null, null, new FloatingService$cargarImagenPuntero$1(this, ((Continuation)v1)), 3, null);
    }

    private final void cargarPerfilEnEditor(GameProfile arg17) {
        View v3_2;
        Object v3;
        FloatingService v1 = this;
        ProfileIdentityRepairDialog v0 = v1.identityRepairDialog;
        if(v0 != null) {
            v0.close();
        }

        Object v12 = null;
        FloatingService.cerrarEditorTecla$default(v1, false, 1, v12);
        v1.ocultarVistaEliminar();
        v1.deseleccionarControl();
        View v2 = v1.mapeoView;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v2 = ((View)v12);
        }

        v2 = v2.findViewById(id.lienzoMapeo);
        if(v2 == null) {
            return;
        }

        v1.loadingIdentityProfile = true;
        try {
            v1.controlSourceIndices.clear();
            v1.visualSourceIndices.clear();
            v1.editorIdentitySource = v1.getProfileStorage().loadResult(arg17.getTargetPackage()).getOriginalJson();
            ((FrameLayout)v2).removeAllViews();
            Iterator v0_2 = arg17.getControls().iterator();
            int v9;
            for(v9 = 0; v0_2.hasNext(); v9 = v10) {
                v3 = v0_2.next();
                int v10 = v9 + 1;
                if(v9 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                Object v13 = v3;
                String v3_1 = ((ProfileControl)v13).getType();
                Float v4 = Float.valueOf(((ProfileControl)v13).getX());
                Float v5 = Float.valueOf(((ProfileControl)v13).getY());
                Object v6 = CollectionsKt.firstOrNull(((ProfileControl)v13).getBindings().values());
                String v6_1 = v6 != null ? ((InputBinding)v6).displayName() : ((String)v12);
                if(v6_1 == null) {
                    v6_1 = "";
                }

                v3_2 = v1.crearControlArrastrable(((FrameLayout)v2), v3_1, v4, v5, v6_1, ((ProfileControl)v13).getWidth(), ((ProfileControl)v13).getHeight());
                if(v3_2 == null) {
                }
                else {
                    v3_2.setTag(((ProfileControl)v13).getId());
                    v1.controlSourceIndices.put(v3_2, Integer.valueOf(v9));
                    if((v3_2 instanceof ProfileComponentControl)) {
                    }
                    else {
                        v3_2 = ((View)v12);
                    }

                    if(v3_2 == null) {
                        goto label_81;
                    }

                    ((ProfileComponentControl)v3_2).applyComponent(((ProfileControl)v13).getComponent());
                    Iterator v4_1 = ((ProfileControl)v13).getBindings().entrySet().iterator();
                    while(v4_1.hasNext()) {
                        Object v5_1 = v4_1.next();
                        ((ProfileComponentControl)v3_2).updateBinding(((Map$Entry)v5_1).getKey(), ((Map$Entry)v5_1).getValue());
                    }
                }

            label_81:
            }

            v0_2 = arg17.getVisualControls().iterator();
            int v13_1;
            for(v13_1 = 0; v0_2.hasNext(); v13_1 = v14) {
                v3 = v0_2.next();
                int v14 = v13_1 + 1;
                if(v13_1 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                Object v15 = v3;
                v3_2 = FloatingService.crearControlArrastrable$default(v1, ((FrameLayout)v2), "VISTA_LIBRE_VISUAL", Float.valueOf(((VistaLibreMarker)v15).getX()), Float.valueOf(((VistaLibreMarker)v15).getY()), null, 0, 0, 0x70, null);
                if((v3_2 instanceof VistaLibreVisual)) {
                }
                else {
                    v3_2 = ((View)v12);
                }

                if(v3_2 != null) {
                    ((VistaLibreVisual)v3_2).restaurarMarcador(((VistaLibreMarker)v15));
                    v1.visualSourceIndices.put(v3_2, Integer.valueOf(v13_1));
                }
            }

            v1.editorIdentityBaseline = v1.construirPerfilActual();
        }
        catch(Throwable v0_1) {
            goto label_133;
        }

        v1.loadingIdentityProfile = false;
        Log.d("GOLDEN_CONFIG", "Perfil cargado package=" + arg17.getTargetPackage() + " controles=" + arg17.getControls().size());
        return;
    label_133:
        v1.loadingIdentityProfile = false;
        throw v0_1;
    }

    private final void cerrarEditorTecla(boolean arg8) {
        WindowManager$LayoutParams v2_1;
        this.getDobleClicEditor().reset();
        int v0 = this.sesionCapturaEditor != null || this.botonEnEdicion != null ? 1 : 0;
        Object v2 = null;
        this.sesionCapturaEditor = v2;
        this.paqueteCapturaEditor = ((String)v2);
        boolean v3 = this.botonEnEdicion instanceof BotonVistaBlueStacks;
        VistaActivationCapture v4 = this.capturaTeclaVista;
        if(v4 != null) {
            v4.close();
        }

        this.capturaTeclaVista = ((VistaActivationCapture)v2);
        Function0 v4_1 = this.cancelarCapturaTeclaVista;
        this.cancelarCapturaTeclaVista = ((Function0)v2);
        ControlConTecla v5 = this.botonEnEdicion;
        if((v5 instanceof BotonVistaBlueStacks)) {
        }
        else {
            v5 = ((ControlConTecla)v2);
        }

        if(v5 != null) {
            ((BotonVistaBlueStacks)v5).activarEdicionTecla(false);
        }

        TeclaEditorView v1 = this.teclaEditorView;
        if(v1 != null) {
            v1.setOnTouchListener(((View$OnTouchListener)v2));
            v1.setOnGenericMotionListener(((View$OnGenericMotionListener)v2));
            ViewParent v5_1 = v1.getParent();
            if((v5_1 instanceof ViewGroup)) {
            }
            else {
                v5_1 = ((ViewParent)v2);
            }

            if(v5_1 == null) {
                goto label_40;
            }

            ((ViewGroup)v5_1).removeView(((View)v1));
        }

    label_40:
        this.teclaEditorView = ((TeclaEditorView)v2);
        this.botonEnEdicion = ((ControlConTecla)v2);
        if(v4_1 != null) {
            v4_1.invoke();
        }
        else if(!v3 && v0 != 0) {
            this.goldenCoreController.setInputBindingCaptureListener(((Function1)v2));
        }

        View v0_1 = this.mapeoView;
        if(v0_1 == null) {
        }
        else {
            String v1_1 = "mapeoView";
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v0_1 = ((View)v2);
            }

            v0_1.setOnKeyListener(((View$OnKeyListener)v2));
            v0_1 = this.mapeoView;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v0_1 = ((View)v2);
            }

            v0_1.setOnTouchListener(((View$OnTouchListener)v2));
            v0_1 = this.mapeoView;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v0_1 = ((View)v2);
            }

            v0_1.setOnGenericMotionListener(((View$OnGenericMotionListener)v2));
            if(!arg8) {
                return;
            }

            SessionOverlayWindows v8 = this.windowManager;
            String v0_2 = "windowManager";
            if(v8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0_2);
                v8 = ((SessionOverlayWindows)v2);
            }

            View v3_1 = this.mapeoView;
            if(v3_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v3_1 = ((View)v2);
            }

            if(!v8.isManaged(v3_1)) {
                return;
            }

            WindowManager$LayoutParams v8_1 = this.mapeoParams;
            String v3_2 = "mapeoParams";
            if(v8_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_2);
                v8_1 = ((WindowManager$LayoutParams)v2);
            }

            WindowManager$LayoutParams v4_2 = this.mapeoParams;
            if(v4_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_2);
                v4_2 = ((WindowManager$LayoutParams)v2);
            }

            v8_1.flags = v4_2.flags | 8;
            v8 = this.windowManager;
            if(v8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0_2);
                v8 = ((SessionOverlayWindows)v2);
            }

            v0_1 = this.mapeoView;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v0_1 = ((View)v2);
            }

            WindowManager$LayoutParams v7 = this.mapeoParams;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_2);
            }
            else {
                v2_1 = v7;
            }

            v8.updateViewLayout(v0_1, ((ViewGroup$LayoutParams)v2_1));
        }
    }

    static void cerrarEditorTecla$default(FloatingService arg0, boolean arg1, int arg2, Object arg3) {
        arg0.cerrarEditorTecla(true);
    }

    private final void cerrarPanelAjustes() {
        View v0;
        if(this.isSettingsTransitioning) {
        }
        else {
            v0 = this.settingsPanelView;
            if(v0 == null) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        View v1 = v0.findViewById(id.panelContainer);
        if(v1 == null) {
            v1 = v0;
        }

        this.setSettingsTransitioning(true);
        long v2 = this.hubTransitions.begin(new FloatingService$$ExternalSyntheticLambda70(this, v0));
        this.vigilarCancelacionPanel(v1, v2);
        this.animarPanelLateral(v1, false, new FloatingService$$ExternalSyntheticLambda71(this, v2));
    }

    static final Unit cerrarPanelAjustes$lambda$163(FloatingService arg2, View arg3, boolean arg4) {
        SessionOverlayWindows v0;
        if(arg2.settingsPanelView != arg3) {
            return Unit.INSTANCE;
        }

        View v4 = null;
        try {
            v0 = arg2.windowManager;
        }
        catch(Throwable v3) {
            goto label_24;
        }

        String v1 = "windowManager";
        if(v0 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0 = ((SessionOverlayWindows)v4);
            label_11:
                if(v0.isManaged(arg3)) {
                    v0 = arg2.windowManager;
                    if(v0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1);
                        v0 = ((SessionOverlayWindows)v4);
                    }

                    v0.removeViewImmediate(arg3);
                }

                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v3) {
            label_24:
                Result.constructor-impl(ResultKt.createFailure(v3));
            }
        }
        else {
            goto label_11;
        }

        arg2.setSettingsPanelView(v4);
        arg2.setSettingsTransitioning(false);
        arg2.volverAlHubTrasPanel();
        return Unit.INSTANCE;
    }

    static final Unit cerrarPanelAjustes$lambda$164(FloatingService arg6, long arg7) {
        HubWindowTransition.finish$default(arg6.hubTransitions, arg7, false, 2, null);
        return Unit.INSTANCE;
    }

    private final void cerrarPanelFpsConAnimacion(Function0 arg5) {
        View v0 = this.fpsSettingsView;
        if(v0 == null) {
            this.setFpsSettingsVisible(false);
            this.setPanelTransitioning(false);
            if(arg5 != null) {
                arg5.invoke();
            }

            this.actualizarControlesEnJuego();
            return;
        }

        View v1 = v0.findViewById(id.panelContainer);
        if(v1 == null) {
            v1 = v0;
        }

        Integer v2 = Integer.valueOf(v1.getWidth());
        if(v2.intValue() > 0) {
        }
        else {
            v2 = null;
        }

        float v2_1 = v2 != null ? ((float)v2.intValue()) : this.getResources().getDisplayMetrics().density * 320f;
        v1.animate().translationX(v2_1).alpha(0f).setDuration(200).setInterpolator(new AccelerateInterpolator(1.8f)).withEndAction(new FloatingService$$ExternalSyntheticLambda75(this, v0, arg5)).start();
    }

    static void cerrarPanelFpsConAnimacion$default(FloatingService arg0, Function0 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        arg0.cerrarPanelFpsConAnimacion(arg1);
    }

    static final void cerrarPanelFpsConAnimacion$lambda$109(FloatingService arg3, View arg4, Function0 arg5) {
        SessionOverlayWindows v1;
        View v0 = null;
        try {
            v1 = arg3.windowManager;
        }
        catch(Exception ) {
            goto label_13;
        }

        String v2 = "windowManager";
        if(v1 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v1 = ((SessionOverlayWindows)v0);
            label_6:
                if(v1.isManaged(arg4)) {
                    v1 = arg3.windowManager;
                    if(v1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v2);
                        v1 = ((SessionOverlayWindows)v0);
                    }

                    v1.removeViewImmediate(arg4);
                }

                goto label_13;
            }
            catch(Exception ) {
            label_13:
                arg3.setFpsSettingsView(v0);
                arg3.setFpsSettingsVisible(false);
                arg3.setPanelTransitioning(false);
                if(arg5 != null) {
                    arg5.invoke();
                }

                arg3.actualizarControlesEnJuego();
                return;
            }
        }

        goto label_6;
    }

    private final void cerrarPanelMouse() {
        View v0;
        if(this.isMousePanelTransitioning) {
        }
        else {
            v0 = this.mousePanelView;
            if(v0 == null) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        this.getMousePanelController().close();
        View v1 = v0.findViewById(id.panelContainer);
        if(v1 == null) {
            v1 = v0;
        }

        this.setMousePanelTransitioning(true);
        long v2 = this.hubTransitions.begin(new FloatingService$$ExternalSyntheticLambda52(this, v0));
        this.vigilarCancelacionPanel(v1, v2);
        this.animarPanelLateral(v1, false, new FloatingService$$ExternalSyntheticLambda53(this, v2));
    }

    static final Unit cerrarPanelMouse$lambda$178(FloatingService arg2, View arg3, boolean arg4) {
        SessionOverlayWindows v0;
        if(arg2.mousePanelView != arg3) {
            return Unit.INSTANCE;
        }

        View v4 = null;
        try {
            v0 = arg2.windowManager;
        }
        catch(Throwable v3) {
            goto label_24;
        }

        String v1 = "windowManager";
        if(v0 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0 = ((SessionOverlayWindows)v4);
            label_11:
                if(v0.isManaged(arg3)) {
                    v0 = arg2.windowManager;
                    if(v0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1);
                        v0 = ((SessionOverlayWindows)v4);
                    }

                    v0.removeViewImmediate(arg3);
                }

                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v3) {
            label_24:
                Result.constructor-impl(ResultKt.createFailure(v3));
            }
        }
        else {
            goto label_11;
        }

        arg2.setMousePanelView(v4);
        arg2.setMousePanelTransitioning(false);
        arg2.volverAlHubTrasPanel();
        return Unit.INSTANCE;
    }

    static final Unit cerrarPanelMouse$lambda$179(FloatingService arg6, long arg7) {
        HubWindowTransition.finish$default(arg6.hubTransitions, arg7, false, 2, null);
        return Unit.INSTANCE;
    }

    private final void cerrarVentanaMacroScript() {
        MacroEditorController v0 = this.macroEditorController;
        if(v0 != null) {
            v0.close();
        }

        this.macroEditorController = null;
        Dialog v1 = this.macroScriptDialog;
        this.macroScriptDialog = null;
        if(v1 != null) {
            v1.dismiss();
        }
    }

    private final void conectarConfiguracionAvanzada(View arg2, ProfileComponentControl arg3) {
        arg3.setOnComponentChanged(new FloatingService$$ExternalSyntheticLambda104(this, arg2));
        arg3.setOnConfigure(new FloatingService$$ExternalSyntheticLambda106(this, arg2, arg3));
    }

    static final Unit conectarConfiguracionAvanzada$lambda$256(FloatingService arg2, View arg3) {
        arg2.getEditorGeometry().refresh(arg3);
        FloatingService.guardarConfiguracion$default(arg2, false, 1, null);
        FloatingService.aplicarPerfilActualAlMotor$default(arg2, null, 1, null);
        return Unit.INSTANCE;
    }

    static final Unit conectarConfiguracionAvanzada$lambda$287(FloatingService arg19, View arg20, ProfileComponentControl arg21) {
        String v5_4;
        String v4_1;
        FloatingService v10_4;
        View v5_3;
        Map v5_2;
        Object v14_2;
        ControlComponent v12;
        Iterator v9_1;
        ControlVisualState v8_1;
        GameProfile v9;
        View v0_2;
        FloatingService v1 = arg19;
        View v2 = arg20;
        v1.getDobleClicEditor().reset();
        Object v5 = null;
        if((arg19.usaDobleClicEditor(arg20)) && v1.botonEnEdicion != null) {
            FloatingService.cerrarEditorTecla$default(v1, false, 1, v5);
        }

        ControlVisualState v6 = EditorControlGeometry.snapshot$default(v1.getEditorGeometry(), v2, false, 2, v5);
        float v0 = v6.getX();
        float v7 = v6.getY();
        Integer v8 = Integer.valueOf(Math.max(v2.getWidth(), v2.getHeight()));
        if(v8.intValue() > 0) {
        }
        else {
            v8 = ((Integer)v5);
        }

        ComponentPlacement v11 = new ComponentPlacement(v0, v7, v8);
        FloatingService$$ExternalSyntheticLambda42 v14 = new FloatingService$$ExternalSyntheticLambda42(v2, v1);
        ProfileComponentControl v7_1 = arg21;
        FloatingService$$ExternalSyntheticLambda43 v0_1 = new FloatingService$$ExternalSyntheticLambda43(v1, v2, v7_1);
        ControlComponent v3 = v7_1.currentComponent();
        if((v3 instanceof MacroScriptComponent)) {
            arg19.abrirConfiguracionMacroScript(arg20, arg21);
        }
        else {
            String v10 = "mapeoView";
            if((v3 instanceof TapComponent)) {
                v0_2 = v1.mapeoView;
                if(v0_2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v10);
                    v0_2 = ((View)v5);
                }

                v0_2 = v0_2.findViewById(id.lienzoMapeo);
                if(v0_2 == null) {
                    return Unit.INSTANCE;
                }

                v9 = v1.construirPerfilActual();
                if(v9 == null) {
                    return Unit.INSTANCE;
                }

                v8_1 = v6;
                String v6_1 = v9.getTargetPackage();
                ControlComponent v10_1 = v3;
                String v13 = v1.identidadControl(v2, ((TapComponent)v10_1).getType());
                v9_1 = v9.getControls().iterator();
                int v14_1 = 0;
                Object v15 = v5;
                while(true) {
                    if(v9_1.hasNext()) {
                        Object v16 = v9_1.next();
                        if(!Intrinsics.areEqual(v16.getId(), v13)) {
                            continue;
                        }

                        if(v14_1 != 0) {
                            goto label_79;
                        }
                        else {
                            v14_1 = 1;
                            v15 = v16;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_80;
                }

                if(v14_1 == 0) {
                label_79:
                    v15 = v5;
                }

            label_80:
                if(v15 != null) {
                    ControlComponent v5_1 = ((ProfileControl)v15).getComponent();
                }

                if(!(v5_1 instanceof TapComponent)) {
                    return Unit.INSTANCE;
                }

                boolean v9_2 = v1.getProfileStorage().loadResult(v6_1).getOriginalJson() != null ? true : false;
                TapComponentSettingsDialog.INSTANCE.show$app(v1, v11, ((TapComponent)v10_1), new FloatingService$$ExternalSyntheticLambda45(v1, v2, v3, v0_2, v13, v6_1, v7_1, v8_1, v9_2));
            }
            else {
                v8_1 = v6;
                if((v3 instanceof JoystickComponent)) {
                    v0_2 = (v2 instanceof JoystickBlueStacks) ? v2 : ((View)v5);
                    if(v0_2 == null) {
                        return Unit.INSTANCE;
                    }

                    View v4 = v1.mapeoView;
                    if(v4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v10);
                        v4 = ((View)v5);
                    }

                    v4 = v4.findViewById(id.lienzoMapeo);
                    if(v4 == null) {
                        return Unit.INSTANCE;
                    }

                    GameProfile v6_2 = v1.construirPerfilActual();
                    if(v6_2 == null) {
                        return Unit.INSTANCE;
                    }

                    v12 = v3;
                    String v3_1 = v1.identidadControl(v2, ((JoystickComponent)v12).getType());
                    v9_1 = v6_2.getControls().iterator();
                    Object v13_1 = v5;
                    int v10_2 = 0;
                    while(true) {
                        if(v9_1.hasNext()) {
                            v14_2 = v9_1.next();
                            if(!Intrinsics.areEqual(v14_2.getId(), v3_1)) {
                                continue;
                            }

                            if(v10_2 != 0) {
                                goto label_147;
                            }
                            else {
                                v10_2 = 1;
                                v13_1 = v14_2;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_148;
                    }

                    if(v10_2 == 0) {
                    label_147:
                        v13_1 = v5;
                    }

                label_148:
                    if(v13_1 == null) {
                        return Unit.INSTANCE;
                    }

                    v9 = v1.getProfileStorage().loadResult(v6_2.getTargetPackage()).getProfile();
                    if(v9 != null) {
                        List v9_3 = v9.getControls();
                        if(v9_3 != null) {
                            v9_1 = ((Iterable)v9_3).iterator();
                            Object v10_3 = v5;
                            int v18 = 0;
                            while(true) {
                                if(v9_1.hasNext()) {
                                    v14_2 = v9_1.next();
                                    if(!Intrinsics.areEqual(v14_2.getId(), v3_1)) {
                                        continue;
                                    }

                                    if(v18 != 0) {
                                    }
                                    else {
                                        v18 = 1;
                                        v10_3 = v14_2;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_176;
                            }

                            if(v18 == 0) {
                            }
                            else {
                                v5 = v10_3;
                            }

                        label_176:
                            if(v5 == null) {
                                goto label_179;
                            }

                            v5_2 = ((ProfileControl)v5).getBindings();
                            if(v5_2 != null) {
                                goto label_180;
                            }
                        }
                        else {
                        }

                        goto label_179;
                    }
                    else {
                    label_179:
                        v5_2 = arg21.currentBindings();
                    }

                label_180:
                    JoystickComponentSettingsDialog.INSTANCE.show$app(v1, v11, ((JoystickComponent)v12), v5_2, ((JoystickBlueStacks)v0_2).areKeysVisible(), new FloatingService$conectarConfiguracionAvanzada$2$3(new EditorPreview(v2, ((FrameLayout)v4), v1.getEditorGeometry())), new FloatingService$conectarConfiguracionAvanzada$2$4(v0_2), new FloatingService$$ExternalSyntheticLambda46(v1, v2, v4, v6_2.getTargetPackage(), v3_1, v8_1, arg21, v13_1, v5_2));
                    goto label_257;
                }

                if((v3 instanceof ViewComponent)) {
                    if((v2 instanceof BotonVistaBlueStacks)) {
                        v5_3 = v2;
                    }

                    ViewComponentSettingsDialog v9_4 = ViewComponentSettingsDialog.INSTANCE;
                    v10_4 = v1;
                    v12 = v3;
                    if(v5_3 != null) {
                        v4_1 = ((BotonVistaBlueStacks)v5_3).obtenerTeclaActual();
                        if(v4_1 == null) {
                            goto label_222;
                        }
                    }
                    else {
                    label_222:
                        v4_1 = ((ViewComponent)v12).getToggleCursorKey();
                    }

                    v9_4.show(((Context)v10_4), v11, ((ViewComponent)v12), v4_1, new FloatingService$$ExternalSyntheticLambda47(((BotonVistaBlueStacks)v5_3), v1), new FloatingService$conectarConfiguracionAvanzada$2$7(v1.goldenCoreController), new FloatingService$$ExternalSyntheticLambda48(v1, v2, v3), new FloatingService$$ExternalSyntheticLambda49(((BotonVistaBlueStacks)v5_3), v1), new FloatingService$$ExternalSyntheticLambda50(((Function2)v0_1)));
                    goto label_257;
                }

                if(!(v3 instanceof FireComponent)) {
                    goto label_259;
                }

                FireComponentSettingsDialog v9_5 = FireComponentSettingsDialog.INSTANCE;
                v10_4 = v1;
                v12 = v3;
                Object v1_1 = CollectionsKt.firstOrNull(arg21.currentBindings().values());
                if(v1_1 != null) {
                    v5_4 = ((InputBinding)v1_1).displayName();
                }

                if(v5_4 == null) {
                    v5_4 = "";
                }

                v9_5.show(((Context)v10_4), v11, ((FireComponent)v12), v5_4, ((Function0)v14), new FloatingService$$ExternalSyntheticLambda51(((Function2)v0_1)));
            }
        }

    label_257:
        return Unit.INSTANCE;
    label_259:
        throw new NoWhenBranchMatchedException();
    }

    static final Unit conectarConfiguracionAvanzada$lambda$287$lambda$259(View arg1, FloatingService arg2) {
        ControlConTecla v1;
        if((arg1 instanceof ControlConTecla)) {
        }
        else {
            v1 = null;
        }

        if(0 != 0) {
            arg2.abrirEditorTecla(v1);
        }

        return Unit.INSTANCE;
    }

    static final Unit conectarConfiguracionAvanzada$lambda$287$lambda$263(FloatingService arg3, View arg4, ProfileComponentControl arg5, ComponentPlacement arg6, ControlComponent arg7) {
        Intrinsics.checkNotNullParameter(arg6, "updatedPlacement");
        Intrinsics.checkNotNullParameter(arg7, "updatedComponent");
        Integer v0 = arg6.getSize();
        Object v1 = null;
        if(v0 != null) {
            if(v0.intValue() > 0) {
            }
            else {
                v0 = ((Integer)v1);
            }

            if(v0 == null) {
                goto label_18;
            }

            int v0_1 = ((Number)v0).intValue();
            ViewGroup$LayoutParams v2 = arg4.getLayoutParams();
            v2.width = v0_1;
            v2.height = v0_1;
            arg4.setLayoutParams(v2);
        }

    label_18:
        float v2_1 = 3.402823E+38f;
        if(Math.abs(arg6.getX()) <= v2_1 && Math.abs(arg6.getY()) <= v2_1) {
            arg3.getEditorGeometry().place(arg4, arg6.getX(), arg6.getY());
        }

        arg5.applyComponent(arg7);
        FloatingService.guardarConfiguracion$default(arg3, false, 1, v1);
        FloatingService.aplicarPerfilActualAlMotor$default(arg3, ((GameProfile)v1), 1, v1);
        return Unit.INSTANCE;
    }

    static final boolean conectarConfiguracionAvanzada$lambda$287$lambda$269(FloatingService arg12, View arg13, ControlComponent arg14, FrameLayout arg15, String arg16, String arg17, ProfileComponentControl arg18, ControlVisualState arg19, boolean arg20, TapSettingsEdit arg21) {
        Object v9_1;
        Object v0_3;
        String v1 = arg16;
        String v2 = arg17;
        TapSettingsEdit v3 = arg21;
        Intrinsics.checkNotNullParameter(v3, "edit");
        GameProfile v4 = arg12.construirPerfilActual();
        String v5 = arg12.identidadControl(arg13, arg14.getType());
        if(arg12.isMapeoVisible) {
            SessionOverlayWindows v6 = arg12.windowManager;
            String v9 = null;
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v6 = ((SessionOverlayWindows)v9);
            }

            View v10 = arg12.mapeoView;
            String v11 = "mapeoView";
            if(v10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v11);
                v10 = ((View)v9);
            }

            if(!v6.isManaged(v10)) {
                goto label_149;
            }

            if(arg13.getParent() != arg15) {
                goto label_149;
            }

            View v6_1 = arg12.mapeoView;
            if(v6_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v11);
                v6_1 = ((View)v9);
            }

            if(v6_1.findViewById(id.lienzoMapeo) != arg15) {
                goto label_149;
            }

            if(!Intrinsics.areEqual(v5, v1)) {
                goto label_149;
            }

            if(v4 == null) {
                goto label_149;
            }

            if(!Intrinsics.areEqual(v4.getTargetPackage(), v2)) {
                goto label_149;
            }

            Iterator v0 = v4.getControls().iterator();
            int v5_1 = 0;
            Object v6_2 = v9;
            while(true) {
                if(v0.hasNext()) {
                    Object v10_1 = v0.next();
                    if(!Intrinsics.areEqual(v10_1.getId(), v1)) {
                        continue;
                    }

                    if(v5_1 != 0) {
                        goto label_58;
                    }
                    else {
                        v5_1 = 1;
                        v6_2 = v10_1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_59;
            }

            if(v5_1 == 0) {
            label_58:
                v6_2 = v9;
            }

        label_59:
            ControlComponent v0_1 = v6_2 != null ? ((ProfileControl)v6_2).getComponent() : ((ControlComponent)v9);
            if(!(v0_1 instanceof TapComponent)) {
                goto label_149;
            }

            if(!(arg18.currentComponent() instanceof TapComponent)) {
                goto label_149;
            }

            GameProfileLoadResult v0_2 = arg12.getProfileStorage().loadResult(v2);
            GameProfile v5_2 = v0_2.getProfile();
            if(v5_2 == null) {
            }
            else {
                v4 = v5_2;
            }

            v4 = arg12.perfilConGeometria(v4, v1, arg19);
            if(v0_2.getProfile() == null) {
                if(v0_2.getOriginalJson() == null && !arg20) {
                    goto label_89;
                }

                v0_3 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("El perfil guardado cambió o está protegido")));
            }
            else {
            label_89:
                v0_3 = v3.save-BWLJW6A(v4, v1, v2, new FloatingService$$ExternalSyntheticLambda117(arg12, v1, arg13));
                if(Result.isSuccess-impl(v0_3)) {
                    GameProfile v0_4 = arg12.limitarPosicionEnPerfil(((GameProfile)v0_3), v1, arg13);
                }

                v0_3 = Result.constructor-impl(v0_3);
            }

            Object v2_1 = Result.isFailure-impl(v0_3) ? v9 : v0_3;
            if(v2_1 == null) {
                Throwable v13 = Result.exceptionOrNull-impl(v0_3);
                if(v13 != null) {
                    v9 = v13.getMessage();
                }

                Toast.makeText(((Context)arg12), "No se pudo guardar TOQUE: " + v9, 1).show();
                return 0;
            }

            if((((GameProfile)v2_1)) != v4) {
                v0 = ((GameProfile)v2_1).getControls().iterator();
                int v3_1 = 0;
                while(true) {
                    if(v0.hasNext()) {
                        Object v4_1 = v0.next();
                        if(!Intrinsics.areEqual(v4_1.getId(), v1)) {
                            continue;
                        }

                        if(v3_1 == 0) {
                            v9_1 = v4_1;
                            v3_1 = 1;
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        goto label_133;
                    }

                    return 1;
                }

                throw new IllegalArgumentException("Collection contains more than one matching element.");
            label_133:
                if(v3_1 != 0) {
                    arg12.getEditorGeometry().place(arg13, ((ProfileControl)v9_1).getX(), ((ProfileControl)v9_1).getY());
                    arg18.applyComponent(((ProfileControl)v9_1).getComponent());
                    arg12.guardarConfiguracion(false);
                    arg12.aplicarPerfilActualAlMotor(((GameProfile)v2_1));
                }
                else {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }

            return 1;
        }

    label_149:
        Toast.makeText(((Context)arg12), "El TOQUE o su perfil ya no están disponibles", 1).show();
        return 0;
    }

    static final Result conectarConfiguracionAvanzada$lambda$287$lambda$269$lambda$266(FloatingService arg1, String arg2, View arg3, GameProfile arg4) {
        Intrinsics.checkNotNullParameter(arg4, "candidate");
        return Result.box-impl(arg1.getProfileStorage().save-IoAF18A(arg1.limitarPosicionEnPerfil(arg4, arg2, arg3)));
    }

    static final boolean conectarConfiguracionAvanzada$lambda$287$lambda$279(FloatingService arg27, View arg28, FrameLayout arg29, String arg30, String arg31, ControlVisualState arg32, ProfileComponentControl arg33, ProfileControl arg34, Map arg35, JoystickSettingsEdit arg36) {
        Iterator v1_2;
        ProfileComponentControl v2_6;
        int v4_1;
        boolean v21;
        ProfileControl v16_1;
        Iterator v2_3;
        FloatingService v0 = arg27;
        View v1 = arg28;
        String v2 = arg30;
        String v3 = arg31;
        JoystickSettingsEdit v6 = arg36;
        Intrinsics.checkNotNullParameter(v6, "edit");
        GameProfile v7 = v0.construirPerfilActual();
        View v5 = v1;
        if(((JoystickBlueStacks)v5).getParent() == arg29 && v7 != null) {
            if(!Intrinsics.areEqual(v7.getTargetPackage(), v2)) {
            }
            else {
                GameProfile v2_1 = v0.getProfileStorage().loadResult(v2).getProfile();
                if(v2_1 == null) {
                    List v2_2 = v7.getControls();
                    ArrayList v8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2_2), 10));
                    v2_3 = ((Iterable)v2_2).iterator();
                    while(v2_3.hasNext()) {
                        Object v16 = v2_3.next();
                        if(Intrinsics.areEqual(((ProfileControl)v16).getId(), v3)) {
                            v16_1 = ProfileControl.copy$default(((ProfileControl)v16), null, null, arg34.getX(), arg34.getY(), arg34.getWidth(), arg34.getHeight(), arg35, null, 0x83, null);
                        }

                        ((Collection)v8).add(v16_1);
                    }

                    v2_1 = GameProfile.copy$default(v7, null, null, v8, null, 11, null);
                }

                v2_1 = v0.perfilConGeometria(v2_1, v3, arg32);
                Iterator v7_1 = v2_1.getControls().iterator();
                String v20 = null;
                int v8_1 = 0;
                Object v9 = v20;
                while(true) {
                    if(v7_1.hasNext()) {
                        Object v10 = v7_1.next();
                        if(!Intrinsics.areEqual(v10.getId(), v3)) {
                            continue;
                        }

                        if(v8_1 != 0) {
                            goto label_77;
                        }
                        else {
                            v9 = v10;
                            v8_1 = 1;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_78;
                }

                if(v8_1 == 0) {
                label_77:
                    v9 = v20;
                }

            label_78:
                if(v9 == null || v6.getRadius() == null) {
                    v21 = false;
                    v4_1 = 1;
                    v6 = arg36;
                }
                else {
                    int v7_2 = ((int)(v6.getRadius().floatValue() * 3f));
                    Float v8_2 = v6.getX();
                    float v10_1 = 2f;
                    float v8_3 = v8_2 != null ? v8_2.floatValue() : ((ProfileControl)v9).getX() + (((float)(((ProfileControl)v9).getWidth() - v7_2))) / v10_1;
                    v8_2 = Float.valueOf(v8_3);
                    Float v11 = v6.getY();
                    float v7_3 = v11 != null ? v11.floatValue() : (((float)(((ProfileControl)v9).getHeight() - v7_2))) / v10_1 + ((ProfileControl)v9).getY();
                    v21 = false;
                    Float v4 = v8_2;
                    v8_2 = Float.valueOf(v7_3);
                    Float v7_4 = v4;
                    v4_1 = 1;
                    v6 = JoystickSettingsEdit.copy$default(v6, v7_4, v8_2, null, null, null, null, null, null, null, null, null, 0x7FC, null);
                }

                Object v2_4 = v6.save-0E7RQCE(v2_1, v3, new FloatingService$$ExternalSyntheticLambda5(v0, v3, v1));
                if(Result.isSuccess-impl(v2_4)) {
                    v2_1 = v0.limitarPosicionEnPerfil(((GameProfile)v2_4), v3, v1);
                }

                v2_4 = Result.constructor-impl(v2_4);
                Object v6_1 = Result.isFailure-impl(v2_4) ? v20 : v2_4;
                if(v6_1 == null) {
                    Throwable v1_1 = Result.exceptionOrNull-impl(v2_4);
                    if(v1_1 != null) {
                        v20 = v1_1.getMessage();
                    }

                    Toast.makeText(((Context)v0), "No se pudo guardar JOYSTICK: " + v20, v4_1).show();
                    return v21;
                }

                v2_3 = ((GameProfile)v6_1).getControls().iterator();
                boolean v14 = v21;
                while(true) {
                    if(!v2_3.hasNext()) {
                        goto label_178;
                    }

                    Object v7_5 = v2_3.next();
                    if(!Intrinsics.areEqual(v7_5.getId(), v3)) {
                        continue;
                    }

                    if(v14) {
                        break;
                    }

                    int v14_1 = v4_1;
                    Object v20_1 = v7_5;
                }

                throw new IllegalArgumentException("Collection contains more than one matching element.");
            label_178:
                if(v14) {
                    ViewGroup$LayoutParams v2_5 = ((JoystickBlueStacks)v5).getLayoutParams();
                    v2_5.width = ((ProfileControl)v20).getWidth();
                    v2_5.height = ((ProfileControl)v20).getHeight();
                    ((JoystickBlueStacks)v5).setLayoutParams(v2_5);
                    v0.getEditorGeometry().place(v1, ((ProfileControl)v20).getX(), ((ProfileControl)v20).getY());
                    v2_6 = arg33;
                    v2_6.applyComponent(((ProfileControl)v20).getComponent());
                    v1_2 = arg36.getBindings().entrySet().iterator();
                }
                else {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }

                while(v1_2.hasNext()) {
                    Object v3_1 = v1_2.next();
                    v2_6.updateBinding(((Map$Entry)v3_1).getKey(), ((Map$Entry)v3_1).getValue());
                }

                v0.guardarConfiguracion(v21);
                v0.aplicarPerfilActualAlMotor(((GameProfile)v6_1));
                return ((boolean)v4_1);
            }
        }

        Toast.makeText(((Context)v0), "El JOYSTICK o su perfil ya no están disponibles", 1).show();
        return 0;
    }

    static final Result conectarConfiguracionAvanzada$lambda$287$lambda$279$lambda$274(FloatingService arg1, String arg2, View arg3, GameProfile arg4) {
        Intrinsics.checkNotNullParameter(arg4, "candidate");
        return Result.box-impl(arg1.getProfileStorage().save-IoAF18A(arg1.limitarPosicionEnPerfil(arg4, arg2, arg3)));
    }

    static final boolean conectarConfiguracionAvanzada$lambda$287$lambda$281(BotonVistaBlueStacks arg1, FloatingService arg2, InputBinding arg3) {
        Intrinsics.checkNotNullParameter(arg3, "binding");
        if(arg1 != null && (arg2.guardarBindingVista(arg1, arg3))) {
            return 1;
        }

        return 0;
    }

    static final String conectarConfiguracionAvanzada$lambda$287$lambda$282(FloatingService arg1, View arg2, ControlComponent arg3, ViewComponent arg4) {
        Intrinsics.checkNotNullParameter(arg4, "updated");
        GameProfile v0 = arg1.construirPerfilActual();
        String v2 = arg1.identidadControl(arg2, ((ViewComponent)arg3).getType());
        if(v0 == null) {
            return "No hay un perfil VISTA vigente";
        }

        return arg1.goldenCoreController.vistaSettingsConflict(v0, v2, arg4);
    }

    static final boolean conectarConfiguracionAvanzada$lambda$287$lambda$284(BotonVistaBlueStacks arg1, FloatingService arg2, ComponentPlacement arg3, ViewComponent arg4) {
        Intrinsics.checkNotNullParameter(arg3, "position");
        Intrinsics.checkNotNullParameter(arg4, "updated");
        if(arg1 != null && (arg2.guardarAjustesVista(arg1, arg3, arg4))) {
            return 1;
        }

        return 0;
    }

    static final Unit conectarConfiguracionAvanzada$lambda$287$lambda$285(Function2 arg1, ComponentPlacement arg2, ViewComponent arg3) {
        Intrinsics.checkNotNullParameter(arg2, "updatedPlacement");
        Intrinsics.checkNotNullParameter(arg3, "updatedComponent");
        arg1.invoke(arg2, arg3);
        return Unit.INSTANCE;
    }

    static final Unit conectarConfiguracionAvanzada$lambda$287$lambda$286(Function2 arg1, ComponentPlacement arg2, FireComponent arg3) {
        Intrinsics.checkNotNullParameter(arg2, "updatedPlacement");
        Intrinsics.checkNotNullParameter(arg3, "updatedComponent");
        arg1.invoke(arg2, arg3);
        return Unit.INSTANCE;
    }

    private final void conectarEditorVisualMacro(View arg18, Function0 arg19, View arg20, ProfileComponentControl arg21) {
        FloatingService v1 = this;
        String v0 = v1.targetPackage;
        if(v0 == null) {
            v0 = "com.TryJeanPc.default";
        }

        String v6 = v0;
        Object v0_1 = arg20.getTag();
        SessionOverlayWindows v3 = null;
        Object v7 = (v0_1 instanceof String) ? v0_1 : v3;
        if(v7 == null) {
            return;
        }

        ControlComponent v0_2 = arg21.currentComponent();
        if((v0_2 instanceof MacroScriptComponent)) {
        }
        else {
            v0_2 = ((ControlComponent)v3);
        }

        MacroDraft v15 = v0_2 != null ? ((MacroScriptComponent)v0_2).getMacro() : ((MacroDraft)v3);
        View v9 = arg18;
        v9.setClickable(true);
        IntRef v2 = new IntRef();
        WindowManager$LayoutParams v0_3 = v1.mapeoParams;
        String v4 = "mapeoParams";
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v4);
            v0_3 = ((WindowManager$LayoutParams)v3);
        }

        v2.element = v0_3.flags;
        v0 = v4;
        FloatRef v4_1 = new FloatRef();
        WindowManager$LayoutParams v5 = v1.mapeoParams;
        if(v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0);
            v5 = ((WindowManager$LayoutParams)v3);
        }

        v4_1.element = v5.alpha;
        IntRef v5_1 = new IntRef();
        View v0_4 = v1.mapeoView;
        if(v0_4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v0_4 = ((View)v3);
        }

        v5_1.element = v0_4.getVisibility();
        BooleanRef v0_5 = new BooleanRef();
        SessionOverlayWindows v10 = v1.windowManager;
        if(v10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        }
        else {
            v3 = v10;
        }

        MacroEditorController v8 = new MacroEditorController(v9, v3, new FloatingService$$ExternalSyntheticLambda65(v1), new FloatingService$$ExternalSyntheticLambda67(v0_5, v2, v1, v4_1, v5_1), new FloatingService$$ExternalSyntheticLambda68(v1), arg19, v15, new FloatingService$$ExternalSyntheticLambda69(v1, v6, arg20, v7, arg21));
        v8.connect();
        v1.macroEditorController = v8;
    }

    static final Dialog conectarEditorVisualMacro$lambda$241(FloatingService arg0) {
        return arg0.macroScriptDialog;
    }

    static final Unit conectarEditorVisualMacro$lambda$242(BooleanRef arg4, IntRef arg5, FloatingService arg6, FloatRef arg7, IntRef arg8, boolean arg9) {
        WindowManager$LayoutParams v2_1;
        WindowManager$LayoutParams v4_1;
        View v4;
        View v7;
        String v0 = "mapeoView";
        String v1 = "mapeoParams";
        ViewGroup$LayoutParams v2 = null;
        if(!arg9 || (arg4.element)) {
            if(arg9) {
                goto label_69;
            }

            if(!arg4.element) {
                goto label_69;
            }

            arg4.element = false;
            v4 = arg6.mapeoView;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0);
                v4 = ((View)v2);
            }

            v4.setVisibility(arg8.element);
            v4_1 = arg6.mapeoParams;
            if(v4_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v4_1 = ((WindowManager$LayoutParams)v2);
            }

            v4_1.flags = arg5.element;
            v4_1 = arg6.mapeoParams;
            if(v4_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v4_1 = ((WindowManager$LayoutParams)v2);
            }

            v4_1.alpha = arg7.element;
        }
        else {
            WindowManager$LayoutParams v9 = arg6.mapeoParams;
            if(v9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v9 = ((WindowManager$LayoutParams)v2);
            }

            arg5.element = v9.flags;
            v9 = arg6.mapeoParams;
            if(v9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v9 = ((WindowManager$LayoutParams)v2);
            }

            arg7.element = v9.alpha;
            v7 = arg6.mapeoView;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0);
                v7 = ((View)v2);
            }

            arg8.element = v7.getVisibility();
            arg4.element = true;
            v4 = arg6.mapeoView;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0);
                v4 = ((View)v2);
            }

            v4.setVisibility(4);
            v4_1 = arg6.mapeoParams;
            if(v4_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v4_1 = ((WindowManager$LayoutParams)v2);
            }

            v4_1.flags = arg5.element | 16;
            v4_1 = arg6.mapeoParams;
            if(v4_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v4_1 = ((WindowManager$LayoutParams)v2);
            }

            v4_1.alpha = 0f;
        }

    label_69:
        SessionOverlayWindows v4_2 = arg6.windowManager;
        String v5 = "windowManager";
        if(v4_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v5);
            v4_2 = ((SessionOverlayWindows)v2);
        }

        v7 = arg6.mapeoView;
        if(v7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v0);
            v7 = ((View)v2);
        }

        if(v4_2.isManaged(v7)) {
            v4_2 = arg6.windowManager;
            if(v4_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v5);
                v4_2 = ((SessionOverlayWindows)v2);
            }

            View v5_1 = arg6.mapeoView;
            if(v5_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0);
                v5_1 = ((View)v2);
            }

            WindowManager$LayoutParams v6 = arg6.mapeoParams;
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
            }
            else {
                v2_1 = v6;
            }

            v4_2.updateViewLayout(v5_1, ((ViewGroup$LayoutParams)v2_1));
        }

        return Unit.INSTANCE;
    }

    static final Pair conectarEditorVisualMacro$lambda$243(FloatingService arg0) {
        return arg0.obtenerTamanoRealPantalla();
    }

    static final Result conectarEditorVisualMacro$lambda$246(FloatingService arg4, String arg5, View arg6, String arg7, ProfileComponentControl arg8, MacroDraft arg9) {
        Object v2_1;
        Object v4;
        Intrinsics.checkNotNullParameter(arg9, "draft");
        GameProfile v0 = arg4.construirPerfilActual();
        View v1 = arg4.mapeoView;
        ProfileControl v2 = null;
        if(v1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v1 = ((View)v2);
        }

        v1 = v1.findViewById(id.lienzoMapeo);
        if(v0 == null || !Intrinsics.areEqual(v0.getTargetPackage(), arg5) || arg6.getParent() != v1 || !Intrinsics.areEqual(arg6.getTag(), arg7)) {
            v4 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("El perfil o el componente cambió durante la edición")));
        }
        else {
            v4 = arg4.getProfileStorage().saveMacro-0E7RQCE(v0, arg7, arg9);
            if(Result.isSuccess-impl(v4)) {
                Iterator v4_1 = ((GameProfile)v4).getControls().iterator();
                int v5 = 0;
                while(true) {
                    if(v4_1.hasNext()) {
                        Object v6 = v4_1.next();
                        if(!Intrinsics.areEqual(v6.getId(), arg7)) {
                            continue;
                        }

                        if(v5 == 0) {
                            v5 = 1;
                            v2_1 = v6;
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        goto label_44;
                    }

                    goto label_53;
                }

                throw new IllegalArgumentException("Collection contains more than one matching element.");
            label_44:
                if(v5 != 0) {
                    arg8.applyComponent(((ProfileControl)v2_1).getComponent());
                    Unit v4_2 = Unit.INSTANCE;
                }
                else {
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }

        label_53:
            v4 = Result.constructor-impl(v4);
        }

        return Result.box-impl(v4);
    }

    private final void conectarModosVisualesMacroScript(View arg4, int[] arg5) {
        ArrayList v3 = new ArrayList(arg5.length);
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            ((Collection)v3).add(arg4.findViewById(arg5[v1]));
        }

        ColorStateList v4 = CollectionsKt.first(((List)v3)).getTextColors();
        ColorStateList v5 = ((List)v3).get(1).getTextColors();
        Iterator v0_1 = v3.iterator();
        while(v0_1.hasNext()) {
            Object v1_1 = v0_1.next();
            ((TextView)v1_1).setOnClickListener(new FloatingService$$ExternalSyntheticLambda6(((TextView)v1_1), ((List)v3), v4, v5));
        }

        Object v0_2 = CollectionsKt.first(((List)v3));
        Intrinsics.checkNotNullExpressionValue(v0_2, "first(...)");
        FloatingService.conectarModosVisualesMacroScript$seleccionarModo(((List)v3), v4, v5, ((TextView)v0_2));
    }

    static final void conectarModosVisualesMacroScript$lambda$251$lambda$250(TextView arg0, List arg1, ColorStateList arg2, ColorStateList arg3, View arg4) {
        Intrinsics.checkNotNull(arg0);
        FloatingService.conectarModosVisualesMacroScript$seleccionarModo(arg1, arg2, arg3, arg0);
    }

    private static final void conectarModosVisualesMacroScript$seleccionarModo(List arg2, ColorStateList arg3, ColorStateList arg4, TextView arg5) {
        Iterator v2 = ((Iterable)arg2).iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            boolean v1 = (((TextView)v0)) == arg5 ? true : false;
            ((TextView)v0).setSelected(v1);
            ColorStateList v1_1 = ((TextView)v0).isSelected() ? arg3 : arg4;
            ((TextView)v0).setTextColor(v1_1);
        }
    }

    private final void configurarSliders() {
        FloatingService v9 = this;
        Function0 v0 = v9.refrescarSlidersHud;
        if(v0 != null) {
            v0.invoke();
            return;
        }

        View v0_1 = v9.hudView;
        String v1 = "hudView";
        ViewParent v2 = null;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0_1 = ((View)v2);
        }

        View v8 = v0_1.findViewById(id.sliderBrightness);
        ViewParent v0_2 = v8 != null ? v8.getParent() : v2;
        ViewParent v4 = (v0_2 instanceof View) ? v0_2 : v2;
        v0_1 = v9.hudView;
        if(v0_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0_1 = ((View)v2);
        }

        View v5 = v0_1.findViewById(id.sliderVolume);
        v0_2 = v5 != null ? v5.getParent() : v2;
        if((v0_2 instanceof View)) {
            v2 = v0_2;
        }

        ViewParent v3 = v2;
        Object v0_3 = v9.getSystemService("audio");
        Intrinsics.checkNotNull(v0_3, "null cannot be cast to non-null type android.media.AudioManager");
        Object v2_1 = v0_3;
        IntRef v1_1 = new IntRef();
        Rect v15 = new Rect();
        int v6 = 10;
        if(v3 != null) {
            ((View)v3).setOnTouchListener(new FloatingService$$ExternalSyntheticLambda110(v2_1, v1_1, v5, v6, v15));
        }

        if(v4 != null) {
            ((View)v4).setOnTouchListener(new FloatingService$$ExternalSyntheticLambda111(v9, v8, v6, v15));
        }

        FloatingService$$ExternalSyntheticLambda112 v0_4 = new FloatingService$$ExternalSyntheticLambda112(v1_1, ((AudioManager)v2_1), ((View)v3), ((View)v4), v5, v6, v15, v8, v9);
        v9.refrescarSlidersHud = ((Function0)v0_4);
        ((Function0)v0_4).invoke();
    }

    private static final void configurarSliders$actualizarNivel(int arg1, Rect arg2, View arg3, float arg4) {
        if(arg3 == null) {
            return;
        }

        arg3.post(new FloatingService$$ExternalSyntheticLambda157(arg3, arg4, arg1, arg2));
    }

    static final void configurarSliders$actualizarNivel$lambda$211(View arg3, float arg4, int arg5, Rect arg6) {
        if(arg3.getWidth() > 0) {
            if(arg3.getHeight() <= 0) {
            }
            else {
                float v0 = ((float)arg5);
                int v4 = RangesKt.coerceIn(arg3.getHeight() - (((int)((((float)arg3.getHeight())) * (((float)RangesKt.coerceIn(((int)(((float)Math.floor(((double)(RangesKt.coerceIn(arg4, 0f, 1f) * v0)))))), 0, arg5))) / v0))), 0, arg3.getHeight());
                if((arg3.getClipBounds(arg6)) && arg6.left == 0 && arg6.top == v4 && arg6.right == arg3.getWidth() && arg6.bottom == arg3.getHeight()) {
                    return;
                }

                arg6.set(0, v4, arg3.getWidth(), arg3.getHeight());
                arg3.setClipBounds(arg6);
            }
        }
    }

    static final boolean configurarSliders$lambda$212(AudioManager arg4, IntRef arg5, View arg6, int arg7, Rect arg8, View arg9, MotionEvent arg10) {
        if(arg9.getHeight() <= 0) {
            return 1;
        }

        int v0 = arg10.getActionMasked();
        if(v0 != 0 && v0 != 1 && v0 != 2) {
            return 0;
        }

        float v9 = RangesKt.coerceIn(1f - arg10.getY() / (((float)arg9.getHeight())), 0f, 1f);
        arg4.setStreamVolume(3, RangesKt.coerceIn(((int)((((float)arg5.element)) * v9)), 0, arg5.element), 0);
        FloatingService.configurarSliders$actualizarNivel(arg7, arg8, arg6, v9);
        return 1;
    }

    static final boolean configurarSliders$lambda$214(FloatingService arg5, View arg6, int arg7, Rect arg8, View arg9, MotionEvent arg10) {
        FloatingService v0 = arg5;
        if(!Settings$System.canWrite(((Context)v0))) {
            if(arg10.getActionMasked() == 1) {
                Toast.makeText(((Context)v0), "Permite a Golden Mouse cambiar el brillo", 1).show();
                Intent v6 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                v6.setData(Uri.parse("package:" + arg5.getPackageName()));
                v6.addFlags(0x10000000);
                arg5.startActivity(v6);
            }

            return 1;
        }

        if(arg9.getHeight() <= 0) {
            return 1;
        }

        int v0_1 = arg10.getActionMasked();
        if(v0_1 != 0 && v0_1 != 1 && v0_1 != 2) {
            return 0;
        }

        float v9 = RangesKt.coerceIn(1f - arg10.getY() / (((float)arg9.getHeight())), 0.05f, 1f);
        v0_1 = RangesKt.coerceIn(((int)(255f * v9)), 13, 0xFF);
        FloatingService.configurarSliders$actualizarNivel(arg7, arg8, arg6, v9);
        if(arg10.getActionMasked() == 1) {
            try {
            label_53:
                Settings$System.putInt(arg5.getContentResolver(), "screen_brightness_mode", 0);
                Settings$System.putInt(arg5.getContentResolver(), "screen_brightness", v0_1);
                return 1;
            }
            catch(Exception ) {
                return 1;
            }
        }
        else if(v0_1 != -1) {
            goto label_53;
        }

        return 1;
    }

    static final Unit configurarSliders$lambda$217(IntRef arg7, AudioManager arg8, View arg9, View arg10, View arg11, int arg12, Rect arg13, View arg14, FloatingService arg15) {
        Rect v6;
        int v5;
        arg7.element = arg8.getStreamMaxVolume(3);
        if(arg9 != null) {
            v5 = arg12;
            v6 = arg13;
            arg9.post(new FloatingService$$ExternalSyntheticLambda155(arg11, arg7, arg8, v5, v6));
        }
        else {
            v5 = arg12;
            v6 = arg13;
        }

        if(arg10 != null) {
            arg10.post(new FloatingService$$ExternalSyntheticLambda156(arg14, arg15, v5, v6));
        }

        return Unit.INSTANCE;
    }

    static final void configurarSliders$lambda$217$lambda$215(View arg1, IntRef arg2, AudioManager arg3, int arg4, Rect arg5) {
        float v3 = arg2.element > 0 ? (((float)arg3.getStreamVolume(3))) / (((float)arg2.element)) : 0f;
        FloatingService.configurarSliders$actualizarNivel(arg4, arg5, arg1, v3);
    }

    static final void configurarSliders$lambda$217$lambda$216(View arg2, FloatingService arg3, int arg4, Rect arg5) {
        try {
            FloatingService.configurarSliders$actualizarNivel(arg4, arg5, arg2, RangesKt.coerceIn((((float)Settings$System.getInt(arg3.getContentResolver(), "screen_brightness"))) / 255f, 0.05f, 1f));
            return;
        }
        catch(Exception ) {
            FloatingService.configurarSliders$actualizarNivel(arg4, arg5, arg2, 0.5f);
            return;
        }
    }

    private final GameProfile construirPerfilActual() {
        int v17;
        int v8_1;
        int v16;
        View v8;
        FloatingService v0 = this;
        String v1 = v0.targetPackage;
        if(v1 == null) {
            v1 = "com.TryJeanPc.default";
        }

        View v2 = v0.mapeoView;
        GameProfile v3 = null;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v2 = ((View)v3);
        }

        v2 = v2.findViewById(id.lienzoMapeo);
        if(v2 == null) {
            return v3;
        }

        List v4 = CollectionsKt.createListBuilder();
        int v5 = ((FrameLayout)v2).getChildCount();
        int v7;
        for(v7 = 0; v7 < v5; ++v7) {
            v8 = ((FrameLayout)v2).getChildAt(v7);
            if((v8 instanceof ControlVisual)) {
                View v9 = (v8 instanceof ProfileComponentControl) ? v8 : ((View)v3);
                if(v9 == null) {
                    goto label_84;
                }

                ControlVisualState v10 = v0.getEditorGeometry().snapshot(v8, false);
                ControlComponent v19 = ((ProfileComponentControl)v9).currentComponent();
                String v12 = v0.identidadControl(v8, v19.getType());
                String v13 = v19.getType();
                float v14 = v10.getX();
                float v15 = v10.getY();
                Integer v11 = Integer.valueOf(v10.getWidth());
                if(v11.intValue() > 0) {
                }
                else {
                    v11 = ((Integer)v3);
                }

                if(v11 == null) {
                    ViewGroup$LayoutParams v11_1 = v8.getLayoutParams();
                    v11 = v11_1 != null ? Integer.valueOf(RangesKt.coerceAtLeast(v11_1.width, 0)) : ((Integer)v3);
                    if(v11 == null) {
                        goto label_57;
                    }

                    goto label_45;
                }
                else {
                label_45:
                    v16 = v11.intValue();
                    goto label_58;
                label_57:
                    v16 = 0;
                }

            label_58:
                Integer v10_1 = Integer.valueOf(v10.getHeight());
                if(v10_1.intValue() > 0) {
                }
                else {
                    v10_1 = ((Integer)v3);
                }

                if(v10_1 != null) {
                    v8_1 = v10_1.intValue();
                    goto label_67;
                }
                else {
                    ViewGroup$LayoutParams v8_2 = v8.getLayoutParams();
                    Integer v8_3 = v8_2 != null ? Integer.valueOf(RangesKt.coerceAtLeast(v8_2.height, 0)) : ((Integer)v3);
                    if(v8_3 != null) {
                        v8_1 = v8_3.intValue();
                    label_67:
                        v17 = v8_1;
                        goto label_80;
                    }

                    v17 = 0;
                }

            label_80:
                v4.add(new ProfileControl(v12, v13, v14, v15, v16, v17, ((ProfileComponentControl)v9).currentBindings(), v19));
            }

        label_84:
        }

        v4 = CollectionsKt.build(v4);
        IntRange v5_1 = RangesKt.until(0, ((FrameLayout)v2).getChildCount());
        ArrayList v7_1 = new ArrayList();
        Iterator v5_2 = ((Iterable)v5_1).iterator();
        while(v5_2.hasNext()) {
            v8 = ((FrameLayout)v2).getChildAt(v5_2.nextInt());
            if((v8 instanceof VistaLibreVisual)) {
            }
            else {
                v8 = ((View)v3);
            }

            VistaLibreMarker v8_4 = v8 == null ? ((VistaLibreMarker)v3) : ((VistaLibreVisual)v8).marcadorGuardado(v0.getEditorGeometry().snapshot(v8, false));
            if(v8_4 == null) {
                continue;
            }

            ((Collection)v7_1).add(v8_4);
        }

        return new GameProfile(v1, v1, v4, ((List)v7_1));
    }

    private final String convertirTipoLegacy(String arg1) {
        String v0 = ControlVisualFactory.INSTANCE.normalizarTipo(arg1);
        switch(v0.hashCode()) {
            case -155485892: {
                arg1 = "JOYSTICK";
                if(!v0.equals(arg1)) {
                    return null;
                }

                return arg1;
            }
            case 1980540961: {
                if(!v0.equals("CAMARA")) {
                    return null;
                }

                return "VISTA";
            }
            case -1905230500: {
                arg1 = "DISPARO";
                if(!v0.equals(arg1)) {
                    return null;
                }

                return arg1;
            }
            case 82819: {
                if(v0.equals("TAP")) {
                    return "TOCAR";
                }

                break;
            }
            default: {
                break;
            }
        }

        return null;
    }

    private final View crearControlArrastrable(FrameLayout arg19, String arg20, Float arg21, Float arg22, String arg23, int arg24, int arg25) {
        VistaLibreVisual v2_2;
        FloatingService v1_2;
        VistaLibreVisual v4;
        FrameLayout v9 = arg19;
        String v0 = arg20;
        Float v15 = arg22;
        int v1 = arg24;
        int v2 = arg25;
        float v3 = 3.402823E+38f;
        View v16 = null;
        if(arg21 != null && Math.abs(arg21.floatValue()) > v3) {
            return v16;
        }
        else if(v15 != null) {
            if(Math.abs(v15.floatValue()) <= v3) {
            }
            else {
                return v16;
            }
        }

        Context v3_1 = v9.getContext();
        if(Intrinsics.areEqual(v0, "VISTA_LIBRE_VISUAL")) {
            Intrinsics.checkNotNull(v3_1);
            v4 = new VistaLibreVisual(v3_1);
        }
        else {
            ControlVisualFactory v4_1 = ControlVisualFactory.INSTANCE;
            Intrinsics.checkNotNull(v3_1);
            View v4_2 = v4_1.crear(v3_1, v0);
        }

        String v3_2 = "Tipo omitido: ";
        String v6 = "GOLDEN_CONFIG";
        if(v4 == null) {
            Log.w(v6, v3_2 + v0);
            return v16;
        }

        VistaLibreVisual v11 = (v4 instanceof ControlVisual) ? v4 : ((VistaLibreVisual)v16);
        if(v11 == null) {
            Log.w(v6, v3_2 + v0);
            return v16;
        }

        ViewGroup$LayoutParams v0_1 = ((View)v4).getLayoutParams();
        if(v0_1 != null) {
            if(((v4 instanceof JoystickBlueStacks)) || (Intrinsics.areEqual(((ControlVisual)v11).obtenerTipo(), "MACRO_SCRIPT"))) {
                if(v1 > 0) {
                    v0_1.width = v1;
                }

                if(v2 <= 0) {
                    goto label_62;
                }

                v0_1.height = v2;
            }

        label_62:
            ((View)v4).setLayoutParams(v0_1);
        }

        IntRange v0_2 = RangesKt.until(0, v9.getChildCount());
        ArrayList v1_1 = new ArrayList();
        Iterator v0_3 = ((Iterable)v0_2).iterator();
        while(v0_3.hasNext()) {
            Object v2_1 = v9.getChildAt(v0_3.nextInt()).getTag();
            if((v2_1 instanceof String)) {
            }
            else {
                v2_1 = v16;
            }

            if(v2_1 == null) {
                continue;
            }

            ((Collection)v1_1).add(v2_1);
        }

        Object v0_4 = ((View)v4).getTag();
        if((v0_4 instanceof String)) {
        }
        else {
            v0_4 = v16;
        }

        if(v0_4 == null || (StringsKt.isBlank(((CharSequence)v0_4))) || (CollectionsKt.contains(v1_1, ((View)v4).getTag()))) {
            ((View)v4).setTag(ProfileIdentities.INSTANCE.fresh(((ControlVisual)v11).obtenerTipo(), ((Collection)v1_1)));
        }

        VistaLibreVisual v12 = (v11 instanceof ControlEliminable) ? v11 : ((VistaLibreVisual)v16);
        if(v12 != null) {
            v1_2 = this;
            v2_2 = v4;
            ((ControlEliminable)v12).establecerOnEliminar(new FloatingService$$ExternalSyntheticLambda86(v1_2, ((View)v2_2), v9, v12, v11));
        }
        else {
            v1_2 = this;
            v2_2 = v4;
        }

        FloatRef v4_3 = new FloatRef();
        FloatRef v5 = new FloatRef();
        v0 = v6;
        FloatRef v6_1 = new FloatRef();
        FloatRef v7 = new FloatRef();
        BooleanRef v8 = new BooleanRef();
        int[] v10 = new int[2];
        BooleanRef v3_3 = new BooleanRef();
        boolean v13 = v1_2.usaDobleClicEditor(((View)v2_2));
        VistaLibreVisual v14 = v2_2;
        FloatingService v2_3 = v1_2;
        VistaLibreVisual v1_3 = v14;
        String v14_1 = v0;
        v9 = arg19;
        FloatingService$$ExternalSyntheticLambda87 v0_5 = new FloatingService$$ExternalSyntheticLambda87(((View)v1_3), v2_3, v3_3, v4_3, v5, v6_1, v7, v8, v9, v10, ((ControlVisual)v11), ((ControlEliminable)v12), v13);
        FloatingService v17 = v2_3;
        v2_2 = v1_3;
        v1_2 = v17;
        ((View)v2_2).setOnTouchListener(((View$OnTouchListener)v0_5));
        v9.addView(((View)v2_2));
        v1_2.aplicarEstiloAControl(((ControlVisual)v11), ((View)v2_2));
        if((v2_2 instanceof ProfileComponentControl)) {
            VistaLibreVisual v16_1 = v2_2;
        }

        VistaLibreVisual v0_6 = ((VistaLibreVisual)v16);
        if(v0_6 != null) {
            v1_2.conectarConfiguracionAvanzada(((View)v2_2), ((ProfileComponentControl)v0_6));
        }

        if((v2_2 instanceof VistaLibreVisual)) {
            v2_2.setOnConfigure(new FloatingService$$ExternalSyntheticLambda89(v1_2, ((View)v2_2), v9));
        }

        Log.d(v14_1, "Control creado: tipo=" + ((ControlVisual)v11).obtenerTipo());
        v1_2.getEditorGeometry().bind(((View)v2_2), arg21, v15);
        v0 = StringsKt.trim(arg23).toString();
        if(((v2_2 instanceof ControlConTecla)) && v0.length() > 0) {
            v2_2.actualizarTecla(v0);
            Log.d(v14_1, "Tecla restaurada: " + v2_2.obtenerTeclaActual());
        }

        return ((View)v2_2);
    }

    static View crearControlArrastrable$default(FloatingService arg1, FrameLayout arg2, String arg3, Float arg4, Float arg5, String arg6, int arg7, int arg8, int arg9, Object arg10) {
        Float v0 = null;
        if((arg9 & 4) != 0) {
            arg4 = v0;
        }

        if((arg9 & 8) != 0) {
            arg5 = v0;
        }

        if((arg9 & 16) != 0) {
            arg6 = "";
        }

        return arg1.crearControlArrastrable(arg2, arg3, arg4, arg5, arg6, 0, 0);
    }

    static final Unit crearControlArrastrable$lambda$222(FloatingService arg10, View arg11, FrameLayout arg12, ControlEliminable arg13, ControlVisual arg14) {
        ViewGroup$LayoutParams v0_4;
        Throwable v11;
        Object v0_1;
        if(arg10.solicitarReparacionIds()) {
            return Unit.INSTANCE;
        }

        arg10.getDobleClicEditor().reset();
        String v2 = null;
        if((arg11 instanceof VistaLibreVisual)) {
            GameProfile v3 = arg10.construirPerfilActual();
            if(v3 == null) {
                return Unit.INSTANCE;
            }

            List v14 = v3.getVisualControls();
            ArrayList v0 = new ArrayList();
            Iterator v14_1 = ((Iterable)v14).iterator();
            while(v14_1.hasNext()) {
                Object v4 = v14_1.next();
                if(Intrinsics.areEqual(v4.getId(), arg11.getTag())) {
                    continue;
                }

                ((Collection)v0).add(v4);
            }

            GameProfile v14_2 = GameProfile.copy$default(v3, null, null, null, v0, 7, null);
            v0_1 = arg10.getProfileStorage().saveFreeLookProfile-IoAF18A(v14_2);
            if(Result.isFailure-impl(v0_1)) {
                v11 = Result.exceptionOrNull-impl(v0_1);
                if(v11 != null) {
                    v2 = v11.getMessage();
                }

                Toast.makeText(((Context)arg10), "No se pudo eliminar Vista libre: " + v2, 1).show();
                return Unit.INSTANCE;
            }

            if(arg10.controlSeleccionado == arg11) {
                arg10.ocultarVistaEliminar();
                arg10.deseleccionarControl();
            }

            arg12.removeView(arg11);
            arg13.establecerOnEliminar(((Function0)v2));
            ((VistaLibreVisual)arg11).setOnConfigure(((Function0)v2));
            arg10.aplicarPerfilActualAlMotor(v14_2);
            return Unit.INSTANCE;
        }

        if(Intrinsics.areEqual(arg14.obtenerTipo(), "MACRO_SCRIPT")) {
            GameProfile v0_2 = arg10.construirPerfilActual();
            Object v3_1 = arg11.getTag();
            if((v3_1 instanceof String)) {
            }
            else {
                v3_1 = v2;
            }

            v0_1 = v0_2 == null || v3_1 == null ? Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Perfil o ID del componente no disponible"))) : arg10.getProfileStorage().deleteMacroComponent-gIAlu-s(v0_2, ((String)v3_1));
            if(!Result.isFailure-impl(v0_1)) {
                goto label_97;
            }

            v11 = Result.exceptionOrNull-impl(v0_1);
            if(v11 != null) {
                v2 = v11.getMessage();
            }

            Toast.makeText(((Context)arg10), "No se pudo eliminar Macro-Script: " + v2, 1).show();
            return Unit.INSTANCE;
        }

    label_97:
        if(arg10.botonEnEdicion == arg11) {
            FloatingService.cerrarEditorTecla$default(arg10, false, 1, v2);
        }

        arg10.ocultarVistaEliminar();
        arg10.deseleccionarControl();
        arg12.removeView(arg11);
        arg13.establecerOnEliminar(((Function0)v2));
        WindowManager$LayoutParams v11_1 = arg10.mapeoParams;
        String v12 = "mapeoParams";
        if(v11_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v12);
            v11_1 = ((WindowManager$LayoutParams)v2);
        }

        WindowManager$LayoutParams v13 = arg10.mapeoParams;
        if(v13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v12);
            v13 = ((WindowManager$LayoutParams)v2);
        }

        v11_1.flags = v13.flags | 8;
        SessionOverlayWindows v11_2 = arg10.windowManager;
        if(v11_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            v11_2 = ((SessionOverlayWindows)v2);
        }

        View v13_1 = arg10.mapeoView;
        if(v13_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v13_1 = ((View)v2);
        }

        WindowManager$LayoutParams v0_3 = arg10.mapeoParams;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v12);
            v0_4 = ((ViewGroup$LayoutParams)v2);
        }

        v11_2.updateViewLayout(v13_1, v0_4);
        FloatingService.guardarConfiguracion$default(arg10, false, 1, v2);
        FloatingService.aplicarPerfilActualAlMotor$default(arg10, ((GameProfile)v2), 1, v2);
        Log.d("GOLDEN_UI", "Control eliminado tipo=" + arg14.obtenerTipo());
        return Unit.INSTANCE;
    }

    static final boolean crearControlArrastrable$lambda$224(View arg20, FloatingService arg21, BooleanRef arg22, FloatRef arg23, FloatRef arg24, FloatRef arg25, FloatRef arg26, BooleanRef arg27, FrameLayout arg28, int[] arg29, ControlVisual arg30, ControlEliminable arg31, boolean arg32, View arg33, MotionEvent arg34) {
        int v16;
        int v14;
        float v3_1;
        String v15;
        View v0 = arg20;
        FloatingService v1 = arg21;
        BooleanRef v2 = arg22;
        FloatRef v3 = arg23;
        FloatRef v4 = arg24;
        FloatRef v5 = arg25;
        FloatRef v6 = arg26;
        BooleanRef v7 = arg27;
        FrameLayout v8 = arg28;
        ControlVisual v9 = arg30;
        ControlEliminable v10 = arg31;
        View v11 = arg33;
        MotionEvent v12 = arg34;
        boolean v13 = v0 instanceof BotonVistaBlueStacks;
        if(v13) {
            Intrinsics.checkNotNull(v12);
            if(v0.handleSensitivityArrowTouch$app(v12)) {
                v1.getDobleClicEditor().reset();
                return 1;
            }
        }

        if((v0 instanceof VistaLibreVisual)) {
            v15 = null;
        }
        else {
            com.TryJeanPc.goldenmouse.controls.TeclaEditorView$Companion v15_1 = TeclaEditorView.Companion;
            Intrinsics.checkNotNull(v12);
            v15 = v15_1.resolverNombreBotonRaton(v12);
        }

        if(v15 != null && v1.botonEnEdicion != null) {
            v1.getDobleClicEditor().reset();
            v2.element = true;
            v1.registrarEntradaDelEditor(v15);
            return 1;
        }

        boolean v17 = v13;
        if(v2.element) {
            if(v12.getActionMasked() == 1 || v12.getActionMasked() == 3 || v12.getActionMasked() == 6) {
                v2.element = false;
            }

            return 1;
        }

        int v2_1 = v12.getActionMasked();
        int v13_1 = 2;
        float v19 = 2f;
        if(v2_1 != 0) {
            if(v2_1 != 1) {
                if(v2_1 != v13_1) {
                    if(v2_1 != 3 && v2_1 != 5 && v2_1 != 6) {
                        return 0;
                    }

                    v1.getDobleClicEditor().reset();
                    return 0;
                }

                if(arg32) {
                    if(v12.getPointerCount() != 1) {
                        v1.getDobleClicEditor().reset();
                    }
                    else {
                        v1.getDobleClicEditor().move(v12.getRawX(), v12.getRawY());
                    }
                }

                float v2_2 = Math.abs(v12.getRawX() - v5.element);
                float v5_1 = 10f;
                if(v2_2 > v5_1 || Math.abs(v12.getRawY() - v6.element) > v5_1) {
                    v7.element = true;
                    v2_2 = v12.getRawX() - (((float)arg29[0])) - v3.element;
                    v3_1 = v12.getRawY() - (((float)arg29[1])) - v4.element;
                    EditorControlGeometry v4_1 = v1.getEditorGeometry();
                    Intrinsics.checkNotNull(v11);
                    v4_1.moveLocal(v11, v2_2, v3_1);
                    if(v1.vistaControlEliminableSeleccionado == v11) {
                        v1.posicionarVistaEliminar(v8, v11);
                    }

                    if(v1.teclaEditorView == null) {
                        return 1;
                    }

                    if(v1.botonEnEdicion != v0) {
                        return 1;
                    }

                    float v0_1 = v11.getResources().getDisplayMetrics().density;
                    v2_1 = ((int)(30f * v0_1));
                    float v4_2 = 38f;
                    v3_1 = v11.getWidth() > 0 ? ((float)v11.getWidth()) : v0_1 * v4_2;
                    if(v11.getHeight() > 0) {
                        v0_1 = ((float)v11.getHeight());
                    }
                    else {
                        v0_1 *= v4_2;
                    }

                    TeclaEditorView v4_3 = v1.teclaEditorView;
                    if(v4_3 != null) {
                        v4_3.setX(v11.getX() + (v3_1 - (((float)v2_1))) / v19);
                    }

                    TeclaEditorView v1_1 = v1.teclaEditorView;
                    if(v1_1 == null) {
                        return 1;
                    }

                    v1_1.setY(v11.getY() + (v0_1 - (((float)v2_1))) / v19);
                }

                return 1;
            }

            if(arg32) {
                v1.getDobleClicEditor().move(v12.getRawX(), v12.getRawY());
                if((v7.element) || v12.getPointerCount() != 1 || !v1.isMapeoVisible || v1.controlSeleccionado != v9 || v11.getParent() != v8) {
                    v1.getDobleClicEditor().reset();
                }

                if(!v1.getDobleClicEditor().up(v12.getEventTime())) {
                    return 1;
                }

                if(!(v0 instanceof ControlConTecla)) {
                    return 1;
                }

                v1.abrirEditorTecla(((ControlConTecla)v0));
            }
            else {
                if(v7.element) {
                    return 1;
                }

                if(!(v0 instanceof ControlConTecla)) {
                    return 1;
                }

                if((v0 instanceof BotonDisparoBlueStacks)) {
                    return 1;
                }

                v1.abrirEditorTecla(((ControlConTecla)v0));
            }

            return 1;
        }

        int[] v2_3 = new int[v13_1];
        v11.getLocationOnScreen(v2_3);
        v3.element = v12.getRawX() - (((float)v2_3[0]));
        v4.element = v12.getRawY() - (((float)v2_3[1]));
        v5.element = v12.getRawX();
        v6.element = v12.getRawY();
        v7.element = false;
        arg28.getLocationOnScreen(arg29);
        if(v0 != v1.vistaControlEliminableSeleccionado) {
            v1.ocultarVistaEliminar();
        }

        v1.seleccionarControl(v9);
        if(v10 != null) {
            v1.mostrarVistaEliminar(v8, v0, v10);
        }

        if(arg32) {
            v3_1 = v11.getResources().getDisplayMetrics().density * 20f;
            int v3_2 = !v17 || (((float)Math.hypot(((double)(v12.getX() - (((float)v11.getWidth())) / v19)), ((double)(v12.getY() - (((float)v11.getHeight())) / v19))))) <= v3_1 ? 1 : 0;
            if(v12.isFromSource(0x2002)) {
                v14 = 1;
                if(v12.getButtonState() == 1) {
                    goto label_254;
                }
                else {
                    v16 = 0;
                }
            }
            else {
                v14 = 1;
            label_254:
                v16 = v14;
            }

            if((v1.isMapeoVisible) && v3_2 != 0 && v16 != 0 && v15 == null && v12.getPointerCount() == v14) {
                v1.getDobleClicEditor().down(new Press(v0, v1.targetPackage, v12.getEventTime(), v12.getRawX(), v12.getRawY(), v12.getSource(), v12.getDeviceId()));
                return 1;
            }

            v1.getDobleClicEditor().reset();
        }

        return 1;
    }

    static final Unit crearControlArrastrable$lambda$232(FloatingService arg9, View arg10, FrameLayout arg11) {
        FloatingService.cerrarEditorTecla$default(arg9, false, 1, null);
        String v7 = arg9.targetPackage;
        Object v0 = arg10.getTag();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.String");
        arg9.mostrarVentanaMacroScript(layout.configurar_vista_libre, new FloatingService$$ExternalSyntheticLambda91(arg10, arg9, v0, v7, arg11));
        return Unit.INSTANCE;
    }

    static final Unit crearControlArrastrable$lambda$232$lambda$231(View arg6, FloatingService arg7, String arg8, String arg9, FrameLayout arg10, View arg11, Function0 arg12) {
        Intrinsics.checkNotNullParameter(arg11, "root");
        Intrinsics.checkNotNullParameter(arg12, "cerrar");
        arg6.conectarPanel(arg11, new FloatingService$$ExternalSyntheticLambda19(arg7, arg8, arg9, arg6, arg10), new FloatingService$crearControlArrastrable$5$1$2(arg7.goldenCoreController), new FloatingService$$ExternalSyntheticLambda20(arg7, arg9, arg6, arg10, arg8), arg12);
        return Unit.INSTANCE;
    }

    static final boolean crearControlArrastrable$lambda$232$lambda$231$lambda$229(FloatingService arg8, String arg9, String arg10, View arg11, FrameLayout arg12) {
        Object v9;
        InputBinding v3_2;
        GameProfile v0 = arg8.construirPerfilActual();
        String v2 = null;
        if(v0 != null) {
            List v3 = v0.getVisualControls();
            if(v3 != null) {
                Iterator v3_1 = ((Iterable)v3).iterator();
                int v4 = 0;
                Object v5 = v2;
                while(true) {
                    if(v3_1.hasNext()) {
                        Object v6 = v3_1.next();
                        if(!Intrinsics.areEqual(v6.getId(), arg9)) {
                            continue;
                        }

                        if(v4 != 0) {
                            goto label_22;
                        }
                        else {
                            v4 = 1;
                            v5 = v6;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_23;
                }

                if(v4 == 0) {
                label_22:
                    v5 = v2;
                }

            label_23:
                if(v5 == null) {
                    goto label_26;
                }

                v3_2 = ((VistaLibreMarker)v5).getActivationBinding();
            }
            else {
                goto label_26;
            }
        }
        else {
        label_26:
            v3_2 = ((InputBinding)v2);
        }

        if(v0 != null && v3_2 != null) {
            v2 = arg8.goldenCoreController.freeLookBindingConflict(v0, arg9, v3_2);
        }

        if(v0 == null || !Intrinsics.areEqual(arg8.targetPackage, arg10) || ((VistaLibreVisual)arg11).getParent() != arg12) {
            v9 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("El perfil o el marcador cambió durante la edición")));
        }
        else if(v2 != null) {
            v9 = Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException(v2)));
        }
        else {
            v9 = arg8.getProfileStorage().saveFreeLookProfile-IoAF18A(v0);
        }

        if((Result.isSuccess-impl(v9)) && v0 != null) {
            arg8.aplicarPerfilActualAlMotor(v0);
        }

        Throwable v10 = Result.exceptionOrNull-impl(v9);
        if(v10 != null) {
            Toast.makeText(((Context)arg8), "No se pudo guardar Vista libre: " + v10.getMessage(), 1).show();
        }

        return Result.isSuccess-impl(v9);
    }

    static final String crearControlArrastrable$lambda$232$lambda$231$lambda$230(FloatingService arg2, String arg3, View arg4, FrameLayout arg5, String arg6, InputBinding arg7) {
        Intrinsics.checkNotNullParameter(arg7, "binding");
        GameProfile v0 = arg2.construirPerfilActual();
        if(v0 != null && (Intrinsics.areEqual(arg2.targetPackage, arg3))) {
            if(((VistaLibreVisual)arg4).getParent() != arg5) {
            }
            else {
                return arg2.goldenCoreController.freeLookBindingConflict(v0, arg6, arg7);
            }
        }

        return "El perfil o el marcador cambió durante la captura";
    }

    static final DecorativeAnimationPreferences decorativeOptions_delegate$lambda$5(FloatingService arg2) {
        SharedPreferences v2 = arg2.getDecorativePreferences();
        Intrinsics.checkNotNullExpressionValue(v2, "<get-decorativePreferences>(...)");
        return new DecorativeAnimationPreferences(v2);
    }

    static final void decorativePreferenceListener$lambda$7(FloatingService arg0, SharedPreferences arg1, String arg2) {
        arg0.mainHandler.post(new FloatingService$$ExternalSyntheticLambda39(arg0));
    }

    static final void decorativePreferenceListener$lambda$7$lambda$6(FloatingService arg1) {
        if((arg1.isActive) && arg1.hudView != null) {
            arg1.aplicarAnimacionesDecorativas();
        }
    }

    static final SharedPreferences decorativePreferences_delegate$lambda$4(FloatingService arg2) {
        return arg2.getSharedPreferences("decorative_animations", 0);
    }

    private final void deseleccionarControl() {
        this.getDobleClicEditor().reset();
        ControlVisual v0 = this.controlSeleccionado;
        if(v0 != null) {
            v0.deseleccionar();
        }

        this.controlSeleccionado = null;
    }

    private final void detenerMonitoreo(Long arg4) {
        VisualWorkSession v0 = this.hudVisualSession;
        if(arg4 == null) {
            v0.stop();
        }
        else if(!v0.stop(arg4.longValue())) {
            return;
        }

        Function0 v4 = null;
        this.updateHudAnimationOptions = v4;
        BlueMagicVisualModeController v0_1 = this.blueMagicVisualMode;
        if(v0_1 != null) {
            v0_1.cancelAnimation();
        }

        Iterator v0_2 = this.hudRingStarts.iterator();
        while(v0_2.hasNext()) {
            Object v1 = v0_2.next();
            ((Pair)v1).component1().removeCallbacks(((Pair)v1).component2());
        }

        this.hudRingStarts.clear();
        View v0_3 = this.hudView;
        if(v0_3 != null) {
            String v1_1 = "hudView";
            if(v0_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v0_3 = ((View)v4);
            }

            v0_3 = v0_3.findViewById(id.cpuView);
            if(v0_3 != null) {
                ((CpuIndicatorView)v0_3).stopVisualAnimation();
            }

            v0_3 = this.hudView;
            if(v0_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v0_3 = ((View)v4);
            }

            v0_3 = v0_3.findViewById(id.ramView);
            if(v0_3 == null) {
                goto label_42;
            }

            ((RamIndicatorView)v0_3).stopVisualAnimation();
        }

    label_42:
        Job v0_4 = this.monitoreoJob;
        if(v0_4 != null) {
            DefaultImpls.cancel$default(v0_4, ((CancellationException)v4), 1, v4);
        }

        this.monitoreoJob = ((Job)v4);
        Animator v0_5 = this.tachometerAnimator;
        if(v0_5 != null) {
            v0_5.cancel();
        }

        this.tachometerAnimator = ((Animator)v4);
        ObjectAnimator v0_6 = this.cpuRingAnimator;
        if(v0_6 != null) {
            v0_6.cancel();
        }

        this.cpuRingAnimator = ((ObjectAnimator)v4);
        v0_6 = this.ramRingAnimator;
        if(v0_6 != null) {
            v0_6.cancel();
        }

        this.ramRingAnimator = ((ObjectAnimator)v4);
    }

    private final void detenerMonitoreo() {
        FloatingService.detenerMonitoreo$default(this, null, 1, null);
    }

    static void detenerMonitoreo$default(FloatingService arg0, Long arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        arg0.detenerMonitoreo(arg1);
    }

    static final EditorDoubleClick dobleClicEditor_delegate$lambda$9(FloatingService arg7) {
        ViewConfiguration v7 = ViewConfiguration.get(((Context)arg7));
        return new EditorDoubleClick(((long)ViewConfiguration.getDoubleTapTimeout()), Math.min(10f, ((float)v7.getScaledTouchSlop())), ((float)v7.getScaledDoubleTapSlop()), ((long)ViewConfiguration.getLongPressTimeout()));
    }

    static final EditorControlGeometry editorGeometry_delegate$lambda$3(FloatingService arg3) {
        View v1 = arg3.mapeoView;
        if(v1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v1 = null;
        }

        v1 = v1.findViewById(id.lienzoMapeo);
        Intrinsics.checkNotNullExpressionValue(v1, "findViewById(...)");
        return new EditorControlGeometry(((ViewGroup)v1), new FloatingService$editorGeometry$2$1(arg3));
    }

    private final void enlazarControlesAjustes(View arg11, Context arg12, SharedPreferences arg13) {
        View v2 = arg11.findViewById(id.switchMostrarControles);
        if(v2 != null) {
            ((Switch)v2).setChecked(arg13.getBoolean("mostrar_controles", true));
        }

        if(v2 != null) {
            ((Switch)v2).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda118(arg13, this));
        }

        FloatingService.enlazarControlesAjustes$enlazarSliderPorcentaje(arg11, arg13, id.seekTransparenciaBotones, id.txtTransparenciaBotones, "alpha_botones", 0, 100, 100, new FloatingService$$ExternalSyntheticLambda121(this));
        FloatingService.enlazarControlesAjustes$enlazarSliderPorcentaje(arg11, arg13, id.seekTamanoTap, id.txtTamanoTap, "tamano_boton_tap", 50, 150, 100, new FloatingService$$ExternalSyntheticLambda122(this));
        FloatingService.enlazarControlesAjustes$enlazarSliderPorcentaje(arg11, arg13, id.seekTamanoJoystick, id.txtTamanoJoystick, "tamano_boton_joystick", 50, 150, 100, new FloatingService$$ExternalSyntheticLambda123(this));
        FloatingService.enlazarControlesAjustes$enlazarSliderPorcentaje(arg11, arg13, id.seekTamanoVista, id.txtTamanoVista, "tamano_boton_vista", 50, 150, 100, new FloatingService$$ExternalSyntheticLambda124(this));
        FloatingService.enlazarControlesAjustes$enlazarSliderPorcentaje(arg11, arg13, id.seekTamanoDisparo, id.txtTamanoDisparo, "tamano_boton_disparo", 50, 150, 100, new FloatingService$$ExternalSyntheticLambda125(this));
        FloatingService.enlazarControlesAjustes$enlazarSliderPorcentaje(arg11, arg13, id.seekTransparenciaLogo, id.txtTransparenciaLogo, "alpha_logo", 0, 100, 100, new FloatingService$$ExternalSyntheticLambda126(this, arg13));
        FloatingService.enlazarControlesAjustes$enlazarSliderPorcentaje(arg11, arg13, id.seekTamanoLogo, id.txtTamanoLogo, "tamano_logo", 50, 150, 100, new FloatingService$$ExternalSyntheticLambda128(this, arg13));
        List v0 = PanelVisual.Companion.getTEMAS_BOTONES();
        View v7 = arg11.findViewById(id.btnTemaBotones);
        View v5 = arg11.findViewById(id.txtTemaBotones);
        ObjectRef v2_1 = new ObjectRef();
        String v4 = "Dorado";
        String v3 = arg13.getString("tema_botones", v4);
        if(v3 == null) {
        }
        else {
            v4 = v3;
        }

        v2_1.element = v4;
        FloatingService.enlazarControlesAjustes$actualizarTema(((TextView)v5), v2_1);
        if(v7 != null) {
            v7.setOnClickListener(new FloatingService$$ExternalSyntheticLambda129(v0, v2_1, arg13, this, ((TextView)v5)));
        }

        v0 = CollectionsKt.listOf(new Triple[]{new Triple(Integer.valueOf(id.seekTamanoTap), Integer.valueOf(id.txtTamanoTap), "tamano_boton_tap"), new Triple(Integer.valueOf(id.seekTamanoJoystick), Integer.valueOf(id.txtTamanoJoystick), "tamano_boton_joystick"), new Triple(Integer.valueOf(id.seekTamanoVista), Integer.valueOf(id.txtTamanoVista), "tamano_boton_vista"), new Triple(Integer.valueOf(id.seekTamanoDisparo), Integer.valueOf(id.txtTamanoDisparo), "tamano_boton_disparo")});
        v2 = arg11.findViewById(id.btnRestablecerTamanos);
        if(v2 != null) {
            v2.setOnClickListener(new FloatingService$$ExternalSyntheticLambda130(arg13, v0, this, arg11));
        }

        IntRange v10 = new IntRange(1, 12);
        ArrayList v0_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10), 10));
        Iterator v10_1 = ((Iterable)v10).iterator();
        while(v10_1.hasNext()) {
            ((Collection)v0_1).add("F" + v10_1.nextInt());
        }

        View v10_2 = arg11.findViewById(id.btnTeclaOcultarMapeo);
        v2 = arg11.findViewById(id.txtTeclaOcultarMapeo);
        ObjectRef v4_1 = new ObjectRef();
        String v7_1 = "F9";
        String v5_1 = arg13.getString("tecla_ocultar", v7_1);
        if(v5_1 == null) {
        }
        else {
            v7_1 = v5_1;
        }

        v4_1.element = v7_1;
        FloatingService.enlazarControlesAjustes$actualizarTextoTecla(((TextView)v2), v4_1);
        if(v10_2 != null) {
            v10_2.setOnClickListener(new FloatingService$$ExternalSyntheticLambda119(((List)v0_1), v4_1, arg13, ((TextView)v2)));
        }

        v10_2 = arg11.findViewById(id.switchMostrarToques);
        if(v10_2 != null) {
            ((Switch)v10_2).setChecked(arg13.getBoolean("mostrar_toques", false));
        }

        if(v10_2 != null) {
            ((Switch)v10_2).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda120(arg13));
        }
    }

    private static final void enlazarControlesAjustes$actualizarTema(TextView arg2, ObjectRef arg3) {
        if(arg2 != null) {
            arg2.setText(arg3.element + "  ›");
        }

        if(arg2 != null) {
            Integer v3 = PanelVisual.Companion.resolverColorTema(arg3.element);
            int v3_1 = v3 != null ? v3.intValue() : -1;
            arg2.setTextColor(v3_1);
        }
    }

    private static final void enlazarControlesAjustes$actualizarTextoTecla(TextView arg1, ObjectRef arg2) {
        if(arg1 != null) {
            arg1.setText(arg2.element + "  ›");
        }
    }

    private static final void enlazarControlesAjustes$enlazarSliderPorcentaje(View arg7, SharedPreferences arg8, int arg9, int arg10, String arg11, int arg12, int arg13, int arg14, Function1 arg15) {
        View v9 = arg7.findViewById(arg9);
        if(v9 == null) {
            return;
        }

        View v3 = arg7.findViewById(arg10);
        ((SeekBar)v9).setMax(arg13 - arg12);
        int v7 = RangesKt.coerceIn(arg8.getInt(arg11, arg14), arg12, arg13);
        ((SeekBar)v9).setProgress(v7 - arg12);
        if(v3 != null) {
            ((TextView)v3).setText(v7 + "%");
        }

        ((SeekBar)v9).setOnSeekBarChangeListener(new FloatingService$enlazarControlesAjustes$enlazarSliderPorcentaje$1(arg12, arg13, ((TextView)v3), arg8, arg11, arg15));
    }

    static final void enlazarControlesAjustes$lambda$180(SharedPreferences arg1, FloatingService arg2, CompoundButton arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<unused var>");
        arg1.edit().putBoolean("mostrar_controles", arg4).apply();
        arg2.aplicarAjustesVisualesBotones();
    }

    static final Unit enlazarControlesAjustes$lambda$181(FloatingService arg0, int arg1) {
        arg0.aplicarAjustesVisualesBotones();
        return Unit.INSTANCE;
    }

    static final Unit enlazarControlesAjustes$lambda$182(FloatingService arg0, int arg1) {
        arg0.aplicarAjustesVisualesBotones();
        return Unit.INSTANCE;
    }

    static final Unit enlazarControlesAjustes$lambda$183(FloatingService arg0, int arg1) {
        arg0.aplicarAjustesVisualesBotones();
        return Unit.INSTANCE;
    }

    static final Unit enlazarControlesAjustes$lambda$184(FloatingService arg0, int arg1) {
        arg0.aplicarAjustesVisualesBotones();
        return Unit.INSTANCE;
    }

    static final Unit enlazarControlesAjustes$lambda$185(FloatingService arg0, int arg1) {
        arg0.aplicarAjustesVisualesBotones();
        return Unit.INSTANCE;
    }

    static final Unit enlazarControlesAjustes$lambda$186(FloatingService arg0, SharedPreferences arg1, int arg2) {
        arg0.aplicarAjustesLogo(arg1);
        return Unit.INSTANCE;
    }

    static final Unit enlazarControlesAjustes$lambda$187(FloatingService arg0, SharedPreferences arg1, int arg2) {
        arg0.aplicarAjustesLogo(arg1);
        return Unit.INSTANCE;
    }

    static final void enlazarControlesAjustes$lambda$188(List arg3, ObjectRef arg4, SharedPreferences arg5, FloatingService arg6, TextView arg7, View arg8) {
        int v8 = arg3.indexOf(arg4.element) + 1;
        int v0 = arg3.size();
        v8 %= v0;
        arg4.element = arg3.get(v8 + (v0 & ((v8 ^ v0) & (-v8 | v8)) >> 0x1F));
        arg5.edit().putString("tema_botones", arg4.element).apply();
        FloatingService.enlazarControlesAjustes$actualizarTema(arg7, arg4);
        arg6.aplicarAjustesVisualesBotones();
    }

    static final void enlazarControlesAjustes$lambda$190(SharedPreferences arg1, List arg2, FloatingService arg3, View arg4, View arg5) {
        arg1.edit().putInt("tamano_boton_tap", 100).putInt("tamano_boton_joystick", 100).putInt("tamano_boton_vista", 100).putInt("tamano_boton_disparo", 100).apply();
        Iterator v1 = ((Iterable)arg2).iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            int v5 = ((Triple)v2).component1().intValue();
            int v2_1 = ((Triple)v2).component2().intValue();
            arg5 = arg4.findViewById(v5);
            if(arg5 != null) {
                ((SeekBar)arg5).setProgress(50);
            }

            View v2_2 = arg4.findViewById(v2_1);
            if(v2_2 == null) {
                continue;
            }

            ((TextView)v2_2).setText("100%");
        }

        arg3.aplicarAjustesVisualesBotones();
    }

    static final void enlazarControlesAjustes$lambda$192(List arg3, ObjectRef arg4, SharedPreferences arg5, TextView arg6, View arg7) {
        int v7 = arg3.indexOf(arg4.element) + 1;
        int v0 = arg3.size();
        v7 %= v0;
        arg4.element = arg3.get(v7 + (v0 & ((v7 ^ v0) & (-v7 | v7)) >> 0x1F));
        arg5.edit().putString("tecla_ocultar", arg4.element).apply();
        FloatingService.enlazarControlesAjustes$actualizarTextoTecla(arg6, arg4);
    }

    static final void enlazarControlesAjustes$lambda$193(SharedPreferences arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.edit().putBoolean("mostrar_toques", arg3).apply();
    }

    private final boolean esEntradaRechazadaParaTocar(ControlConTecla arg3, String arg4) {
        InputBinding v2 = InputBinding.Companion.fromDisplayName(arg4);
        if(v2 != null) {
            ControlComponent v1 = null;
            if((arg3 instanceof ProfileComponentControl)) {
            }
            else {
                arg3 = ((ControlConTecla)v1);
            }

            if(arg3 != null) {
                v1 = ((ProfileComponentControl)arg3).currentComponent();
            }

            if(!(v1 instanceof TapComponent)) {
                if(!(v1 instanceof MacroScriptComponent)) {
                }
                else if(!GameProfileCompiler.INSTANCE.isMacroInputAllowed(v2)) {
                    return 1;
                }

                return 0;
            }
            else if(!GameProfileCompiler.INSTANCE.isTapInputAllowed(v2)) {
            }
            else {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    static final GameForegroundMonitor foregroundMonitor_delegate$lambda$2(FloatingService arg3) {
        return new GameForegroundMonitor(new FloatingService$foregroundMonitor$2$1(arg3.getStretchGameLifecycle()), new FloatingService$$ExternalSyntheticLambda9(arg3));
    }

    static final Unit foregroundMonitor_delegate$lambda$2$lambda$1(FloatingService arg2, Boolean arg3) {
        if(arg2.isActive) {
            boolean v3 = Intrinsics.areEqual(arg3, Boolean.valueOf(true));
            arg2.gameObservedForeground = v3;
            arg2.goldenCoreController.setGameForeground(v3);
            if(!arg2.gameObservedForeground) {
                arg2.suspenderVentanas(true);
            }
        }

        return Unit.INSTANCE;
    }

    private final DecorativeAnimationPreferences getDecorativeOptions() {
        return this.decorativeOptions$delegate.getValue();
    }

    private final SharedPreferences getDecorativePreferences() {
        return this.decorativePreferences$delegate.getValue();
    }

    private final EditorDoubleClick getDobleClicEditor() {
        return this.dobleClicEditor$delegate.getValue();
    }

    private final EditorControlGeometry getEditorGeometry() {
        return this.editorGeometry$delegate.getValue();
    }

    private final GameForegroundMonitor getForegroundMonitor() {
        return this.foregroundMonitor$delegate.getValue();
    }

    private final MousePanelController getMousePanelController() {
        return this.mousePanelController$delegate.getValue();
    }

    private final GameProfileStorage getProfileStorage() {
        return this.profileStorage$delegate.getValue();
    }

    private final RecoilSettingsStore getRecoilSettingsStore() {
        return this.recoilSettingsStore$delegate.getValue();
    }

    public SessionOverlayWindows getSessionOverlayWindows() {
        SessionOverlayWindows v0 = this.windowManager;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            v0 = null;
        }

        return v0;
    }

    private final GoldenStretchGameLifecycle getStretchGameLifecycle() {
        return this.stretchGameLifecycle$delegate.getValue();
    }

    private final TelemetryManager getTelemetryManager() {
        return this.telemetryManagerDelegate.getValue();
    }

    private static Object getTelemetryManager$delegate(FloatingService arg0) {
        return arg0.telemetryManagerDelegate;
    }

    private final boolean guardarAjustesVista(BotonVistaBlueStacks arg12, ComponentPlacement arg13, ViewComponent arg14) {
        View v0 = this.mapeoView;
        Object v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v0 = ((View)v1);
        }

        v0 = v0.findViewById(id.lienzoMapeo);
        if(v0 == null) {
            return 0;
        }

        if(arg12.getParent() != v0) {
            return 0;
        }

        GameProfile v5 = this.construirPerfilActual();
        if(v5 == null) {
            return 0;
        }

        BotonVistaBlueStacks v0_1 = arg12;
        String v6 = this.identidadControl(((View)v0_1), arg12.currentComponent().getType());
        String v3 = this.goldenCoreController.vistaSettingsConflict(v5, v6, arg14);
        if(v3 != null) {
            Toast.makeText(((Context)this), ((CharSequence)v3), 1).show();
            return 0;
        }

        ControlVisualState v3_1 = EditorControlGeometry.snapshot$default(this.getEditorGeometry(), ((View)v0_1), false, 2, v1);
        Pair v13 = this.getEditorGeometry().constrain(arg13.getX(), arg13.getY(), v3_1.getWidth(), v3_1.getHeight());
        float v7 = v13.component1().floatValue();
        float v8 = v13.component2().floatValue();
        Object v13_1 = this.getProfileStorage().saveVistaSettings-yxL6bBk(v5, v6, v7, v8, arg14);
        Throwable v14 = Result.exceptionOrNull-impl(v13_1);
        if(v14 != null) {
            goto label_76;
        }

        this.getEditorGeometry().place(((View)v0_1), v7, v8);
        Iterator v14_1 = ((GameProfile)v13_1).getControls().iterator();
        int v0_2;
        for(v0_2 = 0; true; v0_2 = 1) {
        label_51:
            if(!v14_1.hasNext()) {
                goto label_66;
            }

            Object v3_2 = v14_1.next();
            if(!Intrinsics.areEqual(v3_2.getId(), v6)) {
                goto label_51;
            }

            if(v0_2 != 0) {
                break;
            }

            v1 = v3_2;
        }

        throw new IllegalArgumentException("Collection contains more than one matching element.");
    label_66:
        if(v0_2 != 0) {
            arg12.applyComponent(((ProfileControl)v1).getComponent());
            this.guardarConfiguracion(false);
            this.aplicarPerfilActualAlMotor(((GameProfile)v13_1));
            return 1;
        }

        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    label_76:
        Toast.makeText(((Context)this), "No se guardó VISTA: " + v14.getMessage(), 1).show();
        return 0;
    }

    private final boolean guardarBindingVista(BotonVistaBlueStacks arg10, InputBinding arg11) {
        View v0 = this.mapeoView;
        ProfileControl v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v0 = ((View)v1);
        }

        v0 = v0.findViewById(id.lienzoMapeo);
        if(v0 == null) {
            return 0;
        }

        if(arg10.getParent() != v0) {
            return 0;
        }

        GameProfile v0_1 = this.construirPerfilActual();
        if(v0_1 == null) {
            return 0;
        }

        String v3 = this.identidadControl(arg10, arg10.currentComponent().getType());
        Object v0_2 = this.getProfileStorage().saveVistaPrimary-0E7RQCE(v0_1, v3, arg11);
        Throwable v4 = Result.exceptionOrNull-impl(v0_2);
        if(v4 != null) {
            goto label_63;
        }

        arg10.updateBinding("PRIMARY", arg11);
        Iterator v4_1 = ((GameProfile)v0_2).getControls().iterator();
        int v6 = 0;
        while(true) {
            if(!v4_1.hasNext()) {
                goto label_46;
            }

            Object v7 = v4_1.next();
            if(!Intrinsics.areEqual(v7.getId(), v3)) {
                continue;
            }

            if(v6 != 0) {
                break;
            }

            v6 = 1;
            Object v1_1 = v7;
        }

        throw new IllegalArgumentException("Collection contains more than one matching element.");
    label_46:
        if(v6 != 0) {
            arg10.applyComponent(v1.getComponent());
            this.aplicarPerfilActualAlMotor(((GameProfile)v0_2));
            Toast.makeText(((Context)this), "TECLA: " + arg11.displayName(), 0).show();
            return 1;
        }

        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    label_63:
        Toast.makeText(((Context)this), "No se guardó VISTA: " + v4.getMessage(), 1).show();
        return 0;
    }

    private final boolean guardarConfiguracion(boolean arg12) {
        String v6;
        if((arg12) && (this.solicitarReparacionIds())) {
            return 0;
        }

        View v1 = this.mapeoView;
        String v2 = null;
        if(v1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v1 = ((View)v2);
        }

        v1 = v1.findViewById(id.lienzoMapeo);
        if(v1 == null) {
            return 0;
        }

        GameProfile v3 = this.construirPerfilActual();
        if(v3 != null && (arg12)) {
            Object v12 = this.getProfileStorage().save-IoAF18A(v3);
            if(Result.isFailure-impl(v12)) {
                Throwable v12_1 = Result.exceptionOrNull-impl(v12);
                if(v12_1 != null) {
                    v2 = v12_1.getMessage();
                }

                Toast.makeText(((Context)this), "No se guardó el perfil: " + v2, 1).show();
                return 0;
            }
        }

        StringBuilder v12_2 = new StringBuilder();
        ArrayList v2_1 = new ArrayList();
        int v3_1 = ((FrameLayout)v1).getChildCount();
        int v5;
        for(v5 = 0; true; ++v5) {
            v6 = "GOLDEN_CONFIG";
            if(v5 >= v3_1) {
                break;
            }

            View v7 = ((FrameLayout)v1).getChildAt(v5);
            if((v7 instanceof ControlVisual)) {
                if((v7 instanceof VistaLibreVisual)) {
                }
                else {
                    ControlVisualState v7_1 = this.getEditorGeometry().snapshot(v7, false);
                    ((List)v2_1).add(v7_1);
                    Log.d(v6, "Guardando control: tipo=" + v7_1.getTipo());
                    v6 = this.convertirTipoLegacy(v7_1.getTipo());
                    if(v6 != null) {
                        float v8 = v7_1.getX();
                        float v9 = v7_1.getY();
                        String v7_2 = v7_1.getTecla();
                        if(v7_2 == null) {
                            v7_2 = "";
                        }

                        v12_2.append(v6 + "," + v8 + "," + v9 + "," + v7_2 + ";");
                    }
                }
            }
        }

        this.getSharedPreferences("GoldenMouseConfig", 0).edit().putString("mapeo_guardado", v12_2.toString()).putString("mapeo_guardado_v2", ControlVisualStateSerializer.INSTANCE.serialize(((List)v2_1))).apply();
        Log.d(v6, "Guardado V2 controles=" + ((List)v2_1).size());
        return 1;
    }

    static boolean guardarConfiguracion$default(FloatingService arg0, boolean arg1, int arg2, Object arg3) {
        return arg0.guardarConfiguracion(true);
    }

    private final boolean hayInteraccionUi() {
        if(!this.isMapeoVisible && !this.isHudVisible && !this.isFpsSettingsVisible && this.fpsSettingsView == null && this.settingsPanelView == null && this.mousePanelView == null && !this.isPanelTransitioning && !this.isSettingsTransitioning && !this.isMousePanelTransitioning && !this.isCursorPickerOpen && this.retrocesoDialog == null && this.goldenStretchVisual == null) {
            SessionOverlayWindows v1 = this.windowManager;
            if(v1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v1 = null;
            }

            if(v1.getHasDialogs()) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    private final String identidadControl(View arg6, String arg7) {
        Object v3_2;
        Object v0 = arg6.getTag();
        Object v2 = null;
        if((v0 instanceof String)) {
        }
        else {
            v0 = v2;
        }

        Object v1 = v0;
        if(v1 != null) {
            if(StringsKt.isBlank(((CharSequence)v1))) {
            }
            else {
                return ((String)v0);
            }
        }

        if(!this.controlSourceIndices.containsKey(arg6)) {
            if(this.visualSourceIndices.containsKey(arg6)) {
            }
            else {
                View v5 = this.mapeoView;
                if(v5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
                    v5 = ((View)v2);
                }

                v5 = v5.findViewById(id.lienzoMapeo);
                int v1_1 = v5 != null ? ((FrameLayout)v5).getChildCount() : 0;
                IntRange v0_1 = RangesKt.until(0, v1_1);
                ArrayList v1_2 = new ArrayList();
                Iterator v0_2 = ((Iterable)v0_1).iterator();
                while(v0_2.hasNext()) {
                    int v3 = v0_2.nextInt();
                    if(v5 != null) {
                        View v3_1 = ((FrameLayout)v5).getChildAt(v3);
                        if(v3_1 != null) {
                            v3_2 = v3_1.getTag();
                        }
                        else {
                            goto label_44;
                        }
                    }
                    else {
                    label_44:
                        v3_2 = v2;
                    }

                    if((v3_2 instanceof String)) {
                    }
                    else {
                        v3_2 = v2;
                    }

                    if(v3_2 == null) {
                        continue;
                    }

                    ((Collection)v1_2).add(v3_2);
                }

                String v5_1 = ProfileIdentities.INSTANCE.fresh(arg7, ((Collection)v1_2));
                arg6.setTag(v5_1);
                return v5_1;
            }
        }

        if(v0 == null) {
            return "";
        }

        return ((String)v0);
    }

    private final void inflarPanelFps() {
        if(this.isActive) {
            View v1 = null;
            try {
                View v0_1 = MonitoringPanelFactory.create(new ContextThemeWrapper(this, style.Theme_MaterialComponents_DayNight_NoActionBar));
                WindowManager$LayoutParams v2 = new WindowManager$LayoutParams(-1, -1, 0x7F6, 0x308, -3);
                if(Build$VERSION.SDK_INT >= 30) {
                    v2.layoutInDisplayCutoutMode = 3;
                }
                else if(Build$VERSION.SDK_INT >= 28) {
                    v2.layoutInDisplayCutoutMode = 1;
                }

                View v3 = v0_1.findViewById(id.panelContainer);
                if(v3 == null) {
                    v3 = v0_1;
                }

                v3.setTranslationX(300f * this.getResources().getDisplayMetrics().density);
                v3.setAlpha(0f);
                View v4 = v0_1.findViewById(id.btnCloseMonitoreo);
                if(v4 != null) {
                    v4.setOnClickListener(new FloatingService$$ExternalSyntheticLambda138(this));
                }

                v0_1.setOnClickListener(new FloatingService$$ExternalSyntheticLambda149(this));
                v4 = v0_1.findViewById(id.switchEstiloBluestacks);
                View v6 = v0_1.findViewById(id.switchFps);
                View v7 = v0_1.findViewById(id.switchPing);
                View v8 = v0_1.findViewById(id.switchCpu);
                View v9 = v0_1.findViewById(id.switchRam);
                View v10 = v0_1.findViewById(id.switchTemp);
                View v11 = v0_1.findViewById(id.switchHora);
                if(v4 != null) {
                    ((Switch)v4).setChecked(this.getTelemetryManager().isBluestacksEnabled());
                }

                if(v6 != null) {
                    ((Switch)v6).setChecked(this.getTelemetryManager().isFpsActive());
                }

                if(v7 != null) {
                    ((Switch)v7).setChecked(this.getTelemetryManager().isPingActive());
                }

                if(v8 != null) {
                    ((Switch)v8).setChecked(this.getTelemetryManager().isCpuActive());
                }

                if(v9 != null) {
                    ((Switch)v9).setChecked(this.getTelemetryManager().isRamActive());
                }

                if(v10 != null) {
                    ((Switch)v10).setChecked(this.getTelemetryManager().isTempActive());
                }

                if(v11 != null) {
                    ((Switch)v11).setChecked(this.getTelemetryManager().isHoraActive());
                }

                if(v4 != null) {
                    ((Switch)v4).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda160(this));
                }

                if(v6 != null) {
                    ((Switch)v6).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda171(this));
                }

                if(v7 != null) {
                    ((Switch)v7).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda182(this));
                }

                if(v8 != null) {
                    ((Switch)v8).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda11(this));
                }

                if(v9 != null) {
                    ((Switch)v9).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda22(this));
                }

                if(v10 != null) {
                    ((Switch)v10).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda33(this));
                }

                if(v11 != null) {
                    ((Switch)v11).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda44(this));
                }

                SessionOverlayWindows v4_1 = this.windowManager;
                if(v4_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    v4_1 = ((SessionOverlayWindows)v1);
                }

                Intrinsics.checkNotNull(v0_1);
                v4_1.addView(v0_1, ((ViewGroup$LayoutParams)v2));
                this.setFpsSettingsView(v0_1);
                this.setFpsSettingsVisible(true);
                this.mantenerCursorAlFrente();
                v3.post(new FloatingService$$ExternalSyntheticLambda55(this, v0_1, v3));
                return;
            }
            catch(Exception v0) {
                Log.e("GOLDEN_UI", "Error mostrando Panel FPS", ((Throwable)v0));
                this.setFpsSettingsView(v1);
                this.setFpsSettingsVisible(false);
                this.setPanelTransitioning(false);
                Toast.makeText(this, "No se pudo abrir el monitoreo", 0).show();
                if((this.isActive) && (this.mostrarHudXML())) {
                    return;
                }

                this.actualizarControlesEnJuego();
            }
        }
    }

    static final void inflarPanelFps$lambda$113(FloatingService arg0, View arg1) {
        arg0.cerrarPanelFpsConAnimacion(new FloatingService$$ExternalSyntheticLambda100(arg0));
    }

    static final Unit inflarPanelFps$lambda$113$lambda$112(FloatingService arg0) {
        arg0.mostrarHudXML();
        return Unit.INSTANCE;
    }

    static final void inflarPanelFps$lambda$115(FloatingService arg0, View arg1) {
        arg0.cerrarPanelFpsConAnimacion(new FloatingService$$ExternalSyntheticLambda85(arg0));
    }

    static final Unit inflarPanelFps$lambda$115$lambda$114(FloatingService arg0) {
        arg0.mostrarHudXML();
        return Unit.INSTANCE;
    }

    static final void inflarPanelFps$lambda$116(FloatingService arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.getTelemetryManager().setBluestacksEnabled(arg3);
    }

    static final void inflarPanelFps$lambda$117(FloatingService arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.getTelemetryManager().setFpsEnabled(arg3);
    }

    static final void inflarPanelFps$lambda$118(FloatingService arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.getTelemetryManager().setPingEnabled(arg3);
    }

    static final void inflarPanelFps$lambda$119(FloatingService arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.getTelemetryManager().setCpuEnabled(arg3);
    }

    static final void inflarPanelFps$lambda$120(FloatingService arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.getTelemetryManager().setRamEnabled(arg3);
    }

    static final void inflarPanelFps$lambda$121(FloatingService arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.getTelemetryManager().setTempEnabled(arg3);
    }

    static final void inflarPanelFps$lambda$122(FloatingService arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.getTelemetryManager().setHoraEnabled(arg3);
    }

    static final void inflarPanelFps$lambda$124(FloatingService arg2, View arg3, View arg4) {
        if(arg2.fpsSettingsView == arg3) {
            SessionOverlayWindows v0 = arg2.windowManager;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v0 = null;
            }

            Intrinsics.checkNotNull(arg3);
            if(!v0.isManaged(arg3)) {
                return;
            }

            arg4.setTranslationX(((float)arg4.getWidth()));
            arg4.animate().translationX(0f).alpha(1f).setDuration(0xF0).setInterpolator(new DecelerateInterpolator(1.8f)).withEndAction(new FloatingService$$ExternalSyntheticLambda177(arg2)).start();
        }
    }

    static final void inflarPanelFps$lambda$124$lambda$123(FloatingService arg1) {
        arg1.setPanelTransitioning(false);
    }

    private final void iniciarGiroDecorativo(View arg2, long arg3, boolean arg5) {
        this.postHudRingStart(arg2, arg3, new FloatingService$$ExternalSyntheticLambda41(arg5, this, arg2));
    }

    static final Unit iniciarGiroDecorativo$lambda$202(boolean arg2, FloatingService arg3, View arg4) {
        DecorativeEffect v0 = arg2 ? DecorativeEffect.CPU_RING : DecorativeEffect.RAM_RING;
        if(arg3.getDecorativeOptions().isEnabled(v0)) {
            ObjectAnimator v0_1 = arg2 ? arg3.cpuRingAnimator : arg3.ramRingAnimator;
            if(v0_1 != null) {
                goto label_40;
            }

            arg4.setPivotX((((float)arg4.getWidth())) / 2f);
            arg4.setPivotY((((float)arg4.getHeight())) / 2f);
            ObjectAnimator v4 = ObjectAnimator.ofFloat(arg4, View.ROTATION, new float[]{0f, 360f});
            v4.setDuration(3000);
            v4.setRepeatCount(-1);
            v4.setInterpolator(new LinearInterpolator());
            if(arg2) {
                arg3.cpuRingAnimator = v4;
            }
            else {
                arg3.ramRingAnimator = v4;
            }

            v4.start();
            return Unit.INSTANCE;
        }

    label_40:
        return Unit.INSTANCE;
    }

    private final void iniciarLoopMonitoreo(long arg10, TextView arg12, TextView arg13, CpuIndicatorView arg14, RamIndicatorView arg15) {
        if(!this.monitoreoActual(arg10)) {
            this.detenerMonitoreo(Long.valueOf(arg10));
            return;
        }

        Job v0 = this.monitoreoJob;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, null, 1, null);
        }

        this.monitoreoJob = BuildersKt.launch$default(this.serviceScope, null, null, new FloatingService$iniciarLoopMonitoreo$1(this, arg10, arg13, arg12, arg15, arg14, null), 3, null);
    }

    private final void iniciarModoForeground() {
        try {
            String v0 = "golden_mouse_overlay_service";
            Object v1 = this.getSystemService(NotificationManager.class);
            NotificationChannel v2 = v1 != null ? ((NotificationManager)v1).getNotificationChannel(v0) : null;
            if(v2 == null) {
                v2 = new NotificationChannel(v0, "Golden Mouse Pro Activo", 2);
                v2.setShowBadge(false);
                if(v1 != null) {
                    ((NotificationManager)v1).createNotificationChannel(v2);
                }
            }

            Notification v0_1 = new Notification$Builder(this, v0).setContentTitle("Golden Mouse Pro").setContentText("Motor de mouse y teclado activo").setSmallIcon(drawable.logo).setOngoing(true).build();
            Intrinsics.checkNotNull(v0_1);
            int v3 = 1001;
            if(Build$VERSION.SDK_INT >= 34) {
                this.startForeground(v3, v0_1, 0x40000000);
            }
            else {
                this.startForeground(v3, v0_1);
            }

            Result.constructor-impl(Unit.INSTANCE);
            return;
        }
        catch(Throwable v5) {
            Result.constructor-impl(ResultKt.createFailure(v5));
            return;
        }
    }

    private final void iniciarMonitoreo() {
        String v0_5;
        String v9_1;
        if((this.isActive) && (this.isHudVisible)) {
            SessionOverlayWindows v0 = this.windowManager;
            Continuation v1 = null;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v0 = ((SessionOverlayWindows)v1);
            }

            if(v0.getSuspended()) {
                return;
            }

            VisualVisibilityObserver v0_1 = this.hudVisibilityObserver;
            if(v0_1 == null) {
                return;
            }

            if(!v0_1.getVisible()) {
                return;
            }

            View v0_2 = this.hudView;
            String v3 = "hudView";
            if(v0_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0_2 = ((View)v1);
            }

            if(!v0_2.isAttachedToWindow()) {
                return;
            }

            v0_2 = this.hudView;
            if(v0_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0_2 = ((View)v1);
            }

            if(!v0_2.isShown()) {
                return;
            }

            Long v0_3 = this.hudVisualSession.begin();
            if(v0_3 == null) {
                return;
            }

            long v4 = v0_3.longValue();
            v0_2 = this.hudView;
            if(v0_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0_2 = ((View)v1);
            }

            v0_2 = v0_2.findViewById(id.textRamPercent);
            View v6 = this.hudView;
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v6 = ((View)v1);
            }

            View v3_1 = v6.findViewById(id.textCpuPercent);
            String v6_1 = "format(...)";
            String v7 = "%.2f";
            String v8 = "—";
            if(v0_2 != null) {
                Pair v9 = this.lastRamData;
                if(v9 != null) {
                    v9_1 = String.format(Locale.US, v7, Arrays.copyOf(new Object[]{v9.getFirst()}, 1));
                    Intrinsics.checkNotNullExpressionValue(v9_1, v6_1);
                    if(v9_1 != null) {
                    }
                    else {
                        goto label_62;
                    }
                }
                else {
                label_62:
                    v9_1 = v8;
                }

                ((TextView)v0_2).setText(((CharSequence)v9_1));
            }

            if(v3_1 != null) {
                Pair v0_4 = this.lastCpuData;
                if(v0_4 != null) {
                    v0_5 = String.format(Locale.US, v7, Arrays.copyOf(new Object[]{v0_4.getFirst()}, 1));
                    Intrinsics.checkNotNullExpressionValue(v0_5, v6_1);
                    if(v0_5 != null) {
                    }
                    else {
                        goto label_76;
                    }
                }
                else {
                label_76:
                    v0_5 = v8;
                }

                ((TextView)v3_1).setText(((CharSequence)v0_5));
            }

            this.monitoreoJob = BuildersKt.launch$default(this.serviceScope, null, null, new FloatingService$iniciarMonitoreo$3(this, v4, v1), 3, null);
        }
    }

    private final Pair leerFrecuenciaCpu() {
        float v1_3;
        RandomAccessFile v0;
        Throwable v5 = null;
        try {
            v0 = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "r");
        }
        catch(Exception ) {
            goto label_30;
        }

        RandomAccessFile v1 = v0;
        try {
            String v1_2 = v1.readLine();
            Intrinsics.checkNotNullExpressionValue(v1_2, "readLine(...)");
            v1_3 = ((float)((((double)Long.parseLong(v1_2))) / 1000000));
            goto label_14;
        }
        catch(Throwable v1_1) {
            try {
                throw v1_1;
            }
            catch(Throwable v2) {
                try {
                    CloseableKt.closeFinally(((Closeable)v0), v1_1);
                    throw v2;
                label_14:
                    CloseableKt.closeFinally(((Closeable)v0), v5);
                    return new Pair(Float.valueOf(v1_3), Float.valueOf(RangesKt.coerceIn(v1_3 / 3.5f, 0f, 1f)));
                }
                catch(Exception ) {
                label_30:
                    return ((Pair)v5);
                }
            }
        }
    }

    private final Pair leerRamUsada() {
        ActivityManager$MemoryInfo v0 = new ActivityManager$MemoryInfo();
        Object v7 = this.getSystemService("activity");
        Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager)v7).getMemoryInfo(v0);
        double v1 = (((double)v0.totalMem)) / 1073741824;
        float v7_1 = ((float)(v1 - (((double)v0.availMem)) / 1073741824));
        return new Pair(Float.valueOf(v7_1), Float.valueOf(((float)((((double)v7_1)) / v1))));
    }

    static final void liberarInteraccionUi$lambda$15(FloatingService arg1) {
        if((arg1.isActive) && !arg1.hayInteraccionUi()) {
            arg1.aplicarInteraccionUi(false);
        }
    }

    private final GameProfile limitarPosicionEnPerfil(GameProfile arg17, String arg18, View arg19) {
        ProfileControl v5_1;
        Object v3 = null;
        ControlVisualState v0 = EditorControlGeometry.snapshot$default(this.getEditorGeometry(), arg19, false, 2, v3);
        List v1 = arg17.getControls();
        ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1), 10));
        Iterator v1_1 = ((Iterable)v1).iterator();
        while(v1_1.hasNext()) {
            Object v5 = v1_1.next();
            if(!Intrinsics.areEqual(((ProfileControl)v5).getId(), arg18)) {
            }
            else {
                Integer v4 = Integer.valueOf(((ProfileControl)v5).getWidth());
                if(v4.intValue() > 0) {
                }
                else {
                    v4 = ((Integer)v3);
                }

                int v4_1 = v4 != null ? v4.intValue() : v0.getWidth();
                int v10 = v4_1;
                v4 = Integer.valueOf(((ProfileControl)v5).getHeight());
                if(v4.intValue() > 0) {
                }
                else {
                    v4 = ((Integer)v3);
                }

                v4_1 = v4 != null ? v4.intValue() : v0.getHeight();
                int v11 = v4_1;
                Pair v4_2 = this.getEditorGeometry().constrain(((ProfileControl)v5).getX(), ((ProfileControl)v5).getY(), v10, v11);
                v5_1 = ProfileControl.copy$default(((ProfileControl)v5), null, null, v4_2.component1().floatValue(), v4_2.component2().floatValue(), v10, v11, null, null, 0xC3, null);
            }

            ((Collection)v2).add(v5_1);
        }

        ArrayList v9 = v2;
        if(Intrinsics.areEqual(v9, arg17.getControls())) {
            return arg17;
        }

        return GameProfile.copy$default(arg17, null, null, ((List)v9), null, 11, null);
    }

    private final void mantenerCursorAlFrente() {
        GoldenCursorRenderer v6;
        float v0_4;
        float v1_1;
        Pair v0_3;
        if(this.isActive) {
            SessionOverlayWindows v0 = this.windowManager;
            String v1 = "windowManager";
            SessionOverlayWindows v2 = null;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0 = v2;
            }

            if(v0.getSuspended()) {
                return;
            }

            this.actualizarControlesEnJuego();
            FrameLayout v0_1 = this.cursorOverlayView;
            if(v0_1 == null) {
                return;
            }

            SessionOverlayWindows v3 = this.windowManager;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v3 = v2;
            }

            if(!v3.isManaged(v0_1)) {
                return;
            }

            ViewGroup$LayoutParams v3_1 = v0_1.getLayoutParams();
            if((v3_1 instanceof WindowManager$LayoutParams)) {
            }
            else {
                v3_1 = ((ViewGroup$LayoutParams)v2);
            }

            if(v3_1 == null) {
                return;
            }

            ((WindowManager$LayoutParams)v3_1).flags |= 24;
            try {
                v0_1.setVisibility(0);
                SessionOverlayWindows v4 = this.windowManager;
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v4 = v2;
                }

                v4.removeViewImmediate(v0_1);
                v4 = this.windowManager;
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                }
                else {
                    v2 = v4;
                }

                v2.addView(((View)v0_1), v3_1);
                GoldenCursorRenderer v0_2 = this.cursorRenderer;
                if(v0_2 != null) {
                    v0_3 = v0_2.currentHotspot();
                    if(v0_3 != null) {
                    label_56:
                        v1_1 = v0_3.component1().floatValue();
                        v0_4 = v0_3.component2().floatValue();
                        v6 = this.cursorRenderer;
                        if(v6 == null) {
                            return;
                        }

                        goto label_62;
                    }
                }

                v0_3 = new Pair(Float.valueOf(0f), Float.valueOf(0f));
                goto label_56;
            label_62:
                v6.moveTo(v1_1, v0_4);
                return;
            }
            catch(Exception ) {
                return;
            }
        }
    }

    private final void maximizarMenuMapeo(boolean arg5) {
        View v0 = this.mapeoView;
        View v1 = null;
        String v2 = "mapeoView";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = v1;
        }

        v0 = v0.findViewById(id.contenedorCortinaMapeo);
        if(v0 == null) {
            return;
        }

        this.isMenuMapeoMinimizado = false;
        v0.setVisibility(0);
        v0.bringToFront();
        View v4 = this.mapeoView;
        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
        }
        else {
            v1 = v4;
        }

        v4 = v1.findViewById(id.btnToggleMinimizarMapeo);
        if(v4 != null) {
            v4.bringToFront();
        }

        if(arg5) {
            v0.animate().translationY(0f).setDuration(280).setInterpolator(new DecelerateInterpolator()).start();
            return;
        }

        v0.setTranslationY(0f);
    }

    static void maximizarMenuMapeo$default(FloatingService arg0, boolean arg1, int arg2, Object arg3) {
        arg0.maximizarMenuMapeo(true);
    }

    private final void minimizarMenuMapeo(boolean arg6) {
        View v3;
        View v0 = this.mapeoView;
        String v1 = "mapeoView";
        ViewGroup$LayoutParams v2 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v0 = ((View)v2);
        }

        v0 = v0.findViewById(id.panelMapeoTeclas);
        if(v0 == null) {
        }
        else {
            v3 = this.mapeoView;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v3 = ((View)v2);
            }

            v3 = v3.findViewById(id.contenedorCortinaMapeo);
            if(v3 != null) {
                goto label_18;
            }
        }

        return;
    label_18:
        this.isMenuMapeoMinimizado = true;
        v3.setVisibility(0);
        v3.bringToFront();
        View v5 = this.mapeoView;
        if(v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v1);
            v5 = ((View)v2);
        }

        v5 = v5.findViewById(id.btnToggleMinimizarMapeo);
        if(v5 != null) {
            v5.bringToFront();
        }

        int v5_1 = v0.getHeight() > 0 ? v0.getHeight() : v0.getMeasuredHeight();
        float v5_2 = ((float)v5_1);
        ViewGroup$LayoutParams v0_1 = v0.getLayoutParams();
        if((v0_1 instanceof ViewGroup$MarginLayoutParams)) {
            v2 = v0_1;
        }

        float v0_2 = v2 != null ? ((float)((ViewGroup$MarginLayoutParams)v2).topMargin) : 0f;
        v5_2 = -(v5_2 + v0_2);
        if(arg6) {
            v3.animate().translationY(v5_2).setDuration(280).setInterpolator(new DecelerateInterpolator()).start();
            return;
        }

        v3.setTranslationY(v5_2);
    }

    static void minimizarMenuMapeo$default(FloatingService arg0, boolean arg1, int arg2, Object arg3) {
        arg0.minimizarMenuMapeo(true);
    }

    private final boolean monitoreoActual(long arg3) {
        if((this.hudVisualSession.isCurrent(arg3)) && (this.isActive) && (this.isHudVisible)) {
            SessionOverlayWindows v3 = this.windowManager;
            View v4 = null;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v3 = ((SessionOverlayWindows)v4);
            }

            if(v3.getSuspended()) {
                return 0;
            }

            VisualVisibilityObserver v3_1 = this.hudVisibilityObserver;
            if(v3_1 == null) {
                return 0;
            }

            if(!v3_1.getVisible()) {
                return 0;
            }

            View v3_2 = this.hudView;
            String v1 = "hudView";
            if(v3_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v3_2 = v4;
            }

            if(!v3_2.isAttachedToWindow()) {
                return 0;
            }

            View v2 = this.hudView;
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
            }
            else {
                v4 = v2;
            }

            if(!v4.isShown()) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final void mostrarDiagnosticoCamara() {
        Object v3_1;
        if((this.getApplicationInfo().flags & 2) != 0) {
            AlertDialog v0 = this.cameraDiagnosticsDialog;
            if(v0 != null) {
                v0.dismiss();
            }

            AlertDialog$Builder v0_1 = new AlertDialog$Builder(new ContextThemeWrapper(this, style.Theme_MaterialComponents_DayNight_NoActionBar)).setTitle("Diagnóstico de cámara").setMessage(CameraDiagnostics.INSTANCE.snapshot());
            String v1 = CameraDiagnostics.INSTANCE.getEnabled() ? "Desactivar" : "Activar";
            v0 = v0_1.setPositiveButton(((CharSequence)v1), new FloatingService$$ExternalSyntheticLambda10(this)).setNeutralButton("Compartir", new FloatingService$$ExternalSyntheticLambda12(this)).setNegativeButton("Cerrar", null).create();
            this.cameraDiagnosticsDialog = v0;
            Window v1_1 = v0.getWindow();
            if(v1_1 != null) {
                v1_1.setType(0x7F6);
            }

            v0.setOnDismissListener(new FloatingService$$ExternalSyntheticLambda13(this, v0));
            try {
                Intrinsics.checkNotNull(v0);
                SessionOverlayWindowsKt.showSessionDialog(v0);
                this.bringCursorToFront();
                v3_1 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v3) {
                v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
            }

            v3 = Result.exceptionOrNull-impl(v3_1);
            if(v3 != null) {
                v0.dismiss();
                Log.w("GOLDEN_UI", "No se pudo abrir el diagnóstico de cámara", v3);
            }
        }
    }

    static final void mostrarDiagnosticoCamara$lambda$59(FloatingService arg0, DialogInterface arg1, int arg2) {
        CameraDiagnostics.INSTANCE.setEnabled(CameraDiagnostics.INSTANCE.getEnabled() ^ 1);
        String v1 = CameraDiagnostics.INSTANCE.getEnabled() ? "Diagnóstico activado" : "Diagnóstico desactivado";
        Toast.makeText(((Context)arg0), ((CharSequence)v1), 0).show();
    }

    static final void mostrarDiagnosticoCamara$lambda$63(FloatingService arg1, DialogInterface arg2, int arg3) {
        Object v2_2;
        Intent v2 = new Intent("android.intent.action.SEND");
        v2.setType("text/plain");
        v2.putExtra("android.intent.extra.TEXT", CameraDiagnostics.INSTANCE.snapshot());
        try {
            arg1.startActivity(Intent.createChooser(v2, "Compartir diagnóstico").addFlags(0x10000000));
            v2_2 = Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v2_1) {
            v2_2 = Result.constructor-impl(ResultKt.createFailure(v2_1));
        }

        if(Result.exceptionOrNull-impl(v2_2) != null) {
            Toast.makeText(((Context)arg1), "No se pudo abrir el selector para compartir", 0).show();
        }
    }

    static final void mostrarDiagnosticoCamara$lambda$64(FloatingService arg0, AlertDialog arg1, DialogInterface arg2) {
        if(arg0.cameraDiagnosticsDialog == arg1) {
            arg0.cameraDiagnosticsDialog = null;
        }
    }

    private final void mostrarGoldenStretch() {
        if(this.isActive) {
            SessionOverlayWindows v0 = this.windowManager;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v0 = null;
            }

            if(v0.getSuspended()) {
                return;
            }

            if(this.goldenStretchVisual != null) {
                return;
            }

            if(this.isPanelTransitioning) {
                return;
            }

            GoldenStretchVisualController v0_1 = new GoldenStretchVisualController(this, new FloatingService$$ExternalSyntheticLambda114(this));
            this.setGoldenStretchVisual(v0_1);
            this.ocultarHudParaPanel(new FloatingService$$ExternalSyntheticLambda115(this, v0_1));
        }
    }

    static final Unit mostrarGoldenStretch$lambda$139(FloatingService arg2) {
        GoldenStretchVisualController v0 = null;
        arg2.setGoldenStretchVisual(v0);
        if(arg2.isActive) {
            View v1 = arg2.floatingIconView;
            if(v1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
            }
            else {
                View v0_1 = v1;
            }

            ((View)v0).setVisibility(0);
            arg2.actualizarControlesEnJuego();
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrarGoldenStretch$lambda$140(FloatingService arg2, GoldenStretchVisualController arg3) {
        if(arg2.isActive) {
            if(arg2.goldenStretchVisual != arg3) {
            }
            else {
                try {
                    arg3.show();
                    arg2.bringCursorToFront();
                }
                catch(Exception v3) {
                    Log.e("GOLDEN_UI", "No se pudo abrir Golden Stretch", ((Throwable)v3));
                    Toast.makeText(((Context)arg2), "No se pudo abrir Golden Stretch", 0).show();
                }

                return Unit.INSTANCE;
            }
        }

        return Unit.INSTANCE;
    }

    private final boolean mostrarHudXML() {
        ViewPropertyAnimator v4_1;
        boolean v0_4;
        View v11;
        SessionOverlayWindows v0_2;
        ViewPropertyAnimator v0_1;
        if(!this.isActive) {
            return 0;
        }

        if(!this.isPanelTransitioning && !this.hubTransitions.getRunning() && !this.isSettingsTransitioning && this.settingsPanelView == null && !this.isMousePanelTransitioning) {
            if(this.mousePanelView != null) {
            }
            else {
                if(this.fpsSettingsView == null) {
                    if(this.isFpsSettingsVisible) {
                    }
                    else {
                        this.setPanelTransitioning(true);
                        View v0 = this.hudView;
                        String v3 = "hudView";
                        Runnable v4 = null;
                        if(v0 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3);
                            v0 = ((View)v4);
                        }

                        View v5 = v0.findViewById(id.layoutPanelLeft);
                        v0 = this.hudView;
                        if(v0 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3);
                            v0 = ((View)v4);
                        }

                        View v6 = v0.findViewById(id.layoutPanelRight);
                        long v9 = this.hubTransitions.begin(new FloatingService$$ExternalSyntheticLambda94(this, v5, v6));
                        if(v5 != null) {
                            v0_1 = v5.animate();
                            if(v0_1 != null) {
                                v0_1 = v0_1.withEndAction(v4);
                                if(v0_1 != null) {
                                    v0_1.cancel();
                                }
                            }
                        }

                        if(v6 != null) {
                            v0_1 = v6.animate();
                            if(v0_1 != null) {
                                v0_1 = v0_1.withEndAction(v4);
                                if(v0_1 != null) {
                                    v0_1.cancel();
                                }
                            }
                        }

                        this.goldenCoreController.iniciar();
                        String v7 = "windowManager";
                        if(this.isHudVisible) {
                            v0_2 = this.windowManager;
                            if(v0_2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v7);
                                v0_2 = ((SessionOverlayWindows)v4);
                            }

                            View v8 = this.hudView;
                            if(v8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v3);
                                v8 = ((View)v4);
                            }

                            if(!v0_2.isManaged(v8)) {
                                goto label_90;
                            }

                            v0_2 = this.windowManager;
                            if(v0_2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v7);
                                v0_2 = ((SessionOverlayWindows)v4);
                            }

                            if(!v0_2.getSuspended()) {
                                v0 = this.hudView;
                                if(v0 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                                    v0 = ((View)v4);
                                }

                                if(v0.getParent() != null) {
                                    goto label_83;
                                }

                                goto label_90;
                            }

                        label_83:
                            this.mantenerCursorAlFrente();
                            HubWindowTransition.finish$default(this.hubTransitions, v9, false, 2, null);
                            return 1;
                        }

                    label_90:
                        v0 = this.floatingIconView;
                        if(v0 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
                            v0 = ((View)v4);
                        }

                        v0.setVisibility(8);
                        v0 = this.hudView;
                        if(v0 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3);
                            v0 = ((View)v4);
                        }

                        v0.setVisibility(0);
                        if(v5 != null) {
                            v5.setTranslationX(-800f);
                        }

                        if(v5 != null) {
                            v5.setAlpha(0f);
                        }

                        if(v6 != null) {
                            v6.setTranslationX(800f);
                        }

                        if(v6 != null) {
                            v6.setAlpha(0f);
                        }

                        try {
                            v0_2 = this.windowManager;
                            if(v0_2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v7);
                                v0_2 = ((SessionOverlayWindows)v4);
                            }

                            v11 = this.hudView;
                            if(v11 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v3);
                                v11 = ((View)v4);
                            }

                            if(v0_2.isManaged(v11)) {
                                v0 = this.hudView;
                                if(v0 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                                    v0 = ((View)v4);
                                }

                                if(v0.getParent() != null) {
                                    goto label_143;
                                }

                                goto label_129;
                            }
                            else {
                            label_129:
                                v0_2 = this.windowManager;
                                if(v0_2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(v7);
                                    v0_2 = ((SessionOverlayWindows)v4);
                                }

                                v11 = this.hudView;
                                if(v11 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                                    v11 = ((View)v4);
                                }

                                WindowManager$LayoutParams v12 = this.hudParams;
                                if(v12 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("hudParams");
                                    ViewGroup$LayoutParams v12_1 = ((ViewGroup$LayoutParams)v4);
                                }

                                v0_2.addView(v11, ((ViewGroup$LayoutParams)v12));
                            }

                        label_143:
                            this.mantenerCursorAlFrente();
                            v0_4 = true;
                        }
                        catch(Exception v0_3) {
                            Log.w("GOLDEN_UI", "No se pudo completar la apertura del HUB", ((Throwable)v0_3));
                            v0_4 = false;
                        }

                        SessionOverlayWindows v11_1 = this.windowManager;
                        if(v11_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v7);
                            v11_1 = ((SessionOverlayWindows)v4);
                        }

                        View v12_2 = this.hudView;
                        if(v12_2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3);
                            v12_2 = ((View)v4);
                        }

                        if(v11_1.isManaged(v12_2)) {
                            v11_1 = this.windowManager;
                            if(v11_1 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v7);
                                v11_1 = ((SessionOverlayWindows)v4);
                            }

                            if(!v11_1.getSuspended()) {
                                v11 = this.hudView;
                                if(v11 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                                    v11 = ((View)v4);
                                }

                                if(v11.getParent() != null) {
                                    goto label_174;
                                }

                                goto label_222;
                            }

                        label_174:
                            this.setHudVisible(true);
                            if(v6 != null) {
                                this.vigilarCancelacionPanel(v6, v9);
                            }

                            long v1 = 350;
                            float v3_1 = 1f;
                            if(v5 != null) {
                                ViewPropertyAnimator v5_1 = v5.animate();
                                if(v5_1 != null) {
                                    v5_1 = v5_1.translationX(0f);
                                    if(v5_1 != null) {
                                        v5_1 = v5_1.alpha(v3_1);
                                        if(v5_1 != null) {
                                            v5_1 = v5_1.setDuration(v1);
                                            if(v5_1 != null) {
                                                v5_1 = v5_1.setInterpolator(new DecelerateInterpolator());
                                                if(v5_1 != null) {
                                                    v4_1 = v5_1.withEndAction(v4);
                                                    if(v4_1 != null) {
                                                        v4_1.start();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            if(v6 != null) {
                                v4_1 = v6.animate();
                                if(v4_1 != null) {
                                    v4_1 = v4_1.translationX(0f);
                                    if(v4_1 != null) {
                                        ViewPropertyAnimator v3_2 = v4_1.alpha(v3_1);
                                        if(v3_2 != null) {
                                            ViewPropertyAnimator v1_1 = v3_2.setDuration(v1);
                                            if(v1_1 != null) {
                                                v1_1 = v1_1.setInterpolator(new DecelerateInterpolator());
                                                if(v1_1 != null) {
                                                    v1_1 = v1_1.withEndAction(new FloatingService$$ExternalSyntheticLambda105(this, v9));
                                                    if(v1_1 != null) {
                                                        v1_1.start();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            if(v6 == null) {
                                HubWindowTransition.finish$default(this.hubTransitions, v9, false, 2, null);
                            }

                            this.iniciarMonitoreo();
                            this.configurarSliders();
                            return v0_4;
                        }

                    label_222:
                        v0 = this.hudView;
                        if(v0 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3);
                            v0 = ((View)v4);
                        }

                        if(v0.getParent() == null) {
                            v0_2 = this.windowManager;
                            if(v0_2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v7);
                                v0_2 = ((SessionOverlayWindows)v4);
                            }

                            v5 = this.hudView;
                            if(v5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(v3);
                            }
                            else {
                                View v4_2 = v5;
                            }

                            v0_2.removeViewImmediate(((View)v4));
                        }

                        this.setHudVisible(false);
                        this.hubTransitions.finish(v9, true);
                        return 0;
                    }
                }

                this.setPanelTransitioning(true);
                this.cerrarPanelFpsConAnimacion(new FloatingService$$ExternalSyntheticLambda0(this));
                return 0;
            }
        }

        this.recuperarAccesoHub();
        return 0;
    }

    static final void mostrarHudXML$lambda$101(FloatingService arg6, long arg7) {
        HubWindowTransition.finish$default(arg6.hubTransitions, arg7, false, 2, null);
    }

    static final Unit mostrarHudXML$lambda$98(FloatingService arg1) {
        arg1.setPanelTransitioning(false);
        arg1.mostrarHudXML();
        return Unit.INSTANCE;
    }

    static final Unit mostrarHudXML$lambda$99(FloatingService arg2, View arg3, View arg4, boolean arg5) {
        arg2.setPanelTransitioning(false);
        if((arg5) && (arg2.isHudVisible)) {
            SessionOverlayWindows v5 = arg2.windowManager;
            View v0 = null;
            if(v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v5 = ((SessionOverlayWindows)v0);
            }

            View v1 = arg2.hudView;
            if(v1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hudView");
            }
            else {
                v0 = v1;
            }

            if(!v5.isManaged(v0)) {
                goto label_29;
            }

            if(arg3 != null) {
                arg3.setTranslationX(0f);
            }

            float v0_1 = 1f;
            if(arg3 != null) {
                arg3.setAlpha(v0_1);
            }

            if(arg4 != null) {
                arg4.setTranslationX(0f);
            }

            if(arg4 == null) {
                goto label_29;
            }

            arg4.setAlpha(v0_1);
        }

    label_29:
        arg2.recuperarAccesoHub();
        return Unit.INSTANCE;
    }

    private final void mostrarMapeo() {
        SessionOverlayWindows v0_2;
        if(!this.isActive) {
        }
        else if(!this.isMapeoVisible) {
            this.setMapeoVisible(true);
            View v0 = this.floatingIconView;
            ViewGroup$LayoutParams v1 = null;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
                v0 = ((View)v1);
            }

            v0.setVisibility(8);
            this.ocultarHudXML(false);
            this.setPanelTransitioning(false);
            this.isMenuMapeoMinimizado = false;
            View v2 = this.mapeoView;
            String v3 = "mapeoView";
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v2 = ((View)v1);
            }

            v2.setBackgroundColor(Color.parseColor("#990A0A0A"));
            v2 = this.mapeoView;
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v2 = ((View)v1);
            }

            v2 = v2.findViewById(id.panelMapeoTeclas);
            if(v2 != null) {
                v2.setVisibility(0);
            }

            v2 = this.mapeoView;
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v2 = ((View)v1);
            }

            v2 = v2.findViewById(id.contenedorCortinaMapeo);
            if(v2 != null) {
                v2.setVisibility(0);
            }

            if(v2 != null) {
                v2.setTranslationY(0f);
            }

            if(v2 != null) {
                v2.bringToFront();
            }

            v0 = this.mapeoView;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0 = ((View)v1);
            }

            v0 = v0.findViewById(id.btnToggleMinimizarMapeo);
            if(v0 != null) {
                v0.bringToFront();
            }

            WindowManager$LayoutParams v0_1 = this.mapeoParams;
            String v2_1 = "mapeoParams";
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                v0_1 = ((WindowManager$LayoutParams)v1);
            }

            v0_1.flags = 0x308;
            v0_1 = this.mapeoParams;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                v0_1 = ((WindowManager$LayoutParams)v1);
            }

            v0_1.alpha = 1f;
            try {
                v0_2 = this.windowManager;
            }
            catch(Exception ) {
                goto label_108;
            }

            String v4 = "windowManager";
            if(v0_2 == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException(v4);
                    v0_2 = ((SessionOverlayWindows)v1);
                label_74:
                    View v5 = this.mapeoView;
                    if(v5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3);
                        v5 = ((View)v1);
                    }

                    boolean v0_3 = v0_2.isManaged(v5);
                    goto label_79;
                }
                catch(Exception ) {
                    goto label_108;
                }
            }

            goto label_74;
        label_79:
            SessionOverlayWindows v5_1 = this.windowManager;
            if(!v0_3) {
                if(v5_1 == null) {
                    try {
                        Intrinsics.throwUninitializedPropertyAccessException(v4);
                        v5_1 = ((SessionOverlayWindows)v1);
                    label_84:
                        v0 = this.mapeoView;
                        if(v0 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3);
                            v0 = ((View)v1);
                        }

                        WindowManager$LayoutParams v3_1 = this.mapeoParams;
                        if(v3_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                        }
                        else {
                            goto label_92;
                        }

                    label_93:
                        v5_1.addView(v0, v1);
                        goto label_108;
                    label_92:
                        WindowManager$LayoutParams v1_1 = v3_1;
                        goto label_93;
                    label_95:
                        if(v5_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v4);
                            v5_1 = ((SessionOverlayWindows)v1);
                        }

                        v0 = this.mapeoView;
                        if(v0 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3);
                            v0 = ((View)v1);
                        }

                        v3_1 = this.mapeoParams;
                        if(v3_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                        }
                        else {
                            goto label_106;
                        }

                    label_107:
                        v5_1.updateViewLayout(v0, v1);
                        goto label_108;
                    label_106:
                        v1_1 = v3_1;
                        goto label_107;
                    }
                    catch(Exception ) {
                    label_108:
                        this.aplicarAjustesVisualesBotones();
                        this.mantenerCursorAlFrente();
                        this.solicitarReparacionIds();
                        return;
                    }
                }

                goto label_84;
            }
            else {
                goto label_95;
            }
        }
    }

    private final void mostrarMenuTipos(FrameLayout arg10) {
        View v2_1;
        View v0_1;
        if(!this.isActive) {
        }
        else {
            if(this.subMenuVista != null) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        ViewGroup v2 = null;
        try {
            v0_1 = LayoutInflater.from(new ContextThemeWrapper(this, style.Theme_MaterialComponents_DayNight_NoActionBar)).inflate(layout.layout_menu_tipos, v2);
            WindowManager$LayoutParams v3 = new WindowManager$LayoutParams(-1, -1, 0x7F6, 0x308, -3);
            if(Build$VERSION.SDK_INT >= 30) {
                v3.layoutInDisplayCutoutMode = 3;
            }
            else if(Build$VERSION.SDK_INT >= 28) {
                v3.layoutInDisplayCutoutMode = 1;
            }

            this.minimizarMenuMapeo(true);
            FloatingService$$ExternalSyntheticLambda56 v4 = new FloatingService$$ExternalSyntheticLambda56(this);
            v0_1.findViewById(id.btnTipoTocar).setOnClickListener(new FloatingService$$ExternalSyntheticLambda57(this, arg10, ((Function0)v4)));
            v0_1.findViewById(id.btnTipoMacro).setOnClickListener(new FloatingService$$ExternalSyntheticLambda58(this, arg10, ((Function0)v4)));
            v0_1.findViewById(id.btnTipoJoystick).setOnClickListener(new FloatingService$$ExternalSyntheticLambda59(this, arg10, ((Function0)v4)));
            v0_1.findViewById(id.btnTipoVista).setOnClickListener(new FloatingService$$ExternalSyntheticLambda60(this, arg10, ((Function0)v4)));
            v0_1.findViewById(id.btnTipoDisparo).setOnClickListener(new FloatingService$$ExternalSyntheticLambda61(this, arg10, ((Function0)v4)));
            v0_1.findViewById(id.btnTipoRaton).setOnClickListener(new FloatingService$$ExternalSyntheticLambda62(this, arg10, ((Function0)v4)));
            FloatingService$$ExternalSyntheticLambda63 v10 = new FloatingService$$ExternalSyntheticLambda63(((Function0)v4));
            v0_1.findViewById(id.btnCancelarMenu).setOnClickListener(((View$OnClickListener)v10));
            v0_1.findViewById(id.fondoCerrarMenu).setOnClickListener(((View$OnClickListener)v10));
            SessionOverlayWindows v10_1 = this.windowManager;
            if(v10_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v10_1 = ((SessionOverlayWindows)v2);
            }

            Intrinsics.checkNotNull(v0_1);
            v10_1.addView(v0_1, ((ViewGroup$LayoutParams)v3));
            this.mantenerCursorAlFrente();
            this.subMenuVista = v0_1;
            return;
        }
        catch(Exception v0) {
            Exception v10_2 = v0;
            v0_1 = this.mapeoView;
            String v3_1 = "mapeoView";
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_1);
                v0_1 = ((View)v2);
            }

            v0_1 = v0_1.findViewById(id.contenedorCortinaMapeo);
            if(v0_1 != null) {
                v0_1.setVisibility(0);
            }

            if(v0_1 != null) {
                v0_1.bringToFront();
            }

            v0_1 = this.mapeoView;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_1);
            }
            else {
                v2_1 = v0_1;
            }

            v0_1 = v2_1.findViewById(id.btnToggleMinimizarMapeo);
            if(v0_1 != null) {
                v0_1.bringToFront();
            }

            Toast.makeText(((Context)this), "Error: " + v10_2.getMessage(), 1).show();
            return;
        }
    }

    static final Unit mostrarMenuTipos$lambda$126(FloatingService arg4) {
        View v0 = arg4.subMenuVista;
        View v1 = null;
        if(v0 != null) {
            SessionOverlayWindows v2 = arg4.windowManager;
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v2 = ((SessionOverlayWindows)v1);
            }

            v2.removeView(v0);
            arg4.subMenuVista = v1;
        }

        v0 = arg4.mapeoView;
        String v2_1 = "mapeoView";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2_1);
            v0 = v1;
        }

        v0 = v0.findViewById(id.contenedorCortinaMapeo);
        if(v0 != null) {
            v0.setVisibility(0);
        }

        if(v0 != null) {
            v0.bringToFront();
        }

        View v4 = arg4.mapeoView;
        if(v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2_1);
            v4 = v1;
        }

        v4 = v4.findViewById(id.btnToggleMinimizarMapeo);
        if(v4 != null) {
            v4.bringToFront();
            return Unit.INSTANCE;
        }

        return ((Unit)v1);
    }

    static final void mostrarMenuTipos$lambda$127(FloatingService arg10, FrameLayout arg11, Function0 arg12, View arg13) {
        FloatingService.crearControlArrastrable$default(arg10, arg11, "TOCAR", null, null, null, 0, 0, 0x7C, null);
        arg12.invoke();
    }

    static final void mostrarMenuTipos$lambda$128(FloatingService arg10, FrameLayout arg11, Function0 arg12, View arg13) {
        FloatingService.crearControlArrastrable$default(arg10, arg11, "MACRO_SCRIPT", null, null, null, 0, 0, 0x7C, null);
        arg12.invoke();
    }

    static final void mostrarMenuTipos$lambda$129(FloatingService arg10, FrameLayout arg11, Function0 arg12, View arg13) {
        FloatingService.crearControlArrastrable$default(arg10, arg11, "JOYSTICK", null, null, null, 0, 0, 0x7C, null);
        arg12.invoke();
    }

    static final void mostrarMenuTipos$lambda$130(FloatingService arg10, FrameLayout arg11, Function0 arg12, View arg13) {
        FloatingService.crearControlArrastrable$default(arg10, arg11, "VISTA", null, null, null, 0, 0, 0x7C, null);
        arg12.invoke();
    }

    static final void mostrarMenuTipos$lambda$131(FloatingService arg10, FrameLayout arg11, Function0 arg12, View arg13) {
        FloatingService.crearControlArrastrable$default(arg10, arg11, "DISPARO", null, null, null, 0, 0, 0x7C, null);
        FloatingService.guardarConfiguracion$default(arg10, false, 1, null);
        FloatingService.aplicarPerfilActualAlMotor$default(arg10, null, 1, null);
        arg12.invoke();
    }

    static final void mostrarMenuTipos$lambda$132(FloatingService arg12, FrameLayout arg13, Function0 arg14, View arg15) {
        FloatingService.cerrarEditorTecla$default(arg12, false, 1, null);
        FloatingService.crearControlArrastrable$default(arg12, arg13, "VISTA_LIBRE_VISUAL", null, null, null, 0, 0, 0x7C, null);
        arg14.invoke();
    }

    static final void mostrarMenuTipos$lambda$133(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    private final void mostrarPanelAjustes() {
        if((this.isActive) && (this.isHudVisible) && !this.isPanelTransitioning) {
            if(this.hubTransitions.getRunning()) {
            }
            else if(this.settingsPanelView == null && !this.isSettingsTransitioning && this.mousePanelView == null) {
                if(this.isMousePanelTransitioning) {
                }
                else {
                    this.setSettingsTransitioning(true);
                    this.ocultarHudParaPanel(new FloatingService$$ExternalSyntheticLambda165(this));
                }
            }
        }
    }

    static final Unit mostrarPanelAjustes$lambda$161(FloatingService arg13) {
        Object v0_5;
        View v0_2;
        Exception v4_1;
        View v4;
        ContextThemeWrapper v0_1;
        String v1 = "windowManager";
        View v3 = null;
        try {
            v0_1 = new ContextThemeWrapper(arg13, style.Theme_MaterialComponents_DayNight_NoActionBar);
            v4 = SettingsPanelFactory.create(v0_1);
        }
        catch(Exception v0) {
            v4_1 = v0;
            v0_2 = v3;
            goto label_76;
        }

        try {
            View v5 = v4.findViewById(id.panelContainer);
            if(v5 != null) {
                SharedPreferences v6 = arg13.getSharedPreferences("GoldenMouseVisual", 0);
                Intrinsics.checkNotNull(v4);
                Intrinsics.checkNotNull(v6);
                arg13.enlazarControlesAjustes(v4, ((Context)v0_1), v6);
                v4.setOnClickListener(new FloatingService$$ExternalSyntheticLambda76(arg13));
                v0_2 = v4.findViewById(id.btnCloseSettings);
                if(v0_2 != null) {
                    v0_2.setOnClickListener(new FloatingService$$ExternalSyntheticLambda78(arg13));
                }

                WindowManager$LayoutParams v6_1 = new WindowManager$LayoutParams(-1, -1, 0x7F6, 0x308, -3);
                if(Build$VERSION.SDK_INT >= 30) {
                    v6_1.layoutInDisplayCutoutMode = 3;
                }
                else if(Build$VERSION.SDK_INT >= 28) {
                    v6_1.layoutInDisplayCutoutMode = 1;
                }

                v5.setTranslationX(300f * arg13.getResources().getDisplayMetrics().density);
                v5.setAlpha(0f);
                SessionOverlayWindows v0_3 = arg13.windowManager;
                if(v0_3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v0_3 = ((SessionOverlayWindows)v3);
                }

                v0_3.addView(v4, ((ViewGroup$LayoutParams)v6_1));
                arg13.setSettingsPanelView(v4);
                arg13.mantenerCursorAlFrente();
                v5.post(new FloatingService$$ExternalSyntheticLambda79(arg13, v4, v5));
                goto label_107;
            }

            throw new IllegalStateException("AJUSTES no contiene panelContainer".toString());
        }
        catch(Exception v0) {
            View v12 = v4;
            v4_1 = v0;
            v0_2 = v12;
        }

    label_76:
        if(v0_2 != null) {
            try {
                SessionOverlayWindows v5_1 = arg13.windowManager;
                if(v5_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v5_1 = ((SessionOverlayWindows)v3);
                }

                if(v5_1.isManaged(v0_2)) {
                    v5_1 = arg13.windowManager;
                    if(v5_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1);
                        v5_1 = ((SessionOverlayWindows)v3);
                    }

                    v5_1.removeViewImmediate(v0_2);
                }

                v0_5 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0_4) {
                v0_5 = Result.constructor-impl(ResultKt.createFailure(v0_4));
            }

            Result.box-impl(v0_5);
        }

        arg13.setSettingsPanelView(v3);
        arg13.setSettingsTransitioning(false);
        Log.e("GOLDEN_UI", "No se pudo abrir AJUSTES", ((Throwable)v4_1));
        Toast.makeText(arg13, "No se pudieron abrir los ajustes", 0).show();
        arg13.volverAlHubTrasPanel();
    label_107:
        return Unit.INSTANCE;
    }

    static final void mostrarPanelAjustes$lambda$161$lambda$154(FloatingService arg0, View arg1) {
        arg0.cerrarPanelAjustes();
    }

    static final void mostrarPanelAjustes$lambda$161$lambda$155(FloatingService arg0, View arg1) {
        arg0.cerrarPanelAjustes();
    }

    static final void mostrarPanelAjustes$lambda$161$lambda$158(FloatingService arg2, View arg3, View arg4) {
        if(arg2.settingsPanelView == arg3) {
            SessionOverlayWindows v0 = arg2.windowManager;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v0 = null;
            }

            Intrinsics.checkNotNull(arg3);
            if(!v0.isManaged(arg3)) {
                return;
            }

            long v0_1 = arg2.hubTransitions.begin(new FloatingService$$ExternalSyntheticLambda96(arg2, arg3, arg4));
            arg2.vigilarCancelacionPanel(arg4, v0_1);
            arg4.setTranslationX(((float)arg4.getWidth()));
            arg2.animarPanelLateral(arg4, true, new FloatingService$$ExternalSyntheticLambda97(arg2, v0_1));
        }
    }

    static final Unit mostrarPanelAjustes$lambda$161$lambda$158$lambda$156(FloatingService arg2, View arg3, View arg4, boolean arg5) {
        if(arg2.settingsPanelView != arg3) {
            return Unit.INSTANCE;
        }

        arg2.setSettingsTransitioning(false);
        SessionOverlayWindows v0 = arg2.windowManager;
        View v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            v0 = ((SessionOverlayWindows)v1);
        }

        Intrinsics.checkNotNull(arg3);
        if(!v0.isManaged(arg3)) {
            arg2.setSettingsPanelView(v1);
            arg2.volverAlHubTrasPanel();
        }
        else if(arg5) {
            arg4.setTranslationX(0f);
            arg4.setAlpha(1f);
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrarPanelAjustes$lambda$161$lambda$158$lambda$157(FloatingService arg6, long arg7) {
        HubWindowTransition.finish$default(arg6.hubTransitions, arg7, false, 2, null);
        return Unit.INSTANCE;
    }

    private final void mostrarPanelFps() {
        ViewPropertyAnimator v2_1;
        Log.d("GOLDEN_UI", "Solicitud de monitoreo: hud=" + this.isHudVisible + ", transicion=" + this.isPanelTransitioning + ", visible=" + this.isFpsSettingsVisible);
        if(this.fpsSettingsView == null) {
            if(this.isFpsSettingsVisible) {
            }
            else {
                if((this.isPanelTransitioning) && !this.isHudVisible) {
                    return;
                }

                this.setPanelTransitioning(true);
                View v1 = this.floatingIconView;
                View v2 = null;
                if(v1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
                    v1 = v2;
                }

                v1.setVisibility(8);
                FloatingService$$ExternalSyntheticLambda40 v1_1 = new FloatingService$$ExternalSyntheticLambda40(this);
                if(this.isHudVisible) {
                    View v3 = this.hudView;
                    String v4 = "hudView";
                    if(v3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v4);
                        v3 = v2;
                    }

                    v3 = v3.findViewById(id.layoutPanelLeft);
                    View v9 = this.hudView;
                    if(v9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v4);
                    }
                    else {
                        v2 = v9;
                    }

                    v9 = v2.findViewById(id.layoutPanelRight);
                    if(v3 != null) {
                        v2_1 = v3.animate();
                        if(v2_1 != null) {
                            v2_1.cancel();
                        }
                    }

                    if(v9 != null) {
                        v2_1 = v9.animate();
                        if(v2_1 != null) {
                            v2_1.cancel();
                        }
                    }

                    if(v3 != null) {
                        if(v9 == null) {
                        }
                        else {
                            AnimatorSet v2_2 = new AnimatorSet();
                            v2_2.playTogether(new Animator[]{ObjectAnimator.ofFloat(v3, View.TRANSLATION_X, new float[]{-(((float)v3.getWidth()))}), ObjectAnimator.ofFloat(v3, View.ALPHA, new float[]{0f}), ObjectAnimator.ofFloat(v9, View.TRANSLATION_X, new float[]{((float)v9.getWidth())}), ObjectAnimator.ofFloat(v9, View.ALPHA, new float[]{0f})});
                            v2_2.setDuration(0xF0);
                            v2_2.setInterpolator(new AccelerateInterpolator());
                            v2_2.addListener(new FloatingService$mostrarPanelFps$salidaHud$1$1(((Function0)v1_1)));
                            v2_2.start();
                            return;
                        }
                    }

                    ((Function0)v1_1).invoke();
                    return;
                }

                ((Function0)v1_1).invoke();
            }
        }
    }

    static final Unit mostrarPanelFps$lambda$110(FloatingService arg2) {
        if(arg2.isHudVisible) {
            arg2.ocultarHudXML(false);
        }

        View v0 = arg2.floatingIconView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
            v0 = null;
        }

        v0.setVisibility(8);
        arg2.inflarPanelFps();
        return Unit.INSTANCE;
    }

    private final void mostrarPanelMouse() {
        if((this.isActive) && (this.isHudVisible) && !this.isPanelTransitioning) {
            if(this.hubTransitions.getRunning()) {
            }
            else if(this.mousePanelView == null && !this.isMousePanelTransitioning && this.settingsPanelView == null) {
                if(this.isSettingsTransitioning) {
                }
                else {
                    this.setMousePanelTransitioning(true);
                    this.ocultarHudParaPanel(new FloatingService$$ExternalSyntheticLambda80(this));
                }
            }
        }
    }

    static final Unit mostrarPanelMouse$lambda$176(FloatingService arg15) {
        Object v0_5;
        View v0_2;
        Exception v4_1;
        View v4;
        String v0 = "%";
        String v1 = "windowManager";
        View v3 = null;
        try {
            v4 = MousePanelFactory.create(new ContextThemeWrapper(arg15, style.Theme_MaterialComponents_DayNight_NoActionBar));
        }
        catch(Exception v0_1) {
            v4_1 = v0_1;
            v0_2 = v3;
            goto label_159;
        }

        try {
            View v5 = v4.findViewById(id.panelContainer);
            if(v5 != null) {
                v4.setOnClickListener(new FloatingService$$ExternalSyntheticLambda158(arg15));
                View v6 = v4.findViewById(id.btnCloseMouse);
                if(v6 != null) {
                    v6.setOnClickListener(new FloatingService$$ExternalSyntheticLambda159(arg15));
                }

                v4.findViewById(id.btnImagenPuntero).setOnClickListener(new FloatingService$$ExternalSyntheticLambda161(arg15));
                v6 = v4.findViewById(id.txtImagenPuntero);
                String v7 = arg15.hasCustomCursorImage ? "Personalizado  ›" : "Default  ›";
                ((TextView)v6).setText(((CharSequence)v7));
                SharedPreferences v6_1 = arg15.getSharedPreferences("mouse_settings", 0);
                View v7_1 = v4.findViewById(id.seekVelocidadPuntero);
                View v8 = v4.findViewById(id.txtVelocidadPuntero);
                View v9 = v4.findViewById(id.switchAceleracion);
                ((SeekBar)v7_1).setProgress(CursorMotionSettings.INSTANCE.getOptions().getSpeedPercent());
                ((TextView)v8).setText(((SeekBar)v7_1).getProgress() + v0);
                ((Switch)v9).setChecked(CursorMotionSettings.INSTANCE.getOptions().getAcceleration());
                ((SeekBar)v7_1).setOnSeekBarChangeListener(new FloatingService$mostrarPanelMouse$1$4(v6_1, ((TextView)v8)));
                ((Switch)v9).setOnCheckedChangeListener(new FloatingService$$ExternalSyntheticLambda162(v6_1));
                v7_1 = v4.findViewById(id.seekTamanoPuntero);
                v8 = v4.findViewById(id.txtTamanoPuntero);
                v9 = v4.findViewById(id.seekTransparenciaPuntero);
                View v10 = v4.findViewById(id.txtTransparenciaPuntero);
                int v11 = RangesKt.coerceIn(v6_1.getInt("transparencia_puntero", 100), 0, 100);
                ((SeekBar)v9).setProgress(v11);
                ((TextView)v10).setText(v11 + v0);
                ((SeekBar)v9).setOnSeekBarChangeListener(new FloatingService$mostrarPanelMouse$1$6(((TextView)v10), arg15, v6_1));
                int v9_1 = RangesKt.coerceIn(v6_1.getInt("tamano_puntero", 100), 0, 200);
                ((SeekBar)v7_1).setProgress(v9_1);
                ((TextView)v8).setText(v9_1 + v0);
                ((SeekBar)v7_1).setOnSeekBarChangeListener(new FloatingService$mostrarPanelMouse$1$7(((TextView)v8), arg15, v6_1));
                WindowManager$LayoutParams v8_1 = new WindowManager$LayoutParams(-1, -1, 0x7F6, 0x308, -3);
                if(Build$VERSION.SDK_INT >= 30) {
                    v8_1.layoutInDisplayCutoutMode = 3;
                }
                else if(Build$VERSION.SDK_INT >= 28) {
                    v8_1.layoutInDisplayCutoutMode = 1;
                }

                v8_1.flags &= -9;
                v8_1.softInputMode = 19;
                v5.setTranslationX(300f * arg15.getResources().getDisplayMetrics().density);
                v5.setAlpha(0f);
                SessionOverlayWindows v0_3 = arg15.windowManager;
                if(v0_3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v0_3 = ((SessionOverlayWindows)v3);
                }

                Intrinsics.checkNotNull(v4);
                v0_3.addView(v4, ((ViewGroup$LayoutParams)v8_1));
                arg15.setMousePanelView(v4);
                arg15.getMousePanelController().open(v4);
                MousePanelFactory.stylePolling(v4);
                arg15.mantenerCursorAlFrente();
                v5.post(new FloatingService$$ExternalSyntheticLambda163(arg15, v4, v5));
                goto label_192;
            }

            throw new IllegalStateException("mouse.xml no contiene panelContainer".toString());
        }
        catch(Exception v0_1) {
            View v14 = v4;
            v4_1 = v0_1;
            v0_2 = v14;
        }

    label_159:
        if(v0_2 != null) {
            try {
                SessionOverlayWindows v5_1 = arg15.windowManager;
                if(v5_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v5_1 = ((SessionOverlayWindows)v3);
                }

                if(v5_1.isManaged(v0_2)) {
                    v5_1 = arg15.windowManager;
                    if(v5_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1);
                        v5_1 = ((SessionOverlayWindows)v3);
                    }

                    v5_1.removeViewImmediate(v0_2);
                }

                v0_5 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0_4) {
                v0_5 = Result.constructor-impl(ResultKt.createFailure(v0_4));
            }

            Result.box-impl(v0_5);
        }

        arg15.setMousePanelView(v3);
        arg15.setMousePanelTransitioning(false);
        arg15.getMousePanelController().close();
        Log.e("GOLDEN_UI", "No se pudo abrir mouse.xml", ((Throwable)v4_1));
        Toast.makeText(arg15, "No se pudo abrir el panel Mouse", 0).show();
        arg15.volverAlHubTrasPanel();
    label_192:
        return Unit.INSTANCE;
    }

    static final void mostrarPanelMouse$lambda$176$lambda$167(FloatingService arg0, View arg1) {
        arg0.cerrarPanelMouse();
    }

    static final void mostrarPanelMouse$lambda$176$lambda$168(FloatingService arg0, View arg1) {
        arg0.cerrarPanelMouse();
    }

    static final void mostrarPanelMouse$lambda$176$lambda$169(FloatingService arg0, View arg1) {
        arg0.abrirSelectorImagenPuntero();
    }

    static final void mostrarPanelMouse$lambda$176$lambda$170(SharedPreferences arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        CursorMotionSettings v2 = CursorMotionSettings.INSTANCE;
        Intrinsics.checkNotNull(arg1);
        v2.setAcceleration(arg1, arg3);
    }

    static final void mostrarPanelMouse$lambda$176$lambda$173(FloatingService arg2, View arg3, View arg4) {
        if(arg2.mousePanelView == arg3) {
            SessionOverlayWindows v0 = arg2.windowManager;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                v0 = null;
            }

            Intrinsics.checkNotNull(arg3);
            if(!v0.isManaged(arg3)) {
                return;
            }

            long v0_1 = arg2.hubTransitions.begin(new FloatingService$$ExternalSyntheticLambda108(arg2, arg3, arg4));
            arg2.vigilarCancelacionPanel(arg4, v0_1);
            arg4.setTranslationX(((float)arg4.getWidth()));
            arg2.animarPanelLateral(arg4, true, new FloatingService$$ExternalSyntheticLambda109(arg2, v0_1));
        }
    }

    static final Unit mostrarPanelMouse$lambda$176$lambda$173$lambda$171(FloatingService arg2, View arg3, View arg4, boolean arg5) {
        if(arg2.mousePanelView != arg3) {
            return Unit.INSTANCE;
        }

        arg2.setMousePanelTransitioning(false);
        SessionOverlayWindows v0 = arg2.windowManager;
        View v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            v0 = ((SessionOverlayWindows)v1);
        }

        Intrinsics.checkNotNull(arg3);
        if(!v0.isManaged(arg3)) {
            arg2.setMousePanelView(v1);
            arg2.getMousePanelController().close();
            arg2.volverAlHubTrasPanel();
        }
        else if(arg5) {
            arg4.setTranslationX(0f);
            arg4.setAlpha(1f);
        }

        return Unit.INSTANCE;
    }

    static final Unit mostrarPanelMouse$lambda$176$lambda$173$lambda$172(FloatingService arg6, long arg7) {
        HubWindowTransition.finish$default(arg6.hubTransitions, arg7, false, 2, null);
        return Unit.INSTANCE;
    }

    private final void mostrarRetrocesoVisual() {
        FloatingService$$ExternalSyntheticLambda135 v0_5;
        View v5_1;
        Dialog v6_1;
        FloatingService v7_1;
        View v11_2;
        RecoilSettingsForm v2_3;
        BooleanRef v3_1;
        View v12_1;
        BooleanRef v1_3;
        BooleanRef v2_2;
        int v12;
        WindowManager$LayoutParams v1_1;
        Window v0_2;
        View v7;
        View v4;
        View v3;
        FloatingService v6 = this;
        if(!v6.isActive) {
            return;
        }

        if(v6.retrocesoDialog != null) {
            return;
        }

        if(v6.isPanelTransitioning) {
            return;
        }

        FloatingService v8 = v6;
        ContextThemeWrapper v0 = new ContextThemeWrapper(((Context)v8), style.Theme_MaterialComponents_DayNight_NoActionBar);
        Dialog v5 = new Dialog(v0);
        try {
            v5.requestWindowFeature(1);
            LayoutInflater v1 = LayoutInflater.from(v0);
            FrameLayout v2 = new FrameLayout(v0);
            v3 = RecoilPanelFactory.create(((Context)v0));
            v4 = v1.inflate(layout.editor_retroceso_xy, v2, false);
            v7 = v3.findViewById(id.panelContainer);
            if(v7 == null) {
                goto label_188;
            }

            v2.addView(v3);
            v2.addView(v4);
            v4.setVisibility(8);
            v7.setTranslationX(300f * v6.getResources().getDisplayMetrics().density);
            v7.setAlpha(0f);
            v5.setContentView(((View)v2));
            WindowFocusPolicy.INSTANCE.prepare(v5);
            v0_2 = v5.getWindow();
            if(v0_2 == null) {
                goto label_183;
            }

            v1_1 = v6.mapeoParams;
        }
        catch(Exception v0_1) {
            goto label_194;
        }

        String v2_1 = "mapeoParams";
        WindowManager$LayoutParams v11 = null;
        if(v1_1 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                v1_1 = v11;
            label_53:
                v0_2.setType(v1_1.type);
                v0_2.setWindowAnimations(com.TryJeanPc.goldenmouse.R$style.VistaJoystickWindowAnimations);
                v0_2.setBackgroundDrawable(new ColorDrawable(0));
                v12 = 2;
                v0_2.clearFlags(v12);
                v0_2.addFlags(0x100);
                v0_2.setSoftInputMode(19);
                v0_2.getDecorView().setPadding(0, 0, 0, 0);
                View v1_2 = v0_2.getDecorView();
                View v13 = v6.mapeoView;
                if(v13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
                    v13 = ((View)v11);
                }

                v1_2.setSystemUiVisibility(v13.getSystemUiVisibility());
                if(Build$VERSION.SDK_INT >= 28) {
                    v1_1 = v0_2.getAttributes();
                    WindowManager$LayoutParams v13_1 = v6.mapeoParams;
                    if(v13_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v2_1);
                    }
                    else {
                        v11 = v13_1;
                    }

                    v1_1.layoutInDisplayCutoutMode = v11.layoutInDisplayCutoutMode;
                    v0_2.setAttributes(v1_1);
                }

                v0_2.setGravity(17);
                v0_2.setLayout(-1, -1);
                v2_2 = new BooleanRef();
                v1_3 = new BooleanRef();
                v1_3.element = true;
                Intrinsics.checkNotNull(v3);
                Intrinsics.checkNotNull(v4);
                RecoilSettings v0_3 = v6.recoilSettings;
                if(v0_3 == null) {
                    v0_3 = v6.getRecoilSettingsStore().load();
                }

                RecoilSettings v14 = v0_3;
                int v0_4 = v12;
                RecoilSettingsForm v11_1 = new RecoilSettingsForm(v3, v4, v14, v6.getRecoilSettingsStore(), new FloatingService$$ExternalSyntheticLambda131(v6), new FloatingService$$ExternalSyntheticLambda132(v1_3, v2_2, v3, v4, v5, v6));
                v3.setOnClickListener(new FloatingService$$ExternalSyntheticLambda133(v1_3, v6, v5, v7));
                v3.findViewById(id.btnCloseRetroceso).setOnClickListener(new FloatingService$$ExternalSyntheticLambda134(v1_3, v6, v5, v7));
                v12_1 = v3.findViewById(id.btnEditarCurvasRetroceso);
                int v13_2 = v0_4;
                View v18 = v3;
                v3_1 = v2_2;
                v2_3 = v11_1;
                v11_2 = v7;
                v7_1 = v6;
                v6_1 = v5;
                v5_1 = v4;
                v4 = v18;
                goto label_138;
            }
            catch(Exception v0_1) {
                goto label_194;
            }
        }

        goto label_53;
        try {
        label_138:
            v0_5 = new FloatingService$$ExternalSyntheticLambda135(v1_3, v2_3, v3_1, v4, v5_1, v6_1, v7_1);
            v2_2 = v3_1;
            v3 = v4;
            v4 = v5_1;
            v5 = v6_1;
        }
        catch(Exception v0_1) {
            v5 = v6_1;
            v6 = v7_1;
            goto label_194;
        }

        try {
            v12_1.setOnClickListener(((View$OnClickListener)v0_5));
            int[] v7_2 = new int[]{id.btnCerrarEditorRetroceso, id.btnCancelarEditorRetroceso};
            for(v12 = 0; v12 < v13_2; ++v12) {
                v4.findViewById(v7_2[v12]).setOnClickListener(new FloatingService$$ExternalSyntheticLambda136(v1_3, v2_2, v3, v4, v5, this));
            }

            v5.setCancelable(true);
            v5.setCanceledOnTouchOutside(false);
            BooleanRef v6_2 = v2_2;
            v2_2 = v1_3;
            v1_3 = v6_2;
            v6 = this;
            v7 = v11_2;
        }
        catch(Exception v0_1) {
            goto label_177;
        }

        try {
            v5.setOnKeyListener(new FloatingService$$ExternalSyntheticLambda137(v1_3, v2_2, v3, v4, v5, v6, v7));
            v5.setOnDismissListener(new FloatingService$$ExternalSyntheticLambda139(v7, v6, v5));
            v6.setRetrocesoDialog(v5);
            v6.ocultarHudParaPanel(new FloatingService$$ExternalSyntheticLambda140(v6, v5, v7, v2_2));
            return;
        label_177:
            v6 = this;
            goto label_194;
        label_183:
            throw new IllegalStateException("La ventana de retroceso no está disponible".toString());
        label_188:
            throw new IllegalStateException("configurar_retroceso.xml no contiene panelContainer".toString());
        }
        catch(Exception v0_1) {
        }

    label_194:
        FloatingService.mostrarRetrocesoVisual$cerrar(((FloatingService)v6_1), ((Dialog)v5_1));
        ((Dialog)v5_1).dismiss();
        Log.e("GOLDEN_UI", "No se pudo preparar la ventana visual de retroceso", ((Throwable)v0_1));
        Toast.makeText(((Context)v8), "No se pudo abrir Retroceso", 0).show();
    }

    private static final void mostrarRetrocesoVisual$cerrar(FloatingService arg1, Dialog arg2) {
        if(arg1.retrocesoDialog != arg2) {
        }
        else {
            arg1.setRetrocesoDialog(null);
            arg2.dismiss();
            if(arg1.isActive) {
                arg1.mostrarHudXML();
            }
        }
    }

    private static final void mostrarRetrocesoVisual$cerrarConAnimacion(BooleanRef arg1, FloatingService arg2, Dialog arg3, View arg4) {
        if(!arg1.element) {
            if(arg2.retrocesoDialog != arg3) {
            }
            else {
                arg1.element = true;
                arg2.animarPanelLateral(arg4, false, new FloatingService$$ExternalSyntheticLambda90(arg2, arg3));
            }
        }
    }

    static final Unit mostrarRetrocesoVisual$cerrarConAnimacion$lambda$142(FloatingService arg0, Dialog arg1) {
        FloatingService.mostrarRetrocesoVisual$cerrar(arg0, arg1);
        return Unit.INSTANCE;
    }

    static final Unit mostrarRetrocesoVisual$lambda$143(FloatingService arg1, RecoilSettings arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg1.recoilSettings = arg2;
        arg1.goldenCoreController.configureRecoil(arg2);
        return Unit.INSTANCE;
    }

    static final Unit mostrarRetrocesoVisual$lambda$144(BooleanRef arg7, BooleanRef arg8, View arg9, View arg10, Dialog arg11, FloatingService arg12) {
        FloatingService.mostrarRetrocesoVisual$mostrarVista(arg7, arg8, arg9, arg10, arg11, arg12, false);
        return Unit.INSTANCE;
    }

    static final void mostrarRetrocesoVisual$lambda$145(BooleanRef arg0, FloatingService arg1, Dialog arg2, View arg3, View arg4) {
        FloatingService.mostrarRetrocesoVisual$cerrarConAnimacion(arg0, arg1, arg2, arg3);
    }

    static final void mostrarRetrocesoVisual$lambda$146(BooleanRef arg0, FloatingService arg1, Dialog arg2, View arg3, View arg4) {
        FloatingService.mostrarRetrocesoVisual$cerrarConAnimacion(arg0, arg1, arg2, arg3);
    }

    static final void mostrarRetrocesoVisual$lambda$147(BooleanRef arg0, RecoilSettingsForm arg1, BooleanRef arg2, View arg3, View arg4, Dialog arg5, FloatingService arg6, View arg7) {
        if(!arg0.element) {
            arg1.beginEditor();
            FloatingService.mostrarRetrocesoVisual$mostrarVista(arg0, arg2, arg3, arg4, arg5, arg6, true);
        }
    }

    static final void mostrarRetrocesoVisual$lambda$148(BooleanRef arg0, BooleanRef arg1, View arg2, View arg3, Dialog arg4, FloatingService arg5, View arg6) {
        FloatingService.mostrarRetrocesoVisual$mostrarVista(arg0, arg1, arg2, arg3, arg4, arg5, false);
    }

    static final boolean mostrarRetrocesoVisual$lambda$149(BooleanRef arg1, BooleanRef arg2, View arg3, View arg4, Dialog arg5, FloatingService arg6, View arg7, DialogInterface arg8, int arg9, KeyEvent arg10) {
        if(arg9 == 4) {
            if(arg10.getAction() == 1) {
                if(arg1.element) {
                    FloatingService.mostrarRetrocesoVisual$mostrarVista(arg2, arg1, arg3, arg4, arg5, arg6, false);
                }
                else {
                    FloatingService.mostrarRetrocesoVisual$cerrarConAnimacion(arg2, arg6, arg5, arg7);
                }
            }

            return 1;
        }

        return 0;
    }

    static final void mostrarRetrocesoVisual$lambda$150(View arg0, FloatingService arg1, Dialog arg2, DialogInterface arg3) {
        arg0.animate().withEndAction(null).cancel();
        FloatingService.mostrarRetrocesoVisual$cerrar(arg1, arg2);
    }

    static final Unit mostrarRetrocesoVisual$lambda$153(FloatingService arg1, Dialog arg2, View arg3, BooleanRef arg4) {
        if(arg1.isActive) {
            if(arg1.retrocesoDialog != arg2) {
            }
            else {
                try {
                    SessionOverlayWindowsKt.showSessionDialog(arg2);
                    arg1.bringCursorToFront();
                    arg3.post(new FloatingService$$ExternalSyntheticLambda66(arg1, arg2, arg3, arg4));
                }
                catch(Exception v3) {
                    FloatingService.mostrarRetrocesoVisual$cerrar(arg1, arg2);
                    Log.e("GOLDEN_UI", "No se pudo mostrar la ventana visual de retroceso", ((Throwable)v3));
                    Toast.makeText(((Context)arg1), "No se pudo abrir Retroceso", 0).show();
                }

                return Unit.INSTANCE;
            }
        }

        return Unit.INSTANCE;
    }

    static final void mostrarRetrocesoVisual$lambda$153$lambda$152(FloatingService arg1, Dialog arg2, View arg3, BooleanRef arg4) {
        if(arg1.retrocesoDialog == arg2) {
            if(!arg2.isShowing()) {
            }
            else {
                arg3.setTranslationX(((float)arg3.getWidth()));
                arg1.animarPanelLateral(arg3, true, new FloatingService$$ExternalSyntheticLambda178(arg4));
            }
        }
    }

    static final Unit mostrarRetrocesoVisual$lambda$153$lambda$152$lambda$151(BooleanRef arg1) {
        arg1.element = false;
        return Unit.INSTANCE;
    }

    private static final void mostrarRetrocesoVisual$mostrarVista(BooleanRef arg1, BooleanRef arg2, View arg3, View arg4, Dialog arg5, FloatingService arg6, boolean arg7) {
        if(!arg1.element) {
            if(arg2.element == arg7) {
            }
            else {
                arg2.element = arg7;
                int v1 = 8;
                int v0 = arg7 ? v1 : 0;
                arg3.setVisibility(v0);
                if(arg7) {
                    v1 = 0;
                }

                arg4.setVisibility(v1);
                if(!arg5.isShowing()) {
                    return;
                }

                arg6.bringCursorToFront();
            }
        }
    }

    private final void mostrarVentanaMacroScript(int arg8, Function2 arg9) {
        WindowManager$LayoutParams v3_1;
        this.cerrarVentanaMacroScript();
        ContextThemeWrapper v0 = new ContextThemeWrapper(this, style.Theme_MaterialComponents_DayNight_NoActionBar);
        Dialog v1 = new Dialog(((Context)v0));
        v1.requestWindowFeature(1);
        ViewGroup v3 = null;
        View v0_1 = LayoutInflater.from(((Context)v0)).inflate(arg8, v3);
        v1.setContentView(v0_1);
        v1.setCancelable(true);
        v1.setCanceledOnTouchOutside(false);
        Window v4 = v1.getWindow();
        if(v4 == null) {
            return;
        }

        WindowManager$LayoutParams v5 = this.mapeoParams;
        String v6 = "mapeoParams";
        if(v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v6);
            v5 = ((WindowManager$LayoutParams)v3);
        }

        v4.setType(v5.type);
        v4.setBackgroundDrawable(new ColorDrawable(0));
        v4.clearFlags(2);
        v4.addFlags(0x300);
        v4.setSoftInputMode(16);
        v4.getDecorView().setPadding(0, 0, 0, 0);
        View v2 = v4.getDecorView();
        View v5_1 = this.mapeoView;
        if(v5_1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
            v5_1 = ((View)v3);
        }

        v2.setSystemUiVisibility(v5_1.getSystemUiVisibility());
        if(Build$VERSION.SDK_INT >= 28) {
            WindowManager$LayoutParams v2_1 = v4.getAttributes();
            v5 = this.mapeoParams;
            if(v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
            }
            else {
                v3_1 = v5;
            }

            v2_1.layoutInDisplayCutoutMode = v3_1.layoutInDisplayCutoutMode;
            v4.setAttributes(v2_1);
        }

        Intrinsics.checkNotNull(v0_1);
        arg9.invoke(v0_1, new FloatingService$$ExternalSyntheticLambda14(this));
        if(arg8 == layout.configurar_macro) {
            v1.setOnKeyListener(new FloatingService$$ExternalSyntheticLambda15(this));
        }

        v1.setOnDismissListener(new FloatingService$$ExternalSyntheticLambda16(this, v1));
        this.macroScriptDialog = v1;
        try {
            SessionOverlayWindowsKt.showSessionDialog(v1);
            this.bringCursorToFront();
            v4.setLayout(-1, -1);
            return;
        }
        catch(Exception v8) {
            this.cerrarVentanaMacroScript();
            Log.e("GOLDEN_UI", "No se pudo abrir la ventana visual de Macro-Script", ((Throwable)v8));
            return;
        }
    }

    static final Unit mostrarVentanaMacroScript$lambda$253(FloatingService arg0) {
        arg0.cerrarVentanaMacroScript();
        return Unit.INSTANCE;
    }

    static final boolean mostrarVentanaMacroScript$lambda$254(FloatingService arg0, DialogInterface arg1, int arg2, KeyEvent arg3) {
        if(arg2 == 4) {
            if(arg3.getAction() == 1) {
                MacroEditorController v0 = arg0.macroEditorController;
                if(v0 != null) {
                    v0.requestCancel();
                }
            }

            return 1;
        }

        return 0;
    }

    static final void mostrarVentanaMacroScript$lambda$255(FloatingService arg0, Dialog arg1, DialogInterface arg2) {
        if(arg0.macroScriptDialog == arg1) {
            MacroEditorController v1 = arg0.macroEditorController;
            if(v1 != null) {
                v1.close();
            }

            arg0.macroEditorController = null;
            arg0.macroScriptDialog = null;
        }
    }

    private final void mostrarVistaEliminar(FrameLayout arg1, View arg2, ControlEliminable arg3) {
        ControlEliminable v1 = this.controlEliminableSeleccionado;
        if(v1 != null) {
            v1.ocultarEliminar();
        }

        this.controlEliminableSeleccionado = arg3;
        this.vistaControlEliminableSeleccionado = arg2;
        this.vistaEliminarSeleccionada = arg3.obtenerVistaEliminar();
        arg3.mostrarEliminar();
        View v0 = this.vistaEliminarSeleccionada;
        if(v0 != null) {
            v0.bringToFront();
        }
    }

    static final MousePanelController mousePanelController_delegate$lambda$12(FloatingService arg6) {
        return new MousePanelController(arg6, arg6.goldenCoreController, arg6.serviceScope, new FloatingService$$ExternalSyntheticLambda88(arg6), new FloatingService$$ExternalSyntheticLambda92(arg6));
    }

    static final Pair mousePanelController_delegate$lambda$12$lambda$10(FloatingService arg0) {
        GoldenCursorRenderer v0 = arg0.cursorRenderer;
        if(v0 != null) {
            return v0.currentHotspot();
        }

        return null;
    }

    static final Unit mousePanelController_delegate$lambda$12$lambda$11(FloatingService arg3) {
        SharedPreferences v0 = arg3.getSharedPreferences("mouse_settings", 0);
        arg3.aplicarTamanoPuntero(v0.getInt("tamano_puntero", 100));
        arg3.aplicarTransparenciaPuntero(v0.getInt("transparencia_puntero", 100));
        arg3.cargarImagenPuntero();
        return Unit.INSTANCE;
    }

    public final float obtenerOpacidadGlobal() {
        return this.globalOverlayAlpha;
    }

    private final Pair obtenerTamanoRealPantalla() {
        Display v5_3;
        Pair v5;
        Context v0_1;
        String v2 = "GOLDEN_UI";
        if(Build$VERSION.SDK_INT >= 30) {
            try {
                v0_1 = this.screenMetricsContext;
            }
            catch(RuntimeException v0) {
                goto label_54;
            }

            String v1 = "Required value was null.";
            if(v0_1 == null) {
                try {
                    Object v0_2 = this.getSystemService(DisplayManager.class);
                    Bundle v3 = null;
                    Display v0_3 = v0_2 != null ? ((DisplayManager)v0_2).getDisplay(0) : ((Display)v3);
                    if(v0_3 != null) {
                        v0_1 = this.createDisplayContext(v0_3).createWindowContext(0x7F6, v3);
                        this.screenMetricsContext = v0_1;
                        Intrinsics.checkNotNullExpressionValue(v0_1, "also(...)");
                    }
                    else {
                        throw new IllegalStateException(v1.toString());
                    }

                label_28:
                    v0_2 = v0_1.getSystemService(WindowManager.class);
                    if(v0_2 != null) {
                        Rect v0_4 = ((WindowManager)v0_2).getMaximumWindowMetrics().getBounds();
                        Intrinsics.checkNotNullExpressionValue(v0_4, "getBounds(...)");
                        if(v0_4.width() > 0 && v0_4.height() > 0) {
                            v5 = TuplesKt.to(Integer.valueOf(v0_4.width()), Integer.valueOf(v0_4.height()));
                            return v5;
                        }

                        Log.w(v2, "Métricas de ventana inválidas; se consulta el display real");
                        goto label_55;
                    }

                    throw new IllegalStateException(v1.toString());
                }
                catch(RuntimeException v0) {
                label_54:
                    Log.w(v2, "Métricas de ventana no disponibles; se consulta el display real", ((Throwable)v0));
                    goto label_55;
                }
            }

            goto label_28;
        }

        try {
        label_55:
            Object v5_2 = ((FloatingService)v5).getSystemService("window");
            Intrinsics.checkNotNull(v5_2, "null cannot be cast to non-null type android.view.WindowManager");
            v5_3 = ((WindowManager)v5_2).getDefaultDisplay();
        }
        catch(RuntimeException v5_1) {
            goto label_98;
        }

        try {
            DisplayMetrics v0_5 = new DisplayMetrics();
            v5_3.getRealMetrics(v0_5);
            if(v0_5.widthPixels <= 0) {
                goto label_76;
            }

            if(v0_5.heightPixels <= 0) {
                goto label_76;
            }

            return TuplesKt.to(Integer.valueOf(v0_5.widthPixels), Integer.valueOf(v0_5.heightPixels));
        }
        catch(RuntimeException v0) {
            try {
                Log.w(v2, "No se pudieron leer las métricas reales; se consulta el tamaño del display", ((Throwable)v0));
            label_76:
                Point v0_6 = new Point();
                ((Display)v5).getRealSize(v0_6);
                if(v0_6.x > 0 && v0_6.y > 0) {
                    return TuplesKt.to(Integer.valueOf(v0_6.x), Integer.valueOf(v0_6.y));
                }

                throw new IllegalStateException("El display no proporcionó dimensiones reales válidas".toString());
            }
            catch(RuntimeException v5_1) {
            label_98:
                throw new IllegalStateException("No se pudo consultar un tamaño real de pantalla válido", ((Throwable)v5_1));
            }
        }
    }

    private final void ocultarHudParaPanel(Function0 arg12) {
        if(!this.isHudVisible) {
            arg12.invoke();
            return;
        }

        this.setPanelTransitioning(true);
        this.setHudVisible(false);
        Long v1 = null;
        FloatingService.detenerMonitoreo$default(this, v1, 1, v1);
        View v0 = this.floatingIconView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
            v0 = ((View)v1);
        }

        v0.setVisibility(8);
        v0 = this.hudView;
        String v2 = "hudView";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = ((View)v1);
        }

        v0 = v0.findViewById(id.layoutPanelLeft);
        View v3 = this.hudView;
        if(v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v3 = ((View)v1);
        }

        View v2_1 = v3.findViewById(id.layoutPanelRight);
        long v6 = this.hubTransitions.begin(new FloatingService$$ExternalSyntheticLambda179(this, arg12));
        if(v0 != null) {
            if(v2_1 == null) {
            }
            else {
                v0.animate().withEndAction(((Runnable)v1)).cancel();
                v2_1.animate().withEndAction(((Runnable)v1)).cancel();
                this.vigilarCancelacionPanel(v2_1, v6);
                v0.animate().translationX(-800f).alpha(0f).setDuration(0xFA).setInterpolator(new AccelerateInterpolator()).withEndAction(((Runnable)v1)).start();
                v2_1.animate().translationX(800f).alpha(0f).setDuration(0xFA).setInterpolator(new AccelerateInterpolator()).withEndAction(new FloatingService$$ExternalSyntheticLambda180(this, v6)).start();
                return;
            }
        }

        HubWindowTransition.finish$default(this.hubTransitions, v6, false, 2, null);
    }

    private static final void ocultarHudParaPanel$finalizar$134(FloatingService arg5, Function0 arg6) {
        View v3;
        SessionOverlayWindows v1;
        View v0 = null;
        try {
            if(!arg5.isHudVisible) {
                v1 = arg5.windowManager;
                goto label_4;
            }
        }
        catch(Exception ) {
        }

        goto label_24;
    label_4:
        String v2 = "windowManager";
        if(v1 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v1 = ((SessionOverlayWindows)v0);
            label_8:
                v3 = arg5.hudView;
                goto label_9;
            }
            catch(Exception ) {
                goto label_24;
            }
        }

        goto label_8;
    label_9:
        String v4 = "hudView";
        if(v3 == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
                v3 = v0;
            label_13:
                if(!v1.isManaged(v3)) {
                    goto label_24;
                }

                v1 = arg5.windowManager;
                if(v1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v1 = ((SessionOverlayWindows)v0);
                }

                View v2_1 = arg5.hudView;
                if(v2_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v4);
                    v2_1 = v0;
                }

                v1.removeView(v2_1);
                goto label_24;
            }
            catch(Exception ) {
            label_24:
                View v1_1 = arg5.floatingIconView;
                if(v1_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
                }
                else {
                    v0 = v1_1;
                }

                v0.setVisibility(8);
                if(arg5.isActive) {
                    arg6.invoke();
                }

                return;
            }
        }

        goto label_13;
    }

    static final Unit ocultarHudParaPanel$lambda$135(FloatingService arg0, Function0 arg1, boolean arg2) {
        arg0.setPanelTransitioning(false);
        FloatingService.ocultarHudParaPanel$finalizar$134(arg0, arg1);
        arg0.recuperarAccesoHub();
        return Unit.INSTANCE;
    }

    static final void ocultarHudParaPanel$lambda$136(FloatingService arg6, long arg7) {
        HubWindowTransition.finish$default(arg6.hubTransitions, arg7, false, 2, null);
    }

    private final void ocultarHudXML(boolean arg12) {
        ViewPropertyAnimator v3_1;
        if(this.isHudVisible) {
            this.setPanelTransitioning(true);
            this.setHudVisible(false);
            Long v1 = null;
            FloatingService.detenerMonitoreo$default(this, v1, 1, v1);
            View v0 = this.hudView;
            String v2 = "hudView";
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v0 = ((View)v1);
            }

            v0 = v0.findViewById(id.layoutPanelLeft);
            View v3 = this.hudView;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v3 = ((View)v1);
            }

            View v2_1 = v3.findViewById(id.layoutPanelRight);
            long v6 = this.hubTransitions.begin(new FloatingService$$ExternalSyntheticLambda17(this, arg12));
            if(v0 != null) {
                v3_1 = v0.animate();
                if(v3_1 != null) {
                    v3_1 = v3_1.withEndAction(((Runnable)v1));
                    if(v3_1 != null) {
                        v3_1.cancel();
                    }
                }
            }

            if(v2_1 != null) {
                v3_1 = v2_1.animate();
                if(v3_1 != null) {
                    v3_1 = v3_1.withEndAction(((Runnable)v1));
                    if(v3_1 != null) {
                        v3_1.cancel();
                    }
                }
            }

            if((arg12) && v0 != null && v2_1 != null) {
                this.vigilarCancelacionPanel(v2_1, v6);
                v0.animate().translationX(-800f).alpha(0f).setDuration(0xFA).setInterpolator(new AccelerateInterpolator()).withEndAction(((Runnable)v1)).start();
                v2_1.animate().translationX(800f).alpha(0f).setDuration(0xFA).setInterpolator(new AccelerateInterpolator()).withEndAction(new FloatingService$$ExternalSyntheticLambda18(this, v6)).start();
                return;
            }

            HubWindowTransition.finish$default(this.hubTransitions, v6, false, 2, null);
        }
    }

    static void ocultarHudXML$default(FloatingService arg0, boolean arg1, int arg2, Object arg3) {
        arg0.ocultarHudXML(true);
    }

    private static final void ocultarHudXML$finalizar(FloatingService arg5, boolean arg6) {
        String v1 = "windowManager";
        View v2 = null;
        if(!arg5.isHudVisible) {
            SessionOverlayWindows v0 = arg5.windowManager;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0 = ((SessionOverlayWindows)v2);
            }

            View v3 = arg5.hudView;
            String v4 = "hudView";
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
                v3 = v2;
            }

            if(!v0.isManaged(v3)) {
                goto label_24;
            }

            try {
                v0 = arg5.windowManager;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                    v0 = ((SessionOverlayWindows)v2);
                }

                v3 = arg5.hudView;
                if(v3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v4);
                    v3 = v2;
                }

                v0.removeView(v3);
                goto label_24;
            }
            catch(Exception ) {
            label_24:
                View v0_1 = arg5.fpsSettingsView;
                if(v0_1 != null) {
                    SessionOverlayWindows v3_1 = arg5.windowManager;
                    if(v3_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1);
                        v3_1 = ((SessionOverlayWindows)v2);
                    }

                    if(!v3_1.isManaged(v0_1)) {
                        goto label_37;
                    }

                    try {
                        v3_1 = arg5.windowManager;
                        if(v3_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v1);
                            v3_1 = ((SessionOverlayWindows)v2);
                        }

                        v3_1.removeView(v0_1);
                        goto label_37;
                    }
                    catch(Exception ) {
                    label_37:
                        arg5.setFpsSettingsView(v2);
                        arg5.setFpsSettingsVisible(false);
                        if(arg6) {
                            arg5.setPanelTransitioning(false);
                        }

                        if(!arg5.isMapeoVisible && !arg5.isHudVisible) {
                            View v6 = arg5.floatingIconView;
                            if(v6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
                            }
                            else {
                                v2 = v6;
                            }

                            v2.setVisibility(0);
                        }

                        arg5.actualizarControlesEnJuego();
                        return;
                    }
                }

                goto label_37;
            }
        }

        goto label_24;
    }

    static final Unit ocultarHudXML$lambda$103(FloatingService arg0, boolean arg1, boolean arg2) {
        FloatingService.ocultarHudXML$finalizar(arg0, arg1);
        arg0.recuperarAccesoHub();
        return Unit.INSTANCE;
    }

    static final void ocultarHudXML$lambda$104(FloatingService arg6, long arg7) {
        HubWindowTransition.finish$default(arg6.hubTransitions, arg7, false, 2, null);
    }

    private final void ocultarMapeo() {
        View v2_1;
        View v3_1;
        SessionOverlayWindows v0_2;
        Object v2 = null;
        FloatingService.cerrarEditorTecla$default(this, false, 1, v2);
        this.cerrarVentanaMacroScript();
        if(this.isMapeoVisible) {
            FloatingService.guardarConfiguracion$default(this, false, 1, v2);
            FloatingService.aplicarPerfilActualAlMotor$default(this, ((GameProfile)v2), 1, v2);
            this.ocultarVistaEliminar();
            this.deseleccionarControl();
            this.setMapeoVisible(false);
            this.aplicarAjustesVisualesBotones();
            View v1 = this.floatingIconView;
            if(v1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
                v1 = ((View)v2);
            }

            v1.setVisibility(0);
            View v0 = this.subMenuVista;
            String v1_1 = "windowManager";
            if(v0 != null) {
                try {
                    SessionOverlayWindows v3 = this.windowManager;
                    if(v3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                        v3 = ((SessionOverlayWindows)v2);
                    }

                    if(!v3.isManaged(v0)) {
                        goto label_33;
                    }

                    v3 = this.windowManager;
                    if(v3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                        v3 = ((SessionOverlayWindows)v2);
                    }

                    v3.removeView(v0);
                    goto label_33;
                }
                catch(Exception ) {
                label_33:
                    this.subMenuVista = ((View)v2);
                    try {
                        v0_2 = this.windowManager;
                        if(v0_2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                            v0_2 = ((SessionOverlayWindows)v2);
                        }

                        v3_1 = this.mapeoView;
                    }
                    catch(Throwable v0_1) {
                        goto label_63;
                    }

                    String v4 = "mapeoView";
                    if(v3_1 == null) {
                        try {
                            Intrinsics.throwUninitializedPropertyAccessException(v4);
                            v3_1 = ((View)v2);
                        label_45:
                            if(v0_2.isManaged(v3_1)) {
                                v0_2 = this.windowManager;
                                if(v0_2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                                    v0_2 = ((SessionOverlayWindows)v2);
                                }

                                v1 = this.mapeoView;
                                if(v1 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(v4);
                                }
                                else {
                                    v2_1 = v1;
                                }

                                v0_2.removeViewImmediate(v2_1);
                            }

                            Result.constructor-impl(Unit.INSTANCE);
                        }
                        catch(Throwable v0_1) {
                        label_63:
                            Result.constructor-impl(ResultKt.createFailure(v0_1));
                        }
                    }
                    else {
                        goto label_45;
                    }

                    this.actualizarAutorizacionUi();
                    return;
                }
            }

            goto label_33;
        }
    }

    private final void ocultarVistaEliminar() {
        ControlEliminable v0 = this.controlEliminableSeleccionado;
        if(v0 != null) {
            v0.ocultarEliminar();
        }

        this.controlEliminableSeleccionado = null;
        this.vistaControlEliminableSeleccionado = null;
        this.vistaEliminarSeleccionada = null;
    }

    public IBinder onBind(Intent arg1) {
        return null;
    }

    public void onConfigurationChanged(Configuration arg3) {
        Intrinsics.checkNotNullParameter(arg3, "newConfig");
        super.onConfigurationChanged(arg3);
        GoldenStretchVisualController v3 = this.goldenStretchVisual;
        if(v3 != null) {
            v3.refreshResolution();
        }

        BlueMagicVisualModeController v3_1 = this.blueMagicVisualMode;
        if(v3_1 != null) {
            v3_1.cancelAnimation();
        }

        Pair v3_2 = this.obtenerTamanoRealPantalla();
        int v0 = v3_2.component1().intValue();
        int v3_3 = v3_2.component2().intValue();
        TouchInjector.Companion.updateScreenDimensions(v0, v3_3);
        GoldenCursorRenderer v1 = this.cursorRenderer;
        if(v1 != null) {
            v1.updateBounds(((float)v0), ((float)v3_3));
        }

        FloatingService.aplicarPerfilActualAlMotor$default(this, null, 1, null);
        this.aplicarAjustesVisualesBotones();
    }

    public void onCreate() {
        View v5_3;
        ViewGroup$LayoutParams v8_4;
        View v8_2;
        View v14;
        int v8_1;
        WindowManager$LayoutParams v1_7;
        WindowManager$LayoutParams v6_1;
        ViewGroup v7_1;
        FloatingService v0 = this;
        super.onCreate();
        String v2 = "GOLDEN_START";
        Log.i(v2, "phase=service-create");
        CursorMotionSettings v1 = CursorMotionSettings.INSTANCE;
        SharedPreferences v5 = v0.getSharedPreferences("mouse_settings", 0);
        String v6 = "getSharedPreferences(...)";
        Intrinsics.checkNotNullExpressionValue(v5, v6);
        v1.load(v5);
        MouseWheelSettings v1_1 = MouseWheelSettings.INSTANCE;
        v5 = v0.getSharedPreferences("mouse_settings", 0);
        Intrinsics.checkNotNullExpressionValue(v5, v6);
        v1_1.load(v5);
        GoldenCoreController v1_2 = v0.goldenCoreController;
        SharedPreferences v3 = v0.getSharedPreferences("mouse_settings", 0);
        Intrinsics.checkNotNullExpressionValue(v3, v6);
        v1_2.loadMousePolling(v3);
        RecoilSettings v1_3 = v0.getRecoilSettingsStore().load();
        v0.recoilSettings = v1_3;
        GoldenCoreController v3_1 = v0.goldenCoreController;
        if(v1_3 != null) {
            v3_1.configureRecoil(v1_3);
            v0.goldenCoreController.setCursorScrollCallback(new FloatingService$onCreate$1(v0.getMousePanelController()));
            IntentFilter v1_4 = new IntentFilter("com.TryJeanPc.goldenmouse.CURSOR_IMAGE_CHANGED");
            v1_4.addAction("com.TryJeanPc.goldenmouse.CURSOR_PICKER_FINISHED");
            FloatingService v3_2 = v0;
            ContextCompat.registerReceiver(((Context)v3_2), v0.cursorImageReceiver, v1_4, 4);
            v0.iniciarModoForeground();
            Object v5_1 = v0.getSystemService("window");
            Intrinsics.checkNotNull(v5_1, "null cannot be cast to non-null type android.view.WindowManager");
            v0.windowManager = new SessionOverlayWindows(((WindowManager)v5_1), new FloatingService$onCreate$2(v0));
            v0.goldenCoreController.setGameForeground(false);
            Continuation v5_2 = null;
            BuildersKt.launch$default(v0.serviceScope, null, null, new FloatingService$onCreate$3(v0, v5_2), 3, null);
            LayoutInflater v1_5 = LayoutInflater.from(new ContextThemeWrapper(((Context)v3_2), style.Theme_MaterialComponents_DayNight_NoActionBar));
            View v7 = v1_5.inflate(layout.hud_main, ((ViewGroup)v5_2));
            String v8 = "inflate(...)";
            Intrinsics.checkNotNullExpressionValue(v7, v8);
            v0.hudView = v7;
            View v9 = v0.hudView;
            String v10 = "hudView";
            if(v9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v9 = ((View)v5_2);
            }

            SharedPreferences v11 = v0.getSharedPreferences("blue_magic_visual_mode", 0);
            Intrinsics.checkNotNullExpressionValue(v11, v6);
            v0.blueMagicVisualMode = new BlueMagicVisualModeController(v9, v11, v0.getDecorativeOptions());
            v0.getDecorativePreferences().registerOnSharedPreferenceChangeListener(v0.decorativePreferenceListener);
            v0.aplicarAnimacionesDecorativas();
            v7 = v0.hudView;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v7_1 = ((ViewGroup)v5_2);
            }

            v0.hudVisibilityObserver = new VisualVisibilityObserver(v7_1, new FloatingService$$ExternalSyntheticLambda21(v0));
            v0.hudParams = new WindowManager$LayoutParams(-1, -1, 0x7F6, 0x308, -3);
            String v7_2 = "hudParams";
            int v9_1 = 28;
            int v11_1 = 30;
            int v12 = 3;
            if(Build$VERSION.SDK_INT >= v11_1) {
                v6_1 = v0.hudParams;
                if(v6_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v7_2);
                    v6_1 = ((WindowManager$LayoutParams)v5_2);
                }

                v6_1.layoutInDisplayCutoutMode = v12;
            }
            else {
                if(Build$VERSION.SDK_INT < v9_1) {
                    goto label_124;
                }

                v6_1 = v0.hudParams;
                if(v6_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v7_2);
                    v6_1 = ((WindowManager$LayoutParams)v5_2);
                }

                v6_1.layoutInDisplayCutoutMode = 1;
            }

        label_124:
            View v6_2 = v0.hudView;
            if(v6_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v6_2 = ((View)v5_2);
            }

            v6_2.setSystemUiVisibility(0x1706);
            v6_2 = v0.hudView;
            if(v6_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v6_2 = ((View)v5_2);
            }

            v6_2.setOnClickListener(new FloatingService$$ExternalSyntheticLambda29(v0));
            View v1_6 = v1_5.inflate(layout.layout_mapeo_teclas, ((ViewGroup)v5_2));
            Intrinsics.checkNotNullExpressionValue(v1_6, v8);
            v0.mapeoView = v1_6;
            v0.mapeoParams = new WindowManager$LayoutParams(-1, -1, 0x7F6, 0x308, -3);
            v6 = "mapeoParams";
            if(Build$VERSION.SDK_INT >= v11_1) {
                v1_7 = v0.mapeoParams;
                if(v1_7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v6);
                    v1_7 = ((WindowManager$LayoutParams)v5_2);
                }

                v1_7.layoutInDisplayCutoutMode = v12;
            }
            else {
                if(Build$VERSION.SDK_INT < v9_1) {
                    goto label_165;
                }

                v1_7 = v0.mapeoParams;
                if(v1_7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v6);
                    v1_7 = ((WindowManager$LayoutParams)v5_2);
                }

                v1_7.layoutInDisplayCutoutMode = 1;
            }

        label_165:
            v1_7 = v0.mapeoParams;
            if(v1_7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v1_7 = ((WindowManager$LayoutParams)v5_2);
            }

            v1_7.softInputMode = v12;
            v1_6 = v0.mapeoView;
            v6 = "mapeoView";
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v1_6 = ((View)v5_2);
            }

            v7 = v0.hudView;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v7 = ((View)v5_2);
            }

            v1_6.setSystemUiVisibility(v7.getSystemUiVisibility());
            v1_6 = v0.mapeoView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v1_6 = ((View)v5_2);
            }

            v1_6 = v1_6.findViewById(id.lienzoMapeo);
            if(v1_6 != null) {
                EditorHitDispatcher.Companion.installFallback(v1_6);
                v0.getEditorGeometry().setOnSurfaceChanged(new FloatingService$$ExternalSyntheticLambda30(v0));
                v0.getEditorGeometry().refresh();
            }

            if(v1_6 != null) {
                ((FrameLayout)v1_6).setOnClickListener(new FloatingService$$ExternalSyntheticLambda31(v0));
            }

            v7 = v0.mapeoView;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v7 = ((View)v5_2);
            }

            v7 = v7.findViewById(id.btnCerrarMapeo);
            if(v7 != null) {
                v7.setOnClickListener(new FloatingService$$ExternalSyntheticLambda32(v0));
            }

            v7 = v0.mapeoView;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v7 = ((View)v5_2);
            }

            v7 = v7.findViewById(id.btnAgregarTecla);
            if(v7 != null) {
                v7.setOnClickListener(new FloatingService$$ExternalSyntheticLambda34(((FrameLayout)v1_6), v0));
            }

            v1_6 = v0.mapeoView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v1_6 = ((View)v5_2);
            }

            v1_6 = v1_6.findViewById(id.btnGuardarMapeo);
            if(v1_6 != null) {
                v1_6.setOnClickListener(new FloatingService$$ExternalSyntheticLambda35(v0));
            }

            v1_6 = v0.mapeoView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v1_6 = ((View)v5_2);
            }

            v1_6.findViewById(id.contenedorCortinaMapeo);
            v1_6 = v0.mapeoView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v1_6 = ((View)v5_2);
            }

            v1_6.findViewById(id.panelMapeoTeclas);
            v1_6 = v0.mapeoView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v1_6 = ((View)v5_2);
            }

            v1_6 = v1_6.findViewById(id.btnToggleMinimizarMapeo);
            if(v1_6 != null) {
                v1_6.setOnClickListener(new FloatingService$$ExternalSyntheticLambda36(v0));
            }

            FloatingService$$ExternalSyntheticLambda37 v1_8 = new FloatingService$$ExternalSyntheticLambda37(v0);
            v6_2 = v0.hudView;
            if(v6_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v6_2 = ((View)v5_2);
            }

            v6_2 = v6_2.findViewById(id.btnMonitoringEmulator);
            if(v6_2 != null) {
                v6_2.setOnClickListener(((View$OnClickListener)v1_8));
            }

            int v7_3 = 2;
            if((v0.getApplicationInfo().flags & v7_3) != 0) {
                Integer[] v6_3 = new Integer[v7_3];
                v6_3[0] = Integer.valueOf(id.btnMonitoringEmulator);
                v6_3[1] = Integer.valueOf(id.btnFpsMonitoringItem);
                Iterator v6_4 = CollectionsKt.listOf(((Object[])v6_3)).iterator();
                while(v6_4.hasNext()) {
                    v8_1 = v6_4.next().intValue();
                    v14 = v0.hudView;
                    if(v14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v10);
                        v14 = ((View)v5_2);
                    }

                    v8_2 = v14.findViewById(v8_1);
                    if(v8_2 == null) {
                        continue;
                    }

                    v8_2.setOnLongClickListener(new FloatingService$$ExternalSyntheticLambda38(v0));
                }
            }

            v6_2 = v0.hudView;
            if(v6_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v6_2 = ((View)v5_2);
            }

            v6_2 = v6_2.findViewById(id.btnFpsMonitoringItem);
            if(v6_2 != null) {
                v6_2.setOnClickListener(((View$OnClickListener)v1_8));
            }

            v1_6 = v0.hudView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v1_6 = ((View)v5_2);
            }

            v1_6 = v1_6.findViewById(id.btnCrosshairAssistant);
            if(v1_6 != null) {
                v1_6.setOnClickListener(new FloatingService$$ExternalSyntheticLambda23(v0));
            }

            v1_6 = v0.hudView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v1_6 = ((View)v5_2);
            }

            v1_6 = v1_6.findViewById(id.btnHome);
            if(v1_6 != null) {
                v1_6.setOnClickListener(new FloatingService$$ExternalSyntheticLambda24(v0, v1_6));
            }

            v1_6 = v0.hudView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v1_6 = ((View)v5_2);
            }

            v1_6 = v1_6.findViewById(id.bgOptimize);
            if(v1_6 != null) {
                v1_6.setOnClickListener(new FloatingService$$ExternalSyntheticLambda25(v0));
            }

            v1_6 = v0.hudView;
            if(v1_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v1_6 = ((View)v5_2);
            }

            v1_6 = v1_6.findViewById(id.btnMouseSettingsItem);
            if(v1_6 != null) {
                v1_6.setOnClickListener(new FloatingService$$ExternalSyntheticLambda26(v0));
            }

            int[] v1_9 = new int[]{id.bgBrightnessAuto, id.txtBrightnessAuto};
            int v6_5;
            for(v6_5 = 0; v6_5 < v7_3; ++v6_5) {
                v8_1 = v1_9[v6_5];
                v14 = v0.hudView;
                if(v14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v10);
                    v14 = ((View)v5_2);
                }

                v8_2 = v14.findViewById(v8_1);
                if(v8_2 != null) {
                    v8_2.setOnClickListener(new FloatingService$$ExternalSyntheticLambda27(v0));
                }
            }

            com.TryJeanPc.goldenmouse.ui.GoldenStretchVisualController$Companion v1_10 = GoldenStretchVisualController.Companion;
            v6_2 = v0.hudView;
            if(v6_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v10);
                v6_2 = ((View)v5_2);
            }

            v1_10.bindEntry(v6_2, new FloatingService$$ExternalSyntheticLambda28(v0));
            Pair v1_11 = v0.obtenerTamanoRealPantalla();
            TouchInjector.Companion.updateScreenDimensions(v1_11.component1().intValue(), v1_11.component2().intValue());
            TouchInjector.Companion.setAppContext(v0.getApplicationContext());
            v0.cargarConfiguracion();
            FloatingService.aplicarPerfilActualAlMotor$default(v0, ((GameProfile)v5_2), 1, v5_2);
            v0.aplicarAjustesVisualesBotones();
            v0.floatingIconBaseSizePx = RangesKt.coerceAtLeast(((int)(55f * v0.getResources().getDisplayMetrics().density)), 1);
            SharedPreferences v1_12 = v0.getSharedPreferences("GoldenMouseVisual", 0);
            v7_3 = 100;
            int v15 = RangesKt.coerceAtLeast(((int)((((float)(v0.floatingIconBaseSizePx * RangesKt.coerceIn(v1_12.getInt("tamano_logo", v7_3), 50, 150)))) / 100f)), 1);
            ImageView v6_6 = new ImageView(((Context)v3_2));
            v6_6.setImageResource(drawable.icono_flotante);
            v6_6.setScaleType(ImageView$ScaleType.FIT_CENTER);
            v6_6.setBackgroundColor(0);
            v6_6.setAlpha((((float)RangesKt.coerceIn(v1_12.getInt("alpha_logo", v7_3), 0, v7_3))) / 100f);
            v0.floatingIconView = ((View)v6_6);
            v0.iconParams = new WindowManager$LayoutParams(v15, v15, 0x7F6, 0x308, -3);
            String v4 = "iconParams";
            if(Build$VERSION.SDK_INT >= v11_1) {
                v1_7 = v0.iconParams;
                if(v1_7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v4);
                    v1_7 = ((WindowManager$LayoutParams)v5_2);
                }

                v1_7.layoutInDisplayCutoutMode = v12;
            }
            else {
                if(Build$VERSION.SDK_INT < v9_1) {
                    goto label_452;
                }

                v1_7 = v0.iconParams;
                if(v1_7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v4);
                    v1_7 = ((WindowManager$LayoutParams)v5_2);
                }

                v1_7.layoutInDisplayCutoutMode = 1;
            }

        label_452:
            v1_7 = v0.iconParams;
            if(v1_7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
                v1_7 = ((WindowManager$LayoutParams)v5_2);
            }

            v1_7.gravity = 0x800033;
            v1_7 = v0.iconParams;
            if(v1_7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
                v1_7 = ((WindowManager$LayoutParams)v5_2);
            }

            v1_7.x = v7_3;
            v1_7 = v0.iconParams;
            if(v1_7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
                v1_7 = ((WindowManager$LayoutParams)v5_2);
            }

            v1_7.y = v7_3;
            float v1_13 = RangesKt.coerceAtLeast(((float)ViewConfiguration.get(((Context)v3_2)).getScaledTouchSlop()), 10f);
            View v3_3 = v0.floatingIconView;
            v6 = "floatingIconView";
            if(v3_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v3_3 = ((View)v5_2);
            }

            v3_3.setOnTouchListener(new FloatingService$onCreate$20(v0, v1_13, v15));
            SessionOverlayWindows v1_14 = v0.windowManager;
            String v3_4 = "windowManager";
            if(v1_14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                v1_14 = ((SessionOverlayWindows)v5_2);
            }

            v7 = v0.floatingIconView;
            if(v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
                v7 = ((View)v5_2);
            }

            WindowManager$LayoutParams v8_3 = v0.iconParams;
            if(v8_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
                v8_4 = ((ViewGroup$LayoutParams)v5_2);
            }

            v1_14.addView(v7, v8_4);
            v0.prepararCursor();
            v1_14 = v0.windowManager;
            if(v1_14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                v1_14 = ((SessionOverlayWindows)v5_2);
            }

            View v0_1 = v0.floatingIconView;
            if(v0_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v6);
            }
            else {
                v5_3 = v0_1;
            }

            Log.i(v2, "phase=service-created iconManaged=" + v1_14.isManaged(v5_3));
            return;
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    static final Unit onCreate$lambda$17(FloatingService arg1, boolean arg2) {
        if(arg1.isActive) {
            if(!arg2) {
                FloatingService.detenerMonitoreo$default(arg1, null, 1, null);
            }
            else if(arg1.isHudVisible) {
                arg1.iniciarMonitoreo();
            }
        }

        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$19(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda103(arg1));
    }

    static final void onCreate$lambda$19$lambda$18(FloatingService arg3) {
        FloatingService.ocultarHudXML$default(arg3, false, 1, null);
    }

    static final Unit onCreate$lambda$21$lambda$20(FloatingService arg2) {
        if(arg2.isActive) {
            FloatingService.aplicarPerfilActualAlMotor$default(arg2, null, 1, null);
        }

        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$22(FloatingService arg2, View arg3) {
        FloatingService.cerrarEditorTecla$default(arg2, false, 1, null);
        arg2.ocultarVistaEliminar();
        arg2.deseleccionarControl();
    }

    static final void onCreate$lambda$24(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda107(arg1));
    }

    static final void onCreate$lambda$24$lambda$23(FloatingService arg0) {
        arg0.ocultarMapeo();
    }

    static final void onCreate$lambda$25(FrameLayout arg0, FloatingService arg1, View arg2) {
        if(arg0 != null) {
            arg1.mostrarMenuTipos(arg0);
        }
    }

    static final void onCreate$lambda$27(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda116(arg1));
    }

    static final void onCreate$lambda$27$lambda$26(FloatingService arg2) {
        arg2.ocultarMapeo();
        Toast.makeText(((Context)arg2), "Mapa guardado", 0).show();
    }

    static final void onCreate$lambda$28(FloatingService arg3, View arg4) {
        Object v0 = null;
        if(arg3.isMenuMapeoMinimizado) {
            FloatingService.maximizarMenuMapeo$default(arg3, false, 1, v0);
            return;
        }

        FloatingService.minimizarMenuMapeo$default(arg3, false, 1, v0);
    }

    static final void onCreate$lambda$30(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda167(arg1));
    }

    static final void onCreate$lambda$30$lambda$29(FloatingService arg0) {
        arg0.mostrarPanelFps();
    }

    static final boolean onCreate$lambda$32$lambda$31(FloatingService arg0, View arg1) {
        arg0.mostrarDiagnosticoCamara();
        return 1;
    }

    static final void onCreate$lambda$34(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda77(arg1));
    }

    static final void onCreate$lambda$34$lambda$33(FloatingService arg0) {
        arg0.mostrarMapeo();
    }

    static final void onCreate$lambda$37(FloatingService arg2, View arg3, View arg4) {
        FloatingService.cerrarEditorTecla$default(arg2, false, 1, null);
        arg3.setClickable(false);
        arg3.performHapticFeedback(1);
        arg3.animate().scaleX(0.88f).scaleY(0.88f).setDuration(60).withEndAction(new FloatingService$$ExternalSyntheticLambda101(arg2)).start();
    }

    static final void onCreate$lambda$37$lambda$36(FloatingService arg8) {
        SessionOverlayWindows v0_3;
        Long v1 = null;
        FloatingService.detenerMonitoreo$default(arg8, v1, 1, v1);
        View v0 = arg8.hudView;
        String v2 = "hudView";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = ((View)v1);
        }

        int v3 = 8;
        v0.setVisibility(v3);
        v0 = arg8.floatingIconView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
            v0 = ((View)v1);
        }

        v0.setVisibility(v3);
        v0 = arg8.mapeoView;
        String v4 = "mapeoView";
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v4);
            v0 = ((View)v1);
        }

        v0.setVisibility(v3);
        try {
            Intent v0_2 = new Intent(arg8.getApplicationContext(), MainActivity.class);
            v0_2.addFlags(0x34000000);
            arg8.startActivity(v0_2);
            arg8.getStretchGameLifecycle().goldenHomeRequested();
        }
        catch(Exception v0_1) {
            Log.e("GOLDEN_UI", "Error al abrir MainActivity: " + v0_1.getMessage());
        }

        v0 = arg8.hudView;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2);
            v0 = ((View)v1);
        }

        String v3_1 = "windowManager";
        if(v0.isAttachedToWindow()) {
            try {
                v0_3 = arg8.windowManager;
                if(v0_3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_1);
                    v0_3 = ((SessionOverlayWindows)v1);
                }

                View v5 = arg8.hudView;
                if(v5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v5 = ((View)v1);
                }

                v0_3.removeViewImmediate(v5);
                goto label_57;
            }
            catch(Exception ) {
            label_57:
                v0 = arg8.mapeoView;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v4);
                    v0 = ((View)v1);
                }

                if(v0.isAttachedToWindow()) {
                    try {
                        v0_3 = arg8.windowManager;
                        if(v0_3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3_1);
                            v0_3 = ((SessionOverlayWindows)v1);
                        }

                        View v2_1 = arg8.mapeoView;
                        if(v2_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v4);
                            v2_1 = ((View)v1);
                        }

                        v0_3.removeViewImmediate(v2_1);
                        goto label_72;
                    }
                    catch(Exception ) {
                    label_72:
                        arg8.setHudVisible(false);
                        arg8.setMapeoVisible(false);
                        BuildersKt.launch$default(arg8.serviceScope, Dispatchers.getDefault(), null, new FloatingService$onCreate$14$1$3(arg8, ((Continuation)v1)), 2, null);
                        return;
                    }
                }

                goto label_72;
            }
        }

        goto label_57;
    }

    static final void onCreate$lambda$39(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda1(arg1));
    }

    static final void onCreate$lambda$39$lambda$38(FloatingService arg0) {
        arg0.mostrarPanelAjustes();
    }

    static final void onCreate$lambda$41(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda166(arg1));
    }

    static final void onCreate$lambda$41$lambda$40(FloatingService arg0) {
        arg0.mostrarPanelMouse();
    }

    static final void onCreate$lambda$43(FloatingService arg1, View arg2) {
        arg1.mainHandler.post(new FloatingService$$ExternalSyntheticLambda102(arg1));
    }

    static final void onCreate$lambda$43$lambda$42(FloatingService arg0) {
        arg0.mostrarRetrocesoVisual();
    }

    static final Unit onCreate$lambda$45(FloatingService arg2) {
        arg2.mainHandler.post(new FloatingService$$ExternalSyntheticLambda93(arg2));
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$45$lambda$44(FloatingService arg0) {
        arg0.mostrarGoldenStretch();
    }

    public void onDestroy() {
        SessionOverlayWindows v1_1;
        Unit v2_11;
        View v5_1;
        View v4_1;
        SessionOverlayWindows v2_10;
        Object v2_5;
        SessionOverlayWindows v4;
        this.isActive = false;
        VisualVisibilityObserver v1 = this.hudVisibilityObserver;
        if(v1 != null) {
            v1.close();
        }

        v1 = null;
        this.hudVisibilityObserver = v1;
        this.getDecorativePreferences().unregisterOnSharedPreferenceChangeListener(this.decorativePreferenceListener);
        GoldenStretchVisualController v2 = this.goldenStretchVisual;
        if(v2 != null) {
            v2.close();
        }

        ProfileIdentityRepairDialog v2_1 = this.identityRepairDialog;
        if(v2_1 != null) {
            v2_1.close();
        }

        this.goldenCoreController.cancelRecoil();
        this.mainHandler.removeCallbacks(this.liberarInteraccionUi);
        FloatingService.detenerMonitoreo$default(this, ((Long)v1), 1, v1);
        CameraDiagnostics.INSTANCE.setEnabled(false);
        AlertDialog v3 = this.cameraDiagnosticsDialog;
        if(v3 != null) {
            v3.dismiss();
        }

        this.cameraDiagnosticsDialog = ((AlertDialog)v1);
        Dialog v3_1 = this.retrocesoDialog;
        this.setRetrocesoDialog(((Dialog)v1));
        if(v3_1 != null) {
            v3_1.dismiss();
        }

        this.getForegroundMonitor().close();
        this.getStretchGameLifecycle().observationLost();
        this.cerrarEditorTecla(false);
        CoroutineScopeKt.cancel$default(this.serviceScope, ((CancellationException)v1), 1, v1);
        this.cerrarVentanaMacroScript();
        this.goldenCoreController.setCursorScrollCallback(((Function3)v1));
        this.getMousePanelController().destroy();
        Job v3_2 = this.cursorImageJob;
        if(v3_2 != null) {
            DefaultImpls.cancel$default(v3_2, ((CancellationException)v1), 1, v1);
        }

        this.setCursorPickerOpen(false);
        this.cursorPickerPanelParams = ((WindowManager$LayoutParams)v1);
        try {
            this.unregisterReceiver(this.cursorImageReceiver);
            Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v3_3) {
            Result.constructor-impl(ResultKt.createFailure(v3_3));
        }

        v3_2 = this.monitoreoJob;
        if(v3_2 != null) {
            DefaultImpls.cancel$default(v3_2, ((CancellationException)v1), 1, v1);
        }

        if(this.telemetryManagerDelegate.isInitialized()) {
            try {
                this.getTelemetryManager().destroy();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_2) {
                Result.constructor-impl(ResultKt.createFailure(v2_2));
            }
        }

        this.goldenCoreController.detener();
        GoldenCursorRenderer v2_3 = this.cursorRenderer;
        if(v2_3 != null) {
            v2_3.stop();
        }

        this.cursorRenderer = ((GoldenCursorRenderer)v1);
        FrameLayout v2_4 = this.cursorOverlayView;
        String v3_4 = "windowManager";
        if(v2_4 != null) {
            try {
                v4 = this.windowManager;
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                    v4 = ((SessionOverlayWindows)v1);
                }

                if(v4.isManaged(v2_4)) {
                    v4 = this.windowManager;
                    if(v4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                        v4 = ((SessionOverlayWindows)v1);
                    }

                    v4.removeViewImmediate(((View)v2_4));
                }

                v2_5 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_2) {
                v2_5 = Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            Result.box-impl(v2_5);
        }

        this.cursorOverlayView = ((FrameLayout)v1);
        this.controlesJuegoView = ((View)v1);
        this.cursorView = ((ImageView)v1);
        View v2_6 = this.settingsPanelView;
        if(v2_6 != null) {
            try {
                v4 = this.windowManager;
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                    v4 = ((SessionOverlayWindows)v1);
                }

                if(v4.isManaged(v2_6)) {
                    v4 = this.windowManager;
                    if(v4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                        v4 = ((SessionOverlayWindows)v1);
                    }

                    v4.removeViewImmediate(v2_6);
                }

                v2_5 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_2) {
                v2_5 = Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            Result.box-impl(v2_5);
        }

        this.setSettingsPanelView(((View)v1));
        this.setSettingsTransitioning(false);
        v2_6 = this.mousePanelView;
        if(v2_6 != null) {
            try {
                v4 = this.windowManager;
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                    v4 = ((SessionOverlayWindows)v1);
                }

                if(v4.isManaged(v2_6)) {
                    v4 = this.windowManager;
                    if(v4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                        v4 = ((SessionOverlayWindows)v1);
                    }

                    v4.removeViewImmediate(v2_6);
                }

                v2_5 = Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_2) {
                v2_5 = Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            Result.box-impl(v2_5);
        }

        this.setMousePanelView(((View)v1));
        this.setMousePanelTransitioning(false);
        ValueAnimator v2_7 = this.iconSnapAnimator;
        if(v2_7 != null) {
            v2_7.cancel();
        }

        this.iconSnapAnimator = ((ValueAnimator)v1);
        Animator v2_8 = this.tachometerAnimator;
        if(v2_8 != null) {
            v2_8.cancel();
        }

        this.tachometerAnimator = ((Animator)v1);
        ObjectAnimator v2_9 = this.cpuRingAnimator;
        if(v2_9 != null) {
            v2_9.cancel();
        }

        this.cpuRingAnimator = ((ObjectAnimator)v1);
        v2_9 = this.ramRingAnimator;
        if(v2_9 != null) {
            v2_9.cancel();
        }

        this.ramRingAnimator = ((ObjectAnimator)v1);
        if(this.floatingIconView != null) {
            try {
                v2_10 = this.windowManager;
                if(v2_10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                    v2_10 = ((SessionOverlayWindows)v1);
                }

                v4_1 = this.floatingIconView;
            }
            catch(Throwable v2_2) {
                goto label_208;
            }

            String v5 = "floatingIconView";
            if(v4_1 == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException(v5);
                    v4_1 = ((View)v1);
                label_191:
                    if(v2_10.isManaged(v4_1)) {
                        v2_10 = this.windowManager;
                        if(v2_10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                            v2_10 = ((SessionOverlayWindows)v1);
                        }

                        v4_1 = this.floatingIconView;
                        if(v4_1 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v5);
                            v4_1 = ((View)v1);
                        }

                        v2_10.removeViewImmediate(v4_1);
                    }

                    Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v2_2) {
                label_208:
                    Result.constructor-impl(ResultKt.createFailure(v2_2));
                }

                goto label_209;
            }

            goto label_191;
        }

    label_209:
        String v4_2 = "hudView";
        if(this.hudView != null && (this.isHudVisible)) {
            try {
                v2_10 = this.windowManager;
                if(v2_10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                    v2_10 = ((SessionOverlayWindows)v1);
                }

                v5_1 = this.hudView;
                if(v5_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v4_2);
                    v5_1 = ((View)v1);
                }

                if(v2_10.isManaged(v5_1)) {
                    v2_10 = this.windowManager;
                    if(v2_10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                        v2_10 = ((SessionOverlayWindows)v1);
                    }

                    v5_1 = this.hudView;
                    if(v5_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v4_2);
                        v5_1 = ((View)v1);
                    }

                    v2_10.removeViewImmediate(v5_1);
                }

                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_2) {
                Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            this.setHudVisible(false);
        }

        v2_6 = this.hudView;
        if(v2_6 != null) {
            if(v2_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4_2);
                v2_6 = ((View)v1);
            }

            v2_6 = v2_6.findViewById(id.cpuView);
            if(v2_6 != null) {
                ((CpuIndicatorView)v2_6).releaseVisualResources();
            }

            v2_6 = this.hudView;
            if(v2_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4_2);
                v2_6 = ((View)v1);
            }

            v2_6 = v2_6.findViewById(id.ramView);
            if(v2_6 == null) {
                goto label_260;
            }

            ((RamIndicatorView)v2_6).releaseVisualResources();
        }

    label_260:
        v4_2 = "mapeoView";
        if(this.mapeoView != null) {
            try {
                v2_10 = this.windowManager;
                if(v2_10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                    v2_10 = ((SessionOverlayWindows)v1);
                }

                v5_1 = this.mapeoView;
                if(v5_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v4_2);
                    v5_1 = ((View)v1);
                }

                if(v2_10.isManaged(v5_1)) {
                    v2_10 = this.windowManager;
                    if(v2_10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                        v2_10 = ((SessionOverlayWindows)v1);
                    }

                    v5_1 = this.mapeoView;
                    if(v5_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v4_2);
                        v5_1 = ((View)v1);
                    }

                    v2_10.removeViewImmediate(v5_1);
                }

                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_2) {
                Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            this.setMapeoVisible(false);
        }

        if(this.subMenuVista != null) {
            try {
                v2_6 = this.subMenuVista;
                if(v2_6 != null) {
                    SessionOverlayWindows v5_2 = this.windowManager;
                    if(v5_2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                        v5_2 = ((SessionOverlayWindows)v1);
                    }

                    if(v5_2.isManaged(v2_6)) {
                        v5_2 = this.windowManager;
                        if(v5_2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                            v5_2 = ((SessionOverlayWindows)v1);
                        }

                        v5_2.removeViewImmediate(v2_6);
                    }

                    v2_11 = Unit.INSTANCE;
                }
                else {
                    v2_5 = v1;
                }

                Result.constructor-impl(v2_5);
            }
            catch(Throwable v2_2) {
                Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            this.subMenuVista = ((View)v1);
        }

        if(this.teclaEditorView != null) {
            v2_6 = this.mapeoView;
            if(v2_6 == null) {
                goto label_343;
            }

            if(v2_6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4_2);
                v2_6 = ((View)v1);
            }

            v2_6 = v2_6.findViewById(id.lienzoMapeo);
            try {
                if(v2_6 != null) {
                    ((FrameLayout)v2_6).removeView(this.teclaEditorView);
                    v2_11 = Unit.INSTANCE;
                }
                else {
                    v2_5 = v1;
                }

                Result.constructor-impl(v2_11);
            }
            catch(Throwable v2_2) {
                Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            this.teclaEditorView = ((TeclaEditorView)v1);
        }

    label_343:
        v2_6 = this.fpsSettingsView;
        if(v2_6 != null) {
            try {
                v4 = this.windowManager;
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                    v4 = ((SessionOverlayWindows)v1);
                }

                if(v4.isManaged(v2_6)) {
                    v4 = this.windowManager;
                    if(v4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3_4);
                        v4 = ((SessionOverlayWindows)v1);
                    }

                    v4.removeViewImmediate(v2_6);
                }

                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2_2) {
                Result.constructor-impl(ResultKt.createFailure(v2_2));
            }

            this.setFpsSettingsView(((View)v1));
        }

        this.setFpsSettingsVisible(false);
        this.mainHandler.removeCallbacksAndMessages(v1);
        SessionOverlayWindows v0 = this.windowManager;
        if(v0 != null) {
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3_4);
            }
            else {
                v1_1 = v0;
            }

            v1_1.close();
        }

        super.onDestroy();
    }

    public int onStartCommand(Intent arg7, int arg8, int arg9) {
        String v0 = "start_receiver";
        int v1 = 2;
        Parcelable v2 = null;
        if(!LicenseManager.authorizeSession()) {
            if(arg7 != null) {
                v2 = arg7.getParcelableExtra(v0);
            }

            if(v2 != null) {
                Bundle v7 = new Bundle();
                v7.putString("start_error", "Importa una licencia válida para esta instalación de Golden.");
                ((ResultReceiver)v2).send(v1, v7);
            }

            this.stopSelf(arg9);
            return v1;
        }

        String v8 = "target_package";
        String v9 = arg7 != null ? arg7.getStringExtra(v8) : ((String)v2);
        Log.i("GOLDEN_START", "phase=service-start target=" + v9);
        this.iniciarModoForeground();
        if(arg7 != null) {
            v8 = arg7.getStringExtra(v8);
            if(v8 != null) {
                v8 = StringsKt.trim(((CharSequence)v8)).toString();
                if(v8 == null) {
                    goto label_41;
                }
                else if(v8.length() > 0) {
                }
                else {
                    goto label_41;
                }
            }
            else {
                goto label_41;
            }
        }
        else {
        label_41:
            v8 = ((String)v2);
        }

        if(v8 != null && !Intrinsics.areEqual(v8, this.targetPackage)) {
            FloatingService.cerrarEditorTecla$default(this, false, 1, v2);
            this.ocultarVistaEliminar();
            this.deseleccionarControl();
            this.targetPackage = v8;
            GameProfile v4 = this.getProfileStorage().load(v8);
            if(v4 != null) {
                this.cargarPerfilEnEditor(v4);
            }

            this.getStretchGameLifecycle().select(v8);
            this.getForegroundMonitor().select(v8);
        }

        Pair v8_1 = this.obtenerTamanoRealPantalla();
        TouchInjector.Companion.updateScreenDimensions(v8_1.component1().intValue(), v8_1.component2().intValue());
        TouchInjector.Companion.setAppContext(this.getApplicationContext());
        FloatingService.aplicarPerfilActualAlMotor$default(this, ((GameProfile)v2), 1, v2);
        this.aplicarAjustesVisualesBotones();
        boolean v8_2 = this.hayInteraccionUi();
        this.actualizarAutorizacionUi();
        this.goldenCoreController.iniciar();
        GoldenCoreController v4_1 = this.goldenCoreController;
        if(v8_2) {
            v4_1.setAimActive(false);
        }
        else {
            FloatingService.actualizarVisibilidadCursor$default(this, v4_1.isAimActive(), false, v1, v2);
        }

        this.verificarEstadoBackends();
        if(arg7 != null) {
            v2 = arg7.getParcelableExtra(v0);
        }

        if(v2 != null) {
            this.getForegroundMonitor().whenObservationReady(new FloatingService$$ExternalSyntheticLambda84(this, ((ResultReceiver)v2)));
        }

        return 1;
    }

    static final Unit onStartCommand$lambda$58(FloatingService arg3, ResultReceiver arg4, String arg5) {
        String v0 = "GOLDEN_START";
        if(arg5 == null) {
            Log.i(v0, "phase=observation-ready target=" + arg3.targetPackage);
            arg4.send(1, null);
        }
        else {
            Log.e(v0, "phase=observation-failed target=" + arg3.targetPackage + " error=" + arg5);
            Bundle v3 = new Bundle();
            v3.putString("start_error", arg5);
            arg4.send(2, v3);
        }

        return Unit.INSTANCE;
    }

    private final GameProfile perfilConGeometria(GameProfile arg15, String arg16, ControlVisualState arg17) {
        ProfileControl v2_1;
        List v14 = arg15.getControls();
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v14), 10));
        Iterator v14_1 = ((Iterable)v14).iterator();
        while(v14_1.hasNext()) {
            Object v2 = v14_1.next();
            if(Intrinsics.areEqual(((ProfileControl)v2).getId(), arg16)) {
                v2_1 = ProfileControl.copy$default(((ProfileControl)v2), null, null, arg17.getX(), arg17.getY(), arg17.getWidth(), arg17.getHeight(), null, null, 0xC3, null);
            }

            ((Collection)v0).add(v2_1);
        }

        return GameProfile.copy$default(arg15, null, null, v0, null, 11, null);
    }

    private final void posicionarVistaEliminar(FrameLayout arg1, View arg2) {
    }

    private final void postHudRingStart(View arg2, long arg3, Function0 arg5) {
        FloatingService$$ExternalSyntheticLambda2 v0 = new FloatingService$$ExternalSyntheticLambda2(this, arg3, arg5);
        this.hudRingStarts.add(TuplesKt.to(arg2, v0));
        arg2.post(((Runnable)v0));
    }

    static final void postHudRingStart$lambda$198(FloatingService arg0, long arg1, Function0 arg3) {
        if(arg0.monitoreoActual(arg1)) {
            arg3.invoke();
        }
    }

    private final void prepararCursor() {
        int v0 = RangesKt.coerceAtLeast(((int)(32f * this.getResources().getDisplayMetrics().density)), 1);
        Pair v2 = this.obtenerTamanoRealPantalla();
        int v3 = v2.component1().intValue();
        int v2_1 = v2.component2().intValue();
        WindowManager$LayoutParams v4 = new WindowManager$LayoutParams(-1, -1, 0x7F6, 792, -3);
        if(Build$VERSION.SDK_INT >= 30) {
            v4.setFitInsetsTypes(0);
            v4.layoutInDisplayCutoutMode = 3;
        }
        else if(Build$VERSION.SDK_INT >= 28) {
            v4.layoutInDisplayCutoutMode = 1;
        }

        v4.gravity = 0x800033;
        v4.x = 0;
        v4.y = 0;
        v4.alpha = 0.8f;
        FrameLayout v12 = new FrameLayout(this);
        ImageView v6 = new ImageView(this);
        v6.setImageResource(drawable.mouse);
        v6.setScaleType(ImageView$ScaleType.FIT_CENTER);
        v6.setContentDescription("Cursor Golden Mouse");
        FrameLayout$LayoutParams v5 = new FrameLayout$LayoutParams(v0, v0);
        v5.gravity = 0x800033;
        v6.setLayoutParams(((ViewGroup$LayoutParams)v5));
        v6.setTranslationX(((float)(RangesKt.coerceAtLeast(v3 - v0, 0) / 2)));
        v6.setTranslationY(((float)(RangesKt.coerceAtLeast(v2_1 - v0, 0) / 2)));
        ControlesVisualesView v0_1 = new ControlesVisualesView(this);
        this.controlesJuegoView = ((View)v0_1);
        v12.addView(((View)v0_1), new FrameLayout$LayoutParams(-1, -1));
        v12.addView(v6);
        SessionOverlayWindows v0_2 = this.windowManager;
        SessionOverlayWindows v1 = null;
        String v5_1 = "windowManager";
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v5_1);
            v0_2 = v1;
        }

        v0_2.addView(v12, v4);
        WindowManager$LayoutParams v7 = v4;
        v0_2 = this.windowManager;
        if(v0_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v5_1);
        }
        else {
            v1 = v0_2;
        }

        GoldenCursorRenderer v4_1 = new GoldenCursorRenderer(v1, v6, v7, this.mainHandler, ((float)v3), ((float)v2_1));
        this.cursorOverlayView = v12;
        this.cursorView = v6;
        this.aplicarTamanoPuntero(this.getSharedPreferences("mouse_settings", 0).getInt("tamano_puntero", 100));
        this.aplicarTransparenciaPuntero(this.getSharedPreferences("mouse_settings", 0).getInt("transparencia_puntero", 100));
        this.cursorRenderer = v4_1;
        this.cargarImagenPuntero();
        this.actualizarControlesEnJuego();
        this.goldenCoreController.setCursorCallback(new FloatingService$prepararCursor$1(v4_1));
        this.goldenCoreController.setCursorPositionProvider(new FloatingService$prepararCursor$2(v4_1));
        this.goldenCoreController.setAimModeListener(new FloatingService$$ExternalSyntheticLambda64(this));
    }

    static final Unit prepararCursor$lambda$52(FloatingService arg1, boolean arg2) {
        if(!arg1.isActive) {
            return Unit.INSTANCE;
        }

        boolean v0 = arg1.lastAimActiveState != arg2 ? true : false;
        arg1.lastAimActiveState = arg2;
        arg1.actualizarVisibilidadCursor(arg2, v0);
        return Unit.INSTANCE;
    }

    private final IdRepairPlan prepararReparacionIds() {
        Object v8;
        GameProfile v3 = this.construirPerfilActual();
        if(v3 != null) {
            View v0 = this.mapeoView;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapeoView");
                v0 = null;
            }

            v0 = v0.findViewById(id.lienzoMapeo);
            IntRange v1 = RangesKt.until(0, ((FrameLayout)v0).getChildCount());
            int v4 = 10;
            ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1), v4));
            Iterator v1_1 = ((Iterable)v1).iterator();
            while(v1_1.hasNext()) {
                ((Collection)v2).add(((FrameLayout)v0).getChildAt(v1_1.nextInt()));
            }

            GameProfileStorage v0_1 = this.getProfileStorage();
            String v1_2 = v3.getTargetPackage();
            ArrayList v5 = v2;
            String v2_1 = this.editorIdentitySource;
            ArrayList v6 = new ArrayList();
            Iterator v7 = ((Iterable)v5).iterator();
            while(v7.hasNext()) {
                v8 = v7.next();
                Object v9 = v8;
                if(!(v9 instanceof ControlVisual)) {
                    continue;
                }

                if(!(v9 instanceof ProfileComponentControl)) {
                    continue;
                }

                ((Collection)v6).add(v8);
            }

            ArrayList v7_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6), v4));
            Iterator v6_1 = ((Iterable)v6).iterator();
            while(v6_1.hasNext()) {
                ((Collection)v7_1).add(this.controlSourceIndices.get(v6_1.next()));
            }

            v6 = new ArrayList();
            Iterator v5_1 = ((Iterable)v5).iterator();
            while(v5_1.hasNext()) {
                v8 = v5_1.next();
                if(!(v8 instanceof VistaLibreVisual)) {
                    continue;
                }

                ((Collection)v6).add(v8);
            }

            v5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6), v4));
            Iterator v4_1 = ((Iterable)v6).iterator();
            while(v4_1.hasNext()) {
                ((Collection)v5).add(this.visualSourceIndices.get(v4_1.next()));
            }

            Object v11 = v0_1.prepareIdRepair-hUnOzRk(v1_2, v2_1, v3, v7_1, ((List)v5), this.editorIdentityBaseline);
            ResultKt.throwOnFailure(v11);
            return ((IdRepairPlan)v11);
        }

        throw new IllegalStateException("No hay perfil vigente".toString());
    }

    static final GameProfileStorage profileStorage_delegate$lambda$13(FloatingService arg2) {
        Context v2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getApplicationContext(...)");
        return new GameProfileStorage(v2);
    }

    static final RecoilSettingsStore recoilSettingsStore_delegate$lambda$8(FloatingService arg3) {
        SharedPreferences v3 = arg3.getSharedPreferences("golden_recoil_control", 0);
        Intrinsics.checkNotNullExpressionValue(v3, "getSharedPreferences(...)");
        return new RecoilSettingsStore(v3);
    }

    private final void recuperarAccesoHub() {
        boolean v0_1;
        if((this.isActive) && this.floatingIconView != null) {
            SessionOverlayWindows v0 = this.windowManager;
            if(v0 == null) {
            }
            else {
                boolean v2 = true;
                String v3 = "windowManager";
                View v5 = null;
                if((this.isPanelTransitioning) || (this.isMapeoVisible) || (this.isSettingsTransitioning) || this.settingsPanelView != null || (this.isMousePanelTransitioning) || this.mousePanelView != null || (this.isCursorPickerOpen) || (this.isFpsSettingsVisible) || this.fpsSettingsView != null || this.retrocesoDialog != null || this.goldenStretchVisual != null) {
                label_41:
                    v0_1 = true;
                }
                else {
                    if(v0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3);
                        v0 = ((SessionOverlayWindows)v5);
                    }

                    if(v0.getHasDialogs()) {
                        goto label_41;
                    }

                    v0_1 = false;
                }

                if(this.isHudVisible) {
                    SessionOverlayWindows v1 = this.windowManager;
                    if(v1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3);
                        v1 = ((SessionOverlayWindows)v5);
                    }

                    View v6 = this.hudView;
                    String v7 = "hudView";
                    if(v6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v7);
                        v6 = v5;
                    }

                    if(!v1.isManaged(v6)) {
                        goto label_68;
                    }

                    v1 = this.windowManager;
                    if(v1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v3);
                        v1 = ((SessionOverlayWindows)v5);
                    }

                    if(v1.getSuspended()) {
                        goto label_69;
                    }

                    View v1_1 = this.hudView;
                    if(v1_1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v7);
                        v1_1 = v5;
                    }

                    if(v1_1.getParent() == null) {
                        goto label_68;
                    }
                }
                else {
                label_68:
                    v2 = false;
                }

            label_69:
                if(!this.hubTransitions.needsIcon(v2, v0_1)) {
                    return;
                }

                this.setHudVisible(false);
                View v8 = this.floatingIconView;
                if(v8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("floatingIconView");
                }
                else {
                    v5 = v8;
                }

                v5.setVisibility(0);
            }
        }
    }

    private final void registrarEntradaDelEditor(String arg3) {
        ControlConTecla v0 = this.botonEnEdicion;
        if(v0 == null) {
        }
        else if(!this.capturaEditorVigente(v0, this.sesionCapturaEditor)) {
        }
        else if(this.esEntradaRechazadaParaTocar(v0, arg3)) {
        }
        else if((v0 instanceof BotonVistaBlueStacks)) {
            InputBinding v3 = InputBinding.Companion.fromDisplayName(arg3);
            if(v3 != null) {
                VistaActivationCapture v2 = this.capturaTeclaVista;
                if(v2 != null) {
                    v2.accept(v3);
                }
            }
        }
        else {
            goto label_19;
        }

        return;
    label_19:
        TeclaEditorView v1 = this.teclaEditorView;
        if(v1 != null) {
            v1.recibirTecla(arg3);
            return;
        }

        this.actualizarBindingDelEditor(v0, arg3);
    }

    private final float resolverEscalaControl(SharedPreferences arg1, String arg2) {
        String v0 = ControlVisualFactory.INSTANCE.normalizarTipo(arg2);
        switch(v0.hashCode()) {
            case 1980540961: {
                if(!v0.equals("CAMARA")) {
                    goto label_37;
                }

                v0 = "tamano_boton_vista";
                goto label_38;
            }
            case -1905230500: {
                if(v0.equals("DISPARO")) {
                    goto label_35;
                }

                break;
            }
            case -854989634: {
                if(v0.equals("MACRO_SCRIPT")) {
                    goto label_29;
                }

                break;
            }
            case -225966439: {
                if(v0.equals("VISTA_LIBRE_VISUAL")) {
                    goto label_29;
                }

                break;
            }
            case -155485892: {
                if(!v0.equals("JOYSTICK")) {
                    goto label_37;
                }

                v0 = "tamano_boton_joystick";
                goto label_38;
            }
            case 82819: {
                if(!v0.equals("TAP")) {
                    goto label_37;
                }

            label_29:
                v0 = "tamano_boton_tap";
                goto label_38;
            }
            default: {
                break;
            }
        }

    label_37:
        v0 = null;
        goto label_38;
    label_35:
        v0 = "tamano_boton_disparo";
    label_38:
        int v2 = 100;
        if(v0 != null) {
            v2 = RangesKt.coerceIn(arg1.getInt(v0, v2), 50, 150);
        }

        return (((float)v2)) / 100f;
    }

    private final void restaurarPanelMouseTrasSelector() {
        if((this.isActive) && (this.isCursorPickerOpen)) {
            this.setCursorPickerOpen(false);
            WindowManager$LayoutParams v1 = this.cursorPickerPanelParams;
            WindowManager$LayoutParams v2 = null;
            this.cursorPickerPanelParams = v2;
            View v3 = this.mousePanelView;
            if(v3 == null) {
                return;
            }

            SessionOverlayWindows v4 = this.windowManager;
            String v5 = "windowManager";
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v5);
                v4 = ((SessionOverlayWindows)v2);
            }

            if(v4.isManaged(v3)) {
                return;
            }

            if(v1 == null) {
                return;
            }

            try {
                v4 = this.windowManager;
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v5);
                    v4 = ((SessionOverlayWindows)v2);
                }

                v4.addView(v3, ((ViewGroup$LayoutParams)v1));
                this.mantenerCursorAlFrente();
                this.actualizarNombreImagenPuntero();
                return;
            }
            catch(Exception ) {
                this.setMousePanelView(((View)v2));
                this.setMousePanelTransitioning(false);
                if(!this.isActive || !this.mostrarHudXML()) {
                    this.actualizarControlesEnJuego();
                }

                this.getMousePanelController().close();
                Toast.makeText(((Context)this), "No se pudo recuperar el panel Mouse", 1).show();
            }
        }
    }

    private final void seleccionarControl(ControlVisual arg5) {
        int v0 = this.controlSeleccionado != arg5 || !(arg5 instanceof View) || !this.usaDobleClicEditor(arg5) ? 0 : 1;
        if(this.controlSeleccionado != arg5) {
            this.getDobleClicEditor().reset();
            ControlConTecla v3 = this.botonEnEdicion;
            if(v3 != null && (((ControlVisual)v3)) != arg5) {
                FloatingService.cerrarEditorTecla$default(this, false, 1, null);
            }
        }

        if(v0 == 0) {
            ControlVisual v0_1 = this.controlSeleccionado;
            if(v0_1 != null) {
                v0_1.deseleccionar();
            }
        }

        this.controlSeleccionado = arg5;
        arg5.seleccionar();
        TeclaEditorView v4 = this.teclaEditorView;
        if(v4 != null) {
            v4.bringToFront();
        }

        Log.d("GOLDEN_UI", "Control seleccionado " + arg5.obtenerTipo());
    }

    private final void setCursorPickerOpen(boolean arg1) {
        this.isCursorPickerOpen = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setFpsSettingsView(View arg1) {
        this.fpsSettingsView = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setFpsSettingsVisible(boolean arg1) {
        this.isFpsSettingsVisible = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setGoldenStretchVisual(GoldenStretchVisualController arg1) {
        this.goldenStretchVisual = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setHudVisible(boolean arg1) {
        this.isHudVisible = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setMapeoVisible(boolean arg1) {
        this.isMapeoVisible = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setMousePanelTransitioning(boolean arg1) {
        this.isMousePanelTransitioning = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setMousePanelView(View arg1) {
        this.mousePanelView = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setPanelTransitioning(boolean arg1) {
        this.isPanelTransitioning = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setRetrocesoDialog(Dialog arg1) {
        this.retrocesoDialog = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setSettingsPanelView(View arg1) {
        this.settingsPanelView = arg1;
        this.actualizarAutorizacionUi();
    }

    private final void setSettingsTransitioning(boolean arg1) {
        this.isSettingsTransitioning = arg1;
        this.actualizarAutorizacionUi();
    }

    private final boolean solicitarReparacionIds() {
        ProfileIdentityRepairDialog v0_6;
        boolean v0_4;
        Object v0_3;
        GameProfile v0_2;
        if(this.isActive) {
            if(this.loadingIdentityProfile) {
            }
            else {
                try {
                    GameProfileStorage v0_1 = this.getProfileStorage();
                    String v3 = this.targetPackage;
                    if(v3 == null) {
                        v3 = "com.TryJeanPc.default";
                    }

                    if(v0_1.hasIdentityConflicts(v3)) {
                        goto label_32;
                    }

                    v0_2 = this.construirPerfilActual();
                    if(v0_2 == null) {
                        goto label_30;
                    }
                }
                catch(Throwable v0) {
                    goto label_39;
                }

                try {
                    ProfileIdentities.INSTANCE.requireUnique(v0_2);
                    v0_3 = Result.constructor-impl(Unit.INSTANCE);
                    goto label_27;
                }
                catch(Throwable v0) {
                    try {
                        v0_3 = Result.constructor-impl(ResultKt.createFailure(v0));
                    label_27:
                        if(Result.isFailure-impl(v0_3)) {
                        }
                        else {
                        label_30:
                            v0_4 = false;
                            goto label_33;
                        }

                    label_32:
                        v0_4 = true;
                    label_33:
                        v0_3 = Result.constructor-impl(Boolean.valueOf(v0_4));
                    }
                    catch(Throwable v0) {
                    label_39:
                        v0_3 = Result.constructor-impl(ResultKt.createFailure(v0));
                    }
                }

                Throwable v3_1 = Result.exceptionOrNull-impl(v0_3);
                if(v3_1 == null) {
                    if(!((Boolean)v0_3).booleanValue()) {
                        return 0;
                    }

                    SessionOverlayWindows v0_5 = this.windowManager;
                    if(v0_5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                        v0_5 = null;
                    }

                    if(v0_5.getHasDialogs()) {
                        v0_6 = this.identityRepairDialog;
                        if(v0_6 != null && (v0_6.isOpen())) {
                            goto label_61;
                        }

                        Toast.makeText(((Context)this), "Cierra el diálogo actual antes de confirmar la reparación; la edición sigue abierta", 1).show();
                        return 1;
                    }

                label_61:
                    v0_6 = this.identityRepairDialog;
                    if(v0_6 == null) {
                        ProfileIdentityRepairDialog v3_2 = new ProfileIdentityRepairDialog(new ContextThemeWrapper(this, style.Theme_MaterialComponents_DayNight_NoActionBar), this.getProfileStorage(), 0x7F6, new FloatingService$solicitarReparacionIds$recovery$1(this), new FloatingService$solicitarReparacionIds$recovery$2(this.goldenCoreController), new FloatingService$$ExternalSyntheticLambda3(this), new FloatingService$$ExternalSyntheticLambda4(this));
                        this.identityRepairDialog = v3_2;
                        v0_6 = v3_2;
                    }

                    v0_6.show();
                    return 1;
                }

                Toast.makeText(((Context)this), "No se pudo comprobar el perfil: " + v3_1.getMessage(), 1).show();
                return 1;
            }
        }

        return 0;
    }

    static final boolean solicitarReparacionIds$lambda$81(FloatingService arg4, IdRepairPlan arg5) {
        Object v4_3;
        Intrinsics.checkNotNullParameter(arg5, "plan");
        boolean v1 = false;
        if(arg4.isActive) {
            String v0 = arg4.targetPackage;
            if(v0 == null) {
                v0 = "com.TryJeanPc.default";
            }

            if(!Intrinsics.areEqual(v0, arg5.getTargetPackage())) {
                return v1;
            }

            try {
                IdRepairPlan v4_1 = arg4.prepararReparacionIds();
                boolean v4_2 = !Intrinsics.areEqual(v4_1.getOriginalJson(), arg5.getOriginalJson()) || !ProfileIdentities.INSTANCE.same(new JSONObject(v4_1.getPendingJson()), new JSONObject(arg5.getPendingJson())) ? false : true;
                v4_3 = Result.constructor-impl(Boolean.valueOf(v4_2));
            }
            catch(Throwable v4) {
                v4_3 = Result.constructor-impl(ResultKt.createFailure(v4));
            }

            Boolean v5 = Boolean.valueOf(false);
            if(Result.isFailure-impl(v4_3)) {
                Boolean v4_4 = v5;
            }

            if(!v4_4.booleanValue()) {
                return v1;
            }

            v1 = true;
        }

        return v1;
    }

    static final Unit solicitarReparacionIds$lambda$82(FloatingService arg2, String arg3) {
        if((arg2.isActive) && arg3 != null) {
            GameProfileStorage v0 = arg2.getProfileStorage();
            String v1 = arg2.targetPackage;
            if(v1 == null) {
                v1 = "com.TryJeanPc.default";
            }

            arg2.cargarPerfilEnEditor(v0.importProfile(arg3, v1));
            FloatingService.aplicarPerfilActualAlMotor$default(arg2, null, 1, null);
        }

        return Unit.INSTANCE;
    }

    static final GoldenStretchGameLifecycle stretchGameLifecycle_delegate$lambda$0(FloatingService arg2) {
        com.TryJeanPc.goldenmouse.stretch.physical.GoldenStretchGameLifecycle$Companion v0 = GoldenStretchGameLifecycle.Companion;
        Context v2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getApplicationContext(...)");
        return v0.get(v2);
    }

    private final void suspenderVentanas(boolean arg5) {
        Long v1 = null;
        if(arg5) {
            FloatingService.detenerMonitoreo$default(this, v1, 1, v1);
            this.getMousePanelController().setSessionVisible(false);
            if(this.telemetryManagerDelegate.isInitialized()) {
                this.getTelemetryManager().setSessionVisible(false);
            }
        }

        SessionOverlayWindows v2 = this.windowManager;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        }
        else {
            SessionOverlayWindows v1_1 = v2;
        }

        ((SessionOverlayWindows)v1).setSuspended(arg5);
        if(!arg5 && (this.isActive)) {
            this.getMousePanelController().setSessionVisible(true);
            if(this.telemetryManagerDelegate.isInitialized()) {
                this.getTelemetryManager().setSessionVisible(true);
            }

            if(!this.isHudVisible) {
                return;
            }

            this.iniciarMonitoreo();
        }
    }

    static final TelemetryManager telemetryManagerDelegate$lambda$14(FloatingService arg6) {
        boolean v6_1;
        FloatingService v1 = arg6;
        SessionOverlayWindows v2 = arg6.windowManager;
        SessionOverlayWindows v3 = null;
        String v4 = "windowManager";
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v4);
            WindowManager v2_1 = ((WindowManager)v3);
        }

        if(arg6.isActive) {
            SessionOverlayWindows v6 = arg6.windowManager;
            if(v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v4);
            }
            else {
                v3 = v6;
            }

            if(v3.getSuspended()) {
                goto label_19;
            }

            v6_1 = true;
        }
        else {
        label_19:
            v6_1 = false;
        }

        return new TelemetryManager(((Context)v1), ((WindowManager)v2), v6_1);
    }

    private final boolean usaDobleClicEditor(View arg1) {
        if(!(arg1 instanceof BotonTapBlueStacks) && !(arg1 instanceof BotonMacroScript)) {
            if((arg1 instanceof BotonVistaBlueStacks)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final void verificarEstadoBackends() {
        boolean v0 = ShizukuBridge.INSTANCE.servidorActivo();
        boolean v1 = ShizukuBridge.INSTANCE.permisoConcedido();
        if(v0) {
            if(!v1) {
            }
            else {
                return;
            }
        }

        Toast.makeText(((Context)this), "ALERTA: Shizuku no está en ejecución o no tiene permisos", 1).show();
    }

    private final void vigilarCancelacionPanel(View arg8, long arg9) {
        FloatingService$vigilarCancelacionPanel$detach$1 v2 = new FloatingService$vigilarCancelacionPanel$detach$1(this, arg9);
        arg8.addOnAttachStateChangeListener(v2);
        arg8.animate().setListener(new FloatingService$vigilarCancelacionPanel$1(arg8, v2, this, arg9));
    }

    private static final void vigilarCancelacionPanel$cancelar(FloatingService arg2, long arg3) {
        arg2.mainHandler.post(new FloatingService$$ExternalSyntheticLambda99(arg2, arg3));
    }

    static final void vigilarCancelacionPanel$cancelar$lambda$97(FloatingService arg1, long arg2) {
        arg1.hubTransitions.finish(arg2, true);
    }

    private final void volverAlHubTrasPanel() {
        try {
            if(!this.isActive || !this.mostrarHudXML()) {
                this.actualizarControlesEnJuego();
            }
        }
        catch(Throwable v0) {
            this.recuperarAccesoHub();
            throw v0;
        }

        this.recuperarAccesoHub();
    }
}


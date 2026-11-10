package com.TryJeanPc.goldenmouse.graphicsui;

import android.app.AlertDialog$Builder;
import android.content.Context;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.TryJeanPc.goldenmouse.GoldenSharkGameSwitch;
import com.TryJeanPc.goldenmouse.R$dimen;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.R$layout;
import com.TryJeanPc.goldenmouse.R$string;
import com.TryJeanPc.goldenmouse.graphics.GraphicsCapabilities;
import com.TryJeanPc.goldenmouse.graphics.GraphicsProfile;
import com.TryJeanPc.goldenmouse.graphics.GraphicsProfileKt;
import com.TryJeanPc.goldenmouse.graphics.GraphicsProfileStore;
import com.TryJeanPc.goldenmouse.graphics.GraphicsRuntime;
import com.TryJeanPc.goldenmouse.graphics.GraphicsStatus;
import com.TryJeanPc.goldenmouse.graphics.TexturePreset;
import com.TryJeanPc.goldenmouse.sharksettings.SharkSettingsScreen;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 m2\u00020\u0001:\u0001mB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00104\u001A\u00020\u00172\u0006\u00105\u001A\u00020\u0017H\u0002J\u0012\u00106\u001A\u0002072\b\u00108\u001A\u0004\u0018\u000109H\u0014J\b\u0010:\u001A\u000207H\u0014J\u0010\u0010;\u001A\u0002072\u0006\u0010<\u001A\u000209H\u0014J\u0016\u0010=\u001A\u0002072\u0006\u0010>\u001A\u00020\u0005H\u0082@¢\u0006\u0002\u0010?J\b\u0010@\u001A\u000207H\u0002J\u001A\u0010A\u001A\u0002072\u0006\u0010B\u001A\u00020\u00072\b\b\u0002\u0010C\u001A\u00020\rH\u0002J\b\u0010D\u001A\u00020EH\u0002J\u0012\u0010F\u001A\u0002072\b\b\u0002\u0010G\u001A\u00020\rH\u0002J\b\u0010H\u001A\u000207H\u0002J\b\u0010I\u001A\u000207H\u0002J\b\u0010J\u001A\u000207H\u0002J\b\u0010K\u001A\u000207H\u0002J\u0010\u0010L\u001A\u0002072\u0006\u0010B\u001A\u00020\u0019H\u0002J\u0010\u0010M\u001A\u0002072\u0006\u0010N\u001A\u00020\rH\u0002J\b\u0010O\u001A\u000207H\u0002J\b\u0010P\u001A\u00020\u0005H\u0002J\b\u0010Q\u001A\u000207H\u0002J\b\u0010R\u001A\u000207H\u0016J\u0010\u0010S\u001A\u0002072\u0006\u0010T\u001A\u00020\u0017H\u0002J\b\u0010U\u001A\u00020!H\u0002J\"\u0010V\u001A\u00020!2\u0006\u0010W\u001A\u00020!2\u0006\u0010X\u001A\u00020\u00052\b\b\u0002\u0010Y\u001A\u00020\u0005H\u0002J \u0010Z\u001A\u00020%2\u0006\u0010W\u001A\u00020!2\u0006\u0010[\u001A\u00020\u00052\u0006\u0010\\\u001A\u00020\u0017H\u0002J&\u0010]\u001A\u00020\'2\u0006\u0010W\u001A\u00020!2\u0006\u0010X\u001A\u00020\u00052\f\u0010^\u001A\b\u0012\u0004\u0012\u0002070_H\u0002JP\u0010`\u001A\u00020!2\u0006\u0010W\u001A\u00020!2\f\u0010a\u001A\b\u0012\u0004\u0012\u00020\u00050b2\u0006\u0010c\u001A\u00020\u00172\u0014\b\u0002\u0010d\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0e2\u0012\u0010f\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002070eH\u0002J<\u0010g\u001A\u0002072\u0006\u0010W\u001A\u00020!2\u0006\u0010h\u001A\u00020\u00172\u0006\u0010i\u001A\u00020\u00172\u0006\u0010d\u001A\u00020\r2\u0012\u0010j\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002070eH\u0002J>\u0010k\u001A\u0002072\u0006\u0010W\u001A\u00020!2\u0006\u0010X\u001A\u00020\u00052\u0006\u0010c\u001A\u00020\r2\b\b\u0002\u0010d\u001A\u00020\r2\u0012\u0010j\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002070eH\u0002J\u0010\u0010l\u001A\u0002072\u0006\u0010[\u001A\u00020\u0005H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\'X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\'X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\'X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\'X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010.\u001A\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001A\u0004\b0\u00101¨\u0006n"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsCenterActivity;", "Lcom/TryJeanPc/goldenmouse/sharksettings/SharkSettingsScreen;", "<init>", "()V", "pkg", "", "profile", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "caps", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsCapabilities;", "draftState", "Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsDraftState;", "dirty", "", "getDirty", "()Z", "checking", "saving", "loading", "Lcom/TryJeanPc/goldenmouse/graphicsui/GoldenGraphicsLoadingView;", "inspections", "Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsInspectionQueue;", "page", "", "state", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsStatus;", "notice", "pages", "", "Landroid/widget/ScrollView;", "tabs", "Landroid/view/View;", "rail", "Landroid/widget/LinearLayout;", "frame", "Landroid/widget/FrameLayout;", "status", "Landroid/widget/TextView;", "save", "Landroid/widget/Button;", "apply", "restore", "check", "icon", "Landroid/widget/ImageView;", "leaving", "store", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfileStore;", "getStore", "()Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfileStore;", "store$delegate", "Lkotlin/Lazy;", "dp", "n", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onSaveInstanceState", "outState", "loadSelectedGame", "target", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rebuild", "edit", "value", "rebuildViews", "inspectionKey", "Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsInspectionKey;", "inspect", "force", "drainInspection", "saveProfile", "confirmApply", "confirmRestore", "consumeRuntime", "reflectRuntime", "accepted", "reconcileSave", "sessionOwner", "renderStatus", "finish", "showPage", "index", "newPage", "card", "parent", "title", "description", "label", "text", "size", "button", "click", "Lkotlin/Function0;", "choices", "titles", "", "selected", "enabled", "Lkotlin/Function1;", "choose", "slider", "max", "progress", "change", "toggle", "toast", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsCenterActivity extends SharkSettingsScreen {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsCenterActivity$Companion;", "", "<init>", "()V", "GAME", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String GAME = "graphics_game_package";
    private Button apply;
    private GraphicsCapabilities caps;
    private Button check;
    private boolean checking;
    private GraphicsDraftState draftState;
    private FrameLayout frame;
    private ImageView icon;
    private final GraphicsInspectionQueue inspections;
    private boolean leaving;
    private GoldenGraphicsLoadingView loading;
    private String notice;
    private int page;
    private final List pages;
    private String pkg;
    private GraphicsProfile profile;
    private LinearLayout rail;
    private Button restore;
    private Button save;
    private boolean saving;
    private GraphicsStatus state;
    private TextView status;
    private final Lazy store$delegate;
    private final List tabs;

    static {
        GraphicsCenterActivity.Companion = new Companion(null);
        GraphicsCenterActivity.$stable = 8;
    }

    public GraphicsCenterActivity() {
        super(layout.graphics_center, string.graphics_center_title);
        this.pkg = "";
        this.profile = new GraphicsProfile(false, null, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FFF, null);
        this.caps = new GraphicsCapabilities(null, null, null, null, null, null, null, null, null, null, null, null, null, 0x1FFF, null);
        this.draftState = new GraphicsDraftState(null, false, 3, null);
        this.inspections = new GraphicsInspectionQueue();
        this.state = GraphicsRuntime.INSTANCE.getStatus().getValue();
        this.notice = "SIN CONFIGURAR · ningún cambio se aplica al abrir";
        this.pages = new ArrayList();
        this.tabs = new ArrayList();
        this.store$delegate = LazyKt.lazy(new GraphicsCenterActivity$$ExternalSyntheticLambda22(this));
    }

    public static final void access$consumeRuntime(GraphicsCenterActivity arg0, GraphicsStatus arg1) {
        arg0.consumeRuntime(arg1);
    }

    public static final void access$drainInspection(GraphicsCenterActivity arg0) {
        arg0.drainInspection();
    }

    public static final void access$finish$s1847210388(GraphicsCenterActivity arg0) {
        super.finish();
    }

    public static final GraphicsDraftState access$getDraftState$p(GraphicsCenterActivity arg0) {
        return arg0.draftState;
    }

    public static final GraphicsInspectionQueue access$getInspections$p(GraphicsCenterActivity arg0) {
        return arg0.inspections;
    }

    public static final String access$getNotice$p(GraphicsCenterActivity arg0) {
        return arg0.notice;
    }

    public static final int access$getPage$p(GraphicsCenterActivity arg0) {
        return arg0.page;
    }

    public static final String access$getPkg$p(GraphicsCenterActivity arg0) {
        return arg0.pkg;
    }

    public static final GraphicsProfileStore access$getStore(GraphicsCenterActivity arg0) {
        return arg0.getStore();
    }

    public static final void access$inspect(GraphicsCenterActivity arg0, boolean arg1) {
        arg0.inspect(arg1);
    }

    public static final GraphicsInspectionKey access$inspectionKey(GraphicsCenterActivity arg0) {
        return arg0.inspectionKey();
    }

    public static final Object access$loadSelectedGame(GraphicsCenterActivity arg0, String arg1, Continuation arg2) {
        return arg0.loadSelectedGame(arg1, arg2);
    }

    public static final void access$rebuild(GraphicsCenterActivity arg0) {
        arg0.rebuild();
    }

    public static final void access$reconcileSave(GraphicsCenterActivity arg0) {
        arg0.reconcileSave();
    }

    public static final void access$renderStatus(GraphicsCenterActivity arg0) {
        arg0.renderStatus();
    }

    public static final void access$setCaps$p(GraphicsCenterActivity arg0, GraphicsCapabilities arg1) {
        arg0.caps = arg1;
    }

    public static final void access$setChecking$p(GraphicsCenterActivity arg0, boolean arg1) {
        arg0.checking = arg1;
    }

    public static final void access$setDraftState$p(GraphicsCenterActivity arg0, GraphicsDraftState arg1) {
        arg0.draftState = arg1;
    }

    public static final void access$setLeaving$p(GraphicsCenterActivity arg0, boolean arg1) {
        arg0.leaving = arg1;
    }

    public static final void access$setNotice$p(GraphicsCenterActivity arg0, String arg1) {
        arg0.notice = arg1;
    }

    public static final void access$setProfile$p(GraphicsCenterActivity arg0, GraphicsProfile arg1) {
        arg0.profile = arg1;
    }

    public static final void access$setSaving$p(GraphicsCenterActivity arg0, boolean arg1) {
        arg0.saving = arg1;
    }

    private final Button button(LinearLayout arg4, String arg5, Function0 arg6) {
        Button v0 = new Button(this);
        v0.setText(((CharSequence)arg5));
        v0.setAllCaps(false);
        v0.setTextSize(12f);
        v0.setMinWidth(0);
        v0.setMinimumWidth(0);
        int v5 = -1;
        v0.setTextColor(v5);
        v0.setOnClickListener(new GraphicsCenterActivity$$ExternalSyntheticLambda0(arg6));
        Button v6 = v0;
        if(arg4.getOrientation() == 0) {
            v5 = -2;
        }

        arg4.addView(((View)v6), new LinearLayout$LayoutParams(v5, this.dp(0x30)));
        return v0;
    }

    static final void button$lambda$52$lambda$51(Function0 arg0, View arg1) {
        arg0.invoke();
    }

    private final LinearLayout card(LinearLayout arg7, String arg8, String arg9) {
        LinearLayout v0 = new LinearLayout(this);
        v0.setOrientation(1);
        v0.setPadding(this.dp(14), this.dp(10), this.dp(14), this.dp(10));
        GradientDrawable v1 = new GradientDrawable();
        v1.setColor(-433508814);
        v1.setCornerRadius(((float)this.dp(8)));
        v0.setBackground(((Drawable)v1));
        LinearLayout$LayoutParams v2 = new LinearLayout$LayoutParams(-1, -2);
        v2.topMargin = this.dp(10);
        arg7.addView(v0, ((ViewGroup$LayoutParams)v2));
        this.label(v0, arg8, 16);
        if(arg9.length() > 0) {
            this.label(v0, arg9, 12);
        }

        return v0;
    }

    static LinearLayout card$default(GraphicsCenterActivity arg0, LinearLayout arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = "";
        }

        return arg0.card(arg1, arg2, arg3);
    }

    private final LinearLayout choices(LinearLayout arg8, List arg9, int arg10, Function1 arg11, Function1 arg12) {
        HorizontalScrollView v0 = new HorizontalScrollView(this);
        v0.setHorizontalScrollBarEnabled(true);
        LinearLayout v3 = new LinearLayout(this);
        v0.addView(v3);
        arg8.addView(((View)v0));
        Iterator v8 = ((Iterable)arg9).iterator();
        int v0_1;
        for(v0_1 = 0; v8.hasNext(); v0_1 = v4) {
            Object v1 = v8.next();
            int v4 = v0_1 + 1;
            if(v0_1 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            Button v5 = this.button(v3, ((String)v1), new GraphicsCenterActivity$$ExternalSyntheticLambda29(arg12, v0_1));
            v5.setEnabled(arg11.invoke(Integer.valueOf(v0_1)).booleanValue());
            float v6 = v5.isEnabled() ? 1f : 0.42f;
            v5.setAlpha(v6);
            v5.setBackground(this.getDrawable(drawable.graphics_selection));
            boolean v0_2 = v0_1 == arg10 ? true : false;
            v5.setSelected(v0_2);
            String v0_3 = v5.isSelected() ? ", seleccionado" : "";
            v5.setContentDescription((((String)v1)) + v0_3);
            v5.setPadding(this.dp(14), 0, this.dp(14), 0);
        }

        return v3;
    }

    static LinearLayout choices$default(GraphicsCenterActivity arg6, LinearLayout arg7, List arg8, int arg9, Function1 arg10, Function1 arg11, int arg12, Object arg13) {
        GraphicsCenterActivity$$ExternalSyntheticLambda27 v10;
        if((arg12 & 8) != 0) {
            v10 = new GraphicsCenterActivity$$ExternalSyntheticLambda27();
        }

        return arg6.choices(arg7, arg8, arg9, ((Function1)v10), arg11);
    }

    static final boolean choices$lambda$53(int arg0) {
        return 1;
    }

    static final Unit choices$lambda$57$lambda$55(Function1 arg0, int arg1) {
        arg0.invoke(Integer.valueOf(arg1));
        return Unit.INSTANCE;
    }

    private final void confirmApply() {
        String v2;
        Button v0 = this.apply;
        DialogInterface$OnClickListener v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apply");
            v0 = ((Button)v1);
        }

        if(v0.isEnabled()) {
            if(GraphicsRuntime.INSTANCE.getStatus().getValue().getBusy()) {
            }
            else {
                AlertDialog$Builder v0_1 = new AlertDialog$Builder(this).setTitle("Aplicación manual de configuración");
                if(this.profile.getAnimations() != 0) {
                    v2 = this.profile.getAnimations() == 1 ? "0.5" : "0";
                    v2 = "Confirmas cambiar GLOBALMENTE ventana, transición y duración de animador a " + v2 + "?\n\n";
                }
                else {
                    v2 = "";
                }

                v0_1.setMessage("Se registrarán los originales antes de escribir. Hz, color, MSAA, filtros ANGLE y animaciones pueden tener alcance global. Otras apps que usen ANGLE también pueden recibir la textura; los juegos de la sesión comparten LOD y filtros y se restauran conjuntamente. No se detecta automáticamente la salida del juego: debes volver y Restaurar sesión.\n\n" + v2 + "ANGLE/MSAA pueden requerir que reinicies el juego manualmente; Golden no lo cerrará. El readback confirma configuración, no efecto físico.").setPositiveButton("Confirmar y aplicar", new GraphicsCenterActivity$$ExternalSyntheticLambda28(this)).setNegativeButton("Cancelar", v1).show();
            }
        }
    }

    static final void confirmApply$lambda$38(GraphicsCenterActivity arg6, DialogInterface arg7, int arg8) {
        Display v4 = arg6.getWindowManager().getDefaultDisplay();
        GraphicsRuntime v0 = GraphicsRuntime.INSTANCE;
        Context v1 = arg6.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v1, "getApplicationContext(...)");
        arg6.reflectRuntime(v0.apply(v1, arg6.pkg, arg6.profile, v4, arg6.draftState.getRevision()));
    }

    private final void confirmRestore() {
        Button v0 = this.restore;
        DialogInterface$OnClickListener v1 = null;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restore");
            v0 = ((Button)v1);
        }

        if(v0.isEnabled()) {
            if(GraphicsRuntime.INSTANCE.getStatus().getValue().getBusy()) {
            }
            else {
                AlertDialog$Builder v0_1 = new AlertDialog$Builder(this).setTitle("Restaurar sesión gráfica");
                String v2 = this.state.getSharedTexture() ? "toda la sesión GLOBAL compartida (todos sus juegos)" : this.sessionOwner();
                v0_1.setMessage("Recuperar los valores originales registrados de " + v2 + "? Si otro proceso los cambió o existe incertidumbre, la restauración se detiene y conserva el journal.").setPositiveButton("Restaurar", new GraphicsCenterActivity$$ExternalSyntheticLambda18(this)).setNegativeButton("Cancelar", v1).show();
            }
        }
    }

    static final void confirmRestore$lambda$39(GraphicsCenterActivity arg1, DialogInterface arg2, int arg3) {
        GraphicsRuntime v2 = GraphicsRuntime.INSTANCE;
        Context v3 = arg1.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v3, "getApplicationContext(...)");
        arg1.reflectRuntime(v2.restore(v3));
    }

    private final void consumeRuntime(GraphicsStatus arg5) {
        int v0 = Long.compare(this.state.getRevision(), arg5.getRevision()) != 0 ? 1 : 0;
        this.state = arg5;
        this.reconcileSave();
        if(v0 != 0 && this.pkg.length() > 0 && this.page != 0) {
            GraphicsCenterActivity.inspect$default(this, false, 1, null);
            return;
        }

        this.drainInspection();
        this.renderStatus();
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.getResources().getDisplayMetrics().density));
    }

    private final void drainInspection() {
        GraphicsCenterActivity v0 = this;
        GraphicsInspectionQueue v1 = v0.inspections;
        boolean v2 = (v0.checking) || (v0.state.getBusy()) || v0.pkg.length() == 0 ? true : false;
        GraphicsInspectionKey v1_1 = v1.begin(v2);
        if(v1_1 == null) {
            return;
        }

        v0.checking = true;
        v0.caps = new GraphicsCapabilities(null, null, null, null, null, null, null, null, null, null, null, null, null, 0x1FFF, null);
        v0.renderStatus();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(v0), null, null, new GraphicsCenterActivity$drainInspection$1(v0, v1_1, v0.getWindowManager().getDefaultDisplay(), null), 3, null);
    }

    private final void edit(GraphicsProfile arg3, boolean arg4) {
        if(!this.state.getBusy()) {
            if(this.checking) {
            }
            else {
                Object v0 = CollectionsKt.getOrNull(this.pages, this.page);
                int v0_1 = v0 != null ? ((ScrollView)v0).getScrollY() : 0;
                this.profile = arg3;
                this.draftState = this.draftState.edited();
                if(arg4) {
                    this.rebuild();
                    this.pages.get(this.page).post(new GraphicsCenterActivity$$ExternalSyntheticLambda20(this, v0_1));
                    return;
                }

                this.renderStatus();
            }
        }
    }

    static void edit$default(GraphicsCenterActivity arg0, GraphicsProfile arg1, boolean arg2, int arg3, Object arg4) {
        arg0.edit(arg1, true);
    }

    static final void edit$lambda$37(GraphicsCenterActivity arg1, int arg2) {
        Object v1 = CollectionsKt.getOrNull(arg1.pages, arg1.page);
        if(v1 != null) {
            ((ScrollView)v1).scrollTo(0, arg2);
        }
    }

    public void finish() {
        if(this.leaving) {
            super.finish();
            return;
        }

        if(!this.state.getBusy()) {
            if(this.checking) {
            }
            else {
                if(this.page != 0 && this.state.getPendingPackage() != null || (this.getDirty())) {
                    AlertDialog$Builder v0 = new AlertDialog$Builder(this).setTitle("Volver al carrusel");
                    String v1 = this.page == 0 || this.state.getPendingPackage() == null ? "El borrador no se ha guardado. Volver y descartarlo?" : "La sesión continúa activa. Debes volver y restaurarla manualmente. El journal permanecerá guardado.";
                    v0.setMessage(((CharSequence)v1)).setPositiveButton("Volver", new GraphicsCenterActivity$$ExternalSyntheticLambda11(this)).setNegativeButton("Cancelar", null).show();
                    return;
                }

                super.finish();
                return;
            }
        }

        this.toast("Espera a que termine la operación gráfica");
    }

    static final void finish$lambda$41(GraphicsCenterActivity arg0, DialogInterface arg1, int arg2) {
        arg0.leaving = true;
        super.finish();
    }

    private final boolean getDirty() {
        return this.draftState.getDirty();
    }

    private final GraphicsProfileStore getStore() {
        return this.store$delegate.getValue();
    }

    private final void inspect(boolean arg3) {
        if(this.pkg.length() == 0) {
            return;
        }

        this.inspections.request(this.inspectionKey(), arg3);
        this.drainInspection();
        this.renderStatus();
    }

    static void inspect$default(GraphicsCenterActivity arg0, boolean arg1, int arg2, Object arg3) {
        arg0.inspect(false);
    }

    private final GraphicsInspectionKey inspectionKey() {
        return new GraphicsInspectionKey(this.pkg, this.profile, GraphicsRuntime.INSTANCE.getStatus().getValue().getRevision());
    }

    private final TextView label(LinearLayout arg3, String arg4, int arg5) {
        TextView v0 = new TextView(this);
        v0.setText(((CharSequence)arg4));
        v0.setTextSize(((float)arg5));
        int v1 = -1;
        int v4 = arg5 >= 14 ? v1 : -4800562;
        v0.setTextColor(v4);
        v0.setPadding(0, this.dp(4), 0, this.dp(4));
        arg3.addView(v0, new LinearLayout$LayoutParams(v1, -2));
        return v0;
    }

    private final Object loadSelectedGame(String arg25, Continuation arg26) {
        Object v1_1;
        int v5;
        Continuation v3;
        GraphicsCenterActivity v0 = this;
        String v1 = arg25;
        Continuation v2 = arg26;
        if((v2 instanceof GraphicsCenterActivity$loadSelectedGame$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((GraphicsCenterActivity$loadSelectedGame$1)v3).label & v5) != 0) {
                ((GraphicsCenterActivity$loadSelectedGame$1)v3).label -= v5;
            }
            else {
                goto label_14;
            }
        }
        else {
        label_14:
            GraphicsCenterActivity$loadSelectedGame$1 v3_1 = new GraphicsCenterActivity$loadSelectedGame$1(v0, v2);
        }

        Object v2_1 = ((GraphicsCenterActivity$loadSelectedGame$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((GraphicsCenterActivity$loadSelectedGame$1)v3).label;
        Continuation v7 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            if(GraphicsProfileKt.validGraphicsPackage(v1)) {
                CoroutineDispatcher v2_2 = Dispatchers.getIO();
                GraphicsCenterActivity$loadSelectedGame$3 v5_1 = new GraphicsCenterActivity$loadSelectedGame$3(v0, v1, v7);
                ((GraphicsCenterActivity$loadSelectedGame$1)v3).L$0 = v1;
                ((GraphicsCenterActivity$loadSelectedGame$1)v3).label = 1;
                v2_1 = BuildersKt.withContext(((CoroutineContext)v2_2), ((Function2)v5_1), v3);
                if(v2_1 == v4) {
                    return v4;
                }
            }
            else {
                goto label_87;
            }
        }
        else if(v5 == 1) {
            v1_1 = ((GraphicsCenterActivity$loadSelectedGame$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        Object v3_2 = ((Pair)v2_1).component1();
        v2_1 = ((Pair)v2_1).component2();
        Intrinsics.checkNotNullExpressionValue(v2_1, "component2(...)");
        v0.pkg = ((String)v1_1);
        v0.profile = ((GraphicsProfile)v3_2);
        v0.caps = new GraphicsCapabilities(null, null, null, null, null, null, null, null, null, null, null, null, null, 0x1FFF, null);
        v0.draftState = new GraphicsDraftState(((String)v7), false, 3, ((DefaultConstructorMarker)v7));
        ImageView v1_2 = v0.icon;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
        }
        else {
            ImageView v7_1 = v1_2;
        }

        ((ImageView)v7).setImageDrawable(((Drawable)v2_1));
        v1 = v0.getStore().saved(v0.pkg) ? "GUARDADO · perfil local; estado gráfico indicado aparte" : "SIN CONFIGURAR · perfil local nuevo";
        v0.notice = v1;
        return Unit.INSTANCE;
    label_87:
        throw new IllegalArgumentException("Selecciona un juego válido desde el carrusel".toString());
    }

    private final LinearLayout newPage() {
        LinearLayout v0 = new LinearLayout(this);
        v0.setOrientation(1);
        v0.setPadding(0, this.dp(12), 0, this.dp(12));
        ScrollView v3 = new ScrollView(this);
        v3.setFillViewport(true);
        v3.addView(v0);
        FrameLayout v1 = this.frame;
        if(v1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frame");
            v1 = null;
        }

        v1.addView(v3, new FrameLayout$LayoutParams(-1, -1));
        this.pages.add(v3);
        return v0;
    }

    protected void onCreate(Bundle arg17) {
        String v0_6;
        GraphicsCenterActivity v1 = this;
        Bundle v4 = arg17;
        super.onCreate(arg17);
        int v3 = 3;
        if(Build$VERSION.SDK_INT >= 28) {
            Window v0 = v1.getWindow();
            WindowManager$LayoutParams v2 = v1.getWindow().getAttributes();
            int v6 = Build$VERSION.SDK_INT >= 30 ? v3 : 1;
            v2.layoutInDisplayCutoutMode = v6;
            v0.setAttributes(v2);
        }

        View v0_1 = v1.findViewById(id.graphics_rail);
        Intrinsics.checkNotNullExpressionValue(v0_1, "findViewById(...)");
        v1.rail = ((LinearLayout)v0_1);
        v0_1 = v1.findViewById(id.graphics_pages);
        Intrinsics.checkNotNullExpressionValue(v0_1, "findViewById(...)");
        v1.frame = ((FrameLayout)v0_1);
        v0_1 = v1.findViewById(id.graphics_status);
        Intrinsics.checkNotNullExpressionValue(v0_1, "findViewById(...)");
        v1.status = ((TextView)v0_1);
        v0_1 = v1.findViewById(id.shark_settings_center_header);
        int v2_1 = v0_1.getBackground().getMinimumHeight();
        v0_1.setBackgroundColor(Color.rgb(20, 22, 0x1F));
        v0_1.setMinimumHeight(v2_1);
        GraphicsCenterActivity v6_1 = v1;
        v1.getOnBackPressedDispatcher().addCallback(((LifecycleOwner)v6_1), new GraphicsCenterActivity$onCreate$2(v1));
        ImageView v0_2 = new ImageView(v1);
        v0_2.setContentDescription("Icono del juego seleccionado");
        v1.icon = v0_2;
        LinearLayout v0_3 = v1.rail;
        String v2_2 = "rail";
        Continuation v7 = null;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2_2);
            v0_3 = ((LinearLayout)v7);
        }

        ImageView v8 = v1.icon;
        if(v8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            View v8_1 = ((View)v7);
        }

        LinearLayout$LayoutParams v9 = new LinearLayout$LayoutParams(v1.dp(44), v1.dp(44));
        v9.gravity = 1;
        v0_3.addView(((View)v8), ((ViewGroup$LayoutParams)v9));
        String[] v0_4 = new String[v3];
        int v8_2 = 0;
        v0_4[0] = "Textura Grafica";
        v0_4[1] = "Gráficos";
        int v9_1 = 2;
        v0_4[v9_1] = "Rendimiento";
        Iterator v0_5 = CollectionsKt.listOf(((Object[])v0_4)).iterator();
        for(v3 = 0; v0_5.hasNext(); v3 = v11) {
            Object v10 = v0_5.next();
            int v11 = v3 + 1;
            if(v3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            LayoutInflater v12 = v1.getLayoutInflater();
            int v13 = layout.shark_settings_basic_tab;
            LinearLayout v14 = v1.rail;
            if(v14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2_2);
                ViewGroup v14_1 = ((ViewGroup)v7);
            }

            View v12_1 = v12.inflate(v13, ((ViewGroup)v14), false);
            v12_1.findViewById(id.shark_settings_titleview).setText(((CharSequence)v10));
            v12_1.findViewById(id.shark_settings_lefticon).setImportantForAccessibility(v9_1);
            v12_1.findViewById(id.shark_settings_righticon).setImportantForAccessibility(v9_1);
            v12_1.setFocusable(true);
            v12_1.setOnClickListener(new GraphicsCenterActivity$$ExternalSyntheticLambda21(v1, v3));
            LinearLayout v3_1 = v1.rail;
            if(v3_1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2_2);
                v3_1 = ((LinearLayout)v7);
            }

            LinearLayout$LayoutParams v10_1 = new LinearLayout$LayoutParams(v1.getResources().getDimensionPixelSize(dimen.shark_settings_gxd_dimen_498), v1.getResources().getDimensionPixelSize(dimen.shark_settings_gxd_dimen_124));
            v10_1.topMargin = v1.getResources().getDimensionPixelSize(dimen.shark_settings_gxd_dimen_20);
            v3_1.addView(v12_1, ((ViewGroup$LayoutParams)v10_1));
            v1.tabs.add(v12_1);
        }

        v0_3 = v1.rail;
        if(v0_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(v2_2);
            v0_3 = ((LinearLayout)v7);
        }

        v1.check = v1.button(v0_3, "Comprobar compatibilidad", new GraphicsCenterActivity$$ExternalSyntheticLambda23(v1));
        v0_1 = v1.findViewById(id.graphics_actions);
        Intrinsics.checkNotNull(v0_1);
        v1.save = v1.button(((LinearLayout)v0_1), "Guardar", new GraphicsCenterActivity$$ExternalSyntheticLambda24(v1));
        v1.apply = v1.button(((LinearLayout)v0_1), "Aplicar", new GraphicsCenterActivity$$ExternalSyntheticLambda25(v1));
        v1.restore = v1.button(((LinearLayout)v0_1), "Restaurar sesión", new GraphicsCenterActivity$$ExternalSyntheticLambda26(v1));
        v2_1 = ((LinearLayout)v0_1).getChildCount();
        for(v3 = 0; v3 < v2_1; ++v3) {
            ((LinearLayout)v0_1).getChildAt(v3).setLayoutParams(new LinearLayout$LayoutParams(0, v1.dp(0x30), 1f));
        }

        v1.loading = GoldenGraphicsLoadingView.Companion.attach(v1);
        if(v4 != null) {
            v8_2 = RangesKt.coerceIn(v4.getInt("section"), 0, CollectionsKt.getLastIndex(v1.tabs));
        }

        v1.page = v8_2;
        if(v4 != null) {
            v0_6 = v4.getString("package");
            if(v0_6 == null) {
                goto label_186;
            }
        }
        else {
        label_186:
            v0_6 = v1.getIntent().getStringExtra("graphics_game_package");
        }

        v2_2 = v0_6;
        String v3_2 = v4 != null ? v4.getString("draft") : ((String)v7);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(((LifecycleOwner)v6_1)), null, null, new GraphicsCenterActivity$onCreate$10(v1, v2_2, v3_2, v4, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(((LifecycleOwner)v6_1)), null, null, new GraphicsCenterActivity$onCreate$11(v1, v7), 3, null);
        v1.rebuild();
    }

    static final Unit onCreate$lambda$10(GraphicsCenterActivity arg0) {
        arg0.confirmApply();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$11(GraphicsCenterActivity arg0) {
        arg0.confirmRestore();
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$7$lambda$5$lambda$4(GraphicsCenterActivity arg0, int arg1, View arg2) {
        arg0.showPage(arg1);
    }

    static final Unit onCreate$lambda$8(GraphicsCenterActivity arg1) {
        arg1.inspect(true);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$9(GraphicsCenterActivity arg0) {
        arg0.saveProfile();
        return Unit.INSTANCE;
    }

    protected void onResume() {
        super.onResume();
        GraphicsRuntime v0 = GraphicsRuntime.INSTANCE;
        Context v2 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getApplicationContext(...)");
        v0.refresh(v2);
    }

    protected void onSaveInstanceState(Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg3, "outState");
        arg3.putInt("section", this.page);
        arg3.putString("package", this.pkg);
        arg3.putString("draft", GraphicsProfileStore.Companion.encode(this.profile));
        arg3.putBoolean("dirty", this.getDirty());
        arg3.putString("draftRevision", this.draftState.getRevision());
        arg3.putString("notice", this.notice);
        super.onSaveInstanceState(arg3);
    }

    private final void rebuild() {
        Object v0_2;
        GraphicsCenterActivity v1 = this;
        v1.pages.clear();
        FrameLayout v0 = v1.frame;
        if(v0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frame");
            v0 = null;
        }

        v0.removeAllViews();
        LinearLayout v2 = v1.newPage();
        try {
            v0_2 = Result.constructor-impl(v1.getPackageManager().getApplicationLabel(v1.getPackageManager().getApplicationInfo(v1.pkg, 0)).toString());
        }
        catch(Throwable v0_1) {
            v0_2 = Result.constructor-impl(ResultKt.createFailure(v0_1));
        }

        String v3 = v1.pkg;
        if(Result.isFailure-impl(v0_2)) {
            String v0_3 = v3;
        }

        GraphicsCenterActivity.toggle$default(v1, v2, "Activar para el juego · " + (((String)v0_2)), v1.profile.getTexture(), false, new GraphicsCenterActivity$$ExternalSyntheticLambda30(v1), 8, null);
        LinearLayout v7 = v2;
        String v2_1 = v1.profile.getTexture() ? "Activada" : "Desactivada";
        v2 = v1.card(v7, "Textura", v2_1 + " para " + (((String)v0_2)));
        int v0_4 = 5;
        String[] v3_1 = new String[v0_4];
        String v10 = "Original";
        v3_1[0] = v10;
        v3_1[1] = "Ligero";
        int v12 = 2;
        v3_1[v12] = "Retro";
        int v13 = 3;
        v3_1[v13] = "Bloques";
        int v14 = 4;
        v3_1[v14] = "Extremo";
        v1.choices(v2, CollectionsKt.listOf(((Object[])v3_1)), v1.profile.getLevel(), new GraphicsCenterActivity$$ExternalSyntheticLambda6(v1), new GraphicsCenterActivity$$ExternalSyntheticLambda8(v1));
        v1.toggle(v7, "Píxeles nítidos", v1.profile.getNearest(), v1.profile.getTexture(), new GraphicsCenterActivity$$ExternalSyntheticLambda9(v1));
        v1.toggle(v7, "Distancia escalonada", v1.profile.getMipNearest(), v1.profile.getTexture(), new GraphicsCenterActivity$$ExternalSyntheticLambda10(v1));
        v1.button(v7, "Restablecer Original", new GraphicsCenterActivity$$ExternalSyntheticLambda12(v1)).setEnabled(v1.profile.getTexture());
        v2 = v1.newPage();
        LinearLayout v3_2 = GraphicsCenterActivity.card$default(v1, v2, "Tasa de refresco", null, 4, null);
        LinearLayout v15 = v2;
        List v2_2 = CollectionsKt.plus(CollectionsKt.listOf(Integer.valueOf(0)), CollectionsKt.sorted(v1.caps.getHz()));
        ArrayList v5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(v2_2, 10));
        Iterator v4 = v2_2.iterator();
        while(v4.hasNext()) {
            int v6 = v4.next().intValue();
            String v6_1 = v6 == 0 ? v10 : v6 + " Hz";
            ((Collection)v5).add(v6_1);
        }

        GraphicsCenterActivity.choices$default(v1, v3_2, v5, v2_2.indexOf(Integer.valueOf(v1.profile.getHz())), null, new GraphicsCenterActivity$$ExternalSyntheticLambda13(v1, v2_2), 8, null);
        v1.slider(GraphicsCenterActivity.card$default(v1, v15, "Saturación de color · " + (((float)v1.profile.getSaturation())) / 10f + "x", null, 4, null), 12, v1.profile.getSaturation() - 8, false, new GraphicsCenterActivity$$ExternalSyntheticLambda14());
        v1 = this;
        v3_2 = GraphicsCenterActivity.card$default(v1, v15, "Modo de color", null, 4, null);
        String[] v2_3 = new String[v14];
        v2_3[0] = v10;
        v2_3[1] = "Natural";
        v2_3[v12] = "Vívido";
        v2_3[v13] = "Alto contraste";
        v1.choices(v3_2, CollectionsKt.listOf(((Object[])v2_3)), v1.profile.getColor() + 1, new GraphicsCenterActivity$$ExternalSyntheticLambda15(v1), new GraphicsCenterActivity$$ExternalSyntheticLambda16(v1));
        v1.slider(v1.card(v15, "Resolución del juego · " + v1.profile.getResolution() + "%", "50–100%, paso 5%. Bloqueada: falta exclusión segura con Stretch y restauración exacta del override GameManager."), 10, (v1.profile.getResolution() - 50) / 5, false, new GraphicsCenterActivity$$ExternalSyntheticLambda31());
        v3_2 = GraphicsCenterActivity.card$default(v1, v15, "Límite de FPS", null, 4, null);
        v2_3 = new String[v0_4];
        v2_3[0] = "30";
        v2_3[1] = "60";
        v2_3[v12] = "90";
        v2_3[v13] = "120";
        v2_3[v14] = "Máximo";
        v2_2 = CollectionsKt.listOf(((Object[])v2_3));
        Integer[] v0_5 = new Integer[v0_4];
        v0_5[0] = Integer.valueOf(30);
        v0_5[1] = Integer.valueOf(60);
        v0_5[v12] = Integer.valueOf(90);
        v0_5[v13] = Integer.valueOf(120);
        v0_5[v14] = Integer.valueOf(0);
        v1.choices(v3_2, v2_2, CollectionsKt.listOf(((Object[])v0_5)).indexOf(Integer.valueOf(v1.profile.getFps())), new GraphicsCenterActivity$$ExternalSyntheticLambda32(), new GraphicsCenterActivity$$ExternalSyntheticLambda33());
        boolean v4_1 = v1.profile.getMsaa();
        boolean v5_1 = v1.caps.getMsaa() == null ? true : false;
        v1.toggle(v15, "Antialiasing 4x MSAA", v4_1, v5_1, new GraphicsCenterActivity$$ExternalSyntheticLambda34(v1));
        v2 = GraphicsCenterActivity.card$default(this, v15, "Controlador gráfico", null, 4, null);
        String[] v0_6 = new String[v13];
        v0_6[0] = "Predeterminado";
        v0_6[1] = "Game Driver";
        v0_6[v12] = "Vulkan vía ANGLE";
        this.choices(v2, CollectionsKt.listOf(((Object[])v0_6)), this.profile.getDriver(), new GraphicsCenterActivity$$ExternalSyntheticLambda35(this), new GraphicsCenterActivity$$ExternalSyntheticLambda1(this));
        v2 = this.newPage();
        LinearLayout v0_7 = GraphicsCenterActivity.card$default(this, v2, "Modo de juego", null, 4, null);
        v7 = v2;
        v2_3 = new String[v13];
        v2_3[0] = "Estándar";
        v2_3[1] = "Rendimiento";
        v2_3[v12] = "Ahorro";
        this.choices(v0_7, CollectionsKt.listOf(((Object[])v2_3)), this.profile.getMode(), new GraphicsCenterActivity$$ExternalSyntheticLambda2(this), new GraphicsCenterActivity$$ExternalSyntheticLambda3(this));
        this.toggle(v7, "Rendimiento fijo", false, false, new GraphicsCenterActivity$$ExternalSyntheticLambda4());
        v2 = GraphicsCenterActivity.card$default(this, v7, "Animaciones del sistema", null, 4, null);
        v0_6 = new String[v13];
        v0_6[0] = v10;
        v0_6[1] = "0.5x";
        v0_6[v12] = "Sin animación";
        this.choices(v2, CollectionsKt.listOf(((Object[])v0_6)), this.profile.getAnimations(), new GraphicsCenterActivity$$ExternalSyntheticLambda5(this), new GraphicsCenterActivity$$ExternalSyntheticLambda7(this));
        this.showPage(this.page);
        this.renderStatus();
    }

    static final Unit rebuild$lambda$15(GraphicsCenterActivity arg20, boolean arg21) {
        GraphicsCenterActivity v0 = arg20;
        Object v1 = null;
        if(!arg21) {
            GraphicsCenterActivity.edit$default(v0, GraphicsProfile.copy$default(v0.profile, false, null, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FFE, null), false, 2, v1);
        }
        else {
            v0.rebuild();
            new AlertDialog$Builder(v0).setTitle("Textura Ligera").setMessage("Solo cambia cómo se ven las texturas en tu teléfono. Los archivos del juego no se tocan.").setNegativeButton("Cancelar", ((DialogInterface$OnClickListener)v1)).setPositiveButton("Activar", new GraphicsCenterActivity$$ExternalSyntheticLambda17(v0)).show();
        }

        return Unit.INSTANCE;
    }

    static final void rebuild$lambda$15$lambda$14(GraphicsCenterActivity arg19, DialogInterface arg20, int arg21) {
        GraphicsCenterActivity.edit$default(arg19, GraphicsProfile.copy$default(arg19.profile, true, null, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FFE, null), false, 2, null);
    }

    static final boolean rebuild$lambda$16(GraphicsCenterActivity arg0, int arg1) {
        return arg0.profile.getTexture();
    }

    static final Unit rebuild$lambda$17(GraphicsCenterActivity arg19, int arg20) {
        GraphicsCenterActivity.edit$default(arg19, GraphicsProfile.copy$default(arg19.profile, false, TexturePreset.CUSTOM, arg20, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FF9, null), false, 2, null);
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$18(GraphicsCenterActivity arg19, boolean arg20) {
        arg19.edit(GraphicsProfile.copy$default(arg19.profile, false, TexturePreset.CUSTOM, 0, arg20, false, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FF5, null), false);
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$19(GraphicsCenterActivity arg19, boolean arg20) {
        arg19.edit(GraphicsProfile.copy$default(arg19.profile, false, TexturePreset.CUSTOM, 0, false, arg20, 0, 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FED, null), false);
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$20(GraphicsCenterActivity arg4) {
        GraphicsCenterActivity.edit$default(arg4, arg4.profile.original(), false, 2, null);
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$22(GraphicsCenterActivity arg19, List arg20, int arg21) {
        GraphicsCenterActivity.edit$default(arg19, GraphicsProfile.copy$default(arg19.profile, false, null, 0, false, false, arg20.get(arg21).intValue(), 0, 0, 0, 0, false, 0, 0, false, 0, 0x7FDF, null), false, 2, null);
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$23(int arg0) {
        return Unit.INSTANCE;
    }

    static final boolean rebuild$lambda$24(GraphicsCenterActivity arg1, int arg2) {
        if(arg2 != 0) {
            if(arg1.caps.getColors().contains(Integer.valueOf(arg2 - 1))) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final Unit rebuild$lambda$25(GraphicsCenterActivity arg19, int arg20) {
        GraphicsCenterActivity.edit$default(arg19, GraphicsProfile.copy$default(arg19.profile, false, null, 0, false, false, 0, 0, arg20 - 1, 0, 0, false, 0, 0, false, 0, 0x7F7F, null), false, 2, null);
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$26(int arg0) {
        return Unit.INSTANCE;
    }

    static final boolean rebuild$lambda$27(int arg0) {
        return 0;
    }

    static final Unit rebuild$lambda$28(int arg0) {
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$29(GraphicsCenterActivity arg19, boolean arg20) {
        arg19.edit(GraphicsProfile.copy$default(arg19.profile, false, null, 0, false, false, 0, 0, 0, 0, 0, arg20, 0, 0, false, 0, 0x7BFF, null), false);
        return Unit.INSTANCE;
    }

    static final boolean rebuild$lambda$30(GraphicsCenterActivity arg2, int arg3) {
        if(arg3 != 0 && (arg3 != 1 || arg2.caps.getGameDriver() != null) && (arg3 != 2 || arg2.caps.getAngle() != null)) {
            return 0;
        }

        return 1;
    }

    static final Unit rebuild$lambda$31(GraphicsCenterActivity arg19, int arg20) {
        GraphicsCenterActivity.edit$default(arg19, GraphicsProfile.copy$default(arg19.profile, false, null, 0, false, false, 0, 0, 0, 0, 0, false, arg20, 0, false, 0, 0x77FF, null), false, 2, null);
        return Unit.INSTANCE;
    }

    static final boolean rebuild$lambda$32(GraphicsCenterActivity arg1, int arg2) {
        if(arg2 != 0) {
            Set v1 = arg1.caps.getModes();
            String v2 = arg2 == 1 ? "performance" : "battery";
            if(v1.contains(v2)) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    static final Unit rebuild$lambda$33(GraphicsCenterActivity arg19, int arg20) {
        GraphicsCenterActivity.edit$default(arg19, GraphicsProfile.copy$default(arg19.profile, false, null, 0, false, false, 0, 0, 0, 0, 0, false, 0, arg20, false, 0, 0x6FFF, null), false, 2, null);
        return Unit.INSTANCE;
    }

    static final Unit rebuild$lambda$34(boolean arg0) {
        return Unit.INSTANCE;
    }

    static final boolean rebuild$lambda$35(GraphicsCenterActivity arg0, int arg1) {
        if(arg1 != 0) {
            if(arg0.caps.getAnimations() == null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final Unit rebuild$lambda$36(GraphicsCenterActivity arg19, int arg20) {
        GraphicsCenterActivity.edit$default(arg19, GraphicsProfile.copy$default(arg19.profile, false, null, 0, false, false, 0, 0, 0, 0, 0, false, 0, 0, false, arg20, 0x3FFF, null), false, 2, null);
        return Unit.INSTANCE;
    }

    private final void reconcileSave() {
        if((this.getDirty()) && (Intrinsics.areEqual(this.state.getSavedPackage(), this.pkg)) && (Intrinsics.areEqual(this.state.getSavedRevision(), this.draftState.getRevision()))) {
            this.draftState = this.draftState.confirmed(this.state.getSavedRevision());
            this.notice = "GUARDADO · perfil local; resultado de aplicación indicado aparte, efecto visual no verificado";
        }
    }

    private final void reflectRuntime(boolean arg2) {
        this.consumeRuntime(GraphicsRuntime.INSTANCE.getStatus().getValue());
        if(!arg2) {
            this.toast("Hay otra operación gráfica en curso. Espera su resultado.");
        }
    }

    private final void renderStatus() {
        String v1_1;
        GraphicsCenterActivity v0 = this;
        if(v0.status == null) {
            return;
        }

        List v1 = v0.caps.blockers(v0.profile, v0.pkg);
        boolean v3 = false;
        boolean v2 = (v0.checking) || (v0.inspections.getPending()) ? true : false;
        GraphicsButtonState v5 = GraphicsButtonStateKt.graphicsButtons(v0.pkg, v0.state, v2, v1, v0.sessionOwner());
        TextView v6 = v0.status;
        Object v7 = null;
        if(v6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("status");
            v6 = ((TextView)v7);
        }

        if(v0.page != 0 || !StringsKt.startsWith$default(v0.notice, "ERROR", false, 2, v7)) {
            String v9 = "";
            if(v0.page == 0) {
                if(v0.getDirty()) {
                    v9 = "Cambios sin guardar. ";
                }

                v1_1 = v9.concat("Guardar y pulsar Play para usar la textura. Otras aplicaciones ANGLE también pueden recibir el efecto.");
            }
            else {
                String v8 = v0.draftState.status(v0.notice, v0.state.getMessage());
                String v10 = v5.getExplanation();
                String v11 = "\n";
                if(!v2 && !v0.state.getBusy() && v0.state.getPendingPackage() != null && !v1.isEmpty()) {
                    v9 = v11 + CollectionsKt.joinToString$default(v1, "; ", null, null, 0, null, null, 62, null);
                }

                v1_1 = v8 + v11 + v10 + v9;
            }
        }
        else {
            v1_1 = v0.notice;
        }

        v6.setText(((CharSequence)v1_1));
        if(v0.pkg.length() > 0 && !v0.state.getBusy() && !v2) {
            v3 = true;
        }

        Button v1_2 = v0.save;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
            v1_2 = ((Button)v7);
        }

        v1_2.setEnabled(v3);
        v1_2 = v0.check;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("check");
            v1_2 = ((Button)v7);
        }

        v1_2.setEnabled(v3);
        v1_2 = v0.apply;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apply");
            v1_2 = ((Button)v7);
        }

        v1_2.setEnabled(v5.getApply());
        v1_2 = v0.restore;
        if(v1_2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restore");
            v1_2 = ((Button)v7);
        }

        v1_2.setEnabled(v5.getRestore());
        FrameLayout v1_3 = v0.frame;
        if(v1_3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frame");
            v1_3 = ((FrameLayout)v7);
        }

        v1_3.setEnabled(v0.state.getBusy() ^ 1);
        GoldenGraphicsLoadingView v1_4 = v0.loading;
        if(v1_4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loading");
            v1_4 = ((GoldenGraphicsLoadingView)v7);
        }

        GraphicsLoadingOperation v0_1 = GraphicsLoadingStateKt.graphicsLoadingOperation(v0.state, v0.saving, v2);
        if(v0_1 != null) {
            String v7_1 = v0_1.getLabel();
        }

        v1_4.render(((String)v7));
    }

    private final void saveProfile() {
        if(this.pkg.length() == 0) {
            return;
        }

        if(!this.checking) {
            if(this.state.getBusy()) {
            }
            else {
                String v3 = this.pkg;
                GraphicsProfile v5 = this.profile;
                String v4 = this.draftState.getRevision();
                this.checking = true;
                this.saving = true;
                this.renderStatus();
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GraphicsCenterActivity$saveProfile$1(this, v3, v4, v5, null), 3, null);
            }
        }
    }

    private final String sessionOwner() {
        Object v0_1;
        Object v3_1;
        String v0 = this.state.getPendingPackage();
        if(v0 == null) {
            return "";
        }

        try {
            v3_1 = Result.constructor-impl(this.getPackageManager().getApplicationLabel(this.getPackageManager().getApplicationInfo(v0, 0)).toString());
        }
        catch(Throwable v3) {
            v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
        }

        if(Result.isFailure-impl(v3_1)) {
        }
        else {
            v0_1 = v3_1;
        }

        return ((String)v0_1);
    }

    private final void showPage(int arg10) {
        int v3_2;
        Button v3_1;
        Button v0_2;
        LinearLayout v2_2;
        Object v2_1;
        this.page = arg10;
        View v0 = this.findViewById(id.graphics_actions);
        Button[] v1 = new Button[2];
        Button v2 = this.apply;
        View v3 = null;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apply");
            v2 = ((Button)v3);
        }

        v1[0] = v2;
        v2 = this.restore;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restore");
            v2 = ((Button)v3);
        }

        v1[1] = v2;
        Iterator v1_1 = CollectionsKt.listOf(((Object[])v1)).iterator();
        while(v1_1.hasNext()) {
            v2_1 = v1_1.next();
            if(arg10 == 0) {
                ((LinearLayout)v0).removeView(((View)v2_1));
                continue;
            }

            if(((Button)v2_1).getParent() != null) {
                continue;
            }

            ((LinearLayout)v0).addView(((View)v2_1), new LinearLayout$LayoutParams(0, this.dp(0x30), 1f));
        }

        String v0_1 = "rail";
        String v1_2 = "check";
        if(arg10 == 0) {
            v2_2 = this.rail;
            if(v2_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0_1);
                v2_2 = ((LinearLayout)v3);
            }

            v0_2 = this.check;
            if(v0_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_2);
            }
            else {
                v3_1 = v0_2;
            }

            v2_2.removeView(((View)v3_1));
        }
        else {
            v2 = this.check;
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_2);
                v2 = ((Button)v3);
            }

            if(v2.getParent() != null) {
                goto label_70;
            }

            v2_2 = this.rail;
            if(v2_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0_1);
                v2_2 = ((LinearLayout)v3);
            }

            v0_2 = this.check;
            if(v0_2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_2);
                v0 = v3;
            }

            v2_2.addView(((View)v0_2));
            if(this.pkg.length() <= 0) {
                goto label_70;
            }

            GraphicsCenterActivity.inspect$default(this, false, 1, v3);
        }

    label_70:
        Iterator v0_3 = this.pages.iterator();
        int v1_3;
        for(v1_3 = 0; v0_3.hasNext(); v1_3 = v3_2) {
            v2_1 = v0_3.next();
            v3_2 = v1_3 + 1;
            if(v1_3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            v1_3 = v1_3 == arg10 ? 0 : 8;
            ((ScrollView)v2_1).setVisibility(v1_3);
        }

        v0_3 = this.tabs.iterator();
        for(v1_3 = 0; v0_3.hasNext(); v1_3 = v3_2) {
            v2_1 = v0_3.next();
            v3_2 = v1_3 + 1;
            if(v1_3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            boolean v1_4 = v1_3 == arg10 ? true : false;
            ((View)v2_1).setSelected(v1_4);
        }

        this.renderStatus();
    }

    private final void slider(LinearLayout arg3, int arg4, int arg5, boolean arg6, Function1 arg7) {
        SeekBar v0 = new SeekBar(this);
        v0.setMax(arg4);
        v0.setProgress(arg5);
        v0.setEnabled(arg6);
        View v4 = arg3.getChildAt(0);
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type android.widget.TextView");
        v0.setContentDescription(String.valueOf(((TextView)v4).getText()));
        v0.setProgressTintList(ColorStateList.valueOf(0xFF809FC5));
        v0.setThumbTintList(ColorStateList.valueOf(0xFF9BB4D5));
        v0.setOnSeekBarChangeListener(new GraphicsCenterActivity$slider$1$1(arg7));
        arg3.addView(((View)v0), new LinearLayout$LayoutParams(-1, this.dp(0x30)));
    }

    static final GraphicsProfileStore store_delegate$lambda$0(GraphicsCenterActivity arg2) {
        Context v2 = arg2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(v2, "getApplicationContext(...)");
        return new GraphicsProfileStore(v2);
    }

    private final void toast(String arg2) {
        Toast.makeText(((Context)this), ((CharSequence)arg2), 1).show();
    }

    private final void toggle(LinearLayout arg7, String arg8, boolean arg9, boolean arg10, Function1 arg11) {
        GraphicsCenterActivity v0 = this;
        LinearLayout v6 = GraphicsCenterActivity.card$default(v0, arg7, arg8, null, 4, null);
        View v7 = v0.getLayoutInflater().inflate(layout.graphics_switch, v6, false);
        Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.GoldenSharkGameSwitch");
        ((GoldenSharkGameSwitch)v7).setChecked(arg9);
        ((GoldenSharkGameSwitch)v7).setEnabled(arg10);
        ((GoldenSharkGameSwitch)v7).setContentDescription(arg8);
        ((GoldenSharkGameSwitch)v7).setOnCheckedChangeListener(new GraphicsCenterActivity$$ExternalSyntheticLambda19(arg11));
        v6.addView(v7);
    }

    static void toggle$default(GraphicsCenterActivity arg6, LinearLayout arg7, String arg8, boolean arg9, boolean arg10, Function1 arg11, int arg12, Object arg13) {
        arg6.toggle(arg7, arg8, arg9, true, arg11);
    }

    static final void toggle$lambda$60$lambda$59(Function1 arg1, CompoundButton arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        arg1.invoke(Boolean.valueOf(arg3));
    }
}


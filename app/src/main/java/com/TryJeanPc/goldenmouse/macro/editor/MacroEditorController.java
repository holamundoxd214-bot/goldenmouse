package com.TryJeanPc.goldenmouse.macro.editor;

import android.app.AlertDialog$Builder;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build$VERSION;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.cursor.CursorOverlayOrderKt;
import com.TryJeanPc.goldenmouse.service.SessionOverlayWindowsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\n\u0012\u0018\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F0\u000E0\u0007\u0012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\u0018\u0010\u0013\u001A\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010,\u001A\u00020\u000F2\u0006\u0010-\u001A\u00020\u000FH\u0002J\u0010\u0010.\u001A\u00020\f2\u0006\u0010/\u001A\u000200H\u0002J\u0006\u00101\u001A\u00020\fJ\u0010\u00102\u001A\u00020\f2\u0006\u00103\u001A\u00020\u000FH\u0002J\u0010\u00104\u001A\u00020\f2\u0006\u00105\u001A\u000206H\u0002J\u0006\u00107\u001A\u00020\fJ\u0010\u00108\u001A\u00020\f2\u0006\u00103\u001A\u000209H\u0002J\u0010\u0010:\u001A\u00020\f2\u0006\u00103\u001A\u000209H\u0002J.\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u0002002\u0006\u0010>\u001A\u00020\u00032\u0006\u0010?\u001A\u0002002\f\u0010@\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0007H\u0002J\u0010\u0010A\u001A\u00020\f2\u0006\u0010B\u001A\u00020\bH\u0002J\u0006\u0010C\u001A\u00020\fR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F0\u000E0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001A\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\n \u001D*\u0004\u0018\u00010\u001C0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001E\u001A\n \u001D*\u0004\u0018\u00010\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001A\n \u001D*\u0004\u0018\u00010\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001A\n \u001D*\u0004\u0018\u00010\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001A\b\u0012\u0004\u0012\u00020\b0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorController;", "", "root", "Landroid/view/View;", "manager", "Landroid/view/WindowManager;", "dialogProvider", "Lkotlin/Function0;", "Landroid/app/Dialog;", "onCaptureVisibility", "Lkotlin/Function1;", "", "", "screenSize", "Lkotlin/Pair;", "", "onClose", "initialDraft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "onSave", "Lkotlin/Result;", "<init>", "(Landroid/view/View;Landroid/view/WindowManager;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;Lkotlin/jvm/functions/Function1;)V", "model", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorModel;", "getModel", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorModel;", "timeline", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroTimelineView;", "kotlin.jvm.PlatformType", "name", "Landroid/widget/EditText;", "repetitions", "interval", "gold", "children", "", "picker", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroCoordinatePicker;", "capturing", "closed", "confirmingDiscard", "density", "", "dp", "value", "notice", "message", "", "connect", "selectTool", "id", "capture", "type", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;", "requestCancel", "actionOptions", "", "editAction", "compactDialog", "Landroid/app/AlertDialog;", "title", "content", "positive", "apply", "showChild", "dialog", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroEditorController {
    public static final int $stable = 8;
    private boolean capturing;
    private final Set children;
    private boolean closed;
    private boolean confirmingDiscard;
    private final float density;
    private final Function0 dialogProvider;
    private final int gold;
    private final EditText interval;
    private final WindowManager manager;
    private final MacroEditorModel model;
    private final EditText name;
    private final Function1 onCaptureVisibility;
    private final Function0 onClose;
    private final Function1 onSave;
    private MacroCoordinatePicker picker;
    private final EditText repetitions;
    private final View root;
    private final Function0 screenSize;
    private final MacroTimelineView timeline;

    static {
    }

    public MacroEditorController(View arg2, WindowManager arg3, Function0 arg4, Function1 arg5, Function0 arg6, Function0 arg7, MacroDraft arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg2, "root");
        Intrinsics.checkNotNullParameter(arg3, "manager");
        Intrinsics.checkNotNullParameter(arg4, "dialogProvider");
        Intrinsics.checkNotNullParameter(arg5, "onCaptureVisibility");
        Intrinsics.checkNotNullParameter(arg6, "screenSize");
        Intrinsics.checkNotNullParameter(arg7, "onClose");
        Intrinsics.checkNotNullParameter(arg9, "onSave");
        super();
        this.root = arg2;
        this.manager = arg3;
        this.dialogProvider = arg4;
        this.onCaptureVisibility = arg5;
        this.screenSize = arg6;
        this.onClose = arg7;
        this.onSave = arg9;
        this.model = new MacroEditorModel(arg8);
        this.timeline = arg2.findViewById(id.scrollTimelineMacro);
        this.name = arg2.findViewById(id.editNombreMacro);
        this.repetitions = arg2.findViewById(id.editRepeticionesMacro);
        this.interval = arg2.findViewById(id.editIntervaloMacro);
        this.gold = Color.rgb(0xFF, 210, 26);
        this.children = new LinkedHashSet();
        this.density = arg2.getResources().getDisplayMetrics().density;
    }

    public MacroEditorController(View arg11, WindowManager arg12, Function0 arg13, Function1 arg14, Function0 arg15, Function0 arg16, MacroDraft arg17, Function1 arg18, int arg19, DefaultConstructorMarker arg20) {
        MacroDraft v8 = (arg19 & 0x40) != 0 ? null : arg17;
        this(arg11, arg12, arg13, arg14, arg15, arg16, v8, arg18);
    }

    public static final void access$actionOptions(MacroEditorController arg0, long arg1) {
        arg0.actionOptions(arg1);
    }

    public static final void access$connect$setZoom(MacroEditorController arg0, SeekBar arg1, float arg2) {
        MacroEditorController.connect$setZoom(arg0, arg1, arg2);
    }

    public static final void access$connect$updateLoop(MacroEditorController arg0) {
        MacroEditorController.connect$updateLoop(arg0);
    }

    public static final void access$editAction(MacroEditorController arg0, long arg1) {
        arg0.editAction(arg1);
    }

    private final void actionOptions(long arg12) {
        if(this.closed) {
            return;
        }

        LinearLayout v0 = new LinearLayout(this.root.getContext());
        v0.setOrientation(1);
        v0.setPadding(this.dp(12), this.dp(8), this.dp(12), this.dp(8));
        AlertDialog v8 = new AlertDialog$Builder(this.root.getContext()).setTitle("ACCIÓN").setView(v0).create();
        String[] v2 = new String[2];
        int v4 = 0;
        v2[0] = "DUPLICAR";
        v2[1] = "ELIMINAR";
        Iterator v1 = CollectionsKt.listOf(((Object[])v2)).iterator();
        while(v1.hasNext()) {
            Object v2_1 = v1.next();
            int v9 = v4 + 1;
            if(v4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            TextView v10 = new TextView(this.root.getContext());
            v10.setText(((CharSequence)v2_1));
            v10.setGravity(17);
            v10.setTextColor(this.gold);
            v10.setBackgroundResource(drawable.bg_setting);
            LinearLayout$LayoutParams v2_2 = new LinearLayout$LayoutParams(-1, this.dp(42));
            v2_2.bottomMargin = this.dp(6);
            v10.setLayoutParams(((ViewGroup$LayoutParams)v2_2));
            v10.setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda7(v4, this, arg12, v8));
            v0.addView(((View)v10));
            v4 = v9;
        }

        Intrinsics.checkNotNull(v8);
        this.showChild(((Dialog)v8));
    }

    static final void actionOptions$lambda$33$lambda$32$lambda$31(int arg0, MacroEditorController arg1, long arg2, AlertDialog arg4, View arg5) {
        if(arg0 != 0) {
            arg1.model.delete(arg2);
        }
        else if(arg1.model.duplicate(arg2) == null) {
            arg1.notice("No se pudo duplicar la acción");
        }

        arg1.timeline.refresh();
        arg4.dismiss();
    }

    private final void capture(MacroActionType arg11) {
        if(!this.capturing) {
            if(this.closed) {
            }
            else {
                Object v0 = this.dialogProvider.invoke();
                if(v0 == null) {
                }
                else {
                    Window v1 = ((Dialog)v0).getWindow();
                    if(v1 == null) {
                    }
                    else {
                        this.capturing = true;
                        SessionOverlayWindowsKt.hideSessionDialog(((Dialog)v0));
                        this.onCaptureVisibility.invoke(Boolean.valueOf(true));
                        int v2 = Build$VERSION.SDK_INT >= 28 ? v1.getAttributes().layoutInDisplayCutoutMode : 0;
                        Context v4 = this.root.getContext();
                        Intrinsics.checkNotNullExpressionValue(v4, "getContext(...)");
                        MacroCoordinatePicker v3 = new MacroCoordinatePicker(v4, this.manager, v1.getAttributes().type, v2, arg11, new MacroEditorController$$ExternalSyntheticLambda8(this, ((Dialog)v0), v1, arg11));
                        this.picker = v3;
                        v3.show();
                    }
                }
            }
        }
    }

    static final Unit capture$lambda$25(MacroEditorController arg2, Dialog arg3, Window arg4, MacroActionType arg5, List arg6) {
        arg2.picker = null;
        arg2.capturing = false;
        arg2.onCaptureVisibility.invoke(Boolean.valueOf(false));
        if(!arg2.closed) {
            SessionOverlayWindowsKt.showSessionDialog(arg3);
            Context v3 = arg3.getContext();
            Intrinsics.checkNotNullExpressionValue(v3, "getContext(...)");
            CursorOverlayOrderKt.bringCursorAboveWindow(v3);
            arg4.setLayout(-1, -1);
            if(arg6 != null && arg2.model.insert(arg5, arg6) == null) {
                arg2.notice("No se pudo insertar la acción");
            }

            arg2.timeline.refresh();
        }

        return Unit.INSTANCE;
    }

    public final void close() {
        this.closed = true;
        Iterator v0 = CollectionsKt.toList(this.children).iterator();
        while(v0.hasNext()) {
            v0.next().dismiss();
        }

        this.children.clear();
        MacroCoordinatePicker v0_1 = this.picker;
        if(v0_1 != null) {
            v0_1.close();
        }

        this.picker = null;
        if(this.capturing) {
            this.capturing = false;
            this.onCaptureVisibility.invoke(Boolean.valueOf(false));
        }
    }

    private final AlertDialog compactDialog(String arg3, View arg4, String arg5, Function0 arg6) {
        AlertDialog v3 = new AlertDialog$Builder(this.root.getContext()).setTitle(((CharSequence)arg3)).setView(arg4).setNegativeButton("CANCELAR", null).setPositiveButton(((CharSequence)arg5), null).create();
        Intrinsics.checkNotNull(v3);
        this.showChild(v3);
        v3.getButton(-1).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda9(arg6, v3));
        v3.getButton(-1).setTextColor(this.gold);
        v3.getButton(-2).setTextColor(this.gold);
        return v3;
    }

    static final void compactDialog$lambda$45(Function0 arg0, AlertDialog arg1, View arg2) {
        if(arg0.invoke().booleanValue()) {
            arg1.dismiss();
        }
    }

    public final void connect() {
        int v4;
        this.timeline.setModel(this.model);
        this.timeline.setOnEdit(new MacroEditorController$connect$1(this));
        this.timeline.setOnOptions(new MacroEditorController$connect$2(this));
        this.timeline.setOnConflict(new MacroEditorController$$ExternalSyntheticLambda11(this));
        this.name.setText(this.model.getDraft().getName());
        this.name.setHint("Macro 1");
        EditText v0 = this.name;
        Intrinsics.checkNotNullExpressionValue(v0, "name");
        ((TextView)v0).addTextChangedListener(new MacroEditorController$connect$$inlined$doAfterTextChanged$1(this));
        this.name.setOnFocusChangeListener(new MacroEditorController$$ExternalSyntheticLambda14(this));
        this.repetitions.setText(String.valueOf(this.model.getDraft().getRepetitions()));
        this.interval.setText(String.valueOf(this.model.getDraft().getIntervalMs()));
        v0 = this.repetitions;
        Intrinsics.checkNotNullExpressionValue(v0, "repetitions");
        ((TextView)v0).addTextChangedListener(new MacroEditorController$connect$$inlined$doAfterTextChanged$2(this));
        v0 = this.interval;
        Intrinsics.checkNotNullExpressionValue(v0, "interval");
        ((TextView)v0).addTextChangedListener(new MacroEditorController$connect$$inlined$doAfterTextChanged$3(this));
        int[] v0_1 = new int[]{id.btnModoUnaVezMacro, id.btnModoBucleMacro, id.btnModoMantenerMacro, id.btnModoPresionarSoltarMacro};
        int v2 = 0;
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = 4;
            if(v2 >= v4) {
                break;
            }

            this.root.findViewById(v0_1[v2]).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda15(this, v3, v0_1));
            ++v2;
        }

        this.root.findViewById(v0_1[this.model.getDraft().getMode().ordinal()]).performClick();
        Pair[] v0_2 = new Pair[v4];
        v0_2[0] = TuplesKt.to(Integer.valueOf(id.btnToolToque), MacroActionType.TAP);
        v0_2[1] = TuplesKt.to(Integer.valueOf(id.btnToolDeslizar), MacroActionType.SWIPE);
        v0_2[2] = TuplesKt.to(Integer.valueOf(id.btnToolDelay), MacroActionType.DELAY);
        v0_2[3] = TuplesKt.to(Integer.valueOf(id.btnToolLongPress), MacroActionType.LONG_PRESS);
        Iterator v0_3 = MapsKt.mapOf(v0_2).entrySet().iterator();
        while(v0_3.hasNext()) {
            Object v1 = v0_3.next();
            v2 = ((Map$Entry)v1).getKey().intValue();
            this.root.findViewById(v2).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda16(this, v2, ((Map$Entry)v1).getValue()));
        }

        this.root.findViewById(id.btnToolRecord).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda17(this));
        this.root.findViewById(id.btnAgregarDedo).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda18(this));
        this.root.findViewById(id.btnExportarMacro).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda1(this));
        this.root.findViewById(id.btnImportarMacro).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda2(this));
        this.root.findViewById(id.btnCancelarMacro).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda3(this));
        this.root.findViewById(id.btnGuardarMacro).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda4(this));
        View v0_4 = this.root.findViewById(id.seekZoomMacro);
        ((SeekBar)v0_4).setMax(90);
        ((SeekBar)v0_4).setProgress(40);
        ((SeekBar)v0_4).setOnSeekBarChangeListener(new MacroEditorController$connect$16(this, ((SeekBar)v0_4)));
        this.root.findViewById(id.btnZoomMenos).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda12(this, ((SeekBar)v0_4)));
        this.root.findViewById(id.btnZoomMas).setOnClickListener(new MacroEditorController$$ExternalSyntheticLambda13(this, ((SeekBar)v0_4)));
        MacroEditorController.connect$setZoom(this, ((SeekBar)v0_4), 5f);
    }

    static final Unit connect$lambda$0(MacroEditorController arg1) {
        arg1.notice("Conflicto de pista: el cambio no se aplicó");
        return Unit.INSTANCE;
    }

    static final void connect$lambda$10$lambda$9(MacroEditorController arg7, int arg8, int[] arg9, View arg10) {
        boolean v3;
        arg7.model.setMode(MacroRunMode.getEntries().get(arg8));
        int v10 = arg9.length;
        int v0 = 0;
        int v1 = 0;
        int v2;
        for(v2 = 0; true; v2 = v5) {
            v3 = true;
            if(v1 >= v10) {
                break;
            }

            int v5 = v2 + 1;
            View v4 = arg7.root.findViewById(arg9[v1]);
            if(arg8 == v2) {
            }
            else {
                v3 = false;
            }

            ((TextView)v4).setSelected(v3);
            v2 = ((TextView)v4).isSelected() ? arg7.gold : -1;
            ((TextView)v4).setTextColor(v2);
            ++v1;
        }

        if(arg8 == 1) {
        }
        else {
            int v3_1 = 0;
        }

        View v8 = arg7.root.findViewById(id.camposBucleMacro);
        if(v3) {
        }
        else {
            v0 = 8;
        }

        v8.setVisibility(v0);
        v8 = arg7.root.findViewById(id.cabeceraMacro);
        ViewGroup$LayoutParams v9 = v8.getLayoutParams();
        v10 = v3 ? 0x70 : 72;
        v9.height = arg7.dp(v10);
        v8.setLayoutParams(v9);
    }

    static final void connect$lambda$12$lambda$11(MacroEditorController arg1, int arg2, MacroActionType arg3, View arg4) {
        arg1.selectTool(arg2);
        if(arg3 == MacroActionType.DELAY) {
            if(MacroEditorModel.insert$default(arg1.model, arg3, null, 2, null) == null) {
                arg1.notice("Ya existe un Delay global en ese instante");
            }

            arg1.timeline.refresh();
            return;
        }

        arg1.capture(arg3);
    }

    static final void connect$lambda$13(MacroEditorController arg0, View arg1) {
        arg0.selectTool(id.btnToolRecord);
        arg0.notice("La grabación se implementará en una etapa posterior");
    }

    static final void connect$lambda$14(MacroEditorController arg0, View arg1) {
        arg0.model.addTrack();
        arg0.timeline.refresh();
    }

    static final void connect$lambda$15(MacroEditorController arg0, View arg1) {
        arg0.notice("Exportación pendiente de una etapa posterior");
    }

    static final void connect$lambda$16(MacroEditorController arg0, View arg1) {
        arg0.notice("Importación pendiente de una etapa posterior");
    }

    static final void connect$lambda$17(MacroEditorController arg0, View arg1) {
        arg0.requestCancel();
    }

    static final void connect$lambda$2(MacroEditorController arg0, View arg1, boolean arg2) {
        if(!arg2) {
            Editable v1 = arg0.name.getText();
            Intrinsics.checkNotNullExpressionValue(v1, "getText(...)");
            if(StringsKt.isBlank(((CharSequence)v1))) {
                arg0.name.setText("Macro 1");
            }
        }
    }

    static final void connect$lambda$20(MacroEditorController arg3, View arg4) {
        Object v4_2;
        if(!arg3.model.getCanSave()) {
            arg3.notice("Añade al menos una acción");
            return;
        }

        if(arg3.model.getDraft().getMode() == MacroRunMode.LOOP) {
            MacroEditorModel v4 = arg3.model;
            Integer v0 = StringsKt.toIntOrNull(arg3.repetitions.getText().toString());
            int v0_1 = v0 != null ? v0.intValue() : -1;
            Long v1 = StringsKt.toLongOrNull(arg3.interval.getText().toString());
            long v1_1 = v1 != null ? v1.longValue() : -1;
            if(v4.setLoop(v0_1, v1_1)) {
                goto label_33;
            }

            arg3.notice("Revisa las repeticiones y el intervalo");
            return;
        }

    label_33:
        arg3.model.setName(arg3.name.getText().toString());
        try {
            v4_2 = arg3.onSave.invoke(arg3.model.getDraft()).unbox-impl();
        }
        catch(Exception v4_1) {
            v4_2 = Result.constructor-impl(ResultKt.createFailure(((Throwable)v4_1)));
        }

        Throwable v0_2 = Result.exceptionOrNull-impl(v4_2);
        if(v0_2 == null) {
            arg3.onClose.invoke();
        }
        else {
            String v4_3 = v0_2.getMessage();
            if(v4_3 == null) {
                v4_3 = "error de almacenamiento";
            }

            arg3.notice("No se pudo guardar la macro: " + v4_3);
        }
    }

    static final void connect$lambda$21(MacroEditorController arg1, SeekBar arg2, View arg3) {
        MacroEditorController.connect$setZoom(arg1, arg2, arg1.timeline.getZoom() - 0.5f);
    }

    static final void connect$lambda$22(MacroEditorController arg1, SeekBar arg2, View arg3) {
        MacroEditorController.connect$setZoom(arg1, arg2, arg1.timeline.getZoom() + 0.5f);
    }

    private static final void connect$setZoom(MacroEditorController arg3, SeekBar arg4, float arg5) {
        arg3.timeline.setZoom(arg5);
        View v5 = arg3.root.findViewById(id.txtZoomMacro);
        String v0 = String.format(Locale.US, "%.1fx", Arrays.copyOf(new Object[]{Float.valueOf(arg3.timeline.getZoom())}, 1));
        Intrinsics.checkNotNullExpressionValue(v0, "format(...)");
        ((TextView)v5).setText(((CharSequence)v0));
        int v3 = MathKt.roundToInt((arg3.timeline.getZoom() - 1f) * 10f);
        if(arg4.getProgress() != v3) {
            arg4.setProgress(v3);
        }
    }

    private static final void connect$updateLoop(MacroEditorController arg4) {
        MacroEditorModel v0 = arg4.model;
        Integer v1 = StringsKt.toIntOrNull(arg4.repetitions.getText().toString());
        int v1_1 = v1 != null ? v1.intValue() : -1;
        Long v4 = StringsKt.toLongOrNull(arg4.interval.getText().toString());
        long v2 = v4 != null ? v4.longValue() : -1;
        v0.setLoop(v1_1, v2);
    }

    private final int dp(int arg1) {
        return ((int)((((float)arg1)) * this.density));
    }

    private final void editAction(long arg17) {
        String v5_2;
        MacroEditorController v1 = this;
        MacroEditAction v9 = v1.model.action(arg17);
        if(v9 == null) {
            return;
        }

        LinearLayout v0 = new LinearLayout(v1.root.getContext());
        boolean v10 = true;
        v0.setOrientation(1);
        v0.setPadding(v1.dp(12), v1.dp(8), v1.dp(12), v1.dp(8));
        EditText v11 = MacroEditorController.editAction$field$default(v0, v1, "Inicio (ms)", String.valueOf(v9.getStartMs()), false, 16, null);
        v1 = this;
        EditText v2 = MacroEditorController.editAction$field$default(v0, v1, "Duración (ms)", String.valueOf(v9.getDurationMs()), false, 16, null);
        TextView v3 = new TextView(v1.root.getContext());
        v3.setText("Pista");
        v3.setTextColor(v1.gold);
        v3.setTextSize(12f);
        v0.addView(((View)v3));
        List v3_1 = v9.getType() == MacroActionType.DELAY ? CollectionsKt.plus(CollectionsKt.listOf(null), v1.model.getDraft().getTracks()) : v1.model.getDraft().getTracks();
        Spinner v8 = new Spinner(v1.root.getContext());
        Context v4 = v1.root.getContext();
        int v7 = 10;
        ArrayList v6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(v3_1, v7));
        Iterator v5 = v3_1.iterator();
        while(v5.hasNext()) {
            Object v12 = v5.next();
            String v12_1 = v12 == null ? "Global" : "Dedo " + v12;
            ((Collection)v6).add(v12_1);
        }

        v8.setAdapter(new MacroEditorController$editAction$2(v4, ((List)v6)));
        int v5_1 = 0;
        v8.setSelection(RangesKt.coerceAtLeast(v3_1.indexOf(v9.getTrack()), 0));
        v0.addView(v8);
        List v4_1 = v9.getPoints();
        v6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4_1), v7));
        Iterator v4_2 = ((Iterable)v4_1).iterator();
        while(v4_2.hasNext()) {
            Object v7_1 = v4_2.next();
            int v12_2 = v5_1 + 1;
            if(v5_1 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            if(v9.getType() != MacroActionType.SWIPE) {
                v5_2 = "";
            }
            else if(v5_1 == 0) {
                v5_2 = " inicial";
            }
            else {
                v5_2 = " final";
            }

            EditText v13 = MacroEditorController.editAction$field(v0, v1, "X" + v5_2 + " (px)", String.valueOf(((MacroPoint)v7_1).getX()), v10);
            v10 = true;
            ((Collection)v6).add(TuplesKt.to(v13, MacroEditorController.editAction$field(v0, v1, "Y" + v5_2 + " (px)", String.valueOf(((MacroPoint)v7_1).getY()), true)));
            v5_1 = v12_2;
        }

        ScrollView v4_3 = new ScrollView(v1.root.getContext());
        v4_3.addView(((View)v0));
        String v9_1 = v9.getType().getLabel().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v9_1, "toUpperCase(...)");
        v1.compactDialog(v9_1, v4_3, "APLICAR", new MacroEditorController$$ExternalSyntheticLambda6(v11, v2, v6, v1, arg17, v3_1, v8));
    }

    private static final EditText editAction$field(LinearLayout arg2, MacroEditorController arg3, String arg4, String arg5, boolean arg6) {
        TextView v0 = new TextView(arg3.root.getContext());
        v0.setText(((CharSequence)arg4));
        v0.setTextSize(12f);
        v0.setTextColor(arg3.gold);
        arg2.addView(((View)v0));
        EditText v4 = new EditText(arg3.root.getContext());
        v4.setText(((CharSequence)arg5));
        v4.setTextSize(14f);
        int v5 = -1;
        v4.setTextColor(v5);
        v4.setBackgroundResource(drawable.bg_setting);
        int v6 = arg6 ? 0x2000 : 0;
        v4.setInputType(v6 | 2);
        v4.setSingleLine(true);
        LinearLayout$LayoutParams v6_1 = new LinearLayout$LayoutParams(v5, arg3.dp(40));
        v6_1.bottomMargin = arg3.dp(6);
        v4.setLayoutParams(((ViewGroup$LayoutParams)v6_1));
        arg2.addView(v4);
        return v4;
    }

    static EditText editAction$field$default(LinearLayout arg0, MacroEditorController arg1, String arg2, String arg3, boolean arg4, int arg5, Object arg6) {
        return MacroEditorController.editAction$field(arg0, arg1, arg2, arg3, false);
    }

    static final boolean editAction$lambda$44(EditText arg18, EditText arg19, List arg20, MacroEditorController arg21, long arg22, List arg24, Spinner arg25) {
        Object v6;
        MacroEditorController v0 = arg21;
        Long v1 = StringsKt.toLongOrNull(arg18.getText().toString());
        Long v2 = StringsKt.toLongOrNull(arg19.getText().toString());
        ArrayList v4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arg20, 10));
        Iterator v3 = arg20.iterator();
        while(v3.hasNext()) {
            Object v5 = v3.next();
            v6 = ((Pair)v5).component1();
            v5 = ((Pair)v5).component2();
            Float v6_1 = StringsKt.toFloatOrNull(((EditText)v6).getText().toString());
            float v8 = NaNf;
            float v6_2 = v6_1 != null ? v6_1.floatValue() : v8;
            Float v5_1 = StringsKt.toFloatOrNull(((EditText)v5).getText().toString());
            if(v5_1 != null) {
                v8 = v5_1.floatValue();
            }

            ((Collection)v4).add(new MacroPoint(v6_2, v8));
        }

        ArrayList v17 = v4;
        Object v3_1 = v0.screenSize.invoke();
        int v4_1 = ((Pair)v3_1).component1().intValue();
        int v3_2 = ((Pair)v3_1).component2().intValue();
        ArrayList v5_2 = v17;
        if(!(v5_2 instanceof Collection) || !v5_2.isEmpty()) {
            Iterator v5_3 = ((Iterable)v5_2).iterator();
            while(true) {
                if(v5_3.hasNext()) {
                    v6 = v5_3.next();
                    float v10 = 3.402823E+38f;
                    if(Math.abs(((MacroPoint)v6).getX()) <= v10 && Math.abs(((MacroPoint)v6).getY()) <= v10 && ((MacroPoint)v6).getX() >= 0f && ((MacroPoint)v6).getY() >= 0f && ((MacroPoint)v6).getX() < (((float)v4_1)) && ((MacroPoint)v6).getY() < (((float)v3_2))) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_50;
                }
            }

            v3_2 = 0;
            goto label_76;
        label_50:
            v3_2 = 1;
        }
        else {
            goto label_50;
        }

    label_76:
        if(v1 != null && v2 != null && v3_2 != 0) {
            if(!v0.model.edit(arg22, v1.longValue(), v2.longValue(), arg24.get(arg25.getSelectedItemPosition()), ((List)v17))) {
            }
            else {
                v0.timeline.refresh();
                return 1;
            }
        }

        v0.notice("Revisa tiempos, coordenadas y conflictos de pista");
        return 0;
    }

    public final MacroEditorModel getModel() {
        return this.model;
    }

    private final void notice(String arg2) {
        Toast.makeText(this.root.getContext(), ((CharSequence)arg2), 0).show();
    }

    public final void requestCancel() {
        int v0_2;
        if(!this.closed) {
            if(this.confirmingDiscard) {
            }
            else {
                Integer v0 = StringsKt.toIntOrNull(this.repetitions.getText().toString());
                int v1 = this.model.getDraft().getRepetitions();
                if(v0 == null) {
                    goto label_31;
                }
                else if(v0.intValue() == v1) {
                    Long v0_1 = StringsKt.toLongOrNull(this.interval.getText().toString());
                    long v3 = this.model.getDraft().getIntervalMs();
                    if(v0_1 == null) {
                        goto label_31;
                    }
                    else if(v0_1.longValue() != v3) {
                        goto label_31;
                    }
                    else {
                        v0_2 = 0;
                    }
                }
                else {
                label_31:
                    v0_2 = 1;
                }

                if(!this.model.getHasChanges() && v0_2 == 0 && (Intrinsics.areEqual(this.name.getText().toString(), this.model.getBaselineName()))) {
                    this.onClose.invoke();
                    return;
                }

                this.confirmingDiscard = true;
                TextView v0_3 = new TextView(this.root.getContext());
                v0_3.setText("¿Descartar los cambios de esta sesión?");
                v0_3.setTextColor(-1);
                v0_3.setPadding(this.dp(16), this.dp(12), this.dp(16), this.dp(12));
                AlertDialog v0_4 = this.compactDialog("DESCARTAR CAMBIOS", ((View)v0_3), "DESCARTAR", new MacroEditorController$$ExternalSyntheticLambda0(this));
                v0_4.setOnDismissListener(new MacroEditorController$$ExternalSyntheticLambda10(this, v0_4));
            }
        }
    }

    static final boolean requestCancel$lambda$27(MacroEditorController arg1) {
        arg1.model.discard();
        arg1.onClose.invoke();
        return 1;
    }

    static final void requestCancel$lambda$28(MacroEditorController arg0, AlertDialog arg1, DialogInterface arg2) {
        arg0.children.remove(arg1);
        arg0.confirmingDiscard = false;
    }

    private final void selectTool(int arg6) {
        int[] v0 = new int[]{id.btnToolToque, id.btnToolRecord, id.btnToolDeslizar, id.btnToolDelay, id.btnToolLongPress};
        int v2;
        for(v2 = 0; v2 < 5; ++v2) {
            int v3 = v0[v2];
            View v4 = this.root.findViewById(v3);
            boolean v3_1 = v3 == arg6 ? true : false;
            ((TextView)v4).setSelected(v3_1);
            v3 = ((TextView)v4).isSelected() ? this.gold : -1;
            ((TextView)v4).setTextColor(v3);
        }
    }

    private final void showChild(Dialog arg4) {
        int v1_3;
        Window v0 = arg4.getWindow();
        if(v0 == null) {
            return;
        }

        Object v1 = this.dialogProvider.invoke();
        if(v1 != null) {
            Window v1_1 = ((Dialog)v1).getWindow();
            if(v1_1 != null) {
                WindowManager$LayoutParams v1_2 = v1_1.getAttributes();
                if(v1_2 != null) {
                    v1_3 = v1_2.type;
                }
                else {
                    goto label_12;
                }
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_3 = 0x7F6;
        }

        v0.setType(v1_3);
        v0.setBackgroundDrawable(this.root.getContext().getDrawable(drawable.bg_gamer_panel));
        this.children.add(arg4);
        arg4.setOnDismissListener(new MacroEditorController$$ExternalSyntheticLambda5(this, arg4));
        SessionOverlayWindowsKt.showSessionDialog(arg4);
        Context v4 = arg4.getContext();
        Intrinsics.checkNotNullExpressionValue(v4, "getContext(...)");
        CursorOverlayOrderKt.bringCursorAboveWindow(v4);
        v0.setLayout(Math.min(this.dp(400), ((int)((((float)this.root.getResources().getDisplayMetrics().widthPixels)) * 0.92f))), -2);
    }

    static final void showChild$lambda$46(MacroEditorController arg0, Dialog arg1, DialogInterface arg2) {
        arg0.children.remove(arg1);
    }
}


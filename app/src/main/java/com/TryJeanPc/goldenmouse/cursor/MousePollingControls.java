package com.TryJeanPc.goldenmouse.cursor;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.TryJeanPc.goldenmouse.R$color;
import com.TryJeanPc.goldenmouse.R$drawable;
import com.TryJeanPc.goldenmouse.R$id;
import com.TryJeanPc.goldenmouse.input.MousePollingSelection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\u0018\u001A\u00020\t2\b\b\u0002\u0010\u0019\u001A\u00020\u0017J\u000E\u0010\u001A\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\u0017J\u000E\u0010\u001C\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\u001EJ\b\u0010\u001F\u001A\u00020\tH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001A\u001E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E0\rj\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E`\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001A\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001A\n \u0012*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001A\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/MousePollingControls;", "", "root", "Landroid/view/View;", "selection", "Lkotlin/Function0;", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "apply", "Lkotlin/Function1;", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "presets", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "custom", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "editor", "Landroid/widget/EditText;", "confirm", "editingCustom", "", "render", "resetDraft", "setBusy", "busy", "showError", "message", "", "confirmCustom", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MousePollingControls {
    public static final int $stable = 8;
    private final Function1 apply;
    private final TextView confirm;
    private final TextView custom;
    private boolean editingCustom;
    private final EditText editor;
    private final LinkedHashMap presets;
    private final View root;
    private final Function0 selection;

    static {
    }

    public MousePollingControls(View arg3, Function0 arg4, Function1 arg5) {
        Object v4_1;
        Intrinsics.checkNotNullParameter(arg3, "root");
        Intrinsics.checkNotNullParameter(arg4, "selection");
        Intrinsics.checkNotNullParameter(arg5, "apply");
        super();
        this.root = arg3;
        this.selection = arg4;
        this.apply = arg5;
        LinkedHashMap v4 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(id.btnPollingNativo), Integer.valueOf(0)), TuplesKt.to(Integer.valueOf(id.btnPolling125), Integer.valueOf(0x7D)), TuplesKt.to(Integer.valueOf(id.btnPolling250), Integer.valueOf(0xFA)), TuplesKt.to(Integer.valueOf(id.btnPolling500), Integer.valueOf(500)), TuplesKt.to(Integer.valueOf(id.btnPolling1000), Integer.valueOf(1000))});
        this.presets = v4;
        this.custom = arg3.findViewById(id.btnPollingPersonalizado);
        this.editor = arg3.findViewById(id.editPollingPersonalizado);
        this.confirm = arg3.findViewById(id.btnAplicarPollingPersonalizado);
        Set v3 = v4.keySet();
        Intrinsics.checkNotNullExpressionValue(v3, "<get-keys>(...)");
        Iterator v3_1 = SetsKt.plus(v3, Integer.valueOf(id.btnPollingPersonalizado)).iterator();
        while(v3_1.hasNext()) {
            v4_1 = v3_1.next();
            View v5 = this.root;
            Intrinsics.checkNotNull(v4_1);
            View v4_2 = v5.findViewById(((Integer)v4_1).intValue());
            ((TextView)v4_2).setBackgroundResource(drawable.bg_mouse_polling_option);
            ((TextView)v4_2).setTextColor(((TextView)v4_2).getContext().getColorStateList(color.mouse_polling_text));
        }

        v3_1 = this.presets.entrySet().iterator();
        while(v3_1.hasNext()) {
            v4_1 = v3_1.next();
            this.root.findViewById(((Map$Entry)v4_1).getKey().intValue()).setOnClickListener(new MousePollingControls$$ExternalSyntheticLambda0(this, ((Map$Entry)v4_1).getValue().intValue()));
        }

        this.custom.setOnClickListener(new MousePollingControls$$ExternalSyntheticLambda1(this));
        this.confirm.setOnClickListener(new MousePollingControls$$ExternalSyntheticLambda2(this));
        this.editor.setOnEditorActionListener(new MousePollingControls$$ExternalSyntheticLambda3(this));
        this.render(true);
    }

    static final void _init_$lambda$4(MousePollingControls arg2, View arg3) {
        arg2.editingCustom = true;
        MousePollingControls.render$default(arg2, false, 1, null);
    }

    static final void _init_$lambda$5(MousePollingControls arg0, View arg1) {
        arg0.confirmCustom();
    }

    static final boolean _init_$lambda$6(MousePollingControls arg0, TextView arg1, int arg2, KeyEvent arg3) {
        if(arg2 == 6) {
            arg0.confirmCustom();
            return 1;
        }

        return 0;
    }

    private final void confirmCustom() {
        if(!this.confirm.isEnabled()) {
            return;
        }

        MousePollingSelection v0 = MousePollingSelection.Companion.parseCustom(this.editor.getText().toString());
        EditText v1 = this.editor;
        if(v0 == null) {
            v1.setError("Escribe un número entero entre 100 y 1000");
            return;
        }

        v1.setError(null);
        this.apply.invoke(v0);
    }

    static final void lambda$3$lambda$2(MousePollingControls arg3, int arg4, View arg5) {
        arg3.apply.invoke(new MousePollingSelection(arg4, false, 2, null));
    }

    public final void render(boolean arg6) {
        boolean v2;
        Object v0 = this.selection.invoke();
        if(arg6) {
            this.editingCustom = ((MousePollingSelection)v0).getCustom();
            EditText v6 = this.editor;
            String v1 = ((MousePollingSelection)v0).getCustom() ? String.valueOf(((MousePollingSelection)v0).getHz()) : "400";
            v6.setText(((CharSequence)v1));
            this.editor.setError(null);
            this.editor.clearFocus();
        }

        Iterator v6_1 = this.presets.entrySet().iterator();
        while(true) {
            v2 = false;
            if(!v6_1.hasNext()) {
                break;
            }

            Object v1_1 = v6_1.next();
            int v3 = ((Map$Entry)v1_1).getKey().intValue();
            int v1_2 = ((Map$Entry)v1_1).getValue().intValue();
            View v3_1 = this.root.findViewById(v3);
            if(!((MousePollingSelection)v0).getCustom() && ((MousePollingSelection)v0).getHz() == v1_2) {
                v2 = true;
            }

            v3_1.setSelected(v2);
        }

        this.custom.setSelected(((MousePollingSelection)v0).getCustom());
        View v6_2 = this.root.findViewById(id.groupPollingPersonalizado);
        if(!this.editingCustom) {
            if(((MousePollingSelection)v0).getCustom()) {
            }
            else {
                int v2_1 = 8;
            }
        }

        v6_2.setVisibility(((int)v2));
        View v5 = this.root.findViewById(id.txtPollingAplicado);
        String v6_3 = ((MousePollingSelection)v0).getLabel();
        String v0_1 = ((MousePollingSelection)v0).getCustom() ? " (personalizado)" : "";
        ((TextView)v5).setText("Entrega configurada: " + v6_3 + v0_1);
    }

    public static void render$default(MousePollingControls arg0, boolean arg1, int arg2, Object arg3) {
        arg0.render(false);
    }

    public final void setBusy(boolean arg4) {
        Set v0 = this.presets.keySet();
        Intrinsics.checkNotNullExpressionValue(v0, "<get-keys>(...)");
        Iterator v0_1 = SetsKt.plus(v0, Integer.valueOf(id.btnPollingPersonalizado)).iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            View v2 = this.root;
            Intrinsics.checkNotNull(v1);
            v2.findViewById(((Integer)v1).intValue()).setEnabled((((int)arg4)) ^ 1);
        }

        this.editor.setEnabled((((int)arg4)) ^ 1);
        this.confirm.setEnabled((((int)arg4)) ^ 1);
    }

    public final void showError(String arg4) {
        Intrinsics.checkNotNullParameter(arg4, "message");
        MousePollingControls.render$default(this, false, 1, null);
        this.root.findViewById(id.txtPollingAplicado).append("\nNo se aplicó el cambio: " + arg4);
    }
}


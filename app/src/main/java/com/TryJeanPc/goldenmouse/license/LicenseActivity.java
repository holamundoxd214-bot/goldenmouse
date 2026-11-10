package com.TryJeanPc.goldenmouse.license;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;

public final class LicenseActivity extends Activity {
    class com.TryJeanPc.goldenmouse.license.LicenseActivity$1 implements Runnable {
        com.TryJeanPc.goldenmouse.license.LicenseActivity$1(LicenseActivity arg1) {
            LicenseActivity.this = arg1;
            super();
        }

        public void run() {
            if(!LicenseActivity.this.isFinishing()) {
                if(LicenseActivity.this.isDestroyed()) {
                }
                else if(LicenseManager.isAuthorized()) {
                    LicenseActivity.this.finish();
                    return;
                }
                else {
                    boolean v0 = LicenseManager.isReady();
                    LicenseActivity v1 = LicenseActivity.this;
                    if(!v0) {
                        LicenseActivity.-$$Nest$fgetstatus(v1).setText("Preparando la identidad de esta instalación…");
                    }
                    else if(!LicenseActivity.-$$Nest$fgetreadyShown(v1)) {
                        LicenseActivity.-$$Nest$fputreadyShown(LicenseActivity.this, true);
                        LicenseActivity.-$$Nest$fgetshare(LicenseActivity.this).setEnabled(true);
                        LicenseActivity.-$$Nest$fgetimportButton(LicenseActivity.this).setEnabled(true);
                        LicenseActivity.-$$Nest$fgetstatus(LicenseActivity.this).setText(LicenseManager.error());
                    }

                    LicenseActivity.-$$Nest$fgetui(LicenseActivity.this).postDelayed(((Runnable)this), 0xFA);
                }
            }
        }
    }

    private static final int IMPORT = 17501;
    private final Runnable check;
    private Button importButton;
    private boolean readyShown;
    private Button share;
    private TextView status;
    private final Handler ui;

    static Button -$$Nest$fgetimportButton(LicenseActivity arg0) {
        return arg0.importButton;
    }

    static boolean -$$Nest$fgetreadyShown(LicenseActivity arg0) {
        return arg0.readyShown;
    }

    static Button -$$Nest$fgetshare(LicenseActivity arg0) {
        return arg0.share;
    }

    static TextView -$$Nest$fgetstatus(LicenseActivity arg0) {
        return arg0.status;
    }

    static Handler -$$Nest$fgetui(LicenseActivity arg0) {
        return arg0.ui;
    }

    static void -$$Nest$fputreadyShown(LicenseActivity arg0, boolean arg1) {
        arg0.readyShown = arg1;
    }

    public LicenseActivity() {
        super();
        this.ui = new Handler(Looper.getMainLooper());
        this.check = new com.TryJeanPc.goldenmouse.license.LicenseActivity$1(this);
    }

    void lambda$onActivityResult$4$com-TryJeanPc-goldenmouse-license-LicenseActivity(String arg3) {
        if(!this.isFinishing()) {
            if(this.isDestroyed()) {
            }
            else if(LicenseManager.isAuthorized()) {
                Toast.makeText(((Context)this), ((CharSequence)arg3), 1).show();
                this.finish();
                return;
            }
            else {
                this.status.setText(((CharSequence)arg3));
                this.share.setEnabled(true);
                this.importButton.setEnabled(true);
            }
        }
    }

    void lambda$onActivityResult$5$com-TryJeanPc-goldenmouse-license-LicenseActivity(Intent arg3) {
        String v0_1;
        InputStream v3_1;
        try {
            v3_1 = this.getContentResolver().openInputStream(arg3.getData());
        }
        catch(Exception v3) {
            goto label_21;
        }

        try {
            LicenseManager.importLicense(v3_1);
            v0_1 = "Licencia válida para esta instalación.";
            if(v3_1 == null) {
                goto label_22;
            }

            goto label_6;
        }
        catch(Throwable v0) {
            if(v3_1 == null) {
                goto label_14;
            }

            try {
                v3_1.close();
                goto label_14;
            }
            catch(Throwable v3_2) {
                try {
                    v0.addSuppressed(v3_2);
                label_14:
                    throw v0;
                label_6:
                    v3_1.close();
                }
                catch(Exception v3) {
                label_21:
                    v0_1 = "Licencia rechazada: " + v3.getMessage();
                }
            }
        }

    label_22:
        this.ui.post(new LicenseActivity$$ExternalSyntheticLambda0(this, v0_1));
    }

    void lambda$onCreate$0$com-TryJeanPc-goldenmouse-license-LicenseActivity(View arg3) {
        try {
            this.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", LicenseManager.request()), "Compartir clave pública de Golden"));
            return;
        }
        catch(Exception v3) {
            this.status.setText("No se pudo compartir la clave: " + v3.getMessage());
            return;
        }
    }

    void lambda$onCreate$1$com-TryJeanPc-goldenmouse-license-LicenseActivity(View arg2) {
        try {
            this.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT").addCategory("android.intent.category.OPENABLE").setType("*/*"), 17501);
            return;
        }
        catch(Exception ) {
            this.status.setText("No hay selector de archivos disponible.");
            return;
        }
    }

    void lambda$onCreate$2$com-TryJeanPc-goldenmouse-license-LicenseActivity(View arg1) {
        this.finishAffinity();
    }

    static WindowInsets lambda$onCreate$3(View arg4, WindowInsets arg5) {
        arg4.setPadding(arg5.getSystemWindowInsetLeft(), arg5.getSystemWindowInsetTop(), arg5.getSystemWindowInsetRight(), arg5.getSystemWindowInsetBottom());
        return arg5.consumeSystemWindowInsets();
    }

    public void onActivityResult(int arg2, int arg3, Intent arg4) {
        super.onActivityResult(arg2, arg3, arg4);
        if(arg2 == 17501 && arg3 == -1 && arg4 != null) {
            if(arg4.getData() == null) {
            }
            else {
                this.share.setEnabled(false);
                this.importButton.setEnabled(false);
                this.status.setText("Comprobando licencia…");
                LicenseManager.WORK.execute(new LicenseActivity$$ExternalSyntheticLambda5(this, arg4));
            }
        }
    }

    public void onBackPressed() {
        this.finishAffinity();
    }

    public void onCreate(Bundle arg6) {
        super.onCreate(arg6);
        LicenseManager.initialize(((Context)this));
        ScrollView v6 = new ScrollView(((Context)this));
        LinearLayout v0 = new LinearLayout(((Context)this));
        int v1 = Math.round(this.getResources().getDisplayMetrics().density * 24f);
        v0.setPadding(v1, v1, v1, v1);
        v0.setOrientation(1);
        v6.addView(((View)v0));
        TextView v3 = new TextView(((Context)this));
        v3.setText("Activar Golden Mouse Pro");
        v3.setTextSize(24f);
        v0.addView(((View)v3));
        TextView v2 = new TextView(((Context)this));
        v2.setTextSize(17f);
        v2.setPadding(0, v1, 0, v1);
        v2.setText("Esta instalación necesita tu autorización individual.\n\n1. Comparte la clave pública.\n2. Recibe tu archivo .zlic.\n3. Importa la licencia.\n\nBorrar datos o desinstalar puede eliminar la identidad y requerir una nueva licencia.");
        v0.addView(((View)v2));
        Button v2_1 = new Button(((Context)this));
        this.share = v2_1;
        v2_1.setText("Compartir clave pública");
        this.share.setAllCaps(false);
        v0.addView(this.share);
        this.share.setOnClickListener(new LicenseActivity$$ExternalSyntheticLambda1(this));
        v2_1 = new Button(((Context)this));
        this.importButton = v2_1;
        v2_1.setText("Importar licencia");
        this.importButton.setAllCaps(false);
        v0.addView(this.importButton);
        this.importButton.setOnClickListener(new LicenseActivity$$ExternalSyntheticLambda2(this));
        v2_1 = new Button(((Context)this));
        v2_1.setText("Cerrar");
        v2_1.setAllCaps(false);
        v0.addView(((View)v2_1));
        v2_1.setOnClickListener(new LicenseActivity$$ExternalSyntheticLambda3(this));
        v2 = new TextView(((Context)this));
        this.status = v2;
        v2.setTextSize(16f);
        this.status.setPadding(0, v1, 0, 0);
        v0.addView(this.status);
        this.setContentView(((View)v6));
        this.share.setEnabled(false);
        this.importButton.setEnabled(false);
        v6.setOnApplyWindowInsetsListener(new LicenseActivity$$ExternalSyntheticLambda4());
    }

    public void onDestroy() {
        this.ui.removeCallbacks(this.check);
        super.onDestroy();
    }

    public void onPause() {
        this.ui.removeCallbacks(this.check);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.ui.post(this.check);
    }
}


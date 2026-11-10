package com.TryJeanPc.goldenmouse.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.RemoteInput$Builder;
import androidx.core.app.RemoteInput;
import com.TryJeanPc.goldenmouse.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/notification/GoldenPairingNotification;", "", "<init>", "()V", "CHANNEL", "", "ACTION_CODE", "KEY_CODE", "mostrar", "", "context", "Landroid/content/Context;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenPairingNotification {
    public static final int $stable = 0;
    public static final String ACTION_CODE = "GOLDEN_PAIRING_CODE";
    private static final String CHANNEL = "golden_pairing";
    public static final GoldenPairingNotification INSTANCE = null;
    public static final String KEY_CODE = "pairing_code";

    static {
        GoldenPairingNotification.INSTANCE = new GoldenPairingNotification();
    }

    private GoldenPairingNotification() {
        super();
    }

    public final void mostrar(Context arg8) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        Object v7 = arg8.getSystemService("notification");
        Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager)v7).createNotificationChannel(new NotificationChannel("golden_pairing", "Golden Core", 4));
        Intent v0 = new Intent(arg8, PairingCodeReceiver.class);
        v0.setAction("GOLDEN_PAIRING_CODE");
        PendingIntent v0_1 = PendingIntent.getBroadcast(arg8, 0, v0, 0xA000000);
        RemoteInput v1 = new Builder("pairing_code").setLabel("Código WiFi de 6 dígitos").build();
        Intrinsics.checkNotNullExpressionValue(v1, "build(...)");
        Action v0_2 = new androidx.core.app.NotificationCompat$Action$Builder(0, "Enviar", v0_1).addRemoteInput(v1).build();
        Intrinsics.checkNotNullExpressionValue(v0_2, "build(...)");
        Notification v8 = new androidx.core.app.NotificationCompat$Builder(arg8, "golden_pairing").setSmallIcon(drawable.logo).setContentTitle("GOLDEN CORE").setContentText("Introduce únicamente el código de 6 dígitos").setPriority(1).addAction(v0_2).setAutoCancel(false).build();
        Intrinsics.checkNotNullExpressionValue(v8, "build(...)");
        ((NotificationManager)v7).notify(1001, v8);
    }
}


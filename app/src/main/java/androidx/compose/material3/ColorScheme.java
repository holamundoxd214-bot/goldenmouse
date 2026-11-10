package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bm\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0003\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u0012\u0006\u0010\u0010\u001A\u00020\u0003\u0012\u0006\u0010\u0011\u001A\u00020\u0003\u0012\u0006\u0010\u0012\u001A\u00020\u0003\u0012\u0006\u0010\u0013\u001A\u00020\u0003\u0012\u0006\u0010\u0014\u001A\u00020\u0003\u0012\u0006\u0010\u0015\u001A\u00020\u0003\u0012\u0006\u0010\u0016\u001A\u00020\u0003\u0012\u0006\u0010\u0017\u001A\u00020\u0003\u0012\u0006\u0010\u0018\u001A\u00020\u0003\u0012\u0006\u0010\u0019\u001A\u00020\u0003\u0012\u0006\u0010\u001A\u001A\u00020\u0003\u0012\u0006\u0010\u001B\u001A\u00020\u0003\u0012\u0006\u0010\u001C\u001A\u00020\u0003\u0012\u0006\u0010\u001D\u001A\u00020\u0003\u0012\u0006\u0010\u001E\u001A\u00020\u0003\u0012\u0006\u0010\u001F\u001A\u00020\u0003\u0012\u0006\u0010 \u001A\u00020\u0003\u0012\u0006\u0010!\u001A\u00020\u0003\u0012\u0006\u0010\"\u001A\u00020\u0003\u0012\u0006\u0010#\u001A\u00020\u0003\u0012\u0006\u0010$\u001A\u00020\u0003\u0012\u0006\u0010%\u001A\u00020\u0003\u0012\u0006\u0010&\u001A\u00020\u0003\u0012\u0006\u0010\'\u001A\u00020\u0003\u0012\u0006\u0010(\u001A\u00020\u0003\u0012\u0006\u0010)\u001A\u00020\u0003\u0012\u0006\u0010*\u001A\u00020\u0003\u0012\u0006\u0010+\u001A\u00020\u0003\u0012\u0006\u0010,\u001A\u00020\u0003\u0012\u0006\u0010-\u001A\u00020\u0003\u0012\u0006\u0010.\u001A\u00020\u0003\u0012\u0006\u0010/\u001A\u00020\u0003\u0012\u0006\u00100\u001A\u00020\u0003\u0012\u0006\u00101\u001A\u00020\u0003\u0012\u0006\u00102\u001A\u00020\u0003¢\u0006\u0004\b3\u00104B©\u0002\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u0012\u0006\u0010\u0010\u001A\u00020\u0003\u0012\u0006\u0010\u0011\u001A\u00020\u0003\u0012\u0006\u0010\u0012\u001A\u00020\u0003\u0012\u0006\u0010\u0013\u001A\u00020\u0003\u0012\u0006\u0010\u0014\u001A\u00020\u0003\u0012\u0006\u0010\u0015\u001A\u00020\u0003\u0012\u0006\u0010\u0016\u001A\u00020\u0003\u0012\u0006\u0010\u0017\u001A\u00020\u0003\u0012\u0006\u0010\u0018\u001A\u00020\u0003\u0012\u0006\u0010\u0019\u001A\u00020\u0003\u0012\u0006\u0010\u001A\u001A\u00020\u0003\u0012\u0006\u0010\u001B\u001A\u00020\u0003\u0012\u0006\u0010\u001C\u001A\u00020\u0003\u0012\u0006\u0010\u001D\u001A\u00020\u0003\u0012\u0006\u0010\u001E\u001A\u00020\u0003\u0012\u0006\u0010\u001F\u001A\u00020\u0003\u0012\u0006\u0010 \u001A\u00020\u0003\u0012\u0006\u0010!\u001A\u00020\u0003\u0012\u0006\u0010\"\u001A\u00020\u0003\u0012\u0006\u0010#\u001A\u00020\u0003\u0012\u0006\u0010$\u001A\u00020\u0003\u0012\u0006\u0010%\u001A\u00020\u0003\u0012\u0006\u0010&\u001A\u00020\u0003¢\u0006\u0004\b3\u00105Bñ\u0001\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u0012\u0006\u0010\u0010\u001A\u00020\u0003\u0012\u0006\u0010\u0011\u001A\u00020\u0003\u0012\u0006\u0010\u0012\u001A\u00020\u0003\u0012\u0006\u0010\u0013\u001A\u00020\u0003\u0012\u0006\u0010\u0014\u001A\u00020\u0003\u0012\u0006\u0010\u0015\u001A\u00020\u0003\u0012\u0006\u0010\u0016\u001A\u00020\u0003\u0012\u0006\u0010\u0017\u001A\u00020\u0003\u0012\u0006\u0010\u0018\u001A\u00020\u0003\u0012\u0006\u0010\u0019\u001A\u00020\u0003\u0012\u0006\u0010\u001A\u001A\u00020\u0003\u0012\u0006\u0010\u001B\u001A\u00020\u0003\u0012\u0006\u0010\u001C\u001A\u00020\u0003\u0012\u0006\u0010\u001D\u001A\u00020\u0003\u0012\u0006\u0010\u001E\u001A\u00020\u0003\u0012\u0006\u0010\u001F\u001A\u00020\u0003¢\u0006\u0004\b3\u00106Jí\u0003\u0010i\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00032\b\b\u0002\u0010%\u001A\u00020\u00032\b\b\u0002\u0010&\u001A\u00020\u00032\b\b\u0002\u0010\'\u001A\u00020\u00032\b\b\u0002\u0010(\u001A\u00020\u00032\b\b\u0002\u0010)\u001A\u00020\u00032\b\b\u0002\u0010*\u001A\u00020\u00032\b\b\u0002\u0010+\u001A\u00020\u00032\b\b\u0002\u0010,\u001A\u00020\u00032\b\b\u0002\u0010-\u001A\u00020\u00032\b\b\u0002\u0010.\u001A\u00020\u00032\b\b\u0002\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u00020\u00032\b\b\u0002\u00101\u001A\u00020\u00032\b\b\u0002\u00102\u001A\u00020\u0003¢\u0006\u0004\bj\u0010kJ±\u0002\u0010i\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u0003H\u0007¢\u0006\u0004\bl\u0010mJ÷\u0002\u0010i\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00032\b\b\u0002\u0010%\u001A\u00020\u00032\b\b\u0002\u0010&\u001A\u00020\u0003H\u0007¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001A\u00020qH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b7\u00108R\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b:\u00108R\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b;\u00108R\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b<\u00108R\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b=\u00108R\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b>\u00108R\u0013\u0010\t\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b?\u00108R\u0013\u0010\n\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b@\u00108R\u0013\u0010\u000B\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bA\u00108R\u0013\u0010\f\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bB\u00108R\u0013\u0010\r\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bC\u00108R\u0013\u0010\u000E\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bD\u00108R\u0013\u0010\u000F\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bE\u00108R\u0013\u0010\u0010\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bF\u00108R\u0013\u0010\u0011\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bG\u00108R\u0013\u0010\u0012\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bH\u00108R\u0013\u0010\u0013\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bI\u00108R\u0013\u0010\u0014\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bJ\u00108R\u0013\u0010\u0015\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bK\u00108R\u0013\u0010\u0016\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bL\u00108R\u0013\u0010\u0017\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bM\u00108R\u0013\u0010\u0018\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bN\u00108R\u0013\u0010\u0019\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bO\u00108R\u0013\u0010\u001A\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bP\u00108R\u0013\u0010\u001B\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bQ\u00108R\u0013\u0010\u001C\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bR\u00108R\u0013\u0010\u001D\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bS\u00108R\u0013\u0010\u001E\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bT\u00108R\u0013\u0010\u001F\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bU\u00108R\u0013\u0010 \u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bV\u00108R\u0013\u0010!\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bW\u00108R\u0013\u0010\"\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bX\u00108R\u0013\u0010#\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bY\u00108R\u0013\u0010$\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bZ\u00108R\u0013\u0010%\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b[\u00108R\u0013\u0010&\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b\\\u00108R\u0013\u0010\'\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b]\u00108R\u0013\u0010(\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b^\u00108R\u0013\u0010)\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b_\u00108R\u0013\u0010*\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\b`\u00108R\u0013\u0010+\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\ba\u00108R\u0013\u0010,\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bb\u00108R\u0013\u0010-\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bc\u00108R\u0013\u0010.\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bd\u00108R\u0013\u0010/\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\be\u00108R\u0013\u00100\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bf\u00108R\u0013\u00101\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bg\u00108R\u0013\u00102\u001A\u00020\u0003¢\u0006\n\n\u0002\u00109\u001A\u0004\bh\u00108R\u001C\u0010r\u001A\u0004\u0018\u00010sX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001C\u0010x\u001A\u0004\u0018\u00010sX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\by\u0010u\"\u0004\bz\u0010wR\u001C\u0010{\u001A\u0004\u0018\u00010sX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b|\u0010u\"\u0004\b}\u0010wR\u001D\u0010~\u001A\u0004\u0018\u00010sX\u0080\u000E¢\u0006\u000F\n\u0000\u001A\u0004\b\u007F\u0010u\"\u0005\b\u0080\u0001\u0010wR\u001F\u0010\u0081\u0001\u001A\u0004\u0018\u00010sX\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b\u0082\u0001\u0010u\"\u0005\b\u0083\u0001\u0010wR\"\u0010\u0084\u0001\u001A\u0005\u0018\u00010\u0085\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008A\u0001\u001A\u0005\u0018\u00010\u0085\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u008B\u0001\u0010\u0087\u0001\"\u0006\b\u008C\u0001\u0010\u0089\u0001R\"\u0010\u008D\u0001\u001A\u0005\u0018\u00010\u0085\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u008E\u0001\u0010\u0087\u0001\"\u0006\b\u008F\u0001\u0010\u0089\u0001R\"\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u0091\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\"\u0010\u0096\u0001\u001A\u0005\u0018\u00010\u0091\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0097\u0001\u0010\u0093\u0001\"\u0006\b\u0098\u0001\u0010\u0095\u0001R\"\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u0091\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u009A\u0001\u0010\u0093\u0001\"\u0006\b\u009B\u0001\u0010\u0095\u0001R\"\u0010\u009C\u0001\u001A\u0005\u0018\u00010\u0091\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u009D\u0001\u0010\u0093\u0001\"\u0006\b\u009E\u0001\u0010\u0095\u0001R\"\u0010\u009F\u0001\u001A\u0005\u0018\u00010 \u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u0010¥\u0001\u001A\u0005\u0018\u00010 \u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b¦\u0001\u0010¢\u0001\"\u0006\b§\u0001\u0010¤\u0001R\"\u0010¨\u0001\u001A\u0005\u0018\u00010 \u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b©\u0001\u0010¢\u0001\"\u0006\bª\u0001\u0010¤\u0001R\"\u0010«\u0001\u001A\u0005\u0018\u00010¬\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R*\u0010±\u0001\u001A\u0005\u0018\u00010²\u0001X\u0080\u000E¢\u0006\u001A\n\u0000\u0012\u0006\b³\u0001\u0010´\u0001\u001A\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\"\u0010¹\u0001\u001A\u0005\u0018\u00010º\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R*\u0010¿\u0001\u001A\u0005\u0018\u00010À\u0001X\u0080\u000E¢\u0006\u001A\n\u0000\u0012\u0006\bÁ\u0001\u0010´\u0001\u001A\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\"\u0010Æ\u0001\u001A\u0005\u0018\u00010Ç\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\"\u0010Ì\u0001\u001A\u0005\u0018\u00010Ç\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÍ\u0001\u0010É\u0001\"\u0006\bÎ\u0001\u0010Ë\u0001R\"\u0010Ï\u0001\u001A\u0005\u0018\u00010Ð\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R\"\u0010Õ\u0001\u001A\u0005\u0018\u00010Ð\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÖ\u0001\u0010Ò\u0001\"\u0006\b×\u0001\u0010Ô\u0001R\"\u0010Ø\u0001\u001A\u0005\u0018\u00010Ç\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÙ\u0001\u0010É\u0001\"\u0006\bÚ\u0001\u0010Ë\u0001R\"\u0010Û\u0001\u001A\u0005\u0018\u00010Ð\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÜ\u0001\u0010Ò\u0001\"\u0006\bÝ\u0001\u0010Ô\u0001R\"\u0010Þ\u0001\u001A\u0005\u0018\u00010Ç\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bß\u0001\u0010É\u0001\"\u0006\bà\u0001\u0010Ë\u0001R\"\u0010á\u0001\u001A\u0005\u0018\u00010Ð\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bâ\u0001\u0010Ò\u0001\"\u0006\bã\u0001\u0010Ô\u0001R\"\u0010ä\u0001\u001A\u0005\u0018\u00010Ç\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bå\u0001\u0010É\u0001\"\u0006\bæ\u0001\u0010Ë\u0001R\"\u0010ç\u0001\u001A\u0005\u0018\u00010Ç\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bè\u0001\u0010É\u0001\"\u0006\bé\u0001\u0010Ë\u0001R\"\u0010ê\u0001\u001A\u0005\u0018\u00010Ð\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bë\u0001\u0010Ò\u0001\"\u0006\bì\u0001\u0010Ô\u0001R\"\u0010í\u0001\u001A\u0005\u0018\u00010Ð\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bî\u0001\u0010Ò\u0001\"\u0006\bï\u0001\u0010Ô\u0001R\"\u0010ð\u0001\u001A\u0005\u0018\u00010ñ\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R\"\u0010ö\u0001\u001A\u0005\u0018\u00010÷\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R\"\u0010ü\u0001\u001A\u0005\u0018\u00010ý\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R\"\u0010\u0082\u0002\u001A\u0005\u0018\u00010\u0083\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0006\b\u0086\u0002\u0010\u0087\u0002R\"\u0010\u0088\u0002\u001A\u0005\u0018\u00010\u0089\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u008A\u0002\u0010\u008B\u0002\"\u0006\b\u008C\u0002\u0010\u008D\u0002R\"\u0010\u008E\u0002\u001A\u0005\u0018\u00010\u008F\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R\"\u0010\u0094\u0002\u001A\u0005\u0018\u00010\u0083\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0095\u0002\u0010\u0085\u0002\"\u0006\b\u0096\u0002\u0010\u0087\u0002R\"\u0010\u0097\u0002\u001A\u0005\u0018\u00010\u0098\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0099\u0002\u0010\u009A\u0002\"\u0006\b\u009B\u0002\u0010\u009C\u0002R\"\u0010\u009D\u0002\u001A\u0005\u0018\u00010\u009E\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u009F\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R\"\u0010£\u0002\u001A\u0005\u0018\u00010¤\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R\"\u0010©\u0002\u001A\u0005\u0018\u00010ª\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b«\u0002\u0010¬\u0002\"\u0006\b­\u0002\u0010®\u0002R\"\u0010¯\u0002\u001A\u0005\u0018\u00010°\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b±\u0002\u0010²\u0002\"\u0006\b³\u0002\u0010´\u0002R\"\u0010µ\u0002\u001A\u0005\u0018\u00010°\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b¶\u0002\u0010²\u0002\"\u0006\b·\u0002\u0010´\u0002R*\u0010¸\u0002\u001A\u0005\u0018\u00010¹\u0002X\u0080\u000E¢\u0006\u001A\n\u0000\u0012\u0006\bº\u0002\u0010´\u0001\u001A\u0006\b»\u0002\u0010¼\u0002\"\u0006\b½\u0002\u0010¾\u0002R*\u0010¿\u0002\u001A\u0005\u0018\u00010À\u0002X\u0080\u000E¢\u0006\u001A\n\u0000\u0012\u0006\bÁ\u0002\u0010´\u0001\u001A\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002¨\u0006Æ\u0002"}, d2={"Landroidx/compose/material3/ColorScheme;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPrimary-0d7_KjU", "()J", "J", "getOnPrimary-0d7_KjU", "getPrimaryContainer-0d7_KjU", "getOnPrimaryContainer-0d7_KjU", "getInversePrimary-0d7_KjU", "getSecondary-0d7_KjU", "getOnSecondary-0d7_KjU", "getSecondaryContainer-0d7_KjU", "getOnSecondaryContainer-0d7_KjU", "getTertiary-0d7_KjU", "getOnTertiary-0d7_KjU", "getTertiaryContainer-0d7_KjU", "getOnTertiaryContainer-0d7_KjU", "getBackground-0d7_KjU", "getOnBackground-0d7_KjU", "getSurface-0d7_KjU", "getOnSurface-0d7_KjU", "getSurfaceVariant-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getSurfaceTint-0d7_KjU", "getInverseSurface-0d7_KjU", "getInverseOnSurface-0d7_KjU", "getError-0d7_KjU", "getOnError-0d7_KjU", "getErrorContainer-0d7_KjU", "getOnErrorContainer-0d7_KjU", "getOutline-0d7_KjU", "getOutlineVariant-0d7_KjU", "getScrim-0d7_KjU", "getSurfaceBright-0d7_KjU", "getSurfaceDim-0d7_KjU", "getSurfaceContainer-0d7_KjU", "getSurfaceContainerHigh-0d7_KjU", "getSurfaceContainerHighest-0d7_KjU", "getSurfaceContainerLow-0d7_KjU", "getSurfaceContainerLowest-0d7_KjU", "getPrimaryFixed-0d7_KjU", "getPrimaryFixedDim-0d7_KjU", "getOnPrimaryFixed-0d7_KjU", "getOnPrimaryFixedVariant-0d7_KjU", "getSecondaryFixed-0d7_KjU", "getSecondaryFixedDim-0d7_KjU", "getOnSecondaryFixed-0d7_KjU", "getOnSecondaryFixedVariant-0d7_KjU", "getTertiaryFixed-0d7_KjU", "getTertiaryFixedDim-0d7_KjU", "getOnTertiaryFixed-0d7_KjU", "getOnTertiaryFixedVariant-0d7_KjU", "copy", "copy-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "copy-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "toString", "", "defaultButtonColorsCached", "Landroidx/compose/material3/ButtonColors;", "getDefaultButtonColorsCached$material3", "()Landroidx/compose/material3/ButtonColors;", "setDefaultButtonColorsCached$material3", "(Landroidx/compose/material3/ButtonColors;)V", "defaultElevatedButtonColorsCached", "getDefaultElevatedButtonColorsCached$material3", "setDefaultElevatedButtonColorsCached$material3", "defaultFilledTonalButtonColorsCached", "getDefaultFilledTonalButtonColorsCached$material3", "setDefaultFilledTonalButtonColorsCached$material3", "defaultOutlinedButtonColorsCached", "getDefaultOutlinedButtonColorsCached$material3", "setDefaultOutlinedButtonColorsCached$material3", "defaultTextButtonColorsCached", "getDefaultTextButtonColorsCached$material3", "setDefaultTextButtonColorsCached$material3", "defaultCardColorsCached", "Landroidx/compose/material3/CardColors;", "getDefaultCardColorsCached$material3", "()Landroidx/compose/material3/CardColors;", "setDefaultCardColorsCached$material3", "(Landroidx/compose/material3/CardColors;)V", "defaultElevatedCardColorsCached", "getDefaultElevatedCardColorsCached$material3", "setDefaultElevatedCardColorsCached$material3", "defaultOutlinedCardColorsCached", "getDefaultOutlinedCardColorsCached$material3", "setDefaultOutlinedCardColorsCached$material3", "defaultAssistChipColorsCached", "Landroidx/compose/material3/ChipColors;", "getDefaultAssistChipColorsCached$material3", "()Landroidx/compose/material3/ChipColors;", "setDefaultAssistChipColorsCached$material3", "(Landroidx/compose/material3/ChipColors;)V", "defaultElevatedAssistChipColorsCached", "getDefaultElevatedAssistChipColorsCached$material3", "setDefaultElevatedAssistChipColorsCached$material3", "defaultSuggestionChipColorsCached", "getDefaultSuggestionChipColorsCached$material3", "setDefaultSuggestionChipColorsCached$material3", "defaultElevatedSuggestionChipColorsCached", "getDefaultElevatedSuggestionChipColorsCached$material3", "setDefaultElevatedSuggestionChipColorsCached$material3", "defaultFilterChipColorsCached", "Landroidx/compose/material3/SelectableChipColors;", "getDefaultFilterChipColorsCached$material3", "()Landroidx/compose/material3/SelectableChipColors;", "setDefaultFilterChipColorsCached$material3", "(Landroidx/compose/material3/SelectableChipColors;)V", "defaultElevatedFilterChipColorsCached", "getDefaultElevatedFilterChipColorsCached$material3", "setDefaultElevatedFilterChipColorsCached$material3", "defaultInputChipColorsCached", "getDefaultInputChipColorsCached$material3", "setDefaultInputChipColorsCached$material3", "defaultVerticalDragHandleColorsCached", "Landroidx/compose/material3/DragHandleColors;", "getDefaultVerticalDragHandleColorsCached$material3", "()Landroidx/compose/material3/DragHandleColors;", "setDefaultVerticalDragHandleColorsCached$material3", "(Landroidx/compose/material3/DragHandleColors;)V", "defaultTopAppBarColorsCached", "Landroidx/compose/material3/TopAppBarColors;", "getDefaultTopAppBarColorsCached$material3$annotations", "()V", "getDefaultTopAppBarColorsCached$material3", "()Landroidx/compose/material3/TopAppBarColors;", "setDefaultTopAppBarColorsCached$material3", "(Landroidx/compose/material3/TopAppBarColors;)V", "defaultCheckboxColorsCached", "Landroidx/compose/material3/CheckboxColors;", "getDefaultCheckboxColorsCached$material3", "()Landroidx/compose/material3/CheckboxColors;", "setDefaultCheckboxColorsCached$material3", "(Landroidx/compose/material3/CheckboxColors;)V", "defaultDatePickerColorsCached", "Landroidx/compose/material3/DatePickerColors;", "getDefaultDatePickerColorsCached$material3$annotations", "getDefaultDatePickerColorsCached$material3", "()Landroidx/compose/material3/DatePickerColors;", "setDefaultDatePickerColorsCached$material3", "(Landroidx/compose/material3/DatePickerColors;)V", "defaultIconButtonColorsCached", "Landroidx/compose/material3/IconButtonColors;", "getDefaultIconButtonColorsCached$material3", "()Landroidx/compose/material3/IconButtonColors;", "setDefaultIconButtonColorsCached$material3", "(Landroidx/compose/material3/IconButtonColors;)V", "defaultIconButtonVibrantColorsCached", "getDefaultIconButtonVibrantColorsCached$material3", "setDefaultIconButtonVibrantColorsCached$material3", "defaultIconToggleButtonColorsCached", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultIconToggleButtonColorsCached$material3", "()Landroidx/compose/material3/IconToggleButtonColors;", "setDefaultIconToggleButtonColorsCached$material3", "(Landroidx/compose/material3/IconToggleButtonColors;)V", "defaultIconToggleButtonVibrantColorsCached", "getDefaultIconToggleButtonVibrantColorsCached$material3", "setDefaultIconToggleButtonVibrantColorsCached$material3", "defaultFilledIconButtonColorsCached", "getDefaultFilledIconButtonColorsCached$material3", "setDefaultFilledIconButtonColorsCached$material3", "defaultFilledIconToggleButtonColorsCached", "getDefaultFilledIconToggleButtonColorsCached$material3", "setDefaultFilledIconToggleButtonColorsCached$material3", "defaultFilledTonalIconButtonColorsCached", "getDefaultFilledTonalIconButtonColorsCached$material3", "setDefaultFilledTonalIconButtonColorsCached$material3", "defaultFilledTonalIconToggleButtonColorsCached", "getDefaultFilledTonalIconToggleButtonColorsCached$material3", "setDefaultFilledTonalIconToggleButtonColorsCached$material3", "defaultOutlinedIconButtonColorsCached", "getDefaultOutlinedIconButtonColorsCached$material3", "setDefaultOutlinedIconButtonColorsCached$material3", "defaultOutlinedIconButtonVibrantColorsCached", "getDefaultOutlinedIconButtonVibrantColorsCached$material3", "setDefaultOutlinedIconButtonVibrantColorsCached$material3", "defaultOutlinedIconToggleButtonColorsCached", "getDefaultOutlinedIconToggleButtonColorsCached$material3", "setDefaultOutlinedIconToggleButtonColorsCached$material3", "defaultOutlinedIconToggleButtonVibrantColorsCached", "getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3", "setDefaultOutlinedIconToggleButtonVibrantColorsCached$material3", "defaultListItemColorsCached", "Landroidx/compose/material3/ListItemColors;", "getDefaultListItemColorsCached$material3", "()Landroidx/compose/material3/ListItemColors;", "setDefaultListItemColorsCached$material3", "(Landroidx/compose/material3/ListItemColors;)V", "defaultMenuItemColorsCached", "Landroidx/compose/material3/MenuItemColors;", "getDefaultMenuItemColorsCached$material3", "()Landroidx/compose/material3/MenuItemColors;", "setDefaultMenuItemColorsCached$material3", "(Landroidx/compose/material3/MenuItemColors;)V", "defaultNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationBarItemColors;", "getDefaultNavigationBarItemColorsCached$material3", "()Landroidx/compose/material3/NavigationBarItemColors;", "setDefaultNavigationBarItemColorsCached$material3", "(Landroidx/compose/material3/NavigationBarItemColors;)V", "defaultShortNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationItemColors;", "getDefaultShortNavigationBarItemColorsCached$material3", "()Landroidx/compose/material3/NavigationItemColors;", "setDefaultShortNavigationBarItemColorsCached$material3", "(Landroidx/compose/material3/NavigationItemColors;)V", "defaultNavigationRailItemColorsCached", "Landroidx/compose/material3/NavigationRailItemColors;", "getDefaultNavigationRailItemColorsCached$material3", "()Landroidx/compose/material3/NavigationRailItemColors;", "setDefaultNavigationRailItemColorsCached$material3", "(Landroidx/compose/material3/NavigationRailItemColors;)V", "defaultWideWideNavigationRailColorsCached", "Landroidx/compose/material3/WideNavigationRailColors;", "getDefaultWideWideNavigationRailColorsCached$material3", "()Landroidx/compose/material3/WideNavigationRailColors;", "setDefaultWideWideNavigationRailColorsCached$material3", "(Landroidx/compose/material3/WideNavigationRailColors;)V", "defaultWideNavigationRailItemColorsCached", "getDefaultWideNavigationRailItemColorsCached$material3", "setDefaultWideNavigationRailItemColorsCached$material3", "defaultRadioButtonColorsCached", "Landroidx/compose/material3/RadioButtonColors;", "getDefaultRadioButtonColorsCached$material3", "()Landroidx/compose/material3/RadioButtonColors;", "setDefaultRadioButtonColorsCached$material3", "(Landroidx/compose/material3/RadioButtonColors;)V", "defaultSegmentedButtonColorsCached", "Landroidx/compose/material3/SegmentedButtonColors;", "getDefaultSegmentedButtonColorsCached$material3", "()Landroidx/compose/material3/SegmentedButtonColors;", "setDefaultSegmentedButtonColorsCached$material3", "(Landroidx/compose/material3/SegmentedButtonColors;)V", "defaultSliderColorsCached", "Landroidx/compose/material3/SliderColors;", "getDefaultSliderColorsCached$material3", "()Landroidx/compose/material3/SliderColors;", "setDefaultSliderColorsCached$material3", "(Landroidx/compose/material3/SliderColors;)V", "defaultSwitchColorsCached", "Landroidx/compose/material3/SwitchColors;", "getDefaultSwitchColorsCached$material3", "()Landroidx/compose/material3/SwitchColors;", "setDefaultSwitchColorsCached$material3", "(Landroidx/compose/material3/SwitchColors;)V", "defaultOutlinedTextFieldColorsCached", "Landroidx/compose/material3/TextFieldColors;", "getDefaultOutlinedTextFieldColorsCached$material3", "()Landroidx/compose/material3/TextFieldColors;", "setDefaultOutlinedTextFieldColorsCached$material3", "(Landroidx/compose/material3/TextFieldColors;)V", "defaultTextFieldColorsCached", "getDefaultTextFieldColorsCached$material3", "setDefaultTextFieldColorsCached$material3", "defaultTimePickerColorsCached", "Landroidx/compose/material3/TimePickerColors;", "getDefaultTimePickerColorsCached$material3$annotations", "getDefaultTimePickerColorsCached$material3", "()Landroidx/compose/material3/TimePickerColors;", "setDefaultTimePickerColorsCached$material3", "(Landroidx/compose/material3/TimePickerColors;)V", "defaultRichTooltipColorsCached", "Landroidx/compose/material3/RichTooltipColors;", "getDefaultRichTooltipColorsCached$material3$annotations", "getDefaultRichTooltipColorsCached$material3", "()Landroidx/compose/material3/RichTooltipColors;", "setDefaultRichTooltipColorsCached$material3", "(Landroidx/compose/material3/RichTooltipColors;)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ColorScheme {
    public static final int $stable;
    private final long background;
    private ChipColors defaultAssistChipColorsCached;
    private ButtonColors defaultButtonColorsCached;
    private CardColors defaultCardColorsCached;
    private CheckboxColors defaultCheckboxColorsCached;
    private DatePickerColors defaultDatePickerColorsCached;
    private ChipColors defaultElevatedAssistChipColorsCached;
    private ButtonColors defaultElevatedButtonColorsCached;
    private CardColors defaultElevatedCardColorsCached;
    private SelectableChipColors defaultElevatedFilterChipColorsCached;
    private ChipColors defaultElevatedSuggestionChipColorsCached;
    private IconButtonColors defaultFilledIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledIconToggleButtonColorsCached;
    private ButtonColors defaultFilledTonalButtonColorsCached;
    private IconButtonColors defaultFilledTonalIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached;
    private SelectableChipColors defaultFilterChipColorsCached;
    private IconButtonColors defaultIconButtonColorsCached;
    private IconButtonColors defaultIconButtonVibrantColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonVibrantColorsCached;
    private SelectableChipColors defaultInputChipColorsCached;
    private ListItemColors defaultListItemColorsCached;
    private MenuItemColors defaultMenuItemColorsCached;
    private NavigationBarItemColors defaultNavigationBarItemColorsCached;
    private NavigationRailItemColors defaultNavigationRailItemColorsCached;
    private ButtonColors defaultOutlinedButtonColorsCached;
    private CardColors defaultOutlinedCardColorsCached;
    private IconButtonColors defaultOutlinedIconButtonColorsCached;
    private IconButtonColors defaultOutlinedIconButtonVibrantColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColorsCached;
    private TextFieldColors defaultOutlinedTextFieldColorsCached;
    private RadioButtonColors defaultRadioButtonColorsCached;
    private RichTooltipColors defaultRichTooltipColorsCached;
    private SegmentedButtonColors defaultSegmentedButtonColorsCached;
    private NavigationItemColors defaultShortNavigationBarItemColorsCached;
    private SliderColors defaultSliderColorsCached;
    private ChipColors defaultSuggestionChipColorsCached;
    private SwitchColors defaultSwitchColorsCached;
    private ButtonColors defaultTextButtonColorsCached;
    private TextFieldColors defaultTextFieldColorsCached;
    private TimePickerColors defaultTimePickerColorsCached;
    private TopAppBarColors defaultTopAppBarColorsCached;
    private DragHandleColors defaultVerticalDragHandleColorsCached;
    private NavigationItemColors defaultWideNavigationRailItemColorsCached;
    private WideNavigationRailColors defaultWideWideNavigationRailColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onPrimaryFixed;
    private final long onPrimaryFixedVariant;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSecondaryFixed;
    private final long onSecondaryFixedVariant;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long onTertiaryFixed;
    private final long onTertiaryFixedVariant;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long primaryFixed;
    private final long primaryFixedDim;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long secondaryFixed;
    private final long secondaryFixedDim;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;
    private final long tertiaryFixed;
    private final long tertiaryFixedDim;

    static {
    }

    private ColorScheme(long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156) {
        this(arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), null);
    }

    public ColorScheme(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, long arg43, long arg45, long arg47, long arg49, long arg51, long arg53, long arg55, long arg57, long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, DefaultConstructorMarker arg97) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15, arg17, arg19, arg21, arg23, arg25, arg27, arg29, arg31, arg33, arg35, arg37, arg39, arg41, arg43, arg45, arg47, arg49, arg51, arg53, arg55, arg57, arg59, arg61, arg63, arg65, arg67, arg69, arg71, arg73, arg75, arg77, arg79, arg81, arg83, arg85, arg87, arg89, arg91, arg93, arg95);
    }

    private ColorScheme(long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, long arg160, long arg162, long arg164, long arg166, long arg168, long arg170) {
        this(arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, arg158, arg160, arg162, arg164, arg166, arg168, arg170, Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU(), null);
    }

    private ColorScheme(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, long arg43, long arg45, long arg47, long arg49, long arg51, long arg53, long arg55, long arg57, long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95) {
        super();
        this.primary = arg1;
        this.onPrimary = arg3;
        this.primaryContainer = arg5;
        this.onPrimaryContainer = arg7;
        this.inversePrimary = arg9;
        this.secondary = arg11;
        this.onSecondary = arg13;
        this.secondaryContainer = arg15;
        this.onSecondaryContainer = arg17;
        this.tertiary = arg19;
        this.onTertiary = arg21;
        this.tertiaryContainer = arg23;
        this.onTertiaryContainer = arg25;
        this.background = arg27;
        this.onBackground = arg29;
        this.surface = arg31;
        this.onSurface = arg33;
        this.surfaceVariant = arg35;
        this.onSurfaceVariant = arg37;
        this.surfaceTint = arg39;
        this.inverseSurface = arg41;
        this.inverseOnSurface = arg43;
        this.error = arg45;
        this.onError = arg47;
        this.errorContainer = arg49;
        this.onErrorContainer = arg51;
        this.outline = arg53;
        this.outlineVariant = arg55;
        this.scrim = arg57;
        this.surfaceBright = arg59;
        this.surfaceDim = arg61;
        this.surfaceContainer = arg63;
        this.surfaceContainerHigh = arg65;
        this.surfaceContainerHighest = arg67;
        this.surfaceContainerLow = arg69;
        this.surfaceContainerLowest = arg71;
        this.primaryFixed = arg73;
        this.primaryFixedDim = arg75;
        this.onPrimaryFixed = arg77;
        this.onPrimaryFixedVariant = arg79;
        this.secondaryFixed = arg81;
        this.secondaryFixedDim = arg83;
        this.onSecondaryFixed = arg85;
        this.onSecondaryFixedVariant = arg87;
        this.tertiaryFixed = arg89;
        this.tertiaryFixedDim = arg91;
        this.onTertiaryFixed = arg93;
        this.onTertiaryFixedVariant = arg95;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use constructor with additional \'fixed\' container roles.", replaceWith="<_subannotation>") public ColorScheme(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, long arg43, long arg45, long arg47, long arg49, long arg51, long arg53, long arg55, long arg57, long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, DefaultConstructorMarker arg73) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15, arg17, arg19, arg21, arg23, arg25, arg27, arg29, arg31, arg33, arg35, arg37, arg39, arg41, arg43, arg45, arg47, arg49, arg51, arg53, arg55, arg57, arg59, arg61, arg63, arg65, arg67, arg69, arg71);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use constructor with additional \'surfaceContainer\' roles.", replaceWith="<_subannotation>") public ColorScheme(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, long arg43, long arg45, long arg47, long arg49, long arg51, long arg53, long arg55, long arg57, DefaultConstructorMarker arg59) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15, arg17, arg19, arg21, arg23, arg25, arg27, arg29, arg31, arg33, arg35, arg37, arg39, arg41, arg43, arg45, arg47, arg49, arg51, arg53, arg55, arg57);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with additional fixed roles instead") public final ColorScheme copy-C-Xl9yA(long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, long arg160, long arg162, long arg164, long arg166, long arg168, long arg170, long arg172) {
        return ColorScheme.copy-_VG5OTI$default(this, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, arg158, arg160, arg162, arg164, arg166, arg168, arg170, arg172, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xFFF0, null);
    }

    public static ColorScheme copy-C-Xl9yA$default(ColorScheme arg19, long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, long arg74, long arg76, long arg78, long arg80, long arg82, long arg84, long arg86, long arg88, long arg90, int arg92, int arg93, Object arg94) {
        long v33;
        long v31;
        long v29;
        long v27;
        long v25;
        long v23;
        ColorScheme v20;
        long v47;
        long v45;
        long v43;
        long v41;
        long v39;
        long v37;
        long v35;
        long v61;
        long v59;
        long v57;
        long v55;
        long v53;
        long v51;
        long v49;
        long v75;
        long v73;
        long v71;
        long v69;
        long v67;
        long v65;
        long v63;
        long v87;
        long v85;
        long v83;
        long v81;
        long v79;
        long v77;
        long v91;
        long v89;
        ColorScheme v0 = arg19;
        int v1 = arg92;
        long v2 = (v1 & 1) != 0 ? v0.primary : arg20;
        long v4 = (v1 & 2) != 0 ? v0.onPrimary : arg22;
        long v6 = (v1 & 4) != 0 ? v0.primaryContainer : arg24;
        long v8 = (v1 & 8) != 0 ? v0.onPrimaryContainer : arg26;
        long v10 = (v1 & 16) != 0 ? v0.inversePrimary : arg28;
        long v12 = (v1 & 0x20) != 0 ? v0.secondary : arg30;
        long v14 = (v1 & 0x40) != 0 ? v0.onSecondary : arg32;
        long v16 = v2;
        v2 = (v1 & 0x80) != 0 ? v0.secondaryContainer : arg34;
        arg20 = v2;
        v2 = (v1 & 0x100) != 0 ? v0.onSecondaryContainer : arg36;
        arg22 = v2;
        v2 = (v1 & 0x200) != 0 ? v0.tertiary : arg38;
        arg24 = v2;
        v2 = (v1 & 0x400) != 0 ? v0.onTertiary : arg40;
        arg26 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.tertiaryContainer : arg42;
        arg28 = v2;
        v2 = (v1 & 0x1000) != 0 ? v0.onTertiaryContainer : arg44;
        arg30 = v2;
        v2 = (v1 & 0x2000) != 0 ? v0.background : arg46;
        arg32 = v2;
        v2 = (v1 & 0x4000) != 0 ? v0.onBackground : arg48;
        arg34 = v2;
        long v1_1 = (v1 & 0x8000) != 0 ? v0.surface : arg50;
        arg36 = v1_1;
        v1_1 = (arg92 & 0x10000) != 0 ? v0.onSurface : arg52;
        arg38 = v1_1;
        v1_1 = (arg92 & 0x20000) != 0 ? v0.surfaceVariant : arg54;
        arg40 = v1_1;
        v1_1 = (arg92 & 0x40000) != 0 ? v0.onSurfaceVariant : arg56;
        arg42 = v1_1;
        v1_1 = (arg92 & 0x80000) != 0 ? v0.surfaceTint : arg58;
        arg44 = v1_1;
        v1_1 = (arg92 & 0x100000) != 0 ? v0.inverseSurface : arg60;
        arg46 = v1_1;
        v1_1 = (arg92 & 0x200000) != 0 ? v0.inverseOnSurface : arg62;
        arg48 = v1_1;
        v1_1 = (arg92 & 0x400000) != 0 ? v0.error : arg64;
        arg50 = v1_1;
        v1_1 = (arg92 & 0x800000) != 0 ? v0.onError : arg66;
        arg52 = v1_1;
        v1_1 = (arg92 & 0x1000000) != 0 ? v0.errorContainer : arg68;
        arg54 = v1_1;
        v1_1 = (arg92 & 0x2000000) != 0 ? v0.onErrorContainer : arg70;
        arg56 = v1_1;
        v1_1 = (arg92 & 0x4000000) != 0 ? v0.outline : arg72;
        arg58 = v1_1;
        v1_1 = (arg92 & 0x8000000) != 0 ? v0.outlineVariant : arg74;
        arg60 = v1_1;
        v1_1 = (arg92 & 0x10000000) != 0 ? v0.scrim : arg76;
        arg62 = v1_1;
        v1_1 = (arg92 & 0x20000000) != 0 ? v0.surfaceBright : arg78;
        arg64 = v1_1;
        v1_1 = (arg92 & 0x40000000) != 0 ? v0.surfaceDim : arg80;
        arg66 = v1_1;
        v1_1 = (arg92 & 0x80000000) != 0 ? v0.surfaceContainer : arg82;
        arg68 = v1_1;
        v1_1 = (arg93 & 1) != 0 ? v0.surfaceContainerHigh : arg84;
        arg70 = v1_1;
        v1_1 = (arg93 & 2) != 0 ? v0.surfaceContainerHighest : arg86;
        arg72 = v1_1;
        v1_1 = (arg93 & 4) != 0 ? v0.surfaceContainerLow : arg88;
        if((arg93 & 8) != 0) {
            v89 = v1_1;
            v91 = v0.surfaceContainerLowest;
            v77 = arg62;
            v79 = arg64;
            v81 = arg66;
            v83 = arg68;
            v85 = arg70;
            v87 = arg72;
            v63 = arg48;
            v65 = arg50;
            v67 = arg52;
            v69 = arg54;
            v71 = arg56;
            v73 = arg58;
            v75 = arg60;
            v49 = arg34;
            v51 = arg36;
            v53 = arg38;
            v55 = arg40;
            v57 = arg42;
            v59 = arg44;
            v61 = arg46;
            v35 = arg20;
            v37 = arg22;
            v39 = arg24;
            v41 = arg26;
            v43 = arg28;
            v45 = arg30;
            v47 = arg32;
            v20 = v0;
            v23 = v4;
            v25 = v6;
            v27 = v8;
            v29 = v10;
            v31 = v12;
            v33 = v14;
        }
        else {
            v91 = arg90;
            v89 = v1_1;
            v75 = arg60;
            v77 = arg62;
            v79 = arg64;
            v81 = arg66;
            v83 = arg68;
            v85 = arg70;
            v87 = arg72;
            v61 = arg46;
            v63 = arg48;
            v65 = arg50;
            v67 = arg52;
            v69 = arg54;
            v71 = arg56;
            v73 = arg58;
            v47 = arg32;
            v49 = arg34;
            v51 = arg36;
            v53 = arg38;
            v55 = arg40;
            v57 = arg42;
            v59 = arg44;
            v33 = v14;
            v35 = arg20;
            v37 = arg22;
            v39 = arg24;
            v41 = arg26;
            v43 = arg28;
            v45 = arg30;
            v20 = v0;
            v23 = v4;
            v25 = v6;
            v27 = v8;
            v29 = v10;
            v31 = v12;
        }

        return v20.copy-C-Xl9yA(v16, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v79, v81, v83, v85, v87, v89, v91);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with additional fixed roles instead") public final ColorScheme copy-G1PFc-w(long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158) {
        return ColorScheme.copy-_VG5OTI$default(this, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, arg158, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xE0000000, 0xFFFF, null);
    }

    public static ColorScheme copy-G1PFc-w$default(ColorScheme arg19, long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, long arg74, long arg76, int arg78, Object arg79) {
        long v33;
        long v31;
        long v29;
        long v27;
        long v25;
        long v23;
        ColorScheme v20;
        long v47;
        long v45;
        long v43;
        long v41;
        long v39;
        long v37;
        long v35;
        long v61;
        long v59;
        long v57;
        long v55;
        long v53;
        long v51;
        long v49;
        long v73;
        long v71;
        long v69;
        long v67;
        long v65;
        long v63;
        long v77;
        long v75;
        ColorScheme v0 = arg19;
        int v1 = arg78;
        long v2 = (v1 & 1) != 0 ? v0.primary : arg20;
        long v4 = (v1 & 2) != 0 ? v0.onPrimary : arg22;
        long v6 = (v1 & 4) != 0 ? v0.primaryContainer : arg24;
        long v8 = (v1 & 8) != 0 ? v0.onPrimaryContainer : arg26;
        long v10 = (v1 & 16) != 0 ? v0.inversePrimary : arg28;
        long v12 = (v1 & 0x20) != 0 ? v0.secondary : arg30;
        long v14 = (v1 & 0x40) != 0 ? v0.onSecondary : arg32;
        long v16 = v2;
        v2 = (v1 & 0x80) != 0 ? v0.secondaryContainer : arg34;
        arg20 = v2;
        v2 = (v1 & 0x100) != 0 ? v0.onSecondaryContainer : arg36;
        arg22 = v2;
        v2 = (v1 & 0x200) != 0 ? v0.tertiary : arg38;
        arg24 = v2;
        v2 = (v1 & 0x400) != 0 ? v0.onTertiary : arg40;
        arg26 = v2;
        v2 = (v1 & 0x800) != 0 ? v0.tertiaryContainer : arg42;
        arg28 = v2;
        v2 = (v1 & 0x1000) != 0 ? v0.onTertiaryContainer : arg44;
        arg30 = v2;
        v2 = (v1 & 0x2000) != 0 ? v0.background : arg46;
        arg32 = v2;
        v2 = (v1 & 0x4000) != 0 ? v0.onBackground : arg48;
        arg34 = v2;
        long v1_1 = (v1 & 0x8000) != 0 ? v0.surface : arg50;
        arg36 = v1_1;
        v1_1 = (arg78 & 0x10000) != 0 ? v0.onSurface : arg52;
        arg38 = v1_1;
        v1_1 = (arg78 & 0x20000) != 0 ? v0.surfaceVariant : arg54;
        arg40 = v1_1;
        v1_1 = (arg78 & 0x40000) != 0 ? v0.onSurfaceVariant : arg56;
        arg42 = v1_1;
        v1_1 = (arg78 & 0x80000) != 0 ? v0.surfaceTint : arg58;
        arg44 = v1_1;
        v1_1 = (arg78 & 0x100000) != 0 ? v0.inverseSurface : arg60;
        arg46 = v1_1;
        v1_1 = (arg78 & 0x200000) != 0 ? v0.inverseOnSurface : arg62;
        arg48 = v1_1;
        v1_1 = (arg78 & 0x400000) != 0 ? v0.error : arg64;
        arg50 = v1_1;
        v1_1 = (arg78 & 0x800000) != 0 ? v0.onError : arg66;
        arg52 = v1_1;
        v1_1 = (arg78 & 0x1000000) != 0 ? v0.errorContainer : arg68;
        arg54 = v1_1;
        v1_1 = (arg78 & 0x2000000) != 0 ? v0.onErrorContainer : arg70;
        arg56 = v1_1;
        v1_1 = (arg78 & 0x4000000) != 0 ? v0.outline : arg72;
        arg58 = v1_1;
        v1_1 = (arg78 & 0x8000000) != 0 ? v0.outlineVariant : arg74;
        if((arg78 & 0x10000000) != 0) {
            v75 = v1_1;
            v77 = v0.scrim;
            v63 = arg48;
            v65 = arg50;
            v67 = arg52;
            v69 = arg54;
            v71 = arg56;
            v73 = arg58;
            v49 = arg34;
            v51 = arg36;
            v53 = arg38;
            v55 = arg40;
            v57 = arg42;
            v59 = arg44;
            v61 = arg46;
            v35 = arg20;
            v37 = arg22;
            v39 = arg24;
            v41 = arg26;
            v43 = arg28;
            v45 = arg30;
            v47 = arg32;
            v20 = v0;
            v23 = v4;
            v25 = v6;
            v27 = v8;
            v29 = v10;
            v31 = v12;
            v33 = v14;
        }
        else {
            v77 = arg76;
            v75 = v1_1;
            v61 = arg46;
            v63 = arg48;
            v65 = arg50;
            v67 = arg52;
            v69 = arg54;
            v71 = arg56;
            v73 = arg58;
            v47 = arg32;
            v49 = arg34;
            v51 = arg36;
            v53 = arg38;
            v55 = arg40;
            v57 = arg42;
            v59 = arg44;
            v33 = v14;
            v35 = arg20;
            v37 = arg22;
            v39 = arg24;
            v41 = arg26;
            v43 = arg28;
            v45 = arg30;
            v20 = v0;
            v23 = v4;
            v25 = v6;
            v27 = v8;
            v29 = v10;
            v31 = v12;
        }

        return v20.copy-G1PFc-w(v16, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77);
    }

    public final ColorScheme copy-_VG5OTI(long arg99, long arg101, long arg103, long arg105, long arg107, long arg109, long arg111, long arg113, long arg115, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, long arg131, long arg133, long arg135, long arg137, long arg139, long arg141, long arg143, long arg145, long arg147, long arg149, long arg151, long arg153, long arg155, long arg157, long arg159, long arg161, long arg163, long arg165, long arg167, long arg169, long arg171, long arg173, long arg175, long arg177, long arg179, long arg181, long arg183, long arg185, long arg187, long arg189, long arg191, long arg193) {
        return new ColorScheme(arg99, arg101, arg103, arg105, arg107, arg109, arg111, arg113, arg115, arg117, arg119, arg121, arg123, arg125, arg127, arg129, arg131, arg133, arg135, arg137, arg139, arg141, arg143, arg145, arg147, arg149, arg151, arg153, arg155, arg157, arg159, arg161, arg163, arg165, arg167, arg169, arg171, arg173, arg175, arg177, arg179, arg181, arg183, arg185, arg187, arg189, arg191, arg193, null);
    }

    public static ColorScheme copy-_VG5OTI$default(ColorScheme arg19, long arg20, long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54, long arg56, long arg58, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, long arg74, long arg76, long arg78, long arg80, long arg82, long arg84, long arg86, long arg88, long arg90, long arg92, long arg94, long arg96, long arg98, long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, int arg116, int arg117, Object arg118) {
        long v27;
        long v25;
        long v23;
        ColorScheme v20;
        long v39;
        long v37;
        long v35;
        long v33;
        long v31;
        long v29;
        long v51;
        long v49;
        long v47;
        long v45;
        long v43;
        long v41;
        long v63;
        long v61;
        long v59;
        long v57;
        long v55;
        long v53;
        long v75;
        long v73;
        long v71;
        long v69;
        long v67;
        long v65;
        long v87;
        long v85;
        long v83;
        long v81;
        long v79;
        long v77;
        long v99;
        long v97;
        long v95;
        long v93;
        long v91;
        long v89;
        long v111;
        long v109;
        long v107;
        long v105;
        long v103;
        long v101;
        long v115;
        long v113;
        long v15;
        ColorScheme v0 = arg19;
        int v1 = arg116;
        int v2 = arg117;
        long v3 = (v1 & 1) != 0 ? v0.primary : arg20;
        long v5 = (v1 & 2) != 0 ? v0.onPrimary : arg22;
        long v7 = (v1 & 4) != 0 ? v0.primaryContainer : arg24;
        long v9 = (v1 & 8) != 0 ? v0.onPrimaryContainer : arg26;
        long v11 = (v1 & 16) != 0 ? v0.inversePrimary : arg28;
        long v13 = (v1 & 0x20) != 0 ? v0.secondary : arg30;
        if((v1 & 0x40) != 0) {
            v15 = v3;
            v3 = v0.onSecondary;
        }
        else {
            v15 = v3;
            v3 = arg32;
        }

        arg20 = v3;
        v3 = (v1 & 0x80) != 0 ? v0.secondaryContainer : arg34;
        arg22 = v3;
        v3 = (v1 & 0x100) != 0 ? v0.onSecondaryContainer : arg36;
        arg24 = v3;
        v3 = (v1 & 0x200) != 0 ? v0.tertiary : arg38;
        arg26 = v3;
        v3 = (v1 & 0x400) != 0 ? v0.onTertiary : arg40;
        arg28 = v3;
        v3 = (v1 & 0x800) != 0 ? v0.tertiaryContainer : arg42;
        arg30 = v3;
        v3 = (v1 & 0x1000) != 0 ? v0.onTertiaryContainer : arg44;
        arg32 = v3;
        v3 = (v1 & 0x2000) != 0 ? v0.background : arg46;
        arg34 = v3;
        v3 = (v1 & 0x4000) != 0 ? v0.onBackground : arg48;
        int v17 = 0x8000;
        arg36 = v3;
        v3 = (v1 & v17) != 0 ? v0.surface : arg50;
        arg38 = v3;
        v3 = (v1 & 0x10000) != 0 ? v0.onSurface : arg52;
        arg40 = v3;
        v3 = (v1 & 0x20000) != 0 ? v0.surfaceVariant : arg54;
        arg42 = v3;
        v3 = (v1 & 0x40000) != 0 ? v0.onSurfaceVariant : arg56;
        arg44 = v3;
        v3 = (v1 & 0x80000) != 0 ? v0.surfaceTint : arg58;
        arg46 = v3;
        v3 = (v1 & 0x100000) != 0 ? v0.inverseSurface : arg60;
        arg48 = v3;
        v3 = (v1 & 0x200000) != 0 ? v0.inverseOnSurface : arg62;
        arg50 = v3;
        v3 = (v1 & 0x400000) != 0 ? v0.error : arg64;
        arg52 = v3;
        v3 = (v1 & 0x800000) != 0 ? v0.onError : arg66;
        arg54 = v3;
        v3 = (v1 & 0x1000000) != 0 ? v0.errorContainer : arg68;
        arg56 = v3;
        v3 = (v1 & 0x2000000) != 0 ? v0.onErrorContainer : arg70;
        arg58 = v3;
        v3 = (v1 & 0x4000000) != 0 ? v0.outline : arg72;
        arg60 = v3;
        v3 = (v1 & 0x8000000) != 0 ? v0.outlineVariant : arg74;
        arg62 = v3;
        v3 = (v1 & 0x10000000) != 0 ? v0.scrim : arg76;
        arg64 = v3;
        v3 = (v1 & 0x20000000) != 0 ? v0.surfaceBright : arg78;
        arg66 = v3;
        v3 = (v1 & 0x40000000) != 0 ? v0.surfaceDim : arg80;
        arg68 = v3;
        v3 = (v1 & 0x80000000) != 0 ? v0.surfaceContainer : arg82;
        arg70 = v3;
        v3 = (v2 & 1) != 0 ? v0.surfaceContainerHigh : arg84;
        arg72 = v3;
        v3 = (v2 & 2) != 0 ? v0.surfaceContainerHighest : arg86;
        arg74 = v3;
        v3 = (v2 & 4) != 0 ? v0.surfaceContainerLow : arg88;
        arg76 = v3;
        v3 = (v2 & 8) != 0 ? v0.surfaceContainerLowest : arg90;
        arg78 = v3;
        v3 = (v2 & 16) != 0 ? v0.primaryFixed : arg92;
        arg80 = v3;
        v3 = (v2 & 0x20) != 0 ? v0.primaryFixedDim : arg94;
        arg82 = v3;
        v3 = (v2 & 0x40) != 0 ? v0.onPrimaryFixed : arg96;
        arg84 = v3;
        v3 = (v2 & 0x80) != 0 ? v0.onPrimaryFixedVariant : arg98;
        arg86 = v3;
        v3 = (v2 & 0x100) != 0 ? v0.secondaryFixed : arg100;
        arg88 = v3;
        v3 = (v2 & 0x200) != 0 ? v0.secondaryFixedDim : arg102;
        arg90 = v3;
        v3 = (v2 & 0x400) != 0 ? v0.onSecondaryFixed : arg104;
        arg92 = v3;
        v3 = (v2 & 0x800) != 0 ? v0.onSecondaryFixedVariant : arg106;
        arg94 = v3;
        v3 = (v2 & 0x1000) != 0 ? v0.tertiaryFixed : arg108;
        arg96 = v3;
        v3 = (v2 & 0x2000) != 0 ? v0.tertiaryFixedDim : arg110;
        long v1_1 = (v2 & 0x4000) != 0 ? v0.onTertiaryFixed : arg112;
        if((arg117 & v17) != 0) {
            v113 = v1_1;
            v115 = v0.onTertiaryFixedVariant;
            v101 = arg88;
            v103 = arg90;
            v105 = arg92;
            v107 = arg94;
            v109 = arg96;
            v111 = v3;
            v89 = arg76;
            v91 = arg78;
            v93 = arg80;
            v95 = arg82;
            v97 = arg84;
            v99 = arg86;
            v77 = arg64;
            v79 = arg66;
            v81 = arg68;
            v83 = arg70;
            v85 = arg72;
            v87 = arg74;
            v65 = arg52;
            v67 = arg54;
            v69 = arg56;
            v71 = arg58;
            v73 = arg60;
            v75 = arg62;
            v53 = arg40;
            v55 = arg42;
            v57 = arg44;
            v59 = arg46;
            v61 = arg48;
            v63 = arg50;
            v41 = arg28;
            v43 = arg30;
            v45 = arg32;
            v47 = arg34;
            v49 = arg36;
            v51 = arg38;
            v29 = v11;
            v31 = v13;
            v33 = arg20;
            v35 = arg22;
            v37 = arg24;
            v39 = arg26;
            v20 = v0;
            v23 = v5;
            v25 = v7;
            v27 = v9;
        }
        else {
            v115 = arg114;
            v113 = v1_1;
            v99 = arg86;
            v101 = arg88;
            v103 = arg90;
            v105 = arg92;
            v107 = arg94;
            v109 = arg96;
            v111 = v3;
            v87 = arg74;
            v89 = arg76;
            v91 = arg78;
            v93 = arg80;
            v95 = arg82;
            v97 = arg84;
            v75 = arg62;
            v77 = arg64;
            v79 = arg66;
            v81 = arg68;
            v83 = arg70;
            v85 = arg72;
            v63 = arg50;
            v65 = arg52;
            v67 = arg54;
            v69 = arg56;
            v71 = arg58;
            v73 = arg60;
            v51 = arg38;
            v53 = arg40;
            v55 = arg42;
            v57 = arg44;
            v59 = arg46;
            v61 = arg48;
            v39 = arg26;
            v41 = arg28;
            v43 = arg30;
            v45 = arg32;
            v47 = arg34;
            v49 = arg36;
            v27 = v9;
            v29 = v11;
            v31 = v13;
            v33 = arg20;
            v35 = arg22;
            v37 = arg24;
            v20 = v0;
            v23 = v5;
            v25 = v7;
        }

        return v20.copy-_VG5OTI(v15, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v79, v81, v83, v85, v87, v89, v91, v93, v95, v97, v99, v101, v103, v105, v107, v109, v111, v113, v115);
    }

    public final long getBackground-0d7_KjU() {
        return this.background;
    }

    public final ChipColors getDefaultAssistChipColorsCached$material3() {
        return this.defaultAssistChipColorsCached;
    }

    public final ButtonColors getDefaultButtonColorsCached$material3() {
        return this.defaultButtonColorsCached;
    }

    public final CardColors getDefaultCardColorsCached$material3() {
        return this.defaultCardColorsCached;
    }

    public final CheckboxColors getDefaultCheckboxColorsCached$material3() {
        return this.defaultCheckboxColorsCached;
    }

    public final DatePickerColors getDefaultDatePickerColorsCached$material3() {
        return this.defaultDatePickerColorsCached;
    }

    public static void getDefaultDatePickerColorsCached$material3$annotations() {
    }

    public final ChipColors getDefaultElevatedAssistChipColorsCached$material3() {
        return this.defaultElevatedAssistChipColorsCached;
    }

    public final ButtonColors getDefaultElevatedButtonColorsCached$material3() {
        return this.defaultElevatedButtonColorsCached;
    }

    public final CardColors getDefaultElevatedCardColorsCached$material3() {
        return this.defaultElevatedCardColorsCached;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColorsCached$material3() {
        return this.defaultElevatedFilterChipColorsCached;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColorsCached$material3() {
        return this.defaultElevatedSuggestionChipColorsCached;
    }

    public final IconButtonColors getDefaultFilledIconButtonColorsCached$material3() {
        return this.defaultFilledIconButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColorsCached$material3() {
        return this.defaultFilledIconToggleButtonColorsCached;
    }

    public final ButtonColors getDefaultFilledTonalButtonColorsCached$material3() {
        return this.defaultFilledTonalButtonColorsCached;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColorsCached$material3() {
        return this.defaultFilledTonalIconButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColorsCached$material3() {
        return this.defaultFilledTonalIconToggleButtonColorsCached;
    }

    public final SelectableChipColors getDefaultFilterChipColorsCached$material3() {
        return this.defaultFilterChipColorsCached;
    }

    public final IconButtonColors getDefaultIconButtonColorsCached$material3() {
        return this.defaultIconButtonColorsCached;
    }

    public final IconButtonColors getDefaultIconButtonVibrantColorsCached$material3() {
        return this.defaultIconButtonVibrantColorsCached;
    }

    public final IconToggleButtonColors getDefaultIconToggleButtonColorsCached$material3() {
        return this.defaultIconToggleButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultIconToggleButtonVibrantColorsCached$material3() {
        return this.defaultIconToggleButtonVibrantColorsCached;
    }

    public final SelectableChipColors getDefaultInputChipColorsCached$material3() {
        return this.defaultInputChipColorsCached;
    }

    public final ListItemColors getDefaultListItemColorsCached$material3() {
        return this.defaultListItemColorsCached;
    }

    public final MenuItemColors getDefaultMenuItemColorsCached$material3() {
        return this.defaultMenuItemColorsCached;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColorsCached$material3() {
        return this.defaultNavigationBarItemColorsCached;
    }

    public final NavigationRailItemColors getDefaultNavigationRailItemColorsCached$material3() {
        return this.defaultNavigationRailItemColorsCached;
    }

    public final ButtonColors getDefaultOutlinedButtonColorsCached$material3() {
        return this.defaultOutlinedButtonColorsCached;
    }

    public final CardColors getDefaultOutlinedCardColorsCached$material3() {
        return this.defaultOutlinedCardColorsCached;
    }

    public final IconButtonColors getDefaultOutlinedIconButtonColorsCached$material3() {
        return this.defaultOutlinedIconButtonColorsCached;
    }

    public final IconButtonColors getDefaultOutlinedIconButtonVibrantColorsCached$material3() {
        return this.defaultOutlinedIconButtonVibrantColorsCached;
    }

    public final IconToggleButtonColors getDefaultOutlinedIconToggleButtonColorsCached$material3() {
        return this.defaultOutlinedIconToggleButtonColorsCached;
    }

    public final IconToggleButtonColors getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3() {
        return this.defaultOutlinedIconToggleButtonVibrantColorsCached;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColorsCached$material3() {
        return this.defaultOutlinedTextFieldColorsCached;
    }

    public final RadioButtonColors getDefaultRadioButtonColorsCached$material3() {
        return this.defaultRadioButtonColorsCached;
    }

    public final RichTooltipColors getDefaultRichTooltipColorsCached$material3() {
        return this.defaultRichTooltipColorsCached;
    }

    public static void getDefaultRichTooltipColorsCached$material3$annotations() {
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColorsCached$material3() {
        return this.defaultSegmentedButtonColorsCached;
    }

    public final NavigationItemColors getDefaultShortNavigationBarItemColorsCached$material3() {
        return this.defaultShortNavigationBarItemColorsCached;
    }

    public final SliderColors getDefaultSliderColorsCached$material3() {
        return this.defaultSliderColorsCached;
    }

    public final ChipColors getDefaultSuggestionChipColorsCached$material3() {
        return this.defaultSuggestionChipColorsCached;
    }

    public final SwitchColors getDefaultSwitchColorsCached$material3() {
        return this.defaultSwitchColorsCached;
    }

    public final ButtonColors getDefaultTextButtonColorsCached$material3() {
        return this.defaultTextButtonColorsCached;
    }

    public final TextFieldColors getDefaultTextFieldColorsCached$material3() {
        return this.defaultTextFieldColorsCached;
    }

    public final TimePickerColors getDefaultTimePickerColorsCached$material3() {
        return this.defaultTimePickerColorsCached;
    }

    public static void getDefaultTimePickerColorsCached$material3$annotations() {
    }

    public final TopAppBarColors getDefaultTopAppBarColorsCached$material3() {
        return this.defaultTopAppBarColorsCached;
    }

    public static void getDefaultTopAppBarColorsCached$material3$annotations() {
    }

    public final DragHandleColors getDefaultVerticalDragHandleColorsCached$material3() {
        return this.defaultVerticalDragHandleColorsCached;
    }

    public final NavigationItemColors getDefaultWideNavigationRailItemColorsCached$material3() {
        return this.defaultWideNavigationRailItemColorsCached;
    }

    public final WideNavigationRailColors getDefaultWideWideNavigationRailColorsCached$material3() {
        return this.defaultWideWideNavigationRailColorsCached;
    }

    public final long getError-0d7_KjU() {
        return this.error;
    }

    public final long getErrorContainer-0d7_KjU() {
        return this.errorContainer;
    }

    public final long getInverseOnSurface-0d7_KjU() {
        return this.inverseOnSurface;
    }

    public final long getInversePrimary-0d7_KjU() {
        return this.inversePrimary;
    }

    public final long getInverseSurface-0d7_KjU() {
        return this.inverseSurface;
    }

    public final long getOnBackground-0d7_KjU() {
        return this.onBackground;
    }

    public final long getOnError-0d7_KjU() {
        return this.onError;
    }

    public final long getOnErrorContainer-0d7_KjU() {
        return this.onErrorContainer;
    }

    public final long getOnPrimary-0d7_KjU() {
        return this.onPrimary;
    }

    public final long getOnPrimaryContainer-0d7_KjU() {
        return this.onPrimaryContainer;
    }

    public final long getOnPrimaryFixed-0d7_KjU() {
        return this.onPrimaryFixed;
    }

    public final long getOnPrimaryFixedVariant-0d7_KjU() {
        return this.onPrimaryFixedVariant;
    }

    public final long getOnSecondary-0d7_KjU() {
        return this.onSecondary;
    }

    public final long getOnSecondaryContainer-0d7_KjU() {
        return this.onSecondaryContainer;
    }

    public final long getOnSecondaryFixed-0d7_KjU() {
        return this.onSecondaryFixed;
    }

    public final long getOnSecondaryFixedVariant-0d7_KjU() {
        return this.onSecondaryFixedVariant;
    }

    public final long getOnSurface-0d7_KjU() {
        return this.onSurface;
    }

    public final long getOnSurfaceVariant-0d7_KjU() {
        return this.onSurfaceVariant;
    }

    public final long getOnTertiary-0d7_KjU() {
        return this.onTertiary;
    }

    public final long getOnTertiaryContainer-0d7_KjU() {
        return this.onTertiaryContainer;
    }

    public final long getOnTertiaryFixed-0d7_KjU() {
        return this.onTertiaryFixed;
    }

    public final long getOnTertiaryFixedVariant-0d7_KjU() {
        return this.onTertiaryFixedVariant;
    }

    public final long getOutline-0d7_KjU() {
        return this.outline;
    }

    public final long getOutlineVariant-0d7_KjU() {
        return this.outlineVariant;
    }

    public final long getPrimary-0d7_KjU() {
        return this.primary;
    }

    public final long getPrimaryContainer-0d7_KjU() {
        return this.primaryContainer;
    }

    public final long getPrimaryFixed-0d7_KjU() {
        return this.primaryFixed;
    }

    public final long getPrimaryFixedDim-0d7_KjU() {
        return this.primaryFixedDim;
    }

    public final long getScrim-0d7_KjU() {
        return this.scrim;
    }

    public final long getSecondary-0d7_KjU() {
        return this.secondary;
    }

    public final long getSecondaryContainer-0d7_KjU() {
        return this.secondaryContainer;
    }

    public final long getSecondaryFixed-0d7_KjU() {
        return this.secondaryFixed;
    }

    public final long getSecondaryFixedDim-0d7_KjU() {
        return this.secondaryFixedDim;
    }

    public final long getSurface-0d7_KjU() {
        return this.surface;
    }

    public final long getSurfaceBright-0d7_KjU() {
        return this.surfaceBright;
    }

    public final long getSurfaceContainer-0d7_KjU() {
        return this.surfaceContainer;
    }

    public final long getSurfaceContainerHigh-0d7_KjU() {
        return this.surfaceContainerHigh;
    }

    public final long getSurfaceContainerHighest-0d7_KjU() {
        return this.surfaceContainerHighest;
    }

    public final long getSurfaceContainerLow-0d7_KjU() {
        return this.surfaceContainerLow;
    }

    public final long getSurfaceContainerLowest-0d7_KjU() {
        return this.surfaceContainerLowest;
    }

    public final long getSurfaceDim-0d7_KjU() {
        return this.surfaceDim;
    }

    public final long getSurfaceTint-0d7_KjU() {
        return this.surfaceTint;
    }

    public final long getSurfaceVariant-0d7_KjU() {
        return this.surfaceVariant;
    }

    public final long getTertiary-0d7_KjU() {
        return this.tertiary;
    }

    public final long getTertiaryContainer-0d7_KjU() {
        return this.tertiaryContainer;
    }

    public final long getTertiaryFixed-0d7_KjU() {
        return this.tertiaryFixed;
    }

    public final long getTertiaryFixedDim-0d7_KjU() {
        return this.tertiaryFixedDim;
    }

    public final void setDefaultAssistChipColorsCached$material3(ChipColors arg1) {
        this.defaultAssistChipColorsCached = arg1;
    }

    public final void setDefaultButtonColorsCached$material3(ButtonColors arg1) {
        this.defaultButtonColorsCached = arg1;
    }

    public final void setDefaultCardColorsCached$material3(CardColors arg1) {
        this.defaultCardColorsCached = arg1;
    }

    public final void setDefaultCheckboxColorsCached$material3(CheckboxColors arg1) {
        this.defaultCheckboxColorsCached = arg1;
    }

    public final void setDefaultDatePickerColorsCached$material3(DatePickerColors arg1) {
        this.defaultDatePickerColorsCached = arg1;
    }

    public final void setDefaultElevatedAssistChipColorsCached$material3(ChipColors arg1) {
        this.defaultElevatedAssistChipColorsCached = arg1;
    }

    public final void setDefaultElevatedButtonColorsCached$material3(ButtonColors arg1) {
        this.defaultElevatedButtonColorsCached = arg1;
    }

    public final void setDefaultElevatedCardColorsCached$material3(CardColors arg1) {
        this.defaultElevatedCardColorsCached = arg1;
    }

    public final void setDefaultElevatedFilterChipColorsCached$material3(SelectableChipColors arg1) {
        this.defaultElevatedFilterChipColorsCached = arg1;
    }

    public final void setDefaultElevatedSuggestionChipColorsCached$material3(ChipColors arg1) {
        this.defaultElevatedSuggestionChipColorsCached = arg1;
    }

    public final void setDefaultFilledIconButtonColorsCached$material3(IconButtonColors arg1) {
        this.defaultFilledIconButtonColorsCached = arg1;
    }

    public final void setDefaultFilledIconToggleButtonColorsCached$material3(IconToggleButtonColors arg1) {
        this.defaultFilledIconToggleButtonColorsCached = arg1;
    }

    public final void setDefaultFilledTonalButtonColorsCached$material3(ButtonColors arg1) {
        this.defaultFilledTonalButtonColorsCached = arg1;
    }

    public final void setDefaultFilledTonalIconButtonColorsCached$material3(IconButtonColors arg1) {
        this.defaultFilledTonalIconButtonColorsCached = arg1;
    }

    public final void setDefaultFilledTonalIconToggleButtonColorsCached$material3(IconToggleButtonColors arg1) {
        this.defaultFilledTonalIconToggleButtonColorsCached = arg1;
    }

    public final void setDefaultFilterChipColorsCached$material3(SelectableChipColors arg1) {
        this.defaultFilterChipColorsCached = arg1;
    }

    public final void setDefaultIconButtonColorsCached$material3(IconButtonColors arg1) {
        this.defaultIconButtonColorsCached = arg1;
    }

    public final void setDefaultIconButtonVibrantColorsCached$material3(IconButtonColors arg1) {
        this.defaultIconButtonVibrantColorsCached = arg1;
    }

    public final void setDefaultIconToggleButtonColorsCached$material3(IconToggleButtonColors arg1) {
        this.defaultIconToggleButtonColorsCached = arg1;
    }

    public final void setDefaultIconToggleButtonVibrantColorsCached$material3(IconToggleButtonColors arg1) {
        this.defaultIconToggleButtonVibrantColorsCached = arg1;
    }

    public final void setDefaultInputChipColorsCached$material3(SelectableChipColors arg1) {
        this.defaultInputChipColorsCached = arg1;
    }

    public final void setDefaultListItemColorsCached$material3(ListItemColors arg1) {
        this.defaultListItemColorsCached = arg1;
    }

    public final void setDefaultMenuItemColorsCached$material3(MenuItemColors arg1) {
        this.defaultMenuItemColorsCached = arg1;
    }

    public final void setDefaultNavigationBarItemColorsCached$material3(NavigationBarItemColors arg1) {
        this.defaultNavigationBarItemColorsCached = arg1;
    }

    public final void setDefaultNavigationRailItemColorsCached$material3(NavigationRailItemColors arg1) {
        this.defaultNavigationRailItemColorsCached = arg1;
    }

    public final void setDefaultOutlinedButtonColorsCached$material3(ButtonColors arg1) {
        this.defaultOutlinedButtonColorsCached = arg1;
    }

    public final void setDefaultOutlinedCardColorsCached$material3(CardColors arg1) {
        this.defaultOutlinedCardColorsCached = arg1;
    }

    public final void setDefaultOutlinedIconButtonColorsCached$material3(IconButtonColors arg1) {
        this.defaultOutlinedIconButtonColorsCached = arg1;
    }

    public final void setDefaultOutlinedIconButtonVibrantColorsCached$material3(IconButtonColors arg1) {
        this.defaultOutlinedIconButtonVibrantColorsCached = arg1;
    }

    public final void setDefaultOutlinedIconToggleButtonColorsCached$material3(IconToggleButtonColors arg1) {
        this.defaultOutlinedIconToggleButtonColorsCached = arg1;
    }

    public final void setDefaultOutlinedIconToggleButtonVibrantColorsCached$material3(IconToggleButtonColors arg1) {
        this.defaultOutlinedIconToggleButtonVibrantColorsCached = arg1;
    }

    public final void setDefaultOutlinedTextFieldColorsCached$material3(TextFieldColors arg1) {
        this.defaultOutlinedTextFieldColorsCached = arg1;
    }

    public final void setDefaultRadioButtonColorsCached$material3(RadioButtonColors arg1) {
        this.defaultRadioButtonColorsCached = arg1;
    }

    public final void setDefaultRichTooltipColorsCached$material3(RichTooltipColors arg1) {
        this.defaultRichTooltipColorsCached = arg1;
    }

    public final void setDefaultSegmentedButtonColorsCached$material3(SegmentedButtonColors arg1) {
        this.defaultSegmentedButtonColorsCached = arg1;
    }

    public final void setDefaultShortNavigationBarItemColorsCached$material3(NavigationItemColors arg1) {
        this.defaultShortNavigationBarItemColorsCached = arg1;
    }

    public final void setDefaultSliderColorsCached$material3(SliderColors arg1) {
        this.defaultSliderColorsCached = arg1;
    }

    public final void setDefaultSuggestionChipColorsCached$material3(ChipColors arg1) {
        this.defaultSuggestionChipColorsCached = arg1;
    }

    public final void setDefaultSwitchColorsCached$material3(SwitchColors arg1) {
        this.defaultSwitchColorsCached = arg1;
    }

    public final void setDefaultTextButtonColorsCached$material3(ButtonColors arg1) {
        this.defaultTextButtonColorsCached = arg1;
    }

    public final void setDefaultTextFieldColorsCached$material3(TextFieldColors arg1) {
        this.defaultTextFieldColorsCached = arg1;
    }

    public final void setDefaultTimePickerColorsCached$material3(TimePickerColors arg1) {
        this.defaultTimePickerColorsCached = arg1;
    }

    public final void setDefaultTopAppBarColorsCached$material3(TopAppBarColors arg1) {
        this.defaultTopAppBarColorsCached = arg1;
    }

    public final void setDefaultVerticalDragHandleColorsCached$material3(DragHandleColors arg1) {
        this.defaultVerticalDragHandleColorsCached = arg1;
    }

    public final void setDefaultWideNavigationRailItemColorsCached$material3(NavigationItemColors arg1) {
        this.defaultWideNavigationRailItemColorsCached = arg1;
    }

    public final void setDefaultWideWideNavigationRailColorsCached$material3(WideNavigationRailColors arg1) {
        this.defaultWideWideNavigationRailColorsCached = arg1;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("ColorScheme(primary=");
        v0.append(Color.toString-impl(this.primary)).append("onPrimary=").append(Color.toString-impl(this.onPrimary)).append("primaryContainer=").append(Color.toString-impl(this.primaryContainer)).append("onPrimaryContainer=").append(Color.toString-impl(this.onPrimaryContainer)).append("inversePrimary=").append(Color.toString-impl(this.inversePrimary)).append("secondary=").append(Color.toString-impl(this.secondary)).append("onSecondary=").append(Color.toString-impl(this.onSecondary)).append("secondaryContainer=").append(Color.toString-impl(this.secondaryContainer)).append("onSecondaryContainer=").append(Color.toString-impl(this.onSecondaryContainer)).append("tertiary=").append(Color.toString-impl(this.tertiary)).append("onTertiary=").append(Color.toString-impl(this.onTertiary)).append("tertiaryContainer=");
        v0.append(Color.toString-impl(this.tertiaryContainer)).append("onTertiaryContainer=").append(Color.toString-impl(this.onTertiaryContainer)).append("background=").append(Color.toString-impl(this.background)).append("onBackground=").append(Color.toString-impl(this.onBackground)).append("surface=").append(Color.toString-impl(this.surface)).append("onSurface=").append(Color.toString-impl(this.onSurface)).append("surfaceVariant=").append(Color.toString-impl(this.surfaceVariant)).append("onSurfaceVariant=").append(Color.toString-impl(this.onSurfaceVariant)).append("surfaceTint=").append(Color.toString-impl(this.surfaceTint)).append("inverseSurface=").append(Color.toString-impl(this.inverseSurface)).append("inverseOnSurface=").append(Color.toString-impl(this.inverseOnSurface)).append("error=").append(Color.toString-impl(this.error));
        v0.append("onError=").append(Color.toString-impl(this.onError)).append("errorContainer=").append(Color.toString-impl(this.errorContainer)).append("onErrorContainer=").append(Color.toString-impl(this.onErrorContainer)).append("outline=").append(Color.toString-impl(this.outline)).append("outlineVariant=").append(Color.toString-impl(this.outlineVariant)).append("scrim=").append(Color.toString-impl(this.scrim)).append("surfaceBright=").append(Color.toString-impl(this.surfaceBright)).append("surfaceDim=").append(Color.toString-impl(this.surfaceDim)).append("surfaceContainer=").append(Color.toString-impl(this.surfaceContainer)).append("surfaceContainerHigh=").append(Color.toString-impl(this.surfaceContainerHigh)).append("surfaceContainerHighest=").append(Color.toString-impl(this.surfaceContainerHighest)).append("surfaceContainerLow=");
        v0.append(Color.toString-impl(this.surfaceContainerLow)).append("surfaceContainerLowest=").append(Color.toString-impl(this.surfaceContainerLowest)).append("primaryFixed=").append(Color.toString-impl(this.primaryFixed)).append("primaryFixedDim=").append(Color.toString-impl(this.primaryFixedDim)).append("onPrimaryFixed=").append(Color.toString-impl(this.onPrimaryContainer)).append("onPrimaryFixedVariant=").append(Color.toString-impl(this.onPrimaryFixedVariant)).append("secondaryFixed=").append(Color.toString-impl(this.secondaryFixed)).append("secondaryFixedDim=").append(Color.toString-impl(this.secondaryFixedDim)).append("onSecondaryFixed=").append(Color.toString-impl(this.onSecondaryFixed)).append("onSecondaryFixedVariant=").append(Color.toString-impl(this.onSecondaryFixedVariant)).append("tertiaryFixed=").append(Color.toString-impl(this.tertiaryFixed)).append("tertiaryFixedDim=").append(Color.toString-impl(this.tertiaryFixedDim));
        v0.append("onTertiaryFixed=").append(Color.toString-impl(this.onTertiaryFixed)).append("onTertiaryFixedVariant=").append(Color.toString-impl(this.onTertiaryFixedVariant)).append(')');
        return v0.toString();
    }
}


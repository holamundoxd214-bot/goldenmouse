package androidx.core.net;

import android.net.TrafficStats;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public final class TrafficStatsCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void tagDatagramSocket(DatagramSocket arg0) throws SocketException {
            TrafficStats.tagDatagramSocket(arg0);
        }

        static void untagDatagramSocket(DatagramSocket arg0) throws SocketException {
            TrafficStats.untagDatagramSocket(arg0);
        }
    }

    private TrafficStatsCompat() {
        super();
    }

    @Deprecated public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated public static void incrementOperationCount(int arg0) {
        TrafficStats.incrementOperationCount(arg0);
    }

    @Deprecated public static void incrementOperationCount(int arg0, int arg1) {
        TrafficStats.incrementOperationCount(arg0, arg1);
    }

    @Deprecated public static void setThreadStatsTag(int arg0) {
        TrafficStats.setThreadStatsTag(arg0);
    }

    public static void tagDatagramSocket(DatagramSocket arg0) throws SocketException {
        Api24Impl.tagDatagramSocket(arg0);
    }

    @Deprecated public static void tagSocket(Socket arg0) throws SocketException {
        TrafficStats.tagSocket(arg0);
    }

    public static void untagDatagramSocket(DatagramSocket arg0) throws SocketException {
        Api24Impl.untagDatagramSocket(arg0);
    }

    @Deprecated public static void untagSocket(Socket arg0) throws SocketException {
        TrafficStats.untagSocket(arg0);
    }
}


package com.flyfishxu.kadb.core;

import com.flyfishxu.kadb.KadbOptions;
import com.flyfishxu.kadb.cert.AdbKeyPair;
import com.flyfishxu.kadb.cert.HostKeySet;
import com.flyfishxu.kadb.pair.SslUtils;
import com.flyfishxu.kadb.queue.AdbMessageQueue;
import com.flyfishxu.kadb.stream.AdbStream;
import com.flyfishxu.kadb.tls.TlsErrorMapper;
import com.flyfishxu.kadb.transport.OkioAdaptersKt;
import com.flyfishxu.kadb.transport.TlsNioChannel;
import com.flyfishxu.kadb.transport.TransportChannel;
import com.flyfishxu.kadb.transport.TransportFactory;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLProtocolException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.Source;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0001#BA\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J\u000E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u000BJ\u000E\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u000BJ\u0013\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u0000¢\u0006\u0002\b\u001DJ\b\u0010\u001E\u001A\u00020\rH\u0002J\r\u0010\u001F\u001A\u00020 H\u0001¢\u0006\u0002\b!J\b\u0010\"\u001A\u00020 H\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Lcom/flyfishxu/kadb/core/AdbConnection;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "adbReader", "Lcom/flyfishxu/kadb/core/AdbReader;", "adbWriter", "Lcom/flyfishxu/kadb/core/AdbWriter;", "closeable", "Ljava/io/Closeable;", "supportedFeatures", "", "", "version", "", "outboundMaxPayloadSize", "<init>", "(Lcom/flyfishxu/kadb/core/AdbReader;Lcom/flyfishxu/kadb/core/AdbWriter;Ljava/io/Closeable;Ljava/util/Set;II)V", "random", "Ljava/util/Random;", "messageQueue", "Lcom/flyfishxu/kadb/queue/AdbMessageQueue;", "delayedAckEnabled", "", "open", "Lcom/flyfishxu/kadb/stream/AdbStream;", "destination", "supportsFeature", "feature", "featureSnapshot", "featureSnapshot$kadb", "newId", "ensureEmpty", "", "ensureEmpty$kadb", "close", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbConnection implements AutoCloseable {
    @Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000B2\b\b\u0002\u0010\u0011\u001A\u00020\u000BH\u0086@¢\u0006\u0002\u0010\u0012JP\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000B2\b\b\u0002\u0010\u0011\u001A\u00020\u000BH\u0086@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\tH\u0002J\u0018\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0002¨\u0006\u001F"}, d2={"Lcom/flyfishxu/kadb/core/AdbConnection$Companion;", "", "<init>", "()V", "connect", "Lkotlin/Pair;", "Lcom/flyfishxu/kadb/core/AdbConnection;", "Lcom/flyfishxu/kadb/transport/TransportChannel;", "host", "", "port", "", "hostKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "options", "Lcom/flyfishxu/kadb/KadbOptions;", "connectTimeoutMs", "ioTimeoutMs", "(Ljava/lang/String;ILcom/flyfishxu/kadb/cert/HostKeySet;Lcom/flyfishxu/kadb/KadbOptions;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "(Ljava/lang/String;ILcom/flyfishxu/kadb/cert/AdbKeyPair;Lcom/flyfishxu/kadb/KadbOptions;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseConnectionString", "Lcom/flyfishxu/kadb/core/AdbConnection$Companion$ConnectionString;", "connectionString", "decodeOkayAckBytes", "message", "Lcom/flyfishxu/kadb/core/AdbMessage;", "delayedAckEnabled", "", "ConnectionString", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000E\u001A\u00020\u000FHÖ\u0081\u0004J\n\u0010\u0010\u001A\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2={"Lcom/flyfishxu/kadb/core/AdbConnection$Companion$ConnectionString;", "", "features", "", "", "<init>", "(Ljava/util/Set;)V", "getFeatures", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class ConnectionString {
            private final Set features;

            public ConnectionString(Set arg2) {
                Intrinsics.checkNotNullParameter(arg2, "features");
                super();
                this.features = arg2;
            }

            public final Set component1() {
                return this.features;
            }

            public final ConnectionString copy(Set arg1) {
                Intrinsics.checkNotNullParameter(arg1, "features");
                return new ConnectionString(arg1);
            }

            public static ConnectionString copy$default(ConnectionString arg0, Set arg1, int arg2, Object arg3) {
                if((arg2 & 1) != 0) {
                    arg1 = arg0.features;
                }

                return arg0.copy(arg1);
            }

            public boolean equals(Object arg4) {
                if(this == (((ConnectionString)arg4))) {
                    return 1;
                }

                if(!(arg4 instanceof ConnectionString)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.features, ((ConnectionString)arg4).features)) {
                    return 0;
                }

                return 1;
            }

            public final Set getFeatures() {
                return this.features;
            }

            public int hashCode() {
                return this.features.hashCode();
            }

            public String toString() {
                return "ConnectionString(features=" + this.features + ")";
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final int access$decodeOkayAckBytes(Companion arg0, AdbMessage arg1, boolean arg2) {
            return arg0.decodeOkayAckBytes(arg1, arg2);
        }

        public final Object connect(String arg2, int arg3, AdbKeyPair arg4, KadbOptions arg5, int arg6, int arg7, Continuation arg8) {
            return this.connect(arg2, arg3, HostKeySet.Companion.single(arg4), arg5, arg6, arg7, arg8);
        }

        public final Object connect(String arg30, int arg31, HostKeySet arg32, KadbOptions arg33, int arg34, int arg35, Continuation arg36) {
            AdbReader v5_5;
            DefaultConstructorMarker v1_6;
            Continuation v32_2;
            Source v0_8;
            TransportChannel v5_4;
            Object v2_1;
            Object v5_2;
            long v9_1;
            Object v8;
            int v7_1;
            long v16;
            Object v21;
            Object v0_2;
            int v18;
            Object v1_1;
            Object v33;
            Object v31;
            Object v12;
            Object v14;
            Object v13_1;
            Object v11;
            int v15;
            int v9;
            long v7;
            long v5_1;
            int v14_1;
            int v3_2;
            long v6_1;
            int v11_1;
            AdbReader v1_5;
            AdbWriter v2_3;
            SSLContext v31_1;
            TlsNioChannel v10_1;
            SSLEngine v9_2;
            AdbWriter v8_3;
            AdbConnection v0_7;
            AdbReader v19_1;
            int v23;
            AdbWriter v20;
            int v24;
            int v0_6;
            Set v22;
            long v19;
            Continuation v11_3;
            long v14_3;
            byte[] v16_1;
            int v4_3;
            Object v17;
            long v25;
            ObjectRef v0_5;
            Set v12_2;
            AdbMessage v1_4;
            AdbWriter v32_1;
            ObjectRef v15_1;
            byte[] v14_2;
            Set v2_2;
            AdbWriter v1_3;
            AdbReader v8_2;
            Object v30_1;
            int v6;
            Continuation v4;
            Companion v0 = this;
            int v1 = arg34;
            int v2 = arg35;
            Continuation v3 = arg36;
            if((v3 instanceof AdbConnection$Companion$connect$1)) {
                v4 = v3;
                v6 = 0x80000000;
                if((((AdbConnection$Companion$connect$1)v4).label & v6) != 0) {
                    ((AdbConnection$Companion$connect$1)v4).label -= v6;
                }
                else {
                    goto label_15;
                }
            }
            else {
            label_15:
                AdbConnection$Companion$connect$1 v4_1 = new AdbConnection$Companion$connect$1(v0, v3);
            }

            Continuation v10 = v4;
            Object v3_1 = ((AdbConnection$Companion$connect$1)v10).result;
            Object v4_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int v5 = ((AdbConnection$Companion$connect$1)v10).label;
            int v13 = 2;
            if(v5 == 0) {
                ResultKt.throwOnFailure(v3_1);
                long v8_1 = ((long)v1);
                long v11_2 = ((long)v2);
                TransportFactory v5_3 = TransportFactory.INSTANCE;
                ((AdbConnection$Companion$connect$1)v10).L$0 = arg30;
                HostKeySet v3_3 = arg32;
                ((AdbConnection$Companion$connect$1)v10).L$1 = v3_3;
                KadbOptions v13_2 = arg33;
                ((AdbConnection$Companion$connect$1)v10).L$2 = v13_2;
                ((AdbConnection$Companion$connect$1)v10).I$0 = arg31;
                ((AdbConnection$Companion$connect$1)v10).I$1 = v1;
                ((AdbConnection$Companion$connect$1)v10).I$2 = v2;
                ((AdbConnection$Companion$connect$1)v10).J$0 = v8_1;
                ((AdbConnection$Companion$connect$1)v10).J$1 = v11_2;
                v14_1 = 0;
                ((AdbConnection$Companion$connect$1)v10).I$3 = 0;
                ((AdbConnection$Companion$connect$1)v10).label = 1;
                v5_2 = v5_3.connect(arg30, arg31, v8_1, v10);
                if(v5_2 == v4_2) {
                    return v4_2;
                }
                else {
                    v16 = v8_1;
                    v6_1 = v11_2;
                    KadbOptions v12_1 = v13_2;
                    v11_1 = arg31;
                    v9 = v1;
                    HostKeySet v13_3 = v3_3;
                    v3_2 = 0;
                    String v1_2 = arg30;
                label_121:
                    v30_1 = v1_2;
                    arg31 = v2;
                    v8_2 = new AdbReader(OkioAdaptersKt.asOkioSource(((TransportChannel)v5_2), v6_1), v14_1, 2, null);
                    v1_3 = new AdbWriter(OkioAdaptersKt.asOkioSink(((TransportChannel)v5_2), v6_1));
                    try {
                        v2_2 = CollectionsKt.toSet(AdbProtocol.INSTANCE.connectFeatures(v12_1.getDelayedAckMode()));
                        v14_2 = AdbProtocol.INSTANCE.connectPayload(CollectionsKt.toList(v2_2));
                        v1_3.writeConnect(v14_2);
                        v15_1 = new ObjectRef();
                        v32_1 = v1_3;
                    }
                    catch(Throwable v0_1) {
                        goto label_424;
                    }

                    try {
                        v1_4 = v8_2.readMessage();
                    }
                    catch(SSLProtocolException v0_3) {
                        goto label_419;
                    }
                    catch(Throwable v0_1) {
                        goto label_416;
                    }

                    try {
                        v15_1.element = v1_4;
                        Set v0_4 = v2_2;
                        v2_1 = v30_1;
                        v30_1 = v12_1;
                        v12_2 = v0_4;
                        v1_3 = v32_1;
                        v18 = v3_2;
                        v0_5 = v15_1;
                        v25 = v6_1;
                        v6 = arg31;
                        v7_1 = v9;
                        long v27 = v16;
                        v17 = v4_2;
                        v4_3 = v11_1;
                        v16_1 = v14_2;
                        v14_3 = v27;
                        v11_3 = v10;
                        v9_1 = v25;
                        goto label_162;
                    }
                    catch(Throwable v0_1) {
                        goto label_416;
                    }

                    try {
                    label_419:
                        throw TlsErrorMapper.INSTANCE.map(((Throwable)v0_3));
                    }
                    catch(Throwable v0_1) {
                        goto label_416;
                    }

                    goto label_424;
                label_416:
                    v1_3 = v32_1;
                    goto label_424;
                    try {
                        while(true) {
                        label_162:
                            v3_2 = v0_5.element.getCommand();
                            v19 = v9_1;
                            if(v3_2 != 1213486401) {
                                break;
                            }
                            else {
                                goto label_354;
                            }
                        }
                    }
                    catch(Throwable v0_1) {
                        goto label_411;
                    }

                    if(v3_2 == 1314410051) {
                        try {
                            v22 = CollectionsKt.intersect(this.parseConnectionString(new String(v0_5.element.getPayload(), Charsets.UTF_8)).getFeatures(), ((Iterable)v12_2));
                            v2 = Math.min(v0_5.element.getArg0(), 0x1000001);
                            v1_3.updateProtocolVersion(v2);
                            v0_6 = v0_5.element.getArg1();
                            if(v0_6 > 0) {
                                v0_6 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Math.min(v0_6, 0x100000), 1), 0x100000);
                                v8_2.setInboundMaxPayloadSize(v0_6);
                                v21 = v5_2;
                                v24 = v0_6;
                                v20 = v1_3;
                                v23 = v2;
                                v19_1 = v8_2;
                            }
                            else {
                                goto label_343;
                            }
                        }
                        catch(Throwable v0_1) {
                        label_411:
                            v19_1 = v8_2;
                            goto label_413;
                        }

                        try {
                            v0_7 = new AdbConnection(v19_1, v20, ((Closeable)v21), v22, v23, v24);
                            v8_3 = v20;
                            goto label_338;
                        }
                        catch(Throwable v0_1) {
                            try {
                                v8_3 = v20;
                                goto label_408;
                            label_338:
                                return TuplesKt.to(v0_7, v5_2);
                            label_343:
                                v19_1 = v8_2;
                                v8_3 = v1_3;
                                throw new IOException("Peer maxdata must be > 0: " + v0_6);
                            label_354:
                                v21 = v2_1;
                                arg31 = v6;
                                v9 = v7_1;
                                v2 = v18;
                                v6_1 = v19;
                                v18 = v4_3;
                                v19_1 = v8_2;
                                v4_2 = v17;
                                v8_3 = v1_3;
                                if(v0_5.element.getArg0() == 1) {
                                    v1_1 = CollectionsKt.getOrNull(v13_3.getKeyPairs(), v2);
                                    if(v1_1 != null) {
                                        ++v2;
                                        v8_3.writeAuth(2, ((AdbKeyPair)v1_1).signPayload$kadb(v0_5.element));
                                    }
                                    else {
                                        v8_3.writeAuth(3, AdbConnectionKt.access$adbPublicKey(v13_3.getDefaultKeyPair()));
                                    }

                                    v0_5.element = v19_1.readMessage();
                                    v25 = v6_1;
                                    v7_1 = v9;
                                    v9_1 = v25;
                                    v6 = arg31;
                                    v17 = v4_2;
                                    v1_3 = v8_3;
                                    v4_3 = v18;
                                    v8_2 = v19_1;
                                    v18 = v2;
                                    v2_1 = v21;
                                    goto label_162;
                                }
                                else {
                                    throw new IllegalStateException("Unsupported auth type: " + v0_5.element.toString());
                                }

                                goto label_232;
                            }
                            catch(Throwable v0_1) {
                            }
                        }

                    label_408:
                        v1_3 = v8_3;
                    label_413:
                        v8_2 = v19_1;
                        goto label_424;
                        return v4_2;
                    }
                    else if(v3_2 == 0x534C5453) {
                        v3_2 = 0x1000000;
                        try {
                            v1_3.writeStls(v3_2);
                            SSLContext v3_4 = SslUtils.INSTANCE.getSslContext(v13_3);
                            v9_2 = SslUtils.INSTANCE.newClientEngine(v3_4, ((String)v2_1), v4_3);
                            v10_1 = new TlsNioChannel(((TransportChannel)v5_2), v9_2);
                            v31_1 = v3_4;
                        }
                        catch(Throwable v0_1) {
                            goto label_295;
                        }

                        try {
                            TimeUnit v3_5 = TimeUnit.MILLISECONDS;
                            ((AdbConnection$Companion$connect$1)v11_3).L$0 = v2_1;
                            ((AdbConnection$Companion$connect$1)v11_3).L$1 = v13_3;
                            v21 = v2_1;
                            ((AdbConnection$Companion$connect$1)v11_3).L$2 = SpillingKt.nullOutSpilledVariable(v30_1);
                            ((AdbConnection$Companion$connect$1)v11_3).L$3 = v5_2;
                            ((AdbConnection$Companion$connect$1)v11_3).L$4 = v8_2;
                            ((AdbConnection$Companion$connect$1)v11_3).L$5 = v1_3;
                            ((AdbConnection$Companion$connect$1)v11_3).L$6 = v12_2;
                            ((AdbConnection$Companion$connect$1)v11_3).L$7 = SpillingKt.nullOutSpilledVariable(v16_1);
                            ((AdbConnection$Companion$connect$1)v11_3).L$8 = v0_5;
                            ((AdbConnection$Companion$connect$1)v11_3).L$9 = SpillingKt.nullOutSpilledVariable(v31_1);
                            ((AdbConnection$Companion$connect$1)v11_3).L$10 = SpillingKt.nullOutSpilledVariable(v9_2);
                            ((AdbConnection$Companion$connect$1)v11_3).L$11 = v10_1;
                            ((AdbConnection$Companion$connect$1)v11_3).I$0 = v4_3;
                            ((AdbConnection$Companion$connect$1)v11_3).I$1 = v7_1;
                            ((AdbConnection$Companion$connect$1)v11_3).I$2 = v6;
                            ((AdbConnection$Companion$connect$1)v11_3).J$0 = v14_3;
                            v2 = v6;
                            v9 = v7_1;
                            v6_1 = v19;
                            ((AdbConnection$Companion$connect$1)v11_3).J$1 = v6_1;
                            arg31 = v2;
                            v2 = v18;
                            ((AdbConnection$Companion$connect$1)v11_3).I$3 = v2;
                            v18 = v4_3;
                            ((AdbConnection$Companion$connect$1)v11_3).label = 2;
                            v4_2 = v17;
                            if(v10_1.handshake(v6_1, v3_5, v11_3) != v4_2) {
                                goto label_216;
                            }

                            return v4_2;
                        }
                        catch(Throwable v0_1) {
                            v2_3 = v1_3;
                            v1_1 = v5_2;
                            goto label_287;
                        }

                    label_216:
                        v25 = v14_3;
                        v14_2 = v16_1;
                        v16 = v25;
                        v3 = v11_3;
                        v15 = v18;
                        v18 = v2;
                        TlsNioChannel v11_4 = v10_1;
                        v2_3 = v1_3;
                        v1_5 = v8_2;
                        v8 = v13_3;
                        ObjectRef v13_4 = v0_5;
                        v0_2 = v30_1;
                        v25 = v6_1;
                        v6 = arg31;
                        v7_1 = v9;
                        v9_1 = v25;
                    }
                    else {
                        try {
                            throw new IOException("Connection failed: " + v0_5.element);
                        }
                        catch(Throwable v0_1) {
                        label_295:
                            goto label_424;
                        }
                    }
                }
            }
            else if(v5 == 1) {
                v1 = ((AdbConnection$Companion$connect$1)v10).I$3;
                v5_1 = ((AdbConnection$Companion$connect$1)v10).J$1;
                v7 = ((AdbConnection$Companion$connect$1)v10).J$0;
                v2 = ((AdbConnection$Companion$connect$1)v10).I$2;
                v9 = ((AdbConnection$Companion$connect$1)v10).I$1;
                v11_1 = ((AdbConnection$Companion$connect$1)v10).I$0;
                v12 = ((AdbConnection$Companion$connect$1)v10).L$2;
                v13_1 = ((AdbConnection$Companion$connect$1)v10).L$1;
                v14 = ((AdbConnection$Companion$connect$1)v10).L$0;
                ResultKt.throwOnFailure(v3_1);
                v16 = v7;
                v6_1 = v5_1;
                v5_2 = v3_1;
                v3_2 = v1;
                v1_1 = v14;
                v14_1 = 0;
                goto label_121;
            }
            else if(v5 == v13) {
                v1 = ((AdbConnection$Companion$connect$1)v10).I$3;
                v5_1 = ((AdbConnection$Companion$connect$1)v10).J$1;
                v7 = ((AdbConnection$Companion$connect$1)v10).J$0;
                v2 = ((AdbConnection$Companion$connect$1)v10).I$2;
                v9 = ((AdbConnection$Companion$connect$1)v10).I$1;
                v15 = ((AdbConnection$Companion$connect$1)v10).I$0;
                v11 = ((AdbConnection$Companion$connect$1)v10).L$11;
                v13_1 = ((AdbConnection$Companion$connect$1)v10).L$8;
                v14 = ((AdbConnection$Companion$connect$1)v10).L$7;
                v12 = ((AdbConnection$Companion$connect$1)v10).L$6;
                int v30 = v1;
                v31 = ((AdbConnection$Companion$connect$1)v10).L$5;
                Object v32 = ((AdbConnection$Companion$connect$1)v10).L$4;
                v33 = ((AdbConnection$Companion$connect$1)v10).L$3;
                Object v34 = ((AdbConnection$Companion$connect$1)v10).L$2;
                Object v35 = ((AdbConnection$Companion$connect$1)v10).L$1;
                v1_1 = ((AdbConnection$Companion$connect$1)v10).L$0;
                try {
                    ResultKt.throwOnFailure(v3_1);
                    v18 = v30;
                    v0_2 = v34;
                    v21 = v1_1;
                    v16 = v7;
                    v7_1 = v9;
                    v3 = v10;
                    v1_1 = v32;
                    v8 = v35;
                    v9_1 = v5_1;
                    v5_2 = v33;
                    v6 = v2;
                    v2_1 = v31;
                }
                catch(Throwable v0_1) {
                    v2_1 = v31;
                    v8 = v32;
                    v1_1 = v33;
                    goto label_287;
                }
            }
            else {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }

            try {
            label_232:
                v1_5.close();
                ((AdbWriter)v2_1).close();
            }
            catch(Throwable v0_1) {
                goto label_281;
            }

            try {
                v5_4 = null;
            }
            catch(Throwable v0_1) {
                goto label_281;
            }
            catch(Throwable v0_1) {
                goto label_272;
            }

            try {
                v30_1 = v0_2;
                v0_8 = OkioAdaptersKt.asOkioSource(((TransportChannel)v11), v9_1);
                v31 = v1_5;
                v33 = v2_1;
                v32_2 = v3;
                v1_6 = null;
                v2 = 2;
            }
            catch(Throwable v0_1) {
                goto label_272;
            }

            try {
                v5_5 = new AdbReader(v0_8, 0, v2, v1_6);
            }
            catch(Throwable v0_1) {
                goto label_270;
            }

            try {
                v2_3 = new AdbWriter(OkioAdaptersKt.asOkioSink(((TransportChannel)v11), v9_1));
            }
            catch(Throwable v0_1) {
                goto label_266;
            }

            try {
                ((ObjectRef)v13_1).element = v5_5.readMessage();
                v1_3 = v2_3;
                v0_2 = v13_1;
                v2_1 = v21;
                v13_1 = v8;
                v8_2 = v5_5;
                v5_2 = v11;
                v11_3 = v32_2;
                v25 = v16;
                v17 = v4_2;
                Object v16_2 = v14;
                v4_3 = v15;
                v14_3 = v25;
                goto label_162;
            }
            catch(Throwable v0_1) {
                v1_1 = v2_1;
                goto label_267;
            }

        label_266:
            v1_1 = v33;
        label_267:
            v8_2 = v5_5;
            goto label_276;
        label_270:
            goto label_274;
        label_272:
            v31 = v1_6;
            v33 = v2_1;
        label_274:
            v8 = v31;
            v1_1 = v33;
        label_276:
            v5_2 = v11;
            goto label_424;
        label_281:
            v8 = v1_5;
            v1_1 = v2_1;
            goto label_424;
            try {
            label_287:
                throw TlsErrorMapper.INSTANCE.map(v0_1);
            }
            catch(Throwable v0_1) {
                v5_2 = v1_1;
                v1_1 = v2_1;
            }

            try {
            label_424:
                ((AdbReader)v8).close();
                goto label_425;
            }
            catch(Throwable ) {
                try {
                label_425:
                    v1_3.close();
                    goto label_426;
                }
                catch(Throwable ) {
                    try {
                    label_426:
                        v5_4.close();
                        goto label_427;
                    }
                    catch(Throwable ) {
                    label_427:
                        throw v0_1;
                    }
                }
            }
        }

        public static Object connect$default(Companion arg10, String arg11, int arg12, AdbKeyPair arg13, KadbOptions arg14, int arg15, int arg16, Continuation arg17, int arg18, Object arg19) {
            if((arg18 & 8) != 0) {
                arg14 = new KadbOptions(null, 1, null);
            }

            KadbOptions v6 = arg14;
            int v7 = (arg18 & 16) != 0 ? 10000 : arg15;
            int v8 = (arg18 & 0x20) != 0 ? 0 : arg16;
            return arg10.connect(arg11, arg12, arg13, v6, v7, v8, arg17);
        }

        public static Object connect$default(Companion arg10, String arg11, int arg12, HostKeySet arg13, KadbOptions arg14, int arg15, int arg16, Continuation arg17, int arg18, Object arg19) {
            if((arg18 & 8) != 0) {
                arg14 = new KadbOptions(null, 1, null);
            }

            KadbOptions v6 = arg14;
            int v7 = (arg18 & 16) != 0 ? 10000 : arg15;
            int v8 = (arg18 & 0x20) != 0 ? 0 : arg16;
            return arg10.connect(arg11, arg12, arg13, v6, v7, v8, arg17);
        }

        private final int decodeOkayAckBytes(AdbMessage arg2, boolean arg3) {
            if(arg2.getCommand() == 0x59414B4F) {
                int v1 = arg2.getPayloadLength();
                if(v1 != 0) {
                    if(v1 == 4) {
                        if(arg3) {
                            return new Buffer().write(arg2.getPayload()).readIntLe();
                        }

                        throw new IOException("Unexpected OKAY payload for non-delayed-ack stream: " + arg2.getPayloadLength());
                    }

                    throw new IOException("Invalid OKAY payload size: " + arg2.getPayloadLength());
                }

                if(!arg3) {
                    return 0;
                }

                String v2 = Integer.toString(arg2.getArg1(), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
                throw new IOException("Delayed ACK stream missing OKAY payload for localId: " + v2);
            }

            throw new IllegalArgumentException("Expected OKAY message, got " + arg2.getCommand().toString());
        }

        private final ConnectionString parseConnectionString(String arg14) {
            String v1_2;
            List v14 = StringsKt.split$default(arg14, new String[]{":"}, false, 0, 6, null);
            int v1 = 2;
            if(v14.size() <= v1) {
                return new ConnectionString(SetsKt.emptySet());
            }

            Set v0 = SetsKt.emptySet();
            Iterator v14_1 = StringsKt.split$default(v14.get(v1), new String[]{";"}, false, 0, 6, null).iterator();
            do {
            label_30:
                if(!v14_1.hasNext()) {
                    goto label_90;
                }

                Object v1_1 = v14_1.next();
                Object v7 = v1_1;
                if(((CharSequence)v7).length() == 0) {
                    goto label_30;
                }

                int v2 = StringsKt.indexOf$default(((CharSequence)v7), '=', 0, false, 6, null);
                if(v2 <= 0) {
                    goto label_30;
                }

                if(v2 == StringsKt.getLastIndex(((CharSequence)v7))) {
                    goto label_30;
                }

                String v3 = ((String)v1_1).substring(0, v2);
                Intrinsics.checkNotNullExpressionValue(v3, "substring(...)");
                v1_2 = ((String)v1_1).substring(v2 + 1);
                Intrinsics.checkNotNullExpressionValue(v1_2, "substring(...)");
            }
            while(!Intrinsics.areEqual(v3, "features"));

            List v0_1 = StringsKt.split$default(v1_2, new String[]{","}, false, 0, 6, null);
            ArrayList v1_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_1), 10));
            Iterator v0_2 = ((Iterable)v0_1).iterator();
            goto label_70;
        label_90:
            return new ConnectionString(v0);
        label_70:
            while(v0_2.hasNext()) {
                ((Collection)v1_3).add(StringsKt.trim(v0_2.next()).toString());
            }

            ArrayList v0_3 = new ArrayList();
            Iterator v1_4 = ((Iterable)v1_3).iterator();
            while(v1_4.hasNext()) {
                Object v2_1 = v1_4.next();
                if(v2_1.length() <= 0) {
                    continue;
                }

                ((Collection)v0_3).add(v2_1);
            }

            v0 = CollectionsKt.toSet(((Iterable)v0_3));
            goto label_30;
        }
    }

    public static final Companion Companion;
    private final AdbWriter adbWriter;
    private final Closeable closeable;
    private final boolean delayedAckEnabled;
    private final AdbMessageQueue messageQueue;
    private final int outboundMaxPayloadSize;
    private final Random random;
    private final Set supportedFeatures;
    private final int version;

    static {
        AdbConnection.Companion = new Companion(null);
    }

    public AdbConnection(AdbReader arg2, AdbWriter arg3, Closeable arg4, Set arg5, int arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg2, "adbReader");
        Intrinsics.checkNotNullParameter(arg3, "adbWriter");
        Intrinsics.checkNotNullParameter(arg5, "supportedFeatures");
        super();
        this.adbWriter = arg3;
        this.closeable = arg4;
        this.supportedFeatures = arg5;
        this.version = arg6;
        this.outboundMaxPayloadSize = arg7;
        this.random = new Random();
        this.messageQueue = new AdbMessageQueue(arg2);
        this.delayedAckEnabled = arg5.contains("delayed_ack");
    }

    public void close() {
        try {
            this.messageQueue.close();
            this.adbWriter.close();
            Closeable v1 = this.closeable;
            if(v1 != null) {
                v1.close();
            }

            return;
        }
        catch(Throwable ) {
            return;
        }
    }

    public final void ensureEmpty$kadb() {
        this.messageQueue.ensureEmpty();
    }

    public final Set featureSnapshot$kadb() {
        return CollectionsKt.toSet(this.supportedFeatures);
    }

    private final int newId() {
        int v0;
        do {
            v0 = this.random.nextInt();
        }
        while(v0 == 0);

        return v0;
    }

    public final AdbStream open(String arg11) throws IOException {
        Intrinsics.checkNotNullParameter(arg11, "destination");
        int v5 = this.newId();
        this.messageQueue.startListening(v5);
        try {
            int v0_1 = this.delayedAckEnabled ? 0x2000000 : 0;
            this.adbWriter.writeOpen(v5, arg11, v0_1);
            Object v11 = this.messageQueue.take(v5, 0x59414B4F);
            return new AdbStream(this.messageQueue, this.adbWriter, this.outboundMaxPayloadSize, v5, ((AdbMessage)v11).getArg0(), this.delayedAckEnabled, ((long)Companion.access$decodeOkayAckBytes(AdbConnection.Companion, ((AdbMessage)v11), this.delayedAckEnabled)));
        }
        catch(Throwable v0) {
            this.messageQueue.stopListening(v5);
            throw v0;
        }
    }

    public final boolean supportsFeature(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "feature");
        return this.supportedFeatures.contains(arg2);
    }
}


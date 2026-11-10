package com.flyfish233.crypto.spake2;

import cafe.cryptography.curve25519.CompressedEdwardsY;
import cafe.cryptography.curve25519.Constants;
import cafe.cryptography.curve25519.EdwardsPoint;
import cafe.cryptography.curve25519.InvalidEncodingException;
import cafe.cryptography.ed25519.Ed25519PublicKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.security.auth.Destroyable;

public class Spake2Context implements AutoCloseable, Destroyable {
    class Scalar {
        private final byte[] bytes;

        public Scalar() {
            super();
            this.bytes = new byte[0x20];
        }

        public Scalar(Scalar arg1) {
            this();
            this.copy(arg1);
        }

        public Scalar(byte[] arg3) {
            super();
            byte[] v1 = new byte[0x20];
            this.bytes = v1;
            System.arraycopy(arg3, 0, v1, 0, 0x20);
        }

        Scalar add(Scalar arg2) {
            return new Scalar(this).addInPlace(arg2);
        }

        Scalar addInPlace(Scalar arg6) {
            int v0 = 0;
            int v1 = 0;
            while(v0 < 0x20) {
                int v2 = arg6.bytes[v0] & 0xFF;
                byte[] v3 = this.bytes;
                v2 = v2 + (v3[v0] & 0xFF) + v1;
                v3[v0] = ((byte)v2);
                v1 = v2 >>> 8;
                ++v0;
            }

            return this;
        }

        public Scalar cmov(Scalar arg2, long arg3) {
            Scalar v0 = new Scalar(this);
            v0.conditionalCopyFrom(this, arg2, arg3);
            return v0;
        }

        public void conditionalCopyFrom(Scalar arg5, Scalar arg6, long arg7) {
            int v7 = ((int)(-((arg7 | -arg7) >>> 0x3F)));
            int v8;
            for(v8 = 0; v8 < 0x20; ++v8) {
                this.bytes[v8] = ((byte)(arg5.bytes[v8] & 0xFF & v7 | arg6.bytes[v8] & 0xFF & ~v7));
            }
        }

        public void copy(Scalar arg3) {
            System.arraycopy(arg3.bytes, 0, this.bytes, 0, 0x20);
        }

        public void copyFrom(byte[] arg3) {
            System.arraycopy(arg3, 0, this.bytes, 0, 0x20);
        }

        Scalar dbl() {
            return new Scalar(this).dblInPlace();
        }

        Scalar dblInPlace() {
            int v0 = 0;
            int v1;
            for(v1 = 0; v0 < 0x20; v1 = v4) {
                byte[] v2 = this.bytes;
                int v4 = (v2[v0] & 0xFF) >>> 7;
                v2[v0] = ((byte)(v1 | v2[v0] << 1));
                ++v0;
            }

            return this;
        }

        public byte getByte(int arg1) {
            return this.bytes[arg1];
        }

        public byte[] getBytes() {
            return this.bytes;
        }

        public void reset() {
            Arrays.fill(this.bytes, 0);
        }
    }

    final class SecureRandomHolder {
        private static final SecureRandom INSTANCE;

        static SecureRandom -$$Nest$sfgetINSTANCE() {
            return SecureRandomHolder.INSTANCE;
        }

        static {
            SecureRandom v0;
            try {
                v0 = SecureRandom.getInstanceStrong();
            }
            catch(Throwable ) {
                v0 = new SecureRandom();
            }

            SecureRandomHolder.INSTANCE = v0;
        }

        private SecureRandomHolder() {
            super();
        }
    }

    enum State {
        public static final enum State Init;
        public static final enum State KeyGenerated;
        public static final enum State MsgGenerated;

        private static State[] $values() {
            return new State[]{State.Init, State.MsgGenerated, State.KeyGenerated};
        }

        static {
            State.Init = new State("Init", 0);
            State.MsgGenerated = new State("MsgGenerated", 1);
            State.KeyGenerated = new State("KeyGenerated", 2);
            State.$VALUES = State.$values();
        }

        private State(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static State valueOf(String arg1) {
            return Enum.valueOf(State.class, arg1);
        }

        public static State[] values() {
            return State.$VALUES.clone();
        }
    }

    private static final String HASH_ALGORITHM = "SHA-512";
    private static final EdwardsPoint LIB_M = null;
    private static final EdwardsPoint LIB_N = null;
    public static final int MAX_KEY_SIZE = 0x40;
    public static final int MAX_MSG_SIZE = 0x20;
    public static final int MAX_NAME_SIZE = 0x1000;
    public static final int MAX_PASSWORD_SIZE = 0x10000;
    private static final byte[] M_POINT_ENCODED;
    private static final byte[] N_POINT_ENCODED;
    private boolean isDestroyed;
    private final byte[] myMsg;
    private final byte[] myName;
    private final Spake2Role myRole;
    private final byte[] passwordHash;
    private final byte[] passwordScalar;
    private final byte[] privateKey;
    private final SecureRandom secureRandom;
    private State state;
    private final byte[] theirName;

    static {
        byte[] v0 = HexUtils.hexToBytes("5ada7e4bf6ddd9adb6626d32131c6b5c51a1e347a3478f53cfcf441b88eed12e");
        Spake2Context.M_POINT_ENCODED = v0;
        byte[] v1 = HexUtils.hexToBytes("10e3df0ae37d8e7a99b5fe74b44672103dbddcbd06af680d71329a11693bc778");
        Spake2Context.N_POINT_ENCODED = v1;
        try {
            Spake2Context.LIB_M = new CompressedEdwardsY(v0).decompress();
            Spake2Context.LIB_N = new CompressedEdwardsY(v1).decompress();
            return;
        }
        catch(InvalidEncodingException v0_1) {
            throw new ExceptionInInitializerError(((Throwable)v0_1));
        }
    }

    public Spake2Context(Spake2Role arg2, byte[] arg3, byte[] arg4) {
        this(arg2, arg3, arg4, null);
    }

    public Spake2Context(Spake2Role arg3, byte[] arg4, byte[] arg5, SecureRandom arg6) {
        super();
        this.privateKey = new byte[0x20];
        this.myMsg = new byte[0x20];
        this.passwordScalar = new byte[0x20];
        this.passwordHash = new byte[0x40];
        this.isDestroyed = false;
        if(arg3 != null) {
            if(arg4 != null && arg5 != null) {
                int v1 = 0x1000;
                if(arg4.length <= v1 && arg5.length <= v1) {
                    this.myRole = arg3;
                    this.myName = arg4.clone();
                    this.theirName = arg5.clone();
                    this.state = State.Init;
                    if(arg6 != null) {
                    }
                    else {
                        arg6 = SecureRandomHolder.-$$Nest$sfgetINSTANCE();
                    }

                    this.secureRandom = arg6;
                    return;
                }

                throw new IllegalArgumentException("Participant name too large.");
            }

            throw new IllegalArgumentException("Participant names must not be null.");
        }

        throw new IllegalArgumentException("Role must not be null.");
    }

    public void close() {
        this.destroy();
    }

    public void destroy() {
        if(this.isDestroyed) {
            return;
        }

        this.isDestroyed = true;
        this.wipeSensitiveState();
    }

    public byte[] generateMessage(byte[] arg3) throws IllegalArgumentException, IllegalStateException {
        byte[] v2_1;
        if(arg3 != null && arg3.length != 0) {
            if(arg3.length <= 0x10000) {
                byte[] v0 = new byte[0x40];
                this.secureRandom.nextBytes(v0);
                try {
                    v2_1 = this.generateMessage(arg3, v0);
                }
                catch(Throwable v2) {
                    Arrays.fill(v0, 0);
                    throw v2;
                }

                Arrays.fill(v0, 0);
                return v2_1;
            }
            else {
                throw new IllegalArgumentException("Password too large.");
            }
        }

        throw new IllegalArgumentException("Invalid password input.");
    }

    byte[] generateMessage(byte[] arg6, byte[] arg7) throws IllegalArgumentException, IllegalStateException {
        Object v5_2;
        byte[] v2;
        EdwardsPoint v1;
        if(arg6 != null && arg6.length != 0) {
            if(arg6.length <= 0x10000) {
                if(arg7 != null && arg7.length == 0x40) {
                    if(this.isDestroyed) {
                        throw new IllegalStateException("The context was destroyed.");
                    }
                    else if(this.state == State.Init) {
                        arg7 = cafe.cryptography.curve25519.Scalar.fromBytesModOrderWide(arg7).toByteArray();
                        try {
                            Spake2Context.leftShift3(arg7);
                            System.arraycopy(arg7, 0, this.privateKey, 0, this.privateKey.length);
                            v1 = Constants.ED25519_BASEPOINT.multiply(cafe.cryptography.curve25519.Scalar.fromBits(this.privateKey));
                            arg6 = Spake2Context.getHash(arg6);
                        }
                        catch(Throwable v5) {
                            goto label_76;
                        }

                        try {
                            System.arraycopy(arg6, 0, this.passwordHash, 0, this.passwordHash.length);
                            v2 = cafe.cryptography.curve25519.Scalar.fromBytesModOrderWide(arg6).toByteArray();
                        }
                        catch(Throwable v5) {
                            goto label_73;
                        }

                        try {
                            System.arraycopy(v2, 0, this.passwordScalar, 0, this.passwordScalar.length);
                            goto label_35;
                        }
                        catch(Throwable v5) {
                            try {
                                Arrays.fill(v2, 0);
                                throw v5;
                            label_35:
                                Arrays.fill(v2, 0);
                                goto label_36;
                            }
                            catch(Throwable v5) {
                                try {
                                label_73:
                                    Arrays.fill(arg6, 0);
                                    throw v5;
                                label_36:
                                    Arrays.fill(arg6, 0);
                                    EdwardsPoint v6 = this.myRole == Spake2Role.Alice ? Spake2Context.LIB_M : Spake2Context.LIB_N;
                                    arg6 = v1.add(v6.multiply(cafe.cryptography.curve25519.Scalar.fromBytesModOrder(this.passwordScalar))).compress().toByteArray();
                                }
                                catch(Throwable v5) {
                                    goto label_76;
                                }
                            }
                        }

                        try {
                            Ed25519PublicKey.fromByteArray(arg6);
                            goto label_50;
                        }
                        catch(InvalidEncodingException v5_1) {
                            try {
                                throw new IllegalStateException("Generated point cannot be encoded properly", ((Throwable)v5_1));
                            label_50:
                                System.arraycopy(arg6, 0, this.myMsg, 0, this.myMsg.length);
                                this.state = State.MsgGenerated;
                                v5_2 = this.myMsg.clone();
                                try {
                                    Arrays.fill(arg6, 0);
                                }
                                catch(Throwable v5) {
                                    goto label_76;
                                }
                            }
                            catch(Throwable v5) {
                                try {
                                    Arrays.fill(arg6, 0);
                                    throw v5;
                                }
                                catch(Throwable v5) {
                                label_76:
                                    Arrays.fill(arg7, 0);
                                    throw v5;
                                }
                            }
                        }

                        Arrays.fill(arg7, 0);
                        return ((byte[])v5_2);
                    }
                    else {
                        throw new IllegalStateException("Invalid state: " + this.state);
                    }
                }

                throw new IllegalArgumentException("Invalid private key input.");
            }
            else {
                throw new IllegalArgumentException("Password too large.");
            }
        }

        throw new IllegalArgumentException("Invalid password input.");
    }

    static byte[] getHash(byte[] arg1) throws IllegalArgumentException {
        MessageDigest v0 = Spake2Context.newSha512Digest();
        v0.reset();
        return v0.digest(arg1);
    }

    public byte[] getMyMsg() {
        return this.myMsg.clone();
    }

    public byte[] getMyName() {
        return this.myName.clone();
    }

    public Spake2Role getMyRole() {
        return this.myRole;
    }

    public byte[] getTheirName() {
        return this.theirName.clone();
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    private static void leftShift3(byte[] arg4) {
        int v0 = 0;
        int v1;
        for(v1 = 0; v0 < 0x20; v1 = v3) {
            byte v3 = ((byte)((arg4[v0] & 0xFF) >>> 5));
            arg4[v0] = ((byte)(v1 | arg4[v0] << 3));
            ++v0;
        }
    }

    private static MessageDigest newSha512Digest() {
        try {
            return MessageDigest.getInstance("SHA-512");
        }
        catch(NoSuchAlgorithmException v0) {
            throw new IllegalArgumentException("SHA-512 algorithm is not supported.", ((Throwable)v0));
        }
    }

    public byte[] processMessage(byte[] arg9) throws IllegalArgumentException, IllegalStateException {
        Object v0_3;
        byte[] v1_2;
        EdwardsPoint v0_1;
        int v5;
        String v0 = "Point received from peer was not on the curve.";
        String v1 = "Invalid state: ";
        byte[] v4 = null;
        try {
            if(this.isDestroyed) {
                goto label_116;
            }

            if(this.state != State.MsgGenerated) {
                goto label_108;
            }

            if(arg9 != null) {
                v5 = 0x20;
                if(arg9.length == v5) {
                    try {
                        Ed25519PublicKey.fromByteArray(arg9);
                        goto label_15;
                    }
                    catch(InvalidEncodingException v9_1) {
                        try {
                            throw new IllegalArgumentException(v0, ((Throwable)v9_1));
                        }
                        catch(Throwable v9) {
                            goto label_121;
                        }
                    }
                }
            }

            goto label_104;
        }
        catch(Throwable v9) {
            goto label_121;
        }

        try {
        label_15:
            v0_1 = new CompressedEdwardsY(arg9).decompress();
            goto label_18;
        }
        catch(InvalidEncodingException v9_1) {
            try {
                throw new IllegalArgumentException(((String)v0_1), ((Throwable)v9_1));
            label_18:
                EdwardsPoint v1_1 = this.myRole == Spake2Role.Alice ? Spake2Context.LIB_N : Spake2Context.LIB_M;
                v0_1 = v0_1.subtract(v1_1.multiply(cafe.cryptography.curve25519.Scalar.fromBytesModOrder(this.passwordScalar)));
                v1_1 = v0_1.add(v0_1);
                v1_1 = v1_1.add(v1_1);
                v1_2 = v1_1.add(v1_1).compress().toByteArray();
            }
            catch(Throwable v9) {
                goto label_121;
            }
        }

        try {
            if(v1_2.length == v5 && v1_2[0] == 1) {
                int v6 = 1;
                while(true) {
                    if(v6 >= v5) {
                        break;
                    }
                    else if(v1_2[v6] != 0) {
                    }
                    else {
                        ++v6;
                        continue;
                    }

                    goto label_48;
                }

                throw new IllegalArgumentException("Peer message reduces to identity after unmasking (8*Q == 0).");
            }

            goto label_48;
        }
        catch(Throwable v9) {
            try {
                Arrays.fill(v1_2, 0);
                throw v9;
            label_48:
                Arrays.fill(v1_2, 0);
                v4 = v0_1.multiply(cafe.cryptography.curve25519.Scalar.fromBits(this.privateKey)).compress().toByteArray();
                MessageDigest v0_2 = Spake2Context.newSha512Digest();
                if(this.myRole == Spake2Role.Alice) {
                    Spake2Context.updateWithLengthPrefix(v0_2, this.myName, this.myName.length);
                    Spake2Context.updateWithLengthPrefix(v0_2, this.theirName, this.theirName.length);
                    Spake2Context.updateWithLengthPrefix(v0_2, this.myMsg, this.myMsg.length);
                    Spake2Context.updateWithLengthPrefix(v0_2, arg9, v5);
                }
                else {
                    Spake2Context.updateWithLengthPrefix(v0_2, this.theirName, this.theirName.length);
                    Spake2Context.updateWithLengthPrefix(v0_2, this.myName, this.myName.length);
                    Spake2Context.updateWithLengthPrefix(v0_2, arg9, v5);
                    Spake2Context.updateWithLengthPrefix(v0_2, this.myMsg, this.myMsg.length);
                }

                Spake2Context.updateWithLengthPrefix(v0_2, v4, v4.length);
                Spake2Context.updateWithLengthPrefix(v0_2, this.passwordHash, this.passwordHash.length);
                arg9 = v0_2.digest();
                v0_3 = arg9.clone();
                Arrays.fill(arg9, 0);
                this.state = State.KeyGenerated;
                if(v4 != null) {
                    goto label_90;
                }

                goto label_91;
            }
            catch(Throwable v9) {
                goto label_121;
            }
        }

    label_90:
        Arrays.fill(v4, 0);
    label_91:
        this.wipeSensitiveState();
        return ((byte[])v0_3);
        try {
        label_104:
            throw new IllegalArgumentException("Invalid peer message.");
        label_108:
            throw new IllegalStateException(v1 + this.state);
        label_116:
            throw new IllegalStateException("The context was destroyed.");
        }
        catch(Throwable v9) {
        label_121:
            if(v4 != null) {
                Arrays.fill(v4, 0);
            }

            this.wipeSensitiveState();
            this.isDestroyed = true;
            throw v9;
        }
    }

    private static void updateWithLengthPrefix(MessageDigest arg8, byte[] arg9, int arg10) {
        int v0 = 8;
        byte[] v1 = new byte[v0];
        long v2 = (((long)arg10)) & 0xFFFFFFFFL;
        int v5;
        for(v5 = 0; v5 < v0; ++v5) {
            v1[v5] = ((byte)(((int)(0xFF & v2))));
            v2 >>>= v0;
        }

        arg8.update(v1);
        arg8.update(arg9, 0, arg10);
    }

    private void wipeSensitiveState() {
        Arrays.fill(this.privateKey, 0);
        Arrays.fill(this.passwordScalar, 0);
        Arrays.fill(this.passwordHash, 0);
        Arrays.fill(this.myName, 0);
        Arrays.fill(this.theirName, 0);
        Arrays.fill(this.myMsg, 0);
    }
}


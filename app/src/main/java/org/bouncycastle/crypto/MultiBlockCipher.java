package org.bouncycastle.crypto;

public interface MultiBlockCipher extends BlockCipher {
    int getMultiBlockSize();

    int processBlocks(byte[] arg1, int arg2, int arg3, byte[] arg4, int arg5) throws DataLengthException, IllegalStateException;
}


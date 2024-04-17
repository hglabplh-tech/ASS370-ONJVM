package hgp.utils;


import java.util.Arrays;


public class VMMemory {

    private final MEMDataSource memSource;
    VMMemory(Integer storSize) {
        this.memSource = new MEMDataSource(storSize);
    }

    public MEMDataSource memSource() {
        return memSource;
    }

    public static class MEMDataSource {

        private final Byte[] storage;

        public MEMDataSource(Integer storSize) {
            storage = new Byte[storSize];
            Arrays.fill(this.storage, Byte.valueOf("0"));
        }

        byte [] readAreaFromMem (long startAddress, long endAddress) {
            byte [] tempBuffer = new byte[(int)(endAddress - startAddress) + 1];
            System.arraycopy(this.storage, (int)startAddress, tempBuffer,
                    0, (int)((endAddress - startAddress) + 1));
            return tempBuffer;
        }

        byte [] writeAreaToMem (byte [] buffer, long startAddress) {

            System.arraycopy(buffer, 0, this.storage,
                    (int)startAddress, buffer.length);
            return buffer;
        }

    }
}

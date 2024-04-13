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

    }
}

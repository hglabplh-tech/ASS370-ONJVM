package hgp.utils;


import java.util.*;


public class VMMemory {

    private final MEMDataSource memSource;

    public VMMemory(Integer storSize) {
        this.memSource = new MEMDataSource(storSize);
    }

    public MEMDataSource memSource() {
        return memSource;
    }


    public static class MEMDataSource {

        Map<String, MemAllocAddress> allocationMap = new LinkedHashMap<>();

        List<AddressTuple> allocAddrTuples = new ArrayList<>();
        private final Byte[] storage;


        public MEMDataSource(Integer storSize) {
            storage = new Byte[storSize];
            Arrays.fill(this.storage, Byte.valueOf("0"));
        }

        public byte[] readAreaFromMem(long startAddress, long endAddress) {
            byte[] tempBuffer = new byte[(int) (endAddress - startAddress) + 1];
            System.arraycopy(this.storage, (int) startAddress, tempBuffer, 0, (int) ((endAddress - startAddress) + 1));
            return tempBuffer;
        }

        public byte[] writeAreaToMem(byte[] buffer, long startAddress) {

            System.arraycopy(buffer, 0, this.storage, (int) startAddress, buffer.length);
            return buffer;
        }

        public byte[] loadRegister(byte[] register, int storageAddress) {
            System.arraycopy(this.storage, storageAddress, register, 0, register.length);
            return register;
        }

        public byte[] storeRegister(byte[] register, int storageAddress) {
            System.arraycopy(register, 0, this.storage, storageAddress, register.length);
            return register;
        }

        public Optional<MemAllocAddress> allocateMemory(String label,
                                                Integer startAddress,
                                                Integer allocLength) {
            boolean result = false;
            MemAllocAddress theAddress =
                    new MemAllocAddress(startAddress, allocLength);
            Optional<AddressTuple> resultOverlap = overlappedMem(theAddress);
            result = resultOverlap.isPresent();

            // we also have to look if allocated storage overlaps
            if (theAddress.endAddress() <= (this.storage.length - 1) && result) {
                this.allocationMap.put(label, theAddress);
                this.allocAddrTuples.add(new AddressTuple(theAddress.startAddress(),
                        theAddress.endAddress()));
                result = true;
            }
            if (result) {
                return Optional.of(theAddress);
            } else {
                return Optional.empty();
            }
        }

        public Boolean freeMemory (String label, MemAllocAddress theAddress) {
            MemAllocAddress removedAddr = this.allocationMap.remove(label);
            return removedAddr.equals(theAddress);
        }


        private Optional<AddressTuple> overlappedMem(MemAllocAddress allocAddr) {
            Optional<AddressTuple> optFound =  this.allocAddrTuples.stream()
                    .filter(e -> (
                    ((allocAddr.startAddress() >= e.startAddress())
            && (allocAddr.startAddress <= e.endAddress))
            &&
            ((allocAddr.endAddress() >= e.endAddress())
                    && (allocAddr.endAddress() >= e.startAddress())))).findFirst();
            return optFound;

        }
    }

    public static class MemAllocAddress {
        private final Integer startAddress;

        private final Integer allocLength;

        public MemAllocAddress(Integer startAddress, Integer allocLength) {
            this.startAddress = startAddress;
            this.allocLength = allocLength;
        }

        public Integer startAddress() {
            return this.startAddress;
        }

        public Integer allocLength() {
            return this.allocLength;
        }

        public Integer endAddress() {
            return ((this.startAddress + this.allocLength) - 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MemAllocAddress that = (MemAllocAddress) o;
            return Objects.equals(startAddress, that.startAddress) && Objects.equals(allocLength, that.allocLength);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startAddress, allocLength);
        }

        @Override
        public String toString() {
            return "MemAllocAddress{" +
                    "startAddress=" + startAddress +
                    ", allocLength=" + allocLength +
                    ", endAddress= " + endAddress() +
                    '}';
        }
    }

    public static class AddressTuple {

        private final Integer startAddress;

        private final Integer endAddress;

        public AddressTuple(Integer startAddress, Integer endAddress) {
            this.startAddress = startAddress;
            this.endAddress = endAddress;
        }

        public Integer startAddress() {
            return startAddress;
        }

        public Integer endAddress() {
            return endAddress;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AddressTuple that = (AddressTuple) o;
            return Objects.equals(startAddress, that.startAddress) && Objects.equals(endAddress, that.endAddress);
        }



        @Override
        public int hashCode() {
            return Objects.hash(startAddress, endAddress);
        }

        @Override
        public String toString() {
            return "AddressTuple{" +
                    "startAddress=" + startAddress +
                    ", endAddress=" + endAddress +
                    '}';
        }
    }
}

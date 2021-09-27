package cat062.I062_390;

import lombok.Data;

@Data
public class StandStatus {

    private int EMP;

    private int AVL;

    public static final int length = 1;

    public StandStatus(int[] data, int index) {

        int  originalByte = data[index];
        EMP = (originalByte >> 6) & 0x03;
        AVL = (originalByte >> 4) & 0x03;
    }


    @Override
    public String toString() {
        return EMP + "|" + AVL;
    }
}

package cat062.I062_380;

import lombok.Data;

/**
 *
 Emitter Category
 发射器类别
 */
@Data
public class EmitterCategory {

    private int ECAT;

    public static final int length = 1;

    public EmitterCategory(int[] data, int index) {
        ECAT  = data[index];
    }

    @Override
    public String toString() {
        return ECAT + "";
    }


}

package cat062.I062_380;

import lombok.Data;

/**
 * 速度不确定性
 */
@Data
public class VelocityUncertainty {

    private int Category;

    public static final int length = 1;

    public VelocityUncertainty(int[] data, int index) {
        Category = data[index];
    }

    @Override
    public String toString() {
        return Category+"";
    }


}

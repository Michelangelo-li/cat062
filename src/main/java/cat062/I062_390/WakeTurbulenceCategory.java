package cat062.I062_390;

import lombok.Data;

/**
 * 尾流分类
 */
@Data
public class WakeTurbulenceCategory {

    private char Category;

    public static final int length = 1;

    public WakeTurbulenceCategory(int[] data, int index) {
        Category = (char) (byte) (data[index] & 0xFF);
    }

    @Override
    public String toString() {
        return String.valueOf(Category);
    }

}

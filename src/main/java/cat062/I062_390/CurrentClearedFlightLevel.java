package cat062.I062_390;

import lombok.Data;

/**
 *
 * flight level 是空层，只bai是代表了一个大范围的高du度层，
 * 在zhi民航局有规定直航角dao0到179度范围内，高度由900米至zhuan8100米，每隔600米每一shu个高度层，高度在9000米以上，
 * 每隔1200米为一个高度层。剩余的180度至359度
 CurrentClearedFlightLevel
 当前清除飞行高度
 Pre-Cleared Flight Level 预放行高度

 Definition
 The flight level to or at which a flight has currently been cleared by ATC.
 */
@Data
public class CurrentClearedFlightLevel {

    private double CFL;

    public static final int length = 2;

    public CurrentClearedFlightLevel(int[] data, int index) {

        CFL = (short)((data[index] << 8) | data[index + 1]) / 4.0;
    }

    @Override
    public String toString() {
        return CFL + "";
    }
}

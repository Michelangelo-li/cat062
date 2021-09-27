package cat062.simpleitem;

import lombok.Data;

/**
 * Cat 062 Item220 - ROCD - Opt
 * Calculated rate of Climb/Descent of an aircraft in two’s
 * complement form.
 *
 * @implSpec A positive value indicates a climb, whereas a negative value
 * indicates a descent
 *
 * 计算的爬升率/下降率
 */
@Data
public class I062_220_CalculatedRateOfClimbDescent {

    /**
     * uint:feet/minute, LSB:6.25
     */
    private double Rate;


    public static final int length = 2;

    public I062_220_CalculatedRateOfClimbDescent(int[] data, int index) {
        Rate = (short)((data[index] << 8) | data[index + 1]) * 6.25;
    }

    @Override
    public String toString() {
        return Rate + "";
    }


}

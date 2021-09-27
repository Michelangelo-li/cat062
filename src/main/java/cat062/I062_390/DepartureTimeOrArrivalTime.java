package cat062.I062_390;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 出发时间或到达时间
 */
@Data
@AllArgsConstructor
public class DepartureTimeOrArrivalTime {

    private int TYP;

    private int DAY;

    private int HOR;

    private int MIN;

    private int AVS;

    private int SEC;

    @Override
    public String toString() {
        return TYP + "|" + DAY + "|" + HOR + "|" + MIN + "|" + AVS + "|" + SEC;
    }


}

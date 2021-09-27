package cat062.I062_380;

import lombok.Data;

/**
 * ACAS 机载防撞系统 决议报告
 */
@Data
public class ACASResolutionAdvisoryReport {

    private String Report;

    public static final int length = 7;

    public ACASResolutionAdvisoryReport(int[] data, int index) {

        Report = String.format("%X%X%X%X%X%X%X",
                data[index],
                data[index + 1],
                data[index + 2],
                data[index + 3],
                data[index + 4],
                data[index + 5],
                data[index + 6]);
    }

    @Override
    public String toString() {
        return Report + "";
    }
}

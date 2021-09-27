package cat062.simpleitem;

import lombok.Data;

/**
 *
 * Cat-062 Item 010 - Data Source Identifier - Mandatory
 * Identification of the system sending the data (SAC-SIC)
 *
 * 22是SAC码，中国的SAC码， SIC码，雷达的编码这个码是唯一的
 *
 * 雷达识别码
 *
 * （SAC）系统区域代码	SAC的最新列表已发布在Eurocontrol网站上
 * （SIC）系统识别代码
 */
@Data
public class I062_010_DataSourceIdentifier {

    private int SAC;

    private int SIC;

    public static final int length = 2;

    public I062_010_DataSourceIdentifier(int[] data, int index) {

        SAC = data[index];
        SIC = data[index + 1];
    }

    @Override
    public String toString() {
        return SAC + "," + SIC;
    }

}

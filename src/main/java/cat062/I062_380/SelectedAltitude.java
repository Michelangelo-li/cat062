package cat062.I062_380;

import cat062.decoder.CommonUtil;
import lombok.Data;

/**
 *
 * 所选高度参数
 *
 * 该参数可以用于自动化系统的告警机制中，以减少在垂直方向上可能产生的告警；同时该参数也可以在管制人员的显示界面上直观显示，
 * 或者用于与管制人员输入的指定高度进行交叉检查，从而有效地降低潜在的高度冲突风险；
 *
 * 以Selected Altitude参数为例，可以实现机组操作与管制指令不适配时提前告警，
 * 该告警相比较传统的CLAM（Cleared Level Adherence Monitoring），能够更早的发出告警，
 * 对目前管制工作的作用将会尤为明显（如图1）；
 *
 * 例如X年X月X日，某航空公司B744飞机执行法兰克福至浦东航班，管制员指挥其下降高度到标准气压4200米保持，2分钟后，
 * 管制员发现该机突破指令高度4200米并有继续下降趋势。
 * 如果自动化系统能够获取到Selected Altitude参数，系统就可以提前发出告警，而非等到飞机实际突破高度后再行处理，
 * 从而避免潜在的风险。；
 */
@Data
public class SelectedAltitude {


    private int SAS;

    private int Source;

    private int Altitude;

    public static final int length = 2;



    public SelectedAltitude(int[] data, int index) {

        int b16 = (data[index] << 8) | data[index + 1];

        SAS = (b16 >> 15) & 0x01;

        Source = (b16 >> 13) & 0x03;

        Altitude = CommonUtil.twosComplement(b16 & 0x1FFF, 13) * 25;
    }


    @Override
    public String toString() {
        return Altitude + "|" + SAS + "|" + Source;
    }


}

import javax.swing.JOptionPane;
/**
 * 代码管理应用程序--项目的入口
 * Created by mengfeifei on 2017/10/19.
 *
 */
public class JFrameMain {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Object[] possibleValues = {"开发人员", "测试人员/客户/现场" };
        Object selectedValue =JOptionPane.showInputDialog(null, "请选择身份角色：",
                "选择角色：", JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
                possibleValues[0]);
        if("开发人员".equals(selectedValue)){
            new UpLoad().UpLoadFile("上传文件",selectedValue);
        }

    }
}
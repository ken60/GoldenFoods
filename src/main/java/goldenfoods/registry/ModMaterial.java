package goldenfoods.registry;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterial
{
	//addToolMaterial(ツールマテリアルの名前, 回収レベル, 最大耐久値, 採掘速度, 攻撃に使用したときのダメージ倍率(4を引く), エンチャントの付きやすさ)
	public static ToolMaterial goldenAppleSword = EnumHelper.addToolMaterial("GoldenAppleSword", 3, 59, 2.0F, 193.5F, 10);
	public static ToolMaterial ultimateGoldenAppleSword = EnumHelper.addToolMaterial("ultimateGoldenAppleSword", 3, 59, 2.0F, 291F, 10);
}

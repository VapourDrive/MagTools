package com.vapourdrive.magtools.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.vapourdrive.magtools.blocks.MagBlocks;
import com.vapourdrive.magtools.config.ConfigInfo;
import com.vapourdrive.magtools.items.tools.MagAxe;
import com.vapourdrive.magtools.items.tools.MagEarthMover;
import com.vapourdrive.magtools.items.tools.MagHammer;
import com.vapourdrive.magtools.items.tools.MagHatchet;
import com.vapourdrive.magtools.items.tools.MagPick;
import com.vapourdrive.magtools.items.tools.MagSword;

import cpw.mods.fml.common.registry.GameRegistry;

public class MagItems
{
	public static Item MagPick;
	public static Item MagHatchet;
	public static Item MagAxe;
	public static Item MagSword;
	public static Item MagHammer;
	public static Item MagEarthMover;

	public static Item MagHandle;
	public static Item MagStick;
	public static Item MagHammerHead;
	public static Item MagPickHead;
	public static Item MagAxeHead;
	public static Item MagBlade;
	public static Item MagHatchetHead;
	public static Item MagGem;
	public static Item MagEarthMoverHead;

	public static ToolMaterial Magnanimous = EnumHelper.addToolMaterial("Magnanimous", ConfigInfo.MagMiningLevel, ConfigInfo.MagDurability,
			ConfigInfo.MagEfficiency, ConfigInfo.MagDamage, ConfigInfo.MagEnchantability);

	public static void init()
	{
		MagPick = new MagPick(Magnanimous);
		MagSword = new MagSword(Magnanimous);
		MagHammer = new MagHammer(Magnanimous);
		MagHatchet = new MagHatchet(Magnanimous);
		MagEarthMover = new MagEarthMover(Magnanimous);
		//MagAxe = new MagAxe(Magnanimous);

		MagHandle = new LogiclessItem(MagItemRef.HardenedHandle, "phrase.magtools.handleinfo", "phrase.magtools.handleinfo2", 64);
		MagStick = new LogiclessItem(MagItemRef.MagStick, "phrase.magtools.magstickinfo", null, 64);
		MagHammerHead = new LogiclessItem(MagItemRef.MagHammerHead, "phrase.magtools.hammerheadinfo", null, 1);
		//MagAxeHead = new LogiclessItem(MagItemRef.MagAxeHead, "phrase.magtools.axeheadinfo", null, 1);
		MagPickHead = new LogiclessItem(MagItemRef.MagPickHead, "phrase.magtools.pickheadinfo", null, 1);
		MagBlade = new LogiclessItem(MagItemRef.MagSwordBlade, "phrase.magtools.swordbladeinfo", null, 1);
		MagGem = new LogiclessItem(MagItemRef.MagGem, "phrase.magtools.geminfo", null, 16);
		MagEarthMoverHead = new LogiclessItem(MagItemRef.MagEarthMoverHead, "phrase.magtools.earthmoverheadinfo", null, 1);


		registerItems();
	}
	
	public static void registerItems()
	{
		if(ConfigInfo.EnableSword)
		{
			GameRegistry.registerItem(MagSword, MagItemRef.MagSwordName);
			GameRegistry.registerItem(MagBlade, MagItemRef.MagSwordBlade);
		}
		if(ConfigInfo.EnablePick)
		{
			GameRegistry.registerItem(MagPick, MagItemRef.MagPickName);
			GameRegistry.registerItem(MagPickHead, MagItemRef.MagPickHead);
		}
		if(ConfigInfo.EnableHammer)
		{
			GameRegistry.registerItem(MagHammer, MagItemRef.MagHammerName);
			GameRegistry.registerItem(MagHammerHead, MagItemRef.MagHammerHead);
		}
		if(ConfigInfo.EnableEarthMover)
		{
			GameRegistry.registerItem(MagEarthMover, MagItemRef.MagEarthMover);
			GameRegistry.registerItem(MagEarthMoverHead, MagItemRef.MagEarthMoverHead);
		}
		if(ConfigInfo.EnableAxe)
		{
			//GameRegistry.registerItem(MagAxe, MagItemRef.MagAxe);
			//GameRegistry.registerItem(MagAxeHead, MagItemRef.MagAxeHead);
		}
		// GameRegistry.registerItem(MagHatchet, MagItemRef.MagHatchetName);

		GameRegistry.registerItem(MagHandle, MagItemRef.HardenedHandle);
		GameRegistry.registerItem(MagGem, MagItemRef.MagGem);
		GameRegistry.registerItem(MagStick, MagItemRef.MagStick);
	}

	public static void registerRecipes()
	{
		//GameRegistry.addShapedRecipe(new ItemStack(MagItems.MagAxeHead), new Object[]
		//{
		//		"## ", "###", "## ", '#', MagItems.MagGem
		//});
		GameRegistry.addShapedRecipe(new ItemStack(MagItems.MagBlade), new Object[]
		{
				" ##", "###", "## ", '#', MagItems.MagGem
		});
		GameRegistry.addShapedRecipe(new ItemStack(MagItems.MagHammerHead), new Object[]
		{
				"# #", "###", "# #", '#', MagItems.MagGem
		});
		GameRegistry.addShapedRecipe(new ItemStack(MagItems.MagEarthMoverHead), new Object[]
		{
				" # ", "###", "###", '#', MagItems.MagGem
		});
		GameRegistry.addShapedRecipe(new ItemStack(MagItems.MagPickHead), new Object[]
		{
				" # ", "# #", '#', MagItems.MagGem
		});

		GameRegistry.addShapedRecipe(new ItemStack(MagItems.MagHandle), new Object[]
		{
				"  #", " # ", "#  ", '#', MagItems.MagStick
		});
		
		GameRegistry.addSmelting(MagBlocks.MagLog, new ItemStack(Items.coal, 1, 1), 0.15F);
	}

}

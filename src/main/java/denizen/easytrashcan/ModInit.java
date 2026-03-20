package denizen.easytrashcan;


import denizen.easytrashcan.block.furniture.BrazierBlock;
import denizen.easytrashcan.block.item.GlobeBlock;
import denizen.easytrashcan.block.extension.WallAttachedLanternBlock;
import denizen.easytrashcan.entity.DecorationsEntities;
import denizen.easytrashcan.model.DecorationsModels;
import denizen.easytrashcan.patch.DecorationsLootTablePatches;
import denizen.easytrashcan.polydex.PolydexCompat;
import denizen.easytrashcan.recipe.DecorationsRecipeSerializers;
import denizen.easytrashcan.recipe.DecorationsRecipeTypes;
import denizen.easytrashcan.ui.GuiTextures;
import denizen.easytrashcan.ui.UiResourceCreator;
import denizen.easytrashcan.util.*;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import denizen.easytrashcan.block.DecorationsBlockEntities;
import denizen.easytrashcan.block.DecorationsBlocks;
import denizen.easytrashcan.item.DecorationsItems;
import eu.pb4.polymer.resourcepack.extras.api.ResourcePackExtras;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.core.config.AppenderControlArraySet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ModInit implements ModInitializer {
	public static final String ID = "polydecorations";
	public static final String VERSION = FabricLoader.getInstance().getModContainer(ID).get().getMetadata().getVersion().getFriendlyString();
	public static final Logger LOGGER = LoggerFactory.getLogger("PolyDecorations");
    public static final boolean DEV_ENV = FabricLoader.getInstance().isDevelopmentEnvironment();
    public static final boolean DEV_MODE = VERSION.contains("-dev.") || DEV_ENV;
    @SuppressWarnings("PointlessBooleanExpression")
	public static final boolean DYNAMIC_ASSETS = true && DEV_ENV;
	public static final List<Runnable> LATE_INIT = new ArrayList<>();

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(ID, path);
	}

	@Override
	public void onInitialize() {
		if (VERSION.contains("-dev.")) {
			LOGGER.warn("=====================================================");
			LOGGER.warn("You are using development version of PolyDecorations!");
			LOGGER.warn("Support is limited, as features might be unfinished!");
			LOGGER.warn("You are on your own!");
			LOGGER.warn("=====================================================");
		}

		DecorationsBlocks.register();
		DecorationsBlockEntities.register();
		DecorationsModels.register();
		DecorationsItems.register();
		DecorationsEntities.register();
		DecorationsRecipeTypes.register();
		DecorationsRecipeSerializers.register();
		DecorationsUtil.register();
		DecorationsGamerules.register();
		DecorationsLootTablePatches.register();

		LATE_INIT.forEach(Runnable::run);
		LATE_INIT.clear();

		UiResourceCreator.setup();
		GuiTextures.register();
		PolydexCompat.register();
		PolymerResourcePackUtils.addModAssets(ID);
		PolymerResourcePackUtils.markAsRequired();
		ResourcePackExtras.forDefault().addBridgedModelsFolder(id("block"), id("sgui"));
	}
}

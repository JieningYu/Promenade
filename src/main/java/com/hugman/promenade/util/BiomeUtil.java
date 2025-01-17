package com.hugman.promenade.util;

import com.hugman.promenade.Promenade;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.jetbrains.annotations.Nullable;

public final class BiomeUtil {
	public static final RegistryKey<Biome> PUMPKIN_PASTURES_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("pumpkin_pastures"));
	public static final RegistryKey<Biome> PINK_CHERRY_OAK_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("pink_cherry_oak_forest"));
	public static final RegistryKey<Biome> WHITE_CHERRY_OAK_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("white_cherry_oak_forest"));

	public static final RegistryKey<Biome> TALL_CRIMSON_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("tall_crimson_forest"));
	public static final RegistryKey<Biome> TALL_WARPED_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("tall_warped_forest"));
	public static final RegistryKey<Biome> TRITANOPIAN_GALLERY_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("tritanopian_gallery"));
	public static final RegistryKey<Biome> ACHROMATOPSIAN_GALLERY_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("achromatopsian_gallery"));
	public static final RegistryKey<Biome> PROTANOPIAN_GALLERY_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("protanopian_gallery"));
	public static final RegistryKey<Biome> DARK_AMARANTH_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("dark_amaranth_forest"));
	public static final RegistryKey<Biome> TALL_DARK_AMARANTH_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, Promenade.MOD_DATA.id("tall_dark_amaranth_forest"));

	public static int getSkyColor(float temperature) {
		float g = temperature / 3.0F;
		g = MathHelper.clamp(g, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
	}

	public static BiomeEffects.Builder genericEffectBuilder(float temperature) {
		return new BiomeEffects.Builder()
				.waterColor(4159204)
				.waterFogColor(329011)
				.fogColor(12638463)
				.skyColor(getSkyColor(temperature))
				.moodSound(BiomeMoodSound.CAVE)
				.music(null);
	}

	public static Biome createBiome(Biome.Category category, Biome.Precipitation precipitation, float temperature, float downfall, SpawnSettings spawnSettings, GenerationSettings genSettings, BiomeEffects effects) {
		return new Biome.Builder()
				.precipitation(precipitation)
				.category(category)
				.temperature(temperature)
				.downfall(downfall)
				.effects(effects)
				.spawnSettings(spawnSettings)
				.generationSettings(genSettings)
				.build();
	}

	public static SpawnSettings.Builder composeForestSpawn() {
		SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
		DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
		spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return spawnBuilder;
	}

	public static void addBasicFeatures(GenerationSettings.Builder generationSettings) {
		DefaultBiomeFeatures.addLandCarvers(generationSettings);
		DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
		DefaultBiomeFeatures.addDungeons(generationSettings);
		DefaultBiomeFeatures.addMineables(generationSettings);
		DefaultBiomeFeatures.addSprings(generationSettings);
		DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
	}

	public static GenerationSettings.Builder composeForestGenerationSettings() {
		GenerationSettings.Builder builder = new GenerationSettings.Builder();

		addBasicFeatures(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);

		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addForestGrass(builder);

		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		return builder;
	}

	public static Biome createEndBiome(GenerationSettings.Builder generationBuilder, SpawnSettings.Builder spawnSettings) {
		BiomeEffects.Builder effects = genericEffectBuilder(0.5F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.fogColor(0xA080A0)
				.skyColor(0)
				.particleConfig(new BiomeParticleConfig(ParticleTypes.FALLING_OBSIDIAN_TEAR, 0.002F));
		Biome.Builder settings = new Biome.Builder()
				.precipitation(Biome.Precipitation.NONE)
				.category(Biome.Category.THEEND)
				.temperature(0.5F)
				.downfall(0.5F)
				.effects(effects.build())
				.spawnSettings(spawnSettings.build())
				.generationSettings(generationBuilder.build());
		return settings.build();
	}
}

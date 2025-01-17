package com.hugman.promenade.init;

import com.hugman.dawn.api.creator.BiomeCreator;
import com.hugman.promenade.Promenade;
import com.hugman.promenade.util.BiomeUtil;
import com.hugman.promenade.util.PFeatureRegistrer;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountMultilayerPlacementModifier;

public class TallerNetherForestBundle extends PromenadeBundle {
	public static void addToGen() {
		if(Promenade.CONFIG.biomes.tall_nether_forests) {
			NetherBiomes.addNetherBiome(Biomes.TALL_CRIMSON_FOREST.getRegistryKey(), MultiNoiseUtil.createNoiseHypercube(0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			NetherBiomes.addNetherBiome(Biomes.TALL_WARPED_FOREST.getRegistryKey(), MultiNoiseUtil.createNoiseHypercube(0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.35F));
		}
	}

	public static class Features {
		public static class Configured {
			public static final RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>> TALL_CRIMSON_FUNGUS = PFeatureRegistrer.config("tall_crimson_fungus", CommonBundle.TALL_HUGE_FUNGUS, new HugeFungusFeatureConfig(Blocks.CRIMSON_NYLIUM.getDefaultState(), Blocks.CRIMSON_STEM.getDefaultState(), Blocks.NETHER_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), false));
			public static final RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>> TALL_WARPED_FUNGUS = PFeatureRegistrer.config("tall_warped_fungus", CommonBundle.TALL_HUGE_FUNGUS, new HugeFungusFeatureConfig(Blocks.WARPED_NYLIUM.getDefaultState(), Blocks.WARPED_STEM.getDefaultState(), Blocks.WARPED_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), false));
		}

		public static class Placed {
			public static final RegistryEntry<PlacedFeature> TALL_CRIMSON_FUNGI = PFeatureRegistrer.place("tall_crimson_fungi", Configured.TALL_CRIMSON_FUNGUS, CountMultilayerPlacementModifier.of(8), BiomePlacementModifier.of());
			public static final RegistryEntry<PlacedFeature> TALL_WARPED_FUNGI = PFeatureRegistrer.place("tall_warped_fungi", Configured.TALL_WARPED_FUNGUS, CountMultilayerPlacementModifier.of(8), BiomePlacementModifier.of());
		}
	}

	public static class Biomes {
		public static final BiomeCreator TALL_CRIMSON_FOREST = creator(new BiomeCreator("tall_crimson_forest", createTallCrimsonForest()));
		public static final BiomeCreator TALL_WARPED_FOREST = creator(new BiomeCreator("tall_warped_forest", createTallWarpedForest()));

		public static Biome createTallCrimsonForest() {
			SpawnSettings spawnSettings = new SpawnSettings.Builder()
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4))
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HOGLIN, 9, 3, 4))
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 5, 3, 4))
					.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2))
					.build();
			GenerationSettings.Builder genBuilder = new GenerationSettings.Builder()
					.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.SPRING_LAVA);
			DefaultBiomeFeatures.addDefaultMushrooms(genBuilder);
			genBuilder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_OPEN)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_FIRE)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.WEEPING_VINES)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.Placed.TALL_CRIMSON_FUNGI)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.CRIMSON_FOREST_VEGETATION);

			DefaultBiomeFeatures.addNetherMineables(genBuilder);
			BiomeEffects effects = BiomeUtil.genericEffectBuilder(2.0F)
					.fogColor(0x330303)
					.particleConfig(new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.025f))
					.loopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
					.moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0))
					.additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111))
					.music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST))
					.build();
			return new Biome.Builder()
					.precipitation(Biome.Precipitation.NONE)
					.category(Biome.Category.NETHER)
					.temperature(2.0f).downfall(0.0f)
					.effects(effects)
					.spawnSettings(spawnSettings)
					.generationSettings(genBuilder.build())
					.build();
		}

		public static Biome createTallWarpedForest() {
			SpawnSettings spawnSettings = new SpawnSettings.Builder()
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4))
					.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2))
					.spawnCost(EntityType.ENDERMAN, 1.0, 0.12)
					.build();
			GenerationSettings.Builder genBuilder = new GenerationSettings.Builder()
					.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, MiscPlacedFeatures.SPRING_LAVA);
			DefaultBiomeFeatures.addDefaultMushrooms(genBuilder);
			genBuilder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_OPEN)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_FIRE)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_SOUL_FIRE)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA)
					.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.Placed.TALL_WARPED_FUNGI)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.WARPED_FOREST_VEGETATION)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.NETHER_SPROUTS)
					.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.TWISTING_VINES);
			DefaultBiomeFeatures.addNetherMineables(genBuilder);
			BiomeEffects effects = BiomeUtil.genericEffectBuilder(2.0F)
					.fogColor(1705242)
					.particleConfig(new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428f))
					.loopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
					.moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0))
					.additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111))
					.music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_WARPED_FOREST))
					.build();
			return new Biome.Builder()
					.precipitation(Biome.Precipitation.NONE)
					.category(Biome.Category.NETHER)
					.temperature(2.0f)
					.downfall(0.0f)
					.effects(effects)
					.spawnSettings(spawnSettings)
					.generationSettings(genBuilder.build())
					.build();
		}
	}
}
package com.hugman.promenade.init;

import com.hugman.dawn.api.creator.BiomeCreator;
import com.hugman.promenade.Promenade;
import com.hugman.promenade.util.BiomeUtil;
import com.hugman.promenade.util.PFeatureRegistrer;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

import static com.hugman.promenade.init.MushroomBundle.Features.Configured.*;

public class GalleryBundle extends PromenadeBundle {
	public static void addToGen() {
		if(Promenade.CONFIG.biomes.nether_galleries) {
			NetherBiomes.addNetherBiome(Biomes.TRITANOPIAN_GALLERY.getRegistryKey(), MultiNoiseUtil.createNoiseHypercube(0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F));
			NetherBiomes.addNetherBiome(Biomes.ACHROMATOPSIAN_GALLERY.getRegistryKey(), MultiNoiseUtil.createNoiseHypercube(0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.1F, 0.0F));
			NetherBiomes.addNetherBiome(Biomes.PROTANOPIAN_GALLERY.getRegistryKey(), MultiNoiseUtil.createNoiseHypercube(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F));
		}
	}

	public static class Features {
		public static class Configured {
			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> NORMAL_TRITANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/tritanopian/normal", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_PINK), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN)));
			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> FLAT_TRITANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/tritanopian/flat", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_PINK_FLAT), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN_FLAT)));
			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> CEILING_TRITANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/tritanopian/ceiling", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_PINK_UPSIDE), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN_UPSIDE)));
			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> CEILING_FLAT_TRITANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/tritanopian/ceiling_flat", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_PINK_UPSIDE_FLAT), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN_UPSIDE_FLAT)));

			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> NORMAL_ACHROMATOPSIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/achromatopsian/normal", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_GRAY), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BLACK)));
			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> FLAT_ACHROMATOPSIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/achromatopsian/flat", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_GRAY_FLAT), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BLACK_FLAT)));
			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> CEILING_ACHROMATOPSIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/achromatopsian/ceiling", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_WHITE_UPSIDE), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_LIGHT_GRAY_UPSIDE)));
			public static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> CEILING_FLAT_ACHROMATOPSIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/achromatopsian/ceiling_flat", Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfig(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_WHITE_UPSIDE_FLAT), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_LIGHT_GRAY_UPSIDE_FLAT)));

			public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> NORMAL_PROTANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/protanopian/normal", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BROWN_FLAT), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_YELLOW), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN), 0.25F)), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BLUE)));
			public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> FLAT_PROTANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/protanopian/flat", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BROWN_UPSIDE_FLAT), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_YELLOW_UPSIDE), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN_UPSIDE), 0.25F)),
					PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BLUE_UPSIDE)));
			public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CEILING_PROTANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/protanopian/ceiling", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_YELLOW_FLAT), 1F / 3F), new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN_FLAT), 1F / 3F)), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BLUE_FLAT)));
			public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CEILING_FLAT_PROTANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/protanopian/ceiling_flat", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_YELLOW_UPSIDE_FLAT), 1F / 3F), new RandomFeatureEntry(PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_CYAN_UPSIDE_FLAT), 1F / 3F)), PlacedFeatures.createEntry(HUGE_NETHER_MUSHROOM_BLUE_UPSIDE_FLAT)));

			public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> TRITANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/tritanopian", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatures.createEntry(NORMAL_TRITANOPIAN_HUGE_MUSHROOM), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(FLAT_TRITANOPIAN_HUGE_MUSHROOM), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(CEILING_TRITANOPIAN_HUGE_MUSHROOM), 0.25F)), PlacedFeatures.createEntry(CEILING_FLAT_TRITANOPIAN_HUGE_MUSHROOM)));
			public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ACHROMATOPSIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/achromatopsian", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatures.createEntry(NORMAL_ACHROMATOPSIAN_HUGE_MUSHROOM), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(FLAT_ACHROMATOPSIAN_HUGE_MUSHROOM), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(CEILING_ACHROMATOPSIAN_HUGE_MUSHROOM), 0.25F)),
					PlacedFeatures.createEntry(CEILING_FLAT_ACHROMATOPSIAN_HUGE_MUSHROOM)));
			public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> PROTANOPIAN_HUGE_MUSHROOM = PFeatureRegistrer.config("huge_nether_mushroom/protanopian", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(PlacedFeatures.createEntry(NORMAL_PROTANOPIAN_HUGE_MUSHROOM), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(FLAT_PROTANOPIAN_HUGE_MUSHROOM), 0.25F), new RandomFeatureEntry(PlacedFeatures.createEntry(CEILING_PROTANOPIAN_HUGE_MUSHROOM), 0.25F)), PlacedFeatures.createEntry(CEILING_FLAT_PROTANOPIAN_HUGE_MUSHROOM)));
		}

		public static class Placed {
			private static final List<PlacementModifier> PLACEMENT_MODIFIERS = List.of(CountPlacementModifier.of(16), SquarePlacementModifier.of(), VegetationPlacedFeatures.NOT_IN_SURFACE_WATER_MODIFIER, PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of());

			public static final RegistryEntry<PlacedFeature> TRITANOPIAN_HUGE_MUSHROOMS = PFeatureRegistrer.place("huge_nether_mushrooms/tritanopian", Configured.TRITANOPIAN_HUGE_MUSHROOM, PLACEMENT_MODIFIERS);
			public static final RegistryEntry<PlacedFeature> ACHROMATOPSIAN_HUGE_MUSHROOMS = PFeatureRegistrer.place("huge_nether_mushrooms/achromatopsian", Configured.ACHROMATOPSIAN_HUGE_MUSHROOM, PLACEMENT_MODIFIERS);
			public static final RegistryEntry<PlacedFeature> PROTANOPIAN_HUGE_MUSHROOMS = PFeatureRegistrer.place("huge_nether_mushrooms/protanopian", Configured.PROTANOPIAN_HUGE_MUSHROOM, PLACEMENT_MODIFIERS);
		}
	}

	public static class Biomes {
		public static final BiomeCreator TRITANOPIAN_GALLERY = creator(new BiomeCreator("tritanopian_gallery", createGallery(composeTritanopianSettings())));
		public static final BiomeCreator ACHROMATOPSIAN_GALLERY = creator(new BiomeCreator("achromatopsian_gallery", createGallery(composeAchromatopsianSettings())));
		public static final BiomeCreator PROTANOPIAN_GALLERY = creator(new BiomeCreator("protanopian_gallery", createGallery(composeProtanopianSettings())));

		public static Biome createGallery(GenerationSettings.Builder genBuilder) {
			SpawnSettings spawnSettings = new SpawnSettings.Builder()
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 50, 4, 4))
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4))
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 2, 4, 4))
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 1, 4, 4))
					.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN, 15, 4, 4))
					.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.STRIDER, 60, 1, 2))
					.build();
			BiomeEffects effects = BiomeUtil.genericEffectBuilder(2.0F)
					.fogColor(0x330808)
					.loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
					.moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0))
					.additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111))
					.music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_NETHER_WASTES))
					.build();
			return new Biome.Builder()
					.precipitation(Biome.Precipitation.NONE)
					.category(Biome.Category.NETHER)
					.temperature(2.0F)
					.downfall(0.0F)
					.effects(effects)
					.spawnSettings(spawnSettings)
					.generationSettings(genBuilder.build())
					.build();
		}

		public static GenerationSettings.Builder composeTritanopianSettings() {
			GenerationSettings.Builder builder = new GenerationSettings.Builder();

			builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
			builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.SPRING_OPEN);
			builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.Placed.TRITANOPIAN_HUGE_MUSHROOMS);
			addUndergroundDecoration(builder);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.PINK_MUSHROOM_NETHER_PATCH);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.CYAN_MUSHROOM_NETHER_PATCH);
			DefaultBiomeFeatures.addNetherMineables(builder);

			return builder;
		}

		public static GenerationSettings.Builder composeAchromatopsianSettings() {
			GenerationSettings.Builder builder = new GenerationSettings.Builder();

			builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
			builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.SPRING_OPEN);
			builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.Placed.ACHROMATOPSIAN_HUGE_MUSHROOMS);
			addUndergroundDecoration(builder);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.WHITE_MUSHROOM_NETHER_PATCH);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.LIGHT_GRAY_MUSHROOM_NETHER_PATCH);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.GRAY_MUSHROOM_NETHER_PATCH);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.BLACK_MUSHROOM_NETHER_PATCH);
			DefaultBiomeFeatures.addNetherMineables(builder);

			return builder;
		}

		public static GenerationSettings.Builder composeProtanopianSettings() {
			GenerationSettings.Builder builder = new GenerationSettings.Builder();

			builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
			builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, NetherPlacedFeatures.SPRING_OPEN);
			builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.Placed.PROTANOPIAN_HUGE_MUSHROOMS);
			addUndergroundDecoration(builder, true);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.YELLOW_MUSHROOM_NETHER_PATCH);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.CYAN_MUSHROOM_NETHER_PATCH);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, MushroomBundle.Features.Placed.BLUE_MUSHROOM_NETHER_PATCH);
			DefaultBiomeFeatures.addNetherMineables(builder);

			return builder;
		}

		private static void addUndergroundDecoration(GenerationSettings.Builder builder) {
			addUndergroundDecoration(builder, false);
		}

		private static void addUndergroundDecoration(GenerationSettings.Builder builder, boolean hasBrownMushrooms) {
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_OPEN);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_FIRE);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.PATCH_SOUL_FIRE);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE_EXTRA);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.GLOWSTONE);
			if(hasBrownMushrooms) builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_NETHER);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, OrePlacedFeatures.ORE_MAGMA);
			builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, NetherPlacedFeatures.SPRING_CLOSED);
		}
	}
}
package com.hugman.promenade.object.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public class SpikeFeatureConfig implements FeatureConfig {
	public static final Codec<SpikeFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
			BlockState.CODEC.fieldOf("state").forGetter((config) -> config.state),
			BlockState.CODEC.fieldOf("decor_state").forGetter((config) -> config.decorState),
			Codec.FLOAT.fieldOf("decor_chance").forGetter((config) -> config.decorChance),
			Registry.BLOCK.getCodec().listOf().fieldOf("valid_blocks").forGetter((config) -> config.validBlocks),
			Codec.INT.fieldOf("base_height").orElse(4).forGetter((config) -> config.baseHeight),
			Codec.INT.fieldOf("random_height").orElse(0).forGetter((config) -> config.randomHeight),
			Codec.FLOAT.fieldOf("base_radius").orElse(2.0f).forGetter((config) -> config.baseRadius),
			Codec.FLOAT.fieldOf("random_radius").orElse(0.0f).forGetter((config) -> config.randomRadius),
			Codec.FLOAT.fieldOf("base_ytheta").orElse(360.0F).forGetter((config) -> config.baseYtheta),
			Codec.FLOAT.fieldOf("random_ytheta").orElse(0.0f).forGetter((config) -> config.randomYtheta),
			Codec.FLOAT.fieldOf("base_ztheta").orElse(180.0f).forGetter((config) -> config.baseZtheta),
			Codec.FLOAT.fieldOf("random_ztheta").orElse(0.0f).forGetter((config) -> config.randomZtheta),
			Codec.FLOAT.fieldOf("y_offset").orElse(0.0f).forGetter((config) -> config.yOffset)
	).apply(instance, SpikeFeatureConfig::new));

	public final BlockState state;
	public final BlockState decorState;
	public final float decorChance;
	public final List<Block> validBlocks;
	public final int baseHeight;
	public final int randomHeight;
	public final float baseRadius;
	public final float randomRadius;
	public final float baseYtheta;
	public final float randomYtheta;
	public final float baseZtheta;
	public final float randomZtheta;
	public final float yOffset;

	public SpikeFeatureConfig(BlockState state, BlockState decorState, float decorChance, List<Block> validBlocks, int baseHeight, int randomHeight, float baseRadius, float randomRadius, float baseYtheta, float randomYtheta, float baseZtheta, float randomZtheta, float yOffset) {
		this.state = state;
		this.decorState = decorState;
		this.decorChance = decorChance;
		this.validBlocks = validBlocks;
		this.baseHeight = baseHeight;
		this.randomHeight = randomHeight;
		this.baseRadius = baseRadius;
		this.randomRadius = randomRadius;
		this.baseYtheta = baseYtheta;
		this.randomYtheta = randomYtheta;
		this.baseZtheta = baseZtheta;
		this.randomZtheta = randomZtheta;
		this.yOffset = yOffset;
	}

	public SpikeFeatureConfig(BlockState state, List<Block> validBlocks, int baseHeight, int randomHeight, float baseRadius, float randomRadius, float baseYtheta, float randomYtheta, float baseZtheta, float randomZtheta, float yOffset) {
		this(state, Blocks.AIR.getDefaultState(), 0f, validBlocks, baseHeight, randomHeight, baseRadius, randomRadius, baseYtheta, randomYtheta, baseZtheta, randomZtheta, yOffset);
	}

	public SpikeFeatureConfig setDecoration(BlockState state, float decorChance) {
		return new SpikeFeatureConfig(this.state, state, decorChance, this.validBlocks, this.baseHeight, this.randomHeight, this.baseRadius, this.randomRadius, this.baseYtheta, this.randomYtheta, this.baseZtheta, this.randomZtheta, this.yOffset);
	}
}
package dev.darkar.cog_works.utils.enums;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;

import java.util.Optional;

public enum BuildMaterial implements StringRepresentable {
	
	WOOD(300, 3800, 1000),
	STONE(950, 11500, 4500),
	IRON(1500, 19165, 10000);
	
	/**
	 * The maximum torque resistance of the material.
	 * described in Nm (Newton Meters)
	 */
	private final double maxTorqueResistance;
	/**
	 * The maximum angular speed resistance of the material.
	 * described in rad/s (Radians per second)
	 */
	private final double maxSpeedResistance;
	/**
	 * The maximum power resistance of the material.
	 * described in W (Watts)
	 */
	private final double maxPowerResistance;
	
	
	BuildMaterial(double maxTorque, double maxSpeed, double maxPower) {
		this.maxTorqueResistance = maxTorque;
		this.maxSpeedResistance = maxSpeed;
		this.maxPowerResistance = maxPower;
	}
	
	public double getMaxTorqueResistance() {
		return this.maxTorqueResistance;
	}
	
	public double getMaxSpeedResistance() {
		return this.maxSpeedResistance;
	}
	
	public double getMaxPowerResistance() {
		return this.maxPowerResistance;
	}
	
	public static Optional<BuildMaterial> getMaterial(String materialName) {
	 		for (BuildMaterial material : BuildMaterial.values()) {
			if (material.name().equalsIgnoreCase(materialName)) {
				return Optional.of(material);
			}
		}
		return Optional.empty();
	}
	
	public static Codec<BuildMaterial> CODEC = Codec.STRING.comapFlatMap((materialName) -> {
		Optional<BuildMaterial> buildMaterial = BuildMaterial.getMaterial(materialName);
		return buildMaterial
			.<DataResult<? extends BuildMaterial>>map(DataResult::success)
			.orElseGet(
				() -> DataResult.error(() -> String.format("Invalid Build Material name provided %s",
				                                                                   materialName)));
	}, BuildMaterial::name);
	
	public static StreamCodec<ByteBuf, BuildMaterial> STREAM_CODEC = ByteBufCodecs.STRING_UTF8.map(
		(materialName) -> {
			Optional<BuildMaterial> buildMaterial = BuildMaterial.getMaterial(materialName);
			return buildMaterial.orElseThrow(
				() -> new IllegalArgumentException("Invalid Build Material name provided " + materialName));
		}, BuildMaterial::name);
	
	@Override
	public String getSerializedName() {
		return this.toString().toLowerCase();
	}
}

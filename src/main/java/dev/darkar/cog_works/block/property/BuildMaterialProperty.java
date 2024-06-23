package dev.darkar.cog_works.block.property;

import com.google.common.collect.Lists;
import dev.darkar.cog_works.utils.enums.BuildMaterial;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BuildMaterialProperty extends EnumProperty<BuildMaterial>{
	protected BuildMaterialProperty(String pName, Collection<BuildMaterial> pValues)
	{
		super(pName, BuildMaterial.class, pValues);
	}
	
	public static BuildMaterialProperty create(String name, Collection<BuildMaterial> values)
	{
		return new BuildMaterialProperty(name, values);
	}
	
	public static BuildMaterialProperty create(String name, Predicate<BuildMaterial> filter) {
		return create(name, Arrays
				.stream(BuildMaterial.class.getEnumConstants()).filter(filter).collect(Collectors.toList()));
	}
	
	public static BuildMaterialProperty create(String name) {
		return create(name, val -> true);
	}
	
	public static BuildMaterialProperty create(String name, BuildMaterial... materials) {
		return create(name, Lists.newArrayList(materials));
	}
	
}

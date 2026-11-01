package org.bitwisemadness.tensuracapitalcelestials.gametest;

import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;
import org.bitwisemadness.tensuracapitalcelestials.TensuraCapitalCelestials;

/** Smoke test: the mod loads and the gametest harness runs. */
@GameTestHolder(TensuraCapitalCelestials.MOD_ID)
@PrefixGameTestTemplate(false)
public final class TensuraCapitalCelestialsGameTests {

    private TensuraCapitalCelestialsGameTests() {
    }

    @GameTest(template = "empty")
    public static void mod_loads(GameTestHelper helper) {
        helper.succeed();
    }

    /** The Celestials capital is a registered structure and its central tag resolves. */
    @GameTest(template = "empty")
    public static void capital_registered_and_tagged(GameTestHelper helper) {
        var registry = helper.getLevel().registryAccess().registryOrThrow(Registries.STRUCTURE);
        var key = net.minecraft.resources.ResourceKey.create(Registries.STRUCTURE,
                ResourceLocation.fromNamespaceAndPath(TensuraCapitalCelestials.MOD_ID, "celestials"));
        helper.assertTrue(registry.getHolder(key).isPresent(), "the Celestials capital structure is not registered");
        var tag = net.minecraft.tags.TagKey.create(Registries.STRUCTURE,
                ResourceLocation.fromNamespaceAndPath("tensura_faction_spawn", "capital/celestials"));
        var holders = registry.getTag(tag);
        helper.assertTrue(holders.isPresent() && holders.get().size() > 0, "the Celestials capital tag does not resolve");
        helper.succeed();
    }
}

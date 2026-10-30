package org.bitwisemadness.tensuracapitalcelestials.gametest;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
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
}
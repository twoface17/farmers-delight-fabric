package com.nhoryzon.mc.farmersdelight.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public final class MathUtils {
    public static final Random RAND = new Random();

    private MathUtils() { }

    public static int calcRedstoneFromItemHandler(Inventory inventory) {
        if (inventory == null) {
            return 0;
        } else {
            int i = 0;
            float f = .0f;

            for (int j = 0; j < inventory.size(); i++) {
                ItemStack itemStack = inventory.getStack(j);
                if (!itemStack.isEmpty()) {
                    f += (float) itemStack.getCount() / (float) Math.min(inventory.getMaxCountPerStack(), itemStack.getMaxCount());
                    i++;
                }
            }

            if (inventory.size() > 0) {
                f = f / (float) inventory.size();
            }

            return MathHelper.floor(f * 14.f) + (i > 0 ? 1 : 0);
        }
    }

}
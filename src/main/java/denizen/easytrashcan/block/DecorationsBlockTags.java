package denizen.easytrashcan.block;

import denizen.easytrashcan.ModInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class DecorationsBlockTags {
    public static final TagKey<Block> UNCONNECTABLE = of("unconnectable");
    public static final TagKey<Block> MAILBOXES = of("mailboxes");
    public static final TagKey<Block> SHELVES = of("shelves");
    public static final TagKey<Block> BENCHES = of("benches");
    public static final TagKey<Block> TOOL_RACKS = of("tool_racks");
    public static final TagKey<Block> TABLES = of("tables");
    public static final TagKey<Block> BRAZIERS = of("braziers");
    public static final TagKey<Block> SIGN_POSTS = of("sign_posts");
    public static final TagKey<Block> STUMPS = of("stumps");
    public static final TagKey<Block> SLEEPING_BAGS = of("stumps");
    public static final TagKey<Block> ALLOWED_INTERACTIONS_BLOCKS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("goml", "allowed_interactions"));
    public static final TagKey<Block> USE_BASE_SHAPE_OVER_SUPPORT_SHAPE = of("use_base_shape_over_support_shape");

    private static TagKey<Block> of(String path) {
        return TagKey.create(Registries.BLOCK, ModInit.id(path));
    }
}

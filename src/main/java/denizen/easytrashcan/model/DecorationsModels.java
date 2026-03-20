package denizen.easytrashcan.model;

import static denizen.easytrashcan.ModInit.id;

public interface DecorationsModels {
    DirectionConnectingModel ROPE = new DirectionConnectingModel(id("block/rope"));
    static void register() {

    }
}

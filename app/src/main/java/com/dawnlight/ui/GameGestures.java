package com.dawnlight.ui;

import com.dawnlight.binding.input.GameInputDevice;

public interface GameGestures {
    void toggleKeyboard();

    default void showGameMenu(GameInputDevice device){};
}

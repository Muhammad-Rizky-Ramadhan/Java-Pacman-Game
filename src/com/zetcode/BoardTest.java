package com.zetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PacmanGameTest {
    private Board pacmanGame;

    @BeforeEach
    void setUp() {
        pacmanGame = new Board();
        pacmanGame.pacman_x = 0;
        pacmanGame.pacman_y = 0;
        pacmanGame.pacmand_x = 1; // Default arah kanan
        pacmanGame.pacmand_y = 0;
        pacmanGame.PACMAN_SPEED = 2;
    }

    @Test
    void testMovePacmanRight() {
        // Uji pergerakan ke kanan
        pacmanGame.movePacman();
        assertEquals(2, pacmanGame.pacman_x, "Pacman harus bergerak ke kanan sejauh 2 unit.");
        assertEquals(0, pacmanGame.pacman_y, "Pacman tidak boleh bergerak ke atas atau bawah.");
    }

    @Test
    void testMovePacmanUpBlocked() {
        // Set arah ke atas dan simulasi tembok di atas
        pacmanGame.pacmand_x = 0;
        pacmanGame.pacmand_y = -1;
        pacmanGame.screenData[0] = 2; // Tembok di atas

        pacmanGame.movePacman();

        // Pastikan Pacman tetap di posisi awal karena ada tembok
        assertEquals(0, pacmanGame.pacman_x, "Pacman tidak boleh bergerak ke samping.");
        assertEquals(0, pacmanGame.pacman_y, "Pacman tidak boleh naik karena ada tembok.");
    }
}

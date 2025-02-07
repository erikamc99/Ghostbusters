package dev.erica.ghostbusters.model;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class UserModelTest {
    private UserModel userModel;
    private GhostModel ghost1;
    private GhostModel ghost2;
    private GhostModel ghost3;

    @BeforeEach
    void setUp() {
        userModel = new UserModel();

        ghost1 = new GhostModel("Pepito", GhostClass.CLASS_I, "Alto", "Invisibilidad", "15-03-2023");
        ghost2 = new GhostModel("Menganito", GhostClass.CLASS_II, "Medio", "Teletransportación", "08-03-2023");
        ghost3 = new GhostModel("Lucifer", GhostClass.CLASS_I, "Crítico", "Grito mortal", "22-05-2023");

        userModel.addGhost(ghost1);
        userModel.addGhost(ghost2);
        userModel.addGhost(ghost3);
    }

    @Test
    @DisplayName("Test para capturar un fantasma")
    void testAddGhost() {
        GhostModel ghost = new GhostModel("Casper", GhostClass.CLASS_I, "Bajo", "Mimetización", "10-06-2023");
        userModel.addGhost(ghost);
        assertThat(userModel.getGhosts(), hasItem(ghost));
    }

    @Test
    @DisplayName("Test para obtener los fantasmas capturados")
    void testGetGhosts() {
        List<GhostModel> ghosts = userModel.getGhosts();
        ghosts.clear();
        assertThat(userModel.getGhosts(), is(not(empty())));
    }
}

public class Star {
    public double posX, posY, posZ;
    public int displayX, displayY;

    public Star(boolean randomizeZ) {
        do { 
            posX = Math.random() * Starfield.WIDTH;
            posY = Math.random() * Starfield.HEIGHT;
        } while (posX == Starfield.WIDTH / 2 || posY == Starfield.HEIGHT / 2); // to prevent a 0 value in a StarPanel calculation

        if (randomizeZ) posZ = (Math.random() * Starfield.WIDTH / 4) + Starfield.WIDTH / 4; // Range: 1 quarter - 2 quarter WIDTH
        else posZ = Starfield.WIDTH / 2;

        displayX = (int) StarPanel.map((posX - Starfield.WIDTH / 2) / posZ, -1, 1, 0, Starfield.WIDTH);
        displayY = (int) StarPanel.map((posY - Starfield.HEIGHT / 2) / posZ, -1, 1, 0, Starfield.HEIGHT);
    }
}

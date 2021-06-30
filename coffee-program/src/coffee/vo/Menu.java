package coffee.vo;

public class Menu {
    private String americano;
    private String vanillaLatte;
    private String lemonAde;
    private String grapeFruitAde;
    private String waterMelonJuice;
    private String tomatoJuice;

    public String getAmericano() {
        return americano;
    }

    public void setAmericano(String americano) {
        this.americano = americano;
    }

    public String getVanillaLatte() {
        return vanillaLatte;
    }

    public void setVanillaLatte(String vanillaLatte) {
        this.vanillaLatte = vanillaLatte;
    }

    public String getLemonAde() {
        return lemonAde;
    }

    public void setLemonAde(String lemonAde) {
        this.lemonAde = lemonAde;
    }

    public String getGrapeFruitAde() {
        return grapeFruitAde;
    }

    public void setGrapeFruitAde(String grapeFruitAde) {
        this.grapeFruitAde = grapeFruitAde;
    }

    public String getWaterMelonJuice() {
        return waterMelonJuice;
    }

    public void setWaterMelonJuice(String waterMelonJuice) {
        this.waterMelonJuice = waterMelonJuice;
    }

    public String getTomatoJuice() {
        return tomatoJuice;
    }

    public void setTomatoJuice(String tomatoJuice) {
        this.tomatoJuice = tomatoJuice;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "americano='" + americano + '\'' +
                ", vanillaLatte='" + vanillaLatte + '\'' +
                ", lemonAde='" + lemonAde + '\'' +
                ", grapeFruitAde='" + grapeFruitAde + '\'' +
                ", waterMelonJuice='" + waterMelonJuice + '\'' +
                ", tomatoJuice='" + tomatoJuice + '\'' +
                '}';
    }
}

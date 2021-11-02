package com.github.denakh.deckofcardsapi.models.deckofcards;

import java.util.Objects;

public class Images {

    private String svg;

    private String png;

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Images images = (Images) o;
        return Objects.equals(svg, images.svg) &&
                Objects.equals(png, images.png);
    }

    @Override
    public int hashCode() {
        return Objects.hash(svg, png);
    }

    @Override
    public String toString() {
        return "Images{" +
                "svg='" + svg + '\'' +
                ", png='" + png + '\'' +
                '}';
    }
}

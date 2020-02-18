package com.redhat.developer.model.panel.heatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PanelColor {
    @JsonProperty("cardColor")
    public String cardColor = "#b4ff00";

    @JsonProperty("colorScale")
    public String colorScale = "sqrt";

    @JsonProperty("colorScheme")
    public String colorScheme = "interpolateOranges";

    @JsonProperty("exponent")
    public double exponent = 0.5;

    @JsonProperty("mode")
    public String mode = "spectrum";
}
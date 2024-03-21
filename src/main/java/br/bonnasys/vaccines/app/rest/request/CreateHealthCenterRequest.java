package br.bonnasys.vaccines.app.rest.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateHealthCenterRequest(
        @Schema(example = "Centro de Saúde três corações")
        String name,
        @Schema(example = "Casa da mãe Joana")
        String address,
        @Schema(example = "SP")
        String state,
        @Schema(example = "Jardim Lourdes")
        String neighborhood
) {
}

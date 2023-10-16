package vn.fpt.fap.seven.dto.common;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String error
) {
}

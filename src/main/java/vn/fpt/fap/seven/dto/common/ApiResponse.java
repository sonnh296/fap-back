package vn.fpt.fap.seven.dto.common;

import lombok.Builder;

@Builder
public record ApiResponse<T>(
        String message,
        T data
) {
}

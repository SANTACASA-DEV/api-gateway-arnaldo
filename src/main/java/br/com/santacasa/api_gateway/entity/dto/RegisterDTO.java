package br.com.santacasa.api_gateway.entity.dto;

import br.com.santacasa.api_gateway.entity.UserRole;

public record RegisterDTO(String matricula, String password, String email, UserRole role) {
}

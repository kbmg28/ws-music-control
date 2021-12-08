package br.com.kbmg.wsmusiccontrol.service;

import br.com.kbmg.wsmusiccontrol.dto.user.LoginDto;
import br.com.kbmg.wsmusiccontrol.model.Space;
import br.com.kbmg.wsmusiccontrol.model.UserApp;

import javax.servlet.http.HttpServletRequest;

public interface JwtService {

    String generateToken(LoginDto loginDto, UserApp userApp, Space lastAccessedSpace);
    boolean isValidToken(String token);
    String validateTokenAndGetUserId(String token);

    String getValue(String token, String key);

    String updateSpaceOnToken(HttpServletRequest request, Space space);
}

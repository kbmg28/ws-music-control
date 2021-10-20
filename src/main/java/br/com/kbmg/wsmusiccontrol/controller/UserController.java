package br.com.kbmg.wsmusiccontrol.controller;

import br.com.kbmg.wsmusiccontrol.config.security.annotations.SecuredAnyUserAuth;
import br.com.kbmg.wsmusiccontrol.dto.user.UserDto;
import br.com.kbmg.wsmusiccontrol.dto.user.UserWithPermissionDto;
import br.com.kbmg.wsmusiccontrol.enums.PermissionEnum;
import br.com.kbmg.wsmusiccontrol.model.UserApp;
import br.com.kbmg.wsmusiccontrol.model.UserPermission;
import br.com.kbmg.wsmusiccontrol.service.UserAppService;
import br.com.kbmg.wsmusiccontrol.service.UserPermissionService;
import br.com.kbmg.wsmusiccontrol.util.mapper.UserAppMapper;
import br.com.kbmg.wsmusiccontrol.util.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/spaces/{space-id}/users")
@CrossOrigin(origins = "*")
@SecuredAnyUserAuth
public class UserController extends GenericController {

    @Autowired
    private UserAppService userAppService;

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private UserAppMapper userAppMapper;

    @GetMapping("/all")
    @Transactional
    public ResponseEntity<ResponseData<Set<UserWithPermissionDto>>> findAllBySpace(
            @PathVariable("space-id") Long spaceId
    ) {
        List<UserApp> entityData = userAppService.findAllBySpace(spaceId);
        Set<UserWithPermissionDto> viewData = userAppMapper.toUserWithPermissionDtoList(entityData);
        return super.ok(viewData);
    }

    @GetMapping("/permissions/{permission-key}")
    public ResponseEntity<ResponseData<Set<UserDto>>> findAllByPermission(
            @PathVariable("space-id") Long spaceId,
            @PathVariable("permission-key") PermissionEnum permissionEnum
            ) {
        List<UserPermission> entityData = userPermissionService.findBySpaceAndPermission(spaceId, permissionEnum);
        Set<UserDto> viewData = userAppMapper.toUserDtoList(entityData);
        return super.ok(viewData);
    }

    @PostMapping("/{id-user}/permissions/{permission-key}")
    public ResponseEntity<ResponseData<Void>> addPermission(
            @PathVariable("space-id") Long spaceId,
            @PathVariable("id-user") Long idUser, // TODO: change to email-user
            @PathVariable("permission-key") PermissionEnum permissionEnum
            ) {
        userAppService.addPermissionToUserInSpace(idUser, spaceId, permissionEnum);
        return super.ok();
    }

}

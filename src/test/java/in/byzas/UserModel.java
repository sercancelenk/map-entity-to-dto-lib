package in.byzas;

import in.byzas.annotation.MapperProperty;

import java.util.List;

/**
 * Created by byzas on 25/03/16.
 */
public class UserModel {

    @MapperProperty(mappedProperty = "id")
    private Long id;
    @MapperProperty(mappedProperty = "username")
    private String username;
    @MapperProperty(mappedProperty = "permissionList")
    private List<Permission> permissionList;

    public UserModel() {
    }

    public UserModel(Long id, String username, List<Permission> permissionList) {
        this.id = id;
        this.username = username;
        this.permissionList = permissionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}

package in.byzas;

import java.util.List;

/**
 * Created by byzas on 25/03/16.
 */
public class Permission {
    private Long id;
    private String desc;
    private List<User> userList;

    public Permission() {
    }

    public Permission(Long id, String desc, List<User> userList) {
        this.id = id;
        this.desc = desc;
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

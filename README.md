Object Mapper

You can want to map one class to another class most time. With this api, you can map one class to another class easily.

Example Usage:

User.class
```
class User{
    private Long id;
    private String username;
    private String password;
    private String address;
    private String phone;
    private List<Permission> permissionList;
    
    // Getter and Setter
}

public class UserModel {

    __@MapperProperty(mappedProperty = "id")__ --> Map property name(should be same with source class property)
    private Long id;
    **@MapperProperty(mappedProperty = "username")** --> Map property name(should be same with source class property)
    private String username;
    **@MapperProperty(mappedProperty = "permissionList")** --> Map property name(should be same with source class property)
    private List<Permission> permissionList;
    
    // Getter and Setter
}

static public void main(String...args){
    List<User> userList = loadUsers();
    List<UserModel> userModelList = null;
    
    userModelList = (List<UserModel>) Mapper.map(userList, UserModel.class);
}
```

That's all.
Happy Coding.
@byzas

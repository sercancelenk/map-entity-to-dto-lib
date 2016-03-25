package in.byzas;

import in.byzas.lib.Mapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    List<User> userList;
    List<Permission> permissionList;
    List<UserModel> userModels;



    @Before
    public void setUp(){

        userList = new ArrayList<>();
        permissionList = new ArrayList<>();
        userModels = new ArrayList<>();

        User user = new User();
        user.setId(1L);
        user.setUsername("sercancelenk");
        user.setAddress("adress");
        user.setPhone("16217312983");

        Permission permission = new Permission();
        permission.setId(1L);
        permission.setDesc("ADMIN");
        permissionList.add(permission);

        Permission permission1 = new Permission();
        permission1.setId(1L);
        permission1.setDesc("MODERATOR");
        permissionList.add(permission1);

        Permission permission2 = new Permission();
        permission2.setId(1L);
        permission2.setDesc("STANDART");
        permissionList.add(permission2);

        user.setPermissionList(permissionList);
        userList.add(user);

        permission1.setUserList(userList);

    }

    @After
    public void resetAll(){
        userList = null;
        permissionList = null;
        userModels = null;
    }

    @Test
    public void givenUserList_whenMapper_ToModel(){
        Object data = Mapper.map(userList, UserModel.class);
        assertNotNull(data);
    }

    @Test
    public void givenUserEntity_whenMapper_ToModel(){
        User entity = userList.get(0);
        UserModel um = (UserModel) Mapper.map(entity, UserModel.class);
        assertNotNull(um);
        assertEquals(um.getUsername(), entity.getUsername());
    }

}

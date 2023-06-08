package lt.marius.rest_api;

import retrofit2.Call;
import retrofit2.Response;

import java.util.Collections;
import java.util.List;

import static lt.marius.rest_api.RetrofitBuilder.retrofit;

public class UserRemoteRepository {


    static public User getUser(String name) {
        Call<User> callSyncUser =
                retrofit
                        .create(UserService.class)
                        .getUser(name);

        User user = null;

        try {
            Response<User> response = callSyncUser.execute();
            user = response.body();
            callSyncUser.cancel();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

   static public List<User> getUsers() {

        Call<List<User>> callSyncUsers =
                retrofit
                        .create(UserService.class)
                        .getUsers(10, 2);

        List<User> users = Collections.emptyList();

        try {
            Response<List<User>> response = callSyncUsers.execute();
            users = response.body();
            callSyncUsers.cancel();

            System.out.println("========================================");

            Response<List<User>> responseUsers = callSyncUsers.execute();
            users = responseUsers.body();
            callSyncUsers.cancel();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return users;
    }
}
